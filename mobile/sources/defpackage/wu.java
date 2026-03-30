package defpackage;

/* renamed from: wu  reason: default package */
final class wu extends lv {
    private final vn<Throwable, jt0> a;

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        s((Throwable) p1);
        return jt0.a;
    }

    public wu(vn<? super Throwable, jt0> handler) {
        this.a = handler;
    }

    public void s(Throwable cause) {
        this.a.invoke(cause);
    }
}
