package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: s61  reason: default package */
public final class s61 extends x {
    public static final Parcelable.Creator<s61> CREATOR = new r61();
    private Long a;

    /* renamed from: a  reason: collision with other field name */
    private String f4970a;
    private Long b;

    /* renamed from: b  reason: collision with other field name */
    private String f4971b;
    private String c;

    public s61() {
        this.b = Long.valueOf(System.currentTimeMillis());
    }

    s61(String str, String str2, Long l, String str3, Long l2) {
        this.f4970a = str;
        this.f4971b = str2;
        this.a = l;
        this.c = str3;
        this.b = l2;
    }

    public final boolean r() {
        return hf.b().a() + 300000 < this.b.longValue() + (this.a.longValue() * 1000);
    }

    public final void m(String str) {
        this.f4970a = y90.f(str);
    }

    public final String s() {
        return this.f4970a;
    }

    public final String t() {
        return this.f4971b;
    }

    public final long u() {
        Long l = this.a;
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public final long v() {
        return this.b.longValue();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 2, this.f4970a, false);
        fi0.l(parcel, 3, this.f4971b, false);
        fi0.j(parcel, 4, Long.valueOf(u()), false);
        fi0.l(parcel, 5, this.c, false);
        fi0.j(parcel, 6, Long.valueOf(this.b.longValue()), false);
        fi0.b(parcel, a2);
    }

    public final String w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.f4970a);
            jSONObject.put("access_token", this.f4971b);
            jSONObject.put("expires_in", this.a);
            jSONObject.put("token_type", this.c);
            jSONObject.put("issued_at", this.b);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to convert GetTokenResponse to JSON");
            throw new wy0(e);
        }
    }

    public static s61 p(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            s61 s61 = new s61();
            s61.f4970a = jSONObject.optString("refresh_token", (String) null);
            s61.f4971b = jSONObject.optString("access_token", (String) null);
            s61.a = Long.valueOf(jSONObject.optLong("expires_in"));
            s61.c = jSONObject.optString("token_type", (String) null);
            s61.b = Long.valueOf(jSONObject.optLong("issued_at"));
            return s61;
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to read GetTokenResponse from JSONObject");
            throw new wy0(e);
        }
    }
}
