package com.google.firebase.firestore.core;

final /* synthetic */ class j implements Runnable {
    private final q a;

    /* renamed from: a  reason: collision with other field name */
    private final yt0 f2215a;

    private j(q qVar, yt0 yt0) {
        this.a = qVar;
        this.f2215a = yt0;
    }

    public static Runnable a(q qVar, yt0 yt0) {
        return new j(qVar, yt0);
    }

    public void run() {
        q.n(this.a, this.f2215a);
    }
}
