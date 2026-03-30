package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: l91  reason: default package */
public final class l91 implements Parcelable.Creator<fe0> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new fe0[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 2:
                    bundle = ei0.a(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new fe0(bundle);
    }
}
