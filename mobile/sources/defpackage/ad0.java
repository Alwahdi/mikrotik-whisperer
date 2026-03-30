package defpackage;

import java.io.RandomAccessFile;

/* renamed from: ad0  reason: default package */
class ad0 implements dd0 {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final RandomAccessFile f47a;

    public ad0(RandomAccessFile raf) {
        this.f47a = raf;
        this.a = raf.length();
    }

    public int a(long position) {
        if (position > this.f47a.length()) {
            return -1;
        }
        this.f47a.seek(position);
        return this.f47a.read();
    }

    public int c(long position, byte[] bytes, int off, int len) {
        if (position > this.a) {
            return -1;
        }
        this.f47a.seek(position);
        return this.f47a.read(bytes, off, len);
    }

    public long b() {
        return this.a;
    }

    public void close() {
        this.f47a.close();
    }
}
