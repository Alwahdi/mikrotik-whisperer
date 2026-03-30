package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.b;

/* renamed from: p41  reason: default package */
public final class p41 extends x {
    public static final Parcelable.Creator<p41> CREATOR = new v41();
    private final b a;

    public p41(b bVar) {
        this.a = bVar;
    }

    public final b m() {
        return this.a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.k(parcel, 1, this.a, i, false);
        fi0.b(parcel, a2);
    }
}
