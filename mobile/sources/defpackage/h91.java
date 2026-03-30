package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* renamed from: h91  reason: default package */
public abstract class h91 {
    private static int a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f3155a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static String f3156a;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f3157a;

    public static int a(Context context) {
        b(context);
        return a;
    }

    private static void b(Context context) {
        synchronized (f3155a) {
            if (!f3157a) {
                f3157a = true;
                try {
                    Bundle bundle = aw0.a(context).b(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f3156a = bundle.getString("com.google.app.id");
                        a = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            }
        }
    }
}
