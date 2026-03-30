package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;

@ThreadSafe
public class SingleClientConnManager implements ClientConnectionManager {
    public static final String MISUSE_MESSAGE = "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    protected final boolean alwaysShutDown;
    protected final ClientConnectionOperator connOperator;
    @GuardedBy("this")
    protected long connectionExpiresTime;
    protected volatile boolean isShutDown;
    @GuardedBy("this")
    protected long lastReleaseTime;
    private final Log log;
    @GuardedBy("this")
    protected ConnAdapter managedConn;
    protected final SchemeRegistry schemeRegistry;
    @GuardedBy("this")
    protected PoolEntry uniquePoolEntry;

    @Deprecated
    public SingleClientConnManager(HttpParams params, SchemeRegistry schreg) {
        this(schreg);
    }

    public SingleClientConnManager(SchemeRegistry schreg) {
        this.log = LogFactory.getLog(getClass());
        if (schreg != null) {
            this.schemeRegistry = schreg;
            this.connOperator = createConnectionOperator(schreg);
            this.uniquePoolEntry = new PoolEntry();
            this.managedConn = null;
            this.lastReleaseTime = -1;
            this.alwaysShutDown = false;
            this.isShutDown = false;
            return;
        }
        throw new IllegalArgumentException("Scheme registry must not be null.");
    }

