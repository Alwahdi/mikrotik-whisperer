package io.grpc.internal;

import defpackage.f9;
import io.grpc.internal.k1;
import io.grpc.p;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;

public class u0 implements Closeable, xf {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f3699a;

    /* renamed from: a  reason: collision with other field name */
    private final cn0 f3700a;

    /* renamed from: a  reason: collision with other field name */
    private ff f3701a;

    /* renamed from: a  reason: collision with other field name */
    private i0 f3702a;

    /* renamed from: a  reason: collision with other field name */
    private final m1 f3703a;

    /* renamed from: a  reason: collision with other field name */
    private b f3704a;

    /* renamed from: a  reason: collision with other field name */
    private e f3705a = e.HEADER;

    /* renamed from: a  reason: collision with other field name */
    private sb f3706a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3707a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f3708a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private sb f3709b = new sb();

    /* renamed from: b  reason: collision with other field name */
    private boolean f3710b = false;
    private int c = 5;

    /* renamed from: c  reason: collision with other field name */
    private boolean f3711c = false;
    private int d = -1;

    /* renamed from: d  reason: collision with other field name */
    private volatile boolean f3712d = false;
    private int e;

    public interface b {
        void a(k1.a aVar);

        void c(boolean z);

        void d(Throwable th);

        void e(int i);
    }

    private enum e {
        HEADER,
        BODY
    }

    public u0(b listener, ff decompressor, int maxMessageSize, cn0 statsTraceCtx, m1 transportTracer) {
        this.f3704a = (b) v90.o(listener, "sink");
        this.f3701a = (ff) v90.o(decompressor, "decompressor");
        this.a = maxMessageSize;
        this.f3700a = (cn0) v90.o(statsTraceCtx, "statsTraceCtx");
        this.f3703a = (m1) v90.o(transportTracer, "transportTracer");
    }

    /* access modifiers changed from: package-private */
    public void b0(b listener) {
        this.f3704a = listener;
    }

    public void c(int messageSize) {
        this.a = messageSize;
    }

    public void q(ff decompressor) {
        v90.u(this.f3702a == null, "Already set full stream decompressor");
        this.f3701a = (ff) v90.o(decompressor, "Can't pass an empty decompressor");
    }

    public void a0(i0 fullStreamDecompressor) {
        boolean z = true;
        v90.u(this.f3701a == f9.b.a, "per-message decompressor already set");
        if (this.f3702a != null) {
            z = false;
        }
        v90.u(z, "full stream decompressor already set");
        this.f3702a = (i0) v90.o(fullStreamDecompressor, "Can't pass a null full stream decompressor");
        this.f3709b = null;
    }

    public void f(int numMessages) {
        v90.e(numMessages > 0, "numMessages must be > 0");
        if (!P()) {
            this.f3699a += (long) numMessages;
            C();
        }
    }

    public void o(id0 data) {
        v90.o(data, "data");
        boolean needToCloseData = true;
        try {
            if (!U()) {
                i0 i0Var = this.f3702a;
                if (i0Var != null) {
                    i0Var.K(data);
                } else {
                    this.f3709b.f(data);
                }
                needToCloseData = false;
                C();
            }
        } finally {
            if (needToCloseData) {
                data.close();
            }
        }
    }

