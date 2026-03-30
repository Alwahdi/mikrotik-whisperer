package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

public final class v implements Parcelable.Creator<d> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new d[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    str = ei0.c(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new d(str);
    }
}
