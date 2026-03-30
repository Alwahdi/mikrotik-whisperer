package com.google.firebase.iid;

final /* synthetic */ class z implements lo0 {
    private final FirebaseInstanceId a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2453a;
    private final String b;
    private final String c;

    z(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.a = firebaseInstanceId;
        this.f2453a = str;
        this.b = str2;
        this.c = str3;
    }

    public final eq0 a(Object obj) {
        return this.a.j(this.f2453a, this.b, this.c, (String) obj);
    }
}
