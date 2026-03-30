package defpackage;

import java.util.concurrent.Callable;

/* renamed from: zi0  reason: default package */
public final class zi0 extends m implements Callable<Void> {
    public zi0(Runnable runnable) {
        super(runnable);
    }

    /* renamed from: b */
    public Void call() {
        this.f4303a = Thread.currentThread();
        try {
            this.f4302a.run();
            return null;
        } finally {
            lazySet(m.a);
            this.f4303a = null;
        }
    }
}
