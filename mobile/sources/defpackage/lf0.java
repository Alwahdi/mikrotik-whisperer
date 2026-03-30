package defpackage;

/* renamed from: lf0  reason: default package */
final class lf0 extends ud0<Runnable> {
    lf0(Runnable value) {
        super(value);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void b(Runnable value) {
        value.run();
    }

    public String toString() {
        return "RunnableDisposable(disposed=" + a() + ", " + get() + ")";
    }
}
