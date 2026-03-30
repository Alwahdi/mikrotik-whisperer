package androidx.core.view;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi(16)
final class Api16Impl {
    public static final Api16Impl INSTANCE = new Api16Impl();

    private Api16Impl() {
    }

    @DoNotInline
    public static final void postOnAnimationDelayed(View view, Runnable action, long delayInMillis) {
        lu.f(view, "view");
        lu.f(action, "action");
        view.postOnAnimationDelayed(action, delayInMillis);
    }
}
