package io.grpc.internal;

import defpackage.b30;

abstract class g0 extends b30 {
    private final b30 a;

    g0(b30 delegate) {
        v90.o(delegate, "delegate can not be null");
        this.a = delegate;
    }

    public void d(b30.d listener) {
        this.a.d(listener);
    }

    public void c() {
        this.a.c();
    }

    public void b() {
        this.a.b();
    }

    public String toString() {
        return f20.c(this).d("delegate", this.a).toString();
    }
}
