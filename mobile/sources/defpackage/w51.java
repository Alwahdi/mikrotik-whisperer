package defpackage;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.firebase.auth.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: w51  reason: default package */
abstract class w51<ResultT, CallbackT> implements f01<w41, ResultT> {
    protected final int a;

    /* renamed from: a  reason: collision with other field name */
    protected a71 f5432a;

    /* renamed from: a  reason: collision with other field name */
    private Activity f5433a;

    /* renamed from: a  reason: collision with other field name */
    protected b61 f5434a;

    /* renamed from: a  reason: collision with other field name */
    private Status f5435a;

    /* renamed from: a  reason: collision with other field name */
    protected com.google.firebase.auth.a f5436a;

    /* renamed from: a  reason: collision with other field name */
    protected dm f5437a;

    /* renamed from: a  reason: collision with other field name */
    protected gl f5438a;

    /* renamed from: a  reason: collision with other field name */
    protected CallbackT f5439a;

    /* renamed from: a  reason: collision with other field name */
    protected String f5440a;

    /* renamed from: a  reason: collision with other field name */
    protected final List<h.b> f5441a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    protected Executor f5442a;

    /* renamed from: a  reason: collision with other field name */
    protected jz0 f5443a;

    /* renamed from: a  reason: collision with other field name */
    protected p51 f5444a;

    /* renamed from: a  reason: collision with other field name */
    protected s61 f5445a;

    /* renamed from: a  reason: collision with other field name */
    protected u51 f5446a;

    /* renamed from: a  reason: collision with other field name */
    protected x51<ResultT> f5447a;

    /* renamed from: a  reason: collision with other field name */
    final y51 f5448a = new y51(this);

    /* renamed from: a  reason: collision with other field name */
    protected boolean f5449a;
    private ResultT b;

    /* renamed from: b  reason: collision with other field name */
    protected String f5450b;

    /* renamed from: b  reason: collision with other field name */
    protected boolean f5451b;
    protected String c;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public boolean f5452c;
    protected String d;

    /* renamed from: d  reason: collision with other field name */
    boolean f5453d;

    public w51(int i) {
        this.a = i;
    }

    public abstract void p();

    /* renamed from: w51$a */
    static class a extends LifecycleCallback {
        private final List<h.b> a;

        public static void k(Activity activity, List<h.b> list) {
            dx c = LifecycleCallback.c(activity);
            if (((a) c.h("PhoneAuthActivityStopCallback", a.class)) == null) {
                new a(c, list);
            }
        }

        private a(dx dxVar, List<h.b> list) {
            super(dxVar);
            this.a.e("PhoneAuthActivityStopCallback", this);
            this.a = list;
        }

        public void j() {
            synchronized (this.a) {
                this.a.clear();
            }
        }
    }

    public final w51<ResultT, CallbackT> e(gl glVar) {
        this.f5438a = (gl) y90.k(glVar, "firebaseApp cannot be null");
        return this;
    }

    public final w51<ResultT, CallbackT> f(dm dmVar) {
        this.f5437a = (dm) y90.k(dmVar, "firebaseUser cannot be null");
        return this;
    }

    public final w51<ResultT, CallbackT> h(CallbackT callbackt) {
        this.f5439a = y90.k(callbackt, "external callback cannot be null");
        return this;
    }

    public final w51<ResultT, CallbackT> i(jz0 jz0) {
        this.f5443a = (jz0) y90.k(jz0, "external failure callback cannot be null");
        return this;
    }

    public final w51<ResultT, CallbackT> g(h.b bVar, Activity activity, Executor executor) {
        synchronized (this.f5441a) {
            this.f5441a.add((h.b) y90.j(bVar));
        }
        this.f5433a = activity;
        if (activity != null) {
            a.k(activity, this.f5441a);
        }
        this.f5442a = (Executor) y90.j(executor);
        return this;
    }

    public final f01<w41, ResultT> c() {
        this.f5449a = true;
        return this;
    }

    public final f01<w41, ResultT> a() {
        this.f5451b = true;
        return this;
    }

    public final void o(ResultT resultt) {
        this.f5452c = true;
        this.f5453d = true;
        this.b = resultt;
        this.f5447a.a(resultt, (Status) null);
    }

    public final void j(Status status) {
        this.f5452c = true;
        this.f5453d = false;
        this.f5435a = status;
        this.f5447a.a(null, status);
    }

    /* access modifiers changed from: private */
    public final void q() {
        p();
        y90.m(this.f5452c, "no success or failure set on method implementation");
    }

    /* access modifiers changed from: private */
    public final void n(Status status) {
        jz0 jz0 = this.f5443a;
        if (jz0 != null) {
            jz0.d(status);
        }
    }
}
