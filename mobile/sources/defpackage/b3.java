package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import io.grpc.m;
import io.grpc.okhttp.e;

/* renamed from: b3  reason: default package */
public final class b3 extends nn<b3> {
    private static final Class<?> a = j();

    /* renamed from: a  reason: collision with other field name */
    private Context f147a;

    /* renamed from: a  reason: collision with other field name */
    private final sz<?> f148a;

    private static final Class<?> j() {
        Class<e> cls = e.class;
        try {
            int i = e.g;
            return cls;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static b3 k(sz<?> builder) {
        return new b3(builder);
    }

    private b3(sz<?> delegateBuilder) {
        this.f148a = (sz) v90.o(delegateBuilder, "delegateBuilder");
    }

    public b3 i(Context context) {
        this.f147a = context;
        return this;
    }

    /* access modifiers changed from: protected */
    public sz<?> e() {
        return this.f148a;
    }

    public rz a() {
        return new b(this.f148a.a(), this.f147a);
    }

    /* renamed from: b3$b */
    static final class b extends rz {
        /* access modifiers changed from: private */
        public final Context a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final ConnectivityManager f149a;

        /* renamed from: a  reason: collision with other field name */
        private final Object f150a = new Object();

        /* renamed from: a  reason: collision with other field name */
        private Runnable f151a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final rz f152a;

        b(rz delegate, Context context) {
            this.f152a = delegate;
            this.a = context;
            if (context != null) {
                this.f149a = (ConnectivityManager) context.getSystemService("connectivity");
                try {
                    q();
                } catch (SecurityException e) {
                    Log.w("AndroidChannelBuilder", "Failed to configure network monitoring. Does app have ACCESS_NETWORK_STATE permission?", e);
                }
            } else {
                this.f149a = null;
            }
        }

        private void q() {
            if (Build.VERSION.SDK_INT < 24 || this.f149a == null) {
                d networkReceiver = new d();
                this.a.registerReceiver(networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f151a = new C0003b(networkReceiver);
                return;
            }
            c defaultNetworkCallback = new c();
            this.f149a.registerDefaultNetworkCallback(defaultNetworkCallback);
            this.f151a = new a(defaultNetworkCallback);
        }

        /* renamed from: b3$b$a */
        class a implements Runnable {
            final /* synthetic */ c a;

            a(c cVar) {
                this.a = cVar;
            }

            public void run() {
                b.this.f149a.unregisterNetworkCallback(this.a);
            }
        }

        /* renamed from: b3$b$b  reason: collision with other inner class name */
        class C0003b implements Runnable {
            final /* synthetic */ d a;

            C0003b(d dVar) {
                this.a = dVar;
            }

            public void run() {
                b.this.a.unregisterReceiver(this.a);
            }
        }

        private void r() {
            synchronized (this.f150a) {
                Runnable runnable = this.f151a;
                if (runnable != null) {
                    runnable.run();
                    this.f151a = null;
                }
            }
        }

        public rz m() {
            r();
            return this.f152a.m();
        }

        public <RequestT, ResponseT> io.grpc.b<RequestT, ResponseT> h(m<RequestT, ResponseT> methodDescriptor, n7 callOptions) {
            return this.f152a.h(methodDescriptor, callOptions);
        }

        public String a() {
            return this.f152a.a();
        }

        public io.grpc.e j(boolean requestConnection) {
            return this.f152a.j(requestConnection);
        }

        public void k(io.grpc.e source, Runnable callback) {
            this.f152a.k(source, callback);
        }

        public void l() {
            this.f152a.l();
        }

        public void i() {
            this.f152a.i();
        }

        /* renamed from: b3$b$c */
        private class c extends ConnectivityManager.NetworkCallback {

            /* renamed from: a  reason: collision with other field name */
            private boolean f155a;

            private c() {
                this.f155a = false;
            }

            public void onAvailable(Network network) {
                if (this.f155a) {
                    b.this.f152a.i();
                } else {
                    b.this.f152a.l();
                }
                this.f155a = true;
            }

            public void onLost(Network network) {
                this.f155a = false;
            }
        }

        /* renamed from: b3$b$d */
        private class d extends BroadcastReceiver {

            /* renamed from: a  reason: collision with other field name */
            private boolean f156a;

            private d() {
                this.f156a = false;
            }

            public void onReceive(Context context, Intent intent) {
                NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean wasConnected = this.f156a;
                boolean z = networkInfo != null && networkInfo.isConnected();
                this.f156a = z;
                if (z && !wasConnected) {
                    b.this.f152a.l();
                }
            }
        }
    }
}
