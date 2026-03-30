package io.grpc;

public class q extends Exception {
    private final l a;

    /* renamed from: a  reason: collision with other field name */
    private final p f3960a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f3961a;

    public q(p status) {
        this(status, (l) null);
    }

    public q(p status, l trailers) {
        this(status, trailers, true);
    }

    q(p status, l trailers, boolean fillInStackTrace) {
        super(p.g(status), status.l());
        this.f3960a = status;
        this.a = trailers;
        this.f3961a = fillInStackTrace;
        fillInStackTrace();
    }

    public synchronized Throwable fillInStackTrace() {
        return this.f3961a ? super.fillInStackTrace() : this;
    }

    public final p a() {
        return this.f3960a;
    }
}
