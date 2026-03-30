package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.b;

final /* synthetic */ class d implements Runnable {
    private final b.c a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f2315a;

    private d(b.c cVar, Object obj) {
        this.a = cVar;
        this.f2315a = obj;
    }

    public static Runnable a(b.c cVar, Object obj) {
        return new d(cVar, obj);
    }

    public void run() {
        b.c.g(this.a, this.f2315a);
    }
}
