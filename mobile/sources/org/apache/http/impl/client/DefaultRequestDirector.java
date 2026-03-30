package org.apache.http.impl.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.AbortableHttpRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.BasicManagedEntity;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.routing.BasicRouteDirector;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRouteDirector;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.util.EntityUtils;

@NotThreadSafe
public class DefaultRequestDirector implements RequestDirector {
    protected final ClientConnectionManager connManager;
    private int execCount;
    protected final HttpProcessor httpProcessor;
    protected final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final Log log;
    protected ManagedClientConnection managedConn;
    private int maxRedirects;
    protected final HttpParams params;
    protected final AuthenticationHandler proxyAuthHandler;
    protected final AuthState proxyAuthState;
    private int redirectCount;
    @Deprecated
    protected final RedirectHandler redirectHandler;
    protected final RedirectStrategy redirectStrategy;
    protected final HttpRequestExecutor requestExec;
    protected final HttpRequestRetryHandler retryHandler;
    protected final ConnectionReuseStrategy reuseStrategy;
    protected final HttpRoutePlanner routePlanner;
    protected final AuthenticationHandler targetAuthHandler;
    protected final AuthState targetAuthState;
    protected final UserTokenHandler userTokenHandler;
    private HttpHost virtualHost;

    @Deprecated
    public DefaultRequestDirector(HttpRequestExecutor requestExec2, ClientConnectionManager conman, ConnectionReuseStrategy reustrat, ConnectionKeepAliveStrategy kastrat, HttpRoutePlanner rouplan, HttpProcessor httpProcessor2, HttpRequestRetryHandler retryHandler2, RedirectHandler redirectHandler2, AuthenticationHandler targetAuthHandler2, AuthenticationHandler proxyAuthHandler2, UserTokenHandler userTokenHandler2, HttpParams params2) {
        this(LogFactory.getLog(DefaultRequestDirector.class), requestExec2, conman, reustrat, kastrat, rouplan, httpProcessor2, retryHandler2, new DefaultRedirectStrategyAdaptor(redirectHandler2), targetAuthHandler2, proxyAuthHandler2, userTokenHandler2, params2);
    }

