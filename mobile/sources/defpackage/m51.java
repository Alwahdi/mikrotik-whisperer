package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* renamed from: m51  reason: default package */
public final class m51 extends x {
    public static final Parcelable.Creator<m51> CREATOR = new r51();
    private final Status a;

    /* renamed from: a  reason: collision with other field name */
    private final String f4309a;

    /* renamed from: a  reason: collision with other field name */
    private final l71 f4310a;
    private final String b;

    public m51(Status status, l71 l71, String str, String str2) {
        this.a = status;
        this.f4310a = l71;
        this.f4309a = str;
        this.b = str2;
    }

    public final Status m() {
        return this.a;
    }

    public final l71 p() {
        return this.f4310a;
    }

    public final String r() {
        return this.f4309a;
    }

    public final String s() {
        return this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.k(parcel, 1, this.a, i, false);
        fi0.k(parcel, 2, this.f4310a, i, false);
        fi0.l(parcel, 3, this.f4309a, false);
        fi0.l(parcel, 4, this.b, false);
        fi0.b(parcel, a2);
    }
}
