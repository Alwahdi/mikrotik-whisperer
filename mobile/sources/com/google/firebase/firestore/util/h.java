package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.c;
import java.util.Date;

public class h {
    private final double a;

    /* renamed from: a  reason: collision with other field name */
    private final long f2393a;

    /* renamed from: a  reason: collision with other field name */
    private c.b f2394a;

    /* renamed from: a  reason: collision with other field name */
    private final c.d f2395a;

    /* renamed from: a  reason: collision with other field name */
    private final c f2396a;
    private final long b;
    private long c;
    private long d;
    private long e = new Date().getTime();

    public h(c queue, c.d timerId, long initialDelayMs, double backoffFactor, long maxDelayMs) {
        this.f2396a = queue;
        this.f2395a = timerId;
        this.f2393a = initialDelayMs;
        this.a = backoffFactor;
        this.b = maxDelayMs;
        this.c = maxDelayMs;
        e();
    }

    public void e() {
        this.d = 0;
    }

    public void f() {
        this.d = this.c;
    }

    public void g(long newMax) {
        this.c = newMax;
    }

    public void a(Runnable task) {
        b();
        long desiredDelayWithJitterMs = this.d + c();
        long delaySoFarMs = Math.max(0, new Date().getTime() - this.e);
        long remainingDelayMs = Math.max(0, desiredDelayWithJitterMs - delaySoFarMs);
        if (this.d > 0) {
            i.a(getClass().getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(remainingDelayMs), Long.valueOf(this.d), Long.valueOf(desiredDelayWithJitterMs), Long.valueOf(delaySoFarMs));
        }
        this.f2394a = this.f2396a.f(this.f2395a, remainingDelayMs, g.a(this, task));
        long j = (long) (((double) this.d) * this.a);
        this.d = j;
        long j2 = this.f2393a;
        if (j < j2) {
            this.d = j2;
        } else {
            long j3 = this.c;
            if (j > j3) {
                this.d = j3;
            }
        }
        this.c = this.b;
    }

    static /* synthetic */ void d(h hVar, Runnable task) {
        hVar.e = new Date().getTime();
        task.run();
    }

    public void b() {
        c.b bVar = this.f2394a;
        if (bVar != null) {
            bVar.c();
            this.f2394a = null;
        }
    }

    private long c() {
        return (long) ((Math.random() - 0.5d) * ((double) this.d));
    }
}
