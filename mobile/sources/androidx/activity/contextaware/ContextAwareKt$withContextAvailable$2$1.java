package androidx.activity.contextaware;

final class ContextAwareKt$withContextAvailable$2$1 extends ow implements vn<Throwable, jt0> {
    final /* synthetic */ ContextAwareKt$withContextAvailable$2$listener$1 $listener;
    final /* synthetic */ ContextAware $this_withContextAvailable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextAwareKt$withContextAvailable$2$1(ContextAware contextAware, ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1) {
        super(1);
        this.$this_withContextAvailable = contextAware;
        this.$listener = contextAwareKt$withContextAvailable$2$listener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Throwable) p1);
        return jt0.a;
    }

    public final void invoke(Throwable it) {
        this.$this_withContextAvailable.removeOnContextAvailableListener(this.$listener);
    }
}
