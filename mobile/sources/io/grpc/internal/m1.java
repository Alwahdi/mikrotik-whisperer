package io.grpc.internal;

public final class m1 {
    private static final b a = new b(nr0.a);

    /* renamed from: a  reason: collision with other field name */
    private long f3519a;

    /* renamed from: a  reason: collision with other field name */
    private final cz f3520a;

    /* renamed from: a  reason: collision with other field name */
    private c f3521a;

    /* renamed from: a  reason: collision with other field name */
    private final nr0 f3522a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private volatile long h;

    public interface c {
    }

    private m1(nr0 timeProvider) {
        this.f3520a = p0.a();
        this.f3522a = timeProvider;
    }

    public void c() {
        this.f3519a++;
        this.b = this.f3522a.a();
    }

    public void f(boolean success) {
        if (success) {
            this.c++;
        } else {
            this.d++;
        }
    }

    public void e(int numMessages) {
        if (numMessages != 0) {
            this.f += (long) numMessages;
            this.g = this.f3522a.a();
        }
    }

    public void d() {
        this.f3520a.a(1);
        this.h = this.f3522a.a();
    }

    public void b() {
        this.e++;
    }

    public void g(c flowControlWindowReader) {
        this.f3521a = (c) v90.n(flowControlWindowReader);
    }

    public static final class b {
        private final nr0 a;

        public b(nr0 timeProvider) {
            this.a = timeProvider;
        }

        public m1 a() {
            return new m1(this.a);
        }
    }

    public static b a() {
        return a;
    }
}
