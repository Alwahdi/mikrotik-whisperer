package io.grpc.internal;

import io.grpc.internal.o;
import io.grpc.l;
import io.grpc.m;
import io.grpc.p;

class a0 implements p {
    private final o.a a;

    /* renamed from: a  reason: collision with other field name */
    final p f3291a;

    a0(p error, o.a rpcProgress) {
        v90.e(!error.o(), "error must not be OK");
        this.f3291a = error;
        this.a = rpcProgress;
    }

    public z8 f(m<?, ?> mVar, l headers, n7 callOptions) {
        return new z(this.f3291a, this.a);
    }

    public hu b() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
