package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: x91  reason: default package */
public final class x91 implements Parcelable.Creator<ba1> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new ba1[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        String str2 = null;
        ArrayList<mz0> arrayList = null;
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
                    arrayList = ei0.f(parcel, l, mz0.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new ba1(str, str2, arrayList);
    }
}
