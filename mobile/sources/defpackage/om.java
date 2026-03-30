package defpackage;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.subscriptions.b;
import java.util.NoSuchElementException;

/* renamed from: om  reason: default package */
public final class om<T> extends vl0<T> implements zo<T> {
    final long a;

    /* renamed from: a  reason: collision with other field name */
    final T f4555a;

    /* renamed from: a  reason: collision with other field name */
    final km<T> f4556a;

    public om(km<T> source, long index, T defaultValue) {
        this.f4556a = source;
        this.a = index;
        this.f4555a = defaultValue;
    }

    /* access modifiers changed from: protected */
    public void f(zl0<? super T> s) {
        this.f4556a.y(new a(s, this.a, this.f4555a));
    }

    public km<T> a() {
        return of0.j(new nm(this.f4556a, this.a, this.f4555a, true));
    }

    /* renamed from: om$a */
    static final class a<T> implements en<T>, yg {
        final long a;

        /* renamed from: a  reason: collision with other field name */
        final T f4557a;

        /* renamed from: a  reason: collision with other field name */
        jo0 f4558a;

        /* renamed from: a  reason: collision with other field name */
        final zl0<? super T> f4559a;

        /* renamed from: a  reason: collision with other field name */
        boolean f4560a;
        long b;

        a(zl0<? super T> actual, long index, T defaultValue) {
            this.f4559a = actual;
            this.a = index;
            this.f4557a = defaultValue;
        }

        public void d(jo0 s) {
            if (b.validate(this.f4558a, s)) {
                this.f4558a = s;
                this.f4559a.b(this);
                s.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public void c(T t) {
            if (!this.f4560a) {
                long c = this.b;
                if (c == this.a) {
                    this.f4560a = true;
                    this.f4558a.cancel();
                    this.f4558a = b.CANCELLED;
                    this.f4559a.e(t);
                    return;
                }
                this.b = 1 + c;
            }
        }

        public void onError(Throwable t) {
            if (this.f4560a) {
                of0.l(t);
                return;
            }
            this.f4560a = true;
            this.f4558a = b.CANCELLED;
            this.f4559a.onError(t);
        }

        public void a() {
            this.f4558a = b.CANCELLED;
            if (!this.f4560a) {
                this.f4560a = true;
                T v = this.f4557a;
                if (v != null) {
                    this.f4559a.e(v);
                } else {
                    this.f4559a.onError(new NoSuchElementException());
                }
            }
        }

        public void dispose() {
            this.f4558a.cancel();
            this.f4558a = b.CANCELLED;
        }
    }
}
