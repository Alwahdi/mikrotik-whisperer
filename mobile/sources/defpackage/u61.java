package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: u61  reason: default package */
public final class u61 extends x {
    public static final Parcelable.Creator<u61> CREATOR = new t61();
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final String f5198a;
    private final String b;
    private final String c;

    public u61(String str, String str2, String str3, long j) {
        this.f5198a = str;
        this.b = y90.f(str2);
        this.c = str3;
        this.a = j;
    }

    public final String m() {
        return this.f5198a;
    }

    public final String p() {
        return this.b;
    }

    public final String r() {
        return this.c;
    }

    public final long s() {
        return this.a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.f5198a, false);
        fi0.l(parcel, 2, this.b, false);
        fi0.l(parcel, 3, this.c, false);
        fi0.i(parcel, 4, this.a);
        fi0.b(parcel, a2);
    }
}
