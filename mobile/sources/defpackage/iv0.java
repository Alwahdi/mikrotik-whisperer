package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: iv0  reason: default package */
public final class iv0 {
    public static final c a = new c((Cif) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static iv0 f3985a;

    /* renamed from: a  reason: collision with other field name */
    private static final rw f3986a = vw.a(b.a);

    /* renamed from: a  reason: collision with other field name */
    private final List<au> f3987a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f3988a;
    private final List<au> b;

    /* renamed from: b  reason: collision with other field name */
    private final boolean f3989b;
    private final boolean c;

    public static final a c() {
        return a.a();
    }

    public static final void e(iv0 iv0) {
        a.c(iv0);
    }

    private iv0(List<? extends au> interceptors, boolean isReflection, boolean isCustomViewCreation, boolean isStoreLayoutResId) {
        this.b = interceptors;
        this.f3988a = isReflection;
        this.f3989b = isCustomViewCreation;
        this.c = isStoreLayoutResId;
        this.f3987a = t9.q(t9.m(interceptors, new a()));
    }

    public /* synthetic */ iv0(List interceptors, boolean isReflection, boolean isCustomViewCreation, boolean isStoreLayoutResId, Cif $constructor_marker) {
        this(interceptors, isReflection, isCustomViewCreation, isStoreLayoutResId);
    }

    public final boolean g() {
        return this.f3988a;
    }

    public final boolean f() {
        return this.f3989b;
    }

    public final boolean h() {
        return this.c;
    }

    public final os d(ns originalRequest) {
        lu.g(originalRequest, "originalRequest");
        return new b(this.f3987a, 0, originalRequest).a(originalRequest);
    }

    /* renamed from: iv0$a */
    public static final class a {
        private final List<au> a = new ArrayList();

        /* renamed from: a  reason: collision with other field name */
        private boolean f3990a = true;
        private boolean b = true;
        private boolean c;

        public final a a(au interceptor) {
            lu.g(interceptor, "interceptor");
            this.a.add(interceptor);
            return this;
        }

        public final iv0 b() {
            return new iv0(t9.o(this.a), this.f3990a, this.b, this.c, (Cif) null);
        }
    }

    /* renamed from: iv0$c */
    public static final class c {
        static final /* synthetic */ fw[] a = {xd0.e(new hb0(xd0.b(c.class), "reflectiveFallbackViewCreator", "getReflectiveFallbackViewCreator()Lio/github/inflationx/viewpump/FallbackViewCreator;"))};

        private c() {
        }

        public /* synthetic */ c(Cif $constructor_marker) {
            this();
        }

        public final void c(iv0 viewPump) {
            iv0.f3985a = viewPump;
        }

        public final iv0 b() {
            iv0 a2 = iv0.f3985a;
            if (a2 != null) {
                return a2;
            }
            iv0 it = a().b();
            iv0.f3985a = it;
            return it;
        }

        public final a a() {
            return new a();
        }
    }

    /* renamed from: iv0$b */
    static final class b extends ow implements tn<d> {
        public static final b a = new b();

        b() {
            super(0);
        }

        /* renamed from: b */
        public final d invoke() {
            return new d();
        }
    }
}
