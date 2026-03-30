package androidx.core.view;

import android.view.ViewParent;

/* synthetic */ class ViewKt$ancestors$1 extends xo implements vn<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    public final ViewParent invoke(ViewParent p0) {
        lu.f(p0, "p0");
        return p0.getParent();
    }
}
