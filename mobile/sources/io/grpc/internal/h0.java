package io.grpc.internal;

import defpackage.a9;
import defpackage.n7;
import defpackage.ux;
import io.grpc.internal.h1;
import io.grpc.internal.k1;
import io.grpc.internal.o;
import io.grpc.j;
import io.grpc.l;
import io.grpc.m;
import io.grpc.p;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpStatus;

public abstract class h0 {
    public static final long a;

    /* renamed from: a  reason: collision with other field name */
    public static final h1.d<Executor> f3423a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final l.g<Long> f3424a = l.g.e("grpc-timeout", new h());

    /* renamed from: a  reason: collision with other field name */
    public static final Charset f3425a = Charset.forName("US-ASCII");

    /* renamed from: a  reason: collision with other field name */
    private static final Logger f3426a = Logger.getLogger(h0.class.getName());

    /* renamed from: a  reason: collision with other field name */
    public static final n7.a<Boolean> f3427a = n7.a.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");

    /* renamed from: a  reason: collision with other field name */
    public static final oo0<hn0> f3428a = new d();

    /* renamed from: a  reason: collision with other field name */
    public static final pb0 f3429a = new z0();

    /* renamed from: a  reason: collision with other field name */
    public static final pm0 f3430a = pm0.a(',').c();
    public static final long b = TimeUnit.HOURS.toNanos(2);

    /* renamed from: b  reason: collision with other field name */
    public static final h1.d<ScheduledExecutorService> f3431b = new c();

    /* renamed from: b  reason: collision with other field name */
    public static final l.g<String> f3432b;

    /* renamed from: b  reason: collision with other field name */
    public static final pb0 f3433b = new a();
    public static final long c;

    /* renamed from: c  reason: collision with other field name */
    public static final l.g<byte[]> f3434c = j.b("grpc-accept-encoding", new f((a) null));
    public static final l.g<String> d;
    public static final l.g<byte[]> e = j.b("accept-encoding", new f((a) null));
    public static final l.g<String> f;
    public static final l.g<String> g;
    public static final l.g<String> h;

    static {
        l.d<String> dVar = l.a;
        f3432b = l.g.e("grpc-encoding", dVar);
        d = l.g.e("content-encoding", dVar);
        f = l.g.e("content-type", dVar);
        g = l.g.e("te", dVar);
        h = l.g.e("user-agent", dVar);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a = timeUnit.toNanos(20);
        c = timeUnit.toNanos(20);
    }

    private static final class f implements j.a<byte[]> {
        private f() {
        }

        /* synthetic */ f(a x0) {
            this();
        }

        /* renamed from: d */
        public byte[] a(byte[] value) {
            return value;
        }

        /* renamed from: c */
        public byte[] b(byte[] serialized) {
            return serialized;
        }
    }

    class a implements pb0 {
        a() {
        }

        public ob0 a(SocketAddress targetServerAddress) {
            return null;
        }
    }

    public static boolean l(n7 callOptions) {
        return !Boolean.TRUE.equals(callOptions.h(f3427a));
    }

    public static p j(int httpStatusCode) {
        p status = i(httpStatusCode).toStatus();
        return status.q("HTTP status code " + httpStatusCode);
    }

    private static p.b i(int httpStatusCode) {
        if (httpStatusCode >= 100 && httpStatusCode < 200) {
            return p.b.INTERNAL;
        }
        switch (httpStatusCode) {
            case HttpStatus.SC_BAD_REQUEST /*400*/:
            case 431:
                return p.b.INTERNAL;
            case HttpStatus.SC_UNAUTHORIZED /*401*/:
                return p.b.UNAUTHENTICATED;
            case HttpStatus.SC_FORBIDDEN /*403*/:
                return p.b.PERMISSION_DENIED;
            case HttpStatus.SC_NOT_FOUND /*404*/:
                return p.b.UNIMPLEMENTED;
            case 429:
            case HttpStatus.SC_BAD_GATEWAY /*502*/:
            case HttpStatus.SC_SERVICE_UNAVAILABLE /*503*/:
            case HttpStatus.SC_GATEWAY_TIMEOUT /*504*/:
                return p.b.UNAVAILABLE;
            default:
                return p.b.UNKNOWN;
        }
    }

