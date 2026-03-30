package com.google.firebase.firestore.remote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.firebase.firestore.remote.ConnectivityMonitor;
import com.google.firebase.firestore.remote.h;
import com.google.firebase.firestore.util.Consumer;
import java.util.ArrayList;
import java.util.List;

public final class g implements h {
    /* access modifiers changed from: private */
    public final Context a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ConnectivityManager f2327a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f2328a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final List<hc<h.a>> f2329a = new ArrayList();

    public g(Context context) {
        n4.d(context != null, "Context must be non-null", new Object[0]);
        this.a = context;
        this.f2327a = (ConnectivityManager) context.getSystemService("connectivity");
        e();
    }

    public void a(hc<h.a> callback) {
        synchronized (this.f2329a) {
            this.f2329a.add(callback);
        }
    }

    private void e() {
        if (Build.VERSION.SDK_INT < 24 || this.f2327a == null) {
            d networkReceiver = new d(this, (a) null);
            this.a.registerReceiver(networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f2328a = new b(networkReceiver);
            return;
        }
        c defaultNetworkCallback = new c(this, (a) null);
        this.f2327a.registerDefaultNetworkCallback(defaultNetworkCallback);
        this.f2328a = new a(defaultNetworkCallback);
    }

    class a implements Runnable {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        public void run() {
            g.this.f2327a.unregisterNetworkCallback(this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ d a;

        b(d dVar) {
            this.a = dVar;
        }

        public void run() {
            g.this.a.unregisterReceiver(this.a);
        }
    }

    private class c extends ConnectivityManager.NetworkCallback {
        private c() {
        }

        /* synthetic */ c(g x0, a x1) {
            this();
        }

        public void onAvailable(Network network) {
            synchronized (g.this.f2329a) {
                for (Consumer<ConnectivityMonitor.NetworkStatus> callback : g.this.f2329a) {
                    callback.accept(h.a.REACHABLE);
                }
            }
        }

        public void onLost(Network network) {
            synchronized (g.this.f2329a) {
                for (Consumer<ConnectivityMonitor.NetworkStatus> callback : g.this.f2329a) {
                    callback.accept(h.a.UNREACHABLE);
                }
            }
        }
    }

    private class d extends BroadcastReceiver {

        /* renamed from: a  reason: collision with other field name */
        private boolean f2332a;

        private d() {
            this.f2332a = false;
        }

        /* synthetic */ d(g x0, a x1) {
            this();
        }

        public void onReceive(Context context, Intent intent) {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean wasConnected = this.f2332a;
            boolean z = networkInfo != null && networkInfo.isConnected();
            this.f2332a = z;
            if (z && !wasConnected) {
                synchronized (g.this.f2329a) {
                    for (Consumer<ConnectivityMonitor.NetworkStatus> callback : g.this.f2329a) {
                        callback.accept(h.a.REACHABLE);
                    }
                }
            } else if (!z && wasConnected) {
                synchronized (g.this.f2329a) {
                    for (Consumer<ConnectivityMonitor.NetworkStatus> callback2 : g.this.f2329a) {
                        callback2.accept(h.a.UNREACHABLE);
                    }
                }
            }
        }
    }
}
