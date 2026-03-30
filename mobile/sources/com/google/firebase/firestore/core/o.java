package com.google.firebase.firestore.core;

import java.util.concurrent.Callable;

final /* synthetic */ class o implements Callable {
    private final q a;

    /* renamed from: a  reason: collision with other field name */
    private final mh f2224a;

    private o(q qVar, mh mhVar) {
        this.a = qVar;
        this.f2224a = mhVar;
    }

    public static Callable a(q qVar, mh mhVar) {
        return new o(qVar, mhVar);
    }

    public Object call() {
        return this.a.f2231a.w(this.f2224a);
    }
}
