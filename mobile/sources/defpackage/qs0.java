package defpackage;

import android.content.Context;
import android.os.SystemClock;
import java.util.Date;

/* renamed from: qs0  reason: default package */
public class qs0 {
    private static float a = 100.0f;

    /* renamed from: a  reason: collision with other field name */
    private static int f4854a = 750;

    /* renamed from: a  reason: collision with other field name */
    private static final im0 f4855a = new im0();

    /* renamed from: a  reason: collision with other field name */
    private static final qg f4856a = new qg();

    /* renamed from: a  reason: collision with other field name */
    private static final qs0 f4857a = new qs0();
    private static float b = 100.0f;

    /* renamed from: b  reason: collision with other field name */
    private static int f4858b = 30000;

    /* renamed from: b  reason: collision with other field name */
    private static final String f4859b = qs0.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private String f4860a = "1.us.pool.ntp.org";

    public static Date e() {
        if (d()) {
            return new Date((SystemClock.elapsedRealtime() - a()) + b());
        }
        throw new IllegalStateException("You need to call init() on TrueTime at least once.");
    }

    public static boolean d() {
        return f4855a.l() || f4856a.f();
    }

    public synchronized qs0 j(Context context) {
        f4856a.c(new nl0(context));
        return f4857a;
    }

    public synchronized qs0 h(int timeoutInMillis) {
        f4858b = timeoutInMillis;
        return f4857a;
    }

    public synchronized qs0 i(boolean isLoggingEnabled) {
        ps0.d(isLoggingEnabled);
        return f4857a;
    }

    /* access modifiers changed from: package-private */
    public long[] f(String ntpHost) {
        return f4855a.i(ntpHost, a, b, f4854a, f4858b);
    }

    static synchronized void g() {
        synchronized (qs0.class) {
            im0 im0 = f4855a;
            if (!im0.l()) {
                ps0.c(f4859b, "---- SNTP client not available. not caching TrueTime info in disk");
            } else {
                f4856a.a(im0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(long[] response) {
        f4855a.a(response);
    }

    private static long a() {
        long cachedDeviceUptime;
        im0 im0 = f4855a;
        if (im0.l()) {
            cachedDeviceUptime = im0.c();
        } else {
            cachedDeviceUptime = f4856a.d();
        }
        if (cachedDeviceUptime != 0) {
            return cachedDeviceUptime;
        }
        throw new RuntimeException("expected device time from last boot to be cached. couldn't find it.");
    }

    private static long b() {
        long cachedSntpTime;
        im0 im0 = f4855a;
        if (im0.l()) {
            cachedSntpTime = im0.d();
        } else {
            cachedSntpTime = f4856a.e();
        }
        if (cachedSntpTime != 0) {
            return cachedSntpTime;
        }
        throw new RuntimeException("expected SNTP time from last boot to be cached. couldn't find it.");
    }
}
