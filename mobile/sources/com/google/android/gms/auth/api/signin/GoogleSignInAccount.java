package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends x implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();
    private static b9 a = hf.b();

    /* renamed from: a  reason: collision with other field name */
    private final int f1374a;

    /* renamed from: a  reason: collision with other field name */
    private long f1375a;

    /* renamed from: a  reason: collision with other field name */
    private Uri f1376a;

    /* renamed from: a  reason: collision with other field name */
    private String f1377a;

    /* renamed from: a  reason: collision with other field name */
    private List<Scope> f1378a;

    /* renamed from: a  reason: collision with other field name */
    private Set<Scope> f1379a = new HashSet();
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    public static GoogleSignInAccount y(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", (String) null);
        if (!TextUtils.isEmpty(optString)) {
            uri = Uri.parse(optString);
        } else {
            uri = null;
        }
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount z = z(jSONObject.optString("id"), jSONObject.optString("tokenId", (String) null), jSONObject.optString(NotificationCompat.CATEGORY_EMAIL, (String) null), jSONObject.optString("displayName", (String) null), jSONObject.optString("givenName", (String) null), jSONObject.optString("familyName", (String) null), uri, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        z.e = jSONObject.optString("serverAuthCode", (String) null);
        return z;
    }

    private static GoogleSignInAccount z(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        Long l2;
        if (l == null) {
            l2 = Long.valueOf(a.a() / 1000);
        } else {
            l2 = l;
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, l2.longValue(), y90.f(str7), new ArrayList((Collection) y90.j(set)), str5, str6);
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f1374a = i;
        this.f1377a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f1376a = uri;
        this.e = str5;
        this.f1375a = j;
        this.f = str6;
        this.f1378a = list;
        this.g = str7;
        this.h = str8;
    }

    public String t() {
        return this.f1377a;
    }

    public String u() {
        return this.b;
    }

    public String p() {
        return this.c;
    }

    public String m() {
        return this.d;
    }

    public String s() {
        return this.g;
    }

    public String r() {
        return this.h;
    }

    public Uri v() {
        return this.f1376a;
    }

    public String x() {
        return this.e;
    }

    public Set<Scope> w() {
        HashSet hashSet = new HashSet(this.f1378a);
        hashSet.addAll(this.f1379a);
        return hashSet;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.h(parcel, 1, this.f1374a);
        fi0.l(parcel, 2, t(), false);
        fi0.l(parcel, 3, u(), false);
        fi0.l(parcel, 4, p(), false);
        fi0.l(parcel, 5, m(), false);
        fi0.k(parcel, 6, v(), i, false);
        fi0.l(parcel, 7, x(), false);
        fi0.i(parcel, 8, this.f1375a);
        fi0.l(parcel, 9, this.f, false);
        fi0.o(parcel, 10, this.f1378a, false);
        fi0.l(parcel, 11, s(), false);
        fi0.l(parcel, 12, r(), false);
        fi0.b(parcel, a2);
    }

    public int hashCode() {
        return ((this.f.hashCode() + 527) * 31) + w().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.f.equals(this.f) || !googleSignInAccount.w().equals(w())) {
            return false;
        }
        return true;
    }
}
