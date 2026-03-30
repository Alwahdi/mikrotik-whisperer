package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.a;
import com.google.firebase.auth.f;

/* renamed from: l71  reason: default package */
public class l71 extends f {
    public static final Parcelable.Creator<l71> CREATOR = new b81();
    private final f71 a;

    /* renamed from: a  reason: collision with other field name */
    private final String f4243a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    l71(String str, String str2, String str3, f71 f71, String str4, String str5, String str6) {
        this.f4243a = str;
        this.b = str2;
        this.c = str3;
        this.a = f71;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public static l71 w(f71 f71) {
        y90.k(f71, "Must specify a non-null webSignInCredential");
        return new l71((String) null, (String) null, (String) null, f71, (String) null, (String) null, (String) null);
    }

    public String m() {
        return this.f4243a;
    }

    public String p() {
        return this.f4243a;
    }

    public String t() {
        return this.b;
    }

    public String s() {
        return this.c;
    }

    public String u() {
        return this.e;
    }

    public static f71 v(l71 l71, String str) {
        y90.j(l71);
        f71 f71 = l71.a;
        if (f71 != null) {
            return f71;
        }
        return new f71(l71.t(), l71.s(), l71.m(), (String) null, l71.u(), (String) null, str, l71.d, l71.f);
    }

    public final a r() {
        return new l71(this.f4243a, this.b, this.c, this.a, this.d, this.e, this.f);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, m(), false);
        fi0.l(parcel, 2, t(), false);
        fi0.l(parcel, 3, s(), false);
        fi0.k(parcel, 4, this.a, i, false);
        fi0.l(parcel, 5, this.d, false);
        fi0.l(parcel, 6, u(), false);
        fi0.l(parcel, 7, this.f, false);
        fi0.b(parcel, a2);
    }
}
