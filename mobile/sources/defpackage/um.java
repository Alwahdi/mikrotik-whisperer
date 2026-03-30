package defpackage;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import org.reactivestreams.Subscriber;

/* renamed from: um  reason: default package */
public final class um<T> extends km<T> {
    final T[] a;

    public um(T[] array) {
        this.a = array;
    }

    public void z(ho0<? super T> s) {
        if (s instanceof zb) {
            s.d(new a((zb) s, this.a));
        } else {
            s.d(new b(s, this.a));
        }
    }

    /* renamed from: um$c */
    static abstract class c<T> extends f6<T> {
        int a;

        /* renamed from: a  reason: collision with other field name */
        volatile boolean f5246a;

        /* renamed from: a  reason: collision with other field name */
        final T[] f5247a;

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract void b(long j);

        c(T[] array) {
            this.f5247a = array;
        }

        public final int requestFusion(int mode) {
            return mode & 1;
        }

        public final T poll() {
            int i = this.a;
            T[] arr = this.f5247a;
            if (i == arr.length) {
                return null;
            }
            this.a = i + 1;
            return a40.c(arr[i], "array element is null");
        }

        public final boolean isEmpty() {
            return this.a == this.f5247a.length;
        }

        public final void clear() {
            this.a = this.f5247a.length;
        }

        public final void request(long n) {
            if (io.reactivex.internal.subscriptions.b.validate(n) && m5.a(this, n) == 0) {
                if (n == LocationRequestCompat.PASSIVE_INTERVAL) {
                    a();
                } else {
                    b(n);
                }
            }
        }

        public final void cancel() {
            this.f5246a = true;
        }
    }

    /* renamed from: um$b */
    static final class b<T> extends c<T> {
        final ho0<? super T> a;

        b(ho0<? super T> actual, T[] array) {
            super(array);
            this.a = actual;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            T[] arr = this.f5247a;
            int f = arr.length;
            Subscriber<? super T> a2 = this.a;
            int i = this.a;
            while (i != f) {
                if (!this.f5246a) {
                    T t = arr[i];
                    if (t == null) {
                        a2.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        a2.c(t);
                        i++;
                    }
                } else {
                    return;
                }
            }
            if (this.f5246a == 0) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long r) {
            long e = 0;
            T[] arr = this.f5247a;
            int f = arr.length;
            int i = this.a;
            Subscriber<? super T> a2 = this.a;
            while (true) {
                if (e == r || i == f) {
                    if (i != f) {
                        r = get();
                        if (e == r) {
                            this.a = i;
                            r = addAndGet(-e);
                            if (r != 0) {
                                e = 0;
                            } else {
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f5246a) {
                        a2.a();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.f5246a) {
                    T t = arr[i];
                    if (t == null) {
                        a2.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    a2.c(t);
                    e++;
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: um$a */
    static final class a<T> extends c<T> {
        final zb<? super T> a;

        a(zb<? super T> actual, T[] array) {
            super(array);
            this.a = actual;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            T[] arr = this.f5247a;
            int f = arr.length;
            ConditionalSubscriber<? super T> a2 = this.a;
            int i = this.a;
            while (i != f) {
                if (!this.f5246a) {
                    T t = arr[i];
                    if (t == null) {
                        a2.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        a2.f(t);
                        i++;
                    }
                } else {
                    return;
                }
            }
            if (this.f5246a == 0) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long r) {
            long e = 0;
            T[] arr = this.f5247a;
            int f = arr.length;
            int i = this.a;
            ConditionalSubscriber<? super T> a2 = this.a;
            while (true) {
                if (e == r || i == f) {
                    if (i != f) {
                        r = get();
                        if (e == r) {
                            this.a = i;
                            r = addAndGet(-e);
                            if (r != 0) {
                                e = 0;
                            } else {
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f5246a) {
                        a2.a();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.f5246a) {
                    T t = arr[i];
                    if (t == null) {
                        a2.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    if (a2.f(t)) {
                        e++;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
