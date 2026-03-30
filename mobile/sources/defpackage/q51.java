package defpackage;

import android.text.TextUtils;

/* renamed from: q51  reason: default package */
public abstract class q51 {
    static String a() {
        return b("firebase-auth");
    }

    private static String b(String str) {
        String b = zw.a().b(str);
        if (TextUtils.isEmpty(b) || b.equals("UNKNOWN")) {
            return "-1";
        }
        return b;
    }
}
