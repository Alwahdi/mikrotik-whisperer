package defpackage;

import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* renamed from: lm  reason: default package */
public final class lm<T> extends km<T> {
    final io.reactivex.a a;

    /* renamed from: a  reason: collision with other field name */
    final zm<T> f4258a;

    public lm(zm<T> source, io.reactivex.a backpressure) {
        this.f4258a = source;
        this.a = backpressure;
    }

    /* renamed from: lm$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.reactivex.a.values().length];
            a = iArr;
            try {
                iArr[io.reactivex.a.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[io.reactivex.a.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[io.reactivex.a.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[io.reactivex.a.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void z(ho0<? super T> t) {
        FlowableCreate.BaseEmitter<T> emitter;
        switch (a.a[this.a.ordinal()]) {
            case 1:
                emitter = new g<>(t);
                break;
            case 2:
                emitter = new e<>(t);
                break;
            case 3:
                emitter = new d<>(t);
                break;
            case 4:
                emitter = new f<>(t);
                break;
            default:
                emitter = new c<>(t, km.b());
                break;
        }
        t.d(emitter);
        try {
            this.f4258a.a(emitter);
        } catch (Throwable ex) {
            oj.b(ex);
            emitter.h(ex);
        }
    }

    /* renamed from: lm$b */
    static abstract class b<T> extends AtomicLong implements pm<T>, jo0 {
        final ho0<? super T> a;

        /* renamed from: a  reason: collision with other field name */
        final lk0 f4259a = new lk0();

        b(ho0<? super T> actual) {
            this.a = actual;
        }

        public void a() {
            d();
        }

        /* access modifiers changed from: protected */
        public void d() {
            if (!f()) {
                try {
                    this.a.a();
                } finally {
                    this.f4259a.dispose();
                }
            }
        }

        public final void h(Throwable e) {
            if (!b(e)) {
                of0.l(e);
            }
        }

