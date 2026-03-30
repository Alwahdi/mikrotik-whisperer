package defpackage;

import com.itextpdf.text.a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: pd0  reason: default package */
public class pd0 implements bi {
    protected float a;

    /* renamed from: a  reason: collision with other field name */
    protected int f4698a;

    /* renamed from: a  reason: collision with other field name */
    protected w5 f4699a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f4700a;
    protected float b;

    /* renamed from: b  reason: collision with other field name */
    protected int f4701b;

    /* renamed from: b  reason: collision with other field name */
    protected w5 f4702b;
    protected float c;

    /* renamed from: c  reason: collision with other field name */
    protected w5 f4703c;
    protected float d;

    /* renamed from: d  reason: collision with other field name */
    protected w5 f4704d;
    protected float e;

    /* renamed from: e  reason: collision with other field name */
    protected w5 f4705e;
    protected float f;

    /* renamed from: f  reason: collision with other field name */
    protected w5 f4706f;
    protected float g;
    protected float h;
    protected float i;

    public pd0(float llx, float lly, float urx, float ury) {
        this.f4698a = 0;
        this.f4699a = null;
        this.f4701b = -1;
        this.f4700a = false;
        this.e = -1.0f;
        this.f = -1.0f;
        this.g = -1.0f;
        this.h = -1.0f;
        this.i = -1.0f;
        this.f4702b = null;
        this.f4703c = null;
        this.f4704d = null;
        this.f4705e = null;
        this.f4706f = null;
        this.a = llx;
        this.b = lly;
        this.c = urx;
        this.d = ury;
    }

    public pd0(float urx, float ury) {
        this(0.0f, 0.0f, urx, ury);
    }

    public pd0(pd0 rect) {
        this(rect.a, rect.b, rect.c, rect.d);
        e(rect);
    }

    public boolean a(ci listener) {
        try {
            return listener.c(this);
        } catch (ih e2) {
            return false;
        }
    }

    public int v() {
        return 30;
    }

    public List<a> t() {
        return new ArrayList();
    }

    public boolean r() {
        return true;
    }

    public void V(float llx) {
        this.a = llx;
    }

    public float E() {
        return this.a;
    }

    public float F(float margin) {
        return this.a + margin;
    }

    public void W(float urx) {
        this.c = urx;
    }

    public float G() {
        return this.c;
    }

    public float H(float margin) {
        return this.c - margin;
    }

    public float M() {
        return this.c - this.a;
    }

    public void Y(float ury) {
        this.d = ury;
    }

    public float J() {
        return this.d;
    }

    public float K(float margin) {
        return this.d - margin;
    }

    public void U(float lly) {
        this.b = lly;
    }

    public float B() {
        return this.b;
    }

    public float C(float margin) {
        return this.b + margin;
    }

    public float D() {
        return this.d - this.b;
    }

    public int I() {
        return this.f4698a;
    }

    public void X(int rotation) {
        int i2 = rotation % 360;
        this.f4698a = i2;
        switch (i2) {
            case 90:
            case 180:
            case 270:
                return;
            default:
                this.f4698a = 0;
                return;
        }
    }

    public w5 f() {
        return this.f4699a;
    }

    public void Q(w5 backgroundColor) {
        this.f4699a = backgroundColor;
    }

    public int g() {
        return this.f4701b;
    }

    public boolean O() {
        switch (this.f4701b) {
            case -1:
            case 0:
                return false;
            default:
                if (this.e > 0.0f || this.f > 0.0f || this.g > 0.0f || this.h > 0.0f || this.i > 0.0f) {
                    return true;
                }
                return false;
        }
    }

    public boolean N(int type) {
        int i2 = this.f4701b;
        if (i2 != -1 && (i2 & type) == type) {
            return true;
        }
        return false;
    }

    public void R(int border) {
        this.f4701b = border;
    }

    public boolean P() {
        return this.f4700a;
    }

    public float w() {
        return this.e;
    }

    public void T(float borderWidth) {
        this.e = borderWidth;
    }

    private float L(float variableWidthValue, int side) {
        if ((this.f4701b & side) != 0) {
            return variableWidthValue != -1.0f ? variableWidthValue : this.e;
        }
        return 0.0f;
    }

    public float y() {
        return L(this.f, 4);
    }

    public float z() {
        return L(this.g, 8);
    }

    public float A() {
        return L(this.h, 1);
    }

    public float x() {
        return L(this.i, 2);
    }

    public w5 i() {
        return this.f4702b;
    }

    public void S(w5 borderColor) {
        this.f4702b = borderColor;
    }

    public w5 n() {
        w5 w5Var = this.f4703c;
        if (w5Var == null) {
            return this.f4702b;
        }
        return w5Var;
    }

    public w5 o() {
        w5 w5Var = this.f4704d;
        if (w5Var == null) {
            return this.f4702b;
        }
        return w5Var;
    }

    public w5 q() {
        w5 w5Var = this.f4705e;
        if (w5Var == null) {
            return this.f4702b;
        }
        return w5Var;
    }

    public w5 k() {
        w5 w5Var = this.f4706f;
        if (w5Var == null) {
            return this.f4702b;
        }
        return w5Var;
    }

    public void e(pd0 rect) {
        this.f4698a = rect.f4698a;
        this.f4699a = rect.f4699a;
        this.f4701b = rect.f4701b;
        this.f4700a = rect.f4700a;
        this.e = rect.e;
        this.f = rect.f;
        this.g = rect.g;
        this.h = rect.h;
        this.i = rect.i;
        this.f4702b = rect.f4702b;
        this.f4703c = rect.f4703c;
        this.f4704d = rect.f4704d;
        this.f4705e = rect.f4705e;
        this.f4706f = rect.f4706f;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer("Rectangle: ");
        buf.append(M());
        buf.append('x');
        buf.append(D());
        buf.append(" (rot: ");
        buf.append(this.f4698a);
        buf.append(" degrees)");
        return buf.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof pd0)) {
            return false;
        }
        pd0 other = (pd0) obj;
        if (other.a == this.a && other.b == this.b && other.c == this.c && other.d == this.d && other.f4698a == this.f4698a) {
            return true;
        }
        return false;
    }
}
