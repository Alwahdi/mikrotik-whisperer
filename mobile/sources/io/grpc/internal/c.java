package io.grpc.internal;

import defpackage.f9;
import io.grpc.internal.e;
import io.grpc.internal.k1;
import io.grpc.internal.u0;
import java.io.InputStream;

public abstract class c implements kn0 {
    /* access modifiers changed from: protected */
    public abstract rn r();

    /* access modifiers changed from: protected */
    public abstract a t();

    public void o() {
        t().s();
    }

    public final void f(int numMessages) {
        t().t(numMessages);
    }

    public final void g(InputStream message) {
        v90.o(message, "message");
        try {
            if (!r().c()) {
                r().d(message);
            }
        } finally {
            h0.d(message);
        }
    }

    public final void flush() {
        if (!r().c()) {
            r().flush();
        }
    }

    /* access modifiers changed from: protected */
    public final void q() {
        r().close();
    }

    public final void e(tb compressor) {
        r().b((tb) v90.o(compressor, "compressor"));
    }

    /* access modifiers changed from: protected */
    public final void s(int numBytes) {
        t().o(numBytes);
    }

    public static abstract class a implements e.h, u0.b {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private final cn0 f3331a;

        /* renamed from: a  reason: collision with other field name */
        private final m1 f3332a;

        /* renamed from: a  reason: collision with other field name */
        private final u0 f3333a;

        /* renamed from: a  reason: collision with other field name */
        private final Object f3334a = new Object();
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public xf f3335a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f3336a;
        private boolean b;

        /* access modifiers changed from: protected */
        public abstract k1 m();

        protected a(int maxMessageSize, cn0 statsTraceCtx, m1 transportTracer) {
            this.f3331a = (cn0) v90.o(statsTraceCtx, "statsTraceCtx");
            this.f3332a = (m1) v90.o(transportTracer, "transportTracer");
            u0 u0Var = new u0(this, f9.b.a, maxMessageSize, statsTraceCtx, transportTracer);
            this.f3333a = u0Var;
            this.f3335a = u0Var;
        }

        /* access modifiers changed from: package-private */
        public final void s() {
            this.f3333a.b0(this);
            this.f3335a = this.f3333a;
        }

        /* access modifiers changed from: protected */
        public void v(i0 fullStreamDecompressor) {
            this.f3333a.a0(fullStreamDecompressor);
            this.f3335a = new e(this, this, this.f3333a);
        }

        /* access modifiers changed from: package-private */
        public final void w(int maxSize) {
            this.f3335a.c(maxSize);
        }

        public void a(k1.a producer) {
            m().a(producer);
        }

        /* access modifiers changed from: protected */
        public final void i(boolean stopDelivery) {
            if (stopDelivery) {
                this.f3335a.close();
            } else {
                this.f3335a.w();
            }
        }

        /* access modifiers changed from: protected */
        public final void j(id0 frame) {
            try {
                this.f3335a.o(frame);
            } catch (Throwable t) {
                d(t);
            }
        }

        /* access modifiers changed from: private */
        public void t(int numMessages) {
            b(new C0043a(a90.e(), numMessages));
        }

        /* renamed from: io.grpc.internal.c$a$a  reason: collision with other inner class name */
        class C0043a implements Runnable {
            final /* synthetic */ int a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ hx f3337a;

            C0043a(hx hxVar, int i) {
                this.f3337a = hxVar;
                this.a = i;
            }

            public void run() {
                a90.f("AbstractStream.request");
                a90.d(this.f3337a);
                try {
                    a.this.f3335a.f(this.a);
                } catch (Throwable th) {
                    a90.h("AbstractStream.request");
                    throw th;
                }
                a90.h("AbstractStream.request");
            }
        }

        /* access modifiers changed from: protected */
        public final void u(ff decompressor) {
            this.f3335a.q(decompressor);
        }

        private boolean l() {
            boolean z;
            synchronized (this.f3334a) {
                z = this.f3336a && this.a < 32768 && !this.b;
            }
            return z;
        }

        /* access modifiers changed from: protected */
        public void q() {
            boolean z = false;
            v90.t(m() != null);
            synchronized (this.f3334a) {
                if (!this.f3336a) {
                    z = true;
                }
                v90.u(z, "Already allocated");
                this.f3336a = true;
            }
            n();
        }

        /* access modifiers changed from: protected */
        public final void r() {
            synchronized (this.f3334a) {
                this.b = true;
            }
        }

        /* access modifiers changed from: private */
        public void o(int numBytes) {
            synchronized (this.f3334a) {
                this.a += numBytes;
            }
        }

        public final void p(int numBytes) {
            boolean belowThresholdAfter;
            synchronized (this.f3334a) {
                v90.u(this.f3336a, "onStreamAllocated was not called, but it seems the stream is active");
                int i = this.a;
                boolean z = true;
                boolean belowThresholdBefore = i < 32768;
                int i2 = i - numBytes;
                this.a = i2;
                boolean belowThresholdAfter2 = i2 < 32768;
                if (belowThresholdBefore || !belowThresholdAfter2) {
                    z = false;
                }
                belowThresholdAfter = z;
            }
            if (belowThresholdAfter) {
                n();
            }
        }

        /* access modifiers changed from: protected */
        public m1 k() {
            return this.f3332a;
        }

        private void n() {
            boolean doNotify;
            synchronized (this.f3334a) {
                doNotify = l();
            }
            if (doNotify) {
                m().b();
            }
        }
    }
}
