package defpackage;

import androidx.core.app.NotificationCompat;
import defpackage.a9;
import defpackage.v4;
import io.grpc.l;
import io.grpc.m;
import io.grpc.p;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: ux  reason: default package */
public abstract class ux {
    public static final v4.c<Map<String, ?>> a = v4.c.a("io.grpc.LoadBalancer.loadBalancingConfig");
    public static final v4.c<Map<String, ?>> b = v4.c.a("health-checking-config");

    /* renamed from: ux$c */
    public static abstract class c {
        public abstract ux a(d dVar);
    }

    /* renamed from: ux$d */
    public static abstract class d {
        public abstract h a(b bVar);

        public abstract io.grpc.a b();

        public abstract vo0 c();

        public abstract void d(io.grpc.e eVar, i iVar);
    }

    /* renamed from: ux$f */
    public static abstract class f {
        public abstract n7 a();

        public abstract l b();

        public abstract m<?, ?> c();
    }

    /* renamed from: ux$j */
    public interface j {
        void a(fc fcVar);
    }

    public abstract void b(p pVar);

    public abstract void c(g gVar);

    public abstract void e();

    /* renamed from: ux$g */
    public static final class g {
        private final Object a;

        /* renamed from: a  reason: collision with other field name */
        private final List<ti> f5286a;

        /* renamed from: a  reason: collision with other field name */
        private final v4 f5287a;

        private g(List<ti> addresses, v4 attributes, Object loadBalancingPolicyConfig) {
            this.f5286a = Collections.unmodifiableList(new ArrayList((Collection) v90.o(addresses, "addresses")));
            this.f5287a = (v4) v90.o(attributes, "attributes");
            this.a = loadBalancingPolicyConfig;
        }

        public static a d() {
            return new a();
        }

        public List<ti> a() {
            return this.f5286a;
        }

        public v4 b() {
            return this.f5287a;
        }

        public Object c() {
            return this.a;
        }

        /* renamed from: ux$g$a */
        public static final class a {
            private Object a;

            /* renamed from: a  reason: collision with other field name */
            private List<ti> f5288a;

            /* renamed from: a  reason: collision with other field name */
            private v4 f5289a = v4.a;

            a() {
            }

            public a b(List<ti> addresses) {
                this.f5288a = addresses;
                return this;
            }

            public a c(v4 attributes) {
                this.f5289a = attributes;
                return this;
            }

            public a d(Object loadBalancingPolicyConfig) {
                this.a = loadBalancingPolicyConfig;
                return this;
            }

            public g a() {
                return new g(this.f5288a, this.f5289a, this.a);
            }
        }

        public String toString() {
            return f20.c(this).d("addresses", this.f5286a).d("attributes", this.f5287a).d("loadBalancingPolicyConfig", this.a).toString();
        }

        public int hashCode() {
            return f40.b(this.f5286a, this.f5287a, this.a);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            g that = (g) obj;
            if (!f40.a(this.f5286a, that.f5286a) || !f40.a(this.f5287a, that.f5287a) || !f40.a(this.a, that.a)) {
                return false;
            }
            return true;
        }
    }

    public boolean a() {
        return false;
    }

    public void d() {
    }

    /* renamed from: ux$i */
    public static abstract class i {
        public abstract e a(f fVar);

        public void b() {
        }
    }

    /* renamed from: ux$e */
    public static final class e {
        private static final e a = new e((h) null, (a9.a) null, p.f3953a, false);

        /* renamed from: a  reason: collision with other field name */
        private final a9.a f5282a;

        /* renamed from: a  reason: collision with other field name */
        private final p f5283a;

        /* renamed from: a  reason: collision with other field name */
        private final h f5284a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean f5285a;

        private e(h subchannel, a9.a streamTracerFactory, p status, boolean drop) {
            this.f5284a = subchannel;
            this.f5282a = streamTracerFactory;
            this.f5283a = (p) v90.o(status, NotificationCompat.CATEGORY_STATUS);
            this.f5285a = drop;
        }

