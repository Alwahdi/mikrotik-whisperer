package defpackage;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import defpackage.gr;
import defpackage.pp;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: z5  reason: default package */
public abstract class z5<T extends IInterface> {
    public static final String[] a = {"service_esmobile", "service_googleme"};

    /* renamed from: a  reason: collision with other field name */
    private static final nk[] f5974a = new nk[0];

    /* renamed from: a  reason: collision with other field name */
    private int f5975a;

    /* renamed from: a  reason: collision with other field name */
    private long f5976a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f5977a;

    /* renamed from: a  reason: collision with other field name */
    final Handler f5978a;

    /* renamed from: a  reason: collision with other field name */
    private T f5979a;

    /* renamed from: a  reason: collision with other field name */
    private final Looper f5980a;

    /* renamed from: a  reason: collision with other field name */
    private volatile c11 f5981a = null;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public dc f5982a = null;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ir f5983a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f5984a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final String f5985a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<h<?>> f5986a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    protected AtomicInteger f5987a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    private p71 f5988a;

    /* renamed from: a  reason: collision with other field name */
    private final pp f5989a;

    /* renamed from: a  reason: collision with other field name */
    private final up f5990a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final a f5991a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final b f5992a;

    /* renamed from: a  reason: collision with other field name */
    protected c f5993a;

    /* renamed from: a  reason: collision with other field name */
    private j f5994a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f5995a = false;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private long f5996b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final Object f5997b = new Object();
    private int c = 1;

    /* renamed from: c  reason: collision with other field name */
    private long f5998c;
    private final int d;

    /* renamed from: z5$a */
    public interface a {
        void a(int i);

        void b(Bundle bundle);
    }

    /* renamed from: z5$b */
    public interface b {
        void c(dc dcVar);
    }

    /* renamed from: z5$c */
    public interface c {
        void c(dc dcVar);
    }

    /* renamed from: z5$d */
    protected class d implements c {
        public d() {
        }

        public void c(dc dcVar) {
            if (dcVar.t()) {
                z5 z5Var = z5.this;
                z5Var.a((cr) null, z5Var.y());
            } else if (z5.this.f5992a != null) {
                z5.this.f5992a.c(dcVar);
            }
        }
    }

    /* renamed from: z5$e */
    public interface e {
        void a();
    }

    /* access modifiers changed from: protected */
    public abstract String A();

    /* access modifiers changed from: protected */
    public abstract String B();

    /* access modifiers changed from: protected */
    public abstract T q(IBinder iBinder);

    public abstract Account s();

    /* access modifiers changed from: protected */
    public abstract Set<Scope> y();

