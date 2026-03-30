package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import defpackage.pp;
import java.util.HashMap;

/* renamed from: a51  reason: default package */
final class a51 extends pp implements Handler.Callback {
    private final long a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Context f21a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Handler f22a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ec f23a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<pp.a, g61> f24a = new HashMap<>();
    /* access modifiers changed from: private */
    public final long b;

    a51(Context context) {
        this.f21a = context.getApplicationContext();
        this.f22a = new b51(context.getMainLooper(), this);
        this.f23a = ec.b();
        this.a = 5000;
        this.b = 300000;
    }

    /* access modifiers changed from: protected */
    public final boolean c(pp.a aVar, ServiceConnection serviceConnection, String str) {
        boolean d;
        y90.k(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f24a) {
            g61 g61 = this.f24a.get(aVar);
            if (g61 == null) {
                g61 = new g61(this, aVar);
                g61.e(serviceConnection, str);
                g61.h(str);
                this.f24a.put(aVar, g61);
            } else {
                this.f22a.removeMessages(0, aVar);
                if (!g61.f(serviceConnection)) {
                    g61.e(serviceConnection, str);
                    switch (g61.c()) {
                        case 1:
                            serviceConnection.onServiceConnected(g61.b(), g61.a());
                            break;
                        case 2:
                            g61.h(str);
                            break;
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            d = g61.d();
        }
        return d;
    }

    /* access modifiers changed from: protected */
    public final void d(pp.a aVar, ServiceConnection serviceConnection, String str) {
        y90.k(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f24a) {
            g61 g61 = this.f24a.get(aVar);
            if (g61 == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (g61.f(serviceConnection)) {
                g61.g(serviceConnection, str);
                if (g61.j()) {
                    this.f22a.sendMessageDelayed(this.f22a.obtainMessage(0, aVar), this.a);
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                synchronized (this.f24a) {
                    pp.a aVar = (pp.a) message.obj;
                    g61 g61 = this.f24a.get(aVar);
                    if (g61 != null && g61.j()) {
                        if (g61.d()) {
                            g61.i("GmsClientSupervisor");
                        }
                        this.f24a.remove(aVar);
                    }
                }
                return true;
            case 1:
                synchronized (this.f24a) {
                    pp.a aVar2 = (pp.a) message.obj;
                    g61 g612 = this.f24a.get(aVar2);
                    if (g612 != null && g612.c() == 3) {
                        String valueOf = String.valueOf(aVar2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                        sb.append("Timeout waiting for ServiceConnection callback ");
                        sb.append(valueOf);
                        Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                        ComponentName b2 = g612.b();
                        if (b2 == null) {
                            b2 = aVar2.a();
                        }
                        if (b2 == null) {
                            b2 = new ComponentName(aVar2.b(), EnvironmentCompat.MEDIA_UNKNOWN);
                        }
                        g612.onServiceDisconnected(b2);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
