package io.grpc;

import io.grpc.p;
import java.util.concurrent.TimeoutException;

public abstract class f {
    public static p a(qc context) {
        v90.o(context, "context must not be null");
        if (!context.h()) {
            return null;
        }
        Throwable cancellationCause = context.c();
        if (cancellationCause == null) {
            return p.f3956b.q("io.grpc.Context was cancelled without error");
        }
        if (cancellationCause instanceof TimeoutException) {
            return p.e.q(cancellationCause.getMessage()).p(cancellationCause);
        }
        p status = p.k(cancellationCause);
        if (!p.b.UNKNOWN.equals(status.m()) || status.l() != cancellationCause) {
            return status.p(cancellationCause);
        }
        return p.f3956b.q("Context cancelled").p(cancellationCause);
    }
}
