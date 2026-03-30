package com.google.firebase.firestore.util;

final /* synthetic */ class g implements Runnable {
    private final h a;

    /* renamed from: a  reason: collision with other field name */
    private final Runnable f2392a;

    private g(h hVar, Runnable runnable) {
        this.a = hVar;
        this.f2392a = runnable;
    }

    public static Runnable a(h hVar, Runnable runnable) {
        return new g(hVar, runnable);
    }

    public void run() {
        h.d(this.a, this.f2392a);
    }
}
