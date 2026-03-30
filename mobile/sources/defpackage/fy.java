package defpackage;

import com.google.protobuf.e;

/* renamed from: fy  reason: default package */
final /* synthetic */ class fy implements Runnable {
    private final e a;

    /* renamed from: a  reason: collision with other field name */
    private final ky f2999a;

    private fy(ky kyVar, e eVar) {
        this.f2999a = kyVar;
        this.a = eVar;
    }

    public static Runnable a(ky kyVar, e eVar) {
        return new fy(kyVar, eVar);
    }

    public void run() {
        this.f2999a.f4181a.f(this.a);
    }
}
