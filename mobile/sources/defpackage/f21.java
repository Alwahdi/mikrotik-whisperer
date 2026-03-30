package defpackage;

/* renamed from: f21  reason: default package */
final class f21<E> extends t11<E> {
    static final t11<Object> a = new f21(new Object[0], 0);

    /* renamed from: a  reason: collision with other field name */
    private final transient int f2942a;
    private final transient Object[] b;

    f21(Object[] objArr, int i) {
        this.b = objArr;
        this.f2942a = i;
    }

    public final int size() {
        return this.f2942a;
    }

    /* access modifiers changed from: package-private */
    public final Object[] d() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public final int f() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int h() {
        return this.f2942a;
    }

    /* access modifiers changed from: package-private */
    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.b, 0, objArr, i, this.f2942a);
        return i + this.f2942a;
    }

    public final E get(int i) {
        t01.a(i, this.f2942a);
        return this.b[i];
    }
}
