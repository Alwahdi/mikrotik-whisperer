package defpackage;

import com.itextpdf.text.a;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: o80  reason: default package */
public class o80 extends j60 implements lr {
    private g0 a;

    /* renamed from: a  reason: collision with other field name */
    private transient o80 f4496a;

    /* renamed from: a  reason: collision with other field name */
    private transient p80 f4497a;

    /* renamed from: a  reason: collision with other field name */
    private z60 f4498a;
    private h70 g;

    protected o80(j60 parent, h70 structureType, g0 elementId) {
        this.a = elementId;
        if (parent instanceof o80) {
            this.f4497a = ((o80) parent).f4497a;
            a0(parent, structureType);
            this.f4496a = (o80) parent;
            Q(h70.k8, ((o80) parent).f4498a);
            Q(h70.Bc, h70.lb);
        } else if (parent instanceof p80) {
            this.f4497a = (p80) parent;
            a0(parent, structureType);
            Q(h70.k8, ((p80) parent).V());
            Q(h70.Bc, h70.lb);
        }
    }

    public h70 Z() {
        return this.g;
    }

    private void a0(j60 parent, h70 structureType) {
        x50 kids;
        j60 mcr;
        if (!this.f4497a.W().q0().contains(structureType)) {
            j60 roleMap = this.f4497a.K(h70.ia);
            if (roleMap == null || !roleMap.H(structureType)) {
                throw new mj(new ih(i10.b("unknown.structure.element.role.1", structureType.toString())));
            }
            this.g = roleMap.L(structureType);
        } else {
            this.g = structureType;
        }
        h70 h70 = h70.X5;
        o70 kido = parent.I(h70);
        if (kido == null) {
            kids = new x50();
            parent.Q(h70, kids);
        } else if (kido instanceof x50) {
            kids = (x50) kido;
        } else {
            kids = new x50();
            kids.I(kido);
            parent.Q(h70, kids);
        }
        if (kids.size() > 0) {
            if (kids.Q(0) != null) {
                kids.T(0);
            }
            if (kids.size() > 0 && (mcr = kids.O(0)) != null && h70.S6.equals(mcr.L(h70.Bc))) {
                kids.T(0);
            }
        }
        Q(h70.ta, structureType);
        z60 m0 = this.f4497a.W().m0();
        this.f4498a = m0;
        kids.I(m0);
    }

    public j60 V() {
        return W(false);
    }

    public j60 W(boolean includeStructTreeRoot) {
        o80 o80 = this.f4496a;
        if (o80 != null || !includeStructTreeRoot) {
            return o80;
        }
        return this.f4497a;
    }

    /* access modifiers changed from: package-private */
    public void e0(int page, int mark) {
        if (mark >= 0) {
            Q(h70.X5, new k70(mark));
        }
        this.f4497a.Z(page, this.f4498a);
    }

    /* access modifiers changed from: package-private */
    public void b0(v50 annot, z60 currentPage) {
        h70 h70 = h70.X5;
        x50 kArray = J(h70);
        if (kArray == null) {
            kArray = new x50();
            o70 k = I(h70);
            if (k != null) {
                kArray.I(k);
            }
            Q(h70, kArray);
        }
        j60 dict = new j60();
        dict.Q(h70.Bc, h70.E7);
        dict.Q(h70.D7, annot.V());
        if (annot.j() == h70.n4) {
            dict.Q(h70.I8, currentPage);
        }
        kArray.I(dict);
    }

    public z60 Y() {
        return this.f4498a;
    }

    public o70 a(h70 name) {
        j60 attr = K(h70.b);
        if (attr != null && attr.H(name)) {
            return attr.I(name);
        }
        j60 parent = V();
        if (parent instanceof o80) {
            return ((o80) parent).a(name);
        }
        if (parent instanceof p80) {
            return ((p80) parent).a(name);
        }
        return new j70();
    }

    public void c0(h70 name, o70 obj) {
        h70 h70 = h70.b;
        j60 attr = K(h70);
        if (attr == null) {
            attr = new j60();
            Q(h70, attr);
        }
        attr.Q(name, obj);
    }

    public void h0(br element) {
        if (element instanceof k50) {
            j0((k50) element);
        } else if (element instanceof a) {
            s0((a) element);
        } else if (element instanceof tr) {
            i0((tr) element);
        } else if (element instanceof u70) {
            n0((u70) element);
        } else if (element instanceof t70) {
            m0((t70) element);
        } else if (element instanceof s70) {
            l0((s70) element);
        } else if (element instanceof q70) {
            k0((q70) element);
        } else if (element instanceof y70) {
            q0((y70) element);
        } else if (element instanceof x70) {
            p0((x70) element);
        } else if (element instanceof v70) {
            o0((v70) element);
        } else if (element instanceof q80) {
            r0((q80) element);
        } else if (element instanceof gh) {
            g0((gh) element);
        }
        if (element.u() != null) {
            for (h70 key : element.u().keySet()) {
                if (key.equals(h70.r5)) {
                    o70 attr = element.l(key);
                    Q(key, attr);
                    this.f4497a.X(attr.toString(), Y());
                } else if (key.equals(h70.d6) || key.equals(h70.A) || key.equals(h70.k) || key.equals(h70.T2) || key.equals(h70.zb)) {
                    Q(key, element.l(key));
                } else {
                    c0(key, element.l(key));
                }
            }
        }
    }

