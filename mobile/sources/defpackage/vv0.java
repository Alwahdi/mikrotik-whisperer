package defpackage;

import java.util.concurrent.Executor;

/* renamed from: vv0  reason: default package */
public class vv0 {
    private final hj a;

    /* renamed from: a  reason: collision with other field name */
    private final Executor f5417a;

    /* renamed from: a  reason: collision with other field name */
    private final xo0 f5418a;

    /* renamed from: a  reason: collision with other field name */
    private final yv0 f5419a;

    vv0(Executor executor, hj store, yv0 scheduler, xo0 guard) {
        this.f5417a = executor;
        this.a = store;
        this.f5419a = scheduler;
        this.f5418a = guard;
    }

    public void a() {
        this.f5417a.execute(tv0.a(this));
    }

    static /* synthetic */ Object b(vv0 vv0) {
        for (es0 context : vv0.a.r()) {
            vv0.f5419a.a(context, 1);
        }
        return null;
    }
}
