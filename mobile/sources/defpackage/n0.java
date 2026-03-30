package defpackage;

import android.app.Activity;

/* renamed from: n0  reason: default package */
final /* synthetic */ class n0 implements Runnable {
    private final Activity a;

    /* renamed from: a  reason: collision with other field name */
    private final Runnable f4393a;

    private n0(Activity activity, Runnable runnable) {
        this.a = activity;
        this.f4393a = runnable;
    }

    public static Runnable a(Activity activity, Runnable runnable) {
        return new n0(activity, runnable);
    }

    public void run() {
        r0.c(this.a, this.f4393a);
    }
}
