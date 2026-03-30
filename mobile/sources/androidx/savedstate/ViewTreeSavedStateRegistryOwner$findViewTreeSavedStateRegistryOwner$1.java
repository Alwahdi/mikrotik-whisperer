package androidx.savedstate;

import android.view.View;
import android.view.ViewParent;

final class ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1 extends ow implements vn<View, View> {
    public static final ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1 INSTANCE = new ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1();

    ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1() {
        super(1);
    }

    public final View invoke(View view) {
        lu.f(view, "view");
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
