package io.grpc.internal;

import io.grpc.internal.k1;
import io.grpc.internal.u0;
import java.io.Closeable;

final class j1 extends e0 {
    private final u0.b a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3461a;

    public j1(u0.b delegate) {
        this.a = delegate;
    }

    /* access modifiers changed from: protected */
    public u0.b b() {
        return this.a;
    }

    public void a(k1.a producer) {
        if (!this.f3461a) {
            super.a(producer);
        } else if (producer instanceof Closeable) {
            h0.d((Closeable) producer);
        }
    }

    public void c(boolean hasPartialMessage) {
        this.f3461a = true;
        super.c(hasPartialMessage);
    }

    public void d(Throwable cause) {
        this.f3461a = true;
        super.d(cause);
    }
}
