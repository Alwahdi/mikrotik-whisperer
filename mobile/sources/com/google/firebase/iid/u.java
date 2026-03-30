package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

final /* synthetic */ class u implements ThreadFactory {
    static final ThreadFactory a = new u();

    private u() {
    }

    public final Thread newThread(Runnable runnable) {
        return a.a(runnable);
    }
}
