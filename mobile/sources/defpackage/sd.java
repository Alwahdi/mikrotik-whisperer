package defpackage;

import android.content.Context;

/* renamed from: sd  reason: default package */
class sd {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final c9 f4981a;
    private final c9 b;

    sd(Context applicationContext, c9 wallClock, c9 monotonicClock) {
        this.a = applicationContext;
        this.f4981a = wallClock;
        this.b = monotonicClock;
    }

    /* access modifiers changed from: package-private */
    public rd a(String backendName) {
        return rd.a(this.a, this.f4981a, this.b, backendName);
    }
}
