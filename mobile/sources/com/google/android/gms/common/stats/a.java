package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class a implements Parcelable.Creator<WakeLockEvent> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int s = ei0.s(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    i = ei0.n(parcel2, l);
                    break;
                case 2:
                    j = ei0.o(parcel2, l);
                    break;
                case 4:
                    str = ei0.c(parcel2, l);
                    break;
                case 5:
                    i3 = ei0.n(parcel2, l);
                    break;
                case 6:
                    arrayList = ei0.d(parcel2, l);
                    break;
                case 8:
                    j2 = ei0.o(parcel2, l);
                    break;
                case 10:
                    str3 = ei0.c(parcel2, l);
                    break;
                case 11:
                    i2 = ei0.n(parcel2, l);
                    break;
                case 12:
                    str2 = ei0.c(parcel2, l);
                    break;
                case 13:
                    str4 = ei0.c(parcel2, l);
                    break;
                case 14:
                    i4 = ei0.n(parcel2, l);
                    break;
                case 15:
                    f = ei0.k(parcel2, l);
                    break;
                case 16:
                    j3 = ei0.o(parcel2, l);
                    break;
                case 17:
                    str5 = ei0.c(parcel2, l);
                    break;
                case 18:
                    z = ei0.i(parcel2, l);
                    break;
                default:
                    ei0.r(parcel2, l);
                    break;
            }
        }
        ei0.g(parcel2, s);
        return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3, str5, z);
    }
}
