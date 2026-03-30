package defpackage;

import com.itextpdf.text.pdf.CFFFont;
import defpackage.c7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: d7  reason: default package */
public class d7 extends c7 {
    static final String[] c = {"RESERVED_0", "hstem", "RESERVED_2", "vstem", "vmoveto", "rlineto", "hlineto", "vlineto", "rrcurveto", "RESERVED_9", "callsubr", "return", "escape", "RESERVED_13", "endchar", "RESERVED_15", "RESERVED_16", "RESERVED_17", "hstemhm", "hintmask", "cntrmask", "rmoveto", "hmoveto", "vstemhm", "rcurveline", "rlinecurve", "vvcurveto", "hhcurveto", "shortint", "callgsubr", "vhcurveto", "hvcurveto"};
    static final String[] d = {"RESERVED_0", "RESERVED_1", "RESERVED_2", "and", "or", "not", "RESERVED_6", "RESERVED_7", "RESERVED_8", "abs", "add", "sub", "div", "RESERVED_13", "neg", "eq", "RESERVED_16", "RESERVED_17", "drop", "RESERVED_19", "put", "get", "ifelse", "random", "mul", "RESERVED_25", "sqrt", "dup", "exch", "index", "roll", "RESERVED_31", "RESERVED_32", "RESERVED_33", "hflex", "flex", "hflex1", "flex1", "RESERVED_REST"};
    ArrayList<Integer> a;

    /* renamed from: a  reason: collision with other field name */
    HashMap<Integer, int[]> f2732a;

    /* renamed from: a  reason: collision with other field name */
    HashSet<Integer> f2733a = new HashSet<>();

    /* renamed from: a  reason: collision with other field name */
    LinkedList<c7.g> f2734a;

    /* renamed from: a  reason: collision with other field name */
    byte[] f2735a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<Integer>[] f2736a;

    /* renamed from: a  reason: collision with other field name */
    HashMap<Integer, int[]>[] f2737a;

    /* renamed from: a  reason: collision with other field name */
    byte[][] f2738a;
    ArrayList<Integer> b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    HashMap<Integer, int[]> f2739b = new HashMap<>();

    /* renamed from: b  reason: collision with other field name */
    byte[] f2740b;

    /* renamed from: c  reason: collision with other field name */
    ArrayList<Integer> f2741c = new ArrayList<>();

    /* renamed from: c  reason: collision with other field name */
    HashMap<Integer, int[]> f2742c = new HashMap<>();

    /* renamed from: c  reason: collision with other field name */
    byte[] f2743c;
    int h = 0;
    int i = 0;

