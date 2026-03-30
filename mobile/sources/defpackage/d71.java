package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: d71  reason: default package */
public final class d71 extends x {
    public static final Parcelable.Creator<d71> CREATOR = new c71();
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2744a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f2745a;
    private final String b;
    private final String c;
    private final String d;

    public d71(String str, long j, boolean z, String str2, String str3, String str4) {
        this.f2744a = y90.f(str);
        this.a = j;
        this.f2745a = z;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.f2744a, false);
        fi0.i(parcel, 2, this.a);
        fi0.c(parcel, 3, this.f2745a);
        fi0.l(parcel, 4, this.b, false);
        fi0.l(parcel, 5, this.c, false);
        fi0.l(parcel, 6, this.d, false);
        fi0.b(parcel, a2);
    }
}
