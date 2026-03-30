package defpackage;

import defpackage.bv;

/* renamed from: av  reason: default package */
public abstract class av {
    public static tr a(cd0 ra, int page) {
        if (page >= 1) {
            try {
                bv sr = new bv(ra);
                sr.e();
                bv.a p = sr.c(page);
                return new wr(p.b, p.c, p.b(true), sr.b(true));
            } catch (Exception e) {
                throw new mj(e);
            }
        } else {
            throw new IllegalArgumentException(i10.b("the.page.number.must.be.gt.eq.1", new Object[0]));
        }
    }
}
