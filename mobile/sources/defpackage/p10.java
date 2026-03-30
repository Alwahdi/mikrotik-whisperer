package defpackage;

import java.util.ArrayList;
import java.util.Stack;

/* renamed from: p10  reason: default package */
public class p10 {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public int f4656a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<n10> f4657a;

    /* renamed from: a  reason: collision with other field name */
    public Stack<p10> f4658a;

    /* renamed from: a  reason: collision with other field name */
    public k10 f4659a;

    /* renamed from: a  reason: collision with other field name */
    public m10 f4660a;

    /* renamed from: a  reason: collision with other field name */
    public o10 f4661a;

    /* renamed from: a  reason: collision with other field name */
    public q90 f4662a;

    /* renamed from: a  reason: collision with other field name */
    public w5 f4663a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public int f4664b;

    /* renamed from: b  reason: collision with other field name */
    public w5 f4665b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public p10() {
        this.f4663a = w5.a;
        this.f4665b = w5.e;
        this.f4656a = 2;
        this.f4664b = 1;
        this.c = 1;
        this.f4658a = new Stack<>();
        this.f4657a = new ArrayList<>();
        this.f4662a = new q90(0, 0);
        this.f4661a = new o10();
        this.f4659a = new k10();
        this.f4660a = new m10();
    }

    public p10(p10 state) {
        this.f4663a = w5.a;
        this.f4665b = w5.e;
        this.f4656a = 2;
        this.f4664b = 1;
        this.c = 1;
        y(state);
    }

    public void y(p10 state) {
        this.f4658a = state.f4658a;
        this.f4657a = state.f4657a;
        this.f4662a = state.f4662a;
        this.f4661a = state.f4661a;
        this.f4659a = state.f4659a;
        this.f4660a = state.f4660a;
        this.f4663a = state.f4663a;
        this.f4665b = state.f4665b;
        this.f4656a = state.f4656a;
        this.f4664b = state.f4664b;
        this.d = state.d;
        this.c = state.c;
        this.e = state.e;
        this.f = state.f;
        this.g = state.g;
        this.h = state.h;
        this.a = state.a;
        this.b = state.b;
    }

    public void a(n10 object) {
        for (int k = 0; k < this.f4657a.size(); k++) {
            if (this.f4657a.get(k) == null) {
                this.f4657a.set(k, object);
                return;
            }
        }
        this.f4657a.add(object);
    }

    public void p(int index, d60 cb) {
        n10 obj = this.f4657a.get(index);
        if (obj != null) {
            switch (obj.a()) {
                case 1:
                    o10 o10 = (o10) obj;
                    this.f4661a = o10;
                    int style = o10.d();
                    if (style != 5) {
                        cb.Y0(this.f4661a.b());
                        cb.p1(Math.abs((((float) this.f4661a.c()) * this.a) / ((float) this.g)));
                        switch (style) {
                            case 1:
                                cb.m1(18.0f, 6.0f, 0.0f);
                                return;
                            case 2:
                                cb.l1(3.0f, 0.0f);
                                return;
                            case 3:
                                cb.q1("[9 6 3 6]0 d\n");
                                return;
                            case 4:
                                cb.q1("[9 3 3 3 3 3]0 d\n");
                                return;
                            default:
                                cb.k1(0.0f);
                                return;
                        }
                    } else {
                        return;
                    }
                case 2:
                    k10 k10 = (k10) obj;
                    this.f4659a = k10;
                    int style2 = k10.c();
                    if (style2 == 0) {
                        cb.U0(this.f4659a.b());
                        return;
                    } else if (style2 == 2) {
                        cb.U0(this.f4663a);
                        return;
                    } else {
                        return;
                    }
                case 3:
                    this.f4660a = (m10) obj;
                    return;
                default:
                    return;
            }
        }
    }

    public void c(int index) {
        this.f4657a.set(index, (Object) null);
    }

    public void o(d60 cb) {
        cb.Q0();
        this.f4658a.push(new p10(this));
    }

    public void n(int index, d60 cb) {
        int pops;
        if (index < 0) {
            pops = Math.min(-index, this.f4658a.size());
        } else {
            pops = Math.max(this.f4658a.size() - index, 0);
        }
        if (pops != 0) {
            p10 state = null;
            while (true) {
                int pops2 = pops - 1;
                if (pops != 0) {
                    cb.K0();
                    state = this.f4658a.pop();
                    pops = pops2;
                } else {
                    y(state);
                    return;
                }
            }
        }
    }

    public void b(d60 cb) {
        int k = this.f4658a.size();
        while (true) {
            int k2 = k - 1;
            if (k > 0) {
                cb.K0();
                k = k2;
            } else {
                return;
            }
        }
    }

    public float G(int x) {
        return ((((float) x) - ((float) this.e)) * this.a) / ((float) this.g);
    }

    public float H(int y) {
        return (1.0f - ((((float) y) - ((float) this.f)) / ((float) this.h))) * this.b;
    }

    public void C(float scalingX) {
        this.a = scalingX;
    }

    public void D(float scalingY) {
        this.b = scalingY;
    }

    public void z(int offsetWx) {
        this.e = offsetWx;
    }

    public void A(int offsetWy) {
        this.f = offsetWy;
    }

    public void u(int extentWx) {
        this.g = extentWx;
    }

    public void v(int extentWy) {
        this.h = extentWy;
    }

    public float F(float angle) {
        float ta = this.b < 0.0f ? -angle : angle;
        return (float) (this.a < 0.0f ? 3.141592653589793d - ((double) ta) : (double) ta);
    }

    public void s(q90 p) {
        this.f4662a = p;
    }

    public q90 i() {
        return this.f4662a;
    }

    public k10 f() {
        return this.f4659a;
    }

    public o10 h() {
        return this.f4661a;
    }

    public m10 g() {
        return this.f4660a;
    }

    public w5 e() {
        return this.f4663a;
    }

    public void r(w5 currentBackgroundColor) {
        this.f4663a = currentBackgroundColor;
    }

    public w5 j() {
        return this.f4665b;
    }

    public void t(w5 currentTextColor) {
        this.f4665b = currentTextColor;
    }

    public int d() {
        return this.f4656a;
    }

    public void q(int backgroundMode) {
        this.f4656a = backgroundMode;
    }

    public int m() {
        return this.d;
    }

    public void E(int textAlign) {
        this.d = textAlign;
    }

    public int l() {
        return this.f4664b;
    }

    public void B(int polyFillMode) {
        this.f4664b = polyFillMode;
    }

    public void x(d60 cb) {
        if (this.c != 0) {
            this.c = 0;
            cb.n1(0);
        }
    }

    public void w(d60 cb) {
        if (this.c == 0) {
            this.c = 1;
            cb.n1(1);
        }
    }

    public boolean k() {
        return this.c == 0;
    }
}
