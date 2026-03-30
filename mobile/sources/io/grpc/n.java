package io.grpc;

abstract class n<ReqT, RespT> extends b<ReqT, RespT> {
    /* access modifiers changed from: protected */
    public abstract b<?, ?> e();

    n() {
    }

    public void b(int numMessages) {
        e().b(numMessages);
    }

    public void a() {
        e().a();
    }

    public String toString() {
        return f20.c(this).d("delegate", e()).toString();
    }
}
