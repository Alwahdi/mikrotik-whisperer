package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class j {
    private static final long b = TimeUnit.DAYS.toMillis(7);
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    final String f2431a;

    /* renamed from: b  reason: collision with other field name */
    private final String f2432b;

    private j(String str, String str2, long j) {
        this.f2431a = str;
        this.f2432b = str2;
        this.a = j;
    }

    static j a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new j(str, (String) null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new j(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to parse token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    static String c(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
            sb.append("Failed to encode token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    static String b(j jVar) {
        if (jVar == null) {
            return null;
        }
        return jVar.f2431a;
    }

    /* access modifiers changed from: package-private */
    public final boolean d(String str) {
        return System.currentTimeMillis() > this.a + b || !str.equals(this.f2432b);
    }
}
