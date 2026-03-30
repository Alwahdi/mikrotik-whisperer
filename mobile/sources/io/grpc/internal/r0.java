package io.grpc.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

final class r0 extends f0 {
    private static final ReferenceQueue<r0> a = new ReferenceQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private static final ConcurrentMap<a, a> f3666a = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final Logger f3667a = Logger.getLogger(r0.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private final a f3668a;

    r0(rz delegate) {
        this(delegate, a, f3666a);
    }

    r0(rz delegate, ReferenceQueue<r0> refqueue, ConcurrentMap<a, a> refs) {
        super(delegate);
        this.f3668a = new a(this, delegate, refqueue, refs);
    }

    public rz m() {
        this.f3668a.d();
        return super.m();
    }

    static final class a extends WeakReference<r0> {
        private static final RuntimeException a = e();

        /* renamed from: a  reason: collision with other field name */
        private static final boolean f3669a = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));

        /* renamed from: a  reason: collision with other field name */
        private final String f3670a;

        /* renamed from: a  reason: collision with other field name */
        private final Reference<RuntimeException> f3671a;

        /* renamed from: a  reason: collision with other field name */
        private final ReferenceQueue<r0> f3672a;

        /* renamed from: a  reason: collision with other field name */
        private final ConcurrentMap<a, a> f3673a;

        /* renamed from: a  reason: collision with other field name */
        private final AtomicBoolean f3674a = new AtomicBoolean();

        a(r0 orphanable, rz channel, ReferenceQueue<r0> refqueue, ConcurrentMap<a, a> refs) {
            super(orphanable, refqueue);
            RuntimeException runtimeException;
            if (f3669a) {
                runtimeException = new RuntimeException("ManagedChannel allocation site");
            } else {
                runtimeException = a;
            }
            this.f3671a = new SoftReference(runtimeException);
            this.f3670a = channel.toString();
            this.f3672a = refqueue;
            this.f3673a = refs;
            refs.put(this, this);
            b(refqueue);
        }

        public void clear() {
            c();
            b(this.f3672a);
        }

        /* access modifiers changed from: private */
        public void d() {
            if (!this.f3674a.getAndSet(true)) {
                clear();
            }
        }

        private void c() {
            super.clear();
            this.f3673a.remove(this);
            this.f3671a.clear();
        }

        private static RuntimeException e() {
            RuntimeException e = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            e.setStackTrace(new StackTraceElement[0]);
            return e;
        }

        static int b(ReferenceQueue<r0> refqueue) {
            int orphanedChannels = 0;
            while (true) {
                a aVar = (a) refqueue.poll();
                a ref = aVar;
                if (aVar == null) {
                    return orphanedChannels;
                }
                RuntimeException maybeAllocationSite = ref.f3671a.get();
                ref.c();
                if (!ref.f3674a.get()) {
                    orphanedChannels++;
                    Level level = Level.SEVERE;
                    if (r0.f3667a.isLoggable(level)) {
                        LogRecord lr = new LogRecord(level, "*~*~*~ Channel {0} was not shutdown properly!!! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.");
                        lr.setLoggerName(r0.f3667a.getName());
                        lr.setParameters(new Object[]{ref.f3670a});
                        lr.setThrown(maybeAllocationSite);
                        r0.f3667a.log(lr);
                    }
                }
            }
        }
    }
}
