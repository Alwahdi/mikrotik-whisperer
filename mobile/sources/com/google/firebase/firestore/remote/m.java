package com.google.firebase.firestore.remote;

import io.grpc.b;

final /* synthetic */ class m implements o40 {
    private final n a;

    /* renamed from: a  reason: collision with other field name */
    private final w f2352a;

    /* renamed from: a  reason: collision with other field name */
    private final b[] f2353a;

    private m(n nVar, b[] bVarArr, w wVar) {
        this.a = nVar;
        this.f2353a = bVarArr;
        this.f2352a = wVar;
    }

    public static o40 b(n nVar, b[] bVarArr, w wVar) {
        return new m(nVar, bVarArr, wVar);
    }

    public void a(eq0 eq0) {
        n.c(this.a, this.f2353a, this.f2352a, eq0);
    }
}
