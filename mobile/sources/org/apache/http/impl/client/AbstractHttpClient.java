package org.apache.http.impl.client;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.auth.DigestSchemeFactory;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.auth.NegotiateSchemeFactory;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.impl.cookie.IgnoreSpecFactory;
import org.apache.http.impl.cookie.NetscapeDraftSpecFactory;
import org.apache.http.impl.cookie.RFC2109SpecFactory;
import org.apache.http.impl.cookie.RFC2965SpecFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.DefaultedHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.util.EntityUtils;

@ThreadSafe
public abstract class AbstractHttpClient implements HttpClient {
    @GuardedBy("this")
    private ClientConnectionManager connManager;
    @GuardedBy("this")
    private CookieStore cookieStore;
    @GuardedBy("this")
    private CredentialsProvider credsProvider;
    @GuardedBy("this")
    private HttpParams defaultParams;
    @GuardedBy("this")
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    private final Log log = LogFactory.getLog(getClass());
    @GuardedBy("this")
    private BasicHttpProcessor mutableProcessor;
    @GuardedBy("this")
    private ImmutableHttpProcessor protocolProcessor;
    @GuardedBy("this")
    private AuthenticationHandler proxyAuthHandler;
    @GuardedBy("this")
    private RedirectStrategy redirectStrategy;
    @GuardedBy("this")
    private HttpRequestExecutor requestExec;
    @GuardedBy("this")
    private HttpRequestRetryHandler retryHandler;
    @GuardedBy("this")
    private ConnectionReuseStrategy reuseStrategy;
    @GuardedBy("this")
    private HttpRoutePlanner routePlanner;
    @GuardedBy("this")
    private AuthSchemeRegistry supportedAuthSchemes;
    @GuardedBy("this")
    private CookieSpecRegistry supportedCookieSpecs;
    @GuardedBy("this")
    private AuthenticationHandler targetAuthHandler;
    @GuardedBy("this")
    private UserTokenHandler userTokenHandler;

    /* access modifiers changed from: protected */
    public abstract HttpParams createHttpParams();

    /* access modifiers changed from: protected */
    public abstract BasicHttpProcessor createHttpProcessor();

    protected AbstractHttpClient(ClientConnectionManager conman, HttpParams params) {
        this.defaultParams = params;
        this.connManager = conman;
    }

    /* access modifiers changed from: protected */
    public HttpContext createHttpContext() {
        HttpContext context = new BasicHttpContext();
        context.setAttribute(ClientContext.SCHEME_REGISTRY, getConnectionManager().getSchemeRegistry());
        context.setAttribute(ClientContext.AUTHSCHEME_REGISTRY, getAuthSchemes());
        context.setAttribute(ClientContext.COOKIESPEC_REGISTRY, getCookieSpecs());
        context.setAttribute(ClientContext.COOKIE_STORE, getCookieStore());
        context.setAttribute(ClientContext.CREDS_PROVIDER, getCredentialsProvider());
        return context;
    }

    /* access modifiers changed from: protected */
    public ClientConnectionManager createClientConnectionManager() {
        SchemeRegistry registry = SchemeRegistryFactory.createDefault();
        HttpParams params = getParams();
        ClientConnectionManagerFactory factory = null;
        String className = (String) params.getParameter(ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME);
        if (className != null) {
            try {
                factory = (ClientConnectionManagerFactory) Class.forName(className).newInstance();
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Invalid class name: " + className);
            } catch (IllegalAccessException ex) {
                throw new IllegalAccessError(ex.getMessage());
            } catch (InstantiationException ex2) {
                throw new InstantiationError(ex2.getMessage());
            }
        }
        if (factory != null) {
            return factory.newInstance(params, registry);
        }
        return new SingleClientConnManager(registry);
    }

    /* access modifiers changed from: protected */
    public AuthSchemeRegistry createAuthSchemeRegistry() {
        AuthSchemeRegistry registry = new AuthSchemeRegistry();
        registry.register(AuthPolicy.BASIC, new BasicSchemeFactory());
        registry.register(AuthPolicy.DIGEST, new DigestSchemeFactory());
        registry.register(AuthPolicy.NTLM, new NTLMSchemeFactory());
        registry.register(AuthPolicy.SPNEGO, new NegotiateSchemeFactory());
        return registry;
    }

