package org.apache.http.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.HttpParams;

@ThreadSafe
public class ThreadSafeClientConnManager implements ClientConnectionManager {
    protected final ClientConnectionOperator connOperator;
    protected final ConnPerRouteBean connPerRoute;
    @Deprecated
    protected final AbstractConnPool connectionPool;
    /* access modifiers changed from: private */
    public final Log log;
    protected final ConnPoolByRoute pool;
    protected final SchemeRegistry schemeRegistry;

    public ThreadSafeClientConnManager(SchemeRegistry schreg) {
        this(schreg, -1, TimeUnit.MILLISECONDS);
    }

    public ThreadSafeClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public ThreadSafeClientConnManager(SchemeRegistry schreg, long connTTL, TimeUnit connTTLTimeUnit) {
        if (schreg != null) {
            this.log = LogFactory.getLog(getClass());
            this.schemeRegistry = schreg;
            this.connPerRoute = new ConnPerRouteBean();
            this.connOperator = createConnectionOperator(schreg);
            ConnPoolByRoute createConnectionPool = createConnectionPool(connTTL, connTTLTimeUnit);
            this.pool = createConnectionPool;
            this.connectionPool = createConnectionPool;
            return;
        }
        throw new IllegalArgumentException("Scheme registry may not be null");
    }

