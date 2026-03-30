package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: aj0  reason: default package */
public final class aj0 extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, yg {
    static final Object a = new Object();
    static final Object b = new Object();
    static final Object c = new Object();
    static final Object d = new Object();

    /* renamed from: a  reason: collision with other field name */
    final Runnable f67a;

    public aj0(Runnable actual, zg parent) {
        super(3);
        this.f67a = actual;
        lazySet(0, parent);
    }

    public Object call() {
        run();
        return null;
    }

    public void run() {
        Object o;
        Object o2;
        lazySet(2, Thread.currentThread());
        try {
            this.f67a.run();
        } catch (Throwable th) {
            lazySet(2, (Object) null);
            Object o3 = get(0);
            if (!(o3 == a || !compareAndSet(0, o3, d) || o3 == null)) {
                ((zg) o3).a(this);
            }
            do {
                o2 = get(1);
                if (o2 == b || o2 == c || compareAndSet(1, o2, d)) {
                    throw th;
                }
                o2 = get(1);
                break;
            } while (compareAndSet(1, o2, d));
            throw th;
        }
        lazySet(2, (Object) null);
        Object o4 = get(0);
        if (!(o4 == a || !compareAndSet(0, o4, d) || o4 == null)) {
            ((zg) o4).a(this);
        }
        do {
            o = get(1);
            if (o == b || o == c || compareAndSet(1, o, d)) {
            }
            o = get(1);
            return;
        } while (compareAndSet(1, o, d));
    }

    public void a(Future<?> f) {
        Object o;
        do {
            o = get(1);
            if (o != d) {
                if (o == b) {
                    f.cancel(false);
                    return;
                } else if (o == c) {
                    f.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, o, f));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r7 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r7.get(r0)
            java.lang.Object r2 = d
            r3 = 0
            if (r1 == r2) goto L_0x0034
            java.lang.Object r2 = b
            if (r1 == r2) goto L_0x0034
            java.lang.Object r4 = c
            if (r1 != r4) goto L_0x0013
            goto L_0x0034
        L_0x0013:
            r5 = 2
            java.lang.Object r5 = r7.get(r5)
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            if (r5 == r6) goto L_0x0020
            r5 = 1
            goto L_0x0021
        L_0x0020:
            r5 = 0
        L_0x0021:
            if (r5 == 0) goto L_0x0024
            r2 = r4
        L_0x0024:
            boolean r0 = r7.compareAndSet(r0, r1, r2)
            if (r0 == 0) goto L_0x0033
            if (r1 == 0) goto L_0x0034
            r0 = r1
            java.util.concurrent.Future r0 = (java.util.concurrent.Future) r0
            r0.cancel(r5)
            goto L_0x0034
        L_0x0033:
            goto L_0x0000
        L_0x0034:
            java.lang.Object r0 = r7.get(r3)
            java.lang.Object r1 = d
            if (r0 == r1) goto L_0x0051
            java.lang.Object r1 = a
            if (r0 == r1) goto L_0x0051
            if (r0 != 0) goto L_0x0043
            goto L_0x0051
        L_0x0043:
            boolean r1 = r7.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0050
            r1 = r0
            zg r1 = (defpackage.zg) r1
            r1.a(r7)
            return
        L_0x0050:
            goto L_0x0034
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aj0.dispose():void");
    }
}
