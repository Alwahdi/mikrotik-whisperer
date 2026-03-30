package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import defpackage.i3;
import defpackage.vp;
import java.util.Set;

/* renamed from: kx0  reason: default package */
public final class kx0 extends sx0 implements vp.a, vp.b {
    private static i3.a<? extends gx0, rl0> b = uw0.f5272a;
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final Handler f4168a;

    /* renamed from: a  reason: collision with other field name */
    private gx0 f4169a;

    /* renamed from: a  reason: collision with other field name */
    private final i3.a<? extends gx0, rl0> f4170a;

    /* renamed from: a  reason: collision with other field name */
    private Set<Scope> f4171a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public lx0 f4172a;

    /* renamed from: a  reason: collision with other field name */
    private y8 f4173a;

    public kx0(Context context, Handler handler, y8 y8Var) {
        this(context, handler, y8Var, b);
    }

    public kx0(Context context, Handler handler, y8 y8Var, i3.a<? extends gx0, rl0> aVar) {
        this.a = context;
        this.f4168a = handler;
        this.f4173a = (y8) y90.k(y8Var, "ClientSettings must not be null");
        this.f4171a = y8Var.g();
        this.f4170a = aVar;
    }

    public final void k0(lx0 lx0) {
        gx0 gx0 = this.f4169a;
        if (gx0 != null) {
            gx0.m();
        }
        this.f4173a.i(Integer.valueOf(System.identityHashCode(this)));
        i3.a<? extends gx0, rl0> aVar = this.f4170a;
        Context context = this.a;
        Looper looper = this.f4168a.getLooper();
        y8 y8Var = this.f4173a;
        this.f4169a = (gx0) aVar.b(context, looper, y8Var, y8Var.h(), this, this);
        this.f4172a = lx0;
        Set<Scope> set = this.f4171a;
        if (set == null || set.isEmpty()) {
            this.f4168a.post(new jx0(this));
        } else {
            this.f4169a.n();
        }
    }

    public final void l0() {
        gx0 gx0 = this.f4169a;
        if (gx0 != null) {
            gx0.m();
        }
    }

    public final void b(Bundle bundle) {
        this.f4169a.c(this);
    }

    public final void a(int i) {
        this.f4169a.m();
    }

    public final void c(dc dcVar) {
        this.f4172a.b(dcVar);
    }

    public final void I(gy0 gy0) {
        this.f4168a.post(new mx0(this, gy0));
    }

    /* access modifiers changed from: private */
    public final void m0(gy0 gy0) {
        dc m = gy0.m();
        if (m.t()) {
            le0 p = gy0.p();
            dc p2 = p.p();
            if (!p2.t()) {
                String valueOf = String.valueOf(p2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.f4172a.b(p2);
                this.f4169a.m();
                return;
            }
            this.f4172a.a(p.m(), this.f4171a);
        } else {
            this.f4172a.b(m);
        }
        this.f4169a.m();
    }
}
