package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: r61  reason: default package */
public final class r61 implements Parcelable.Creator<s61> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new s61[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        String str2 = null;
        Long l = null;
        String str3 = null;
        Long l2 = null;
        while (parcel.dataPosition() < s) {
            int l3 = ei0.l(parcel);
            switch (ei0.h(l3)) {
                case 2:
                    str = ei0.c(parcel, l3);
                    break;
                case 3:
                    str2 = ei0.c(parcel, l3);
                    break;
                case 4:
                    l = ei0.p(parcel, l3);
                    break;
                case 5:
                    str3 = ei0.c(parcel, l3);
                    break;
                case 6:
                    l2 = ei0.p(parcel, l3);
                    break;
                default:
                    ei0.r(parcel, l3);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new s61(str, str2, l, str3, l2);
    }
}
