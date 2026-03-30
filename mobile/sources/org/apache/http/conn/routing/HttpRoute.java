package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.util.LangUtils;

@Immutable
public final class HttpRoute implements RouteInfo, Cloneable {
    private static final HttpHost[] EMPTY_HTTP_HOST_ARRAY = new HttpHost[0];
    private final RouteInfo.LayerType layered;
    private final InetAddress localAddress;
    private final HttpHost[] proxyChain;
    private final boolean secure;
    private final HttpHost targetHost;
    private final RouteInfo.TunnelType tunnelled;

    private HttpRoute(InetAddress local, HttpHost target, HttpHost[] proxies, boolean secure2, RouteInfo.TunnelType tunnelled2, RouteInfo.LayerType layered2) {
        if (target == null) {
            throw new IllegalArgumentException("Target host may not be null.");
        } else if (proxies == null) {
            throw new IllegalArgumentException("Proxies may not be null.");
        } else if (tunnelled2 == RouteInfo.TunnelType.TUNNELLED && proxies.length == 0) {
            throw new IllegalArgumentException("Proxy required if tunnelled.");
        } else {
            tunnelled2 = tunnelled2 == null ? RouteInfo.TunnelType.PLAIN : tunnelled2;
            layered2 = layered2 == null ? RouteInfo.LayerType.PLAIN : layered2;
            this.targetHost = target;
            this.localAddress = local;
            this.proxyChain = proxies;
            this.secure = secure2;
            this.tunnelled = tunnelled2;
            this.layered = layered2;
        }
    }

    public HttpRoute(HttpHost target, InetAddress local, HttpHost[] proxies, boolean secure2, RouteInfo.TunnelType tunnelled2, RouteInfo.LayerType layered2) {
        this(local, target, toChain(proxies), secure2, tunnelled2, layered2);
    }

    public HttpRoute(HttpHost target, InetAddress local, HttpHost proxy, boolean secure2, RouteInfo.TunnelType tunnelled2, RouteInfo.LayerType layered2) {
        this(local, target, toChain(proxy), secure2, tunnelled2, layered2);
    }

