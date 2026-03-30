package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import defpackage.pp;
import java.util.HashSet;
import java.util.Set;

/* renamed from: g61  reason: default package */
final class g61 implements ServiceConnection {
    private int a = 2;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ a51 f3013a;

    /* renamed from: a  reason: collision with other field name */
    private ComponentName f3014a;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f3015a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<ServiceConnection> f3016a = new HashSet();

    /* renamed from: a  reason: collision with other field name */
    private final pp.a f3017a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3018a;

    public g61(a51 a51, pp.a aVar) {
        this.f3013a = a51;
        this.f3017a = aVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f3013a.f24a) {
            this.f3013a.f22a.removeMessages(1, this.f3017a);
            this.f3015a = iBinder;
            this.f3014a = componentName;
            for (ServiceConnection onServiceConnected : this.f3016a) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.a = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f3013a.f24a) {
            this.f3013a.f22a.removeMessages(1, this.f3017a);
            this.f3015a = null;
            this.f3014a = componentName;
            for (ServiceConnection onServiceDisconnected : this.f3016a) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.a = 2;
        }
    }

    public final void h(String str) {
        this.a = 3;
        boolean d = this.f3013a.f23a.d(this.f3013a.f21a, str, this.f3017a.c(this.f3013a.f21a), this, this.f3017a.d());
        this.f3018a = d;
        if (d) {
            this.f3013a.f22a.sendMessageDelayed(this.f3013a.f22a.obtainMessage(1, this.f3017a), this.f3013a.b);
            return;
        }
        this.a = 2;
        try {
            this.f3013a.f23a.c(this.f3013a.f21a, this);
        } catch (IllegalArgumentException e) {
        }
    }

    public final void i(String str) {
        this.f3013a.f22a.removeMessages(1, this.f3017a);
        this.f3013a.f23a.c(this.f3013a.f21a, this);
        this.f3018a = false;
        this.a = 2;
    }

    public final void e(ServiceConnection serviceConnection, String str) {
        ec unused = this.f3013a.f23a;
        Context unused2 = this.f3013a.f21a;
        this.f3017a.c(this.f3013a.f21a);
        this.f3016a.add(serviceConnection);
    }

    public final void g(ServiceConnection serviceConnection, String str) {
        ec unused = this.f3013a.f23a;
        Context unused2 = this.f3013a.f21a;
        this.f3016a.remove(serviceConnection);
    }

    public final boolean d() {
        return this.f3018a;
    }

    public final int c() {
        return this.a;
    }

    public final boolean f(ServiceConnection serviceConnection) {
        return this.f3016a.contains(serviceConnection);
    }

    public final boolean j() {
        return this.f3016a.isEmpty();
    }

    public final IBinder a() {
        return this.f3015a;
    }

    public final ComponentName b() {
        return this.f3014a;
    }
}
