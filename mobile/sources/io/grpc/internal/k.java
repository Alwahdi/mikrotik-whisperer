package io.grpc.internal;

final class k {
    static final b a = new a();

    /* renamed from: a  reason: collision with other field name */
    private volatile long f3462a;

    /* renamed from: a  reason: collision with other field name */
    private final cz f3463a = p0.a();

    /* renamed from: a  reason: collision with other field name */
    private final nr0 f3464a;
    private final cz b = p0.a();
    private final cz c = p0.a();

    public interface b {
        k a();
    }

    k(nr0 timeProvider) {
        this.f3464a = timeProvider;
    }

    public void b() {
        this.f3463a.a(1);
        this.f3462a = this.f3464a.a();
    }

    public void a(boolean success) {
        if (success) {
            this.b.a(1);
        } else {
            this.c.a(1);
        }
    }

    class a implements b {
        a() {
        }

        public k a() {
            return new k(nr0.a);
        }
    }
}
