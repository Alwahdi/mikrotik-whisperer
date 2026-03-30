package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: yl0  reason: default package */
public final class yl0<T> extends vl0<T> {
    final bj0 a;

    /* renamed from: a  reason: collision with other field name */
    final bm0<T> f5893a;

    public yl0(bm0<T> source, bj0 scheduler) {
        this.f5893a = source;
        this.a = scheduler;
    }

    /* access modifiers changed from: protected */
    public void f(zl0<? super T> s) {
        this.f5893a.b(new a(s, this.a));
    }

    /* renamed from: yl0$a */
    static final class a<T> extends AtomicReference<yg> implements zl0<T>, yg, Runnable {
        final bj0 a;

        /* renamed from: a  reason: collision with other field name */
        T f5894a;

        /* renamed from: a  reason: collision with other field name */
        Throwable f5895a;

        /* renamed from: a  reason: collision with other field name */
        final zl0<? super T> f5896a;

        a(zl0<? super T> actual, bj0 scheduler) {
            this.f5896a = actual;
            this.a = scheduler;
        }

        public void b(yg d) {
            if (io.reactivex.internal.disposables.a.setOnce(this, d)) {
                this.f5896a.b(this);
            }
        }

        public void e(T value) {
            this.f5894a = value;
            io.reactivex.internal.disposables.a.replace(this, this.a.b(this));
        }

        public void onError(Throwable e) {
            this.f5895a = e;
            io.reactivex.internal.disposables.a.replace(this, this.a.b(this));
        }

        public void run() {
            Throwable ex = this.f5895a;
            if (ex != null) {
                this.f5896a.onError(ex);
            } else {
                this.f5896a.e(this.f5894a);
            }
        }

        public void dispose() {
            io.reactivex.internal.disposables.a.dispose(this);
        }
    }
}
