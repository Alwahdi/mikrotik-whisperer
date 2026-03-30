package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: mw0  reason: default package */
public final class mw0 implements Parcelable.Creator<vw0> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new vw0[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    i = ei0.n(parcel, l);
                    break;
                case 2:
                    i2 = ei0.n(parcel, l);
                    break;
                case 3:
                    intent = (Intent) ei0.b(parcel, l, Intent.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new vw0(i, i2, intent);
    }
}
