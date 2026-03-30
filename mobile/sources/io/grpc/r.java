package io.grpc;

public class r extends RuntimeException {
    private final l a;

    /* renamed from: a  reason: collision with other field name */
    private final p f3962a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f3963a;

    public r(p status) {
        this(status, (l) null);
    }

    public r(p status, l trailers) {
        this(status, trailers, true);
    }

    r(p status, l trailers, boolean fillInStackTrace) {
        super(p.g(status), status.l());
        this.f3962a = status;
        this.a = trailers;
        this.f3963a = fillInStackTrace;
        fillInStackTrace();
    }

    public synchronized Throwable fillInStackTrace() {
        return this.f3963a ? super.fillInStackTrace() : this;
    }

    public final p a() {
        return this.f3962a;
    }
}
