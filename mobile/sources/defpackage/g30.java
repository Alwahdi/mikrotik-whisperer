package defpackage;

import defpackage.bj0;
import java.util.concurrent.ThreadFactory;

/* renamed from: g30  reason: default package */
public final class g30 extends bj0 {
    private static final pf0 a = new pf0("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: a  reason: collision with other field name */
    final ThreadFactory f3007a;

    public g30() {
        this(a);
    }

    public g30(ThreadFactory threadFactory) {
        this.f3007a = threadFactory;
    }

    public bj0.b a() {
        return new h30(this.f3007a);
    }
}
