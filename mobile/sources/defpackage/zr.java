package defpackage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;

/* renamed from: zr  reason: default package */
public class zr extends tr {
    public zr(URL url) {
        super(url);
        t1();
    }

    private void t1() {
        String errorID;
        this.c = 35;
        this.g = 6;
        InputStream is = null;
        try {
            if (this.f5139a == null) {
                is = this.f5134a.openStream();
                errorID = this.f5134a.toString();
            } else {
                is = new ByteArrayInputStream(this.f5139a);
                errorID = "Byte array";
            }
            rs in = new rs(is);
            if (in.d() == -1698247209) {
                in.f();
                int left = in.e();
                int top = in.e();
                int right = in.e();
                int bottom = in.e();
                int inch = in.f();
                this.h = 72;
                this.i = 72;
                float f = (((float) (bottom - top)) / ((float) inch)) * 72.0f;
                this.o = f;
                Y(f);
                float f2 = (((float) (right - left)) / ((float) inch)) * 72.0f;
                this.n = f2;
                W(f2);
                return;
            }
            throw new n5(i10.b("1.is.not.a.valid.placeable.windows.metafile", errorID));
        } finally {
            if (is != null) {
                is.close();
            }
            this.l = M();
            this.m = D();
        }
    }

    public void u1(q80 template) {
        InputStream is;
        n1(template);
        template.k2(M());
        template.i2(D());
        InputStream is2 = null;
        try {
            if (this.f5139a == null) {
                is = this.f5134a.openStream();
            } else {
                is = new ByteArrayInputStream(this.f5139a);
            }
            new l10(is2, template).e();
        } finally {
            if (is2 != null) {
                is2.close();
            }
        }
    }
}
