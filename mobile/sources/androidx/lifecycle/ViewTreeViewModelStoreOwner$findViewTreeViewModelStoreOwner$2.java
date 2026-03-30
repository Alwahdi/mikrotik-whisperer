package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;

final class ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 extends ow implements vn<View, ViewModelStoreOwner> {
    public static final ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 INSTANCE = new ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2();

    ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2() {
        super(1);
    }

    public final ViewModelStoreOwner invoke(View view) {
        lu.f(view, "view");
        Object tag = view.getTag(R.id.view_tree_view_model_store_owner);
        if (tag instanceof ViewModelStoreOwner) {
            return (ViewModelStoreOwner) tag;
        }
        return null;
    }
}
