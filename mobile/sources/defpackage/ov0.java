package defpackage;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ov0  reason: default package */
public class ov0 {
    private static ScheduledExecutorService a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile a f4598a = new vy0();

    /* renamed from: a  reason: collision with other field name */
    private final int f4599a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f4600a;

    /* renamed from: a  reason: collision with other field name */
    private final PowerManager.WakeLock f4601a;

    /* renamed from: a  reason: collision with other field name */
    private WorkSource f4602a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f4603a;

    /* renamed from: a  reason: collision with other field name */
    private final String f4604a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, Integer[]> f4605a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<Future<?>> f4606a;

    /* renamed from: a  reason: collision with other field name */
    private AtomicInteger f4607a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f4608a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private final String f4609b;
    private final String c;

    /* renamed from: ov0$a */
    public interface a {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ov0(Context context, int i, String str) {
        this(context, i, str, (String) null, context == null ? null : context.getPackageName());
    }

    private ov0(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, (String) null, str3, (String) null);
    }

    private ov0(Context context, int i, String str, String str2, String str3, String str4) {
        this.f4603a = this;
        this.f4608a = true;
        this.f4605a = new HashMap();
        this.f4606a = Collections.synchronizedSet(new HashSet());
        this.f4607a = new AtomicInteger(0);
        y90.k(context, "WakeLock: context must not be null");
        y90.g(str, "WakeLock: wakeLockName must not be empty");
        this.f4599a = i;
        this.f4609b = null;
        this.c = null;
        Context applicationContext = context.getApplicationContext();
        this.f4600a = applicationContext;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf("*gcore*:");
            String valueOf2 = String.valueOf(str);
            this.f4604a = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.f4604a = str;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        this.f4601a = newWakeLock;
        if (zv0.c(context)) {
            WorkSource a2 = zv0.a(context, tn0.b(str3) ? context.getPackageName() : str3);
            this.f4602a = a2;
            if (a2 != null && zv0.c(applicationContext)) {
                WorkSource workSource = this.f4602a;
                if (workSource != null) {
                    workSource.add(a2);
                } else {
                    this.f4602a = a2;
                }
                try {
                    newWakeLock.setWorkSource(this.f4602a);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                    Log.wtf("WakeLock", e.toString());
                }
            }
        }
        if (a == null) {
            a = r90.a().a();
        }
    }

