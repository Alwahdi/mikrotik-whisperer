package io.grpc.internal;

import io.grpc.b;
import io.grpc.e;
import io.grpc.m;

abstract class f0 extends rz {
    private final rz a;

    f0(rz delegate) {
        this.a = delegate;
    }

    public rz m() {
        return this.a.m();
    }

    public <RequestT, ResponseT> b<RequestT, ResponseT> h(m<RequestT, ResponseT> methodDescriptor, n7 callOptions) {
        return this.a.h(methodDescriptor, callOptions);
    }

    public String a() {
        return this.a.a();
    }

    public e j(boolean requestConnection) {
        return this.a.j(requestConnection);
    }

    public void k(e source, Runnable callback) {
        this.a.k(source, callback);
    }

    public void l() {
        this.a.l();
    }

    public void i() {
        this.a.i();
    }

    public String toString() {
        return f20.c(this).d("delegate", this.a).toString();
    }
}
