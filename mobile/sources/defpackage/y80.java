package defpackage;

/* renamed from: y80  reason: default package */
public class y80 implements w80 {
    protected int a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected v80 f5857a;

    public y80(v80 writer) {
        this.f5857a = writer;
    }

    public int d() {
        return this.a;
    }

    public boolean a() {
        return c();
    }

    public boolean c() {
        return this.a != 0;
    }

    public boolean e() {
        return this.a == 1;
    }

    public boolean f() {
        return this.a == 2;
    }

    /* Debug info: failed to restart local var, previous not found, register: 16 */
    public void b(int key, Object obj1) {
        Object obj = obj1;
        v80 v80 = this.f5857a;
        if (v80 != null && v80.x0()) {
            int conf = this.f5857a.h0();
            switch (key) {
                case 1:
                    switch (conf) {
                        case 1:
                            if (obj instanceof dk) {
                                dk ec = (dk) obj;
                                switch (ec.h()) {
                                    case 0:
                                        throw new x80(i10.b("colorspace.rgb.is.not.allowed", new Object[0]));
                                    case 1:
                                    case 2:
                                        return;
                                    case 3:
                                        ((qm0) ec).k().b();
                                        throw null;
                                    case 4:
                                        ((p50) ec).k().l2();
                                        throw null;
                                    case 5:
                                        ((fl0) ec).k().X();
                                        throw null;
                                    default:
                                        return;
                                }
                            } else if (obj instanceof w5) {
                                throw new x80(i10.b("colorspace.rgb.is.not.allowed", new Object[0]));
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                case 3:
                    if (conf == 1) {
                        throw new x80(i10.b("colorspace.rgb.is.not.allowed", new Object[0]));
                    }
                    return;
                case 4:
                    if (!((y5) obj).z()) {
                        throw new x80(i10.b("all.the.fonts.must.be.embedded.this.one.isn.t.1", ((y5) obj).o()));
                    }
                    return;
                case 5:
                    w60 image = (w60) obj;
                    if (image.I(h70.Na) == null) {
                        switch (conf) {
                            case 1:
                                o70 cs = image.I(h70.n1);
                                if (cs != null) {
                                    if (cs.A()) {
                                        if (h70.s2.equals(cs)) {
                                            throw new x80(i10.b("colorspace.rgb.is.not.allowed", new Object[0]));
                                        }
                                        return;
                                    } else if (cs.t() && h70.H0.equals(((x50) cs).S(0))) {
                                        throw new x80(i10.b("colorspace.calrgb.is.not.allowed", new Object[0]));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            default:
                                return;
                        }
                    } else {
                        throw new x80(i10.b("the.smask.key.is.not.allowed.in.images", new Object[0]));
                    }
                case 6:
                    j60 gs = (j60) obj;
                    if (gs != null) {
                        o70 obj2 = gs.I(h70.t0);
                        if (obj2 == null || u60.g.equals(obj2) || u60.h.equals(obj2)) {
                            o70 obj3 = gs.I(h70.E0);
                            if (obj3 != null) {
                                double H = ((k70) obj3).H();
                                double v = H;
                                if (H != 1.0d) {
                                    throw new x80(i10.b("transparency.is.not.allowed.ca.eq.1", String.valueOf(v)));
                                }
                            }
                            o70 obj4 = gs.I(h70.F0);
                            if (obj4 != null) {
                                double H2 = ((k70) obj4).H();
                                double v2 = H2;
                                if (H2 != 1.0d) {
                                    throw new x80(i10.b("transparency.is.not.allowed.ca.eq.1", String.valueOf(v2)));
                                }
                                return;
                            }
                            return;
                        }
                        throw new x80(i10.b("blend.mode.1.not.allowed", obj2.toString()));
                    }
                    return;
                case 7:
                    throw new x80(i10.b("layers.are.not.allowed", new Object[0]));
                default:
                    return;
            }
        }
    }
}
