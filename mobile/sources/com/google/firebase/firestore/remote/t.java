package com.google.firebase.firestore.remote;

import java.util.concurrent.Callable;

final /* synthetic */ class t implements Callable {
    private final v a;

    private t(v vVar) {
        this.a = vVar;
    }

    public static Callable a(v vVar) {
        return new t(vVar);
    }

    public Object call() {
        return v.f(this.a);
    }
}
