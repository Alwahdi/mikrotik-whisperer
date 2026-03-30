package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;

final class ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1 extends ow implements vn<View, View> {
    public static final ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1 INSTANCE = new ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1();

    ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1() {
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
