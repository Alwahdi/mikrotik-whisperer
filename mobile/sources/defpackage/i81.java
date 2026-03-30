package defpackage;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: i81  reason: default package */
public final class i81 extends x implements eu0 {
    public static final Parcelable.Creator<i81> CREATOR = new v81();
    private Uri a;

    /* renamed from: a  reason: collision with other field name */
    private String f3208a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3209a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public i81(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        this.f3208a = str;
        this.b = str2;
        this.e = str3;
        this.f = str4;
        this.c = str5;
        this.d = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.a = Uri.parse(this.d);
        }
        this.f3209a = z;
        this.g = str7;
    }

    public i81(b61 b61, String str) {
        y90.j(b61);
        y90.f(str);
        this.f3208a = y90.f(b61.r());
        this.b = str;
        this.e = b61.m();
        this.c = b61.s();
        Uri t = b61.t();
        if (t != null) {
            this.d = t.toString();
            this.a = t;
        }
        this.f3209a = b61.p();
        this.g = null;
        this.f = b61.u();
    }

    public i81(w61 w61) {
        y90.j(w61);
        this.f3208a = w61.m();
        this.b = y90.f(w61.s());
        this.c = w61.p();
        Uri r = w61.r();
        if (r != null) {
            this.d = r.toString();
            this.a = r;
        }
        this.e = w61.v();
        this.f = w61.t();
        this.f3209a = false;
        this.g = w61.u();
    }

    public final String s() {
        return this.f3208a;
    }

    public final String i() {
        return this.b;
    }

    public final String m() {
        return this.c;
    }

    public final String p() {
        return this.e;
    }

    public final String r() {
        return this.f;
    }

    public final boolean t() {
        return this.f3209a;
    }

    public final String u() {
        return this.g;
    }

    public final String w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.f3208a);
            jSONObject.putOpt("providerId", this.b);
            jSONObject.putOpt("displayName", this.c);
            jSONObject.putOpt("photoUrl", this.d);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EMAIL, this.e);
            jSONObject.putOpt("phoneNumber", this.f);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.f3209a));
            jSONObject.putOpt("rawUserInfo", this.g);
            return jSONObject.toString();
        } catch (JSONException e2) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new wy0(e2);
        }
    }

    public static i81 v(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new i81(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString(NotificationCompat.CATEGORY_EMAIL), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e2) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new wy0(e2);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, s(), false);
        fi0.l(parcel, 2, i(), false);
        fi0.l(parcel, 3, m(), false);
        fi0.l(parcel, 4, this.d, false);
        fi0.l(parcel, 5, p(), false);
        fi0.l(parcel, 6, r(), false);
        fi0.c(parcel, 7, t());
        fi0.l(parcel, 8, this.g, false);
        fi0.b(parcel, a2);
    }
}
