package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.SimpleArrayMap;

/* renamed from: cc  reason: default package */
public abstract class cc {
    private static final SimpleArrayMap<String, String> a = new SimpleArrayMap<>();

    public static String g(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(qc0.common_google_play_services_install_title);
            case 2:
                return resources.getString(qc0.common_google_play_services_update_title);
            case 3:
                return resources.getString(qc0.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return h(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return h(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return h(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return h(context, "common_google_play_services_restricted_profile_title");
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i);
                Log.e("GoogleApiAvailability", sb.toString());
                return null;
        }
    }

    public static String f(Context context, int i) {
        String str;
        if (i == 6) {
            str = h(context, "common_google_play_services_resolution_required_title");
        } else {
            str = g(context, i);
        }
        if (str == null) {
            return context.getResources().getString(qc0.common_google_play_services_notification_ticker);
        }
        return str;
    }

    public static String d(Context context, int i) {
        Resources resources = context.getResources();
        String a2 = a(context);
        switch (i) {
            case 1:
                return resources.getString(qc0.common_google_play_services_install_text, new Object[]{a2});
            case 2:
                if (jg.c(context)) {
                    return resources.getString(qc0.common_google_play_services_wear_update_text);
                }
                return resources.getString(qc0.common_google_play_services_update_text, new Object[]{a2});
            case 3:
                return resources.getString(qc0.common_google_play_services_enable_text, new Object[]{a2});
            case 5:
                return i(context, "common_google_play_services_invalid_account_text", a2);
            case 7:
                return i(context, "common_google_play_services_network_error_text", a2);
            case 9:
                return resources.getString(qc0.common_google_play_services_unsupported_text, new Object[]{a2});
            case 16:
                return i(context, "common_google_play_services_api_unavailable_text", a2);
            case 17:
                return i(context, "common_google_play_services_sign_in_failed_text", a2);
            case 18:
                return resources.getString(qc0.common_google_play_services_updating_text, new Object[]{a2});
            case 20:
                return i(context, "common_google_play_services_restricted_profile_text", a2);
            default:
                return resources.getString(rc0.common_google_play_services_unknown_issue, new Object[]{a2});
        }
    }

    public static String e(Context context, int i) {
        if (i == 6 || i == 19) {
            return i(context, "common_google_play_services_resolution_required_text", a(context));
        }
        return d(context, i);
    }

    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(qc0.common_google_play_services_install_button);
            case 2:
                return resources.getString(qc0.common_google_play_services_update_button);
            case 3:
                return resources.getString(qc0.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return aw0.a(context).c(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                return packageName;
            }
            return str;
        }
    }

    private static String i(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String h = h(context, str);
        if (h == null) {
            h = resources.getString(rc0.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, h, new Object[]{str2});
    }

    private static String h(Context context, String str) {
        SimpleArrayMap<String, String> simpleArrayMap = a;
        synchronized (simpleArrayMap) {
            String str2 = simpleArrayMap.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources d = zp.d(context);
            if (d == null) {
                return null;
            }
            int identifier = d.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = d.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
                return null;
            }
            simpleArrayMap.put(str, string);
            return string;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(qc0.common_google_play_services_notification_channel_name);
    }
}
