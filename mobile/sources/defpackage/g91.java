package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: g91  reason: default package */
public final class g91 implements em {
    public static final Parcelable.Creator<g91> CREATOR = new r91();
    private long a;
    private long b;

    public g91(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final long i() {
        return this.a;
    }

    public final long f() {
        return this.b;
    }

    public final JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.a);
            jSONObject.put("creationTimestamp", this.b);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static g91 o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new g91(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException e) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.i(parcel, 1, i());
        fi0.i(parcel, 2, f());
        fi0.b(parcel, a2);
    }

    public final int describeContents() {
        return 0;
    }
}
