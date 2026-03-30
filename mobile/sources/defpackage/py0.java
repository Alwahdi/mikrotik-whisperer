package defpackage;

import defpackage.r90;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: py0  reason: default package */
final class py0 implements r90.a {
    py0() {
    }

    public final ScheduledExecutorService a() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
