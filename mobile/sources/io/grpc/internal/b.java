package io.grpc.internal;

import defpackage.b30;
import io.grpc.ClientInterceptor;
import io.grpc.h;
import io.grpc.internal.b;
import io.grpc.internal.m1;
import io.grpc.internal.y;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class b<T extends b<T>> extends sz<T> {
    private static final Logger a = Logger.getLogger(b.class.getName());
    private static final gf b = gf.c();

    /* renamed from: b  reason: collision with other field name */
    private static final ub f3296b = ub.a();
    private static final b40<? extends Executor> c = i1.c(h0.f3423a);
    static final long d = TimeUnit.MINUTES.toMillis(30);
    static final long e = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: a  reason: collision with other field name */
    int f3297a;

    /* renamed from: a  reason: collision with other field name */
    long f3298a;

    /* renamed from: a  reason: collision with other field name */
    private b30.c f3299a;

    /* renamed from: a  reason: collision with other field name */
    b40<? extends Executor> f3300a;

    /* renamed from: a  reason: collision with other field name */
    final d30 f3301a;

    /* renamed from: a  reason: collision with other field name */
    gf f3302a;

    /* renamed from: a  reason: collision with other field name */
    h f3303a;

    /* renamed from: a  reason: collision with other field name */
    protected m1.b f3304a;

    /* renamed from: a  reason: collision with other field name */
    final String f3305a;

    /* renamed from: a  reason: collision with other field name */
    private final SocketAddress f3306a;

    /* renamed from: a  reason: collision with other field name */
    private final List<w8> f3307a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    Map<String, ?> f3308a;

    /* renamed from: a  reason: collision with other field name */
    pb0 f3309a;

    /* renamed from: a  reason: collision with other field name */
    ub f3310a;

    /* renamed from: a  reason: collision with other field name */
    boolean f3311a;

    /* renamed from: b  reason: collision with other field name */
    int f3312b;

    /* renamed from: b  reason: collision with other field name */
    long f3313b;

    /* renamed from: b  reason: collision with other field name */
    b40<? extends Executor> f3314b;

    /* renamed from: b  reason: collision with other field name */
    String f3315b;

    /* renamed from: b  reason: collision with other field name */
    boolean f3316b;

    /* renamed from: c  reason: collision with other field name */
    int f3317c;

    /* renamed from: c  reason: collision with other field name */
    long f3318c;

    /* renamed from: c  reason: collision with other field name */
    String f3319c;

    /* renamed from: c  reason: collision with other field name */
    boolean f3320c;

    /* renamed from: d  reason: collision with other field name */
    private int f3321d;

    /* renamed from: d  reason: collision with other field name */
    String f3322d;

    /* renamed from: d  reason: collision with other field name */
    boolean f3323d;

    /* renamed from: e  reason: collision with other field name */
    private boolean f3324e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;

    /* access modifiers changed from: protected */
    public abstract q e();

    /* access modifiers changed from: protected */
    public abstract int f();

    /* access modifiers changed from: protected */
    public final int i() {
        return this.f3321d;
    }

    protected b(String target) {
        b40<? extends Executor> b40 = c;
        this.f3300a = b40;
        this.f3314b = b40;
        d30 c2 = d30.c();
        this.f3301a = c2;
        this.f3299a = c2.b();
        this.f3322d = "pick_first";
        this.f3302a = b;
        this.f3310a = f3296b;
        this.f3298a = d;
        this.f3297a = 5;
        this.f3312b = 5;
        this.f3313b = 16777216;
        this.f3318c = 1048576;
        this.f3316b = false;
        this.f3303a = h.g();
        this.f3323d = true;
        this.f3304a = m1.a();
        this.f3321d = 4194304;
        this.f3324e = true;
        this.f = true;
        this.g = true;
        this.h = false;
        this.i = true;
        this.f3305a = (String) v90.o(target, "target");
        this.f3306a = null;
    }

    public rz a() {
        return new r0(new q0(this, e(), new y.a(), i1.c(h0.f3423a), h0.f3428a, g(), nr0.a));
    }

    /* access modifiers changed from: package-private */
    public final List<w8> g() {
        List<ClientInterceptor> effectiveInterceptors = new ArrayList<>(this.f3307a);
        this.f3320c = false;
        if (this.f3324e) {
            this.f3320c = true;
            w8 statsInterceptor = null;
            try {
                Class<?> censusStatsAccessor = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
                Class cls = Boolean.TYPE;
                statsInterceptor = (w8) censusStatsAccessor.getDeclaredMethod("getClientInterceptor", new Class[]{cls, cls, cls}).invoke((Object) null, new Object[]{Boolean.valueOf(this.f), Boolean.valueOf(this.g), Boolean.valueOf(this.h)});
            } catch (ClassNotFoundException e2) {
                a.log(Level.FINE, "Unable to apply census stats", e2);
            } catch (NoSuchMethodException e3) {
                a.log(Level.FINE, "Unable to apply census stats", e3);
            } catch (IllegalAccessException e4) {
                a.log(Level.FINE, "Unable to apply census stats", e4);
            } catch (InvocationTargetException e5) {
                a.log(Level.FINE, "Unable to apply census stats", e5);
            }
            if (statsInterceptor != null) {
                effectiveInterceptors.add(0, statsInterceptor);
            }
        }
        if (this.i) {
            this.f3320c = true;
            w8 tracingInterceptor = null;
            try {
                tracingInterceptor = (w8) Class.forName("io.grpc.census.InternalCensusTracingAccessor").getDeclaredMethod("getClientInterceptor", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (ClassNotFoundException e6) {
                a.log(Level.FINE, "Unable to apply census stats", e6);
            } catch (NoSuchMethodException e7) {
                a.log(Level.FINE, "Unable to apply census stats", e7);
            } catch (IllegalAccessException e8) {
                a.log(Level.FINE, "Unable to apply census stats", e8);
            } catch (InvocationTargetException e9) {
                a.log(Level.FINE, "Unable to apply census stats", e9);
            }
            if (tracingInterceptor != null) {
                effectiveInterceptors.add(0, tracingInterceptor);
            }
        }
        return effectiveInterceptors;
    }

    /* access modifiers changed from: package-private */
    public b30.c h() {
        if (this.f3319c == null) {
            return this.f3299a;
        }
        return new y0(this.f3299a, this.f3319c);
    }
}
