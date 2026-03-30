package defpackage;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* renamed from: tn0  reason: default package */
public abstract class tn0 {
    private static final Pattern a = Pattern.compile("\\$\\{(.*?)\\}");

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public static boolean b(String str) {
        return str == null || str.trim().isEmpty();
    }
}
