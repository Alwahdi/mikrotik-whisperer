package io.grpc.okhttp;

import io.grpc.internal.h0;
import io.grpc.okhttp.internal.c;
import io.grpc.okhttp.internal.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

class i {
    private static i a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final Logger f3918a;
    private static final c b = c.e();

    /* renamed from: a  reason: collision with other field name */
    protected final c f3919a;

    static {
        Class<i> cls = i.class;
        f3918a = Logger.getLogger(cls.getName());
        a = d(cls.getClassLoader());
    }

    i(c platform) {
        this.f3919a = (c) v90.o(platform, "platform");
    }

    public static i e() {
        return a;
    }

    static i d(ClassLoader loader) {
        boolean android2 = true;
        try {
            loader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e1) {
            f3918a.log(Level.FINE, "Unable to find Conscrypt. Skipping", e1);
            try {
                loader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e2) {
                f3918a.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", e2);
                android2 = false;
            }
        }
        if (android2) {
            return new a(b);
        }
        return new i(b);
    }

    public String h(SSLSocket sslSocket, String hostname, List<d> protocols) {
        if (protocols != null) {
            c(sslSocket, hostname, protocols);
        }
        try {
            sslSocket.startHandshake();
            String negotiatedProtocol = f(sslSocket);
            if (negotiatedProtocol != null) {
                return negotiatedProtocol;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + protocols);
        } finally {
            this.f3919a.a(sslSocket);
        }
    }

    /* access modifiers changed from: protected */
    public void c(SSLSocket sslSocket, String hostname, List<d> protocols) {
        this.f3919a.c(sslSocket, hostname, protocols);
    }

    public String f(SSLSocket socket) {
        return this.f3919a.h(socket);
    }

    static final class a extends i {
        private static final Constructor<?> a;

        /* renamed from: a  reason: collision with other field name */
        private static final Method f3920a;

        /* renamed from: a  reason: collision with other field name */
        private static final y40<Socket> f3921a;
        private static final Method b;

        /* renamed from: b  reason: collision with other field name */
        private static final y40<Socket> f3922b;
        private static final Method c;

        /* renamed from: c  reason: collision with other field name */
        private static final y40<Socket> f3923c;
        private static final Method d;

        /* renamed from: d  reason: collision with other field name */
        private static final y40<Socket> f3924d;
        private static final Method e;

        /* renamed from: e  reason: collision with other field name */
        private static final y40<Socket> f3925e;
        private static final Method f;

        /* renamed from: f  reason: collision with other field name */
        private static final y40<Socket> f3926f;

