package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;

public final class ViewTreeLifecycleOwner {
    public static final void set(View $this$setViewTreeLifecycleOwner, LifecycleOwner lifecycleOwner) {
        lu.f($this$setViewTreeLifecycleOwner, "<this>");
        $this$setViewTreeLifecycleOwner.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }

    public static final LifecycleOwner get(View $this$findViewTreeLifecycleOwner) {
        lu.f($this$findViewTreeLifecycleOwner, "<this>");
        return (LifecycleOwner) kk0.h(kk0.i(ik0.e($this$findViewTreeLifecycleOwner, ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1.INSTANCE), ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2.INSTANCE));
    }
}
