package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: v81  reason: default package */
public final class v81 implements Parcelable.Creator<i81> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new i81[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        boolean z = false;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    str = ei0.c(parcel, l);
                    break;
                case 2:
                    str2 = ei0.c(parcel, l);
                    break;
                case 3:
                    str5 = ei0.c(parcel, l);
                    break;
                case 4:
                    str4 = ei0.c(parcel, l);
                    break;
                case 5:
                    str3 = ei0.c(parcel, l);
                    break;
                case 6:
                    str6 = ei0.c(parcel, l);
                    break;
                case 7:
                    z = ei0.i(parcel, l);
                    break;
                case 8:
                    str7 = ei0.c(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new i81(str, str2, str3, str4, str5, str6, z, str7);
    }
}
