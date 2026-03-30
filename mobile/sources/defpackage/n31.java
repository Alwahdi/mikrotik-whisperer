package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: n31  reason: default package */
public final class n31 extends x {
    public static final Parcelable.Creator<n31> CREATOR = new o31();
    private final String a;

    public n31(String str) {
        this.a = str;
    }

    public final String m() {
        return this.a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.a, false);
        fi0.b(parcel, a2);
    }
}
