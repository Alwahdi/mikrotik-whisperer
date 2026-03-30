package io.grpc.internal;

import java.util.concurrent.atomic.AtomicLong;

final class g implements cz {
    private final AtomicLong a = new AtomicLong();

    g() {
    }

    public void a(long delta) {
        this.a.getAndAdd(delta);
    }
}
