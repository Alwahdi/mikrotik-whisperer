package org.apache.http.client.protocol;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.HttpRoutedConnection;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

@Immutable
public class RequestAddCookies implements HttpRequestInterceptor {
    private final Log log = LogFactory.getLog(getClass());

    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        URI requestURI;
        Header header;
        CookieSpecRegistry registry;
        CookieStore cookieStore;
        HttpRequest httpRequest = request;
        HttpContext httpContext = context;
        if (httpRequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (httpContext != null) {
            String method = request.getRequestLine().getMethod();
            if (!method.equalsIgnoreCase("CONNECT")) {
                CookieStore cookieStore2 = (CookieStore) httpContext.getAttribute(ClientContext.COOKIE_STORE);
                if (cookieStore2 == null) {
                    this.log.debug("Cookie store not specified in HTTP context");
                    return;
                }
                CookieSpecRegistry registry2 = (CookieSpecRegistry) httpContext.getAttribute(ClientContext.COOKIESPEC_REGISTRY);
                if (registry2 == null) {
                    this.log.debug("CookieSpec registry not specified in HTTP context");
                    return;
                }
                HttpHost targetHost = (HttpHost) httpContext.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
                if (targetHost == null) {
                    this.log.debug("Target host not set in the context");
                    return;
                }
                HttpRoutedConnection conn = (HttpRoutedConnection) httpContext.getAttribute(ExecutionContext.HTTP_CONNECTION);
                if (conn == null) {
                    this.log.debug("HTTP connection not set in the context");
                    return;
                }
                String policy = HttpClientParams.getCookiePolicy(request.getParams());
                if (this.log.isDebugEnabled()) {
                    this.log.debug("CookieSpec selected: " + policy);
                }
                if (httpRequest instanceof HttpUriRequest) {
                    requestURI = ((HttpUriRequest) httpRequest).getURI();
                } else {
                    try {
                        requestURI = new URI(request.getRequestLine().getUri());
                    } catch (URISyntaxException ex) {
                        String str = method;
                        CookieStore cookieStore3 = cookieStore2;
                        CookieSpecRegistry cookieSpecRegistry = registry2;
                        throw new ProtocolException("Invalid request URI: " + request.getRequestLine().getUri(), ex);
                    }
                }
                String hostName = targetHost.getHostName();
                int port = targetHost.getPort();
                if (port < 0) {
                    if (conn.getRoute().getHopCount() == 1) {
                        port = conn.getRemotePort();
                    } else {
                        String scheme = targetHost.getSchemeName();
                        if (scheme.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
                            port = 80;
                        } else if (scheme.equalsIgnoreCase("https")) {
                            port = 443;
                        } else {
                            port = 0;
                        }
                    }
                }
                CookieOrigin cookieOrigin = new CookieOrigin(hostName, port, requestURI.getPath(), conn.isSecure());
                CookieSpec cookieSpec = registry2.getCookieSpec(policy, request.getParams());
                List<Cookie> cookies = new ArrayList<>(cookieStore2.getCookies());
                List<Cookie> matchedCookies = new ArrayList<>();
                Date now = new Date();
                for (Cookie cookie : cookies) {
                    URI requestURI2 = requestURI;
                    String method2 = method;
                    Date now2 = now;
                    Date now3 = now2;
                    if (cookie.isExpired(now2)) {
                        cookieStore = cookieStore2;
                        registry = registry2;
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Cookie " + cookie + " expired");
                        }
                    } else if (cookieSpec.match(cookie, cookieOrigin)) {
                        cookieStore = cookieStore2;
                        if (this.log.isDebugEnabled()) {
                            registry = registry2;
                            this.log.debug("Cookie " + cookie + " match " + cookieOrigin);
                        } else {
                            registry = registry2;
                        }
                        matchedCookies.add(cookie);
                    } else {
                        cookieStore = cookieStore2;
                        registry = registry2;
                    }
                    cookieStore2 = cookieStore;
                    method = method2;
                    requestURI = requestURI2;
                    now = now3;
                    registry2 = registry;
                }
                String str2 = method;
                CookieSpecRegistry cookieSpecRegistry2 = registry2;
                Date date = now;
                CookieStore cookieStore4 = cookieStore2;
                if (!matchedCookies.isEmpty()) {
                    for (Header header2 : cookieSpec.formatCookies(matchedCookies)) {
                        httpRequest.addHeader(header2);
                    }
                }
                int ver = cookieSpec.getVersion();
                if (ver > 0) {
                    boolean needVersionHeader = false;
                    for (Cookie cookie2 : matchedCookies) {
                        if (ver != cookie2.getVersion() || !(cookie2 instanceof SetCookie2)) {
                            needVersionHeader = true;
                        }
                    }
                    if (needVersionHeader && (header = cookieSpec.getVersionHeader()) != null) {
                        httpRequest.addHeader(header);
                    }
                }
                httpContext.setAttribute(ClientContext.COOKIE_SPEC, cookieSpec);
                httpContext.setAttribute(ClientContext.COOKIE_ORIGIN, cookieOrigin);
            }
        } else {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
    }
}
