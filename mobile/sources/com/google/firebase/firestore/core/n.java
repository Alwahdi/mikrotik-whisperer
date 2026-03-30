package com.google.firebase.firestore.core;

final /* synthetic */ class n implements Runnable {
    private final q a;

    /* renamed from: a  reason: collision with other field name */
    private final y f2223a;

    private n(q qVar, y yVar) {
        this.a = qVar;
        this.f2223a = yVar;
    }

    public static Runnable a(q qVar, y yVar) {
        return new n(qVar, yVar);
    }

    public void run() {
        this.a.f2226a.f(this.f2223a);
    }
}
