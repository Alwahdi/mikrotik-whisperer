package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: s31  reason: default package */
public final class s31 extends x {
    public static final Parcelable.Creator<s31> CREATOR = new x31();
    private final f71 a;

    /* renamed from: a  reason: collision with other field name */
    private final String f4958a;

    public s31(String str, f71 f71) {
        this.f4958a = str;
        this.a = f71;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.f4958a, false);
        fi0.k(parcel, 2, this.a, i, false);
        fi0.b(parcel, a2);
    }
}
