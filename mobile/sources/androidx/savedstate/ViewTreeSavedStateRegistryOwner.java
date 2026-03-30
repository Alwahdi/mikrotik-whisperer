package androidx.savedstate;

import android.view.View;

public final class ViewTreeSavedStateRegistryOwner {
    public static final void set(View $this$setViewTreeSavedStateRegistryOwner, SavedStateRegistryOwner owner) {
        lu.f($this$setViewTreeSavedStateRegistryOwner, "<this>");
        $this$setViewTreeSavedStateRegistryOwner.setTag(R.id.view_tree_saved_state_registry_owner, owner);
    }

    public static final SavedStateRegistryOwner get(View $this$findViewTreeSavedStateRegistryOwner) {
        lu.f($this$findViewTreeSavedStateRegistryOwner, "<this>");
        return (SavedStateRegistryOwner) kk0.h(kk0.i(ik0.e($this$findViewTreeSavedStateRegistryOwner, ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1.INSTANCE), ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2.INSTANCE));
    }
}
