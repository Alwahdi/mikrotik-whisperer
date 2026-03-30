package defpackage;

/* renamed from: zd0  reason: default package */
class zd0<E> extends bs<E> {
    static final bs<Object> a = new zd0(new Object[0], 0);

    /* renamed from: a  reason: collision with other field name */
    private final transient int f6021a;
    final transient Object[] b;

    zd0(Object[] array, int size) {
        this.b = array;
        this.f6021a = size;
    }

    public int size() {
        return this.f6021a;
    }

    /* access modifiers changed from: package-private */
    public Object[] b() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f6021a;
    }

    /* access modifiers changed from: package-private */
    public int a(Object[] dst, int dstOff) {
        System.arraycopy(this.b, 0, dst, dstOff, this.f6021a);
        return this.f6021a + dstOff;
    }

    public E get(int index) {
        v90.l(index, this.f6021a);
        return this.b[index];
    }
}
