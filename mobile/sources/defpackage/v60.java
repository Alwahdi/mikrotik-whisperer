package defpackage;

/* renamed from: v60  reason: default package */
public class v60 extends m80 {
    public v60(dr profile, int compressionLevel) {
        try {
            int numberOfComponents = profile.d();
            switch (numberOfComponents) {
                case 1:
                    Q(h70.B, h70.r2);
                    break;
                case 3:
                    Q(h70.B, h70.s2);
                    break;
                case 4:
                    Q(h70.B, h70.t2);
                    break;
                default:
                    throw new p60(i10.a("1.component.s.is.not.supported", numberOfComponents));
            }
            Q(h70.b7, new k70(numberOfComponents));
            byte[] a = profile.a();
            this.f4495a = a;
            Q(h70.m6, new k70(a.length));
            T(compressionLevel);
        } catch (Exception e) {
            throw new mj(e);
        }
    }
}
