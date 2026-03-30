package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ View a;

    public /* synthetic */ a(View view) {
        this.a = view;
    }

    public final void run() {
        ((InputMethodManager) this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 0);
    }
}
