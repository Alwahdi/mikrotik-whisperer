package defpackage;

/* renamed from: jy  reason: default package */
final /* synthetic */ class jy implements Runnable {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final ky f4096a;

    private jy(ky kyVar, int i) {
        this.f4096a = kyVar;
        this.a = i;
    }

    public static Runnable a(ky kyVar, int i) {
        return new jy(kyVar, i);
    }

    public void run() {
        ky.r(this.f4096a, this.a);
    }
}
