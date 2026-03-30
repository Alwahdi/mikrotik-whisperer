package defpackage;

/* renamed from: zy0  reason: default package */
final /* synthetic */ class zy0 implements Runnable {
    private final aa1 a;

    zy0(aa1 aa1) {
        this.a = aa1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        r4 = java.lang.String.valueOf(r1);
        r6 = new java.lang.StringBuilder(java.lang.String.valueOf(r4).length() + 8);
        r6.append("Sending ");
        r6.append(r4);
        android.util.Log.d("MessengerIpcClient", r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        r3 = r0.f46a.f5869a;
        r4 = r0.f42a;
        r5 = android.os.Message.obtain();
        r5.what = r1.b;
        r5.arg1 = r1.a;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.d());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle("data", r1.f4953a);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.f45a.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a7, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a8, code lost:
        r0.c(2, r1.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            aa1 r0 = r8.a
        L_0x0002:
            monitor-enter(r0)
            int r1 = r0.a     // Catch:{ all -> 0x00b1 }
            r2 = 2
            if (r1 == r2) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            return
        L_0x000a:
            java.util.Queue<rz0<?>> r1 = r0.f44a     // Catch:{ all -> 0x00b1 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x0017
            r0.f()     // Catch:{ all -> 0x00b1 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            return
        L_0x0017:
            java.util.Queue<rz0<?>> r1 = r0.f44a     // Catch:{ all -> 0x00b1 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x00b1 }
            rz0 r1 = (defpackage.rz0) r1     // Catch:{ all -> 0x00b1 }
            android.util.SparseArray<rz0<?>> r3 = r0.f43a     // Catch:{ all -> 0x00b1 }
            int r4 = r1.a     // Catch:{ all -> 0x00b1 }
            r3.put(r4, r1)     // Catch:{ all -> 0x00b1 }
            y91 r3 = r0.f46a     // Catch:{ all -> 0x00b1 }
            java.util.concurrent.ScheduledExecutorService r3 = r3.f5870a     // Catch:{ all -> 0x00b1 }
            dz0 r4 = new dz0     // Catch:{ all -> 0x00b1 }
            r4.<init>(r0, r1)     // Catch:{ all -> 0x00b1 }
            r5 = 30
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x00b1 }
            r3.schedule(r4, r5, r7)     // Catch:{ all -> 0x00b1 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = "MessengerIpcClient"
            r4 = 3
            boolean r3 = android.util.Log.isLoggable(r3, r4)
            if (r3 == 0) goto L_0x0067
            java.lang.String r3 = "MessengerIpcClient"
            java.lang.String r4 = java.lang.String.valueOf(r1)
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Sending "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            android.util.Log.d(r3, r4)
        L_0x0067:
            y91 r3 = r0.f46a
            android.content.Context r3 = r3.f5869a
            android.os.Messenger r4 = r0.f42a
            android.os.Message r5 = android.os.Message.obtain()
            int r6 = r1.b
            r5.what = r6
            int r6 = r1.a
            r5.arg1 = r6
            r5.replyTo = r4
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r6 = "oneWay"
            boolean r7 = r1.d()
            r4.putBoolean(r6, r7)
            java.lang.String r6 = "pkg"
            java.lang.String r3 = r3.getPackageName()
            r4.putString(r6, r3)
            java.lang.String r3 = "data"
            android.os.Bundle r1 = r1.f4953a
            r4.putBundle(r3, r1)
            r5.setData(r4)
            nz0 r1 = r0.f45a     // Catch:{ RemoteException -> 0x00a7 }
            r1.a(r5)     // Catch:{ RemoteException -> 0x00a7 }
            goto L_0x0002
        L_0x00a7:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            r0.c(r2, r1)
            goto L_0x0002
        L_0x00b1:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zy0.run():void");
    }
}
