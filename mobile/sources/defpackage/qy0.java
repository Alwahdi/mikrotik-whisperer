package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* renamed from: qy0  reason: default package */
public abstract class qy0 {
    private static float a = Float.NaN;

    /* renamed from: a  reason: collision with other field name */
    private static long f4868a;

    /* renamed from: a  reason: collision with other field name */
    private static final IntentFilter f4869a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    public static int a(Context context) {
        boolean z;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, f4869a);
        int i = 0;
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (n90.e()) {
            z = powerManager.isInteractive();
        } else {
            z = powerManager.isScreenOn();
        }
        if (z) {
            i = 2;
        }
        return i | i2;
    }

    public static synchronized float b(Context context) {
        synchronized (qy0.class) {
            if (SystemClock.elapsedRealtime() - f4868a >= 60000 || Float.isNaN(a)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, f4869a);
                if (registerReceiver != null) {
                    a = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                f4868a = SystemClock.elapsedRealtime();
                float f = a;
                return f;
            }
            float f2 = a;
            return f2;
        }
    }
}