    /* access modifiers changed from: protected */
    public CookieSpecRegistry createCookieSpecRegistry() {
        CookieSpecRegistry registry = new CookieSpecRegistry();
        registry.register(CookiePolicy.BEST_MATCH, new BestMatchSpecFactory());
        registry.register(CookiePolicy.BROWSER_COMPATIBILITY, new BrowserCompatSpecFactory());
        registry.register(CookiePolicy.NETSCAPE, new NetscapeDraftSpecFactory());
        registry.register(CookiePolicy.RFC_2109, new RFC2109SpecFactory());
        registry.register(CookiePolicy.RFC_2965, new RFC2965SpecFactory());
        registry.register(CookiePolicy.IGNORE_COOKIES, new IgnoreSpecFactory());
        return registry;
    }

    /* access modifiers changed from: protected */
    public HttpRequestExecutor createRequestExecutor() {
        return new HttpRequestExecutor();
    }

    /* access modifiers changed from: protected */
    public ConnectionReuseStrategy createConnectionReuseStrategy() {
        return new DefaultConnectionReuseStrategy();
    }

    /* access modifiers changed from: protected */
    public ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new DefaultConnectionKeepAliveStrategy();
    }

    /* access modifiers changed from: protected */
    public HttpRequestRetryHandler createHttpRequestRetryHandler() {
        return new DefaultHttpRequestRetryHandler();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public RedirectHandler createRedirectHandler() {
        return new DefaultRedirectHandler();
    }

    /* access modifiers changed from: protected */
    public AuthenticationHandler createTargetAuthenticationHandler() {
        return new DefaultTargetAuthenticationHandler();
    }

    /* access modifiers changed from: protected */
    public AuthenticationHandler createProxyAuthenticationHandler() {
        return new DefaultProxyAuthenticationHandler();
    }

    /* access modifiers changed from: protected */
    public CookieStore createCookieStore() {
        return new BasicCookieStore();
    }

    /* access modifiers changed from: protected */
    public CredentialsProvider createCredentialsProvider() {
        return new BasicCredentialsProvider();
    }

    /* access modifiers changed from: protected */
    public HttpRoutePlanner createHttpRoutePlanner() {
        return new DefaultHttpRoutePlanner(getConnectionManager().getSchemeRegistry());
    }

    /* access modifiers changed from: protected */
    public UserTokenHandler createUserTokenHandler() {
        return new DefaultUserTokenHandler();
    }

    public final synchronized HttpParams getParams() {
        if (this.defaultParams == null) {
            this.defaultParams = createHttpParams();
        }
        return this.defaultParams;
    }

    public synchronized void setParams(HttpParams params) {
        this.defaultParams = params;
    }

    public final synchronized ClientConnectionManager getConnectionManager() {
        if (this.connManager == null) {
            this.connManager = createClientConnectionManager();
        }
        return this.connManager;
    }

    public final synchronized HttpRequestExecutor getRequestExecutor() {
        if (this.requestExec == null) {
            this.requestExec = createRequestExecutor();
        }
        return this.requestExec;
    }

    public final synchronized AuthSchemeRegistry getAuthSchemes() {
        if (this.supportedAuthSchemes == null) {
            this.supportedAuthSchemes = createAuthSchemeRegistry();
        }
        return this.supportedAuthSchemes;
    }

    public synchronized void setAuthSchemes(AuthSchemeRegistry authSchemeRegistry) {
        this.supportedAuthSchemes = authSchemeRegistry;
    }

    public final synchronized CookieSpecRegistry getCookieSpecs() {
        if (this.supportedCookieSpecs == null) {
            this.supportedCookieSpecs = createCookieSpecRegistry();
        }
        return this.supportedCookieSpecs;
    }

    public synchronized void setCookieSpecs(CookieSpecRegistry cookieSpecRegistry) {
        this.supportedCookieSpecs = cookieSpecRegistry;
    }

    public final synchronized ConnectionReuseStrategy getConnectionReuseStrategy() {
        if (this.reuseStrategy == null) {
            this.reuseStrategy = createConnectionReuseStrategy();
        }
        return this.reuseStrategy;
    }

    public synchronized void setReuseStrategy(ConnectionReuseStrategy reuseStrategy2) {
        this.reuseStrategy = reuseStrategy2;
    }

    public final synchronized ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
        if (this.keepAliveStrategy == null) {
            this.keepAliveStrategy = createConnectionKeepAliveStrategy();
        }
        return this.keepAliveStrategy;
    }

    public synchronized void setKeepAliveStrategy(ConnectionKeepAliveStrategy keepAliveStrategy2) {
        this.keepAliveStrategy = keepAliveStrategy2;
    }

    public final synchronized HttpRequestRetryHandler getHttpRequestRetryHandler() {
        if (this.retryHandler == null) {
            this.retryHandler = createHttpRequestRetryHandler();
        }
        return this.retryHandler;
    }

    public synchronized void setHttpRequestRetryHandler(HttpRequestRetryHandler retryHandler2) {
        this.retryHandler = retryHandler2;
    }

    @Deprecated
    public final synchronized RedirectHandler getRedirectHandler() {
        return createRedirectHandler();
    }

    @Deprecated
    public synchronized void setRedirectHandler(RedirectHandler redirectHandler) {
        this.redirectStrategy = new DefaultRedirectStrategyAdaptor(redirectHandler);
    }

    public final synchronized RedirectStrategy getRedirectStrategy() {
        if (this.redirectStrategy == null) {
            this.redirectStrategy = new DefaultRedirectStrategy();
        }
        return this.redirectStrategy;
    }

    public synchronized void setRedirectStrategy(RedirectStrategy redirectStrategy2) {
        this.redirectStrategy = redirectStrategy2;
    }

    public final synchronized AuthenticationHandler getTargetAuthenticationHandler() {
        if (this.targetAuthHandler == null) {
            this.targetAuthHandler = createTargetAuthenticationHandler();
        }
        return this.targetAuthHandler;
    }

    public synchronized void setTargetAuthenticationHandler(AuthenticationHandler targetAuthHandler2) {
        this.targetAuthHandler = targetAuthHandler2;
    }

    public final synchronized AuthenticationHandler getProxyAuthenticationHandler() {
        if (this.proxyAuthHandler == null) {
            this.proxyAuthHandler = createProxyAuthenticationHandler();
        }
        return this.proxyAuthHandler;
    }

    public synchronized void setProxyAuthenticationHandler(AuthenticationHandler proxyAuthHandler2) {
        this.proxyAuthHandler = proxyAuthHandler2;
    }

    public final synchronized CookieStore getCookieStore() {
        if (this.cookieStore == null) {
            this.cookieStore = createCookieStore();
        }
        return this.cookieStore;
    }

    public synchronized void setCookieStore(CookieStore cookieStore2) {
        this.cookieStore = cookieStore2;
    }

    public final synchronized CredentialsProvider getCredentialsProvider() {
        if (this.credsProvider == null) {
            this.credsProvider = createCredentialsProvider();
        }
        return this.credsProvider;
    }

    public synchronized void setCredentialsProvider(CredentialsProvider credsProvider2) {
        this.credsProvider = credsProvider2;
    }

    public final synchronized HttpRoutePlanner getRoutePlanner() {
        if (this.routePlanner == null) {
            this.routePlanner = createHttpRoutePlanner();
        }
        return this.routePlanner;
    }

    public synchronized void setRoutePlanner(HttpRoutePlanner routePlanner2) {
        this.routePlanner = routePlanner2;
    }

    public final synchronized UserTokenHandler getUserTokenHandler() {
        if (this.userTokenHandler == null) {
            this.userTokenHandler = createUserTokenHandler();
        }
        return this.userTokenHandler;
    }

    public synchronized void setUserTokenHandler(UserTokenHandler userTokenHandler2) {
        this.userTokenHandler = userTokenHandler2;
    }

    /* access modifiers changed from: protected */
    public final synchronized BasicHttpProcessor getHttpProcessor() {
        if (this.mutableProcessor == null) {
            this.mutableProcessor = createHttpProcessor();
        }
        return this.mutableProcessor;
    }

    private final synchronized HttpProcessor getProtocolProcessor() {
        if (this.protocolProcessor == null) {
            BasicHttpProcessor proc = getHttpProcessor();
            int reqc = proc.getRequestInterceptorCount();
            HttpRequestInterceptor[] reqinterceptors = new HttpRequestInterceptor[reqc];
            for (int i = 0; i < reqc; i++) {
                reqinterceptors[i] = proc.getRequestInterceptor(i);
            }
            int resc = proc.getResponseInterceptorCount();
            HttpResponseInterceptor[] resinterceptors = new HttpResponseInterceptor[resc];
            for (int i2 = 0; i2 < resc; i2++) {
                resinterceptors[i2] = proc.getResponseInterceptor(i2);
            }
            this.protocolProcessor = new ImmutableHttpProcessor(reqinterceptors, resinterceptors);
        }
        return this.protocolProcessor;
    }

    public synchronized int getResponseInterceptorCount() {
        return getHttpProcessor().getResponseInterceptorCount();
    }

    public synchronized HttpResponseInterceptor getResponseInterceptor(int index) {
        return getHttpProcessor().getResponseInterceptor(index);
    }

    public synchronized HttpRequestInterceptor getRequestInterceptor(int index) {
        return getHttpProcessor().getRequestInterceptor(index);
    }

    public synchronized int getRequestInterceptorCount() {
        return getHttpProcessor().getRequestInterceptorCount();
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor itcp) {
        getHttpProcessor().addInterceptor(itcp);
        this.protocolProcessor = null;
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor itcp, int index) {
        getHttpProcessor().addInterceptor(itcp, index);
        this.protocolProcessor = null;
    }

    public synchronized void clearResponseInterceptors() {
        getHttpProcessor().clearResponseInterceptors();
        this.protocolProcessor = null;
    }

    public synchronized void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> clazz) {
        getHttpProcessor().removeResponseInterceptorByClass(clazz);
        this.protocolProcessor = null;
    }

    public synchronized void addRequestInterceptor(HttpRequestInterceptor itcp) {
        getHttpProcessor().addInterceptor(itcp);
        this.protocolProcessor = null;
    }

    public synchronized void addRequestInterceptor(HttpRequestInterceptor itcp, int index) {
        getHttpProcessor().addInterceptor(itcp, index);
        this.protocolProcessor = null;
    }

    public synchronized void clearRequestInterceptors() {
        getHttpProcessor().clearRequestInterceptors();
        this.protocolProcessor = null;
    }

    public synchronized void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> clazz) {
        getHttpProcessor().removeRequestInterceptorByClass(clazz);
        this.protocolProcessor = null;
    }

    public final HttpResponse execute(HttpUriRequest request) throws IOException, ClientProtocolException {
        return execute(request, (HttpContext) null);
    }

    public final HttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException, ClientProtocolException {
        if (request != null) {
            return execute(determineTarget(request), (HttpRequest) request, context);
        }
        throw new IllegalArgumentException("Request must not be null.");
    }

    private static HttpHost determineTarget(HttpUriRequest request) throws ClientProtocolException {
        HttpHost target = null;
        URI requestURI = request.getURI();
        if (!requestURI.isAbsolute() || (target = URIUtils.extractHost(requestURI)) != null) {
            return target;
        }
        throw new ClientProtocolException("URI does not specify a valid host name: " + requestURI);
    }

    public final HttpResponse execute(HttpHost target, HttpRequest request) throws IOException, ClientProtocolException {
        return execute(target, request, (HttpContext) null);
    }

    public final HttpResponse execute(HttpHost target, HttpRequest request, HttpContext context) throws IOException, ClientProtocolException {
        HttpContext execContext;
        HttpRequestExecutor requestExecutor;
        ClientConnectionManager connectionManager;
        ConnectionReuseStrategy connectionReuseStrategy;
        ConnectionKeepAliveStrategy connectionKeepAliveStrategy;
        HttpRoutePlanner routePlanner2;
        HttpProcessor protocolProcessor2;
        HttpRequestRetryHandler httpRequestRetryHandler;
        RedirectStrategy redirectStrategy2;
        AuthenticationHandler targetAuthenticationHandler;
        AuthenticationHandler proxyAuthenticationHandler;
        UserTokenHandler userTokenHandler2;
        HttpParams determineParams;
        HttpContext execContext2;
        HttpRequest httpRequest = request;
        HttpContext httpContext = context;
        if (httpRequest != null) {
            synchronized (this) {
                try {
                    HttpContext defaultContext = createHttpContext();
                    if (httpContext == null) {
                        execContext = defaultContext;
                    } else {
                        execContext = new DefaultedHttpContext(httpContext, defaultContext);
                    }
                    try {
                        requestExecutor = getRequestExecutor();
                        connectionManager = getConnectionManager();
                        connectionReuseStrategy = getConnectionReuseStrategy();
                        connectionKeepAliveStrategy = getConnectionKeepAliveStrategy();
                        routePlanner2 = getRoutePlanner();
                        protocolProcessor2 = getProtocolProcessor();
                        httpRequestRetryHandler = getHttpRequestRetryHandler();
                        redirectStrategy2 = getRedirectStrategy();
                        targetAuthenticationHandler = getTargetAuthenticationHandler();
                        proxyAuthenticationHandler = getProxyAuthenticationHandler();
                        userTokenHandler2 = getUserTokenHandler();
                        determineParams = determineParams(httpRequest);
                        execContext2 = execContext;
                    } catch (Throwable th) {
                        httpException = th;
                        HttpHost httpHost = target;
                        HttpRequest httpRequest2 = httpRequest;
                        HttpContext httpContext2 = execContext;
                        while (true) {
                            try {
                                break;
                            } catch (Throwable th2) {
                                httpException = th2;
                            }
                        }
                        throw httpException;
                    }
                    try {
                        RequestDirector director = createClientRequestDirector(requestExecutor, connectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, routePlanner2, protocolProcessor2, httpRequestRetryHandler, redirectStrategy2, targetAuthenticationHandler, proxyAuthenticationHandler, userTokenHandler2, determineParams);
                        try {
                            try {
                                return director.execute(target, request, execContext2);
                            } catch (HttpException e) {
                                throw new ClientProtocolException((Throwable) e);
                            }
                        } catch (Throwable th3) {
                            httpException = th3;
                            HttpHost httpHost2 = target;
                            HttpRequest httpRequest3 = request;
                            RequestDirector requestDirector = director;
                            HttpContext httpContext3 = execContext2;
                            while (true) {
                                break;
                            }
                            throw httpException;
                        }
                    } catch (Throwable th4) {
                        httpException = th4;
                        HttpHost httpHost3 = target;
                        HttpRequest httpRequest4 = request;
                        HttpContext httpContext4 = execContext2;
                        while (true) {
                            break;
                        }
                        throw httpException;
                    }
                } catch (Throwable th5) {
                    httpException = th5;
                    HttpHost httpHost4 = target;
                    HttpRequest httpRequest5 = httpRequest;
                    while (true) {
                        break;
                    }
                    throw httpException;
                }
            }
        } else {
            HttpHost httpHost5 = target;
            HttpRequest httpRequest6 = httpRequest;
            throw new IllegalArgumentException("Request must not be null.");
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public RequestDirector createClientRequestDirector(HttpRequestExecutor requestExec2, ClientConnectionManager conman, ConnectionReuseStrategy reustrat, ConnectionKeepAliveStrategy kastrat, HttpRoutePlanner rouplan, HttpProcessor httpProcessor, HttpRequestRetryHandler retryHandler2, RedirectHandler redirectHandler, AuthenticationHandler targetAuthHandler2, AuthenticationHandler proxyAuthHandler2, UserTokenHandler stateHandler, HttpParams params) {
        return new DefaultRequestDirector(requestExec2, conman, reustrat, kastrat, rouplan, httpProcessor, retryHandler2, redirectHandler, targetAuthHandler2, proxyAuthHandler2, stateHandler, params);
    }

    /* access modifiers changed from: protected */
    public RequestDirector createClientRequestDirector(HttpRequestExecutor requestExec2, ClientConnectionManager conman, ConnectionReuseStrategy reustrat, ConnectionKeepAliveStrategy kastrat, HttpRoutePlanner rouplan, HttpProcessor httpProcessor, HttpRequestRetryHandler retryHandler2, RedirectStrategy redirectStrategy2, AuthenticationHandler targetAuthHandler2, AuthenticationHandler proxyAuthHandler2, UserTokenHandler stateHandler, HttpParams params) {
        return new DefaultRequestDirector(this.log, requestExec2, conman, reustrat, kastrat, rouplan, httpProcessor, retryHandler2, redirectStrategy2, targetAuthHandler2, proxyAuthHandler2, stateHandler, params);
    }

    /* access modifiers changed from: protected */
    public HttpParams determineParams(HttpRequest req) {
        return new ClientParamsStack((HttpParams) null, getParams(), req.getParams(), (HttpParams) null);
    }

    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(request, responseHandler, (HttpContext) null);
    }

    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        return execute(determineTarget(request), request, responseHandler, context);
    }

    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(target, request, responseHandler, (HttpContext) null);
    }

    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        if (responseHandler != null) {
            HttpResponse response = execute(target, request, context);
            try {
                T result = responseHandler.handleResponse(response);
                EntityUtils.consume(response.getEntity());
                return result;
            } catch (Throwable th) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (Exception t2) {
                    this.log.warn("Error consuming content after an exception.", t2);
                }
                if (th instanceof Error) {
                    throw th;
                } else if (th instanceof RuntimeException) {
                    throw th;
                } else if (th instanceof IOException) {
                    throw th;
                } else {
                    throw new UndeclaredThrowableException(th);
                }
            }
        } else {
            throw new IllegalArgumentException("Response handler must not be null.");
        }
    }
}
