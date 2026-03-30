package defpackage;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: sm0  reason: default package */
public final class sm0<T> implements tl0<T> {
    private static final Object a = new Object();
    static final int d = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: a  reason: collision with other field name */
    int f5004a;

    /* renamed from: a  reason: collision with other field name */
    long f5005a;

    /* renamed from: a  reason: collision with other field name */
    final AtomicLong f5006a = new AtomicLong();

    /* renamed from: a  reason: collision with other field name */
    AtomicReferenceArray<Object> f5007a;
    final int b;

    /* renamed from: b  reason: collision with other field name */
    final AtomicLong f5008b = new AtomicLong();

    /* renamed from: b  reason: collision with other field name */
    AtomicReferenceArray<Object> f5009b;
    final int c;

    public sm0(int bufferSize) {
        int p2capacity = t90.a(Math.max(8, bufferSize));
        int mask = p2capacity - 1;
        AtomicReferenceArray<Object> buffer = new AtomicReferenceArray<>(p2capacity + 1);
        this.f5007a = buffer;
        this.b = mask;
        a(p2capacity);
        this.f5009b = buffer;
        this.c = mask;
        this.f5005a = (long) (mask - 1);
        o(0);
    }

    public boolean offer(T e) {
        if (e != null) {
            AtomicReferenceArray<Object> buffer = this.f5007a;
            long index = e();
            int mask = this.b;
            int offset = c(index, mask);
            if (index < this.f5005a) {
                return p(buffer, e, index, offset);
            }
            int lookAheadStep = this.f5004a;
            if (g(buffer, c(((long) lookAheadStep) + index, mask)) == null) {
                this.f5005a = (((long) lookAheadStep) + index) - 1;
                return p(buffer, e, index, offset);
            } else if (g(buffer, c(1 + index, mask)) == null) {
                return p(buffer, e, index, offset);
            } else {
                k(buffer, index, offset, e, (long) mask);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    private boolean p(AtomicReferenceArray<Object> buffer, T e, long index, int offset) {
        m(buffer, offset, e);
        o(1 + index);
        return true;
    }

    private void k(AtomicReferenceArray<Object> oldBuffer, long currIndex, int offset, T e, long mask) {
        AtomicReferenceArray<Object> newBuffer = new AtomicReferenceArray<>(oldBuffer.length());
        this.f5007a = newBuffer;
        this.f5005a = (currIndex + mask) - 1;
        m(newBuffer, offset, e);
        n(oldBuffer, newBuffer);
        m(oldBuffer, offset, a);
        o(1 + currIndex);
    }

    private void n(AtomicReferenceArray<Object> curr, AtomicReferenceArray<Object> next) {
        m(curr, b(curr.length() - 1), next);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> curr, int nextIndex) {
        int nextOffset = b(nextIndex);
        AtomicReferenceArray<Object> nextBuffer = (AtomicReferenceArray) g(curr, nextOffset);
        m(curr, nextOffset, (Object) null);
        return nextBuffer;
    }

    public T poll() {
        AtomicReferenceArray<Object> buffer = this.f5009b;
        long index = d();
        int mask = this.c;
        int offset = c(index, mask);
        Object e = g(buffer, offset);
        boolean isNextBuffer = e == a;
        if (e != null && !isNextBuffer) {
            m(buffer, offset, (Object) null);
            l(1 + index);
            return e;
        } else if (isNextBuffer) {
            return j(h(buffer, mask + 1), index, mask);
        } else {
            return null;
        }
    }

    private T j(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.f5009b = nextBuffer;
        int offsetInNew = c(index, mask);
        T n = g(nextBuffer, offsetInNew);
        if (n != null) {
            m(nextBuffer, offsetInNew, (Object) null);
            l(1 + index);
        }
        return n;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return i() == f();
    }

    private void a(int capacity) {
        this.f5004a = Math.min(capacity / 4, d);
    }

    private long i() {
        return this.f5006a.get();
    }

    private long f() {
        return this.f5008b.get();
    }

    private long e() {
        return this.f5006a.get();
    }

    private long d() {
        return this.f5008b.get();
    }

    private void o(long v) {
        this.f5006a.lazySet(v);
    }

    private void l(long v) {
        this.f5008b.lazySet(v);
    }

    private static int c(long index, int mask) {
        return b(((int) index) & mask);
    }

    private static int b(int index) {
        return index;
    }

    private static void m(AtomicReferenceArray<Object> buffer, int offset, Object e) {
        buffer.lazySet(offset, e);
    }

    private static <E> Object g(AtomicReferenceArray<Object> buffer, int offset) {
        return buffer.get(offset);
    }
}
