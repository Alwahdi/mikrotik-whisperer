package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.c;

final /* synthetic */ class d implements Runnable {
    private final c.b a;

    private d(c.b bVar) {
        this.a = bVar;
    }

    public static Runnable a(c.b bVar) {
        return new d(bVar);
    }

    public void run() {
        this.a.d();
    }
}
