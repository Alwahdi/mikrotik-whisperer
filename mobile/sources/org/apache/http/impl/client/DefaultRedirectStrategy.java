package org.apache.http.impl.client;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

@Immutable
public class DefaultRedirectStrategy implements RedirectStrategy {
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private final Log log = LogFactory.getLog(getClass());

    public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context) throws ProtocolException {
        if (response != null) {
            int statusCode = response.getStatusLine().getStatusCode();
            String method = request.getRequestLine().getMethod();
            Header locationHeader = response.getFirstHeader("location");
            switch (statusCode) {
                case HttpStatus.SC_MOVED_PERMANENTLY:
                case HttpStatus.SC_TEMPORARY_REDIRECT:
                    if (method.equalsIgnoreCase(HttpGet.METHOD_NAME) || method.equalsIgnoreCase(HttpHead.METHOD_NAME)) {
                        return true;
                    }
                    return false;
                case HttpStatus.SC_MOVED_TEMPORARILY:
                    if ((method.equalsIgnoreCase(HttpGet.METHOD_NAME) || method.equalsIgnoreCase(HttpHead.METHOD_NAME)) && locationHeader != null) {
                        return true;
                    }
                    return false;
                case HttpStatus.SC_SEE_OTHER:
                    return true;
                default:
                    return false;
            }
        } else {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
    }

    public URI getLocationURI(HttpRequest request, HttpResponse response, HttpContext context) throws ProtocolException {
        URI requestURI;
        URI redirectURI;
        if (response != null) {
            Header locationHeader = response.getFirstHeader("location");
            if (locationHeader != null) {
                String location = locationHeader.getValue();
                if (this.log.isDebugEnabled()) {
                    Log log2 = this.log;
                    log2.debug("Redirect requested to location '" + location + "'");
                }
                URI uri = createLocationURI(location);
                HttpParams params = response.getParams();
                if (uri.isAbsolute()) {
                    requestURI = null;
                } else if (!params.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT)) {
                    HttpHost target = (HttpHost) context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
                    if (target != null) {
                        try {
                            requestURI = new URI(request.getRequestLine().getUri());
                            uri = URIUtils.resolve(URIUtils.rewriteURI(requestURI, target, true), uri);
                        } catch (URISyntaxException ex) {
                            throw new ProtocolException(ex.getMessage(), ex);
                        }
                    } else {
                        throw new IllegalStateException("Target host not available in the HTTP context");
                    }
                } else {
                    throw new ProtocolException("Relative redirect location '" + uri + "' not allowed");
                }
                if (params.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS)) {
                    RedirectLocations redirectLocations = (RedirectLocations) context.getAttribute(REDIRECT_LOCATIONS);
                    if (redirectLocations == null) {
                        redirectLocations = new RedirectLocations();
                        context.setAttribute(REDIRECT_LOCATIONS, redirectLocations);
                    }
                    if (uri.getFragment() != null) {
                        try {
                            redirectURI = URIUtils.rewriteURI(uri, new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()), true);
                        } catch (URISyntaxException ex2) {
                            URI uri2 = requestURI;
                            throw new ProtocolException(ex2.getMessage(), ex2);
                        }
                    } else {
                        URI redirectURI2 = requestURI;
                        redirectURI = uri;
                    }
                    if (!redirectLocations.contains(redirectURI)) {
                        redirectLocations.add(redirectURI);
                    } else {
                        throw new CircularRedirectException("Circular redirect to '" + redirectURI + "'");
                    }
                }
                return uri;
            }
            throw new ProtocolException("Received redirect response " + response.getStatusLine() + " but no location header");
        }
        throw new IllegalArgumentException("HTTP response may not be null");
    }

    /* access modifiers changed from: protected */
    public URI createLocationURI(String location) throws ProtocolException {
        try {
            return new URI(location);
        } catch (URISyntaxException ex) {
            throw new ProtocolException("Invalid redirect URI: " + location, ex);
        }
    }

    public HttpUriRequest getRedirect(HttpRequest request, HttpResponse response, HttpContext context) throws ProtocolException {
        URI uri = getLocationURI(request, response, context);
        if (request.getRequestLine().getMethod().equalsIgnoreCase(HttpHead.METHOD_NAME)) {
            return new HttpHead(uri);
        }
        return new HttpGet(uri);
    }
}