    private void s0(a chunk) {
        if (chunk == null) {
            return;
        }
        if (chunk.k() != null) {
            i0(chunk.k());
            return;
        }
        HashMap<String, Object> attr = chunk.e();
        if (attr != null) {
            c0(h70.C7, h70.j6);
            if (attr.containsKey("UNDERLINE")) {
                c0(h70.Lb, h70.Jc);
            }
            if (attr.containsKey("BACKGROUND")) {
                w5 color = (w5) ((Object[]) attr.get("BACKGROUND"))[0];
                c0(h70.a0, new x50(new float[]{((float) color.e()) / 255.0f, ((float) color.c()) / 255.0f, ((float) color.b()) / 255.0f}));
            }
            lr parent = (lr) W(true);
            h70 h70 = h70.k1;
            o70 obj = X(parent, h70);
            if (!(chunk.g() == null || chunk.g().h() == null)) {
                d0(chunk.g().h(), obj, h70);
            }
            h70 h702 = h70.Kb;
            o70 decorThickness = X(parent, h702);
            h70 h703 = h70.Jb;
            o70 decorColor = X(parent, h703);
            if (attr.containsKey("UNDERLINE")) {
                Object[][] unders = (Object[][]) attr.get("UNDERLINE");
                Object[] arr = unders[unders.length - 1];
                w5 color2 = (w5) arr[0];
                float thickness = ((float[]) arr[1])[0];
                if (!(decorThickness instanceof k70)) {
                    c0(h702, new k70(thickness));
                } else if (Float.compare(thickness, ((k70) decorThickness).I()) != 0) {
                    c0(h702, new k70(thickness));
                }
                if (color2 != null) {
                    d0(color2, decorColor, h703);
                }
            }
            if (attr.containsKey("LINEHEIGHT")) {
                float height = ((Float) attr.get("LINEHEIGHT")).floatValue();
                h70 h704 = h70.s6;
                o70 parentLH = X(parent, h704);
                if (!(parentLH instanceof k70)) {
                    c0(h704, new k70(height));
                } else if (Float.compare(((k70) parentLH).I(), height) != 0) {
                    c0(h704, new k70(height));
                }
            }
        }
    }

    private void i0(tr image) {
        if (image != null) {
            c0(h70.C7, h70.j6);
            if (image.M() > 0.0f) {
                c0(h70.Ad, new k70(image.M()));
            }
            if (image.D() > 0.0f) {
                c0(h70.Y4, new k70(image.D()));
            }
            c0(h70.e0, new f80((pd0) image, image.I()));
            if (image.f() != null) {
                w5 color = image.f();
                c0(h70.a0, new x50(new float[]{((float) color.e()) / 255.0f, ((float) color.c()) / 255.0f, ((float) color.b()) / 255.0f}));
            }
        }
    }

    private void r0(q80 template) {
        if (template != null) {
            c0(h70.C7, h70.j6);
            if (template.f2() > 0.0f) {
                c0(h70.Ad, new k70(template.f2()));
            }
            if (template.Y1() > 0.0f) {
                c0(h70.Y4, new k70(template.Y1()));
            }
            c0(h70.e0, new f80(template.V1()));
        }
    }

    private void j0(k50 paragraph) {
        if (paragraph != null) {
            c0(h70.C7, h70.j6);
            if (Float.compare(paragraph.c(), 0.0f) != 0) {
                c0(h70.Sa, new k70(paragraph.c()));
            }
            if (Float.compare(paragraph.X(), 0.0f) != 0) {
                c0(h70.Ra, new k70(paragraph.X()));
            }
            lr parent = (lr) W(true);
            h70 h70 = h70.k1;
            o70 obj = X(parent, h70);
            if (!(paragraph.E() == null || paragraph.E().h() == null)) {
                d0(paragraph.E().h(), obj, h70);
            }
            h70 h702 = h70.Mb;
            o70 obj2 = X(parent, h702);
            if (Float.compare(paragraph.T(), 0.0f) != 0) {
                boolean writeIndent = true;
                if ((obj2 instanceof k70) && Float.compare(((k70) obj2).I(), new Float(paragraph.T()).floatValue()) == 0) {
                    writeIndent = false;
                }
                if (writeIndent) {
                    c0(h702, new k70(paragraph.T()));
                }
            }
            h70 h703 = h70.eb;
            o70 obj3 = X(parent, h703);
            if (obj3 instanceof k70) {
                if (Float.compare(((k70) obj3).I(), paragraph.U()) != 0) {
                    c0(h703, new k70(paragraph.U()));
                }
            } else if (Math.abs(paragraph.U()) > Float.MIN_VALUE) {
                c0(h703, new k70(paragraph.U()));
            }
            h70 h704 = h70.h3;
            o70 obj4 = X(parent, h704);
            if (obj4 instanceof k70) {
                if (Float.compare(((k70) obj4).I(), paragraph.V()) != 0) {
                    c0(h704, new k70(paragraph.V()));
                }
            } else if (Float.compare(paragraph.V(), 0.0f) != 0) {
                c0(h704, new k70(paragraph.V()));
            }
            f0(paragraph.R());
        }
    }

