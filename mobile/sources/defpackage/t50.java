package defpackage;

import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: t50  reason: default package */
public class t50 extends j60 {
    private HashSet<q80> a = new HashSet<>();

    /* renamed from: a  reason: collision with other field name */
    private v80 f5072a;

    /* renamed from: a  reason: collision with other field name */
    private x50 f5073a = new x50();
    private int b = 0;

    /* renamed from: b  reason: collision with other field name */
    private x50 f5074b = new x50();

    public t50(v80 writer) {
        this.f5072a = writer;
    }

    public void U(HashSet<q80> ft) {
        this.a.addAll(ft);
    }

    public void T(z60 ref) {
        this.f5073a.I(ref);
    }

    public boolean V() {
        if (this.f5073a.size() == 0) {
            return false;
        }
        Q(h70.G3, this.f5073a);
        int i = this.b;
        if (i != 0) {
            Q(h70.Ia, new k70(i));
        }
        if (this.f5074b.size() > 0) {
            Q(h70.i1, this.f5074b);
        }
        if (this.a.isEmpty()) {
            return true;
        }
        j60 dic = new j60();
        Iterator i$ = this.a.iterator();
        while (i$.hasNext()) {
            s60.f0(dic, (j60) i$.next().d2());
        }
        Q(h70.K2, dic);
        Q(h70.X1, new n80("/Helv 0 Tf 0 g "));
        j60 fonts = (j60) dic.I(h70.c4);
        if (fonts != null) {
            this.f5072a.N(fonts);
        }
        return true;
    }

    public void F(v80 writer, OutputStream os) {
        v80.H(writer, 15, this);
        super.F(writer, os);
    }
}