    public SingleClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    /* access modifiers changed from: protected */
    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schreg) {
        return new DefaultClientConnectionOperator(schreg);
    }

    /* access modifiers changed from: protected */
    public final void assertStillUp() throws IllegalStateException {
        if (this.isShutDown) {
            throw new IllegalStateException("Manager is shut down.");
        }
    }

    public final ClientConnectionRequest requestConnection(final HttpRoute route, final Object state) {
        return new ClientConnectionRequest() {
            public void abortRequest() {
            }

            public ManagedClientConnection getConnection(long timeout, TimeUnit tunit) {
                return SingleClientConnManager.this.getConnection(route, state);
            }
        };
    }

    public synchronized ManagedClientConnection getConnection(HttpRoute route, Object state) {
        ConnAdapter connAdapter;
        if (route != null) {
            try {
                assertStillUp();
                if (this.log.isDebugEnabled()) {
                    Log log2 = this.log;
                    log2.debug("Get connection for route " + route);
                }
                if (this.managedConn == null) {
                    boolean recreate = false;
                    boolean shutdown = false;
                    closeExpiredConnections();
                    if (this.uniquePoolEntry.connection.isOpen()) {
                        RouteTracker tracker = this.uniquePoolEntry.tracker;
                        shutdown = tracker == null || !tracker.toRoute().equals(route);
                    } else {
                        recreate = true;
                    }
                    if (shutdown) {
                        recreate = true;
                        this.uniquePoolEntry.shutdown();
                    }
                    if (recreate) {
                        this.uniquePoolEntry = new PoolEntry();
                    }
                    connAdapter = new ConnAdapter(this.uniquePoolEntry, route);
                    this.managedConn = connAdapter;
                } else {
                    throw new IllegalStateException(MISUSE_MESSAGE);
                }
            } catch (IOException iox) {
                this.log.debug("Problem shutting down connection.", iox);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Route may not be null.");
        }
        return connAdapter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00af, code lost:
        return;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:42:0x0098=Splitter:B:42:0x0098, B:30:0x006a=Splitter:B:30:0x006a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void releaseConnection(org.apache.http.conn.ManagedClientConnection r11, long r12, java.util.concurrent.TimeUnit r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            r10.assertStillUp()     // Catch:{ all -> 0x00d4 }
            boolean r0 = r11 instanceof org.apache.http.impl.conn.SingleClientConnManager.ConnAdapter     // Catch:{ all -> 0x00d4 }
            if (r0 == 0) goto L_0x00cc
            org.apache.commons.logging.Log r0 = r10.log     // Catch:{ all -> 0x00d4 }
            boolean r0 = r0.isDebugEnabled()     // Catch:{ all -> 0x00d4 }
            if (r0 == 0) goto L_0x0026
            org.apache.commons.logging.Log r0 = r10.log     // Catch:{ all -> 0x00d4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
            r1.<init>()     // Catch:{ all -> 0x00d4 }
            java.lang.String r2 = "Releasing connection "
            r1.append(r2)     // Catch:{ all -> 0x00d4 }
            r1.append(r11)     // Catch:{ all -> 0x00d4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d4 }
            r0.debug(r1)     // Catch:{ all -> 0x00d4 }
        L_0x0026:
            r0 = r11
            org.apache.http.impl.conn.SingleClientConnManager$ConnAdapter r0 = (org.apache.http.impl.conn.SingleClientConnManager.ConnAdapter) r0     // Catch:{ all -> 0x00d4 }
            org.apache.http.impl.conn.AbstractPoolEntry r1 = r0.poolEntry     // Catch:{ all -> 0x00d4 }
            if (r1 != 0) goto L_0x002f
            monitor-exit(r10)
            return
        L_0x002f:
            org.apache.http.conn.ClientConnectionManager r1 = r0.getManager()     // Catch:{ all -> 0x00d4 }
            if (r1 == 0) goto L_0x0040
            if (r1 != r10) goto L_0x0038
            goto L_0x0040
        L_0x0038:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00d4 }
            java.lang.String r3 = "Connection not obtained from this manager."
            r2.<init>(r3)     // Catch:{ all -> 0x00d4 }
            throw r2     // Catch:{ all -> 0x00d4 }
        L_0x0040:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4 = 0
            r6 = 0
            boolean r7 = r0.isOpen()     // Catch:{ IOException -> 0x0088 }
            if (r7 == 0) goto L_0x006a
            boolean r7 = r10.alwaysShutDown     // Catch:{ IOException -> 0x0088 }
            if (r7 != 0) goto L_0x0058
            boolean r7 = r0.isMarkedReusable()     // Catch:{ IOException -> 0x0088 }
            if (r7 != 0) goto L_0x006a
        L_0x0058:
            org.apache.commons.logging.Log r7 = r10.log     // Catch:{ IOException -> 0x0088 }
            boolean r7 = r7.isDebugEnabled()     // Catch:{ IOException -> 0x0088 }
            if (r7 == 0) goto L_0x0067
            org.apache.commons.logging.Log r7 = r10.log     // Catch:{ IOException -> 0x0088 }
            java.lang.String r8 = "Released connection open but not reusable."
            r7.debug(r8)     // Catch:{ IOException -> 0x0088 }
        L_0x0067:
            r0.shutdown()     // Catch:{ IOException -> 0x0088 }
        L_0x006a:
            r0.detach()     // Catch:{ all -> 0x00d4 }
            r10.managedConn = r6     // Catch:{ all -> 0x00d4 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d4 }
            r10.lastReleaseTime = r6     // Catch:{ all -> 0x00d4 }
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0083
            long r2 = r14.toMillis(r12)     // Catch:{ all -> 0x00d4 }
            long r4 = r10.lastReleaseTime     // Catch:{ all -> 0x00d4 }
        L_0x007f:
            long r2 = r2 + r4
            r10.connectionExpiresTime = r2     // Catch:{ all -> 0x00d4 }
            goto L_0x00ae
        L_0x0083:
            r10.connectionExpiresTime = r2     // Catch:{ all -> 0x00d4 }
            goto L_0x00ae
        L_0x0086:
            r7 = move-exception
            goto L_0x00b0
        L_0x0088:
            r7 = move-exception
            org.apache.commons.logging.Log r8 = r10.log     // Catch:{ all -> 0x0086 }
            boolean r8 = r8.isDebugEnabled()     // Catch:{ all -> 0x0086 }
            if (r8 == 0) goto L_0x0098
            org.apache.commons.logging.Log r8 = r10.log     // Catch:{ all -> 0x0086 }
            java.lang.String r9 = "Exception shutting down released connection."
            r8.debug(r9, r7)     // Catch:{ all -> 0x0086 }
        L_0x0098:
            r0.detach()     // Catch:{ all -> 0x00d4 }
            r10.managedConn = r6     // Catch:{ all -> 0x00d4 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d4 }
            r10.lastReleaseTime = r6     // Catch:{ all -> 0x00d4 }
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0083
            long r2 = r14.toMillis(r12)     // Catch:{ all -> 0x00d4 }
            long r4 = r10.lastReleaseTime     // Catch:{ all -> 0x00d4 }
            goto L_0x007f
        L_0x00ae:
            monitor-exit(r10)
            return
        L_0x00b0:
            r0.detach()     // Catch:{ all -> 0x00d4 }
            r10.managedConn = r6     // Catch:{ all -> 0x00d4 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d4 }
            r10.lastReleaseTime = r8     // Catch:{ all -> 0x00d4 }
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c9
            long r2 = r14.toMillis(r12)     // Catch:{ all -> 0x00d4 }
            long r4 = r10.lastReleaseTime     // Catch:{ all -> 0x00d4 }
            long r2 = r2 + r4
            r10.connectionExpiresTime = r2     // Catch:{ all -> 0x00d4 }
            goto L_0x00cb
        L_0x00c9:
            r10.connectionExpiresTime = r2     // Catch:{ all -> 0x00d4 }
        L_0x00cb:
            throw r7     // Catch:{ all -> 0x00d4 }
        L_0x00cc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00d4 }
            java.lang.String r1 = "Connection class mismatch, connection not obtained from this manager."
            r0.<init>(r1)     // Catch:{ all -> 0x00d4 }
            throw r0     // Catch:{ all -> 0x00d4 }
        L_0x00d4:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.SingleClientConnManager.releaseConnection(org.apache.http.conn.ManagedClientConnection, long, java.util.concurrent.TimeUnit):void");
    }

    public synchronized void closeExpiredConnections() {
        if (System.currentTimeMillis() >= this.connectionExpiresTime) {
            closeIdleConnections(0, TimeUnit.MILLISECONDS);
        }
    }

    public synchronized void closeIdleConnections(long idletime, TimeUnit tunit) {
        assertStillUp();
        if (tunit == null) {
            throw new IllegalArgumentException("Time unit must not be null.");
        } else if (this.managedConn == null && this.uniquePoolEntry.connection.isOpen()) {
            if (this.lastReleaseTime <= System.currentTimeMillis() - tunit.toMillis(idletime)) {
                try {
                    this.uniquePoolEntry.close();
                } catch (IOException iox) {
                    this.log.debug("Problem closing idle connection.", iox);
                }
            }
        }
        return;
    }

    public synchronized void shutdown() {
        this.isShutDown = true;
        ConnAdapter connAdapter = this.managedConn;
        if (connAdapter != null) {
            connAdapter.detach();
        }
        try {
            PoolEntry poolEntry = this.uniquePoolEntry;
            if (poolEntry != null) {
                poolEntry.shutdown();
            }
            this.uniquePoolEntry = null;
        } catch (IOException iox) {
            try {
                this.log.debug("Problem while shutting down manager.", iox);
            } finally {
                this.uniquePoolEntry = null;
            }
        }
        return;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public synchronized void revokeConnection() {
        ConnAdapter connAdapter = this.managedConn;
        if (connAdapter != null) {
            connAdapter.detach();
            try {
                this.uniquePoolEntry.shutdown();
            } catch (IOException iox) {
                this.log.debug("Problem while shutting down connection.", iox);
            }
        } else {
            return;
        }
        return;
    }

    protected class PoolEntry extends AbstractPoolEntry {
        protected PoolEntry() {
            super(SingleClientConnManager.this.connOperator, (HttpRoute) null);
        }

        /* access modifiers changed from: protected */
        public void close() throws IOException {
            shutdownEntry();
            if (this.connection.isOpen()) {
                this.connection.close();
            }
        }

        /* access modifiers changed from: protected */
        public void shutdown() throws IOException {
            shutdownEntry();
            if (this.connection.isOpen()) {
                this.connection.shutdown();
            }
        }
    }

    protected class ConnAdapter extends AbstractPooledConnAdapter {
        protected ConnAdapter(PoolEntry entry, HttpRoute route) {
            super(SingleClientConnManager.this, entry);
            markReusable();
            entry.route = route;
        }
    }
}
