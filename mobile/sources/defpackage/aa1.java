package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: aa1  reason: default package */
final class aa1 implements ServiceConnection {
    int a;

    /* renamed from: a  reason: collision with other field name */
    final Messenger f42a;

    /* renamed from: a  reason: collision with other field name */
    final SparseArray<rz0<?>> f43a;

    /* renamed from: a  reason: collision with other field name */
    final Queue<rz0<?>> f44a;

    /* renamed from: a  reason: collision with other field name */
    nz0 f45a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ y91 f46a;

    private aa1(y91 y91) {
        this.f46a = y91;
        this.a = 0;
        this.f42a = new Messenger(new d51(Looper.getMainLooper(), new ia1(this)));
        this.f44a = new ArrayDeque();
        this.f43a = new SparseArray<>();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0075, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean e(defpackage.rz0<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.a     // Catch:{ all -> 0x008f }
            r1 = 0
            r2 = 1
            switch(r0) {
                case 0: goto L_0x001e;
                case 1: goto L_0x0017;
                case 2: goto L_0x000d;
                case 3: goto L_0x000b;
                case 4: goto L_0x000b;
                default: goto L_0x0008;
            }     // Catch:{ all -> 0x008f }
        L_0x0008:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008f }
            goto L_0x0076
        L_0x000b:
            monitor-exit(r5)
            return r1
        L_0x000d:
            java.util.Queue<rz0<?>> r0 = r5.f44a     // Catch:{ all -> 0x008f }
            r0.add(r6)     // Catch:{ all -> 0x008f }
            r5.a()     // Catch:{ all -> 0x008f }
            monitor-exit(r5)
            return r2
        L_0x0017:
            java.util.Queue<rz0<?>> r0 = r5.f44a     // Catch:{ all -> 0x008f }
            r0.add(r6)     // Catch:{ all -> 0x008f }
            monitor-exit(r5)
            return r2
        L_0x001e:
            java.util.Queue<rz0<?>> r0 = r5.f44a     // Catch:{ all -> 0x008f }
            r0.add(r6)     // Catch:{ all -> 0x008f }
            int r6 = r5.a     // Catch:{ all -> 0x008f }
            if (r6 != 0) goto L_0x002a
            r6 = 1
            goto L_0x002b
        L_0x002a:
            r6 = 0
        L_0x002b:
            defpackage.y90.l(r6)     // Catch:{ all -> 0x008f }
            java.lang.String r6 = "MessengerIpcClient"
            r0 = 2
            boolean r6 = android.util.Log.isLoggable(r6, r0)     // Catch:{ all -> 0x008f }
            if (r6 == 0) goto L_0x003e
            java.lang.String r6 = "MessengerIpcClient"
            java.lang.String r0 = "Starting bind to GmsCore"
            android.util.Log.v(r6, r0)     // Catch:{ all -> 0x008f }
        L_0x003e:
            r5.a = r2     // Catch:{ all -> 0x008f }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x008f }
            java.lang.String r0 = "com.google.android.c2dm.intent.REGISTER"
            r6.<init>(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = "com.google.android.gms"
            r6.setPackage(r0)     // Catch:{ all -> 0x008f }
            ec r0 = defpackage.ec.b()     // Catch:{ all -> 0x008f }
            y91 r3 = r5.f46a     // Catch:{ all -> 0x008f }
            android.content.Context r3 = r3.f5869a     // Catch:{ all -> 0x008f }
            boolean r6 = r0.a(r3, r6, r5, r2)     // Catch:{ all -> 0x008f }
            if (r6 != 0) goto L_0x0062
            java.lang.String r6 = "Unable to bind to service"
            r5.c(r1, r6)     // Catch:{ all -> 0x008f }
            goto L_0x0074
        L_0x0062:
            y91 r6 = r5.f46a     // Catch:{ all -> 0x008f }
            java.util.concurrent.ScheduledExecutorService r6 = r6.f5870a     // Catch:{ all -> 0x008f }
            fa1 r0 = new fa1     // Catch:{ all -> 0x008f }
            r0.<init>(r5)     // Catch:{ all -> 0x008f }
            r3 = 30
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x008f }
            r6.schedule(r0, r3, r1)     // Catch:{ all -> 0x008f }
        L_0x0074:
            monitor-exit(r5)
            return r2
        L_0x0076:
            int r0 = r5.a     // Catch:{ all -> 0x008f }
            r1 = 26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r2.<init>(r1)     // Catch:{ all -> 0x008f }
            java.lang.String r1 = "Unknown state: "
            r2.append(r1)     // Catch:{ all -> 0x008f }
            r2.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x008f }
            r6.<init>(r0)     // Catch:{ all -> 0x008f }
            throw r6     // Catch:{ all -> 0x008f }
        L_0x008f:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aa1.e(rz0):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005d, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        r1.c(new defpackage.pz0(4, "Not supported by GmsCore"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        r1.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(android.os.Message r5) {
        /*
            r4 = this;
            int r0 = r5.arg1
            java.lang.String r1 = "MessengerIpcClient"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)
            if (r1 == 0) goto L_0x0023
            java.lang.String r1 = "MessengerIpcClient"
            r2 = 41
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Received response to request: "
            r3.append(r2)
            r3.append(r0)
            java.lang.String r2 = r3.toString()
            android.util.Log.d(r1, r2)
        L_0x0023:
            monitor-enter(r4)
            android.util.SparseArray<rz0<?>> r1 = r4.f43a     // Catch:{ all -> 0x006f }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x006f }
            rz0 r1 = (defpackage.rz0) r1     // Catch:{ all -> 0x006f }
            r2 = 1
            if (r1 != 0) goto L_0x0049
            java.lang.String r5 = "MessengerIpcClient"
            r1 = 50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r3.<init>(r1)     // Catch:{ all -> 0x006f }
            java.lang.String r1 = "Received response for unknown request: "
            r3.append(r1)     // Catch:{ all -> 0x006f }
            r3.append(r0)     // Catch:{ all -> 0x006f }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x006f }
            android.util.Log.w(r5, r0)     // Catch:{ all -> 0x006f }
            monitor-exit(r4)     // Catch:{ all -> 0x006f }
            return r2
        L_0x0049:
            android.util.SparseArray<rz0<?>> r3 = r4.f43a     // Catch:{ all -> 0x006f }
            r3.remove(r0)     // Catch:{ all -> 0x006f }
            r4.f()     // Catch:{ all -> 0x006f }
            monitor-exit(r4)     // Catch:{ all -> 0x006f }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r3 = 0
            boolean r0 = r5.getBoolean(r0, r3)
            if (r0 == 0) goto L_0x006b
            pz0 r5 = new pz0
            r0 = 4
            java.lang.String r3 = "Not supported by GmsCore"
            r5.<init>(r0, r3)
            r1.c(r5)
            goto L_0x006e
        L_0x006b:
            r1.a(r5)
        L_0x006e:
            return r2
        L_0x006f:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aa1.d(android.os.Message):boolean");
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f46a.f5870a.execute(new bz0(this, iBinder));
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f46a.f5870a.execute(new zy0(this));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f46a.f5870a.execute(new gz0(this));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void c(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        switch (this.a) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.a = 4;
                ec.b().c(this.f46a.f5869a, this);
                pz0 pz0 = new pz0(i, str);
                for (rz0 c : this.f44a) {
                    c.c(pz0);
                }
                this.f44a.clear();
                for (int i2 = 0; i2 < this.f43a.size(); i2++) {
                    this.f43a.valueAt(i2).c(pz0);
                }
                this.f43a.clear();
                return;
            case 3:
                this.a = 4;
                return;
            case 4:
                return;
            default:
                int i3 = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void f() {
        if (this.a == 2 && this.f44a.isEmpty() && this.f43a.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.a = 3;
            ec.b().c(this.f46a.f5869a, this);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void g() {
        if (this.a == 1) {
            c(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(int i) {
        rz0 rz0 = this.f43a.get(i);
        if (rz0 != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.f43a.remove(i);
            rz0.c(new pz0(3, "Timed out waiting for response"));
            f();
        }
    }
}
