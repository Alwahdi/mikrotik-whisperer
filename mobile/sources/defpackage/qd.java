package defpackage;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;

/* renamed from: qd  reason: default package */
public abstract class qd {
    private static int a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static DropBoxManager f4839a = null;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f4840a = false;

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f4841a = {"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static int b = 0;
    private static int c = 0;

    public static boolean a(Context context, Throwable th) {
        return b(context, th, 536870912);
    }

    private static boolean b(Context context, Throwable th, int i) {
        try {
            y90.j(context);
            y90.j(th);
            return false;
        } catch (Exception e) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
            return false;
        }
    }
}
