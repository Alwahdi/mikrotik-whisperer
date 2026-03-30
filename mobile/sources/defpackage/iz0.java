package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: iz0  reason: default package */
public final class iz0 implements Parcelable.Creator<mz0> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new mz0[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        long j = 0;
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
                    j = ei0.o(parcel, l);
                    break;
                case 4:
                    str3 = ei0.c(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new mz0(str, str2, j, str3);
    }
}
