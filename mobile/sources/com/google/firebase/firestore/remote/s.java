package com.google.firebase.firestore.remote;

final /* synthetic */ class s implements Runnable {
    private final v a;

    /* renamed from: a  reason: collision with other field name */
    private final rz f2366a;

    private s(v vVar, rz rzVar) {
        this.a = vVar;
        this.f2366a = rzVar;
    }

    public static Runnable a(v vVar, rz rzVar) {
        return new s(vVar, rzVar);
    }

    public void run() {
        v.j(this.a, this.f2366a);
    }
}
