package defpackage;

/* renamed from: dq  reason: default package */
abstract class dq implements dd0 {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private a f2810a;

    /* renamed from: a  reason: collision with other field name */
    private final a[] f2811a;

    /* access modifiers changed from: protected */
    public abstract int e(long j);

    /* access modifiers changed from: protected */
    public abstract void f(dd0 dd0);

    /* access modifiers changed from: protected */
    public abstract void g(dd0 dd0);

    public dq(dd0[] sources) {
        this.f2811a = new a[sources.length];
        long totalSize = 0;
        for (int i = 0; i < sources.length; i++) {
            this.f2811a[i] = new a(i, sources[i], totalSize);
            totalSize += sources[i].b();
        }
        this.a = totalSize;
        a aVar = this.f2811a[sources.length - 1];
        this.f2810a = aVar;
        f(aVar.f2813a);
    }

    private a d(long offset) {
        if (offset >= this.a) {
            return null;
        }
        a aVar = this.f2810a;
        if (offset >= aVar.f2812a && offset <= aVar.b) {
            return aVar;
        }
        g(aVar.f2813a);
        int i = e(offset);
        while (true) {
            a[] aVarArr = this.f2811a;
            if (i >= aVarArr.length) {
                return null;
            }
            if (offset < aVarArr[i].f2812a || offset > aVarArr[i].b) {
                i++;
            } else {
                a aVar2 = aVarArr[i];
                this.f2810a = aVar2;
                f(aVar2.f2813a);
                return this.f2810a;
            }
        }
    }

    public int a(long position) {
        a entry = d(position);
        if (entry == null) {
            return -1;
        }
        return entry.f2813a.a(entry.a(position));
    }

    public int c(long position, byte[] bytes, int off, int len) {
        int i = len;
        a entry = d(position);
        if (entry == null) {
            return -1;
        }
        long position2 = position;
        a entry2 = entry;
        long offN = entry.a(position2);
        int remaining = len;
        int off2 = off;
        while (true) {
            if (remaining <= 0) {
                break;
            } else if (entry2 == null) {
                break;
            } else if (offN > entry2.f2813a.b()) {
                break;
            } else {
                int count = entry2.f2813a.c(offN, bytes, off2, remaining);
                if (count == -1) {
                    break;
                }
                off2 += count;
                position2 += (long) count;
                remaining -= count;
                offN = 0;
                entry2 = d(position2);
            }
        }
        if (remaining == i) {
            return -1;
        }
        return i - remaining;
    }

    public long b() {
        return this.a;
    }

    public void close() {
        for (a entry : this.f2811a) {
            entry.f2813a.close();
        }
    }

    /* renamed from: dq$a */
    private static class a {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        final long f2812a;

        /* renamed from: a  reason: collision with other field name */
        final dd0 f2813a;
        final long b;

        public a(int index, dd0 source, long offset) {
            this.a = index;
            this.f2813a = source;
            this.f2812a = offset;
            this.b = (source.b() + offset) - 1;
        }

        public long a(long absoluteOffset) {
            return absoluteOffset - this.f2812a;
        }
    }
}
