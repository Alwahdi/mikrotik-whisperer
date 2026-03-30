package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.b;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: ut0  reason: default package */
public class ut0 {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final c9 f5266a;

    /* renamed from: a  reason: collision with other field name */
    private final h5 f5267a;

    /* renamed from: a  reason: collision with other field name */
    private final hj f5268a;

    /* renamed from: a  reason: collision with other field name */
    private final Executor f5269a;

    /* renamed from: a  reason: collision with other field name */
    private final xo0 f5270a;

    /* renamed from: a  reason: collision with other field name */
    private final yv0 f5271a;

    public ut0(Context context, h5 backendRegistry, hj eventStore, yv0 workScheduler, Executor executor, xo0 guard, c9 clock) {
        this.a = context;
        this.f5267a = backendRegistry;
        this.f5268a = eventStore;
        this.f5271a = workScheduler;
        this.f5269a = executor;
        this.f5270a = guard;
        this.f5266a = clock;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void g(es0 transportContext, int attemptNumber, Runnable callback) {
        this.f5269a.execute(pt0.a(this, transportContext, attemptNumber, callback));
    }

    static /* synthetic */ void e(ut0 ut0, es0 transportContext, int attemptNumber, Runnable callback) {
        try {
            xo0 xo0 = ut0.f5270a;
            hj hjVar = ut0.f5268a;
            hjVar.getClass();
            xo0.c(st0.b(hjVar));
            if (!ut0.a()) {
                ut0.f5270a.c(tt0.b(ut0, transportContext, attemptNumber));
            } else {
                ut0.f(transportContext, attemptNumber);
            }
        } catch (wo0 e) {
            ut0.f5271a.a(transportContext, attemptNumber + 1);
        } catch (Throwable th) {
            callback.run();
            throw th;
        }
        callback.run();
    }

    /* access modifiers changed from: package-private */
    public void f(es0 transportContext, int attemptNumber) {
        b response;
        ds0 backend = this.f5267a.a(transportContext.b());
        Iterable<PersistedEvent> persistedEvents = (Iterable) this.f5270a.c(qt0.b(this, transportContext));
        if (persistedEvents.iterator().hasNext()) {
            if (backend == null) {
                xy.a("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                response = b.a();
            } else {
                List<EventInternal> eventInternals = new ArrayList<>();
                Iterator<PersistedEvent> it = persistedEvents.iterator();
                while (it.hasNext()) {
                    eventInternals.add(((b90) it.next()).b());
                }
                response = backend.b(i5.a().b(eventInternals).c(transportContext.c()).a());
            }
            this.f5270a.c(rt0.b(this, response, persistedEvents, transportContext, attemptNumber));
        }
    }

    static /* synthetic */ Object c(ut0 ut0, b response, Iterable persistedEvents, es0 transportContext, int attemptNumber) {
        if (response.c() == b.a.TRANSIENT_ERROR) {
            ut0.f5268a.l(persistedEvents);
            ut0.f5271a.a(transportContext, attemptNumber + 1);
            return null;
        }
        ut0.f5268a.s(persistedEvents);
        if (response.c() == b.a.OK) {
            ut0.f5268a.H(transportContext, ut0.f5266a.a() + response.b());
        }
        if (!ut0.f5268a.L(transportContext)) {
            return null;
        }
        ut0.f5271a.a(transportContext, 1);
        return null;
    }
}
