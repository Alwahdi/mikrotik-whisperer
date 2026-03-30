package defpackage;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: rm0  reason: default package */
public final class rm0<E> extends AtomicReferenceArray<E> implements tl0<E> {
    private static final Integer a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: a  reason: collision with other field name */
    final int f4908a = (length() - 1);

    /* renamed from: a  reason: collision with other field name */
    long f4909a;

    /* renamed from: a  reason: collision with other field name */
    final AtomicLong f4910a = new AtomicLong();
    final int b;

    /* renamed from: b  reason: collision with other field name */
    final AtomicLong f4911b = new AtomicLong();

    public rm0(int capacity) {
        super(t90.a(capacity));
        this.b = Math.min(capacity / 4, a.intValue());
    }

    public boolean offer(E e) {
        if (e != null) {
            int mask = this.f4908a;
            long index = this.f4910a.get();
            int offset = b(index, mask);
            if (index >= this.f4909a) {
                int step = this.b;
                if (c(b(((long) step) + index, mask)) == null) {
                    this.f4909a = ((long) step) + index;
                } else if (c(offset) != null) {
                    return false;
                }
            }
            e(offset, e);
            f(1 + index);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E poll() {
        long index = this.f4911b.get();
        int offset = a(index);
        E e = c(offset);
        if (e == null) {
            return null;
        }
        d(1 + index);
        e(offset, (Object) null);
        return e;
    }

    public boolean isEmpty() {
        return this.f4910a.get() == this.f4911b.get();
    }

    /* access modifiers changed from: package-private */
    public void f(long newIndex) {
        this.f4910a.lazySet(newIndex);
    }

    /* access modifiers changed from: package-private */
    public void d(long newIndex) {
        this.f4911b.lazySet(newIndex);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int b(long index, int mask) {
        return ((int) index) & mask;
    }

    /* access modifiers changed from: package-private */
    public int a(long index) {
        return ((int) index) & this.f4908a;
    }

    /* access modifiers changed from: package-private */
    public void e(int offset, E value) {
        lazySet(offset, value);
    }

    /* access modifiers changed from: package-private */
    public E c(int offset) {
        return get(offset);
    }
}
