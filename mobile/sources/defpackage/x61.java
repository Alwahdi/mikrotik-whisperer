package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: x61  reason: default package */
public final class x61 implements Parcelable.Creator<z61> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new z61[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        ArrayList<w61> arrayList = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 2:
                    arrayList = ei0.f(parcel, l, w61.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new z61(arrayList);
    }
}