        public boolean b(Throwable e) {
            return e(e);
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        public boolean e(Throwable e) {
            if (e == null) {
                e = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (f()) {
                return false;
            }
            try {
                this.a.onError(e);
                this.f4259a.dispose();
                return true;
            } catch (Throwable th) {
                this.f4259a.dispose();
                throw th;
            }
        }

        public final void cancel() {
            this.f4259a.dispose();
            j();
        }

        /* access modifiers changed from: package-private */
        public void j() {
        }

        public final boolean f() {
            return this.f4259a.a();
        }

        public final void request(long n) {
            if (io.reactivex.internal.subscriptions.b.validate(n)) {
                m5.a(this, n);
                i();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
        }
    }

    /* renamed from: lm$g */
    static final class g<T> extends b<T> {
        g(ho0<? super T> actual) {
            super(actual);
        }

        public void c(T t) {
            long r;
            if (!f()) {
                if (t != null) {
                    this.a.c(t);
                    do {
                        r = get();
                        if (r == 0 || compareAndSet(r, r - 1)) {
                            return;
                        }
                        r = get();
                        return;
                    } while (compareAndSet(r, r - 1));
                    return;
                }
                h(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    /* renamed from: lm$h */
    static abstract class h<T> extends b<T> {
        /* access modifiers changed from: package-private */
        public abstract void k();

        h(ho0<? super T> actual) {
            super(actual);
        }

        public final void c(T t) {
            if (!f()) {
                if (t == null) {
                    h(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else if (get() != 0) {
                    this.a.c(t);
                    m5.c(this, 1);
                } else {
                    k();
                }
            }
        }
    }

    /* renamed from: lm$d */
    static final class d<T> extends h<T> {
        d(ho0<? super T> actual) {
            super(actual);
        }

        /* access modifiers changed from: package-private */
        public void k() {
        }
    }

    /* renamed from: lm$e */
    static final class e<T> extends h<T> {
        e(ho0<? super T> actual) {
            super(actual);
        }

        /* access modifiers changed from: package-private */
        public void k() {
            h(new a20("create: could not emit value due to lack of requests"));
        }
    }

    /* renamed from: lm$c */
    static final class c<T> extends b<T> {
        Throwable a;

        /* renamed from: a  reason: collision with other field name */
        final AtomicInteger f4260a = new AtomicInteger();

        /* renamed from: a  reason: collision with other field name */
        final sm0<T> f4261a;

        /* renamed from: a  reason: collision with other field name */
        volatile boolean f4262a;

        c(ho0<? super T> actual, int capacityHint) {
            super(actual);
            this.f4261a = new sm0<>(capacityHint);
        }

        public void c(T t) {
            if (!this.f4262a && !f()) {
                if (t == null) {
                    h(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f4261a.offer(t);
                k();
            }
        }

        public boolean b(Throwable e) {
            if (this.f4262a || f()) {
                return false;
            }
            if (e == null) {
                e = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.a = e;
            this.f4262a = true;
            k();
            return true;
        }

        public void a() {
            this.f4262a = true;
            k();
        }

        /* access modifiers changed from: package-private */
        public void i() {
            k();
        }

        /* access modifiers changed from: package-private */
        public void j() {
            if (this.f4260a.getAndIncrement() == 0) {
                this.f4261a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void k() {
            if (this.f4260a.getAndIncrement() == 0) {
                int missed = 1;
                Subscriber<? super T> a2 = this.a;
                SpscLinkedArrayQueue<T> q = this.f4261a;
                do {
                    long r = get();
                    long e = 0;
                    while (e != r) {
                        if (f()) {
                            q.clear();
                            return;
                        }
                        boolean d = this.f4262a;
                        T o = q.poll();
                        boolean empty = o == null;
                        if (d && empty) {
                            Throwable ex = this.a;
                            if (ex != null) {
                                e(ex);
                                return;
                            } else {
                                d();
                                return;
                            }
                        } else if (empty) {
                            break;
                        } else {
                            a2.c(o);
                            e++;
                        }
                    }
                    if (e == r) {
                        if (f()) {
                            q.clear();
                            return;
                        }
                        boolean d2 = this.f4262a;
                        boolean empty2 = q.isEmpty();
                        if (d2 && empty2) {
                            Throwable ex2 = this.a;
                            if (ex2 != null) {
                                e(ex2);
                                return;
                            } else {
                                d();
                                return;
                            }
                        }
                    }
                    if (e != 0) {
                        m5.c(this, e);
                    }
                    missed = this.f4260a.addAndGet(-missed);
                } while (missed != 0);
            }
        }
    }

    /* renamed from: lm$f */
    static final class f<T> extends b<T> {
        Throwable a;

        /* renamed from: a  reason: collision with other field name */
        final AtomicInteger f4263a = new AtomicInteger();

        /* renamed from: a  reason: collision with other field name */
        final AtomicReference<T> f4264a = new AtomicReference<>();

        /* renamed from: a  reason: collision with other field name */
        volatile boolean f4265a;

        f(ho0<? super T> actual) {
            super(actual);
        }

        public void c(T t) {
            if (!this.f4265a && !f()) {
                if (t == null) {
                    h(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f4264a.set(t);
                k();
            }
        }

        public boolean b(Throwable e) {
            if (this.f4265a || f()) {
                return false;
            }
            if (e == null) {
                h(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.a = e;
            this.f4265a = true;
            k();
            return true;
        }

        public void a() {
            this.f4265a = true;
            k();
        }

        /* access modifiers changed from: package-private */
        public void i() {
            k();
        }

        /* access modifiers changed from: package-private */
        public void j() {
            if (this.f4263a.getAndIncrement() == 0) {
                this.f4264a.lazySet((Object) null);
            }
        }

        /* access modifiers changed from: package-private */
        public void k() {
            boolean empty;
            if (this.f4263a.getAndIncrement() == 0) {
                int missed = 1;
                Subscriber<? super T> a2 = this.a;
                AtomicReference<T> q = this.f4264a;
                do {
                    long r = get();
                    long e = 0;
                    while (true) {
                        empty = true;
                        if (e == r) {
                            break;
                        } else if (f()) {
                            q.lazySet((Object) null);
                            return;
                        } else {
                            boolean d = this.f4265a;
                            T o = q.getAndSet((Object) null);
                            boolean empty2 = o == null;
                            if (d && empty2) {
                                Throwable ex = this.a;
                                if (ex != null) {
                                    e(ex);
                                    return;
                                } else {
                                    d();
                                    return;
                                }
                            } else if (empty2) {
                                break;
                            } else {
                                a2.c(o);
                                e++;
                            }
                        }
                    }
                    if (e == r) {
                        if (f()) {
                            q.lazySet((Object) null);
                            return;
                        }
                        boolean d2 = this.f4265a;
                        if (q.get() != null) {
                            empty = false;
                        }
                        if (d2 && empty) {
                            Throwable ex2 = this.a;
                            if (ex2 != null) {
                                e(ex2);
                                return;
                            } else {
                                d();
                                return;
                            }
                        }
                    }
                    if (e != 0) {
                        m5.c(this, e);
                    }
                    missed = this.f4263a.addAndGet(-missed);
                } while (missed != 0);
            }
        }
    }
}
