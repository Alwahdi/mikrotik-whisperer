package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;

final class i extends d51 {
    private final /* synthetic */ f a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    i(f fVar, Looper looper) {
        super(looper);
        this.a = fVar;
    }

    public final void handleMessage(Message message) {
        this.a.d(message);
    }
}
