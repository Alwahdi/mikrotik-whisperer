package com.google.firebase.firestore.util;

import java.util.concurrent.Callable;

final /* synthetic */ class a implements Callable {
    private final Runnable a;

    private a(Runnable runnable) {
        this.a = runnable;
    }

    public static Callable a(Runnable runnable) {
        return new a(runnable);
    }

    public Object call() {
        return this.a.run();
    }
}
