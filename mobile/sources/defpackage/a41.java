package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.g;

/* renamed from: a41  reason: default package */
public final class a41 implements Parcelable.Creator<v31> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new v31[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        g gVar = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    str = ei0.c(parcel, l);
                    break;
                case 2:
                    gVar = (g) ei0.b(parcel, l, g.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new v31(str, gVar);
    }
}
