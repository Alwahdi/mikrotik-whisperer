package defpackage;

import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher;

/* renamed from: m40  reason: default package */
public final /* synthetic */ class m40 implements OnBackInvokedCallback {
    public final /* synthetic */ tn a;

    public /* synthetic */ m40(tn tnVar) {
        this.a = tnVar;
    }

    public final void onBackInvoked() {
        OnBackPressedDispatcher.Api33Impl.createOnBackInvokedCallback$lambda$0(this.a);
    }
}
