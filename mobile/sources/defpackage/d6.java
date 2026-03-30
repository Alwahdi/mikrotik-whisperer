package defpackage;

import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.b;

/* renamed from: d6  reason: default package */
public abstract class d6<T, R> implements en<T>, wb0<R> {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    protected final ho0<? super R> f2709a;

    /* renamed from: a  reason: collision with other field name */
    protected jo0 f2710a;

    /* renamed from: a  reason: collision with other field name */
    protected wb0<T> f2711a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f2712a;

    public d6(ho0<? super R> actual) {
        this.f2709a = actual;
    }

    public final void d(jo0 s) {
        if (b.validate(this.f2710a, s)) {
            this.f2710a = s;
            if (s instanceof wb0) {
                this.f2711a = (wb0) s;
            }
            if (e()) {
                this.f2709a.d(this);
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
        if (this.f2712a) {
            of0.l(t);
            return;
        }
        this.f2712a = true;
        this.f2709a.onError(t);
    }

    /* access modifiers changed from: protected */
    public final void g(Throwable t) {
        oj.b(t);
        this.f2710a.cancel();
        onError(t);
    }

    public void a() {
        if (!this.f2712a) {
            this.f2712a = true;
            this.f2709a.a();
        }
    }

    /* access modifiers changed from: protected */
    public final int h(int mode) {
        QueueSubscription<T> qs = this.f2711a;
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
        this.f2710a.request(n);
    }

    public void cancel() {
        this.f2710a.cancel();
    }

    public boolean isEmpty() {
        return this.f2711a.isEmpty();
    }

    public void clear() {
        this.f2711a.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
