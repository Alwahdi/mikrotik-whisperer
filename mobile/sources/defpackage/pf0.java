package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: pf0  reason: default package */
public final class pf0 extends AtomicLong implements ThreadFactory {
    final int a;

    /* renamed from: a  reason: collision with other field name */
    final String f4711a;

    /* renamed from: a  reason: collision with other field name */
    final boolean f4712a;

    public pf0(String prefix) {
        this(prefix, 5, false);
    }

    public pf0(String prefix, int priority) {
        this(prefix, priority, false);
    }

    public pf0(String prefix, int priority, boolean nonBlocking) {
        this.f4711a = prefix;
        this.a = priority;
        this.f4712a = nonBlocking;
    }

    public Thread newThread(Runnable r) {
        StringBuilder sb = new StringBuilder(this.f4711a);
        sb.append('-');
        String name = sb.append(incrementAndGet()).toString();
        Thread t = this.f4712a ? new a(r, name) : new Thread(r, name);
        t.setPriority(this.a);
        t.setDaemon(true);
        return t;
    }

    public String toString() {
        return "RxThreadFactory[" + this.f4711a + "]";
    }

    /* renamed from: pf0$a */
    static final class a extends Thread {
        a(Runnable run, String name) {
            super(run, name);
        }
    }
}
