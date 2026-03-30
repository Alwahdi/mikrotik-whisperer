package defpackage;

import android.os.SystemClock;

/* renamed from: qg  reason: default package */
class qg {
    private static final String a = qg.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private l7 f4843a = null;

    qg() {
    }

    /* access modifiers changed from: package-private */
    public void c(l7 cacheInterface) {
        this.f4843a = cacheInterface;
    }

    /* access modifiers changed from: package-private */
    public void a(im0 sntpClient) {
        if (!b()) {
            long cachedSntpTime = sntpClient.d();
            long cachedDeviceUptime = sntpClient.c();
            long bootTime = cachedSntpTime - cachedDeviceUptime;
            ps0.a(a, String.format("Caching true time info to disk sntp [%s] device [%s] boot [%s]", new Object[]{Long.valueOf(cachedSntpTime), Long.valueOf(cachedDeviceUptime), Long.valueOf(bootTime)}));
            this.f4843a.b("timeme.com.instacart.library.truetime.cached_boot_time", bootTime);
            this.f4843a.b("timeme.com.instacart.library.truetime.cached_device_uptime", cachedDeviceUptime);
            this.f4843a.b("timeme.com.instacart.library.truetime.cached_sntp_time", cachedSntpTime);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (b() || this.f4843a.a("timeme.com.instacart.library.truetime.cached_boot_time", 0) == 0) {
            return false;
        }
        boolean bootTimeChanged = SystemClock.elapsedRealtime() < d();
        String str = a;
        ps0.c(str, "---- boot time changed " + bootTimeChanged);
        if (!bootTimeChanged) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        if (b()) {
            return 0;
        }
        return this.f4843a.a("timeme.com.instacart.library.truetime.cached_device_uptime", 0);
    }

    /* access modifiers changed from: package-private */
    public long e() {
        if (b()) {
            return 0;
        }
        return this.f4843a.a("timeme.com.instacart.library.truetime.cached_sntp_time", 0);
    }

    private boolean b() {
        if (this.f4843a != null) {
            return false;
        }
        ps0.e(a, "Cannot use disk caching strategy for TrueTime. CacheInterface unavailable");
        return true;
    }
}
