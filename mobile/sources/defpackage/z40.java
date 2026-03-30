package defpackage;

import java.io.OutputStream;

/* renamed from: z40  reason: default package */
public class z40 extends OutputStream {
    protected long a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected OutputStream f5972a;

    public z40(OutputStream out) {
        this.f5972a = out;
    }

    public void close() {
        this.f5972a.close();
    }

    public void flush() {
        this.f5972a.flush();
    }

    public void write(byte[] b) {
        this.a += (long) b.length;
        this.f5972a.write(b);
    }

    public void write(int b) {
        this.a++;
        this.f5972a.write(b);
    }

    public void write(byte[] b, int off, int len) {
        this.a += (long) len;
        this.f5972a.write(b, off, len);
    }

    public long c() {
        return this.a;
    }
}
