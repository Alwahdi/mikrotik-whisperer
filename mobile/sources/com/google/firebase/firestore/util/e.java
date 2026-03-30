package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.c;
import java.lang.Thread;

final /* synthetic */ class e implements Thread.UncaughtExceptionHandler {
    private final c.C0026c a;

    private e(c.C0026c cVar) {
        this.a = cVar;
    }

    public static Thread.UncaughtExceptionHandler a(c.C0026c cVar) {
        return new e(cVar);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        c.this.l(th);
    }
}
