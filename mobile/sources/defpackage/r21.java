package defpackage;

/* renamed from: r21  reason: default package */
final class r21 extends t11<Object> {
    private final transient int a;
    private final transient int b;

    /* renamed from: b  reason: collision with other field name */
    private final transient Object[] f4874b;

    r21(Object[] objArr, int i, int i2) {
        this.f4874b = objArr;
        this.a = i;
        this.b = i2;
    }

    public final Object get(int i) {
        t01.a(i, this.b);
        return this.f4874b[(i * 2) + this.a];
    }

    public final int size() {
        return this.b;
    }
}
