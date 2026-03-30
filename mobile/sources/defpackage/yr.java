package defpackage;

import java.net.URL;

/* renamed from: yr  reason: default package */
public class yr extends tr {
    public yr(q80 template) {
        super((URL) null);
        if (template == null) {
            throw new n5(i10.b("the.template.can.not.be.null", new Object[0]));
        } else if (template.e2() != 3) {
            this.c = 35;
            float Y1 = template.Y1();
            this.o = Y1;
            Y(Y1);
            float f2 = template.f2();
            this.n = f2;
            W(f2);
            n1(template);
            this.l = M();
            this.m = D();
        } else {
            throw new n5(i10.b("a.pattern.can.not.be.used.as.a.template.to.create.an.image", new Object[0]));
        }
    }
}
