package defpackage;

import com.google.firebase.firestore.i;

/* renamed from: ll  reason: default package */
public final class ll extends vd {
    private int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final cu f4253a;

    /* renamed from: a  reason: collision with other field name */
    private px<yt0> f4254a;

    /* renamed from: a  reason: collision with other field name */
    private final qr f4255a;

    /* renamed from: a  reason: collision with other field name */
    private yt0 f4256a = d();

    /* renamed from: a  reason: collision with other field name */
    private boolean f4257a;

    public ll(cu authProvider) {
        this.f4253a = authProvider;
        qr b = jl.b(this);
        this.f4255a = b;
        authProvider.a(b);
    }

    static /* synthetic */ void f(ll llVar, ju token) {
        synchronized (llVar) {
            yt0 d = llVar.d();
            llVar.f4256a = d;
            llVar.a++;
            px<yt0> pxVar = llVar.f4254a;
            if (pxVar != null) {
                pxVar.a(d);
            }
        }
    }

    public synchronized eq0<String> a() {
        boolean doForceRefresh;
        doForceRefresh = this.f4257a;
        this.f4257a = false;
        return this.f4253a.c(doForceRefresh).i(kl.b(this, this.a));
    }

    static /* synthetic */ String e(ll llVar, int savedCounter, eq0 task) {
        String c;
        synchronized (llVar) {
            if (savedCounter != llVar.a) {
                throw new i("getToken aborted due to token change", i.a.ABORTED);
            } else if (task.r()) {
                c = ((hp) task.n()).c();
            } else {
                throw task.m();
            }
        }
        return c;
    }

    public synchronized void b() {
        this.f4257a = true;
    }

    public synchronized void c(px<yt0> changeListener) {
        this.f4254a = changeListener;
        changeListener.a(this.f4256a);
    }

    private yt0 d() {
        String uid = this.f4253a.b();
        return uid != null ? new yt0(uid) : yt0.a;
    }
}