        public static e i(h subchannel, a9.a streamTracerFactory) {
            return new e((h) v90.o(subchannel, "subchannel"), streamTracerFactory, p.f3953a, false);
        }

        public static e h(h subchannel) {
            return i(subchannel, (a9.a) null);
        }

        public static e f(p error) {
            v90.e(!error.o(), "error status shouldn't be OK");
            return new e((h) null, (a9.a) null, error, false);
        }

        public static e e(p status) {
            v90.e(!status.o(), "drop status shouldn't be OK");
            return new e((h) null, (a9.a) null, status, true);
        }

        public static e g() {
            return a;
        }

        public h c() {
            return this.f5284a;
        }

        public a9.a b() {
            return this.f5282a;
        }

        public p a() {
            return this.f5283a;
        }

        public boolean d() {
            return this.f5285a;
        }

        public String toString() {
            return f20.c(this).d("subchannel", this.f5284a).d("streamTracerFactory", this.f5282a).d(NotificationCompat.CATEGORY_STATUS, this.f5283a).e("drop", this.f5285a).toString();
        }

        public int hashCode() {
            return f40.b(this.f5284a, this.f5283a, this.f5282a, Boolean.valueOf(this.f5285a));
        }

        public boolean equals(Object other) {
            if (!(other instanceof e)) {
                return false;
            }
            e that = (e) other;
            if (!f40.a(this.f5284a, that.f5284a) || !f40.a(this.f5283a, that.f5283a) || !f40.a(this.f5282a, that.f5282a) || this.f5285a != that.f5285a) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: ux$b */
    public static final class b {
        private final List<ti> a;

        /* renamed from: a  reason: collision with other field name */
        private final v4 f5278a;

        /* renamed from: a  reason: collision with other field name */
        private final Object[][] f5279a;

        private b(List<ti> addrs, v4 attrs, Object[][] customOptions) {
            this.a = (List) v90.o(addrs, "addresses are not set");
            this.f5278a = (v4) v90.o(attrs, "attrs");
            this.f5279a = (Object[][]) v90.o(customOptions, "customOptions");
        }

        public List<ti> a() {
            return this.a;
        }

        public v4 b() {
            return this.f5278a;
        }

        public static a c() {
            return new a();
        }

        public String toString() {
            return f20.c(this).d("addrs", this.a).d("attrs", this.f5278a).d("customOptions", Arrays.deepToString(this.f5279a)).toString();
        }

        /* renamed from: ux$b$a */
        public static final class a {
            private List<ti> a;

            /* renamed from: a  reason: collision with other field name */
            private v4 f5280a = v4.a;

            /* renamed from: a  reason: collision with other field name */
            private Object[][] f5281a = ((Object[][]) Array.newInstance(Object.class, new int[]{0, 2}));

            a() {
            }

            public a b(ti addrs) {
                this.a = Collections.singletonList(addrs);
                return this;
            }

            public a c(List<ti> addrs) {
                v90.e(!addrs.isEmpty(), "addrs is empty");
                this.a = Collections.unmodifiableList(new ArrayList(addrs));
                return this;
            }

            public a d(v4 attrs) {
                this.f5280a = (v4) v90.o(attrs, "attrs");
                return this;
            }

            public b a() {
                return new b(this.a, this.f5280a, this.f5281a);
            }
        }
    }

    /* renamed from: ux$h */
    public static abstract class h {
        public abstract List<ti> b();

        public abstract v4 c();

        public abstract Object d();

        public abstract void e();

        public abstract void f();

        public abstract void g(j jVar);

        public abstract void h(List<ti> list);

        public final ti a() {
            List<ti> b = b();
            boolean z = true;
            if (b.size() != 1) {
                z = false;
            }
            v90.w(z, "%s does not have exactly one group", b);
            return b.get(0);
        }
    }
}
