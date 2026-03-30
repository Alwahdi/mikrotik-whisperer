package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: v9  reason: default package */
public abstract class v9 {
    private static final qo0<long[]> a = new a();
    private static final qo0<double[]> b = new e();

    /* renamed from: v9$a */
    static class a implements qo0<long[]> {
        a() {
        }

        /* renamed from: a */
        public long[] get() {
            return new long[]{0, 0};
        }
    }

    /* renamed from: v9$e */
    static class e implements qo0<double[]> {
        e() {
        }

        /* renamed from: a */
        public double[] get() {
            return new double[]{0.0d, 0.0d};
        }
    }

    public static <T> u9<T, ?, List<T>> d() {
        return new i(new g(), new h());
    }

    /* renamed from: v9$g */
    static class g implements qo0<List<T>> {
        g() {
        }

        /* renamed from: a */
        public List<T> get() {
            return new ArrayList();
        }
    }

    /* renamed from: v9$h */
    static class h implements g6<List<T>, T> {
        h() {
        }

        /* renamed from: b */
        public void a(List<T> t, T u) {
            t.add(u);
        }
    }

    public static <T> u9<T, ?, Long> c(rr0<? super T> mapper) {
        return new i(a, new b(mapper), new c());
    }

    /* renamed from: v9$b */
    static class b implements g6<long[], T> {
        final /* synthetic */ rr0 a;

        b(rr0 rr0) {
            this.a = rr0;
        }

        /* renamed from: b */
        public void a(long[] t, T u) {
            t[0] = t[0] + this.a.a(u);
        }
    }

    /* renamed from: v9$c */
    static class c implements uo<long[], Long> {
        c() {
        }

        /* renamed from: a */
        public Long apply(long[] value) {
            return Long.valueOf(value[0]);
        }
    }

    /* renamed from: v9$d */
    static class d implements rr0<T> {
        d() {
        }

        public long a(T t) {
            return 1;
        }
    }

    public static <T> u9<T, ?, Long> b() {
        return c(new d());
    }

    /* renamed from: v9$f */
    static class f implements uo<A, R> {
        f() {
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [A, R] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public R apply(A r1) {
            /*
                r0 = this;
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.v9.f.apply(java.lang.Object):java.lang.Object");
        }
    }

    static <A, R> uo<A, R> a() {
        return new f();
    }

    /* renamed from: v9$i */
    private static final class i<T, A, R> implements u9<T, A, R> {
        private final g6<A, T> a;

        /* renamed from: a  reason: collision with other field name */
        private final qo0<A> f5375a;

        /* renamed from: a  reason: collision with other field name */
        private final uo<A, R> f5376a;

        public i(qo0<A> supplier, g6<A, T> accumulator) {
            this(supplier, accumulator, v9.a());
        }

        public i(qo0<A> supplier, g6<A, T> accumulator, uo<A, R> finisher) {
            this.f5375a = supplier;
            this.a = accumulator;
            this.f5376a = finisher;
        }

        public qo0<A> b() {
            return this.f5375a;
        }

        public g6<A, T> a() {
            return this.a;
        }

        public uo<A, R> c() {
            return this.f5376a;
        }
    }
}
