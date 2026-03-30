package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: d60  reason: default package */
public class d60 {
    private static HashMap<h70, String> a;

    /* renamed from: a  reason: collision with other field name */
    private static final float[] f2713a = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: a  reason: collision with other field name */
    protected int f2714a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected a f2715a = new a();

    /* renamed from: a  reason: collision with other field name */
    protected d60 f2716a = null;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<a> f2717a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    protected l60 f2718a;

    /* renamed from: a  reason: collision with other field name */
    protected v80 f2719a;

    /* renamed from: a  reason: collision with other field name */
    protected w6 f2720a = new w6();

    /* renamed from: a  reason: collision with other field name */
    private boolean f2721a = false;
    protected int b = 10;

    /* renamed from: b  reason: collision with other field name */
    protected ArrayList<Integer> f2722b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2723b = false;
    private int c = 0;

    /* renamed from: c  reason: collision with other field name */
    private ArrayList<br> f2724c = new ArrayList<>();

    /* renamed from: d60$a */
    public static class a {
        float a;

        /* renamed from: a  reason: collision with other field name */
        protected int f2725a = 0;

        /* renamed from: a  reason: collision with other field name */
        protected f2 f2726a = new f2();

        /* renamed from: a  reason: collision with other field name */
        jn f2727a;

        /* renamed from: a  reason: collision with other field name */
        protected o70 f2728a = null;

        /* renamed from: a  reason: collision with other field name */
        protected w5 f2729a = new cq(0);

        /* renamed from: a  reason: collision with other field name */
        w9 f2730a;
        protected float b = 0.0f;

        /* renamed from: b  reason: collision with other field name */
        protected w5 f2731b = new cq(0);
        protected float c = 0.0f;
        protected float d = 1.0f;
        protected float e = 0.0f;
        protected float f = 0.0f;
        protected float g = 1.0f;
        protected float h = 0.0f;
        protected float i = 0.0f;
        protected float j = 100.0f;
        protected float k = 0.0f;
        protected float l = 0.0f;

        a() {
        }

        a(a cp) {
            a(cp);
        }

        /* access modifiers changed from: package-private */
        public void a(a cp) {
            this.f2727a = cp.f2727a;
            this.f2730a = cp.f2730a;
            this.a = cp.a;
            this.b = cp.b;
            this.c = cp.c;
            this.d = cp.d;
            this.e = cp.e;
            this.f = cp.f;
            this.g = cp.g;
            this.h = cp.h;
            this.i = cp.i;
            this.j = cp.j;
            this.k = cp.k;
            this.l = cp.l;
            this.f2729a = cp.f2729a;
            this.f2731b = cp.f2731b;
            this.f2726a = new f2(cp.f2726a);
            this.f2725a = cp.f2725a;
            this.f2728a = cp.f2728a;
        }

        /* access modifiers changed from: package-private */
        public void b(a restore) {
            a(restore);
        }
    }

    static {
        HashMap<h70, String> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put(h70.l0, "/BPC ");
        a.put(h70.n1, "/CS ");
        a.put(h70.e2, "/D ");
        a.put(h70.f2, "/DP ");
        a.put(h70.K3, "/F ");
        a.put(h70.Y4, "/H ");
        a.put(h70.A5, "/IM ");
        a.put(h70.K5, "/Intent ");
        a.put(h70.L5, "/I ");
        a.put(h70.Ad, "/W ");
    }

    public d60(v80 wr) {
        if (wr != null) {
            this.f2719a = wr;
            this.f2718a = wr.l0();
        }
    }

    public String toString() {
        return this.f2720a.toString();
    }

    public boolean q0() {
        return this.f2723b;
    }

    public boolean p0() {
        v80 v80 = this.f2719a;
        return v80 != null && v80.z0() && !q0();
    }

    public w6 g0() {
        return this.f2720a;
    }

    public byte[] P1(v80 writer) {
        N0();
        return this.f2720a.c0();
    }

    public void d(d60 other) {
        v80 v80 = other.f2719a;
        if (v80 == null || this.f2719a == v80) {
            this.f2720a.C(other.f2720a);
            this.f2714a += other.f2714a;
            return;
        }
        throw new RuntimeException(i10.b("inconsistent.writers.are.you.mixing.two.documents", new Object[0]));
    }

    public float n0() {
        return this.f2715a.b;
    }

    public float o0() {
        return this.f2715a.c;
    }

    public float a0() {
        return this.f2715a.k;
    }

    public void g1(int style) {
        if (style >= 0 && style <= 2) {
            this.f2720a.w(style).J(" J").V(this.b);
        }
    }

    public void k1(float phase) {
        h1((double) phase);
    }

    public void h1(double phase) {
        this.f2720a.J("[] ").o(phase).J(" d").V(this.b);
    }

    public void l1(float unitsOn, float phase) {
        i1((double) unitsOn, (double) phase);
    }

    public void i1(double unitsOn, double phase) {
        this.f2720a.J("[").o(unitsOn).J("] ").o(phase).J(" d").V(this.b);
    }

    public void m1(float unitsOn, float unitsOff, float phase) {
        j1((double) unitsOn, (double) unitsOff, (double) phase);
    }

    public void j1(double unitsOn, double unitsOff, double phase) {
        this.f2720a.J("[").o(unitsOn).f(' ').o(unitsOff).J("] ").o(phase).J(" d").V(this.b);
    }

    public void n1(int style) {
        if (style >= 0 && style <= 2) {
            this.f2720a.w(style).J(" j").V(this.b);
        }
    }

    public void p1(float w) {
        o1((double) w);
    }

    public void o1(double w) {
        this.f2720a.o(w).J(" w").V(this.b);
    }

    public void G() {
        if (this.f2721a && p0()) {
            V();
        }
        this.f2720a.J("W").V(this.b);
    }

    public void X() {
        if (this.f2721a && p0()) {
            V();
        }
        this.f2720a.J("W*").V(this.b);
    }

    public void e1(float gray) {
        O0(new cq(gray), true);
        this.f2720a.q(gray).J(" g").V(this.b);
    }

    public void F0() {
        O0(new cq(0), true);
        this.f2720a.J("0 g").V(this.b);
    }

    public void f1(float gray) {
        O0(new cq(gray), false);
        this.f2720a.q(gray).J(" G").V(this.b);
    }

    public void G0() {
        O0(new cq(0), false);
        this.f2720a.J("0 G").V(this.b);
    }

    private void c(float red, float green, float blue) {
        if (red < 0.0f) {
            red = 0.0f;
        } else if (red > 1.0f) {
            red = 1.0f;
        }
        if (green < 0.0f) {
            green = 0.0f;
        } else if (green > 1.0f) {
            green = 1.0f;
        }
        if (blue < 0.0f) {
            blue = 0.0f;
        } else if (blue > 1.0f) {
            blue = 1.0f;
        }
        this.f2720a.q(red).f(' ').q(green).f(' ').q(blue);
    }

    public void H0() {
        F0();
    }

    public void I0() {
        G0();
    }

    private void a(float cyan, float magenta, float yellow, float black) {
        if (cyan < 0.0f) {
            cyan = 0.0f;
        } else if (cyan > 1.0f) {
            cyan = 1.0f;
        }
        if (magenta < 0.0f) {
            magenta = 0.0f;
        } else if (magenta > 1.0f) {
            magenta = 1.0f;
        }
        if (yellow < 0.0f) {
            yellow = 0.0f;
        } else if (yellow > 1.0f) {
            yellow = 1.0f;
        }
        if (black < 0.0f) {
            black = 0.0f;
        } else if (black > 1.0f) {
            black = 1.0f;
        }
        this.f2720a.q(cyan).f(' ').q(magenta).f(' ').q(yellow).f(' ').q(black);
    }

    public void R0(float cyan, float magenta, float yellow, float black) {
        O0(new f7(cyan, magenta, yellow, black), true);
        a(cyan, magenta, yellow, black);
        this.f2720a.J(" k").V(this.b);
    }

    public void S0(float cyan, float magenta, float yellow, float black) {
        O0(new f7(cyan, magenta, yellow, black), false);
        a(cyan, magenta, yellow, black);
        this.f2720a.J(" K").V(this.b);
    }

    public void v0(float x, float y) {
        u0((double) x, (double) y);
    }

    public void u0(double x, double y) {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.f2720a.o(x).f(' ').o(y).J(" m").V(this.b);
    }

    public void s0(float x, float y) {
        r0((double) x, (double) y);
    }

    public void r0(double x, double y) {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.f2720a.o(x).f(' ').o(y).J(" l").V(this.b);
    }

    public void S(double x1, double y1, double x2, double y2, double x3, double y3) {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.f2720a.o(x1).f(' ').o(y1).f(' ').o(x2).f(' ').o(y2).f(' ').o(x3).f(' ').o(y3).J(" c").V(this.b);
    }

    public void B0(float x, float y, float w, float h) {
        A0((double) x, (double) y, (double) w, (double) h);
    }

    public void A0(double x, double y, double w, double h) {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.f2720a.o(x).f(' ').o(y).f(' ').o(w).f(' ').o(h).J(" re").V(this.b);
    }

    private boolean N(w5 c1, w5 c2) {
        if (c1 == null && c2 == null) {
            return true;
        }
        if (c1 == null || c2 == null) {
            return false;
        }
        if (c1 instanceof dk) {
            return c1.equals(c2);
        }
        return c2.equals(c1);
    }

