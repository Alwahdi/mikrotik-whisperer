package io.grpc.internal;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

class e1 implements Executor {
    private static final Logger a = Logger.getLogger(e1.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private ArrayDeque<Runnable> f3402a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3403a;

    e1() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r6.f3402a == null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r6.f3402a != null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r6.f3403a = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute(java.lang.Runnable r7) {
        /*
            r6 = this;
            java.lang.String r0 = "'task' must not be null."
            defpackage.v90.o(r7, r0)
            boolean r0 = r6.f3403a
            if (r0 != 0) goto L_0x0044
            r0 = 1
            r6.f3403a = r0
            r0 = 0
            r7.run()     // Catch:{ all -> 0x001a }
            java.util.ArrayDeque<java.lang.Runnable> r1 = r6.f3402a
            if (r1 == 0) goto L_0x0017
        L_0x0014:
            r6.a()
        L_0x0017:
            r6.f3403a = r0
            goto L_0x0038
        L_0x001a:
            r1 = move-exception
            java.util.logging.Logger r2 = a     // Catch:{ all -> 0x0039 }
            java.util.logging.Level r3 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r4.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r5 = "Exception while executing runnable "
            r4.append(r5)     // Catch:{ all -> 0x0039 }
            r4.append(r7)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0039 }
            r2.log(r3, r4, r1)     // Catch:{ all -> 0x0039 }
            java.util.ArrayDeque<java.lang.Runnable> r1 = r6.f3402a
            if (r1 == 0) goto L_0x0017
            goto L_0x0014
        L_0x0038:
            goto L_0x0047
        L_0x0039:
            r1 = move-exception
            java.util.ArrayDeque<java.lang.Runnable> r2 = r6.f3402a
            if (r2 == 0) goto L_0x0041
            r6.a()
        L_0x0041:
            r6.f3403a = r0
            throw r1
        L_0x0044:
            r6.b(r7)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.e1.execute(java.lang.Runnable):void");
    }

    private void a() {
        while (true) {
            Runnable poll = this.f3402a.poll();
            Runnable task = poll;
            if (poll != null) {
                try {
                    task.run();
                } catch (Throwable t) {
                    Logger logger = a;
                    Level level = Level.SEVERE;
                    logger.log(level, "Exception while executing runnable " + task, t);
                }
            } else {
                return;
            }
        }
    }

    private void b(Runnable r) {
        if (this.f3402a == null) {
            this.f3402a = new ArrayDeque<>(4);
        }
        this.f3402a.add(r);
    }
}