    @Deprecated
    public ThreadSafeClientConnManager(HttpParams params, SchemeRegistry schreg) {
        if (schreg != null) {
            this.log = LogFactory.getLog(getClass());
            this.schemeRegistry = schreg;
            this.connPerRoute = new ConnPerRouteBean();
            this.connOperator = createConnectionOperator(schreg);
            ConnPoolByRoute connPoolByRoute = (ConnPoolByRoute) createConnectionPool(params);
            this.pool = connPoolByRoute;
            this.connectionPool = connPoolByRoute;
            return;
        }
        throw new IllegalArgumentException("Scheme registry may not be null");
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public AbstractConnPool createConnectionPool(HttpParams params) {
        return new ConnPoolByRoute(this.connOperator, params);
    }

    /* access modifiers changed from: protected */
    public ConnPoolByRoute createConnectionPool(long connTTL, TimeUnit connTTLTimeUnit) {
        return new ConnPoolByRoute(this.connOperator, this.connPerRoute, 20, connTTL, connTTLTimeUnit);
    }

    /* access modifiers changed from: protected */
    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schreg) {
        return new DefaultClientConnectionOperator(schreg);
    }

    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    public ClientConnectionRequest requestConnection(final HttpRoute route, Object state) {
        final PoolEntryRequest poolRequest = this.pool.requestPoolEntry(route, state);
        return new ClientConnectionRequest() {
            public void abortRequest() {
                poolRequest.abortRequest();
            }

            public ManagedClientConnection getConnection(long timeout, TimeUnit tunit) throws InterruptedException, ConnectionPoolTimeoutException {
                if (route != null) {
                    if (ThreadSafeClientConnManager.this.log.isDebugEnabled()) {
                        Log access$000 = ThreadSafeClientConnManager.this.log;
                        access$000.debug("Get connection: " + route + ", timeout = " + timeout);
                    }
                    return new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, poolRequest.getPoolEntry(timeout, tunit));
                }
                throw new IllegalArgumentException("Route may not be null.");
            }
        };
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0074=Splitter:B:35:0x0074, B:20:0x0036=Splitter:B:20:0x0036} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void releaseConnection(org.apache.http.conn.ManagedClientConnection r11, long r12, java.util.concurrent.TimeUnit r14) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof org.apache.http.impl.conn.tsccm.BasicPooledConnAdapter
            if (r0 == 0) goto L_0x00c9
            r0 = r11
            org.apache.http.impl.conn.tsccm.BasicPooledConnAdapter r0 = (org.apache.http.impl.conn.tsccm.BasicPooledConnAdapter) r0
            org.apache.http.impl.conn.AbstractPoolEntry r1 = r0.getPoolEntry()
            if (r1 == 0) goto L_0x001c
            org.apache.http.conn.ClientConnectionManager r1 = r0.getManager()
            if (r1 != r10) goto L_0x0014
            goto L_0x001c
        L_0x0014:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Connection not obtained from this manager."
            r1.<init>(r2)
            throw r1
        L_0x001c:
            monitor-enter(r0)
            org.apache.http.impl.conn.AbstractPoolEntry r1 = r0.getPoolEntry()     // Catch:{ all -> 0x00c6 }
            org.apache.http.impl.conn.tsccm.BasicPoolEntry r1 = (org.apache.http.impl.conn.tsccm.BasicPoolEntry) r1     // Catch:{ all -> 0x00c6 }
            if (r1 != 0) goto L_0x0027
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            return
        L_0x0027:
            boolean r2 = r0.isOpen()     // Catch:{ IOException -> 0x0064 }
            if (r2 == 0) goto L_0x0036
            boolean r2 = r0.isMarkedReusable()     // Catch:{ IOException -> 0x0064 }
            if (r2 != 0) goto L_0x0036
            r0.shutdown()     // Catch:{ IOException -> 0x0064 }
        L_0x0036:
            boolean r2 = r0.isMarkedReusable()     // Catch:{ all -> 0x00c6 }
            r8 = r2
            org.apache.commons.logging.Log r2 = r10.log     // Catch:{ all -> 0x00c6 }
            boolean r2 = r2.isDebugEnabled()     // Catch:{ all -> 0x00c6 }
            if (r2 == 0) goto L_0x0054
            if (r8 == 0) goto L_0x004d
            org.apache.commons.logging.Log r2 = r10.log     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = "Released connection is reusable."
            r2.debug(r3)     // Catch:{ all -> 0x00c6 }
            goto L_0x0054
        L_0x004d:
            org.apache.commons.logging.Log r2 = r10.log     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = "Released connection is not reusable."
            r2.debug(r3)     // Catch:{ all -> 0x00c6 }
        L_0x0054:
            r0.detach()     // Catch:{ all -> 0x00c6 }
            org.apache.http.impl.conn.tsccm.ConnPoolByRoute r2 = r10.pool     // Catch:{ all -> 0x00c6 }
        L_0x0059:
            r3 = r1
            r4 = r8
            r5 = r12
            r7 = r14
            r2.freeEntry(r3, r4, r5, r7)     // Catch:{ all -> 0x00c6 }
            goto L_0x0098
        L_0x0061:
            r2 = move-exception
            r8 = r2
            goto L_0x009a
        L_0x0064:
            r2 = move-exception
            org.apache.commons.logging.Log r3 = r10.log     // Catch:{ all -> 0x0061 }
            boolean r3 = r3.isDebugEnabled()     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x0074
            org.apache.commons.logging.Log r3 = r10.log     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = "Exception shutting down released connection."
            r3.debug(r4, r2)     // Catch:{ all -> 0x0061 }
        L_0x0074:
            boolean r2 = r0.isMarkedReusable()     // Catch:{ all -> 0x00c6 }
            r8 = r2
            org.apache.commons.logging.Log r2 = r10.log     // Catch:{ all -> 0x00c6 }
            boolean r2 = r2.isDebugEnabled()     // Catch:{ all -> 0x00c6 }
            if (r2 == 0) goto L_0x0092
            if (r8 == 0) goto L_0x008b
            org.apache.commons.logging.Log r2 = r10.log     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = "Released connection is reusable."
            r2.debug(r3)     // Catch:{ all -> 0x00c6 }
            goto L_0x0092
        L_0x008b:
            org.apache.commons.logging.Log r2 = r10.log     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = "Released connection is not reusable."
            r2.debug(r3)     // Catch:{ all -> 0x00c6 }
        L_0x0092:
            r0.detach()     // Catch:{ all -> 0x00c6 }
            org.apache.http.impl.conn.tsccm.ConnPoolByRoute r2 = r10.pool     // Catch:{ all -> 0x00c6 }
            goto L_0x0059
        L_0x0098:
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            return
        L_0x009a:
            boolean r2 = r0.isMarkedReusable()     // Catch:{ all -> 0x00c6 }
            r9 = r2
            org.apache.commons.logging.Log r2 = r10.log     // Catch:{ all -> 0x00c6 }
            boolean r2 = r2.isDebugEnabled()     // Catch:{ all -> 0x00c6 }
            if (r2 == 0) goto L_0x00b8
            if (r9 == 0) goto L_0x00b1
            org.apache.commons.logging.Log r2 = r10.log     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = "Released connection is reusable."
            r2.debug(r3)     // Catch:{ all -> 0x00c6 }
            goto L_0x00b8
        L_0x00b1:
            org.apache.commons.logging.Log r2 = r10.log     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = "Released connection is not reusable."
            r2.debug(r3)     // Catch:{ all -> 0x00c6 }
        L_0x00b8:
            r0.detach()     // Catch:{ all -> 0x00c6 }
            org.apache.http.impl.conn.tsccm.ConnPoolByRoute r2 = r10.pool     // Catch:{ all -> 0x00c6 }
            r3 = r1
            r4 = r9
            r5 = r12
            r7 = r14
            r2.freeEntry(r3, r4, r5, r7)     // Catch:{ all -> 0x00c6 }
            throw r8     // Catch:{ all -> 0x00c6 }
        L_0x00c6:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            throw r1
        L_0x00c9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Connection class mismatch, connection not obtained from this manager."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager.releaseConnection(org.apache.http.conn.ManagedClientConnection, long, java.util.concurrent.TimeUnit):void");
    }

    public void shutdown() {
        this.log.debug("Shutting down");
        this.pool.shutdown();
    }

    public int getConnectionsInPool(HttpRoute route) {
        return this.pool.getConnectionsInPool(route);
    }

    public int getConnectionsInPool() {
        return this.pool.getConnectionsInPool();
    }

    public void closeIdleConnections(long idleTimeout, TimeUnit tunit) {
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            log2.debug("Closing connections idle longer than " + idleTimeout + " " + tunit);
        }
        this.pool.closeIdleConnections(idleTimeout, tunit);
    }

    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpiredConnections();
    }

    public int getMaxTotal() {
        return this.pool.getMaxTotalConnections();
    }

    public void setMaxTotal(int max) {
        this.pool.setMaxTotalConnections(max);
    }

    public int getDefaultMaxPerRoute() {
        return this.connPerRoute.getDefaultMaxPerRoute();
    }

    public void setDefaultMaxPerRoute(int max) {
        this.connPerRoute.setDefaultMaxPerRoute(max);
    }

    public int getMaxForRoute(HttpRoute route) {
        return this.connPerRoute.getMaxForRoute(route);
    }

    public void setMaxForRoute(HttpRoute route, int max) {
        this.connPerRoute.setMaxForRoute(route, max);
    }
}