        static {
            Class<String> cls = String.class;
            Class<byte[]> cls2 = byte[].class;
            Class cls3 = Boolean.TYPE;
            f3921a = new y40<>((Class<?>) null, "setUseSessionTickets", cls3);
            f3922b = new y40<>((Class<?>) null, "setHostname", cls);
            f3923c = new y40<>(cls2, "getAlpnSelectedProtocol", new Class[0]);
            f3924d = new y40<>((Class<?>) null, "setAlpnProtocols", cls2);
            f3925e = new y40<>(cls2, "getNpnSelectedProtocol", new Class[0]);
            f3926f = new y40<>((Class<?>) null, "setNpnProtocols", cls2);
            Method setApplicationProtocolsMethod = null;
            Method getApplicationProtocolsMethod = null;
            Method getApplicationProtocolMethod = null;
            Method sslSocketsIsSupportedSocketMethod = null;
            Method sslSocketsSetUseSessionTicketsMethod = null;
            Class<SSLParameters> cls4 = SSLParameters.class;
            try {
                setApplicationProtocolsMethod = cls4.getMethod("setApplicationProtocols", new Class[]{String[].class});
                getApplicationProtocolsMethod = cls4.getMethod("getApplicationProtocols", new Class[0]);
                getApplicationProtocolMethod = SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                Class<?> sslSockets = Class.forName("android.net.ssl.SSLSockets");
                sslSocketsIsSupportedSocketMethod = sslSockets.getMethod("isSupportedSocket", new Class[]{SSLSocket.class});
                sslSocketsSetUseSessionTicketsMethod = sslSockets.getMethod("setUseSessionTickets", new Class[]{SSLSocket.class, cls3});
            } catch (ClassNotFoundException e2) {
                i.f3918a.log(Level.FINER, "Failed to find Android 10.0+ APIs", e2);
            } catch (NoSuchMethodException e3) {
                i.f3918a.log(Level.FINER, "Failed to find Android 10.0+ APIs", e3);
            }
            c = setApplicationProtocolsMethod;
            d = getApplicationProtocolsMethod;
            e = getApplicationProtocolMethod;
            f3920a = sslSocketsIsSupportedSocketMethod;
            b = sslSocketsSetUseSessionTicketsMethod;
            Method setServerNamesMethod = null;
            Constructor<?> sniHostNameConstructor = null;
            try {
                setServerNamesMethod = SSLParameters.class.getMethod("setServerNames", new Class[]{List.class});
                sniHostNameConstructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls});
            } catch (ClassNotFoundException e4) {
                i.f3918a.log(Level.FINER, "Failed to find Android 7.0+ APIs", e4);
            } catch (NoSuchMethodException e5) {
                i.f3918a.log(Level.FINER, "Failed to find Android 7.0+ APIs", e5);
            }
            f = setServerNamesMethod;
            a = sniHostNameConstructor;
        }

        a(c platform) {
            super(platform);
        }

        public String h(SSLSocket sslSocket, String hostname, List<d> protocols) {
            String negotiatedProtocol = f(sslSocket);
            if (negotiatedProtocol == null) {
                return i.super.h(sslSocket, hostname, protocols);
            }
            return negotiatedProtocol;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object[]} */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e3, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e9, code lost:
            throw new java.lang.RuntimeException(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f1, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f7, code lost:
            throw new java.lang.RuntimeException(r2);
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004d A[Catch:{ InvocationTargetException -> 0x007f, IllegalAccessException -> 0x00f1, InstantiationException -> 0x00e3, IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0061 A[Catch:{ InvocationTargetException -> 0x007f, IllegalAccessException -> 0x00f1, InstantiationException -> 0x00e3, IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00e3 A[ExcHandler: InstantiationException (r2v3 'e' java.lang.InstantiationException A[CUSTOM_DECLARE]), Splitter:B:2:0x000c] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00f1 A[ExcHandler: IllegalAccessException (r2v1 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:2:0x000c] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(javax.net.ssl.SSLSocket r11, java.lang.String r12, java.util.List<io.grpc.okhttp.internal.d> r13) {
            /*
                r10 = this;
                java.lang.String[] r0 = io.grpc.okhttp.i.i(r13)
                javax.net.ssl.SSLParameters r1 = r11.getSSLParameters()
                r2 = 1
                r3 = 0
                if (r12 == 0) goto L_0x006a
                boolean r4 = io.grpc.okhttp.i.g(r12)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                if (r4 == 0) goto L_0x006a
                java.lang.reflect.Method r4 = f3920a     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                if (r4 == 0) goto L_0x0038
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r5[r3] = r11     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r6 = 0
                java.lang.Object r4 = r4.invoke(r6, r5)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                boolean r4 = r4.booleanValue()     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                if (r4 == 0) goto L_0x0038
                java.lang.reflect.Method r4 = b     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r5 = 2
                java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r5[r3] = r11     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r5[r2] = r7     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r4.invoke(r6, r5)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                goto L_0x0045
            L_0x0038:
                y40<java.net.Socket> r4 = f3921a     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r5[r3] = r6     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r4.e(r11, r5)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
            L_0x0045:
                java.lang.reflect.Method r4 = f     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                if (r4 == 0) goto L_0x0061
                java.lang.reflect.Constructor<?> r5 = a     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                if (r5 == 0) goto L_0x0061
                java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r7[r3] = r12     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.lang.Object r5 = r5.newInstance(r7)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.util.List r5 = java.util.Collections.singletonList(r5)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r6[r3] = r5     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r4.invoke(r1, r6)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                goto L_0x006a
            L_0x0061:
                y40<java.net.Socket> r4 = f3922b     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r5[r3] = r12     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                r4.e(r11, r5)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
            L_0x006a:
                r4 = 0
                java.lang.reflect.Method r5 = e     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                if (r5 == 0) goto L_0x0096
                java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ InvocationTargetException -> 0x007f, IllegalAccessException -> 0x00f1, InstantiationException -> 0x00e3 }
                r5.invoke(r11, r6)     // Catch:{ InvocationTargetException -> 0x007f, IllegalAccessException -> 0x00f1, InstantiationException -> 0x00e3 }
                java.lang.reflect.Method r5 = c     // Catch:{ InvocationTargetException -> 0x007f, IllegalAccessException -> 0x00f1, InstantiationException -> 0x00e3 }
                java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ InvocationTargetException -> 0x007f, IllegalAccessException -> 0x00f1, InstantiationException -> 0x00e3 }
                r6[r3] = r0     // Catch:{ InvocationTargetException -> 0x007f, IllegalAccessException -> 0x00f1, InstantiationException -> 0x00e3 }
                r5.invoke(r1, r6)     // Catch:{ InvocationTargetException -> 0x007f, IllegalAccessException -> 0x00f1, InstantiationException -> 0x00e3 }
                r4 = 1
                goto L_0x0096
            L_0x007f:
                r5 = move-exception
                java.lang.Throwable r6 = r5.getTargetException()     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                boolean r7 = r6 instanceof java.lang.UnsupportedOperationException     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                if (r7 == 0) goto L_0x0094
                java.util.logging.Logger r7 = io.grpc.okhttp.i.f3918a     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.util.logging.Level r8 = java.util.logging.Level.FINER     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.lang.String r9 = "setApplicationProtocol unsupported, will try old methods"
                r7.log(r8, r9)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                goto L_0x0096
            L_0x0094:
                throw r5     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
            L_0x0096:
                r11.setSSLParameters(r1)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                if (r4 == 0) goto L_0x00b3
                java.lang.reflect.Method r5 = d     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                if (r5 == 0) goto L_0x00b3
                javax.net.ssl.SSLParameters r6 = r11.getSSLParameters()     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.lang.Object r5 = r5.invoke(r6, r7)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                boolean r6 = java.util.Arrays.equals(r0, r5)     // Catch:{ IllegalAccessException -> 0x00f1, InvocationTargetException -> 0x00ea, InstantiationException -> 0x00e3 }
                if (r6 == 0) goto L_0x00b3
                return
            L_0x00b3:
                java.lang.Object[] r2 = new java.lang.Object[r2]
                byte[] r4 = io.grpc.okhttp.internal.c.b(r13)
                r2[r3] = r4
                io.grpc.okhttp.internal.c r3 = r10.f3919a
                io.grpc.okhttp.internal.c$h r3 = r3.i()
                io.grpc.okhttp.internal.c$h r4 = io.grpc.okhttp.internal.c.h.ALPN_AND_NPN
                if (r3 != r4) goto L_0x00cb
                y40<java.net.Socket> r3 = f3924d
                r3.f(r11, r2)
            L_0x00cb:
                io.grpc.okhttp.internal.c r3 = r10.f3919a
                io.grpc.okhttp.internal.c$h r3 = r3.i()
                io.grpc.okhttp.internal.c$h r4 = io.grpc.okhttp.internal.c.h.NONE
                if (r3 == r4) goto L_0x00db
                y40<java.net.Socket> r3 = f3926f
                r3.f(r11, r2)
                return
            L_0x00db:
                java.lang.RuntimeException r3 = new java.lang.RuntimeException
                java.lang.String r4 = "We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS"
                r3.<init>(r4)
                throw r3
            L_0x00e3:
                r2 = move-exception
                java.lang.RuntimeException r3 = new java.lang.RuntimeException
                r3.<init>(r2)
                throw r3
            L_0x00ea:
                r2 = move-exception
                java.lang.RuntimeException r3 = new java.lang.RuntimeException
                r3.<init>(r2)
                throw r3
            L_0x00f1:
                r2 = move-exception
                java.lang.RuntimeException r3 = new java.lang.RuntimeException
                r3.<init>(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.i.a.c(javax.net.ssl.SSLSocket, java.lang.String, java.util.List):void");
        }

        public String f(SSLSocket socket) {
            Method method = e;
            if (method != null) {
                try {
                    return (String) method.invoke(socket, new Object[0]);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (InvocationTargetException e3) {
                    if (e3.getTargetException() instanceof UnsupportedOperationException) {
                        i.f3918a.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                    } else {
                        throw new RuntimeException(e3);
                    }
                }
            }
            if (this.f3919a.i() == c.h.ALPN_AND_NPN) {
                try {
                    byte[] alpnResult = (byte[]) f3923c.f(socket, new Object[0]);
                    if (alpnResult != null) {
                        return new String(alpnResult, ru0.a);
                    }
                } catch (Exception e4) {
                    i.f3918a.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", e4);
                }
            }
            if (this.f3919a.i() == c.h.NONE) {
                return null;
            }
            try {
                byte[] npnResult = (byte[]) f3925e.f(socket, new Object[0]);
                if (npnResult != null) {
                    return new String(npnResult, ru0.a);
                }
                return null;
            } catch (Exception e5) {
                i.f3918a.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", e5);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static String[] i(List<d> protocols) {
        List<String> result = new ArrayList<>();
        for (d protocol : protocols) {
            result.add(protocol.toString());
        }
        return (String[]) result.toArray(new String[0]);
    }

    static boolean g(String name) {
        if (name.contains("_")) {
            return false;
        }
        try {
            h0.b(name);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
