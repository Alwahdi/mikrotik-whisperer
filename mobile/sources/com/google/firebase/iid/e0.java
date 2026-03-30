package com.google.firebase.iid;

import android.os.Bundle;

final /* synthetic */ class e0 implements Runnable {
    private final Bundle a;

    /* renamed from: a  reason: collision with other field name */
    private final c0 f2420a;

    /* renamed from: a  reason: collision with other field name */
    private final gq0 f2421a;

    e0(c0 c0Var, Bundle bundle, gq0 gq0) {
        this.f2420a = c0Var;
        this.a = bundle;
        this.f2421a = gq0;
    }

    public final void run() {
        this.f2420a.f(this.a, this.f2421a);
    }
}
