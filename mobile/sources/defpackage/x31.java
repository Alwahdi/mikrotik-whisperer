package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: x31  reason: default package */
public final class x31 implements Parcelable.Creator<s31> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new s31[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        f71 f71 = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    str = ei0.c(parcel, l);
                    break;
                case 2:
                    f71 = (f71) ei0.b(parcel, l, f71.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new s31(str, f71);
    }
}
