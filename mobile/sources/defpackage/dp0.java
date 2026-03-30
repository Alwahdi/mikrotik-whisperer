package defpackage;

/* renamed from: dp0  reason: default package */
public class dp0 {
    static short[] a = {6430, 6400, 6400, 6400, 3225, 3225, 3225, 3225, 944, 944, 944, 944, 976, 976, 976, 976, 1456, 1456, 1456, 1456, 1488, 1488, 1488, 1488, 718, 718, 718, 718, 718, 718, 718, 718, 750, 750, 750, 750, 750, 750, 750, 750, 1520, 1520, 1520, 1520, 1552, 1552, 1552, 1552, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 654, 654, 654, 654, 654, 654, 654, 654, 1072, 1072, 1072, 1072, 1104, 1104, 1104, 1104, 1136, 1136, 1136, 1136, 1168, 1168, 1168, 1168, 1200, 1200, 1200, 1200, 1232, 1232, 1232, 1232, 622, 622, 622, 622, 622, 622, 622, 622, 1008, 1008, 1008, 1008, 1040, 1040, 1040, 1040, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 1712, 1712, 1712, 1712, 1744, 1744, 1744, 1744, 846, 846, 846, 846, 846, 846, 846, 846, 1264, 1264, 1264, 1264, 1296, 1296, 1296, 1296, 1328, 1328, 1328, 1328, 1360, 1360, 1360, 1360, 1392, 1392, 1392, 1392, 1424, 1424, 1424, 1424, 686, 686, 686, 686, 686, 686, 686, 686, 910, 910, 910, 910, 910, 910, 910, 910, 1968, 1968, 1968, 1968, 2000, 2000, 2000, 2000, 2032, 2032, 2032, 2032, 16, 16, 16, 16, 10257, 10257, 10257, 10257, 12305, 12305, 12305, 12305, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 878, 878, 878, 878, 878, 878, 878, 878, 1904, 1904, 1904, 1904, 1936, 1936, 1936, 1936, -18413, -18413, -16365, -16365, -14317, -14317, -10221, -10221, 590, 590, 590, 590, 590, 590, 590, 590, 782, 782, 782, 782, 782, 782, 782, 782, 1584, 1584, 1584, 1584, 1616, 1616, 1616, 1616, 1648, 1648, 1648, 1648, 1680, 1680, 1680, 1680, 814, 814, 814, 814, 814, 814, 814, 814, 1776, 1776, 1776, 1776, 1808, 1808, 1808, 1808, 1840, 1840, 1840, 1840, 1872, 1872, 1872, 1872, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, 14353, 14353, 14353, 14353, 16401, 16401, 16401, 16401, 22547, 22547, 24595, 24595, 20497, 20497, 20497, 20497, 18449, 18449, 18449, 18449, 26643, 26643, 28691, 28691, 30739, 30739, -32749, -32749, -30701, -30701, -28653, -28653, -26605, -26605, -24557, -24557, -22509, -22509, -20461, -20461, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232};
    static byte[] b = {0, Byte.MIN_VALUE, 64, -64, 32, -96, 96, -32, 16, -112, 80, -48, 48, -80, 112, -16, 8, -120, 72, -56, 40, -88, 104, -24, 24, -104, 88, -40, 56, -72, 120, -8, 4, -124, 68, -60, 36, -92, 100, -28, 20, -108, 84, -44, 52, -76, 116, -12, 12, -116, 76, -52, 44, -84, 108, -20, 28, -100, 92, -36, 60, -68, 124, -4, 2, -126, 66, -62, 34, -94, 98, -30, 18, -110, 82, -46, 50, -78, 114, -14, 10, -118, 74, -54, 42, -86, 106, -22, 26, -102, 90, -38, 58, -70, 122, -6, 6, -122, 70, -58, 38, -90, 102, -26, 22, -106, 86, -42, 54, -74, 118, -10, 14, -114, 78, -50, 46, -82, 110, -18, 30, -98, 94, -34, 62, -66, 126, -2, 1, -127, 65, -63, 33, -95, 97, -31, 17, -111, 81, -47, 49, -79, 113, -15, 9, -119, 73, -55, 41, -87, 105, -23, 25, -103, 89, -39, 57, -71, 121, -7, 5, -123, 69, -59, 37, -91, 101, -27, 21, -107, 85, -43, 53, -75, 117, -11, 13, -115, 77, -51, 45, -83, 109, -19, 29, -99, 93, -35, 61, -67, 125, -3, 3, -125, 67, -61, 35, -93, 99, -29, 19, -109, 83, -45, 51, -77, 115, -13, 11, -117, 75, -53, 43, -85, 107, -21, 27, -101, 91, -37, 59, -69, 123, -5, 7, -121, 71, -57, 39, -89, 103, -25, 23, -105, 87, -41, 55, -73, 119, -9, 15, -113, 79, -49, 47, -81, 111, -17, 31, -97, 95, -33, 63, -65, Byte.MAX_VALUE, -1};

