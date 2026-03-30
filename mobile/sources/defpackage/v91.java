package defpackage;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* renamed from: v91  reason: default package */
final class v91<TResult> extends eq0<TResult> {
    private Exception a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f5377a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final n91<TResult> f5378a = new n91<>();

    /* renamed from: a  reason: collision with other field name */
    private boolean f5379a;
    private TResult b;

    /* renamed from: b  reason: collision with other field name */
    private volatile boolean f5380b;

    v91() {
    }

    public final boolean q() {
        boolean z;
        synchronized (this.f5377a) {
            z = this.f5379a;
        }
        return z;
    }

    /* renamed from: v91$a */
    private static class a extends LifecycleCallback {
        private final List<WeakReference<j91<?>>> a = new ArrayList();

        public static a k(Activity activity) {
            dx c = LifecycleCallback.c(activity);
            a aVar = (a) c.h("TaskOnStopCallback", a.class);
            if (aVar == null) {
                return new a(c);
            }
            return aVar;
        }

        private a(dx dxVar) {
            super(dxVar);
            this.a.e("TaskOnStopCallback", this);
        }

        public final <T> void l(j91<T> j91) {
            synchronized (this.a) {
                this.a.add(new WeakReference(j91));
            }
        }

        public void j() {
            synchronized (this.a) {
                for (WeakReference<j91<?>> weakReference : this.a) {
                    j91 j91 = (j91) weakReference.get();
                    if (j91 != null) {
                        j91.cancel();
                    }
                }
                this.a.clear();
            }
        }
    }

    public final boolean p() {
        return this.f5380b;
    }

    public final boolean r() {
        boolean z;
        synchronized (this.f5377a) {
            z = this.f5379a && !this.f5380b && this.a == null;
        }
        return z;
    }

    public final TResult n() {
        TResult tresult;
        synchronized (this.f5377a) {
            y();
            A();
            if (this.a == null) {
                tresult = this.b;
            } else {
                throw new mf0(this.a);
            }
        }
        return tresult;
    }

    public final <X extends Throwable> TResult o(Class<X> cls) {
        TResult tresult;
        synchronized (this.f5377a) {
            y();
            A();
            if (cls.isInstance(this.a)) {
                throw ((Throwable) cls.cast(this.a));
            } else if (this.a == null) {
                tresult = this.b;
            } else {
                throw new mf0(this.a);
            }
        }
        return tresult;
    }

    public final Exception m() {
        Exception exc;
        synchronized (this.f5377a) {
            exc = this.a;
        }
        return exc;
    }

    public final eq0<TResult> g(t40<? super TResult> t40) {
        return h(jq0.a, t40);
    }

    public final eq0<TResult> h(Executor executor, t40<? super TResult> t40) {
        this.f5378a.b(new u81(executor, t40));
        B();
        return this;
    }

    public final eq0<TResult> e(r40 r40) {
        return f(jq0.a, r40);
    }

    public final eq0<TResult> f(Executor executor, r40 r40) {
        this.f5378a.b(new m81(executor, r40));
        B();
        return this;
    }

    public final eq0<TResult> b(o40<TResult> o40) {
        return d(jq0.a, o40);
    }

    public final eq0<TResult> d(Executor executor, o40<TResult> o40) {
        this.f5378a.b(new a81(executor, o40));
        B();
        return this;
    }

    public final eq0<TResult> c(Activity activity, o40<TResult> o40) {
        a81 a81 = new a81(jq0.a, o40);
        this.f5378a.b(a81);
        a.k(activity).l(a81);
        B();
        return this;
    }

    public final <TContinuationResult> eq0<TContinuationResult> i(sc<TResult, TContinuationResult> scVar) {
        return j(jq0.a, scVar);
    }

    public final <TContinuationResult> eq0<TContinuationResult> j(Executor executor, sc<TResult, TContinuationResult> scVar) {
        v91 v91 = new v91();
        this.f5378a.b(new d31(executor, scVar, v91));
        B();
        return v91;
    }

    public final <TContinuationResult> eq0<TContinuationResult> k(sc<TResult, eq0<TContinuationResult>> scVar) {
        return l(jq0.a, scVar);
    }

    public final eq0<TResult> a(Executor executor, n40 n40) {
        this.f5378a.b(new k71(executor, n40));
        B();
        return this;
    }

    public final <TContinuationResult> eq0<TContinuationResult> l(Executor executor, sc<TResult, eq0<TContinuationResult>> scVar) {
        v91 v91 = new v91();
        this.f5378a.b(new e51(executor, scVar, v91));
        B();
        return v91;
    }

    public final <TContinuationResult> eq0<TContinuationResult> s(Executor executor, lo0<TResult, TContinuationResult> lo0) {
        v91 v91 = new v91();
        this.f5378a.b(new a91(executor, lo0, v91));
        B();
        return v91;
    }

    public final void u(TResult tresult) {
        synchronized (this.f5377a) {
            z();
            this.f5379a = true;
            this.b = tresult;
        }
        this.f5378a.a(this);
    }

    public final boolean w(TResult tresult) {
        synchronized (this.f5377a) {
            if (this.f5379a) {
                return false;
            }
            this.f5379a = true;
            this.b = tresult;
            this.f5378a.a(this);
            return true;
        }
    }

    public final void t(Exception exc) {
        y90.k(exc, "Exception must not be null");
        synchronized (this.f5377a) {
            z();
            this.f5379a = true;
            this.a = exc;
        }
        this.f5378a.a(this);
    }

    public final boolean v(Exception exc) {
        y90.k(exc, "Exception must not be null");
        synchronized (this.f5377a) {
            if (this.f5379a) {
                return false;
            }
            this.f5379a = true;
            this.a = exc;
            this.f5378a.a(this);
            return true;
        }
    }

    public final boolean x() {
        synchronized (this.f5377a) {
            if (this.f5379a) {
                return false;
            }
            this.f5379a = true;
            this.f5380b = true;
            this.f5378a.a(this);
            return true;
        }
    }

    private final void y() {
        y90.m(this.f5379a, "Task is not yet complete");
    }

    private final void z() {
        y90.m(!this.f5379a, "Task is already complete");
    }

    private final void A() {
        if (this.f5380b) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void B() {
        synchronized (this.f5377a) {
            if (this.f5379a) {
                this.f5378a.a(this);
            }
        }
    }
}
