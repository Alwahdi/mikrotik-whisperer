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
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

@Immutable
@Deprecated
public class DefaultRedirectHandler implements RedirectHandler {
    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private final Log log = LogFactory.getLog(getClass());

    public boolean isRedirectRequested(HttpResponse response, HttpContext context) {
        if (response != null) {
            switch (response.getStatusLine().getStatusCode()) {
                case HttpStatus.SC_MOVED_PERMANENTLY:
                case HttpStatus.SC_MOVED_TEMPORARILY:
                case HttpStatus.SC_TEMPORARY_REDIRECT:
                    String method = ((HttpRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST)).getRequestLine().getMethod();
                    if (method.equalsIgnoreCase(HttpGet.METHOD_NAME) || method.equalsIgnoreCase(HttpHead.METHOD_NAME)) {
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

    public URI getLocationURI(HttpResponse response, HttpContext context) throws ProtocolException {
        URI redirectURI;
        if (response != null) {
            Header locationHeader = response.getFirstHeader("location");
            if (locationHeader != null) {
                String location = locationHeader.getValue();
                if (this.log.isDebugEnabled()) {
                    Log log2 = this.log;
                    log2.debug("Redirect requested to location '" + location + "'");
                }
                try {
                    URI uri = new URI(location);
                    HttpParams params = response.getParams();
                    if (!uri.isAbsolute()) {
                        if (!params.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT)) {
                            HttpHost target = (HttpHost) context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
                            if (target != null) {
                                HttpRequest request = (HttpRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST);
                                try {
                                    uri = URIUtils.resolve(URIUtils.rewriteURI(new URI(request.getRequestLine().getUri()), target, true), uri);
                                    HttpRequest httpRequest = request;
                                } catch (URISyntaxException ex) {
                                    throw new ProtocolException(ex.getMessage(), ex);
                                }
                            } else {
                                throw new IllegalStateException("Target host not available in the HTTP context");
                            }
                        } else {
                            throw new ProtocolException("Relative redirect location '" + uri + "' not allowed");
                        }
                    }
                    if (params.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS)) {
                        RedirectLocations redirectLocations = (RedirectLocations) context.getAttribute("http.protocol.redirect-locations");
                        if (redirectLocations == null) {
                            redirectLocations = new RedirectLocations();
                            context.setAttribute("http.protocol.redirect-locations", redirectLocations);
                        }
                        if (uri.getFragment() != null) {
                            try {
                                redirectURI = URIUtils.rewriteURI(uri, new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()), true);
                            } catch (URISyntaxException ex2) {
                                throw new ProtocolException(ex2.getMessage(), ex2);
                            }
                        } else {
                            redirectURI = uri;
                        }
                        if (!redirectLocations.contains(redirectURI)) {
                            redirectLocations.add(redirectURI);
                        } else {
                            throw new CircularRedirectException("Circular redirect to '" + redirectURI + "'");
                        }
                    }
                    return uri;
                } catch (URISyntaxException ex3) {
                    throw new ProtocolException("Invalid redirect URI: " + location, ex3);
                }
            } else {
                throw new ProtocolException("Received redirect response " + response.getStatusLine() + " but no location header");
            }
        } else {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
    }
}
