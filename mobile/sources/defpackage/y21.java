package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: y21  reason: default package */
public final class y21 implements Parcelable.Creator<c11> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new c11[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        Bundle bundle = null;
        nk[] nkVarArr = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    bundle = ei0.a(parcel, l);
                    break;
                case 2:
                    nkVarArr = (nk[]) ei0.e(parcel, l, nk.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new c11(bundle, nkVarArr);
    }
}
