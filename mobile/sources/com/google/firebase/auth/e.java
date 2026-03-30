package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class e extends a {
    public static final Parcelable.Creator<e> CREATOR = new w();
    private final String a;
    private final String b;

    e(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        this.a = s(str, "idToken");
        this.b = s(str2, "accessToken");
    }

    public String m() {
        return "google.com";
    }

    public String p() {
        return "google.com";
    }

    public static f71 t(e eVar, String str) {
        y90.j(eVar);
        return new f71(eVar.a, eVar.b, eVar.m(), (String) null, (String) null, (String) null, str, (String) null, (String) null);
    }

    private static String s(String str, String str2) {
        if (str == null || !TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2).concat(" must not be empty"));
    }

    public final a r() {
        return new e(this.a, this.b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.a, false);
        fi0.l(parcel, 2, this.b, false);
        fi0.b(parcel, a2);
    }
}
