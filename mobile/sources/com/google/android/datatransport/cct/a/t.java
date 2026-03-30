package com.google.android.datatransport.cct.a;

public final class t implements y30<i> {
    public void a(Object obj, Object obj2) {
        i iVar = (i) obj;
        z30 z30 = (z30) obj2;
        if (iVar.b() != null) {
            z30.b("mobileSubtype", iVar.b().name());
        }
        if (iVar.c() != null) {
            z30.b("networkType", iVar.c().name());
        }
    }
}
