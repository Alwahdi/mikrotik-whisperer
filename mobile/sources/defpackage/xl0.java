package defpackage;

/* renamed from: xl0  reason: default package */
public final class xl0<T, R> extends vl0<R> {
    final bm0<? extends T> a;

    /* renamed from: a  reason: collision with other field name */
    final mo<? super T, ? extends R> f5747a;

    public xl0(bm0<? extends T> source, mo<? super T, ? extends R> mapper) {
        this.a = source;
        this.f5747a = mapper;
    }

    /* access modifiers changed from: protected */
    public void f(zl0<? super R> t) {
        this.a.b(new a(t, this.f5747a));
    }

    /* renamed from: xl0$a */
    static final class a<T, R> implements zl0<T> {
        final mo<? super T, ? extends R> a;

        /* renamed from: a  reason: collision with other field name */
        final zl0<? super R> f5748a;

        a(zl0<? super R> t, mo<? super T, ? extends R> mapper) {
            this.f5748a = t;
            this.a = mapper;
        }

        public void b(yg d) {
            this.f5748a.b(d);
        }

        public void e(T value) {
            try {
                this.f5748a.e(a40.c(this.a.apply(value), "The mapper function returned a null value."));
            } catch (Throwable e) {
                oj.b(e);
                onError(e);
            }
        }

        public void onError(Throwable e) {
            this.f5748a.onError(e);
        }
    }
}
