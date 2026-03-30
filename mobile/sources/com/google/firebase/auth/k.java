package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

public final class k implements Parcelable.Creator<g> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new g[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z = false;
        boolean z2 = false;
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
                    z = ei0.i(parcel, l);
                    break;
                case 4:
                    str3 = ei0.c(parcel, l);
                    break;
                case 5:
                    z2 = ei0.i(parcel, l);
                    break;
                case 6:
                    str4 = ei0.c(parcel, l);
                    break;
                case 7:
                    str5 = ei0.c(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new g(str, str2, z, str3, z2, str4, str5);
    }
}
