package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: n01  reason: default package */
public final class n01 implements Parcelable.Creator<i01> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new i01[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        ArrayList<mz0> arrayList = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    arrayList = ei0.f(parcel, l, mz0.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new i01(arrayList);
    }
}
