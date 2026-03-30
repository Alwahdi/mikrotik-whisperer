package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class g extends a implements Cloneable {
    public static final Parcelable.Creator<g> CREATOR = new k();
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2156a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2157b;
    private String c;
    private String d;
    private String e;

    g(String str, String str2, boolean z, String str3, boolean z2, String str4, String str5) {
        y90.b((z && !TextUtils.isEmpty(str3) && TextUtils.isEmpty(str5)) || (z && TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str5)) || ((!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4))), "Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, temporary proof, or enrollment ID.");
        this.a = str;
        this.b = str2;
        this.f2156a = z;
        this.c = str3;
        this.f2157b = z2;
        this.d = str4;
        this.e = str5;
    }

    public String s() {
        return this.b;
    }

    public String m() {
        return "phone";
    }

    public String p() {
        return "phone";
    }

    public final g t(boolean z) {
        this.f2157b = false;
        return this;
    }

    public final a r() {
        return (g) clone();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.a, false);
        fi0.l(parcel, 2, s(), false);
        fi0.c(parcel, 3, this.f2156a);
        fi0.l(parcel, 4, this.c, false);
        fi0.c(parcel, 5, this.f2157b);
        fi0.l(parcel, 6, this.d, false);
        fi0.l(parcel, 7, this.e, false);
        fi0.b(parcel, a2);
    }

    public /* synthetic */ Object clone() {
        return new g(this.a, s(), this.f2156a, this.c, this.f2157b, this.d, this.e);
    }
}
