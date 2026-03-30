package com.google.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class e implements Iterable<Byte>, Serializable {
    private static final d a;

    /* renamed from: a  reason: collision with other field name */
    public static final e f2563a = new g(l.f2584a);

    /* renamed from: a  reason: collision with other field name */
    private int f2564a = 0;

    private interface d {
        byte[] a(byte[] bArr, int i, int i2);
    }

    /* renamed from: com.google.protobuf.e$e  reason: collision with other inner class name */
    public interface C0032e extends Iterator<Byte> {
    }

    public abstract e A(int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void E(y6 y6Var);

    public abstract byte b(int i);

    public abstract boolean equals(Object obj);

    /* access modifiers changed from: protected */
    public abstract void p(byte[] bArr, int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int q();

    /* access modifiers changed from: protected */
    public abstract boolean r();

    public abstract int size();

    public abstract f t();

    /* access modifiers changed from: protected */
    public abstract int u(int i, int i2, int i3);

    static {
        Class<e> cls = e.class;
        boolean isAndroid = true;
        try {
            Class.forName("android.content.Context");
        } catch (ClassNotFoundException e) {
            isAndroid = false;
        }
        a = isAndroid ? new h((a) null) : new b((a) null);
    }

    private static final class h implements d {
        private h() {
        }

        /* synthetic */ h(a x0) {
            this();
        }

        public byte[] a(byte[] bytes, int offset, int size) {
            byte[] copy = new byte[size];
            System.arraycopy(bytes, offset, copy, 0, size);
            return copy;
        }
    }

    private static final class b implements d {
        private b() {
        }

        /* synthetic */ b(a x0) {
            this();
        }

        public byte[] a(byte[] bytes, int offset, int size) {
            return Arrays.copyOfRange(bytes, offset, offset + size);
        }
    }

    e() {
    }

    class a implements C0032e {
        private int a = 0;
        private final int b;

        a() {
            this.b = e.this.size();
        }

        public boolean hasNext() {
            return this.a < this.b;
        }

        /* renamed from: a */
        public Byte next() {
            return Byte.valueOf(b());
        }

        public byte b() {
            try {
                e eVar = e.this;
                int i = this.a;
                this.a = i + 1;
                return eVar.b(i);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: s */
    public final C0032e iterator() {
        return new a();
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final e z(int beginIndex) {
        return A(beginIndex, size());
    }

    public static e l(byte[] bytes, int offset, int size) {
        return new g(a.a(bytes, offset, size));
    }

    public static e j(byte[] bytes) {
        return l(bytes, 0, bytes.length);
    }

    static e C(byte[] bytes) {
        return new g(bytes);
    }

    static e D(byte[] bytes, int offset, int length) {
        return new c(bytes, offset, length);
    }

    public static e m(String text) {
        return new g(text.getBytes(l.f2583a));
    }

    public final e f(e other) {
        if (Integer.MAX_VALUE - size() >= other.size()) {
            return s.I(this, other);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + other.size());
    }

    public static e h(Iterable<e> byteStrings) {
        int tempSize;
        if (!(byteStrings instanceof Collection)) {
            tempSize = 0;
            Iterator<e> it = byteStrings.iterator();
            while (it.hasNext()) {
                it.next();
                tempSize++;
            }
        } else {
            tempSize = ((Collection) byteStrings).size();
        }
        if (tempSize == 0) {
            return f2563a;
        }
        return a(byteStrings.iterator(), tempSize);
    }

    private static e a(Iterator<e> iterator, int length) {
        if (length < 1) {
            throw new AssertionError();
        } else if (length == 1) {
            return iterator.next();
        } else {
            int halfLength = length >>> 1;
            return a(iterator, halfLength).f(a(iterator, length - halfLength));
        }
    }

    public final void o(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
        d(sourceOffset, sourceOffset + numberToCopy, size());
        d(targetOffset, targetOffset + numberToCopy, target.length);
        if (numberToCopy > 0) {
            p(target, sourceOffset, targetOffset, numberToCopy);
        }
    }

    public final byte[] B() {
        int size = size();
        if (size == 0) {
            return l.f2584a;
        }
        byte[] result = new byte[size];
        p(result, 0, 0, size);
        return result;
    }

    static abstract class f extends e {
        /* access modifiers changed from: package-private */
        public abstract boolean F(e eVar, int i, int i2);

        f() {
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return e.super.iterator();
        }

        /* access modifiers changed from: protected */
        public final int q() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public final boolean r() {
            return true;
        }
    }

    public final int hashCode() {
        int h2 = this.f2564a;
        if (h2 == 0) {
            int size = size();
            h2 = u(size, 0, size);
            if (h2 == 0) {
                h2 = 1;
            }
            this.f2564a = h2;
        }
        return h2;
    }

    /* access modifiers changed from: protected */
    public final int v() {
        return this.f2564a;
    }

    static void c(int index, int size) {
        if (((size - (index + 1)) | index) >= 0) {
            return;
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + index);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + index + ", " + size);
    }

    static int d(int startIndex, int endIndex, int size) {
        int length = endIndex - startIndex;
        if ((startIndex | endIndex | length | (size - endIndex)) >= 0) {
            return length;
        }
        if (startIndex < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + startIndex + " < 0");
        } else if (endIndex < startIndex) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + startIndex + ", " + endIndex);
        } else {
            throw new IndexOutOfBoundsException("End index: " + endIndex + " >= " + size);
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    private static class g extends f {
        protected final byte[] a;

        g(byte[] bytes) {
            this.a = bytes;
        }

        public byte b(int index) {
            return this.a[index];
        }

        public int size() {
            return this.a.length;
        }

        public final e A(int beginIndex, int endIndex) {
            int length = e.d(beginIndex, endIndex, size());
            if (length == 0) {
                return e.f2563a;
            }
            return new c(this.a, G() + beginIndex, length);
        }

        /* access modifiers changed from: protected */
        public void p(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
            System.arraycopy(this.a, sourceOffset, target, targetOffset, numberToCopy);
        }

        /* access modifiers changed from: package-private */
        public final void E(y6 output) {
            output.a(this.a, G(), size());
        }

        public final boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof e) || size() != ((e) other).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(other instanceof g)) {
                return other.equals(this);
            }
            int thisHash = v();
            int thatHash = ((g) other).v();
            if (thisHash == 0 || thatHash == 0 || thisHash == thatHash) {
                return F((g) other, 0, size());
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean F(e other, int offset, int length) {
            if (length > other.size()) {
                throw new IllegalArgumentException("Length too large: " + length + size());
            } else if (offset + length > other.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + offset + ", " + length + ", " + other.size());
            } else if (!(other instanceof g)) {
                return other.A(offset, offset + length).equals(A(0, length));
            } else {
                g lbsOther = (g) other;
                byte[] thisBytes = this.a;
                byte[] otherBytes = lbsOther.a;
                int thisLimit = G() + length;
                int thisIndex = G();
                int otherIndex = lbsOther.G() + offset;
                while (thisIndex < thisLimit) {
                    if (thisBytes[thisIndex] != otherBytes[otherIndex]) {
                        return false;
                    }
                    thisIndex++;
                    otherIndex++;
                }
                return true;
            }
        }

        /* access modifiers changed from: protected */
        public final int u(int h, int offset, int length) {
            return l.e(h, this.a, G() + offset, length);
        }

        public final f t() {
            return f.i(this.a, G(), size(), true);
        }

        /* access modifiers changed from: protected */
        public int G() {
            return 0;
        }
    }

    private static final class c extends g {
        private final int b;
        private final int c;

        c(byte[] bytes, int offset, int length) {
            super(bytes);
            e.d(offset, offset + length, bytes.length);
            this.b = offset;
            this.c = length;
        }

        public byte b(int index) {
            e.c(index, size());
            return this.a[this.b + index];
        }

        public int size() {
            return this.c;
        }

        /* access modifiers changed from: protected */
        public int G() {
            return this.b;
        }

        /* access modifiers changed from: protected */
        public void p(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
            System.arraycopy(this.a, G() + sourceOffset, target, targetOffset, numberToCopy);
        }
    }
}
