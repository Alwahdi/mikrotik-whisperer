package defpackage;

import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.b;

/* renamed from: c6  reason: default package */
public abstract class c6<T, R> implements zb<T>, wb0<R> {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    protected jo0 f286a;

    /* renamed from: a  reason: collision with other field name */
    protected wb0<T> f287a;

    /* renamed from: a  reason: collision with other field name */
    protected final zb<? super R> f288a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f289a;

    public c6(zb<? super R> actual) {
        this.f288a = actual;
    }

    public final void d(jo0 s) {
        if (b.validate(this.f286a, s)) {
            this.f286a = s;
            if (s instanceof wb0) {
                this.f287a = (wb0) s;
            }
            if (e()) {
                this.f288a.d(this);
                b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public void onError(Throwable t) {
        if (this.f289a) {
            of0.l(t);
            return;
        }
        this.f289a = true;
        this.f288a.onError(t);
    }

    /* access modifiers changed from: protected */
    public final void g(Throwable t) {
        oj.b(t);
        this.f286a.cancel();
        onError(t);
    }

    public void a() {
        if (!this.f289a) {
            this.f289a = true;
            this.f288a.a();
        }
    }

    /* access modifiers changed from: protected */
    public final int h(int mode) {
        QueueSubscription<T> qs = this.f287a;
        if (qs == null || (mode & 4) != 0) {
            return 0;
        }
        int m = qs.requestFusion(mode);
        if (m != 0) {
            this.a = m;
        }
        return m;
    }

    public void request(long n) {
        this.f286a.request(n);
    }

    public void cancel() {
        this.f286a.cancel();
    }

    public boolean isEmpty() {
        return this.f287a.isEmpty();
    }

    public void clear() {
        this.f287a.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
