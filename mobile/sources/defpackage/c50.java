package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* renamed from: c50  reason: default package */
public class c50 {
    private final Context a;

    public c50(Context context) {
        this.a = context;
    }

    public ApplicationInfo b(String str, int i) {
        return this.a.getPackageManager().getApplicationInfo(str, i);
    }

    public PackageInfo d(String str, int i) {
        return this.a.getPackageManager().getPackageInfo(str, i);
    }

    public int a(String str, String str2) {
        return this.a.getPackageManager().checkPermission(str, str2);
    }

    public CharSequence c(String str) {
        return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(str, 0));
    }
}
