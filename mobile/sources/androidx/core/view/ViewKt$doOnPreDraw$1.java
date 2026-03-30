package androidx.core.view;

import android.view.View;

public final class ViewKt$doOnPreDraw$1 implements Runnable {
    final /* synthetic */ vn<View, jt0> $action;
    final /* synthetic */ View $this_doOnPreDraw;

    public ViewKt$doOnPreDraw$1(vn<? super View, jt0> vnVar, View view) {
        this.$action = vnVar;
        this.$this_doOnPreDraw = view;
    }

    public final void run() {
        this.$action.invoke(this.$this_doOnPreDraw);
    }
}
