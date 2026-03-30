package defpackage;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.firebase.iid.p;
import java.util.concurrent.ExecutorService;

/* renamed from: f31  reason: default package */
public abstract class f31 extends Service {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Binder f2943a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f2944a;

    /* renamed from: a  reason: collision with other field name */
    private final ExecutorService f2945a;
    private int b;

    public f31() {
        g11 a2 = uy0.a();
        String valueOf = String.valueOf(getClass().getSimpleName());
        this.f2945a = a2.b(new e30(valueOf.length() != 0 ? "Firebase-".concat(valueOf) : new String("Firebase-")), j61.b);
        this.f2944a = new Object();
        this.b = 0;
    }

    /* access modifiers changed from: protected */
    public abstract Intent a(Intent intent);

    public abstract boolean c(Intent intent);

    public abstract void d(Intent intent);

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f2943a == null) {
            this.f2943a = new p(new n61(this));
        }
        return this.f2943a;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final eq0<Void> e(Intent intent) {
        if (c(intent)) {
            return lq0.e(null);
        }
        gq0 gq0 = new gq0();
        this.f2945a.execute(new f51(this, intent, gq0));
        return gq0.a();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f2944a) {
            this.a = i2;
            this.b++;
        }
        Intent a2 = a(intent);
        if (a2 == null) {
            g(intent);
            return 2;
        }
        eq0<Void> f = e(a2);
        if (f.q()) {
            g(intent);
            return 2;
        }
        f.d(u71.a, new m71(this, intent));
        return 3;
    }

    public void onDestroy() {
        this.f2945a.shutdown();
        super.onDestroy();
    }

    private final void g(Intent intent) {
        if (intent != null) {
            v01.b(intent);
        }
        synchronized (this.f2944a) {
            int i = this.b - 1;
            this.b = i;
            if (i == 0) {
                stopSelfResult(this.a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Intent intent, eq0 eq0) {
        g(intent);
    }
}
