package com.google.android.datatransport.cct.a;

public final class p implements y30<g> {
    public void a(Object obj, Object obj2) {
        g gVar = (g) obj;
        z30 z30 = (z30) obj2;
        z30.c("eventTimeMs", gVar.a()).c("eventUptimeMs", gVar.d()).c("timezoneOffsetSeconds", gVar.e());
        if (gVar.h() != null) {
            z30.b("sourceExtension", gVar.h());
        }
        if (gVar.i() != null) {
            z30.b("sourceExtensionJsonProto3", gVar.i());
        }
        if (gVar.f() != Integer.MIN_VALUE) {
            z30.e("eventCode", gVar.f());
        }
        if (gVar.g() != null) {
            z30.b("networkConnectionInfo", gVar.g());
        }
    }
}
