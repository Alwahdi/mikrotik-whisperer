package defpackage;

import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: ev0  reason: default package */
public final /* synthetic */ class ev0 implements View.OnUnhandledKeyEventListener {
    public final /* synthetic */ ViewCompat.OnUnhandledKeyEventListenerCompat a;

    public /* synthetic */ ev0(ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        this.a = onUnhandledKeyEventListenerCompat;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.a.onUnhandledKeyEvent(view, keyEvent);
    }
}
