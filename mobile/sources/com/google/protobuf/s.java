package com.google.protobuf;

import com.google.protobuf.e;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

final class s extends e {
    /* access modifiers changed from: private */
    public static final int[] a;
    private final int b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final e f2590b;
    private final int c;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public final e f2591c;
    private final int d;

    static {
        List<Integer> numbers = new ArrayList<>();
        int f1 = 1;
        int f2 = 1;
        while (f2 > 0) {
            numbers.add(Integer.valueOf(f2));
            int temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }
        numbers.add(Integer.MAX_VALUE);
        a = new int[numbers.size()];
        int i = 0;
        while (true) {
            int[] iArr = a;
            if (i < iArr.length) {
                iArr[i] = numbers.get(i).intValue();
                i++;
            } else {
                return;
            }
        }
    }

    private s(e left, e right) {
        this.f2590b = left;
        this.f2591c = right;
        int size = left.size();
        this.c = size;
        this.b = size + right.size();
        this.d = Math.max(left.q(), right.q()) + 1;
    }

    static e I(e left, e right) {
        if (right.size() == 0) {
            return left;
        }
        if (left.size() == 0) {
            return right;
        }
        int newLength = left.size() + right.size();
        if (newLength < 128) {
            return J(left, right);
        }
        if (left instanceof s) {
            s leftRope = (s) left;
            if (leftRope.f2591c.size() + right.size() < 128) {
                return new s(leftRope.f2590b, J(leftRope.f2591c, right));
            } else if (leftRope.f2590b.q() > leftRope.f2591c.q() && leftRope.q() > right.q()) {
                return new s(leftRope.f2590b, new s(leftRope.f2591c, right));
            }
        }
        if (newLength >= a[Math.max(left.q(), right.q()) + 1]) {
            return new s(left, right);
        }
        return new b().b(left, right);
    }

    private static e J(e left, e right) {
        int leftSize = left.size();
        int rightSize = right.size();
        byte[] bytes = new byte[(leftSize + rightSize)];
        left.o(bytes, 0, 0, leftSize);
        right.o(bytes, 0, leftSize, rightSize);
        return e.C(bytes);
    }

    public byte b(int index) {
        e.c(index, this.b);
        int i = this.c;
        if (index < i) {
            return this.f2590b.b(index);
        }
        return this.f2591c.b(index - i);
    }

