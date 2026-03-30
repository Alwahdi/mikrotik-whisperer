package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.KeyEventDispatcher;

public final /* synthetic */ class b implements KeyEventDispatcher.Component {
    public final /* synthetic */ AppCompatDialog a;

    public /* synthetic */ b(AppCompatDialog appCompatDialog) {
        this.a = appCompatDialog;
    }

    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.superDispatchKeyEvent(keyEvent);
    }
}
