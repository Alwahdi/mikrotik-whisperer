package defpackage;

/* renamed from: pt0  reason: default package */
final /* synthetic */ class pt0 implements Runnable {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final es0 f4729a;

    /* renamed from: a  reason: collision with other field name */
    private final Runnable f4730a;

    /* renamed from: a  reason: collision with other field name */
    private final ut0 f4731a;

    private pt0(ut0 ut0, es0 es0, int i, Runnable runnable) {
        this.f4731a = ut0;
        this.f4729a = es0;
        this.a = i;
        this.f4730a = runnable;
    }

    public static Runnable a(ut0 ut0, es0 es0, int i, Runnable runnable) {
        return new pt0(ut0, es0, i, runnable);
    }

    public void run() {
        ut0.e(this.f4731a, this.f4729a, this.a, this.f4730a);
    }
}
