package defpackage;

import com.itextpdf.text.pdf.c;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: s60  reason: default package */
public class s60 extends v50 {
    public static final h70 A = h70.Y;
    public static final h70 B = h70.ta;
    public static final h70 C = h70.b7;
    public static final h70 D;
    public static final h70 E = h70.k8;
    static h70[] a = {h70.c4, h70.Rd, h70.n1, h70.z8};
    public static final h70 z;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<s60> f4968a;

    /* renamed from: a  reason: collision with other field name */
    protected s60 f4969a;

    static {
        h70 h70 = h70.b;
        z = h70;
        D = h70;
    }

    protected s60(v80 writer) {
        super(writer, (pd0) null);
        this.f5306a = true;
        this.f5307b = false;
        this.g = h70.n4;
    }

    public s60 e0() {
        return this.f4969a;
    }

    public ArrayList<s60> d0() {
        return this.f4968a;
    }

    static void g0(j60 result, j60 source, l80 writer) {
        int k = 0;
        while (true) {
            h70[] h70Arr = a;
            if (k < h70Arr.length) {
                h70 target = h70Arr[k];
                j60 pdfDict = source.K(target);
                j60 dic = pdfDict;
                if (pdfDict != null) {
                    j60 j60 = (j60) c.c(result.I(target), result);
                    j60 res = j60;
                    if (j60 == null) {
                        res = new j60();
                    }
                    res.P(dic);
                    result.Q(target, res);
                    if (writer != null) {
                        writer.H0(res);
                    }
                }
                k++;
            } else {
                return;
            }
        }
    }

    static void f0(j60 result, j60 source) {
        g0(result, source, (l80) null);
    }

    public void c0() {
        this.c = true;
        s60 s60 = this.f4969a;
        if (s60 != null) {
            Q(h70.u8, s60.V());
        }
        if (this.f4968a != null) {
            x50 array = new x50();
            for (int k = 0; k < this.f4968a.size(); k++) {
                array.I(this.f4968a.get(k).V());
            }
            Q(h70.Z5, array);
        }
        if (this.f5303a != null) {
            j60 dic = new j60();
            Iterator i$ = this.f5303a.iterator();
            while (i$.hasNext()) {
                f0(dic, (j60) i$.next().d2());
            }
            Q(h70.K2, dic);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: v50} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: v50} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: v50} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: s60} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.v50 h0(defpackage.v50 r4) {
        /*
            boolean r0 = r4.Z()
            if (r0 == 0) goto L_0x001a
            s60 r0 = new s60
            v80 r1 = r4.f5304a
            r0.<init>(r1)
            r1 = r0
            r2 = r4
            s60 r2 = (defpackage.s60) r2
            s60 r3 = r2.f4969a
            r1.f4969a = r3
            java.util.ArrayList<s60> r3 = r2.f4968a
            r1.f4968a = r3
            goto L_0x0029
        L_0x001a:
            v80 r0 = r4.f5304a
            r1 = 0
            h70 r2 = defpackage.h70.tb
            o70 r2 = r4.I(r2)
            h70 r2 = (defpackage.h70) r2
            v50 r0 = r0.M(r1, r2)
        L_0x0029:
            r0.O(r4)
            boolean r1 = r4.f5306a
            r0.f5306a = r1
            boolean r1 = r4.f5307b
            r0.f5307b = r1
            java.util.HashSet<q80> r1 = r4.f5303a
            r0.f5303a = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s60.h0(v50):v50");
    }
}
