package com.google.firebase.firestore.core;

import android.content.Context;
import com.google.firebase.firestore.j;

final /* synthetic */ class k implements Runnable {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final q f2216a;

    /* renamed from: a  reason: collision with other field name */
    private final j f2217a;

    /* renamed from: a  reason: collision with other field name */
    private final gq0 f2218a;

    private k(q qVar, gq0 gq0, Context context, j jVar) {
        this.f2216a = qVar;
        this.f2218a = gq0;
        this.a = context;
        this.f2217a = jVar;
    }

    public static Runnable a(q qVar, gq0 gq0, Context context, j jVar) {
        return new k(qVar, gq0, context, jVar);
    }

    public void run() {
        q.m(this.f2216a, this.f2218a, this.a, this.f2217a);
    }
}
