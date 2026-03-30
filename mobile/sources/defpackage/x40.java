package defpackage;

import java.util.NoSuchElementException;

/* renamed from: x40  reason: default package */
public class x40<T> {
    private static final x40<?> a = new x40<>();

    /* renamed from: a  reason: collision with other field name */
    private final T f5570a;

    public static <T> x40<T> d(T value) {
        return new x40<>(value);
    }

    public static <T> x40<T> a() {
        return a;
    }

    private x40() {
        this.f5570a = null;
    }

    private x40(T value) {
        this.f5570a = g40.c(value);
    }

    public T b() {
        return e();
    }

    public boolean c() {
        return this.f5570a != null;
    }

    public T e() {
        T t = this.f5570a;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x40)) {
            return false;
        }
        return g40.a(this.f5570a, ((x40) obj).f5570a);
    }

    public int hashCode() {
        return g40.b(this.f5570a);
    }

    public String toString() {
        T t = this.f5570a;
        if (t == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{t});
    }
}
