package defpackage;

/* renamed from: ep  reason: default package */
public class ep implements dd0 {
    private long a = -1;

    /* renamed from: a  reason: collision with other field name */
    private final dd0 f2921a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f2922a;
    private long b = -1;

    public ep(dd0 source) {
        this.f2921a = source;
        this.f2922a = new byte[((int) Math.min(Math.max(source.b() / 4, 1), 4096))];
        this.a = -1;
        this.b = -1;
    }

    public int a(long position) {
        if (position < this.a || position > this.b) {
            dd0 dd0 = this.f2921a;
            byte[] bArr = this.f2922a;
            int count = dd0.c(position, bArr, 0, bArr.length);
            if (count == -1) {
                return -1;
            }
            this.a = position;
            this.b = (((long) count) + position) - 1;
        }
        return this.f2922a[(int) (position - this.a)] & 255;
    }

    public int c(long position, byte[] bytes, int off, int len) {
        return this.f2921a.c(position, bytes, off, len);
    }

    public long b() {
        return this.f2921a.b();
    }

    public void close() {
        this.f2921a.close();
        this.a = -1;
        this.b = -1;
    }
}
