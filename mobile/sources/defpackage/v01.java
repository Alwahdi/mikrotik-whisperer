package defpackage;

import android.content.Intent;
import java.util.concurrent.TimeUnit;

/* renamed from: v01  reason: default package */
public abstract class v01 {
    private static final long a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: a  reason: collision with other field name */
    private static final Object f5291a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static ov0 f5292a;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.ComponentName a(android.content.Context r4, android.content.Intent r5) {
        /*
            java.lang.Object r0 = f5291a
            monitor-enter(r0)
            ov0 r1 = f5292a     // Catch:{ all -> 0x0035 }
            r2 = 1
            if (r1 != 0) goto L_0x0015
            ov0 r1 = new ov0     // Catch:{ all -> 0x0035 }
            java.lang.String r3 = "wake:com.google.firebase.iid.WakeLockHolder"
            r1.<init>(r4, r2, r3)     // Catch:{ all -> 0x0035 }
            f5292a = r1     // Catch:{ all -> 0x0035 }
            r1.c(r2)     // Catch:{ all -> 0x0035 }
        L_0x0015:
            java.lang.String r1 = "com.google.firebase.iid.WakeLockHolder.wakefulintent"
            r3 = 0
            boolean r1 = r5.getBooleanExtra(r1, r3)     // Catch:{ all -> 0x0035 }
            c(r5, r2)     // Catch:{ all -> 0x0035 }
            android.content.ComponentName r4 = r4.startService(r5)     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x002a
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r4
        L_0x002a:
            if (r1 != 0) goto L_0x0033
            ov0 r5 = f5292a     // Catch:{ all -> 0x0035 }
            long r1 = a     // Catch:{ all -> 0x0035 }
            r5.a(r1)     // Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r4
        L_0x0035:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v01.a(android.content.Context, android.content.Intent):android.content.ComponentName");
    }

    private static void c(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    public static void b(Intent intent) {
        synchronized (f5291a) {
            if (f5292a != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                c(intent, false);
                f5292a.b();
            }
        }
    }
}
