package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: mz0  reason: default package */
public final class mz0 extends ga1 {
    public static final Parcelable.Creator<mz0> CREATOR = new iz0();
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final String f4392a;
    private final String b;
    private final String c;

    public mz0(String str, String str2, long j, String str3) {
        this.f4392a = y90.f(str);
        this.b = str2;
        this.a = j;
        this.c = y90.f(str3);
    }

    public static mz0 p(JSONObject jSONObject) {
        if (jSONObject.has("enrollmentTimestamp")) {
            return new mz0(jSONObject.optString("uid"), jSONObject.optString("displayName"), jSONObject.optLong("enrollmentTimestamp"), jSONObject.optString("phoneNumber"));
        }
        throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
    }

    public final JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "phone");
            jSONObject.putOpt("uid", this.f4392a);
            jSONObject.putOpt("displayName", this.b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.a));
            jSONObject.putOpt("phoneNumber", this.c);
            return jSONObject;
        } catch (JSONException e) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new wy0(e);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.l(parcel, 1, this.f4392a, false);
        fi0.l(parcel, 2, this.b, false);
        fi0.i(parcel, 3, this.a);
        fi0.l(parcel, 4, this.c, false);
        fi0.b(parcel, a2);
    }
}
