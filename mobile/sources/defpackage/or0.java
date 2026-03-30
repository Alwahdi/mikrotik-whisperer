package defpackage;

import java.io.InterruptedIOException;

/* renamed from: or0  reason: default package */
public abstract class or0 {
    public static final or0 a = new a();

    /* renamed from: a  reason: collision with other field name */
    private long f4589a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f4590a;
    private long b;

    /* renamed from: or0$a */
    class a extends or0 {
        a() {
        }

        public void c() {
        }
    }

    public long d() {
        return this.b;
    }

    public boolean b() {
        return this.f4590a;
    }

    public long a() {
        if (this.f4590a) {
            return this.f4589a;
        }
        throw new IllegalStateException("No deadline");
    }

    public void c() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f4590a && this.f4589a - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
