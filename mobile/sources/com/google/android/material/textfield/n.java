package com.google.android.material.textfield;

import androidx.core.view.accessibility.AccessibilityManagerCompat;

public final /* synthetic */ class n implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {
    public final /* synthetic */ p a;

    public /* synthetic */ n(p pVar) {
        this.a = pVar;
    }

    public final void onTouchExplorationStateChanged(boolean z) {
        this.a.L(z);
    }
}
