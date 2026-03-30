package com.google.firebase.firestore.core;

import com.google.firebase.firestore.util.c;
import java.util.concurrent.atomic.AtomicBoolean;

final /* synthetic */ class l implements px {
    private final q a;

    /* renamed from: a  reason: collision with other field name */
    private final c f2219a;

    /* renamed from: a  reason: collision with other field name */
    private final gq0 f2220a;

    /* renamed from: a  reason: collision with other field name */
    private final AtomicBoolean f2221a;

    private l(q qVar, AtomicBoolean atomicBoolean, gq0 gq0, c cVar) {
        this.a = qVar;
        this.f2221a = atomicBoolean;
        this.f2220a = gq0;
        this.f2219a = cVar;
    }

    public static px b(q qVar, AtomicBoolean atomicBoolean, gq0 gq0, c cVar) {
        return new l(qVar, atomicBoolean, gq0, cVar);
    }

    public void a(Object obj) {
        q.o(this.a, this.f2221a, this.f2220a, this.f2219a, (yt0) obj);
    }
}