    public void R1(pd0 rect) {
        w5 cfil;
        float f;
        boolean cdef;
        float f2;
        float t = rect.J();
        float b2 = rect.B();
        float r = rect.G();
        float l = rect.E();
        float wt = rect.A();
        float wb = rect.x();
        float wr = rect.z();
        float wl = rect.y();
        w5 ct = rect.q();
        w5 cb = rect.k();
        w5 cr = rect.o();
        w5 cl = rect.n();
        Q0();
        g1(0);
        n1(0);
        float clw = 0.0f;
        boolean cdef2 = false;
        w5 ccol = null;
        boolean cdefi = false;
        if (wt > 0.0f) {
            float clw2 = wt;
            p1(wt);
            cdef2 = true;
            if (ct == null) {
                I0();
            } else {
                Y0(ct);
            }
            ccol = ct;
            v0(l, t - (wt / 2.0f));
            s0(r, t - (wt / 2.0f));
            O1();
            clw = clw2;
        }
        if (wb > 0.0f) {
            if (wb != clw) {
                clw = wb;
                p1(wb);
            }
            if (!cdef2 || !N(ccol, cb)) {
                cdef2 = true;
                if (cb == null) {
                    I0();
                } else {
                    Y0(cb);
                }
                ccol = cb;
            }
            v0(r, b2 + (wb / 2.0f));
            s0(l, (wb / 2.0f) + b2);
            O1();
            clw = clw;
        }
        if (wr > 0.0f) {
            if (wr != clw) {
                clw = wr;
                p1(wr);
            }
            if (!cdef2 || !N(ccol, cr)) {
                cdef2 = true;
                if (cr == null) {
                    I0();
                } else {
                    Y0(cr);
                }
                ccol = cr;
            }
            boolean bt = N(ct, cr);
            boolean bb = N(cb, cr);
            float clw3 = clw;
            float clw4 = r - (wr / 2.0f);
            if (bt) {
                cdef = cdef2;
                f2 = t;
            } else {
                cdef = cdef2;
                f2 = t - wt;
            }
            v0(clw4, f2);
            s0(r - (wr / 2.0f), bb ? b2 : b2 + wb);
            O1();
            if (!bt || !bb) {
                cdefi = true;
                if (cr == null) {
                    H0();
                } else {
                    U0(cr);
                }
                w5 cfil2 = cr;
                if (!bt) {
                    v0(r, t);
                    s0(r, t - wt);
                    s0(r - wr, t - wt);
                    Z();
                }
                if (!bb) {
                    v0(r, b2);
                    s0(r, b2 + wb);
                    s0(r - wr, b2 + wb);
                    Z();
                }
                clw = clw3;
                cdef2 = cdef;
                w5 w5Var = cfil2;
                float f3 = r;
                cfil = w5Var;
            } else {
                clw = clw3;
                cdef2 = cdef;
                float f4 = r;
                cfil = null;
            }
        } else {
            float f5 = r;
            cfil = null;
        }
        if (wl > 0.0f) {
            if (wl != clw) {
                p1(wl);
            }
            if (!cdef2 || !N(ccol, cl)) {
                if (cl == null) {
                    I0();
                } else {
                    Y0(cl);
                }
            }
            boolean bt2 = N(ct, cl);
            boolean bb2 = N(cb, cl);
            float f6 = wr;
            float wr2 = l + (wl / 2.0f);
            if (bt2) {
                w5 w5Var2 = ct;
                f = t;
            } else {
                w5 w5Var3 = ct;
                f = t - wt;
            }
            v0(wr2, f);
            s0((wl / 2.0f) + l, bb2 ? b2 : b2 + wb);
            O1();
            if (!bt2 || !bb2) {
                if (!cdefi || !N(cfil, cl)) {
                    if (cl == null) {
                        H0();
                    } else {
                        U0(cl);
                    }
                }
                if (!bt2) {
                    v0(l, t);
                    s0(l, t - wt);
                    s0(l + wl, t - wt);
                    Z();
                }
                if (!bb2) {
                    v0(l, b2);
                    s0(l, b2 + wb);
                    s0(l + wl, b2 + wb);
                    Z();
                }
            }
        } else {
            w5 w5Var4 = ct;
        }
        K0();
    }

    public void C0(pd0 rectangle) {
        float x1 = rectangle.E();
        float y1 = rectangle.B();
        float x2 = rectangle.G();
        float y2 = rectangle.J();
        w5 background = rectangle.f();
        if (background != null) {
            Q0();
            U0(background);
            B0(x1, y1, x2 - x1, y2 - y1);
            Z();
            K0();
        }
        if (rectangle.O()) {
            if (rectangle.P()) {
                R1(rectangle);
                return;
            }
            if (rectangle.w() != -1.0f) {
                p1(rectangle.w());
            }
            w5 color = rectangle.i();
            if (color != null) {
                Y0(color);
            }
            if (rectangle.N(15)) {
                B0(x1, y1, x2 - x1, y2 - y1);
            } else {
                if (rectangle.N(8)) {
                    v0(x2, y1);
                    s0(x2, y2);
                }
                if (rectangle.N(4)) {
                    v0(x1, y1);
                    s0(x1, y2);
                }
                if (rectangle.N(2)) {
                    v0(x1, y1);
                    s0(x2, y1);
                }
                if (rectangle.N(1)) {
                    v0(x1, y2);
                    s0(x2, y2);
                }
            }
            O1();
            if (color != null) {
                I0();
            }
        }
    }

    public void J() {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.f2720a.J("h").V(this.b);
    }

    public void w0() {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.f2720a.J("n").V(this.b);
    }

    public void O1() {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        v80.H(this.f2719a, 1, this.f2715a.f2731b);
        v80.H(this.f2719a, 6, this.f2715a.f2728a);
        this.f2720a.J("S").V(this.b);
    }

    public void M() {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        v80.H(this.f2719a, 1, this.f2715a.f2731b);
        v80.H(this.f2719a, 6, this.f2715a.f2728a);
        this.f2720a.J("s").V(this.b);
    }

    public void Z() {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        v80.H(this.f2719a, 1, this.f2715a.f2729a);
        v80.H(this.f2719a, 6, this.f2715a.f2728a);
        this.f2720a.J("f").V(this.b);
    }

    public void Y() {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        v80.H(this.f2719a, 1, this.f2715a.f2729a);
        v80.H(this.f2719a, 6, this.f2715a.f2728a);
        this.f2720a.J("f*").V(this.b);
    }

    public void L() {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        v80.H(this.f2719a, 1, this.f2715a.f2729a);
        v80.H(this.f2719a, 1, this.f2715a.f2731b);
        v80.H(this.f2719a, 6, this.f2715a.f2728a);
        this.f2720a.J("b").V(this.b);
    }

