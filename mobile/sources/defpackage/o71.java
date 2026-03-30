package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o71  reason: default package */
public final class o71 implements Parcelable.Creator<f71> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new f71[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int s = ei0.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 2:
                    str = ei0.c(parcel2, l);
                    break;
                case 3:
                    str2 = ei0.c(parcel2, l);
                    break;
                case 4:
                    str3 = ei0.c(parcel2, l);
                    break;
                case 5:
                    str4 = ei0.c(parcel2, l);
                    break;
                case 6:
                    str5 = ei0.c(parcel2, l);
                    break;
                case 7:
                    str6 = ei0.c(parcel2, l);
                    break;
                case 8:
                    str7 = ei0.c(parcel2, l);
                    break;
                case 9:
                    str8 = ei0.c(parcel2, l);
                    break;
                case 10:
                    z = ei0.i(parcel2, l);
                    break;
                case 11:
                    z2 = ei0.i(parcel2, l);
                    break;
                case 12:
                    str9 = ei0.c(parcel2, l);
                    break;
                case 13:
                    str10 = ei0.c(parcel2, l);
                    break;
                case 14:
                    str11 = ei0.c(parcel2, l);
                    break;
                case 15:
                    str12 = ei0.c(parcel2, l);
                    break;
                case 16:
                    z3 = ei0.i(parcel2, l);
                    break;
                case 17:
                    str13 = ei0.c(parcel2, l);
                    break;
                default:
                    ei0.r(parcel2, l);
                    break;
            }
        }
        ei0.g(parcel2, s);
        return new f71(str, str2, str3, str4, str5, str6, str7, str8, z, z2, str9, str10, str11, str12, z3, str13);
    }
}
