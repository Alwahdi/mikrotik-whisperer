package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: l41  reason: default package */
public final class l41 extends x {
    public static final Parcelable.Creator<l41> CREATOR = new m41();
    private final f71 a;

    public l41(f71 f71) {
        this.a = f71;
    }

    public final f71 m() {
        return this.a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.k(parcel, 1, this.a, i, false);
        fi0.b(parcel, a2);
    }
}
