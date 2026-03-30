package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import defpackage.b30;
import io.grpc.EquivalentAddressGroup;
import io.grpc.internal.h1;
import io.grpc.p;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public class w extends b30 {
    private static final g a;

    /* renamed from: a  reason: collision with other field name */
    private static final Set<String> f3753a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"clientLanguage", "percentage", "clientHostname", "serviceConfig"})));
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final Logger f3754a;
    private static final String c;
    private static final String d;
    private static final String e;

    /* renamed from: e  reason: collision with other field name */
    static boolean f3755e;
    private static String f;

    /* renamed from: f  reason: collision with other field name */
    static boolean f3756f;
    protected static boolean g;

    /* renamed from: a  reason: collision with other field name */
    private final int f3757a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final long f3758a;

    /* renamed from: a  reason: collision with other field name */
    private b30.d f3759a;

    /* renamed from: a  reason: collision with other field name */
    private final b30.f f3760a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final hn0 f3761a;

    /* renamed from: a  reason: collision with other field name */
    private final h1.d<Executor> f3762a;

    /* renamed from: a  reason: collision with other field name */
    protected volatile b f3763a = d.INSTANCE;

    /* renamed from: a  reason: collision with other field name */
    private final String f3764a;

    /* renamed from: a  reason: collision with other field name */
    private final Random f3765a = new Random();

    /* renamed from: a  reason: collision with other field name */
    private Executor f3766a;

    /* renamed from: a  reason: collision with other field name */
    private final AtomicReference<f> f3767a = new AtomicReference<>();

    /* renamed from: a  reason: collision with other field name */
    final pb0 f3768a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final vo0 f3769a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f3770a;
    /* access modifiers changed from: private */
    public final String b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f3771b;

    /* renamed from: c  reason: collision with other field name */
    private final boolean f3772c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with other field name */
    public boolean f3773d;

    public interface b {
        List<InetAddress> resolveAddress(String str);
    }

    public interface f {
        List<String> a(String str);
    }

    interface g {
        Throwable a();

        f b();
    }

    static {
        Class<w> cls = w.class;
        f3754a = Logger.getLogger(cls.getName());
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        c = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        d = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        e = property3;
        f3755e = Boolean.parseBoolean(property);
        f3756f = Boolean.parseBoolean(property2);
        g = Boolean.parseBoolean(property3);
        a = u(cls.getClassLoader());
    }

    protected w(String nsAuthority, String name, b30.a args, h1.d<Executor> executorResource, hn0 stopwatch, boolean isAndroid) {
        v90.o(args, "args");
        this.f3762a = executorResource;
        URI nameUri = URI.create("//" + ((String) v90.o(name, "name")));
        boolean z = true;
        v90.j(nameUri.getHost() != null, "Invalid DNS name: %s", name);
        this.f3764a = (String) v90.p(nameUri.getAuthority(), "nameUri (%s) doesn't have an authority", nameUri);
        this.b = nameUri.getHost();
        if (nameUri.getPort() == -1) {
            this.f3757a = args.a();
        } else {
            this.f3757a = nameUri.getPort();
        }
        this.f3768a = (pb0) v90.o(args.c(), "proxyDetector");
        this.f3758a = r(isAndroid);
        this.f3761a = (hn0) v90.o(stopwatch, NotificationCompat.CATEGORY_STOPWATCH);
        this.f3769a = (vo0) v90.o(args.e(), "syncContext");
        Executor b2 = args.b();
        this.f3766a = b2;
        this.f3772c = b2 != null ? false : z;
        this.f3760a = (b30.f) v90.o(args.d(), "serviceConfigParser");
    }

    public String a() {
        return this.f3764a;
    }

    public void d(b30.d listener) {
        v90.u(this.f3759a == null, "already started");
        if (this.f3772c) {
            this.f3766a = (Executor) h1.d(this.f3762a);
        }
        this.f3759a = (b30.d) v90.o(listener, "listener");
        y();
    }

    public void b() {
        v90.u(this.f3759a != null, "not started");
        y();
    }

    private List<ti> z() {
        Exception addressesException;
        try {
            List<InetAddress> resolveAddress = this.f3763a.resolveAddress(this.b);
            if (0 != 0) {
                f3754a.log(Level.FINE, "Address resolution failure", (Throwable) null);
            }
            List<EquivalentAddressGroup> servers = new ArrayList<>(resolveAddress.size());
            for (InetAddress inetAddr : resolveAddress) {
                servers.add(new ti((SocketAddress) new InetSocketAddress(inetAddr, this.f3757a)));
            }
            return Collections.unmodifiableList(servers);
        } catch (Exception e2) {
            addressesException = e2;
            hr0.f(e2);
            throw new RuntimeException(e2);
        } catch (Throwable th) {
            if (addressesException != null) {
                f3754a.log(Level.FINE, "Address resolution failure", addressesException);
            }
            throw th;
        }
    }

    private b30.b A() {
        List<String> txtRecords = Collections.emptyList();
        f resourceResolver = t();
        if (resourceResolver != null) {
            try {
                txtRecords = resourceResolver.a("_grpc_config." + this.b);
            } catch (Exception e2) {
                f3754a.log(Level.FINE, "ServiceConfig resolution failure", e2);
            }
        }
        if (!txtRecords.isEmpty()) {
            b30.b rawServiceConfig = w(txtRecords, this.f3765a, q());
            if (rawServiceConfig == null) {
                return null;
            }
            if (rawServiceConfig.d() != null) {
                return b30.b.b(rawServiceConfig.d());
            }
            return this.f3760a.a((Map) rawServiceConfig.c());
        }
        f3754a.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.b});
        return null;
    }

    /* access modifiers changed from: private */
    public ti m() {
        ob0 proxiedAddr = this.f3768a.a(InetSocketAddress.createUnresolved(this.b, this.f3757a));
        if (proxiedAddr != null) {
            return new ti((SocketAddress) proxiedAddr);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public c n(boolean forceTxt) {
        c result = new c();
        try {
            List unused = result.f3775a = z();
        } catch (Exception e2) {
            if (!forceTxt) {
                p pVar = p.p;
                p unused2 = result.f3774a = pVar.q("Unable to resolve host " + this.b).p(e2);
                return result;
            }
        }
        if (g) {
            b30.b unused3 = result.a = A();
        }
        return result;
    }

    private final class e implements Runnable {
        private final b30.d a;

        e(b30.d savedListener) {
            this.a = (b30.d) v90.o(savedListener, "savedListener");
        }

        public void run() {
            vo0 e;
            a aVar;
            Logger f = w.f3754a;
            Level level = Level.FINER;
            if (f.isLoggable(level)) {
                Logger f2 = w.f3754a;
                f2.finer("Attempting DNS resolution of " + w.this.b);
            }
            c result = null;
            boolean succeed = true;
            try {
                ti proxiedAddr = w.this.m();
                b30.e.a resolutionResultBuilder = b30.e.d();
                if (proxiedAddr != null) {
                    if (w.f3754a.isLoggable(level)) {
                        Logger f3 = w.f3754a;
                        f3.finer("Using proxy address " + proxiedAddr);
                    }
                    resolutionResultBuilder.b(Collections.singletonList(proxiedAddr));
                } else {
                    result = w.this.n(false);
                    if (result.f3774a != null) {
                        this.a.a(result.f3774a);
                        if (result == null || result.f3774a != null) {
                            succeed = false;
                        }
                        w.this.f3769a.execute(new a(succeed));
                        return;
                    }
                    if (result.f3775a != null) {
                        resolutionResultBuilder.b(result.f3775a);
                    }
                    if (result.a != null) {
                        resolutionResultBuilder.d(result.a);
                    }
                    v4 v4Var = result.f3776a;
                    if (v4Var != null) {
                        resolutionResultBuilder.c(v4Var);
                    }
                }
                this.a.b(resolutionResultBuilder.a());
                if (result == null || result.f3774a != null) {
                    succeed = false;
                }
                boolean succeed2 = succeed;
                e = w.this.f3769a;
                aVar = new a(succeed2);
            } catch (IOException e2) {
                b30.d dVar = this.a;
                p pVar = p.p;
                dVar.a(pVar.q("Unable to resolve host " + w.this.b).p(e2));
                if (result == null || result.f3774a != null) {
                    succeed = false;
                }
                boolean succeed3 = succeed;
                e = w.this.f3769a;
                aVar = new a(succeed3);
            } catch (Throwable th) {
                if (result == null || result.f3774a != null) {
                    succeed = false;
                }
                w.this.f3769a.execute(new a(succeed));
                throw th;
            }
            e.execute(aVar);
        }

        class a implements Runnable {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ boolean f3778a;

            a(boolean z) {
                this.f3778a = z;
            }

            public void run() {
                if (this.f3778a) {
                    w wVar = w.this;
                    wVar.f3770a = true;
                    if (wVar.f3758a > 0) {
                        w.this.f3761a.f().g();
                    }
                }
                boolean unused = w.this.f3773d = false;
            }
        }
    }

    static b30.b w(List<String> rawTxtRecords, Random random, String localHostname) {
        try {
            Map<String, ?> possibleServiceConfig = null;
            for (Map<String, ?> possibleServiceConfigChoice : x(rawTxtRecords)) {
                try {
                    possibleServiceConfig = v(possibleServiceConfigChoice, random, localHostname);
                    if (possibleServiceConfig != null) {
                        break;
                    }
                } catch (RuntimeException e2) {
                    return b30.b.b(p.c.q("failed to pick service config choice").p(e2));
                }
            }
            if (possibleServiceConfig == null) {
                return null;
            }
            return b30.b.a(possibleServiceConfig);
        } catch (IOException | RuntimeException e3) {
            return b30.b.b(p.c.q("failed to parse TXT records").p(e3));
        }
    }

    private void y() {
        if (!this.f3773d && !this.f3771b && l()) {
            this.f3773d = true;
            this.f3766a.execute(new e(this.f3759a));
        }
    }

    private boolean l() {
        if (this.f3770a) {
            long j = this.f3758a;
            return j == 0 || (j > 0 && this.f3761a.d(TimeUnit.NANOSECONDS) > this.f3758a);
        }
    }

    public void c() {
        if (!this.f3771b) {
            this.f3771b = true;
            Executor executor = this.f3766a;
            if (executor != null && this.f3772c) {
                this.f3766a = (Executor) h1.f(this.f3762a, executor);
            }
        }
    }

    static List<Map<String, ?>> x(List<String> txtRecords) {
        List<Map<String, ?>> possibleServiceConfigChoices = new ArrayList<>();
        for (String txtRecord : txtRecords) {
            if (!txtRecord.startsWith("grpc_config=")) {
                f3754a.log(Level.FINE, "Ignoring non service config {0}", new Object[]{txtRecord});
            } else {
                Object rawChoices = uv.a(txtRecord.substring("grpc_config=".length()));
                if (rawChoices instanceof List) {
                    possibleServiceConfigChoices.addAll(vv.a((List) rawChoices));
                } else {
                    throw new ClassCastException("wrong type " + rawChoices);
                }
            }
        }
        return possibleServiceConfigChoices;
    }

    private static final Double s(Map<String, ?> serviceConfigChoice) {
        return vv.h(serviceConfigChoice, "percentage");
    }

    private static final List<String> o(Map<String, ?> serviceConfigChoice) {
        return vv.g(serviceConfigChoice, "clientLanguage");
    }

    private static final List<String> p(Map<String, ?> serviceConfigChoice) {
        return vv.g(serviceConfigChoice, "clientHostname");
    }

    private static long r(boolean isAndroid) {
        if (isAndroid) {
            return 0;
        }
        String cacheTtlPropertyValue = System.getProperty("networkaddress.cache.ttl");
        long cacheTtl = 30;
        if (cacheTtlPropertyValue != null) {
            try {
                cacheTtl = Long.parseLong(cacheTtlPropertyValue);
            } catch (NumberFormatException e2) {
                f3754a.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", cacheTtlPropertyValue, 30L});
            }
        }
        return cacheTtl > 0 ? TimeUnit.SECONDS.toNanos(cacheTtl) : cacheTtl;
    }

    static Map<String, ?> v(Map<String, ?> choice, Random random, String hostname) {
        for (Map.Entry<String, ?> entry : choice.entrySet()) {
            xu0.a(f3753a.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List<String> clientLanguages = o(choice);
        if (clientLanguages != null && !clientLanguages.isEmpty()) {
            boolean javaPresent = false;
            Iterator<String> it = clientLanguages.iterator();
            while (true) {
                if (it.hasNext()) {
                    if ("java".equalsIgnoreCase(it.next())) {
                        javaPresent = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!javaPresent) {
                return null;
            }
        }
        Double percentage = s(choice);
        if (percentage != null) {
            int pct = percentage.intValue();
            xu0.a(pct >= 0 && pct <= 100, "Bad percentage: %s", percentage);
            if (random.nextInt(100) >= pct) {
                return null;
            }
        }
        List<String> clientHostnames = p(choice);
        if (clientHostnames != null && !clientHostnames.isEmpty()) {
            boolean hostnamePresent = false;
            Iterator<String> it2 = clientHostnames.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().equals(hostname)) {
                        hostnamePresent = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!hostnamePresent) {
                return null;
            }
        }
        Map<String, ?> sc = vv.j(choice, "serviceConfig");
        if (sc != null) {
            return sc;
        }
        throw new yu0(String.format("key '%s' missing in '%s'", new Object[]{choice, "serviceConfig"}));
    }

    protected static final class c {
        /* access modifiers changed from: private */
        public b30.b a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public p f3774a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public List<ti> f3775a;

        /* renamed from: a  reason: collision with other field name */
        public v4 f3776a;

        private c() {
        }
    }

    private enum d implements b {
        INSTANCE;

        public List<InetAddress> resolveAddress(String host) throws UnknownHostException {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(host)));
        }
    }

    /* access modifiers changed from: protected */
    public f t() {
        g gVar;
        if (!B(f3755e, f3756f, this.b)) {
            return null;
        }
        f fVar = this.f3767a.get();
        f rr = fVar;
        if (fVar != null || (gVar = a) == null) {
            return rr;
        }
        if (gVar.a() == null) {
            return gVar.b();
        }
        throw new AssertionError();
    }

    static g u(ClassLoader loader) {
        try {
            try {
                try {
                    g rrf = (g) Class.forName("io.grpc.internal.n0", true, loader).asSubclass(g.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (rrf.a() == null) {
                        return rrf;
                    }
                    f3754a.log(Level.FINE, "JndiResourceResolverFactory not available, skipping.", rrf.a());
                    return null;
                } catch (Exception e2) {
                    f3754a.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", e2);
                    return null;
                }
            } catch (Exception e3) {
                f3754a.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", e3);
                return null;
            }
        } catch (ClassNotFoundException e4) {
            f3754a.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", e4);
            return null;
        } catch (ClassCastException e5) {
            f3754a.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", e5);
            return null;
        }
    }

    private static String q() {
        if (f == null) {
            try {
                f = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e2) {
                throw new RuntimeException(e2);
            }
        }
        return f;
    }

    protected static boolean B(boolean jndiEnabled, boolean jndiLocalhostEnabled, String target) {
        if (!jndiEnabled) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(target)) {
            return jndiLocalhostEnabled;
        }
        if (target.contains(":")) {
            return false;
        }
        boolean alldigits = true;
        for (int i = 0; i < target.length(); i++) {
            char c2 = target.charAt(i);
            if (c2 != '.') {
                alldigits &= c2 >= '0' && c2 <= '9';
            }
        }
        return !alldigits;
    }
}
