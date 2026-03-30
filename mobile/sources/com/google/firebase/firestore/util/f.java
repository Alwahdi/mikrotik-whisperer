package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.c;
import java.util.concurrent.Callable;

final /* synthetic */ class f implements Runnable {
    private final gq0 a;

    /* renamed from: a  reason: collision with other field name */
    private final Callable f2391a;

    private f(gq0 gq0, Callable callable) {
        this.a = gq0;
        this.f2391a = callable;
    }

    public static Runnable a(gq0 gq0, Callable callable) {
        return new f(gq0, callable);
    }

    public void run() {
        c.C0026c.h(this.a, this.f2391a);
    }
}
