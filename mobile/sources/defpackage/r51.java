package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* renamed from: r51  reason: default package */
public final class r51 implements Parcelable.Creator<m51> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new m51[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        Status status = null;
        l71 l71 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < s) {
            int l = ei0.l(parcel);
            switch (ei0.h(l)) {
                case 1:
                    status = (Status) ei0.b(parcel, l, Status.CREATOR);
                    break;
                case 2:
                    l71 = (l71) ei0.b(parcel, l, l71.CREATOR);
                    break;
                case 3:
                    str = ei0.c(parcel, l);
                    break;
                case 4:
                    str2 = ei0.c(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new m51(status, l71, str, str2);
    }
}
