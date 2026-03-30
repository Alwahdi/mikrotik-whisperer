package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: r91  reason: default package */
public final class r91 implements Parcelable.Creator<g91> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new g91[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    j = ei0.o(parcel, l);
                    break;
                case 2:
                    j2 = ei0.o(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new g91(j, j2);
    }
}
