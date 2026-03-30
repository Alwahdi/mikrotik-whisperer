package defpackage;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.subscriptions.b;
import java.util.Collection;
import java.util.concurrent.Callable;

/* renamed from: gn  reason: default package */
public final class gn<T, U extends Collection<? super T>> extends n<T, U> {
    final Callable<U> a;

    public gn(km<T> source, Callable<U> collectionSupplier) {
        super(source);
        this.a = collectionSupplier;
    }

    /* access modifiers changed from: protected */
    public void z(ho0<? super U> s) {
        try {
            this.a.y(new a(s, (Collection) a40.c(this.a.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable e) {
            oj.b(e);
            io.reactivex.internal.subscriptions.a.error(e, s);
        }
    }

    /* renamed from: gn$a */
    static final class a<T, U extends Collection<? super T>> extends wf<U> implements en<T>, jo0 {
        jo0 a;

        /* JADX WARNING: type inference failed for: r2v0, types: [T, U] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        a(defpackage.ho0<? super U> r1, U r2) {
            /*
                r0 = this;
                r0.<init>(r1)
                r0.f5484a = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.gn.a.<init>(ho0, java.util.Collection):void");
        }

        public void d(jo0 s) {
            if (b.validate(this.a, s)) {
                this.a = s;
                this.a.d(this);
                s.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }

        public void c(T t) {
            U v = (Collection) this.f5484a;
            if (v != null) {
                v.add(t);
            }
        }

        public void onError(Throwable t) {
            this.f5484a = null;
            this.a.onError(t);
        }

        public void a() {
            h(this.f5484a);
        }

        public void cancel() {
            super.cancel();
            this.a.cancel();
        }
    }
}
