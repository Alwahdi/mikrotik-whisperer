package com.google.android.datatransport.cct.a;

public final class m implements y30<f> {
    public void a(Object obj, Object obj2) {
        f fVar = (f) obj;
        z30 z30 = (z30) obj2;
        if (fVar.c() != null) {
            z30.b("clientType", fVar.c().name());
        }
        if (fVar.b() != null) {
            z30.b("androidClientInfo", fVar.b());
        }
    }
}
