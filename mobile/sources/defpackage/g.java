package defpackage;

/* renamed from: g  reason: default package */
public abstract class g {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private String f3001a;
    private String b;
    private String c;

    /* access modifiers changed from: package-private */
    public abstract void a(n80 n80, o70 o70);

    /* access modifiers changed from: package-private */
    public void j(String cmapName) {
        this.f3001a = cmapName;
    }

    public String f() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void k(String ordering) {
        this.c = ordering;
    }

    public String g() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public void l(String registry) {
        this.b = registry;
    }

    public int h() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public void m(int supplement) {
        this.a = supplement;
    }

    /* access modifiers changed from: package-private */
    public void b(n80 from, n80 to, o70 code) {
        byte[] a1 = d(from);
        byte[] a2 = d(to);
        if (a1.length != a2.length || a1.length == 0) {
            throw new IllegalArgumentException("Invalid map.");
        }
        byte[] sout = null;
        if (code instanceof n80) {
            sout = d((n80) code);
        }
        int start = c(a1);
        int end = c(a2);
        for (int k = start; k <= end; k++) {
            i(k, a1);
            n80 s = new n80(a1);
            s.I(true);
            if (code instanceof x50) {
                a(s, ((x50) code).S(k - start));
            } else if (code instanceof k70) {
                a(s, new k70((((k70) code).J() + k) - start));
            } else if (code instanceof n80) {
                n80 s1 = new n80(sout);
                s1.I(true);
                int length = sout.length - 1;
                sout[length] = (byte) (sout[length] + 1);
                a(s, s1);
            }
        }
    }

    private static void i(int v, byte[] b2) {
        for (int k = b2.length - 1; k >= 0; k--) {
            b2[k] = (byte) v;
            v >>>= 8;
        }
    }

    private static int c(byte[] b2) {
        int v = 0;
        for (byte b3 : b2) {
            v = (v << 8) | (b3 & 255);
        }
        return v;
    }

    public static byte[] d(n80 s) {
        byte[] b2 = s.q();
        byte[] br = new byte[b2.length];
        System.arraycopy(b2, 0, br, 0, b2.length);
        return br;
    }

    public String e(n80 ps) {
        if (ps.H()) {
            return n60.d(ps.q(), "UnicodeBigUnmarked");
        }
        return ps.J();
    }
}
