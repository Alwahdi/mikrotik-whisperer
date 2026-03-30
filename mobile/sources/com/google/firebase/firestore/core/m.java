package com.google.firebase.firestore.core;

final /* synthetic */ class m implements Runnable {
    private final q a;

    /* renamed from: a  reason: collision with other field name */
    private final y f2222a;

    private m(q qVar, y yVar) {
        this.a = qVar;
        this.f2222a = yVar;
    }

    public static Runnable a(q qVar, y yVar) {
        return new m(qVar, yVar);
    }

    public void run() {
        this.a.f2226a.d(this.f2222a);
    }
}
