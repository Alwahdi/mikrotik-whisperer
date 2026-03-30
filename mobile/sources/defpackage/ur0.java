package defpackage;

import android.window.OnBackInvokedCallback;

/* renamed from: ur0  reason: default package */
public final /* synthetic */ class ur0 implements OnBackInvokedCallback {
    public final /* synthetic */ Runnable a;

    public /* synthetic */ ur0(Runnable runnable) {
        this.a = runnable;
    }

    public final void onBackInvoked() {
        this.a.run();
    }
}
