package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* renamed from: e60  reason: default package */
class e60 extends m80 {
    static final byte[] d = fh.b("q\n");
    static final byte[] e = fh.b("Q\n");
    static final byte[] f = fh.b("0 1 -1 0 ");
    static final byte[] g = fh.b("-1 0 0 -1 ");
    static final byte[] h = fh.b("0 -1 1 0 ");
    static final byte[] i = fh.b(" cm\n");

    e60(d60 under, d60 content, d60 text, d60 secondContent, pd0 page) {
        OutputStream out;
        Deflater deflater = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.a = byteArrayOutputStream;
            if (gh.f3078e) {
                this.f4317a = true;
                if (text != null) {
                    this.f4318b = text.m0().T();
                } else if (content != null) {
                    this.f4318b = content.m0().T();
                }
                deflater = new Deflater(this.f4318b);
                out = new DeflaterOutputStream(this.a, deflater);
            } else {
                out = byteArrayOutputStream;
            }
            switch (page.I()) {
                case 90:
                    out.write(f);
                    out.write(fh.b(w6.X((double) page.J())));
                    out.write(32);
                    out.write(48);
                    out.write(i);
                    break;
                case 180:
                    out.write(g);
                    out.write(fh.b(w6.X((double) page.G())));
                    out.write(32);
                    out.write(fh.b(w6.X((double) page.J())));
                    out.write(i);
                    break;
                case 270:
                    out.write(h);
                    out.write(48);
                    out.write(32);
                    out.write(fh.b(w6.X((double) page.G())));
                    out.write(i);
                    break;
            }
            if (under.M1() > 0) {
                out.write(d);
                under.g0().d0(out);
                out.write(e);
            }
            if (content.M1() > 0) {
                out.write(d);
                content.g0().d0(out);
                out.write(e);
            }
            if (text != null) {
                out.write(d);
                text.g0().d0(out);
                out.write(e);
            }
            if (secondContent.M1() > 0) {
                secondContent.g0().d0(out);
            }
            out.close();
            if (deflater != null) {
                deflater.end();
            }
            Q(h70.m6, new k70(this.a.size()));
            if (this.f4317a) {
                Q(h70.K3, h70.a4);
            }
        } catch (Exception e2) {
            throw new o5(e2.getMessage());
        }
    }
}
