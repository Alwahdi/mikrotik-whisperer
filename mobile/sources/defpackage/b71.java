package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: b71  reason: default package */
public final class b71 implements Parcelable.Creator<a71> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new a71[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        u61 u61 = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 2:
                    str = ei0.c(parcel, l);
                    break;
                case 3:
                    str2 = ei0.c(parcel, l);
                    break;
                case 4:
                    str3 = ei0.c(parcel, l);
                    break;
                case 5:
                    u61 = (u61) ei0.b(parcel, l, u61.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new a71(str, str2, str3, u61);
    }
}
