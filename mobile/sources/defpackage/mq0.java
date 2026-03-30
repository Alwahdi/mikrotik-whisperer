package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: mq0  reason: default package */
public abstract class mq0 {
    public static final int a = bp0.d("kotlinx.coroutines.scheduler.core.pool.size", hd0.a(zo0.a(), 2), 1, 0, 8, (Object) null);

    /* renamed from: a  reason: collision with other field name */
    public static final long f4382a = bp0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);

    /* renamed from: a  reason: collision with other field name */
    public static fj0 f4383a = f30.a;

    /* renamed from: a  reason: collision with other field name */
    public static final hq0 f4384a = new iq0(0);
    public static final int b = bp0.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, (Object) null);

    /* renamed from: b  reason: collision with other field name */
    public static final long f4385b = TimeUnit.SECONDS.toNanos(bp0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));

    /* renamed from: b  reason: collision with other field name */
    public static final hq0 f4386b = new iq0(1);
}
