package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: xy0  reason: default package */
public final class xy0 implements Parcelable.Creator<dc> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new dc[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s = ei0.s(parcel);
        PendingIntent pendingIntent = null;
        String str = null;
        int i = 0;
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
                    pendingIntent = (PendingIntent) ei0.b(parcel, l, PendingIntent.CREATOR);
                    break;
                case 4:
                    str = ei0.c(parcel, l);
                    break;
                default:
                    ei0.r(parcel, l);
                    break;
            }
        }
        ei0.g(parcel, s);
        return new dc(i, i2, pendingIntent, str);
    }
}
