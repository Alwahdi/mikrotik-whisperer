package com.google.android.datatransport.cct.a;

public final class r implements y30<h> {
    public void a(Object obj, Object obj2) {
        h hVar = (h) obj;
        z30 z30 = (z30) obj2;
        z30.c("requestTimeMs", hVar.f()).c("requestUptimeMs", hVar.g());
        if (hVar.b() != null) {
            z30.b("clientInfo", hVar.b());
        }
        if (hVar.e() != null) {
            z30.b("logSourceName", hVar.e());
        } else if (hVar.d() != Integer.MIN_VALUE) {
            z30.e("logSource", hVar.d());
        } else {
            throw new ri("Log request must have either LogSourceName or LogSource");
        }
        if (!hVar.c().isEmpty()) {
            z30.b("logEvent", hVar.c());
        }
    }
}
