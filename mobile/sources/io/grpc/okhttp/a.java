package io.grpc.okhttp;

import io.grpc.okhttp.b;
import java.io.IOException;
import java.net.Socket;

final class a implements fm0 {
    /* access modifiers changed from: private */
    public fm0 a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final b.a f3819a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Object f3820a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Socket f3821a;

    /* renamed from: a  reason: collision with other field name */
    private final mk0 f3822a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final r6 f3823a = new r6();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f3824a = false;
    /* access modifiers changed from: private */
    public boolean b = false;
    private boolean c = false;

    private a(mk0 executor, b.a exceptionHandler) {
        this.f3822a = (mk0) v90.o(executor, "executor");
        this.f3819a = (b.a) v90.o(exceptionHandler, "exceptionHandler");
    }

    static a P(mk0 executor, b.a exceptionHandler) {
        return new a(executor, exceptionHandler);
    }

    /* access modifiers changed from: package-private */
    public void K(fm0 sink, Socket socket) {
        v90.u(this.a == null, "AsyncSink's becomeConnected should only be called once.");
        this.a = (fm0) v90.o(sink, "sink");
        this.f3821a = (Socket) v90.o(socket, "socket");
    }

    public void G(r6 source, long byteCount) {
        v90.o(source, "source");
        if (!this.c) {
            a90.f("AsyncSink.write");
            try {
                synchronized (this.f3820a) {
                    this.f3823a.G(source, byteCount);
                    if (!this.f3824a && !this.b) {
                        if (this.f3823a.J() > 0) {
                            this.f3824a = true;
                            this.f3822a.execute(new C0047a());
                            a90.h("AsyncSink.write");
                            return;
                        }
                    }
                    a90.h("AsyncSink.write");
                }
            } catch (Throwable th) {
                a90.h("AsyncSink.write");
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: io.grpc.okhttp.a$a  reason: collision with other inner class name */
    class C0047a extends d {
        final hx a = a90.e();

        C0047a() {
            super(a.this, (C0047a) null);
        }

        public void a() {
            a90.f("WriteRunnable.runWrite");
            a90.d(this.a);
            r6 buf = new r6();
            try {
                synchronized (a.this.f3820a) {
                    buf.G(a.this.f3823a, a.this.f3823a.J());
                    boolean unused = a.this.f3824a = false;
                }
                a.this.a.G(buf, buf.g0());
                a90.h("WriteRunnable.runWrite");
            } catch (Throwable th) {
                a90.h("WriteRunnable.runWrite");
                throw th;
            }
        }
    }

    public void flush() {
        if (!this.c) {
            a90.f("AsyncSink.flush");
            try {
                synchronized (this.f3820a) {
                    if (this.b) {
                        a90.h("AsyncSink.flush");
                        return;
                    }
                    this.b = true;
                    this.f3822a.execute(new b());
                    a90.h("AsyncSink.flush");
                }
            } catch (Throwable th) {
                a90.h("AsyncSink.flush");
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    class b extends d {
        final hx a = a90.e();

        b() {
            super(a.this, (C0047a) null);
        }

        public void a() {
            a90.f("WriteRunnable.runFlush");
            a90.d(this.a);
            r6 buf = new r6();
            try {
                synchronized (a.this.f3820a) {
                    buf.G(a.this.f3823a, a.this.f3823a.g0());
                    boolean unused = a.this.b = false;
                }
                a.this.a.G(buf, buf.g0());
                a.this.a.flush();
                a90.h("WriteRunnable.runFlush");
            } catch (Throwable th) {
                a90.h("WriteRunnable.runFlush");
                throw th;
            }
        }
    }

    public void close() {
        if (!this.c) {
            this.c = true;
            this.f3822a.execute(new c());
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            a.this.f3823a.close();
            try {
                if (a.this.a != null) {
                    a.this.a.close();
                }
            } catch (IOException e) {
                a.this.f3819a.a(e);
            }
            try {
                if (a.this.f3821a != null) {
                    a.this.f3821a.close();
                }
            } catch (IOException e2) {
                a.this.f3819a.a(e2);
            }
        }
    }

    private abstract class d implements Runnable {
        public abstract void a();

        private d() {
        }

        /* synthetic */ d(a x0, C0047a x1) {
            this();
        }

        public final void run() {
            try {
                if (a.this.a != null) {
                    a();
                    return;
                }
                throw new IOException("Unable to perform write due to unavailable sink.");
            } catch (Exception e) {
                a.this.f3819a.a(e);
            }
        }
    }
}
