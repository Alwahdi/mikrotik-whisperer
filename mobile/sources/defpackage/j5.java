package defpackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: j5  reason: default package */
public final class j5 implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final j5 a = new j5();

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f4030a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private final AtomicBoolean f4031a = new AtomicBoolean();

    /* renamed from: a  reason: collision with other field name */
    private boolean f4032a = false;
    private final AtomicBoolean b = new AtomicBoolean();

    /* renamed from: j5$a */
    public interface a {
        void a(boolean z);
    }

    private j5() {
    }

    public static j5 b() {
        return a;
    }

    public static void c(Application application) {
        j5 j5Var = a;
        synchronized (j5Var) {
            if (!j5Var.f4032a) {
                application.registerActivityLifecycleCallbacks(j5Var);
                application.registerComponentCallbacks(j5Var);
                j5Var.f4032a = true;
            }
        }
    }

    public final boolean f(boolean z) {
        if (!this.b.get()) {
            if (!n90.c()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f4031a.set(true);
            }
        }
        return d();
    }

    public final boolean d() {
        return this.f4031a.get();
    }

    public final void a(a aVar) {
        synchronized (a) {
            this.f4030a.add(aVar);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f4031a.compareAndSet(true, false);
        this.b.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f4031a.compareAndSet(true, false);
        this.b.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.f4031a.compareAndSet(false, true)) {
            this.b.set(true);
            e(true);
        }
    }

    private final void e(boolean z) {
        synchronized (a) {
            ArrayList<a> arrayList = this.f4030a;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                a aVar = arrayList.get(i);
                i++;
                aVar.a(z);
            }
        }
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }
}
