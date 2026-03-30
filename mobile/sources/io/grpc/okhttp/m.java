package io.grpc.okhttp;

class m implements bw0 {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final r6 f3944a;
    private int b;

    m(r6 buffer, int capacity) {
        this.f3944a = buffer;
        this.a = capacity;
    }

    public void write(byte[] src, int srcIndex, int length) {
        this.f3944a.m0(src, srcIndex, length);
        this.a -= length;
        this.b += length;
    }

    public void d(byte b2) {
        this.f3944a.I(b2);
        this.a--;
        this.b++;
    }

    public int c() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public void a() {
    }

    /* access modifiers changed from: package-private */
    public r6 e() {
        return this.f3944a;
    }
}
