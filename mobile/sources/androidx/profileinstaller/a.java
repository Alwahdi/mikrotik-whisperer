package androidx.profileinstaller;

import android.view.Choreographer;

public final /* synthetic */ class a implements Choreographer.FrameCallback {
    public final /* synthetic */ Runnable a;

    public /* synthetic */ a(Runnable runnable) {
        this.a = runnable;
    }

    public final void doFrame(long j) {
        this.a.run();
    }
}
