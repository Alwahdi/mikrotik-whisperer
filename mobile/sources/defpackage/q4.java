package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: q4  reason: default package */
public class q4 extends or0 {
    static q4 b;
    private static final long d;
    private static final long e;
    private q4 a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f4749b;
    private long c;

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        d = millis;
        e = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void g() {
        if (!this.f4749b) {
            long timeoutNanos = d();
            boolean hasDeadline = b();
            if (timeoutNanos != 0 || hasDeadline) {
                this.f4749b = true;
                m(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    private static synchronized void m(q4 node, long timeoutNanos, boolean hasDeadline) {
        Class<q4> cls = q4.class;
        synchronized (cls) {
            if (b == null) {
                b = new q4();
                new c().start();
            }
            long now = System.nanoTime();
            if (timeoutNanos != 0 && hasDeadline) {
                node.c = Math.min(timeoutNanos, node.a() - now) + now;
            } else if (timeoutNanos != 0) {
                node.c = now + timeoutNanos;
            } else if (hasDeadline) {
                node.c = node.a();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = node.l(now);
            q4 prev = b;
            while (true) {
                q4 q4Var = prev.a;
                if (q4Var == null) {
                    break;
                } else if (remainingNanos < q4Var.l(now)) {
                    break;
                } else {
                    prev = prev.a;
                }
            }
            node.a = prev.a;
            prev.a = node;
            if (prev == b) {
                cls.notify();
            }
        }
    }

    public final boolean j() {
        if (!this.f4749b) {
            return false;
        }
        this.f4749b = false;
        return f(this);
    }

    private static synchronized boolean f(q4 node) {
        synchronized (q4.class) {
            q4 prev = b;
            while (prev != null) {
                q4 q4Var = prev.a;
                if (q4Var == node) {
                    prev.a = node.a;
                    node.a = null;
                    return false;
                }
                prev = q4Var;
            }
            return true;
        }
    }

    private long l(long now) {
        return this.c - now;
    }

    /* access modifiers changed from: protected */
    public void p() {
    }

    /* renamed from: q4$a */
    class a implements fm0 {
        final /* synthetic */ fm0 a;

        a(fm0 fm0) {
            this.a = fm0;
        }

        public void G(r6 source, long byteCount) {
            su0.b(source.f4882a, 0, byteCount);
            while (byteCount > 0) {
                long toWrite = 0;
                vj0 s = source.f4883a;
                while (true) {
                    if (toWrite >= 65536) {
                        break;
                    }
                    vj0 vj0 = source.f4883a;
                    toWrite += (long) (vj0.b - vj0.a);
                    if (toWrite >= byteCount) {
                        toWrite = byteCount;
                        break;
                    }
                    s = s.f5387a;
                }
                q4.this.g();
                try {
                    this.a.G(source, toWrite);
                    byteCount -= toWrite;
                    q4.this.i(true);
                } catch (IOException e) {
                    throw q4.this.h(e);
                } catch (Throwable th) {
                    q4.this.i(false);
                    throw th;
                }
            }
        }

        public void flush() {
            q4.this.g();
            try {
                this.a.flush();
                q4.this.i(true);
            } catch (IOException e) {
                throw q4.this.h(e);
            } catch (Throwable th) {
                q4.this.i(false);
                throw th;
            }
        }

        public void close() {
            q4.this.g();
            try {
                this.a.close();
                q4.this.i(true);
            } catch (IOException e) {
                throw q4.this.h(e);
            } catch (Throwable th) {
                q4.this.i(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.a + ")";
        }
    }

    public final fm0 n(fm0 sink) {
        return new a(sink);
    }

    /* renamed from: q4$b */
    class b implements jm0 {
        final /* synthetic */ jm0 a;

        b(jm0 jm0) {
            this.a = jm0;
        }

        public long T(r6 sink, long byteCount) {
            q4.this.g();
            try {
                long result = this.a.T(sink, byteCount);
                q4.this.i(true);
                return result;
            } catch (IOException e) {
                throw q4.this.h(e);
            } catch (Throwable th) {
                q4.this.i(false);
                throw th;
            }
        }

        public void close() {
            try {
                this.a.close();
                q4.this.i(true);
            } catch (IOException e) {
                throw q4.this.h(e);
            } catch (Throwable th) {
                q4.this.i(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.a + ")";
        }
    }

    public final jm0 o(jm0 source) {
        return new b(source);
    }

    /* access modifiers changed from: package-private */
    public final void i(boolean throwOnTimeout) {
        if (j() && throwOnTimeout) {
            throw k((IOException) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException h(IOException cause) {
        if (!j()) {
            return cause;
        }
        return k(cause);
    }

    /* access modifiers changed from: protected */
    public IOException k(IOException cause) {
        InterruptedIOException e2 = new InterruptedIOException("timeout");
        if (cause != null) {
            e2.initCause(cause);
        }
        return e2;
    }

    /* renamed from: q4$c */
    private static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r1.p();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<q4> r0 = defpackage.q4.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x001c }
                q4 r1 = defpackage.q4.e()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                q4 r2 = defpackage.q4.b     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r2 = 0
                defpackage.q4.b = r2     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.p()     // Catch:{ InterruptedException -> 0x001c }
                goto L_0x001d
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                throw r1     // Catch:{ InterruptedException -> 0x001c }
            L_0x001c:
                r0 = move-exception
            L_0x001d:
                goto L_0x0000
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.q4.c.run():void");
        }
    }

    static q4 e() {
        Class<q4> cls = q4.class;
        q4 node = b.a;
        if (node == null) {
            long startNanos = System.nanoTime();
            cls.wait(d);
            if (b.a != null || System.nanoTime() - startNanos < e) {
                return null;
            }
            return b;
        }
        long waitNanos = node.l(System.nanoTime());
        if (waitNanos > 0) {
            long waitMillis = waitNanos / 1000000;
            cls.wait(waitMillis, (int) (waitNanos - (1000000 * waitMillis)));
            return null;
        }
        b.a = node.a;
        node.a = null;
        return node;
    }
}
