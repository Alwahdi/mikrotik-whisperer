package androidx.activity;

import android.view.View;

public final class ViewTreeOnBackPressedDispatcherOwner {
    public static final void set(View $this$setViewTreeOnBackPressedDispatcherOwner, OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        lu.f($this$setViewTreeOnBackPressedDispatcherOwner, "<this>");
        lu.f(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        $this$setViewTreeOnBackPressedDispatcherOwner.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, onBackPressedDispatcherOwner);
    }

    public static final OnBackPressedDispatcherOwner get(View $this$findViewTreeOnBackPressedDispatcherOwner) {
        lu.f($this$findViewTreeOnBackPressedDispatcherOwner, "<this>");
        return (OnBackPressedDispatcherOwner) kk0.h(kk0.i(ik0.e($this$findViewTreeOnBackPressedDispatcherOwner, ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$1.INSTANCE), ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2.INSTANCE));
    }
}
