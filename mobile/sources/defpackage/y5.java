package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: y5  reason: default package */
public abstract class y5 {
    protected static final HashMap<String, h70> a;

    /* renamed from: a  reason: collision with other field name */
    protected static ConcurrentHashMap<String, y5> f5818a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static final double[] f5819a = {0.001d, 0.0d, 0.0d, 0.001d, 0.0d, 0.0d};
    public static final int[] b = {0, 383, 8192, 8303, 8352, 8399, 64256, 64262};
    public static final int[] c = {0, 127, 1536, 1663, 8352, 8399, 64336, 64511, 65136, 65279};
    public static final int[] d = {0, 127, 1424, 1535, 8352, 8399, 64285, 64335};
    public static final int[] e = {0, 127, 1024, 1327, 8192, 8303, 8352, 8399};

    /* renamed from: a  reason: collision with other field name */
    int f5820a;

    /* renamed from: a  reason: collision with other field name */
    protected String f5821a;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<int[]> f5822a;

    /* renamed from: a  reason: collision with other field name */
    protected ys f5823a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f5824a;

    /* renamed from: a  reason: collision with other field name */
    protected char[] f5825a = new char[256];

    /* renamed from: a  reason: collision with other field name */
    protected int[] f5826a = new int[256];

    /* renamed from: a  reason: collision with other field name */
    protected String[] f5827a = new String[256];

    /* renamed from: a  reason: collision with other field name */
    protected int[][] f5828a = new int[256][];

    /* renamed from: b  reason: collision with other field name */
    protected int f5829b = -1;

    /* renamed from: b  reason: collision with other field name */
    protected boolean f5830b = true;

    /* renamed from: c  reason: collision with other field name */
    protected boolean f5831c = false;

    /* renamed from: d  reason: collision with other field name */
    protected boolean f5832d = false;

    /* renamed from: e  reason: collision with other field name */
    protected boolean f5833e = true;
    protected boolean f = false;
    protected boolean g = false;

    /* access modifiers changed from: package-private */
    public abstract void E(v80 v80, z60 z60, Object[] objArr);

    public abstract String[][] k();

    public abstract float l(int i, float f2);

    public abstract int n(int i, int i2);

    public abstract String o();

    /* access modifiers changed from: protected */
    public abstract int[] p(int i, String str);

    /* access modifiers changed from: package-private */
    public abstract int q(int i, String str);

    public abstract boolean y();

    static {
        HashMap<String, h70> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("Courier", h70.H1);
        hashMap.put("Courier-Bold", h70.I1);
        hashMap.put("Courier-BoldOblique", h70.K1);
        hashMap.put("Courier-Oblique", h70.J1);
        hashMap.put("Helvetica", h70.a5);
        hashMap.put("Helvetica-Bold", h70.b5);
        hashMap.put("Helvetica-BoldOblique", h70.d5);
        hashMap.put("Helvetica-Oblique", h70.c5);
        hashMap.put("Symbol", h70.yb);
        hashMap.put("Times-Roman", h70.Vb);
        hashMap.put("Times-Bold", h70.Wb);
        hashMap.put("Times-BoldItalic", h70.Yb);
        hashMap.put("Times-Italic", h70.Xb);
        hashMap.put("ZapfDingbats", h70.Zd);
    }

    /* renamed from: y5$a */
    static class a extends m80 {
        public a(byte[] contents, int[] lengths, int compressionLevel) {
            try {
                this.f4495a = contents;
                Q(h70.m6, new k70(contents.length));
                for (int k = 0; k < lengths.length; k++) {
                    Q(new h70("Length" + (k + 1)), new k70(lengths[k]));
                }
                T(compressionLevel);
            } catch (Exception e) {
                throw new ih(e);
            }
        }

        public a(byte[] contents, String subType, int compressionLevel) {
            try {
                this.f4495a = contents;
                Q(h70.m6, new k70(contents.length));
                if (subType != null) {
                    Q(h70.tb, new h70(subType));
                }
                T(compressionLevel);
            } catch (Exception e) {
                throw new ih(e);
            }
        }
    }

    protected y5() {
    }

    public static y5 d(String name, String encoding, boolean embedded) {
        return f(name, encoding, embedded, true, (byte[]) null, (byte[]) null, false);
    }

