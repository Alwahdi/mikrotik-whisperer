package defpackage;

import com.itextpdf.text.a;
import com.itextpdf.text.d;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: q70  reason: default package */
public class q70 extends pd0 implements br {
    protected d a;

    /* renamed from: a  reason: collision with other field name */
    protected g0 f4775a;

    /* renamed from: a  reason: collision with other field name */
    protected h70 f4776a;

    /* renamed from: a  reason: collision with other field name */
    private ia f4777a;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<s70> f4778a;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<h70, o70> f4779a;

    /* renamed from: a  reason: collision with other field name */
    private r70 f4780a;

    /* renamed from: a  reason: collision with other field name */
    private tr f4781a;

    /* renamed from: a  reason: collision with other field name */
    private u70 f4782a;
    private boolean b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f4783c;
    private int d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f4784d;
    private int e;
    private int f;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;

    public q70() {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.f4777a = new ia((d60) null);
        this.c = 4;
        this.j = 2.0f;
        this.k = 2.0f;
        this.l = 2.0f;
        this.m = 2.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.b = false;
        this.d = 1;
        this.e = 1;
        this.f4783c = false;
        this.f4784d = false;
        this.f4776a = h70.Eb;
        this.f4779a = null;
        this.f4775a = new g0();
        this.f4778a = null;
        this.e = 0.5f;
        this.f4701b = 15;
        this.f4777a.K(0.0f, 1.0f);
    }

