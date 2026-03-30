package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;

public final class ViewTreeViewModelStoreOwner {
    public static final void set(View $this$setViewTreeViewModelStoreOwner, ViewModelStoreOwner viewModelStoreOwner) {
        lu.f($this$setViewTreeViewModelStoreOwner, "<this>");
        $this$setViewTreeViewModelStoreOwner.setTag(R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }

    public static final ViewModelStoreOwner get(View $this$findViewTreeViewModelStoreOwner) {
        lu.f($this$findViewTreeViewModelStoreOwner, "<this>");
        return (ViewModelStoreOwner) kk0.h(kk0.i(ik0.e($this$findViewTreeViewModelStoreOwner, ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1.INSTANCE), ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2.INSTANCE));
    }
}
