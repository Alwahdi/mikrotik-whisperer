package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class a implements OnBackInvokedCallback {
    public final /* synthetic */ AppCompatDelegateImpl a;

    public /* synthetic */ a(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.a = appCompatDelegateImpl;
    }

    public final void onBackInvoked() {
        this.a.onBackPressed();
    }
}
