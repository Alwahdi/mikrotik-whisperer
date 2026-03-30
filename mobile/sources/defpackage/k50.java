package defpackage;

import com.itextpdf.text.Element;
import com.itextpdf.text.a;
import com.itextpdf.text.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: k50  reason: default package */
public class k50 extends d implements km0, br {
    protected int a = -1;

    /* renamed from: a  reason: collision with other field name */
    protected g0 f4098a = null;

    /* renamed from: a  reason: collision with other field name */
    protected h70 f4099a = h70.k8;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<h70, o70> f4100a = null;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f4101a = false;
    protected float c;
    protected float d;
    private float e = 0.0f;
    protected float f;
    protected float g;
    private float h = 0.0f;
    protected float i;

    public k50() {
    }

    public k50(a chunk) {
        super(chunk);
    }

    public k50(d phrase) {
        super(phrase);
        if (phrase instanceof k50) {
            k50 p = (k50) phrase;
            Z(p.a);
            c0(p.U());
            d0(p.V());
            b0(p.T());
            f0(p.X());
            g0(p.c());
            a0(p.S());
            b(p.f4099a);
            this.f4098a = p.s();
            if (p.f4100a != null) {
                this.f4100a = new HashMap<>(p.f4100a);
            }
        }
    }

    public k50 Q(boolean spacingBefore) {
        k50 copy = new k50();
        Y(copy, spacingBefore);
        return copy;
    }

    /* access modifiers changed from: protected */
    public void Y(k50 copy, boolean spacingBefore) {
        copy.L(E());
        copy.Z(R());
        copy.N(G(), this.b);
        copy.c0(U());
        copy.d0(V());
        copy.b0(T());
        copy.f0(X());
        if (spacingBefore) {
            copy.g0(c());
        }
        copy.a0(S());
        copy.b(this.f4099a);
        copy.f4098a = s();
        if (this.f4100a != null) {
            copy.f4100a = new HashMap<>(this.f4100a);
        }
        copy.O(I());
        copy.e0(W());
    }

    /* Debug info: failed to restart local var, previous not found, register: 9 */
    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Throwable, ix] */
    public List<bi> P() {
        List<Element> list = new ArrayList<>();
        k50 tmp = null;
        Iterator i$ = iterator();
        while (true) {
            boolean z = true;
            ? r5 = 0;
            if (i$.hasNext()) {
                bi e2 = (bi) i$.next();
                if (e2.v() == 14 || e2.v() == 23 || e2.v() == 12) {
                    if (tmp != null && tmp.size() > 0) {
                        tmp.f0(0.0f);
                        list.add(tmp);
                        tmp = Q(false);
                    }
                    if (list.size() == 0) {
                        switch (e2.v()) {
                            case 12:
                                ((k50) e2).g0(c());
                                break;
                            case 14:
                                b6.a(e2);
                                r5.c();
                                throw r5;
                            case 23:
                                ((u70) e2).u0(c());
                                break;
                        }
                    }
                    list.add(e2);
                } else {
                    if (tmp == null) {
                        if (list.size() != 0) {
                            z = false;
                        }
                        tmp = Q(z);
                    }
                    tmp.add(e2);
                }
            } else {
                if (tmp != null && tmp.size() > 0) {
                    list.add(tmp);
                }
                if (list.size() != 0) {
                    bi lastElement = (bi) list.get(list.size() - 1);
                    switch (lastElement.v()) {
                        case 12:
                            ((k50) lastElement).f0(X());
                            break;
                        case 14:
                            b6.a(lastElement);
                            r5.i();
                            throw r5;
                        case 23:
                            ((u70) lastElement).t0(X());
                            break;
                    }
                }
                return list;
            }
        }
    }

    public int v() {
        return 12;
    }

    /* renamed from: A */
    public boolean add(bi o) {
        if (o instanceof tr) {
            super.D(o);
            return true;
        } else if (!(o instanceof k50)) {
            return super.add(o);
        } else {
            super.D(o);
            return true;
        }
    }

    public void Z(int alignment) {
        this.a = alignment;
    }

    public void c0(float indentation) {
        this.c = indentation;
    }

    public void d0(float indentation) {
        this.d = indentation;
    }

    public void b0(float firstLineIndent) {
        this.e = firstLineIndent;
    }

    public void g0(float spacing) {
        this.f = spacing;
    }

    public void f0(float spacing) {
        this.g = spacing;
    }

    public void e0(boolean keeptogether) {
        this.f4101a = keeptogether;
    }

    public boolean W() {
        return this.f4101a;
    }

    public int R() {
        return this.a;
    }

    public float U() {
        return this.c;
    }

    public float V() {
        return this.d;
    }

    public float T() {
        return this.e;
    }

    public float c() {
        return this.f;
    }

    public float X() {
        return this.g;
    }

    public float S() {
        return this.h;
    }

    public void a0(float extraParagraphSpace) {
        this.h = extraParagraphSpace;
    }

    public o70 l(h70 key) {
        HashMap<h70, o70> hashMap = this.f4100a;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public void p(h70 key, o70 value) {
        if (this.f4100a == null) {
            this.f4100a = new HashMap<>();
        }
        this.f4100a.put(key, value);
    }

    public HashMap<h70, o70> u() {
        return this.f4100a;
    }

    public h70 j() {
        return this.f4099a;
    }

    public void b(h70 role) {
        this.f4099a = role;
    }

    public g0 s() {
        if (this.f4098a == null) {
            this.f4098a = new g0();
        }
        return this.f4098a;
    }

    public void h(g0 id) {
        this.f4098a = id;
    }

    public boolean isInline() {
        return false;
    }

    public float m() {
        return this.i;
    }
}
