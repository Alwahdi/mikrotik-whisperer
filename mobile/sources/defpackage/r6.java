package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* renamed from: r6  reason: default package */
public final class r6 implements t6, s6, Cloneable {
    private static final byte[] a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with other field name */
    long f4882a;

    /* renamed from: a  reason: collision with other field name */
    vj0 f4883a;

    public long g0() {
        return this.f4882a;
    }

    public r6 O() {
        return this;
    }

    /* renamed from: r6$a */
    class a extends OutputStream {
        a() {
        }

        public void write(int b) {
            r6.this.I((byte) b);
        }

        public void write(byte[] data, int offset, int byteCount) {
            r6.this.m0(data, offset, byteCount);
        }

        public void flush() {
        }

        public void close() {
        }

        public String toString() {
            return r6.this + ".outputStream()";
        }
    }

    public OutputStream V() {
        return new a();
    }

    public boolean F() {
        return this.f4882a == 0;
    }

    public void y(long byteCount) {
        if (this.f4882a < byteCount) {
            throw new EOFException();
        }
    }

    public r6 K(r6 out, long offset, long byteCount) {
        if (out != null) {
            su0.b(this.f4882a, offset, byteCount);
            if (byteCount == 0) {
                return this;
            }
            out.f4882a += byteCount;
            vj0 s = this.f4883a;
            while (true) {
                int i = s.b;
                int i2 = s.a;
                if (offset < ((long) (i - i2))) {
                    break;
                }
                offset -= (long) (i - i2);
                s = s.f5387a;
            }
            while (byteCount > 0) {
                vj0 copy = new vj0(s);
                int i3 = (int) (((long) copy.a) + offset);
                copy.a = i3;
                copy.b = Math.min(i3 + ((int) byteCount), copy.b);
                vj0 vj0 = out.f4883a;
                if (vj0 == null) {
                    copy.f5390b = copy;
                    copy.f5387a = copy;
                    out.f4883a = copy;
                } else {
                    vj0.f5390b.c(copy);
                }
                byteCount -= (long) (copy.b - copy.a);
                offset = 0;
                s = s.f5387a;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public long J() {
        long result = this.f4882a;
        if (result == 0) {
            return 0;
        }
        vj0 tail = this.f4883a.f5390b;
        int i = tail.b;
        if (i >= 8192 || !tail.f5391b) {
            return result;
        }
        return result - ((long) (i - tail.a));
    }

    public byte readByte() {
        long j = this.f4882a;
        if (j != 0) {
            vj0 segment = this.f4883a;
            int pos = segment.a;
            int limit = segment.b;
            int pos2 = pos + 1;
            byte b = segment.f5389a[pos];
            this.f4882a = j - 1;
            if (pos2 == limit) {
                this.f4883a = segment.b();
                wj0.a(segment);
            } else {
                segment.a = pos2;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    public byte P(long pos) {
        su0.b(this.f4882a, pos, 1);
        vj0 s = this.f4883a;
        while (true) {
            int i = s.b;
            int i2 = s.a;
            int segmentByteCount = i - i2;
            if (pos < ((long) segmentByteCount)) {
                return s.f5389a[i2 + ((int) pos)];
            }
            pos -= (long) segmentByteCount;
            s = s.f5387a;
        }
    }

    public short readShort() {
        long j = this.f4882a;
        if (j >= 2) {
            vj0 segment = this.f4883a;
            int pos = segment.a;
            int limit = segment.b;
            if (limit - pos < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] data = segment.f5389a;
            int pos2 = pos + 1;
            int pos3 = pos2 + 1;
            int s = ((data[pos] & 255) << 8) | (data[pos2] & 255);
            this.f4882a = j - 2;
            if (pos3 == limit) {
                this.f4883a = segment.b();
                wj0.a(segment);
            } else {
                segment.a = pos3;
            }
            return (short) s;
        }
        throw new IllegalStateException("size < 2: " + this.f4882a);
    }

    public int readInt() {
        long j = this.f4882a;
        if (j >= 4) {
            vj0 segment = this.f4883a;
            int pos = segment.a;
            int limit = segment.b;
            if (limit - pos < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] data = segment.f5389a;
            int pos2 = pos + 1;
            int pos3 = pos2 + 1;
            int i = ((data[pos] & 255) << 24) | ((data[pos2] & 255) << 16);
            int pos4 = pos3 + 1;
            int i2 = i | ((data[pos3] & 255) << 8);
            int pos5 = pos4 + 1;
            int i3 = i2 | (data[pos4] & 255);
            this.f4882a = j - 4;
            if (pos5 == limit) {
                this.f4883a = segment.b();
                wj0.a(segment);
            } else {
                segment.a = pos5;
            }
            return i3;
        }
        throw new IllegalStateException("size < 4: " + this.f4882a);
    }

    public a7 Y() {
        return new a7(X());
    }

    public a7 n(long byteCount) {
        return new a7(N(byteCount));
    }

    public String b0() {
        try {
            return a0(this.f4882a, su0.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String c0(long byteCount) {
        return a0(byteCount, su0.a);
    }

    public String a0(long byteCount, Charset charset) {
        su0.b(this.f4882a, 0, byteCount);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (byteCount > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + byteCount);
        } else if (byteCount == 0) {
            return "";
        } else {
            vj0 s = this.f4883a;
            int i = s.a;
            if (((long) i) + byteCount > ((long) s.b)) {
                return new String(N(byteCount), charset);
            }
            String result = new String(s.f5389a, i, (int) byteCount, charset);
            int i2 = (int) (((long) s.a) + byteCount);
            s.a = i2;
            this.f4882a -= byteCount;
            if (i2 == s.b) {
                this.f4883a = s.b();
                wj0.a(s);
            }
            return result;
        }
    }

    public String e0() {
        return f0(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public String f0(long limit) {
        if (limit >= 0) {
            long scanLength = LocationRequestCompat.PASSIVE_INTERVAL;
            if (limit != LocationRequestCompat.PASSIVE_INTERVAL) {
                scanLength = limit + 1;
            }
            long newline = U((byte) 10, 0, scanLength);
            if (newline != -1) {
                return d0(newline);
            }
            if (scanLength < g0() && P(scanLength - 1) == 13 && P(scanLength) == 10) {
                return d0(scanLength);
            }
            r6 data = new r6();
            K(data, 0, Math.min(32, g0()));
            throw new EOFException("\\n not found: limit=" + Math.min(g0(), limit) + " content=" + data.Y().h() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + limit);
    }

    /* access modifiers changed from: package-private */
    public String d0(long newline) {
        if (newline <= 0 || P(newline - 1) != 13) {
            String result = c0(newline);
            Q(1);
            return result;
        }
        String result2 = c0(newline - 1);
        Q(2);
        return result2;
    }

    public byte[] X() {
        try {
            return N(this.f4882a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] N(long byteCount) {
        su0.b(this.f4882a, 0, byteCount);
        if (byteCount <= 2147483647L) {
            byte[] result = new byte[((int) byteCount)];
            Z(result);
            return result;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + byteCount);
    }

    public void Z(byte[] sink) {
        int offset = 0;
        while (offset < sink.length) {
            int read = read(sink, offset, sink.length - offset);
            if (read != -1) {
                offset += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public int read(byte[] sink, int offset, int byteCount) {
        su0.b((long) sink.length, (long) offset, (long) byteCount);
        vj0 s = this.f4883a;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(byteCount, s.b - s.a);
        System.arraycopy(s.f5389a, s.a, sink, offset, toCopy);
        int i = s.a + toCopy;
        s.a = i;
        this.f4882a -= (long) toCopy;
        if (i == s.b) {
            this.f4883a = s.b();
            wj0.a(s);
        }
        return toCopy;
    }

    public void c() {
        try {
            Q(this.f4882a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void Q(long byteCount) {
        while (byteCount > 0) {
            vj0 vj0 = this.f4883a;
            if (vj0 != null) {
                int toSkip = (int) Math.min(byteCount, (long) (vj0.b - vj0.a));
                this.f4882a -= (long) toSkip;
                byteCount -= (long) toSkip;
                vj0 vj02 = this.f4883a;
                int i = vj02.a + toSkip;
                vj02.a = i;
                if (i == vj02.b) {
                    vj0 toRecycle = this.f4883a;
                    this.f4883a = toRecycle.b();
                    wj0.a(toRecycle);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public r6 k0(a7 byteString) {
        if (byteString != null) {
            byteString.t(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: r0 */
    public r6 R(String string) {
        return s0(string, 0, string.length());
    }

    public r6 s0(String string, int beginIndex, int endIndex) {
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        } else if (beginIndex < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + beginIndex);
        } else if (endIndex < beginIndex) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + endIndex + " < " + beginIndex);
        } else if (endIndex <= string.length()) {
            int runSize = beginIndex;
            while (runSize < endIndex) {
                int c = string.charAt(runSize);
                if (c < 128) {
                    vj0 tail = j0(1);
                    byte[] data = tail.f5389a;
                    int segmentOffset = tail.b - runSize;
                    int runLimit = Math.min(endIndex, 8192 - segmentOffset);
                    int i = runSize + 1;
                    data[runSize + segmentOffset] = (byte) c;
                    while (i < runLimit) {
                        int c2 = string.charAt(i);
                        if (c2 >= 128) {
                            break;
                        }
                        data[i + segmentOffset] = (byte) c2;
                        i++;
                    }
                    int i2 = tail.b;
                    int runSize2 = (i + segmentOffset) - i2;
                    tail.b = i2 + runSize2;
                    this.f4882a += (long) runSize2;
                    runSize = i;
                } else if (c < 2048) {
                    I((c >> 6) | 192);
                    I(128 | (c & 63));
                    runSize++;
                } else if (c < 55296 || c > 57343) {
                    I((c >> 12) | 224);
                    I(((c >> 6) & 63) | 128);
                    I(128 | (c & 63));
                    runSize++;
                } else {
                    int low = runSize + 1 < endIndex ? string.charAt(runSize + 1) : 0;
                    if (c > 56319 || low < 56320 || low > 57343) {
                        I(63);
                        runSize++;
                    } else {
                        int codePoint = (((-55297 & c) << 10) | (-56321 & low)) + 65536;
                        I((codePoint >> 18) | 240);
                        I(((codePoint >> 12) & 63) | 128);
                        I(((codePoint >> 6) & 63) | 128);
                        I(128 | (codePoint & 63));
                        runSize += 2;
                    }
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + endIndex + " > " + string.length());
        }
    }

    public r6 t0(int codePoint) {
        if (codePoint < 128) {
            I(codePoint);
        } else if (codePoint < 2048) {
            I((codePoint >> 6) | 192);
            I(128 | (codePoint & 63));
        } else if (codePoint < 65536) {
            if (codePoint < 55296 || codePoint > 57343) {
                I((codePoint >> 12) | 224);
                I(((codePoint >> 6) & 63) | 128);
                I(128 | (codePoint & 63));
            } else {
                I(63);
            }
        } else if (codePoint <= 1114111) {
            I((codePoint >> 18) | 240);
            I(((codePoint >> 12) & 63) | 128);
            I(((codePoint >> 6) & 63) | 128);
            I(128 | (codePoint & 63));
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(codePoint));
        }
        return this;
    }

    /* renamed from: l0 */
    public r6 D(byte[] source) {
        if (source != null) {
            return m0(source, 0, source.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public r6 m0(byte[] source, int offset, int byteCount) {
        if (source != null) {
            su0.b((long) source.length, (long) offset, (long) byteCount);
            int limit = offset + byteCount;
            while (offset < limit) {
                vj0 tail = j0(1);
                int toCopy = Math.min(limit - offset, 8192 - tail.b);
                System.arraycopy(source, offset, tail.f5389a, tail.b, toCopy);
                offset += toCopy;
                tail.b += toCopy;
            }
            this.f4882a += (long) byteCount;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: n0 */
    public r6 I(int b) {
        vj0 tail = j0(1);
        byte[] bArr = tail.f5389a;
        int i = tail.b;
        tail.b = i + 1;
        bArr[i] = (byte) b;
        this.f4882a++;
        return this;
    }

    /* renamed from: q0 */
    public r6 A(int s) {
        vj0 tail = j0(2);
        byte[] data = tail.f5389a;
        int limit = tail.b;
        int limit2 = limit + 1;
        data[limit] = (byte) ((s >>> 8) & 255);
        data[limit2] = (byte) (s & 255);
        tail.b = limit2 + 1;
        this.f4882a += 2;
        return this;
    }

    /* renamed from: p0 */
    public r6 x(int i) {
        vj0 tail = j0(4);
        byte[] data = tail.f5389a;
        int limit = tail.b;
        int limit2 = limit + 1;
        data[limit] = (byte) ((i >>> 24) & 255);
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((i >>> 16) & 255);
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((i >>> 8) & 255);
        data[limit4] = (byte) (i & 255);
        tail.b = limit4 + 1;
        this.f4882a += 4;
        return this;
    }

    public r6 o0(long v) {
        if (v == 0) {
            return I(48);
        }
        int width = (Long.numberOfTrailingZeros(Long.highestOneBit(v)) / 4) + 1;
        vj0 tail = j0(width);
        byte[] data = tail.f5389a;
        int start = tail.b;
        for (int pos = (tail.b + width) - 1; pos >= start; pos--) {
            data[pos] = a[(int) (15 & v)];
            v >>>= 4;
        }
        tail.b += width;
        this.f4882a += (long) width;
        return this;
    }

    /* access modifiers changed from: package-private */
    public vj0 j0(int minimumCapacity) {
        if (minimumCapacity < 1 || minimumCapacity > 8192) {
            throw new IllegalArgumentException();
        }
        vj0 vj0 = this.f4883a;
        if (vj0 == null) {
            vj0 b = wj0.b();
            this.f4883a = b;
            b.f5390b = b;
            b.f5387a = b;
            return b;
        }
        vj0 tail = vj0.f5390b;
        if (tail.b + minimumCapacity > 8192 || !tail.f5391b) {
            return tail.c(wj0.b());
        }
        return tail;
    }

    public void G(r6 source, long byteCount) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        } else if (source != this) {
            su0.b(source.f4882a, 0, byteCount);
            while (byteCount > 0) {
                vj0 vj0 = source.f4883a;
                if (byteCount < ((long) (vj0.b - vj0.a))) {
                    vj0 vj02 = this.f4883a;
                    vj0 tail = vj02 != null ? vj02.f5390b : null;
                    if (tail != null && tail.f5391b) {
                        if ((((long) tail.b) + byteCount) - ((long) (tail.f5388a ? 0 : tail.a)) <= 8192) {
                            vj0.e(tail, (int) byteCount);
                            source.f4882a -= byteCount;
                            this.f4882a += byteCount;
                            return;
                        }
                    }
                    source.f4883a = vj0.d((int) byteCount);
                }
                vj0 segmentToMove = source.f4883a;
                long movedByteCount = (long) (segmentToMove.b - segmentToMove.a);
                source.f4883a = segmentToMove.b();
                vj0 vj03 = this.f4883a;
                if (vj03 == null) {
                    this.f4883a = segmentToMove;
                    segmentToMove.f5390b = segmentToMove;
                    segmentToMove.f5387a = segmentToMove;
                } else {
                    vj03.f5390b.c(segmentToMove).a();
                }
                source.f4882a -= movedByteCount;
                this.f4882a += movedByteCount;
                byteCount -= movedByteCount;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long T(r6 sink, long byteCount) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (byteCount >= 0) {
            long j = this.f4882a;
            if (j == 0) {
                return -1;
            }
            if (byteCount > j) {
                byteCount = this.f4882a;
            }
            sink.G(this, byteCount);
            return byteCount;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + byteCount);
        }
    }

    public long U(byte b, long fromIndex, long toIndex) {
        vj0 s;
        long offset;
        if (fromIndex < 0 || toIndex < fromIndex) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f4882a), Long.valueOf(fromIndex), Long.valueOf(toIndex)}));
        }
        long j = this.f4882a;
        if (toIndex > j) {
            toIndex = this.f4882a;
        }
        if (fromIndex == toIndex || (s = this.f4883a) == null) {
            return -1;
        }
        if (j - fromIndex >= fromIndex) {
            long offset2 = 0;
            while (true) {
                long j2 = ((long) (s.b - s.a)) + offset;
                long nextOffset = j2;
                if (j2 >= fromIndex) {
                    break;
                }
                s = s.f5387a;
                offset2 = nextOffset;
            }
        } else {
            offset = this.f4882a;
            while (offset > fromIndex) {
                s = s.f5390b;
                offset -= (long) (s.b - s.a);
            }
        }
        while (offset < toIndex) {
            byte[] data = s.f5389a;
            int limit = (int) Math.min((long) s.b, (((long) s.a) + toIndex) - offset);
            for (int pos = (int) ((((long) s.a) + fromIndex) - offset); pos < limit; pos++) {
                if (data[pos] == b) {
                    return ((long) (pos - s.a)) + offset;
                }
            }
            offset += (long) (s.b - s.a);
            fromIndex = offset;
            s = s.f5387a;
        }
        return -1;
    }

    public void flush() {
    }

    public void close() {
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 1
            if (r0 != r1) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof defpackage.r6
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            r3 = r1
            r6 r3 = (defpackage.r6) r3
            long r5 = r0.f4882a
            long r7 = r3.f4882a
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x001a
            return r4
        L_0x001a:
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0021
            return r2
        L_0x0021:
            vj0 r5 = r0.f4883a
            vj0 r6 = r3.f4883a
            int r7 = r5.a
            int r8 = r6.a
            r9 = 0
        L_0x002b:
            long r11 = r0.f4882a
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0069
            int r11 = r5.b
            int r11 = r11 - r7
            int r12 = r6.b
            int r12 = r12 - r8
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = 0
        L_0x003d:
            long r14 = (long) r13
            int r16 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r16 >= 0) goto L_0x0057
            byte[] r14 = r5.f5389a
            int r15 = r7 + 1
            byte r7 = r14[r7]
            byte[] r14 = r6.f5389a
            int r16 = r8 + 1
            byte r8 = r14[r8]
            if (r7 == r8) goto L_0x0051
            return r4
        L_0x0051:
            int r13 = r13 + 1
            r7 = r15
            r8 = r16
            goto L_0x003d
        L_0x0057:
            int r13 = r5.b
            if (r7 != r13) goto L_0x005f
            vj0 r5 = r5.f5387a
            int r7 = r5.a
        L_0x005f:
            int r13 = r6.b
            if (r8 != r13) goto L_0x0067
            vj0 r6 = r6.f5387a
            int r8 = r6.a
        L_0x0067:
            long r9 = r9 + r11
            goto L_0x002b
        L_0x0069:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r6.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        vj0 s = this.f4883a;
        if (s == null) {
            return 0;
        }
        int result = 1;
        do {
            int limit = s.b;
            for (int pos = s.a; pos < limit; pos++) {
                result = (result * 31) + s.f5389a[pos];
            }
            s = s.f5387a;
        } while (s != this.f4883a);
        return result;
    }

    public String toString() {
        return h0().toString();
    }

    /* renamed from: w */
    public r6 clone() {
        r6 result = new r6();
        if (this.f4882a == 0) {
            return result;
        }
        vj0 vj0 = new vj0(this.f4883a);
        result.f4883a = vj0;
        vj0.f5390b = vj0;
        vj0.f5387a = vj0;
        for (vj0 s = this.f4883a.f5387a; s != this.f4883a; s = s.f5387a) {
            result.f4883a.f5390b.c(new vj0(s));
        }
        result.f4882a = this.f4882a;
        return result;
    }

    public a7 h0() {
        long j = this.f4882a;
        if (j <= 2147483647L) {
            return i0((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f4882a);
    }

    public a7 i0(int byteCount) {
        if (byteCount == 0) {
            return a7.a;
        }
        return new xj0(this, byteCount);
    }
}
