package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

public final class b implements Parcelable.Creator<Status> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new Status[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    i2 = ei0.n(parcel, l);
                    break;
                case 2:
                    str = ei0.c(parcel, l);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) ei0.b(parcel, l, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i = ei0.n(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new Status(i, i2, str, pendingIntent);
    }
}
