package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: p91  reason: default package */
final class p91 extends WeakReference<Throwable> {
    private final int a;

    public p91(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != p91.class) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        p91 p91 = (p91) obj;
        if (this.a == p91.a && get() == p91.get()) {
            return true;
        }
        return false;
    }
}
