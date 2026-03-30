package org.apache.http.conn.scheme;

import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.LangUtils;

@Immutable
public final class Scheme {
    private final int defaultPort;
    private final boolean layered;
    private final String name;
    private final SchemeSocketFactory socketFactory;
    private String stringRep;

    public Scheme(String name2, int port, SchemeSocketFactory factory) {
        if (name2 == null) {
            throw new IllegalArgumentException("Scheme name may not be null");
        } else if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Port is invalid: " + port);
        } else if (factory != null) {
            this.name = name2.toLowerCase(Locale.ENGLISH);
            this.socketFactory = factory;
            this.defaultPort = port;
            this.layered = factory instanceof LayeredSchemeSocketFactory;
        } else {
            throw new IllegalArgumentException("Socket factory may not be null");
        }
    }

    @Deprecated
    public Scheme(String name2, SocketFactory factory, int port) {
        if (name2 == null) {
            throw new IllegalArgumentException("Scheme name may not be null");
        } else if (factory == null) {
            throw new IllegalArgumentException("Socket factory may not be null");
        } else if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Port is invalid: " + port);
        } else {
            this.name = name2.toLowerCase(Locale.ENGLISH);
            if (factory instanceof LayeredSocketFactory) {
                this.socketFactory = new LayeredSchemeSocketFactoryAdaptor((LayeredSocketFactory) factory);
                this.layered = true;
            } else {
                this.socketFactory = new SchemeSocketFactoryAdaptor(factory);
                this.layered = false;
            }
            this.defaultPort = port;
        }
    }

    public final int getDefaultPort() {
        return this.defaultPort;
    }

    @Deprecated
    public final SocketFactory getSocketFactory() {
        SchemeSocketFactory schemeSocketFactory = this.socketFactory;
        if (schemeSocketFactory instanceof SchemeSocketFactoryAdaptor) {
            return ((SchemeSocketFactoryAdaptor) schemeSocketFactory).getFactory();
        }
        if (this.layered) {
            return new LayeredSocketFactoryAdaptor((LayeredSchemeSocketFactory) schemeSocketFactory);
        }
        return new SocketFactoryAdaptor(schemeSocketFactory);
    }

    public final SchemeSocketFactory getSchemeSocketFactory() {
        return this.socketFactory;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isLayered() {
        return this.layered;
    }

    public final int resolvePort(int port) {
        return port <= 0 ? this.defaultPort : port;
    }

    public final String toString() {
        if (this.stringRep == null) {
            this.stringRep = this.name + ':' + Integer.toString(this.defaultPort);
        }
        return this.stringRep;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scheme)) {
            return false;
        }
        Scheme that = (Scheme) obj;
        if (this.name.equals(that.name) && this.defaultPort == that.defaultPort && this.layered == that.layered) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.defaultPort), (Object) this.name), this.layered);
    }
}
