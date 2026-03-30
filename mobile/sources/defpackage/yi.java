package defpackage;

import com.google.firebase.events.EventHandler;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* renamed from: yi  reason: default package */
class yi implements io0, sb0 {
    private final Map<Class<?>, ConcurrentHashMap<zi<Object>, Executor>> a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private Queue<vi<?>> f5885a = new ArrayDeque();

    /* renamed from: a  reason: collision with other field name */
    private final Executor f5886a;

    yi(Executor defaultExecutor) {
        this.f5886a = defaultExecutor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r0.hasNext() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r1 = r0.next();
        r1.getValue().execute(defpackage.xi.a(r1, r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
        r0 = c(r6).iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(defpackage.vi<?> r6) {
        /*
            r5 = this;
            defpackage.w90.b(r6)
            monitor-enter(r5)
            java.util.Queue<vi<?>> r0 = r5.f5885a     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x000d
            r0.add(r6)     // Catch:{ all -> 0x0032 }
            monitor-exit(r5)     // Catch:{ all -> 0x0032 }
            return
        L_0x000d:
            monitor-exit(r5)     // Catch:{ all -> 0x0032 }
            java.util.Set r0 = r5.c(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0031
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r2 = r6
            java.lang.Object r3 = r1.getValue()
            java.util.concurrent.Executor r3 = (java.util.concurrent.Executor) r3
            java.lang.Runnable r4 = defpackage.xi.a(r1, r2)
            r3.execute(r4)
            goto L_0x0016
        L_0x0031:
            return
        L_0x0032:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0032 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yi.e(vi):void");
    }

    private synchronized Set<Map.Entry<zi<Object>, Executor>> c(vi<?> event) {
        Map<EventHandler<Object>, Executor> handlers;
        handlers = this.a.get(event.a());
        return handlers == null ? Collections.emptySet() : handlers.entrySet();
    }

    public synchronized <T> void f(Class<T> type, Executor executor, zi<? super T> handler) {
        w90.b(type);
        w90.b(handler);
        w90.b(executor);
        if (!this.a.containsKey(type)) {
            this.a.put(type, new ConcurrentHashMap());
        }
        this.a.get(type).put(handler, executor);
    }

    public <T> void a(Class<T> type, zi<? super T> handler) {
        f(type, this.f5886a, handler);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Queue<vi<?>> queue = null;
        synchronized (this) {
            Queue<vi<?>> queue2 = this.f5885a;
            if (queue2 != null) {
                queue = queue2;
                this.f5885a = null;
            }
        }
        if (queue != null) {
            Iterator it = queue.iterator();
            while (it.hasNext()) {
                e((vi) it.next());
            }
        }
    }
}
