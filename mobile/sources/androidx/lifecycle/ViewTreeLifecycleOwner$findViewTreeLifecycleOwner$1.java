package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;

final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 extends ow implements vn<View, View> {
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 INSTANCE = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1();

    ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1() {
        super(1);
    }

    public final View invoke(View currentView) {
        lu.f(currentView, "currentView");
        ViewParent parent = currentView.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
