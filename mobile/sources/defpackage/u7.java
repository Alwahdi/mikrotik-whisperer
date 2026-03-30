package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: u7  reason: default package */
public final class u7 extends va {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(u7.class, "_resumed");
    private volatile /* synthetic */ int _resumed;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public u7(defpackage.rc<?> r4, java.lang.Throwable r5, boolean r6) {
        /*
            r3 = this;
            if (r5 != 0) goto L_0x001e
            java.util.concurrent.CancellationException r0 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Continuation "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = " was cancelled normally"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            goto L_0x001f
        L_0x001e:
            r0 = r5
        L_0x001f:
            r3.<init>(r0, r6)
            r0 = 0
            r3._resumed = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u7.<init>(rc, java.lang.Throwable, boolean):void");
    }

    public final boolean c() {
        return b.compareAndSet(this, 0, 1);
    }
}
