package defpackage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: w50  reason: default package */
public class w50 {
    protected ArrayList<v50> a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    protected t50 f5431a;
    protected ArrayList<v50> b = new ArrayList<>();

    public w50(v80 writer) {
        this.f5431a = new t50(writer);
    }

    public boolean g() {
        return this.f5431a.V();
    }

    public t50 e() {
        return this.f5431a;
    }

    public void a(v50 annot) {
        if (annot.Z()) {
            s60 field = (s60) annot;
            if (field.e0() == null) {
                b(field);
                return;
            }
            return;
        }
        this.a.add(annot);
    }

    public void c(v50 annot) {
        this.a.add(annot);
    }

    /* access modifiers changed from: package-private */
    public void b(s60 field) {
        this.a.add(field);
        ArrayList<s60> d0 = field.d0();
        if (d0 != null) {
            for (int k = 0; k < d0.size(); k++) {
                s60 kid = d0.get(k);
                if (!kid.a0()) {
                    b(kid);
                }
            }
        }
    }

    public boolean f() {
        return !this.a.isEmpty();
    }

    public void h() {
        this.a = this.b;
        this.b = new ArrayList<>();
    }

    public x50 i(v80 writer, pd0 pageSize) {
        f80 rect;
        HashSet<q80> X;
        x50 array = new x50();
        int rotation = pageSize.I() % 360;
        int currentPage = writer.W();
        for (int k = 0; k < this.a.size(); k++) {
            v50 dic = this.a.get(k);
            if (dic.W() > currentPage) {
                this.b.add(dic);
                v80 v80 = writer;
            } else {
                if (dic.Z()) {
                    if (!dic.a0() && (X = dic.X()) != null) {
                        this.f5431a.U(X);
                    }
                    s60 field = (s60) dic;
                    if (field.e0() == null) {
                        this.f5431a.T(field.V());
                    }
                }
                if (dic.Y()) {
                    array.I(dic.V());
                    if (!dic.a0()) {
                        h70 h70 = h70.E9;
                        x50 tmp = dic.J(h70);
                        if (tmp.size() == 4) {
                            rect = new f80(tmp.Q(0).I(), tmp.Q(1).I(), tmp.Q(2).I(), tmp.Q(3).I());
                        } else {
                            rect = new f80(tmp.Q(0).I(), tmp.Q(1).I());
                        }
                        switch (rotation) {
                            case 90:
                                dic.Q(h70, new f80(pageSize.J() - rect.V(), rect.X(), pageSize.J() - rect.Z(), rect.Y()));
                                break;
                            case 180:
                                dic.Q(h70, new f80(pageSize.G() - rect.X(), pageSize.J() - rect.V(), pageSize.G() - rect.Y(), pageSize.J() - rect.Z()));
                                break;
                            case 270:
                                dic.Q(h70, new f80(rect.V(), pageSize.G() - rect.X(), rect.Z(), pageSize.G() - rect.Y()));
                                break;
                        }
                    }
                }
                if (!dic.a0()) {
                    dic.c0();
                    try {
                        try {
                            writer.z(dic, dic.V());
                        } catch (IOException e) {
                            e = e;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        v80 v802 = writer;
                        throw new mj(e);
                    }
                } else {
                    v80 v803 = writer;
                }
            }
        }
        v80 v804 = writer;
        return array;
    }

    public static v50 d(v80 writer, h3 annot, pd0 defaultRect) {
        q60 fs;
        v80 v80 = writer;
        switch (annot.b()) {
            case 1:
                return writer.K(annot.f(), annot.h(), annot.l(), annot.n(), new u50((URL) annot.c().get("url")), (h70) null);
            case 2:
                return writer.K(annot.f(), annot.h(), annot.l(), annot.n(), new u50((String) annot.c().get("file")), (h70) null);
            case 3:
                return writer.K(annot.f(), annot.h(), annot.l(), annot.n(), new u50((String) annot.c().get("file"), (String) annot.c().get("destination")), (h70) null);
            case 4:
                return writer.K(annot.f(), annot.h(), annot.l(), annot.n(), new u50((String) annot.c().get("file"), ((Integer) annot.c().get("page")).intValue()), (h70) null);
            case 5:
                return writer.K(annot.f(), annot.h(), annot.l(), annot.n(), new u50(((Integer) annot.c().get("named")).intValue()), (h70) null);
            case 6:
                return writer.K(annot.f(), annot.h(), annot.l(), annot.n(), new u50((String) annot.c().get("application"), (String) annot.c().get("parameters"), (String) annot.c().get("operation"), (String) annot.c().get("defaultdir")), (h70) null);
            case 7:
                boolean[] sparams = (boolean[]) annot.c().get("parameters");
                String fname = (String) annot.c().get("file");
                String mimetype = (String) annot.c().get("mime");
                if (sparams[0]) {
                    fs = q60.T(v80, fname, fname, (byte[]) null);
                } else {
                    fs = q60.W(v80, fname);
                }
                return v50.U(writer, new pd0(annot.f(), annot.h(), annot.l(), annot.n()), fname, fs, mimetype, sparams[1]);
            default:
                return writer.L(defaultRect.E(), defaultRect.B(), defaultRect.G(), defaultRect.J(), new n80(annot.k(), "UnicodeBig"), new n80(annot.e(), "UnicodeBig"), (h70) null);
        }
    }
}
