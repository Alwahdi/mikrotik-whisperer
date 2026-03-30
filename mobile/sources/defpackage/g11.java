package defpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* renamed from: g11  reason: default package */
public interface g11 {
    ScheduledExecutorService a(int i, ThreadFactory threadFactory, int i2);

    ExecutorService b(ThreadFactory threadFactory, int i);
}
