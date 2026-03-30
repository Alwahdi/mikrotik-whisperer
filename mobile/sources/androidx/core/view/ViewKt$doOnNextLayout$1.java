package androidx.core.view;

import android.view.View;

public final class ViewKt$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ vn<View, jt0> $action;

    public ViewKt$doOnNextLayout$1(vn<? super View, jt0> $action2) {
        this.$action = $action2;
    }

    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        lu.f(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.$action.invoke(view);
    }
}
