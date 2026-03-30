package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.j;
import defpackage.fm;

/* renamed from: c91  reason: default package */
public abstract class c91 {
    private static final pe a = new tv().f(fm.c.class, new fm.b()).f(fm.class, new fm.a()).c();

    public static void b(Intent intent, cs0<String> cs0) {
        c("_nr", intent);
        if (cs0 != null) {
            try {
                cs0.a(wi.d(a.b(new fm.c(new fm("MESSAGE_DELIVERED", intent)))));
            } catch (ri e) {
                Log.d("FirebaseMessaging", "Failed to encode big query analytics payload. Skip sending");
            }
        }
    }

    public static void a(Intent intent) {
        if (intent != null) {
            if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                z2 z2Var = (z2) gl.j().g(z2.class);
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                }
                if (z2Var != null) {
                    String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    z2Var.a("fcm", "_ln", stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString("source", "Firebase");
                    bundle.putString("medium", "notification");
                    bundle.putString("campaign", stringExtra);
                    z2Var.b("fcm", "_cmp", bundle);
                } else {
                    Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                }
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
            }
        }
        c("_no", intent);
    }

    public static void f(Intent intent) {
        c("_nd", intent);
    }

    public static void h(Intent intent) {
        c("_nf", intent);
    }

    public static boolean j(Intent intent) {
        if (intent == null || t(intent)) {
            return false;
        }
        return "1".equals(intent.getStringExtra("google.c.a.e"));
    }

    public static boolean k(Intent intent) {
        if (intent == null || t(intent)) {
            return false;
        }
        return d();
    }

    private static boolean t(Intent intent) {
        return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction());
    }

    static boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            gl.j();
            Context i = gl.j().i();
            SharedPreferences sharedPreferences = i.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = i.getPackageManager();
                if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(i.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("delivery_metrics_exported_to_big_query_enabled"))) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException e) {
            }
            return false;
        } catch (IllegalStateException e2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    private static void c(String str, Intent intent) {
        String str2;
        String str3;
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra3)) {
            bundle.putString("label", stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("google.c.a.m_c");
        if (!TextUtils.isEmpty(stringExtra4)) {
            bundle.putString("message_channel", stringExtra4);
        }
        String r = r(intent);
        if (r != null) {
            bundle.putString("_nt", r);
        }
        String stringExtra5 = intent.getStringExtra("google.c.a.ts");
        if (stringExtra5 != null) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(stringExtra5));
            } catch (NumberFormatException e) {
                Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e);
            }
        }
        if (intent.hasExtra("google.c.a.udt")) {
            str2 = intent.getStringExtra("google.c.a.udt");
        } else {
            str2 = null;
        }
        if (str2 != null) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(str2));
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e2);
            }
        }
        if (intent.getExtras() == null || !j.d(intent.getExtras())) {
            str3 = "data";
        } else {
            str3 = "display";
        }
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", str3);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(valueOf).length());
            sb.append("Logging to scion event=");
            sb.append(str);
            sb.append(" scionPayload=");
            sb.append(valueOf);
            Log.d("FirebaseMessaging", sb.toString());
        }
        z2 z2Var = (z2) gl.j().g(z2.class);
        if (z2Var != null) {
            z2Var.b("fcm", str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }

    static int l(Intent intent) {
        Object obj = intent.getExtras().get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
            sb.append("Invalid TTL: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0;
        }
    }

    static String m(Intent intent) {
        return intent.getStringExtra("collapse_key");
    }

    static String n(Intent intent) {
        return intent.getStringExtra("google.c.a.c_l");
    }

    static String o(Intent intent) {
        return intent.getStringExtra("google.c.a.m_l");
    }

    static String p(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        if (stringExtra == null) {
            return intent.getStringExtra("message_id");
        }
        return stringExtra;
    }

    static String e() {
        return gl.j().i().getPackageName();
    }

    static String g() {
        return FirebaseInstanceId.getInstance(gl.j()).a();
    }

    static String q(Intent intent) {
        if (intent.getExtras() == null || !j.d(intent.getExtras())) {
            return "DATA_MESSAGE";
        }
        return "DISPLAY_NOTIFICATION";
    }

    static String r(Intent intent) {
        String stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            return null;
        }
        return stringExtra;
    }

    static int s(Intent intent) {
        String stringExtra = intent.getStringExtra("google.delivered_priority");
        if (stringExtra == null) {
            if ("1".equals(intent.getStringExtra("google.priority_reduced"))) {
                return 2;
            }
            stringExtra = intent.getStringExtra("google.priority");
        }
        if ("high".equals(stringExtra)) {
            return 1;
        }
        if ("normal".equals(stringExtra)) {
            return 2;
        }
        return 0;
    }

    static String i() {
        gl j = gl.j();
        String d = j.m().d();
        if (d != null) {
            return d;
        }
        String c = j.m().c();
        if (!c.startsWith("1:")) {
            return c;
        }
        String[] split = c.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }
}
