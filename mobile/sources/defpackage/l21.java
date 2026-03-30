package defpackage;

import java.util.Map;

/* renamed from: l21  reason: default package */
final class l21<K, V> extends d21<K, V> {
    static final d21<Object, Object> a = new l21((Object) null, new Object[0], 0);

    /* renamed from: a  reason: collision with other field name */
    private final transient int f4192a;

    /* renamed from: a  reason: collision with other field name */
    private final transient Object f4193a;

    /* renamed from: a  reason: collision with other field name */
    private final transient Object[] f4194a;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: byte[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        r2[r6] = (byte) r3;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c6, code lost:
        r2[r6] = (short) r3;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ff, code lost:
        r2[r7] = r4;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <K, V> defpackage.l21<K, V> f(int r10, java.lang.Object[] r11) {
        /*
            if (r10 != 0) goto L_0x0007
            d21<java.lang.Object, java.lang.Object> r10 = a
            l21 r10 = (defpackage.l21) r10
            return r10
        L_0x0007:
            r0 = 0
            r1 = 0
            r2 = 1
            if (r10 != r2) goto L_0x0019
            r10 = r11[r1]
            r1 = r11[r2]
            defpackage.s11.a(r10, r1)
            l21 r10 = new l21
            r10.<init>(r0, r11, r2)
            return r10
        L_0x0019:
            int r3 = r11.length
            int r3 = r3 >> r2
            defpackage.t01.e(r10, r3)
            r3 = 2
            int r3 = java.lang.Math.max(r10, r3)
            r4 = 751619276(0x2ccccccc, float:5.8207657E-12)
            r5 = 1073741824(0x40000000, float:2.0)
            if (r3 >= r4) goto L_0x0044
            int r4 = r3 + -1
            int r4 = java.lang.Integer.highestOneBit(r4)
            int r4 = r4 << r2
            r5 = r4
        L_0x0033:
            double r6 = (double) r5
            r8 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            double r6 = r6 * r8
            double r8 = (double) r3
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x0043
            int r5 = r5 << 1
            goto L_0x0033
        L_0x0043:
            goto L_0x004c
        L_0x0044:
            if (r3 >= r5) goto L_0x0048
            r3 = 1
            goto L_0x0049
        L_0x0048:
            r3 = 0
        L_0x0049:
            if (r3 == 0) goto L_0x011d
        L_0x004c:
            if (r10 != r2) goto L_0x0059
            r1 = r11[r1]
            r2 = r11[r2]
            defpackage.s11.a(r1, r2)
            goto L_0x0116
        L_0x0059:
            int r0 = r5 + -1
            r2 = 128(0x80, float:1.794E-43)
            r3 = -1
            if (r5 > r2) goto L_0x009d
            byte[] r2 = new byte[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x0066:
            if (r1 >= r10) goto L_0x009a
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            defpackage.s11.a(r4, r5)
            int r6 = r4.hashCode()
            int r6 = defpackage.r11.a(r6)
        L_0x007b:
            r6 = r6 & r0
            byte r7 = r2[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x008a
            byte r3 = (byte) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x0066
        L_0x008a:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0095
            int r6 = r6 + 1
            goto L_0x007b
        L_0x0095:
            java.lang.IllegalArgumentException r10 = e(r4, r5, r11, r7)
            throw r10
        L_0x009a:
            r0 = r2
            goto L_0x0116
        L_0x009d:
            r2 = 32768(0x8000, float:4.5918E-41)
            if (r5 > r2) goto L_0x00df
            short[] r2 = new short[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x00a8:
            if (r1 >= r10) goto L_0x00dd
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            defpackage.s11.a(r4, r5)
            int r6 = r4.hashCode()
            int r6 = defpackage.r11.a(r6)
        L_0x00bd:
            r6 = r6 & r0
            short r7 = r2[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x00cd
            short r3 = (short) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x00a8
        L_0x00cd:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00d8
            int r6 = r6 + 1
            goto L_0x00bd
        L_0x00d8:
            java.lang.IllegalArgumentException r10 = e(r4, r5, r11, r7)
            throw r10
        L_0x00dd:
            r0 = r2
            goto L_0x0116
        L_0x00df:
            int[] r2 = new int[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x00e5:
            if (r1 >= r10) goto L_0x0115
            int r4 = r1 * 2
            r5 = r11[r4]
            r6 = r4 ^ 1
            r6 = r11[r6]
            defpackage.s11.a(r5, r6)
            int r7 = r5.hashCode()
            int r7 = defpackage.r11.a(r7)
        L_0x00fa:
            r7 = r7 & r0
            r8 = r2[r7]
            if (r8 != r3) goto L_0x0105
            r2[r7] = r4
            int r1 = r1 + 1
            goto L_0x00e5
        L_0x0105:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x0110
            int r7 = r7 + 1
            goto L_0x00fa
        L_0x0110:
            java.lang.IllegalArgumentException r10 = e(r5, r6, r11, r8)
            throw r10
        L_0x0115:
            r0 = r2
        L_0x0116:
            l21 r1 = new l21
            r1.<init>(r0, r11, r10)
            return r1
        L_0x011d:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "collection too large"
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l21.f(int, java.lang.Object[]):l21");
    }

    private static IllegalArgumentException e(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private l21(Object obj, Object[] objArr, int i) {
        this.f4193a = obj;
        this.f4194a = objArr;
        this.f4192a = i;
    }

    public final int size() {
        return this.f4192a;
    }

    public final V get(Object obj) {
        Object obj2 = this.f4193a;
        V[] vArr = this.f4194a;
        int i = this.f4192a;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int a2 = r11.a(obj.hashCode());
                while (true) {
                    int i2 = a2 & length;
                    byte b = bArr[i2] & 255;
                    if (b == 255) {
                        return null;
                    }
                    if (vArr[b].equals(obj)) {
                        return vArr[b ^ 1];
                    }
                    a2 = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int a3 = r11.a(obj.hashCode());
                while (true) {
                    int i3 = a3 & length2;
                    short s = sArr[i3] & 65535;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    a3 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int a4 = r11.a(obj.hashCode());
                while (true) {
                    int i4 = a4 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    a4 = i4 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final h21<Map.Entry<K, V>> b() {
        return new j21(this, this.f4194a, 0, this.f4192a);
    }

    /* access modifiers changed from: package-private */
    public final h21<K> c() {
        return new n21(this, new r21(this.f4194a, 0, this.f4192a));
    }

    /* access modifiers changed from: package-private */
    public final v11<V> d() {
        return new r21(this.f4194a, 1, this.f4192a);
    }
}
