package defpackage;

/* renamed from: uu  reason: default package */
final class uu extends o7 {
    private final vn<Throwable, jt0> a;

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        b((Throwable) p1);
        return jt0.a;
    }

    public uu(vn<? super Throwable, jt0> handler) {
        this.a = handler;
    }

    public void b(Throwable cause) {
        this.a.invoke(cause);
    }

    public String toString() {
        return "InvokeOnCancel[" + ef.a(this.a) + '@' + ef.b(this) + ']';
    }
}
