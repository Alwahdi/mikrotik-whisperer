package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.g;

/* renamed from: t41  reason: default package */
public final class t41 extends x {
    public static final Parcelable.Creator<t41> CREATOR = new x41();
    private final g a;

    /* renamed from: a  reason: collision with other field name */
    private final String f5071a;

    public t41(g gVar, String str) {
        this.a = gVar;
        this.f5071a = str;
    }

    public final g m() {
        return this.a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.k(parcel, 1, this.a, i, false);
        fi0.l(parcel, 2, this.f5071a, false);
        fi0.b(parcel, a2);
    }
}
