package defpackage;

import defpackage.p90;
import java.io.Serializable;

/* renamed from: f2  reason: default package */
public class f2 implements Cloneable, Serializable {
    double a;

    /* renamed from: a  reason: collision with other field name */
    transient int f2937a;
    double b;
    double c;
    double d;
    double e;
    double f;

    public f2() {
        this.f2937a = 0;
        this.d = 1.0d;
        this.a = 1.0d;
        this.f = 0.0d;
        this.e = 0.0d;
        this.c = 0.0d;
        this.b = 0.0d;
    }

    public f2(f2 t) {
        this.f2937a = t.f2937a;
        this.a = t.a;
        this.b = t.b;
        this.c = t.c;
        this.d = t.d;
        this.e = t.e;
        this.f = t.f;
    }

    public f2(double m00, double m10, double m01, double m11, double m02, double m12) {
        this.f2937a = -1;
        this.a = m00;
        this.b = m10;
        this.c = m01;
        this.d = m11;
        this.e = m02;
        this.f = m12;
    }

    public int b() {
        int i = this.f2937a;
        if (i != -1) {
            return i;
        }
        int type = 0;
        double d2 = this.a;
        double d3 = this.c;
        double d4 = this.b;
        double d5 = this.d;
        if ((d2 * d3) + (d4 * d5) != 0.0d) {
            return 0 | 32;
        }
        if (this.e != 0.0d || this.f != 0.0d) {
            type = 0 | 1;
        } else if (d2 == 1.0d && d5 == 1.0d && d3 == 0.0d && d4 == 0.0d) {
            return 0;
        }
        if ((d2 * d5) - (d3 * d4) < 0.0d) {
            type |= 64;
        }
        double dx = (d2 * d2) + (d4 * d4);
        if (dx != (d3 * d3) + (d5 * d5)) {
            type |= 4;
        } else if (dx != 1.0d) {
            type |= 2;
        }
        if ((d2 == 0.0d && d5 == 0.0d) || (d4 == 0.0d && d3 == 0.0d && (d2 < 0.0d || d5 < 0.0d))) {
            return type | 8;
        }
        if (d3 == 0.0d && d4 == 0.0d) {
            return type;
        }
        return type | 16;
    }

    public boolean c() {
        return b() == 0;
    }

    public void e(double m00, double m10, double m01, double m11, double m02, double m12) {
        this.f2937a = -1;
        this.a = m00;
        this.b = m10;
        this.c = m01;
        this.d = m11;
        this.e = m02;
        this.f = m12;
    }

    public void h(f2 t) {
        this.f2937a = t.f2937a;
        e(t.a, t.b, t.c, t.d, t.e, t.f);
    }

    /* access modifiers changed from: package-private */
    public f2 d(f2 t1, f2 t2) {
        f2 f2Var = t1;
        f2 f2Var2 = t2;
        double d2 = f2Var.a;
        double d3 = f2Var2.a;
        double d4 = f2Var.b;
        double d5 = f2Var2.c;
        double d6 = f2Var2.b;
        double d7 = (d2 * d3) + (d4 * d5);
        double d8 = f2Var2.d;
        double d9 = (d4 * d8) + (d2 * d6);
        double d10 = f2Var.c;
        double d11 = d9;
        double d12 = f2Var.d;
        double d13 = (d10 * d3) + (d12 * d5);
        double d14 = (d10 * d6) + (d12 * d8);
        double d15 = f2Var.e;
        double d16 = f2Var.f;
        return new f2(d7, d11, d13, d14, (d3 * d15) + (d5 * d16) + f2Var2.e, (d15 * d6) + (d16 * d8) + f2Var2.f);
    }

    public void a(f2 t) {
        h(d(t, this));
    }

    public void j(p90[] src, int srcOff, p90[] dst, int dstOff, int length) {
        int srcOff2 = srcOff;
        int dstOff2 = dstOff;
        int length2 = length;
        while (true) {
            length2--;
            if (length2 >= 0) {
                int srcOff3 = srcOff2 + 1;
                p90 srcPoint = src[srcOff2];
                double x = srcPoint.a();
                double y = srcPoint.b();
                p90 dstPoint = dst[dstOff2];
                if (dstPoint == null) {
                    if (srcPoint instanceof p90.a) {
                        dstPoint = new p90.a();
                    } else {
                        dstPoint = new p90.b();
                    }
                }
                dstPoint.c((this.a * x) + (this.c * y) + this.e, (this.b * x) + (this.d * y) + this.f);
                dst[dstOff2] = dstPoint;
                srcOff2 = srcOff3;
                dstOff2++;
            } else {
                return;
            }
        }
    }

    public void i(float[] src, int srcOff, float[] dst, int dstOff, int length) {
        int step = 2;
        if (src == dst && srcOff < dstOff && dstOff < (length * 2) + srcOff) {
            srcOff = ((length * 2) + srcOff) - 2;
            dstOff = ((length * 2) + dstOff) - 2;
            step = -2;
        }
        while (true) {
            length--;
            if (length >= 0) {
                float x = src[srcOff + 0];
                float y = src[srcOff + 1];
                dst[dstOff + 0] = (float) ((((double) x) * this.a) + (((double) y) * this.c) + this.e);
                dst[dstOff + 1] = (float) ((((double) x) * this.b) + (((double) y) * this.d) + this.f);
                srcOff += step;
                dstOff += step;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return getClass().getName() + "[[" + this.a + ", " + this.c + ", " + this.e + "], [" + this.b + ", " + this.d + ", " + this.f + "]]";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new InternalError();
        }
    }

    public int hashCode() {
        nq hash = new nq();
        hash.a(this.a);
        hash.a(this.c);
        hash.a(this.e);
        hash.a(this.b);
        hash.a(this.d);
        hash.a(this.f);
        return hash.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        f2 t = (f2) obj;
        if (this.a == t.a && this.c == t.c && this.e == t.e && this.b == t.b && this.d == t.d && this.f == t.f) {
            return true;
        }
        return false;
    }
}
