package defpackage;

import java.io.EOFException;

/* renamed from: md0  reason: default package */
final class md0 implements t6 {
    public final jm0 a;

    /* renamed from: a  reason: collision with other field name */
    public final r6 f4327a = new r6();

    /* renamed from: a  reason: collision with other field name */
    boolean f4328a;

    md0(jm0 source) {
        if (source != null) {
            this.a = source;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public r6 O() {
        return this.f4327a;
    }

    public long T(r6 sink, long byteCount) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (byteCount < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + byteCount);
        } else if (!this.f4328a) {
            r6 r6Var = this.f4327a;
            if (r6Var.f4882a == 0 && this.a.T(r6Var, 8192) == -1) {
                return -1;
            }
            return this.f4327a.T(sink, Math.min(byteCount, this.f4327a.f4882a));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public boolean F() {
        if (!this.f4328a) {
            return this.f4327a.F() && this.a.T(this.f4327a, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public void y(long byteCount) {
        if (!c(byteCount)) {
            throw new EOFException();
        }
    }

    public boolean c(long byteCount) {
        r6 r6Var;
        if (byteCount < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + byteCount);
        } else if (!this.f4328a) {
            do {
                r6Var = this.f4327a;
                if (r6Var.f4882a >= byteCount) {
                    return true;
                }
            } while (this.a.T(r6Var, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public byte readByte() {
        y(1);
        return this.f4327a.readByte();
    }

    public a7 n(long byteCount) {
        y(byteCount);
        return this.f4327a.n(byteCount);
    }

    public byte[] N(long byteCount) {
        y(byteCount);
        return this.f4327a.N(byteCount);
    }

    public short readShort() {
        y(2);
        return this.f4327a.readShort();
    }

    public int readInt() {
        y(4);
        return this.f4327a.readInt();
    }

    public void Q(long byteCount) {
        if (!this.f4328a) {
            while (byteCount > 0) {
                r6 r6Var = this.f4327a;
                if (r6Var.f4882a == 0 && this.a.T(r6Var, 8192) == -1) {
                    throw new EOFException();
                }
                long toSkip = Math.min(byteCount, this.f4327a.g0());
                this.f4327a.Q(toSkip);
                byteCount -= toSkip;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public void close() {
        if (!this.f4328a) {
            this.f4328a = true;
            this.a.close();
            this.f4327a.c();
        }
    }

    public String toString() {
        return "buffer(" + this.a + ")";
    }
}
