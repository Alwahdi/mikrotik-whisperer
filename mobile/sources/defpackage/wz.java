package defpackage;

import java.io.IOException;
import java.nio.channels.FileChannel;

/* renamed from: wz  reason: default package */
class wz implements dd0 {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final FileChannel f5560a;

    /* renamed from: a  reason: collision with other field name */
    private x6 f5561a;
    private final long b;

    public wz(FileChannel channel, long offset, long length) {
        if (offset < 0) {
            throw new IllegalArgumentException(offset + " is negative");
        } else if (length > 0) {
            this.f5560a = channel;
            this.a = offset;
            this.b = length;
            this.f5561a = null;
        } else {
            throw new IllegalArgumentException(length + " is zero or negative");
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.f5561a == null) {
            if (this.f5560a.isOpen()) {
                try {
                    this.f5561a = new x6(this.f5560a.map(FileChannel.MapMode.READ_ONLY, this.a, this.b));
                } catch (IOException e) {
                    if (d(e)) {
                        throw new vz(e);
                    }
                    throw e;
                }
            } else {
                throw new IllegalStateException("Channel is closed");
            }
        }
    }

    private static boolean d(IOException e) {
        if (e.getMessage() == null || e.getMessage().indexOf("Map failed") < 0) {
            return false;
        }
        return true;
    }

    public int a(long position) {
        x6 x6Var = this.f5561a;
        if (x6Var != null) {
            return x6Var.a(position);
        }
        throw new IOException("RandomAccessSource not opened");
    }

    public int c(long position, byte[] bytes, int off, int len) {
        x6 x6Var = this.f5561a;
        if (x6Var != null) {
            return x6Var.c(position, bytes, off, len);
        }
        throw new IOException("RandomAccessSource not opened");
    }

    public long b() {
        return this.b;
    }

    public void close() {
        x6 x6Var = this.f5561a;
        if (x6Var != null) {
            x6Var.close();
            this.f5561a = null;
        }
    }

    public String toString() {
        return getClass().getName() + " (" + this.a + ", " + this.b + ")";
    }
}
