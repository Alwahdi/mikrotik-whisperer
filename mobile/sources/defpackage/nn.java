package defpackage;

import defpackage.nn;
import java.util.concurrent.TimeUnit;

/* renamed from: nn  reason: default package */
public abstract class nn<T extends nn<T>> extends sz<T> {
    /* access modifiers changed from: protected */
    public abstract sz<?> e();

    protected nn() {
    }

    /* renamed from: h */
    public T d() {
        e().d();
        return g();
    }

    /* renamed from: f */
    public T c(long keepAliveTime, TimeUnit timeUnit) {
        e().c(keepAliveTime, timeUnit);
        return g();
    }

    public String toString() {
        return f20.c(this).d("delegate", e()).toString();
    }

    /* access modifiers changed from: protected */
    public final T g() {
        return this;
    }
}
