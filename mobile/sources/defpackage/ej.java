package defpackage;

import java.util.concurrent.locks.LockSupport;

/* renamed from: ej  reason: default package */
public abstract class ej extends cj {
    /* access modifiers changed from: protected */
    public abstract Thread g0();

    /* access modifiers changed from: protected */
    public final void h0() {
        Thread thread = g0();
        if (Thread.currentThread() != thread) {
            f0.a();
            LockSupport.unpark(thread);
        }
    }
}
