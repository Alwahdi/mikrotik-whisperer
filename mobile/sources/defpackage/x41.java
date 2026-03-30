package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.g;

/* renamed from: x41  reason: default package */
public final class x41 implements Parcelable.Creator<t41> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new t41[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        g gVar = null;
        String str = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    gVar = (g) ei0.b(parcel, l, g.CREATOR);
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
        return new t41(gVar, str);
    }
}
