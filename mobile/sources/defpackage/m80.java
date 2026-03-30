package defpackage;

import com.itextpdf.text.pdf.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* renamed from: m80  reason: default package */
public class m80 extends j60 {
    static final byte[] b;
    static final byte[] c;
    static final int e;
    protected ByteArrayOutputStream a = null;

    /* renamed from: a  reason: collision with other field name */
    protected InputStream f4314a;

    /* renamed from: a  reason: collision with other field name */
    protected v80 f4315a;

    /* renamed from: a  reason: collision with other field name */
    protected z60 f4316a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f4317a = false;

    /* renamed from: b  reason: collision with other field name */
    protected int f4318b = 0;

    /* renamed from: c  reason: collision with other field name */
    protected int f4319c = -1;
    protected int d;

    static {
        byte[] b2 = fh.b("stream\n");
        b = b2;
        byte[] b3 = fh.b("\nendstream");
        c = b3;
        e = b2.length + b3.length;
    }

    public m80(byte[] bytes) {
        this.a = 7;
        this.f4495a = bytes;
        this.d = bytes.length;
        Q(h70.m6, new k70(bytes.length));
    }

    public m80(InputStream inputStream, v80 writer) {
        this.a = 7;
        this.f4314a = inputStream;
        this.f4315a = writer;
        z60 m0 = writer.m0();
        this.f4316a = m0;
        Q(h70.m6, m0);
    }

    protected m80() {
        this.a = 7;
    }

    public void X() {
        if (this.f4314a != null) {
            int i = this.f4319c;
            if (i != -1) {
                this.f4315a.A(new k70(i), this.f4316a, false);
                return;
            }
            throw new IOException(i10.b("writelength.can.only.be.called.after.output.of.the.stream.body", new Object[0]));
        }
        throw new UnsupportedOperationException(i10.b("writelength.can.only.be.called.in.a.contructed.pdfstream.inputstream.pdfwriter", new Object[0]));
    }

    public int U() {
        return this.d;
    }

