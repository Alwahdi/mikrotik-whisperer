package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: k41  reason: default package */
public final class k41 implements Parcelable.Creator<j41> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new j41[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        d71 d71 = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    d71 = (d71) ei0.b(parcel, l, d71.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new j41(d71);
    }
}
