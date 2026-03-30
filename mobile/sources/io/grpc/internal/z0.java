package io.grpc.internal;

import defpackage.xq;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class z0 implements pb0 {
    /* access modifiers changed from: private */
    public static final Logger a = Logger.getLogger(z0.class.getName());
    private static final c b = new a();

    /* renamed from: b  reason: collision with other field name */
    private static final oo0<ProxySelector> f3793b = new b();

    /* renamed from: a  reason: collision with other field name */
    private final c f3794a;

    /* renamed from: a  reason: collision with other field name */
    private final InetSocketAddress f3795a;

    /* renamed from: a  reason: collision with other field name */
    private final oo0<ProxySelector> f3796a;

    interface c {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i, String str2, String str3, String str4);
    }

    class a implements c {
        a() {
        }

        public PasswordAuthentication a(String host, InetAddress addr, int port, String protocol, String prompt, String scheme) {
            URL url;
            String str = host;
            String str2 = protocol;
            try {
                int i = port;
                try {
                    url = new URL(str2, host, port, "");
                } catch (MalformedURLException e) {
                    z0.a.log(Level.WARNING, String.format("failed to create URL for Authenticator: %s %s", new Object[]{str2, str}));
                    url = null;
                    return Authenticator.requestPasswordAuthentication(host, addr, port, protocol, prompt, scheme, url, Authenticator.RequestorType.PROXY);
                }
            } catch (MalformedURLException e2) {
                int i2 = port;
                z0.a.log(Level.WARNING, String.format("failed to create URL for Authenticator: %s %s", new Object[]{str2, str}));
                url = null;
                return Authenticator.requestPasswordAuthentication(host, addr, port, protocol, prompt, scheme, url, Authenticator.RequestorType.PROXY);
            }
            return Authenticator.requestPasswordAuthentication(host, addr, port, protocol, prompt, scheme, url, Authenticator.RequestorType.PROXY);
        }
    }

    class b implements oo0<ProxySelector> {
        b() {
        }

        /* renamed from: a */
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    }

    public z0() {
        this(f3793b, b, System.getenv("GRPC_PROXY_EXP"));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [oo0<java.net.ProxySelector>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    z0(defpackage.oo0<java.net.ProxySelector> r2, io.grpc.internal.z0.c r3, java.lang.String r4) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.Object r0 = defpackage.v90.n(r2)
            oo0 r0 = (defpackage.oo0) r0
            r1.f3796a = r0
            java.lang.Object r0 = defpackage.v90.n(r3)
            io.grpc.internal.z0$c r0 = (io.grpc.internal.z0.c) r0
            r1.f3794a = r0
            if (r4 == 0) goto L_0x001c
            java.net.InetSocketAddress r0 = d(r4)
            r1.f3795a = r0
            goto L_0x001f
        L_0x001c:
            r0 = 0
            r1.f3795a = r0
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.z0.<init>(oo0, io.grpc.internal.z0$c, java.lang.String):void");
    }

    public ob0 a(SocketAddress targetServerAddress) {
        if (!(targetServerAddress instanceof InetSocketAddress)) {
            return null;
        }
        if (this.f3795a != null) {
            return xq.e().c(this.f3795a).d((InetSocketAddress) targetServerAddress).a();
        }
        return c((InetSocketAddress) targetServerAddress);
    }

    private ob0 c(InetSocketAddress targetAddr) {
        InetSocketAddress resolvedProxyAddr;
        String str = null;
        try {
            try {
                URI uri = new URI("https", (String) null, h0.f(targetAddr), targetAddr.getPort(), (String) null, (String) null, (String) null);
                ProxySelector proxySelector = this.f3796a.get();
                if (proxySelector == null) {
                    a.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> proxies = proxySelector.select(uri);
                if (proxies.size() > 1) {
                    a.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = proxies.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress proxyAddr = (InetSocketAddress) proxy.address();
                PasswordAuthentication auth = this.f3794a.a(h0.f(proxyAddr), proxyAddr.getAddress(), proxyAddr.getPort(), "https", "", (String) null);
                if (proxyAddr.isUnresolved()) {
                    resolvedProxyAddr = new InetSocketAddress(InetAddress.getByName(proxyAddr.getHostName()), proxyAddr.getPort());
                } else {
                    resolvedProxyAddr = proxyAddr;
                }
                xq.b builder = xq.e().d(targetAddr).c(resolvedProxyAddr);
                if (auth == null) {
                    return builder.a();
                }
                xq.b e = builder.e(auth.getUserName());
                if (auth.getPassword() != null) {
                    str = new String(auth.getPassword());
                }
                return e.b(str).a();
            } catch (URISyntaxException e2) {
                InetSocketAddress inetSocketAddress = targetAddr;
                a.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", e2);
                return null;
            }
        } catch (Throwable e3) {
            InetSocketAddress inetSocketAddress2 = targetAddr;
            a.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", e3);
            return null;
        }
    }

    private static InetSocketAddress d(String proxyHostPort) {
        if (proxyHostPort == null) {
            return null;
        }
        String[] parts = proxyHostPort.split(":", 2);
        int port = 80;
        if (parts.length > 1) {
            port = Integer.parseInt(parts[1]);
        }
        a.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(parts[0], port);
    }
}
