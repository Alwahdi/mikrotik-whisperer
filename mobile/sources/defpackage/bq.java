package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;

/* renamed from: bq  reason: default package */
public class bq {
    private static bq a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f242a;

    private bq(Context context) {
        this.f242a = context.getApplicationContext();
    }

    public static bq a(Context context) {
        y90.j(context);
        synchronized (bq.class) {
            if (a == null) {
                g31.a(context);
                a = new bq(context);
            }
        }
        return a;
    }

    public static boolean c(PackageInfo packageInfo, boolean z) {
        g51 g51;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                g51 = b(packageInfo, v71.a);
            } else {
                g51 = b(packageInfo, v71.a[0]);
            }
            if (g51 != null) {
                return true;
            }
        }
        return false;
    }

    private static g51 b(PackageInfo packageInfo, g51... g51Arr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        o61 o61 = new o61(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < g51Arr.length; i++) {
            if (g51Arr[i].equals(o61)) {
                return g51Arr[i];
            }
        }
        return null;
    }
}