    private final List<String> e() {
        return zv0.b(this.f4602a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        if (r2 == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        if (r13.b == 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
        defpackage.pv0.a().c(r13.f4600a, defpackage.dn0.a(r13.f4601a, r6), 7, r13.f4604a, r6, (java.lang.String) null, r13.f4599a, e(), r14);
        r13.b++;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.f4607a
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.d(r0)
            java.lang.Object r0 = r13.f4603a
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f4605a     // Catch:{ all -> 0x009b }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x009b }
            r2 = 0
            if (r1 == 0) goto L_0x001d
            int r1 = r13.b     // Catch:{ all -> 0x009b }
            if (r1 <= 0) goto L_0x002c
        L_0x001d:
            android.os.PowerManager$WakeLock r1 = r13.f4601a     // Catch:{ all -> 0x009b }
            boolean r1 = r1.isHeld()     // Catch:{ all -> 0x009b }
            if (r1 != 0) goto L_0x002c
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f4605a     // Catch:{ all -> 0x009b }
            r1.clear()     // Catch:{ all -> 0x009b }
            r13.b = r2     // Catch:{ all -> 0x009b }
        L_0x002c:
            boolean r1 = r13.f4608a     // Catch:{ all -> 0x009b }
            r12 = 1
            if (r1 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f4605a     // Catch:{ all -> 0x009b }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x009b }
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch:{ all -> 0x009b }
            if (r1 != 0) goto L_0x004a
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f4605a     // Catch:{ all -> 0x009b }
            java.lang.Integer[] r3 = new java.lang.Integer[r12]     // Catch:{ all -> 0x009b }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x009b }
            r3[r2] = r4     // Catch:{ all -> 0x009b }
            r1.put(r6, r3)     // Catch:{ all -> 0x009b }
            r2 = 1
            goto L_0x0058
        L_0x004a:
            r3 = r1[r2]     // Catch:{ all -> 0x009b }
            int r3 = r3.intValue()     // Catch:{ all -> 0x009b }
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x009b }
            r1[r2] = r3     // Catch:{ all -> 0x009b }
        L_0x0058:
            if (r2 != 0) goto L_0x0062
        L_0x005a:
            boolean r1 = r13.f4608a     // Catch:{ all -> 0x009b }
            if (r1 != 0) goto L_0x0081
            int r1 = r13.b     // Catch:{ all -> 0x009b }
            if (r1 != 0) goto L_0x0081
        L_0x0062:
            pv0 r1 = defpackage.pv0.a()     // Catch:{ all -> 0x009b }
            android.content.Context r2 = r13.f4600a     // Catch:{ all -> 0x009b }
            android.os.PowerManager$WakeLock r3 = r13.f4601a     // Catch:{ all -> 0x009b }
            java.lang.String r3 = defpackage.dn0.a(r3, r6)     // Catch:{ all -> 0x009b }
            r4 = 7
            java.lang.String r5 = r13.f4604a     // Catch:{ all -> 0x009b }
            r7 = 0
            int r8 = r13.f4599a     // Catch:{ all -> 0x009b }
            java.util.List r9 = r13.e()     // Catch:{ all -> 0x009b }
            r10 = r14
            r1.c(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x009b }
            int r1 = r13.b     // Catch:{ all -> 0x009b }
            int r1 = r1 + r12
            r13.b = r1     // Catch:{ all -> 0x009b }
        L_0x0081:
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            android.os.PowerManager$WakeLock r0 = r13.f4601a
            r0.acquire()
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x009a
            java.util.concurrent.ScheduledExecutorService r0 = a
            h11 r1 = new h11
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L_0x009a:
            return
        L_0x009b:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ov0.a(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r1 == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        if (r12.b == 1) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        defpackage.pv0.a().b(r12.f4600a, defpackage.dn0.a(r12.f4601a, r6), 8, r12.f4604a, r6, (java.lang.String) null, r12.f4599a, e());
        r12.b--;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.f4607a
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L_0x001a
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r12.f4604a
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = " release without a matched acquire!"
            java.lang.String r1 = r1.concat(r2)
            android.util.Log.e(r0, r1)
        L_0x001a:
            r0 = 0
            java.lang.String r6 = r12.d(r0)
            java.lang.Object r0 = r12.f4603a
            monitor-enter(r0)
            boolean r1 = r12.f4608a     // Catch:{ all -> 0x0081 }
            r10 = 1
            r11 = 0
            if (r1 == 0) goto L_0x0055
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f4605a     // Catch:{ all -> 0x0081 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0081 }
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch:{ all -> 0x0081 }
            if (r1 != 0) goto L_0x0036
            r1 = 0
            goto L_0x0053
        L_0x0036:
            r2 = r1[r11]     // Catch:{ all -> 0x0081 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0081 }
            if (r2 != r10) goto L_0x0045
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f4605a     // Catch:{ all -> 0x0081 }
            r1.remove(r6)     // Catch:{ all -> 0x0081 }
            r1 = 1
            goto L_0x0053
        L_0x0045:
            r2 = r1[r11]     // Catch:{ all -> 0x0081 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0081 }
            int r2 = r2 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0081 }
            r1[r11] = r2     // Catch:{ all -> 0x0081 }
            r1 = 0
        L_0x0053:
            if (r1 != 0) goto L_0x005d
        L_0x0055:
            boolean r1 = r12.f4608a     // Catch:{ all -> 0x0081 }
            if (r1 != 0) goto L_0x007c
            int r1 = r12.b     // Catch:{ all -> 0x0081 }
            if (r1 != r10) goto L_0x007c
        L_0x005d:
            pv0 r1 = defpackage.pv0.a()     // Catch:{ all -> 0x0081 }
            android.content.Context r2 = r12.f4600a     // Catch:{ all -> 0x0081 }
            android.os.PowerManager$WakeLock r3 = r12.f4601a     // Catch:{ all -> 0x0081 }
            java.lang.String r3 = defpackage.dn0.a(r3, r6)     // Catch:{ all -> 0x0081 }
            r4 = 8
            java.lang.String r5 = r12.f4604a     // Catch:{ all -> 0x0081 }
            r7 = 0
            int r8 = r12.f4599a     // Catch:{ all -> 0x0081 }
            java.util.List r9 = r12.e()     // Catch:{ all -> 0x0081 }
            r1.b(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0081 }
            int r1 = r12.b     // Catch:{ all -> 0x0081 }
            int r1 = r1 - r10
            r12.b = r1     // Catch:{ all -> 0x0081 }
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            r12.f(r11)
            return
        L_0x0081:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ov0.b():void");
    }

    /* access modifiers changed from: private */
    public final void f(int i) {
        if (this.f4601a.isHeld()) {
            try {
                this.f4601a.release();
            } catch (RuntimeException e) {
                if (e.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.f4604a).concat(" was already released!"), e);
                } else {
                    throw e;
                }
            }
            this.f4601a.isHeld();
        }
    }

    private final String d(String str) {
        if (this.f4608a) {
            return !TextUtils.isEmpty(str) ? str : this.f4609b;
        }
        return this.f4609b;
    }

    public void c(boolean z) {
        this.f4601a.setReferenceCounted(z);
        this.f4608a = z;
    }
}
