package com.google.firebase.firestore.remote;

final /* synthetic */ class q implements Runnable {
    private final v a;

    /* renamed from: a  reason: collision with other field name */
    private final rz f2364a;

    private q(v vVar, rz rzVar) {
        this.a = vVar;
        this.f2364a = rzVar;
    }

    public static Runnable a(v vVar, rz rzVar) {
        return new q(vVar, rzVar);
    }

    public void run() {
        v.g(this.a, this.f2364a);
    }
}
