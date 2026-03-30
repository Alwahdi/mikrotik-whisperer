package defpackage;

import androidx.fragment.app.FragmentActivity;

/* renamed from: o0  reason: default package */
final /* synthetic */ class o0 implements Runnable {
    private final FragmentActivity a;

    /* renamed from: a  reason: collision with other field name */
    private final Runnable f4475a;

    private o0(FragmentActivity fragmentActivity, Runnable runnable) {
        this.a = fragmentActivity;
        this.f4475a = runnable;
    }

    public static Runnable a(FragmentActivity fragmentActivity, Runnable runnable) {
        return new o0(fragmentActivity, runnable);
    }

    public void run() {
        r0.d(this.a, this.f4475a);
    }
}
