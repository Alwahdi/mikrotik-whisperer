package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

public class d extends a {
    public static final Parcelable.Creator<d> CREATOR = new v();
    private String a;

    d(String str) {
        this.a = y90.f(str);
    }

    public String m() {
        return "github.com";
    }

    public String p() {
        return "github.com";
    }

    public static f71 s(d dVar, String str) {
        y90.j(dVar);
        return new f71((String) null, dVar.a, dVar.m(), (String) null, (String) null, (String) null, str, (String) null, (String) null);
    }

    public final a r() {
        return new d(this.a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.a, false);
        fi0.b(parcel, a2);
    }
}
