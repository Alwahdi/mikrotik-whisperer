package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

public class j extends a {
    public static final Parcelable.Creator<j> CREATOR = new m();
    private String a;
    private String b;

    j(String str, String str2) {
        this.a = y90.f(str);
        this.b = y90.f(str2);
    }

    public String m() {
        return "twitter.com";
    }

    public String p() {
        return "twitter.com";
    }

    public static f71 s(j jVar, String str) {
        y90.j(jVar);
        return new f71((String) null, jVar.a, jVar.m(), (String) null, jVar.b, (String) null, str, (String) null, (String) null);
    }

    public final a r() {
        return new j(this.a, this.b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.a, false);
        fi0.l(parcel, 2, this.b, false);
        fi0.b(parcel, a2);
    }
}
