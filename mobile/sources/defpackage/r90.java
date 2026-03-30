package defpackage;

import java.util.concurrent.ScheduledExecutorService;

/* renamed from: r90  reason: default package */
public abstract class r90 {
    private static a a;

    /* renamed from: r90$a */
    public interface a {
        ScheduledExecutorService a();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (r90.class) {
            if (a == null) {
                a = new py0();
            }
            aVar = a;
        }
        return aVar;
    }
}
