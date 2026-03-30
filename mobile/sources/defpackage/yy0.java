package defpackage;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: yy0  reason: default package */
public final class yy0 {
    /* access modifiers changed from: private */
    public static vy a = new vy("TokenRefresher", "FirebaseAuth:");

    /* renamed from: a  reason: collision with other field name */
    volatile long f5960a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f5961a = new f81(this.f5962a.getLooper());

    /* renamed from: a  reason: collision with other field name */
    private HandlerThread f5962a;

    /* renamed from: a  reason: collision with other field name */
    private final gl f5963a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f5964a;
    volatile long b;
    private long c;

    public yy0(gl glVar) {
        a.f("Initializing TokenRefresher", new Object[0]);
        gl glVar2 = (gl) y90.j(glVar);
        this.f5963a = glVar2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.f5962a = handlerThread;
        handlerThread.start();
        this.f5964a = new ha1(this, glVar2.l());
        this.c = 300000;
    }

    public final void a() {
        vy vyVar = a;
        long j = this.f5960a - this.c;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j);
        vyVar.f(sb.toString(), new Object[0]);
        c();
        this.b = Math.max((this.f5960a - hf.b().a()) - this.c, 0) / 1000;
        this.f5961a.postDelayed(this.f5964a, this.b * 1000);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        long j;
        switch ((int) this.b) {
            case 30:
            case 60:
            case 120:
            case 240:
            case 480:
                j = 2 * this.b;
                break;
            case 960:
                j = 960;
                break;
            default:
                j = 30;
                break;
        }
        this.b = j;
        this.f5960a = hf.b().a() + (this.b * 1000);
        vy vyVar = a;
        long j2 = this.f5960a;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j2);
        vyVar.f(sb.toString(), new Object[0]);
        this.f5961a.postDelayed(this.f5964a, this.b * 1000);
    }

    public final void c() {
        this.f5961a.removeCallbacks(this.f5964a);
    }
}