    public enum g {
        NO_ERROR(0, r1),
        PROTOCOL_ERROR(1, r4),
        INTERNAL_ERROR(2, r4),
        FLOW_CONTROL_ERROR(3, r4),
        SETTINGS_TIMEOUT(4, r4),
        STREAM_CLOSED(5, r4),
        FRAME_SIZE_ERROR(6, r4),
        REFUSED_STREAM(7, r1),
        CANCEL(8, p.f3956b),
        COMPRESSION_ERROR(9, r4),
        CONNECT_ERROR(10, r4),
        ENHANCE_YOUR_CALM(11, p.j.q("Bandwidth exhausted")),
        INADEQUATE_SECURITY(12, p.h.q("Permission denied as protocol is not secure enough to call")),
        HTTP_1_1_REQUIRED(13, p.c);
        
        private static final g[] codeMap = null;
        private final int code;
        private final p status;

        static {
            codeMap = buildHttp2CodeMap();
        }

        private static g[] buildHttp2CodeMap() {
            g[] errors = values();
            g[] http2CodeMap = new g[(((int) errors[errors.length - 1].code()) + 1)];
            for (g error : errors) {
                http2CodeMap[(int) error.code()] = error;
            }
            return http2CodeMap;
        }

        private g(int code2, p status2) {
            this.code = code2;
            this.status = status2.e("HTTP/2 error code: " + name());
        }

        public long code() {
            return (long) this.code;
        }

        public p status() {
            return this.status;
        }

        public static g forCode(long code2) {
            g[] gVarArr = codeMap;
            if (code2 >= ((long) gVarArr.length) || code2 < 0) {
                return null;
            }
            return gVarArr[(int) code2];
        }

        public static p statusForCode(long code2) {
            g error = forCode(code2);
            if (error != null) {
                return error.status();
            }
            p h = p.h(INTERNAL_ERROR.status().m().value());
            return h.q("Unrecognized HTTP/2 error code: " + code2);
        }
    }

    public static boolean k(String contentType) {
        char nextChar;
        if (contentType == null || "application/grpc".length() > contentType.length()) {
            return false;
        }
        String contentType2 = contentType.toLowerCase();
        if (!contentType2.startsWith("application/grpc")) {
            return false;
        }
        if (contentType2.length() == "application/grpc".length() || (nextChar = contentType2.charAt("application/grpc".length())) == '+' || nextChar == ';') {
            return true;
        }
        return false;
    }

    public static String e(String transportName, String applicationUserAgent) {
        StringBuilder builder = new StringBuilder();
        if (applicationUserAgent != null) {
            builder.append(applicationUserAgent);
            builder.append(' ');
        }
        builder.append("grpc-java-");
        builder.append(transportName);
        builder.append('/');
        builder.append("1.32.2");
        return builder.toString();
    }

    public static URI a(String authority) {
        v90.o(authority, "authority");
        try {
            return new URI((String) null, authority, (String) null, (String) null, (String) null);
        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException("Invalid authority: " + authority, ex);
        }
    }

    public static String b(String authority) {
        URI uri = a(authority);
        boolean z = true;
        v90.j(uri.getHost() != null, "No host in authority '%s'", authority);
        if (uri.getUserInfo() != null) {
            z = false;
        }
        v90.j(z, "Userinfo must not be present on authority: '%s'", authority);
        return authority;
    }

    class b implements h1.d<Executor> {
        b() {
        }

        /* renamed from: d */
        public Executor b() {
            return Executors.newCachedThreadPool(h0.g("grpc-default-executor-%d", true));
        }

        /* renamed from: c */
        public void a(Executor instance) {
            ((ExecutorService) instance).shutdown();
        }

        public String toString() {
            return "grpc-default-executor";
        }
    }

    class c implements h1.d<ScheduledExecutorService> {
        c() {
        }

        /* renamed from: d */
        public ScheduledExecutorService b() {
            ScheduledExecutorService service = Executors.newScheduledThreadPool(1, h0.g("grpc-timer-%d", true));
            try {
                service.getClass().getMethod("setRemoveOnCancelPolicy", new Class[]{Boolean.TYPE}).invoke(service, new Object[]{true});
            } catch (NoSuchMethodException e) {
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
            return Executors.unconfigurableScheduledExecutorService(service);
        }

        /* renamed from: c */
        public void a(ScheduledExecutorService instance) {
            instance.shutdown();
        }
    }

