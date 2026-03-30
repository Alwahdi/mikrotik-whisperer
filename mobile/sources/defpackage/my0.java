package defpackage;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: my0  reason: default package */
public final class my0 {
    private final Map<BasePendingResult<?>, Boolean> a = Collections.synchronizedMap(new WeakHashMap());
    /* access modifiers changed from: private */
    public final Map<gq0<?>, Boolean> b = Collections.synchronizedMap(new WeakHashMap());

    /* access modifiers changed from: package-private */
    public final <TResult> void a(gq0<TResult> gq0, boolean z) {
        this.b.put(gq0, Boolean.valueOf(z));
        gq0.a().b(new ow0(this, gq0));
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return !this.a.isEmpty() || !this.b.isEmpty();
    }

    public final void d() {
        b(false, wp.a);
    }

    public final void e() {
        b(true, px0.a);
    }

    /* JADX WARNING: type inference failed for: r5v4, types: [java.lang.Throwable, com.google.android.gms.common.api.internal.BasePendingResult] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(boolean r5, com.google.android.gms.common.api.Status r6) {
        /*
            r4 = this;
            java.util.Map<com.google.android.gms.common.api.internal.BasePendingResult<?>, java.lang.Boolean> r0 = r4.a
            monitor-enter(r0)
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x007a }
            java.util.Map<com.google.android.gms.common.api.internal.BasePendingResult<?>, java.lang.Boolean> r2 = r4.a     // Catch:{ all -> 0x007a }
            r1.<init>(r2)     // Catch:{ all -> 0x007a }
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            java.util.Map<gq0<?>, java.lang.Boolean> r2 = r4.b
            monitor-enter(r2)
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0077 }
            java.util.Map<gq0<?>, java.lang.Boolean> r3 = r4.b     // Catch:{ all -> 0x0077 }
            r0.<init>(r3)     // Catch:{ all -> 0x0077 }
            monitor-exit(r2)     // Catch:{ all -> 0x0077 }
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x001e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0045
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            if (r5 != 0) goto L_0x0039
            java.lang.Object r3 = r2.getValue()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L_0x0039
            goto L_0x001e
        L_0x0039:
            java.lang.Object r5 = r2.getKey()
            defpackage.b6.a(r5)
            r5 = 0
            r5.a(r6)
            throw r5
        L_0x0045:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x004d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0076
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            if (r5 != 0) goto L_0x0067
            java.lang.Object r2 = r1.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0075
        L_0x0067:
            java.lang.Object r1 = r1.getKey()
            gq0 r1 = (defpackage.gq0) r1
            l3 r2 = new l3
            r2.<init>(r6)
            r1.d(r2)
        L_0x0075:
            goto L_0x004d
        L_0x0076:
            return
        L_0x0077:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0077 }
            throw r5
        L_0x007a:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.my0.b(boolean, com.google.android.gms.common.api.Status):void");
    }
}
