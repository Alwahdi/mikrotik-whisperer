package defpackage;

import io.reactivex.internal.operators.single.SingleSubscribeOn;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: cm0  reason: default package */
public final class cm0<T> extends vl0<T> {
    final bj0 a;

    /* renamed from: a  reason: collision with other field name */
    final bm0<? extends T> f341a;

    public cm0(bm0<? extends T> source, bj0 scheduler) {
        this.f341a = source;
        this.a = scheduler;
    }

    /* access modifiers changed from: protected */
    public void f(zl0<? super T> s) {
        SingleSubscribeOn.SubscribeOnObserver<T> parent = new a<>(s, this.f341a);
        s.b(parent);
        parent.f342a.b(this.a.b(parent));
    }

    /* renamed from: cm0$a */
    static final class a<T> extends AtomicReference<yg> implements zl0<T>, yg, Runnable {
        final bm0<? extends T> a;

        /* renamed from: a  reason: collision with other field name */
        final lk0 f342a = new lk0();

        /* renamed from: a  reason: collision with other field name */
        final zl0<? super T> f343a;

        a(zl0<? super T> actual, bm0<? extends T> source) {
            this.f343a = actual;
            this.a = source;
        }

        public void b(yg d) {
            io.reactivex.internal.disposables.a.setOnce(this, d);
        }

        public void e(T value) {
            this.f343a.e(value);
        }

        public void onError(Throwable e) {
            this.f343a.onError(e);
        }

        public void dispose() {
            io.reactivex.internal.disposables.a.dispose(this);
            this.f342a.dispose();
        }

        public void run() {
            this.a.b(this);
        }
    }
}
