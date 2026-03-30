package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: c81  reason: default package */
public final class c81 implements Parcelable.Creator<m61> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new m61[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        String str2 = null;
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
                    z = ei0.i(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new m61(str, str2, z);
    }
}