    public HttpRoute(HttpHost target, InetAddress local, boolean secure2) {
        this(local, target, EMPTY_HTTP_HOST_ARRAY, secure2, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
    }

    public HttpRoute(HttpHost target) {
        this((InetAddress) null, target, EMPTY_HTTP_HOST_ARRAY, false, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRoute(org.apache.http.HttpHost r8, java.net.InetAddress r9, org.apache.http.HttpHost r10, boolean r11) {
        /*
            r7 = this;
            org.apache.http.HttpHost[] r3 = toChain((org.apache.http.HttpHost) r10)
            if (r11 == 0) goto L_0x0009
            org.apache.http.conn.routing.RouteInfo$TunnelType r0 = org.apache.http.conn.routing.RouteInfo.TunnelType.TUNNELLED
            goto L_0x000b
        L_0x0009:
            org.apache.http.conn.routing.RouteInfo$TunnelType r0 = org.apache.http.conn.routing.RouteInfo.TunnelType.PLAIN
        L_0x000b:
            r5 = r0
            if (r11 == 0) goto L_0x0011
            org.apache.http.conn.routing.RouteInfo$LayerType r0 = org.apache.http.conn.routing.RouteInfo.LayerType.LAYERED
            goto L_0x0013
        L_0x0011:
            org.apache.http.conn.routing.RouteInfo$LayerType r0 = org.apache.http.conn.routing.RouteInfo.LayerType.PLAIN
        L_0x0013:
            r6 = r0
            r0 = r7
            r1 = r9
            r2 = r8
            r4 = r11
            r0.<init>((java.net.InetAddress) r1, (org.apache.http.HttpHost) r2, (org.apache.http.HttpHost[]) r3, (boolean) r4, (org.apache.http.conn.routing.RouteInfo.TunnelType) r5, (org.apache.http.conn.routing.RouteInfo.LayerType) r6)
            if (r10 == 0) goto L_0x001e
            return
        L_0x001e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Proxy host may not be null."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.conn.routing.HttpRoute.<init>(org.apache.http.HttpHost, java.net.InetAddress, org.apache.http.HttpHost, boolean):void");
    }

    private static HttpHost[] toChain(HttpHost proxy) {
        if (proxy == null) {
            return EMPTY_HTTP_HOST_ARRAY;
        }
        return new HttpHost[]{proxy};
    }

    private static HttpHost[] toChain(HttpHost[] proxies) {
        if (proxies == null || proxies.length < 1) {
            return EMPTY_HTTP_HOST_ARRAY;
        }
        HttpHost[] arr$ = proxies;
        int len$ = arr$.length;
        int i$ = 0;
        while (i$ < len$) {
            if (arr$[i$] != null) {
                i$++;
            } else {
                throw new IllegalArgumentException("Proxy chain may not contain null elements.");
            }
        }
        HttpHost[] result = new HttpHost[proxies.length];
        System.arraycopy(proxies, 0, result, 0, proxies.length);
        return result;
    }

    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    public final InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public final int getHopCount() {
        return this.proxyChain.length + 1;
    }

    public final HttpHost getHopTarget(int hop) {
        if (hop >= 0) {
            int hopcount = getHopCount();
            if (hop >= hopcount) {
                throw new IllegalArgumentException("Hop index " + hop + " exceeds route length " + hopcount);
            } else if (hop < hopcount - 1) {
                return this.proxyChain[hop];
            } else {
                return this.targetHost;
            }
        } else {
            throw new IllegalArgumentException("Hop index must not be negative: " + hop);
        }
    }

    public final HttpHost getProxyHost() {
        HttpHost[] httpHostArr = this.proxyChain;
        if (httpHostArr.length == 0) {
            return null;
        }
        return httpHostArr[0];
    }

    public final RouteInfo.TunnelType getTunnelType() {
        return this.tunnelled;
    }

    public final boolean isTunnelled() {
        return this.tunnelled == RouteInfo.TunnelType.TUNNELLED;
    }

    public final RouteInfo.LayerType getLayerType() {
        return this.layered;
    }

    public final boolean isLayered() {
        return this.layered == RouteInfo.LayerType.LAYERED;
    }

    public final boolean isSecure() {
        return this.secure;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRoute)) {
            return false;
        }
        HttpRoute that = (HttpRoute) obj;
        if (this.secure != that.secure || this.tunnelled != that.tunnelled || this.layered != that.layered || !LangUtils.equals((Object) this.targetHost, (Object) that.targetHost) || !LangUtils.equals((Object) this.localAddress, (Object) that.localAddress) || !LangUtils.equals((Object[]) this.proxyChain, (Object[]) that.proxyChain)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hash = LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.targetHost), (Object) this.localAddress);
        int i = 0;
        while (true) {
            HttpHost[] httpHostArr = this.proxyChain;
            if (i >= httpHostArr.length) {
                return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(hash, this.secure), (Object) this.tunnelled), (Object) this.layered);
            }
            hash = LangUtils.hashCode(hash, (Object) httpHostArr[i]);
            i++;
        }
    }

    public final String toString() {
        StringBuilder cab = new StringBuilder((getHopCount() * 30) + 50);
        cab.append("HttpRoute[");
        InetAddress inetAddress = this.localAddress;
        if (inetAddress != null) {
            cab.append(inetAddress);
            cab.append("->");
        }
        cab.append('{');
        if (this.tunnelled == RouteInfo.TunnelType.TUNNELLED) {
            cab.append('t');
        }
        if (this.layered == RouteInfo.LayerType.LAYERED) {
            cab.append('l');
        }
        if (this.secure) {
            cab.append('s');
        }
        cab.append("}->");
        for (HttpHost aProxyChain : this.proxyChain) {
            cab.append(aProxyChain);
            cab.append("->");
        }
        cab.append(this.targetHost);
        cab.append(']');
        return cab.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
