package defpackage;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: g50  reason: default package */
class g50 extends dq {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final a<dd0> f3010a;

    /* renamed from: a  reason: collision with other field name */
    private final FileChannel f3011a;

    public g50(FileChannel channel) {
        this(channel, 67108864, 16);
    }

    public g50(FileChannel channel, int totalBufferSize, int maxOpenBuffers) {
        super(h(channel, totalBufferSize / maxOpenBuffers));
        this.f3011a = channel;
        this.a = totalBufferSize / maxOpenBuffers;
        this.f3010a = new a<>(maxOpenBuffers);
    }

    private static dd0[] h(FileChannel channel, int bufferSize) {
        int i = bufferSize;
        long size = channel.size();
        if (size > 0) {
            int bufferCount = ((int) (size / ((long) i))) + (size % ((long) i) == 0 ? 0 : 1);
            wz[] sources = new wz[bufferCount];
            for (int i2 = 0; i2 < bufferCount; i2++) {
                long pageOffset = ((long) i2) * ((long) i);
                sources[i2] = new wz(channel, pageOffset, Math.min(size - pageOffset, (long) i));
            }
            return sources;
        }
        throw new IOException("File size must be greater than zero");
    }

    /* access modifiers changed from: protected */
    public int e(long offset) {
        return (int) (offset / ((long) this.a));
    }

    /* access modifiers changed from: protected */
    public void g(dd0 source) {
        dd0 old = this.f3010a.a(source);
        if (old != null) {
            old.close();
        }
    }

    /* access modifiers changed from: protected */
    public void f(dd0 source) {
        ((wz) source).e();
    }

    public void close() {
        super.close();
        this.f3011a.close();
    }

    /* renamed from: g50$a */
    private static class a<E> {
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private LinkedList<E> f3012a = new LinkedList<>();

        public a(int limit) {
            this.a = limit;
        }

        public E a(E newElement) {
            if (this.f3012a.size() > 0 && this.f3012a.getFirst() == newElement) {
                return null;
            }
            Iterator<E> it = this.f3012a.iterator();
            while (it.hasNext()) {
                if (newElement == it.next()) {
                    it.remove();
                    this.f3012a.addFirst(newElement);
                    return null;
                }
            }
            this.f3012a.addFirst(newElement);
            if (this.f3012a.size() > this.a) {
                return this.f3012a.removeLast();
            }
            return null;
        }
    }
}
