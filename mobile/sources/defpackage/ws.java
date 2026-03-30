package defpackage;

/* renamed from: ws  reason: default package */
public final class ws<T> implements ik<T> {
    private static final ws<Object> a = new ws<>((Object) null);

    /* renamed from: a  reason: collision with other field name */
    private final T f5551a;

    public static <T> ik<T> a(T instance) {
        return new ws(x90.c(instance, "instance cannot be null"));
    }

    private ws(T instance) {
        this.f5551a = instance;
    }

    public T get() {
        return this.f5551a;
    }
}