    /* renamed from: b  reason: collision with other field name */
    static short[] f2796b = {28679, 28679, 31752, -32759, -31735, -30711, -29687, -28663, 29703, 29703, 30727, 30727, -27639, -26615, -25591, -24567};
    static byte[] c = {80, 88, 23, 71, 30, 30, 62, 62, 4, 4, 4, 4, 4, 4, 4, 4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41};

    /* renamed from: c  reason: collision with other field name */
    static int[] f2797c = {0, 1, 3, 7, 15, 31, 63, 127, 255};

    /* renamed from: c  reason: collision with other field name */
    static short[] f2798c = {3226, 6412, 200, 168, 38, 38, 134, 134, 100, 100, 100, 100, 68, 68, 68, 68};
    static int[] d = {0, 128, 192, 224, 240, 248, 252, 254, 255};

    /* renamed from: d  reason: collision with other field name */
    static short[] f2799d = {292, 260, 226, 226};
    static short[] e = {62, 62, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 588, 588, 588, 588, 588, 588, 588, 588, 1680, 1680, 20499, 22547, 24595, 26643, 1776, 1776, 1808, 1808, -24557, -22509, -20461, -18413, 1904, 1904, 1936, 1936, -16365, -14317, 782, 782, 782, 782, 814, 814, 814, 814, -12269, -10221, 10257, 10257, 12305, 12305, 14353, 14353, 16403, 18451, 1712, 1712, 1744, 1744, 28691, 30739, -32749, -30701, -28653, -26605, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 750, 750, 750, 750, 1616, 1616, 1648, 1648, 1424, 1424, 1456, 1456, 1488, 1488, 1520, 1520, 1840, 1840, 1872, 1872, 1968, 1968, 8209, 8209, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 1552, 1552, 1584, 1584, 2000, 2000, 2032, 2032, 976, 976, 1008, 1008, 1040, 1040, 1072, 1072, 1296, 1296, 1328, 1328, 718, 718, 718, 718, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 4113, 4113, 6161, 6161, 848, 848, 880, 880, 912, 912, 944, 944, 622, 622, 622, 622, 654, 654, 654, 654, 1104, 1104, 1136, 1136, 1168, 1168, 1200, 1200, 1232, 1232, 1264, 1264, 686, 686, 686, 686, 1360, 1360, 1392, 1392, 12, 12, 12, 12, 12, 12, 12, 12, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390};

    /* renamed from: a  reason: collision with other field name */
    private int f2800a;

    /* renamed from: a  reason: collision with other field name */
    private long f2801a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2802a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f2803a;

    /* renamed from: a  reason: collision with other field name */
    private int[] f2804a;

    /* renamed from: b  reason: collision with other field name */
    private int f2805b;

    /* renamed from: b  reason: collision with other field name */
    private int[] f2806b;

    /* renamed from: c  reason: collision with other field name */
    private int f2807c;

    /* renamed from: d  reason: collision with other field name */
    private int f2808d;

    /* renamed from: e  reason: collision with other field name */
    private int f2809e = 0;
    private int f = 0;
    private int g = 2;
    private int h = 0;
    private int i = 0;
    private int j;

    public dp0(long fillOrder, int w, int h2) {
        this.f2801a = fillOrder;
        this.f2807c = w;
        this.f2808d = h2;
        this.f2800a = 0;
        this.f2805b = 0;
        this.f2804a = new int[(w * 2)];
        this.f2806b = new int[(w * 2)];
    }

    public static void l(byte[] b2) {
        for (int k = 0; k < b2.length; k++) {
            b2[k] = b[b2[k] & 255];
        }
    }

