package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import defpackage.i3;
import defpackage.vp;
import defpackage.z5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: wp  reason: default package */
public class wp implements Handler.Callback {
    public static final Status a = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final Object f5496a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static wp f5497a;
    /* access modifiers changed from: private */
    public static final Status b = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public long f5498a = 5000;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Context f5499a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Handler f5500a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Map<o3<?>, a<?>> f5501a = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: a  reason: collision with other field name */
    private final Set<o3<?>> f5502a = new ArraySet();

    /* renamed from: a  reason: collision with other field name */
    private final AtomicInteger f5503a = new AtomicInteger(1);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public pw0 f5504a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final sp f5505a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final tp f5506a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public long f5507b = 120000;

    /* renamed from: b  reason: collision with other field name */
    private final Set<o3<?>> f5508b = new ArraySet();

    /* renamed from: b  reason: collision with other field name */
    private final AtomicInteger f5509b = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public long c = 10000;

    public static wp e(Context context) {
        wp wpVar;
        synchronized (f5496a) {
            if (f5497a == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f5497a = new wp(context.getApplicationContext(), handlerThread.getLooper(), sp.m());
            }
            wpVar = f5497a;
        }
        return wpVar;
    }

    /* renamed from: wp$c */
    private static class c {
        /* access modifiers changed from: private */
        public final nk a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final o3<?> f5527a;

        private c(o3<?> o3Var, nk nkVar) {
            this.f5527a = o3Var;
            this.a = nkVar;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!e40.a(this.f5527a, cVar.f5527a) || !e40.a(this.a, cVar.a)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return e40.b(this.f5527a, this.a);
        }

        public final String toString() {
            return e40.c(this).a("key", this.f5527a).a("feature", this.a).toString();
        }

        /* synthetic */ c(o3 o3Var, nk nkVar, xw0 xw0) {
            this(o3Var, nkVar);
        }
    }

    /* renamed from: wp$b */
    private class b implements lx0, z5.c {
        private cr a = null;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final i3.f f5522a;

        /* renamed from: a  reason: collision with other field name */
        private Set<Scope> f5523a = null;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final o3<?> f5524a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public boolean f5526a = false;

        public b(i3.f fVar, o3<?> o3Var) {
            this.f5522a = fVar;
            this.f5524a = o3Var;
        }

        public final void c(dc dcVar) {
            wp.this.f5500a.post(new dx0(this, dcVar));
        }

        public final void b(dc dcVar) {
            ((a) wp.this.f5501a.get(this.f5524a)).F(dcVar);
        }

        public final void a(cr crVar, Set<Scope> set) {
            if (crVar == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                b(new dc(4));
                return;
            }
            this.a = crVar;
            this.f5523a = set;
            g();
        }

        /* access modifiers changed from: private */
        public final void g() {
            cr crVar;
            if (this.f5526a && (crVar = this.a) != null) {
                this.f5522a.a(crVar, this.f5523a);
            }
        }
    }

    /* renamed from: wp$a */
    public class a<O extends i3.d> implements vp.a, vp.b {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private dc f5510a = null;

        /* renamed from: a  reason: collision with other field name */
        private final i3.b f5511a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final i3.f f5512a;

        /* renamed from: a  reason: collision with other field name */
        private final List<c> f5513a = new ArrayList();

        /* renamed from: a  reason: collision with other field name */
        private final Map<qx<?>, Object> f5514a = new HashMap();

        /* renamed from: a  reason: collision with other field name */
        private final Queue<ix0> f5515a = new LinkedList();

        /* renamed from: a  reason: collision with other field name */
        private final Set<fy0> f5516a = new HashSet();

        /* renamed from: a  reason: collision with other field name */
        private final kx0 f5517a;

        /* renamed from: a  reason: collision with other field name */
        private final my0 f5518a;

        /* renamed from: a  reason: collision with other field name */
        private final o3<O> f5519a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f5521a;

        public a(rp<O> rpVar) {
            i3.f g = rpVar.g(wp.this.f5500a.getLooper(), this);
            this.f5512a = g;
            this.f5511a = g;
            this.f5519a = rpVar.d();
            this.f5518a = new my0();
            this.a = rpVar.f();
            if (g.h()) {
                this.f5517a = rpVar.i(wp.this.f5499a, wp.this.f5500a);
            } else {
                this.f5517a = null;
            }
        }

