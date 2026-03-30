package defpackage;

import org.apache.http.HttpStatus;

/* renamed from: b7  reason: default package */
public class b7 {
    private static byte[] c = {8, 7, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static byte[] d = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8};
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private w6 f199a = new w6(1024);

    /* renamed from: a  reason: collision with other field name */
    private byte[] f200a;

    /* renamed from: a  reason: collision with other field name */
    private int[] f201a = {3, 1, 0};

    /* renamed from: a  reason: collision with other field name */
    private int[][] f202a = {new int[]{8, 53, 0}, new int[]{6, 7, 1}, new int[]{4, 7, 2}, new int[]{4, 8, 3}, new int[]{4, 11, 4}, new int[]{4, 12, 5}, new int[]{4, 14, 6}, new int[]{4, 15, 7}, new int[]{5, 19, 8}, new int[]{5, 20, 9}, new int[]{5, 7, 10}, new int[]{5, 8, 11}, new int[]{6, 8, 12}, new int[]{6, 3, 13}, new int[]{6, 52, 14}, new int[]{6, 53, 15}, new int[]{6, 42, 16}, new int[]{6, 43, 17}, new int[]{7, 39, 18}, new int[]{7, 12, 19}, new int[]{7, 8, 20}, new int[]{7, 23, 21}, new int[]{7, 3, 22}, new int[]{7, 4, 23}, new int[]{7, 40, 24}, new int[]{7, 43, 25}, new int[]{7, 19, 26}, new int[]{7, 36, 27}, new int[]{7, 24, 28}, new int[]{8, 2, 29}, new int[]{8, 3, 30}, new int[]{8, 26, 31}, new int[]{8, 27, 32}, new int[]{8, 18, 33}, new int[]{8, 19, 34}, new int[]{8, 20, 35}, new int[]{8, 21, 36}, new int[]{8, 22, 37}, new int[]{8, 23, 38}, new int[]{8, 40, 39}, new int[]{8, 41, 40}, new int[]{8, 42, 41}, new int[]{8, 43, 42}, new int[]{8, 44, 43}, new int[]{8, 45, 44}, new int[]{8, 4, 45}, new int[]{8, 5, 46}, new int[]{8, 10, 47}, new int[]{8, 11, 48}, new int[]{8, 82, 49}, new int[]{8, 83, 50}, new int[]{8, 84, 51}, new int[]{8, 85, 52}, new int[]{8, 36, 53}, new int[]{8, 37, 54}, new int[]{8, 88, 55}, new int[]{8, 89, 56}, new int[]{8, 90, 57}, new int[]{8, 91, 58}, new int[]{8, 74, 59}, new int[]{8, 75, 60}, new int[]{8, 50, 61}, new int[]{8, 51, 62}, new int[]{8, 52, 63}, new int[]{5, 27, 64}, new int[]{5, 18, 128}, new int[]{6, 23, 192}, new int[]{7, 55, 256}, new int[]{8, 54, 320}, new int[]{8, 55, 384}, new int[]{8, 100, 448}, new int[]{8, 101, 512}, new int[]{8, 104, 576}, new int[]{8, 103, 640}, new int[]{9, HttpStatus.SC_NO_CONTENT, 704}, new int[]{9, HttpStatus.SC_RESET_CONTENT, 768}, new int[]{9, 210, 832}, new int[]{9, 211, 896}, new int[]{9, 212, 960}, new int[]{9, 213, 1024}, new int[]{9, 214, 1088}, new int[]{9, 215, 1152}, new int[]{9, 216, 1216}, new int[]{9, 217, 1280}, new int[]{9, 218, 1344}, new int[]{9, 219, 1408}, new int[]{9, 152, 1472}, new int[]{9, 153, 1536}, new int[]{9, 154, 1600}, new int[]{6, 24, 1664}, new int[]{9, 155, 1728}, new int[]{11, 8, 1792}, new int[]{11, 12, 1856}, new int[]{11, 13, 1920}, new int[]{12, 18, 1984}, new int[]{12, 19, 2048}, new int[]{12, 20, 2112}, new int[]{12, 21, 2176}, new int[]{12, 22, 2240}, new int[]{12, 23, 2304}, new int[]{12, 28, 2368}, new int[]{12, 29, 2432}, new int[]{12, 30, 2496}, new int[]{12, 31, 2560}, new int[]{12, 1, -1}, new int[]{9, 1, -2}, new int[]{10, 1, -2}, new int[]{11, 1, -2}, new int[]{12, 0, -2}};
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f203b;

