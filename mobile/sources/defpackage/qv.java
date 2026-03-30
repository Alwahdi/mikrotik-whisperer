package defpackage;

import java.io.InputStream;
import java.net.URL;
import org.apache.http.HttpStatus;

/* renamed from: qv  reason: default package */
public class qv extends tr {
    public static final int[] b = {192, 193, 194};
    public static final byte[] c = {74, 70, 73, 70, 0};

    /* renamed from: c  reason: collision with other field name */
    public static final int[] f4864c = {195, 197, 198, 199, 200, HttpStatus.SC_CREATED, HttpStatus.SC_ACCEPTED, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, HttpStatus.SC_RESET_CONTENT, HttpStatus.SC_PARTIAL_CONTENT, HttpStatus.SC_MULTI_STATUS};
    public static final byte[] d = {56, 66, 73, 77, 3, -19};

    /* renamed from: d  reason: collision with other field name */
    public static final int[] f4865d = {208, 209, 210, 211, 212, 213, 214, 215, 216, 1};
    private byte[][] a;

    public qv(URL url) {
        super(url);
        v1();
    }

    public qv(byte[] img) {
        super((URL) null);
        this.f5139a = img;
        this.f5142b = img;
        v1();
    }

    private static final int t1(InputStream is) {
        return (is.read() << 8) + is.read();
    }

