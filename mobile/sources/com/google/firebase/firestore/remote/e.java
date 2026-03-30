package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.b;

final /* synthetic */ class e implements Runnable {
    private final b.c a;

    private e(b.c cVar) {
        this.a = cVar;
    }

    public static Runnable a(b.c cVar) {
        return new e(cVar);
    }

    public void run() {
        b.c.h(this.a);
    }
}
