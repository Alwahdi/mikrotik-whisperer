package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.b;

/* renamed from: v41  reason: default package */
public final class v41 implements Parcelable.Creator<p41> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new p41[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        b bVar = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    bVar = (b) ei0.b(parcel, l, b.CREATOR);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new p41(bVar);
    }
}
