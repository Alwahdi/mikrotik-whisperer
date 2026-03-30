package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.Comparator;
import java.util.concurrent.Callable;

/* renamed from: yo  reason: default package */
public abstract class yo {
    public static final bz a = new c();

    /* renamed from: a  reason: collision with other field name */
    static final ga0<Object> f5907a = new m();

    /* renamed from: a  reason: collision with other field name */
    static final ic<Object> f5908a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final Runnable f5909a = new d();

    /* renamed from: a  reason: collision with other field name */
    static final Comparator<Object> f5910a = new j();

    /* renamed from: a  reason: collision with other field name */
    static final Callable<Object> f5911a = new k();

    /* renamed from: a  reason: collision with other field name */
    public static final k0 f5912a = new a();

    /* renamed from: a  reason: collision with other field name */
    static final mo<Object, Object> f5913a = new g();
    static final ga0<Object> b = new f();

    /* renamed from: b  reason: collision with other field name */
    public static final ic<Throwable> f5914b = new e();
    public static final ic<Throwable> c = new l();
    public static final ic<jo0> d = new i();

    public static <T> ic<T> b() {
        return f5908a;
    }

    public static <T> ga0<T> a() {
        return f5907a;
    }

    /* renamed from: yo$h */
    static final class h<T, U> implements Callable<U>, mo<T, U> {
        final U a;

        h(U value) {
            this.a = value;
        }

        public U call() {
            return this.a;
        }

        public U apply(T t) {
            return this.a;
        }
    }

    public static <T> Callable<T> c(T value) {
        return new h(value);
    }

    /* renamed from: yo$g */
    static final class g implements mo<Object, Object> {
        g() {
        }

        public Object apply(Object v) {
            return v;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* renamed from: yo$d */
    static final class d implements Runnable {
        d() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* renamed from: yo$a */
    static final class a implements k0 {
        a() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* renamed from: yo$b */
    static final class b implements ic<Object> {
        b() {
        }

        public void accept(Object v) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* renamed from: yo$e */
    static final class e implements ic<Throwable> {
        e() {
        }

        /* renamed from: a */
        public void accept(Throwable error) {
            of0.l(error);
        }
    }

    /* renamed from: yo$l */
    static final class l implements ic<Throwable> {
        l() {
        }

        /* renamed from: a */
        public void accept(Throwable error) {
            of0.l(new q40(error));
        }
    }

    /* renamed from: yo$c */
    static final class c implements bz {
        c() {
        }
    }

    /* renamed from: yo$m */
    static final class m implements ga0<Object> {
        m() {
        }

        public boolean test(Object o) {
            return true;
        }
    }

    /* renamed from: yo$f */
    static final class f implements ga0<Object> {
        f() {
        }

        public boolean test(Object o) {
            return false;
        }
    }

    /* renamed from: yo$k */
    static final class k implements Callable<Object> {
        k() {
        }

        public Object call() {
            return null;
        }
    }

    /* renamed from: yo$j */
    static final class j implements Comparator<Object> {
        j() {
        }

        public int compare(Object a, Object b) {
            return ((Comparable) a).compareTo(b);
        }
    }

    /* renamed from: yo$i */
    static final class i implements ic<jo0> {
        i() {
        }

        /* renamed from: a */
        public void accept(jo0 t) {
            t.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
