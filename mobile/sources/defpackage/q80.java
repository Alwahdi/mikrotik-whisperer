package defpackage;

import java.util.HashMap;

/* renamed from: q80  reason: default package */
public class q80 extends d60 implements br {
    protected e50 a;

    /* renamed from: a  reason: collision with other field name */
    private g0 f4785a = null;

    /* renamed from: a  reason: collision with other field name */
    protected h70 f4786a = h70.H3;

    /* renamed from: a  reason: collision with other field name */
    private j60 f4787a = null;

    /* renamed from: a  reason: collision with other field name */
    protected m70 f4788a;

    /* renamed from: a  reason: collision with other field name */
    protected pd0 f4789a = new pd0(0.0f, 0.0f);

    /* renamed from: a  reason: collision with other field name */
    protected s80 f4790a;

    /* renamed from: a  reason: collision with other field name */
    protected x50 f4791a;

    /* renamed from: a  reason: collision with other field name */
    protected z60 f4792a;
    protected HashMap<h70, o70> b = null;

    /* renamed from: b  reason: collision with other field name */
    protected z60 f4793b;
    protected boolean c = false;
    protected int d = 1;

    protected q80() {
        super((v80) null);
    }

    q80(v80 wr) {
        super(wr);
        e50 e50 = new e50();
        this.a = e50;
        e50.b(wr.X());
        this.f4792a = this.f2719a.m0();
    }

    public static q80 S1(v80 writer, float width, float height) {
        return T1(writer, width, height, (h70) null);
    }

    static q80 T1(v80 writer, float width, float height, h70 forcedName) {
        q80 template = new q80(writer);
        template.k2(width);
        template.i2(height);
        writer.n(template, forcedName);
        return template;
    }

    public boolean p0() {
        return super.p0() && this.c;
    }

    public void k2(float width) {
        this.f4789a.V(0.0f);
        this.f4789a.W(width);
    }

    public void i2(float height) {
        this.f4789a.U(0.0f);
        this.f4789a.Y(height);
    }

    public float f2() {
        return this.f4789a.M();
    }

    public float Y1() {
        return this.f4789a.D();
    }

    public pd0 V1() {
        return this.f4789a;
    }

    public m70 a2() {
        return this.f4788a;
    }

    /* access modifiers changed from: package-private */
    public x50 b2() {
        return this.f4791a;
    }

    public z60 Z1() {
        if (this.f4792a == null) {
            this.f4792a = this.f2719a.m0();
        }
        return this.f4792a;
    }

    /* access modifiers changed from: package-private */
    public o70 d2() {
        return j0().i();
    }

    public m80 W1(int compressionLevel) {
        return new t60(this, compressionLevel);
    }

    public d60 c0() {
        q80 tpl = new q80();
        tpl.f2719a = this.f2719a;
        tpl.f2718a = this.f2718a;
        tpl.f4792a = this.f4792a;
        tpl.a = this.a;
        tpl.f4789a = new pd0(this.f4789a);
        tpl.f4788a = this.f4788a;
        x50 x50 = this.f4791a;
        if (x50 != null) {
            tpl.f4791a = new x50(x50);
        }
        tpl.b = this.b;
        tpl.f4787a = this.f4787a;
        tpl.c = this.c;
        tpl.f2716a = this;
        return tpl;
    }

    public int e2() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public e50 j0() {
        return this.a;
    }

    public s80 X1() {
        return this.f4790a;
    }

    public j60 U1() {
        return this.f4787a;
    }

    public z60 b0() {
        z60 z60 = this.f4793b;
        return z60 == null ? this.f2719a.V() : z60;
    }

    public z60 c2() {
        return this.f4793b;
    }

    public void j2(z60 pageReference) {
        this.f4793b = pageReference;
    }

    public boolean g2() {
        return this.c;
    }

    public void h2(boolean contentTagged) {
        this.c = contentTagged;
    }

    public o70 l(h70 key) {
        HashMap<h70, o70> hashMap = this.b;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public void p(h70 key, o70 value) {
        if (this.b == null) {
            this.b = new HashMap<>();
        }
        this.b.put(key, value);
    }

    public HashMap<h70, o70> u() {
        return this.b;
    }

    public h70 j() {
        return this.f4786a;
    }

    public void b(h70 role) {
        this.f4786a = role;
    }

    public g0 s() {
        if (this.f4785a == null) {
            this.f4785a = new g0();
        }
        return this.f4785a;
    }

    public void h(g0 id) {
        this.f4785a = id;
    }

    public boolean isInline() {
        return true;
    }
}