        public final void b(Bundle bundle) {
            if (Looper.myLooper() == wp.this.f5500a.getLooper()) {
                q();
            } else {
                wp.this.f5500a.post(new yw0(this));
            }
        }

        /* access modifiers changed from: private */
        public final void q() {
            v();
            H(dc.a);
            w();
            Iterator<Object> it = this.f5514a.values().iterator();
            if (!it.hasNext()) {
                s();
                x();
                return;
            }
            b6.a(it.next());
            throw null;
        }

        public final void a(int i) {
            if (Looper.myLooper() == wp.this.f5500a.getLooper()) {
                r();
            } else {
                wp.this.f5500a.post(new zw0(this));
            }
        }

        /* access modifiers changed from: private */
        public final void r() {
            v();
            this.f5521a = true;
            this.f5518a.e();
            wp.this.f5500a.sendMessageDelayed(Message.obtain(wp.this.f5500a, 9, this.f5519a), wp.this.f5498a);
            wp.this.f5500a.sendMessageDelayed(Message.obtain(wp.this.f5500a, 11, this.f5519a), wp.this.f5507b);
            wp.this.f5506a.a();
        }

        public final void F(dc dcVar) {
            y90.d(wp.this.f5500a);
            this.f5512a.m();
            c(dcVar);
        }

        private final boolean G(dc dcVar) {
            synchronized (wp.f5496a) {
                pw0 unused = wp.this.f5504a;
            }
            return false;
        }

        public final void c(dc dcVar) {
            y90.d(wp.this.f5500a);
            kx0 kx0 = this.f5517a;
            if (kx0 != null) {
                kx0.l0();
            }
            v();
            wp.this.f5506a.a();
            H(dcVar);
            if (dcVar.m() == 4) {
                z(wp.b);
            } else if (this.f5515a.isEmpty()) {
                this.f5510a = dcVar;
            } else if (!G(dcVar) && !wp.this.l(dcVar, this.a)) {
                if (dcVar.m() == 18) {
                    this.f5521a = true;
                }
                if (this.f5521a) {
                    wp.this.f5500a.sendMessageDelayed(Message.obtain(wp.this.f5500a, 9, this.f5519a), wp.this.f5498a);
                    return;
                }
                String a2 = this.f5519a.a();
                String valueOf = String.valueOf(dcVar);
                StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 63 + String.valueOf(valueOf).length());
                sb.append("API: ");
                sb.append(a2);
                sb.append(" is not available on this device. Connection failed with: ");
                sb.append(valueOf);
                z(new Status(17, sb.toString()));
            }
        }

