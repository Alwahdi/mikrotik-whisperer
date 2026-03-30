package org.apache.http.impl.conn;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.protocol.HttpContext;

public abstract class AbstractClientConnAdapter implements ManagedClientConnection, HttpContext {
    private volatile ClientConnectionManager connManager;
    private volatile long duration = LocationRequestCompat.PASSIVE_INTERVAL;
    private volatile boolean markedReusable = false;
    private volatile boolean released = false;
    private volatile OperatedClientConnection wrappedConnection;

    protected AbstractClientConnAdapter(ClientConnectionManager mgr, OperatedClientConnection conn) {
        this.connManager = mgr;
        this.wrappedConnection = conn;
    }

    /* access modifiers changed from: protected */
    public synchronized void detach() {
        this.wrappedConnection = null;
        this.connManager = null;
        this.duration = LocationRequestCompat.PASSIVE_INTERVAL;
    }

    /* access modifiers changed from: protected */
    public OperatedClientConnection getWrappedConnection() {
        return this.wrappedConnection;
    }

    /* access modifiers changed from: protected */
    public ClientConnectionManager getManager() {
        return this.connManager;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public final void assertNotAborted() throws InterruptedIOException {
        if (isReleased()) {
            throw new InterruptedIOException("Connection has been shut down");
        }
    }

    /* access modifiers changed from: protected */
    public boolean isReleased() {
        return this.released;
    }

    /* access modifiers changed from: protected */
    public final void assertValid(OperatedClientConnection wrappedConn) throws ConnectionShutdownException {
        if (isReleased() || wrappedConn == null) {
            throw new ConnectionShutdownException();
        }
    }

    public boolean isOpen() {
        OperatedClientConnection conn = getWrappedConnection();
        if (conn == null) {
            return false;
        }
        return conn.isOpen();
    }

    public boolean isStale() {
        OperatedClientConnection conn;
        if (!isReleased() && (conn = getWrappedConnection()) != null) {
            return conn.isStale();
        }
        return true;
    }

    public void setSocketTimeout(int timeout) {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        conn.setSocketTimeout(timeout);
    }

    public int getSocketTimeout() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getSocketTimeout();
    }

    public HttpConnectionMetrics getMetrics() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getMetrics();
    }

    public void flush() throws IOException {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        conn.flush();
    }

    public boolean isResponseAvailable(int timeout) throws IOException {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.isResponseAvailable(timeout);
    }

    public void receiveResponseEntity(HttpResponse response) throws HttpException, IOException {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.receiveResponseEntity(response);
    }

    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        return conn.receiveResponseHeader();
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest request) throws HttpException, IOException {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.sendRequestEntity(request);
    }

    public void sendRequestHeader(HttpRequest request) throws HttpException, IOException {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        unmarkReusable();
        conn.sendRequestHeader(request);
    }

    public InetAddress getLocalAddress() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getLocalAddress();
    }

    public int getLocalPort() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getLocalPort();
    }

    public InetAddress getRemoteAddress() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getRemoteAddress();
    }

    public int getRemotePort() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getRemotePort();
    }

    public boolean isSecure() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.isSecure();
    }

    public SSLSession getSSLSession() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        if (!isOpen()) {
            return null;
        }
        Socket sock = conn.getSocket();
        if (sock instanceof SSLSocket) {
            return ((SSLSocket) sock).getSession();
        }
        return null;
    }

    public void markReusable() {
        this.markedReusable = true;
    }

    public void unmarkReusable() {
        this.markedReusable = false;
    }

    public boolean isMarkedReusable() {
        return this.markedReusable;
    }

    public void setIdleDuration(long duration2, TimeUnit unit) {
        if (duration2 > 0) {
            this.duration = unit.toMillis(duration2);
        } else {
            this.duration = -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void releaseConnection() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.released     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            r0 = 1
            r4.released = r0     // Catch:{ all -> 0x0019 }
            org.apache.http.conn.ClientConnectionManager r0 = r4.connManager     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0017
            org.apache.http.conn.ClientConnectionManager r0 = r4.connManager     // Catch:{ all -> 0x0019 }
            long r1 = r4.duration     // Catch:{ all -> 0x0019 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0019 }
            r0.releaseConnection(r4, r1, r3)     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r4)
            return
        L_0x0019:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.AbstractClientConnAdapter.releaseConnection():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void abortConnection() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.released     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            r0 = 1
            r4.released = r0     // Catch:{ all -> 0x0021 }
            r4.unmarkReusable()     // Catch:{ all -> 0x0021 }
            r4.shutdown()     // Catch:{ IOException -> 0x0011 }
            goto L_0x0012
        L_0x0011:
            r0 = move-exception
        L_0x0012:
            org.apache.http.conn.ClientConnectionManager r0 = r4.connManager     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x001f
            org.apache.http.conn.ClientConnectionManager r0 = r4.connManager     // Catch:{ all -> 0x0021 }
            long r1 = r4.duration     // Catch:{ all -> 0x0021 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0021 }
            r0.releaseConnection(r4, r1, r3)     // Catch:{ all -> 0x0021 }
        L_0x001f:
            monitor-exit(r4)
            return
        L_0x0021:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.AbstractClientConnAdapter.abortConnection():void");
    }

    public synchronized Object getAttribute(String id) {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        if (!(conn instanceof HttpContext)) {
            return null;
        }
        return ((HttpContext) conn).getAttribute(id);
    }

    public synchronized Object removeAttribute(String id) {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        if (!(conn instanceof HttpContext)) {
            return null;
        }
        return ((HttpContext) conn).removeAttribute(id);
    }

    public synchronized void setAttribute(String id, Object obj) {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        if (conn instanceof HttpContext) {
            ((HttpContext) conn).setAttribute(id, obj);
        }
    }
}
