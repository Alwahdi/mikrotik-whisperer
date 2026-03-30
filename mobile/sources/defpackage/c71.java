package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: c71  reason: default package */
public final class c71 implements Parcelable.Creator<d71> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new d71[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        boolean z = false;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    str = ei0.c(parcel, l);
                    break;
                case 2:
                    j = ei0.o(parcel, l);
                    break;
                case 3:
                    z = ei0.i(parcel, l);
                    break;
                case 4:
                    str2 = ei0.c(parcel, l);
                    break;
                case 5:
                    str3 = ei0.c(parcel, l);
                    break;
                case 6:
                    str4 = ei0.c(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new d71(str, j, z, str2, str3, str4);
    }
}
