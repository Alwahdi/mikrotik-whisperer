package defpackage;

import java.util.List;

/* renamed from: hy  reason: default package */
final /* synthetic */ class hy implements Runnable {
    private final List a;

    /* renamed from: a  reason: collision with other field name */
    private final ky f3183a;

    private hy(ky kyVar, List list) {
        this.f3183a = kyVar;
        this.a = list;
    }

    public static Runnable a(ky kyVar, List list) {
        return new hy(kyVar, list);
    }

    public void run() {
        ky.p(this.f3183a, this.a);
    }
}
