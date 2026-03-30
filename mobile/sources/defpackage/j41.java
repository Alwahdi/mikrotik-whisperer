package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: j41  reason: default package */
public final class j41 extends x {
    public static final Parcelable.Creator<j41> CREATOR = new k41();
    private final d71 a;

    public j41(d71 d71) {
        this.a = d71;
    }

    public final d71 m() {
        return this.a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.k(parcel, 1, this.a, i, false);
        fi0.b(parcel, a2);
    }
}