    public void b(byte[] buffer, byte[] compData, int startX, int height) {
        this.f2803a = compData;
        int lineOffset = 0;
        int scanlineStride = (this.f2807c + 7) / 8;
        this.f2800a = 0;
        this.f2805b = 0;
        for (int i2 = 0; i2 < height; i2++) {
            e(buffer, lineOffset, startX);
            lineOffset += scanlineStride;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
        if (r3 != r0.f2807c) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0089, code lost:
        if (r0.g != 2) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (r8 != false) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0092, code lost:
        r14 = f2798c[i(4)];
        r6 = r14 & 1;
        r4 = (r14 >>> 1) & 15;
        r5 = (r14 >>> 5) & 2047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a7, code lost:
        if (r5 != 100) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a9, code lost:
        r14 = e[j(9)];
        r6 = r14 & 1;
        r4 = (r14 >>> 1) & 15;
        r5 = (r14 >>> 5) & 2047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bd, code lost:
        if (r4 != r9) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bf, code lost:
        o(5);
        r13 = f2796b[i(4)];
        r5 = (r13 >>> 4) & 4095;
        n(r1, r2, r3, r5);
        r3 = r3 + r5;
        o(4 - ((r13 >>> 1) & 7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00dd, code lost:
        if (r4 == 15) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00df, code lost:
        n(r1, r2, r3, r5);
        r3 = r3 + r5;
        o(9 - r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e8, code lost:
        if (r6 != 0) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ea, code lost:
        r8 = true;
        r12 = r0.f2806b;
        r15 = r0.f2809e;
        r0.f2809e = r15 + 1;
        r12[r15] = r3;
        r9 = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f8, code lost:
        r9 = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0108, code lost:
        throw new java.lang.RuntimeException(defpackage.i10.b("eol.code.word.encountered.in.black.run", new java.lang.Object[0]));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x010b, code lost:
        if (r5 != 200) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x010d, code lost:
        r12 = f2799d[i(2)];
        r5 = (r12 >>> 5) & 2047;
        n(r1, r2, r3, r5);
        r3 = r3 + r5;
        o(2 - ((r12 >>> 1) & 15));
        r8 = true;
        r13 = r0.f2806b;
        r14 = r0.f2809e;
        r0.f2809e = r14 + 1;
        r13[r14] = r3;
        r9 = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0135, code lost:
        n(r1, r2, r3, r5);
        r3 = r3 + r5;
        o(4 - r4);
        r8 = true;
        r9 = r0.f2806b;
        r12 = r0.f2809e;
        r0.f2809e = r12 + 1;
        r9[r12] = r3;
        r9 = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0153, code lost:
        if (r0.g != 2) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0155, code lost:
        a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(byte[] r17, int r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 1
            r7 = 0
            r0.f2809e = r7
            r8 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r19
        L_0x0013:
            int r9 = r0.f2807c
            if (r3 >= r9) goto L_0x0158
        L_0x0017:
            r9 = 12
            r10 = 2
            r11 = 15
            if (r8 == 0) goto L_0x0083
            r12 = 10
            int r12 = r0.j(r12)
            short[] r13 = a
            short r13 = r13[r12]
            r6 = r13 & 1
            int r14 = r13 >>> 1
            r4 = r14 & 15
            if (r4 != r9) goto L_0x004b
            int r10 = r0.i(r10)
            int r11 = r12 << 2
            r9 = r9 & r11
            r9 = r9 | r10
            short[] r11 = f2796b
            short r11 = r11[r9]
            int r12 = r11 >>> 1
            r4 = r12 & 7
            int r12 = r11 >>> 4
            r5 = r12 & 4095(0xfff, float:5.738E-42)
            int r3 = r3 + r5
            int r12 = 4 - r4
            r0.o(r12)
            goto L_0x0017
        L_0x004b:
            if (r4 == 0) goto L_0x0075
            if (r4 == r11) goto L_0x0067
            int r9 = r13 >>> 5
            r5 = r9 & 2047(0x7ff, float:2.868E-42)
            int r3 = r3 + r5
            int r9 = 10 - r4
            r0.o(r9)
            if (r6 != 0) goto L_0x0017
            r8 = 0
            int[] r9 = r0.f2806b
            int r10 = r0.f2809e
            int r11 = r10 + 1
            r0.f2809e = r11
            r9[r10] = r3
            goto L_0x0017
        L_0x0067:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r10 = "eol.code.word.encountered.in.white.run"
            java.lang.String r7 = defpackage.i10.b(r10, r7)
            r9.<init>(r7)
            throw r9
        L_0x0075:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r10 = "invalid.code.encountered"
            java.lang.String r7 = defpackage.i10.b(r10, r7)
            r9.<init>(r7)
            throw r9
        L_0x0083:
            int r12 = r0.f2807c
            if (r3 != r12) goto L_0x0090
            int r7 = r0.g
            if (r7 != r10) goto L_0x0158
            r16.a()
            goto L_0x0158
        L_0x0090:
            if (r8 != 0) goto L_0x014d
            r12 = 4
            int r13 = r0.i(r12)
            short[] r14 = f2798c
            short r14 = r14[r13]
            r6 = r14 & 1
            int r15 = r14 >>> 1
            r4 = r15 & 15
            int r15 = r14 >>> 5
            r5 = r15 & 2047(0x7ff, float:2.868E-42)
            r15 = 100
            if (r5 != r15) goto L_0x0109
            r15 = 9
            int r13 = r0.j(r15)
            short[] r15 = e
            short r14 = r15[r13]
            r6 = r14 & 1
            int r15 = r14 >>> 1
            r4 = r15 & 15
            int r15 = r14 >>> 5
            r5 = r15 & 2047(0x7ff, float:2.868E-42)
            if (r4 != r9) goto L_0x00dd
            r15 = 5
            r0.o(r15)
            int r12 = r0.i(r12)
            short[] r13 = f2796b
            short r13 = r13[r12]
            int r14 = r13 >>> 1
            r4 = r14 & 7
            int r14 = r13 >>> 4
            r5 = r14 & 4095(0xfff, float:5.738E-42)
            r0.n(r1, r2, r3, r5)
            int r3 = r3 + r5
            int r14 = 4 - r4
            r0.o(r14)
            goto L_0x0090
        L_0x00dd:
            if (r4 == r11) goto L_0x00fb
            r0.n(r1, r2, r3, r5)
            int r3 = r3 + r5
            int r12 = 9 - r4
            r0.o(r12)
            if (r6 != 0) goto L_0x00f8
            r8 = 1
            int[] r12 = r0.f2806b
            int r15 = r0.f2809e
            int r9 = r15 + 1
            r0.f2809e = r9
            r12[r15] = r3
            r9 = 12
            goto L_0x0090
        L_0x00f8:
            r9 = 12
            goto L_0x0090
        L_0x00fb:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r10 = "eol.code.word.encountered.in.black.run"
            java.lang.String r7 = defpackage.i10.b(r10, r7)
            r9.<init>(r7)
            throw r9
        L_0x0109:
            r9 = 200(0xc8, float:2.8E-43)
            if (r5 != r9) goto L_0x0135
            int r9 = r0.i(r10)
            short[] r12 = f2799d
            short r12 = r12[r9]
            int r13 = r12 >>> 5
            r5 = r13 & 2047(0x7ff, float:2.868E-42)
            int r13 = r12 >>> 1
            r4 = r13 & 15
            r0.n(r1, r2, r3, r5)
            int r3 = r3 + r5
            int r13 = 2 - r4
            r0.o(r13)
            r8 = 1
            int[] r13 = r0.f2806b
            int r14 = r0.f2809e
            int r15 = r14 + 1
            r0.f2809e = r15
            r13[r14] = r3
            r9 = 12
            goto L_0x0090
        L_0x0135:
            r0.n(r1, r2, r3, r5)
            int r3 = r3 + r5
            int r9 = 4 - r4
            r0.o(r9)
            r8 = 1
            int[] r9 = r0.f2806b
            int r12 = r0.f2809e
            int r15 = r12 + 1
            r0.f2809e = r15
            r9[r12] = r3
            r9 = 12
            goto L_0x0090
        L_0x014d:
            int r9 = r0.f2807c
            if (r3 != r9) goto L_0x0013
            int r7 = r0.g
            if (r7 != r10) goto L_0x0158
            r16.a()
        L_0x0158:
            int[] r7 = r0.f2806b
            int r9 = r0.f2809e
            int r10 = r9 + 1
            r0.f2809e = r10
            r7[r9] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dp0.e(byte[], int, int):void");
    }

    public void c(byte[] buffer, byte[] compData, int startX, int height, long tiffT4Options) {
        char c2;
        int currIndex;
        byte[] bArr = buffer;
        int i2 = startX;
        this.f2803a = compData;
        this.g = 3;
        boolean z = false;
        this.f2800a = 0;
        this.f2805b = 0;
        int scanlineStride = (this.f2807c + 7) / 8;
        int[] b2 = new int[2];
        this.j = (int) (tiffT4Options & 1);
        this.h = (int) ((tiffT4Options & 2) >> 1);
        this.i = (int) ((tiffT4Options & 4) >> 2);
        if (k(true) == 1) {
            e(bArr, 0, i2);
            int lineOffset = 0 + scanlineStride;
            int lines = 1;
            while (lines < height) {
                if (k(z) == 0) {
                    int[] temp = this.f2804a;
                    this.f2804a = this.f2806b;
                    this.f2806b = temp;
                    int currIndex2 = 0;
                    int a0 = -1;
                    this.f = z ? 1 : 0;
                    boolean isWhite = true;
                    int bitOffset = startX;
                    char c3 = z;
                    while (bitOffset < this.f2807c) {
                        h(a0, isWhite, b2);
                        int b1 = b2[c3];
                        int b22 = b2[1];
                        int i3 = c[i(7)] & 255;
                        int code = (i3 & 120) >>> 3;
                        int bits = i3 & 7;
                        if (code == 0) {
                            if (!isWhite) {
                                int i4 = i3;
                                n(bArr, lineOffset, bitOffset, b22 - bitOffset);
                            } else {
                                int entry = i3;
                            }
                            a0 = b22;
                            bitOffset = b22;
                            o(7 - bits);
                            byte[] bArr2 = compData;
                            c2 = 0;
                        } else {
                            int entry2 = i3;
                            if (code == 1) {
                                o(7 - bits);
                                if (isWhite) {
                                    int number = g();
                                    int bitOffset2 = bitOffset + number;
                                    int i5 = number;
                                    int currIndex3 = currIndex2 + 1;
                                    this.f2806b[currIndex2] = bitOffset2;
                                    int number2 = d();
                                    n(bArr, lineOffset, bitOffset2, number2);
                                    bitOffset = bitOffset2 + number2;
                                    currIndex = currIndex3 + 1;
                                    this.f2806b[currIndex3] = bitOffset;
                                } else {
                                    int number3 = d();
                                    n(bArr, lineOffset, bitOffset, number3);
                                    int bitOffset3 = bitOffset + number3;
                                    int i6 = number3;
                                    int currIndex4 = currIndex2 + 1;
                                    this.f2806b[currIndex2] = bitOffset3;
                                    bitOffset = bitOffset3 + g();
                                    currIndex = currIndex4 + 1;
                                    this.f2806b[currIndex4] = bitOffset;
                                }
                                currIndex2 = currIndex;
                                a0 = bitOffset;
                                byte[] bArr3 = compData;
                                c2 = 0;
                            } else if (code <= 8) {
                                int a1 = b1 + (code - 5);
                                int currIndex5 = currIndex2 + 1;
                                this.f2806b[currIndex2] = a1;
                                if (!isWhite) {
                                    n(bArr, lineOffset, bitOffset, a1 - bitOffset);
                                }
                                a0 = a1;
                                bitOffset = a1;
                                isWhite = !isWhite;
                                o(7 - bits);
                                byte[] bArr4 = compData;
                                currIndex2 = currIndex5;
                                c2 = 0;
                            } else {
                                int i7 = code;
                                boolean z2 = isWhite;
                                throw new RuntimeException(i10.b("invalid.code.encountered.while.decoding.2d.group.3.compressed.data", new Object[0]));
                            }
                        }
                        c3 = c2;
                    }
                    int currIndex6 = currIndex2 + 1;
                    this.f2806b[currIndex2] = bitOffset;
                    this.f2809e = currIndex6;
                    int a02 = currIndex6;
                } else {
                    e(bArr, lineOffset, i2);
                }
                lineOffset += scanlineStride;
                lines++;
                byte[] bArr5 = compData;
                z = false;
            }
            return;
        }
        int i8 = height;
        throw new RuntimeException(i10.b("first.scanline.must.be.1d.encoded", new Object[0]));
    }

    public void f(byte[] buffer, byte[] compData, int startX, int height, long tiffT6Options) {
        int[] b2;
        int[] b3;
        boolean exit;
        int code;
        int bitOffset;
        boolean isWhite;
        byte[] bArr = buffer;
        this.f2803a = compData;
        this.g = 4;
        int entry = 0;
        this.f2800a = 0;
        this.f2805b = 0;
        int i2 = this.f2807c;
        int scanlineStride = (i2 + 7) / 8;
        int[] b4 = new int[2];
        this.h = (int) ((tiffT6Options & 2) >> 1);
        int[] cce = this.f2806b;
        this.f2809e = 0;
        int i3 = 0 + 1;
        this.f2809e = i3;
        cce[0] = i2;
        this.f2809e = i3 + 1;
        cce[i3] = i2;
        int lineOffset = 0;
        int lines = 0;
        while (lines < height) {
            int a0 = -1;
            boolean isWhite2 = true;
            int[] temp = this.f2804a;
            this.f2804a = this.f2806b;
            this.f2806b = temp;
            int[] cce2 = temp;
            int currIndex = 0;
            this.f = entry;
            int bitOffset2 = startX;
            while (true) {
                if (bitOffset2 < this.f2807c) {
                    if (this.f2805b >= this.f2803a.length) {
                        b3 = b2;
                        entry = 0;
                        break;
                    }
                    h(a0, isWhite2, b2);
                    int b1 = b2[0];
                    int b22 = b2[1];
                    int i4 = c[i(7)] & 255;
                    int[] b5 = b2;
                    int code2 = (i4 & 120) >>> 3;
                    int bits = i4 & 7;
                    if (code2 == 0) {
                        if (!isWhite2) {
                            n(bArr, lineOffset, bitOffset2, b22 - bitOffset2);
                        }
                        a0 = b22;
                        bitOffset2 = b22;
                        o(7 - bits);
                        byte[] bArr2 = compData;
                        b2 = b5;
                        entry = 0;
                    } else if (code2 == 1) {
                        o(7 - bits);
                        if (isWhite2) {
                            int bitOffset3 = bitOffset2 + g();
                            int currIndex2 = currIndex + 1;
                            cce2[currIndex] = bitOffset3;
                            int number = d();
                            n(bArr, lineOffset, bitOffset3, number);
                            bitOffset2 = bitOffset3 + number;
                            currIndex = currIndex2 + 1;
                            cce2[currIndex2] = bitOffset2;
                        } else {
                            int number2 = d();
                            n(bArr, lineOffset, bitOffset2, number2);
                            int bitOffset4 = bitOffset2 + number2;
                            int currIndex3 = currIndex + 1;
                            cce2[currIndex] = bitOffset4;
                            bitOffset2 = bitOffset4 + g();
                            currIndex = currIndex3 + 1;
                            cce2[currIndex3] = bitOffset2;
                        }
                        a0 = bitOffset2;
                        byte[] bArr3 = compData;
                        b2 = b5;
                        entry = 0;
                    } else if (code2 <= 8) {
                        int a1 = b1 + (code2 - 5);
                        int currIndex4 = currIndex + 1;
                        cce2[currIndex] = a1;
                        if (!isWhite2) {
                            n(bArr, lineOffset, bitOffset2, a1 - bitOffset2);
                        }
                        a0 = a1;
                        bitOffset2 = a1;
                        isWhite2 = !isWhite2;
                        o(7 - bits);
                        byte[] bArr4 = compData;
                        b2 = b5;
                        currIndex = currIndex4;
                        entry = 0;
                    } else if (code2 == 11) {
                        int i5 = i4;
                        if (i(3) == 7) {
                            int zeros = 0;
                            boolean exit2 = false;
                            while (!exit2) {
                                while (true) {
                                    exit = exit2;
                                    code = code2;
                                    if (i(1) == 1) {
                                        break;
                                    }
                                    zeros++;
                                    exit2 = exit;
                                    code2 = code;
                                }
                                if (zeros > 5) {
                                    zeros -= 6;
                                    if (!isWhite2 && zeros > 0) {
                                        cce2[currIndex] = bitOffset2;
                                        currIndex++;
                                    }
                                    bitOffset2 += zeros;
                                    if (zeros > 0) {
                                        isWhite2 = true;
                                    }
                                    if (i(1) == 0) {
                                        if (!isWhite2) {
                                            cce2[currIndex] = bitOffset2;
                                            currIndex++;
                                        }
                                        isWhite2 = true;
                                    } else {
                                        if (isWhite2) {
                                            cce2[currIndex] = bitOffset2;
                                            currIndex++;
                                        }
                                        isWhite2 = false;
                                    }
                                    exit = true;
                                }
                                if (zeros == 5) {
                                    if (!isWhite2) {
                                        cce2[currIndex] = bitOffset2;
                                        currIndex++;
                                    }
                                    bitOffset = bitOffset2 + zeros;
                                    isWhite = true;
                                    exit2 = exit;
                                    code2 = code;
                                } else {
                                    int bitOffset5 = bitOffset2 + zeros;
                                    cce2[currIndex] = bitOffset5;
                                    n(bArr, lineOffset, bitOffset5, 1);
                                    bitOffset = bitOffset5 + 1;
                                    isWhite = false;
                                    currIndex++;
                                    exit2 = exit;
                                    code2 = code;
                                }
                            }
                            int i6 = code2;
                            byte[] bArr5 = compData;
                            b2 = b5;
                            entry = 0;
                        } else {
                            throw new ru(i10.b("invalid.code.encountered.while.decoding.2d.group.4.compressed.data", new Object[0]));
                        }
                    } else {
                        int entry2 = i4;
                        int i7 = code2;
                        entry = 0;
                        bitOffset2 = this.f2807c;
                        o(7 - bits);
                        byte[] bArr6 = compData;
                        b2 = b5;
                    }
                } else {
                    b3 = b2;
                    break;
                }
            }
            if (currIndex < cce2.length) {
                cce2[currIndex] = bitOffset2;
                currIndex++;
            }
            this.f2809e = currIndex;
            lineOffset += scanlineStride;
            lines++;
            byte[] bArr7 = compData;
            b4 = b3;
        }
    }

    private void n(byte[] buffer, int lineOffset, int bitOffset, int numBits) {
        int bitNum = (lineOffset * 8) + bitOffset;
        int lastBit = bitNum + numBits;
        int byteNum = bitNum >> 3;
        int shift = bitNum & 7;
        if (shift > 0) {
            int maskVal = 1 << (7 - shift);
            byte val = buffer[byteNum];
            while (maskVal > 0 && bitNum < lastBit) {
                val = (byte) (val | maskVal);
                maskVal >>= 1;
                bitNum++;
            }
            buffer[byteNum] = val;
        }
        int byteNum2 = bitNum >> 3;
        while (bitNum < lastBit - 7) {
            buffer[byteNum2] = -1;
            bitNum += 8;
            byteNum2++;
        }
        while (bitNum < lastBit) {
            int byteNum3 = bitNum >> 3;
            if (!this.f2802a || byteNum3 < buffer.length) {
                buffer[byteNum3] = (byte) (buffer[byteNum3] | (1 << (7 - (bitNum & 7))));
            }
            bitNum++;
        }
    }

    private int g() {
        int runLength = 0;
        boolean isWhite = true;
        while (isWhite) {
            int current = j(10);
            short entry = a[current];
            int isT = entry & 1;
            int bits = (entry >>> 1) & 15;
            if (bits == 12) {
                short entry2 = f2796b[(12 & (current << 2)) | i(2)];
                runLength += (entry2 >>> 4) & 4095;
                o(4 - ((entry2 >>> 1) & 7));
            } else if (bits == 0) {
                throw new ru(i10.b("invalid.code.encountered", new Object[0]));
            } else if (bits != 15) {
                runLength += (entry >>> 5) & 2047;
                o(10 - bits);
                if (isT == 0) {
                    isWhite = false;
                }
            } else if (runLength == 0) {
                isWhite = false;
            } else {
                throw new RuntimeException(i10.b("eol.code.word.encountered.in.white.run", new Object[0]));
            }
        }
        return runLength;
    }

    private int d() {
        int runLength = 0;
        boolean isWhite = false;
        while (!isWhite) {
            short entry = f2798c[i(4)];
            short s = entry & 1;
            int bits = (entry >>> 1) & 15;
            int code = (entry >>> 5) & 2047;
            if (code == 100) {
                short entry2 = e[j(9)];
                int isT = entry2 & 1;
                int bits2 = (entry2 >>> 1) & 15;
                int code2 = (entry2 >>> 5) & 2047;
                if (bits2 == 12) {
                    o(5);
                    short entry3 = f2796b[i(4)];
                    runLength += (entry3 >>> 4) & 4095;
                    o(4 - ((entry3 >>> 1) & 7));
                } else if (bits2 != 15) {
                    runLength += code2;
                    o(9 - bits2);
                    if (isT == 0) {
                        isWhite = true;
                    }
                } else {
                    throw new RuntimeException(i10.b("eol.code.word.encountered.in.black.run", new Object[0]));
                }
            } else if (code == 200) {
                short entry4 = f2799d[i(2)];
                runLength += (entry4 >>> 5) & 2047;
                o(2 - ((entry4 >>> 1) & 15));
                isWhite = true;
            } else {
                runLength += code;
                o(4 - bits);
                isWhite = true;
            }
        }
        return runLength;
    }

    private int k(boolean isFirstEOL) {
        int n;
        int next12Bits = this.i;
        if (next12Bits == 0) {
            int next12Bits2 = j(12);
            if (isFirstEOL && next12Bits2 == 0 && j(4) == 1) {
                this.i = 1;
                return 1;
            } else if (next12Bits2 != 1) {
                throw new RuntimeException(i10.b("scanline.must.begin.with.eol.code.word", new Object[0]));
            }
        } else if (next12Bits == 1) {
            int bitsLeft = 8 - this.f2800a;
            if (j(bitsLeft) != 0) {
                throw new RuntimeException(i10.b("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            } else if (bitsLeft >= 4 || j(8) == 0) {
                do {
                    int j2 = j(8);
                    n = j2;
                    if (j2 != 1) {
                    }
                } while (n == 0);
                throw new RuntimeException(i10.b("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            } else {
                throw new RuntimeException(i10.b("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            }
        }
        if (this.j == 0) {
            return 1;
        }
        return i(1);
    }

    private void h(int a0, boolean isWhite, int[] ret) {
        int start;
        int[] pce = this.f2804a;
        int ces = this.f2809e;
        int i2 = this.f;
        int start2 = i2 > 0 ? i2 - 1 : 0;
        if (isWhite) {
            start = start2 & -2;
        } else {
            start = start2 | 1;
        }
        int i3 = start;
        while (true) {
            if (i3 >= ces) {
                break;
            }
            int temp = pce[i3];
            if (temp > a0) {
                this.f = i3;
                ret[0] = temp;
                break;
            }
            i3 += 2;
        }
        if (i3 + 1 < ces) {
            ret[1] = pce[i3 + 1];
        }
    }

    private int j(int bitsToGet) {
        byte b2;
        byte b3;
        byte next;
        byte[] bArr = this.f2803a;
        int l = bArr.length - 1;
        int bp = this.f2805b;
        long j2 = this.f2801a;
        if (j2 == 1) {
            b3 = bArr[bp];
            if (bp == l) {
                next = 0;
                b2 = 0;
            } else if (bp + 1 == l) {
                next = bArr[bp + 1];
                b2 = 0;
            } else {
                byte b4 = bArr[bp + 1];
                b2 = bArr[bp + 2];
                next = b4;
            }
        } else if (j2 == 2) {
            byte[] bArr2 = b;
            byte b5 = bArr2[bArr[bp] & 255];
            if (bp == l) {
                next = 0;
                byte b6 = b5;
                b2 = 0;
                b3 = b6;
            } else if (bp + 1 == l) {
                next = bArr2[bArr[bp + 1] & 255];
                byte b7 = b5;
                b2 = 0;
                b3 = b7;
            } else {
                byte next2 = bArr2[bArr[bp + 1] & 255];
                byte b8 = bArr2[bArr[bp + 2] & 255];
                b3 = b5;
                b2 = b8;
                next = next2;
            }
        } else {
            throw new RuntimeException(i10.b("tiff.fill.order.tag.must.be.either.1.or.2", new Object[0]));
        }
        int bitsLeft = 8 - this.f2800a;
        int bitsFromNextByte = bitsToGet - bitsLeft;
        int bitsFromNext2NextByte = 0;
        if (bitsFromNextByte > 8) {
            bitsFromNext2NextByte = bitsFromNextByte - 8;
            bitsFromNextByte = 8;
        }
        int i2 = this.f2805b + 1;
        this.f2805b = i2;
        int i1 = (f2797c[bitsLeft] & b3) << (bitsToGet - bitsLeft);
        int[] iArr = d;
        int i22 = (iArr[bitsFromNextByte] & next) >>> (8 - bitsFromNextByte);
        if (bitsFromNext2NextByte != 0) {
            i22 = (i22 << bitsFromNext2NextByte) | ((iArr[bitsFromNext2NextByte] & b2) >>> (8 - bitsFromNext2NextByte));
            this.f2805b = i2 + 1;
            this.f2800a = bitsFromNext2NextByte;
        } else if (bitsFromNextByte == 8) {
            this.f2800a = 0;
            this.f2805b = i2 + 1;
        } else {
            this.f2800a = bitsFromNextByte;
        }
        return i1 | i22;
    }

    private int i(int bitsToGet) {
        byte b2 = 0;
        byte next = 0;
        byte[] bArr = this.f2803a;
        int l = bArr.length - 1;
        int bp = this.f2805b;
        long j2 = this.f2801a;
        if (j2 == 1) {
            b2 = bArr[bp];
            if (bp == l) {
                next = 0;
            } else {
                next = bArr[bp + 1];
            }
        } else if (j2 != 2) {
            throw new RuntimeException(i10.b("tiff.fill.order.tag.must.be.either.1.or.2", new Object[0]));
        } else if (!this.f2802a || bp < bArr.length) {
            byte[] bArr2 = b;
            b2 = bArr2[bArr[bp] & 255];
            if (bp == l) {
                next = 0;
            } else {
                next = bArr2[bArr[bp + 1] & 255];
            }
        }
        int i2 = this.f2800a;
        int bitsLeft = 8 - i2;
        int bitsFromNextByte = bitsToGet - bitsLeft;
        int shift = bitsLeft - bitsToGet;
        if (shift >= 0) {
            int i1 = (f2797c[bitsLeft] & b2) >>> shift;
            int i3 = i2 + bitsToGet;
            this.f2800a = i3;
            if (i3 != 8) {
                return i1;
            }
            this.f2800a = 0;
            this.f2805b++;
            return i1;
        }
        int i12 = ((f2797c[bitsLeft] & b2) << (-shift)) | ((d[bitsFromNextByte] & next) >>> (8 - bitsFromNextByte));
        this.f2805b++;
        this.f2800a = bitsFromNextByte;
        return i12;
    }

    private void o(int bitsToMoveBack) {
        int i2 = this.f2800a - bitsToMoveBack;
        if (i2 < 0) {
            this.f2805b--;
            this.f2800a = i2 + 8;
            return;
        }
        this.f2800a = i2;
    }

    private boolean a() {
        if (this.f2800a != 0) {
            this.f2805b++;
            this.f2800a = 0;
        }
        return true;
    }

    public void m(boolean recoverFromImageError) {
        this.f2802a = recoverFromImageError;
    }
}
