package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

public class c extends a {
    public static final Parcelable.Creator<c> CREATOR = new p();
    private final String a;

    c(String str) {
        this.a = y90.f(str);
    }

    public String m() {
        return "facebook.com";
    }

    public String p() {
        return "facebook.com";
    }

    public static f71 s(c cVar, String str) {
        y90.j(cVar);
        return new f71((String) null, cVar.a, cVar.m(), (String) null, (String) null, (String) null, str, (String) null, (String) null);
    }

    public final a r() {
        return new c(this.a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.a, false);
        fi0.b(parcel, a2);
    }
}
