package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: n81  reason: default package */
public final class n81 implements Parcelable.Creator<t71> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new t71[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        y81 y81 = null;
        m61 m61 = null;
        l71 l71 = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    y81 = (y81) ei0.b(parcel, l, y81.CREATOR);
                    break;
                case 2:
                    m61 = (m61) ei0.b(parcel, l, m61.CREATOR);
                    break;
                case 3:
                    l71 = (l71) ei0.b(parcel, l, l71.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new t71(y81, m61, l71);
    }
}
