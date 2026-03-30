package defpackage;

import java.io.Serializable;

/* renamed from: se0  reason: default package */
public abstract class se0<T> implements Serializable {
    public static final a a = new a((Cif) null);

    public static <T> Object a(Object obj) {
        return obj;
    }

    public static final boolean d(Object arg0) {
        return !(arg0 instanceof b);
    }

    public static final boolean c(Object arg0) {
        return arg0 instanceof b;
    }

    public static final Throwable b(Object arg0) {
        if (arg0 instanceof b) {
            return ((b) arg0).a;
        }
        return null;
    }

    /* renamed from: se0$a */
    public static final class a {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: se0$b */
    public static final class b implements Serializable {
        public final Throwable a;

        public b(Throwable exception) {
            lu.f(exception, "exception");
            this.a = exception;
        }

        public boolean equals(Object other) {
            return (other instanceof b) && lu.a(this.a, ((b) other).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.a + ')';
        }
    }
}
