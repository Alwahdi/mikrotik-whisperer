package defpackage;

import androidx.core.app.NotificationCompat;
import defpackage.v4;
import io.grpc.p;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: b30  reason: default package */
public abstract class b30 {

    /* renamed from: b30$c */
    public static abstract class c {
        public static final v4.c<Integer> a = v4.c.a("params-default-port");
        public static final v4.c<pb0> b = v4.c.a("params-proxy-detector");
        private static final v4.c<vo0> c = v4.c.a("params-sync-context");
        private static final v4.c<f> d = v4.c.a("params-parser");

        public abstract String a();

        public abstract b30 b(URI uri, a aVar);
    }

    /* renamed from: b30$d */
    public static abstract class d {
        public abstract void a(p pVar);

        public abstract void b(e eVar);
    }

    /* renamed from: b30$f */
    public static abstract class f {
        public abstract b a(Map<String, ?> map);
    }

    public abstract String a();

    public abstract void b();

    public abstract void c();

    public abstract void d(d dVar);

    /* renamed from: b30$a */
    public static final class a {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private final f f157a;

        /* renamed from: a  reason: collision with other field name */
        private final io.grpc.a f158a;

        /* renamed from: a  reason: collision with other field name */
        private final Executor f159a;

        /* renamed from: a  reason: collision with other field name */
        private final ScheduledExecutorService f160a;

        /* renamed from: a  reason: collision with other field name */
        private final pb0 f161a;

        /* renamed from: a  reason: collision with other field name */
        private final vo0 f162a;

        /* synthetic */ a(Integer x0, pb0 x1, vo0 x2, f x3, ScheduledExecutorService x4, io.grpc.a x5, Executor x6, a30 x7) {
            this(x0, x1, x2, x3, x4, x5, x6);
        }

        private a(Integer defaultPort, pb0 proxyDetector, vo0 syncContext, f serviceConfigParser, ScheduledExecutorService scheduledExecutorService, io.grpc.a channelLogger, Executor executor) {
            this.a = ((Integer) v90.o(defaultPort, "defaultPort not set")).intValue();
            this.f161a = (pb0) v90.o(proxyDetector, "proxyDetector not set");
            this.f162a = (vo0) v90.o(syncContext, "syncContext not set");
            this.f157a = (f) v90.o(serviceConfigParser, "serviceConfigParser not set");
            this.f160a = scheduledExecutorService;
            this.f158a = channelLogger;
            this.f159a = executor;
        }

        public int a() {
            return this.a;
        }

        public pb0 c() {
            return this.f161a;
        }

        public vo0 e() {
            return this.f162a;
        }

        public f d() {
            return this.f157a;
        }

        public Executor b() {
            return this.f159a;
        }

        public String toString() {
            return f20.c(this).b("defaultPort", this.a).d("proxyDetector", this.f161a).d("syncContext", this.f162a).d("serviceConfigParser", this.f157a).d("scheduledExecutorService", this.f160a).d("channelLogger", this.f158a).d("executor", this.f159a).toString();
        }

        public static C0004a f() {
            return new C0004a();
        }

        /* renamed from: b30$a$a  reason: collision with other inner class name */
        public static final class C0004a {
            private f a;

            /* renamed from: a  reason: collision with other field name */
            private io.grpc.a f163a;

            /* renamed from: a  reason: collision with other field name */
            private Integer f164a;

            /* renamed from: a  reason: collision with other field name */
            private Executor f165a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledExecutorService f166a;

            /* renamed from: a  reason: collision with other field name */
            private pb0 f167a;

            /* renamed from: a  reason: collision with other field name */
            private vo0 f168a;

            C0004a() {
            }

            public C0004a c(int defaultPort) {
                this.f164a = Integer.valueOf(defaultPort);
                return this;
            }

            public C0004a e(pb0 proxyDetector) {
                this.f167a = (pb0) v90.n(proxyDetector);
                return this;
            }

            public C0004a h(vo0 syncContext) {
                this.f168a = (vo0) v90.n(syncContext);
                return this;
            }

            public C0004a f(ScheduledExecutorService scheduledExecutorService) {
                this.f166a = (ScheduledExecutorService) v90.n(scheduledExecutorService);
                return this;
            }

            public C0004a g(f parser) {
                this.a = (f) v90.n(parser);
                return this;
            }

            public C0004a b(io.grpc.a channelLogger) {
                this.f163a = (io.grpc.a) v90.n(channelLogger);
                return this;
            }

            public C0004a d(Executor executor) {
                this.f165a = executor;
                return this;
            }

            public a a() {
                return new a(this.f164a, this.f167a, this.f168a, this.a, this.f166a, this.f163a, this.f165a, (a30) null);
            }
        }
    }

    /* renamed from: b30$e */
    public static final class e {
        private final b a;

        /* renamed from: a  reason: collision with other field name */
        private final List<ti> f170a;

        /* renamed from: a  reason: collision with other field name */
        private final v4 f171a;

        e(List<ti> addresses, v4 attributes, b serviceConfig) {
            this.f170a = Collections.unmodifiableList(new ArrayList(addresses));
            this.f171a = (v4) v90.o(attributes, "attributes");
            this.a = serviceConfig;
        }

        public static a d() {
            return new a();
        }

        public List<ti> a() {
            return this.f170a;
        }

        public v4 b() {
            return this.f171a;
        }

        public b c() {
            return this.a;
        }

        public String toString() {
            return f20.c(this).d("addresses", this.f170a).d("attributes", this.f171a).d("serviceConfig", this.a).toString();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e that = (e) obj;
            if (!f40.a(this.f170a, that.f170a) || !f40.a(this.f171a, that.f171a) || !f40.a(this.a, that.a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return f40.b(this.f170a, this.f171a, this.a);
        }

        /* renamed from: b30$e$a */
        public static final class a {
            private b a;

            /* renamed from: a  reason: collision with other field name */
            private List<ti> f172a = Collections.emptyList();

            /* renamed from: a  reason: collision with other field name */
            private v4 f173a = v4.a;

            a() {
            }

            public a b(List<ti> addresses) {
                this.f172a = addresses;
                return this;
            }

            public a c(v4 attributes) {
                this.f173a = attributes;
                return this;
            }

            public a d(b serviceConfig) {
                this.a = serviceConfig;
                return this;
            }

            public e a() {
                return new e(this.f172a, this.f173a, this.a);
            }
        }
    }

    /* renamed from: b30$b */
    public static final class b {
        private final p a;

        /* renamed from: a  reason: collision with other field name */
        private final Object f169a;

        public static b a(Object config) {
            return new b(config);
        }

        public static b b(p status) {
            return new b(status);
        }

        private b(Object config) {
            this.f169a = v90.o(config, "config");
            this.a = null;
        }

        private b(p status) {
            this.f169a = null;
            this.a = (p) v90.o(status, NotificationCompat.CATEGORY_STATUS);
            v90.j(!status.o(), "cannot use OK status: %s", status);
        }

        public Object c() {
            return this.f169a;
        }

        public p d() {
            return this.a;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            b that = (b) o;
            if (!f40.a(this.a, that.a) || !f40.a(this.f169a, that.f169a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return f40.b(this.a, this.f169a);
        }

        public String toString() {
            if (this.f169a != null) {
                return f20.c(this).d("config", this.f169a).toString();
            }
            if (this.a != null) {
                return f20.c(this).d("error", this.a).toString();
            }
            throw new AssertionError();
        }
    }
}
