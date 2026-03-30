package defpackage;

import android.content.Context;

/* renamed from: rd  reason: default package */
public abstract class rd {
    public abstract Context b();

    public abstract String c();

    public abstract c9 d();

    public abstract c9 e();

    public static rd a(Context applicationContext, c9 wallClock, c9 monotonicClock, String backendName) {
        return new y4(applicationContext, wallClock, monotonicClock, backendName);
    }
}
