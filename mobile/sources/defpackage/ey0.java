package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: ey0  reason: default package */
public final class ey0 implements Parcelable.Creator<gy0> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new gy0[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        dc dcVar = null;
        le0 le0 = null;
        int i = 0;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    i = ei0.n(parcel, l);
                    break;
                case 2:
                    dcVar = (dc) ei0.b(parcel, l, dc.CREATOR);
                    break;
                case 3:
                    le0 = (le0) ei0.b(parcel, l, le0.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new gy0(i, dcVar, le0);
    }
}
