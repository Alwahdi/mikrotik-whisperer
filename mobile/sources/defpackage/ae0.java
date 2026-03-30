package defpackage;

/* renamed from: ae0  reason: default package */
final class ae0<E> extends cs<E> {
    static final ae0<Object> a = new ae0(new Object[0], 0, (Object[]) null, 0, 0);

    /* renamed from: a  reason: collision with other field name */
    private final transient int f56a;
    private final transient int b;

    /* renamed from: b  reason: collision with other field name */
    final transient Object[] f57b;
    private final transient int c;

    /* renamed from: c  reason: collision with other field name */
    final transient Object[] f58c;

    ae0(Object[] elements, int hashCode, Object[] table, int mask, int size) {
        this.f57b = elements;
        this.f58c = table;
        this.f56a = mask;
        this.b = hashCode;
        this.c = size;
    }

    public boolean contains(Object target) {
        Object[] table = this.f58c;
        if (target == null || table == null) {
            return false;
        }
        int i = oq.b(target);
        while (true) {
            int i2 = i & this.f56a;
            Object candidate = table[i2];
            if (candidate == null) {
                return false;
            }
            if (candidate.equals(target)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public int size() {
        return this.c;
    }

    /* renamed from: t */
    public lt0<E> iterator() {
        return h().iterator();
    }

    /* access modifiers changed from: package-private */
    public Object[] b() {
        return this.f57b;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public int a(Object[] dst, int offset) {
        System.arraycopy(this.f57b, 0, dst, offset, this.c);
        return this.c + offset;
    }

    /* access modifiers changed from: package-private */
    public bs<E> o() {
        return bs.j(this.f57b, this.c);
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return false;
    }

    public int hashCode() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return true;
    }
}
