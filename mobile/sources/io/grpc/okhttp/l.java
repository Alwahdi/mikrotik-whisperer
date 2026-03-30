package io.grpc.okhttp;

import io.grpc.okhttp.internal.b;
import io.grpc.okhttp.internal.d;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

abstract class l {
    static final List<d> a = Collections.unmodifiableList(Arrays.asList(new d[]{d.HTTP_2}));

    public static SSLSocket b(SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String host, int port, b spec) {
        v90.o(sslSocketFactory, "sslSocketFactory");
        v90.o(socket, "socket");
        v90.o(spec, "spec");
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(socket, host, port, true);
        spec.c(sslSocket, false);
        String negotiatedProtocol = i.e().h(sslSocket, host, spec.f() ? a : null);
        List<d> list = a;
        boolean contains = list.contains(d.get(negotiatedProtocol));
        v90.w(contains, "Only " + list + " are supported, but negotiated protocol is %s", negotiatedProtocol);
        if (hostnameVerifier == null) {
            hostnameVerifier = j40.a;
        }
        if (hostnameVerifier.verify(a(host), sslSocket.getSession())) {
            return sslSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + host);
    }

    static String a(String host) {
        if (!host.startsWith("[") || !host.endsWith("]")) {
            return host;
        }
        return host.substring(1, host.length() - 1);
    }
}
