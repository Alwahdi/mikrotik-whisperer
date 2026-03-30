package defpackage;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: v50  reason: default package */
public class v50 extends j60 implements br {
    public static final h70 h;
    public static final h70 i = h70.o5;
    public static final h70 j = h70.C7;
    public static final h70 k = h70.k8;
    public static final h70 l = h70.zb;
    public static final h70 m;
    public static final h70 n = h70.u9;
    public static final h70 o;
    public static final h70 p = h70.T2;
    public static final h70 q = h70.Md;
    public static final h70 r;
    public static final h70 s = h70.Fc;
    public static final h70 t = h70.b4;
    public static final h70 u = h70.n0;
    public static final h70 v = h70.X5;
    public static final h70 w = h70.w3;
    public static final h70 x = h70.bd;
    public static final h70 y = h70.B0;
    private g0 a = null;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<h70, o70> f5302a = null;

    /* renamed from: a  reason: collision with other field name */
    protected HashSet<q80> f5303a;

    /* renamed from: a  reason: collision with other field name */
    protected v80 f5304a;

    /* renamed from: a  reason: collision with other field name */
    protected z60 f5305a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f5306a = false;
    private int b = -1;

    /* renamed from: b  reason: collision with other field name */
    protected boolean f5307b = true;
    protected boolean c = false;
    protected h70 g = null;

    static {
        h70 h70 = h70.b7;
        h = h70;
        m = h70;
        h70 h702 = h70.W1;
        o = h702;
        r = h702;
    }

    public v50(v80 writer, pd0 rect) {
        this.f5304a = writer;
        if (rect != null) {
            Q(h70.E9, new f80(rect));
        }
    }

    public v50(v80 writer, float llx, float lly, float urx, float ury, n80 title, n80 content) {
        this.f5304a = writer;
        Q(h70.tb, h70.Hb);
        Q(h70.zb, title);
        Q(h70.E9, new f80(llx, lly, urx, ury));
        Q(h70.E1, content);
    }

    public v50(v80 writer, float llx, float lly, float urx, float ury, u50 action) {
        this.f5304a = writer;
        Q(h70.tb, h70.t6);
        Q(h70.E9, new f80(llx, lly, urx, ury));
        Q(h70.b, action);
        Q(h70.u0, new a60(0.0f, 0.0f, 0.0f));
        Q(h70.B0, new c60(0, 0, 255));
    }

    public static v50 U(v80 writer, pd0 rect, String clipTitle, q60 fs, String mimeType, boolean playOnDisplay) {
        v50 ann = writer.M(rect, h70.xa);
        ann.Q(h70.w3, new k70(4));
        ann.Q(h70.Bc, h70.G);
        ann.b0();
        z60 actionRef = writer.y(u50.V(clipTitle, fs, mimeType, ann.V())).a();
        if (playOnDisplay) {
            j60 aa = new j60();
            aa.Q(new h70("PV"), actionRef);
            ann.Q(h70.d, aa);
        }
        ann.Q(h70.b, actionRef);
        return ann;
    }

    public z60 V() {
        if (this.f5305a == null) {
            this.f5305a = this.f5304a.m0();
        }
        return this.f5305a;
    }

    public boolean a0() {
        return this.c;
    }

    public void c0() {
        this.c = true;
    }

    public HashSet<q80> X() {
        return this.f5303a;
    }

    public boolean Z() {
        return this.f5306a;
    }

    public boolean Y() {
        return this.f5307b;
    }

    public void b0() {
        Q(h70.k8, this.f5304a.V());
    }

    public int W() {
        return this.b;
    }

    public void T(f2 ctm) {
        f80 rect;
        h70 h70 = h70.E9;
        x50 origRect = J(h70);
        if (origRect != null) {
            if (origRect.size() == 4) {
                rect = new f80(origRect.Q(0).I(), origRect.Q(1).I(), origRect.Q(2).I(), origRect.Q(3).I());
            } else {
                rect = new f80(origRect.Q(0).I(), origRect.Q(1).I());
            }
            Q(h70, rect.a0(ctm));
        }
    }

    public void F(v80 writer, OutputStream os) {
        v80.H(writer, 13, this);
        super.F(writer, os);
    }

    public o70 l(h70 key) {
        HashMap<h70, o70> hashMap = this.f5302a;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public void p(h70 key, o70 value) {
        if (this.f5302a == null) {
            this.f5302a = new HashMap<>();
        }
        this.f5302a.put(key, value);
    }

    public HashMap<h70, o70> u() {
        return this.f5302a;
    }

    public h70 j() {
        return this.g;
    }

    public void b(h70 role) {
        this.g = role;
    }

    public g0 s() {
        if (this.a == null) {
            this.a = new g0();
        }
        return this.a;
    }

    public void h(g0 id) {
        this.a = id;
    }

    public boolean isInline() {
        return false;
    }
}
