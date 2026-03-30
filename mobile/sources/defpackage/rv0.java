package defpackage;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: rv0  reason: default package */
final class rv0 extends wd {
    private static final WeakHashMap<Class<? extends Throwable>, vn<Throwable, Throwable>> a = new WeakHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static final ReentrantReadWriteLock f4950a = new ReentrantReadWriteLock();

    /* renamed from: a  reason: collision with other field name */
    public static final rv0 f4951a = new rv0();

    private rv0() {
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public defpackage.vn<java.lang.Throwable, java.lang.Throwable> a(java.lang.Class<? extends java.lang.Throwable> r10) {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f4950a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            r1.lock()
            r2 = 0
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, vn<java.lang.Throwable, java.lang.Throwable>> r3 = a     // Catch:{ all -> 0x007b }
            java.lang.Object r3 = r3.get(r10)     // Catch:{ all -> 0x007b }
            vn r3 = (defpackage.vn) r3     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x001b
            r0 = r3
            r3 = 0
            r1.unlock()
            return r0
        L_0x001b:
            r1.unlock()
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x002e
            int r2 = r0.getReadHoldCount()
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            r4 = 0
        L_0x0030:
            if (r4 >= r2) goto L_0x0038
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0030
        L_0x0038:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            r4 = 0
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, vn<java.lang.Throwable, java.lang.Throwable>> r5 = a     // Catch:{ all -> 0x006e }
            java.lang.Object r6 = r5.get(r10)     // Catch:{ all -> 0x006e }
            vn r6 = (defpackage.vn) r6     // Catch:{ all -> 0x006e }
            if (r6 == 0) goto L_0x0059
            r5 = r6
            r6 = 0
        L_0x004d:
            if (r3 >= r2) goto L_0x0055
            r1.lock()
            int r3 = r3 + 1
            goto L_0x004d
        L_0x0055:
            r0.unlock()
            return r5
        L_0x0059:
            vn r6 = defpackage.pj.b(r10)     // Catch:{ all -> 0x006e }
            r7 = r6
            r8 = 0
            r5.put(r10, r7)     // Catch:{ all -> 0x006e }
        L_0x0062:
            if (r3 >= r2) goto L_0x006a
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0062
        L_0x006a:
            r0.unlock()
            return r6
        L_0x006e:
            r4 = move-exception
        L_0x006f:
            if (r3 >= r2) goto L_0x0077
            r1.lock()
            int r3 = r3 + 1
            goto L_0x006f
        L_0x0077:
            r0.unlock()
            throw r4
        L_0x007b:
            r0 = move-exception
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rv0.a(java.lang.Class):vn");
    }
}
