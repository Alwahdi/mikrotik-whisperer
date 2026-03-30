package defpackage;

import defpackage.qk0;
import io.grpc.LoadBalancerProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: wx  reason: default package */
public final class wx {
    private static final Iterable<Class<?>> a = c();

    /* renamed from: a  reason: collision with other field name */
    private static final Logger f5555a = Logger.getLogger(wx.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private static wx f5556a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedHashMap<String, vx> f5557a = new LinkedHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private final LinkedHashSet<vx> f5558a = new LinkedHashSet<>();

    private synchronized void a(vx provider) {
        v90.e(provider.d(), "isAvailable() returned false");
        this.f5558a.add(provider);
    }

    private synchronized void e() {
        this.f5557a.clear();
        Iterator it = this.f5558a.iterator();
        while (it.hasNext()) {
            vx provider = (vx) it.next();
            String policy = provider.b();
            vx existing = this.f5557a.get(policy);
            if (existing == null || existing.c() < provider.c()) {
                this.f5557a.put(policy, provider);
            }
        }
    }

    public static synchronized wx b() {
        wx wxVar;
        Class<vx> cls = vx.class;
        synchronized (wx.class) {
            if (f5556a == null) {
                List<LoadBalancerProvider> providerList = qk0.f(cls, a, cls.getClassLoader(), new a());
                f5556a = new wx();
                Iterator<LoadBalancerProvider> it = providerList.iterator();
                while (it.hasNext()) {
                    vx provider = (vx) it.next();
                    Logger logger = f5555a;
                    logger.fine("Service loader found " + provider);
                    if (provider.d()) {
                        f5556a.a(provider);
                    }
                }
                f5556a.e();
            }
            wxVar = f5556a;
        }
        return wxVar;
    }

    public synchronized vx d(String policy) {
        return this.f5557a.get(v90.o(policy, "policy"));
    }

    static List<Class<?>> c() {
        ArrayList<Class<?>> list = new ArrayList<>();
        Class<g90> cls = g90.class;
        try {
            int i = g90.a;
            list.add(cls);
        } catch (ClassNotFoundException e) {
            f5555a.log(Level.WARNING, "Unable to find pick-first LoadBalancer", e);
        }
        Class<tj0> cls2 = tj0.class;
        try {
            int i2 = tj0.a;
            list.add(cls2);
        } catch (ClassNotFoundException e2) {
            f5555a.log(Level.FINE, "Unable to find round-robin LoadBalancer", e2);
        }
        return Collections.unmodifiableList(list);
    }

    /* renamed from: wx$a */
    private static final class a implements qk0.b<vx> {
        a() {
        }

        /* renamed from: d */
        public boolean a(vx provider) {
            return provider.d();
        }

        /* renamed from: c */
        public int b(vx provider) {
            return provider.c();
        }
    }
}
