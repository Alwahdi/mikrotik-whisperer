package defpackage;

import com.itextpdf.text.a;
import java.io.OutputStream;
import java.util.ArrayList;

/* renamed from: p70  reason: default package */
public class p70 extends j60 {
    private h60 a;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<p70> f4683a;

    /* renamed from: a  reason: collision with other field name */
    private p70 f4684a;

    /* renamed from: a  reason: collision with other field name */
    private u50 f4685a;

    /* renamed from: a  reason: collision with other field name */
    protected v80 f4686a;

    /* renamed from: a  reason: collision with other field name */
    private w5 f4687a;

    /* renamed from: a  reason: collision with other field name */
    private z60 f4688a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f4689a;
    private int b;
    private int c;

    p70(v80 writer) {
        super(j60.c);
        this.b = 0;
        this.f4683a = new ArrayList<>();
        this.c = 0;
        this.f4689a = true;
        this.f4684a = null;
        this.f4686a = writer;
    }

    public p70(p70 parent, h60 destination, k50 title, boolean open) {
        this.b = 0;
        this.f4683a = new ArrayList<>();
        this.c = 0;
        StringBuffer buf = new StringBuffer();
        for (a chunk : title.t()) {
            buf.append(chunk.f());
        }
        this.a = destination;
        X(parent, buf.toString(), open);
    }

    /* access modifiers changed from: package-private */
    public void X(p70 parent, String title, boolean open) {
        this.f4689a = open;
        this.f4684a = parent;
        this.f4686a = parent.f4686a;
        Q(h70.Zb, new n80(title, "UnicodeBig"));
        parent.T(this);
        h60 h60 = this.a;
        if (h60 != null && !h60.W()) {
            c0(this.f4686a.V());
        }
    }

    public void d0(z60 reference) {
        this.f4688a = reference;
    }

    public z60 W() {
        return this.f4688a;
    }

    public p70 a0() {
        return this.f4684a;
    }

    public boolean c0(z60 pageReference) {
        h60 h60 = this.a;
        if (h60 == null) {
            return false;
        }
        return h60.V(pageReference);
    }

    /* access modifiers changed from: package-private */
    public int U() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public void b0(int count) {
        this.b = count;
    }

    public int Z() {
        p70 p70 = this.f4684a;
        if (p70 == null) {
            return 0;
        }
        return p70.Z() + 1;
    }

    public void F(v80 writer, OutputStream os) {
        w5 w5Var = this.f4687a;
        if (w5Var != null && !w5Var.equals(w5.e)) {
            Q(h70.B0, new x50(new float[]{((float) this.f4687a.e()) / 255.0f, ((float) this.f4687a.c()) / 255.0f, ((float) this.f4687a.b()) / 255.0f}));
        }
        int flag = 0;
        int i = this.c;
        if ((i & 1) != 0) {
            flag = 0 | 2;
        }
        if ((2 & i) != 0) {
            flag |= 1;
        }
        if (flag != 0) {
            Q(h70.w3, new k70(flag));
        }
        p70 p70 = this.f4684a;
        if (p70 != null) {
            Q(h70.u8, p70.W());
        }
        h60 h60 = this.a;
        if (h60 != null && h60.W()) {
            Q(h70.o2, this.a);
        }
        u50 u50 = this.f4685a;
        if (u50 != null) {
            Q(h70.b, u50);
        }
        int i2 = this.b;
        if (i2 != 0) {
            Q(h70.G1, new k70(i2));
        }
        super.F(writer, os);
    }

    public void T(p70 outline) {
        this.f4683a.add(outline);
    }

    public ArrayList<p70> V() {
        return this.f4683a;
    }

    public boolean Y() {
        return this.f4689a;
    }
}
