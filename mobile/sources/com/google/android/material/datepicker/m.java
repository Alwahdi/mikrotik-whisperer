package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

abstract class m<S> extends Fragment {
    protected final LinkedHashSet<s40<S>> a = new LinkedHashSet<>();

    m() {
    }

    /* access modifiers changed from: package-private */
    public boolean i(s40<S> listener) {
        return this.a.add(listener);
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.a.clear();
    }
}
