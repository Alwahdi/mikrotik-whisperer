package defpackage;

/* renamed from: em0  reason: default package */
final class em0<E> extends cs<E> {
    private transient int a;

    /* renamed from: a  reason: collision with other field name */
    final transient E f2917a;

    em0(E element) {
        this.f2917a = v90.n(element);
    }

    em0(E element, int hashCode) {
        this.f2917a = element;
        this.a = hashCode;
    }

    public int size() {
        return 1;
    }

    public boolean contains(Object target) {
        return this.f2917a.equals(target);
    }

    /* renamed from: t */
    public lt0<E> iterator() {
        return zu.c(this.f2917a);
    }

    /* access modifiers changed from: package-private */
    public bs<E> o() {
        return bs.r(this.f2917a);
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public int a(Object[] dst, int offset) {
        dst[offset] = this.f2917a;
        return offset + 1;
    }

    public final int hashCode() {
        int code = this.a;
        if (code != 0) {
            return code;
        }
        int hashCode = this.f2917a.hashCode();
        int code2 = hashCode;
        this.a = hashCode;
        return code2;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.a != 0;
    }

    public String toString() {
        return '[' + this.f2917a.toString() + ']';
    }
}
