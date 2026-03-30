package androidx.core.view;

import android.view.View;

public final class ViewKt$doOnAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ vn<View, jt0> $action;
    final /* synthetic */ View $this_doOnAttach;

    public ViewKt$doOnAttach$1(View $receiver, vn<? super View, jt0> $action2) {
        this.$this_doOnAttach = $receiver;
        this.$action = $action2;
    }

    public void onViewAttachedToWindow(View view) {
        lu.f(view, "view");
        this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
        this.$action.invoke(view);
    }

    public void onViewDetachedFromWindow(View view) {
        lu.f(view, "view");
    }
}
