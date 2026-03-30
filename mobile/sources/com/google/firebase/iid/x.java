package com.google.firebase.iid;

final /* synthetic */ class x implements sc {
    private final FirebaseInstanceId a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2452a;
    private final String b;

    x(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.a = firebaseInstanceId;
        this.f2452a = str;
        this.b = str2;
    }

    public final Object a(eq0 eq0) {
        return this.a.h(this.f2452a, this.b, eq0);
    }
}