    private static final int u1(int marker) {
        int i = 0;
        while (true) {
            int[] iArr = b;
            if (i >= iArr.length) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = f4865d;
                    if (i2 >= iArr2.length) {
                        int i3 = 0;
                        while (true) {
                            int[] iArr3 = f4864c;
                            if (i3 >= iArr3.length) {
                                return -1;
                            }
                            if (marker == iArr3[i3]) {
                                return 1;
                            }
                            i3++;
                        }
                    } else if (marker == iArr2[i2]) {
                        return 2;
                    } else {
                        i2++;
                    }
                }
            } else if (marker == iArr[i]) {
                return 0;
            } else {
                i++;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v30 */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0265, code lost:
        defpackage.tu0.j(r2, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x026f, code lost:
        if (r2.read() != 8) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0271, code lost:
        r6 = (float) t1(r2);
        r1.o = r6;
        Y(r6);
        r6 = (float) t1(r2);
        r1.n = r6;
        W(r6);
        r1.f5149j = r2.read();
        r1.d = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x028f, code lost:
        r2.close();
        r1.l = M();
        r1.m = D();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02a2, code lost:
        if (r1.a == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02a4, code lost:
        r3 = 0;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02a6, code lost:
        r5 = r1.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02aa, code lost:
        if (r4 >= r5.length) goto L_0x02bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02ae, code lost:
        if (r5[r4] != null) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02b0, code lost:
        r1.a = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02b2, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02b3, code lost:
        r3 = r3 + (r5[r4].length - 14);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02bb, code lost:
        r4 = new byte[r3];
        r3 = 0;
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02bf, code lost:
        r6 = r1.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02c2, code lost:
        if (r5 >= r6.length) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02c4, code lost:
        java.lang.System.arraycopy(r6[r5], 14, r4, r3, r6[r5].length - 14);
        r3 = r3 + (r1.a[r5].length - 14);
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        s1(defpackage.dr.c(r4, r1.f5149j));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02f6, code lost:
        throw new defpackage.n5(defpackage.i10.b("1.must.have.8.bits.per.component", r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:?, code lost:
        return;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r0v4, types: [int, boolean] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0235 A[Catch:{ all -> 0x0347 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0239 A[Catch:{ all -> 0x0347 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x023c A[Catch:{ all -> 0x0347 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0248 A[Catch:{ all -> 0x0347 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v1() {
        /*
            r20 = this;
            r1 = r20
            r0 = 32
            r1.c = r0
            r0 = 1
            r1.g = r0
            r2 = 0
            byte[] r3 = r1.f5139a     // Catch:{ all -> 0x0347 }
            if (r3 != 0) goto L_0x001c
            java.net.URL r3 = r1.f5134a     // Catch:{ all -> 0x0347 }
            java.io.InputStream r3 = r3.openStream()     // Catch:{ all -> 0x0347 }
            r2 = r3
            java.net.URL r3 = r1.f5134a     // Catch:{ all -> 0x0347 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0347 }
            goto L_0x0026
        L_0x001c:
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0347 }
            byte[] r4 = r1.f5139a     // Catch:{ all -> 0x0347 }
            r3.<init>(r4)     // Catch:{ all -> 0x0347 }
            r2 = r3
            java.lang.String r3 = "Byte array"
        L_0x0026:
            int r4 = r2.read()     // Catch:{ all -> 0x0347 }
            r6 = 255(0xff, float:3.57E-43)
            if (r4 != r6) goto L_0x0335
            int r4 = r2.read()     // Catch:{ all -> 0x0347 }
            r7 = 216(0xd8, float:3.03E-43)
            if (r4 != r7) goto L_0x0335
            r4 = 1
        L_0x0037:
            int r7 = r2.read()     // Catch:{ all -> 0x0347 }
            if (r7 < 0) goto L_0x0326
            if (r7 != r6) goto L_0x031f
            int r8 = r2.read()     // Catch:{ all -> 0x0347 }
            r9 = 16
            r11 = 1076006748(0x40228f5c, float:2.54)
            r12 = 2
            if (r4 == 0) goto L_0x00d0
            r13 = 224(0xe0, float:3.14E-43)
            if (r8 != r13) goto L_0x00d0
            r4 = 0
            int r13 = t1(r2)     // Catch:{ all -> 0x0347 }
            if (r13 >= r9) goto L_0x005c
            int r9 = r13 + -2
            defpackage.tu0.j(r2, r9)     // Catch:{ all -> 0x0347 }
            goto L_0x00bb
        L_0x005c:
            byte[] r9 = c     // Catch:{ all -> 0x0347 }
            int r9 = r9.length     // Catch:{ all -> 0x0347 }
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x0347 }
            int r14 = r2.read(r9)     // Catch:{ all -> 0x0347 }
            int r15 = r9.length     // Catch:{ all -> 0x0347 }
            if (r14 != r15) goto L_0x00bf
            r15 = 1
            r16 = 0
            r6 = r16
        L_0x006d:
            int r5 = r9.length     // Catch:{ all -> 0x0347 }
            if (r6 >= r5) goto L_0x007d
            byte r5 = r9[r6]     // Catch:{ all -> 0x0347 }
            byte[] r18 = c     // Catch:{ all -> 0x0347 }
            byte r10 = r18[r6]     // Catch:{ all -> 0x0347 }
            if (r5 == r10) goto L_0x007a
            r15 = 0
            goto L_0x007d
        L_0x007a:
            int r6 = r6 + 1
            goto L_0x006d
        L_0x007d:
            if (r15 != 0) goto L_0x0087
            int r5 = r13 + -2
            int r6 = r9.length     // Catch:{ all -> 0x0347 }
            int r5 = r5 - r6
            defpackage.tu0.j(r2, r5)     // Catch:{ all -> 0x0347 }
            goto L_0x00bb
        L_0x0087:
            defpackage.tu0.j(r2, r12)     // Catch:{ all -> 0x0347 }
            int r5 = r2.read()     // Catch:{ all -> 0x0347 }
            int r6 = t1(r2)     // Catch:{ all -> 0x0347 }
            int r10 = t1(r2)     // Catch:{ all -> 0x0347 }
            if (r5 != r0) goto L_0x009d
            r1.h = r6     // Catch:{ all -> 0x0347 }
            r1.i = r10     // Catch:{ all -> 0x0347 }
            goto L_0x00b1
        L_0x009d:
            if (r5 != r12) goto L_0x00b1
            float r12 = (float) r6     // Catch:{ all -> 0x0347 }
            float r12 = r12 * r11
            r18 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r18
            int r12 = (int) r12     // Catch:{ all -> 0x0347 }
            r1.h = r12     // Catch:{ all -> 0x0347 }
            float r12 = (float) r10     // Catch:{ all -> 0x0347 }
            float r12 = r12 * r11
            float r12 = r12 + r18
            int r11 = (int) r12     // Catch:{ all -> 0x0347 }
            r1.i = r11     // Catch:{ all -> 0x0347 }
        L_0x00b1:
            int r11 = r13 + -2
            int r12 = r9.length     // Catch:{ all -> 0x0347 }
            int r11 = r11 - r12
            int r11 = r11 + -7
            defpackage.tu0.j(r2, r11)     // Catch:{ all -> 0x0347 }
        L_0x00bb:
            r6 = 255(0xff, float:3.57E-43)
            goto L_0x0037
        L_0x00bf:
            n5 r5 = new n5     // Catch:{ all -> 0x0347 }
            java.lang.String r6 = "1.corrupted.jfif.marker"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0347 }
            r10 = 0
            r0[r10] = r3     // Catch:{ all -> 0x0347 }
            java.lang.String r0 = defpackage.i10.b(r6, r0)     // Catch:{ all -> 0x0347 }
            r5.<init>(r0)     // Catch:{ all -> 0x0347 }
            throw r5     // Catch:{ all -> 0x0347 }
        L_0x00d0:
            r5 = 238(0xee, float:3.34E-43)
            java.lang.String r6 = "ISO-8859-1"
            r10 = 12
            if (r8 != r5) goto L_0x0109
            int r5 = t1(r2)     // Catch:{ all -> 0x0347 }
            int r5 = r5 - r12
            byte[] r9 = new byte[r5]     // Catch:{ all -> 0x0347 }
            r11 = 0
        L_0x00e0:
            if (r11 >= r5) goto L_0x00ec
            int r12 = r2.read()     // Catch:{ all -> 0x0347 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x0347 }
            r9[r11] = r12     // Catch:{ all -> 0x0347 }
            int r11 = r11 + 1
            goto L_0x00e0
        L_0x00ec:
            int r11 = r9.length     // Catch:{ all -> 0x0347 }
            if (r11 < r10) goto L_0x0105
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x0347 }
            r11 = 5
            r12 = 0
            r10.<init>(r9, r12, r11, r6)     // Catch:{ all -> 0x0347 }
            r6 = r10
            java.lang.String r10 = "Adobe"
            boolean r10 = r6.equals(r10)     // Catch:{ all -> 0x0347 }
            if (r10 == 0) goto L_0x0101
            r1.f5146f = r0     // Catch:{ all -> 0x0347 }
        L_0x0101:
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0257
        L_0x0105:
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0257
        L_0x0109:
            r5 = 226(0xe2, float:3.17E-43)
            r13 = 14
            if (r8 != r5) goto L_0x015d
            int r5 = t1(r2)     // Catch:{ all -> 0x0347 }
            int r5 = r5 - r12
            byte[] r9 = new byte[r5]     // Catch:{ all -> 0x0347 }
            r11 = 0
        L_0x0117:
            if (r11 >= r5) goto L_0x0123
            int r12 = r2.read()     // Catch:{ all -> 0x0347 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x0347 }
            r9[r11] = r12     // Catch:{ all -> 0x0347 }
            int r11 = r11 + 1
            goto L_0x0117
        L_0x0123:
            int r11 = r9.length     // Catch:{ all -> 0x0347 }
            if (r11 < r13) goto L_0x0159
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0347 }
            r12 = 11
            r13 = 0
            r11.<init>(r9, r13, r12, r6)     // Catch:{ all -> 0x0347 }
            r6 = r11
            java.lang.String r11 = "ICC_PROFILE"
            boolean r11 = r6.equals(r11)     // Catch:{ all -> 0x0347 }
            if (r11 == 0) goto L_0x0155
            byte r10 = r9[r10]     // Catch:{ all -> 0x0347 }
            r11 = 255(0xff, float:3.57E-43)
            r10 = r10 & r11
            r12 = 13
            byte r12 = r9[r12]     // Catch:{ all -> 0x0347 }
            r12 = r12 & r11
            if (r10 >= r0) goto L_0x0144
            r10 = 1
        L_0x0144:
            if (r12 >= r0) goto L_0x0147
            r12 = 1
        L_0x0147:
            byte[][] r11 = r1.a     // Catch:{ all -> 0x0347 }
            if (r11 != 0) goto L_0x014f
            byte[][] r11 = new byte[r12][]     // Catch:{ all -> 0x0347 }
            r1.a = r11     // Catch:{ all -> 0x0347 }
        L_0x014f:
            byte[][] r11 = r1.a     // Catch:{ all -> 0x0347 }
            int r13 = r10 + -1
            r11[r13] = r9     // Catch:{ all -> 0x0347 }
        L_0x0155:
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0257
        L_0x0159:
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0257
        L_0x015d:
            r5 = 237(0xed, float:3.32E-43)
            r6 = 8
            if (r8 != r5) goto L_0x025a
            int r5 = t1(r2)     // Catch:{ all -> 0x0347 }
            int r5 = r5 - r12
            byte[] r10 = new byte[r5]     // Catch:{ all -> 0x0347 }
            r13 = 0
        L_0x016b:
            if (r13 >= r5) goto L_0x0177
            int r14 = r2.read()     // Catch:{ all -> 0x0347 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x0347 }
            r10[r13] = r14     // Catch:{ all -> 0x0347 }
            int r13 = r13 + 1
            goto L_0x016b
        L_0x0177:
            r13 = 0
            r13 = 0
        L_0x0179:
            byte[] r14 = d     // Catch:{ all -> 0x0347 }
            int r14 = r14.length     // Catch:{ all -> 0x0347 }
            int r14 = r5 - r14
            if (r13 >= r14) goto L_0x01a2
            r14 = 1
            r15 = 0
        L_0x0182:
            byte[] r11 = d     // Catch:{ all -> 0x0347 }
            int r12 = r11.length     // Catch:{ all -> 0x0347 }
            if (r15 >= r12) goto L_0x0198
            int r12 = r13 + r15
            byte r12 = r10[r12]     // Catch:{ all -> 0x0347 }
            byte r11 = r11[r15]     // Catch:{ all -> 0x0347 }
            if (r12 == r11) goto L_0x0191
            r14 = 0
            goto L_0x0198
        L_0x0191:
            int r15 = r15 + 1
            r11 = 1076006748(0x40228f5c, float:2.54)
            r12 = 2
            goto L_0x0182
        L_0x0198:
            if (r14 == 0) goto L_0x019b
            goto L_0x01a2
        L_0x019b:
            int r13 = r13 + 1
            r11 = 1076006748(0x40228f5c, float:2.54)
            r12 = 2
            goto L_0x0179
        L_0x01a2:
            byte[] r11 = d     // Catch:{ all -> 0x0347 }
            int r12 = r11.length     // Catch:{ all -> 0x0347 }
            int r13 = r13 + r12
            int r11 = r11.length     // Catch:{ all -> 0x0347 }
            int r11 = r5 - r11
            if (r13 >= r11) goto L_0x0254
            byte r11 = r10[r13]     // Catch:{ all -> 0x0347 }
            int r12 = r11 + 1
            byte r11 = (byte) r12     // Catch:{ all -> 0x0347 }
            int r12 = r11 % 2
            if (r12 != r0) goto L_0x01b7
            int r12 = r11 + 1
            byte r11 = (byte) r12     // Catch:{ all -> 0x0347 }
        L_0x01b7:
            int r13 = r13 + r11
            byte r12 = r10[r13]     // Catch:{ all -> 0x0347 }
            int r12 = r12 << 24
            int r14 = r13 + 1
            byte r14 = r10[r14]     // Catch:{ all -> 0x0347 }
            int r14 = r14 << r9
            int r12 = r12 + r14
            int r14 = r13 + 2
            byte r14 = r10[r14]     // Catch:{ all -> 0x0347 }
            int r14 = r14 << r6
            int r12 = r12 + r14
            int r14 = r13 + 3
            byte r14 = r10[r14]     // Catch:{ all -> 0x0347 }
            int r12 = r12 + r14
            if (r12 == r9) goto L_0x01d3
            r13 = 255(0xff, float:3.57E-43)
            goto L_0x0257
        L_0x01d3:
            int r13 = r13 + 4
            byte r9 = r10[r13]     // Catch:{ all -> 0x0347 }
            int r9 = r9 << r6
            int r14 = r13 + 1
            byte r14 = r10[r14]     // Catch:{ all -> 0x0347 }
            r15 = 255(0xff, float:3.57E-43)
            r14 = r14 & r15
            int r9 = r9 + r14
            int r13 = r13 + 2
            r14 = 2
            int r13 = r13 + r14
            byte r14 = r10[r13]     // Catch:{ all -> 0x0347 }
            int r14 = r14 << r6
            int r15 = r13 + 1
            byte r15 = r10[r15]     // Catch:{ all -> 0x0347 }
            r0 = 255(0xff, float:3.57E-43)
            r15 = r15 & r0
            int r14 = r14 + r15
            int r13 = r13 + 2
            r0 = 2
            int r13 = r13 + r0
            byte r0 = r10[r13]     // Catch:{ all -> 0x0347 }
            int r0 = r0 << r6
            int r15 = r13 + 1
            byte r15 = r10[r15]     // Catch:{ all -> 0x0347 }
            r6 = 255(0xff, float:3.57E-43)
            r15 = r15 & r6
            int r0 = r0 + r15
            int r13 = r13 + 2
            r6 = 2
            int r13 = r13 + r6
            byte r6 = r10[r13]     // Catch:{ all -> 0x0347 }
            r15 = 8
            int r6 = r6 << r15
            int r15 = r13 + 1
            byte r15 = r10[r15]     // Catch:{ all -> 0x0347 }
            r19 = r13
            r13 = 255(0xff, float:3.57E-43)
            r15 = r15 & r13
            int r6 = r6 + r15
            r15 = 1
            if (r14 == r15) goto L_0x0218
            r15 = 2
            if (r14 != r15) goto L_0x0232
            goto L_0x0219
        L_0x0218:
            r15 = 2
        L_0x0219:
            if (r14 != r15) goto L_0x0227
            float r15 = (float) r9     // Catch:{ all -> 0x0347 }
            r17 = 1076006748(0x40228f5c, float:2.54)
            float r15 = r15 * r17
            r17 = 1056964608(0x3f000000, float:0.5)
            float r15 = r15 + r17
            int r15 = (int) r15     // Catch:{ all -> 0x0347 }
            goto L_0x0228
        L_0x0227:
            r15 = r9
        L_0x0228:
            r9 = r15
            int r15 = r1.h     // Catch:{ all -> 0x0347 }
            if (r15 == 0) goto L_0x0230
            if (r15 == r9) goto L_0x0230
            goto L_0x0232
        L_0x0230:
            r1.h = r9     // Catch:{ all -> 0x0347 }
        L_0x0232:
            r15 = 1
            if (r6 == r15) goto L_0x0239
            r15 = 2
            if (r6 != r15) goto L_0x0253
            goto L_0x023a
        L_0x0239:
            r15 = 2
        L_0x023a:
            if (r6 != r15) goto L_0x0248
            float r15 = (float) r0     // Catch:{ all -> 0x0347 }
            r17 = 1076006748(0x40228f5c, float:2.54)
            float r15 = r15 * r17
            r17 = 1056964608(0x3f000000, float:0.5)
            float r15 = r15 + r17
            int r15 = (int) r15     // Catch:{ all -> 0x0347 }
            goto L_0x0249
        L_0x0248:
            r15 = r0
        L_0x0249:
            r0 = r15
            int r15 = r1.i     // Catch:{ all -> 0x0347 }
            if (r15 == 0) goto L_0x0251
            if (r15 == r0) goto L_0x0251
            goto L_0x0253
        L_0x0251:
            r1.i = r0     // Catch:{ all -> 0x0347 }
        L_0x0253:
            goto L_0x0257
        L_0x0254:
            r0 = r13
            r13 = 255(0xff, float:3.57E-43)
        L_0x0257:
            r0 = 1
            goto L_0x00bb
        L_0x025a:
            r0 = 14
            r13 = 255(0xff, float:3.57E-43)
            r4 = 0
            int r5 = u1(r8)     // Catch:{ all -> 0x0347 }
            if (r5 != 0) goto L_0x02f7
            r6 = 2
            defpackage.tu0.j(r2, r6)     // Catch:{ all -> 0x0347 }
            int r6 = r2.read()     // Catch:{ all -> 0x0347 }
            r9 = 8
            if (r6 != r9) goto L_0x02e5
            int r6 = t1(r2)     // Catch:{ all -> 0x0347 }
            float r6 = (float) r6     // Catch:{ all -> 0x0347 }
            r1.o = r6     // Catch:{ all -> 0x0347 }
            r1.Y(r6)     // Catch:{ all -> 0x0347 }
            int r6 = t1(r2)     // Catch:{ all -> 0x0347 }
            float r6 = (float) r6     // Catch:{ all -> 0x0347 }
            r1.n = r6     // Catch:{ all -> 0x0347 }
            r1.W(r6)     // Catch:{ all -> 0x0347 }
            int r6 = r2.read()     // Catch:{ all -> 0x0347 }
            r1.f5149j = r6     // Catch:{ all -> 0x0347 }
            r6 = 8
            r1.d = r6     // Catch:{ all -> 0x0347 }
            r2.close()
            float r3 = r20.M()
            r1.l = r3
            float r3 = r20.D()
            r1.m = r3
            byte[][] r3 = r1.a
            if (r3 == 0) goto L_0x02e4
            r3 = 0
            r4 = 0
        L_0x02a6:
            byte[][] r5 = r1.a
            int r6 = r5.length
            r7 = 0
            if (r4 >= r6) goto L_0x02bb
            r6 = r5[r4]
            if (r6 != 0) goto L_0x02b3
            r1.a = r7
            return
        L_0x02b3:
            r5 = r5[r4]
            int r5 = r5.length
            int r5 = r5 - r0
            int r3 = r3 + r5
            int r4 = r4 + 1
            goto L_0x02a6
        L_0x02bb:
            byte[] r4 = new byte[r3]
            r3 = 0
            r5 = 0
        L_0x02bf:
            byte[][] r6 = r1.a
            int r8 = r6.length
            if (r5 >= r8) goto L_0x02d7
            r8 = r6[r5]
            r6 = r6[r5]
            int r6 = r6.length
            int r6 = r6 - r0
            java.lang.System.arraycopy(r8, r0, r4, r3, r6)
            byte[][] r6 = r1.a
            r6 = r6[r5]
            int r6 = r6.length
            int r6 = r6 - r0
            int r3 = r3 + r6
            int r5 = r5 + 1
            goto L_0x02bf
        L_0x02d7:
            int r0 = r1.f5149j     // Catch:{ IllegalArgumentException -> 0x02e1 }
            dr r0 = defpackage.dr.c(r4, r0)     // Catch:{ IllegalArgumentException -> 0x02e1 }
            r1.s1(r0)     // Catch:{ IllegalArgumentException -> 0x02e1 }
            goto L_0x02e2
        L_0x02e1:
            r0 = move-exception
        L_0x02e2:
            r1.a = r7
        L_0x02e4:
            return
        L_0x02e5:
            n5 r0 = new n5     // Catch:{ all -> 0x0347 }
            java.lang.String r6 = "1.must.have.8.bits.per.component"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0347 }
            r10 = 0
            r9[r10] = r3     // Catch:{ all -> 0x0347 }
            java.lang.String r6 = defpackage.i10.b(r6, r9)     // Catch:{ all -> 0x0347 }
            r0.<init>(r6)     // Catch:{ all -> 0x0347 }
            throw r0     // Catch:{ all -> 0x0347 }
        L_0x02f7:
            r0 = 1
            if (r5 == r0) goto L_0x0306
            r0 = 2
            if (r5 == r0) goto L_0x0321
            int r6 = t1(r2)     // Catch:{ all -> 0x0347 }
            int r6 = r6 - r0
            defpackage.tu0.j(r2, r6)     // Catch:{ all -> 0x0347 }
            goto L_0x0321
        L_0x0306:
            n5 r0 = new n5     // Catch:{ all -> 0x0347 }
            java.lang.String r6 = "1.unsupported.jpeg.marker.2"
            r9 = 2
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0347 }
            r10 = 0
            r9[r10] = r3     // Catch:{ all -> 0x0347 }
            java.lang.String r10 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0347 }
            r11 = 1
            r9[r11] = r10     // Catch:{ all -> 0x0347 }
            java.lang.String r6 = defpackage.i10.b(r6, r9)     // Catch:{ all -> 0x0347 }
            r0.<init>(r6)     // Catch:{ all -> 0x0347 }
            throw r0     // Catch:{ all -> 0x0347 }
        L_0x031f:
            r13 = 255(0xff, float:3.57E-43)
        L_0x0321:
            r0 = 1
            r6 = 255(0xff, float:3.57E-43)
            goto L_0x0037
        L_0x0326:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0347 }
            java.lang.String r5 = "premature.eof.while.reading.jpg"
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0347 }
            java.lang.String r5 = defpackage.i10.b(r5, r6)     // Catch:{ all -> 0x0347 }
            r0.<init>(r5)     // Catch:{ all -> 0x0347 }
            throw r0     // Catch:{ all -> 0x0347 }
        L_0x0335:
            n5 r0 = new n5     // Catch:{ all -> 0x0347 }
            java.lang.String r4 = "1.is.not.a.valid.jpeg.file"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0347 }
            r6 = 0
            r5[r6] = r3     // Catch:{ all -> 0x0347 }
            java.lang.String r4 = defpackage.i10.b(r4, r5)     // Catch:{ all -> 0x0347 }
            r0.<init>(r4)     // Catch:{ all -> 0x0347 }
            throw r0     // Catch:{ all -> 0x0347 }
        L_0x0347:
            r0 = move-exception
            if (r2 == 0) goto L_0x034d
            r2.close()
        L_0x034d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qv.v1():void");
    }
}
