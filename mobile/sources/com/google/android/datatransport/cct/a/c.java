package com.google.android.datatransport.cct.a;

public final class c implements y30<d> {
    public void a(Object obj, Object obj2) {
        d dVar = (d) obj;
        z30 z30 = (z30) obj2;
        if (dVar.i() != Integer.MIN_VALUE) {
            z30.e("sdkVersion", dVar.i());
        }
        if (dVar.f() != null) {
            z30.b("model", dVar.f());
        }
        if (dVar.d() != null) {
            z30.b("hardware", dVar.d());
        }
        if (dVar.b() != null) {
            z30.b("device", dVar.b());
        }
        if (dVar.h() != null) {
            z30.b("product", dVar.h());
        }
        if (dVar.g() != null) {
            z30.b("osBuild", dVar.g());
        }
        if (dVar.e() != null) {
            z30.b("manufacturer", dVar.e());
        }
        if (dVar.c() != null) {
            z30.b("fingerprint", dVar.c());
        }
    }
}