    private void n0(u70 table) {
        if (table != null) {
            c0(h70.C7, h70.Bb);
            if (Float.compare(table.c(), 0.0f) != 0) {
                c0(h70.Sa, new k70(table.c()));
            }
            if (Float.compare(table.S(), 0.0f) != 0) {
                c0(h70.Ra, new k70(table.S()));
            }
            if (table.U() > 0.0f) {
                c0(h70.Y4, new k70(table.U()));
            }
            if (table.V() > 0.0f) {
                c0(h70.Ad, new k70(table.V()));
            }
        }
    }

    private void m0(t70 row) {
        if (row != null) {
            c0(h70.C7, h70.Bb);
        }
    }

    private void k0(q70 cell) {
        if (cell != null) {
            c0(h70.C7, h70.Bb);
            if (cell.d0() != 1) {
                c0(h70.v1, new k70(cell.d0()));
            }
            if (cell.p0() != 1) {
                c0(h70.na, new k70(cell.p0()));
            }
            if (cell.k0() != null) {
                x50 headers = new x50();
                Iterator i$ = cell.k0().iterator();
                while (i$.hasNext()) {
                    s70 header = i$.next();
                    if (header.L0() != null) {
                        headers.I(new n80(header.L0()));
                    }
                }
                if (!headers.isEmpty()) {
                    c0(h70.X4, headers);
                }
            }
            if (cell.b0() > 0.0f) {
                c0(h70.Y4, new k70(cell.b0()));
            }
            if (cell.M() > 0.0f) {
                c0(h70.Ad, new k70(cell.M()));
            }
            if (cell.f() != null) {
                w5 color = cell.f();
                c0(h70.a0, new x50(new float[]{((float) color.e()) / 255.0f, ((float) color.c()) / 255.0f, ((float) color.b()) / 255.0f}));
            }
        }
    }

    private void l0(s70 headerCell) {
        if (headerCell != null) {
            if (headerCell.M0() != 0) {
                switch (headerCell.M0()) {
                    case 1:
                        c0(h70.wa, h70.la);
                        break;
                    case 2:
                        c0(h70.wa, h70.w1);
                        break;
                    case 3:
                        c0(h70.wa, h70.v0);
                        break;
                }
            }
            if (headerCell.L0() != null) {
                c0(h70.h7, new h70(headerCell.L0()));
            }
            k0(headerCell);
        }
    }

    private void q0(y70 header) {
        if (header != null) {
            c0(h70.C7, h70.Bb);
        }
    }

    private void o0(v70 body) {
    }

    private void p0(x70 footer) {
    }

    private void g0(gh document) {
    }

    private boolean T(x50 parentColor, float[] color) {
        if (Float.compare(color[0], parentColor.Q(0).I()) == 0 && Float.compare(color[1], parentColor.Q(1).I()) == 0 && Float.compare(color[2], parentColor.Q(2).I()) == 0) {
            return true;
        }
        return false;
    }

    private void d0(w5 newColor, o70 oldColor, h70 attributeName) {
        float[] colorArr = {((float) newColor.e()) / 255.0f, ((float) newColor.c()) / 255.0f, ((float) newColor.b()) / 255.0f};
        if (oldColor == null || !(oldColor instanceof x50)) {
            c0(attributeName, new x50(colorArr));
        } else if (T((x50) oldColor, colorArr)) {
            c0(attributeName, new x50(colorArr));
        } else {
            c0(attributeName, new x50(colorArr));
        }
    }

    private void f0(int elementAlign) {
        h70 align = null;
        switch (elementAlign) {
            case 0:
                align = h70.db;
                break;
            case 1:
                align = h70.P0;
                break;
            case 2:
                align = h70.g3;
                break;
            case 3:
                align = h70.W5;
                break;
        }
        o80 o80 = this.f4496a;
        h70 h70 = h70.Ib;
        o70 obj = X(o80, h70);
        if (obj instanceof h70) {
            h70 textAlign = (h70) obj;
            if (align != null && !textAlign.equals(align)) {
                c0(h70, align);
            }
        } else if (align != null && !h70.db.equals(align)) {
            c0(h70, align);
        }
    }

    public void F(v80 writer, OutputStream os) {
        v80.H(writer, 16, this);
        super.F(writer, os);
    }

    private o70 X(lr parent, h70 name) {
        if (parent == null) {
            return null;
        }
        return parent.a(name);
    }

    /* access modifiers changed from: protected */
    public g0 U() {
        return this.a;
    }
}
