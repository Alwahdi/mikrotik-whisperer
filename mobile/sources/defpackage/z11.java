package defpackage;

/* renamed from: z11  reason: default package */
final class z11<E> extends p11<E> {
    private final t11<E> a;

    z11(t11<E> t11, int i) {
        super(t11.size(), i);
        this.a = t11;
    }

    /* access modifiers changed from: protected */
    public final E a(int i) {
        return this.a.get(i);
    }
}
