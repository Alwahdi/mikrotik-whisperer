package io.grpc.internal;

import io.grpc.internal.k1;
import io.grpc.internal.u0;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

final class f implements u0.b {
    private final d a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final u0.b f3404a;

    /* renamed from: a  reason: collision with other field name */
    private final Queue<InputStream> f3405a = new ArrayDeque();

    public interface d {
        void b(Runnable runnable);
    }

    public f(u0.b listener, d transportExecutor) {
        this.f3404a = (u0.b) v90.o(listener, "listener");
        this.a = (d) v90.o(transportExecutor, "transportExecutor");
    }

    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void run() {
            f.this.f3404a.e(this.a);
        }
    }

    public void e(int numBytes) {
        this.a.b(new a(numBytes));
    }

    public void a(k1.a producer) {
        while (true) {
            InputStream c2 = producer.c();
            InputStream message = c2;
            if (c2 != null) {
                this.f3405a.add(message);
            } else {
                return;
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ boolean f3407a;

        b(boolean z) {
            this.f3407a = z;
        }

        public void run() {
            f.this.f3404a.c(this.f3407a);
        }
    }

    public void c(boolean hasPartialMessage) {
        this.a.b(new b(hasPartialMessage));
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Throwable f3408a;

        c(Throwable th) {
            this.f3408a = th;
        }

        public void run() {
            f.this.f3404a.d(this.f3408a);
        }
    }

    public void d(Throwable cause) {
        this.a.b(new c(cause));
    }

    public InputStream f() {
        return this.f3405a.poll();
    }
}
