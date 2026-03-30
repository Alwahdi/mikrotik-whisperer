package io.grpc.okhttp.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class c {
    private static final c a = d();

    /* renamed from: a  reason: collision with other field name */
    public static final Logger f3934a = Logger.getLogger(c.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f3935a = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* renamed from: a  reason: collision with other field name */
    private final Provider f3936a;

    public enum h {
        ALPN_AND_NPN,
        NPN,
        NONE
    }

    public static c e() {
        return a;
    }

    public c(Provider sslProvider) {
        this.f3936a = sslProvider;
    }

    public Provider g() {
        return this.f3936a;
    }

    public h i() {
        return h.NONE;
    }

    public void c(SSLSocket sslSocket, String hostname, List<d> list) {
    }

    public void a(SSLSocket sslSocket) {
    }

    public String h(SSLSocket socket) {
        return null;
    }

    private static c d() {
        Method trafficStatsUntagSocket;
        Method trafficStatsTagSocket;
        h tlsExtensionType;
        Class<byte[]> cls = byte[].class;
        Provider androidOrAppEngineProvider = f();
        if (androidOrAppEngineProvider != null) {
            OptionalMethod<Socket> setUseSessionTickets = new y40<>((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
            OptionalMethod<Socket> setHostname = new y40<>((Class<?>) null, "setHostname", String.class);
            Method trafficStatsTagSocket2 = null;
            Method trafficStatsUntagSocket2 = null;
            OptionalMethod<Socket> getAlpnSelectedProtocol = new y40<>(cls, "getAlpnSelectedProtocol", new Class[0]);
            OptionalMethod<Socket> setAlpnProtocols = new y40<>((Class<?>) null, "setAlpnProtocols", cls);
            try {
                Class<?> trafficStats = Class.forName("android.net.TrafficStats");
                trafficStatsTagSocket2 = trafficStats.getMethod("tagSocket", new Class[]{Socket.class});
                trafficStatsUntagSocket2 = trafficStats.getMethod("untagSocket", new Class[]{Socket.class});
            } catch (ClassNotFoundException e2) {
            } catch (NoSuchMethodException e3) {
                trafficStatsTagSocket = null;
                trafficStatsUntagSocket = null;
            }
            trafficStatsTagSocket = trafficStatsTagSocket2;
            trafficStatsUntagSocket = trafficStatsUntagSocket2;
            if (androidOrAppEngineProvider.getName().equals("GmsCore_OpenSSL") || androidOrAppEngineProvider.getName().equals("Conscrypt") || androidOrAppEngineProvider.getName().equals("Ssl_Guard")) {
                tlsExtensionType = h.ALPN_AND_NPN;
            } else if (k()) {
                tlsExtensionType = h.ALPN_AND_NPN;
            } else if (j()) {
                tlsExtensionType = h.NPN;
            } else {
                tlsExtensionType = h.NONE;
            }
            return new d(setUseSessionTickets, setHostname, trafficStatsTagSocket, trafficStatsUntagSocket, getAlpnSelectedProtocol, setAlpnProtocols, androidOrAppEngineProvider, tlsExtensionType);
        }
        try {
            Provider sslProvider = SSLContext.getDefault().getProvider();
            try {
                SSLContext context = SSLContext.getInstance(SSLSocketFactory.TLS, sslProvider);
                context.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                ((Method) AccessController.doPrivileged(new a())).invoke(context.createSSLEngine(), new Object[0]);
                return new e(sslProvider, (Method) AccessController.doPrivileged(new b()), (Method) AccessController.doPrivileged(new C0049c()), (a) null);
            } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException e4) {
                try {
                    Class<?> negoClass = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> providerClass = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
                    return new f(negoClass.getMethod("put", new Class[]{SSLSocket.class, providerClass}), negoClass.getMethod("get", new Class[]{SSLSocket.class}), negoClass.getMethod("remove", new Class[]{SSLSocket.class}), Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider"), sslProvider);
                } catch (ClassNotFoundException | NoSuchMethodException e5) {
                    return new c(sslProvider);
                }
            }
        } catch (NoSuchAlgorithmException nsae) {
            throw new RuntimeException(nsae);
        }
    }

    class a implements PrivilegedExceptionAction<Method> {
        a() {
        }

        /* renamed from: a */
        public Method run() {
            return SSLEngine.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    class b implements PrivilegedExceptionAction<Method> {
        b() {
        }

        /* renamed from: a */
        public Method run() {
            return SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class});
        }
    }

    /* renamed from: io.grpc.okhttp.internal.c$c  reason: collision with other inner class name */
    class C0049c implements PrivilegedExceptionAction<Method> {
        C0049c() {
        }

        /* renamed from: a */
        public Method run() {
            return SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    private static boolean k() {
        try {
            c.class.getClassLoader().loadClass("android.net.Network");
            return true;
        } catch (ClassNotFoundException e2) {
            f3934a.log(Level.FINE, "Can't find class", e2);
            return false;
        }
    }

    private static boolean j() {
        try {
            c.class.getClassLoader().loadClass("android.app.ActivityOptions");
            return true;
        } catch (ClassNotFoundException e2) {
            f3934a.log(Level.FINE, "Can't find class", e2);
            return false;
        }
    }

    private static Provider f() {
        for (Provider availableProvider : Security.getProviders()) {
            for (String providerClassName : f3935a) {
                if (providerClassName.equals(availableProvider.getClass().getName())) {
                    f3934a.log(Level.FINE, "Found registered provider {0}", providerClassName);
                    return availableProvider;
                }
            }
        }
        f3934a.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    private static class d extends c {
        private final h a;

        /* renamed from: a  reason: collision with other field name */
        private final Method f3937a;

        /* renamed from: a  reason: collision with other field name */
        private final y40<Socket> f3938a;
        private final Method b;

        /* renamed from: b  reason: collision with other field name */
        private final y40<Socket> f3939b;
        private final y40<Socket> c;
        private final y40<Socket> d;

        public d(y40<Socket> setUseSessionTickets, y40<Socket> setHostname, Method trafficStatsTagSocket, Method trafficStatsUntagSocket, y40<Socket> getAlpnSelectedProtocol, y40<Socket> setAlpnProtocols, Provider provider, h tlsExtensionType) {
            super(provider);
            this.f3938a = setUseSessionTickets;
            this.f3939b = setHostname;
            this.f3937a = trafficStatsTagSocket;
            this.b = trafficStatsUntagSocket;
            this.c = getAlpnSelectedProtocol;
            this.d = setAlpnProtocols;
            this.a = tlsExtensionType;
        }

        public h i() {
            return this.a;
        }

        public void c(SSLSocket sslSocket, String hostname, List<d> protocols) {
            if (hostname != null) {
                this.f3938a.e(sslSocket, true);
                this.f3939b.e(sslSocket, hostname);
            }
            if (this.d.g(sslSocket)) {
                this.d.f(sslSocket, c.b(protocols));
            }
        }

        public String h(SSLSocket socket) {
            byte[] alpnResult;
            if (this.c.g(socket) && (alpnResult = (byte[]) this.c.f(socket, new Object[0])) != null) {
                return new String(alpnResult, ru0.a);
            }
            return null;
        }
    }

    private static class e extends c {
        private final Method a;
        private final Method b;

        /* synthetic */ e(Provider x0, Method x1, Method x2, a x3) {
            this(x0, x1, x2);
        }

        private e(Provider provider, Method setApplicationProtocols, Method getApplicationProtocol) {
            super(provider);
            this.a = setApplicationProtocols;
            this.b = getApplicationProtocol;
        }

        public h i() {
            return h.ALPN_AND_NPN;
        }

        public void c(SSLSocket sslSocket, String hostname, List<d> protocols) {
            SSLParameters parameters = sslSocket.getSSLParameters();
            List<String> names = new ArrayList<>(protocols.size());
            for (d protocol : protocols) {
                if (protocol != d.HTTP_1_0) {
                    names.add(protocol.toString());
                }
            }
            try {
                this.a.invoke(parameters, new Object[]{names.toArray(new String[names.size()])});
                sslSocket.setSSLParameters(parameters);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }

        public String h(SSLSocket socket) {
            try {
                return (String) this.b.invoke(socket, new Object[0]);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private static class f extends c {
        private final Class<?> a;

        /* renamed from: a  reason: collision with other field name */
        private final Method f3940a;
        private final Class<?> b;

        /* renamed from: b  reason: collision with other field name */
        private final Method f3941b;
        private final Method c;

        public f(Method putMethod, Method getMethod, Method removeMethod, Class<?> clientProviderClass, Class<?> serverProviderClass, Provider provider) {
            super(provider);
            this.f3940a = putMethod;
            this.f3941b = getMethod;
            this.c = removeMethod;
            this.a = clientProviderClass;
            this.b = serverProviderClass;
        }

        public h i() {
            return h.ALPN_AND_NPN;
        }

        public void c(SSLSocket sslSocket, String hostname, List<d> protocols) {
            List<String> names = new ArrayList<>(protocols.size());
            int size = protocols.size();
            for (int i = 0; i < size; i++) {
                d protocol = protocols.get(i);
                if (protocol != d.HTTP_1_0) {
                    names.add(protocol.toString());
                }
            }
            try {
                Object provider = Proxy.newProxyInstance(c.class.getClassLoader(), new Class[]{this.a, this.b}, new g(names));
                this.f3940a.invoke((Object) null, new Object[]{sslSocket, provider});
            } catch (InvocationTargetException e) {
                throw new AssertionError(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public void a(SSLSocket sslSocket) {
            try {
                this.c.invoke((Object) null, new Object[]{sslSocket});
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException ex) {
                c.f3934a.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", ex);
            }
        }

        public String h(SSLSocket socket) {
            try {
                g provider = (g) Proxy.getInvocationHandler(this.f3941b.invoke((Object) null, new Object[]{socket}));
                if (!provider.f3943a && provider.a == null) {
                    c.f3934a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                } else if (provider.f3943a) {
                    return null;
                } else {
                    return provider.a;
                }
            } catch (InvocationTargetException e) {
                throw new AssertionError();
            } catch (IllegalAccessException e2) {
                throw new AssertionError();
            }
        }
    }

    private static class g implements InvocationHandler {
        /* access modifiers changed from: private */
        public String a;

        /* renamed from: a  reason: collision with other field name */
        private final List<String> f3942a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public boolean f3943a;

        public g(List<String> protocols) {
            this.f3942a = protocols;
        }

        public Object invoke(Object proxy, Method method, Object[] args) {
            String methodName = method.getName();
            Class<?> returnType = method.getReturnType();
            if (args == null) {
                args = ru0.f4949a;
            }
            if (methodName.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (methodName.equals("unsupported") && Void.TYPE == returnType) {
                this.f3943a = true;
                return null;
            } else if (methodName.equals("protocols") && args.length == 0) {
                return this.f3942a;
            } else {
                if ((methodName.equals("selectProtocol") || methodName.equals("select")) && String.class == returnType && args.length == 1 && (args[0] instanceof List)) {
                    List<String> peerProtocols = (List) args[0];
                    int size = peerProtocols.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f3942a.contains(peerProtocols.get(i))) {
                            String str = peerProtocols.get(i);
                            this.a = str;
                            return str;
                        }
                    }
                    String str2 = this.f3942a.get(0);
                    this.a = str2;
                    return str2;
                } else if ((!methodName.equals("protocolSelected") && !methodName.equals("selected")) || args.length != 1) {
                    return method.invoke(this, args);
                } else {
                    this.a = (String) args[0];
                    return null;
                }
            }
        }
    }

    public static byte[] b(List<d> protocols) {
        r6 result = new r6();
        int size = protocols.size();
        for (int i = 0; i < size; i++) {
            d protocol = protocols.get(i);
            if (protocol != d.HTTP_1_0) {
                result.I(protocol.toString().length());
                result.R(protocol.toString());
            }
        }
        return result.X();
    }
}
