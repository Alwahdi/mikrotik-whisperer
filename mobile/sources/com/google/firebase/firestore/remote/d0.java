package com.google.firebase.firestore.remote;

final /* synthetic */ class d0 implements Runnable {
    private final e0 a;

    private d0(e0 e0Var) {
        this.a = e0Var;
    }

    public static Runnable a(e0 e0Var) {
        return new d0(e0Var);
    }

    public void run() {
        e0.z(this.a);
    }
}
