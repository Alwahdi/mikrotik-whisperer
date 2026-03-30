package defpackage;

/* renamed from: xm  reason: default package */
public final class xm<T, U> extends n<T, U> {
    final mo<? super T, ? extends U> a;

    public xm(km<T> source, mo<? super T, ? extends U> mapper) {
        super(source);
        this.a = mapper;
    }

    /* access modifiers changed from: protected */
    public void z(ho0<? super U> s) {
        if (s instanceof zb) {
            this.a.y(new a((zb) s, this.a));
        } else {
            this.a.y(new b(s, this.a));
        }
    }

    /* renamed from: xm$b */
    static final class b<T, U> extends d6<T, U> {
        final mo<? super T, ? extends U> a;

        b(ho0<? super U> actual, mo<? super T, ? extends U> mapper) {
            super(actual);
            this.a = mapper;
        }

        public void c(T t) {
            if (!this.f2712a) {
                if (this.a != 0) {
                    this.f2709a.c(null);
                    return;
                }
                try {
                    this.f2709a.c(a40.c(this.a.apply(t), "The mapper function returned a null value."));
                } catch (Throwable ex) {
                    g(ex);
                }
            }
        }

        public int requestFusion(int mode) {
            return h(mode);
        }

        public U poll() {
            T t = this.f2711a.poll();
            if (t != null) {
                return a40.c(this.a.apply(t), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    /* renamed from: xm$a */
    static final class a<T, U> extends c6<T, U> {
        final mo<? super T, ? extends U> a;

        a(zb<? super U> actual, mo<? super T, ? extends U> function) {
            super(actual);
            this.a = function;
        }

        public void c(T t) {
            if (!this.f289a) {
                if (this.a != 0) {
                    this.f288a.c(null);
                    return;
                }
                try {
                    this.f288a.c(a40.c(this.a.apply(t), "The mapper function returned a null value."));
                } catch (Throwable ex) {
                    g(ex);
                }
            }
        }

        public boolean f(T t) {
            if (this.f289a) {
                return false;
            }
            try {
                return this.f288a.f(a40.c(this.a.apply(t), "The mapper function returned a null value."));
            } catch (Throwable ex) {
                g(ex);
                return true;
            }
        }

        public int requestFusion(int mode) {
            return h(mode);
        }

        public U poll() {
            T t = this.f287a.poll();
            if (t != null) {
                return a40.c(this.a.apply(t), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