    public void T(int compressionLevel) {
        if (gh.f3078e && !this.f4317a) {
            this.f4318b = compressionLevel;
            if (this.f4314a != null) {
                this.f4317a = true;
                return;
            }
            h70 h70 = h70.K3;
            o70 filter = c.b(I(h70));
            if (filter != null) {
                if (filter.A()) {
                    if (h70.a4.equals(filter)) {
                        return;
                    }
                } else if (!filter.t()) {
                    throw new RuntimeException(i10.b("stream.could.not.be.compressed.filter.is.not.a.name.or.array", new Object[0]));
                } else if (((x50) filter).M(h70.a4)) {
                    return;
                }
            }
            try {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Deflater deflater = new Deflater(compressionLevel);
                DeflaterOutputStream zip = new DeflaterOutputStream(stream, deflater);
                ByteArrayOutputStream byteArrayOutputStream = this.a;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.writeTo(zip);
                } else {
                    zip.write(this.f4495a);
                }
                zip.close();
                deflater.end();
                this.a = stream;
                this.f4495a = null;
                Q(h70.m6, new k70(stream.size()));
                if (filter == null) {
                    Q(h70, h70.a4);
                } else {
                    x50 filters = new x50(filter);
                    filters.H(0, h70.a4);
                    Q(h70, filters);
                }
                this.f4317a = true;
            } catch (IOException ioe) {
                throw new mj(ioe);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void V(v80 writer, OutputStream os) {
        super.F(writer, os);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: z40} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: a50} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: a50} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.util.zip.DeflaterOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.util.zip.DeflaterOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: a50} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void F(defpackage.v80 r12, java.io.OutputStream r13) {
        /*
            r11 = this;
            java.io.InputStream r0 = r11.f4314a
            if (r0 == 0) goto L_0x000f
            boolean r0 = r11.f4317a
            if (r0 == 0) goto L_0x000f
            h70 r0 = defpackage.h70.K3
            h70 r1 = defpackage.h70.a4
            r11.Q(r0, r1)
        L_0x000f:
            r0 = 0
            if (r12 == 0) goto L_0x0016
            o60 r0 = r12.a0()
        L_0x0016:
            r1 = 0
            if (r0 == 0) goto L_0x0045
            h70 r2 = defpackage.h70.K3
            o70 r2 = r11.I(r2)
            if (r2 == 0) goto L_0x0045
            h70 r3 = defpackage.h70.R1
            boolean r4 = r3.equals(r2)
            if (r4 == 0) goto L_0x002b
            r0 = 0
            goto L_0x0045
        L_0x002b:
            boolean r4 = r2.t()
            if (r4 == 0) goto L_0x0045
            r4 = r2
            x50 r4 = (defpackage.x50) r4
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x0045
            o70 r5 = r4.S(r1)
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0045
            r0 = 0
        L_0x0045:
            h70 r2 = defpackage.h70.m6
            o70 r3 = r11.I(r2)
            if (r0 == 0) goto L_0x006f
            if (r3 == 0) goto L_0x006f
            boolean r4 = r3.C()
            if (r4 == 0) goto L_0x006f
            r4 = r3
            k70 r4 = (defpackage.k70) r4
            int r4 = r4.J()
            k70 r5 = new k70
            int r6 = r0.a(r4)
            r5.<init>((int) r6)
            r11.Q(r2, r5)
            r11.V(r12, r13)
            r11.Q(r2, r3)
            goto L_0x0072
        L_0x006f:
            r11.V(r12, r13)
        L_0x0072:
            r2 = 9
            defpackage.v80.H(r12, r2, r11)
            byte[] r2 = b
            r13.write(r2)
            java.io.InputStream r2 = r11.f4314a
            if (r2 == 0) goto L_0x00da
            r11.d = r1
            r2 = 0
            z40 r4 = new z40
            r4.<init>(r13)
            r5 = 0
            r6 = r4
            if (r0 == 0) goto L_0x0098
            boolean r7 = r0.f()
            if (r7 != 0) goto L_0x0098
            a50 r7 = r0.e(r6)
            r5 = r7
            r6 = r7
        L_0x0098:
            r7 = 0
            boolean r8 = r11.f4317a
            if (r8 == 0) goto L_0x00af
            java.util.zip.Deflater r8 = new java.util.zip.Deflater
            int r9 = r11.f4318b
            r8.<init>(r9)
            r7 = r8
            java.util.zip.DeflaterOutputStream r8 = new java.util.zip.DeflaterOutputStream
            r9 = 32768(0x8000, float:4.5918E-41)
            r8.<init>(r6, r7, r9)
            r2 = r8
            r6 = r8
        L_0x00af:
            r8 = 4192(0x1060, float:5.874E-42)
            byte[] r8 = new byte[r8]
        L_0x00b3:
            java.io.InputStream r9 = r11.f4314a
            int r9 = r9.read(r8)
            if (r9 > 0) goto L_0x00d1
            if (r2 == 0) goto L_0x00c4
            r2.finish()
            r7.end()
        L_0x00c4:
            if (r5 == 0) goto L_0x00c9
            r5.c()
        L_0x00c9:
            long r9 = r4.c()
            int r1 = (int) r9
            r11.f4319c = r1
            goto L_0x0106
        L_0x00d1:
            r6.write(r8, r1, r9)
            int r10 = r11.d
            int r10 = r10 + r9
            r11.d = r10
            goto L_0x00b3
        L_0x00da:
            if (r0 == 0) goto L_0x00f9
            boolean r1 = r0.f()
            if (r1 != 0) goto L_0x00f9
            java.io.ByteArrayOutputStream r1 = r11.a
            if (r1 == 0) goto L_0x00ef
            byte[] r1 = r1.toByteArray()
            byte[] r1 = r0.d(r1)
            goto L_0x00f5
        L_0x00ef:
            byte[] r1 = r11.f4495a
            byte[] r1 = r0.d(r1)
        L_0x00f5:
            r13.write(r1)
            goto L_0x0106
        L_0x00f9:
            java.io.ByteArrayOutputStream r1 = r11.a
            if (r1 == 0) goto L_0x0101
            r1.writeTo(r13)
            goto L_0x0106
        L_0x0101:
            byte[] r1 = r11.f4495a
            r13.write(r1)
        L_0x0106:
            byte[] r1 = c
            r13.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m80.F(v80, java.io.OutputStream):void");
    }

    public void W(OutputStream os) {
        ByteArrayOutputStream byteArrayOutputStream = this.a;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.writeTo(os);
            return;
        }
        byte[] bArr = this.f4495a;
        if (bArr != null) {
            os.write(bArr);
        }
    }

    public String toString() {
        h70 h70 = h70.Bc;
        if (I(h70) == null) {
            return "Stream";
        }
        return "Stream of type: " + I(h70);
    }
}
