package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;

final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 extends ow implements vn<View, LifecycleOwner> {
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 INSTANCE = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2();

    ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2() {
        super(1);
    }

    public final LifecycleOwner invoke(View viewParent) {
        lu.f(viewParent, "viewParent");
        Object tag = viewParent.getTag(R.id.view_tree_lifecycle_owner);
        if (tag instanceof LifecycleOwner) {
            return (LifecycleOwner) tag;
        }
        return null;
    }
}
