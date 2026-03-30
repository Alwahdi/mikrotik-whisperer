package defpackage;

/* renamed from: t60  reason: default package */
public class t60 extends m80 {
    public static final f70 a = new f70("[1 0 0 1 0 0]");

    /* renamed from: a  reason: collision with other field name */
    public static final k70 f5075a = new k70(0);
    public static final k70 b = new k70(1);

    t60(q80 template, int compressionLevel) {
        Q(h70.Bc, h70.Rd);
        Q(h70.tb, h70.n4);
        Q(h70.N9, template.d2());
        Q(h70.e0, new f80(template.V1()));
        Q(h70.o4, b);
        if (template.a2() != null) {
            Q(h70.G7, template.a2().d());
        }
        template.X1();
        x50 matrix = template.b2();
        if (matrix == null) {
            Q(h70.H6, a);
        } else {
            Q(h70.H6, matrix);
        }
        byte[] P1 = template.P1((v80) null);
        this.f4495a = P1;
        Q(h70.m6, new k70(P1.length));
        if (template.U1() != null) {
            R(template.U1());
        }
        T(compressionLevel);
    }
}
