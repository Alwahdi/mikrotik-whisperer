package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: y91  reason: default package */
public final class y91 {
    private static y91 a;

    /* renamed from: a  reason: collision with other field name */
    private int f5867a = 1;

    /* renamed from: a  reason: collision with other field name */
    private aa1 f5868a = new aa1(this);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Context f5869a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ScheduledExecutorService f5870a;

    public static synchronized y91 e(Context context) {
        y91 y91;
        synchronized (y91.class) {
            if (a == null) {
                a = new y91(context, uy0.a().a(1, new e30("MessengerIpcClient"), j61.b));
            }
            y91 = a;
        }
        return y91;
    }

    private y91(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f5870a = scheduledExecutorService;
        this.f5869a = context.getApplicationContext();
    }

    public final eq0<Void> b(int i, Bundle bundle) {
        return c(new kz0(a(), 2, bundle));
    }

    public final eq0<Bundle> f(int i, Bundle bundle) {
        return c(new vz0(a(), 1, bundle));
    }

    private final synchronized <T> eq0<T> c(rz0<T> rz0) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(rz0);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.f5868a.e(rz0)) {
            aa1 aa1 = new aa1(this);
            this.f5868a = aa1;
            aa1.e(rz0);
        }
        return rz0.f4954a.a();
    }

    private final synchronized int a() {
        int i;
        i = this.f5867a;
        this.f5867a = i + 1;
        return i;
    }
}