    /* renamed from: b  reason: collision with other field name */
    private int[] f204b = {4, 1, 0};

    /* renamed from: b  reason: collision with other field name */
    private int[][] f205b = {new int[]{10, 55, 0}, new int[]{3, 2, 1}, new int[]{2, 3, 2}, new int[]{2, 2, 3}, new int[]{3, 3, 4}, new int[]{4, 3, 5}, new int[]{4, 2, 6}, new int[]{5, 3, 7}, new int[]{6, 5, 8}, new int[]{6, 4, 9}, new int[]{7, 4, 10}, new int[]{7, 5, 11}, new int[]{7, 7, 12}, new int[]{8, 4, 13}, new int[]{8, 7, 14}, new int[]{9, 24, 15}, new int[]{10, 23, 16}, new int[]{10, 24, 17}, new int[]{10, 8, 18}, new int[]{11, 103, 19}, new int[]{11, 104, 20}, new int[]{11, 108, 21}, new int[]{11, 55, 22}, new int[]{11, 40, 23}, new int[]{11, 23, 24}, new int[]{11, 24, 25}, new int[]{12, HttpStatus.SC_ACCEPTED, 26}, new int[]{12, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 27}, new int[]{12, HttpStatus.SC_NO_CONTENT, 28}, new int[]{12, HttpStatus.SC_RESET_CONTENT, 29}, new int[]{12, 104, 30}, new int[]{12, 105, 31}, new int[]{12, 106, 32}, new int[]{12, 107, 33}, new int[]{12, 210, 34}, new int[]{12, 211, 35}, new int[]{12, 212, 36}, new int[]{12, 213, 37}, new int[]{12, 214, 38}, new int[]{12, 215, 39}, new int[]{12, 108, 40}, new int[]{12, 109, 41}, new int[]{12, 218, 42}, new int[]{12, 219, 43}, new int[]{12, 84, 44}, new int[]{12, 85, 45}, new int[]{12, 86, 46}, new int[]{12, 87, 47}, new int[]{12, 100, 48}, new int[]{12, 101, 49}, new int[]{12, 82, 50}, new int[]{12, 83, 51}, new int[]{12, 36, 52}, new int[]{12, 55, 53}, new int[]{12, 56, 54}, new int[]{12, 39, 55}, new int[]{12, 40, 56}, new int[]{12, 88, 57}, new int[]{12, 89, 58}, new int[]{12, 43, 59}, new int[]{12, 44, 60}, new int[]{12, 90, 61}, new int[]{12, 102, 62}, new int[]{12, 103, 63}, new int[]{10, 15, 64}, new int[]{12, 200, 128}, new int[]{12, HttpStatus.SC_CREATED, 192}, new int[]{12, 91, 256}, new int[]{12, 51, 320}, new int[]{12, 52, 384}, new int[]{12, 53, 448}, new int[]{13, 108, 512}, new int[]{13, 109, 576}, new int[]{13, 74, 640}, new int[]{13, 75, 704}, new int[]{13, 76, 768}, new int[]{13, 77, 832}, new int[]{13, 114, 896}, new int[]{13, 115, 960}, new int[]{13, 116, 1024}, new int[]{13, 117, 1088}, new int[]{13, 118, 1152}, new int[]{13, 119, 1216}, new int[]{13, 82, 1280}, new int[]{13, 83, 1344}, new int[]{13, 84, 1408}, new int[]{13, 85, 1472}, new int[]{13, 90, 1536}, new int[]{13, 91, 1600}, new int[]{13, 100, 1664}, new int[]{13, 101, 1728}, new int[]{11, 8, 1792}, new int[]{11, 12, 1856}, new int[]{11, 13, 1920}, new int[]{12, 18, 1984}, new int[]{12, 19, 2048}, new int[]{12, 20, 2112}, new int[]{12, 21, 2176}, new int[]{12, 22, 2240}, new int[]{12, 23, 2304}, new int[]{12, 28, 2368}, new int[]{12, 29, 2432}, new int[]{12, 30, 2496}, new int[]{12, 31, 2560}, new int[]{12, 1, -1}, new int[]{9, 1, -2}, new int[]{10, 1, -2}, new int[]{11, 1, -2}, new int[]{12, 0, -2}};

