package defpackage;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.disposables.b;
import java.util.Collection;
import java.util.concurrent.Callable;

/* renamed from: hn  reason: default package */
public final class hn<T, U extends Collection<? super T>> extends vl0<U> implements zo<U> {
    final Callable<U> a;

    /* renamed from: a  reason: collision with other field name */
    final km<T> f3172a;

    public hn(km<T> source) {
        this(source, io.reactivex.internal.util.a.asCallable());
    }

    public hn(km<T> source, Callable<U> collectionSupplier) {
        this.f3172a = source;
        this.a = collectionSupplier;
    }

    /* access modifiers changed from: protected */
    public void f(zl0<? super U> s) {
        try {
            this.f3172a.y(new a(s, (Collection) a40.c(this.a.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable e) {
            oj.b(e);
            b.error(e, (zl0<?>) s);
        }
    }

    public km<U> a() {
        return of0.j(new gn(this.f3172a, this.a));
    }

    /* renamed from: hn$a */
    static final class a<T, U extends Collection<? super T>> implements en<T>, yg {
        U a;

        /* renamed from: a  reason: collision with other field name */
        jo0 f3173a;

        /* renamed from: a  reason: collision with other field name */
        final zl0<? super U> f3174a;

        a(zl0<? super U> actual, U collection) {
            this.f3174a = actual;
            this.a = collection;
        }

        public void d(jo0 s) {
            if (io.reactivex.internal.subscriptions.b.validate(this.f3173a, s)) {
                this.f3173a = s;
                this.f3174a.b(this);
                s.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public void c(T t) {
            this.a.add(t);
        }

        public void onError(Throwable t) {
            this.a = null;
            this.f3173a = io.reactivex.internal.subscriptions.b.CANCELLED;
            this.f3174a.onError(t);
        }

        public void a() {
            this.f3173a = io.reactivex.internal.subscriptions.b.CANCELLED;
            this.f3174a.e(this.a);
        }

        public void dispose() {
            this.f3173a.cancel();
            this.f3173a = io.reactivex.internal.subscriptions.b.CANCELLED;
        }
    }
}
