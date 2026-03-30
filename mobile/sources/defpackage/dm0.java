package defpackage;

/* renamed from: dm0  reason: default package */
public final class dm0<T> extends km<T> {
    final bm0<? extends T> a;

    public dm0(bm0<? extends T> source) {
        this.a = source;
    }

    public void z(ho0<? super T> s) {
        this.a.b(new a(s));
    }

    /* renamed from: dm0$a */
    static final class a<T> extends wf<T> implements zl0<T> {
        yg a;

        a(ho0<? super T> actual) {
            super(actual);
        }

        public void b(yg d) {
            if (io.reactivex.internal.disposables.a.validate(this.a, d)) {
                this.a = d;
                this.a.d(this);
            }
        }

        public void e(T value) {
            h(value);
        }

        public void onError(Throwable e) {
            this.a.onError(e);
        }

        public void cancel() {
            super.cancel();
            this.a.dispose();
        }
    }
}
