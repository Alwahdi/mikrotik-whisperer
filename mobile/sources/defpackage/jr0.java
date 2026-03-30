package defpackage;

import java.util.zip.DataFormatException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* renamed from: jr0  reason: default package */
public abstract class jr0 {
    static int e(ep0 fd, int resolutionUnit) {
        if (fd == null) {
            return 0;
        }
        long[] res = fd.i(0);
        float frac = ((float) res[0]) / ((float) res[1]);
        switch (resolutionUnit) {
            case 1:
            case 2:
                return (int) (((double) frac) + 0.5d);
            case 3:
                return (int) ((((double) frac) * 2.54d) + 0.5d);
            default:
                return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0235 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03d5 A[SYNTHETIC, Splitter:B:144:0x03d5] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03f6 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008f A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00af A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bc A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d3 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d9 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f1 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0112 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0116 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012d A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013b A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0145 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014d A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0150 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x016f A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0178 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x019b A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01d7 A[Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01e4 A[ADDED_TO_REGION, Catch:{ RuntimeException -> 0x02fc, ru -> 0x0291, Exception -> 0x040b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.tr i(defpackage.cd0 r50, boolean r51, int r52, boolean r53) {
        /*
            r1 = r50
            r2 = r51
            r3 = r52
            r4 = 1
            if (r3 < r4) goto L_0x0412
            cp0 r0 = new cp0     // Catch:{ Exception -> 0x040b }
            int r6 = r3 + -1
            r0.<init>(r1, r6)     // Catch:{ Exception -> 0x040b }
            r6 = r0
            r0 = 322(0x142, float:4.51E-43)
            boolean r0 = r6.e(r0)     // Catch:{ Exception -> 0x040b }
            if (r0 != 0) goto L_0x03fb
            r0 = 1
            r7 = 259(0x103, float:3.63E-43)
            boolean r8 = r6.e(r7)     // Catch:{ Exception -> 0x040b }
            if (r8 == 0) goto L_0x0029
            long r7 = r6.b(r7)     // Catch:{ Exception -> 0x040b }
            int r0 = (int) r7     // Catch:{ Exception -> 0x040b }
            r7 = r0
            goto L_0x002a
        L_0x0029:
            r7 = r0
        L_0x002a:
            switch(r7) {
                case 2: goto L_0x0036;
                case 3: goto L_0x0036;
                case 4: goto L_0x0036;
                case 32771: goto L_0x0036;
                default: goto L_0x002d;
            }     // Catch:{ Exception -> 0x040b }
        L_0x002d:
            r2 = r6
            r42 = r7
            tr r0 = j(r2, r1)     // Catch:{ Exception -> 0x040b }
            goto L_0x03fa
        L_0x0036:
            r0 = 0
            r8 = 274(0x112, float:3.84E-43)
            boolean r9 = r6.e(r8)     // Catch:{ Exception -> 0x040b }
            r10 = 8
            r11 = 5
            if (r9 == 0) goto L_0x0069
            long r8 = r6.b(r8)     // Catch:{ Exception -> 0x040b }
            int r9 = (int) r8     // Catch:{ Exception -> 0x040b }
            r8 = 3
            if (r9 == r8) goto L_0x0064
            r8 = 4
            if (r9 != r8) goto L_0x004f
            goto L_0x0064
        L_0x004f:
            if (r9 == r11) goto L_0x005f
            if (r9 != r10) goto L_0x0054
            goto L_0x005f
        L_0x0054:
            r8 = 6
            if (r9 == r8) goto L_0x005a
            r8 = 7
            if (r9 != r8) goto L_0x0069
        L_0x005a:
            r0 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            r8 = r0
            goto L_0x006a
        L_0x005f:
            r0 = 1070141403(0x3fc90fdb, float:1.5707964)
            r8 = r0
            goto L_0x006a
        L_0x0064:
            r0 = 1078530011(0x40490fdb, float:3.1415927)
            r8 = r0
            goto L_0x006a
        L_0x0069:
            r8 = r0
        L_0x006a:
            r9 = 0
            r12 = 0
            r14 = 0
            r16 = 1
            r0 = 257(0x101, float:3.6E-43)
            r18 = r12
            long r11 = r6.b(r0)     // Catch:{ Exception -> 0x040b }
            int r12 = (int) r11     // Catch:{ Exception -> 0x040b }
            r0 = 256(0x100, float:3.59E-43)
            long r10 = r6.b(r0)     // Catch:{ Exception -> 0x040b }
            int r11 = (int) r10     // Catch:{ Exception -> 0x040b }
            r0 = 0
            r10 = 0
            r20 = 0
            r21 = 2
            r13 = 296(0x128, float:4.15E-43)
            boolean r23 = r6.e(r13)     // Catch:{ Exception -> 0x040b }
            if (r23 == 0) goto L_0x0095
            long r4 = r6.b(r13)     // Catch:{ Exception -> 0x040b }
            int r5 = (int) r4     // Catch:{ Exception -> 0x040b }
            goto L_0x0097
        L_0x0095:
            r5 = r21
        L_0x0097:
            r4 = 282(0x11a, float:3.95E-43)
            ep0 r4 = r6.a(r4)     // Catch:{ Exception -> 0x040b }
            int r4 = e(r4, r5)     // Catch:{ Exception -> 0x040b }
            r0 = r4
            r4 = 283(0x11b, float:3.97E-43)
            ep0 r4 = r6.a(r4)     // Catch:{ Exception -> 0x040b }
            int r4 = e(r4, r5)     // Catch:{ Exception -> 0x040b }
            r10 = 1
            if (r5 != r10) goto L_0x00bc
            if (r4 == 0) goto L_0x00b5
            float r10 = (float) r0     // Catch:{ Exception -> 0x040b }
            float r13 = (float) r4     // Catch:{ Exception -> 0x040b }
            float r20 = r10 / r13
        L_0x00b5:
            r0 = 0
            r4 = 0
            r10 = r4
            r13 = r20
            r4 = r0
            goto L_0x00c0
        L_0x00bc:
            r10 = r4
            r13 = r20
            r4 = r0
        L_0x00c0:
            r0 = r12
            r20 = r0
            r0 = 278(0x116, float:3.9E-43)
            boolean r21 = r6.e(r0)     // Catch:{ Exception -> 0x040b }
            if (r21 == 0) goto L_0x00d3
            r24 = r14
            long r14 = r6.b(r0)     // Catch:{ Exception -> 0x040b }
            int r0 = (int) r14     // Catch:{ Exception -> 0x040b }
            goto L_0x00d7
        L_0x00d3:
            r24 = r14
            r0 = r20
        L_0x00d7:
            if (r0 <= 0) goto L_0x00de
            if (r0 <= r12) goto L_0x00dc
            goto L_0x00de
        L_0x00dc:
            r14 = r0
            goto L_0x00e0
        L_0x00de:
            r0 = r12
            r14 = r0
        L_0x00e0:
            r0 = 273(0x111, float:3.83E-43)
            long[] r0 = d(r6, r0)     // Catch:{ Exception -> 0x040b }
            r15 = r0
            r0 = 279(0x117, float:3.91E-43)
            long[] r0 = d(r6, r0)     // Catch:{ Exception -> 0x040b }
            r20 = 0
            if (r0 == 0) goto L_0x0112
            int r3 = r0.length     // Catch:{ Exception -> 0x040b }
            r26 = r5
            r5 = 1
            if (r3 != r5) goto L_0x010d
            r3 = 0
            r27 = r0[r3]     // Catch:{ Exception -> 0x040b }
            int r5 = (r27 > r20 ? 1 : (r27 == r20 ? 0 : -1))
            if (r5 == 0) goto L_0x0114
            r27 = r0[r3]     // Catch:{ Exception -> 0x040b }
            r29 = r15[r3]     // Catch:{ Exception -> 0x040b }
            long r27 = r27 + r29
            long r29 = r50.b()     // Catch:{ Exception -> 0x040b }
            int r3 = (r27 > r29 ? 1 : (r27 == r29 ? 0 : -1))
            if (r3 <= 0) goto L_0x010d
            goto L_0x0114
        L_0x010d:
            r29 = r8
            r30 = r9
            goto L_0x0131
        L_0x0112:
            r26 = r5
        L_0x0114:
            if (r12 != r14) goto L_0x012d
            r3 = 1
            long[] r5 = new long[r3]     // Catch:{ Exception -> 0x040b }
            long r27 = r50.b()     // Catch:{ Exception -> 0x040b }
            r29 = r8
            r30 = r9
            r3 = 0
            r8 = r15[r3]     // Catch:{ Exception -> 0x040b }
            int r9 = (int) r8     // Catch:{ Exception -> 0x040b }
            long r8 = (long) r9     // Catch:{ Exception -> 0x040b }
            long r27 = r27 - r8
            r5[r3] = r27     // Catch:{ Exception -> 0x040b }
            r0 = r5
            r3 = r0
            goto L_0x0132
        L_0x012d:
            r29 = r8
            r30 = r9
        L_0x0131:
            r3 = r0
        L_0x0132:
            r0 = 0
            r5 = 266(0x10a, float:3.73E-43)
            ep0 r5 = r6.a(r5)     // Catch:{ Exception -> 0x040b }
            if (r5 == 0) goto L_0x0145
            r8 = 0
            long r27 = r5.e(r8)     // Catch:{ Exception -> 0x040b }
            r16 = r27
            r8 = r16
            goto L_0x0147
        L_0x0145:
            r8 = r16
        L_0x0147:
            r16 = 2
            int r27 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r27 != 0) goto L_0x0150
            r16 = 1
            goto L_0x0152
        L_0x0150:
            r16 = 0
        L_0x0152:
            r0 = 0
            r17 = r5
            r5 = 262(0x106, float:3.67E-43)
            boolean r27 = r6.e(r5)     // Catch:{ Exception -> 0x040b }
            r31 = 1
            if (r27 == 0) goto L_0x0169
            long r27 = r6.b(r5)     // Catch:{ Exception -> 0x040b }
            int r5 = (r27 > r31 ? 1 : (r27 == r31 ? 0 : -1))
            if (r5 != 0) goto L_0x0169
            r0 = r0 | 1
        L_0x0169:
            r5 = 0
            r27 = 4
            switch(r7) {
                case 2: goto L_0x01d7;
                case 3: goto L_0x019b;
                case 4: goto L_0x0178;
                case 32771: goto L_0x01d7;
                default: goto L_0x016f;
            }     // Catch:{ Exception -> 0x040b }
        L_0x016f:
            r33 = r13
            r34 = r5
            r31 = r24
            r5 = r0
            goto L_0x01e2
        L_0x0178:
            r20 = 0
            r5 = 256(0x100, float:3.59E-43)
            r21 = r5
            r5 = 293(0x125, float:4.1E-43)
            ep0 r5 = r6.a(r5)     // Catch:{ Exception -> 0x040b }
            if (r5 == 0) goto L_0x0193
            r33 = r13
            r13 = 0
            long r31 = r5.e(r13)     // Catch:{ Exception -> 0x040b }
            r24 = r31
            r5 = r0
            r34 = r21
            goto L_0x01e2
        L_0x0193:
            r33 = r13
            r5 = r0
            r34 = r21
            r31 = r24
            goto L_0x01e2
        L_0x019b:
            r33 = r13
            r5 = 257(0x101, float:3.6E-43)
            r0 = r0 | 12
            r13 = 292(0x124, float:4.09E-43)
            ep0 r13 = r6.a(r13)     // Catch:{ Exception -> 0x040b }
            if (r13 == 0) goto L_0x01d1
            r34 = r5
            r5 = 0
            long r35 = r13.e(r5)     // Catch:{ Exception -> 0x040b }
            r18 = r35
            long r31 = r18 & r31
            int r5 = (r31 > r20 ? 1 : (r31 == r20 ? 0 : -1))
            if (r5 == 0) goto L_0x01bb
            r5 = 258(0x102, float:3.62E-43)
            goto L_0x01bd
        L_0x01bb:
            r5 = r34
        L_0x01bd:
            long r31 = r18 & r27
            int r34 = (r31 > r20 ? 1 : (r31 == r20 ? 0 : -1))
            if (r34 == 0) goto L_0x01cb
            r0 = r0 | 2
            r34 = r5
            r31 = r24
            r5 = r0
            goto L_0x01e2
        L_0x01cb:
            r34 = r5
            r31 = r24
            r5 = r0
            goto L_0x01e2
        L_0x01d1:
            r34 = r5
            r5 = r0
            r31 = r24
            goto L_0x01e2
        L_0x01d7:
            r33 = r13
            r5 = 257(0x101, float:3.6E-43)
            r0 = r0 | 10
            r34 = r5
            r31 = r24
            r5 = r0
        L_0x01e2:
            if (r53 == 0) goto L_0x0223
            if (r14 != r12) goto L_0x0223
            r42 = r14
            r20 = 0
            r13 = r3[r20]     // Catch:{ Exception -> 0x040b }
            int r0 = (int) r13     // Catch:{ Exception -> 0x040b }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x040b }
            r13 = r15[r20]     // Catch:{ Exception -> 0x040b }
            r1.n(r13)     // Catch:{ Exception -> 0x040b }
            r1.readFully(r0)     // Catch:{ Exception -> 0x040b }
            r22 = 0
            r20 = r11
            r21 = r12
            r23 = r34
            r24 = r5
            r25 = r0
            tr r13 = defpackage.tr.q0(r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x040b }
            r14 = 1
            r13.i1(r14)     // Catch:{ Exception -> 0x040b }
            r45 = r5
            r47 = r8
            r5 = r12
            r43 = r18
            r12 = r42
            r19 = r3
            r18 = r6
            r42 = r7
            r3 = r29
            r7 = r33
            r6 = r4
            r29 = r15
            goto L_0x03c4
        L_0x0223:
            r42 = r14
            r0 = r12
            b7 r13 = new b7     // Catch:{ Exception -> 0x040b }
            r13.<init>(r11)     // Catch:{ Exception -> 0x040b }
            r14 = 0
            r43 = r18
            r18 = r6
            r6 = r14
            r14 = r0
        L_0x0232:
            int r0 = r15.length     // Catch:{ Exception -> 0x040b }
            if (r6 >= r0) goto L_0x039c
            r19 = r4
            r45 = r5
            r4 = r3[r6]     // Catch:{ Exception -> 0x040b }
            int r0 = (int) r4     // Catch:{ Exception -> 0x040b }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x040b }
            r4 = r0
            r5 = r12
            r46 = r13
            r12 = r15[r6]     // Catch:{ Exception -> 0x040b }
            r1.n(r12)     // Catch:{ Exception -> 0x040b }
            r1.readFully(r4)     // Catch:{ Exception -> 0x040b }
            r12 = r42
            int r0 = java.lang.Math.min(r12, r14)     // Catch:{ Exception -> 0x040b }
            r13 = r0
            dp0 r0 = new dp0     // Catch:{ Exception -> 0x040b }
            r0.<init>(r8, r11, r13)     // Catch:{ Exception -> 0x040b }
            r42 = r0
            r47 = r8
            r8 = r42
            r8.m(r2)     // Catch:{ Exception -> 0x040b }
            int r0 = r11 + 7
            r9 = 8
            int r0 = r0 / r9
            int r0 = r0 * r13
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x040b }
            r42 = r0
            switch(r7) {
                case 2: goto L_0x0365;
                case 3: goto L_0x02bb;
                case 4: goto L_0x0281;
                case 32771: goto L_0x0365;
                default: goto L_0x026d;
            }
        L_0x026d:
            r35 = r6
            r6 = r19
            r2 = r42
            r9 = r46
            r19 = r3
            r42 = r7
            r3 = r29
            r7 = r33
            r29 = r15
            goto L_0x0381
        L_0x0281:
            r38 = 0
            r35 = r8
            r36 = r42
            r37 = r4
            r39 = r13
            r40 = r31
            r35.f(r36, r37, r38, r39, r40)     // Catch:{ ru -> 0x0291 }
            goto L_0x0298
        L_0x0291:
            r0 = move-exception
            r20 = r0
            r0 = r20
            if (r2 == 0) goto L_0x02b2
        L_0x0298:
            r9 = r46
            r49 = r42
            r42 = r7
            r7 = r49
            r9.e(r7, r13)     // Catch:{ Exception -> 0x040b }
            r35 = r6
            r2 = r7
            r6 = r19
            r7 = r33
            r19 = r3
            r3 = r29
            r29 = r15
            goto L_0x0381
        L_0x02b2:
            r9 = r46
            r49 = r42
            r42 = r7
            r7 = r49
            throw r0     // Catch:{ Exception -> 0x040b }
        L_0x02bb:
            r9 = r46
            r49 = r42
            r42 = r7
            r7 = r49
            r38 = 0
            r35 = r8
            r36 = r7
            r37 = r4
            r39 = r13
            r40 = r43
            r35.c(r36, r37, r38, r39, r40)     // Catch:{ RuntimeException -> 0x02d3 }
            goto L_0x02ea
        L_0x02d3:
            r0 = move-exception
            r20 = r0
            r46 = r20
            long r43 = r43 ^ r27
            r38 = 0
            r35 = r8
            r36 = r7
            r37 = r4
            r39 = r13
            r40 = r43
            r35.c(r36, r37, r38, r39, r40)     // Catch:{ RuntimeException -> 0x02fc }
        L_0x02ea:
            r9.e(r7, r13)     // Catch:{ Exception -> 0x040b }
            r35 = r6
            r2 = r7
            r6 = r19
            r7 = r33
            r19 = r3
            r3 = r29
            r29 = r15
            goto L_0x0381
        L_0x02fc:
            r0 = move-exception
            r20 = r0
            r0 = r20
            if (r2 == 0) goto L_0x0358
            r2 = 1
            if (r12 == r2) goto L_0x034b
            r35 = r6
            r36 = r7
            r2 = 0
            r6 = r3[r2]     // Catch:{ Exception -> 0x040b }
            int r7 = (int) r6     // Catch:{ Exception -> 0x040b }
            byte[] r6 = new byte[r7]     // Catch:{ Exception -> 0x040b }
            r4 = r6
            r6 = r15[r2]     // Catch:{ Exception -> 0x040b }
            r1.n(r6)     // Catch:{ Exception -> 0x040b }
            r1.readFully(r4)     // Catch:{ Exception -> 0x040b }
            r22 = 0
            r20 = r11
            r21 = r5
            r23 = r34
            r24 = r45
            r25 = r4
            tr r2 = defpackage.tr.q0(r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x040b }
            r6 = 1
            r2.i1(r6)     // Catch:{ Exception -> 0x040b }
            r6 = r19
            r2.f1(r6, r10)     // Catch:{ Exception -> 0x040b }
            r7 = r33
            r2.r1(r7)     // Catch:{ Exception -> 0x040b }
            r19 = r3
            r3 = 5
            r2.k1(r3)     // Catch:{ Exception -> 0x040b }
            r3 = 0
            int r3 = (r29 > r3 ? 1 : (r29 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0348
            r3 = r29
            r2.h1(r3)     // Catch:{ Exception -> 0x040b }
            goto L_0x034a
        L_0x0348:
            r3 = r29
        L_0x034a:
            return r2
        L_0x034b:
            r35 = r6
            r36 = r7
            r6 = r19
            r7 = r33
            r19 = r3
            r3 = r29
            throw r46     // Catch:{ Exception -> 0x040b }
        L_0x0358:
            r35 = r6
            r36 = r7
            r6 = r19
            r7 = r33
            r19 = r3
            r3 = r29
            throw r46     // Catch:{ Exception -> 0x040b }
        L_0x0365:
            r35 = r6
            r6 = r19
            r36 = r42
            r9 = r46
            r19 = r3
            r42 = r7
            r3 = r29
            r7 = r33
            r29 = r15
            r2 = r36
            r15 = 0
            r8.b(r2, r4, r15, r13)     // Catch:{ Exception -> 0x040b }
            r9.e(r2, r13)     // Catch:{ Exception -> 0x040b }
        L_0x0381:
            int r14 = r14 - r12
            int r0 = r35 + 1
            r2 = r51
            r4 = r6
            r33 = r7
            r13 = r9
            r15 = r29
            r7 = r42
            r8 = r47
            r6 = r0
            r29 = r3
            r42 = r12
            r3 = r19
            r12 = r5
            r5 = r45
            goto L_0x0232
        L_0x039c:
            r19 = r3
            r45 = r5
            r35 = r6
            r47 = r8
            r5 = r12
            r9 = r13
            r3 = r29
            r12 = r42
            r6 = r4
            r42 = r7
            r29 = r15
            r7 = r33
            byte[] r25 = r9.c()     // Catch:{ Exception -> 0x040b }
            r22 = 0
            r23 = 256(0x100, float:3.59E-43)
            r24 = r45 & 1
            r20 = r11
            r21 = r5
            tr r0 = defpackage.tr.q0(r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x040b }
            r13 = r0
        L_0x03c4:
            r13.f1(r6, r10)     // Catch:{ Exception -> 0x040b }
            r13.r1(r7)     // Catch:{ Exception -> 0x040b }
            r0 = 34675(0x8773, float:4.859E-41)
            r2 = r18
            boolean r4 = r2.e(r0)     // Catch:{ Exception -> 0x040b }
            if (r4 == 0) goto L_0x03ed
            ep0 r0 = r2.a(r0)     // Catch:{ RuntimeException -> 0x03ec }
            byte[] r4 = r0.b()     // Catch:{ RuntimeException -> 0x03ec }
            dr r4 = defpackage.dr.b(r4)     // Catch:{ RuntimeException -> 0x03ec }
            int r8 = r4.d()     // Catch:{ RuntimeException -> 0x03ec }
            r9 = 1
            if (r8 != r9) goto L_0x03eb
            r13.s1(r4)     // Catch:{ RuntimeException -> 0x03ec }
        L_0x03eb:
            goto L_0x03ed
        L_0x03ec:
            r0 = move-exception
        L_0x03ed:
            r4 = 5
            r13.k1(r4)     // Catch:{ Exception -> 0x040b }
            r4 = 0
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x03f9
            r13.h1(r3)     // Catch:{ Exception -> 0x040b }
        L_0x03f9:
            return r13
        L_0x03fa:
            return r0
        L_0x03fb:
            r2 = r6
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x040b }
            java.lang.String r3 = "tiles.are.not.supported"
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x040b }
            java.lang.String r3 = defpackage.i10.b(r3, r4)     // Catch:{ Exception -> 0x040b }
            r0.<init>(r3)     // Catch:{ Exception -> 0x040b }
            throw r0     // Catch:{ Exception -> 0x040b }
        L_0x040b:
            r0 = move-exception
            mj r2 = new mj
            r2.<init>(r0)
            throw r2
        L_0x0412:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "the.page.number.must.be.gt.eq.1"
            java.lang.String r2 = defpackage.i10.b(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jr0.i(cd0, boolean, int, boolean):tr");
    }

    public static tr h(cd0 s, boolean recoverFromImageError, int page) {
        return i(s, recoverFromImageError, page, false);
    }

    public static tr f(cd0 s, int page) {
        return g(s, page, false);
    }

    public static tr g(cd0 s, int page, boolean direct) {
        return i(s, false, page, direct);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01b5 A[Catch:{ Exception -> 0x05c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01b6 A[Catch:{ Exception -> 0x05c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x020b A[Catch:{ Exception -> 0x05c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0212 A[Catch:{ Exception -> 0x05c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x021f A[Catch:{ Exception -> 0x05c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0235 A[Catch:{ Exception -> 0x05c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0241 A[ADDED_TO_REGION, Catch:{ Exception -> 0x05c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0266 A[Catch:{ Exception -> 0x05c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0274 A[Catch:{ Exception -> 0x05c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x027d A[Catch:{ Exception -> 0x05c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x046e  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0571 A[Catch:{ Exception -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x057d A[Catch:{ Exception -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0586 A[Catch:{ Exception -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x058c A[Catch:{ Exception -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0590 A[Catch:{ Exception -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x05a8 A[Catch:{ Exception -> 0x05bf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static defpackage.tr j(defpackage.cp0 r41, defpackage.cd0 r42) {
        /*
            r1 = r41
            r2 = r42
            r0 = 1
            r3 = 259(0x103, float:3.63E-43)
            boolean r4 = r1.e(r3)     // Catch:{ Exception -> 0x05c1 }
            if (r4 == 0) goto L_0x0014
            long r3 = r1.b(r3)     // Catch:{ Exception -> 0x05c1 }
            int r0 = (int) r3
            r3 = r0
            goto L_0x0015
        L_0x0014:
            r3 = r0
        L_0x0015:
            r0 = 1
            r4 = 0
            switch(r3) {
                case 1: goto L_0x0023;
                case 5: goto L_0x0023;
                case 6: goto L_0x0023;
                case 7: goto L_0x0023;
                case 8: goto L_0x0023;
                case 32773: goto L_0x0023;
                case 32946: goto L_0x0023;
                default: goto L_0x001a;
            }
        L_0x001a:
            r21 = r0
            r14 = r1
            r19 = r4
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b5
        L_0x0023:
            r5 = 262(0x106, float:3.67E-43)
            long r5 = r1.b(r5)     // Catch:{ Exception -> 0x05c1 }
            int r6 = (int) r5     // Catch:{ Exception -> 0x05c1 }
            r5 = 6
            r7 = 7
            switch(r6) {
                case 0: goto L_0x0035;
                case 1: goto L_0x0035;
                case 2: goto L_0x0035;
                case 3: goto L_0x0035;
                case 4: goto L_0x0030;
                case 5: goto L_0x0035;
                default: goto L_0x0030;
            }     // Catch:{ Exception -> 0x05c1 }
        L_0x0030:
            if (r3 == r5) goto L_0x0042
            if (r3 != r7) goto L_0x0036
            goto L_0x0042
        L_0x0035:
            goto L_0x0042
        L_0x0036:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x05c1 }
            java.lang.String r7 = "the.photometric.1.is.not.supported"
            java.lang.String r7 = defpackage.i10.a(r7, r6)     // Catch:{ Exception -> 0x05c1 }
            r5.<init>(r7)     // Catch:{ Exception -> 0x05c1 }
            throw r5     // Catch:{ Exception -> 0x05c1 }
        L_0x0042:
            r8 = 0
            r9 = 274(0x112, float:3.84E-43)
            boolean r10 = r1.e(r9)     // Catch:{ Exception -> 0x05c1 }
            r11 = 5
            r12 = 8
            r13 = 3
            if (r10 == 0) goto L_0x006e
            long r9 = r1.b(r9)     // Catch:{ Exception -> 0x05c1 }
            int r10 = (int) r9     // Catch:{ Exception -> 0x05c1 }
            if (r10 == r13) goto L_0x006b
            r9 = 4
            if (r10 != r9) goto L_0x005a
            goto L_0x006b
        L_0x005a:
            if (r10 == r11) goto L_0x0067
            if (r10 != r12) goto L_0x005f
            goto L_0x0067
        L_0x005f:
            if (r10 == r5) goto L_0x0063
            if (r10 != r7) goto L_0x006e
        L_0x0063:
            r8 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            goto L_0x006e
        L_0x0067:
            r8 = 1070141403(0x3fc90fdb, float:1.5707964)
            goto L_0x006e
        L_0x006b:
            r8 = 1078530011(0x40490fdb, float:3.1415927)
        L_0x006e:
            r9 = 284(0x11c, float:3.98E-43)
            boolean r10 = r1.e(r9)     // Catch:{ Exception -> 0x05c1 }
            r14 = 0
            if (r10 == 0) goto L_0x0090
            long r9 = r1.b(r9)     // Catch:{ Exception -> 0x05c1 }
            r15 = 2
            int r17 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x0082
            goto L_0x0090
        L_0x0082:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x05c1 }
            java.lang.String r7 = "planar.images.are.not.supported"
            java.lang.Object[] r9 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x05c1 }
            java.lang.String r7 = defpackage.i10.b(r7, r9)     // Catch:{ Exception -> 0x05c1 }
            r5.<init>(r7)     // Catch:{ Exception -> 0x05c1 }
            throw r5     // Catch:{ Exception -> 0x05c1 }
        L_0x0090:
            r9 = 0
            r10 = 338(0x152, float:4.74E-43)
            boolean r10 = r1.e(r10)     // Catch:{ Exception -> 0x05c1 }
            if (r10 == 0) goto L_0x009a
            r9 = 1
        L_0x009a:
            r10 = 1
            r15 = 277(0x115, float:3.88E-43)
            boolean r16 = r1.e(r15)     // Catch:{ Exception -> 0x05c1 }
            if (r16 == 0) goto L_0x00ab
            r16 = r8
            long r7 = r1.b(r15)     // Catch:{ Exception -> 0x05c1 }
            int r10 = (int) r7     // Catch:{ Exception -> 0x05c1 }
            goto L_0x00ad
        L_0x00ab:
            r16 = r8
        L_0x00ad:
            r7 = 1
            r8 = 258(0x102, float:3.62E-43)
            boolean r15 = r1.e(r8)     // Catch:{ Exception -> 0x05c1 }
            if (r15 == 0) goto L_0x00bd
            r15 = r6
            long r5 = r1.b(r8)     // Catch:{ Exception -> 0x05c1 }
            int r7 = (int) r5
            goto L_0x00be
        L_0x00bd:
            r15 = r6
        L_0x00be:
            switch(r7) {
                case 1: goto L_0x00d0;
                case 2: goto L_0x00d0;
                case 4: goto L_0x00d0;
                case 8: goto L_0x00d0;
                default: goto L_0x00c1;
            }
        L_0x00c1:
            r21 = r0
            r14 = r1
            r19 = r4
            r1 = r7
            r28 = r9
            r11 = r15
            r2 = r16
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x05bf }
            goto L_0x05ab
        L_0x00d0:
            r5 = 0
            r6 = 257(0x101, float:3.6E-43)
            long r12 = r1.b(r6)     // Catch:{ Exception -> 0x05c1 }
            int r6 = (int) r12     // Catch:{ Exception -> 0x05c1 }
            r12 = 256(0x100, float:3.59E-43)
            long r12 = r1.b(r12)     // Catch:{ Exception -> 0x05c1 }
            int r13 = (int) r12     // Catch:{ Exception -> 0x05c1 }
            r12 = 0
            r18 = 0
            r19 = 2
            r8 = 296(0x128, float:4.15E-43)
            boolean r21 = r1.e(r8)     // Catch:{ Exception -> 0x05c1 }
            if (r21 == 0) goto L_0x00f6
            r21 = r12
            long r11 = r1.b(r8)     // Catch:{ Exception -> 0x05c1 }
            int r8 = (int) r11     // Catch:{ Exception -> 0x05c1 }
            r11 = r8
            goto L_0x00fa
        L_0x00f6:
            r21 = r12
            r11 = r19
        L_0x00fa:
            r8 = 282(0x11a, float:3.95E-43)
            ep0 r8 = r1.a(r8)     // Catch:{ Exception -> 0x05c1 }
            int r8 = e(r8, r11)     // Catch:{ Exception -> 0x05c1 }
            r12 = r8
            r8 = 283(0x11b, float:3.97E-43)
            ep0 r8 = r1.a(r8)     // Catch:{ Exception -> 0x05c1 }
            int r8 = e(r8, r11)     // Catch:{ Exception -> 0x05c1 }
            r18 = 1
            r19 = 0
            r14 = 266(0x10a, float:3.73E-43)
            ep0 r14 = r1.a(r14)     // Catch:{ Exception -> 0x05c1 }
            if (r14 == 0) goto L_0x0128
            r21 = r0
            r0 = 0
            int r22 = r14.d(r0)     // Catch:{ Exception -> 0x05c1 }
            r18 = r22
            r0 = r4
            r4 = r18
            goto L_0x012d
        L_0x0128:
            r21 = r0
            r0 = r4
            r4 = r18
        L_0x012d:
            r26 = r5
            r5 = 2
            r18 = r8
            if (r4 != r5) goto L_0x0137
            r22 = 1
            goto L_0x0139
        L_0x0137:
            r22 = 0
        L_0x0139:
            r27 = r22
            r19 = r6
            r5 = 278(0x116, float:3.9E-43)
            boolean r22 = r1.e(r5)     // Catch:{ Exception -> 0x05c1 }
            if (r22 == 0) goto L_0x014d
            r28 = r9
            long r8 = r1.b(r5)     // Catch:{ Exception -> 0x05c1 }
            int r5 = (int) r8     // Catch:{ Exception -> 0x05c1 }
            goto L_0x0151
        L_0x014d:
            r28 = r9
            r5 = r19
        L_0x0151:
            if (r5 <= 0) goto L_0x0155
            if (r5 <= r6) goto L_0x0156
        L_0x0155:
            r5 = r6
        L_0x0156:
            r8 = 273(0x111, float:3.83E-43)
            long[] r8 = d(r1, r8)     // Catch:{ Exception -> 0x05c1 }
            r9 = 279(0x117, float:3.91E-43)
            long[] r9 = d(r1, r9)     // Catch:{ Exception -> 0x05c1 }
            if (r9 == 0) goto L_0x0189
            r19 = r0
            int r0 = r9.length     // Catch:{ Exception -> 0x05c1 }
            r29 = r4
            r4 = 1
            if (r0 != r4) goto L_0x0184
            r0 = 0
            r22 = r9[r0]     // Catch:{ Exception -> 0x05c1 }
            r30 = 0
            int r4 = (r22 > r30 ? 1 : (r22 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x018d
            r22 = r9[r0]     // Catch:{ Exception -> 0x05c1 }
            r30 = r8[r0]     // Catch:{ Exception -> 0x05c1 }
            long r22 = r22 + r30
            long r30 = r42.b()     // Catch:{ Exception -> 0x05c1 }
            int r0 = (r22 > r30 ? 1 : (r22 == r30 ? 0 : -1))
            if (r0 <= 0) goto L_0x0184
            goto L_0x018d
        L_0x0184:
            r30 = r14
            r24 = r15
            goto L_0x01a9
        L_0x0189:
            r19 = r0
            r29 = r4
        L_0x018d:
            if (r6 != r5) goto L_0x01a5
            r4 = 1
            long[] r0 = new long[r4]     // Catch:{ Exception -> 0x05c1 }
            long r22 = r42.b()     // Catch:{ Exception -> 0x05c1 }
            r30 = r14
            r24 = r15
            r4 = 0
            r14 = r8[r4]     // Catch:{ Exception -> 0x05c1 }
            int r15 = (int) r14     // Catch:{ Exception -> 0x05c1 }
            long r14 = (long) r15     // Catch:{ Exception -> 0x05c1 }
            long r22 = r22 - r14
            r0[r4] = r22     // Catch:{ Exception -> 0x05c1 }
            r9 = r0
            goto L_0x01a9
        L_0x01a5:
            r30 = r14
            r24 = r15
        L_0x01a9:
            r4 = 5
            if (r3 == r4) goto L_0x01bb
            r0 = 32946(0x80b2, float:4.6167E-41)
            if (r3 == r0) goto L_0x01bb
            r4 = 8
            if (r3 != r4) goto L_0x01b6
            goto L_0x01bb
        L_0x01b6:
            r4 = r18
            r31 = r11
            goto L_0x0206
        L_0x01bb:
            r4 = r18
            r0 = 317(0x13d, float:4.44E-43)
            ep0 r0 = r1.a(r0)     // Catch:{ Exception -> 0x05c1 }
            if (r0 == 0) goto L_0x0202
            r15 = 0
            int r18 = r0.d(r15)     // Catch:{ Exception -> 0x05c1 }
            r15 = r18
            r14 = 1
            if (r15 == r14) goto L_0x01ea
            r14 = 2
            if (r15 != r14) goto L_0x01d7
            r18 = r0
            r31 = r11
            goto L_0x01ee
        L_0x01d7:
            java.lang.RuntimeException r14 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x05c1 }
            r18 = r0
            java.lang.String r0 = "illegal.value.for.predictor.in.tiff.file"
            r31 = r11
            r11 = 0
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x05c1 }
            java.lang.String r0 = defpackage.i10.b(r0, r11)     // Catch:{ Exception -> 0x05c1 }
            r14.<init>(r0)     // Catch:{ Exception -> 0x05c1 }
            throw r14     // Catch:{ Exception -> 0x05c1 }
        L_0x01ea:
            r18 = r0
            r31 = r11
        L_0x01ee:
            r11 = 2
            if (r15 != r11) goto L_0x0208
            r11 = 8
            if (r7 != r11) goto L_0x01f6
            goto L_0x0208
        L_0x01f6:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x05c1 }
            java.lang.String r11 = "1.bit.samples.are.not.supported.for.horizontal.differencing.predictor"
            java.lang.String r11 = defpackage.i10.a(r11, r7)     // Catch:{ Exception -> 0x05c1 }
            r0.<init>(r11)     // Catch:{ Exception -> 0x05c1 }
            throw r0     // Catch:{ Exception -> 0x05c1 }
        L_0x0202:
            r18 = r0
            r31 = r11
        L_0x0206:
            r15 = r21
        L_0x0208:
            r14 = 5
            if (r3 != r14) goto L_0x0212
            fp0 r0 = new fp0     // Catch:{ Exception -> 0x05c1 }
            r0.<init>(r13, r15, r10)     // Catch:{ Exception -> 0x05c1 }
            r14 = r0
            goto L_0x0214
        L_0x0212:
            r14 = r19
        L_0x0214:
            r0 = r6
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            if (r28 <= 0) goto L_0x0235
            java.io.ByteArrayOutputStream r22 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x05c1 }
            r22.<init>()     // Catch:{ Exception -> 0x05c1 }
            r19 = r22
            java.util.zip.DeflaterOutputStream r11 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x05c1 }
            r23 = r0
            r0 = r19
            r11.<init>(r0)     // Catch:{ Exception -> 0x05c1 }
            r21 = r11
            r11 = r0
            r32 = r21
            goto L_0x023b
        L_0x0235:
            r23 = r0
            r11 = r19
            r32 = r21
        L_0x023b:
            r0 = 0
            r33 = r11
            r11 = 1
            if (r7 != r11) goto L_0x0255
            if (r10 != r11) goto L_0x0255
            r34 = r4
            r11 = r24
            r4 = 3
            if (r11 == r4) goto L_0x0259
            b7 r4 = new b7     // Catch:{ Exception -> 0x05c1 }
            r4.<init>(r13)     // Catch:{ Exception -> 0x05c1 }
            r0 = r4
            r35 = r18
            r36 = r20
            goto L_0x027a
        L_0x0255:
            r34 = r4
            r11 = r24
        L_0x0259:
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x05c1 }
            r4.<init>()     // Catch:{ Exception -> 0x05c1 }
            r18 = r0
            r0 = 6
            if (r3 == r0) goto L_0x0274
            r0 = 7
            if (r3 == r0) goto L_0x0274
            java.util.zip.DeflaterOutputStream r0 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x05c1 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x05c1 }
            r20 = r0
            r35 = r4
            r4 = r18
            r36 = r20
            goto L_0x027a
        L_0x0274:
            r35 = r4
            r4 = r18
            r36 = r20
        L_0x027a:
            r0 = 6
            if (r3 != r0) goto L_0x02eb
            r0 = 513(0x201, float:7.19E-43)
            boolean r18 = r1.e(r0)     // Catch:{ Exception -> 0x05c1 }
            if (r18 == 0) goto L_0x02d4
            r38 = r14
            r37 = r15
            long r14 = r1.b(r0)     // Catch:{ Exception -> 0x05c1 }
            int r0 = (int) r14     // Catch:{ Exception -> 0x05c1 }
            long r14 = r42.b()     // Catch:{ Exception -> 0x05c1 }
            int r15 = (int) r14     // Catch:{ Exception -> 0x05c1 }
            int r15 = r15 - r0
            r14 = 514(0x202, float:7.2E-43)
            boolean r18 = r1.e(r14)     // Catch:{ Exception -> 0x05c1 }
            if (r18 == 0) goto L_0x02ad
            r18 = r15
            long r14 = r1.b(r14)     // Catch:{ Exception -> 0x05c1 }
            int r15 = (int) r14     // Catch:{ Exception -> 0x05c1 }
            r40 = r6
            r39 = r7
            r14 = 0
            r6 = r9[r14]     // Catch:{ Exception -> 0x05c1 }
            int r7 = (int) r6     // Catch:{ Exception -> 0x05c1 }
            int r15 = r15 + r7
            goto L_0x02b3
        L_0x02ad:
            r40 = r6
            r39 = r7
            r18 = r15
        L_0x02b3:
            long r6 = r42.b()     // Catch:{ Exception -> 0x05c1 }
            int r7 = (int) r6     // Catch:{ Exception -> 0x05c1 }
            int r7 = r7 - r0
            int r6 = java.lang.Math.min(r15, r7)     // Catch:{ Exception -> 0x05c1 }
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x05c1 }
            r7 = r15
            long r14 = (long) r0     // Catch:{ Exception -> 0x05c1 }
            r2.n(r14)     // Catch:{ Exception -> 0x05c1 }
            r2.readFully(r6)     // Catch:{ Exception -> 0x05c1 }
            qv r14 = new qv     // Catch:{ Exception -> 0x05c1 }
            r14.<init>((byte[]) r6)     // Catch:{ Exception -> 0x05c1 }
            r0 = r14
            r6 = r0
            r2 = r36
            r1 = r39
            goto L_0x0463
        L_0x02d4:
            r40 = r6
            r39 = r7
            r38 = r14
            r37 = r15
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x05c1 }
            java.lang.String r6 = "missing.tag.s.for.ojpeg.compression"
            r7 = 0
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x05c1 }
            java.lang.String r6 = defpackage.i10.b(r6, r7)     // Catch:{ Exception -> 0x05c1 }
            r0.<init>(r6)     // Catch:{ Exception -> 0x05c1 }
            throw r0     // Catch:{ Exception -> 0x05c1 }
        L_0x02eb:
            r40 = r6
            r39 = r7
            r38 = r14
            r37 = r15
            r0 = 7
            if (r3 != r0) goto L_0x038f
            int r0 = r9.length     // Catch:{ Exception -> 0x038a }
            r6 = 1
            if (r0 > r6) goto L_0x037d
            r0 = 0
            r6 = r9[r0]     // Catch:{ Exception -> 0x038a }
            int r7 = (int) r6     // Catch:{ Exception -> 0x038a }
            byte[] r6 = new byte[r7]     // Catch:{ Exception -> 0x038a }
            r14 = r8[r0]     // Catch:{ Exception -> 0x038a }
            r2.n(r14)     // Catch:{ Exception -> 0x038a }
            r2.readFully(r6)     // Catch:{ Exception -> 0x038a }
            r0 = 347(0x15b, float:4.86E-43)
            ep0 r0 = r1.a(r0)     // Catch:{ Exception -> 0x038a }
            if (r0 == 0) goto L_0x0368
            byte[] r7 = r0.b()     // Catch:{ Exception -> 0x038a }
            r14 = 0
            int r15 = r7.length     // Catch:{ Exception -> 0x038a }
            r19 = r0
            r18 = 0
            byte r0 = r7[r18]     // Catch:{ Exception -> 0x038a }
            r18 = r14
            r14 = -1
            if (r0 != r14) goto L_0x032d
            r20 = 1
            byte r0 = r7[r20]     // Catch:{ Exception -> 0x05c1 }
            r14 = -40
            if (r0 != r14) goto L_0x032d
            r14 = 2
            int r15 = r15 + -2
            goto L_0x032f
        L_0x032d:
            r14 = r18
        L_0x032f:
            int r0 = r7.length     // Catch:{ Exception -> 0x038a }
            r18 = 2
            int r0 = r0 + -2
            byte r0 = r7[r0]     // Catch:{ Exception -> 0x038a }
            r1 = -1
            if (r0 != r1) goto L_0x0344
            int r0 = r7.length     // Catch:{ Exception -> 0x038a }
            r1 = 1
            int r0 = r0 - r1
            byte r0 = r7[r0]     // Catch:{ Exception -> 0x038a }
            r1 = -39
            if (r0 != r1) goto L_0x0344
            int r15 = r15 + -2
        L_0x0344:
            byte[] r0 = new byte[r15]     // Catch:{ Exception -> 0x038a }
            r1 = 0
            java.lang.System.arraycopy(r7, r14, r0, r1, r15)     // Catch:{ Exception -> 0x038a }
            int r1 = r6.length     // Catch:{ Exception -> 0x038a }
            r18 = r7
            int r7 = r0.length     // Catch:{ Exception -> 0x038a }
            int r1 = r1 + r7
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x038a }
            r20 = r14
            r7 = 2
            r14 = 0
            java.lang.System.arraycopy(r6, r14, r1, r14, r7)     // Catch:{ Exception -> 0x038a }
            int r7 = r0.length     // Catch:{ Exception -> 0x038a }
            r21 = r15
            r15 = 2
            java.lang.System.arraycopy(r0, r14, r1, r15, r7)     // Catch:{ Exception -> 0x038a }
            int r7 = r0.length     // Catch:{ Exception -> 0x038a }
            int r7 = r7 + r15
            int r14 = r6.length     // Catch:{ Exception -> 0x038a }
            int r14 = r14 - r15
            java.lang.System.arraycopy(r6, r15, r1, r7, r14)     // Catch:{ Exception -> 0x038a }
            r6 = r1
            goto L_0x036a
        L_0x0368:
            r19 = r0
        L_0x036a:
            qv r0 = new qv     // Catch:{ Exception -> 0x038a }
            r0.<init>((byte[]) r6)     // Catch:{ Exception -> 0x038a }
            r1 = 2
            if (r11 != r1) goto L_0x0376
            r1 = 0
            r0.d1(r1)     // Catch:{ Exception -> 0x038a }
        L_0x0376:
            r6 = r0
            r2 = r36
            r1 = r39
            goto L_0x0463
        L_0x037d:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x038a }
            java.lang.String r1 = "compression.jpeg.is.only.supported.with.a.single.strip.this.image.has.1.strips"
            int r6 = r9.length     // Catch:{ Exception -> 0x038a }
            java.lang.String r1 = defpackage.i10.a(r1, r6)     // Catch:{ Exception -> 0x038a }
            r0.<init>(r1)     // Catch:{ Exception -> 0x038a }
            throw r0     // Catch:{ Exception -> 0x038a }
        L_0x038a:
            r0 = move-exception
            r14 = r41
            goto L_0x05c3
        L_0x038f:
            r1 = 0
            r0 = 0
            r6 = r23
        L_0x0393:
            int r7 = r8.length     // Catch:{ Exception -> 0x038a }
            if (r0 >= r7) goto L_0x041f
            r14 = r9[r0]     // Catch:{ Exception -> 0x038a }
            int r7 = (int) r14     // Catch:{ Exception -> 0x038a }
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x038a }
            r14 = r8[r0]     // Catch:{ Exception -> 0x038a }
            r2.n(r14)     // Catch:{ Exception -> 0x038a }
            r2.readFully(r7)     // Catch:{ Exception -> 0x038a }
            int r14 = java.lang.Math.min(r5, r6)     // Catch:{ Exception -> 0x038a }
            r15 = 0
            r1 = 1
            if (r3 == r1) goto L_0x03bc
            int r1 = r13 * r39
            int r1 = r1 * r10
            r17 = 7
            int r1 = r1 + 7
            r18 = 8
            int r1 = r1 / 8
            int r1 = r1 * r14
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x038a }
            r15 = r1
        L_0x03bc:
            if (r27 == 0) goto L_0x03c1
            defpackage.dp0.l(r7)     // Catch:{ Exception -> 0x038a }
        L_0x03c1:
            switch(r3) {
                case 1: goto L_0x03e2;
                case 5: goto L_0x03da;
                case 8: goto L_0x03cd;
                case 32773: goto L_0x03c7;
                case 32946: goto L_0x03cd;
                default: goto L_0x03c4;
            }     // Catch:{ Exception -> 0x038a }
        L_0x03c4:
            r1 = r38
            goto L_0x03e6
        L_0x03c7:
            c(r7, r15)     // Catch:{ Exception -> 0x038a }
            r1 = r38
            goto L_0x03e6
        L_0x03cd:
            k(r7, r15)     // Catch:{ Exception -> 0x038a }
            r1 = r37
            b(r15, r1, r13, r14, r10)     // Catch:{ Exception -> 0x038a }
            r37 = r1
            r1 = r38
            goto L_0x03e6
        L_0x03da:
            r1 = r37
            r1 = r38
            r1.d(r7, r15, r14)     // Catch:{ Exception -> 0x038a }
            goto L_0x03e6
        L_0x03e2:
            r1 = r38
            r15 = r7
        L_0x03e6:
            r38 = r1
            r1 = r39
            r2 = 1
            if (r1 != r2) goto L_0x03f8
            if (r10 != r2) goto L_0x03f8
            r2 = 3
            if (r11 == r2) goto L_0x03f8
            r4.e(r15, r14)     // Catch:{ Exception -> 0x038a }
            r2 = r36
            goto L_0x0413
        L_0x03f8:
            if (r28 <= 0) goto L_0x040e
            r18 = r36
            r19 = r32
            r20 = r15
            r21 = r10
            r22 = r1
            r23 = r13
            r24 = r14
            a(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x038a }
            r2 = r36
            goto L_0x0413
        L_0x040e:
            r2 = r36
            r2.write(r15)     // Catch:{ Exception -> 0x038a }
        L_0x0413:
            int r6 = r6 - r5
            int r0 = r0 + 1
            r39 = r1
            r36 = r2
            r1 = 0
            r2 = r42
            goto L_0x0393
        L_0x041f:
            r2 = r36
            r1 = r39
            r7 = 1
            if (r1 != r7) goto L_0x0446
            if (r10 != r7) goto L_0x0446
            r14 = 3
            if (r11 == r14) goto L_0x0446
            r20 = 0
            r21 = 256(0x100, float:3.59E-43)
            if (r11 != r7) goto L_0x0434
            r22 = 1
            goto L_0x0436
        L_0x0434:
            r22 = 0
        L_0x0436:
            byte[] r23 = r4.c()     // Catch:{ Exception -> 0x038a }
            r18 = r13
            r19 = r40
            tr r0 = defpackage.tr.q0(r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x038a }
            r23 = r6
            r6 = r0
            goto L_0x0463
        L_0x0446:
            r2.close()     // Catch:{ Exception -> 0x038a }
            xr r0 = new xr     // Catch:{ Exception -> 0x038a }
            int r21 = r10 - r28
            byte[] r23 = r35.toByteArray()     // Catch:{ Exception -> 0x038a }
            r18 = r0
            r19 = r13
            r20 = r40
            r22 = r1
            r18.<init>(r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x038a }
            r7 = 1
            r0.e1(r7)     // Catch:{ Exception -> 0x038a }
            r23 = r6
            r6 = r0
        L_0x0463:
            r7 = r34
            r6.f1(r12, r7)     // Catch:{ Exception -> 0x038a }
            r0 = 6
            if (r3 == r0) goto L_0x0571
            r0 = 7
            if (r3 == r0) goto L_0x0571
            r0 = 34675(0x8773, float:4.859E-41)
            r14 = r41
            boolean r15 = r14.e(r0)     // Catch:{ Exception -> 0x05bf }
            if (r15 == 0) goto L_0x049b
            ep0 r0 = r14.a(r0)     // Catch:{ RuntimeException -> 0x0497 }
            byte[] r15 = r0.b()     // Catch:{ RuntimeException -> 0x0497 }
            dr r15 = defpackage.dr.b(r15)     // Catch:{ RuntimeException -> 0x0497 }
            r17 = r0
            int r0 = r10 - r28
            r18 = r2
            int r2 = r15.d()     // Catch:{ RuntimeException -> 0x0495 }
            if (r0 != r2) goto L_0x0494
            r6.s1(r15)     // Catch:{ RuntimeException -> 0x0495 }
        L_0x0494:
            goto L_0x049d
        L_0x0495:
            r0 = move-exception
            goto L_0x049d
        L_0x0497:
            r0 = move-exception
            r18 = r2
            goto L_0x049d
        L_0x049b:
            r18 = r2
        L_0x049d:
            r0 = 320(0x140, float:4.48E-43)
            boolean r2 = r14.e(r0)     // Catch:{ Exception -> 0x05bf }
            if (r2 == 0) goto L_0x0566
            ep0 r0 = r14.a(r0)     // Catch:{ Exception -> 0x05bf }
            char[] r2 = r0.c()     // Catch:{ Exception -> 0x05bf }
            int r15 = r2.length     // Catch:{ Exception -> 0x05bf }
            byte[] r15 = new byte[r15]     // Catch:{ Exception -> 0x05bf }
            r17 = r0
            int r0 = r2.length     // Catch:{ Exception -> 0x05bf }
            r19 = 3
            int r0 = r0 / 3
            int r19 = r0 * 2
            r20 = 0
            r21 = r4
            r4 = r20
        L_0x04bf:
            if (r4 >= r0) goto L_0x04f7
            int r20 = r4 * 3
            char r22 = r2[r4]     // Catch:{ Exception -> 0x05bf }
            r25 = r5
            r24 = 8
            int r5 = r22 >>> 8
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x05bf }
            r15[r20] = r5     // Catch:{ Exception -> 0x05bf }
            int r5 = r4 * 3
            r20 = 1
            int r5 = r5 + 1
            int r20 = r4 + r0
            char r20 = r2[r20]     // Catch:{ Exception -> 0x05bf }
            r34 = r7
            r22 = 8
            int r7 = r20 >>> 8
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x05bf }
            r15[r5] = r7     // Catch:{ Exception -> 0x05bf }
            int r5 = r4 * 3
            r7 = 2
            int r5 = r5 + r7
            int r7 = r4 + r19
            char r7 = r2[r7]     // Catch:{ Exception -> 0x05bf }
            r20 = 8
            int r7 = r7 >>> 8
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x05bf }
            r15[r5] = r7     // Catch:{ Exception -> 0x05bf }
            int r4 = r4 + 1
            r5 = r25
            r7 = r34
            goto L_0x04bf
        L_0x04f7:
            r25 = r5
            r34 = r7
            r4 = 1
            r5 = 0
        L_0x04fd:
            int r7 = r15.length     // Catch:{ Exception -> 0x05bf }
            if (r5 >= r7) goto L_0x0509
            byte r7 = r15[r5]     // Catch:{ Exception -> 0x05bf }
            if (r7 == 0) goto L_0x0506
            r4 = 0
            goto L_0x0509
        L_0x0506:
            int r5 = r5 + 1
            goto L_0x04fd
        L_0x0509:
            if (r4 == 0) goto L_0x0535
            r5 = 0
        L_0x050c:
            if (r5 >= r0) goto L_0x0532
            int r7 = r5 * 3
            r20 = r4
            char r4 = r2[r5]     // Catch:{ Exception -> 0x05bf }
            byte r4 = (byte) r4     // Catch:{ Exception -> 0x05bf }
            r15[r7] = r4     // Catch:{ Exception -> 0x05bf }
            int r4 = r5 * 3
            r7 = 1
            int r4 = r4 + r7
            int r7 = r5 + r0
            char r7 = r2[r7]     // Catch:{ Exception -> 0x05bf }
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x05bf }
            r15[r4] = r7     // Catch:{ Exception -> 0x05bf }
            int r4 = r5 * 3
            r7 = 2
            int r4 = r4 + r7
            int r22 = r5 + r19
            char r7 = r2[r22]     // Catch:{ Exception -> 0x05bf }
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x05bf }
            r15[r4] = r7     // Catch:{ Exception -> 0x05bf }
            int r5 = r5 + 1
            r4 = r20
            goto L_0x050c
        L_0x0532:
            r20 = r4
            goto L_0x0537
        L_0x0535:
            r20 = r4
        L_0x0537:
            x50 r4 = new x50     // Catch:{ Exception -> 0x05bf }
            r4.<init>()     // Catch:{ Exception -> 0x05bf }
            h70 r5 = defpackage.h70.E5     // Catch:{ Exception -> 0x05bf }
            r4.I(r5)     // Catch:{ Exception -> 0x05bf }
            h70 r5 = defpackage.h70.s2     // Catch:{ Exception -> 0x05bf }
            r4.I(r5)     // Catch:{ Exception -> 0x05bf }
            k70 r5 = new k70     // Catch:{ Exception -> 0x05bf }
            int r7 = r0 + -1
            r5.<init>((int) r7)     // Catch:{ Exception -> 0x05bf }
            r4.I(r5)     // Catch:{ Exception -> 0x05bf }
            n80 r5 = new n80     // Catch:{ Exception -> 0x05bf }
            r5.<init>((byte[]) r15)     // Catch:{ Exception -> 0x05bf }
            r4.I(r5)     // Catch:{ Exception -> 0x05bf }
            j60 r5 = new j60     // Catch:{ Exception -> 0x05bf }
            r5.<init>()     // Catch:{ Exception -> 0x05bf }
            h70 r7 = defpackage.h70.n1     // Catch:{ Exception -> 0x05bf }
            r5.Q(r7, r4)     // Catch:{ Exception -> 0x05bf }
            r6.c1(r5)     // Catch:{ Exception -> 0x05bf }
            goto L_0x056c
        L_0x0566:
            r21 = r4
            r25 = r5
            r34 = r7
        L_0x056c:
            r2 = 5
            r6.k1(r2)     // Catch:{ Exception -> 0x05bf }
            goto L_0x057b
        L_0x0571:
            r14 = r41
            r18 = r2
            r21 = r4
            r25 = r5
            r34 = r7
        L_0x057b:
            if (r11 != 0) goto L_0x0581
            r2 = 1
            r6.i1(r2)     // Catch:{ Exception -> 0x05bf }
        L_0x0581:
            r0 = 0
            int r0 = (r16 > r0 ? 1 : (r16 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x058c
            r2 = r16
            r6.h1(r2)     // Catch:{ Exception -> 0x05bf }
            goto L_0x058e
        L_0x058c:
            r2 = r16
        L_0x058e:
            if (r28 <= 0) goto L_0x05a8
            r32.close()     // Catch:{ Exception -> 0x05bf }
            byte[] r0 = r33.toByteArray()     // Catch:{ Exception -> 0x05bf }
            r4 = r40
            r5 = 1
            tr r0 = defpackage.tr.o0(r13, r4, r5, r1, r0)     // Catch:{ Exception -> 0x05bf }
            r0.V0()     // Catch:{ Exception -> 0x05bf }
            r0.e1(r5)     // Catch:{ Exception -> 0x05bf }
            r6.g1(r0)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05aa
        L_0x05a8:
            r4 = r40
        L_0x05aa:
            return r6
        L_0x05ab:
            java.lang.String r4 = "bits.per.sample.1.is.not.supported"
            java.lang.String r4 = defpackage.i10.a(r4, r1)     // Catch:{ Exception -> 0x05bf }
            r0.<init>(r4)     // Catch:{ Exception -> 0x05bf }
            throw r0     // Catch:{ Exception -> 0x05bf }
        L_0x05b5:
            java.lang.String r1 = "the.compression.1.is.not.supported"
            java.lang.String r1 = defpackage.i10.a(r1, r3)     // Catch:{ Exception -> 0x05bf }
            r0.<init>(r1)     // Catch:{ Exception -> 0x05bf }
            throw r0     // Catch:{ Exception -> 0x05bf }
        L_0x05bf:
            r0 = move-exception
            goto L_0x05c3
        L_0x05c1:
            r0 = move-exception
            r14 = r1
        L_0x05c3:
            mj r1 = new mj
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jr0.j(cp0, cd0):tr");
    }

    static tr a(DeflaterOutputStream zip, DeflaterOutputStream mzip, byte[] outBuf, int samplePerPixel, int bitsPerSample, int width, int height) {
        if (bitsPerSample == 8) {
            byte[] mask = new byte[(width * height)];
            int mptr = 0;
            int optr = 0;
            int total = width * height * samplePerPixel;
            int k = 0;
            while (k < total) {
                int s = 0;
                while (s < samplePerPixel - 1) {
                    outBuf[optr] = outBuf[k + s];
                    s++;
                    optr++;
                }
                mask[mptr] = outBuf[(k + samplePerPixel) - 1];
                k += samplePerPixel;
                mptr++;
            }
            zip.write(outBuf, 0, optr);
            mzip.write(mask, 0, mptr);
            return null;
        }
        throw new IllegalArgumentException(i10.b("extra.samples.are.not.supported", new Object[0]));
    }

    static long[] d(cp0 dir, int tag) {
        ep0 field = dir.a(tag);
        if (field == null) {
            return null;
        }
        if (field.k() == 4) {
            return field.h();
        }
        char[] offset = field.c();
        long[] offset2 = new long[offset.length];
        for (int k = 0; k < offset.length; k++) {
            offset2[k] = (long) offset[k];
        }
        return offset2;
    }

    public static void c(byte[] data, byte[] dst) {
        int srcCount = 0;
        int dstCount = 0;
        while (dstCount < dst.length) {
            try {
                int srcCount2 = srcCount + 1;
                try {
                    byte b = data[srcCount];
                    if (b >= 0 && b <= Byte.MAX_VALUE) {
                        int i = 0;
                        while (i < b + 1) {
                            int dstCount2 = dstCount + 1;
                            int srcCount3 = srcCount2 + 1;
                            try {
                                dst[dstCount] = data[srcCount2];
                                i++;
                                dstCount = dstCount2;
                                srcCount2 = srcCount3;
                            } catch (Exception e) {
                                int i2 = dstCount2;
                                int i3 = srcCount3;
                                return;
                            }
                        }
                        srcCount = srcCount2;
                    } else if (b > -1 || b < -127) {
                        srcCount = srcCount2 + 1;
                    } else {
                        int srcCount4 = srcCount2 + 1;
                        try {
                            byte srcCount5 = data[srcCount2];
                            int i4 = 0;
                            while (i4 < (-b) + 1) {
                                int dstCount3 = dstCount + 1;
                                try {
                                    dst[dstCount] = srcCount5;
                                    i4++;
                                    dstCount = dstCount3;
                                } catch (Exception e2) {
                                    int i5 = srcCount4;
                                    int i6 = dstCount3;
                                    return;
                                }
                            }
                            srcCount = srcCount4;
                        } catch (Exception e3) {
                            int i7 = srcCount4;
                            return;
                        }
                    }
                } catch (Exception e4) {
                    int i8 = srcCount2;
                    return;
                }
            } catch (Exception e5) {
                return;
            }
        }
    }

    public static void k(byte[] deflated, byte[] inflated) {
        Inflater inflater = new Inflater();
        inflater.setInput(deflated);
        try {
            inflater.inflate(inflated);
        } catch (DataFormatException dfe) {
            throw new mj(dfe);
        }
    }

    public static void b(byte[] uncompData, int predictor, int w, int h, int samplesPerPixel) {
        if (predictor == 2) {
            for (int j = 0; j < h; j++) {
                int count = ((j * w) + 1) * samplesPerPixel;
                for (int i = samplesPerPixel; i < w * samplesPerPixel; i++) {
                    uncompData[count] = (byte) (uncompData[count] + uncompData[count - samplesPerPixel]);
                    count++;
                }
            }
        }
    }
}