    public int size() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public int q() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        return this.b >= a[this.d];
    }

    public e A(int beginIndex, int endIndex) {
        int length = e.d(beginIndex, endIndex, this.b);
        if (length == 0) {
            return e.f2563a;
        }
        if (length == this.b) {
            return this;
        }
        int i = this.c;
        if (endIndex <= i) {
            return this.f2590b.A(beginIndex, endIndex);
        }
        if (beginIndex >= i) {
            return this.f2591c.A(beginIndex - i, endIndex - i);
        }
        return new s(this.f2590b.z(beginIndex), this.f2591c.A(0, endIndex - this.c));
    }

    /* access modifiers changed from: protected */
    public void p(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
        int i = sourceOffset + numberToCopy;
        int i2 = this.c;
        if (i <= i2) {
            this.f2590b.p(target, sourceOffset, targetOffset, numberToCopy);
        } else if (sourceOffset >= i2) {
            this.f2591c.p(target, sourceOffset - i2, targetOffset, numberToCopy);
        } else {
            int leftLength = i2 - sourceOffset;
            this.f2590b.p(target, sourceOffset, targetOffset, leftLength);
            this.f2591c.p(target, 0, targetOffset + leftLength, numberToCopy - leftLength);
        }
    }

    /* access modifiers changed from: package-private */
    public void E(y6 output) {
        this.f2590b.E(output);
        this.f2591c.E(output);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e otherByteString = (e) other;
        if (this.b != otherByteString.size()) {
            return false;
        }
        if (this.b == 0) {
            return true;
        }
        int thisHash = v();
        int thatHash = otherByteString.v();
        if (thisHash == 0 || thatHash == 0 || thisHash == thatHash) {
            return K(otherByteString);
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.google.protobuf.e$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.google.protobuf.e$f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean K(com.google.protobuf.e r13) {
        /*
            r12 = this;
            r0 = 0
            com.google.protobuf.s$c r1 = new com.google.protobuf.s$c
            r2 = 0
            r1.<init>(r12)
            java.lang.Object r3 = r1.next()
            com.google.protobuf.e$f r3 = (com.google.protobuf.e.f) r3
            r4 = 0
            com.google.protobuf.s$c r5 = new com.google.protobuf.s$c
            r5.<init>(r13)
            r2 = r5
            java.lang.Object r5 = r2.next()
            com.google.protobuf.e$f r5 = (com.google.protobuf.e.f) r5
            r6 = 0
        L_0x001b:
            int r7 = r3.size()
            int r7 = r7 - r0
            int r8 = r5.size()
            int r8 = r8 - r4
            int r9 = java.lang.Math.min(r7, r8)
            if (r0 != 0) goto L_0x0030
            boolean r10 = r3.F(r5, r4, r9)
            goto L_0x0034
        L_0x0030:
            boolean r10 = r5.F(r3, r0, r9)
        L_0x0034:
            if (r10 != 0) goto L_0x0039
            r11 = 0
            return r11
        L_0x0039:
            int r6 = r6 + r9
            int r11 = r12.b
            if (r6 < r11) goto L_0x0048
            if (r6 != r11) goto L_0x0042
            r11 = 1
            return r11
        L_0x0042:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            r11.<init>()
            throw r11
        L_0x0048:
            if (r9 != r7) goto L_0x0053
            r0 = 0
            java.lang.Object r11 = r1.next()
            r3 = r11
            com.google.protobuf.e$f r3 = (com.google.protobuf.e.f) r3
            goto L_0x0054
        L_0x0053:
            int r0 = r0 + r9
        L_0x0054:
            if (r9 != r8) goto L_0x005f
            r4 = 0
            java.lang.Object r11 = r2.next()
            r5 = r11
            com.google.protobuf.e$f r5 = (com.google.protobuf.e.f) r5
            goto L_0x0060
        L_0x005f:
            int r4 = r4 + r9
        L_0x0060:
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.s.K(com.google.protobuf.e):boolean");
    }

    /* access modifiers changed from: protected */
    public int u(int h, int offset, int length) {
        int toIndex = offset + length;
        int i = this.c;
        if (toIndex <= i) {
            return this.f2590b.u(h, offset, length);
        }
        if (offset >= i) {
            return this.f2591c.u(h, offset - i, length);
        }
        int leftLength = i - offset;
        return this.f2591c.u(this.f2590b.u(h, offset, leftLength), 0, length - leftLength);
    }

    public f t() {
        return f.f(new d());
    }

    private static class b {
        private final Stack<e> a;

        private b() {
            this.a = new Stack<>();
        }

        /* access modifiers changed from: private */
        public e b(e left, e right) {
            c(left);
            c(right);
            e partialString = this.a.pop();
            while (!this.a.isEmpty()) {
                partialString = new s(this.a.pop(), partialString);
            }
            return partialString;
        }

        private void c(e root) {
            if (root.r()) {
                e(root);
            } else if (root instanceof s) {
                s rbs = (s) root;
                c(rbs.f2590b);
                c(rbs.f2591c);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + root.getClass());
            }
        }

        private void e(e byteString) {
            int depthBin = d(byteString.size());
            int binEnd = s.a[depthBin + 1];
            if (this.a.isEmpty() || this.a.peek().size() >= binEnd) {
                this.a.push(byteString);
                return;
            }
            int binStart = s.a[depthBin];
            e newTree = this.a.pop();
            while (!this.a.isEmpty() && this.a.peek().size() < binStart) {
                newTree = new s(this.a.pop(), newTree);
            }
            e newTree2 = new s(newTree, byteString);
            while (!this.a.isEmpty()) {
                if (this.a.peek().size() >= s.a[d(newTree2.size()) + 1]) {
                    break;
                }
                newTree2 = new s(this.a.pop(), newTree2);
            }
            this.a.push(newTree2);
        }

        private int d(int length) {
            int depth = Arrays.binarySearch(s.a, length);
            if (depth < 0) {
                return (-(depth + 1)) - 1;
            }
            return depth;
        }
    }

    private static class c implements Iterator<e.f> {
        private e.f a;

        /* renamed from: a  reason: collision with other field name */
        private final Stack<s> f2592a;

        private c(e root) {
            this.f2592a = new Stack<>();
            this.a = a(root);
        }

        private e.f a(e root) {
            e pos = root;
            while (pos instanceof s) {
                s rbs = (s) pos;
                this.f2592a.push(rbs);
                pos = rbs.f2590b;
            }
            return (e.f) pos;
        }

        private e.f b() {
            while (!this.f2592a.isEmpty()) {
                e.f result = a(this.f2592a.pop().f2591c);
                if (!result.isEmpty()) {
                    return result;
                }
            }
            return null;
        }

        public boolean hasNext() {
            return this.a != null;
        }

        /* renamed from: c */
        public e.f next() {
            if (this.a != null) {
                e.f result = this.a;
                this.a = b();
                return result;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class d extends InputStream {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private e.f f2593a;

        /* renamed from: a  reason: collision with other field name */
        private c f2594a;
        private int b;
        private int c;
        private int d;

        public d() {
            f();
        }

        public int read(byte[] b2, int offset, int length) {
            if (b2 == null) {
                throw new NullPointerException();
            } else if (offset >= 0 && length >= 0 && length <= b2.length - offset) {
                return o(b2, offset, length);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public long skip(long length) {
            if (length >= 0) {
                if (length > 2147483647L) {
                    length = 2147483647L;
                }
                return (long) o((byte[]) null, 0, (int) length);
            }
            throw new IndexOutOfBoundsException();
        }

        private int o(byte[] b2, int offset, int length) {
            int bytesRemaining = length;
            while (true) {
                if (bytesRemaining <= 0) {
                    break;
                }
                c();
                if (this.f2593a != null) {
                    int count = Math.min(this.a - this.b, bytesRemaining);
                    if (b2 != null) {
                        this.f2593a.o(b2, this.b, offset, count);
                        offset += count;
                    }
                    this.b += count;
                    bytesRemaining -= count;
                } else if (bytesRemaining == length) {
                    return -1;
                }
            }
            return length - bytesRemaining;
        }

        public int read() {
            c();
            e.f fVar = this.f2593a;
            if (fVar == null) {
                return -1;
            }
            int i = this.b;
            this.b = i + 1;
            return fVar.b(i) & 255;
        }

        public int available() {
            return s.this.size() - (this.c + this.b);
        }

        public boolean markSupported() {
            return true;
        }

        public void mark(int readAheadLimit) {
            this.d = this.c + this.b;
        }

        public synchronized void reset() {
            f();
            o((byte[]) null, 0, this.d);
        }

        private void f() {
            c cVar = new c(s.this);
            this.f2594a = cVar;
            e.f c2 = cVar.next();
            this.f2593a = c2;
            this.a = c2.size();
            this.b = 0;
            this.c = 0;
        }

        private void c() {
            int i;
            if (this.f2593a != null && this.b == (i = this.a)) {
                this.c += i;
                this.b = 0;
                if (this.f2594a.hasNext()) {
                    e.f c2 = this.f2594a.next();
                    this.f2593a = c2;
                    this.a = c2.size();
                    return;
                }
                this.f2593a = null;
                this.a = 0;
            }
        }
    }
}
