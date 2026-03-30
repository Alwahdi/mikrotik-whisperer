package defpackage;

/* renamed from: mm  reason: default package */
public final class mm<T> extends n<T, T> {
    final ic<? super T> a;

    /* renamed from: a  reason: collision with other field name */
    final k0 f4367a;
    final ic<? super Throwable> b;

    /* renamed from: b  reason: collision with other field name */
    final k0 f4368b;

    public mm(km<T> source, ic<? super T> onNext, ic<? super Throwable> onError, k0 onComplete, k0 onAfterTerminate) {
        super(source);
        this.a = onNext;
        this.b = onError;
        this.f4367a = onComplete;
        this.f4368b = onAfterTerminate;
    }

    /* access modifiers changed from: protected */
    public void z(ho0<? super T> s) {
        if (s instanceof zb) {
            this.a.y(new a((zb) s, this.a, this.b, this.f4367a, this.f4368b));
            return;
        }
        this.a.y(new b(s, this.a, this.b, this.f4367a, this.f4368b));
    }

    /* renamed from: mm$b */
    static final class b<T> extends d6<T, T> {
        final ic<? super T> a;

        /* renamed from: a  reason: collision with other field name */
        final k0 f4371a;
        final ic<? super Throwable> b;

        /* renamed from: b  reason: collision with other field name */
        final k0 f4372b;

        b(ho0<? super T> actual, ic<? super T> onNext, ic<? super Throwable> onError, k0 onComplete, k0 onAfterTerminate) {
            super(actual);
            this.a = onNext;
            this.b = onError;
            this.f4371a = onComplete;
            this.f4372b = onAfterTerminate;
        }

        public void c(T t) {
            if (!this.f2712a) {
                if (this.a != 0) {
                    this.f2709a.c(null);
                    return;
                }
                try {
                    this.a.accept(t);
                    this.f2709a.c(t);
                } catch (Throwable e) {
                    g(e);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f2712a) {
                of0.l(t);
                return;
            }
            this.f2712a = true;
            boolean relay = true;
            try {
                this.b.accept(t);
            } catch (Throwable e) {
                oj.b(e);
                this.f2709a.onError(new rb(t, e));
                relay = false;
            }
            if (relay) {
                this.f2709a.onError(t);
            }
            try {
                this.f4372b.run();
            } catch (Throwable e2) {
                oj.b(e2);
                of0.l(e2);
            }
        }

        public void a() {
            if (!this.f2712a) {
                try {
                    this.f4371a.run();
                    this.f2712a = true;
                    this.f2709a.a();
                    try {
                        this.f4372b.run();
                    } catch (Throwable e) {
                        oj.b(e);
                        of0.l(e);
                    }
                } catch (Throwable e2) {
                    g(e2);
                }
            }
        }

        public int requestFusion(int mode) {
            return h(mode);
        }

        public T poll() {
            try {
                T v = this.f2711a.poll();
                if (v != null) {
                    try {
                        this.a.accept(v);
                        this.f4372b.run();
                    } catch (Throwable exc) {
                        throw new rb(ex, exc);
                    }
                } else if (this.a == 1) {
                    this.f4371a.run();
                    this.f4372b.run();
                }
                return v;
            } catch (Throwable exc2) {
                throw new rb(ex, exc2);
            }
        }
    }

    /* renamed from: mm$a */
    static final class a<T> extends c6<T, T> {
        final ic<? super T> a;

        /* renamed from: a  reason: collision with other field name */
        final k0 f4369a;
        final ic<? super Throwable> b;

        /* renamed from: b  reason: collision with other field name */
        final k0 f4370b;

        a(zb<? super T> actual, ic<? super T> onNext, ic<? super Throwable> onError, k0 onComplete, k0 onAfterTerminate) {
            super(actual);
            this.a = onNext;
            this.b = onError;
            this.f4369a = onComplete;
            this.f4370b = onAfterTerminate;
        }

        public void c(T t) {
            if (!this.f289a) {
                if (this.a != 0) {
                    this.f288a.c(null);
                    return;
                }
                try {
                    this.a.accept(t);
                    this.f288a.c(t);
                } catch (Throwable e) {
                    g(e);
                }
            }
        }

        public boolean f(T t) {
            if (this.f289a) {
                return false;
            }
            try {
                this.a.accept(t);
                return this.f288a.f(t);
            } catch (Throwable e) {
                g(e);
                return false;
            }
        }

        public void onError(Throwable t) {
            if (this.f289a) {
                of0.l(t);
                return;
            }
            this.f289a = true;
            boolean relay = true;
            try {
                this.b.accept(t);
            } catch (Throwable e) {
                oj.b(e);
                this.f288a.onError(new rb(t, e));
                relay = false;
            }
            if (relay) {
                this.f288a.onError(t);
            }
            try {
                this.f4370b.run();
            } catch (Throwable e2) {
                oj.b(e2);
                of0.l(e2);
            }
        }

        public void a() {
            if (!this.f289a) {
                try {
                    this.f4369a.run();
                    this.f289a = true;
                    this.f288a.a();
                    try {
                        this.f4370b.run();
                    } catch (Throwable e) {
                        oj.b(e);
                        of0.l(e);
                    }
                } catch (Throwable e2) {
                    g(e2);
                }
            }
        }

        public int requestFusion(int mode) {
            return h(mode);
        }

        public T poll() {
            try {
                T v = this.f287a.poll();
                if (v != null) {
                    try {
                        this.a.accept(v);
                        this.f4370b.run();
                    } catch (Throwable exc) {
                        throw new rb(ex, exc);
                    }
                } else if (this.a == 1) {
                    this.f4369a.run();
                    this.f4370b.run();
                }
                return v;
            } catch (Throwable exc2) {
                throw new rb(ex, exc2);
            }
        }
    }
}