    /* renamed from: z5$g */
    final class g extends b51 {
        public g(Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.app.PendingIntent} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r8) {
            /*
                r7 = this;
                z5 r0 = defpackage.z5.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.f5987a
                int r0 = r0.get()
                int r1 = r8.arg1
                if (r0 == r1) goto L_0x0016
                boolean r0 = b(r8)
                if (r0 == 0) goto L_0x0015
                a(r8)
            L_0x0015:
                return
            L_0x0016:
                int r0 = r8.what
                r1 = 4
                r2 = 1
                r3 = 5
                if (r0 == r2) goto L_0x002e
                r4 = 7
                if (r0 == r4) goto L_0x002e
                if (r0 != r1) goto L_0x002a
                z5 r0 = defpackage.z5.this
                boolean r0 = r0.r()
                if (r0 == 0) goto L_0x002e
            L_0x002a:
                int r0 = r8.what
                if (r0 != r3) goto L_0x003a
            L_0x002e:
                z5 r0 = defpackage.z5.this
                boolean r0 = r0.e()
                if (r0 != 0) goto L_0x003a
                a(r8)
                return
            L_0x003a:
                int r0 = r8.what
                r4 = 8
                r5 = 3
                r6 = 0
                if (r0 != r1) goto L_0x0085
                z5 r0 = defpackage.z5.this
                dc r1 = new dc
                int r8 = r8.arg2
                r1.<init>(r8)
                defpackage.dc unused = r0.f5982a = r1
                z5 r8 = defpackage.z5.this
                boolean r8 = r8.e0()
                if (r8 == 0) goto L_0x0064
                z5 r8 = defpackage.z5.this
                boolean r8 = r8.f5995a
                if (r8 != 0) goto L_0x0064
                z5 r8 = defpackage.z5.this
                r8.O(r5, null)
                return
            L_0x0064:
                z5 r8 = defpackage.z5.this
                dc r8 = r8.f5982a
                if (r8 == 0) goto L_0x0073
                z5 r8 = defpackage.z5.this
                dc r8 = r8.f5982a
                goto L_0x0078
            L_0x0073:
                dc r8 = new dc
                r8.<init>(r4)
            L_0x0078:
                z5 r0 = defpackage.z5.this
                z5$c r0 = r0.f5993a
                r0.c(r8)
                z5 r0 = defpackage.z5.this
                r0.E(r8)
                return
            L_0x0085:
                if (r0 != r3) goto L_0x00a8
                z5 r8 = defpackage.z5.this
                dc r8 = r8.f5982a
                if (r8 == 0) goto L_0x0096
                z5 r8 = defpackage.z5.this
                dc r8 = r8.f5982a
                goto L_0x009b
            L_0x0096:
                dc r8 = new dc
                r8.<init>(r4)
            L_0x009b:
                z5 r0 = defpackage.z5.this
                z5$c r0 = r0.f5993a
                r0.c(r8)
                z5 r0 = defpackage.z5.this
                r0.E(r8)
                return
            L_0x00a8:
                if (r0 != r5) goto L_0x00c7
                java.lang.Object r0 = r8.obj
                boolean r1 = r0 instanceof android.app.PendingIntent
                if (r1 == 0) goto L_0x00b3
                r6 = r0
                android.app.PendingIntent r6 = (android.app.PendingIntent) r6
            L_0x00b3:
                dc r0 = new dc
                int r8 = r8.arg2
                r0.<init>(r8, r6)
                z5 r8 = defpackage.z5.this
                z5$c r8 = r8.f5993a
                r8.c(r0)
                z5 r8 = defpackage.z5.this
                r8.E(r0)
                return
            L_0x00c7:
                r1 = 6
                if (r0 != r1) goto L_0x00ef
                z5 r0 = defpackage.z5.this
                r0.O(r3, null)
                z5 r0 = defpackage.z5.this
                z5$a r0 = r0.f5991a
                if (r0 == 0) goto L_0x00e2
                z5 r0 = defpackage.z5.this
                z5$a r0 = r0.f5991a
                int r1 = r8.arg2
                r0.a(r1)
            L_0x00e2:
                z5 r0 = defpackage.z5.this
                int r8 = r8.arg2
                r0.F(r8)
                z5 r8 = defpackage.z5.this
                boolean unused = r8.T(r3, r2, r6)
                return
            L_0x00ef:
                r1 = 2
                if (r0 != r1) goto L_0x00fe
                z5 r0 = defpackage.z5.this
                boolean r0 = r0.l()
                if (r0 != 0) goto L_0x00fe
                a(r8)
                return
            L_0x00fe:
                boolean r0 = b(r8)
                if (r0 == 0) goto L_0x010c
                java.lang.Object r8 = r8.obj
                z5$h r8 = (defpackage.z5.h) r8
                r8.e()
                return
            L_0x010c:
                int r8 = r8.what
                r0 = 45
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                java.lang.String r0 = "Don't know how to handle message: "
                r1.append(r0)
                r1.append(r8)
                java.lang.String r8 = r1.toString()
                java.lang.Exception r0 = new java.lang.Exception
                r0.<init>()
                java.lang.String r1 = "GmsClient"
                android.util.Log.wtf(r1, r8, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.z5.g.handleMessage(android.os.Message):void");
        }

        private static void a(Message message) {
            h hVar = (h) message.obj;
            hVar.d();
            hVar.b();
        }

        private static boolean b(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }
    }

    /* renamed from: z5$j */
    public final class j implements ServiceConnection {
        private final int a;

        public j(int i) {
            this.a = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ir irVar;
            if (iBinder == null) {
                z5.this.V(16);
                return;
            }
            synchronized (z5.this.f5997b) {
                z5 z5Var = z5.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof ir)) {
                    irVar = new hr(iBinder);
                } else {
                    irVar = (ir) queryLocalInterface;
                }
                ir unused = z5Var.f5983a = irVar;
            }
            z5.this.N(0, (Bundle) null, this.a);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (z5.this.f5997b) {
                ir unused = z5.this.f5983a = null;
            }
            Handler handler = z5.this.f5978a;
            handler.sendMessage(handler.obtainMessage(6, this.a, 1));
        }
    }

    /* renamed from: z5$l */
    protected final class l extends f {
        public l(int i, Bundle bundle) {
            super(i, (Bundle) null);
        }

        /* access modifiers changed from: protected */
        public final void f(dc dcVar) {
            if (!z5.this.r() || !z5.this.e0()) {
                z5.this.f5993a.c(dcVar);
                z5.this.E(dcVar);
                return;
            }
            z5.this.V(16);
        }

        /* access modifiers changed from: protected */
        public final boolean g() {
            z5.this.f5993a.c(dc.a);
            return true;
        }
    }

    /* renamed from: z5$h */
    protected abstract class h<TListener> {
        private TListener a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f6001a = false;

        public h(TListener tlistener) {
            this.a = tlistener;
        }

        /* access modifiers changed from: protected */
        public abstract void c(TListener tlistener);

        /* access modifiers changed from: protected */
        public abstract void d();

        public final void e() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.a;
                if (this.f6001a) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    c(tlistener);
                } catch (RuntimeException e) {
                    d();
                    throw e;
                }
            } else {
                d();
            }
            synchronized (this) {
                this.f6001a = true;
            }
            b();
        }

        public final void b() {
            a();
            synchronized (z5.this.f5986a) {
                z5.this.f5986a.remove(this);
            }
        }

        public final void a() {
            synchronized (this) {
                this.a = null;
            }
        }
    }

    /* renamed from: z5$i */
    public static final class i extends gr.a {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private z5 f6002a;

        public i(z5 z5Var, int i) {
            this.f6002a = z5Var;
            this.a = i;
        }

        public final void D(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public final void F(int i, IBinder iBinder, Bundle bundle) {
            y90.k(this.f6002a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f6002a.G(i, iBinder, bundle, this.a);
            this.f6002a = null;
        }

        public final void P(int i, IBinder iBinder, c11 c11) {
            y90.k(this.f6002a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            y90.j(c11);
            this.f6002a.S(c11);
            F(i, iBinder, c11.a);
        }
    }

    /* renamed from: z5$k */
    protected final class k extends f {
        private final IBinder a;

        public k(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.a = iBinder;
        }

        /* access modifiers changed from: protected */
        public final void f(dc dcVar) {
            if (z5.this.f5992a != null) {
                z5.this.f5992a.c(dcVar);
            }
            z5.this.E(dcVar);
        }

        /* access modifiers changed from: protected */
        public final boolean g() {
            try {
                String interfaceDescriptor = this.a.getInterfaceDescriptor();
                if (!z5.this.A().equals(interfaceDescriptor)) {
                    String A = z5.this.A();
                    StringBuilder sb = new StringBuilder(String.valueOf(A).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(A);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface q = z5.this.q(this.a);
                if (q == null || (!z5.this.T(2, 4, q) && !z5.this.T(3, 4, q))) {
                    return false;
                }
                dc unused = z5.this.f5982a = null;
                Bundle u = z5.this.u();
                if (z5.this.f5991a == null) {
                    return true;
                }
                z5.this.f5991a.b(u);
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* renamed from: z5$f */
    private abstract class f extends h<Boolean> {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private final Bundle f5999a;

        protected f(int i, Bundle bundle) {
            super(true);
            this.a = i;
            this.f5999a = bundle;
        }

        /* access modifiers changed from: protected */
        public abstract void f(dc dcVar);

        /* access modifiers changed from: protected */
        public abstract boolean g();

        /* access modifiers changed from: protected */
        public final void d() {
        }

        /* JADX WARNING: type inference failed for: r5v11, types: [android.os.Parcelable] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void c(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                r0 = 1
                r1 = 0
                if (r5 != 0) goto L_0x000c
                z5 r5 = defpackage.z5.this
                r5.O(r0, null)
                return
            L_0x000c:
                int r5 = r4.a
                switch(r5) {
                    case 0: goto L_0x0055;
                    case 10: goto L_0x0025;
                    default: goto L_0x0011;
                }
            L_0x0011:
                z5 r5 = defpackage.z5.this
                r5.O(r0, null)
                android.os.Bundle r5 = r4.f5999a
                if (r5 == 0) goto L_0x006b
                java.lang.String r0 = "pendingIntent"
                android.os.Parcelable r5 = r5.getParcelable(r0)
                r1 = r5
                android.app.PendingIntent r1 = (android.app.PendingIntent) r1
                goto L_0x006b
            L_0x0025:
                z5 r5 = defpackage.z5.this
                r5.O(r0, null)
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                java.lang.Class r3 = r4.getClass()
                java.lang.String r3 = r3.getSimpleName()
                r1[r2] = r3
                z5 r2 = defpackage.z5.this
                java.lang.String r2 = r2.B()
                r1[r0] = r2
                r0 = 2
                z5 r2 = defpackage.z5.this
                java.lang.String r2 = r2.A()
                r1[r0] = r2
                java.lang.String r0 = "A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. "
                java.lang.String r0 = java.lang.String.format(r0, r1)
                r5.<init>(r0)
                throw r5
            L_0x0055:
                boolean r5 = r4.g()
                if (r5 != 0) goto L_0x0075
                z5 r5 = defpackage.z5.this
                r5.O(r0, null)
                dc r5 = new dc
                r0 = 8
                r5.<init>(r0, r1)
                r4.f(r5)
                return
            L_0x006b:
                dc r5 = new dc
                int r0 = r4.a
                r5.<init>(r0, r1)
                r4.f(r5)
            L_0x0075:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.z5.f.c(java.lang.Object):void");
        }
    }

    protected z5(Context context, Looper looper, pp ppVar, up upVar, int i2, a aVar, b bVar, String str) {
        this.f5977a = (Context) y90.k(context, "Context must not be null");
        this.f5980a = (Looper) y90.k(looper, "Looper must not be null");
        this.f5989a = (pp) y90.k(ppVar, "Supervisor must not be null");
        this.f5990a = (up) y90.k(upVar, "API availability must not be null");
        this.f5978a = new g(looper);
        this.d = i2;
        this.f5991a = aVar;
        this.f5992a = bVar;
        this.f5985a = str;
    }

    /* access modifiers changed from: protected */
    public String C() {
        return "com.google.android.gms";
    }

    private final String c0() {
        String str = this.f5985a;
        return str == null ? this.f5977a.getClass().getName() : str;
    }

    /* access modifiers changed from: protected */
    public String x() {
        return null;
    }

    /* access modifiers changed from: private */
    public final void S(c11 c11) {
        this.f5981a = c11;
    }

    public final nk[] k() {
        c11 c11 = this.f5981a;
        if (c11 == null) {
            return null;
        }
        return c11.f281a;
    }

    /* access modifiers changed from: protected */
    public void D(T t) {
        this.f5996b = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void F(int i2) {
        this.f5975a = i2;
        this.f5976a = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void E(dc dcVar) {
        this.b = dcVar.m();
        this.f5998c = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public final void O(int i2, T t) {
        p71 p71;
        p71 p712;
        y90.a((i2 == 4) == (t != null));
        synchronized (this.f5984a) {
            this.c = i2;
            this.f5979a = t;
            H(i2, t);
            switch (i2) {
                case 1:
                    if (this.f5994a != null) {
                        this.f5989a.b(this.f5988a.c(), this.f5988a.a(), this.f5988a.b(), this.f5994a, c0());
                        this.f5994a = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    if (!(this.f5994a == null || (p712 = this.f5988a) == null)) {
                        String c2 = p712.c();
                        String a2 = this.f5988a.a();
                        StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 70 + String.valueOf(a2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(c2);
                        sb.append(" on ");
                        sb.append(a2);
                        Log.e("GmsClient", sb.toString());
                        this.f5989a.b(this.f5988a.c(), this.f5988a.a(), this.f5988a.b(), this.f5994a, c0());
                        this.f5987a.incrementAndGet();
                    }
                    this.f5994a = new j(this.f5987a.get());
                    if (this.c != 3 || x() == null) {
                        p71 = new p71(C(), B(), false, 129);
                    } else {
                        p71 = new p71(v().getPackageName(), x(), true, 129);
                    }
                    this.f5988a = p71;
                    if (!this.f5989a.c(new pp.a(p71.c(), this.f5988a.a(), this.f5988a.b()), this.f5994a, c0())) {
                        String c3 = this.f5988a.c();
                        String a3 = this.f5988a.a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(c3).length() + 34 + String.valueOf(a3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(c3);
                        sb2.append(" on ");
                        sb2.append(a3);
                        Log.e("GmsClient", sb2.toString());
                        N(16, (Bundle) null, this.f5987a.get());
                    }
                    break;
                case 4:
                    D(t);
                    break;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void H(int i2, T t) {
    }

    /* access modifiers changed from: private */
    public final boolean T(int i2, int i3, T t) {
        synchronized (this.f5984a) {
            if (this.c != i2) {
                return false;
            }
            O(i3, t);
            return true;
        }
    }

    public void f(c cVar) {
        this.f5993a = (c) y90.k(cVar, "Connection progress callbacks cannot be null.");
        O(2, (IInterface) null);
    }

    public boolean l() {
        boolean z;
        synchronized (this.f5984a) {
            z = this.c == 4;
        }
        return z;
    }

    public boolean e() {
        boolean z;
        synchronized (this.f5984a) {
            int i2 = this.c;
            if (i2 != 2) {
                if (i2 != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private final boolean d0() {
        boolean z;
        synchronized (this.f5984a) {
            z = this.c == 3;
        }
        return z;
    }

    public void m() {
        this.f5987a.incrementAndGet();
        synchronized (this.f5986a) {
            int size = this.f5986a.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f5986a.get(i2).a();
            }
            this.f5986a.clear();
        }
        synchronized (this.f5997b) {
            this.f5983a = null;
        }
        O(1, (IInterface) null);
    }

    public void J(int i2) {
        Handler handler = this.f5978a;
        handler.sendMessage(handler.obtainMessage(6, this.f5987a.get(), i2));
    }

    /* access modifiers changed from: private */
    public final void V(int i2) {
        int i3;
        if (d0()) {
            i3 = 5;
            this.f5995a = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.f5978a;
        handler.sendMessage(handler.obtainMessage(i3, this.f5987a.get(), 16));
    }

    public final Context v() {
        return this.f5977a;
    }

    public nk[] t() {
        return f5974a;
    }

    /* access modifiers changed from: protected */
    public Bundle w() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    public void G(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.f5978a;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    public final void N(int i2, Bundle bundle, int i3) {
        Handler handler = this.f5978a;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2, (Bundle) null)));
    }

    /* access modifiers changed from: protected */
    public final void p() {
        if (!l()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle u() {
        return null;
    }

    public final T z() {
        T t;
        synchronized (this.f5984a) {
            if (this.c != 5) {
                p();
                y90.m(this.f5979a != null, "Client is connected but service is null");
                t = this.f5979a;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    public void a(cr crVar, Set<Scope> set) {
        Bundle w = w();
        gp gpVar = new gp(this.d);
        gpVar.f3119a = this.f5977a.getPackageName();
        gpVar.f3117a = w;
        if (set != null) {
            gpVar.f3121a = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (h()) {
            gpVar.f3116a = s() != null ? s() : new Account("<<default account>>", "com.google");
            if (crVar != null) {
                gpVar.f3118a = crVar.asBinder();
            }
        } else if (I()) {
            gpVar.f3116a = s();
        }
        gpVar.f3122a = f5974a;
        gpVar.f3123b = t();
        try {
            synchronized (this.f5997b) {
                ir irVar = this.f5983a;
                if (irVar != null) {
                    irVar.j(new i(this, this.f5987a.get()), gpVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            J(1);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException | RuntimeException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            G(8, (IBinder) null, (Bundle) null, this.f5987a.get());
        }
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public void o(e eVar) {
        eVar.a();
    }

    public boolean I() {
        return false;
    }

    public boolean d() {
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean e0() {
        if (this.f5995a || TextUtils.isEmpty(A()) || TextUtils.isEmpty(x())) {
            return false;
        }
        try {
            Class.forName(A());
            return true;
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    public String g() {
        p71 p71;
        if (l() && (p71 = this.f5988a) != null) {
            return p71.a();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }
}
