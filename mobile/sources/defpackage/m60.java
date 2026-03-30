package defpackage;

import java.io.InputStream;

/* renamed from: m60  reason: default package */
public class m60 extends m80 {
    public m60(InputStream in, v80 writer) {
        super(in, writer);
    }

    public m60(byte[] fileStore) {
        super(fileStore);
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
            if (r0 == 0) goto L_0x0086
            boolean r2 = r0.f()
            if (r2 == 0) goto L_0x0086
            x50 r2 = new x50
            r2.<init>()
            x50 r3 = new x50
            r3.<init>()
            j60 r4 = new j60
            r4.<init>()
            h70 r5 = defpackage.h70.h7
            h70 r6 = defpackage.h70.gb
            r4.Q(r5, r6)
            h70 r5 = defpackage.h70.R1
            r2.I(r5)
            r3.I(r4)
            boolean r5 = r11.f4317a
            if (r5 == 0) goto L_0x007c
            h70 r5 = defpackage.h70.a4
            r2.I(r5)
            j70 r5 = new j70
            r5.<init>()
            r3.I(r5)
        L_0x007c:
            h70 r5 = defpackage.h70.K3
            r11.Q(r5, r2)
            h70 r5 = defpackage.h70.f2
            r11.Q(r5, r3)
        L_0x0086:
            h70 r2 = defpackage.h70.m6
            o70 r3 = r11.I(r2)
            if (r0 == 0) goto L_0x00b0
            if (r3 == 0) goto L_0x00b0
            boolean r4 = r3.C()
            if (r4 == 0) goto L_0x00b0
            r4 = r3
            k70 r4 = (defpackage.k70) r4
            int r4 = r4.J()
            k70 r5 = new k70
            int r6 = r0.a(r4)
            r5.<init>((int) r6)
            r11.Q(r2, r5)
            r11.V(r12, r13)
            r11.Q(r2, r3)
            goto L_0x00b3
        L_0x00b0:
            r11.V(r12, r13)
        L_0x00b3:
            byte[] r2 = defpackage.m80.b
            r13.write(r2)
            java.io.InputStream r2 = r11.f4314a
            if (r2 == 0) goto L_0x0110
            r11.d = r1
            r2 = 0
            z40 r4 = new z40
            r4.<init>(r13)
            r5 = 0
            r6 = r4
            if (r0 == 0) goto L_0x00ce
            a50 r7 = r0.e(r6)
            r5 = r7
            r6 = r7
        L_0x00ce:
            r7 = 0
            boolean r8 = r11.f4317a
            if (r8 == 0) goto L_0x00e5
            java.util.zip.Deflater r8 = new java.util.zip.Deflater
            int r9 = r11.f4318b
            r8.<init>(r9)
            r7 = r8
            java.util.zip.DeflaterOutputStream r8 = new java.util.zip.DeflaterOutputStream
            r9 = 32768(0x8000, float:4.5918E-41)
            r8.<init>(r6, r7, r9)
            r2 = r8
            r6 = r8
        L_0x00e5:
            r8 = 4192(0x1060, float:5.874E-42)
            byte[] r8 = new byte[r8]
        L_0x00e9:
            java.io.InputStream r9 = r11.f4314a
            int r9 = r9.read(r8)
            if (r9 > 0) goto L_0x0107
            if (r2 == 0) goto L_0x00fa
            r2.finish()
            r7.end()
        L_0x00fa:
            if (r5 == 0) goto L_0x00ff
            r5.c()
        L_0x00ff:
            long r9 = r4.c()
            int r1 = (int) r9
            r11.f4319c = r1
            goto L_0x0136
        L_0x0107:
            r6.write(r8, r1, r9)
            int r10 = r11.d
            int r10 = r10 + r9
            r11.d = r10
            goto L_0x00e9
        L_0x0110:
            if (r0 != 0) goto L_0x0120
            java.io.ByteArrayOutputStream r1 = r11.a
            if (r1 == 0) goto L_0x011a
            r1.writeTo(r13)
            goto L_0x0136
        L_0x011a:
            byte[] r1 = r11.f4495a
            r13.write(r1)
            goto L_0x0136
        L_0x0120:
            java.io.ByteArrayOutputStream r1 = r11.a
            if (r1 == 0) goto L_0x012d
            byte[] r1 = r1.toByteArray()
            byte[] r1 = r0.d(r1)
            goto L_0x0133
        L_0x012d:
            byte[] r1 = r11.f4495a
            byte[] r1 = r0.d(r1)
        L_0x0133:
            r13.write(r1)
        L_0x0136:
            byte[] r1 = defpackage.m80.c
            r13.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m60.F(v80, java.io.OutputStream):void");
    }
}
