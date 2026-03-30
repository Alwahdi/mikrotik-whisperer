package defpackage;

import java.util.HashSet;

/* renamed from: es  reason: default package */
public abstract class es<T> {
    private final HashSet<T> a = new HashSet<>();

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract void b();

    public final void d(T object, boolean inUse) {
        int origSize = this.a.size();
        if (inUse) {
            this.a.add(object);
            if (origSize == 0) {
                a();
            }
        } else if (this.a.remove(object) && origSize == 1) {
            b();
        }
    }

    public final boolean c() {
        return !this.a.isEmpty();
    }
}
