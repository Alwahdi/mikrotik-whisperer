package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: m41  reason: default package */
public final class m41 implements Parcelable.Creator<l41> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new l41[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        f71 f71 = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    f71 = (f71) ei0.b(parcel, l, f71.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new l41(f71);
    }
}
