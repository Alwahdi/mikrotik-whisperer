package defpackage;

import android.os.Build;
import java.util.Locale;

/* renamed from: uz  reason: default package */
public abstract class uz {
    public static boolean b() {
        return a().equals("meizu");
    }

    private static String a() {
        String manufacturer = Build.MANUFACTURER;
        if (manufacturer != null) {
            return manufacturer.toLowerCase(Locale.ENGLISH);
        }
        return "";
    }
}
