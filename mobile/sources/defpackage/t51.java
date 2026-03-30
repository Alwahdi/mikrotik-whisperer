package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: t51  reason: default package */
public final class t51 implements Parcelable.Creator<p51> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new p51[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        String str = null;
        ArrayList<u61> arrayList = null;
        l71 l71 = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    str = ei0.c(parcel, l);
                    break;
                case 2:
                    arrayList = ei0.f(parcel, l, u61.CREATOR);
                    break;
                case 3:
                    l71 = (l71) ei0.b(parcel, l, l71.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new p51(str, arrayList, l71);
    }
}
