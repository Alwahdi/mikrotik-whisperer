package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.dynamite.DynamiteModule;

/* renamed from: z41  reason: default package */
public final class z41 extends op<j51> implements w41 {
    private static vy a = new vy("FirebaseAuth", "FirebaseAuth:");

    /* renamed from: a  reason: collision with other field name */
    private final n51 f5973a;
    private final Context b;

    public z41(Context context, Looper looper, y8 y8Var, n51 n51, ac acVar, p40 p40) {
        super(context, looper, 112, y8Var, acVar, p40);
        this.b = (Context) y90.j(context);
        this.f5973a = n51;
    }

    /* access modifiers changed from: protected */
    public final String B() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    /* access modifiers changed from: protected */
    public final String A() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    /* access modifiers changed from: protected */
    public final String C() {
        if (this.f5973a.a) {
            a.d("Preparing to create service connection to fallback implementation", new Object[0]);
            return this.b.getPackageName();
        }
        a.d("Preparing to create service connection to gms implementation", new Object[0]);
        return "com.google.android.gms";
    }

    public final boolean d() {
        return DynamiteModule.a(this.b, "com.google.firebase.auth") == 0;
    }

    /* access modifiers changed from: protected */
    public final Bundle w() {
        Bundle w = super.w();
        if (w == null) {
            w = new Bundle();
        }
        n51 n51 = this.f5973a;
        if (n51 != null) {
            w.putString("com.google.firebase.auth.API_KEY", n51.a());
        }
        w.putString("com.google.firebase.auth.LIBRARY_VERSION", q51.a());
        return w;
    }

    public final int i() {
        return 12451000;
    }

    public final nk[] t() {
        return c51.f285a;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface q(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        if (queryLocalInterface instanceof j51) {
            return (j51) queryLocalInterface;
        }
        return new k51(iBinder);
    }

    public final /* synthetic */ j51 b() {
        return (j51) super.z();
    }
}
