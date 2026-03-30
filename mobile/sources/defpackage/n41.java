package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: n41  reason: default package */
public final class n41 extends x {
    public static final Parcelable.Creator<n41> CREATOR = new r41();
    private final String a;
    private final String b;
    private final String c;

    public n41(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final String m() {
        return this.a;
    }

    public final String p() {
        return this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.a, false);
        fi0.l(parcel, 2, this.b, false);
        fi0.l(parcel, 3, this.c, false);
        fi0.b(parcel, a2);
    }
}
