package io.grpc.internal;

import io.grpc.internal.k1;
import io.grpc.internal.o;
import io.grpc.l;
import io.grpc.p;

abstract class c0 implements o {
    /* access modifiers changed from: protected */
    public abstract o f();

    c0() {
    }

    public void e(l headers) {
        f().e(headers);
    }

    public void d(p status, l trailers) {
        f().d(status, trailers);
    }

    public void c(p status, o.a rpcProgress, l trailers) {
        f().c(status, rpcProgress, trailers);
    }

    public void a(k1.a producer) {
        f().a(producer);
    }

    public void b() {
        f().b();
    }

    public String toString() {
        return f20.c(this).d("delegate", f()).toString();
    }
}
