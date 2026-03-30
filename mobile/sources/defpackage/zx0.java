package defpackage;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: zx0  reason: default package */
public final class zx0 extends tw0 implements ux0 {
    zx0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void z(dy0 dy0, hx0 hx0) {
        Parcel a = a();
        qx0.c(a, dy0);
        qx0.b(a, hx0);
        b(12, a);
    }
}
