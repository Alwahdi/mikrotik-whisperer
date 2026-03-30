package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: a71  reason: default package */
public final class a71 extends x {
    public static final Parcelable.Creator<a71> CREATOR = new b71();
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private u61 f29a;
    private String b;
    private String c;

    a71(String str, String str2, String str3, u61 u61) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.f29a = u61;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 2, this.a, false);
        fi0.l(parcel, 3, this.b, false);
        fi0.l(parcel, 4, this.c, false);
        fi0.k(parcel, 5, this.f29a, i, false);
        fi0.b(parcel, a2);
    }
}
