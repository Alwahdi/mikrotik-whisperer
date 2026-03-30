package com.google.firebase.firestore.remote;

final /* synthetic */ class r implements Runnable {
    private final v a;

    /* renamed from: a  reason: collision with other field name */
    private final rz f2365a;

    private r(v vVar, rz rzVar) {
        this.a = vVar;
        this.f2365a = rzVar;
    }

    public static Runnable a(v vVar, rz rzVar) {
        return new r(vVar, rzVar);
    }

    public void run() {
        this.a.f2370a.g(u.a(this.a, this.f2365a));
    }
}
