package defpackage;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.subscriptions.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ko0  reason: default package */
public class ko0 extends AtomicInteger implements jo0 {
    long a;

    /* renamed from: a  reason: collision with other field name */
    final AtomicLong f4127a = new AtomicLong();

    /* renamed from: a  reason: collision with other field name */
    final AtomicReference<jo0> f4128a = new AtomicReference<>();

    /* renamed from: a  reason: collision with other field name */
    jo0 f4129a;

    /* renamed from: a  reason: collision with other field name */
    volatile boolean f4130a;
    final AtomicLong b = new AtomicLong();

    /* renamed from: b  reason: collision with other field name */
    protected boolean f4131b;

    public final void e(jo0 s) {
        if (this.f4130a) {
            s.cancel();
            return;
        }
        a40.c(s, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            jo0 a2 = this.f4128a.getAndSet(s);
            if (a2 != null) {
                a2.cancel();
            }
            a();
            return;
        }
        jo0 a3 = this.f4129a;
        if (a3 != null) {
            a3.cancel();
        }
        this.f4129a = s;
        long r = this.a;
        if (decrementAndGet() != 0) {
            b();
        }
        if (r != 0) {
            s.request(r);
        }
    }

    public final void request(long n) {
        if (b.validate(n) && !this.f4131b) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                m5.a(this.f4127a, n);
                a();
                return;
            }
            long r = this.a;
            if (r != LocationRequestCompat.PASSIVE_INTERVAL) {
                long r2 = m5.b(r, n);
                this.a = r2;
                if (r2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                    this.f4131b = true;
                }
            }
            jo0 a2 = this.f4129a;
            if (decrementAndGet() != 0) {
                b();
            }
            if (a2 != null) {
                a2.request(n);
            }
        }
    }

    public final void d(long n) {
        if (!this.f4131b) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                m5.a(this.b, n);
                a();
                return;
            }
            long r = this.a;
            if (r != LocationRequestCompat.PASSIVE_INTERVAL) {
                long u = r - n;
                if (u < 0) {
                    b.reportMoreProduced(u);
                    u = 0;
                }
                this.a = u;
            }
            if (decrementAndGet() != 0) {
                b();
            }
        }
    }

    public void cancel() {
        if (!this.f4130a) {
            this.f4130a = true;
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (getAndIncrement() == 0) {
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        int missed = 1;
        long requestAmount = 0;
        jo0 requestTarget = null;
        do {
            jo0 ms = this.f4128a.get();
            if (ms != null) {
                ms = this.f4128a.getAndSet((Object) null);
            }
            long mr = this.f4127a.get();
            if (mr != 0) {
                mr = this.f4127a.getAndSet(0);
            }
            long mp = this.b.get();
            if (mp != 0) {
                mp = this.b.getAndSet(0);
            }
            jo0 a2 = this.f4129a;
            if (this.f4130a) {
                if (a2 != null) {
                    a2.cancel();
                    this.f4129a = null;
                }
                if (ms != null) {
                    ms.cancel();
                }
            } else {
                long r = this.a;
                if (r != LocationRequestCompat.PASSIVE_INTERVAL) {
                    long u = m5.b(r, mr);
                    if (u != LocationRequestCompat.PASSIVE_INTERVAL) {
                        long v = u - mp;
                        if (v < 0) {
                            b.reportMoreProduced(v);
                            v = 0;
                        }
                        r = v;
                    } else {
                        r = u;
                    }
                    this.a = r;
                }
                if (ms != null) {
                    if (a2 != null) {
                        a2.cancel();
                    }
                    this.f4129a = ms;
                    if (r != 0) {
                        requestAmount = m5.b(requestAmount, r);
                        requestTarget = ms;
                    }
                } else if (!(a2 == null || mr == 0)) {
                    requestAmount = m5.b(requestAmount, mr);
                    requestTarget = a2;
                }
            }
            missed = addAndGet(-missed);
        } while (missed != 0);
        if (requestAmount != 0) {
            requestTarget.request(requestAmount);
        }
    }

    public final boolean c() {
        return this.f4130a;
    }
}
