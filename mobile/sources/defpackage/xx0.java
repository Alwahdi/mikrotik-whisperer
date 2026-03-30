package defpackage;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* renamed from: xx0  reason: default package */
public abstract class xx0 extends nw0 implements hx0 {
    public xx0() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public boolean h0(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                A((dc) qx0.a(parcel, dc.CREATOR), (vw0) qx0.a(parcel, vw0.CREATOR));
                break;
            case 4:
                m((Status) qx0.a(parcel, Status.CREATOR));
                break;
            case 6:
                b0((Status) qx0.a(parcel, Status.CREATOR));
                break;
            case 7:
                g((Status) qx0.a(parcel, Status.CREATOR), (GoogleSignInAccount) qx0.a(parcel, GoogleSignInAccount.CREATOR));
                break;
            case 8:
                I((gy0) qx0.a(parcel, gy0.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
