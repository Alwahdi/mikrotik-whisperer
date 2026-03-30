package io.grpc.internal;

import io.grpc.l;
import io.grpc.p;

public interface o extends k1 {

    public enum a {
        PROCESSED,
        REFUSED,
        DROPPED
    }

    void c(p pVar, a aVar, l lVar);

    void d(p pVar, l lVar);

    void e(l lVar);
}
