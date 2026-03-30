package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

final /* synthetic */ class r implements Runnable {
    private final Intent a;

    /* renamed from: a  reason: collision with other field name */
    private final s f2447a;

    r(s sVar, Intent intent) {
        this.f2447a = sVar;
        this.a = intent;
    }

    public final void run() {
        s sVar = this.f2447a;
        String action = this.a.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        sVar.a();
    }
}
