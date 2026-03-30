package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: x8  reason: default package */
public abstract class x8 {
    public static boolean a(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            if ((aw0.a(context).b(str, 0).flags & 2097152) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
