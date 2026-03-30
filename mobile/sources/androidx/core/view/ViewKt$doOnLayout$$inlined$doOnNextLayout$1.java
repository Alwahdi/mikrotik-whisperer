package androidx.core.view;

import android.view.View;

public final class ViewKt$doOnLayout$$inlined$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ vn $action$inlined;

    public ViewKt$doOnLayout$$inlined$doOnNextLayout$1(vn vnVar) {
        this.$action$inlined = vnVar;
    }

    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        lu.f(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.$action$inlined.invoke(view);
    }
}
