package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;

public class i extends a {
    public static final Parcelable.Creator<i> CREATOR = new l();
    private final String a;

    i(String str) {
        this.a = y90.f(str);
    }

    public String m() {
        return "playgames.google.com";
    }

    public String p() {
        return "playgames.google.com";
    }

    public static f71 s(i iVar, String str) {
        y90.j(iVar);
        return new f71((String) null, (String) null, iVar.m(), (String) null, (String) null, iVar.a, str, (String) null, (String) null);
    }

    public final a r() {
        return new i(this.a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.a, false);
        fi0.b(parcel, a2);
    }
}
