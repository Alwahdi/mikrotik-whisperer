package androidx.activity;

public final class OnBackPressedDispatcherKt$addCallback$callback$1 extends OnBackPressedCallback {
    final /* synthetic */ vn<OnBackPressedCallback, jt0> $onBackPressed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnBackPressedDispatcherKt$addCallback$callback$1(boolean $enabled, vn<? super OnBackPressedCallback, jt0> $onBackPressed2) {
        super($enabled);
        this.$onBackPressed = $onBackPressed2;
    }

    public void handleOnBackPressed() {
        this.$onBackPressed.invoke(this);
    }
}
