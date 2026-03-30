package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.b;
import io.grpc.l;

final /* synthetic */ class c implements Runnable {
    private final b.c a;

    /* renamed from: a  reason: collision with other field name */
    private final l f2313a;

    private c(b.c cVar, l lVar) {
        this.a = cVar;
        this.f2313a = lVar;
    }

    public static Runnable a(b.c cVar, l lVar) {
        return new c(cVar, lVar);
    }

    public void run() {
        b.c.f(this.a, this.f2313a);
    }
}
