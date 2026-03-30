package defpackage;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;
import java.util.List;

/* renamed from: qb  reason: default package */
public final class qb implements yg, zg {
    v40<yg> a;

    /* renamed from: a  reason: collision with other field name */
    volatile boolean f4796a;

    public void dispose() {
        if (!this.f4796a) {
            synchronized (this) {
                if (!this.f4796a) {
                    this.f4796a = true;
                    OpenHashSet<Disposable> set = this.a;
                    this.a = null;
                    d(set);
                }
            }
        }
    }

    public boolean e() {
        return this.f4796a;
    }

    public boolean c(yg d) {
        a40.c(d, "d is null");
        if (!this.f4796a) {
            synchronized (this) {
                if (!this.f4796a) {
                    OpenHashSet<Disposable> set = this.a;
                    if (set == null) {
                        set = new v40<>();
                        this.a = set;
                    }
                    set.a(d);
                    return true;
                }
            }
        }
        d.dispose();
        return false;
    }

    public boolean b(yg d) {
        if (!a(d)) {
            return false;
        }
        d.dispose();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(defpackage.yg r4) {
        /*
            r3 = this;
            java.lang.String r0 = "Disposable item is null"
            defpackage.a40.c(r4, r0)
            boolean r0 = r3.f4796a
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r3)
            boolean r0 = r3.f4796a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            v40<yg> r0 = r3.a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r2 = r0.e(r4)     // Catch:{ all -> 0x0022 }
            if (r2 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            r0 = 1
            return r0
        L_0x0020:
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qb.a(yg):boolean");
    }

    /* access modifiers changed from: package-private */
    public void d(v40<yg> set) {
        if (set != null) {
            List<Throwable> errors = null;
            for (Object o : set.b()) {
                if (o instanceof yg) {
                    try {
                        ((yg) o).dispose();
                    } catch (Throwable ex) {
                        oj.b(ex);
                        if (errors == null) {
                            errors = new ArrayList<>();
                        }
                        errors.add(ex);
                    }
                }
            }
            if (errors == null) {
                return;
            }
            if (errors.size() == 1) {
                throw nj.d(errors.get(0));
            }
            throw new rb((Iterable<? extends Throwable>) errors);
        }
    }
}
