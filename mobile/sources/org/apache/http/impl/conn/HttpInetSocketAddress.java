package org.apache.http.impl.conn;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.apache.http.HttpHost;

class HttpInetSocketAddress extends InetSocketAddress {
    private static final long serialVersionUID = -6650701828361907957L;
    private final HttpHost host;

    public HttpInetSocketAddress(HttpHost host2, InetAddress addr, int port) {
        super(addr, port);
        if (host2 != null) {
            this.host = host2;
            return;
        }
        throw new IllegalArgumentException("HTTP host may not be null");
    }

    public HttpHost getHost() {
        return this.host;
    }

    public String toString() {
        return this.host.getHostName() + ":" + getPort();
    }
}
