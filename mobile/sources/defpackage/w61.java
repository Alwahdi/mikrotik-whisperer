package defpackage;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* renamed from: w61  reason: default package */
public final class w61 extends x {
    public static final Parcelable.Creator<w61> CREATOR = new v61();
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    w61(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public final String m() {
        return this.a;
    }

    public final String p() {
        return this.b;
    }

    public final Uri r() {
        if (!TextUtils.isEmpty(this.c)) {
            return Uri.parse(this.c);
        }
        return null;
    }

    public final String s() {
        return this.d;
    }

    public final String t() {
        return this.f;
    }

    public final String u() {
        return this.e;
    }

    public final String v() {
        return this.g;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 2, this.a, false);
        fi0.l(parcel, 3, this.b, false);
        fi0.l(parcel, 4, this.c, false);
        fi0.l(parcel, 5, this.d, false);
        fi0.l(parcel, 6, this.e, false);
        fi0.l(parcel, 7, this.f, false);
        fi0.l(parcel, 8, this.g, false);
        fi0.b(parcel, a2);
    }
}
