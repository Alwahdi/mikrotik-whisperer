package defpackage;

import java.net.URL;

/* renamed from: vr  reason: default package */
public class vr extends tr {
    public vr(int width, int height, boolean reverseBits, int typeCCITT, int parameters, byte[] data) {
        super((URL) null);
        if (typeCCITT == 256 || typeCCITT == 257 || typeCCITT == 258) {
            if (reverseBits) {
                dp0.l(data);
            }
            this.c = 34;
            float f = (float) height;
            this.o = f;
            Y(f);
            float f2 = (float) width;
            this.n = f2;
            W(f2);
            this.f5149j = parameters;
            this.d = typeCCITT;
            this.f5139a = data;
            this.l = M();
            this.m = D();
            return;
        }
        throw new n5(i10.b("the.ccitt.compression.type.must.be.ccittg4.ccittg3.1d.or.ccittg3.2d", new Object[0]));
    }
}
