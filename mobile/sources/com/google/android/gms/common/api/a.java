package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator<Scope> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new Scope[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    i = ei0.n(parcel, l);
                    break;
                case 2:
                    str = ei0.c(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new Scope(i, str);
    }
}
