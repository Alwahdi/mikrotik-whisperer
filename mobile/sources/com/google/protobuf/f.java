package com.google.protobuf;

import com.google.protobuf.p;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class f {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private a f2566a = null;

    /* renamed from: a  reason: collision with other field name */
    private final InputStream f2567a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f2568a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f2569a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2570b = false;
    private int c;
    private int d;
    private int e;
    private int f = Integer.MAX_VALUE;
    private int g;
    private int h = 100;
    private int i = 67108864;

    private interface a {
        void a();
    }

    public static f f(InputStream input) {
        return new f(input, 4096);
    }

    public static f g(byte[] buf) {
        return h(buf, 0, buf.length);
    }

    public static f h(byte[] buf, int off, int len) {
        return i(buf, off, len, false);
    }

    static f i(byte[] buf, int off, int len, boolean bufferIsImmutable) {
        f result = new f(buf, off, len, bufferIsImmutable);
        try {
            result.k(len);
            return result;
        } catch (m ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public int J() {
        if (e()) {
            this.d = 0;
            return 0;
        }
        int A = A();
        this.d = A;
        if (z.a(A) != 0) {
            return this.d;
        }
        throw m.b();
    }

    public void a(int value) {
        if (this.d != value) {
            throw m.a();
        }
    }

    public boolean P(int tag) {
        switch (z.b(tag)) {
            case 0:
                T();
                return true;
            case 1:
                R(8);
                return true;
            case 2:
                R(A());
                return true;
            case 3:
                Q();
                a(z.c(z.a(tag), 4));
                return true;
            case 4:
                return false;
            case 5:
                R(4);
                return true;
            default:
                throw m.d();
        }
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void Q() {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r2.J()
            if (r0 == 0) goto L_0x000e
            boolean r1 = r2.P(r0)
            if (r1 != 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            goto L_0x0000
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f.Q():void");
    }

    public double n() {
        return Double.longBitsToDouble(z());
    }

    public float r() {
        return Float.intBitsToFloat(y());
    }

    public long L() {
        return B();
    }

    public long t() {
        return B();
    }

    public int s() {
        return A();
    }

    public long q() {
        return z();
    }

    public int p() {
        return y();
    }

    public boolean l() {
        return B() != 0;
    }

    public String H() {
        int size = A();
        int i2 = this.a;
        int i3 = this.c;
        if (size <= i2 - i3 && size > 0) {
            String result = new String(this.f2569a, i3, size, l.f2583a);
            this.c += size;
            return result;
        } else if (size == 0) {
            return "";
        } else {
            if (size > i2) {
                return new String(x(size), l.f2583a);
            }
            N(size);
            String result2 = new String(this.f2569a, this.c, size, l.f2583a);
            this.c += size;
            return result2;
        }
    }

    public String I() {
        int pos;
        byte[] bytes;
        int size = A();
        int oldPos = this.c;
        int i2 = this.a;
        if (size <= i2 - oldPos && size > 0) {
            bytes = this.f2569a;
            this.c = oldPos + size;
            pos = oldPos;
        } else if (size == 0) {
            return "";
        } else {
            if (size <= i2) {
                N(size);
                bytes = this.f2569a;
                pos = 0;
                this.c = 0 + size;
            } else {
                bytes = x(size);
                pos = 0;
            }
        }
        if (y.l(bytes, pos, pos + size)) {
            return new String(bytes, pos, size, l.f2583a);
        }
        throw m.c();
    }

    public void v(p.a builder, fk extensionRegistry) {
        int length = A();
        if (this.g < this.h) {
            int oldLimit = k(length);
            this.g++;
            builder.o(this, extensionRegistry);
            a(0);
            this.g--;
            j(oldLimit);
            return;
        }
        throw m.h();
    }

    public <T extends p> T u(n50<T> parser, fk extensionRegistry) {
        int length = A();
        if (this.g < this.h) {
            int oldLimit = k(length);
            this.g++;
            T result = (p) parser.a(this, extensionRegistry);
            a(0);
            this.g--;
            j(oldLimit);
            return result;
        }
        throw m.h();
    }

    public e m() {
        e result;
        int size = A();
        int i2 = this.a;
        int i3 = this.c;
        if (size <= i2 - i3 && size > 0) {
            if (!this.f2568a || !this.f2570b) {
                result = e.l(this.f2569a, i3, size);
            } else {
                result = e.D(this.f2569a, i3, size);
            }
            this.c += size;
            return result;
        } else if (size == 0) {
            return e.f2563a;
        } else {
            return e.C(x(size));
        }
    }

    public int K() {
        return A();
    }

    public int o() {
        return A();
    }

    public int D() {
        return y();
    }

    public long E() {
        return z();
    }

    public int F() {
        return b(A());
    }

    public long G() {
        return c(B());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
        if (r2[r1] < 0) goto L_0x0072;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int A() {
        /*
            r6 = this;
            int r0 = r6.c
            int r1 = r6.a
            if (r1 != r0) goto L_0x0008
            goto L_0x0072
        L_0x0008:
            byte[] r2 = r6.f2569a
            int r3 = r0 + 1
            byte r0 = r2[r0]
            r4 = r0
            if (r0 < 0) goto L_0x0014
            r6.c = r3
            return r4
        L_0x0014:
            int r1 = r1 - r3
            r0 = 9
            if (r1 >= r0) goto L_0x001a
            goto L_0x0072
        L_0x001a:
            int r0 = r3 + 1
            byte r1 = r2[r3]
            int r1 = r1 << 7
            r1 = r1 ^ r4
            r3 = r1
            if (r1 >= 0) goto L_0x0027
            r1 = r3 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x007d
        L_0x0027:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            int r0 = r0 << 14
            r0 = r0 ^ r3
            r3 = r0
            if (r0 < 0) goto L_0x0037
            r0 = r3 ^ 16256(0x3f80, float:2.278E-41)
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x007d
        L_0x0037:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 21
            r1 = r1 ^ r3
            r3 = r1
            if (r1 >= 0) goto L_0x0046
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r1 = r1 ^ r3
            goto L_0x007d
        L_0x0046:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            int r4 = r0 << 28
            r3 = r3 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r3 = r3 ^ r4
            if (r0 >= 0) goto L_0x007b
            int r4 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x0078
            int r1 = r4 + 1
            byte r4 = r2[r4]
            if (r4 >= 0) goto L_0x007b
            int r4 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x0078
            int r1 = r4 + 1
            byte r4 = r2[r4]
            if (r4 >= 0) goto L_0x007b
            int r4 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x0078
        L_0x0072:
            long r0 = r6.C()
            int r1 = (int) r0
            return r1
        L_0x0078:
            r1 = r3
            r0 = r4
            goto L_0x007d
        L_0x007b:
            r0 = r1
            r1 = r3
        L_0x007d:
            r6.c = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f.A():int");
    }

    private void T() {
        if (this.a - this.c >= 10) {
            byte[] buffer = this.f2569a;
            int pos = this.c;
            int i2 = 0;
            while (i2 < 10) {
                int pos2 = pos + 1;
                if (buffer[pos] >= 0) {
                    this.c = pos2;
                    return;
                } else {
                    i2++;
                    pos = pos2;
                }
            }
        }
        U();
    }

    private void U() {
        int i2 = 0;
        while (i2 < 10) {
            if (w() < 0) {
                i2++;
            } else {
                return;
            }
        }
        throw m.e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bd, code lost:
        if (((long) r2[r1]) < 0) goto L_0x00c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long B() {
        /*
            r10 = this;
            int r0 = r10.c
            int r1 = r10.a
            if (r1 != r0) goto L_0x0008
            goto L_0x00c0
        L_0x0008:
            byte[] r2 = r10.f2569a
            int r3 = r0 + 1
            byte r0 = r2[r0]
            r4 = r0
            if (r0 < 0) goto L_0x0015
            r10.c = r3
            long r0 = (long) r4
            return r0
        L_0x0015:
            int r1 = r1 - r3
            r0 = 9
            if (r1 >= r0) goto L_0x001c
            goto L_0x00c0
        L_0x001c:
            int r0 = r3 + 1
            byte r1 = r2[r3]
            int r1 = r1 << 7
            r1 = r1 ^ r4
            r3 = r1
            if (r1 >= 0) goto L_0x002b
            r1 = r3 ^ -128(0xffffffffffffff80, float:NaN)
            long r4 = (long) r1
            goto L_0x00c6
        L_0x002b:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            int r0 = r0 << 14
            r0 = r0 ^ r3
            r3 = r0
            if (r0 < 0) goto L_0x003b
            r0 = r3 ^ 16256(0x3f80, float:2.278E-41)
            long r4 = (long) r0
            r0 = r1
            goto L_0x00c6
        L_0x003b:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 21
            r1 = r1 ^ r3
            r3 = r1
            if (r1 >= 0) goto L_0x004c
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r1 = r1 ^ r3
            long r4 = (long) r1
            goto L_0x00c6
        L_0x004c:
            long r4 = (long) r3
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r6 = (long) r0
            r0 = 28
            long r6 = r6 << r0
            long r4 = r4 ^ r6
            r6 = r4
            r8 = 0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0063
            r4 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r4 = r4 ^ r6
            r0 = r1
            goto L_0x00c6
        L_0x0063:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r4 = (long) r1
            r1 = 35
            long r4 = r4 << r1
            long r4 = r4 ^ r6
            r6 = r4
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x0078
            r4 = -34093383808(0xfffffff80fe03f80, double:NaN)
            long r4 = r4 ^ r6
            goto L_0x00c6
        L_0x0078:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r4 = (long) r0
            r0 = 42
            long r4 = r4 << r0
            long r4 = r4 ^ r6
            r6 = r4
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x008e
            r4 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            long r4 = r4 ^ r6
            r0 = r1
            goto L_0x00c6
        L_0x008e:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r4 = (long) r1
            r1 = 49
            long r4 = r4 << r1
            long r4 = r4 ^ r6
            r6 = r4
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x00a3
            r4 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            long r4 = r4 ^ r6
            goto L_0x00c6
        L_0x00a3:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r4 = (long) r0
            r0 = 56
            long r4 = r4 << r0
            long r4 = r4 ^ r6
            r6 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r4 = r4 ^ r6
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x00c5
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r6 = (long) r1
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x00c6
        L_0x00c0:
            long r0 = r10.C()
            return r0
        L_0x00c5:
            r0 = r1
        L_0x00c6:
            r10.c = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f.B():long");
    }

    /* access modifiers changed from: package-private */
    public long C() {
        long result = 0;
        for (int shift = 0; shift < 64; shift += 7) {
            byte b2 = w();
            result |= ((long) (b2 & Byte.MAX_VALUE)) << shift;
            if ((b2 & 128) == 0) {
                return result;
            }
        }
        throw m.e();
    }

    public int y() {
        int pos = this.c;
        if (this.a - pos < 4) {
            N(4);
            pos = this.c;
        }
        byte[] buffer = this.f2569a;
        this.c = pos + 4;
        return (buffer[pos] & 255) | ((buffer[pos + 1] & 255) << 8) | ((buffer[pos + 2] & 255) << 16) | ((buffer[pos + 3] & 255) << 24);
    }

    public long z() {
        int pos = this.c;
        if (this.a - pos < 8) {
            N(8);
            pos = this.c;
        }
        byte[] buffer = this.f2569a;
        this.c = pos + 8;
        return (((long) buffer[pos]) & 255) | ((((long) buffer[pos + 1]) & 255) << 8) | ((((long) buffer[pos + 2]) & 255) << 16) | ((((long) buffer[pos + 3]) & 255) << 24) | ((((long) buffer[pos + 4]) & 255) << 32) | ((((long) buffer[pos + 5]) & 255) << 40) | ((((long) buffer[pos + 6]) & 255) << 48) | ((((long) buffer[pos + 7]) & 255) << 56);
    }

    public static int b(int n) {
        return (n >>> 1) ^ (-(n & 1));
    }

    public static long c(long n) {
        return (n >>> 1) ^ (-(1 & n));
    }

    private f(byte[] buffer, int off, int len, boolean bufferIsImmutable) {
        this.f2569a = buffer;
        this.a = off + len;
        this.c = off;
        this.e = -off;
        this.f2567a = null;
        this.f2568a = bufferIsImmutable;
    }

    private f(InputStream input, int bufferSize) {
        this.f2569a = new byte[bufferSize];
        this.c = 0;
        this.e = 0;
        this.f2567a = input;
        this.f2568a = false;
    }

    public int O(int limit) {
        if (limit >= 0) {
            int oldLimit = this.i;
            this.i = limit;
            return oldLimit;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + limit);
    }

    public int k(int byteLimit) {
        if (byteLimit >= 0) {
            int byteLimit2 = byteLimit + this.e + this.c;
            int oldLimit = this.f;
            if (byteLimit2 <= oldLimit) {
                this.f = byteLimit2;
                M();
                return oldLimit;
            }
            throw m.k();
        }
        throw m.f();
    }

    private void M() {
        int i2 = this.a + this.b;
        this.a = i2;
        int bufferEnd = this.e + i2;
        int i3 = this.f;
        if (bufferEnd > i3) {
            int i4 = bufferEnd - i3;
            this.b = i4;
            this.a = i2 - i4;
            return;
        }
        this.b = 0;
    }

    public void j(int oldLimit) {
        this.f = oldLimit;
        M();
    }

    public int d() {
        int i2 = this.f;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - (this.e + this.c);
    }

    public boolean e() {
        return this.c == this.a && !V(1);
    }

    private void N(int n) {
        if (!V(n)) {
            throw m.k();
        }
    }

    private boolean V(int n) {
        int i2 = this.c;
        if (i2 + n <= this.a) {
            throw new IllegalStateException("refillBuffer() called when " + n + " bytes were already available in buffer");
        } else if (this.e + i2 + n > this.f) {
            return false;
        } else {
            a aVar = this.f2566a;
            if (aVar != null) {
                aVar.a();
            }
            if (this.f2567a != null) {
                int pos = this.c;
                if (pos > 0) {
                    int i3 = this.a;
                    if (i3 > pos) {
                        byte[] bArr = this.f2569a;
                        System.arraycopy(bArr, pos, bArr, 0, i3 - pos);
                    }
                    this.e += pos;
                    this.a -= pos;
                    this.c = 0;
                }
                InputStream inputStream = this.f2567a;
                byte[] bArr2 = this.f2569a;
                int i4 = this.a;
                int bytesRead = inputStream.read(bArr2, i4, bArr2.length - i4);
                if (bytesRead == 0 || bytesRead < -1 || bytesRead > this.f2569a.length) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + bytesRead + "\nThe InputStream implementation is buggy.");
                } else if (bytesRead > 0) {
                    this.a += bytesRead;
                    if ((this.e + n) - this.i <= 0) {
                        M();
                        if (this.a >= n) {
                            return true;
                        }
                        return V(n);
                    }
                    throw m.j();
                }
            }
            return false;
        }
    }

    public byte w() {
        if (this.c == this.a) {
            N(1);
        }
        byte[] bArr = this.f2569a;
        int i2 = this.c;
        this.c = i2 + 1;
        return bArr[i2];
    }

    private byte[] x(int size) {
        if (size > 0) {
            int i2 = this.e;
            int i3 = this.c;
            int currentMessageSize = i2 + i3 + size;
            if (currentMessageSize <= this.i) {
                int i4 = this.f;
                if (currentMessageSize <= i4) {
                    InputStream inputStream = this.f2567a;
                    if (inputStream != null) {
                        int originalBufferPos = this.c;
                        int i5 = this.a;
                        int bufferedBytes = i5 - i3;
                        this.e = i2 + i5;
                        this.c = 0;
                        this.a = 0;
                        int sizeLeft = size - bufferedBytes;
                        if (sizeLeft < 4096 || sizeLeft <= inputStream.available()) {
                            byte[] bytes = new byte[size];
                            System.arraycopy(this.f2569a, originalBufferPos, bytes, 0, bufferedBytes);
                            int pos = bufferedBytes;
                            while (pos < bytes.length) {
                                int n = this.f2567a.read(bytes, pos, size - pos);
                                if (n != -1) {
                                    this.e += n;
                                    pos += n;
                                } else {
                                    throw m.k();
                                }
                            }
                            return bytes;
                        }
                        List<byte[]> chunks = new ArrayList<>();
                        while (sizeLeft > 0) {
                            byte[] chunk = new byte[Math.min(sizeLeft, 4096)];
                            int pos2 = 0;
                            while (pos2 < chunk.length) {
                                int n2 = this.f2567a.read(chunk, pos2, chunk.length - pos2);
                                if (n2 != -1) {
                                    this.e += n2;
                                    pos2 += n2;
                                } else {
                                    throw m.k();
                                }
                            }
                            sizeLeft -= chunk.length;
                            chunks.add(chunk);
                        }
                        byte[] bytes2 = new byte[size];
                        System.arraycopy(this.f2569a, originalBufferPos, bytes2, 0, bufferedBytes);
                        int pos3 = bufferedBytes;
                        for (byte[] chunk2 : chunks) {
                            System.arraycopy(chunk2, 0, bytes2, pos3, chunk2.length);
                            pos3 += chunk2.length;
                        }
                        return bytes2;
                    }
                    throw m.k();
                }
                R((i4 - i2) - i3);
                throw m.k();
            }
            throw m.j();
        } else if (size == 0) {
            return l.f2584a;
        } else {
            throw m.f();
        }
    }

    public void R(int size) {
        int i2 = this.a;
        int i3 = this.c;
        if (size > i2 - i3 || size < 0) {
            S(size);
        } else {
            this.c = i3 + size;
        }
    }

    private void S(int size) {
        if (size >= 0) {
            int i2 = this.e;
            int i3 = this.c;
            int i4 = i2 + i3 + size;
            int i5 = this.f;
            if (i4 <= i5) {
                int i6 = this.a;
                int pos = i6 - i3;
                this.c = i6;
                N(1);
                while (true) {
                    int i7 = size - pos;
                    int i8 = this.a;
                    if (i7 > i8) {
                        pos += i8;
                        this.c = i8;
                        N(1);
                    } else {
                        this.c = size - pos;
                        return;
                    }
                }
            } else {
                R((i5 - i2) - i3);
                throw m.k();
            }
        } else {
            throw m.f();
        }
    }
}
