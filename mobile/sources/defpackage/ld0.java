package defpackage;

/* renamed from: ld0  reason: default package */
final class ld0 implements s6 {
    public final fm0 a;

    /* renamed from: a  reason: collision with other field name */
    public final r6 f4245a = new r6();

    /* renamed from: a  reason: collision with other field name */
    boolean f4246a;

    ld0(fm0 sink) {
        if (sink != null) {
            this.a = sink;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public void G(r6 source, long byteCount) {
        if (!this.f4246a) {
            this.f4245a.G(source, byteCount);
            c();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public s6 R(String string) {
        if (!this.f4246a) {
            this.f4245a.R(string);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public s6 D(byte[] source) {
        if (!this.f4246a) {
            this.f4245a.D(source);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public s6 I(int b) {
        if (!this.f4246a) {
            this.f4245a.I(b);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public s6 A(int s) {
        if (!this.f4246a) {
            this.f4245a.A(s);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public s6 x(int i) {
        if (!this.f4246a) {
            this.f4245a.x(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public s6 c() {
        if (!this.f4246a) {
            long byteCount = this.f4245a.J();
            if (byteCount > 0) {
                this.a.G(this.f4245a, byteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() {
        if (!this.f4246a) {
            r6 r6Var = this.f4245a;
            long j = r6Var.f4882a;
            if (j > 0) {
                this.a.G(r6Var, j);
            }
            this.a.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public void close() {
        if (!this.f4246a) {
            Throwable thrown = null;
            try {
                r6 r6Var = this.f4245a;
                long j = r6Var.f4882a;
                if (j > 0) {
                    this.a.G(r6Var, j);
                }
            } catch (Throwable e) {
                thrown = e;
            }
            try {
                this.a.close();
            } catch (Throwable e2) {
                if (thrown == null) {
                    thrown = e2;
                }
            }
            this.f4246a = true;
            if (thrown != null) {
                su0.c(thrown);
            }
        }
    }

    public String toString() {
        return "buffer(" + this.a + ")";
    }
}
