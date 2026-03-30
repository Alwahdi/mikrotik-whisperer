package defpackage;

import java.io.OutputStream;

/* renamed from: q60  reason: default package */
public class q60 extends j60 {
    protected v80 a;

    /* renamed from: a  reason: collision with other field name */
    protected z60 f4771a;

    public q60() {
        super(h70.J3);
    }

    public static q60 T(v80 writer, String filePath, String fileDisplay, byte[] fileStore) {
        return U(writer, filePath, fileDisplay, fileStore, 9);
    }

    public static q60 U(v80 writer, String filePath, String fileDisplay, byte[] fileStore, int compressionLevel) {
        return V(writer, filePath, fileDisplay, fileStore, (String) null, (j60) null, compressionLevel);
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0110 A[SYNTHETIC, Splitter:B:51:0x0110] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.q60 V(defpackage.v80 r9, java.lang.String r10, java.lang.String r11, byte[] r12, java.lang.String r13, defpackage.j60 r14, int r15) {
        /*
            q60 r0 = new q60
            r0.<init>()
            r0.a = r9
            h70 r1 = defpackage.h70.w3
            n80 r2 = new n80
            r2.<init>((java.lang.String) r11)
            r0.Q(r1, r2)
            r1 = 0
            r0.Y(r11, r1)
            r2 = 0
            r3 = 0
            r4 = 0
            if (r12 != 0) goto L_0x007c
            z60 r5 = r9.m0()     // Catch:{ all -> 0x010c }
            r3 = r5
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x010c }
            r5.<init>(r10)     // Catch:{ all -> 0x010c }
            boolean r6 = r5.canRead()     // Catch:{ all -> 0x010c }
            if (r6 == 0) goto L_0x0031
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x010c }
            r1.<init>(r10)     // Catch:{ all -> 0x010c }
            r2 = r1
            goto L_0x0075
        L_0x0031:
            java.lang.String r6 = "file:/"
            boolean r6 = r10.startsWith(r6)     // Catch:{ all -> 0x010c }
            if (r6 != 0) goto L_0x006b
            java.lang.String r6 = "http://"
            boolean r6 = r10.startsWith(r6)     // Catch:{ all -> 0x010c }
            if (r6 != 0) goto L_0x006b
            java.lang.String r6 = "https://"
            boolean r6 = r10.startsWith(r6)     // Catch:{ all -> 0x010c }
            if (r6 != 0) goto L_0x006b
            java.lang.String r6 = "jar:"
            boolean r6 = r10.startsWith(r6)     // Catch:{ all -> 0x010c }
            if (r6 == 0) goto L_0x0052
            goto L_0x006b
        L_0x0052:
            java.io.InputStream r6 = defpackage.nn0.a(r10)     // Catch:{ all -> 0x010c }
            r2 = r6
            if (r2 == 0) goto L_0x005a
            goto L_0x0075
        L_0x005a:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x010c }
            java.lang.String r7 = "1.not.found.as.file.or.resource"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x010c }
            r8[r1] = r10     // Catch:{ all -> 0x010c }
            java.lang.String r1 = defpackage.i10.b(r7, r8)     // Catch:{ all -> 0x010c }
            r6.<init>(r1)     // Catch:{ all -> 0x010c }
            throw r6     // Catch:{ all -> 0x010c }
        L_0x006b:
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x010c }
            r1.<init>(r10)     // Catch:{ all -> 0x010c }
            java.io.InputStream r1 = r1.openStream()     // Catch:{ all -> 0x010c }
            r2 = r1
        L_0x0075:
            m60 r1 = new m60     // Catch:{ all -> 0x010c }
            r1.<init>(r2, r9)     // Catch:{ all -> 0x010c }
            r5 = r1
            goto L_0x0082
        L_0x007c:
            m60 r1 = new m60     // Catch:{ all -> 0x010c }
            r1.<init>(r12)     // Catch:{ all -> 0x010c }
            r5 = r1
        L_0x0082:
            h70 r1 = defpackage.h70.Bc     // Catch:{ all -> 0x010a }
            h70 r6 = defpackage.h70.Z2     // Catch:{ all -> 0x010a }
            r5.Q(r1, r6)     // Catch:{ all -> 0x010a }
            r5.T(r15)     // Catch:{ all -> 0x010a }
            j60 r1 = new j60     // Catch:{ all -> 0x010a }
            r1.<init>()     // Catch:{ all -> 0x010a }
            if (r14 == 0) goto L_0x0096
            r1.O(r14)     // Catch:{ all -> 0x010a }
        L_0x0096:
            h70 r6 = defpackage.h70.Z6     // Catch:{ all -> 0x010a }
            boolean r7 = r1.H(r6)     // Catch:{ all -> 0x010a }
            if (r7 != 0) goto L_0x00a6
            g60 r7 = new g60     // Catch:{ all -> 0x010a }
            r7.<init>()     // Catch:{ all -> 0x010a }
            r1.Q(r6, r7)     // Catch:{ all -> 0x010a }
        L_0x00a6:
            if (r12 != 0) goto L_0x00ae
            h70 r6 = defpackage.h70.t8     // Catch:{ all -> 0x010a }
            r5.Q(r6, r3)     // Catch:{ all -> 0x010a }
            goto L_0x00c1
        L_0x00ae:
            h70 r6 = defpackage.h70.Ma     // Catch:{ all -> 0x010a }
            k70 r7 = new k70     // Catch:{ all -> 0x010a }
            int r8 = r5.U()     // Catch:{ all -> 0x010a }
            r7.<init>((int) r8)     // Catch:{ all -> 0x010a }
            r1.Q(r6, r7)     // Catch:{ all -> 0x010a }
            h70 r6 = defpackage.h70.t8     // Catch:{ all -> 0x010a }
            r5.Q(r6, r1)     // Catch:{ all -> 0x010a }
        L_0x00c1:
            if (r13 == 0) goto L_0x00cd
            h70 r6 = defpackage.h70.tb     // Catch:{ all -> 0x010a }
            h70 r7 = new h70     // Catch:{ all -> 0x010a }
            r7.<init>(r13)     // Catch:{ all -> 0x010a }
            r5.Q(r6, r7)     // Catch:{ all -> 0x010a }
        L_0x00cd:
            y60 r6 = r9.y(r5)     // Catch:{ all -> 0x010a }
            z60 r4 = r6.a()     // Catch:{ all -> 0x010a }
            if (r12 != 0) goto L_0x00ee
            r5.X()     // Catch:{ all -> 0x00ec }
            h70 r6 = defpackage.h70.Ma     // Catch:{ all -> 0x00ec }
            k70 r7 = new k70     // Catch:{ all -> 0x00ec }
            int r8 = r5.U()     // Catch:{ all -> 0x00ec }
            r7.<init>((int) r8)     // Catch:{ all -> 0x00ec }
            r1.Q(r6, r7)     // Catch:{ all -> 0x00ec }
            r9.z(r1, r3)     // Catch:{ all -> 0x00ec }
            goto L_0x00ee
        L_0x00ec:
            r1 = move-exception
            goto L_0x010e
        L_0x00ee:
            if (r2 == 0) goto L_0x00f5
            r2.close()     // Catch:{ Exception -> 0x00f4 }
            goto L_0x00f5
        L_0x00f4:
            r1 = move-exception
        L_0x00f5:
            j60 r1 = new j60
            r1.<init>()
            h70 r6 = defpackage.h70.w3
            r1.Q(r6, r4)
            h70 r6 = defpackage.h70.Hc
            r1.Q(r6, r4)
            h70 r6 = defpackage.h70.V2
            r0.Q(r6, r1)
            return r0
        L_0x010a:
            r1 = move-exception
            goto L_0x010e
        L_0x010c:
            r1 = move-exception
            r5 = r4
        L_0x010e:
            if (r2 == 0) goto L_0x0115
            r2.close()     // Catch:{ Exception -> 0x0114 }
            goto L_0x0115
        L_0x0114:
            r6 = move-exception
        L_0x0115:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q60.V(v80, java.lang.String, java.lang.String, byte[], java.lang.String, j60, int):q60");
    }

    public static q60 W(v80 writer, String filePath) {
        q60 fs = new q60();
        fs.a = writer;
        fs.Q(h70.w3, new n80(filePath));
        fs.Y(filePath, false);
        return fs;
    }

    public z60 X() {
        z60 z60 = this.f4771a;
        if (z60 != null) {
            return z60;
        }
        z60 a2 = this.a.y(this).a();
        this.f4771a = a2;
        return a2;
    }

    public void Y(String filename, boolean unicode) {
        Q(h70.Hc, new n80(filename, unicode ? "UnicodeBig" : "PDF"));
    }

    public void F(v80 writer, OutputStream os) {
        v80.H(writer, 10, this);
        super.F(writer, os);
    }
}
