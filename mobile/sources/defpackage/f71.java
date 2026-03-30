package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* renamed from: f71  reason: default package */
public final class f71 extends x {
    public static final Parcelable.Creator<f71> CREATOR = new o71();
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2952a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2953b;
    private String c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f2954c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;

    f71(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, String str10, String str11, String str12, boolean z3, String str13) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.f2952a = z;
        this.f2953b = z2;
        this.i = str9;
        this.j = str10;
        this.k = str11;
        this.l = str12;
        this.f2954c = z3;
        this.m = str13;
    }

    public f71(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.a = "http://localhost";
        this.c = str;
        this.d = str2;
        this.h = str5;
        this.i = str6;
        this.l = str7;
        this.m = str8;
        this.f2952a = true;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.d) || !TextUtils.isEmpty(this.i)) {
            this.e = y90.f(str3);
            this.f = null;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.c)) {
                sb.append("id_token=");
                sb.append(this.c);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.d)) {
                sb.append("access_token=");
                sb.append(this.d);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.f)) {
                sb.append("identifier=");
                sb.append(this.f);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.h)) {
                sb.append("oauth_token_secret=");
                sb.append(this.h);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.i)) {
                sb.append("code=");
                sb.append(this.i);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(str9)) {
                sb.append("nonce=");
                sb.append(str9);
                sb.append("&");
            }
            sb.append("providerId=");
            sb.append(this.e);
            this.g = sb.toString();
            this.f2953b = true;
            return;
        }
        throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
    }

    public final f71 m(boolean z) {
        this.f2953b = false;
        return this;
    }

    public final f71 p(String str) {
        this.l = str;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 2, this.a, false);
        fi0.l(parcel, 3, this.b, false);
        fi0.l(parcel, 4, this.c, false);
        fi0.l(parcel, 5, this.d, false);
        fi0.l(parcel, 6, this.e, false);
        fi0.l(parcel, 7, this.f, false);
        fi0.l(parcel, 8, this.g, false);
        fi0.l(parcel, 9, this.h, false);
        fi0.c(parcel, 10, this.f2952a);
        fi0.c(parcel, 11, this.f2953b);
        fi0.l(parcel, 12, this.i, false);
        fi0.l(parcel, 13, this.j, false);
        fi0.l(parcel, 14, this.k, false);
        fi0.l(parcel, 15, this.l, false);
        fi0.c(parcel, 16, this.f2954c);
        fi0.l(parcel, 17, this.m, false);
        fi0.b(parcel, a2);
    }
}
