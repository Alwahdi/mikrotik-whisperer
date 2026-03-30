package com.google.firebase.firestore.util;

final /* synthetic */ class b implements Runnable {
    private final Throwable a;

    private b(Throwable th) {
        this.a = th;
    }

    public static Runnable a(Throwable th) {
        return new b(th);
    }

    public void run() {
        c.k(this.a);
    }
}
