package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: j11  reason: default package */
public final class j11 implements Parcelable.Creator<nk> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new nk[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    str = ei0.c(parcel, l);
                    break;
                case 2:
                    i = ei0.n(parcel, l);
                    break;
                case 3:
                    j = ei0.o(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new nk(str, i, j);
    }
}
