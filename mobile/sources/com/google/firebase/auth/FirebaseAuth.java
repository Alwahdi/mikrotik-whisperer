package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.h;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class FirebaseAuth implements cu {
    /* access modifiers changed from: private */
    public b91 a;

    /* renamed from: a  reason: collision with other field name */
    private dm f2143a;

    /* renamed from: a  reason: collision with other field name */
    private gl f2144a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f2145a;

    /* renamed from: a  reason: collision with other field name */
    private String f2146a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final List<b> f2147a;

    /* renamed from: a  reason: collision with other field name */
    private p01 f2148a;

    /* renamed from: a  reason: collision with other field name */
    private q01 f2149a;

    /* renamed from: a  reason: collision with other field name */
    private final s01 f2150a;

    /* renamed from: a  reason: collision with other field name */
    private u01 f2151a;

    /* renamed from: a  reason: collision with other field name */
    private final zz0 f2152a;
    private final Object b;

    /* renamed from: b  reason: collision with other field name */
    private String f2153b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final List<qr> f2154b;
    /* access modifiers changed from: private */
    public List<a> c;

    public interface a {
        void a(FirebaseAuth firebaseAuth);
    }

    public interface b {
        void a(FirebaseAuth firebaseAuth);
    }

    class c implements ny0 {
        c() {
        }

        public final void a(s61 s61, dm dmVar) {
            y90.j(s61);
            y90.j(dmVar);
            dmVar.x(s61);
            FirebaseAuth.this.l(dmVar, s61, true);
        }
    }

    class d implements ny0, jz0 {
        d() {
        }

        public final void a(s61 s61, dm dmVar) {
            y90.j(s61);
            y90.j(dmVar);
            dmVar.x(s61);
            FirebaseAuth.this.m(dmVar, s61, true, true);
        }

        public final void d(Status status) {
            if (status.m() == 17011 || status.m() == 17021 || status.m() == 17005 || status.m() == 17091) {
                FirebaseAuth.this.h();
            }
        }
    }

    @NonNull
    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) gl.j().g(FirebaseAuth.class);
    }

    @NonNull
    @Keep
    public static FirebaseAuth getInstance(@NonNull gl glVar) {
        return (FirebaseAuth) glVar.g(FirebaseAuth.class);
    }

    public FirebaseAuth(gl glVar) {
        this(glVar, l51.a(glVar.i(), new s51(glVar.m().b()).a()), new s01(glVar.i(), glVar.n()), zz0.a());
    }

    private FirebaseAuth(gl glVar, p01 p01, s01 s01, zz0 zz0) {
        s61 f;
        this.f2145a = new Object();
        this.b = new Object();
        this.f2144a = (gl) y90.j(glVar);
        this.f2148a = (p01) y90.j(p01);
        s01 s012 = (s01) y90.j(s01);
        this.f2150a = s012;
        this.a = new b91();
        zz0 zz02 = (zz0) y90.j(zz0);
        this.f2152a = zz02;
        this.f2147a = new CopyOnWriteArrayList();
        this.f2154b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.f2151a = u01.a();
        dm a2 = s012.a();
        this.f2143a = a2;
        if (!(a2 == null || (f = s012.f(a2)) == null)) {
            l(this.f2143a, f, false);
        }
        zz02.c(this);
    }

    public dm e() {
        return this.f2143a;
    }

    public String b() {
        dm dmVar = this.f2143a;
        if (dmVar == null) {
            return null;
        }
        return dmVar.r();
    }

    public final void l(dm dmVar, s61 s61, boolean z) {
        m(dmVar, s61, z, false);
    }

    /* access modifiers changed from: package-private */
    public final void m(dm dmVar, s61 s61, boolean z, boolean z2) {
        boolean z3;
        y90.j(dmVar);
        y90.j(s61);
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = this.f2143a != null && dmVar.r().equals(this.f2143a.r());
        if (z6 || !z2) {
            dm dmVar2 = this.f2143a;
            if (dmVar2 == null) {
                z4 = true;
            } else {
                boolean z7 = !dmVar2.D().t().equals(s61.t());
                if (!z6 || z7) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z5 = z3;
                if (!z6) {
                    z4 = true;
                }
            }
            y90.j(dmVar);
            dm dmVar3 = this.f2143a;
            if (dmVar3 == null) {
                this.f2143a = dmVar;
            } else {
                dmVar3.v(dmVar.p());
                if (!dmVar.s()) {
                    this.f2143a.y();
                }
                this.f2143a.z(dmVar.G().a());
            }
            if (z) {
                this.f2150a.c(this.f2143a);
            }
            if (z5) {
                dm dmVar4 = this.f2143a;
                if (dmVar4 != null) {
                    dmVar4.x(s61);
                }
                w(this.f2143a);
            }
            if (z4) {
                z(this.f2143a);
            }
            if (z) {
                this.f2150a.d(dmVar, s61);
            }
            x().c(this.f2143a.D());
        }
    }

    public final void k() {
        dm dmVar = this.f2143a;
        if (dmVar != null) {
            s01 s01 = this.f2150a;
            y90.j(dmVar);
            s01.e(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{dmVar.r()}));
            this.f2143a = null;
        }
        this.f2150a.e("com.google.firebase.auth.FIREBASE_USER");
        w((dm) null);
        z((dm) null);
    }

    private final synchronized void p(q01 q01) {
        this.f2149a = q01;
    }

    private final synchronized q01 x() {
        if (this.f2149a == null) {
            p(new q01(this.f2144a));
        }
        return this.f2149a;
    }

    public final gl q() {
        return this.f2144a;
    }

    public void a(qr qrVar) {
        y90.j(qrVar);
        this.f2154b.add(qrVar);
        x().b(this.f2154b.size());
    }

    private final void w(dm dmVar) {
        if (dmVar != null) {
            String r = dmVar.r();
            StringBuilder sb = new StringBuilder(String.valueOf(r).length() + 45);
            sb.append("Notifying id token listeners about user ( ");
            sb.append(r);
            sb.append(" ).");
            Log.d("FirebaseAuth", sb.toString());
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        this.f2151a.execute(new q(this, new ju(dmVar != null ? dmVar.F() : null)));
    }

    private final void z(dm dmVar) {
        if (dmVar != null) {
            String r = dmVar.r();
            StringBuilder sb = new StringBuilder(String.valueOf(r).length() + 47);
            sb.append("Notifying auth state listeners about user ( ");
            sb.append(r);
            sb.append(" ).");
            Log.d("FirebaseAuth", sb.toString());
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        this.f2151a.execute(new s(this));
    }

    public eq0<hp> c(boolean z) {
        return i(this.f2143a, z);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [a11, com.google.firebase.auth.r] */
    public final eq0<hp> i(dm dmVar, boolean z) {
        if (dmVar == null) {
            return lq0.d(y41.b(new Status(17495)));
        }
        s61 D = dmVar.D();
        if (!D.r() || z) {
            return this.f2148a.h(this.f2144a, dmVar, D.s(), new r(this));
        }
        return lq0.e(g01.a(D.t()));
    }

    public eq0<w4> f(a aVar) {
        y90.j(aVar);
        a r = aVar.r();
        if (r instanceof b) {
            b bVar = (b) r;
            if (!bVar.w()) {
                return this.f2148a.t(this.f2144a, bVar.t(), bVar.u(), this.f2153b, new c());
            }
            if (t(bVar.v())) {
                return lq0.d(y41.b(new Status(17072)));
            }
            return this.f2148a.j(this.f2144a, bVar, new c());
        } else if (!(r instanceof g)) {
            return this.f2148a.i(this.f2144a, r, this.f2153b, new c());
        } else {
            return this.f2148a.k(this.f2144a, (g) r, this.f2153b, new c());
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [a11, com.google.firebase.auth.FirebaseAuth$d] */
    /* JADX WARNING: type inference failed for: r9v0, types: [a11, com.google.firebase.auth.FirebaseAuth$d] */
    /* JADX WARNING: type inference failed for: r1v1, types: [a11, com.google.firebase.auth.FirebaseAuth$d] */
    /* JADX WARNING: type inference failed for: r10v0, types: [a11, com.google.firebase.auth.FirebaseAuth$d] */
    public final eq0<w4> r(dm dmVar, a aVar) {
        y90.j(dmVar);
        y90.j(aVar);
        a r = aVar.r();
        if (r instanceof b) {
            b bVar = (b) r;
            if ("password".equals(bVar.p())) {
                return this.f2148a.s(this.f2144a, dmVar, bVar.t(), bVar.u(), dmVar.B(), new d());
            } else if (t(bVar.v())) {
                return lq0.d(y41.b(new Status(17072)));
            } else {
                return this.f2148a.q(this.f2144a, dmVar, bVar, new d());
            }
        } else if (r instanceof g) {
            return this.f2148a.r(this.f2144a, dmVar, (g) r, this.f2153b, new d());
        } else {
            return this.f2148a.p(this.f2144a, dmVar, r, dmVar.B(), new d());
        }
    }

    public eq0<w4> g(String str, String str2) {
        y90.f(str);
        y90.f(str2);
        return this.f2148a.t(this.f2144a, str, str2, this.f2153b, new c());
    }

    public final void o(String str, long j, TimeUnit timeUnit, h.b bVar, Activity activity, Executor executor, boolean z, String str2) {
        t tVar;
        h.b bVar2;
        long j2 = j;
        long convert = TimeUnit.SECONDS.convert(j, timeUnit);
        if (convert < 0 || convert > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        d71 d71 = new d71(str, convert, z, this.f2146a, this.f2153b, (String) null);
        if (this.a.c()) {
            String str3 = str;
            if (str.equals(this.a.a())) {
                tVar = new t(this, bVar);
                this.f2148a.o(this.f2144a, d71, tVar, activity, executor);
            }
            bVar2 = bVar;
        } else {
            bVar2 = bVar;
        }
        tVar = bVar2;
        this.f2148a.o(this.f2144a, d71, tVar, activity, executor);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [a11, com.google.firebase.auth.FirebaseAuth$d] */
    public final eq0<w4> u(dm dmVar, a aVar) {
        y90.j(aVar);
        y90.j(dmVar);
        return this.f2148a.g(this.f2144a, dmVar, aVar.r(), new d());
    }

    public eq0<w4> d(String str, String str2) {
        y90.f(str);
        y90.f(str2);
        return this.f2148a.l(this.f2144a, str, str2, this.f2153b, new c());
    }

    public void h() {
        k();
        q01 q01 = this.f2149a;
        if (q01 != null) {
            q01.a();
        }
    }

    public final void n(String str) {
        y90.f(str);
        synchronized (this.b) {
            this.f2153b = str;
        }
    }

    private final boolean t(String str) {
        l61 b2 = l61.b(str);
        return b2 != null && !TextUtils.equals(this.f2153b, b2.c());
    }
}
