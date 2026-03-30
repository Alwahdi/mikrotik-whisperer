package com.google.firebase.iid;

import java.util.concurrent.Executor;

final /* synthetic */ class t implements Executor {
    static final Executor a = new t();

    private t() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
