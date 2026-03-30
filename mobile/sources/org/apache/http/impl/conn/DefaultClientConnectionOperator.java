package org.apache.http.impl.conn;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.LayeredSchemeSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@ThreadSafe
public class DefaultClientConnectionOperator implements ClientConnectionOperator {
    private final Log log = LogFactory.getLog(getClass());
    protected final SchemeRegistry schemeRegistry;

    public DefaultClientConnectionOperator(SchemeRegistry schemes) {
        if (schemes != null) {
            this.schemeRegistry = schemes;
            return;
        }
        throw new IllegalArgumentException("Scheme registry amy not be null");
    }

    public OperatedClientConnection createConnection() {
        return new DefaultClientConnection();
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openConnection(org.apache.http.conn.OperatedClientConnection r18, org.apache.http.HttpHost r19, java.net.InetAddress r20, org.apache.http.protocol.HttpContext r21, org.apache.http.params.HttpParams r22) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r22
            if (r2 == 0) goto L_0x0102
            if (r3 == 0) goto L_0x00f8
            if (r5 == 0) goto L_0x00ee
            boolean r0 = r18.isOpen()
            if (r0 != 0) goto L_0x00e4
            org.apache.http.conn.scheme.SchemeRegistry r0 = r1.schemeRegistry
            java.lang.String r6 = r19.getSchemeName()
            org.apache.http.conn.scheme.Scheme r6 = r0.getScheme((java.lang.String) r6)
            org.apache.http.conn.scheme.SchemeSocketFactory r7 = r6.getSchemeSocketFactory()
            java.lang.String r0 = r19.getHostName()
            java.net.InetAddress[] r8 = r1.resolveHostname(r0)
            int r0 = r19.getPort()
            int r9 = r6.resolvePort(r0)
            r0 = 0
            r10 = r0
        L_0x0036:
            int r0 = r8.length
            if (r10 >= r0) goto L_0x00e3
            r11 = r8[r10]
            int r0 = r8.length
            r12 = 1
            int r0 = r0 - r12
            r13 = 0
            if (r10 != r0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r12 = 0
        L_0x0043:
            java.net.Socket r14 = r7.createSocket(r5)
            r2.opening(r14, r3)
            org.apache.http.impl.conn.HttpInetSocketAddress r0 = new org.apache.http.impl.conn.HttpInetSocketAddress
            r0.<init>(r3, r11, r9)
            r15 = r0
            r0 = 0
            if (r4 == 0) goto L_0x005c
            r16 = r0
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress
            r0.<init>(r4, r13)
            r13 = r0
            goto L_0x0060
        L_0x005c:
            r16 = r0
            r13 = r16
        L_0x0060:
            org.apache.commons.logging.Log r0 = r1.log
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x0081
            org.apache.commons.logging.Log r0 = r1.log
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r16 = r6
            java.lang.String r6 = "Connecting to "
            r4.append(r6)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            r0.debug(r4)
            goto L_0x0083
        L_0x0081:
            r16 = r6
        L_0x0083:
            java.net.Socket r0 = r7.connectSocket(r14, r15, r13, r5)     // Catch:{ ConnectException -> 0x00a5, ConnectTimeoutException -> 0x009e }
            if (r14 == r0) goto L_0x008d
            r14 = r0
            r2.opening(r14, r3)     // Catch:{ ConnectException -> 0x00a5, ConnectTimeoutException -> 0x009e }
        L_0x008d:
            r4 = r21
            r1.prepareSocket(r14, r4, r5)     // Catch:{ ConnectException -> 0x009c, ConnectTimeoutException -> 0x009a }
            boolean r6 = r7.isSecure(r14)     // Catch:{ ConnectException -> 0x009c, ConnectTimeoutException -> 0x009a }
            r2.openCompleted(r6, r5)     // Catch:{ ConnectException -> 0x009c, ConnectTimeoutException -> 0x009a }
            return
        L_0x009a:
            r0 = move-exception
            goto L_0x00a1
        L_0x009c:
            r0 = move-exception
            goto L_0x00a8
        L_0x009e:
            r0 = move-exception
            r4 = r21
        L_0x00a1:
            if (r12 != 0) goto L_0x00a4
            goto L_0x00ab
        L_0x00a4:
            throw r0
        L_0x00a5:
            r0 = move-exception
            r4 = r21
        L_0x00a8:
            if (r12 != 0) goto L_0x00dd
        L_0x00ab:
            org.apache.commons.logging.Log r0 = r1.log
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x00d3
            org.apache.commons.logging.Log r0 = r1.log
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "Connect to "
            r6.append(r1)
            r6.append(r15)
            java.lang.String r1 = " timed out. "
            r6.append(r1)
            java.lang.String r1 = "Connection will be retried using another IP address"
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r0.debug(r1)
        L_0x00d3:
            int r10 = r10 + 1
            r1 = r17
            r4 = r20
            r6 = r16
            goto L_0x0036
        L_0x00dd:
            org.apache.http.conn.HttpHostConnectException r1 = new org.apache.http.conn.HttpHostConnectException
            r1.<init>(r3, r0)
            throw r1
        L_0x00e3:
            return
        L_0x00e4:
            r4 = r21
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Connection must not be open"
            r0.<init>(r1)
            throw r0
        L_0x00ee:
            r4 = r21
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Parameters may not be null"
            r0.<init>(r1)
            throw r0
        L_0x00f8:
            r4 = r21
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Target host may not be null"
            r0.<init>(r1)
            throw r0
        L_0x0102:
            r4 = r21
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Connection may not be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.DefaultClientConnectionOperator.openConnection(org.apache.http.conn.OperatedClientConnection, org.apache.http.HttpHost, java.net.InetAddress, org.apache.http.protocol.HttpContext, org.apache.http.params.HttpParams):void");
    }

    public void updateSecureConnection(OperatedClientConnection conn, HttpHost target, HttpContext context, HttpParams params) throws IOException {
        if (conn == null) {
            throw new IllegalArgumentException("Connection may not be null");
        } else if (target == null) {
            throw new IllegalArgumentException("Target host may not be null");
        } else if (params == null) {
            throw new IllegalArgumentException("Parameters may not be null");
        } else if (conn.isOpen()) {
            Scheme schm = this.schemeRegistry.getScheme(target.getSchemeName());
            if (schm.getSchemeSocketFactory() instanceof LayeredSchemeSocketFactory) {
                LayeredSchemeSocketFactory lsf = (LayeredSchemeSocketFactory) schm.getSchemeSocketFactory();
                try {
                    Socket sock = lsf.createLayeredSocket(conn.getSocket(), target.getHostName(), target.getPort(), true);
                    prepareSocket(sock, context, params);
                    conn.update(sock, target, lsf.isSecure(sock), params);
                } catch (ConnectException ex) {
                    throw new HttpHostConnectException(target, ex);
                }
            } else {
                throw new IllegalArgumentException("Target scheme (" + schm.getName() + ") must have layered socket factory.");
            }
        } else {
            throw new IllegalStateException("Connection must be open");
        }
    }

    /* access modifiers changed from: protected */
    public void prepareSocket(Socket sock, HttpContext context, HttpParams params) throws IOException {
        sock.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(params));
        sock.setSoTimeout(HttpConnectionParams.getSoTimeout(params));
        int linger = HttpConnectionParams.getLinger(params);
        if (linger >= 0) {
            sock.setSoLinger(linger > 0, linger);
        }
    }

    /* access modifiers changed from: protected */
    public InetAddress[] resolveHostname(String host) throws UnknownHostException {
        return InetAddress.getAllByName(host);
    }
}
