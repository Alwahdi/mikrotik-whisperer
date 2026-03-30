package defpackage;

import java.util.concurrent.Callable;

/* renamed from: gj0  reason: default package */
public abstract class gj0 {
    static final bj0 a = of0.h(new h());
    static final bj0 b = of0.e(new b());
    static final bj0 c = of0.f(new c());
    static final bj0 d = wr0.d();
    static final bj0 e = of0.g(new f());

    /* renamed from: gj0$a */
    static final class a {
        static final bj0 a = new xb();
    }

    /* renamed from: gj0$d */
    static final class d {
        static final bj0 a = new xu();
    }

    /* renamed from: gj0$e */
    static final class e {
        static final bj0 a = new g30();
    }

    /* renamed from: gj0$g */
    static final class g {
        static final bj0 a = new am0();
    }

    public static bj0 a() {
        return of0.m(c);
    }

    /* renamed from: gj0$c */
    static final class c implements Callable<bj0> {
        c() {
        }

        /* renamed from: a */
        public bj0 call() {
            return d.a;
        }
    }

    /* renamed from: gj0$f */
    static final class f implements Callable<bj0> {
        f() {
        }

        /* renamed from: a */
        public bj0 call() {
            return e.a;
        }
    }

    /* renamed from: gj0$h */
    static final class h implements Callable<bj0> {
        h() {
        }

        /* renamed from: a */
        public bj0 call() {
            return g.a;
        }
    }

    /* renamed from: gj0$b */
    static final class b implements Callable<bj0> {
        b() {
        }

        /* renamed from: a */
        public bj0 call() {
            return a.a;
        }
    }
}
