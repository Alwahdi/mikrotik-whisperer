package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ej0  reason: default package */
public abstract class ej0 {
    public static final int a;

    /* renamed from: a  reason: collision with other field name */
    static final Map<ScheduledThreadPoolExecutor, Object> f2913a = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    static final AtomicReference<ScheduledExecutorService> f2914a = new AtomicReference<>();

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f2915a;

    static {
        boolean purgeEnable = true;
        int purgePeriod = 1;
        Properties properties = System.getProperties();
        if (properties.containsKey("rx2.purge-enabled")) {
            purgeEnable = Boolean.getBoolean("rx2.purge-enabled");
        }
        if (purgeEnable && properties.containsKey("rx2.purge-period-seconds")) {
            purgePeriod = Integer.getInteger("rx2.purge-period-seconds", 1).intValue();
        }
        f2915a = purgeEnable;
        a = purgePeriod;
        b();
    }

    public static void b() {
        if (f2915a) {
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = f2914a;
                ScheduledExecutorService curr = atomicReference.get();
                if (curr == null || curr.isShutdown()) {
                    ScheduledExecutorService next = Executors.newScheduledThreadPool(1, new pf0("RxSchedulerPurge"));
                    if (atomicReference.compareAndSet(curr, next)) {
                        a aVar = new a();
                        int i = a;
                        next.scheduleAtFixedRate(aVar, (long) i, (long) i, TimeUnit.SECONDS);
                        return;
                    }
                    next.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    public static ScheduledExecutorService a(ThreadFactory factory) {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1, factory);
        if (f2915a && (exec instanceof ScheduledThreadPoolExecutor)) {
            f2913a.put((ScheduledThreadPoolExecutor) exec, exec);
        }
        return exec;
    }

    /* renamed from: ej0$a */
    static final class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                Iterator it = new ArrayList(ej0.f2913a.keySet()).iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor e = (ScheduledThreadPoolExecutor) it.next();
                    if (e.isShutdown()) {
                        ej0.f2913a.remove(e);
                    } else {
                        e.purge();
                    }
                }
            } catch (Throwable e2) {
                of0.l(e2);
            }
        }
    }
}
