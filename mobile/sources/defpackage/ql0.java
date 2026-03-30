package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import defpackage.vp;
import defpackage.z5;

/* renamed from: ql0  reason: default package */
public class ql0 extends op<ux0> implements gx0 {
    private final Bundle a;

    /* renamed from: a  reason: collision with other field name */
    private Integer f4847a;
    private final y8 b;

    /* renamed from: b  reason: collision with other field name */
    private final boolean f4848b;

    private ql0(Context context, Looper looper, boolean z, y8 y8Var, Bundle bundle, vp.a aVar, vp.b bVar) {
        super(context, looper, 44, y8Var, aVar, bVar);
        this.f4848b = true;
        this.b = y8Var;
        this.a = bundle;
        this.f4847a = y8Var.d();
    }

    public ql0(Context context, Looper looper, boolean z, y8 y8Var, rl0 rl0, vp.a aVar, vp.b bVar) {
        this(context, looper, true, y8Var, j0(y8Var), aVar, bVar);
    }

    public boolean h() {
        return this.f4848b;
    }

    public final void c(hx0 hx0) {
        y90.k(hx0, "Expecting a valid ISignInCallbacks");
        try {
            Account b2 = this.b.b();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(b2.name)) {
                googleSignInAccount = in0.a(v()).b();
            }
            ((ux0) z()).z(new dy0(new ke0(b2, this.f4847a.intValue(), googleSignInAccount)), hx0);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                hx0.I(new gy0(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String B() {
        return "com.google.android.gms.signin.service.START";
    }

    /* access modifiers changed from: protected */
    public String A() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public Bundle w() {
        if (!v().getPackageName().equals(this.b.f())) {
            this.a.putString("com.google.android.gms.signin.internal.realClientPackageName", this.b.f());
        }
        return this.a;
    }

    public final void n() {
        f(new z5.d());
    }

    public static Bundle j0(y8 y8Var) {
        rl0 h = y8Var.h();
        Integer d = y8Var.d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", y8Var.a());
        if (d != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", d.intValue());
        }
        if (h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h.h());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h.g());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h.f());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h.b());
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", h.c());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h.i());
            if (h.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h.a().longValue());
            }
            if (h.d() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h.d().longValue());
            }
        }
        return bundle;
    }

    public int i() {
        return 12451000;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ IInterface q(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof ux0) {
            return (ux0) queryLocalInterface;
        }
        return new zx0(iBinder);
    }
}
