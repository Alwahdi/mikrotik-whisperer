package io.grpc.internal;

import io.grpc.internal.f;
import io.grpc.internal.k1;
import io.grpc.internal.u0;
import java.io.Closeable;
import java.io.InputStream;

public class e implements xf {
    /* access modifiers changed from: private */
    public final f a;

    /* renamed from: a  reason: collision with other field name */
    private final u0.b f3395a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final u0 f3396a;

    interface h extends f.d {
    }

    e(u0.b listener, h transportExecutor, u0 deframer) {
        j1 j1Var = new j1((u0.b) v90.o(listener, "listener"));
        this.f3395a = j1Var;
        f fVar = new f(j1Var, transportExecutor);
        this.a = fVar;
        deframer.b0(fVar);
        this.f3396a = deframer;
    }

    public void c(int messageSize) {
        this.f3396a.c(messageSize);
    }

    public void q(ff decompressor) {
        this.f3396a.q(decompressor);
    }

    public void f(int numMessages) {
        this.f3395a.a(new g(this, new a(numMessages), (a) null));
    }

    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void run() {
            if (!e.this.f3396a.P()) {
                try {
                    e.this.f3396a.f(this.a);
                } catch (Throwable t) {
                    e.this.a.d(t);
                    e.this.f3396a.close();
                }
            }
        }
    }

    public void o(id0 data) {
        this.f3395a.a(new f(new b(data), new c(data)));
    }

    class b implements Runnable {
        final /* synthetic */ id0 a;

        b(id0 id0) {
            this.a = id0;
        }

        public void run() {
            try {
                e.this.f3396a.o(this.a);
            } catch (Throwable t) {
                e.this.a.d(t);
                e.this.f3396a.close();
            }
        }
    }

    class c implements Closeable {
        final /* synthetic */ id0 a;

        c(id0 id0) {
            this.a = id0;
        }

        public void close() {
            this.a.close();
        }
    }

    public void w() {
        this.f3395a.a(new g(this, new d(), (a) null));
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            e.this.f3396a.w();
        }
    }

    public void close() {
        this.f3396a.c0();
        this.f3395a.a(new g(this, new C0044e(), (a) null));
    }

    /* renamed from: io.grpc.internal.e$e  reason: collision with other inner class name */
    class C0044e implements Runnable {
        C0044e() {
        }

        public void run() {
            e.this.f3396a.close();
        }
    }

    private class g implements k1.a {

        /* renamed from: a  reason: collision with other field name */
        private final Runnable f3400a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f3401a;

        /* synthetic */ g(e x0, Runnable x1, a x2) {
            this(x1);
        }

        private g(Runnable runnable) {
            this.f3401a = false;
            this.f3400a = runnable;
        }

        private void f() {
            if (!this.f3401a) {
                this.f3400a.run();
                this.f3401a = true;
            }
        }

        public InputStream c() {
            f();
            return e.this.a.f();
        }
    }

    private class f extends g implements Closeable {
        private final Closeable a;

        public f(Runnable runnable, Closeable closeable) {
            super(e.this, runnable, (a) null);
            this.a = closeable;
        }

        public void close() {
            this.a.close();
        }
    }
}
