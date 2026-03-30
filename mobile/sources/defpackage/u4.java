package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: u4  reason: default package */
public final class u4 extends AtomicReference<Throwable> {
    public boolean a(Throwable t) {
        return nj.a(this, t);
    }

    public Throwable b() {
        return nj.b(this);
    }
}
