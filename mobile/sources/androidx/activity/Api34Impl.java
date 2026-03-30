package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi(34)
public final class Api34Impl {
    public static final Api34Impl INSTANCE = new Api34Impl();

    private Api34Impl() {
    }

    @DoNotInline
    public final BackEvent createOnBackEvent(float touchX, float touchY, float progress, int swipeEdge) {
        return new BackEvent(touchX, touchY, progress, swipeEdge);
    }

    @DoNotInline
    public final float progress(BackEvent backEvent) {
        lu.f(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    @DoNotInline
    public final float touchX(BackEvent backEvent) {
        lu.f(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    @DoNotInline
    public final float touchY(BackEvent backEvent) {
        lu.f(backEvent, "backEvent");
        return backEvent.getTouchY();
    }

    @DoNotInline
    public final int swipeEdge(BackEvent backEvent) {
        lu.f(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }
}