    public DefaultRequestDirector(Log log2, HttpRequestExecutor requestExec2, ClientConnectionManager conman, ConnectionReuseStrategy reustrat, ConnectionKeepAliveStrategy kastrat, HttpRoutePlanner rouplan, HttpProcessor httpProcessor2, HttpRequestRetryHandler retryHandler2, RedirectStrategy redirectStrategy2, AuthenticationHandler targetAuthHandler2, AuthenticationHandler proxyAuthHandler2, UserTokenHandler userTokenHandler2, HttpParams params2) {
        this.redirectHandler = null;
        if (log2 == null) {
            throw new IllegalArgumentException("Log may not be null.");
        } else if (requestExec2 == null) {
            throw new IllegalArgumentException("Request executor may not be null.");
        } else if (conman == null) {
            throw new IllegalArgumentException("Client connection manager may not be null.");
        } else if (reustrat == null) {
            throw new IllegalArgumentException("Connection reuse strategy may not be null.");
        } else if (kastrat == null) {
            throw new IllegalArgumentException("Connection keep alive strategy may not be null.");
        } else if (rouplan == null) {
            throw new IllegalArgumentException("Route planner may not be null.");
        } else if (httpProcessor2 == null) {
            throw new IllegalArgumentException("HTTP protocol processor may not be null.");
        } else if (retryHandler2 == null) {
            throw new IllegalArgumentException("HTTP request retry handler may not be null.");
        } else if (redirectStrategy2 == null) {
            throw new IllegalArgumentException("Redirect strategy may not be null.");
        } else if (targetAuthHandler2 == null) {
            throw new IllegalArgumentException("Target authentication handler may not be null.");
        } else if (proxyAuthHandler2 == null) {
            throw new IllegalArgumentException("Proxy authentication handler may not be null.");
        } else if (userTokenHandler2 == null) {
            throw new IllegalArgumentException("User token handler may not be null.");
        } else if (params2 != null) {
            this.log = log2;
            this.requestExec = requestExec2;
            this.connManager = conman;
            this.reuseStrategy = reustrat;
            this.keepAliveStrategy = kastrat;
            this.routePlanner = rouplan;
            this.httpProcessor = httpProcessor2;
            this.retryHandler = retryHandler2;
            this.redirectStrategy = redirectStrategy2;
            this.targetAuthHandler = targetAuthHandler2;
            this.proxyAuthHandler = proxyAuthHandler2;
            this.userTokenHandler = userTokenHandler2;
            this.params = params2;
            this.managedConn = null;
            this.execCount = 0;
            this.redirectCount = 0;
            this.maxRedirects = params2.getIntParameter(ClientPNames.MAX_REDIRECTS, 100);
            this.targetAuthState = new AuthState();
            this.proxyAuthState = new AuthState();
        } else {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }

    private RequestWrapper wrapRequest(HttpRequest request) throws ProtocolException {
        if (request instanceof HttpEntityEnclosingRequest) {
            return new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) request);
        }
        return new RequestWrapper(request);
    }

    /* access modifiers changed from: protected */
    public void rewriteRequestURI(RequestWrapper request, HttpRoute route) throws ProtocolException {
        try {
            URI uri = request.getURI();
            if (route.getProxyHost() == null || route.isTunnelled()) {
                if (uri.isAbsolute()) {
                    request.setURI(URIUtils.rewriteURI(uri, (HttpHost) null));
                }
            } else if (!uri.isAbsolute()) {
                request.setURI(URIUtils.rewriteURI(uri, route.getTargetHost()));
            }
        } catch (URISyntaxException ex) {
            throw new ProtocolException("Invalid URI: " + request.getRequestLine().getUri(), ex);
        }
    }

    public HttpResponse execute(HttpHost target, HttpRequest request, HttpContext context) throws HttpException, IOException {
        ConnectionShutdownException ex;
        HttpException ex2;
        IOException ex3;
        RuntimeException ex4;
        boolean done;
        HttpRoute origRoute;
        RequestWrapper origWrapper;
        HttpRequest orig;
        HttpHost target2;
        long duration;
        String s;
        boolean done2;
        boolean done3;
        boolean done4;
        boolean done5;
        Log log2;
        StringBuilder sb;
        boolean z;
        StringBuilder sb2;
        InterruptedException interrupted;
        int port;
        HttpContext httpContext = context;
        HttpRequest orig2 = request;
        RequestWrapper origWrapper2 = wrapRequest(orig2);
        origWrapper2.setParams(this.params);
        HttpHost target3 = target;
        HttpRoute origRoute2 = determineRoute(target3, origWrapper2, httpContext);
        HttpHost httpHost = (HttpHost) orig2.getParams().getParameter(ClientPNames.VIRTUAL_HOST);
        this.virtualHost = httpHost;
        if (!(httpHost == null || httpHost.getPort() != -1 || (port = target.getPort()) == -1)) {
            this.virtualHost = new HttpHost(this.virtualHost.getHostName(), port, this.virtualHost.getSchemeName());
        }
        RoutedRequest roureq = new RoutedRequest(origWrapper2, origRoute2);
        boolean reuse = false;
        boolean done6 = false;
        HttpResponse response = null;
        while (!done6) {
            try {
                RequestWrapper wrapper = roureq.getRequest();
                HttpRoute route = roureq.getRoute();
                Object userToken = httpContext.getAttribute(ClientContext.USER_TOKEN);
                if (this.managedConn == null) {
                    try {
                        ClientConnectionRequest connRequest = this.connManager.requestConnection(route, userToken);
                        origWrapper = origWrapper2;
                        try {
                            if (orig2 instanceof AbortableHttpRequest) {
                                try {
                                    ((AbortableHttpRequest) orig2).setConnectionRequest(connRequest);
                                } catch (ConnectionShutdownException e) {
                                    ex = e;
                                    HttpRequest httpRequest = orig2;
                                    HttpRoute httpRoute = origRoute2;
                                } catch (HttpException e2) {
                                    ex2 = e2;
                                    HttpRequest httpRequest2 = orig2;
                                    HttpRoute httpRoute2 = origRoute2;
                                    abortConnection();
                                    throw ex2;
                                } catch (IOException e3) {
                                    ex3 = e3;
                                    HttpRequest httpRequest3 = orig2;
                                    HttpRoute httpRoute3 = origRoute2;
                                    abortConnection();
                                    throw ex3;
                                } catch (RuntimeException e4) {
                                    ex4 = e4;
                                    HttpRequest httpRequest4 = orig2;
                                    HttpRoute httpRoute4 = origRoute2;
                                    abortConnection();
                                    throw ex4;
                                }
                            }
                            long timeout = ConnManagerParams.getTimeout(this.params);
                            try {
                                target = target3;
                                origRoute = origRoute2;
                                long timeout2 = timeout;
                                try {
                                    this.managedConn = connRequest.getConnection(timeout2, TimeUnit.MILLISECONDS);
                                    try {
                                        if (!HttpConnectionParams.isStaleCheckingEnabled(this.params)) {
                                        } else if (this.managedConn.isOpen()) {
                                            long j = timeout2;
                                            this.log.debug("Stale connection check");
                                            if (this.managedConn.isStale()) {
                                                this.log.debug("Stale connection detected");
                                                this.managedConn.close();
                                            }
                                        }
                                    } catch (ConnectionShutdownException e5) {
                                        HttpHost httpHost2 = target;
                                        ex = e5;
                                        HttpRequest httpRequest5 = orig2;
                                    } catch (HttpException e6) {
                                        HttpHost httpHost3 = target;
                                        ex2 = e6;
                                        HttpRequest httpRequest6 = orig2;
                                        abortConnection();
                                        throw ex2;
                                    } catch (IOException e7) {
                                        HttpHost httpHost4 = target;
                                        ex3 = e7;
                                        HttpRequest httpRequest7 = orig2;
                                        abortConnection();
                                        throw ex3;
                                    } catch (RuntimeException e8) {
                                        HttpHost httpHost5 = target;
                                        ex4 = e8;
                                        HttpRequest httpRequest8 = orig2;
                                        abortConnection();
                                        throw ex4;
                                    }
                                } catch (InterruptedException e9) {
                                    long j2 = timeout2;
                                    interrupted = e9;
                                }
                            } catch (InterruptedException e10) {
                                HttpHost httpHost6 = target3;
                                HttpRoute httpRoute5 = origRoute2;
                                long j3 = timeout;
                                interrupted = e10;
                                InterruptedIOException iox = new InterruptedIOException();
                                iox.initCause(interrupted);
                                throw iox;
                            }
                        } catch (ConnectionShutdownException e11) {
                            HttpHost httpHost7 = target3;
                            HttpRoute httpRoute6 = origRoute2;
                            ex = e11;
                            HttpRequest httpRequest9 = orig2;
                            InterruptedIOException ioex = new InterruptedIOException("Connection has been shut down");
                            ioex.initCause(ex);
                            throw ioex;
                        } catch (HttpException e12) {
                            HttpHost httpHost8 = target3;
                            HttpRoute httpRoute7 = origRoute2;
                            ex2 = e12;
                            HttpRequest httpRequest10 = orig2;
                            abortConnection();
                            throw ex2;
                        } catch (IOException e13) {
                            HttpHost httpHost9 = target3;
                            HttpRoute httpRoute8 = origRoute2;
                            ex3 = e13;
                            HttpRequest httpRequest11 = orig2;
                            abortConnection();
                            throw ex3;
                        } catch (RuntimeException e14) {
                            HttpHost httpHost10 = target3;
                            HttpRoute httpRoute9 = origRoute2;
                            ex4 = e14;
                            HttpRequest httpRequest12 = orig2;
                            abortConnection();
                            throw ex4;
                        }
                    } catch (ConnectionShutdownException e15) {
                        RequestWrapper requestWrapper = origWrapper2;
                        HttpHost httpHost11 = target3;
                        HttpRoute httpRoute10 = origRoute2;
                        ex = e15;
                        HttpRequest httpRequest13 = orig2;
                        InterruptedIOException ioex2 = new InterruptedIOException("Connection has been shut down");
                        ioex2.initCause(ex);
                        throw ioex2;
                    } catch (HttpException e16) {
                        RequestWrapper requestWrapper2 = origWrapper2;
                        HttpHost httpHost12 = target3;
                        HttpRoute httpRoute11 = origRoute2;
                        ex2 = e16;
                        HttpRequest httpRequest14 = orig2;
                        abortConnection();
                        throw ex2;
                    } catch (IOException e17) {
                        RequestWrapper requestWrapper3 = origWrapper2;
                        HttpHost httpHost13 = target3;
                        HttpRoute httpRoute12 = origRoute2;
                        ex3 = e17;
                        HttpRequest httpRequest15 = orig2;
                        abortConnection();
                        throw ex3;
                    } catch (RuntimeException e18) {
                        RequestWrapper requestWrapper4 = origWrapper2;
                        HttpHost httpHost14 = target3;
                        HttpRoute httpRoute13 = origRoute2;
                        ex4 = e18;
                        HttpRequest httpRequest16 = orig2;
                        abortConnection();
                        throw ex4;
                    }
                } else {
                    origWrapper = origWrapper2;
                    target = target3;
                    origRoute = origRoute2;
                }
                try {
                    if (orig2 instanceof AbortableHttpRequest) {
                        ((AbortableHttpRequest) orig2).setReleaseTrigger(this.managedConn);
                    }
                    try {
                        tryConnect(roureq, httpContext);
                        wrapper.resetHeaders();
                        rewriteRequestURI(wrapper, route);
                        target3 = this.virtualHost;
                        if (target3 == null) {
                            try {
                                target3 = route.getTargetHost();
                            } catch (ConnectionShutdownException e19) {
                                ex = e19;
                                HttpRequest httpRequest17 = orig2;
                                InterruptedIOException ioex22 = new InterruptedIOException("Connection has been shut down");
                                ioex22.initCause(ex);
                                throw ioex22;
                            } catch (HttpException e20) {
                                ex2 = e20;
                                HttpRequest httpRequest18 = orig2;
                                abortConnection();
                                throw ex2;
                            } catch (IOException e21) {
                                ex3 = e21;
                                HttpRequest httpRequest19 = orig2;
                                abortConnection();
                                throw ex3;
                            } catch (RuntimeException e22) {
                                ex4 = e22;
                                HttpRequest httpRequest20 = orig2;
                                abortConnection();
                                throw ex4;
                            }
                        }
                        try {
                            HttpHost proxy = route.getProxyHost();
                            httpContext.setAttribute(ExecutionContext.HTTP_TARGET_HOST, target3);
                            httpContext.setAttribute(ExecutionContext.HTTP_PROXY_HOST, proxy);
                            httpContext.setAttribute(ExecutionContext.HTTP_CONNECTION, this.managedConn);
                            httpContext.setAttribute(ClientContext.TARGET_AUTH_STATE, this.targetAuthState);
                            httpContext.setAttribute(ClientContext.PROXY_AUTH_STATE, this.proxyAuthState);
                            this.requestExec.preProcess(wrapper, this.httpProcessor, httpContext);
                            response = tryExecute(roureq, httpContext);
                            if (response == null) {
                                origWrapper2 = origWrapper;
                                origRoute2 = origRoute;
                            } else {
                                response.setParams(this.params);
                                this.requestExec.postProcess(response, this.httpProcessor, httpContext);
                                reuse = this.reuseStrategy.keepAlive(response, httpContext);
                                if (reuse) {
                                    long duration2 = this.keepAliveStrategy.getKeepAliveDuration(response, httpContext);
                                    if (this.log.isDebugEnabled()) {
                                        HttpRequest orig3 = orig2;
                                        target = proxy;
                                        duration = duration2;
                                        if (duration > 0) {
                                            try {
                                                sb2 = new StringBuilder();
                                                target2 = target3;
                                            } catch (ConnectionShutdownException e23) {
                                                HttpHost httpHost15 = target3;
                                                ex = e23;
                                                HttpRequest httpRequest21 = orig3;
                                                InterruptedIOException ioex222 = new InterruptedIOException("Connection has been shut down");
                                                ioex222.initCause(ex);
                                                throw ioex222;
                                            } catch (HttpException e24) {
                                                HttpHost httpHost16 = target3;
                                                ex2 = e24;
                                                HttpRequest httpRequest22 = orig3;
                                                abortConnection();
                                                throw ex2;
                                            } catch (IOException e25) {
                                                HttpHost httpHost17 = target3;
                                                ex3 = e25;
                                                HttpRequest httpRequest23 = orig3;
                                                abortConnection();
                                                throw ex3;
                                            } catch (RuntimeException e26) {
                                                HttpHost httpHost18 = target3;
                                                ex4 = e26;
                                                HttpRequest httpRequest24 = orig3;
                                                abortConnection();
                                                throw ex4;
                                            }
                                            try {
                                                sb2.append("for ");
                                                sb2.append(duration);
                                                sb2.append(" ");
                                                sb2.append(TimeUnit.MILLISECONDS);
                                                s = sb2.toString();
                                            } catch (ConnectionShutdownException e27) {
                                                ex = e27;
                                                HttpRequest httpRequest25 = orig3;
                                                HttpHost httpHost19 = target2;
                                                InterruptedIOException ioex2222 = new InterruptedIOException("Connection has been shut down");
                                                ioex2222.initCause(ex);
                                                throw ioex2222;
                                            } catch (HttpException e28) {
                                                ex2 = e28;
                                                HttpRequest httpRequest26 = orig3;
                                                HttpHost httpHost20 = target2;
                                                abortConnection();
                                                throw ex2;
                                            } catch (IOException e29) {
                                                ex3 = e29;
                                                HttpRequest httpRequest27 = orig3;
                                                HttpHost httpHost21 = target2;
                                                abortConnection();
                                                throw ex3;
                                            } catch (RuntimeException e30) {
                                                ex4 = e30;
                                                HttpRequest httpRequest28 = orig3;
                                                HttpHost httpHost22 = target2;
                                                abortConnection();
                                                throw ex4;
                                            }
                                        } else {
                                            target2 = target3;
                                            s = "indefinitely";
                                        }
                                        try {
                                            done2 = duration2;
                                            done3 = duration2;
                                            done4 = duration2;
                                            done5 = duration2;
                                            log2 = this.log;
                                            orig = orig3;
                                            try {
                                                done2 = duration2;
                                                done3 = duration2;
                                                done4 = duration2;
                                                done5 = duration2;
                                                sb = new StringBuilder();
                                                z = done6;
                                            } catch (ConnectionShutdownException e31) {
                                                boolean z2 = done6;
                                                ex = e31;
                                                HttpHost httpHost23 = target2;
                                                InterruptedIOException ioex22222 = new InterruptedIOException("Connection has been shut down");
                                                ioex22222.initCause(ex);
                                                throw ioex22222;
                                            } catch (HttpException e32) {
                                                boolean z3 = done6;
                                                ex2 = e32;
                                                HttpHost httpHost24 = target2;
                                                abortConnection();
                                                throw ex2;
                                            } catch (IOException e33) {
                                                boolean z4 = done6;
                                                ex3 = e33;
                                                HttpHost httpHost25 = target2;
                                                abortConnection();
                                                throw ex3;
                                            } catch (RuntimeException e34) {
                                                boolean z5 = done6;
                                                ex4 = e34;
                                                HttpHost httpHost26 = target2;
                                                abortConnection();
                                                throw ex4;
                                            }
                                        } catch (ConnectionShutdownException e35) {
                                            HttpRequest httpRequest29 = orig3;
                                            boolean z6 = done6;
                                            ex = e35;
                                            HttpHost httpHost27 = target2;
                                            InterruptedIOException ioex222222 = new InterruptedIOException("Connection has been shut down");
                                            ioex222222.initCause(ex);
                                            throw ioex222222;
                                        } catch (HttpException e36) {
                                            HttpRequest httpRequest30 = orig3;
                                            boolean z7 = done6;
                                            ex2 = e36;
                                            HttpHost httpHost28 = target2;
                                            abortConnection();
                                            throw ex2;
                                        } catch (IOException e37) {
                                            HttpRequest httpRequest31 = orig3;
                                            boolean z8 = done6;
                                            ex3 = e37;
                                            HttpHost httpHost29 = target2;
                                            abortConnection();
                                            throw ex3;
                                        } catch (RuntimeException e38) {
                                            HttpRequest httpRequest32 = orig3;
                                            boolean z9 = done6;
                                            ex4 = e38;
                                            HttpHost httpHost30 = target2;
                                            abortConnection();
                                            throw ex4;
                                        }
                                        try {
                                            done2 = z;
                                            done3 = z;
                                            done4 = z;
                                            done5 = z;
                                            sb.append("Connection can be kept alive ");
                                            sb.append(s);
                                            log2.debug(sb.toString());
                                            done = z;
                                        } catch (ConnectionShutdownException e39) {
                                            ex = e39;
                                            HttpHost httpHost31 = target2;
                                            boolean z10 = done2;
                                            InterruptedIOException ioex2222222 = new InterruptedIOException("Connection has been shut down");
                                            ioex2222222.initCause(ex);
                                            throw ioex2222222;
                                        } catch (HttpException e40) {
                                            ex2 = e40;
                                            HttpHost httpHost32 = target2;
                                            boolean z11 = done3;
                                            abortConnection();
                                            throw ex2;
                                        } catch (IOException e41) {
                                            ex3 = e41;
                                            HttpHost httpHost33 = target2;
                                            boolean z12 = done4;
                                            abortConnection();
                                            throw ex3;
                                        } catch (RuntimeException e42) {
                                            ex4 = e42;
                                            HttpHost httpHost34 = target2;
                                            boolean z13 = done5;
                                            abortConnection();
                                            throw ex4;
                                        }
                                    } else {
                                        orig = orig2;
                                        target = proxy;
                                        target2 = target3;
                                        duration = duration2;
                                        done = done6;
                                    }
                                    this.managedConn.setIdleDuration(duration, TimeUnit.MILLISECONDS);
                                } else {
                                    orig = orig2;
                                    target = proxy;
                                    target2 = target3;
                                    done = done6;
                                }
                                RoutedRequest followup = handleResponse(roureq, response, httpContext);
                                if (followup == null) {
                                    done6 = true;
                                } else {
                                    if (reuse) {
                                        EntityUtils.consume(response.getEntity());
                                        this.managedConn.markReusable();
                                    } else {
                                        this.managedConn.close();
                                        invalidateAuthIfSuccessful(this.proxyAuthState);
                                        invalidateAuthIfSuccessful(this.targetAuthState);
                                    }
                                    if (!followup.getRoute().equals(roureq.getRoute())) {
                                        releaseConnection();
                                    }
                                    roureq = followup;
                                    done6 = done;
                                }
                                try {
                                    if (this.managedConn != null && userToken == null) {
                                        Object userToken2 = this.userTokenHandler.getUserToken(httpContext);
                                        httpContext.setAttribute(ClientContext.USER_TOKEN, userToken2);
                                        if (userToken2 != null) {
                                            this.managedConn.setState(userToken2);
                                        }
                                    }
                                    origWrapper2 = origWrapper;
                                    origRoute2 = origRoute;
                                    target3 = target2;
                                    orig2 = orig;
                                } catch (ConnectionShutdownException e43) {
                                    ex = e43;
                                    HttpHost httpHost35 = target2;
                                    InterruptedIOException ioex22222222 = new InterruptedIOException("Connection has been shut down");
                                    ioex22222222.initCause(ex);
                                    throw ioex22222222;
                                } catch (HttpException e44) {
                                    ex2 = e44;
                                    HttpHost httpHost36 = target2;
                                    abortConnection();
                                    throw ex2;
                                } catch (IOException e45) {
                                    ex3 = e45;
                                    HttpHost httpHost37 = target2;
                                    abortConnection();
                                    throw ex3;
                                } catch (RuntimeException e46) {
                                    ex4 = e46;
                                    HttpHost httpHost38 = target2;
                                    abortConnection();
                                    throw ex4;
                                }
                            }
                        } catch (ConnectionShutdownException e47) {
                            HttpRequest httpRequest33 = orig2;
                            HttpHost httpHost39 = target3;
                            boolean z14 = done6;
                            ex = e47;
                            InterruptedIOException ioex222222222 = new InterruptedIOException("Connection has been shut down");
                            ioex222222222.initCause(ex);
                            throw ioex222222222;
                        } catch (HttpException e48) {
                            HttpRequest httpRequest34 = orig2;
                            HttpHost httpHost40 = target3;
                            boolean z15 = done6;
                            ex2 = e48;
                            abortConnection();
                            throw ex2;
                        } catch (IOException e49) {
                            HttpRequest httpRequest35 = orig2;
                            HttpHost httpHost41 = target3;
                            boolean z16 = done6;
                            ex3 = e49;
                            abortConnection();
                            throw ex3;
                        } catch (RuntimeException e50) {
                            HttpRequest httpRequest36 = orig2;
                            HttpHost httpHost42 = target3;
                            boolean z17 = done6;
                            ex4 = e50;
                            abortConnection();
                            throw ex4;
                        }
                    } catch (TunnelRefusedException e51) {
                        HttpRequest httpRequest37 = orig2;
                        done = done6;
                        TunnelRefusedException ex5 = e51;
                        try {
                            if (this.log.isDebugEnabled()) {
                                this.log.debug(ex5.getMessage());
                            }
                            response = ex5.getResponse();
                        } catch (ConnectionShutdownException e52) {
                            HttpHost httpHost43 = target;
                            ex = e52;
                            boolean z18 = done;
                            InterruptedIOException ioex2222222222 = new InterruptedIOException("Connection has been shut down");
                            ioex2222222222.initCause(ex);
                            throw ioex2222222222;
                        } catch (HttpException e53) {
                            HttpHost httpHost44 = target;
                            ex2 = e53;
                            boolean z19 = done;
                            abortConnection();
                            throw ex2;
                        } catch (IOException e54) {
                            HttpHost httpHost45 = target;
                            ex3 = e54;
                            boolean z20 = done;
                            abortConnection();
                            throw ex3;
                        } catch (RuntimeException e55) {
                            HttpHost httpHost46 = target;
                            ex4 = e55;
                            boolean z21 = done;
                            abortConnection();
                            throw ex4;
                        }
                    }
                } catch (ConnectionShutdownException e56) {
                    HttpRequest httpRequest38 = orig2;
                    boolean z22 = done6;
                    HttpHost httpHost47 = target;
                    ex = e56;
                    InterruptedIOException ioex22222222222 = new InterruptedIOException("Connection has been shut down");
                    ioex22222222222.initCause(ex);
                    throw ioex22222222222;
                } catch (HttpException e57) {
                    HttpRequest httpRequest39 = orig2;
                    boolean z23 = done6;
                    HttpHost httpHost48 = target;
                    ex2 = e57;
                    abortConnection();
                    throw ex2;
                } catch (IOException e58) {
                    HttpRequest httpRequest40 = orig2;
                    boolean z24 = done6;
                    HttpHost httpHost49 = target;
                    ex3 = e58;
                    abortConnection();
                    throw ex3;
                } catch (RuntimeException e59) {
                    HttpRequest httpRequest41 = orig2;
                    boolean z25 = done6;
                    HttpHost httpHost50 = target;
                    ex4 = e59;
                    abortConnection();
                    throw ex4;
                }
            } catch (ConnectionShutdownException e60) {
                HttpRequest httpRequest42 = orig2;
                RequestWrapper requestWrapper5 = origWrapper2;
                HttpHost httpHost51 = target3;
                HttpRoute httpRoute14 = origRoute2;
                boolean z26 = done6;
                ex = e60;
                InterruptedIOException ioex222222222222 = new InterruptedIOException("Connection has been shut down");
                ioex222222222222.initCause(ex);
                throw ioex222222222222;
            } catch (HttpException e61) {
                HttpRequest httpRequest43 = orig2;
                RequestWrapper requestWrapper6 = origWrapper2;
                HttpHost httpHost52 = target3;
                HttpRoute httpRoute15 = origRoute2;
                boolean z27 = done6;
                ex2 = e61;
                abortConnection();
                throw ex2;
            } catch (IOException e62) {
                HttpRequest httpRequest44 = orig2;
                RequestWrapper requestWrapper7 = origWrapper2;
                HttpHost httpHost53 = target3;
                HttpRoute httpRoute16 = origRoute2;
                boolean z28 = done6;
                ex3 = e62;
                abortConnection();
                throw ex3;
            } catch (RuntimeException e63) {
                HttpRequest httpRequest45 = orig2;
                RequestWrapper requestWrapper8 = origWrapper2;
                HttpHost httpHost54 = target3;
                HttpRoute httpRoute17 = origRoute2;
                boolean z29 = done6;
                ex4 = e63;
                abortConnection();
                throw ex4;
            }
        }
        RequestWrapper requestWrapper9 = origWrapper2;
        HttpHost httpHost55 = target3;
        HttpRoute httpRoute18 = origRoute2;
        boolean z30 = done6;
        if (!(response == null || response.getEntity() == null)) {
            if (response.getEntity().isStreaming()) {
                response.setEntity(new BasicManagedEntity(response.getEntity(), this.managedConn, reuse));
                return response;
            }
        }
        if (reuse) {
            this.managedConn.markReusable();
        }
        releaseConnection();
        return response;
    }

    private void tryConnect(RoutedRequest req, HttpContext context) throws HttpException, IOException {
        HttpRoute route = req.getRoute();
        int connectCount = 0;
        while (true) {
            connectCount++;
            try {
                if (!this.managedConn.isOpen()) {
                    this.managedConn.open(route, context, this.params);
                } else {
                    this.managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(this.params));
                }
                establishRoute(route, context);
                return;
            } catch (IOException ex) {
                try {
                    this.managedConn.close();
                } catch (IOException e) {
                }
                if (this.retryHandler.retryRequest(ex, connectCount, context)) {
                    if (this.log.isInfoEnabled()) {
                        Log log2 = this.log;
                        log2.info("I/O exception (" + ex.getClass().getName() + ") caught when connecting to the target host: " + ex.getMessage());
                    }
                    if (this.log.isDebugEnabled()) {
                        this.log.debug(ex.getMessage(), ex);
                    }
                    this.log.info("Retrying connect");
                } else {
                    throw ex;
                }
            }
        }
    }

    private HttpResponse tryExecute(RoutedRequest req, HttpContext context) throws HttpException, IOException {
        RequestWrapper wrapper = req.getRequest();
        HttpRoute route = req.getRoute();
        Exception retryReason = null;
        while (true) {
            this.execCount++;
            wrapper.incrementExecCount();
            if (!wrapper.isRepeatable()) {
                this.log.debug("Cannot retry non-repeatable request");
                if (retryReason != null) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.  The cause lists the reason the original request failed.", retryReason);
                }
                throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
            }
            try {
                if (!this.managedConn.isOpen()) {
                    if (!route.isTunnelled()) {
                        this.log.debug("Reopening the direct connection.");
                        this.managedConn.open(route, context, this.params);
                    } else {
                        this.log.debug("Proxied connection. Need to start over.");
                        return null;
                    }
                }
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Attempt " + this.execCount + " to execute request");
                }
                return this.requestExec.execute(wrapper, this.managedConn, context);
            } catch (IOException ex) {
                this.log.debug("Closing the connection.");
                try {
                    this.managedConn.close();
                } catch (IOException e) {
                }
                if (this.retryHandler.retryRequest(ex, wrapper.getExecCount(), context)) {
                    if (this.log.isInfoEnabled()) {
                        this.log.info("I/O exception (" + ex.getClass().getName() + ") caught when processing request: " + ex.getMessage());
                    }
                    if (this.log.isDebugEnabled()) {
                        this.log.debug(ex.getMessage(), ex);
                    }
                    this.log.info("Retrying request");
                    retryReason = ex;
                } else {
                    throw ex;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void releaseConnection() {
        try {
            this.managedConn.releaseConnection();
        } catch (IOException ignored) {
            this.log.debug("IOException releasing connection", ignored);
        }
        this.managedConn = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: org.apache.http.HttpHost} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.http.conn.routing.HttpRoute determineRoute(org.apache.http.HttpHost r3, org.apache.http.HttpRequest r4, org.apache.http.protocol.HttpContext r5) throws org.apache.http.HttpException {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            org.apache.http.params.HttpParams r0 = r4.getParams()
            java.lang.String r1 = "http.default-host"
            java.lang.Object r0 = r0.getParameter(r1)
            r3 = r0
            org.apache.http.HttpHost r3 = (org.apache.http.HttpHost) r3
        L_0x000f:
            if (r3 == 0) goto L_0x0018
            org.apache.http.conn.routing.HttpRoutePlanner r0 = r2.routePlanner
            org.apache.http.conn.routing.HttpRoute r0 = r0.determineRoute(r3, r4, r5)
            return r0
        L_0x0018:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Target host must not be null, or set in parameters."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.client.DefaultRequestDirector.determineRoute(org.apache.http.HttpHost, org.apache.http.HttpRequest, org.apache.http.protocol.HttpContext):org.apache.http.conn.routing.HttpRoute");
    }

    /* access modifiers changed from: protected */
    public void establishRoute(HttpRoute route, HttpContext context) throws HttpException, IOException {
        int step;
        HttpRouteDirector rowdy = new BasicRouteDirector();
        do {
            HttpRoute fact = this.managedConn.getRoute();
            step = rowdy.nextStep(route, fact);
            switch (step) {
                case -1:
                    throw new HttpException("Unable to establish route: planned = " + route + "; current = " + fact);
                case 0:
                    break;
                case 1:
                case 2:
                    this.managedConn.open(route, context, this.params);
                    continue;
                case 3:
                    boolean secure = createTunnelToTarget(route, context);
                    this.log.debug("Tunnel to target created.");
                    this.managedConn.tunnelTarget(secure, this.params);
                    continue;
                case 4:
                    int hop = fact.getHopCount() - 1;
                    boolean secure2 = createTunnelToProxy(route, hop, context);
                    this.log.debug("Tunnel to proxy created.");
                    this.managedConn.tunnelProxy(route.getHopTarget(hop), secure2, this.params);
                    continue;
                case 5:
                    this.managedConn.layerProtocol(context, this.params);
                    continue;
                default:
                    throw new IllegalStateException("Unknown step indicator " + step + " from RouteDirector.");
            }
        } while (step > 0);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0118 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean createTunnelToTarget(org.apache.http.conn.routing.HttpRoute r19, org.apache.http.protocol.HttpContext r20) throws org.apache.http.HttpException, java.io.IOException {
        /*
            r18 = this;
            r7 = r18
            r8 = r20
            org.apache.http.HttpHost r9 = r19.getProxyHost()
            org.apache.http.HttpHost r10 = r19.getTargetHost()
            r0 = 0
            r1 = 0
        L_0x000e:
            if (r1 != 0) goto L_0x0138
            r11 = 1
            org.apache.http.conn.ManagedClientConnection r1 = r7.managedConn
            boolean r1 = r1.isOpen()
            if (r1 != 0) goto L_0x0023
            org.apache.http.conn.ManagedClientConnection r1 = r7.managedConn
            org.apache.http.params.HttpParams r2 = r7.params
            r12 = r19
            r1.open(r12, r8, r2)
            goto L_0x0025
        L_0x0023:
            r12 = r19
        L_0x0025:
            org.apache.http.HttpRequest r13 = r18.createConnectRequest(r19, r20)
            org.apache.http.params.HttpParams r1 = r7.params
            r13.setParams(r1)
            java.lang.String r1 = "http.target_host"
            r8.setAttribute(r1, r10)
            java.lang.String r1 = "http.proxy_host"
            r8.setAttribute(r1, r9)
            org.apache.http.conn.ManagedClientConnection r1 = r7.managedConn
            java.lang.String r2 = "http.connection"
            r8.setAttribute(r2, r1)
            org.apache.http.auth.AuthState r1 = r7.targetAuthState
            java.lang.String r2 = "http.auth.target-scope"
            r8.setAttribute(r2, r1)
            org.apache.http.auth.AuthState r1 = r7.proxyAuthState
            java.lang.String r2 = "http.auth.proxy-scope"
            r8.setAttribute(r2, r1)
            java.lang.String r1 = "http.request"
            r8.setAttribute(r1, r13)
            org.apache.http.protocol.HttpRequestExecutor r1 = r7.requestExec
            org.apache.http.protocol.HttpProcessor r2 = r7.httpProcessor
            r1.preProcess(r13, r2, r8)
            org.apache.http.protocol.HttpRequestExecutor r1 = r7.requestExec
            org.apache.http.conn.ManagedClientConnection r2 = r7.managedConn
            org.apache.http.HttpResponse r14 = r1.execute(r13, r2, r8)
            org.apache.http.params.HttpParams r0 = r7.params
            r14.setParams(r0)
            org.apache.http.protocol.HttpRequestExecutor r0 = r7.requestExec
            org.apache.http.protocol.HttpProcessor r1 = r7.httpProcessor
            r0.postProcess(r14, r1, r8)
            org.apache.http.StatusLine r0 = r14.getStatusLine()
            int r15 = r0.getStatusCode()
            r0 = 200(0xc8, float:2.8E-43)
            if (r15 < r0) goto L_0x011d
            java.lang.String r0 = "http.auth.credentials-provider"
            java.lang.Object r0 = r8.getAttribute(r0)
            r6 = r0
            org.apache.http.client.CredentialsProvider r6 = (org.apache.http.client.CredentialsProvider) r6
            if (r6 == 0) goto L_0x0114
            org.apache.http.params.HttpParams r0 = r7.params
            boolean r0 = org.apache.http.client.params.HttpClientParams.isAuthenticating(r0)
            if (r0 == 0) goto L_0x0114
            org.apache.http.client.AuthenticationHandler r0 = r7.proxyAuthHandler
            boolean r0 = r0.isAuthenticationRequested(r14, r8)
            if (r0 == 0) goto L_0x010a
            org.apache.commons.logging.Log r0 = r7.log
            java.lang.String r1 = "Proxy requested authentication"
            r0.debug(r1)
            org.apache.http.client.AuthenticationHandler r0 = r7.proxyAuthHandler
            java.util.Map r16 = r0.getChallenges(r14, r8)
            org.apache.http.auth.AuthState r3 = r7.proxyAuthState     // Catch:{ AuthenticationException -> 0x00b5 }
            org.apache.http.client.AuthenticationHandler r4 = r7.proxyAuthHandler     // Catch:{ AuthenticationException -> 0x00b5 }
            r1 = r18
            r2 = r16
            r5 = r14
            r17 = r10
            r10 = r6
            r6 = r20
            r1.processChallenges(r2, r3, r4, r5, r6)     // Catch:{ AuthenticationException -> 0x00b3 }
            goto L_0x00de
        L_0x00b3:
            r0 = move-exception
            goto L_0x00b9
        L_0x00b5:
            r0 = move-exception
            r17 = r10
            r10 = r6
        L_0x00b9:
            org.apache.commons.logging.Log r1 = r7.log
            boolean r1 = r1.isWarnEnabled()
            if (r1 == 0) goto L_0x00de
            org.apache.commons.logging.Log r1 = r7.log
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Authentication error: "
            r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.warn(r2)
            r1 = r11
            r0 = r14
            goto L_0x013c
        L_0x00de:
            org.apache.http.auth.AuthState r0 = r7.proxyAuthState
            r7.updateAuthState(r0, r9, r10)
            org.apache.http.auth.AuthState r0 = r7.proxyAuthState
            org.apache.http.auth.Credentials r0 = r0.getCredentials()
            if (r0 == 0) goto L_0x0108
            r11 = 0
            org.apache.http.ConnectionReuseStrategy r0 = r7.reuseStrategy
            boolean r0 = r0.keepAlive(r14, r8)
            if (r0 == 0) goto L_0x0103
            org.apache.commons.logging.Log r0 = r7.log
            java.lang.String r1 = "Connection kept alive"
            r0.debug(r1)
            org.apache.http.HttpEntity r0 = r14.getEntity()
            org.apache.http.util.EntityUtils.consume(r0)
            goto L_0x0108
        L_0x0103:
            org.apache.http.conn.ManagedClientConnection r0 = r7.managedConn
            r0.close()
        L_0x0108:
            r1 = r11
            goto L_0x0118
        L_0x010a:
            r17 = r10
            r10 = r6
            org.apache.http.auth.AuthState r0 = r7.proxyAuthState
            r1 = 0
            r0.setAuthScope(r1)
            goto L_0x0117
        L_0x0114:
            r17 = r10
            r10 = r6
        L_0x0117:
            r1 = r11
        L_0x0118:
            r0 = r14
            r10 = r17
            goto L_0x000e
        L_0x011d:
            org.apache.http.HttpException r0 = new org.apache.http.HttpException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected response to CONNECT request: "
            r1.append(r2)
            org.apache.http.StatusLine r2 = r14.getStatusLine()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0138:
            r12 = r19
            r17 = r10
        L_0x013c:
            org.apache.http.StatusLine r2 = r0.getStatusLine()
            int r2 = r2.getStatusCode()
            r3 = 299(0x12b, float:4.19E-43)
            if (r2 <= r3) goto L_0x0176
            org.apache.http.HttpEntity r3 = r0.getEntity()
            if (r3 == 0) goto L_0x0156
            org.apache.http.entity.BufferedHttpEntity r4 = new org.apache.http.entity.BufferedHttpEntity
            r4.<init>(r3)
            r0.setEntity(r4)
        L_0x0156:
            org.apache.http.conn.ManagedClientConnection r4 = r7.managedConn
            r4.close()
            org.apache.http.impl.client.TunnelRefusedException r4 = new org.apache.http.impl.client.TunnelRefusedException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "CONNECT refused by proxy: "
            r5.append(r6)
            org.apache.http.StatusLine r6 = r0.getStatusLine()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5, r0)
            throw r4
        L_0x0176:
            org.apache.http.conn.ManagedClientConnection r3 = r7.managedConn
            r3.markReusable()
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.client.DefaultRequestDirector.createTunnelToTarget(org.apache.http.conn.routing.HttpRoute, org.apache.http.protocol.HttpContext):boolean");
    }

    /* access modifiers changed from: protected */
    public boolean createTunnelToProxy(HttpRoute route, int hop, HttpContext context) throws HttpException, IOException {
        throw new HttpException("Proxy chains are not supported.");
    }

    /* access modifiers changed from: protected */
    public HttpRequest createConnectRequest(HttpRoute route, HttpContext context) {
        HttpHost target = route.getTargetHost();
        String host = target.getHostName();
        int port = target.getPort();
        if (port < 0) {
            port = this.connManager.getSchemeRegistry().getScheme(target.getSchemeName()).getDefaultPort();
        }
        StringBuilder buffer = new StringBuilder(host.length() + 6);
        buffer.append(host);
        buffer.append(':');
        buffer.append(Integer.toString(port));
        return new BasicHttpRequest("CONNECT", buffer.toString(), HttpProtocolParams.getVersion(this.params));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0171 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0172 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01d8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01d9 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.http.impl.client.RoutedRequest handleResponse(org.apache.http.impl.client.RoutedRequest r20, org.apache.http.HttpResponse r21, org.apache.http.protocol.HttpContext r22) throws org.apache.http.HttpException, java.io.IOException {
        /*
            r19 = this;
            r7 = r19
            r8 = r21
            r9 = r22
            org.apache.http.conn.routing.HttpRoute r10 = r20.getRoute()
            org.apache.http.impl.client.RequestWrapper r11 = r20.getRequest()
            org.apache.http.params.HttpParams r12 = r11.getParams()
            boolean r0 = org.apache.http.client.params.HttpClientParams.isRedirecting(r12)
            r13 = 0
            if (r0 == 0) goto L_0x00f1
            org.apache.http.client.RedirectStrategy r0 = r7.redirectStrategy
            boolean r0 = r0.isRedirected(r11, r8, r9)
            if (r0 == 0) goto L_0x00f1
            int r0 = r7.redirectCount
            int r1 = r7.maxRedirects
            if (r0 >= r1) goto L_0x00d3
            int r0 = r0 + 1
            r7.redirectCount = r0
            r7.virtualHost = r13
            org.apache.http.client.RedirectStrategy r0 = r7.redirectStrategy
            org.apache.http.client.methods.HttpUriRequest r0 = r0.getRedirect(r11, r8, r9)
            org.apache.http.HttpRequest r1 = r11.getOriginal()
            org.apache.http.Header[] r2 = r1.getAllHeaders()
            r0.setHeaders(r2)
            java.net.URI r2 = r0.getURI()
            java.lang.String r3 = r2.getHost()
            if (r3 == 0) goto L_0x00bc
            org.apache.http.HttpHost r3 = new org.apache.http.HttpHost
            java.lang.String r4 = r2.getHost()
            int r5 = r2.getPort()
            java.lang.String r6 = r2.getScheme()
            r3.<init>(r4, r5, r6)
            org.apache.http.auth.AuthState r4 = r7.targetAuthState
            r4.setAuthScope(r13)
            org.apache.http.auth.AuthState r4 = r7.proxyAuthState
            r4.setAuthScope(r13)
            org.apache.http.HttpHost r4 = r10.getTargetHost()
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0085
            org.apache.http.auth.AuthState r4 = r7.targetAuthState
            r4.invalidate()
            org.apache.http.auth.AuthState r4 = r7.proxyAuthState
            org.apache.http.auth.AuthScheme r4 = r4.getAuthScheme()
            if (r4 == 0) goto L_0x0085
            boolean r5 = r4.isConnectionBased()
            if (r5 == 0) goto L_0x0085
            org.apache.http.auth.AuthState r5 = r7.proxyAuthState
            r5.invalidate()
        L_0x0085:
            org.apache.http.impl.client.RequestWrapper r4 = r7.wrapRequest(r0)
            r4.setParams(r12)
            org.apache.http.conn.routing.HttpRoute r5 = r7.determineRoute(r3, r4, r9)
            org.apache.http.impl.client.RoutedRequest r6 = new org.apache.http.impl.client.RoutedRequest
            r6.<init>(r4, r5)
            org.apache.commons.logging.Log r13 = r7.log
            boolean r13 = r13.isDebugEnabled()
            if (r13 == 0) goto L_0x00bb
            org.apache.commons.logging.Log r13 = r7.log
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Redirecting to '"
            r14.append(r15)
            r14.append(r2)
            java.lang.String r15 = "' via "
            r14.append(r15)
            r14.append(r5)
            java.lang.String r14 = r14.toString()
            r13.debug(r14)
        L_0x00bb:
            return r6
        L_0x00bc:
            org.apache.http.ProtocolException r3 = new org.apache.http.ProtocolException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Redirect URI does not specify a valid host name: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x00d3:
            org.apache.http.client.RedirectException r0 = new org.apache.http.client.RedirectException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Maximum redirects ("
            r1.append(r2)
            int r2 = r7.maxRedirects
            r1.append(r2)
            java.lang.String r2 = ") exceeded"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00f1:
            java.lang.String r0 = "http.auth.credentials-provider"
            java.lang.Object r0 = r9.getAttribute(r0)
            r14 = r0
            org.apache.http.client.CredentialsProvider r14 = (org.apache.http.client.CredentialsProvider) r14
            if (r14 == 0) goto L_0x01df
            boolean r0 = org.apache.http.client.params.HttpClientParams.isAuthenticating(r12)
            if (r0 == 0) goto L_0x01df
            org.apache.http.client.AuthenticationHandler r0 = r7.targetAuthHandler
            boolean r0 = r0.isAuthenticationRequested(r8, r9)
            java.lang.String r15 = "Authentication error: "
            if (r0 == 0) goto L_0x0173
            java.lang.String r0 = "http.target_host"
            java.lang.Object r0 = r9.getAttribute(r0)
            org.apache.http.HttpHost r0 = (org.apache.http.HttpHost) r0
            if (r0 != 0) goto L_0x011c
            org.apache.http.HttpHost r0 = r10.getTargetHost()
            r6 = r0
            goto L_0x011d
        L_0x011c:
            r6 = r0
        L_0x011d:
            org.apache.commons.logging.Log r0 = r7.log
            java.lang.String r1 = "Target requested authentication"
            r0.debug(r1)
            org.apache.http.client.AuthenticationHandler r0 = r7.targetAuthHandler
            java.util.Map r16 = r0.getChallenges(r8, r9)
            org.apache.http.auth.AuthState r3 = r7.targetAuthState     // Catch:{ AuthenticationException -> 0x013e }
            org.apache.http.client.AuthenticationHandler r4 = r7.targetAuthHandler     // Catch:{ AuthenticationException -> 0x013e }
            r1 = r19
            r2 = r16
            r5 = r21
            r17 = r6
            r6 = r22
            r1.processChallenges(r2, r3, r4, r5, r6)     // Catch:{ AuthenticationException -> 0x013c }
            goto L_0x0162
        L_0x013c:
            r0 = move-exception
            goto L_0x0141
        L_0x013e:
            r0 = move-exception
            r17 = r6
        L_0x0141:
            org.apache.commons.logging.Log r1 = r7.log
            boolean r1 = r1.isWarnEnabled()
            if (r1 == 0) goto L_0x0162
            org.apache.commons.logging.Log r1 = r7.log
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r15)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.warn(r2)
            return r13
        L_0x0162:
            org.apache.http.auth.AuthState r0 = r7.targetAuthState
            r1 = r17
            r7.updateAuthState(r0, r1, r14)
            org.apache.http.auth.AuthState r0 = r7.targetAuthState
            org.apache.http.auth.Credentials r0 = r0.getCredentials()
            if (r0 == 0) goto L_0x0172
            return r20
        L_0x0172:
            return r13
        L_0x0173:
            org.apache.http.auth.AuthState r0 = r7.targetAuthState
            r0.setAuthScope(r13)
            org.apache.http.client.AuthenticationHandler r0 = r7.proxyAuthHandler
            boolean r0 = r0.isAuthenticationRequested(r8, r9)
            if (r0 == 0) goto L_0x01da
            org.apache.http.HttpHost r6 = r10.getProxyHost()
            org.apache.commons.logging.Log r0 = r7.log
            java.lang.String r1 = "Proxy requested authentication"
            r0.debug(r1)
            org.apache.http.client.AuthenticationHandler r0 = r7.proxyAuthHandler
            java.util.Map r16 = r0.getChallenges(r8, r9)
            org.apache.http.auth.AuthState r3 = r7.proxyAuthState     // Catch:{ AuthenticationException -> 0x01a5 }
            org.apache.http.client.AuthenticationHandler r4 = r7.proxyAuthHandler     // Catch:{ AuthenticationException -> 0x01a5 }
            r1 = r19
            r2 = r16
            r5 = r21
            r18 = r6
            r6 = r22
            r1.processChallenges(r2, r3, r4, r5, r6)     // Catch:{ AuthenticationException -> 0x01a3 }
            goto L_0x01c9
        L_0x01a3:
            r0 = move-exception
            goto L_0x01a8
        L_0x01a5:
            r0 = move-exception
            r18 = r6
        L_0x01a8:
            org.apache.commons.logging.Log r1 = r7.log
            boolean r1 = r1.isWarnEnabled()
            if (r1 == 0) goto L_0x01c9
            org.apache.commons.logging.Log r1 = r7.log
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r15)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.warn(r2)
            return r13
        L_0x01c9:
            org.apache.http.auth.AuthState r0 = r7.proxyAuthState
            r1 = r18
            r7.updateAuthState(r0, r1, r14)
            org.apache.http.auth.AuthState r0 = r7.proxyAuthState
            org.apache.http.auth.Credentials r0 = r0.getCredentials()
            if (r0 == 0) goto L_0x01d9
            return r20
        L_0x01d9:
            return r13
        L_0x01da:
            org.apache.http.auth.AuthState r0 = r7.proxyAuthState
            r0.setAuthScope(r13)
        L_0x01df:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.client.DefaultRequestDirector.handleResponse(org.apache.http.impl.client.RoutedRequest, org.apache.http.HttpResponse, org.apache.http.protocol.HttpContext):org.apache.http.impl.client.RoutedRequest");
    }

    private void abortConnection() {
        ManagedClientConnection mcc = this.managedConn;
        if (mcc != null) {
            this.managedConn = null;
            try {
                mcc.abortConnection();
            } catch (IOException ex) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug(ex.getMessage(), ex);
                }
            }
            try {
                mcc.releaseConnection();
            } catch (IOException ignored) {
                this.log.debug("Error releasing connection", ignored);
            }
        }
    }

    private void processChallenges(Map<String, Header> challenges, AuthState authState, AuthenticationHandler authHandler, HttpResponse response, HttpContext context) throws MalformedChallengeException, AuthenticationException {
        AuthScheme authScheme = authState.getAuthScheme();
        if (authScheme == null) {
            authScheme = authHandler.selectScheme(challenges, response, context);
            authState.setAuthScheme(authScheme);
        }
        String id = authScheme.getSchemeName();
        Header challenge = challenges.get(id.toLowerCase(Locale.ENGLISH));
        if (challenge != null) {
            authScheme.processChallenge(challenge);
            this.log.debug("Authorization challenge processed");
            return;
        }
        throw new AuthenticationException(id + " authorization challenge expected, but not found");
    }

    private void updateAuthState(AuthState authState, HttpHost host, CredentialsProvider credsProvider) {
        if (authState.isValid()) {
            String hostname = host.getHostName();
            int port = host.getPort();
            if (port < 0) {
                port = this.connManager.getSchemeRegistry().getScheme(host).getDefaultPort();
            }
            AuthScheme authScheme = authState.getAuthScheme();
            AuthScope authScope = new AuthScope(hostname, port, authScheme.getRealm(), authScheme.getSchemeName());
            if (this.log.isDebugEnabled()) {
                Log log2 = this.log;
                log2.debug("Authentication scope: " + authScope);
            }
            Credentials creds = authState.getCredentials();
            if (creds == null) {
                creds = credsProvider.getCredentials(authScope);
                if (this.log.isDebugEnabled()) {
                    if (creds != null) {
                        this.log.debug("Found credentials");
                    } else {
                        this.log.debug("Credentials not found");
                    }
                }
            } else if (authScheme.isComplete()) {
                this.log.debug("Authentication failed");
                creds = null;
            }
            authState.setAuthScope(authScope);
            authState.setCredentials(creds);
        }
    }

    private void invalidateAuthIfSuccessful(AuthState authState) {
        AuthScheme authscheme = authState.getAuthScheme();
        if (authscheme != null && authscheme.isConnectionBased() && authscheme.isComplete() && authState.getCredentials() != null) {
            authState.invalidate();
        }
    }
}
