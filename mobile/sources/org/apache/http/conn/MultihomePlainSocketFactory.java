package org.apache.http.conn;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

@Immutable
@Deprecated
public final class MultihomePlainSocketFactory implements SocketFactory {
    private static final MultihomePlainSocketFactory DEFAULT_FACTORY = new MultihomePlainSocketFactory();

    public static MultihomePlainSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    private MultihomePlainSocketFactory() {
    }

    public Socket createSocket() {
        return new Socket();
    }

    public Socket connectSocket(Socket sock, String host, int port, InetAddress localAddress, int localPort, HttpParams params) throws IOException {
        Socket sock2;
        int localPort2;
        InetAddress inetAddress = localAddress;
        if (host == null) {
            int i = port;
            throw new IllegalArgumentException("Target host may not be null.");
        } else if (params != null) {
            if (sock == null) {
                sock2 = createSocket();
            } else {
                sock2 = sock;
            }
            if (inetAddress != null || localPort > 0) {
                if (localPort < 0) {
                    localPort2 = 0;
                } else {
                    localPort2 = localPort;
                }
                sock2.bind(new InetSocketAddress(inetAddress, localPort2));
            } else {
                int i2 = localPort;
            }
            int timeout = HttpConnectionParams.getConnectionTimeout(params);
            InetAddress[] inetadrs = InetAddress.getAllByName(host);
            List<InetAddress> addresses = new ArrayList<>(inetadrs.length);
            addresses.addAll(Arrays.asList(inetadrs));
            Collections.shuffle(addresses);
            Iterator i$ = addresses.iterator();
            IOException lastEx = null;
            Socket sock3 = sock2;
            while (true) {
                if (!i$.hasNext()) {
                    int i3 = port;
                    break;
                }
                InetAddress remoteAddress = i$.next();
                try {
                    try {
                        sock3.connect(new InetSocketAddress(remoteAddress, port), timeout);
                        break;
                    } catch (SocketTimeoutException e) {
                    } catch (IOException e2) {
                        ex = e2;
                    }
                } catch (SocketTimeoutException e3) {
                    int i4 = port;
                    throw new ConnectTimeoutException("Connect to " + remoteAddress + " timed out");
                } catch (IOException e4) {
                    ex = e4;
                    int i5 = port;
                }
                sock3 = new Socket();
                lastEx = ex;
            }
            if (lastEx == null) {
                return sock3;
            }
            throw lastEx;
        } else {
            int i6 = port;
            throw new IllegalArgumentException("Parameters may not be null.");
        }
    }

    public final boolean isSecure(Socket sock) throws IllegalArgumentException {
        if (sock == null) {
            throw new IllegalArgumentException("Socket may not be null.");
        } else if (sock.getClass() != Socket.class) {
            throw new IllegalArgumentException("Socket not created by this factory.");
        } else if (!sock.isClosed()) {
            return false;
        } else {
            throw new IllegalArgumentException("Socket is closed.");
        }
    }
}
