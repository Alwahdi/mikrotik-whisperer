package defpackage;

/* renamed from: vj0  reason: default package */
final class vj0 {
    int a;

    /* renamed from: a  reason: collision with other field name */
    vj0 f5387a;

    /* renamed from: a  reason: collision with other field name */
    boolean f5388a;

    /* renamed from: a  reason: collision with other field name */
    final byte[] f5389a;
    int b;

    /* renamed from: b  reason: collision with other field name */
    vj0 f5390b;

    /* renamed from: b  reason: collision with other field name */
    boolean f5391b;

    vj0() {
        this.f5389a = new byte[8192];
        this.f5391b = true;
        this.f5388a = false;
    }

    vj0(vj0 shareFrom) {
        this(shareFrom.f5389a, shareFrom.a, shareFrom.b);
        shareFrom.f5388a = true;
    }

    vj0(byte[] data, int pos, int limit) {
        this.f5389a = data;
        this.a = pos;
        this.b = limit;
        this.f5391b = false;
        this.f5388a = true;
    }

    public vj0 b() {
        vj0 vj0 = this.f5387a;
        vj0 result = vj0 != this ? vj0 : null;
        vj0 vj02 = this.f5390b;
        vj02.f5387a = vj0;
        this.f5387a.f5390b = vj02;
        this.f5387a = null;
        this.f5390b = null;
        return result;
    }

    public vj0 c(vj0 segment) {
        segment.f5390b = this;
        segment.f5387a = this.f5387a;
        this.f5387a.f5390b = segment;
        this.f5387a = segment;
        return segment;
    }

    public vj0 d(int byteCount) {
        vj0 prefix;
        if (byteCount <= 0 || byteCount > this.b - this.a) {
            throw new IllegalArgumentException();
        }
        if (byteCount >= 1024) {
            prefix = new vj0(this);
        } else {
            prefix = wj0.b();
            System.arraycopy(this.f5389a, this.a, prefix.f5389a, 0, byteCount);
        }
        prefix.b = prefix.a + byteCount;
        this.a += byteCount;
        this.f5390b.c(prefix);
        return prefix;
    }

    public void a() {
        vj0 vj0 = this.f5390b;
        if (vj0 == this) {
            throw new IllegalStateException();
        } else if (vj0.f5391b) {
            int byteCount = this.b - this.a;
            if (byteCount <= (8192 - vj0.b) + (vj0.f5388a ? 0 : vj0.a)) {
                e(vj0, byteCount);
                b();
                wj0.a(this);
            }
        }
    }

    public void e(vj0 sink, int byteCount) {
        if (sink.f5391b) {
            int i = sink.b;
            if (i + byteCount > 8192) {
                if (!sink.f5388a) {
                    int i2 = sink.a;
                    if ((i + byteCount) - i2 <= 8192) {
                        byte[] bArr = sink.f5389a;
                        System.arraycopy(bArr, i2, bArr, 0, i - i2);
                        sink.b -= sink.a;
                        sink.a = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f5389a, this.a, sink.f5389a, sink.b, byteCount);
            sink.b += byteCount;
            this.a += byteCount;
            return;
        }
        throw new IllegalArgumentException();
    }
}
