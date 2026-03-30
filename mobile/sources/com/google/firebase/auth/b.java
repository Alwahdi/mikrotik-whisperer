package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class b extends a {
    public static final Parcelable.Creator<b> CREATOR = new o();
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2155a;
    private String b;
    private final String c;
    private String d;

    b(String str, String str2, String str3, String str4, boolean z) {
        this.a = y90.f(str);
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.f2155a = z;
            return;
        }
        throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
    }

    public final String t() {
        return this.a;
    }

    public final String u() {
        return this.b;
    }

    public final String v() {
        return this.c;
    }

    public final b s(dm dmVar) {
        this.d = dmVar.E();
        this.f2155a = true;
        return this;
    }

    public String m() {
        return "password";
    }

    public String p() {
        if (!TextUtils.isEmpty(this.b)) {
            return "password";
        }
        return "emailLink";
    }

    public final boolean w() {
        return !TextUtils.isEmpty(this.c);
    }

    public final a r() {
        return new b(this.a, this.b, this.c, this.d, this.f2155a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.a, false);
        fi0.l(parcel, 2, this.b, false);
        fi0.l(parcel, 3, this.c, false);
        fi0.l(parcel, 4, this.d, false);
        fi0.c(parcel, 5, this.f2155a);
        fi0.b(parcel, a2);
    }
}
