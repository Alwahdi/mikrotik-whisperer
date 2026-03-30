package defpackage;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.g;

/* renamed from: h51  reason: default package */
public abstract class h51 extends ty0 implements i51 {
    public h51() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                f((s61) e41.a(parcel, s61.CREATOR));
                return true;
            case 2:
                K((s61) e41.a(parcel, s61.CREATOR), (b61) e41.a(parcel, b61.CREATOR));
                return true;
            case 3:
                J((u51) e41.a(parcel, u51.CREATOR));
                return true;
            case 4:
                k((a71) e41.a(parcel, a71.CREATOR));
                return true;
            case 5:
                d((Status) e41.a(parcel, Status.CREATOR));
                return true;
            case 6:
                E();
                return true;
            case 7:
                X();
                return true;
            case 8:
                r(parcel.readString());
                return true;
            case 9:
                H(parcel.readString());
                return true;
            case 10:
                h((g) e41.a(parcel, g.CREATOR));
                return true;
            case 11:
                S(parcel.readString());
                return true;
            case 12:
                e0((Status) e41.a(parcel, Status.CREATOR), (g) e41.a(parcel, g.CREATOR));
                return true;
            case 13:
                l();
                return true;
            case 14:
                g0((m51) e41.a(parcel, m51.CREATOR));
                return true;
            case 15:
                x((p51) e41.a(parcel, p51.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