    public void K() {
        if (this.f2721a) {
            if (p0()) {
                V();
            } else {
                throw new sr(i10.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        v80.H(this.f2719a, 1, this.f2715a.f2729a);
        v80.H(this.f2719a, 1, this.f2715a.f2731b);
        v80.H(this.f2719a, 6, this.f2715a.f2728a);
        this.f2720a.J("b*").V(this.b);
    }

    public void g(tr image) {
        o(image, false);
    }

    public void o(tr image, boolean inlineImage) {
        if (image.J0()) {
            float[] matrix = image.W0();
            matrix[4] = image.Z() - matrix[4];
            matrix[5] = image.a0() - matrix[5];
            n(image, matrix[0], matrix[1], matrix[2], matrix[3], matrix[4], matrix[5], inlineImage);
            return;
        }
        throw new ih(i10.b("the.image.must.have.absolute.positioning", new Object[0]));
    }

    public void m(tr image, float a2, float b2, float c2, float d, float e, float f) {
        n(image, a2, b2, c2, d, e, f, false);
    }

    public void n(tr image, float a2, float b2, float c2, float d, float e, float f, boolean inlineImage) {
        i(image, (double) a2, (double) b2, (double) c2, (double) d, (double) e, (double) f, inlineImage);
    }

    public void i(tr image, double a2, double b2, double c2, double d, double e, double f, boolean inlineImage) {
        k(image, a2, b2, c2, d, e, f, inlineImage, false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x038f A[Catch:{ IOException -> 0x0458 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03c1 A[Catch:{ IOException -> 0x0458 }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x03c8 A[Catch:{ IOException -> 0x0458 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x03d1 A[Catch:{ IOException -> 0x0458 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03d2 A[Catch:{ IOException -> 0x0458 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0464  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x046f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(defpackage.tr r30, double r31, double r33, double r35, double r37, double r39, double r41, boolean r43, boolean r44) {
        /*
            r29 = this;
            r15 = r29
            r13 = r30
            r11 = r31
            r9 = r33
            r7 = r35
            r5 = r37
            r3 = r39
            r1 = r41
            f2 r0 = new f2     // Catch:{ IOException -> 0x045a }
            r16 = r0
            r17 = r31
            r19 = r33
            r21 = r35
            r23 = r37
            r25 = r39
            r27 = r41
            r16.<init>(r17, r19, r21, r23, r25, r27)     // Catch:{ IOException -> 0x045a }
            r17 = r0
            m70 r0 = r30.x0()     // Catch:{ IOException -> 0x045a }
            if (r0 == 0) goto L_0x0032
            m70 r0 = r30.x0()     // Catch:{ IOException -> 0x045a }
            r15.v(r0)     // Catch:{ IOException -> 0x045a }
        L_0x0032:
            boolean r0 = r29.p0()     // Catch:{ IOException -> 0x045a }
            r14 = 4
            if (r0 == 0) goto L_0x00fe
            boolean r0 = r15.f2721a     // Catch:{ IOException -> 0x00f9 }
            if (r0 == 0) goto L_0x0040
            r29.V()     // Catch:{ IOException -> 0x045a }
        L_0x0040:
            p90$b[] r0 = new defpackage.p90.b[r14]     // Catch:{ IOException -> 0x00f9 }
            p90$b r14 = new p90$b     // Catch:{ IOException -> 0x00f9 }
            r1 = 0
            r14.<init>(r1, r1)     // Catch:{ IOException -> 0x00f9 }
            r2 = 0
            r0[r2] = r14     // Catch:{ IOException -> 0x00f9 }
            p90$b r2 = new p90$b     // Catch:{ IOException -> 0x00f9 }
            r14 = 1065353216(0x3f800000, float:1.0)
            r2.<init>(r14, r1)     // Catch:{ IOException -> 0x00f9 }
            r16 = 1
            r0[r16] = r2     // Catch:{ IOException -> 0x045a }
            p90$b r2 = new p90$b     // Catch:{ IOException -> 0x00f9 }
            r2.<init>(r14, r14)     // Catch:{ IOException -> 0x00f9 }
            r18 = 2
            r0[r18] = r2     // Catch:{ IOException -> 0x00f9 }
            p90$b r2 = new p90$b     // Catch:{ IOException -> 0x00f9 }
            r2.<init>(r1, r14)     // Catch:{ IOException -> 0x00f9 }
            r1 = 3
            r0[r1] = r2     // Catch:{ IOException -> 0x00f9 }
            r18 = r0
            r0 = 4
            p90$b[] r1 = new defpackage.p90.b[r0]     // Catch:{ IOException -> 0x00f9 }
            r0 = r1
            r19 = 0
            r21 = 0
            r22 = 4
            r20 = r0
            r17.j(r18, r19, r20, r21, r22)     // Catch:{ IOException -> 0x00f9 }
            r1 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r14 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r19 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r20 = 0
            r3 = r19
            r4 = r20
        L_0x008a:
            r5 = 4
            if (r4 >= r5) goto L_0x00dd
            r5 = r0[r4]     // Catch:{ IOException -> 0x045a }
            double r5 = r5.a()     // Catch:{ IOException -> 0x045a }
            double r7 = (double) r1     // Catch:{ IOException -> 0x045a }
            int r19 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r19 >= 0) goto L_0x009f
            r5 = r0[r4]     // Catch:{ IOException -> 0x045a }
            double r5 = r5.a()     // Catch:{ IOException -> 0x045a }
            float r1 = (float) r5     // Catch:{ IOException -> 0x045a }
        L_0x009f:
            r5 = r0[r4]     // Catch:{ IOException -> 0x045a }
            double r5 = r5.a()     // Catch:{ IOException -> 0x045a }
            double r7 = (double) r2     // Catch:{ IOException -> 0x045a }
            int r19 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r19 <= 0) goto L_0x00b1
            r5 = r0[r4]     // Catch:{ IOException -> 0x045a }
            double r5 = r5.a()     // Catch:{ IOException -> 0x045a }
            float r2 = (float) r5     // Catch:{ IOException -> 0x045a }
        L_0x00b1:
            r5 = r0[r4]     // Catch:{ IOException -> 0x045a }
            double r5 = r5.b()     // Catch:{ IOException -> 0x045a }
            double r7 = (double) r14     // Catch:{ IOException -> 0x045a }
            int r19 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r19 >= 0) goto L_0x00c4
            r5 = r0[r4]     // Catch:{ IOException -> 0x045a }
            double r5 = r5.b()     // Catch:{ IOException -> 0x045a }
            float r5 = (float) r5     // Catch:{ IOException -> 0x045a }
            r14 = r5
        L_0x00c4:
            r5 = r0[r4]     // Catch:{ IOException -> 0x045a }
            double r5 = r5.b()     // Catch:{ IOException -> 0x045a }
            double r7 = (double) r3     // Catch:{ IOException -> 0x045a }
            int r19 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r19 <= 0) goto L_0x00d6
            r5 = r0[r4]     // Catch:{ IOException -> 0x045a }
            double r5 = r5.b()     // Catch:{ IOException -> 0x045a }
            float r3 = (float) r5
        L_0x00d6:
            int r4 = r4 + 1
            r7 = r35
            r5 = r37
            goto L_0x008a
        L_0x00dd:
            h70 r4 = defpackage.h70.e0     // Catch:{ IOException -> 0x00f9 }
            x50 r5 = new x50     // Catch:{ IOException -> 0x00f9 }
            r6 = 4
            float[] r7 = new float[r6]     // Catch:{ IOException -> 0x00f9 }
            r19 = 0
            r7[r19] = r1     // Catch:{ IOException -> 0x00f9 }
            r16 = 1
            r7[r16] = r14     // Catch:{ IOException -> 0x045a }
            r6 = 2
            r7[r6] = r2     // Catch:{ IOException -> 0x045a }
            r6 = 3
            r7[r6] = r3     // Catch:{ IOException -> 0x045a }
            r5.<init>((float[]) r7)     // Catch:{ IOException -> 0x045a }
            r13.p(r4, r5)     // Catch:{ IOException -> 0x045a }
            goto L_0x0102
        L_0x00f9:
            r0 = move-exception
            r16 = 1
            goto L_0x045b
        L_0x00fe:
            r16 = 1
            r19 = 0
        L_0x0102:
            v80 r0 = r15.f2719a     // Catch:{ IOException -> 0x045a }
            if (r0 == 0) goto L_0x017d
            boolean r0 = r30.N0()     // Catch:{ IOException -> 0x0178 }
            if (r0 == 0) goto L_0x017d
            v80 r0 = r15.f2719a     // Catch:{ IOException -> 0x0178 }
            r0.l(r13)     // Catch:{ IOException -> 0x0178 }
            q80 r0 = r30.E0()     // Catch:{ IOException -> 0x0178 }
            java.util.HashMap r1 = r30.u()     // Catch:{ IOException -> 0x0178 }
            if (r1 == 0) goto L_0x013b
            java.util.HashMap r1 = r30.u()     // Catch:{ IOException -> 0x045a }
            java.util.Set r1 = r1.keySet()     // Catch:{ IOException -> 0x045a }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x045a }
        L_0x0127:
            boolean r2 = r1.hasNext()     // Catch:{ IOException -> 0x045a }
            if (r2 == 0) goto L_0x013b
            java.lang.Object r2 = r1.next()     // Catch:{ IOException -> 0x045a }
            h70 r2 = (defpackage.h70) r2     // Catch:{ IOException -> 0x045a }
            o70 r3 = r13.l(r2)     // Catch:{ IOException -> 0x045a }
            r0.p(r2, r3)     // Catch:{ IOException -> 0x045a }
            goto L_0x0127
        L_0x013b:
            float r1 = r0.f2()     // Catch:{ IOException -> 0x0178 }
            r14 = r1
            float r1 = r0.Y1()     // Catch:{ IOException -> 0x0178 }
            r7 = r1
            double r1 = (double) r14     // Catch:{ IOException -> 0x0178 }
            double r3 = r11 / r1
            double r1 = (double) r14     // Catch:{ IOException -> 0x0178 }
            double r5 = r9 / r1
            double r1 = (double) r7     // Catch:{ IOException -> 0x0178 }
            double r20 = r35 / r1
            double r1 = (double) r7     // Catch:{ IOException -> 0x0178 }
            double r22 = r37 / r1
            r18 = 0
            r24 = 0
            r1 = r29
            r2 = r0
            r25 = r7
            r7 = r20
            r9 = r22
            r11 = r39
            r19 = r14
            r13 = r41
            r15 = r18
            r16 = r24
            r1.q(r2, r3, r5, r7, r9, r11, r13, r15, r16)     // Catch:{ IOException -> 0x0178 }
            r14 = r29
            r4 = r30
            r12 = r31
            r10 = r33
            r8 = r35
            r6 = 0
            goto L_0x0389
        L_0x0178:
            r0 = move-exception
            r14 = r29
            goto L_0x045c
        L_0x017d:
            r14 = r29
            w6 r0 = r14.f2720a     // Catch:{ IOException -> 0x0458 }
            java.lang.String r1 = "q "
            r0.J(r1)     // Catch:{ IOException -> 0x0458 }
            boolean r0 = r17.c()     // Catch:{ IOException -> 0x0458 }
            r1 = 32
            if (r0 != 0) goto L_0x01ec
            w6 r0 = r14.f2720a     // Catch:{ IOException -> 0x01dd }
            r12 = r31
            w6 r0 = r0.o(r12)     // Catch:{ IOException -> 0x01db }
            r0.f(r1)     // Catch:{ IOException -> 0x01db }
            w6 r0 = r14.f2720a     // Catch:{ IOException -> 0x01db }
            r10 = r33
            w6 r0 = r0.o(r10)     // Catch:{ IOException -> 0x01d9 }
            r0.f(r1)     // Catch:{ IOException -> 0x01d9 }
            w6 r0 = r14.f2720a     // Catch:{ IOException -> 0x01d9 }
            r8 = r35
            w6 r0 = r0.o(r8)     // Catch:{ IOException -> 0x01d7 }
            r0.f(r1)     // Catch:{ IOException -> 0x01d7 }
            w6 r0 = r14.f2720a     // Catch:{ IOException -> 0x01d7 }
            r6 = r37
            w6 r0 = r0.o(r6)     // Catch:{ IOException -> 0x01d5 }
            r0.f(r1)     // Catch:{ IOException -> 0x01d5 }
            w6 r0 = r14.f2720a     // Catch:{ IOException -> 0x01d5 }
            r4 = r39
            w6 r0 = r0.o(r4)     // Catch:{ IOException -> 0x01d3 }
            r0.f(r1)     // Catch:{ IOException -> 0x01d3 }
            w6 r0 = r14.f2720a     // Catch:{ IOException -> 0x01d3 }
            r2 = r41
            w6 r0 = r0.o(r2)     // Catch:{ IOException -> 0x0458 }
            java.lang.String r15 = " cm"
            r0.J(r15)     // Catch:{ IOException -> 0x0458 }
            goto L_0x01f8
        L_0x01d3:
            r0 = move-exception
            goto L_0x01e8
        L_0x01d5:
            r0 = move-exception
            goto L_0x01e6
        L_0x01d7:
            r0 = move-exception
            goto L_0x01e4
        L_0x01d9:
            r0 = move-exception
            goto L_0x01e2
        L_0x01db:
            r0 = move-exception
            goto L_0x01e0
        L_0x01dd:
            r0 = move-exception
            r12 = r31
        L_0x01e0:
            r10 = r33
        L_0x01e2:
            r8 = r35
        L_0x01e4:
            r6 = r37
        L_0x01e6:
            r4 = r39
        L_0x01e8:
            r2 = r41
            goto L_0x045c
        L_0x01ec:
            r12 = r31
            r10 = r33
            r8 = r35
            r6 = r37
            r4 = r39
            r2 = r41
        L_0x01f8:
            if (r43 == 0) goto L_0x0343
            w6 r0 = r14.f2720a     // Catch:{ IOException -> 0x033e }
            java.lang.String r1 = "\nBI\n"
            r0.J(r1)     // Catch:{ IOException -> 0x033e }
            w60 r0 = new w60     // Catch:{ IOException -> 0x033e }
            java.lang.String r1 = ""
            r15 = 0
            r4 = r30
            r0.<init>(r4, r1, r15)     // Catch:{ IOException -> 0x0458 }
            boolean r1 = r4 instanceof defpackage.wr     // Catch:{ IOException -> 0x0458 }
            if (r1 == 0) goto L_0x022d
            r1 = r4
            wr r1 = (defpackage.wr) r1     // Catch:{ IOException -> 0x0458 }
            byte[] r1 = r1.t1()     // Catch:{ IOException -> 0x0458 }
            if (r1 == 0) goto L_0x022d
            j60 r5 = new j60     // Catch:{ IOException -> 0x0458 }
            r5.<init>()     // Catch:{ IOException -> 0x0458 }
            h70 r15 = defpackage.h70.T5     // Catch:{ IOException -> 0x0458 }
            v80 r2 = r14.f2719a     // Catch:{ IOException -> 0x0458 }
            z60 r2 = r2.o0(r1)     // Catch:{ IOException -> 0x0458 }
            r5.Q(r15, r2)     // Catch:{ IOException -> 0x0458 }
            h70 r2 = defpackage.h70.f2     // Catch:{ IOException -> 0x0458 }
            r0.Q(r2, r5)     // Catch:{ IOException -> 0x0458 }
        L_0x022d:
            v80 r1 = r14.f2719a     // Catch:{ IOException -> 0x0458 }
            r2 = 17
            defpackage.v80.H(r1, r2, r0)     // Catch:{ IOException -> 0x0458 }
            java.util.Set r1 = r0.N()     // Catch:{ IOException -> 0x0458 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x0458 }
        L_0x023c:
            boolean r2 = r1.hasNext()     // Catch:{ IOException -> 0x0458 }
            if (r2 == 0) goto L_0x02ff
            java.lang.Object r2 = r1.next()     // Catch:{ IOException -> 0x0458 }
            h70 r2 = (defpackage.h70) r2     // Catch:{ IOException -> 0x0458 }
            r3 = r2
            o70 r5 = r0.I(r3)     // Catch:{ IOException -> 0x0458 }
            java.util.HashMap<h70, java.lang.String> r15 = a     // Catch:{ IOException -> 0x0458 }
            java.lang.Object r15 = r15.get(r3)     // Catch:{ IOException -> 0x0458 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x0458 }
            if (r15 != 0) goto L_0x0258
            goto L_0x023c
        L_0x0258:
            r18 = r1
            w6 r1 = r14.f2720a     // Catch:{ IOException -> 0x0458 }
            r1.J(r15)     // Catch:{ IOException -> 0x0458 }
            r1 = 1
            r19 = r1
            h70 r1 = defpackage.h70.n1     // Catch:{ IOException -> 0x0458 }
            boolean r20 = r3.equals(r1)     // Catch:{ IOException -> 0x0458 }
            if (r20 == 0) goto L_0x02bf
            boolean r20 = r5.t()     // Catch:{ IOException -> 0x0458 }
            if (r20 == 0) goto L_0x02bf
            r20 = r5
            x50 r20 = (defpackage.x50) r20     // Catch:{ IOException -> 0x0458 }
            r21 = r20
            r20 = r2
            int r2 = r21.size()     // Catch:{ IOException -> 0x0458 }
            r22 = r15
            r15 = 4
            if (r2 != r15) goto L_0x02b9
            h70 r2 = defpackage.h70.E5     // Catch:{ IOException -> 0x0458 }
            r15 = r21
            r6 = 0
            h70 r7 = r15.P(r6)     // Catch:{ IOException -> 0x0458 }
            boolean r2 = r2.equals(r7)     // Catch:{ IOException -> 0x0458 }
            if (r2 == 0) goto L_0x02b6
            r7 = 1
            o70 r2 = r15.S(r7)     // Catch:{ IOException -> 0x0458 }
            boolean r2 = r2.A()     // Catch:{ IOException -> 0x0458 }
            if (r2 == 0) goto L_0x02b4
            r2 = 2
            o70 r21 = r15.S(r2)     // Catch:{ IOException -> 0x0458 }
            boolean r21 = r21.C()     // Catch:{ IOException -> 0x0458 }
            if (r21 == 0) goto L_0x02b4
            r2 = 3
            o70 r21 = r15.S(r2)     // Catch:{ IOException -> 0x0458 }
            boolean r21 = r21.D()     // Catch:{ IOException -> 0x0458 }
            if (r21 == 0) goto L_0x02c6
            r19 = 0
            goto L_0x02c6
        L_0x02b4:
            r2 = 3
            goto L_0x02c6
        L_0x02b6:
            r2 = 3
            r7 = 1
            goto L_0x02c6
        L_0x02b9:
            r15 = r21
            r2 = 3
            r6 = 0
            r7 = 1
            goto L_0x02c6
        L_0x02bf:
            r20 = r2
            r22 = r15
            r2 = 3
            r6 = 0
            r7 = 1
        L_0x02c6:
            if (r19 == 0) goto L_0x02ec
            boolean r1 = r3.equals(r1)     // Catch:{ IOException -> 0x0458 }
            if (r1 == 0) goto L_0x02ec
            boolean r1 = r5.A()     // Catch:{ IOException -> 0x0458 }
            if (r1 != 0) goto L_0x02ec
            v80 r1 = r14.f2719a     // Catch:{ IOException -> 0x0458 }
            h70 r1 = r1.S()     // Catch:{ IOException -> 0x0458 }
            e50 r15 = r29.j0()     // Catch:{ IOException -> 0x0458 }
            v80 r2 = r14.f2719a     // Catch:{ IOException -> 0x0458 }
            y60 r2 = r2.y(r5)     // Catch:{ IOException -> 0x0458 }
            z60 r2 = r2.a()     // Catch:{ IOException -> 0x0458 }
            r15.a(r1, r2)     // Catch:{ IOException -> 0x0458 }
            r5 = r1
        L_0x02ec:
            w6 r1 = r14.f2720a     // Catch:{ IOException -> 0x0458 }
            r2 = 0
            r5.F(r2, r1)     // Catch:{ IOException -> 0x0458 }
            w6 r1 = r14.f2720a     // Catch:{ IOException -> 0x0458 }
            r15 = 10
            r1.f(r15)     // Catch:{ IOException -> 0x0458 }
            r6 = r37
            r1 = r18
            goto L_0x023c
        L_0x02ff:
            r18 = r1
            r6 = 0
            r7 = 1
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0458 }
            r1.<init>()     // Catch:{ IOException -> 0x0458 }
            r0.W(r1)     // Catch:{ IOException -> 0x0458 }
            byte[] r2 = r1.toByteArray()     // Catch:{ IOException -> 0x0458 }
            w6 r3 = r14.f2720a     // Catch:{ IOException -> 0x0458 }
            java.lang.String r5 = "/L %s\n"
            java.lang.Object[] r15 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x0458 }
            int r7 = r2.length     // Catch:{ IOException -> 0x0458 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x0458 }
            r15[r6] = r7     // Catch:{ IOException -> 0x0458 }
            java.lang.String r5 = java.lang.String.format(r5, r15)     // Catch:{ IOException -> 0x0458 }
            r3.J(r5)     // Catch:{ IOException -> 0x0458 }
            w6 r3 = r14.f2720a     // Catch:{ IOException -> 0x0458 }
            java.lang.String r5 = "ID\n"
            r3.J(r5)     // Catch:{ IOException -> 0x0458 }
            w6 r3 = r14.f2720a     // Catch:{ IOException -> 0x0458 }
            r3.K(r2)     // Catch:{ IOException -> 0x0458 }
            w6 r3 = r14.f2720a     // Catch:{ IOException -> 0x0458 }
            java.lang.String r5 = "\nEI\nQ"
            w6 r3 = r3.J(r5)     // Catch:{ IOException -> 0x0458 }
            int r5 = r14.b     // Catch:{ IOException -> 0x0458 }
            r3.V(r5)     // Catch:{ IOException -> 0x0458 }
            goto L_0x0389
        L_0x033e:
            r0 = move-exception
            r4 = r30
            goto L_0x045c
        L_0x0343:
            r4 = r30
            r6 = 0
            e50 r0 = r29.j0()     // Catch:{ IOException -> 0x0458 }
            tr r2 = r30.k0()     // Catch:{ IOException -> 0x0458 }
            if (r2 == 0) goto L_0x035f
            v80 r3 = r14.f2719a     // Catch:{ IOException -> 0x0458 }
            h70 r3 = r3.l(r2)     // Catch:{ IOException -> 0x0458 }
            v80 r5 = r14.f2719a     // Catch:{ IOException -> 0x0458 }
            z60 r5 = r5.c0(r3)     // Catch:{ IOException -> 0x0458 }
            r0.h(r3, r5)     // Catch:{ IOException -> 0x0458 }
        L_0x035f:
            v80 r3 = r14.f2719a     // Catch:{ IOException -> 0x0458 }
            h70 r3 = r3.l(r4)     // Catch:{ IOException -> 0x0458 }
            v80 r5 = r14.f2719a     // Catch:{ IOException -> 0x0458 }
            z60 r5 = r5.c0(r3)     // Catch:{ IOException -> 0x0458 }
            h70 r5 = r0.h(r3, r5)     // Catch:{ IOException -> 0x0458 }
            r3 = r5
            w6 r5 = r14.f2720a     // Catch:{ IOException -> 0x0458 }
            w6 r1 = r5.f(r1)     // Catch:{ IOException -> 0x0458 }
            byte[] r5 = r3.q()     // Catch:{ IOException -> 0x0458 }
            w6 r1 = r1.K(r5)     // Catch:{ IOException -> 0x0458 }
            java.lang.String r5 = " Do Q"
            w6 r1 = r1.J(r5)     // Catch:{ IOException -> 0x0458 }
            int r5 = r14.b     // Catch:{ IOException -> 0x0458 }
            r1.V(r5)     // Catch:{ IOException -> 0x0458 }
        L_0x0389:
            boolean r0 = r30.O()     // Catch:{ IOException -> 0x0458 }
            if (r0 == 0) goto L_0x03c1
            r29.Q0()     // Catch:{ IOException -> 0x0458 }
            float r0 = r30.M()     // Catch:{ IOException -> 0x0458 }
            float r1 = r30.D()     // Catch:{ IOException -> 0x0458 }
            r15 = r1
            double r1 = (double) r0     // Catch:{ IOException -> 0x0458 }
            double r2 = r12 / r1
            double r6 = (double) r0     // Catch:{ IOException -> 0x0458 }
            double r5 = r10 / r6
            r16 = r0
            double r0 = (double) r15     // Catch:{ IOException -> 0x0458 }
            double r18 = r8 / r0
            double r0 = (double) r15     // Catch:{ IOException -> 0x0458 }
            r7 = 0
            double r20 = r37 / r0
            r1 = r29
            r4 = r5
            r0 = r15
            r15 = 0
            r6 = r18
            r8 = r20
            r10 = r39
            r12 = r41
            r1.O(r2, r4, r6, r8, r10, r12)     // Catch:{ IOException -> 0x0458 }
            r29.C0(r30)     // Catch:{ IOException -> 0x0458 }
            r29.K0()     // Catch:{ IOException -> 0x0458 }
            goto L_0x03c2
        L_0x03c1:
            r15 = 0
        L_0x03c2:
            m70 r0 = r30.x0()     // Catch:{ IOException -> 0x0458 }
            if (r0 == 0) goto L_0x03cb
            r29.T()     // Catch:{ IOException -> 0x0458 }
        L_0x03cb:
            h3 r0 = r30.d0()     // Catch:{ IOException -> 0x0458 }
            if (r0 != 0) goto L_0x03d2
            return
        L_0x03d2:
            float[] r1 = f2713a     // Catch:{ IOException -> 0x0458 }
            int r1 = r1.length     // Catch:{ IOException -> 0x0458 }
            double[] r1 = new double[r1]     // Catch:{ IOException -> 0x0458 }
            r2 = 0
        L_0x03d8:
            float[] r3 = f2713a     // Catch:{ IOException -> 0x0458 }
            int r4 = r3.length     // Catch:{ IOException -> 0x0458 }
            if (r2 >= r4) goto L_0x0404
            r4 = r3[r2]     // Catch:{ IOException -> 0x0458 }
            double r4 = (double) r4     // Catch:{ IOException -> 0x0458 }
            double r4 = r4 * r31
            int r6 = r2 + 1
            r6 = r3[r6]     // Catch:{ IOException -> 0x0458 }
            double r6 = (double) r6     // Catch:{ IOException -> 0x0458 }
            double r6 = r6 * r35
            double r4 = r4 + r6
            double r4 = r4 + r39
            r1[r2] = r4     // Catch:{ IOException -> 0x0458 }
            int r4 = r2 + 1
            r5 = r3[r2]     // Catch:{ IOException -> 0x0458 }
            double r5 = (double) r5     // Catch:{ IOException -> 0x0458 }
            double r5 = r5 * r33
            int r7 = r2 + 1
            r3 = r3[r7]     // Catch:{ IOException -> 0x0458 }
            double r7 = (double) r3     // Catch:{ IOException -> 0x0458 }
            double r7 = r7 * r37
            double r5 = r5 + r7
            double r5 = r5 + r41
            r1[r4] = r5     // Catch:{ IOException -> 0x0458 }
            int r2 = r2 + 2
            goto L_0x03d8
        L_0x0404:
            r2 = r1[r15]     // Catch:{ IOException -> 0x0458 }
            r4 = 1
            r5 = r1[r4]     // Catch:{ IOException -> 0x0458 }
            r7 = r2
            r9 = r5
            r11 = 2
        L_0x040c:
            int r12 = r1.length     // Catch:{ IOException -> 0x0458 }
            if (r11 >= r12) goto L_0x0432
            r12 = r1[r11]     // Catch:{ IOException -> 0x0458 }
            double r12 = java.lang.Math.min(r2, r12)     // Catch:{ IOException -> 0x0458 }
            r2 = r12
            int r12 = r11 + 1
            r12 = r1[r12]     // Catch:{ IOException -> 0x0458 }
            double r12 = java.lang.Math.min(r5, r12)     // Catch:{ IOException -> 0x0458 }
            r5 = r12
            r12 = r1[r11]     // Catch:{ IOException -> 0x0458 }
            double r12 = java.lang.Math.max(r7, r12)     // Catch:{ IOException -> 0x0458 }
            r7 = r12
            int r12 = r11 + 1
            r12 = r1[r12]     // Catch:{ IOException -> 0x0458 }
            double r12 = java.lang.Math.max(r9, r12)     // Catch:{ IOException -> 0x0458 }
            r9 = r12
            int r11 = r11 + 2
            goto L_0x040c
        L_0x0432:
            h3 r11 = new h3     // Catch:{ IOException -> 0x0458 }
            r11.<init>(r0)     // Catch:{ IOException -> 0x0458 }
            r0 = r11
            float r11 = (float) r2     // Catch:{ IOException -> 0x0458 }
            float r12 = (float) r5     // Catch:{ IOException -> 0x0458 }
            float r13 = (float) r7     // Catch:{ IOException -> 0x0458 }
            float r4 = (float) r9     // Catch:{ IOException -> 0x0458 }
            r0.j(r11, r12, r13, r4)     // Catch:{ IOException -> 0x0458 }
            v80 r4 = r14.f2719a     // Catch:{ IOException -> 0x0458 }
            pd0 r11 = new pd0     // Catch:{ IOException -> 0x0458 }
            float r12 = (float) r2     // Catch:{ IOException -> 0x0458 }
            float r13 = (float) r5     // Catch:{ IOException -> 0x0458 }
            float r15 = (float) r7     // Catch:{ IOException -> 0x0458 }
            r16 = r1
            float r1 = (float) r9     // Catch:{ IOException -> 0x0458 }
            r11.<init>(r12, r13, r15, r1)     // Catch:{ IOException -> 0x0458 }
            v50 r1 = defpackage.w50.d(r4, r0, r11)     // Catch:{ IOException -> 0x0458 }
            if (r1 != 0) goto L_0x0453
            return
        L_0x0453:
            r14.e(r1)     // Catch:{ IOException -> 0x0458 }
            return
        L_0x0458:
            r0 = move-exception
            goto L_0x045c
        L_0x045a:
            r0 = move-exception
        L_0x045b:
            r14 = r15
        L_0x045c:
            if (r30 == 0) goto L_0x046f
            java.net.URL r1 = r30.G0()
            if (r1 == 0) goto L_0x046f
            java.net.URL r1 = r30.G0()
            java.lang.String r1 = r1.getPath()
            r2 = r1
            r1 = 0
            goto L_0x0478
        L_0x046f:
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "unknown"
            java.lang.String r2 = defpackage.i10.b(r3, r2)
        L_0x0478:
            ih r3 = new ih
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r2
            java.lang.String r1 = "add.image.exception"
            java.lang.String r1 = defpackage.i10.b(r1, r4)
            r3.<init>(r1, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d60.k(tr, double, double, double, double, double, double, boolean, boolean):void");
    }

    public void D0() {
        E0(true);
    }

    public void E0(boolean validateContent) {
        this.f2720a.Z();
        this.f2714a = 0;
        if (validateContent) {
            N0();
        }
        this.f2715a = new a();
        this.f2717a = new ArrayList<>();
    }

    /* access modifiers changed from: protected */
    public void B(boolean restoreTM) {
        if (!this.f2721a) {
            this.f2721a = true;
            this.f2720a.J("BT").V(this.b);
            if (restoreTM) {
                a aVar = this.f2715a;
                float xTLM = aVar.b;
                float tx = aVar.h;
                E1(aVar.d, aVar.e, aVar.f, aVar.g, aVar.h, aVar.c);
                a aVar2 = this.f2715a;
                aVar2.b = xTLM;
                aVar2.h = tx;
                return;
            }
            a aVar3 = this.f2715a;
            aVar3.b = 0.0f;
            aVar3.c = 0.0f;
            aVar3.h = 0.0f;
        } else if (!p0()) {
            throw new sr(i10.b("unbalanced.begin.end.text.operators", new Object[0]));
        }
    }

    public void A() {
        B(false);
    }

    public void V() {
        if (this.f2721a) {
            this.f2721a = false;
            this.f2720a.J("ET").V(this.b);
        } else if (!p0()) {
            throw new sr(i10.b("unbalanced.begin.end.text.operators", new Object[0]));
        }
    }

    public void Q0() {
        v80.H(this.f2719a, 12, "q");
        if (this.f2721a && p0()) {
            V();
        }
        this.f2720a.J("q").V(this.b);
        this.f2717a.add(new a(this.f2715a));
    }

    public void K0() {
        v80.H(this.f2719a, 12, "Q");
        if (this.f2721a && p0()) {
            V();
        }
        this.f2720a.J("Q").V(this.b);
        int idx = this.f2717a.size() - 1;
        if (idx >= 0) {
            this.f2715a.b(this.f2717a.get(idx));
            this.f2717a.remove(idx);
            return;
        }
        throw new sr(i10.b("unbalanced.save.restore.state.operators", new Object[0]));
    }

    public void T0(float charSpace) {
        if (!this.f2721a && p0()) {
            B(true);
        }
        this.f2715a.k = charSpace;
        this.f2720a.q(charSpace).J(" Tc").V(this.b);
    }

    public void I1(float wordSpace) {
        if (!this.f2721a && p0()) {
            B(true);
        }
        this.f2715a.l = wordSpace;
        this.f2720a.q(wordSpace).J(" Tw").V(this.b);
    }

    public void c1(y5 bf, float size) {
        if (!this.f2721a && p0()) {
            B(true);
        }
        F();
        if (size >= 1.0E-4f || size <= -1.0E-4f) {
            a aVar = this.f2715a;
            aVar.a = size;
            aVar.f2727a = this.f2719a.r(bf);
            this.f2720a.K(j0().e(this.f2715a.f2727a.e(), this.f2715a.f2727a.g()).q()).f(' ').q(size).J(" Tf").V(this.b);
            return;
        }
        throw new IllegalArgumentException(i10.b("font.size.too.small.1", String.valueOf(size)));
    }

    public void F1(int rendering) {
        if (!this.f2721a && p0()) {
            B(true);
        }
        this.f2715a.f2725a = rendering;
        this.f2720a.w(rendering).J(" Tr").V(this.b);
    }

    public void H1(float rise) {
        G1((double) rise);
    }

    public void G1(double rise) {
        if (!this.f2721a && p0()) {
            B(true);
        }
        this.f2720a.o(rise).J(" Ts").V(this.b);
    }

    private void L1(String text) {
        jn jnVar = this.f2715a.f2727a;
        if (jnVar != null) {
            qn0.b(jnVar.b(text), this.f2720a);
            return;
        }
        throw new NullPointerException(i10.b("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
    }

    public void K1(String text) {
        E();
        if (!this.f2721a && p0()) {
            B(true);
        }
        L1(text);
        Q1(text, 0.0f);
        this.f2720a.J("Tj").V(this.b);
    }

    public void E1(float a2, float b2, float c2, float d, float x, float y) {
        if (!this.f2721a && p0()) {
            B(true);
        }
        a aVar = this.f2715a;
        aVar.b = x;
        aVar.c = y;
        aVar.d = a2;
        aVar.e = b2;
        aVar.f = c2;
        aVar.g = d;
        aVar.h = x;
        this.f2720a.q(a2).f(' ').q(b2).V(32).q(c2).V(32).q(d).V(32).q(x).V(32).q(y).J(" Tm").V(this.b);
    }

    public void D1(float x, float y) {
        E1(1.0f, 0.0f, 0.0f, 1.0f, x, y);
    }

    public void t0(float x, float y) {
        if (!this.f2721a && p0()) {
            B(true);
        }
        a aVar = this.f2715a;
        aVar.b += x;
        aVar.c += y;
        if (p0()) {
            a aVar2 = this.f2715a;
            float f = aVar2.b;
            if (f != aVar2.h) {
                E1(aVar2.d, aVar2.e, aVar2.f, aVar2.g, f, aVar2.c);
                return;
            }
        }
        this.f2720a.q(x).f(' ').q(y).J(" Td").V(this.b);
    }

    /* access modifiers changed from: package-private */
    public int M1() {
        return N1(true);
    }

    /* access modifiers changed from: package-private */
    public int N1(boolean includeMarkedContentSize) {
        if (includeMarkedContentSize) {
            return this.f2720a.b0();
        }
        return this.f2720a.b0() - this.f2714a;
    }

    private float e0(String text, boolean kerned, float kerning) {
        float w;
        y5 bf = this.f2715a.f2727a.d();
        if (kerned) {
            w = bf.x(text, this.f2715a.a);
        } else {
            w = bf.w(text, this.f2715a.a);
        }
        if (this.f2715a.k != 0.0f && text.length() > 0) {
            w += this.f2715a.k * ((float) text.length());
        }
        if (this.f2715a.l != 0.0f && !bf.B()) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    w += this.f2715a.l;
                }
            }
        }
        a aVar = this.f2715a;
        float w2 = w - ((kerning / 1000.0f) * aVar.a);
        float f = aVar.j;
        if (((double) f) != 100.0d) {
            return (f * w2) / 100.0f;
        }
        return w2;
    }

    public void P(float a2, float b2, float c2, float d, float e, float f) {
        O((double) a2, (double) b2, (double) c2, (double) d, (double) e, (double) f);
    }

    public void O(double a2, double b2, double c2, double d, double e, double f) {
        if (this.f2721a && p0()) {
            V();
        }
        double d2 = b2;
        double d3 = c2;
        double d4 = d;
        double d5 = e;
        double d6 = f;
        this.f2715a.f2726a.a(new f2(a2, d2, d3, d4, d5, d6));
        this.f2720a.o(a2).f(' ').o(d2).f(' ').o(d3).f(' ');
        this.f2720a.o(d4).f(' ').o(d5).f(' ').o(d6).J(" cm").V(this.b);
    }

    public static ArrayList<double[]> C(double x1, double y1, double x2, double y2, double startAng, double extent) {
        double x22;
        double x12;
        double y22;
        double y12;
        int Nfrag;
        double fragAngle;
        double fragAngle2;
        ArrayList<double[]> pointList;
        if (x1 > x2) {
            x12 = x2;
            x22 = x1;
        } else {
            x12 = x1;
            x22 = x2;
        }
        if (y2 > y1) {
            y12 = y2;
            y22 = y1;
        } else {
            y12 = y1;
            y22 = y2;
        }
        if (Math.abs(extent) <= 90.0d) {
            fragAngle = extent;
            Nfrag = 1;
        } else {
            Nfrag = (int) Math.ceil(Math.abs(extent) / 90.0d);
            fragAngle = extent / ((double) Nfrag);
        }
        double x_cen = (x12 + x22) / 2.0d;
        double y_cen = (y12 + y22) / 2.0d;
        double rx = (x22 - x12) / 2.0d;
        double ry = (y22 - y12) / 2.0d;
        double halfAng = (fragAngle * 3.141592653589793d) / 360.0d;
        double kappa = Math.abs(((1.0d - Math.cos(halfAng)) * 1.3333333333333333d) / Math.sin(halfAng));
        ArrayList<double[]> pointList2 = new ArrayList<>();
        int i = 0;
        while (i < Nfrag) {
            double x13 = x12;
            double theta0 = ((startAng + (((double) i) * fragAngle)) * 3.141592653589793d) / 180.0d;
            double x23 = x22;
            double theta1 = ((startAng + (((double) (i + 1)) * fragAngle)) * 3.141592653589793d) / 180.0d;
            double cos0 = Math.cos(theta0);
            double cos1 = Math.cos(theta1);
            double sin0 = Math.sin(theta0);
            double sin1 = Math.sin(theta1);
            if (fragAngle > 0.0d) {
                fragAngle2 = fragAngle;
                pointList = pointList2;
                pointList.add(new double[]{x_cen + (rx * cos0), y_cen - (ry * sin0), x_cen + ((cos0 - (kappa * sin0)) * rx), y_cen - ((sin0 + (kappa * cos0)) * ry), x_cen + ((cos1 + (kappa * sin1)) * rx), y_cen - ((sin1 - (kappa * cos1)) * ry), x_cen + (rx * cos1), y_cen - (ry * sin1)});
            } else {
                fragAngle2 = fragAngle;
                pointList = pointList2;
                pointList.add(new double[]{x_cen + (rx * cos0), y_cen - (ry * sin0), x_cen + ((cos0 + (kappa * sin0)) * rx), y_cen - ((sin0 - (kappa * cos0)) * ry), x_cen + ((cos1 - (kappa * sin1)) * rx), y_cen - ((sin1 + (kappa * cos1)) * ry), x_cen + (rx * cos1), y_cen - (ry * sin1)});
            }
            i++;
            x12 = x13;
            pointList2 = pointList;
            x22 = x23;
            fragAngle = fragAngle2;
        }
        return pointList2;
    }

    public void t(float x1, float y1, float x2, float y2, float startAng, float extent) {
        r((double) x1, (double) y1, (double) x2, (double) y2, (double) startAng, (double) extent);
    }

    public void r(double x1, double y1, double x2, double y2, double startAng, double extent) {
        ArrayList<double[]> ar = C(x1, y1, x2, y2, startAng, extent);
        if (!ar.isEmpty()) {
            double[] pt = ar.get(0);
            u0(pt[0], pt[1]);
            for (int k = 0; k < ar.size(); k++) {
                double[] pt2 = ar.get(k);
                S(pt2[2], pt2[3], pt2[4], pt2[5], pt2[6], pt2[7]);
            }
        }
    }

    public q80 Q(float width, float height) {
        return R(width, height, (h70) null);
    }

    /* access modifiers changed from: package-private */
    public q80 R(float width, float height, h70 forcedName) {
        F();
        q80 template = new q80(this.f2719a);
        template.k2(width);
        template.i2(height);
        this.f2719a.n(template, forcedName);
        return template;
    }

    private void q(q80 template, double a2, double b2, double c2, double d, double e, double f, boolean tagTemplate, boolean tagContent) {
        q80 q80 = template;
        F();
        D(template);
        v80.H(this.f2719a, 20, q80);
        h70 name = this.f2719a.n(q80, (h70) null);
        e50 prs = j0();
        h70 name2 = prs.h(name, template.Z1());
        if (p0() && tagTemplate) {
            if (this.f2721a) {
                V();
            }
            if (template.g2() || (template.c2() != null && tagContent)) {
                throw new RuntimeException(i10.b("template.with.tagged.could.not.be.used.more.than.once", new Object[0]));
            }
            q80.j2(this.f2719a.V());
            if (tagContent) {
                q80.h2(true);
                W();
                ArrayList<br> i0 = i0();
                if (i0 != null && i0.size() > 0) {
                    template.i0().add(i0.get(i0.size() - 1));
                }
            } else {
                x0(template);
            }
        }
        this.f2720a.J("q ");
        this.f2720a.o(a2).f(' ');
        this.f2720a.o(b2).f(' ');
        this.f2720a.o(c2).f(' ');
        this.f2720a.o(d).f(' ');
        e50 e50 = prs;
        this.f2720a.o(e).f(' ');
        this.f2720a.o(f).J(" cm ");
        this.f2720a.K(name2.q()).J(" Do Q").V(this.b);
        if (p0() && tagTemplate && !tagContent) {
            H(template);
            q80.h((g0) null);
        }
    }

    public void z1(int red, int green, int blue) {
        O0(new w5(red, green, blue), true);
        c(((float) (red & 255)) / 255.0f, ((float) (green & 255)) / 255.0f, ((float) (blue & 255)) / 255.0f);
        this.f2720a.J(" rg").V(this.b);
    }

    public void A1(int red, int green, int blue) {
        O0(new w5(red, green, blue), false);
        c(((float) (red & 255)) / 255.0f, ((float) (green & 255)) / 255.0f, ((float) (blue & 255)) / 255.0f);
        this.f2720a.J(" RG").V(this.b);
    }

    public void Y0(w5 color) {
        switch (dk.i(color)) {
            case 1:
                f1(((cq) color).k());
                break;
            case 2:
                f7 cmyk = (f7) color;
                S0(cmyk.l(), cmyk.m(), cmyk.n(), cmyk.k());
                break;
            case 3:
                qm0 spot = (qm0) color;
                b1(spot.k(), spot.l());
                break;
            case 4:
                w1(((p50) color).k());
                break;
            case 5:
                C1(((fl0) color).k());
                break;
            case 6:
                hg devicen = (hg) color;
                Z0(devicen.k(), devicen.l());
                break;
            case 7:
                nw lab = (nw) color;
                a1(lab.n(), lab.m(), lab.k(), lab.l());
                break;
            default:
                A1(color.e(), color.c(), color.b());
                break;
        }
        int alpha = color.a();
        if (alpha < 255) {
            u60 gState = new u60();
            gState.U(((float) alpha) / 255.0f);
            d1(gState);
        }
    }

    public void U0(w5 color) {
        switch (dk.i(color)) {
            case 1:
                e1(((cq) color).k());
                break;
            case 2:
                f7 cmyk = (f7) color;
                R0(cmyk.l(), cmyk.m(), cmyk.n(), cmyk.k());
                break;
            case 3:
                qm0 spot = (qm0) color;
                X0(spot.k(), spot.l());
                break;
            case 4:
                t1(((p50) color).k());
                break;
            case 5:
                B1(((fl0) color).k());
                break;
            case 6:
                hg devicen = (hg) color;
                V0(devicen.k(), devicen.l());
                break;
            case 7:
                nw lab = (nw) color;
                W0(lab.n(), lab.m(), lab.k(), lab.l());
                break;
            default:
                z1(color.e(), color.c(), color.b());
                break;
        }
        int alpha = color.a();
        if (alpha < 255) {
            u60 gState = new u60();
            gState.T(((float) alpha) / 255.0f);
            d1(gState);
        }
    }

    public void X0(k80 sp, float tint) {
        F();
        this.f2715a.f2730a = this.f2719a.q(sp);
        h70 name = j0().a(this.f2715a.f2730a.a(), this.f2715a.f2730a.b());
        O0(new qm0(sp, tint), true);
        this.f2720a.K(name.q()).J(" cs ").q(tint).J(" scn").V(this.b);
    }

    public void V0(i60 dn, float[] tints) {
        F();
        this.f2715a.f2730a = this.f2719a.q(dn);
        h70 name = j0().a(this.f2715a.f2730a.a(), this.f2715a.f2730a.b());
        O0(new hg(dn, tints), true);
        this.f2720a.K(name.q()).J(" cs ");
        for (float tint : tints) {
            w6 w6Var = this.f2720a;
            w6Var.J(tint + " ");
        }
        this.f2720a.J("scn").V(this.b);
    }

    public void W0(c70 lab, float l, float a2, float b2) {
        F();
        this.f2715a.f2730a = this.f2719a.q(lab);
        h70 name = j0().a(this.f2715a.f2730a.a(), this.f2715a.f2730a.b());
        O0(new nw(lab, l, a2, b2), true);
        this.f2720a.K(name.q()).J(" cs ");
        w6 w6Var = this.f2720a;
        w6Var.J(l + " " + a2 + " " + b2 + " ");
        this.f2720a.J("scn").V(this.b);
    }

    public void b1(k80 sp, float tint) {
        F();
        this.f2715a.f2730a = this.f2719a.q(sp);
        h70 name = j0().a(this.f2715a.f2730a.a(), this.f2715a.f2730a.b());
        O0(new qm0(sp, tint), false);
        this.f2720a.K(name.q()).J(" CS ").q(tint).J(" SCN").V(this.b);
    }

    public void Z0(i60 sp, float[] tints) {
        F();
        this.f2715a.f2730a = this.f2719a.q(sp);
        h70 name = j0().a(this.f2715a.f2730a.a(), this.f2715a.f2730a.b());
        O0(new hg(sp, tints), true);
        this.f2720a.K(name.q()).J(" CS ");
        for (float tint : tints) {
            w6 w6Var = this.f2720a;
            w6Var.J(tint + " ");
        }
        this.f2720a.J("SCN").V(this.b);
    }

    public void a1(c70 lab, float l, float a2, float b2) {
        F();
        this.f2715a.f2730a = this.f2719a.q(lab);
        h70 name = j0().a(this.f2715a.f2730a.a(), this.f2715a.f2730a.b());
        O0(new nw(lab, l, a2, b2), true);
        this.f2720a.K(name.q()).J(" CS ");
        w6 w6Var = this.f2720a;
        w6Var.J(l + " " + a2 + " " + b2 + " ");
        this.f2720a.J("SCN").V(this.b);
    }

    public void t1(d80 p) {
        if (p.n2()) {
            u1(p, p.l2());
            return;
        }
        F();
        h70 name = j0().f(this.f2719a.t(p), p.Z1());
        O0(new p50(p), true);
        this.f2720a.K(h70.z8.q()).J(" cs ").K(name.q()).J(" scn").V(this.b);
    }

    /* access modifiers changed from: package-private */
    public void z0(w5 color, float tint) {
        v80.H(this.f2719a, 1, color);
        switch (dk.i(color)) {
            case 0:
                this.f2720a.q(((float) color.e()) / 255.0f);
                this.f2720a.f(' ');
                this.f2720a.q(((float) color.c()) / 255.0f);
                this.f2720a.f(' ');
                this.f2720a.q(((float) color.b()) / 255.0f);
                return;
            case 1:
                this.f2720a.q(((cq) color).k());
                return;
            case 2:
                f7 cmyk = (f7) color;
                this.f2720a.q(cmyk.l()).f(' ').q(cmyk.m());
                this.f2720a.f(' ').q(cmyk.n()).f(' ').q(cmyk.k());
                return;
            case 3:
                this.f2720a.q(tint);
                return;
            default:
                throw new RuntimeException(i10.b("invalid.color.type", new Object[0]));
        }
    }

    public void u1(d80 p, w5 color) {
        if (dk.i(color) == 3) {
            v1(p, color, ((qm0) color).l());
        } else {
            v1(p, color, 0.0f);
        }
    }

    public void v1(d80 p, w5 color, float tint) {
        F();
        if (p.n2()) {
            e50 prs = j0();
            h70 name = prs.f(this.f2719a.t(p), p.Z1());
            w9 csDetail = this.f2719a.u(color);
            h70 cName = prs.a(csDetail.a(), csDetail.b());
            O0(new b(p, color, tint), true);
            this.f2720a.K(cName.q()).J(" cs").V(this.b);
            z0(color, tint);
            this.f2720a.f(' ').K(name.q()).J(" scn").V(this.b);
            return;
        }
        throw new RuntimeException(i10.b("an.uncolored.pattern.was.expected", new Object[0]));
    }

    public void x1(d80 p, w5 color) {
        if (dk.i(color) == 3) {
            y1(p, color, ((qm0) color).l());
        } else {
            y1(p, color, 0.0f);
        }
    }

    public void y1(d80 p, w5 color, float tint) {
        F();
        if (p.n2()) {
            e50 prs = j0();
            h70 name = prs.f(this.f2719a.t(p), p.Z1());
            w9 csDetail = this.f2719a.u(color);
            h70 cName = prs.a(csDetail.a(), csDetail.b());
            O0(new b(p, color, tint), false);
            this.f2720a.K(cName.q()).J(" CS").V(this.b);
            z0(color, tint);
            this.f2720a.f(' ').K(name.q()).J(" SCN").V(this.b);
            return;
        }
        throw new RuntimeException(i10.b("an.uncolored.pattern.was.expected", new Object[0]));
    }

    public void w1(d80 p) {
        if (p.n2()) {
            x1(p, p.l2());
            return;
        }
        F();
        h70 name = j0().f(this.f2719a.t(p), p.Z1());
        O0(new p50(p), false);
        this.f2720a.K(h70.z8.q()).J(" CS ").K(name.q()).J(" SCN").V(this.b);
    }

    public void B1(j80 shading) {
        this.f2719a.x(shading);
        e50 prs = j0();
        h70 name = prs.f(shading.V(), shading.W());
        O0(new fl0(shading), true);
        this.f2720a.K(h70.z8.q()).J(" cs ").K(name.q()).J(" scn").V(this.b);
        w9 details = shading.U();
        if (details != null) {
            prs.a(details.a(), details.b());
        }
    }

    public void C1(j80 shading) {
        this.f2719a.x(shading);
        e50 prs = j0();
        h70 name = prs.f(shading.V(), shading.W());
        O0(new fl0(shading), false);
        this.f2720a.K(h70.z8.q()).J(" CS ").K(name.q()).J(" SCN").V(this.b);
        w9 details = shading.U();
        if (details != null) {
            prs.a(details.a(), details.b());
        }
    }

    /* access modifiers changed from: protected */
    public void F() {
        if (this.f2719a == null) {
            throw new NullPointerException(i10.b("the.writer.in.pdfcontentbyte.is.null", new Object[0]));
        }
    }

    public void J1(r80 text) {
        E();
        if (!this.f2721a && p0()) {
            B(true);
        }
        if (this.f2715a.f2727a != null) {
            this.f2720a.J("[");
            boolean lastWasNumber = false;
            Iterator i$ = text.c().iterator();
            while (i$.hasNext()) {
                Object obj = i$.next();
                if (obj instanceof String) {
                    L1((String) obj);
                    Q1((String) obj, 0.0f);
                    lastWasNumber = false;
                } else {
                    if (lastWasNumber) {
                        this.f2720a.f(' ');
                    } else {
                        lastWasNumber = true;
                    }
                    this.f2720a.q(((Float) obj).floatValue());
                    Q1("", ((Float) obj).floatValue());
                }
            }
            this.f2720a.J("]TJ").V(this.b);
            return;
        }
        throw new NullPointerException(i10.b("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
    }

    public v80 m0() {
        return this.f2719a;
    }

    public l60 l0() {
        return this.f2718a;
    }

    public d60 c0() {
        d60 cb = new d60(this.f2719a);
        cb.f2716a = this;
        return cb;
    }

    public d60 d0(boolean inheritGraphicState) {
        d60 cb = c0();
        if (inheritGraphicState) {
            cb.f2715a = this.f2715a;
            cb.f2717a = this.f2717a;
        }
        return cb;
    }

    public void M0(float x, float y, float w, float h, float r) {
        L0((double) x, (double) y, (double) w, (double) h, (double) r);
    }

    public void L0(double x, double y, double w, double h, double r) {
        double w2;
        double x2;
        double h2;
        double y2;
        double r2;
        double d = w;
        double d2 = h;
        double d3 = r;
        if (d < 0.0d) {
            w2 = -d;
            x2 = x + d;
        } else {
            x2 = x;
            w2 = d;
        }
        if (d2 < 0.0d) {
            y2 = y + d2;
            h2 = -d2;
        } else {
            y2 = y;
            h2 = d2;
        }
        if (d3 < 0.0d) {
            r2 = -d3;
        } else {
            r2 = d3;
        }
        u0(x2 + r2, y2);
        r0((x2 + w2) - r2, y2);
        double d4 = y2;
        double y3 = y2;
        S((x2 + w2) - (((double) 0.4477f) * r2), d4, x2 + w2, y2 + (((double) 0.4477f) * r2), x2 + w2, y2 + r2);
        r0(x2 + w2, (y3 + h2) - r2);
        S(x2 + w2, (y3 + h2) - (((double) 0.4477f) * r2), (x2 + w2) - (((double) 0.4477f) * r2), y3 + h2, (x2 + w2) - r2, y3 + h2);
        r0(x2 + r2, y3 + h2);
        S(x2 + (((double) 0.4477f) * r2), y3 + h2, x2, (y3 + h2) - (((double) 0.4477f) * r2), x2, (y3 + h2) - r2);
        r0(x2, y3 + r2);
        S(x2, y3 + (((double) 0.4477f) * r2), x2 + (((double) 0.4477f) * r2), y3, x2 + r2, y3);
    }

    public void q1(String s) {
        this.f2720a.J(s);
    }

    /* access modifiers changed from: package-private */
    public void D(q80 t) {
        if (t.e2() == 3) {
            throw new RuntimeException(i10.b("invalid.use.of.a.pattern.a.template.was.expected", new Object[0]));
        }
    }

    /* access modifiers changed from: package-private */
    public e50 j0() {
        return this.f2718a.P();
    }

    public void d1(u60 gstate) {
        o70[] obj = this.f2719a.s(gstate);
        h70 name = j0().d((h70) obj[0], (z60) obj[1]);
        this.f2715a.f2728a = gstate;
        this.f2720a.K(name.q()).J(" gs").V(this.b);
    }

    public void v(m70 layer) {
        if (this.f2722b == null) {
            this.f2722b = new ArrayList<>();
        }
        b6.a(layer);
        this.f2722b.add(0);
    }

    public void T() {
        ArrayList<Integer> arrayList = this.f2722b;
        if (arrayList == null || arrayList.isEmpty()) {
            throw new sr(i10.b("unbalanced.layer.operators", new Object[0]));
        }
        ArrayList<Integer> arrayList2 = this.f2722b;
        int n = arrayList2.get(arrayList2.size() - 1).intValue();
        ArrayList<Integer> arrayList3 = this.f2722b;
        arrayList3.remove(arrayList3.size() - 1);
        while (true) {
            int n2 = n - 1;
            if (n > 0) {
                this.f2720a.J("EMC").V(this.b);
                n = n2;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(v50 annot) {
        boolean needToTag = p0() && annot.j() != null && (!(annot instanceof s60) || ((s60) annot).d0() == null);
        if (needToTag) {
            x0(annot);
        }
        this.f2719a.k(annot);
        if (needToTag) {
            o80 strucElem = this.f2718a.Q(annot.s());
            if (strucElem != null) {
                int structParent = this.f2718a.T(annot);
                annot.Q(h70.mb, new k70(structParent));
                strucElem.b0(annot, b0());
                this.f2719a.r0().Y(structParent, strucElem.Y());
            }
            H(annot);
        }
    }

    public void f(v50 annot, boolean applyCTM) {
        if (applyCTM && this.f2715a.f2726a.b() != 0) {
            annot.T(this.f2715a.f2726a);
        }
        e(annot);
    }

    public void y(o80 struc) {
        z(struc, (String) null);
    }

    private void z(o80 struc, String expansion) {
        x50 ar;
        h70 h70 = h70.X5;
        o70 obj = struc.I(h70);
        int[] structParentMarkPoint = this.f2718a.U(b0());
        int structParent = structParentMarkPoint[0];
        int mark = structParentMarkPoint[1];
        if (obj != null) {
            if (obj.C()) {
                ar = new x50();
                ar.I(obj);
                struc.Q(h70, ar);
            } else if (obj.t()) {
                ar = (x50) obj;
            } else {
                throw new IllegalArgumentException(i10.b("unknown.object.at.k.1", obj.getClass().toString()));
            }
            if (ar.Q(0) != null) {
                j60 dic = new j60(h70.S6);
                dic.Q(h70.I8, b0());
                dic.Q(h70.R6, new k70(mark));
                ar.I(dic);
            }
            struc.e0(this.f2718a.T(b0()), -1);
        } else {
            struc.e0(structParent, mark);
            struc.Q(h70.I8, b0());
        }
        r1(h0() + 1);
        int contentSize = this.f2720a.b0();
        this.f2720a.K(struc.I(h70.ta).q()).J(" <</MCID ").w(mark);
        if (expansion != null) {
            this.f2720a.J("/E (").J(expansion).J(")");
        }
        this.f2720a.J(">> BDC").V(this.b);
        this.f2714a += this.f2720a.b0() - contentSize;
    }

    /* access modifiers changed from: protected */
    public z60 b0() {
        return this.f2719a.V();
    }

    public void U() {
        if (h0() != 0) {
            int contentSize = this.f2720a.b0();
            r1(h0() - 1);
            this.f2720a.J("EMC").V(this.b);
            this.f2714a += this.f2720a.b0() - contentSize;
            return;
        }
        throw new sr(i10.b("unbalanced.begin.end.marked.content.operators", new Object[0]));
    }

    public void x(h70 tag, j60 property, boolean inline) {
        o70[] objs;
        int contentSize = this.f2720a.b0();
        if (property == null) {
            this.f2720a.K(tag.q()).J(" BMC").V(this.b);
            r1(h0() + 1);
        } else {
            this.f2720a.K(tag.q()).f(' ');
            if (inline) {
                try {
                    property.F(this.f2719a, this.f2720a);
                } catch (Exception e) {
                    throw new mj(e);
                }
            } else {
                if (this.f2719a.B0(property)) {
                    objs = this.f2719a.v(property, (z60) null);
                } else {
                    v80 v80 = this.f2719a;
                    objs = v80.v(property, v80.m0());
                }
                this.f2720a.K(j0().g((h70) objs[0], (z60) objs[1]).q());
            }
            this.f2720a.J(" BDC").V(this.b);
            r1(h0() + 1);
        }
        this.f2714a += this.f2720a.b0() - contentSize;
    }

    public void w(h70 tag) {
        x(tag, (j60) null, false);
    }

    public void N0() {
        if (h0() == 0) {
            if (this.f2721a) {
                if (p0()) {
                    V();
                } else {
                    throw new sr(i10.b("unbalanced.begin.end.text.operators", new Object[0]));
                }
            }
            ArrayList<Integer> arrayList = this.f2722b;
            if (arrayList != null && !arrayList.isEmpty()) {
                throw new sr(i10.b("unbalanced.layer.operators", new Object[0]));
            } else if (!this.f2717a.isEmpty()) {
                throw new sr(i10.b("unbalanced.save.restore.state.operators", new Object[0]));
            }
        } else {
            throw new sr(i10.b("unbalanced.marked.content.operators", new Object[0]));
        }
    }

    public void x0(br element) {
        if (p0()) {
            W();
            if (element != null && !i0().contains(element)) {
                o80 structureElement = y0(element);
                i0().add(element);
                if (structureElement != null) {
                    this.f2718a.k0(element.s(), structureElement);
                }
            }
        }
    }

    private j60 k0() {
        j60 parent = null;
        if (i0().size() > 0) {
            parent = this.f2718a.Q(i0().get(i0().size() - 1).s());
        }
        if (parent == null) {
            return this.f2719a.r0();
        }
        return parent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private defpackage.o80 y0(defpackage.br r10) {
        /*
            r9 = this;
            r0 = 0
            boolean r1 = r9.p0()
            if (r1 == 0) goto L_0x00ea
            r1 = 0
            java.util.ArrayList r2 = r9.i0()
            int r2 = r2.size()
            r3 = 1
            if (r2 <= 0) goto L_0x0027
            java.util.ArrayList r2 = r9.i0()
            java.util.ArrayList r4 = r9.i0()
            int r4 = r4.size()
            int r4 = r4 - r3
            java.lang.Object r2 = r2.get(r4)
            r1 = r2
            br r1 = (defpackage.br) r1
        L_0x0027:
            v80 r2 = r9.f2719a
            r2.F(r10, r1)
            h70 r2 = r10.j()
            if (r2 == 0) goto L_0x00ea
            h70 r2 = defpackage.h70.O
            h70 r4 = r10.j()
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L_0x005c
            l60 r4 = r9.f2718a
            g0 r5 = r10.s()
            o80 r0 = r4.Q(r5)
            if (r0 != 0) goto L_0x005c
            o80 r4 = new o80
            j60 r5 = r9.k0()
            h70 r6 = r10.j()
            g0 r7 = r10.s()
            r4.<init>(r5, r6, r7)
            r0 = r4
        L_0x005c:
            h70 r4 = r10.j()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00b3
            java.util.HashMap r2 = r10.u()
            r4 = 0
            if (r2 == 0) goto L_0x009d
            boolean r5 = r2.isEmpty()
            if (r5 != 0) goto L_0x009d
            j60 r5 = new j60
            r5.<init>()
            r4 = r5
            java.util.Set r5 = r2.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0081:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x009d
            java.lang.Object r6 = r5.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getKey()
            h70 r7 = (defpackage.h70) r7
            java.lang.Object r8 = r6.getValue()
            o70 r8 = (defpackage.o70) r8
            r4.Q(r7, r8)
            goto L_0x0081
        L_0x009d:
            boolean r5 = r9.f2721a
            boolean r6 = r9.f2721a
            if (r6 == 0) goto L_0x00a6
            r9.V()
        L_0x00a6:
            h70 r6 = r10.j()
            r9.x(r6, r4, r3)
            if (r5 == 0) goto L_0x00b2
            r9.B(r3)
        L_0x00b2:
            goto L_0x00ea
        L_0x00b3:
            v80 r2 = r9.f2719a
            boolean r2 = r2.A0(r10)
            if (r2 == 0) goto L_0x00ea
            boolean r2 = r9.f2721a
            boolean r4 = r9.f2721a
            if (r4 == 0) goto L_0x00c4
            r9.V()
        L_0x00c4:
            java.util.HashMap r4 = r10.u()
            if (r4 == 0) goto L_0x00e2
            h70 r4 = defpackage.h70.T2
            o70 r5 = r10.l(r4)
            if (r5 == 0) goto L_0x00e2
            o70 r5 = r10.l(r4)
            java.lang.String r5 = r5.toString()
            r9.z(r0, r5)
            r5 = 0
            r10.p(r4, r5)
            goto L_0x00e5
        L_0x00e2:
            r9.y(r0)
        L_0x00e5:
            if (r2 == 0) goto L_0x00ea
            r9.B(r3)
        L_0x00ea:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d60.y0(br):o80");
    }

    public void H(br element) {
        if (p0() && element != null && i0().contains(element)) {
            I(element);
            i0().remove(element);
        }
    }

    private void I(br element) {
        if (p0() && element.j() != null) {
            o80 structureElement = this.f2718a.Q(element.s());
            if (structureElement != null) {
                structureElement.h0(element);
            }
            if (this.f2719a.A0(element)) {
                boolean inTextLocal = this.f2721a;
                if (this.f2721a) {
                    V();
                }
                U();
                if (inTextLocal) {
                    B(true);
                }
            }
        }
    }

    private void W() {
        l60 l60 = this.f2718a;
        if (l60.f4232h) {
            l60.f4232h = false;
            this.f2719a.Z().x0(this.f2718a);
        }
    }

    /* access modifiers changed from: protected */
    public ArrayList<br> P0() {
        ArrayList<br> arrayList = new ArrayList<>();
        if (p0()) {
            arrayList = i0();
            for (int i = 0; i < arrayList.size(); i++) {
                I(arrayList.get(i));
            }
            s1(new ArrayList());
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void J0(ArrayList<br> mcElements) {
        if (p0() && mcElements != null) {
            s1(mcElements);
            for (int i = 0; i < i0().size(); i++) {
                y0(i0().get(i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public int h0() {
        d60 d60 = this.f2716a;
        if (d60 != null) {
            return d60.h0();
        }
        return this.c;
    }

    /* access modifiers changed from: protected */
    public void r1(int value) {
        d60 d60 = this.f2716a;
        if (d60 != null) {
            d60.r1(value);
        } else {
            this.c = value;
        }
    }

    /* access modifiers changed from: protected */
    public ArrayList<br> i0() {
        d60 d60 = this.f2716a;
        if (d60 != null) {
            return d60.i0();
        }
        return this.f2724c;
    }

    /* access modifiers changed from: protected */
    public void s1(ArrayList<br> value) {
        d60 d60 = this.f2716a;
        if (d60 != null) {
            d60.s1(value);
        } else {
            this.f2724c = value;
        }
    }

    /* access modifiers changed from: protected */
    public void Q1(String text, float Tj) {
        this.f2715a.h += e0(text, false, Tj);
    }

    private void O0(w5 color, boolean fill) {
        if (fill) {
            this.f2715a.f2729a = color;
        } else {
            this.f2715a.f2731b = color;
        }
    }

    /* renamed from: d60$b */
    static class b extends p50 {
        protected float a;
        protected w5 n;

        protected b(d80 p, w5 color, float tint) {
            super(p);
            this.n = color;
            this.a = tint;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            ((b) obj).a.equals(this.a);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean f0() {
        return this.f2721a;
    }

    /* access modifiers changed from: protected */
    public void E() {
        boolean stroke = false;
        boolean fill = false;
        a aVar = this.f2715a;
        int i = aVar.f2725a;
        if (i == 0) {
            fill = true;
        } else if (i == 1) {
            stroke = true;
        } else if (i == 2) {
            fill = true;
            stroke = true;
        }
        if (fill) {
            v80.H(this.f2719a, 1, aVar.f2729a);
        }
        if (stroke) {
            v80.H(this.f2719a, 1, this.f2715a.f2731b);
        }
        v80.H(this.f2719a, 6, this.f2715a.f2728a);
    }
}
