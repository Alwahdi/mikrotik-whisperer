package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import io.grpc.internal.o;
import io.grpc.l;
import io.grpc.p;

public final class z extends m30 {
    private final o.a a;

    /* renamed from: a  reason: collision with other field name */
    private final p f3791a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3792a;

    public z(p error) {
        this(error, o.a.PROCESSED);
    }

    public z(p error, o.a rpcProgress) {
        v90.e(!error.o(), "error must not be OK");
        this.f3791a = error;
        this.a = rpcProgress;
    }

    public void k(o listener) {
        v90.u(!this.f3792a, "already started");
        this.f3792a = true;
        listener.c(this.f3791a, this.a, new l());
    }

    public void n(vs insight) {
        insight.b("error", this.f3791a).b(NotificationCompat.CATEGORY_PROGRESS, this.a);
    }
}
