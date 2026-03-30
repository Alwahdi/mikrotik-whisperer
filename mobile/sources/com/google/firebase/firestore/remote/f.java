package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.b;
import io.grpc.p;

final /* synthetic */ class f implements Runnable {
    private final b.c a;

    /* renamed from: a  reason: collision with other field name */
    private final p f2326a;

    private f(b.c cVar, p pVar) {
        this.a = cVar;
        this.f2326a = pVar;
    }

    public static Runnable a(b.c cVar, p pVar) {
        return new f(cVar, pVar);
    }

    public void run() {
        b.c.e(this.a, this.f2326a);
    }
}