    public static ThreadFactory g(String nameFormat, boolean daemon) {
        return new yq0().e(daemon).f(nameFormat).b();
    }

    class d implements oo0<hn0> {
        d() {
        }

        /* renamed from: a */
        public hn0 get() {
            return hn0.c();
        }
    }

    public static String f(InetSocketAddress addr) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", new Class[0]).invoke(addr, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            return addr.getHostName();
        }
    }

    static class h implements l.d<Long> {
        h() {
        }

        /* renamed from: d */
        public String b(Long timeoutNanos) {
            TimeUnit unit = TimeUnit.NANOSECONDS;
            if (timeoutNanos.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            } else if (timeoutNanos.longValue() < 100000000) {
                return timeoutNanos + "n";
            } else if (timeoutNanos.longValue() < 100000000 * 1000) {
                return unit.toMicros(timeoutNanos.longValue()) + "u";
            } else if (timeoutNanos.longValue() < 100000000 * 1000 * 1000) {
                return unit.toMillis(timeoutNanos.longValue()) + "m";
            } else if (timeoutNanos.longValue() < 100000000 * 1000 * 1000 * 1000) {
                return unit.toSeconds(timeoutNanos.longValue()) + "S";
            } else if (timeoutNanos.longValue() < 100000000 * 1000 * 1000 * 1000 * 60) {
                return unit.toMinutes(timeoutNanos.longValue()) + "M";
            } else {
                return unit.toHours(timeoutNanos.longValue()) + "H";
            }
        }

        /* renamed from: c */
        public Long a(String serialized) {
            v90.e(serialized.length() > 0, "empty timeout");
            v90.e(serialized.length() <= 9, "bad timeout format");
            long value = Long.parseLong(serialized.substring(0, serialized.length() - 1));
            char unit = serialized.charAt(serialized.length() - 1);
            switch (unit) {
                case 'H':
                    return Long.valueOf(TimeUnit.HOURS.toNanos(value));
                case 'M':
                    return Long.valueOf(TimeUnit.MINUTES.toNanos(value));
                case 'S':
                    return Long.valueOf(TimeUnit.SECONDS.toNanos(value));
                case 'm':
                    return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(value));
                case 'n':
                    return Long.valueOf(value);
                case 'u':
                    return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(value));
                default:
                    throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", new Object[]{Character.valueOf(unit)}));
            }
        }
    }

    static p h(ux.e result, boolean isWaitForReady) {
        p transport;
        ux.h subchannel = result.c();
        if (subchannel != null) {
            transport = ((l1) subchannel.d()).a();
        } else {
            transport = null;
        }
        if (transport != null) {
            a9.a streamTracerFactory = result.b();
            if (streamTracerFactory == null) {
                return transport;
            }
            return new e(transport, streamTracerFactory);
        } else if (result.a().o()) {
            return null;
        } else {
            if (result.d()) {
                return new a0(result.a(), o.a.DROPPED);
            }
            if (!isWaitForReady) {
                return new a0(result.a(), o.a.PROCESSED);
            }
            return null;
        }
    }

    class e implements p {
        final /* synthetic */ a9.a a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ p f3435a;

        e(p pVar, a9.a aVar) {
            this.f3435a = pVar;
            this.a = aVar;
        }

        public z8 f(m<?, ?> method, l headers, n7 callOptions) {
            return this.f3435a.f(method, headers, callOptions.q(this.a));
        }

        public hu b() {
            return this.f3435a.b();
        }
    }

    static void c(k1.a producer) {
        while (true) {
            InputStream c2 = producer.c();
            InputStream message = c2;
            if (c2 != null) {
                d(message);
            } else {
                return;
            }
        }
    }

    public static void d(Closeable message) {
        if (message != null) {
            try {
                message.close();
            } catch (IOException ioException) {
                f3426a.log(Level.WARNING, "exception caught in closeQuietly", ioException);
            }
        }
    }
}
