package defpackage;

import java.util.Comparator;

/* renamed from: ph  reason: default package */
class ph {
    static final Comparator<ph> a = nh.a();
    static final Comparator<ph> b = oh.a();

    /* renamed from: a  reason: collision with other field name */
    private final int f4713a;

    /* renamed from: a  reason: collision with other field name */
    private final mh f4714a;

    public ph(mh key, int targetOrBatchId) {
        this.f4714a = key;
        this.f4713a = targetOrBatchId;
    }

    /* access modifiers changed from: package-private */
    public mh b() {
        return this.f4714a;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f4713a;
    }

    static /* synthetic */ int c(ph o1, ph o2) {
        int keyComp = o1.f4714a.compareTo(o2.f4714a);
        if (keyComp != 0) {
            return keyComp;
        }
        return qu0.d(o1.f4713a, o2.f4713a);
    }

    static /* synthetic */ int d(ph o1, ph o2) {
        int targetComp = qu0.d(o1.f4713a, o2.f4713a);
        if (targetComp != 0) {
            return targetComp;
        }
        return o1.f4714a.compareTo(o2.f4714a);
    }
}
