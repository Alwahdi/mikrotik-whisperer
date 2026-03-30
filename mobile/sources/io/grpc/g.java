package io.grpc;

import io.grpc.b;

public abstract class g<ReqT, RespT> extends n<ReqT, RespT> {
    /* access modifiers changed from: protected */
    public abstract b<ReqT, RespT> e();

    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    public /* bridge */ /* synthetic */ void b(int i) {
        super.b(i);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public void d(b.a<RespT> responseListener, l headers) {
        e().d(responseListener, headers);
    }

    public void c(ReqT message) {
        e().c(message);
    }
}
