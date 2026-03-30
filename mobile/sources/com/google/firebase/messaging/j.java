package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

public final class j {
    private final Bundle a;

    public j(Bundle bundle) {
        if (bundle != null) {
            this.a = new Bundle(bundle);
            return;
        }
        throw new NullPointerException("data");
    }

    public final String c(String str) {
        Bundle bundle = this.a;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String r = r(str);
            if (this.a.containsKey(r)) {
                str = r;
            }
        }
        return bundle.getString(str);
    }

    public final boolean g(String str) {
        String c = c(str);
        return "1".equals(c) || Boolean.parseBoolean(c);
    }

    public final Integer h(String str) {
        String c = c(str);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(c));
        } catch (NumberFormatException e) {
            String q = q(str);
            StringBuilder sb = new StringBuilder(String.valueOf(q).length() + 38 + String.valueOf(c).length());
            sb.append("Couldn't parse value of ");
            sb.append(q);
            sb.append("(");
            sb.append(c);
            sb.append(") into an int");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final Long j(String str) {
        String c = c(str);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(c));
        } catch (NumberFormatException e) {
            String q = q(str);
            StringBuilder sb = new StringBuilder(String.valueOf(q).length() + 38 + String.valueOf(c).length());
            sb.append("Couldn't parse value of ");
            sb.append(q);
            sb.append("(");
            sb.append(c);
            sb.append(") into a long");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    public final String m(String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        return c(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    public final Object[] o(String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        JSONArray p = p(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (p == null) {
            return null;
        }
        int length = p.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = p.optString(i);
        }
        return strArr;
    }

    private final JSONArray p(String str) {
        String c = c(str);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        try {
            return new JSONArray(c);
        } catch (JSONException e) {
            String q = q(str);
            StringBuilder sb = new StringBuilder(String.valueOf(q).length() + 50 + String.valueOf(c).length());
            sb.append("Malformed JSON for key ");
            sb.append(q);
            sb.append(": ");
            sb.append(c);
            sb.append(", falling back to default");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    private static String q(String str) {
        if (str.startsWith("gcm.n.")) {
            return str.substring(6);
        }
        return str;
    }

    public final Uri a() {
        String c = c("gcm.n.link_android");
        if (TextUtils.isEmpty(c)) {
            c = c("gcm.n.link");
        }
        if (!TextUtils.isEmpty(c)) {
            return Uri.parse(c);
        }
        return null;
    }

    public final String e() {
        String c = c("gcm.n.sound2");
        if (TextUtils.isEmpty(c)) {
            return c("gcm.n.sound");
        }
        return c;
    }

    public final long[] i() {
        JSONArray p = p("gcm.n.vibrate_timings");
        if (p == null) {
            return null;
        }
        try {
            if (p.length() > 1) {
                int length = p.length();
                long[] jArr = new long[length];
                for (int i = 0; i < length; i++) {
                    jArr[i] = p.optLong(i);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException e) {
            String valueOf = String.valueOf(p);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 74);
            sb.append("User defined vibrateTimings is invalid: ");
            sb.append(valueOf);
            sb.append(". Skipping setting vibrateTimings.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final int[] k() {
        JSONArray p = p("gcm.n.light_settings");
        if (p == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (p.length() == 3) {
                int parseColor = Color.parseColor(p.optString(0));
                if (parseColor != -16777216) {
                    iArr[0] = parseColor;
                    iArr[1] = p.optInt(1);
                    iArr[2] = p.optInt(2);
                    return iArr;
                }
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (JSONException e) {
            String valueOf = String.valueOf(p);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 58);
            sb.append("LightSettings is invalid: ");
            sb.append(valueOf);
            sb.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb.toString());
            return null;
        } catch (IllegalArgumentException e2) {
            String valueOf2 = String.valueOf(p);
            String message = e2.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 60 + String.valueOf(message).length());
            sb2.append("LightSettings is invalid: ");
            sb2.append(valueOf2);
            sb2.append(". ");
            sb2.append(message);
            sb2.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb2.toString());
            return null;
        }
    }

    public final Bundle l() {
        Bundle bundle = new Bundle(this.a);
        for (String str : this.a.keySet()) {
            if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public final Bundle n() {
        Bundle bundle = new Bundle(this.a);
        for (String str : this.a.keySet()) {
            if (!(str.startsWith("google.c.a.") || str.equals("from"))) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    private final String f(Resources resources, String str, String str2) {
        String m = m(str2);
        if (TextUtils.isEmpty(m)) {
            return null;
        }
        int identifier = resources.getIdentifier(m, "string", str);
        if (identifier == 0) {
            String valueOf = String.valueOf(str2);
            String valueOf2 = String.valueOf("_loc_key");
            String q = q(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
            StringBuilder sb = new StringBuilder(String.valueOf(q).length() + 49 + String.valueOf(str2).length());
            sb.append(q);
            sb.append(" resource not found: ");
            sb.append(str2);
            sb.append(" Default value will be used.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
        Object[] o = o(str2);
        if (o == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, o);
        } catch (MissingFormatArgumentException e) {
            String q2 = q(str2);
            String arrays = Arrays.toString(o);
            StringBuilder sb2 = new StringBuilder(String.valueOf(q2).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(q2);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            Log.w("NotificationParams", sb2.toString(), e);
            return null;
        }
    }

    public final String b(Resources resources, String str, String str2) {
        String c = c(str2);
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        return f(resources, str, str2);
    }

    public static boolean d(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(r("gcm.n.e"))) || bundle.getString("gcm.n.icon") != null || bundle.getString(r("gcm.n.icon")) != null;
    }

    private static String r(String str) {
        if (!str.startsWith("gcm.n.")) {
            return str;
        }
        return str.replace("gcm.n.", "gcm.notification.");
    }
}
