package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* renamed from: up  reason: default package */
public class up {
    public static final int a = aq.a;

    /* renamed from: a  reason: collision with other field name */
    private static final up f5248a = new up();

    public static up e() {
        return f5248a;
    }

    up() {
    }

    public int f(Context context) {
        return g(context, a);
    }

    public int g(Context context, int i) {
        int e = aq.e(context, i);
        if (aq.f(context, e)) {
            return 18;
        }
        return e;
    }

    public void i(Context context, int i) {
        aq.a(context, i);
    }

    public boolean h(int i) {
        return aq.i(i);
    }

    public Intent a(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                if (context == null || !jg.c(context)) {
                    return h71.a("com.google.android.gms", j(context, str));
                }
                return h71.c();
            case 3:
                return h71.b("com.google.android.gms");
            default:
                return null;
        }
    }

    public PendingIntent b(Context context, int i, int i2) {
        return c(context, i, i2, (String) null);
    }

    public PendingIntent c(Context context, int i, int i2, String str) {
        Intent a2 = a(context, i, str);
        if (a2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, a2, 134217728);
    }

    public String d(int i) {
        return aq.b(i);
    }

    private static String j(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(aw0.a(context).d(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return sb.toString();
    }
}