    /* renamed from: c  reason: collision with other field name */
    private int f206c = 8;

    /* renamed from: c  reason: collision with other field name */
    private int[] f207c = {0, 1, 3, 7, 15, 31, 63, 127, 255};

    /* renamed from: c  reason: collision with other field name */
    private int[][] f208c = {new int[]{7, 3, 0}, new int[]{6, 3, 0}, new int[]{3, 3, 0}, new int[]{1, 1, 0}, new int[]{3, 2, 0}, new int[]{6, 2, 0}, new int[]{7, 2, 0}};

    /* renamed from: d  reason: collision with other field name */
    private int f209d;
    private int e;
    private int f;

    public b7(int width) {
        int i = width;
        this.b = i;
        int i2 = (i + 7) / 8;
        this.a = i2;
        this.f200a = new byte[i2];
    }

    public void f(byte[] data, int offset, int size) {
        this.f203b = data;
        this.e = offset;
        this.f = size;
        while (this.f > 0) {
            a();
            System.arraycopy(this.f203b, this.e, this.f200a, 0, this.a);
            int i = this.e;
            int i2 = this.a;
            this.e = i + i2;
            this.f -= i2;
        }
    }

    public static byte[] d(byte[] data, int width, int height) {
        b7 g4 = new b7(width);
        g4.f(data, 0, g4.a * height);
        return g4.c();
    }

    public void e(byte[] data, int height) {
        f(data, 0, this.a * height);
    }

    private void m(int[] table) {
        l(table[1], table[0]);
    }

    private void n(int span, int[][] tab) {
        while (span >= 2624) {
            int[] te = tab[103];
            l(te[1], te[0]);
            span -= te[2];
        }
        if (span >= 64) {
            int[] te2 = tab[(span >> 6) + 63];
            l(te2[1], te2[0]);
            span -= te2[2];
        }
        l(tab[span][1], tab[span][0]);
    }

    private void l(int bits, int length) {
        int i;
        while (true) {
            i = this.f206c;
            if (length <= i) {
                break;
            }
            int i2 = this.f209d | (bits >> (length - i));
            this.f209d = i2;
            length -= i;
            this.f199a.c((byte) i2);
            this.f209d = 0;
            this.f206c = 8;
        }
        int i3 = this.f209d | ((this.f207c[length] & bits) << (i - length));
        this.f209d = i3;
        int i4 = i - length;
        this.f206c = i4;
        if (i4 == 0) {
            this.f199a.c((byte) i3);
            this.f209d = 0;
            this.f206c = 8;
        }
    }

    private void a() {
        int a0 = 0;
        int a1 = k(this.f203b, this.e, 0) != 0 ? 0 : i(this.f203b, this.e, 0, this.b, 0);
        int b1 = k(this.f200a, 0, 0) != 0 ? 0 : i(this.f200a, 0, 0, this.b, 0);
        while (true) {
            byte[] bArr = this.f200a;
            int b2 = j(bArr, 0, b1, this.b, k(bArr, 0, b1));
            if (b2 >= a1) {
                int d2 = b1 - a1;
                if (-3 > d2 || d2 > 3) {
                    byte[] bArr2 = this.f203b;
                    int i = this.e;
                    int a2 = j(bArr2, i, a1, this.b, k(bArr2, i, a1));
                    m(this.f201a);
                    if (a0 + a1 == 0 || k(this.f203b, this.e, a0) == 0) {
                        n(a1 - a0, this.f202a);
                        n(a2 - a1, this.f205b);
                    } else {
                        n(a1 - a0, this.f205b);
                        n(a2 - a1, this.f202a);
                    }
                    a0 = a2;
                } else {
                    m(this.f208c[d2 + 3]);
                    a0 = a1;
                }
            } else {
                m(this.f204b);
                a0 = b2;
            }
            int i2 = this.b;
            if (a0 < i2) {
                byte[] bArr3 = this.f203b;
                int i3 = this.e;
                a1 = i(bArr3, i3, a0, i2, k(bArr3, i3, a0));
                b1 = i(this.f200a, 0, i(this.f200a, 0, a0, this.b, k(this.f203b, this.e, a0) ^ 1), this.b, k(this.f203b, this.e, a0));
            } else {
                return;
            }
        }
    }

