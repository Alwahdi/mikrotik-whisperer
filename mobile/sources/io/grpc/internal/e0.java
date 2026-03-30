package io.grpc.internal;

import io.grpc.internal.k1;
import io.grpc.internal.u0;

abstract class e0 implements u0.b {
    /* access modifiers changed from: protected */
    public abstract u0.b b();

    e0() {
    }

    public void e(int numBytes) {
        b().e(numBytes);
    }

    public void a(k1.a producer) {
        b().a(producer);
    }

    public void c(boolean hasPartialMessage) {
        b().c(hasPartialMessage);
    }

    public void d(Throwable cause) {
        b().d(cause);
    }
}
