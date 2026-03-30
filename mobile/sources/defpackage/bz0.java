package defpackage;

import android.os.IBinder;

/* renamed from: bz0  reason: default package */
final /* synthetic */ class bz0 implements Runnable {
    private final aa1 a;

    /* renamed from: a  reason: collision with other field name */
    private final IBinder f278a;

    bz0(aa1 aa1, IBinder iBinder) {
        this.a = aa1;
        this.f278a = iBinder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0022, code lost:
        r0.c(0, r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002c, code lost:
        throw r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x000a, B:9:0x000f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
            aa1 r0 = r4.a
            android.os.IBinder r1 = r4.f278a
            monitor-enter(r0)
            r2 = 0
            if (r1 != 0) goto L_0x000f
            java.lang.String r1 = "Null service connection"
            r0.c(r2, r1)     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x000f:
            nz0 r3 = new nz0     // Catch:{ RemoteException -> 0x0021 }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x0021 }
            r0.f45a = r3     // Catch:{ RemoteException -> 0x0021 }
            r1 = 2
            r0.a = r1     // Catch:{ all -> 0x001f }
            r0.a()     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            goto L_0x002b
        L_0x0021:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x001f }
            r0.c(r2, r1)     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bz0.run():void");
    }
}
