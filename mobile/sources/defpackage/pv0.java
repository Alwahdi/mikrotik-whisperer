package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.List;

/* renamed from: pv0  reason: default package */
public class pv0 {
    private static Boolean a;

    /* renamed from: a  reason: collision with other field name */
    private static pv0 f4733a = new pv0();

    /* renamed from: a  reason: collision with other field name */
    private static boolean f4734a = false;

    public static pv0 a() {
        return f4733a;
    }

    public void b(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        c(context, str, i, str2, str3, str4, i2, list, 0);
    }

    public void c(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        int i3 = i;
        if (e()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                Log.e("WakeLockTracker", valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
            } else if (7 == i3 || 8 == i3 || 10 == i3 || 11 == i3) {
                WakeLockEvent wakeLockEvent = r0;
                WakeLockEvent wakeLockEvent2 = new WakeLockEvent(System.currentTimeMillis(), i, str2, i2, dn0.b(list), str, SystemClock.elapsedRealtime(), qy0.a(context), str3, dn0.c(context.getPackageName()), qy0.b(context), j, str4, false);
                d(context, wakeLockEvent);
            }
        }
    }

    private static void d(Context context, WakeLockEvent wakeLockEvent) {
        try {
            context.startService(new Intent().setComponent(yy.f5959a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
        } catch (Exception e) {
            Log.wtf("WakeLockTracker", e);
        }
    }

    private static boolean e() {
        if (a == null) {
            a = false;
        }
        return a.booleanValue();
    }
}
