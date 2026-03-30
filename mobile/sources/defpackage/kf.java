package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* renamed from: kf  reason: default package */
public final class kf extends dj implements Runnable {
    private static volatile Thread _thread;
    public static final kf a;
    private static final long b;
    private static volatile int debugStatus;

    private kf() {
    }

    static {
        Long l;
        kf kfVar = new kf();
        a = kfVar;
        cj.c0(kfVar, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException e) {
            l = 1000L;
        }
        b = timeUnit.toNanos(l.longValue());
    }

    /* access modifiers changed from: protected */
    public Thread g0() {
        Thread thread = _thread;
        return thread == null ? t0() : thread;
    }

    private final boolean u0() {
        return debugStatus == 4;
    }

    private final boolean v0() {
        int debugStatus2 = debugStatus;
        return debugStatus2 == 2 || debugStatus2 == 3;
    }

    public void k0(Runnable task) {
        if (u0()) {
            x0();
        }
        super.k0(task);
    }

    private final void x0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public void run() {
        ar0.a.c(this);
        f0.a();
        long shutdownNanos = LocationRequestCompat.PASSIVE_INTERVAL;
        try {
            if (w0()) {
                while (true) {
                    Thread.interrupted();
                    long parkNanos = o0();
                    if (parkNanos == LocationRequestCompat.PASSIVE_INTERVAL) {
                        f0.a();
                        long now = System.nanoTime();
                        if (shutdownNanos == LocationRequestCompat.PASSIVE_INTERVAL) {
                            shutdownNanos = now + b;
                        }
                        long tillShutdown = shutdownNanos - now;
                        if (tillShutdown <= 0) {
                            _thread = null;
                            s0();
                            f0.a();
                            if (!n0()) {
                                g0();
                            }
                            long j = parkNanos;
                            long j2 = tillShutdown;
                            long j3 = now;
                            return;
                        }
                        parkNanos = hd0.c(parkNanos, tillShutdown);
                    } else {
                        shutdownNanos = LocationRequestCompat.PASSIVE_INTERVAL;
                    }
                    if (parkNanos > 0) {
                        if (v0()) {
                            _thread = null;
                            s0();
                            f0.a();
                            if (!n0()) {
                                g0();
                            }
                            long j4 = parkNanos;
                            return;
                        }
                        f0.a();
                        LockSupport.parkNanos(this, parkNanos);
                    }
                }
            }
        } finally {
            _thread = null;
            s0();
            f0.a();
            if (!n0()) {
                g0();
            }
        }
    }

    private final synchronized Thread t0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            Thread $this$createThreadSync_u24lambda_u2d0 = thread;
            _thread = $this$createThreadSync_u24lambda_u2d0;
            $this$createThreadSync_u24lambda_u2d0.setDaemon(true);
            $this$createThreadSync_u24lambda_u2d0.start();
        }
        return thread;
    }

    private final synchronized boolean w0() {
        if (v0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final synchronized void s0() {
        if (v0()) {
            debugStatus = 3;
            q0();
            notifyAll();
        }
    }
}
