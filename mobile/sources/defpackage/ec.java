package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import java.util.Collections;
import java.util.List;

/* renamed from: ec  reason: default package */
public class ec {
    private static volatile ec a;

    /* renamed from: a  reason: collision with other field name */
    private static final Object f2900a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static boolean f2901a = false;

    /* renamed from: a  reason: collision with other field name */
    private final List<String> f2902a;
    private final List<String> b;
    private final List<String> c;
    private final List<String> d;

    public static ec b() {
        if (a == null) {
            synchronized (f2900a) {
                if (a == null) {
                    a = new ec();
                }
            }
        }
        return a;
    }

    private ec() {
        List<String> list = Collections.EMPTY_LIST;
        this.f2902a = list;
        this.b = list;
        this.c = list;
        this.d = list;
    }

    public final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        boolean z;
        ComponentName component = intent.getComponent();
        if (component == null) {
            z = false;
        } else {
            z = x8.a(context, component.getPackageName());
        }
        if (!z) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return d(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public void c(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }
}