        private final void s() {
            ArrayList arrayList = new ArrayList(this.f5515a);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ix0 ix0 = (ix0) obj;
                if (!this.f5512a.l()) {
                    return;
                }
                if (p(ix0)) {
                    this.f5515a.remove(ix0);
                }
            }
        }

        public final void k(ix0 ix0) {
            y90.d(wp.this.f5500a);
            if (!this.f5512a.l()) {
                this.f5515a.add(ix0);
                dc dcVar = this.f5510a;
                if (dcVar == null || !dcVar.s()) {
                    d();
                } else {
                    c(this.f5510a);
                }
            } else if (p(ix0)) {
                x();
            } else {
                this.f5515a.add(ix0);
            }
        }

        public final void t() {
            y90.d(wp.this.f5500a);
            z(wp.a);
            this.f5518a.d();
            for (qx cy0 : (qx[]) this.f5514a.keySet().toArray(new qx[this.f5514a.size()])) {
                k(new cy0(cy0, new gq0()));
            }
            H(new dc(4));
            if (this.f5512a.l()) {
                this.f5512a.o(new bx0(this));
            }
        }

        public final i3.f l() {
            return this.f5512a;
        }

        public final Map<qx<?>, Object> u() {
            return this.f5514a;
        }

        public final void v() {
            y90.d(wp.this.f5500a);
            this.f5510a = null;
        }

        private final boolean p(ix0 ix0) {
            if (!(ix0 instanceof sw0)) {
                A(ix0);
                return true;
            }
            sw0 sw0 = (sw0) ix0;
            nk h = h(sw0.g(this));
            if (h == null) {
                A(ix0);
                return true;
            } else if (sw0.h(this)) {
                c cVar = new c(this.f5519a, h, (xw0) null);
                int indexOf = this.f5513a.indexOf(cVar);
                if (indexOf >= 0) {
                    c cVar2 = this.f5513a.get(indexOf);
                    wp.this.f5500a.removeMessages(15, cVar2);
                    wp.this.f5500a.sendMessageDelayed(Message.obtain(wp.this.f5500a, 15, cVar2), wp.this.f5498a);
                    return false;
                }
                this.f5513a.add(cVar);
                wp.this.f5500a.sendMessageDelayed(Message.obtain(wp.this.f5500a, 15, cVar), wp.this.f5498a);
                wp.this.f5500a.sendMessageDelayed(Message.obtain(wp.this.f5500a, 16, cVar), wp.this.f5507b);
                dc dcVar = new dc(2, (PendingIntent) null);
                if (G(dcVar)) {
                    return false;
                }
                wp.this.l(dcVar, this.a);
                return false;
            } else {
                sw0.c(new ot0(h));
                return false;
            }
        }

        private final void A(ix0 ix0) {
            ix0.d(this.f5518a, f());
            try {
                ix0.f(this);
            } catch (DeadObjectException e) {
                a(1);
                this.f5512a.m();
            }
        }

        public final void z(Status status) {
            y90.d(wp.this.f5500a);
            for (ix0 b : this.f5515a) {
                b.b(status);
            }
            this.f5515a.clear();
        }

        public final void g() {
            y90.d(wp.this.f5500a);
            if (this.f5521a) {
                d();
            }
        }

        private final void w() {
            if (this.f5521a) {
                wp.this.f5500a.removeMessages(11, this.f5519a);
                wp.this.f5500a.removeMessages(9, this.f5519a);
                this.f5521a = false;
            }
        }

        public final void m() {
            Status status;
            y90.d(wp.this.f5500a);
            if (this.f5521a) {
                w();
                if (wp.this.f5505a.f(wp.this.f5499a) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                z(status);
                this.f5512a.m();
            }
        }

        private final void x() {
            wp.this.f5500a.removeMessages(12, this.f5519a);
            wp.this.f5500a.sendMessageDelayed(wp.this.f5500a.obtainMessage(12, this.f5519a), wp.this.c);
        }

        public final boolean y() {
            return B(true);
        }

        private final boolean B(boolean z) {
            y90.d(wp.this.f5500a);
            if (!this.f5512a.l() || this.f5514a.size() != 0) {
                return false;
            }
            if (this.f5518a.c()) {
                if (z) {
                    x();
                }
                return false;
            }
            this.f5512a.m();
            return true;
        }

        public final void d() {
            y90.d(wp.this.f5500a);
            if (!this.f5512a.l() && !this.f5512a.e()) {
                int b = wp.this.f5506a.b(wp.this.f5499a, this.f5512a);
                if (b != 0) {
                    c(new dc(b, (PendingIntent) null));
                    return;
                }
                b bVar = new b(this.f5512a, this.f5519a);
                if (this.f5512a.h()) {
                    this.f5517a.k0(bVar);
                }
                this.f5512a.f(bVar);
            }
        }

        /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Throwable, fy0] */
        private final void H(dc dcVar) {
            String str;
            Iterator<fy0> it = this.f5516a.iterator();
            if (it.hasNext()) {
                b6.a(it.next());
                ? r1 = 0;
                if (e40.a(dcVar, dc.a)) {
                    str = this.f5512a.g();
                } else {
                    str = r1;
                }
                r1.a(this.f5519a, dcVar, str);
                throw r1;
            }
            this.f5516a.clear();
        }

        public final boolean f() {
            return this.f5512a.h();
        }

        public final int e() {
            return this.a;
        }

        private final nk h(nk[] nkVarArr) {
            if (nkVarArr == null || nkVarArr.length == 0) {
                return null;
            }
            nk[] k = this.f5512a.k();
            if (k == null) {
                k = new nk[0];
            }
            ArrayMap arrayMap = new ArrayMap(k.length);
            for (nk nkVar : k) {
                arrayMap.put(nkVar.m(), Long.valueOf(nkVar.p()));
            }
            for (nk nkVar2 : nkVarArr) {
                if (!arrayMap.containsKey(nkVar2.m()) || ((Long) arrayMap.get(nkVar2.m())).longValue() < nkVar2.p()) {
                    return nkVar2;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final void j(c cVar) {
            if (!this.f5513a.contains(cVar) || this.f5521a) {
                return;
            }
            if (!this.f5512a.l()) {
                d();
            } else {
                s();
            }
        }

        /* access modifiers changed from: private */
        public final void o(c cVar) {
            nk[] g;
            if (this.f5513a.remove(cVar)) {
                wp.this.f5500a.removeMessages(15, cVar);
                wp.this.f5500a.removeMessages(16, cVar);
                nk b = cVar.a;
                ArrayList arrayList = new ArrayList(this.f5515a.size());
                for (ix0 ix0 : this.f5515a) {
                    if ((ix0 instanceof sw0) && (g = ((sw0) ix0).g(this)) != null && f4.a(g, b)) {
                        arrayList.add(ix0);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ix0 ix02 = (ix0) obj;
                    this.f5515a.remove(ix02);
                    ix02.c(new ot0(b));
                }
            }
        }
    }

    private wp(Context context, Looper looper, sp spVar) {
        this.f5499a = context;
        ly0 ly0 = new ly0(looper, this);
        this.f5500a = ly0;
        this.f5505a = spVar;
        this.f5506a = new tp(spVar);
        ly0.sendMessage(ly0.obtainMessage(6));
    }

    public final int h() {
        return this.f5503a.getAndIncrement();
    }

    public final void c(rp<?> rpVar) {
        Handler handler = this.f5500a;
        handler.sendMessage(handler.obtainMessage(7, rpVar));
    }

    private final void g(rp<?> rpVar) {
        o3<?> d = rpVar.d();
        a aVar = this.f5501a.get(d);
        if (aVar == null) {
            aVar = new a(rpVar);
            this.f5501a.put(d, aVar);
        }
        if (aVar.f()) {
            this.f5508b.add(d);
        }
        aVar.d();
    }

    public final void s() {
        Handler handler = this.f5500a;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final <O extends i3.d, ResultT> void d(rp<O> rpVar, int i, fq0<i3.b, ResultT> fq0, gq0<ResultT> gq0, fn0 fn0) {
        yx0 yx0 = new yx0(i, fq0, gq0, fn0);
        Handler handler = this.f5500a;
        handler.sendMessage(handler.obtainMessage(4, new ex0(yx0, this.f5509b.get(), rpVar)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: wp$a} */
    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Throwable, qw0, fy0] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r8) {
        /*
            r7 = this;
            int r0 = r8.what
            r1 = 1
            r2 = 300000(0x493e0, double:1.482197E-318)
            java.lang.String r4 = "GoogleApiManager"
            r5 = 0
            switch(r0) {
                case 1: goto L_0x0220;
                case 2: goto L_0x0217;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01b0;
                case 5: goto L_0x011f;
                case 6: goto L_0x00e9;
                case 7: goto L_0x00e0;
                case 8: goto L_0x01b0;
                case 9: goto L_0x00c7;
                case 10: goto L_0x00a1;
                case 11: goto L_0x0088;
                case 12: goto L_0x006f;
                case 13: goto L_0x01b0;
                case 14: goto L_0x0066;
                case 15: goto L_0x0045;
                case 16: goto L_0x0024;
                default: goto L_0x000c;
            }
        L_0x000c:
            r8 = 31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r8)
            java.lang.String r8 = "Unknown message id: "
            r1.append(r8)
            r1.append(r0)
            java.lang.String r8 = r1.toString()
            android.util.Log.w(r4, r8)
            r8 = 0
            return r8
        L_0x0024:
            java.lang.Object r8 = r8.obj
            wp$c r8 = (defpackage.wp.c) r8
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            o3 r2 = r8.f5527a
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x025b
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            o3 r2 = r8.f5527a
            java.lang.Object r0 = r0.get(r2)
            wp$a r0 = (defpackage.wp.a) r0
            r0.o(r8)
            goto L_0x025b
        L_0x0045:
            java.lang.Object r8 = r8.obj
            wp$c r8 = (defpackage.wp.c) r8
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            o3 r2 = r8.f5527a
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x025b
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            o3 r2 = r8.f5527a
            java.lang.Object r0 = r0.get(r2)
            wp$a r0 = (defpackage.wp.a) r0
            r0.j(r8)
            goto L_0x025b
        L_0x0066:
            java.lang.Object r8 = r8.obj
            defpackage.b6.a(r8)
            r5.a()
            throw r5
        L_0x006f:
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            java.lang.Object r2 = r8.obj
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x025b
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            java.lang.Object r8 = r8.obj
            java.lang.Object r8 = r0.get(r8)
            wp$a r8 = (defpackage.wp.a) r8
            r8.y()
            goto L_0x025b
        L_0x0088:
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            java.lang.Object r2 = r8.obj
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x025b
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            java.lang.Object r8 = r8.obj
            java.lang.Object r8 = r0.get(r8)
            wp$a r8 = (defpackage.wp.a) r8
            r8.m()
            goto L_0x025b
        L_0x00a1:
            java.util.Set<o3<?>> r8 = r7.f5508b
            java.util.Iterator r8 = r8.iterator()
        L_0x00a8:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00c0
            java.lang.Object r0 = r8.next()
            o3 r0 = (defpackage.o3) r0
            java.util.Map<o3<?>, wp$a<?>> r2 = r7.f5501a
            java.lang.Object r0 = r2.remove(r0)
            wp$a r0 = (defpackage.wp.a) r0
            r0.t()
            goto L_0x00a8
        L_0x00c0:
            java.util.Set<o3<?>> r8 = r7.f5508b
            r8.clear()
            goto L_0x025b
        L_0x00c7:
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            java.lang.Object r2 = r8.obj
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x025b
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            java.lang.Object r8 = r8.obj
            java.lang.Object r8 = r0.get(r8)
            wp$a r8 = (defpackage.wp.a) r8
            r8.g()
            goto L_0x025b
        L_0x00e0:
            java.lang.Object r8 = r8.obj
            rp r8 = (defpackage.rp) r8
            r7.g(r8)
            goto L_0x025b
        L_0x00e9:
            boolean r8 = defpackage.n90.a()
            if (r8 == 0) goto L_0x011d
            android.content.Context r8 = r7.f5499a
            android.content.Context r8 = r8.getApplicationContext()
            boolean r8 = r8 instanceof android.app.Application
            if (r8 == 0) goto L_0x011d
            android.content.Context r8 = r7.f5499a
            android.content.Context r8 = r8.getApplicationContext()
            android.app.Application r8 = (android.app.Application) r8
            defpackage.j5.c(r8)
            j5 r8 = defpackage.j5.b()
            xw0 r0 = new xw0
            r0.<init>(r7)
            r8.a(r0)
            j5 r8 = defpackage.j5.b()
            boolean r8 = r8.f(r1)
            if (r8 != 0) goto L_0x011d
            r7.c = r2
        L_0x011d:
            goto L_0x025b
        L_0x011f:
            int r0 = r8.arg1
            java.lang.Object r8 = r8.obj
            dc r8 = (defpackage.dc) r8
            java.util.Map<o3<?>, wp$a<?>> r2 = r7.f5501a
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0130:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0146
            java.lang.Object r3 = r2.next()
            wp$a r3 = (defpackage.wp.a) r3
            int r6 = r3.e()
            if (r6 != r0) goto L_0x0145
            r5 = r3
            goto L_0x0146
        L_0x0145:
            goto L_0x0130
        L_0x0146:
            if (r5 == 0) goto L_0x018e
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status
            r2 = 17
            sp r3 = r7.f5505a
            int r4 = r8.m()
            java.lang.String r3 = r3.d(r4)
            java.lang.String r8 = r8.p()
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            int r4 = r4 + 69
            java.lang.String r6 = java.lang.String.valueOf(r8)
            int r6 = r6.length()
            int r4 = r4 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            java.lang.String r4 = "Error resolution was canceled by the user, original error message: "
            r6.append(r4)
            r6.append(r3)
            java.lang.String r3 = ": "
            r6.append(r3)
            r6.append(r8)
            java.lang.String r8 = r6.toString()
            r0.<init>(r2, r8)
            r5.z(r0)
            goto L_0x025b
        L_0x018e:
            r8 = 76
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            java.lang.String r8 = "Could not find API instance "
            r2.append(r8)
            r2.append(r0)
            java.lang.String r8 = " while trying to fail enqueued calls."
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            java.lang.Exception r0 = new java.lang.Exception
            r0.<init>()
            android.util.Log.wtf(r4, r8, r0)
            goto L_0x025b
        L_0x01b0:
            java.lang.Object r8 = r8.obj
            ex0 r8 = (defpackage.ex0) r8
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            rp<?> r2 = r8.f2926a
            o3 r2 = r2.d()
            java.lang.Object r0 = r0.get(r2)
            wp$a r0 = (defpackage.wp.a) r0
            if (r0 != 0) goto L_0x01d7
            rp<?> r0 = r8.f2926a
            r7.g(r0)
            java.util.Map<o3<?>, wp$a<?>> r0 = r7.f5501a
            rp<?> r2 = r8.f2926a
            o3 r2 = r2.d()
            java.lang.Object r0 = r0.get(r2)
            wp$a r0 = (defpackage.wp.a) r0
        L_0x01d7:
            boolean r2 = r0.f()
            if (r2 == 0) goto L_0x01f2
            java.util.concurrent.atomic.AtomicInteger r2 = r7.f5509b
            int r2 = r2.get()
            int r3 = r8.a
            if (r2 == r3) goto L_0x01f2
            ix0 r8 = r8.f2925a
            com.google.android.gms.common.api.Status r2 = a
            r8.b(r2)
            r0.t()
            goto L_0x025b
        L_0x01f2:
            ix0 r8 = r8.f2925a
            r0.k(r8)
            goto L_0x025b
        L_0x01f8:
            java.util.Map<o3<?>, wp$a<?>> r8 = r7.f5501a
            java.util.Collection r8 = r8.values()
            java.util.Iterator r8 = r8.iterator()
        L_0x0203:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0216
            java.lang.Object r0 = r8.next()
            wp$a r0 = (defpackage.wp.a) r0
            r0.v()
            r0.d()
            goto L_0x0203
        L_0x0216:
            goto L_0x025b
        L_0x0217:
            java.lang.Object r8 = r8.obj
            defpackage.b6.a(r8)
            r5.b()
            throw r5
        L_0x0220:
            java.lang.Object r8 = r8.obj
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x022e
            r2 = 10000(0x2710, double:4.9407E-320)
            goto L_0x022f
        L_0x022e:
        L_0x022f:
            r7.c = r2
            android.os.Handler r8 = r7.f5500a
            r0 = 12
            r8.removeMessages(r0)
            java.util.Map<o3<?>, wp$a<?>> r8 = r7.f5501a
            java.util.Set r8 = r8.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0242:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x025a
            java.lang.Object r2 = r8.next()
            o3 r2 = (defpackage.o3) r2
            android.os.Handler r3 = r7.f5500a
            android.os.Message r2 = r3.obtainMessage(r0, r2)
            long r4 = r7.c
            r3.sendMessageDelayed(r2, r4)
            goto L_0x0242
        L_0x025a:
        L_0x025b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wp.handleMessage(android.os.Message):boolean");
    }

    /* access modifiers changed from: package-private */
    public final boolean l(dc dcVar, int i) {
        return this.f5505a.t(this.f5499a, dcVar, i);
    }

    public final void b(dc dcVar, int i) {
        if (!l(dcVar, i)) {
            Handler handler = this.f5500a;
            handler.sendMessage(handler.obtainMessage(5, i, 0, dcVar));
        }
    }
}
