package io.grpc.internal;

import defpackage.f9;
import io.grpc.p;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class v0 implements rn {
    private int a = -1;

    /* renamed from: a  reason: collision with other field name */
    private long f3741a;

    /* renamed from: a  reason: collision with other field name */
    private bw0 f3742a;

    /* renamed from: a  reason: collision with other field name */
    private final cn0 f3743a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final cw0 f3744a;

    /* renamed from: a  reason: collision with other field name */
    private final c f3745a = new c();

    /* renamed from: a  reason: collision with other field name */
    private final d f3746a;

    /* renamed from: a  reason: collision with other field name */
    private tb f3747a = f9.b.a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3748a = true;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f3749a = new byte[5];
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f3750b;
    private int c = -1;

    public interface d {
        void p(bw0 bw0, boolean z, boolean z2, int i);
    }

    public v0(d sink, cw0 bufferAllocator, cn0 statsTraceCtx) {
        this.f3746a = (d) v90.o(sink, "sink");
        this.f3744a = (cw0) v90.o(bufferAllocator, "bufferAllocator");
        this.f3743a = (cn0) v90.o(statsTraceCtx, "statsTraceCtx");
    }

    /* renamed from: j */
    public v0 b(tb compressor) {
        this.f3747a = (tb) v90.o(compressor, "Can't pass an empty compressor");
        return this;
    }

    public void a(int maxSize) {
        v90.u(this.a == -1, "max size already set");
        this.a = maxSize;
    }

    public void d(InputStream message) {
        int written;
        k();
        this.b++;
        int i = this.c + 1;
        this.c = i;
        this.f3741a = 0;
        this.f3743a.i(i);
        boolean compressed = this.f3748a && this.f3747a != f9.b.a;
        try {
            int messageLength = h(message);
            if (messageLength == 0 || !compressed) {
                written = q(message, messageLength);
            } else {
                written = m(message, messageLength);
            }
            if (messageLength == -1 || written == messageLength) {
                this.f3743a.k((long) written);
                this.f3743a.l(this.f3741a);
                this.f3743a.j(this.c, this.f3741a, (long) written);
                return;
            }
            throw p.o.q(String.format("Message length inaccurate %s != %s", new Object[]{Integer.valueOf(written), Integer.valueOf(messageLength)})).d();
        } catch (IOException e) {
            throw p.o.q("Failed to frame message").p(e).d();
        } catch (RuntimeException e2) {
            throw p.o.q("Failed to frame message").p(e2).d();
        }
    }

    private int q(InputStream message, int messageLength) {
        if (messageLength != -1) {
            this.f3741a = (long) messageLength;
            return n(message, messageLength);
        }
        b bufferChain = new b();
        int written = p(message, bufferChain);
        int i = this.a;
        if (i < 0 || written <= i) {
            l(bufferChain, false);
            return written;
        }
        throw p.j.q(String.format("message too large %d > %d", new Object[]{Integer.valueOf(written), Integer.valueOf(this.a)})).d();
    }

    /* JADX INFO: finally extract failed */
    private int m(InputStream message, int unusedMessageLength) {
        b bufferChain = new b();
        OutputStream compressingStream = this.f3747a.c(bufferChain);
        try {
            int written = p(message, compressingStream);
            compressingStream.close();
            int i = this.a;
            if (i < 0 || written <= i) {
                l(bufferChain, true);
                return written;
            }
            throw p.j.q(String.format("message too large %d > %d", new Object[]{Integer.valueOf(written), Integer.valueOf(this.a)})).d();
        } catch (Throwable th) {
            compressingStream.close();
            throw th;
        }
    }

    private int h(InputStream inputStream) {
        if ((inputStream instanceof hw) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    private int n(InputStream message, int messageLength) {
        int i = this.a;
        if (i < 0 || messageLength <= i) {
            ByteBuffer header = ByteBuffer.wrap(this.f3749a);
            header.put((byte) 0);
            header.putInt(messageLength);
            if (this.f3742a == null) {
                this.f3742a = this.f3744a.a(header.position() + messageLength);
            }
            o(this.f3749a, 0, header.position());
            return p(message, this.f3745a);
        }
        throw p.j.q(String.format("message too large %d > %d", new Object[]{Integer.valueOf(messageLength), Integer.valueOf(this.a)})).d();
    }

    private void l(b bufferChain, boolean compressed) {
        ByteBuffer header = ByteBuffer.wrap(this.f3749a);
        header.put(compressed);
        int messageLength = bufferChain.b();
        header.putInt(messageLength);
        bw0 writeableHeader = this.f3744a.a(5);
        writeableHeader.write(this.f3749a, 0, header.position());
        if (messageLength == 0) {
            this.f3742a = writeableHeader;
            return;
        }
        this.f3746a.p(writeableHeader, false, false, this.b - 1);
        this.b = 1;
        List<WritableBuffer> bufferList = bufferChain.f3752a;
        for (int i = 0; i < bufferList.size() - 1; i++) {
            this.f3746a.p((bw0) bufferList.get(i), false, false, 0);
        }
        this.f3742a = (bw0) bufferList.get(bufferList.size() - 1);
        this.f3741a = (long) messageLength;
    }

    private static int p(InputStream message, OutputStream outputStream) {
        if (message instanceof wh) {
            return ((wh) message).c(outputStream);
        }
        long written = z6.b(message, outputStream);
        v90.i(written <= 2147483647L, "Message size overflow: %s", written);
        return (int) written;
    }

    /* access modifiers changed from: private */
    public void o(byte[] b2, int off, int len) {
        while (len > 0) {
            bw0 bw0 = this.f3742a;
            if (bw0 != null && bw0.c() == 0) {
                g(false, false);
            }
            if (this.f3742a == null) {
                this.f3742a = this.f3744a.a(len);
            }
            int toWrite = Math.min(len, this.f3742a.c());
            this.f3742a.write(b2, off, toWrite);
            off += toWrite;
            len -= toWrite;
        }
    }

    public void flush() {
        bw0 bw0 = this.f3742a;
        if (bw0 != null && bw0.b() > 0) {
            g(false, true);
        }
    }

    public boolean c() {
        return this.f3750b;
    }

    public void close() {
        if (!c()) {
            this.f3750b = true;
            bw0 bw0 = this.f3742a;
            if (bw0 != null && bw0.b() == 0) {
                i();
            }
            g(true, true);
        }
    }

    private void i() {
        bw0 bw0 = this.f3742a;
        if (bw0 != null) {
            bw0.a();
            this.f3742a = null;
        }
    }

    private void g(boolean endOfStream, boolean flush) {
        bw0 buf = this.f3742a;
        this.f3742a = null;
        this.f3746a.p(buf, endOfStream, flush, this.b);
        this.b = 0;
    }

    private void k() {
        if (c()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    private class c extends OutputStream {
        private c() {
        }

        public void write(int b) {
            write(new byte[]{(byte) b}, 0, 1);
        }

        public void write(byte[] b, int off, int len) {
            v0.this.o(b, off, len);
        }
    }

    private final class b extends OutputStream {
        private bw0 a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final List<bw0> f3752a;

        private b() {
            this.f3752a = new ArrayList();
        }

        public void write(int b) {
            bw0 bw0 = this.a;
            if (bw0 == null || bw0.c() <= 0) {
                write(new byte[]{(byte) b}, 0, 1);
                return;
            }
            this.a.d((byte) b);
        }

        public void write(byte[] b, int off, int len) {
            if (this.a == null) {
                bw0 a2 = v0.this.f3744a.a(len);
                this.a = a2;
                this.f3752a.add(a2);
            }
            while (len > 0) {
                int canWrite = Math.min(len, this.a.c());
                if (canWrite == 0) {
                    bw0 a3 = v0.this.f3744a.a(Math.max(len, this.a.b() * 2));
                    this.a = a3;
                    this.f3752a.add(a3);
                } else {
                    this.a.write(b, off, canWrite);
                    off += canWrite;
                    len -= canWrite;
                }
            }
        }

        /* access modifiers changed from: private */
        public int b() {
            int readable = 0;
            for (bw0 writableBuffer : this.f3752a) {
                readable += writableBuffer.b();
            }
            return readable;
        }
    }
}
