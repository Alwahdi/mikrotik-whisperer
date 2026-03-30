package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: m31  reason: default package */
public final class m31 implements Parcelable.Creator<k31> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new k31[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
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
                    str3 = ei0.c(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new k31(str, str2, str3);
    }
}
