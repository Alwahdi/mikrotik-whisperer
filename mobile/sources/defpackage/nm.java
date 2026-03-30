package defpackage;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.subscriptions.b;
import java.util.NoSuchElementException;

/* renamed from: nm  reason: default package */
public final class nm<T> extends n<T, T> {
    final long a;

    /* renamed from: a  reason: collision with other field name */
    final T f4443a;

    /* renamed from: a  reason: collision with other field name */
    final boolean f4444a;

    public nm(km<T> source, long index, T defaultValue, boolean errorOnFewer) {
        super(source);
        this.a = index;
        this.f4443a = defaultValue;
        this.f4444a = errorOnFewer;
    }

    /* access modifiers changed from: protected */
    public void z(ho0<? super T> s) {
        this.a.y(new a(s, this.a, this.f4443a, this.f4444a));
    }

    /* renamed from: nm$a */
    static final class a<T> extends wf<T> implements en<T> {
        final long a;

        /* renamed from: a  reason: collision with other field name */
        jo0 f4445a;

        /* renamed from: a  reason: collision with other field name */
        final boolean f4446a;
        long b;

        /* renamed from: b  reason: collision with other field name */
        final T f4447b;

        /* renamed from: b  reason: collision with other field name */
        boolean f4448b;

        a(ho0<? super T> actual, long index, T defaultValue, boolean errorOnFewer) {
            super(actual);
            this.a = index;
            this.f4447b = defaultValue;
            this.f4446a = errorOnFewer;
        }

        public void d(jo0 s) {
            if (b.validate(this.f4445a, s)) {
                this.f4445a = s;
                this.a.d(this);
                s.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public void c(T t) {
            if (!this.f4448b) {
                long c = this.b;
                if (c == this.a) {
                    this.f4448b = true;
                    this.f4445a.cancel();
                    h(t);
                    return;
                }
                this.b = 1 + c;
            }
        }

        public void onError(Throwable t) {
            if (this.f4448b) {
                of0.l(t);
                return;
            }
            this.f4448b = true;
            this.a.onError(t);
        }

        public void a() {
            if (!this.f4448b) {
                this.f4448b = true;
                T v = this.f4447b;
                if (v != null) {
                    h(v);
                } else if (this.f4446a) {
                    this.a.onError(new NoSuchElementException());
                } else {
                    this.a.a();
                }
            }
        }

        public void cancel() {
            super.cancel();
            this.f4445a.cancel();
        }
    }
}
