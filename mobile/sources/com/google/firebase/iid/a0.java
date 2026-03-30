package com.google.firebase.iid;

final /* synthetic */ class a0 implements g {
    private final FirebaseInstanceId a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2412a;
    private final String b;
    private final String c;

    a0(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.a = firebaseInstanceId;
        this.f2412a = str;
        this.b = str2;
        this.c = str3;
    }

    public final eq0 a() {
        return this.a.i(this.f2412a, this.b, this.c);
    }
}
