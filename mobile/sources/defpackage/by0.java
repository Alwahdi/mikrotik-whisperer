package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: by0  reason: default package */
public final class by0 implements Parcelable.Creator<dy0> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new dy0[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        int i = 0;
        ke0 ke0 = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    i = ei0.n(parcel, l);
                    break;
                case 2:
                    ke0 = (ke0) ei0.b(parcel, l, ke0.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new dy0(i, ke0);
    }
}