    public static y5 e(String name, String encoding, boolean embedded, boolean cached, byte[] ttfAfm, byte[] pfb) {
        return f(name, encoding, embedded, cached, ttfAfm, pfb, false);
    }

    public static y5 f(String name, String encoding, boolean embedded, boolean cached, byte[] ttfAfm, byte[] pfb, boolean noThrow) {
        return g(name, encoding, embedded, cached, ttfAfm, pfb, noThrow, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.y5 g(java.lang.String r17, java.lang.String r18, boolean r19, boolean r20, byte[] r21, byte[] r22, boolean r23, boolean r24) {
        /*
            r7 = r17
            java.lang.String r8 = i(r17)
            java.lang.String r9 = C(r18)
            java.util.HashMap<java.lang.String, h70> r0 = a
            boolean r10 = r0.containsKey(r7)
            r0 = 0
            if (r10 == 0) goto L_0x0015
            r1 = 0
            goto L_0x0019
        L_0x0015:
            boolean r1 = defpackage.e7.P(r8, r9)
        L_0x0019:
            r11 = r1
            java.lang.String r1 = "Identity-V"
            java.lang.String r2 = "Identity-H"
            if (r10 != 0) goto L_0x0036
            if (r11 == 0) goto L_0x0023
            goto L_0x0036
        L_0x0023:
            boolean r3 = r9.equals(r2)
            if (r3 != 0) goto L_0x0033
            boolean r3 = r9.equals(r1)
            if (r3 == 0) goto L_0x0030
            goto L_0x0033
        L_0x0030:
            r12 = r19
            goto L_0x0038
        L_0x0033:
            r3 = 1
            r12 = r3
            goto L_0x0038
        L_0x0036:
            r3 = 0
            r12 = r3
        L_0x0038:
            r3 = 0
            r13 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            java.lang.String r5 = "\n"
            r4.append(r5)
            r4.append(r9)
            r4.append(r5)
            r4.append(r12)
            java.lang.String r14 = r4.toString()
            if (r20 == 0) goto L_0x0064
            java.util.concurrent.ConcurrentHashMap<java.lang.String, y5> r4 = f5818a
            java.lang.Object r4 = r4.get(r14)
            r3 = r4
            y5 r3 = (defpackage.y5) r3
            if (r3 == 0) goto L_0x0062
            return r3
        L_0x0062:
            r15 = r3
            goto L_0x0065
        L_0x0064:
            r15 = r3
        L_0x0065:
            java.lang.String r6 = "Cp1252"
            if (r10 != 0) goto L_0x00fe
            java.lang.String r3 = r17.toLowerCase()
            java.lang.String r4 = ".afm"
            boolean r3 = r3.endsWith(r4)
            if (r3 != 0) goto L_0x00fe
            java.lang.String r3 = r17.toLowerCase()
            java.lang.String r4 = ".pfm"
            boolean r3 = r3.endsWith(r4)
            if (r3 == 0) goto L_0x0084
            r7 = r6
            goto L_0x00ff
        L_0x0084:
            java.lang.String r3 = r8.toLowerCase()
            java.lang.String r4 = ".ttf"
            boolean r3 = r3.endsWith(r4)
            if (r3 != 0) goto L_0x00ca
            java.lang.String r3 = r8.toLowerCase()
            java.lang.String r4 = ".otf"
            boolean r3 = r3.endsWith(r4)
            if (r3 != 0) goto L_0x00ca
            java.lang.String r3 = r8.toLowerCase()
            java.lang.String r4 = ".ttc,"
            int r3 = r3.indexOf(r4)
            if (r3 <= 0) goto L_0x00a9
            goto L_0x00ca
        L_0x00a9:
            if (r11 == 0) goto L_0x00b2
            e7 r0 = new e7
            r0.<init>(r7, r9, r12)
            goto L_0x0116
        L_0x00b2:
            if (r23 == 0) goto L_0x00b6
            r0 = 0
            return r0
        L_0x00b6:
            ih r1 = new ih
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r0] = r7
            r0 = 1
            r2[r0] = r9
            java.lang.String r0 = "font.1.with.2.is.not.recognized"
            java.lang.String r0 = defpackage.i10.b(r0, r2)
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x00ca:
            boolean r0 = r9.equals(r2)
            if (r0 != 0) goto L_0x00ef
            boolean r0 = r9.equals(r1)
            if (r0 == 0) goto L_0x00d7
            goto L_0x00ef
        L_0x00d7:
            ss0 r16 = new ss0
            r5 = 0
            r0 = r16
            r1 = r17
            r2 = r9
            r3 = r12
            r4 = r21
            r7 = r6
            r6 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6)
            boolean r1 = r9.equals(r7)
            r0.f = r1
            goto L_0x0116
        L_0x00ef:
            us0 r6 = new us0
            r0 = r6
            r1 = r17
            r2 = r9
            r3 = r12
            r4 = r21
            r5 = r24
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0116
        L_0x00fe:
            r7 = r6
        L_0x00ff:
            xs0 r16 = new xs0
            r0 = r16
            r1 = r17
            r2 = r9
            r3 = r12
            r4 = r21
            r5 = r22
            r6 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6)
            boolean r1 = r9.equals(r7)
            r0.f = r1
        L_0x0116:
            if (r20 == 0) goto L_0x0129
            java.util.concurrent.ConcurrentHashMap<java.lang.String, y5> r1 = f5818a
            java.lang.Object r1 = r1.get(r14)
            r15 = r1
            y5 r15 = (defpackage.y5) r15
            if (r15 == 0) goto L_0x0124
            return r15
        L_0x0124:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, y5> r1 = f5818a
            r1.putIfAbsent(r14, r0)
        L_0x0129:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y5.g(java.lang.String, java.lang.String, boolean, boolean, byte[], byte[], boolean, boolean):y5");
    }

    public boolean B() {
        return this.g;
    }

    protected static String i(String name) {
        if (name.endsWith(",Bold")) {
            return name.substring(0, name.length() - 5);
        }
        if (name.endsWith(",Italic")) {
            return name.substring(0, name.length() - 7);
        }
        if (name.endsWith(",BoldItalic")) {
            return name.substring(0, name.length() - 11);
        }
        return name;
    }

    protected static String C(String enc) {
        if (enc.equals("winansi") || enc.equals("")) {
            return "Cp1252";
        }
        if (enc.equals("macroman")) {
            return "MacRoman";
        }
        return enc;
    }

    /* access modifiers changed from: protected */
    public void c() {
        char c2;
        int orderK;
        if (this.f5821a.startsWith("#")) {
            this.f5823a = new ys();
            StringTokenizer tok = new StringTokenizer(this.f5821a.substring(1), " ,\t\n\r\f");
            if (tok.nextToken().equals("full")) {
                while (tok.hasMoreTokens()) {
                    String order = tok.nextToken();
                    String name = tok.nextToken();
                    char uni = (char) Integer.parseInt(tok.nextToken(), 16);
                    if (order.startsWith("'")) {
                        orderK = order.charAt(1);
                    } else {
                        orderK = Integer.parseInt(order);
                    }
                    int orderK2 = orderK % 256;
                    this.f5823a.d(uni, orderK2);
                    this.f5827a[orderK2] = name;
                    this.f5825a[orderK2] = uni;
                    this.f5826a[orderK2] = q(uni, name);
                    this.f5828a[orderK2] = p(uni, name);
                }
            } else {
                int k = 0;
                if (tok.hasMoreTokens()) {
                    k = Integer.parseInt(tok.nextToken());
                }
                while (tok.hasMoreTokens() && k < 256) {
                    int uni2 = Integer.parseInt(tok.nextToken(), 16) % 65536;
                    String name2 = mp.b(uni2);
                    if (name2 != null) {
                        this.f5823a.d(uni2, k);
                        this.f5827a[k] = name2;
                        this.f5825a[k] = (char) uni2;
                        this.f5826a[k] = q(uni2, name2);
                        this.f5828a[k] = p(uni2, name2);
                        k++;
                    }
                }
            }
            for (int k2 = 0; k2 < 256; k2++) {
                String[] strArr = this.f5827a;
                if (strArr[k2] == null) {
                    strArr[k2] = ".notdef";
                }
            }
        } else if (this.f5830b) {
            for (int k3 = 0; k3 < 256; k3++) {
                this.f5826a[k3] = q(k3, (String) null);
                this.f5828a[k3] = p(k3, (String) null);
            }
        } else {
            byte[] b2 = new byte[1];
            for (int k4 = 0; k4 < 256; k4++) {
                b2[0] = (byte) k4;
                String s = n60.d(b2, this.f5821a);
                if (s.length() > 0) {
                    c2 = s.charAt(0);
                } else {
                    c2 = '?';
                }
                String name3 = mp.b(c2);
                if (name3 == null) {
                    name3 = ".notdef";
                }
                this.f5827a[k4] = name3;
                this.f5825a[k4] = c2;
                this.f5826a[k4] = q(c2, name3);
                this.f5828a[k4] = p(c2, name3);
            }
        }
    }

    public int t(int char1) {
        if (!this.f) {
            int total = 0;
            byte[] mbytes = a(char1);
            for (byte b2 : mbytes) {
                total += this.f5826a[b2 & 255];
            }
            return total;
        } else if (char1 < 128 || (char1 >= 160 && char1 <= 255)) {
            return this.f5826a[char1];
        } else {
            return this.f5826a[n60.f4399a.b(char1)];
        }
    }

    public int u(String text) {
        int i;
        int total = 0;
        if (this.f) {
            int len = text.length();
            for (int k = 0; k < len; k++) {
                char char1 = text.charAt(k);
                if (char1 < 128 || (char1 >= 160 && char1 <= 255)) {
                    i = this.f5826a[char1];
                } else {
                    i = this.f5826a[n60.f4399a.b(char1)];
                }
                total += i;
            }
            return total;
        }
        byte[] mbytes = b(text);
        for (byte b2 : mbytes) {
            total += this.f5826a[b2 & 255];
        }
        return total;
    }

    public float x(String text, float fontSize) {
        float size = ((float) u(text)) * 0.001f * fontSize;
        if (!y()) {
            return size;
        }
        int len = text.length() - 1;
        int kern = 0;
        char[] c2 = text.toCharArray();
        for (int k = 0; k < len; k++) {
            kern += n(c2[k], c2[k + 1]);
        }
        return (((float) kern) * 0.001f * fontSize) + size;
    }

    public float w(String text, float fontSize) {
        return ((float) u(text)) * 0.001f * fontSize;
    }

    public float v(int char1, float fontSize) {
        return ((float) t(char1)) * 0.001f * fontSize;
    }

    public byte[] b(String text) {
        if (this.f5832d) {
            return n60.c(text, (String) null);
        }
        if (this.f5823a == null) {
            return n60.c(text, this.f5821a);
        }
        byte[] b2 = new byte[text.length()];
        int ptr = 0;
        int length = text.length();
        for (int k = 0; k < length; k++) {
            char c2 = text.charAt(k);
            if (this.f5823a.a(c2)) {
                b2[ptr] = (byte) this.f5823a.b(c2);
                ptr++;
            }
        }
        if (ptr >= length) {
            return b2;
        }
        byte[] b22 = new byte[ptr];
        System.arraycopy(b2, 0, b22, 0, ptr);
        return b22;
    }

    /* access modifiers changed from: package-private */
    public byte[] a(int char1) {
        if (this.f5832d) {
            return n60.b((char) char1, (String) null);
        }
        ys ysVar = this.f5823a;
        if (ysVar == null) {
            return n60.b((char) char1, this.f5821a);
        }
        if (!ysVar.a(char1)) {
            return new byte[0];
        }
        return new byte[]{(byte) this.f5823a.b(char1)};
    }

    public String j() {
        return this.f5821a;
    }

    public int m() {
        return this.f5820a;
    }

    public boolean z() {
        return this.f5824a;
    }

    public boolean A() {
        return this.f5830b;
    }

    public static String h() {
        StringBuilder s = new StringBuilder("");
        for (int k = 0; k < 6; k++) {
            s.append((char) ((int) ((Math.random() * 26.0d) + 65.0d)));
        }
        return s + "+";
    }

    /* access modifiers changed from: package-private */
    public char r(int index) {
        return this.f5825a[index];
    }

    public void D(boolean subset) {
        this.f5833e = subset;
    }

    public int s(int c2) {
        return c2;
    }
}