    public void w() {
        if (!P()) {
            if (V()) {
                close();
            } else {
                this.f3711c = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c0() {
        this.f3712d = true;
    }

    /* JADX INFO: finally extract failed */
    public void close() {
        if (!P()) {
            sb sbVar = this.f3706a;
            boolean z = true;
            boolean hasPartialMessage = sbVar != null && sbVar.b() > 0;
            try {
                i0 i0Var = this.f3702a;
                if (i0Var != null) {
                    if (!hasPartialMessage) {
                        if (!i0Var.X()) {
                            z = false;
                        }
                    }
                    hasPartialMessage = z;
                    this.f3702a.close();
                }
                sb sbVar2 = this.f3709b;
                if (sbVar2 != null) {
                    sbVar2.close();
                }
                sb sbVar3 = this.f3706a;
                if (sbVar3 != null) {
                    sbVar3.close();
                }
                this.f3702a = null;
                this.f3709b = null;
                this.f3706a = null;
                this.f3704a.c(hasPartialMessage);
            } catch (Throwable th) {
                this.f3702a = null;
                this.f3709b = null;
                this.f3706a = null;
                throw th;
            }
        }
    }

    public boolean P() {
        return this.f3709b == null && this.f3702a == null;
    }

    private boolean U() {
        return P() || this.f3711c;
    }

    private boolean V() {
        i0 i0Var = this.f3702a;
        if (i0Var != null) {
            return i0Var.b0();
        }
        return this.f3709b.b() == 0;
    }

    private void C() {
        if (!this.f3710b) {
            this.f3710b = true;
            while (!this.f3712d && this.f3699a > 0 && Z()) {
                try {
                    switch (a.a[this.f3705a.ordinal()]) {
                        case 1:
                            Y();
                            break;
                        case 2:
                            X();
                            this.f3699a--;
                            break;
                        default:
                            throw new AssertionError("Invalid state: " + this.f3705a);
                    }
                } finally {
                    this.f3710b = false;
                }
            }
            if (this.f3712d) {
                close();
                return;
            }
            if (this.f3711c && V()) {
                close();
            }
            this.f3710b = false;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            try {
                iArr[e.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[e.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private boolean Z() {
        int totalBytesRead = 0;
        int deflatedBytesRead = 0;
        try {
            if (this.f3706a == null) {
                this.f3706a = new sb();
            }
            while (true) {
                int b2 = this.c - this.f3706a.b();
                int missingBytes = b2;
                if (b2 <= 0) {
                    if (totalBytesRead > 0) {
                        this.f3704a.e(totalBytesRead);
                        if (this.f3705a == e.BODY) {
                            if (this.f3702a != null) {
                                this.f3700a.g((long) deflatedBytesRead);
                                this.e += deflatedBytesRead;
                            } else {
                                this.f3700a.g((long) totalBytesRead);
                                this.e += totalBytesRead;
                            }
                        }
                    }
                    return true;
                } else if (this.f3702a != null) {
                    byte[] bArr = this.f3708a;
                    if (bArr == null || this.b == bArr.length) {
                        this.f3708a = new byte[Math.min(missingBytes, 2097152)];
                        this.b = 0;
                    }
                    int n = this.f3702a.Z(this.f3708a, this.b, Math.min(missingBytes, this.f3708a.length - this.b));
                    totalBytesRead += this.f3702a.U();
                    deflatedBytesRead += this.f3702a.V();
                    if (n == 0) {
                        if (totalBytesRead > 0) {
                            this.f3704a.e(totalBytesRead);
                            if (this.f3705a == e.BODY) {
                                if (this.f3702a != null) {
                                    this.f3700a.g((long) deflatedBytesRead);
                                    this.e += deflatedBytesRead;
                                } else {
                                    this.f3700a.g((long) totalBytesRead);
                                    this.e += totalBytesRead;
                                }
                            }
                        }
                        return false;
                    }
                    this.f3706a.f(jd0.e(this.f3708a, this.b, n));
                    this.b += n;
                } else if (this.f3709b.b() == 0) {
                    if (totalBytesRead > 0) {
                        this.f3704a.e(totalBytesRead);
                        if (this.f3705a == e.BODY) {
                            if (this.f3702a != null) {
                                this.f3700a.g((long) deflatedBytesRead);
                                this.e += deflatedBytesRead;
                            } else {
                                this.f3700a.g((long) totalBytesRead);
                                this.e += totalBytesRead;
                            }
                        }
                    }
                    return false;
                } else {
                    int toRead = Math.min(missingBytes, this.f3709b.b());
                    totalBytesRead += toRead;
                    this.f3706a.f(this.f3709b.v(toRead));
                }
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        } catch (DataFormatException e3) {
            throw new RuntimeException(e3);
        } catch (Throwable th) {
            if (totalBytesRead > 0) {
                this.f3704a.e(totalBytesRead);
                if (this.f3705a == e.BODY) {
                    if (this.f3702a != null) {
                        this.f3700a.g((long) deflatedBytesRead);
                        this.e += deflatedBytesRead;
                    } else {
                        this.f3700a.g((long) totalBytesRead);
                        this.e += totalBytesRead;
                    }
                }
            }
            throw th;
        }
    }

    private void Y() {
        int type = this.f3706a.readUnsignedByte();
        if ((type & 254) == 0) {
            this.f3707a = (type & 1) != 0;
            int readInt = this.f3706a.readInt();
            this.c = readInt;
            if (readInt < 0 || readInt > this.a) {
                throw p.j.q(String.format("gRPC message exceeds maximum size %d: %d", new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.c)})).d();
            }
            int i = this.d + 1;
            this.d = i;
            this.f3700a.d(i);
            this.f3703a.d();
            this.f3705a = e.BODY;
            return;
        }
        throw p.o.q("gRPC frame header malformed: reserved bits not zero").d();
    }

    private void X() {
        this.f3700a.e(this.d, (long) this.e, -1);
        this.e = 0;
        InputStream stream = this.f3707a ? J() : K();
        this.f3706a = null;
        this.f3704a.a(new c(stream, (a) null));
        this.f3705a = e.HEADER;
        this.c = 5;
    }

    private InputStream K() {
        this.f3700a.f((long) this.f3706a.b());
        return jd0.b(this.f3706a, true);
    }

    private InputStream J() {
        ff ffVar = this.f3701a;
        if (ffVar != f9.b.a) {
            try {
                return new d(ffVar.b(jd0.b(this.f3706a, true)), this.a, this.f3700a);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            throw p.o.q("Can't decode compressed gRPC message as compression not configured").d();
        }
    }

    static final class d extends FilterInputStream {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private long f3713a;

        /* renamed from: a  reason: collision with other field name */
        private final cn0 f3714a;
        private long b;
        private long c = -1;

        d(InputStream in, int maxMessageSize, cn0 statsTraceCtx) {
            super(in);
            this.a = maxMessageSize;
            this.f3714a = statsTraceCtx;
        }

        public int read() {
            int result = this.in.read();
            if (result != -1) {
                this.b++;
            }
            f();
            c();
            return result;
        }

        public int read(byte[] b2, int off, int len) {
            int result = this.in.read(b2, off, len);
            if (result != -1) {
                this.b += (long) result;
            }
            f();
            c();
            return result;
        }

        public long skip(long n) {
            long result = this.in.skip(n);
            this.b += result;
            f();
            c();
            return result;
        }

        public synchronized void mark(int readlimit) {
            this.in.mark(readlimit);
            this.c = this.b;
        }

        public synchronized void reset() {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.c != -1) {
                this.in.reset();
                this.b = this.c;
            } else {
                throw new IOException("Mark not set");
            }
        }

        private void c() {
            long j = this.b;
            long j2 = this.f3713a;
            if (j > j2) {
                this.f3714a.f(j - j2);
                this.f3713a = this.b;
            }
        }

        private void f() {
            long j = this.b;
            int i = this.a;
            if (j > ((long) i)) {
                throw p.j.q(String.format("Compressed gRPC message exceeds maximum size %d: %d bytes read", new Object[]{Integer.valueOf(i), Long.valueOf(this.b)})).d();
            }
        }
    }

    private static class c implements k1.a {
        private InputStream a;

        /* synthetic */ c(InputStream x0, a x1) {
            this(x0);
        }

        private c(InputStream message) {
            this.a = message;
        }

        public InputStream c() {
            InputStream messageToReturn = this.a;
            this.a = null;
            return messageToReturn;
        }
    }
}
