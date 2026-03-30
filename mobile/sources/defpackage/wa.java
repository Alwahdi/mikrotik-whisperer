package defpackage;

/* renamed from: wa  reason: default package */
public final class wa {
    public final Object a;

    /* renamed from: a  reason: collision with other field name */
    public final vn<Throwable, jt0> f5472a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wa)) {
            return false;
        }
        wa waVar = (wa) obj;
        return lu.a(this.a, waVar.a) && lu.a(this.f5472a, waVar.f5472a);
    }

    public int hashCode() {
        Object obj = this.a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f5472a.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.a + ", onCancellation=" + this.f5472a + ')';
    }

    public wa(Object result, vn<? super Throwable, jt0> onCancellation) {
        this.a = result;
        this.f5472a = onCancellation;
    }
}
