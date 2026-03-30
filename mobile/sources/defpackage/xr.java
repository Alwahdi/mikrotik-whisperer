package defpackage;

import java.net.URL;

/* renamed from: xr  reason: default package */
public class xr extends tr {
    public xr(int width, int height, int components, int bpc, byte[] data) {
        super((URL) null);
        this.c = 34;
        float f = (float) height;
        this.o = f;
        Y(f);
        float f2 = (float) width;
        this.n = f2;
        W(f2);
        if (components != 1 && components != 3 && components != 4) {
            throw new n5(i10.b("components.must.be.1.3.or.4", new Object[0]));
        } else if (bpc == 1 || bpc == 2 || bpc == 4 || bpc == 8) {
            this.f5149j = components;
            this.d = bpc;
            this.f5139a = data;
            this.l = M();
            this.m = D();
        } else {
            throw new n5(i10.b("bits.per.component.must.be.1.2.4.or.8", new Object[0]));
        }
    }
}
