package com.google.protobuf;

import com.google.protobuf.y;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class g extends y6 {
    /* access modifiers changed from: private */
    public static final long a = x.d();

    /* renamed from: a  reason: collision with other field name */
    private static final Logger f2571a = Logger.getLogger(g.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f2572a = x.h();

    public abstract void K();

    public abstract int P();

    public abstract void Q(byte b2);

    public abstract void R(int i, boolean z);

    /* access modifiers changed from: package-private */
    public abstract void U(byte[] bArr, int i, int i2);

    public abstract void V(int i, e eVar);

    public abstract void W(e eVar);

    public abstract void a(byte[] bArr, int i, int i2);

    public abstract void b0(int i);

    public abstract void c0(int i, long j);

    public abstract void d0(long j);

    public abstract void h0(int i, int i2);

    public abstract void i0(int i);

    public abstract void l0(int i, p pVar);

    public abstract void m0(p pVar);

    public abstract void r0(int i, String str);

    public abstract void s0(String str);

    public abstract void t0(int i, int i2);

    public abstract void u0(int i);

    public abstract void v0(int i, long j);

    public abstract void w0(long j);

    static int y(int dataLength) {
        if (dataLength > 4096) {
            return 4096;
        }
        return dataLength;
    }

    public static g M(OutputStream output, int bufferSize) {
        return new e(output, bufferSize);
    }

    public static g N(byte[] flatArray) {
        return O(flatArray, 0, flatArray.length);
    }

    public static g O(byte[] flatArray, int offset, int length) {
        return new c(flatArray, offset, length);
    }

    private g() {
    }

    public final void j0(int fieldNumber, long value) {
        v0(fieldNumber, value);
    }

    public final void X(int fieldNumber, double value) {
        c0(fieldNumber, Double.doubleToRawLongBits(value));
    }

    public final void Z(int fieldNumber, int value) {
        h0(fieldNumber, value);
    }

    public final void p0(int value) {
        u0(I(value));
    }

    public final void n0(int value) {
        b0(value);
    }

    public final void k0(long value) {
        w0(value);
    }

    public final void q0(long value) {
        w0(J(value));
    }

    public final void o0(long value) {
        d0(value);
    }

    public final void e0(float value) {
        b0(Float.floatToRawIntBits(value));
    }

    public final void Y(double value) {
        d0(Double.doubleToRawLongBits(value));
    }

    public final void S(boolean value) {
        Q(value ? (byte) 1 : 0);
    }

    public final void a0(int value) {
        i0(value);
    }

    public final void T(byte[] value) {
        U(value, 0, value.length);
    }

    public static int r(int fieldNumber, int value) {
        return F(fieldNumber) + s(value);
    }

    public static int t(int fieldNumber, long value) {
        return F(fieldNumber) + u(value);
    }

    public static int j(int fieldNumber, double value) {
        return F(fieldNumber) + k(value);
    }

    public static int e(int fieldNumber, boolean value) {
        return F(fieldNumber) + f(value);
    }

    public static int l(int fieldNumber, int value) {
        return F(fieldNumber) + m(value);
    }

    public static int D(int fieldNumber, String value) {
        return F(fieldNumber) + E(value);
    }

    public static int h(int fieldNumber, e value) {
        return F(fieldNumber) + i(value);
    }

    public static int w(int fieldNumber, p value) {
        return F(fieldNumber) + x(value);
    }

    public static int F(int fieldNumber) {
        return G(z.c(fieldNumber, 0));
    }

    public static int s(int value) {
        if (value >= 0) {
            return G(value);
        }
        return 10;
    }

    public static int G(int value) {
        if ((value & -128) == 0) {
            return 1;
        }
        if ((value & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & value) == 0) {
            return 3;
        }
        if ((-268435456 & value) == 0) {
            return 4;
        }
        return 5;
    }

    public static int B(int value) {
        return G(I(value));
    }

    public static int n(int unused) {
        return 4;
    }

    public static int z(int unused) {
        return 4;
    }

    public static int u(long value) {
        return H(value);
    }

    public static int H(long value) {
        if ((-128 & value) == 0) {
            return 1;
        }
        if (value < 0) {
            return 10;
        }
        int n = 2;
        if ((-34359738368L & value) != 0) {
            n = 2 + 4;
            value >>>= 28;
        }
        if ((-2097152 & value) != 0) {
            n += 2;
            value >>>= 14;
        }
        if ((-16384 & value) != 0) {
            return n + 1;
        }
        return n;
    }

    public static int C(long value) {
        return H(J(value));
    }

    public static int o(long unused) {
        return 8;
    }

    public static int A(long unused) {
        return 8;
    }

    public static int p(float unused) {
        return 4;
    }

    public static int k(double unused) {
        return 8;
    }

    public static int f(boolean unused) {
        return 1;
    }

    public static int m(int value) {
        return s(value);
    }

    public static int E(String value) {
        int length;
        try {
            length = y.f(value);
        } catch (y.c e2) {
            length = value.getBytes(l.f2583a).length;
        }
        return v(length);
    }

    public static int i(e value) {
        return v(value.size());
    }

    public static int g(byte[] value) {
        return v(value.length);
    }

    public static int x(p value) {
        return v(value.d());
    }

    static int v(int fieldLength) {
        return G(fieldLength) + fieldLength;
    }

    public static int I(int n) {
        return (n << 1) ^ (n >> 31);
    }

    public static long J(long n) {
        return (n << 1) ^ (n >> 63);
    }

    public final void d() {
        if (P() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static class d extends IOException {
        d(Throwable cause) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", cause);
        }

        d(String explanationMessage, Throwable cause) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + explanationMessage, cause);
        }
    }

    /* access modifiers changed from: package-private */
    public final void L(String value, y.c cause) {
        f2571a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", cause);
        byte[] bytes = value.getBytes(l.f2583a);
        try {
            u0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new d(e2);
        } catch (d e3) {
            throw e3;
        }
    }

    public final void f0(int fieldNumber, p value) {
        t0(fieldNumber, 3);
        g0(value);
        t0(fieldNumber, 4);
    }

    public final void g0(p value) {
        value.b(this);
    }

    public static int q(p value) {
        return value.d();
    }

    private static class c extends g {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private final byte[] f2574a;
        private final int b;
        private int c;

        c(byte[] buffer, int offset, int length) {
            super();
            if (buffer == null) {
                throw new NullPointerException("buffer");
            } else if ((offset | length | (buffer.length - (offset + length))) >= 0) {
                this.f2574a = buffer;
                this.a = offset;
                this.c = offset;
                this.b = offset + length;
            } else {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(buffer.length), Integer.valueOf(offset), Integer.valueOf(length)}));
            }
        }

        public final void t0(int fieldNumber, int wireType) {
            u0(z.c(fieldNumber, wireType));
        }

        public final void h0(int fieldNumber, int value) {
            t0(fieldNumber, 0);
            i0(value);
        }

        public final void v0(int fieldNumber, long value) {
            t0(fieldNumber, 0);
            w0(value);
        }

        public final void c0(int fieldNumber, long value) {
            t0(fieldNumber, 1);
            d0(value);
        }

        public final void R(int fieldNumber, boolean value) {
            t0(fieldNumber, 0);
            Q(value ? (byte) 1 : 0);
        }

        public final void r0(int fieldNumber, String value) {
            t0(fieldNumber, 2);
            s0(value);
        }

        public final void V(int fieldNumber, e value) {
            t0(fieldNumber, 2);
            W(value);
        }

        public final void W(e value) {
            u0(value.size());
            value.E(this);
        }

        public final void U(byte[] value, int offset, int length) {
            u0(length);
            x0(value, offset, length);
        }

        public final void l0(int fieldNumber, p value) {
            t0(fieldNumber, 2);
            m0(value);
        }

        public final void m0(p value) {
            u0(value.d());
            value.b(this);
        }

        public final void Q(byte value) {
            try {
                byte[] bArr = this.f2574a;
                int i = this.c;
                this.c = i + 1;
                bArr[i] = value;
            } catch (IndexOutOfBoundsException e) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.b), 1}), e);
            }
        }

        public final void i0(int value) {
            if (value >= 0) {
                u0(value);
            } else {
                w0((long) value);
            }
        }

        public final void u0(int value) {
            if (!g.f2572a || P() < 10) {
                while ((value & -128) != 0) {
                    byte[] bArr = this.f2574a;
                    int i = this.c;
                    this.c = i + 1;
                    bArr[i] = (byte) ((value & 127) | 128);
                    value >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f2574a;
                    int i2 = this.c;
                    this.c = i2 + 1;
                    bArr2[i2] = (byte) value;
                } catch (IndexOutOfBoundsException e) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.b), 1}), e);
                }
            } else {
                long pos = g.a + ((long) this.c);
                while ((value & -128) != 0) {
                    x.j(this.f2574a, pos, (byte) ((value & 127) | 128));
                    this.c++;
                    value >>>= 7;
                    pos = 1 + pos;
                }
                long j = 1 + pos;
                x.j(this.f2574a, pos, (byte) value);
                this.c++;
            }
        }

        public final void b0(int value) {
            try {
                byte[] bArr = this.f2574a;
                int i = this.c;
                int i2 = i + 1;
                this.c = i2;
                bArr[i] = (byte) (value & 255);
                int i3 = i2 + 1;
                this.c = i3;
                bArr[i2] = (byte) ((value >> 8) & 255);
                int i4 = i3 + 1;
                this.c = i4;
                bArr[i3] = (byte) ((value >> 16) & 255);
                this.c = i4 + 1;
                bArr[i4] = (byte) ((value >> 24) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.b), 1}), e);
            }
        }

        public final void w0(long value) {
            if (!g.f2572a || P() < 10) {
                while ((value & -128) != 0) {
                    byte[] bArr = this.f2574a;
                    int i = this.c;
                    this.c = i + 1;
                    bArr[i] = (byte) ((((int) value) & 127) | 128);
                    value >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f2574a;
                    int i2 = this.c;
                    this.c = i2 + 1;
                    bArr2[i2] = (byte) ((int) value);
                } catch (IndexOutOfBoundsException e) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.b), 1}), e);
                }
            } else {
                long pos = g.a + ((long) this.c);
                while ((value & -128) != 0) {
                    x.j(this.f2574a, pos, (byte) ((((int) value) & 127) | 128));
                    this.c++;
                    value >>>= 7;
                    pos++;
                }
                long j = 1 + pos;
                x.j(this.f2574a, pos, (byte) ((int) value));
                this.c++;
            }
        }

        public final void d0(long value) {
            try {
                byte[] bArr = this.f2574a;
                int i = this.c;
                int i2 = i + 1;
                this.c = i2;
                bArr[i] = (byte) (((int) value) & 255);
                int i3 = i2 + 1;
                this.c = i3;
                bArr[i2] = (byte) (((int) (value >> 8)) & 255);
                int i4 = i3 + 1;
                this.c = i4;
                bArr[i3] = (byte) (((int) (value >> 16)) & 255);
                int i5 = i4 + 1;
                this.c = i5;
                bArr[i4] = (byte) (((int) (value >> 24)) & 255);
                int i6 = i5 + 1;
                this.c = i6;
                bArr[i5] = (byte) (((int) (value >> 32)) & 255);
                int i7 = i6 + 1;
                this.c = i7;
                bArr[i6] = (byte) (((int) (value >> 40)) & 255);
                int i8 = i7 + 1;
                this.c = i8;
                bArr[i7] = (byte) (((int) (value >> 48)) & 255);
                this.c = i8 + 1;
                bArr[i8] = (byte) (((int) (value >> 56)) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.b), 1}), e);
            }
        }

        public final void x0(byte[] value, int offset, int length) {
            try {
                System.arraycopy(value, offset, this.f2574a, this.c, length);
                this.c += length;
            } catch (IndexOutOfBoundsException e) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.b), Integer.valueOf(length)}), e);
            }
        }

        public final void a(byte[] value, int offset, int length) {
            x0(value, offset, length);
        }

        public final void s0(String value) {
            int oldPosition = this.c;
            try {
                int maxLengthVarIntSize = g.G(value.length() * 3);
                int minLengthVarIntSize = g.G(value.length());
                if (minLengthVarIntSize == maxLengthVarIntSize) {
                    int i = oldPosition + minLengthVarIntSize;
                    this.c = i;
                    int newPosition = y.e(value, this.f2574a, i, P());
                    this.c = oldPosition;
                    u0((newPosition - oldPosition) - minLengthVarIntSize);
                    this.c = newPosition;
                    return;
                }
                u0(y.f(value));
                this.c = y.e(value, this.f2574a, this.c, P());
            } catch (y.c e) {
                this.c = oldPosition;
                L(value, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new d(e2);
            }
        }

        public void K() {
        }

        public final int P() {
            return this.b - this.c;
        }
    }

    private static abstract class b extends g {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        final byte[] f2573a;
        int b;
        int c;

        b(int bufferSize) {
            super();
            if (bufferSize >= 0) {
                byte[] bArr = new byte[Math.max(bufferSize, 20)];
                this.f2573a = bArr;
                this.a = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final int P() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        /* access modifiers changed from: package-private */
        public final void x0(byte value) {
            byte[] bArr = this.f2573a;
            int i = this.b;
            this.b = i + 1;
            bArr[i] = value;
            this.c++;
        }

        /* access modifiers changed from: package-private */
        public final void B0(int fieldNumber, int wireType) {
            C0(z.c(fieldNumber, wireType));
        }

        /* access modifiers changed from: package-private */
        public final void A0(int value) {
            if (value >= 0) {
                C0(value);
            } else {
                D0((long) value);
            }
        }

        /* access modifiers changed from: package-private */
        public final void C0(int value) {
            if (g.f2572a) {
                long originalPos = g.a + ((long) this.b);
                long pos = originalPos;
                while ((value & -128) != 0) {
                    x.j(this.f2573a, pos, (byte) ((value & 127) | 128));
                    value >>>= 7;
                    pos = 1 + pos;
                }
                x.j(this.f2573a, pos, (byte) value);
                int delta = (int) ((1 + pos) - originalPos);
                this.b += delta;
                this.c += delta;
                return;
            }
            while ((value & -128) != 0) {
                byte[] bArr = this.f2573a;
                int i = this.b;
                this.b = i + 1;
                bArr[i] = (byte) ((value & 127) | 128);
                this.c++;
                value >>>= 7;
            }
            byte[] bArr2 = this.f2573a;
            int i2 = this.b;
            this.b = i2 + 1;
            bArr2[i2] = (byte) value;
            this.c++;
        }

        /* access modifiers changed from: package-private */
        public final void D0(long value) {
            if (g.f2572a) {
                long originalPos = g.a + ((long) this.b);
                long pos = originalPos;
                long value2 = value;
                while ((value2 & -128) != 0) {
                    x.j(this.f2573a, pos, (byte) ((((int) value2) & 127) | 128));
                    value2 >>>= 7;
                    pos++;
                }
                x.j(this.f2573a, pos, (byte) ((int) value2));
                int delta = (int) ((1 + pos) - originalPos);
                this.b += delta;
                this.c += delta;
                return;
            }
            long value3 = value;
            while ((value3 & -128) != 0) {
                byte[] bArr = this.f2573a;
                int i = this.b;
                this.b = i + 1;
                bArr[i] = (byte) ((((int) value3) & 127) | 128);
                this.c++;
                value3 >>>= 7;
            }
            byte[] bArr2 = this.f2573a;
            int i2 = this.b;
            this.b = i2 + 1;
            bArr2[i2] = (byte) ((int) value3);
            this.c++;
        }

        /* access modifiers changed from: package-private */
        public final void y0(int value) {
            byte[] bArr = this.f2573a;
            int i = this.b;
            int i2 = i + 1;
            this.b = i2;
            bArr[i] = (byte) (value & 255);
            int i3 = i2 + 1;
            this.b = i3;
            bArr[i2] = (byte) ((value >> 8) & 255);
            int i4 = i3 + 1;
            this.b = i4;
            bArr[i3] = (byte) ((value >> 16) & 255);
            this.b = i4 + 1;
            bArr[i4] = (byte) ((value >> 24) & 255);
            this.c += 4;
        }

        /* access modifiers changed from: package-private */
        public final void z0(long value) {
            byte[] bArr = this.f2573a;
            int i = this.b;
            int i2 = i + 1;
            this.b = i2;
            bArr[i] = (byte) ((int) (value & 255));
            int i3 = i2 + 1;
            this.b = i3;
            bArr[i2] = (byte) ((int) ((value >> 8) & 255));
            int i4 = i3 + 1;
            this.b = i4;
            bArr[i3] = (byte) ((int) ((value >> 16) & 255));
            int i5 = i4 + 1;
            this.b = i5;
            bArr[i4] = (byte) ((int) (255 & (value >> 24)));
            int i6 = i5 + 1;
            this.b = i6;
            bArr[i5] = (byte) (((int) (value >> 32)) & 255);
            int i7 = i6 + 1;
            this.b = i7;
            bArr[i6] = (byte) (((int) (value >> 40)) & 255);
            int i8 = i7 + 1;
            this.b = i8;
            bArr[i7] = (byte) (((int) (value >> 48)) & 255);
            this.b = i8 + 1;
            bArr[i8] = (byte) (((int) (value >> 56)) & 255);
            this.c += 8;
        }
    }

    private static final class e extends b {
        private final OutputStream a;

        e(OutputStream out, int bufferSize) {
            super(bufferSize);
            if (out != null) {
                this.a = out;
                return;
            }
            throw new NullPointerException("out");
        }

        public void t0(int fieldNumber, int wireType) {
            u0(z.c(fieldNumber, wireType));
        }

        public void h0(int fieldNumber, int value) {
            F0(20);
            B0(fieldNumber, 0);
            A0(value);
        }

        public void v0(int fieldNumber, long value) {
            F0(20);
            B0(fieldNumber, 0);
            D0(value);
        }

        public void c0(int fieldNumber, long value) {
            F0(18);
            B0(fieldNumber, 1);
            z0(value);
        }

        public void R(int fieldNumber, boolean value) {
            F0(11);
            B0(fieldNumber, 0);
            x0(value ? (byte) 1 : 0);
        }

        public void r0(int fieldNumber, String value) {
            t0(fieldNumber, 2);
            s0(value);
        }

        public void V(int fieldNumber, e value) {
            t0(fieldNumber, 2);
            W(value);
        }

        public void W(e value) {
            u0(value.size());
            value.E(this);
        }

        public void U(byte[] value, int offset, int length) {
            u0(length);
            G0(value, offset, length);
        }

        public void l0(int fieldNumber, p value) {
            t0(fieldNumber, 2);
            m0(value);
        }

        public void m0(p value) {
            u0(value.d());
            value.b(this);
        }

        public void Q(byte value) {
            if (this.b == this.a) {
                E0();
            }
            x0(value);
        }

        public void i0(int value) {
            if (value >= 0) {
                u0(value);
            } else {
                w0((long) value);
            }
        }

        public void u0(int value) {
            F0(10);
            C0(value);
        }

        public void b0(int value) {
            F0(4);
            y0(value);
        }

        public void w0(long value) {
            F0(10);
            D0(value);
        }

        public void d0(long value) {
            F0(8);
            z0(value);
        }

        public void s0(String value) {
            int oldPosition;
            int length;
            try {
                int maxLength = value.length() * 3;
                int maxLengthVarIntSize = g.G(maxLength);
                int i = maxLengthVarIntSize + maxLength;
                int i2 = this.a;
                if (i > i2) {
                    byte[] encodedBytes = new byte[maxLength];
                    int actualLength = y.e(value, encodedBytes, 0, maxLength);
                    u0(actualLength);
                    a(encodedBytes, 0, actualLength);
                    return;
                }
                if (maxLengthVarIntSize + maxLength > i2 - this.b) {
                    E0();
                }
                int minLengthVarIntSize = g.G(value.length());
                oldPosition = this.b;
                if (minLengthVarIntSize == maxLengthVarIntSize) {
                    int i3 = oldPosition + minLengthVarIntSize;
                    this.b = i3;
                    int newPosition = y.e(value, this.f2573a, i3, this.a - i3);
                    this.b = oldPosition;
                    length = (newPosition - oldPosition) - minLengthVarIntSize;
                    C0(length);
                    this.b = newPosition;
                } else {
                    length = y.f(value);
                    C0(length);
                    this.b = y.e(value, this.f2573a, this.b, length);
                }
                this.c += length;
            } catch (y.c e) {
                this.c -= this.b - oldPosition;
                this.b = oldPosition;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new d(e2);
            } catch (y.c e3) {
                L(value, e3);
            }
        }

        public void K() {
            if (this.b > 0) {
                E0();
            }
        }

        public void G0(byte[] value, int offset, int length) {
            int i = this.a;
            int i2 = this.b;
            if (i - i2 >= length) {
                System.arraycopy(value, offset, this.f2573a, i2, length);
                this.b += length;
                this.c += length;
                return;
            }
            int bytesWritten = i - i2;
            System.arraycopy(value, offset, this.f2573a, i2, bytesWritten);
            int offset2 = offset + bytesWritten;
            int length2 = length - bytesWritten;
            this.b = this.a;
            this.c += bytesWritten;
            E0();
            if (length2 <= this.a) {
                System.arraycopy(value, offset2, this.f2573a, 0, length2);
                this.b = length2;
            } else {
                this.a.write(value, offset2, length2);
            }
            this.c += length2;
        }

        public void a(byte[] value, int offset, int length) {
            G0(value, offset, length);
        }

        private void F0(int requiredSize) {
            if (this.a - this.b < requiredSize) {
                E0();
            }
        }

        private void E0() {
            this.a.write(this.f2573a, 0, this.b);
            this.b = 0;
        }
    }
}
