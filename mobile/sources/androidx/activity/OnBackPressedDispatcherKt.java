package androidx.activity;

import androidx.lifecycle.LifecycleOwner;

public final class OnBackPressedDispatcherKt {
    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z, vn vnVar, int i, Object obj) {
        if ((i & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return addCallback(onBackPressedDispatcher, lifecycleOwner, z, vnVar);
    }

    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher $this$addCallback, LifecycleOwner owner, boolean enabled, vn<? super OnBackPressedCallback, jt0> onBackPressed) {
        lu.f($this$addCallback, "<this>");
        lu.f(onBackPressed, "onBackPressed");
        OnBackPressedDispatcherKt$addCallback$callback$1 callback = new OnBackPressedDispatcherKt$addCallback$callback$1(enabled, onBackPressed);
        if (owner != null) {
            $this$addCallback.addCallback(owner, callback);
        } else {
            $this$addCallback.addCallback(callback);
        }
        return callback;
    }
}
