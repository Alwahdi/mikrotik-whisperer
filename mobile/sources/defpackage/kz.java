package defpackage;

import defpackage.iz;

/* renamed from: kz  reason: default package */
final /* synthetic */ class kz implements Runnable {
    private final iz.d a;

    private kz(iz.d dVar) {
        this.a = dVar;
    }

    public static Runnable a(iz.d dVar) {
        return new kz(dVar);
    }

    public void run() {
        iz.d.a(this.a);
    }
}
