package com.google.firebase.firestore.remote;

final /* synthetic */ class x implements Runnable {
    private final y a;

    private x(y yVar) {
        this.a = yVar;
    }

    public static Runnable a(y yVar) {
        return new x(yVar);
    }

    public void run() {
        y.d(this.a);
    }
}