    private void b() {
        l(1, 12);
        l(1, 12);
        if (this.f206c != 8) {
            this.f199a.c((byte) this.f209d);
            this.f209d = 0;
            this.f206c = 8;
        }
    }

    public byte[] c() {
        b();
        return this.f199a.c0();
    }

    private int k(byte[] data, int offset, int bit) {
        if (bit >= this.b) {
            return 0;
        }
        return ((data[(bit >> 3) + offset] & 255) >> (7 - (bit & 7))) & 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int h(byte[] r6, int r7, int r8, int r9) {
        /*
            int r0 = r9 - r8
            int r1 = r8 >> 3
            int r1 = r1 + r7
            r2 = 8
            if (r0 <= 0) goto L_0x0029
            r3 = r8 & 7
            r4 = r3
            if (r3 == 0) goto L_0x0029
            byte[] r3 = d
            byte r5 = r6[r1]
            int r5 = r5 << r4
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r3 = r3[r5]
            int r5 = 8 - r4
            if (r3 <= r5) goto L_0x001d
            int r3 = 8 - r4
        L_0x001d:
            if (r3 <= r0) goto L_0x0020
            r3 = r0
        L_0x0020:
            int r5 = r4 + r3
            if (r5 >= r2) goto L_0x0025
            return r3
        L_0x0025:
            int r0 = r0 - r3
            int r1 = r1 + 1
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            if (r0 < r2) goto L_0x0042
            byte r4 = r6[r1]
            r5 = -1
            if (r4 == r5) goto L_0x003b
            byte[] r2 = d
            byte r4 = r6[r1]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r2 = r2[r4]
            int r2 = r2 + r3
            return r2
        L_0x003b:
            int r3 = r3 + 8
            int r0 = r0 + -8
            int r1 = r1 + 1
            goto L_0x002a
        L_0x0042:
            if (r0 <= 0) goto L_0x0052
            byte[] r2 = d
            byte r4 = r6[r1]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r2 = r2[r4]
            if (r2 <= r0) goto L_0x0050
            r4 = r0
            goto L_0x0051
        L_0x0050:
            r4 = r2
        L_0x0051:
            int r3 = r3 + r4
        L_0x0052:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b7.h(byte[], int, int, int):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int g(byte[] r6, int r7, int r8, int r9) {
        /*
            int r0 = r9 - r8
            int r1 = r8 >> 3
            int r1 = r1 + r7
            r2 = 8
            if (r0 <= 0) goto L_0x0029
            r3 = r8 & 7
            r4 = r3
            if (r3 == 0) goto L_0x0029
            byte[] r3 = c
            byte r5 = r6[r1]
            int r5 = r5 << r4
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r3 = r3[r5]
            int r5 = 8 - r4
            if (r3 <= r5) goto L_0x001d
            int r3 = 8 - r4
        L_0x001d:
            if (r3 <= r0) goto L_0x0020
            r3 = r0
        L_0x0020:
            int r5 = r4 + r3
            if (r5 >= r2) goto L_0x0025
            return r3
        L_0x0025:
            int r0 = r0 - r3
            int r1 = r1 + 1
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            if (r0 < r2) goto L_0x0041
            byte r4 = r6[r1]
            if (r4 == 0) goto L_0x003a
            byte[] r2 = c
            byte r4 = r6[r1]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r2 = r2[r4]
            int r2 = r2 + r3
            return r2
        L_0x003a:
            int r3 = r3 + 8
            int r0 = r0 + -8
            int r1 = r1 + 1
            goto L_0x002a
        L_0x0041:
            if (r0 <= 0) goto L_0x0051
            byte[] r2 = c
            byte r4 = r6[r1]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r2 = r2[r4]
            if (r2 <= r0) goto L_0x004f
            r4 = r0
            goto L_0x0050
        L_0x004f:
            r4 = r2
        L_0x0050:
            int r3 = r3 + r4
        L_0x0051:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b7.g(byte[], int, int, int):int");
    }

    private static int i(byte[] bp, int offset, int bs, int be, int color) {
        return (color != 0 ? h(bp, offset, bs, be) : g(bp, offset, bs, be)) + bs;
    }

    private static int j(byte[] bp, int offset, int bs, int be, int color) {
        return bs < be ? i(bp, offset, bs, be, color) : be;
    }
}
