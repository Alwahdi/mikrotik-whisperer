package io.grpc.okhttp;

import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import java.io.IOException;

class o {
    private int a = SupportMenu.USER_MASK;

    /* renamed from: a  reason: collision with other field name */
    private final g f3945a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final b f3946a = new b(0, (int) SupportMenu.USER_MASK);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final qn f3947a;

    o(g transport, qn frameWriter) {
        this.f3945a = (g) v90.o(transport, NotificationCompat.CATEGORY_TRANSPORT);
        this.f3947a = (qn) v90.o(frameWriter, "frameWriter");
    }

    /* access modifiers changed from: package-private */
    public boolean e(int newWindowSize) {
        if (newWindowSize >= 0) {
            int delta = newWindowSize - this.a;
            this.a = newWindowSize;
            for (f stream : this.f3945a.U()) {
                b state = (b) stream.N();
                if (state == null) {
                    stream.Q(new b(this, stream, this.a));
                } else {
                    state.f(delta);
                }
            }
            if (delta > 0) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Invalid initial window size: " + newWindowSize);
    }

    /* access modifiers changed from: package-private */
    public int g(f stream, int delta) {
        if (stream == null) {
            int updatedWindow = this.f3946a.f(delta);
            h();
            return updatedWindow;
        }
        b state = f(stream);
        int updatedWindow2 = state.f(delta);
        c writeStatus = new c();
        state.l(state.j(), writeStatus);
        if (writeStatus.a()) {
            d();
        }
        return updatedWindow2;
    }

    /* access modifiers changed from: package-private */
    public void c(boolean outFinished, int streamId, r6 source, boolean flush) {
        v90.o(source, "source");
        f stream = this.f3945a.Z(streamId);
        if (stream != null) {
            b state = f(stream);
            int window = state.j();
            boolean framesAlreadyQueued = state.e();
            int size = (int) source.g0();
            if (framesAlreadyQueued || window < size) {
                if (!framesAlreadyQueued && window > 0) {
                    state.k(source, window, false);
                }
                state.d(source, (int) source.g0(), outFinished);
            } else {
                state.k(source, size, outFinished);
            }
            if (flush) {
                d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        try {
            this.f3947a.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private b f(f stream) {
        b state = (b) stream.N();
        if (state != null) {
            return state;
        }
        b state2 = new b(this, stream, this.a);
        stream.Q(state2);
        return state2;
    }

    /* access modifiers changed from: package-private */
    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void h() {
        /*
            r10 = this;
            io.grpc.okhttp.g r0 = r10.f3945a
            io.grpc.okhttp.f[] r0 = r0.U()
            io.grpc.okhttp.o$b r1 = r10.f3946a
            int r1 = r1.i()
            int r2 = r0.length
        L_0x000d:
            if (r2 <= 0) goto L_0x0048
            if (r1 <= 0) goto L_0x0048
            r3 = 0
            float r4 = (float) r1
            float r5 = (float) r2
            float r4 = r4 / r5
            double r4 = (double) r4
            double r4 = java.lang.Math.ceil(r4)
            int r4 = (int) r4
            r5 = 0
        L_0x001c:
            if (r5 >= r2) goto L_0x0046
            if (r1 <= 0) goto L_0x0046
            r6 = r0[r5]
            io.grpc.okhttp.o$b r7 = r10.f(r6)
            int r8 = r7.h()
            int r8 = java.lang.Math.min(r8, r4)
            int r8 = java.lang.Math.min(r1, r8)
            if (r8 <= 0) goto L_0x0038
            r7.a(r8)
            int r1 = r1 - r8
        L_0x0038:
            int r9 = r7.h()
            if (r9 <= 0) goto L_0x0043
            int r9 = r3 + 1
            r0[r3] = r6
            r3 = r9
        L_0x0043:
            int r5 = r5 + 1
            goto L_0x001c
        L_0x0046:
            r2 = r3
            goto L_0x000d
        L_0x0048:
            io.grpc.okhttp.o$c r2 = new io.grpc.okhttp.o$c
            r3 = 0
            r2.<init>()
            io.grpc.okhttp.g r3 = r10.f3945a
            io.grpc.okhttp.f[] r3 = r3.U()
            int r4 = r3.length
            r5 = 0
        L_0x0056:
            if (r5 >= r4) goto L_0x006b
            r6 = r3[r5]
            io.grpc.okhttp.o$b r7 = r10.f(r6)
            int r8 = r7.b()
            r7.l(r8, r2)
            r7.c()
            int r5 = r5 + 1
            goto L_0x0056
        L_0x006b:
            boolean r3 = r2.a()
            if (r3 == 0) goto L_0x0074
            r10.d()
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.o.h():void");
    }

    private static final class c {
        int a;

        private c() {
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.a++;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.a > 0;
        }
    }

    private final class b {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        f f3948a;

        /* renamed from: a  reason: collision with other field name */
        final r6 f3950a;

        /* renamed from: a  reason: collision with other field name */
        boolean f3951a;
        int b;
        int c;

        b(int streamId, int initialWindowSize) {
            this.f3951a = false;
            this.a = streamId;
            this.b = initialWindowSize;
            this.f3950a = new r6();
        }

        b(o oVar, f stream, int initialWindowSize) {
            this(stream.P(), initialWindowSize);
            this.f3948a = stream;
        }

        /* access modifiers changed from: package-private */
        public int i() {
            return this.b;
        }

        /* access modifiers changed from: package-private */
        public void a(int bytes) {
            this.c += bytes;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public int h() {
            return g() - this.c;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.c = 0;
        }

        /* access modifiers changed from: package-private */
        public int f(int delta) {
            if (delta <= 0 || Integer.MAX_VALUE - delta >= this.b) {
                int i = this.b + delta;
                this.b = i;
                return i;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.a);
        }

        /* access modifiers changed from: package-private */
        public int j() {
            return Math.min(this.b, o.this.f3946a.i());
        }

        /* access modifiers changed from: package-private */
        public int g() {
            return Math.max(0, Math.min(this.b, (int) this.f3950a.g0()));
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            return this.f3950a.g0() > 0;
        }

        /* access modifiers changed from: package-private */
        public int l(int bytes, c writeStatus) {
            int bytesAttempted = 0;
            int maxBytes = Math.min(bytes, j());
            while (e() && maxBytes > 0) {
                if (((long) maxBytes) >= this.f3950a.g0()) {
                    bytesAttempted += (int) this.f3950a.g0();
                    r6 r6Var = this.f3950a;
                    k(r6Var, (int) r6Var.g0(), this.f3951a);
                } else {
                    bytesAttempted += maxBytes;
                    k(this.f3950a, maxBytes, false);
                }
                writeStatus.b();
                maxBytes = Math.min(bytes - bytesAttempted, j());
            }
            return bytesAttempted;
        }

        /* access modifiers changed from: package-private */
        public void k(r6 buffer, int bytesToSend, boolean endOfStream) {
            int bytesToWrite = bytesToSend;
            do {
                int frameBytes = Math.min(bytesToWrite, o.this.f3947a.t());
                o.this.f3946a.f(-frameBytes);
                f(-frameBytes);
                try {
                    o.this.f3947a.E(buffer.g0() == ((long) frameBytes) && endOfStream, this.a, buffer, frameBytes);
                    this.f3948a.y().p(frameBytes);
                    bytesToWrite -= frameBytes;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } while (bytesToWrite > 0);
        }

        /* access modifiers changed from: package-private */
        public void d(r6 buffer, int size, boolean endOfStream) {
            this.f3950a.G(buffer, (long) size);
            this.f3951a |= endOfStream;
        }
    }
}
