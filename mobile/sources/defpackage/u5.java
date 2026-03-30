package defpackage;

import java.io.PrintStream;

/* renamed from: u5  reason: default package */
public abstract class u5 {
    private static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};
    private static final byte[] c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};
    private static final byte[] e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9};

    private static final byte[] e(int options) {
        if ((options & 16) == 16) {
            return d;
        }
        if ((options & 32) == 32) {
            return f;
        }
        return b;
    }

    private static int d(byte[] source, int srcOffset, byte[] destination, int destOffset, int options) {
        byte[] DECODABET = e(options);
        if (source[srcOffset + 2] == 61) {
            destination[destOffset] = (byte) ((((DECODABET[source[srcOffset]] & 255) << 18) | ((DECODABET[source[srcOffset + 1]] & 255) << 12)) >>> 16);
            return 1;
        } else if (source[srcOffset + 3] == 61) {
            int outBuff = ((DECODABET[source[srcOffset]] & 255) << 18) | ((DECODABET[source[srcOffset + 1]] & 255) << 12) | ((DECODABET[source[srcOffset + 2]] & 255) << 6);
            destination[destOffset] = (byte) (outBuff >>> 16);
            destination[destOffset + 1] = (byte) (outBuff >>> 8);
            return 2;
        } else {
            try {
                int outBuff2 = ((DECODABET[source[srcOffset]] & 255) << 18) | ((DECODABET[source[srcOffset + 1]] & 255) << 12) | ((DECODABET[source[srcOffset + 2]] & 255) << 6) | (DECODABET[source[srcOffset + 3]] & 255);
                destination[destOffset] = (byte) (outBuff2 >> 16);
                destination[destOffset + 1] = (byte) (outBuff2 >> 8);
                destination[destOffset + 2] = (byte) outBuff2;
                return 3;
            } catch (Exception e2) {
                PrintStream printStream = System.out;
                printStream.println("" + source[srcOffset] + ": " + DECODABET[source[srcOffset]]);
                PrintStream printStream2 = System.out;
                printStream2.println("" + source[srcOffset + 1] + ": " + DECODABET[source[srcOffset + 1]]);
                PrintStream printStream3 = System.out;
                printStream3.println("" + source[srcOffset + 2] + ": " + DECODABET[source[srcOffset + 2]]);
                PrintStream printStream4 = System.out;
                printStream4.println("" + source[srcOffset + 3] + ": " + DECODABET[source[srcOffset + 3]]);
                return -1;
            }
        }
    }

    public static byte[] c(byte[] source, int off, int len, int options) {
        byte[] DECODABET = e(options);
        byte[] outBuff = new byte[((len * 3) / 4)];
        int outBuffPosn = 0;
        byte[] b4 = new byte[4];
        int b4Posn = 0;
        int i = off;
        while (i < off + len) {
            byte sbiCrop = (byte) (source[i] & Byte.MAX_VALUE);
            byte sbiDecode = DECODABET[sbiCrop];
            if (sbiDecode >= -5) {
                if (sbiDecode >= -1) {
                    int b4Posn2 = b4Posn + 1;
                    b4[b4Posn] = sbiCrop;
                    if (b4Posn2 > 3) {
                        outBuffPosn += d(b4, 0, outBuff, outBuffPosn, options);
                        b4Posn = 0;
                        if (sbiCrop == 61) {
                            break;
                        }
                    } else {
                        b4Posn = b4Posn2;
                    }
                }
                i++;
            } else {
                PrintStream printStream = System.err;
                printStream.println("Bad Base64 input character at " + i + ": " + source[i] + "(decimal)");
                return null;
            }
        }
        byte[] out = new byte[outBuffPosn];
        System.arraycopy(outBuff, 0, out, 0, outBuffPosn);
        return out;
    }

    public static byte[] a(String s) {
        return b(s, 0);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0060=Splitter:B:25:0x0060, B:46:0x0082=Splitter:B:46:0x0082} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(java.lang.String r9, int r10) {
        /*
            r0 = 0
            java.lang.String r1 = "UTF-8"
            byte[] r0 = r9.getBytes(r1)     // Catch:{ UnsupportedEncodingException -> 0x0008 }
            goto L_0x000d
        L_0x0008:
            r1 = move-exception
            byte[] r0 = r9.getBytes()
        L_0x000d:
            int r1 = r0.length
            r2 = 0
            byte[] r0 = c(r0, r2, r1, r10)
            if (r0 == 0) goto L_0x0085
            int r1 = r0.length
            r3 = 4
            if (r1 < r3) goto L_0x0085
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r3 = 1
            byte r3 = r0[r3]
            int r3 = r3 << 8
            r4 = 65280(0xff00, float:9.1477E-41)
            r3 = r3 & r4
            r1 = r1 | r3
            r3 = 35615(0x8b1f, float:4.9907E-41)
            if (r3 != r1) goto L_0x0085
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r7 = 0
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0077, all -> 0x0066 }
            r8.<init>()     // Catch:{ IOException -> 0x0077, all -> 0x0066 }
            r5 = r8
            java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0077, all -> 0x0066 }
            r8.<init>(r0)     // Catch:{ IOException -> 0x0077, all -> 0x0066 }
            r3 = r8
            java.util.zip.GZIPInputStream r8 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0077, all -> 0x0066 }
            r8.<init>(r3)     // Catch:{ IOException -> 0x0077, all -> 0x0066 }
            r4 = r8
        L_0x0046:
            int r8 = r4.read(r6)     // Catch:{ IOException -> 0x0077, all -> 0x0066 }
            r7 = r8
            if (r8 < 0) goto L_0x0051
            r5.write(r6, r2, r7)     // Catch:{ IOException -> 0x0077, all -> 0x0066 }
            goto L_0x0046
        L_0x0051:
            byte[] r2 = r5.toByteArray()     // Catch:{ IOException -> 0x0077, all -> 0x0066 }
            r0 = r2
            r5.close()     // Catch:{ Exception -> 0x005a }
            goto L_0x005b
        L_0x005a:
            r2 = move-exception
        L_0x005b:
            r4.close()     // Catch:{ Exception -> 0x005f }
            goto L_0x0060
        L_0x005f:
            r2 = move-exception
        L_0x0060:
            r3.close()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0085
        L_0x0064:
            r2 = move-exception
            goto L_0x0085
        L_0x0066:
            r2 = move-exception
            r5.close()     // Catch:{ Exception -> 0x006b }
            goto L_0x006c
        L_0x006b:
            r8 = move-exception
        L_0x006c:
            r4.close()     // Catch:{ Exception -> 0x0070 }
            goto L_0x0071
        L_0x0070:
            r8 = move-exception
        L_0x0071:
            r3.close()     // Catch:{ Exception -> 0x0075 }
            goto L_0x0076
        L_0x0075:
            r8 = move-exception
        L_0x0076:
            throw r2
        L_0x0077:
            r2 = move-exception
            r5.close()     // Catch:{ Exception -> 0x007c }
            goto L_0x007d
        L_0x007c:
            r2 = move-exception
        L_0x007d:
            r4.close()     // Catch:{ Exception -> 0x0081 }
            goto L_0x0082
        L_0x0081:
            r2 = move-exception
        L_0x0082:
            r3.close()     // Catch:{ Exception -> 0x0064 }
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u5.b(java.lang.String, int):byte[]");
    }
}
