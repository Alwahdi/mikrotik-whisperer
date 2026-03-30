package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

public final class OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1 implements OnBackAnimationCallback {
    final /* synthetic */ tn<jt0> $onBackCancelled;
    final /* synthetic */ tn<jt0> $onBackInvoked;
    final /* synthetic */ vn<BackEventCompat, jt0> $onBackProgressed;
    final /* synthetic */ vn<BackEventCompat, jt0> $onBackStarted;

    OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(vn<? super BackEventCompat, jt0> $onBackStarted2, vn<? super BackEventCompat, jt0> $onBackProgressed2, tn<jt0> $onBackInvoked2, tn<jt0> $onBackCancelled2) {
        this.$onBackStarted = $onBackStarted2;
        this.$onBackProgressed = $onBackProgressed2;
        this.$onBackInvoked = $onBackInvoked2;
        this.$onBackCancelled = $onBackCancelled2;
    }

    public void onBackStarted(BackEvent backEvent) {
        lu.f(backEvent, "backEvent");
        this.$onBackStarted.invoke(new BackEventCompat(backEvent));
    }

    public void onBackProgressed(BackEvent backEvent) {
        lu.f(backEvent, "backEvent");
        this.$onBackProgressed.invoke(new BackEventCompat(backEvent));
    }

    public void onBackInvoked() {
        this.$onBackInvoked.invoke();
    }

    public void onBackCancelled() {
        this.$onBackCancelled.invoke();
    }
}
