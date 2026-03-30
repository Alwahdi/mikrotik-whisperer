package defpackage;

import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: jd0  reason: default package */
public abstract class jd0 {
    private static final id0 a = new c(new byte[0]);

    public static id0 e(byte[] bytes, int offset, int length) {
        return new c(bytes, offset, length);
    }

    public static byte[] c(id0 buffer) {
        v90.o(buffer, "buffer");
        int length = buffer.b();
        byte[] bytes = new byte[length];
        buffer.m(bytes, 0, length);
        return bytes;
    }

    public static String d(id0 buffer, Charset charset) {
        v90.o(charset, "charset");
        return new String(c(buffer), charset);
    }

    public static InputStream b(id0 buffer, boolean owner) {
        return new b(owner ? buffer : a(buffer));
    }

    /* renamed from: jd0$a */
    class a extends on {
        a(id0 buf) {
            super(buf);
        }

        public void close() {
        }
    }

    public static id0 a(id0 buffer) {
        return new a(buffer);
    }

    /* renamed from: jd0$c */
    private static class c extends u {
        int a;

        /* renamed from: a  reason: collision with other field name */
        final byte[] f4052a;
        final int b;

        c(byte[] bytes) {
            this(bytes, 0, bytes.length);
        }

        c(byte[] bytes, int offset, int length) {
            boolean z = true;
            v90.e(offset >= 0, "offset must be >= 0");
            v90.e(length >= 0, "length must be >= 0");
            v90.e(offset + length > bytes.length ? false : z, "offset + length exceeds array boundary");
            this.f4052a = (byte[]) v90.o(bytes, "bytes");
            this.a = offset;
            this.b = offset + length;
        }

        public int b() {
            return this.b - this.a;
        }

        public int readUnsignedByte() {
            c(1);
            byte[] bArr = this.f4052a;
            int i = this.a;
            this.a = i + 1;
            return bArr[i] & 255;
        }

        public void m(byte[] dest, int destIndex, int length) {
            System.arraycopy(this.f4052a, this.a, dest, destIndex, length);
            this.a += length;
        }

        /* renamed from: f */
        public c v(int length) {
            c(length);
            int originalOffset = this.a;
            this.a += length;
            return new c(this.f4052a, originalOffset, length);
        }
    }

    /* renamed from: jd0$b */
    private static final class b extends InputStream implements hw {
        final id0 a;

        public b(id0 buffer) {
            this.a = (id0) v90.o(buffer, "buffer");
        }

        public int available() {
            return this.a.b();
        }

        public int read() {
            if (this.a.b() == 0) {
                return -1;
            }
            return this.a.readUnsignedByte();
        }

        public int read(byte[] dest, int destOffset, int length) {
            if (this.a.b() == 0) {
                return -1;
            }
            int length2 = Math.min(this.a.b(), length);
            this.a.m(dest, destOffset, length2);
            return length2;
        }

        public void close() {
            this.a.close();
        }
    }
}
