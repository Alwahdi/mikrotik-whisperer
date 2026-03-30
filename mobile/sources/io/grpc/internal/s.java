package io.grpc.internal;

abstract class s implements Runnable {
    private final qc a;

    public abstract void a();

    protected s(qc context) {
        this.a = context;
    }

    public final void run() {
        qc previous = this.a.b();
        try {
            a();
        } finally {
            this.a.f(previous);
        }
    }
}