    public q70(d phrase) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.f4777a = new ia((d60) null);
        this.c = 4;
        this.j = 2.0f;
        this.k = 2.0f;
        this.l = 2.0f;
        this.m = 2.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.b = false;
        this.d = 1;
        this.e = 1;
        this.f4783c = false;
        this.f4784d = false;
        this.f4776a = h70.Eb;
        this.f4779a = null;
        this.f4775a = new g0();
        this.f4778a = null;
        this.e = 0.5f;
        this.f4701b = 15;
        ia iaVar = this.f4777a;
        this.a = phrase;
        iaVar.b(phrase);
        this.f4777a.K(0.0f, 1.0f);
    }

    public q70(tr image) {
        this(image, false);
    }

    public q70(tr image, boolean fit) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.f4777a = new ia((d60) null);
        this.c = 4;
        this.j = 2.0f;
        this.k = 2.0f;
        this.l = 2.0f;
        this.m = 2.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.b = false;
        this.d = 1;
        this.e = 1;
        this.f4783c = false;
        this.f4784d = false;
        this.f4776a = h70.Eb;
        this.f4779a = null;
        this.f4775a = new g0();
        this.f4778a = null;
        this.e = 0.5f;
        this.f4701b = 15;
        this.f4777a.K(0.0f, 1.0f);
        if (fit) {
            this.f4781a = image;
            E0(this.e / 2.0f);
            return;
        }
        image.m1(false);
        ia iaVar = this.f4777a;
        d dVar = new d(new a(image, 0.0f, 0.0f, true));
        this.a = dVar;
        iaVar.b(dVar);
        E0(0.0f);
    }

    public q70(q70 cell) {
        super(cell.a, cell.b, cell.c, cell.d);
        this.f4777a = new ia((d60) null);
        this.c = 4;
        this.j = 2.0f;
        this.k = 2.0f;
        this.l = 2.0f;
        this.m = 2.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.b = false;
        this.d = 1;
        this.e = 1;
        this.f4783c = false;
        this.f4784d = false;
        this.f4776a = h70.Eb;
        this.f4779a = null;
        this.f4775a = new g0();
        this.f4778a = null;
        e(cell);
        this.c = cell.c;
        this.j = cell.j;
        this.k = cell.k;
        this.l = cell.l;
        this.m = cell.m;
        this.a = cell.a;
        this.n = cell.n;
        this.p = cell.p;
        this.b = cell.b;
        this.d = cell.d;
        this.e = cell.e;
        if (cell.f4782a != null) {
            this.f4782a = new u70(cell.f4782a);
        }
        this.f4781a = tr.s0(cell.f4781a);
        this.f4780a = cell.f4780a;
        this.f4783c = cell.f4783c;
        this.f4777a = ia.d(cell.f4777a);
        this.f4784d = cell.f4784d;
        this.f = cell.f;
        this.f4775a = cell.f4775a;
        this.f4776a = cell.f4776a;
        if (cell.f4779a != null) {
            this.f4779a = new HashMap<>(cell.f4779a);
        }
        this.f4778a = cell.f4778a;
    }

    public void Z(bi element) {
        if (this.f4782a != null) {
            this.f4782a = null;
            this.f4777a.S((d) null);
        }
        if (element instanceof u70) {
            ((u70) element).v0(false);
        }
        this.f4777a.a(element);
    }

    public void I0(d phrase) {
        this.f4782a = null;
        this.f4781a = null;
        ia iaVar = this.f4777a;
        this.a = phrase;
        iaVar.S(phrase);
    }

    public int l0() {
        return this.f4777a.h();
    }

    public int r0() {
        return this.c;
    }

    public float g0() {
        if (!x0()) {
            return this.j;
        }
        return this.j + (y() / (P() ? 1.0f : 2.0f));
    }

    public void G0(float paddingLeft) {
        this.j = paddingLeft;
    }

    public float h0() {
        if (!x0()) {
            return this.k;
        }
        return this.k + (z() / (P() ? 1.0f : 2.0f));
    }

    public void H0(float paddingRight) {
        this.k = paddingRight;
    }

    public float i0() {
        if (!x0()) {
            return this.l;
        }
        return this.l + (A() / (P() ? 1.0f : 2.0f));
    }

    public float f0() {
        if (!x0()) {
            return this.m;
        }
        return this.m + (x() / (P() ? 1.0f : 2.0f));
    }

    public void F0(float paddingBottom) {
        this.m = paddingBottom;
    }

    public void E0(float padding) {
        this.m = padding;
        this.l = padding;
        this.j = padding;
        this.k = padding;
    }

    public boolean x0() {
        return this.f4784d;
    }

    public void z0(float calculatedHeight) {
        this.o = calculatedHeight;
    }

    public float b0() {
        return this.o;
    }

    public boolean t0() {
        return b0() > 0.0f;
    }

    public void C0(float fixedHeight) {
        this.n = fixedHeight;
        this.p = 0.0f;
    }

    public float j0() {
        return this.n;
    }

    public boolean u0() {
        return j0() > 0.0f;
    }

    public float a0() {
        return this.q;
    }

    public boolean s0() {
        return this.q > 0.0f;
    }

    public void D0(float minimumHeight) {
        this.p = minimumHeight;
        this.n = 0.0f;
    }

    public float o0() {
        return this.p;
    }

    public boolean v0() {
        return o0() > 0.0f;
    }

    public boolean w0() {
        return this.b;
    }

    public int d0() {
        return this.d;
    }

    public void A0(int colspan) {
        this.d = colspan;
    }

    public int p0() {
        return this.e;
    }

    public void J0(int rowspan) {
        this.e = rowspan;
    }

    public void K0(int runDirection) {
        this.f4777a.M(runDirection);
    }

    public int q0() {
        return this.f4777a.n();
    }

    public tr m0() {
        return this.f4781a;
    }

    public r70 c0() {
        return this.f4780a;
    }

    public boolean y0() {
        return this.f4783c;
    }

    public ia e0() {
        return this.f4777a;
    }

    public void B0(ia column) {
        this.f4777a = column;
    }

    public int I() {
        return this.f;
    }

    public float n0() {
        float bottom;
        float left;
        float top;
        float right;
        boolean pivoted = I() == 90 || I() == 270;
        tr img = m0();
        if (img != null) {
            img.Z0(100.0f);
            img.Z0(100.0f * ((((G() - h0()) - g0()) - E()) / (pivoted ? img.A0() : img.B0())));
            U(((J() - i0()) - f0()) - (pivoted ? img.B0() : img.A0()));
        } else if ((!pivoted || !u0()) && e0() != null) {
            ia ct = ia.d(e0());
            if (pivoted) {
                right = 20000.0f;
                top = G() - h0();
                left = 0.0f;
                bottom = E() + g0();
            } else {
                right = w0() ? 20000.0f : G() - h0();
                top = J() - i0();
                left = E() + g0();
                bottom = t0() ? (J() + f0()) - b0() : -1.07374182E9f;
            }
            t70.v(ct, left, bottom, right, top);
            try {
                ct.q(true);
                if (pivoted) {
                    U(((J() - i0()) - f0()) - ct.k());
                } else {
                    float yLine = ct.o();
                    if (y0()) {
                        yLine += ct.j();
                    }
                    U(yLine - f0());
                }
            } catch (ih e2) {
                throw new mj(e2);
            }
        } else {
            U(J() - j0());
        }
        float height = D();
        if (height == i0() + f0()) {
            height = 0.0f;
        }
        if (u0()) {
            height = j0();
        } else if (v0() && height < o0()) {
            height = o0();
        }
        this.q = height;
        return height;
    }

    public o70 l(h70 key) {
        HashMap<h70, o70> hashMap = this.f4779a;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public void p(h70 key, o70 value) {
        if (this.f4779a == null) {
            this.f4779a = new HashMap<>();
        }
        this.f4779a.put(key, value);
    }

    public HashMap<h70, o70> u() {
        return this.f4779a;
    }

    public h70 j() {
        return this.f4776a;
    }

    public void b(h70 role) {
        this.f4776a = role;
    }

    public g0 s() {
        return this.f4775a;
    }

    public void h(g0 id) {
        this.f4775a = id;
    }

    public boolean isInline() {
        return false;
    }

    public ArrayList<s70> k0() {
        return this.f4778a;
    }
}
