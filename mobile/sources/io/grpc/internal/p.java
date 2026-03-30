package io.grpc.internal;

import io.grpc.l;
import io.grpc.m;
import java.util.concurrent.Executor;

public interface p extends gu<Object> {

    public interface a {
        void a(long j);

        void b(Throwable th);
    }

    z8 f(m<?, ?> mVar, l lVar, n7 n7Var);

    void g(a aVar, Executor executor);
}