    public d7(cd0 rf, HashMap<Integer, int[]> GlyphsUsed) {
        super(rf);
        this.f2732a = GlyphsUsed;
        this.a = new ArrayList<>(GlyphsUsed.keySet());
        int i2 = 0;
        while (true) {
            c7.c[] cVarArr = this.f294a;
            if (i2 < cVarArr.length) {
                l(cVarArr[i2].d);
                this.f294a[i2].i = a();
                l(this.f);
                this.f294a[i2].j = a() + c7.b.length;
                c7.c[] cVarArr2 = this.f294a;
                cVarArr2[i2].f307c = e(cVarArr2[i2].d);
                if (this.f294a[i2].h >= 0) {
                    X(i2);
                    n(i2);
                }
                if (this.f294a[i2].f302a) {
                    R(i2);
                }
                c7.c[] cVarArr3 = this.f294a;
                cVarArr3[i2].k = B(cVarArr3[i2].f, cVarArr3[i2].i);
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int B(int Offset, int NumofGlyphs) {
        l(Offset);
        switch (b()) {
            case 0:
                return (NumofGlyphs * 2) + 1;
            case 1:
                return (C(NumofGlyphs, 1) * 3) + 1;
            case 2:
                return (C(NumofGlyphs, 2) * 4) + 1;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public int C(int NumofGlyphs, int Type) {
        int nLeft;
        int num = 0;
        int i2 = 1;
        while (i2 < NumofGlyphs) {
            num++;
            char a2 = a();
            if (Type == 1) {
                nLeft = b();
            } else {
                nLeft = a();
            }
            i2 += nLeft + 1;
        }
        return num;
    }

    /* access modifiers changed from: protected */
    public void X(int Font) {
        c7.c[] cVarArr = this.f294a;
        int NumOfGlyphs = cVarArr[Font].i;
        int[] FDSelect = new int[NumOfGlyphs];
        l(cVarArr[Font].h);
        this.f294a[Font].m = b();
        switch (this.f294a[Font].m) {
            case 0:
                for (int i2 = 0; i2 < NumOfGlyphs; i2++) {
                    FDSelect[i2] = b();
                }
                c7.c[] cVarArr2 = this.f294a;
                cVarArr2[Font].l = cVarArr2[Font].i + 1;
                break;
            case 3:
                int nRanges = a();
                int l = 0;
                int first = a();
                for (int i3 = 0; i3 < nRanges; i3++) {
                    int fd = b();
                    int last = a();
                    int steps = last - first;
                    for (int k = 0; k < steps; k++) {
                        FDSelect[l] = fd;
                        l++;
                    }
                    first = last;
                }
                this.f294a[Font].l = (nRanges * 3) + 3 + 2;
                break;
        }
        this.f294a[Font].f308d = FDSelect;
    }

    /* access modifiers changed from: protected */
    public void n(int Font) {
        int[] FDSelect = this.f294a[Font].f308d;
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.f2733a.add(Integer.valueOf(FDSelect[this.a.get(i2).intValue()]));
        }
    }

    /* access modifiers changed from: protected */
    public void R(int Font) {
        l(this.f294a[Font].g);
        this.f294a[Font].o = a();
        this.f294a[Font].p = b();
        c7.c[] cVarArr = this.f294a;
        if (cVarArr[Font].p < 4) {
            cVarArr[Font].p++;
        }
        cVarArr[Font].f309e = e(cVarArr[Font].g);
    }

    public byte[] N(String fontName) {
        try {
            this.f291a.d();
            int j = 0;
            while (true) {
                c7.c[] cVarArr = this.f294a;
                if (j >= cVarArr.length) {
                    break;
                } else if (fontName.equals(cVarArr[j].f301a)) {
                    break;
                } else {
                    j++;
                }
            }
            if (j == this.f294a.length) {
                return null;
            }
            int i2 = this.g;
            if (i2 >= 0) {
                this.h = x(i2, j);
            }
            r(j);
            v(j);
            byte[] Ret = s(j);
            try {
                this.f291a.close();
            } catch (Exception e) {
            }
            return Ret;
        } finally {
            try {
                this.f291a.close();
            } catch (Exception e2) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public int x(int Offset, int Font) {
        l(Offset);
        int nSubrs = a();
        if (this.f294a[Font].n == 1) {
            return 0;
        }
        if (nSubrs < 1240) {
            return 107;
        }
        if (nSubrs < 33900) {
            return 1131;
        }
        return 32768;
    }

    /* access modifiers changed from: protected */
    public void r(int FontIndex) {
        this.f2743c = t(this.f294a[FontIndex].f307c, this.f2732a, (byte) 14);
    }

    /* access modifiers changed from: protected */
    public void v(int Font) {
        c7.c[] cVarArr = this.f294a;
        if (cVarArr[Font].f302a) {
            this.f2737a = new HashMap[cVarArr[Font].f303a.length];
            this.f2736a = new ArrayList[cVarArr[Font].f303a.length];
            this.f2738a = new byte[cVarArr[Font].f303a.length][];
            cVarArr[Font].f310f = new int[cVarArr[Font].f303a.length];
            cVarArr[Font].f304a = new int[cVarArr[Font].f303a.length][];
            ArrayList<Integer> FDInList = new ArrayList<>(this.f2733a);
            for (int j = 0; j < FDInList.size(); j++) {
                int FD = FDInList.get(j).intValue();
                this.f2737a[FD] = new HashMap<>();
                this.f2736a[FD] = new ArrayList<>();
                o(Font, FD);
                c7.c[] cVarArr2 = this.f294a;
                if (cVarArr2[Font].f310f[FD] >= 0) {
                    w(Font, FD, cVarArr2[Font].f310f[FD], cVarArr2[Font].f304a[FD], this.f2737a[FD], this.f2736a[FD]);
                    this.f2738a[FD] = t(this.f294a[Font].f304a[FD], this.f2737a[FD], (byte) 11);
                }
            }
        } else if (cVarArr[Font].c >= 0) {
            cVarArr[Font].f311g = e(cVarArr[Font].c);
            c7.c[] cVarArr3 = this.f294a;
            w(Font, -1, cVarArr3[Font].c, cVarArr3[Font].f311g, this.f2742c, this.f2741c);
        }
        p(Font);
        c7.c[] cVarArr4 = this.f294a;
        if (cVarArr4[Font].c >= 0) {
            this.f2735a = t(cVarArr4[Font].f311g, this.f2742c, (byte) 11);
        }
        this.f2740b = u(this.f299d, (byte) 11);
    }

    /* access modifiers changed from: protected */
    public void o(int Font, int FD) {
        c7.c[] cVarArr;
        c7.c[] cVarArr2 = this.f294a;
        cVarArr2[Font].f310f[FD] = -1;
        l(cVarArr2[Font].f303a[FD]);
        while (true) {
            int i2 = i();
            cVarArr = this.f294a;
            if (i2 >= cVarArr[Font].f303a[FD] + cVarArr[Font].f306b[FD]) {
                break;
            }
            c();
            if (this.f292a == "Subrs") {
                this.f294a[Font].f310f[FD] = ((Integer) this.f295a[0]).intValue() + this.f294a[Font].f303a[FD];
            }
        }
        if (cVarArr[Font].f310f[FD] >= 0) {
            cVarArr[Font].f304a[FD] = e(cVarArr[Font].f310f[FD]);
        }
    }

    /* access modifiers changed from: protected */
    public void w(int Font, int FD, int SubrOffset, int[] SubrsOffsets, HashMap<Integer, int[]> hSubr, ArrayList<Integer> lSubr) {
        int i2 = Font;
        int i3 = FD;
        int[] iArr = SubrsOffsets;
        int LBias = x(SubrOffset, i2);
        for (int i4 = 0; i4 < this.a.size(); i4++) {
            int glyph = this.a.get(i4).intValue();
            c7.c[] cVarArr = this.f294a;
            int Start = cVarArr[i2].f307c[glyph];
            int End = cVarArr[i2].f307c[glyph + 1];
            if (i3 >= 0) {
                K();
                this.i = 0;
                int GlyphFD = this.f294a[i2].f308d[glyph];
                if (GlyphFD == i3) {
                    int i5 = GlyphFD;
                    P(Start, End, this.h, LBias, hSubr, lSubr, SubrsOffsets);
                }
            } else {
                P(Start, End, this.h, LBias, hSubr, lSubr, SubrsOffsets);
            }
        }
        for (int i6 = 0; i6 < lSubr.size(); i6++) {
            int Subr = lSubr.get(i6).intValue();
            if (Subr >= iArr.length - 1 || Subr < 0) {
            } else {
                int i7 = Subr;
                P(iArr[Subr], iArr[Subr + 1], this.h, LBias, hSubr, lSubr, SubrsOffsets);
            }
        }
        ArrayList<Integer> arrayList = lSubr;
    }

    /* access modifiers changed from: protected */
    public void p(int Font) {
        int LBias;
        int j;
        int i2 = Font;
        int SizeOfNonCIDSubrsUsed = 0;
        c7.c[] cVarArr = this.f294a;
        if (cVarArr[i2].c >= 0) {
            int LBias2 = x(cVarArr[i2].c, i2);
            SizeOfNonCIDSubrsUsed = this.f2741c.size();
            LBias = LBias2;
        } else {
            LBias = 0;
        }
        int SizeOfNonCIDSubrsUsed2 = SizeOfNonCIDSubrsUsed;
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            int Subr = this.b.get(i3).intValue();
            int[] iArr = this.f299d;
            if (Subr < iArr.length - 1 && Subr >= 0) {
                int Start = iArr[Subr];
                int End = iArr[Subr + 1];
                c7.c[] cVarArr2 = this.f294a;
                if (cVarArr2[i2].f302a) {
                    P(Start, End, this.h, 0, this.f2739b, this.b, (int[]) null);
                } else {
                    P(Start, End, this.h, LBias, this.f2742c, this.f2741c, cVarArr2[i2].f311g);
                    if (SizeOfNonCIDSubrsUsed2 < this.f2741c.size()) {
                        int j2 = SizeOfNonCIDSubrsUsed2;
                        while (j2 < this.f2741c.size()) {
                            int LSubr = this.f2741c.get(j2).intValue();
                            c7.c[] cVarArr3 = this.f294a;
                            if (LSubr >= cVarArr3[i2].f311g.length - 1 || LSubr < 0) {
                                j = j2;
                            } else {
                                int i4 = LSubr;
                                j = j2;
                                P(cVarArr3[i2].f311g[LSubr], cVarArr3[i2].f311g[LSubr + 1], this.h, LBias, this.f2742c, this.f2741c, cVarArr3[i2].f311g);
                            }
                            j2 = j + 1;
                        }
                        int i5 = j2;
                        SizeOfNonCIDSubrsUsed2 = this.f2741c.size();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.Integer} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void P(int r15, int r16, int r17, int r18, java.util.HashMap<java.lang.Integer, int[]> r19, java.util.ArrayList<java.lang.Integer> r20, int[] r21) {
        /*
            r14 = this;
            r6 = r14
            r7 = r19
            r14.K()
            r0 = 0
            r6.i = r0
            r14.l(r15)
        L_0x000c:
            int r0 = r14.i()
            r8 = r16
            if (r0 >= r8) goto L_0x00f7
            r14.Q()
            int r9 = r14.i()
            r0 = 0
            int r1 = r6.f296b
            if (r1 <= 0) goto L_0x0028
            java.lang.Object[] r2 = r6.f295a
            int r1 = r1 + -1
            r0 = r2[r1]
            r10 = r0
            goto L_0x0029
        L_0x0028:
            r10 = r0
        L_0x0029:
            int r11 = r6.f296b
            r14.L()
            java.lang.String r0 = r6.f292a
            r1 = 0
            java.lang.String r2 = "callsubr"
            if (r0 != r2) goto L_0x0076
            if (r11 <= 0) goto L_0x0072
            r0 = r10
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r12 = r0 + r18
            java.lang.Integer r0 = java.lang.Integer.valueOf(r12)
            boolean r0 = r7.containsKey(r0)
            if (r0 != 0) goto L_0x005b
            java.lang.Integer r0 = java.lang.Integer.valueOf(r12)
            r7.put(r0, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r12)
            r13 = r20
            r13.add(r0)
            goto L_0x005d
        L_0x005b:
            r13 = r20
        L_0x005d:
            r1 = r21[r12]
            int r0 = r12 + 1
            r2 = r21[r0]
            r0 = r14
            r3 = r18
            r4 = r17
            r5 = r21
            r0.y(r1, r2, r3, r4, r5)
            r14.l(r9)
            goto L_0x00f5
        L_0x0072:
            r13 = r20
            goto L_0x00f5
        L_0x0076:
            r13 = r20
            java.lang.String r2 = "callgsubr"
            if (r0 != r2) goto L_0x00bb
            if (r11 <= 0) goto L_0x00f5
            r0 = r10
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r12 = r0 + r17
            java.util.HashMap<java.lang.Integer, int[]> r0 = r6.f2739b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            boolean r0 = r0.containsKey(r2)
            if (r0 != 0) goto L_0x00a5
            java.util.HashMap<java.lang.Integer, int[]> r0 = r6.f2739b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            r0.put(r2, r1)
            java.util.ArrayList<java.lang.Integer> r0 = r6.b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            r0.add(r1)
        L_0x00a5:
            int[] r0 = r6.f299d
            r1 = r0[r12]
            int r2 = r12 + 1
            r2 = r0[r2]
            r0 = r14
            r3 = r18
            r4 = r17
            r5 = r21
            r0.y(r1, r2, r3, r4, r5)
            r14.l(r9)
            goto L_0x00f5
        L_0x00bb:
            java.lang.String r1 = "hstem"
            if (r0 == r1) goto L_0x00ee
            java.lang.String r1 = "vstem"
            if (r0 == r1) goto L_0x00ee
            java.lang.String r1 = "hstemhm"
            if (r0 == r1) goto L_0x00ee
            java.lang.String r1 = "vstemhm"
            if (r0 != r1) goto L_0x00cc
            goto L_0x00ee
        L_0x00cc:
            java.lang.String r1 = "hintmask"
            if (r0 == r1) goto L_0x00d4
            java.lang.String r1 = "cntrmask"
            if (r0 != r1) goto L_0x00f5
        L_0x00d4:
            int r0 = r6.i
            int r1 = r11 / 2
            int r0 = r0 + r1
            r6.i = r0
            int r1 = r0 / 8
            int r0 = r0 % 8
            if (r0 != 0) goto L_0x00e3
            if (r1 != 0) goto L_0x00e5
        L_0x00e3:
            int r1 = r1 + 1
        L_0x00e5:
            r0 = 0
        L_0x00e6:
            if (r0 >= r1) goto L_0x00f5
            r14.b()
            int r0 = r0 + 1
            goto L_0x00e6
        L_0x00ee:
            int r0 = r6.i
            int r1 = r11 / 2
            int r0 = r0 + r1
            r6.i = r0
        L_0x00f5:
            goto L_0x000c
        L_0x00f7:
            r13 = r20
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d7.P(int, int, int, int, java.util.HashMap, java.util.ArrayList, int[]):void");
    }

    /* access modifiers changed from: protected */
    public void L() {
        int StackHandel = W();
        if (StackHandel >= 2) {
            K();
        } else if (StackHandel == 1) {
            O();
        } else {
            int StackHandel2 = StackHandel * -1;
            for (int i2 = 0; i2 < StackHandel2; i2++) {
                M();
            }
        }
    }

    /* access modifiers changed from: protected */
    public int W() {
        String str = this.f292a;
        if (str == "ifelse") {
            return -3;
        }
        if (str == "roll" || str == "put") {
            return -2;
        }
        if (str == "callsubr" || str == "callgsubr" || str == "add" || str == "sub" || str == "div" || str == "mul" || str == "drop" || str == "and" || str == "or" || str == "eq") {
            return -1;
        }
        if (str == "abs" || str == "neg" || str == "sqrt" || str == "exch" || str == "index" || str == "get" || str == "not" || str == "return") {
            return 0;
        }
        if (str == "random" || str == "dup") {
            return 1;
        }
        return 2;
    }

    /* access modifiers changed from: protected */
    public void K() {
        for (int i2 = 0; i2 < this.f296b; i2++) {
            this.f295a[i2] = null;
        }
        this.f296b = 0;
    }

    /* access modifiers changed from: protected */
    public void M() {
        int i2 = this.f296b;
        if (i2 > 0) {
            this.f295a[i2 - 1] = null;
            this.f296b = i2 - 1;
        }
    }

    /* access modifiers changed from: protected */
    public void O() {
        this.f296b++;
    }

    /* access modifiers changed from: protected */
    public void Q() {
        this.f292a = null;
        boolean gotKey = false;
        while (!gotKey) {
            char b0 = b();
            if (b0 == 28) {
                this.f295a[this.f296b] = Integer.valueOf((b() << 8) | b());
                this.f296b++;
            } else if (b0 >= ' ' && b0 <= 246) {
                this.f295a[this.f296b] = Integer.valueOf(b0 - 139);
                this.f296b++;
            } else if (b0 >= 247 && b0 <= 250) {
                this.f295a[this.f296b] = Integer.valueOf(((b0 - 247) * 256) + b() + 108);
                this.f296b++;
            } else if (b0 >= 251 && b0 <= 254) {
                this.f295a[this.f296b] = Integer.valueOf((((-(b0 - 251)) * 256) - b()) - 108);
                this.f296b++;
            } else if (b0 == 255) {
                this.f295a[this.f296b] = Integer.valueOf((b() << 24) | (b() << 16) | (b() << 8) | b());
                this.f296b++;
            } else if (b0 <= 31 && b0 != 28) {
                gotKey = true;
                if (b0 == 12) {
                    int b1 = b();
                    String[] strArr = d;
                    if (b1 > strArr.length - 1) {
                        b1 = strArr.length - 1;
                    }
                    this.f292a = strArr[b1];
                } else {
                    this.f292a = c[b0];
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.Integer} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int y(int r13, int r14, int r15, int r16, int[] r17) {
        /*
            r12 = this;
            r6 = r12
            r12.l(r13)
        L_0x0004:
            int r0 = r12.i()
            r7 = r14
            if (r0 >= r7) goto L_0x00a4
            r12.Q()
            int r8 = r12.i()
            r0 = 0
            int r1 = r6.f296b
            if (r1 <= 0) goto L_0x001f
            java.lang.Object[] r2 = r6.f295a
            int r1 = r1 + -1
            r0 = r2[r1]
            r9 = r0
            goto L_0x0020
        L_0x001f:
            r9 = r0
        L_0x0020:
            int r10 = r6.f296b
            r12.L()
            java.lang.String r0 = r6.f292a
            java.lang.String r1 = "callsubr"
            if (r0 != r1) goto L_0x0049
            if (r10 <= 0) goto L_0x00a2
            r0 = r9
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r11 = r0 + r15
            r1 = r17[r11]
            int r0 = r11 + 1
            r2 = r17[r0]
            r0 = r12
            r3 = r15
            r4 = r16
            r5 = r17
            r0.y(r1, r2, r3, r4, r5)
            r12.l(r8)
            goto L_0x00a2
        L_0x0049:
            java.lang.String r1 = "callgsubr"
            if (r0 != r1) goto L_0x006d
            if (r10 <= 0) goto L_0x00a2
            r0 = r9
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r11 = r0 + r16
            int[] r0 = r6.f299d
            r1 = r0[r11]
            int r2 = r11 + 1
            r2 = r0[r2]
            r0 = r12
            r3 = r15
            r4 = r16
            r5 = r17
            r0.y(r1, r2, r3, r4, r5)
            r12.l(r8)
            goto L_0x00a2
        L_0x006d:
            java.lang.String r1 = "hstem"
            if (r0 == r1) goto L_0x009b
            java.lang.String r1 = "vstem"
            if (r0 == r1) goto L_0x009b
            java.lang.String r1 = "hstemhm"
            if (r0 == r1) goto L_0x009b
            java.lang.String r1 = "vstemhm"
            if (r0 != r1) goto L_0x007e
            goto L_0x009b
        L_0x007e:
            java.lang.String r1 = "hintmask"
            if (r0 == r1) goto L_0x0086
            java.lang.String r1 = "cntrmask"
            if (r0 != r1) goto L_0x00a2
        L_0x0086:
            int r0 = r6.i
            int r1 = r0 / 8
            int r0 = r0 % 8
            if (r0 != 0) goto L_0x0090
            if (r1 != 0) goto L_0x0092
        L_0x0090:
            int r1 = r1 + 1
        L_0x0092:
            r0 = 0
        L_0x0093:
            if (r0 >= r1) goto L_0x00a2
            r12.b()
            int r0 = r0 + 1
            goto L_0x0093
        L_0x009b:
            int r0 = r6.i
            int r1 = r10 / 2
            int r0 = r0 + r1
            r6.i = r0
        L_0x00a2:
            goto L_0x0004
        L_0x00a4:
            int r0 = r6.i
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d7.y(int, int, int, int, int[]):int");
    }

    /* access modifiers changed from: protected */
    public byte[] t(int[] Offsets, HashMap<Integer, int[]> Used, byte OperatorForUnusedEntries) {
        int unusedCount = 0;
        int Offset = 0;
        int[] NewOffsets = new int[Offsets.length];
        for (int i2 = 0; i2 < Offsets.length; i2++) {
            NewOffsets[i2] = Offset;
            if (Used.containsKey(Integer.valueOf(i2))) {
                Offset += Offsets[i2 + 1] - Offsets[i2];
            } else {
                unusedCount++;
            }
        }
        byte[] NewObjects = new byte[(Offset + unusedCount)];
        int unusedOffset = 0;
        for (int i3 = 0; i3 < Offsets.length - 1; i3++) {
            int start = NewOffsets[i3];
            int end = NewOffsets[i3 + 1];
            NewOffsets[i3] = start + unusedOffset;
            if (start != end) {
                this.f291a.n((long) Offsets[i3]);
                this.f291a.readFully(NewObjects, start + unusedOffset, end - start);
            } else {
                NewObjects[start + unusedOffset] = OperatorForUnusedEntries;
                unusedOffset++;
            }
        }
        int length = Offsets.length - 1;
        NewOffsets[length] = NewOffsets[length] + unusedOffset;
        return m(NewOffsets, NewObjects);
    }

    /* access modifiers changed from: protected */
    public byte[] u(int[] Offsets, byte OperatorForUnusedEntries) {
        int Offset = 0;
        int[] NewOffsets = new int[Offsets.length];
        for (int i2 = 0; i2 < Offsets.length - 1; i2++) {
            NewOffsets[i2] = Offset;
            Offset += Offsets[i2 + 1] - Offsets[i2];
        }
        NewOffsets[Offsets.length - 1] = Offset;
        byte[] NewObjects = new byte[(Offset + 0 + 1)];
        int unusedOffset = 0;
        for (int i3 = 0; i3 < Offsets.length - 1; i3++) {
            int start = NewOffsets[i3];
            int end = NewOffsets[i3 + 1];
            NewOffsets[i3] = start + unusedOffset;
            if (start != end) {
                this.f291a.n((long) Offsets[i3]);
                this.f291a.readFully(NewObjects, start + unusedOffset, end - start);
            } else {
                NewObjects[start + unusedOffset] = OperatorForUnusedEntries;
                unusedOffset++;
            }
        }
        int length = Offsets.length - 1;
        NewOffsets[length] = NewOffsets[length] + unusedOffset;
        return m(NewOffsets, NewObjects);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        r4[r6] = (byte) ((r10 >>> 16) & 255);
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0061, code lost:
        r4[r6] = (byte) ((r10 >>> 8) & 255);
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006a, code lost:
        r4[r6] = (byte) ((r10 >>> 0) & 255);
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
        r8 = r8 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] m(int[] r14, byte[] r15) {
        /*
            r13 = this;
            int r0 = r14.length
            int r0 = r0 + -1
            char r0 = (char) r0
            int r1 = r14.length
            int r1 = r1 + -1
            r1 = r14[r1]
            r2 = 255(0xff, float:3.57E-43)
            if (r1 >= r2) goto L_0x000f
            r3 = 1
            goto L_0x001e
        L_0x000f:
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r1 >= r3) goto L_0x0016
            r3 = 2
            goto L_0x001e
        L_0x0016:
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            if (r1 >= r3) goto L_0x001d
            r3 = 3
            goto L_0x001e
        L_0x001d:
            r3 = 4
        L_0x001e:
            int r4 = r0 + 1
            int r4 = r4 * r3
            int r4 = r4 + 3
            int r5 = r15.length
            int r4 = r4 + r5
            byte[] r4 = new byte[r4]
            r5 = 0
            int r6 = r5 + 1
            int r7 = r0 >>> 8
            r7 = r7 & r2
            byte r7 = (byte) r7
            r4[r5] = r7
            int r5 = r6 + 1
            int r7 = r0 >>> 0
            r7 = r7 & r2
            byte r7 = (byte) r7
            r4[r6] = r7
            int r6 = r5 + 1
            r4[r5] = r3
            r5 = r14
            int r7 = r5.length
            r8 = 0
        L_0x0040:
            if (r8 >= r7) goto L_0x0076
            r9 = r5[r8]
            r10 = 0
            r10 = r14[r10]
            int r10 = r9 - r10
            int r10 = r10 + 1
            switch(r3) {
                case 1: goto L_0x006a;
                case 2: goto L_0x0061;
                case 3: goto L_0x0058;
                case 4: goto L_0x004f;
                default: goto L_0x004e;
            }
        L_0x004e:
            goto L_0x0073
        L_0x004f:
            int r11 = r6 + 1
            int r12 = r10 >>> 24
            r12 = r12 & r2
            byte r12 = (byte) r12
            r4[r6] = r12
            r6 = r11
        L_0x0058:
            int r11 = r6 + 1
            int r12 = r10 >>> 16
            r12 = r12 & r2
            byte r12 = (byte) r12
            r4[r6] = r12
            r6 = r11
        L_0x0061:
            int r11 = r6 + 1
            int r12 = r10 >>> 8
            r12 = r12 & r2
            byte r12 = (byte) r12
            r4[r6] = r12
            r6 = r11
        L_0x006a:
            int r11 = r6 + 1
            int r12 = r10 >>> 0
            r12 = r12 & r2
            byte r12 = (byte) r12
            r4[r6] = r12
            r6 = r11
        L_0x0073:
            int r8 = r8 + 1
            goto L_0x0040
        L_0x0076:
            r2 = r15
            int r5 = r2.length
            r7 = 0
        L_0x0079:
            if (r7 >= r5) goto L_0x0085
            byte r8 = r2[r7]
            int r9 = r6 + 1
            r4[r6] = r8
            int r7 = r7 + 1
            r6 = r9
            goto L_0x0079
        L_0x0085:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d7.m(int[], byte[]):byte[]");
    }

    /* access modifiers changed from: protected */
    public byte[] s(int Font) {
        int i2 = Font;
        this.f2734a = new LinkedList<>();
        A();
        q(1, 1, 1);
        this.f2734a.addLast(new c7.p((char) (this.f294a[i2].f301a.length() + 1)));
        this.f2734a.addLast(new c7.k(this.f294a[i2].f301a));
        q(1, 2, 1);
        c7.i topdictIndex1Ref = new c7.f(2);
        this.f2734a.addLast(topdictIndex1Ref);
        c7.d topdictBase = new c7.d();
        this.f2734a.addLast(topdictBase);
        c7.i charsetRef = new c7.b();
        c7.i charstringsRef = new c7.b();
        c7.i fdarrayRef = new c7.b();
        c7.i fdselectRef = new c7.b();
        c7.i privateRef = new c7.b();
        c7.c[] cVarArr = this.f294a;
        if (!cVarArr[i2].f302a) {
            this.f2734a.addLast(new c7.a(cVarArr[i2].j));
            this.f2734a.addLast(new c7.a(this.f294a[i2].j + 1));
            this.f2734a.addLast(new c7.a(0));
            this.f2734a.addLast(new c7.p(12));
            this.f2734a.addLast(new c7.p(30));
            this.f2734a.addLast(new c7.a(this.f294a[i2].i));
            this.f2734a.addLast(new c7.p(12));
            this.f2734a.addLast(new c7.p('\"'));
        }
        l(this.f297b[i2]);
        while (i() < this.f297b[i2 + 1]) {
            int p1 = i();
            c();
            int p2 = i();
            String str = this.f292a;
            if (!(str == "Encoding" || str == "Private" || str == "FDSelect" || str == "FDArray" || str == "charset" || str == "CharStrings")) {
                this.f2734a.add(new c7.j(this.f291a, p1, p2 - p1));
            }
        }
        G(fdarrayRef, fdselectRef, charsetRef, charstringsRef);
        this.f2734a.addLast(new c7.e(topdictIndex1Ref, topdictBase));
        if (this.f294a[i2].f302a) {
            this.f2734a.addLast(d(this.f));
        } else {
            H(Font);
        }
        this.f2734a.addLast(new c7.j(new cd0(this.f2740b), 0, this.f2740b.length));
        c7.c[] cVarArr2 = this.f294a;
        if (cVarArr2[i2].f302a) {
            this.f2734a.addLast(new c7.h(fdselectRef));
            c7.c[] cVarArr3 = this.f294a;
            if (cVarArr3[i2].h >= 0) {
                this.f2734a.addLast(new c7.j(this.f291a, cVarArr3[i2].h, cVarArr3[i2].l));
            } else {
                F(fdselectRef, cVarArr3[i2].i);
            }
            this.f2734a.addLast(new c7.h(charsetRef));
            LinkedList<c7.g> linkedList = this.f2734a;
            cd0 cd0 = this.f291a;
            c7.c[] cVarArr4 = this.f294a;
            linkedList.addLast(new c7.j(cd0, cVarArr4[i2].f, cVarArr4[i2].k));
            if (this.f294a[i2].g >= 0) {
                this.f2734a.addLast(new c7.h(fdarrayRef));
                S(Font);
            } else {
                E(fdarrayRef, privateRef, i2);
            }
        } else {
            F(fdselectRef, cVarArr2[i2].i);
            D(charsetRef, this.f294a[i2].i);
            E(fdarrayRef, privateRef, i2);
        }
        if (this.f294a[i2].a >= 0) {
            c7.d PrivateBase = new c7.d();
            this.f2734a.addLast(PrivateBase);
            this.f2734a.addLast(new c7.h(privateRef));
            c7.i Subr = new c7.b();
            I(i2, Subr);
            J(i2, PrivateBase, Subr);
        }
        this.f2734a.addLast(new c7.h(charstringsRef));
        this.f2734a.addLast(new c7.j(new cd0(this.f2743c), 0, this.f2743c.length));
        int[] currentOffset = {0};
        Iterator<CFFFont.Item> listIter = this.f2734a.iterator();
        while (listIter.hasNext()) {
            ((c7.g) listIter.next()).b(currentOffset);
        }
        Iterator<CFFFont.Item> listIter2 = this.f2734a.iterator();
        while (listIter2.hasNext()) {
            ((c7.g) listIter2.next()).c();
        }
        byte[] b2 = new byte[currentOffset[0]];
        Iterator<CFFFont.Item> listIter3 = this.f2734a.iterator();
        while (listIter3.hasNext()) {
            ((c7.g) listIter3.next()).a(b2);
        }
        return b2;
    }

    /* access modifiers changed from: protected */
    public void A() {
        l(0);
        char b2 = b();
        char b3 = b();
        int hdrSize = b();
        char b4 = b();
        this.f290a = hdrSize;
        this.f2734a.addLast(new c7.j(this.f291a, 0, hdrSize));
    }

    /* access modifiers changed from: protected */
    public void q(int Count, int Offsize, int First) {
        this.f2734a.addLast(new c7.m((char) Count));
        this.f2734a.addLast(new c7.p((char) Offsize));
        switch (Offsize) {
            case 1:
                this.f2734a.addLast(new c7.p((char) First));
                return;
            case 2:
                this.f2734a.addLast(new c7.m((char) First));
                return;
            case 3:
                this.f2734a.addLast(new c7.n((char) First));
                return;
            case 4:
                this.f2734a.addLast(new c7.o((char) First));
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void G(c7.i fdarrayRef, c7.i fdselectRef, c7.i charsetRef, c7.i charstringsRef) {
        this.f2734a.addLast(fdarrayRef);
        this.f2734a.addLast(new c7.p(12));
        this.f2734a.addLast(new c7.p('$'));
        this.f2734a.addLast(fdselectRef);
        this.f2734a.addLast(new c7.p(12));
        this.f2734a.addLast(new c7.p('%'));
        this.f2734a.addLast(charsetRef);
        this.f2734a.addLast(new c7.p(15));
        this.f2734a.addLast(charstringsRef);
        this.f2734a.addLast(new c7.p(17));
    }

    /* access modifiers changed from: protected */
    public void H(int Font) {
        byte stringsIndexOffSize;
        String fdFontName = this.f294a[Font].f301a + "-OneRange";
        if (fdFontName.length() > 127) {
            fdFontName = fdFontName.substring(0, 127);
        }
        String extraStrings = "AdobeIdentity" + fdFontName;
        int[] iArr = this.f298c;
        int origStringsLen = iArr[iArr.length - 1] - iArr[0];
        int stringsBaseOffset = iArr[0] - 1;
        if (extraStrings.length() + origStringsLen <= 255) {
            stringsIndexOffSize = 1;
        } else if (extraStrings.length() + origStringsLen <= 65535) {
            stringsIndexOffSize = 2;
        } else if (extraStrings.length() + origStringsLen <= 16777215) {
            stringsIndexOffSize = 3;
        } else {
            stringsIndexOffSize = 4;
        }
        this.f2734a.addLast(new c7.m((char) ((this.f298c.length - 1) + 3)));
        this.f2734a.addLast(new c7.p((char) stringsIndexOffSize));
        for (int stringOffset : this.f298c) {
            this.f2734a.addLast(new c7.f(stringsIndexOffSize, stringOffset - stringsBaseOffset));
        }
        int[] arr$ = this.f298c;
        int currentStringsOffset = (arr$[arr$.length - 1] - stringsBaseOffset) + "Adobe".length();
        this.f2734a.addLast(new c7.f(stringsIndexOffSize, currentStringsOffset));
        int currentStringsOffset2 = currentStringsOffset + "Identity".length();
        this.f2734a.addLast(new c7.f(stringsIndexOffSize, currentStringsOffset2));
        this.f2734a.addLast(new c7.f(stringsIndexOffSize, currentStringsOffset2 + fdFontName.length()));
        this.f2734a.addLast(new c7.j(this.f291a, this.f298c[0], origStringsLen));
        this.f2734a.addLast(new c7.k(extraStrings));
    }

    /* access modifiers changed from: protected */
    public void F(c7.i fdselectRef, int nglyphs) {
        this.f2734a.addLast(new c7.h(fdselectRef));
        this.f2734a.addLast(new c7.p(3));
        this.f2734a.addLast(new c7.m(1));
        this.f2734a.addLast(new c7.m(0));
        this.f2734a.addLast(new c7.p(0));
        this.f2734a.addLast(new c7.m((char) nglyphs));
    }

    /* access modifiers changed from: protected */
    public void D(c7.i charsetRef, int nglyphs) {
        this.f2734a.addLast(new c7.h(charsetRef));
        this.f2734a.addLast(new c7.p(2));
        this.f2734a.addLast(new c7.m(1));
        this.f2734a.addLast(new c7.m((char) (nglyphs - 1)));
    }

    /* access modifiers changed from: protected */
    public void E(c7.i fdarrayRef, c7.i privateRef, int Font) {
        this.f2734a.addLast(new c7.h(fdarrayRef));
        q(1, 1, 1);
        c7.i privateIndex1Ref = new c7.f(1);
        this.f2734a.addLast(privateIndex1Ref);
        c7.d privateBase = new c7.d();
        this.f2734a.addLast(privateBase);
        c7.c[] cVarArr = this.f294a;
        int NewSize = cVarArr[Font].b;
        int OrgSubrsOffsetSize = z(cVarArr[Font].a, cVarArr[Font].b);
        if (OrgSubrsOffsetSize != 0) {
            NewSize += 5 - OrgSubrsOffsetSize;
        }
        this.f2734a.addLast(new c7.a(NewSize));
        this.f2734a.addLast(privateRef);
        this.f2734a.addLast(new c7.p(18));
        this.f2734a.addLast(new c7.e(privateIndex1Ref, privateBase));
    }

    /* access modifiers changed from: package-private */
    public void S(int Font) {
        c7.c[] cVarArr = this.f294a;
        c7.i[] fdPrivate = new c7.b[(cVarArr[Font].f309e.length - 1)];
        c7.d[] fdPrivateBase = new c7.d[cVarArr[Font].f303a.length];
        c7.i[] fdSubrs = new c7.b[cVarArr[Font].f303a.length];
        T(Font, fdPrivate);
        U(Font, fdPrivate, fdPrivateBase, fdSubrs);
        V(Font, fdPrivateBase, fdSubrs);
    }

    /* access modifiers changed from: package-private */
    public void T(int Font, c7.i[] fdPrivate) {
        c7.c[] cVarArr = this.f294a;
        q(cVarArr[Font].o, cVarArr[Font].p, 1);
        c7.i[] fdOffsets = new c7.f[(this.f294a[Font].f309e.length - 1)];
        int i2 = 0;
        while (true) {
            c7.c[] cVarArr2 = this.f294a;
            if (i2 >= cVarArr2[Font].f309e.length - 1) {
                break;
            }
            fdOffsets[i2] = new c7.f(cVarArr2[Font].p);
            this.f2734a.addLast(fdOffsets[i2]);
            i2++;
        }
        c7.d fdArrayBase = new c7.d();
        this.f2734a.addLast(fdArrayBase);
        int k = 0;
        while (true) {
            c7.c[] cVarArr3 = this.f294a;
            if (k < cVarArr3[Font].f309e.length - 1) {
                l(cVarArr3[Font].f309e[k]);
                while (i() < this.f294a[Font].f309e[k + 1]) {
                    int p1 = i();
                    c();
                    int p2 = i();
                    if (this.f292a == "Private") {
                        int NewSize = ((Integer) this.f295a[0]).intValue();
                        c7.c[] cVarArr4 = this.f294a;
                        int OrgSubrsOffsetSize = z(cVarArr4[Font].f303a[k], cVarArr4[Font].f306b[k]);
                        if (OrgSubrsOffsetSize != 0) {
                            NewSize += 5 - OrgSubrsOffsetSize;
                        }
                        this.f2734a.addLast(new c7.a(NewSize));
                        fdPrivate[k] = new c7.b();
                        this.f2734a.addLast(fdPrivate[k]);
                        this.f2734a.addLast(new c7.p(18));
                        l(p2);
                    } else {
                        this.f2734a.addLast(new c7.j(this.f291a, p1, p2 - p1));
                    }
                }
                this.f2734a.addLast(new c7.e(fdOffsets[k], fdArrayBase));
                k++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void U(int Font, c7.i[] fdPrivate, c7.d[] fdPrivateBase, c7.i[] fdSubrs) {
        for (int i2 = 0; i2 < this.f294a[Font].f303a.length; i2++) {
            this.f2734a.addLast(new c7.h(fdPrivate[i2]));
            fdPrivateBase[i2] = new c7.d();
            this.f2734a.addLast(fdPrivateBase[i2]);
            l(this.f294a[Font].f303a[i2]);
            while (true) {
                int i3 = i();
                c7.c[] cVarArr = this.f294a;
                if (i3 >= cVarArr[Font].f303a[i2] + cVarArr[Font].f306b[i2]) {
                    break;
                }
                int p1 = i();
                c();
                int p2 = i();
                if (this.f292a == "Subrs") {
                    fdSubrs[i2] = new c7.b();
                    this.f2734a.addLast(fdSubrs[i2]);
                    this.f2734a.addLast(new c7.p(19));
                } else {
                    this.f2734a.addLast(new c7.j(this.f291a, p1, p2 - p1));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void V(int Font, c7.d[] fdPrivateBase, c7.i[] fdSubrs) {
        int i2 = 0;
        while (true) {
            c7.c[] cVarArr = this.f294a;
            if (i2 < cVarArr[Font].f306b.length) {
                if (fdSubrs[i2] != null && cVarArr[Font].f310f[i2] >= 0) {
                    this.f2734a.addLast(new c7.l(fdSubrs[i2], fdPrivateBase[i2]));
                    byte[][] bArr = this.f2738a;
                    if (bArr[i2] != null) {
                        this.f2734a.addLast(new c7.j(new cd0(bArr[i2]), 0, this.f2738a[i2].length));
                    }
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int z(int Offset, int Size) {
        int OffsetSize = 0;
        l(Offset);
        while (i() < Offset + Size) {
            int p1 = i();
            c();
            int p2 = i();
            if (this.f292a == "Subrs") {
                OffsetSize = (p2 - p1) - 1;
            }
        }
        return OffsetSize;
    }

    /* access modifiers changed from: package-private */
    public void I(int Font, c7.i Subr) {
        l(this.f294a[Font].a);
        while (true) {
            int i2 = i();
            c7.c[] cVarArr = this.f294a;
            if (i2 < cVarArr[Font].a + cVarArr[Font].b) {
                int p1 = i();
                c();
                int p2 = i();
                if (this.f292a == "Subrs") {
                    this.f2734a.addLast(Subr);
                    this.f2734a.addLast(new c7.p(19));
                } else {
                    this.f2734a.addLast(new c7.j(this.f291a, p1, p2 - p1));
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void J(int Font, c7.d PrivateBase, c7.i Subrs) {
        this.f2734a.addLast(new c7.l(Subrs, PrivateBase));
        byte[] bArr = this.f2735a;
        if (bArr != null) {
            this.f2734a.addLast(new c7.j(new cd0(bArr), 0, this.f2735a.length));
        }
    }
}
