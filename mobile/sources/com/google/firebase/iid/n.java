package com.google.firebase.iid;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import java.util.Map;

final class n {
    private int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final k f2440a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<Integer, gq0<Void>> f2441a = new ArrayMap();

    n(k kVar) {
        this.f2440a = kVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a() {
        return d() != null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (c(r5, r0) != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2 = r4.f2441a.remove(java.lang.Integer.valueOf(r4.a));
        e(r0);
        r4.a++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r2 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        r2.c(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(com.google.firebase.iid.FirebaseInstanceId r5) {
        /*
            r4 = this;
        L_0x0000:
            monitor-enter(r4)
            java.lang.String r0 = r4.d()     // Catch:{ all -> 0x0042 }
            r1 = 1
            if (r0 != 0) goto L_0x0017
            boolean r5 = com.google.firebase.iid.FirebaseInstanceId.w()     // Catch:{ all -> 0x0042 }
            if (r5 == 0) goto L_0x0015
            java.lang.String r5 = "FirebaseInstanceId"
            java.lang.String r0 = "topic sync succeeded"
            android.util.Log.d(r5, r0)     // Catch:{ all -> 0x0042 }
        L_0x0015:
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            return r1
        L_0x0017:
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            boolean r2 = c(r5, r0)
            if (r2 != 0) goto L_0x0020
            r5 = 0
            return r5
        L_0x0020:
            monitor-enter(r4)
            java.util.Map<java.lang.Integer, gq0<java.lang.Void>> r2 = r4.f2441a     // Catch:{ all -> 0x003f }
            int r3 = r4.a     // Catch:{ all -> 0x003f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r2.remove(r3)     // Catch:{ all -> 0x003f }
            gq0 r2 = (defpackage.gq0) r2     // Catch:{ all -> 0x003f }
            r4.e(r0)     // Catch:{ all -> 0x003f }
            int r0 = r4.a     // Catch:{ all -> 0x003f }
            int r0 = r0 + r1
            r4.a = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r4)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003e
            r0 = 0
            r2.c(r0)
        L_0x003e:
            goto L_0x0000
        L_0x003f:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003f }
            throw r5
        L_0x0042:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.n.b(com.google.firebase.iid.FirebaseInstanceId):boolean");
    }

    private final String d() {
        String b;
        synchronized (this.f2440a) {
            b = this.f2440a.b();
        }
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        String[] split = b.split(",");
        if (split.length <= 1 || TextUtils.isEmpty(split[1])) {
            return null;
        }
        return split[1];
    }

    private final synchronized boolean e(String str) {
        synchronized (this.f2440a) {
            String b = this.f2440a.b();
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (!b.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                return false;
            }
            String valueOf3 = String.valueOf(",");
            String valueOf4 = String.valueOf(str);
            this.f2440a.d(b.substring((valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).length()));
            return true;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(com.google.firebase.iid.FirebaseInstanceId r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r1 = "!"
            java.lang.String[] r7 = r7.split(r1)
            int r1 = r7.length
            r2 = 1
            r3 = 2
            if (r1 != r3) goto L_0x00a0
            r1 = 0
            r3 = r7[r1]
            r7 = r7[r2]
            r4 = -1
            int r5 = r3.hashCode()     // Catch:{ IOException -> 0x0051 }
            switch(r5) {
                case 83: goto L_0x0025;
                case 84: goto L_0x001a;
                case 85: goto L_0x001b;
                default: goto L_0x001a;
            }     // Catch:{ IOException -> 0x0051 }
        L_0x001a:
            goto L_0x002e
        L_0x001b:
            java.lang.String r5 = "U"
            boolean r3 = r3.equals(r5)     // Catch:{ IOException -> 0x0051 }
            if (r3 == 0) goto L_0x001a
            r4 = 1
            goto L_0x002e
        L_0x0025:
            java.lang.String r5 = "S"
            boolean r3 = r3.equals(r5)     // Catch:{ IOException -> 0x0051 }
            if (r3 == 0) goto L_0x001a
            r4 = 0
        L_0x002e:
            switch(r4) {
                case 0: goto L_0x0041;
                case 1: goto L_0x0032;
                default: goto L_0x0031;
            }     // Catch:{ IOException -> 0x0051 }
        L_0x0031:
            goto L_0x0050
        L_0x0032:
            r6.u(r7)     // Catch:{ IOException -> 0x0051 }
            boolean r6 = com.google.firebase.iid.FirebaseInstanceId.w()     // Catch:{ IOException -> 0x0051 }
            if (r6 == 0) goto L_0x0050
            java.lang.String r6 = "unsubscribe operation succeeded"
            android.util.Log.d(r0, r6)     // Catch:{ IOException -> 0x0051 }
            goto L_0x0050
        L_0x0041:
            r6.s(r7)     // Catch:{ IOException -> 0x0051 }
            boolean r6 = com.google.firebase.iid.FirebaseInstanceId.w()     // Catch:{ IOException -> 0x0051 }
            if (r6 == 0) goto L_0x0050
            java.lang.String r6 = "subscribe operation succeeded"
            android.util.Log.d(r0, r6)     // Catch:{ IOException -> 0x0051 }
            goto L_0x00a0
        L_0x0050:
            goto L_0x00a0
        L_0x0051:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            java.lang.String r2 = "SERVICE_NOT_AVAILABLE"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x0078
            java.lang.String r7 = r6.getMessage()
            java.lang.String r2 = "INTERNAL_SERVER_ERROR"
            boolean r7 = r2.equals(r7)
            if (r7 == 0) goto L_0x006b
            goto L_0x0078
        L_0x006b:
            java.lang.String r7 = r6.getMessage()
            if (r7 != 0) goto L_0x0077
            java.lang.String r6 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r0, r6)
            return r1
        L_0x0077:
            throw r6
        L_0x0078:
            java.lang.String r6 = r6.getMessage()
            java.lang.String r7 = java.lang.String.valueOf(r6)
            int r7 = r7.length()
            int r7 = r7 + 53
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r7)
            java.lang.String r7 = "Topic operation failed: "
            r2.append(r7)
            r2.append(r6)
            java.lang.String r6 = ". Will retry Topic operation."
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            android.util.Log.e(r0, r6)
            return r1
        L_0x00a0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.n.c(com.google.firebase.iid.FirebaseInstanceId, java.lang.String):boolean");
    }
}
