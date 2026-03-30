package io.grpc.internal;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class h1 {
    private static final h1 a = new h1(new a());

    /* renamed from: a  reason: collision with other field name */
    private final e f3436a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final IdentityHashMap<d<?>, c> f3437a = new IdentityHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ScheduledExecutorService f3438a;

    public interface d<T> {
        void a(T t);

        T b();
    }

    interface e {
        ScheduledExecutorService a();
    }

    class a implements e {
        a() {
        }

        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(h0.g("grpc-shared-destroyer-%d", true));
        }
    }

    h1(e destroyerFactory) {
        this.f3436a = destroyerFactory;
    }

    public static <T> T d(d<T> resource) {
        return a.e(resource);
    }

    public static <T> T f(d<T> resource, T instance) {
        return a.g(resource, instance);
    }

    /* access modifiers changed from: package-private */
    public synchronized <T> T e(d<T> resource) {
        c instance;
        instance = this.f3437a.get(resource);
        if (instance == null) {
            instance = new c(resource.b());
            this.f3437a.put(resource, instance);
        }
        ScheduledFuture<?> scheduledFuture = instance.f3443a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            instance.f3443a = null;
        }
        instance.a++;
        return instance.f3442a;
    }

    /* access modifiers changed from: package-private */
    public synchronized <T> T g(d<T> resource, T instance) {
        c cached = this.f3437a.get(resource);
        if (cached != null) {
            boolean z = false;
            v90.e(instance == cached.f3442a, "Releasing the wrong instance");
            v90.u(cached.a > 0, "Refcount has already reached zero");
            int i = cached.a - 1;
            cached.a = i;
            if (i == 0) {
                if (cached.f3443a == null) {
                    z = true;
                }
                v90.u(z, "Destroy task already scheduled");
                if (this.f3438a == null) {
                    this.f3438a = this.f3436a.a();
                }
                cached.f3443a = this.f3438a.schedule(new ty(new b(cached, resource, instance)), 1, TimeUnit.SECONDS);
            }
        } else {
            throw new IllegalArgumentException("No cached instance found for " + resource);
        }
        return null;
    }

    class b implements Runnable {
        final /* synthetic */ c a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ d f3439a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Object f3441a;

        b(c cVar, d dVar, Object obj) {
            this.a = cVar;
            this.f3439a = dVar;
            this.f3441a = obj;
        }

        /* JADX INFO: finally extract failed */
        public void run() {
            synchronized (h1.this) {
                if (this.a.a == 0) {
                    try {
                        this.f3439a.a(this.f3441a);
                        h1.this.f3437a.remove(this.f3439a);
                        if (h1.this.f3437a.isEmpty()) {
                            h1.this.f3438a.shutdown();
                            ScheduledExecutorService unused = h1.this.f3438a = null;
                        }
                    } catch (Throwable th) {
                        h1.this.f3437a.remove(this.f3439a);
                        if (h1.this.f3437a.isEmpty()) {
                            h1.this.f3438a.shutdown();
                            ScheduledExecutorService unused2 = h1.this.f3438a = null;
                        }
                        throw th;
                    }
                }
            }
        }
    }

    private static class c {
        int a;

        /* renamed from: a  reason: collision with other field name */
        final Object f3442a;

        /* renamed from: a  reason: collision with other field name */
        ScheduledFuture<?> f3443a;

        c(Object payload) {
            this.f3442a = payload;
        }
    }
}
