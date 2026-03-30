package defpackage;

import androidx.core.os.EnvironmentCompat;
import defpackage.b30;
import defpackage.qk0;
import io.grpc.NameResolverProvider;
import io.grpc.internal.x;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: d30  reason: default package */
public final class d30 {
    private static d30 a;

    /* renamed from: a  reason: collision with other field name */
    private static final Logger f2700a = Logger.getLogger(d30.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private final b30.c f2701a = new b(this, (a) null);

    /* renamed from: a  reason: collision with other field name */
    private final LinkedHashSet<c30> f2702a = new LinkedHashSet<>();

    /* renamed from: a  reason: collision with other field name */
    private List<c30> f2703a = Collections.emptyList();

    private synchronized void a(c30 provider) {
        v90.e(provider.c(), "isAvailable() returned false");
        this.f2702a.add(provider);
    }

    private synchronized void f() {
        List<NameResolverProvider> providers = new ArrayList<>(this.f2702a);
        Collections.sort(providers, Collections.reverseOrder(new a()));
        this.f2703a = Collections.unmodifiableList(providers);
    }

    /* renamed from: d30$a */
    class a implements Comparator<c30> {
        a() {
        }

        /* renamed from: a */
        public int compare(c30 o1, c30 o2) {
            return o1.d() - o2.d();
        }
    }

    public static synchronized d30 c() {
        d30 d30;
        Class<c30> cls = c30.class;
        synchronized (d30.class) {
            if (a == null) {
                List<NameResolverProvider> providerList = qk0.f(cls, d(), cls.getClassLoader(), new c((a) null));
                if (providerList.isEmpty()) {
                    f2700a.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                a = new d30();
                Iterator<NameResolverProvider> it = providerList.iterator();
                while (it.hasNext()) {
                    c30 provider = (c30) it.next();
                    Logger logger = f2700a;
                    logger.fine("Service loader found " + provider);
                    if (provider.c()) {
                        a.a(provider);
                    }
                }
                a.f();
            }
            d30 = a;
        }
        return d30;
    }

    /* access modifiers changed from: package-private */
    public synchronized List<c30> e() {
        return this.f2703a;
    }

    public b30.c b() {
        return this.f2701a;
    }

    static List<Class<?>> d() {
        ArrayList<Class<?>> list = new ArrayList<>();
        Class<x> cls = x.class;
        try {
            int i = x.a;
            list.add(cls);
        } catch (ClassNotFoundException e) {
            f2700a.log(Level.FINE, "Unable to find DNS NameResolver", e);
        }
        return Collections.unmodifiableList(list);
    }

    /* renamed from: d30$b */
    private final class b extends b30.c {
        private b() {
        }

        /* synthetic */ b(d30 x0, a x1) {
            this();
        }

        public b30 b(URI targetUri, b30.a args) {
            for (c30 provider : d30.this.e()) {
                b30 resolver = provider.b(targetUri, args);
                if (resolver != null) {
                    return resolver;
                }
            }
            return null;
        }

        public String a() {
            List<c30> e = d30.this.e();
            if (e.isEmpty()) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            return e.get(0).a();
        }
    }

    /* renamed from: d30$c */
    private static final class c implements qk0.b<c30> {
        private c() {
        }

        /* synthetic */ c(a x0) {
            this();
        }

        /* renamed from: d */
        public boolean a(c30 provider) {
            return provider.c();
        }

        /* renamed from: c */
        public int b(c30 provider) {
            return provider.d();
        }
    }
}
