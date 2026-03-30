package defpackage;

import android.os.Process;

/* renamed from: ry0  reason: default package */
final class ry0 implements Runnable {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final Runnable f4952a;

    public ry0(Runnable runnable, int i) {
        this.f4952a = runnable;
        this.a = i;
    }

    public final void run() {
        Process.setThreadPriority(this.a);
        this.f4952a.run();
    }
}
