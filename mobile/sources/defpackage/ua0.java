package defpackage;

import androidx.lifecycle.ProcessLifecycleOwner;

/* renamed from: ua0  reason: default package */
public final /* synthetic */ class ua0 implements Runnable {
    public final /* synthetic */ ProcessLifecycleOwner a;

    public /* synthetic */ ua0(ProcessLifecycleOwner processLifecycleOwner) {
        this.a = processLifecycleOwner;
    }

    public final void run() {
        ProcessLifecycleOwner.delayedPauseRunnable$lambda$0(this.a);
    }
}
