package com.google.firebase.firestore.core;

import java.util.List;

final /* synthetic */ class i implements Runnable {
    private final q a;

    /* renamed from: a  reason: collision with other field name */
    private final gq0 f2213a;

    /* renamed from: a  reason: collision with other field name */
    private final List f2214a;

    private i(q qVar, List list, gq0 gq0) {
        this.a = qVar;
        this.f2214a = list;
        this.f2213a = gq0;
    }

    public static Runnable a(q qVar, List list, gq0 gq0) {
        return new i(qVar, list, gq0);
    }

    public void run() {
        this.a.f2225a.x(this.f2214a, this.f2213a);
    }
}
