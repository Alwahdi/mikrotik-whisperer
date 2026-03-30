package com.google.firebase.firestore.remote;

final /* synthetic */ class u implements Runnable {
    private final v a;

    /* renamed from: a  reason: collision with other field name */
    private final rz f2367a;

    private u(v vVar, rz rzVar) {
        this.a = vVar;
        this.f2367a = rzVar;
    }

    public static Runnable a(v vVar, rz rzVar) {
        return new u(vVar, rzVar);
    }

    public void run() {
        this.a.k(this.f2367a);
    }
}
