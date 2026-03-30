package defpackage;

import com.itextpdf.text.a;
import com.itextpdf.text.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: ia  reason: default package */
public class ia {
    protected float a;

    /* renamed from: a  reason: collision with other field name */
    protected int f3211a = 1;

    /* renamed from: a  reason: collision with other field name */
    protected d f3212a;

    /* renamed from: a  reason: collision with other field name */
    protected d60 f3213a;

    /* renamed from: a  reason: collision with other field name */
    protected ia f3214a;

    /* renamed from: a  reason: collision with other field name */
    protected j6 f3215a;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<float[]> f3216a;

    /* renamed from: a  reason: collision with other field name */
    protected LinkedList<bi> f3217a;

    /* renamed from: a  reason: collision with other field name */
    private final uy f3218a = wy.a(ia.class);

    /* renamed from: a  reason: collision with other field name */
    protected boolean f3219a;

    /* renamed from: a  reason: collision with other field name */
    protected d60[] f3220a;
    protected float b;

    /* renamed from: b  reason: collision with other field name */
    protected int f3221b = 0;

    /* renamed from: b  reason: collision with other field name */
    protected ArrayList<float[]> f3222b;

    /* renamed from: b  reason: collision with other field name */
    protected boolean f3223b = false;
    protected float c;

    /* renamed from: c  reason: collision with other field name */
    protected int f3224c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f3225c = true;
    protected float d;

    /* renamed from: d  reason: collision with other field name */
    private int f3226d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f3227d = true;
    protected float e;

    /* renamed from: e  reason: collision with other field name */
    private int f3228e = 0;

    /* renamed from: e  reason: collision with other field name */
    private boolean f3229e = false;
    protected float f;

    /* renamed from: f  reason: collision with other field name */
    protected int f3230f = 0;

    /* renamed from: f  reason: collision with other field name */
    protected boolean f3231f = false;
    protected float g = 16.0f;

    /* renamed from: g  reason: collision with other field name */
    protected int f3232g = 0;

    /* renamed from: g  reason: collision with other field name */
    private boolean f3233g = false;
    protected float h = 16.0f;

    /* renamed from: h  reason: collision with other field name */
    private int f3234h = -2;

    /* renamed from: h  reason: collision with other field name */
    private boolean f3235h = true;
    protected float i = 0.0f;

    /* renamed from: i  reason: collision with other field name */
    private boolean f3236i = false;
    protected float j = 0.0f;

    /* renamed from: j  reason: collision with other field name */
    private boolean f3237j = true;
    protected float k = 0.0f;
    protected float l = 0.0f;
    protected float m = 0.0f;
    protected float n = -1.0f;
    private float o = 0.0f;
    private float p;
    protected float q;
    private float r;

    public ia(d60 canvas) {
        this.f3213a = canvas;
    }

    public static ia d(ia org2) {
        ia ct = new ia((d60) null);
        ct.x(org2);
        return ct;
    }

    public ia x(ia org2) {
        if (org2 != null) {
            Q(org2);
            if (org2.f3215a != null) {
                this.f3215a = new j6(org2.f3215a);
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void Q(ia org2) {
        this.a = org2.a;
        this.b = org2.b;
        this.f3221b = org2.f3221b;
        this.f3216a = null;
        if (org2.f3216a != null) {
            this.f3216a = new ArrayList<>(org2.f3216a);
        }
        this.f3222b = null;
        if (org2.f3222b != null) {
            this.f3222b = new ArrayList<>(org2.f3222b);
        }
        this.e = org2.e;
        this.g = org2.g;
        this.h = org2.h;
        this.i = org2.i;
        this.f3213a = org2.f3213a;
        this.f3220a = org2.f3220a;
        this.f3224c = org2.f3224c;
        this.j = org2.j;
        this.k = org2.k;
        this.l = org2.l;
        this.m = org2.m;
        this.n = org2.n;
        this.f3223b = org2.f3223b;
        this.o = org2.o;
        this.f3225c = org2.f3225c;
        this.f3227d = org2.f3227d;
        this.f3226d = org2.f3226d;
        this.f3228e = org2.f3228e;
        this.f3211a = org2.f3211a;
        this.q = org2.q;
        this.f3231f = org2.f3231f;
        this.f3234h = org2.f3234h;
        if (org2.f3231f) {
            this.f3217a = new LinkedList<>();
            Iterator i$ = org2.f3217a.iterator();
            while (i$.hasNext()) {
                bi element = (bi) i$.next();
                if (element instanceof u70) {
                    this.f3217a.add(new u70((u70) element));
                } else {
                    this.f3217a.add(element);
                }
            }
            ia iaVar = org2.f3214a;
            if (iaVar != null) {
                this.f3214a = d(iaVar);
            }
        }
        this.f3230f = org2.f3230f;
        this.f3232g = org2.f3232g;
        this.p = org2.p;
        this.c = org2.c;
        this.d = org2.d;
        this.f3229e = org2.f3229e;
        this.f3212a = org2.f3212a;
        this.f3233g = org2.f3233g;
        this.r = org2.r;
        this.f3235h = org2.f3235h;
        this.f3236i = org2.f3236i;
        this.f3237j = org2.f3237j;
    }

    private void c() {
        if (this.f3215a == null && this.f3212a != null) {
            this.f3215a = new j6();
            for (a c2 : this.f3212a.t()) {
                this.f3215a.a(new b60(c2, (u50) null, this.f3212a.I()));
            }
            this.f3212a = null;
        }
    }

    public void b(d phrase) {
        if (phrase != null && !this.f3231f) {
            c();
            if (this.f3215a == null) {
                this.f3212a = phrase;
                return;
            }
            for (a b60 : phrase.t()) {
                this.f3215a.a(new b60(b60, (u50) null, phrase.I()));
            }
        }
    }

    public void S(d phrase) {
        this.f3215a = null;
        this.f3231f = false;
        this.f3214a = null;
        this.f3217a = null;
        this.f3230f = 0;
        this.f3232g = 0;
        this.f3234h = -1;
        this.f3212a = phrase;
    }

    public void a(bi element) {
        if (element != null) {
            if (element instanceof tr) {
                tr img = (tr) element;
                u70 t = new u70(1);
                float w = img.H0();
                if (w == 0.0f) {
                    t.w0(img.B0());
                    t.q0(true);
                } else {
                    t.x0(w);
                }
                t.t0(img.D0());
                t.u0(img.c());
                switch (img.c0()) {
                    case 0:
                        t.o0(0);
                        break;
                    case 2:
                        t.o0(2);
                        break;
                    default:
                        t.o0(1);
                        break;
                }
                q70 c2 = new q70(img, true);
                c2.E0(0.0f);
                c2.R(img.g());
                c2.S(img.i());
                c2.T(img.w());
                c2.Q(img.f());
                t.e(c2);
                element = t;
            }
            if (element.v() == 10) {
                element = new k50((a) element);
            } else if (element.v() == 11) {
                element = new k50((d) element);
            } else if (element.v() == 23) {
                ((u70) element).Y();
            }
            if (element.v() == 12 || element.v() == 14 || element.v() == 23 || element.v() == 55 || element.v() == 37) {
                if (!this.f3231f) {
                    this.f3231f = true;
                    this.f3217a = new LinkedList<>();
                    this.f3215a = null;
                    this.f3212a = null;
                }
                if (element.v() == 12) {
                    this.f3217a.addAll(((k50) element).P());
                } else {
                    this.f3217a.add(element);
                }
            } else {
                throw new IllegalArgumentException(i10.b("element.not.allowed", new Object[0]));
            }
        }
    }

    /* access modifiers changed from: protected */
    public float f(ArrayList<float[]> wall) {
        this.f3224c = 0;
        float f2 = this.e;
        if (f2 < this.b || f2 > this.a) {
            this.f3224c = 1;
            return 0.0f;
        }
        for (int k2 = 0; k2 < wall.size(); k2++) {
            float[] r2 = wall.get(k2);
            float f3 = this.e;
            if (f3 >= r2[0] && f3 <= r2[1]) {
                return (r2[2] * f3) + r2[3];
            }
        }
        this.f3224c = 2;
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public float[] e() {
        float x1 = f(this.f3216a);
        int i2 = this.f3224c;
        if (i2 == 1 || i2 == 2) {
            return null;
        }
        float x2 = f(this.f3222b);
        if (this.f3224c == 2) {
            return null;
        }
        return new float[]{x1, x2};
    }

    /* access modifiers changed from: protected */
    public float[] g() {
        boolean repeat = false;
        while (true) {
            if (repeat && this.g == 0.0f) {
                return null;
            }
            repeat = true;
            float[] x1 = e();
            int i2 = this.f3224c;
            if (i2 == 1) {
                return null;
            }
            this.e -= this.g;
            if (i2 != 2) {
                float[] x2 = e();
                int i3 = this.f3224c;
                if (i3 == 1) {
                    return null;
                }
                if (i3 == 2) {
                    this.e -= this.g;
                } else if (x1[0] < x2[1] && x2[0] < x1[1]) {
                    return new float[]{x1[0], x1[1], x2[0], x2[1]};
                }
            }
        }
    }

    public void P(d phrase, float llx, float lly, float urx, float ury, float leading, int alignment) {
        b(phrase);
        O(llx, lly, urx, ury, leading, alignment);
    }

    public void O(float llx, float lly, float urx, float ury, float leading, int alignment) {
        J(leading);
        this.f3221b = alignment;
        N(llx, lly, urx, ury);
    }

    public void N(float llx, float lly, float urx, float ury) {
        this.c = Math.min(llx, urx);
        this.a = Math.max(lly, ury);
        this.b = Math.min(lly, ury);
        float max = Math.max(llx, urx);
        this.d = max;
        this.e = this.a;
        float f2 = max - this.c;
        this.n = f2;
        if (f2 < 0.0f) {
            this.n = 0.0f;
        }
        this.f3223b = true;
    }

    public void J(float leading) {
        this.h = leading;
        this.i = 0.0f;
    }

    public void K(float fixedLeading, float multipliedLeading) {
        this.h = fixedLeading;
        this.i = multipliedLeading;
    }

    public float o() {
        return this.e;
    }

    public void z(int alignment) {
        this.f3221b = alignment;
    }

    public int h() {
        return this.f3221b;
    }

    public void H(float indent, boolean repeatFirstLineIndent) {
        this.j = indent;
        this.f3225c = true;
        this.f3227d = repeatFirstLineIndent;
    }

    public void F(float indent) {
        this.k = indent;
        this.f3225c = true;
    }

    public void L(float indent) {
        this.l = indent;
        this.f3225c = true;
    }

    public void I(boolean inheritGraphicState) {
        this.f3236i = inheritGraphicState;
    }

    public boolean t() {
        return this.f3237j;
    }

    public void G(boolean ignoreSpacingBefore) {
        this.f3237j = ignoreSpacingBefore;
    }

    public int p() {
        return q(false);
    }

    public int q(boolean simulate) {
        return r(simulate, (br) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int r(boolean r34, defpackage.br r35) {
        /*
            r33 = this;
            r0 = r33
            r1 = 0
            r0.f3219a = r1
            boolean r2 = r0.f3231f
            if (r2 == 0) goto L_0x000e
            int r1 = r33.s(r34)
            return r1
        L_0x000e:
            r2 = 0
            d60 r3 = r0.f3213a
            boolean r3 = u(r3)
            if (r3 == 0) goto L_0x0017
        L_0x0017:
            r33.c()
            j6 r3 = r0.f3215a
            r4 = 1
            if (r3 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r3 = 0
            r0.q = r3
            r0.f3226d = r1
            r0.f = r3
            r5 = 0
            float r6 = r0.o
            r7 = 2
            java.lang.Object[] r14 = new java.lang.Object[r7]
            r8 = 0
            java.lang.Float r9 = new java.lang.Float
            r9.<init>(r3)
            r15 = r9
            r14[r4] = r15
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 2143289344(0x7fc00000, float:NaN)
            r0.p = r12
            int r13 = r0.f3211a
            d60 r12 = r0.f3213a
            if (r12 == 0) goto L_0x0065
            d60 r10 = r0.f3213a
            l60 r9 = r12.l0()
            d60 r12 = r0.f3213a
            boolean r12 = u(r12)
            if (r12 != 0) goto L_0x005e
            d60 r12 = r0.f3213a
            boolean r7 = r0.f3236i
            d60 r11 = r12.d0(r7)
            r7 = r9
            r25 = r10
            r12 = r11
            goto L_0x006b
        L_0x005e:
            d60 r11 = r0.f3213a
            r7 = r9
            r25 = r10
            r12 = r11
            goto L_0x006b
        L_0x0065:
            if (r34 == 0) goto L_0x030e
            r7 = r9
            r25 = r10
            r12 = r11
        L_0x006b:
            if (r34 != 0) goto L_0x0089
            int r9 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x007c
            v80 r9 = r12.m0()
            float r6 = r9.p0()
            r26 = r6
            goto L_0x008b
        L_0x007c:
            r9 = 981668463(0x3a83126f, float:0.001)
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x0089
            r6 = 981668463(0x3a83126f, float:0.001)
            r26 = r6
            goto L_0x008b
        L_0x0089:
            r26 = r6
        L_0x008b:
            boolean r6 = r0.f3223b
            if (r6 != 0) goto L_0x00b6
            r6 = 0
            j6 r9 = r0.f3215a
            java.util.ArrayList<b60> r9 = r9.f4034a
            java.util.Iterator r9 = r9.iterator()
        L_0x0098:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00ad
            java.lang.Object r10 = r9.next()
            b60 r10 = (defpackage.b60) r10
            float r11 = r10.t()
            float r6 = java.lang.Math.max(r6, r11)
            goto L_0x0098
        L_0x00ad:
            float r9 = r0.h
            float r10 = r0.i
            float r10 = r10 * r6
            float r9 = r9 + r10
            r0.g = r9
        L_0x00b6:
            r6 = 0
            r27 = 0
            r9 = 0
            r28 = r8
        L_0x00bc:
            boolean r8 = r0.f3225c
            if (r8 == 0) goto L_0x00c3
            float r8 = r0.j
            goto L_0x00c5
        L_0x00c3:
            float r8 = r0.k
        L_0x00c5:
            r6 = r8
            boolean r8 = r0.f3223b
            if (r8 == 0) goto L_0x01c2
            float r8 = r0.n
            float r10 = r0.l
            float r10 = r10 + r6
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 > 0) goto L_0x00e6
            r1 = 2
            j6 r3 = r0.f3215a
            boolean r3 = r3.k()
            if (r3 == 0) goto L_0x00e2
            r1 = r1 | 1
            r31 = r6
            goto L_0x026f
        L_0x00e2:
            r31 = r6
            goto L_0x026f
        L_0x00e6:
            j6 r8 = r0.f3215a
            boolean r8 = r8.k()
            if (r8 == 0) goto L_0x00f3
            r1 = 1
            r31 = r6
            goto L_0x026f
        L_0x00f3:
            j6 r8 = r0.f3215a
            float r10 = r0.c
            float r11 = r0.n
            float r11 = r11 - r6
            float r3 = r0.l
            float r18 = r11 - r3
            int r3 = r0.f3221b
            int r11 = r0.f3228e
            float r4 = r0.b
            float r1 = r0.e
            r29 = r9
            float r9 = r0.q
            r16 = r8
            r17 = r10
            r19 = r3
            r20 = r13
            r21 = r11
            r22 = r4
            r23 = r1
            r24 = r9
            e70 r1 = r16.o(r17, r18, r19, r20, r21, r22, r23, r24)
            boolean r3 = r0.f3219a
            j6 r4 = r0.f3215a
            boolean r4 = r4.m()
            r3 = r3 | r4
            r0.f3219a = r3
            if (r1 != 0) goto L_0x0133
            r3 = 1
            r1 = r3
            r31 = r6
            r9 = r29
            goto L_0x026f
        L_0x0133:
            float r3 = r0.h
            float r4 = r0.i
            float[] r3 = r1.j(r3, r4)
            boolean r4 = r33.v()
            if (r4 == 0) goto L_0x0150
            float r4 = r0.p
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 == 0) goto L_0x0150
            float r4 = r1.e()
            r0.g = r4
            goto L_0x015f
        L_0x0150:
            r4 = 0
            r8 = r3[r4]
            r4 = 1
            r9 = r3[r4]
            float r4 = r0.q
            float r9 = r9 - r4
            float r4 = java.lang.Math.max(r8, r9)
            r0.g = r4
        L_0x015f:
            float r4 = r0.e
            float r8 = r0.a
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 > 0) goto L_0x01b5
            float r8 = r0.g
            float r9 = r4 - r8
            float r10 = r0.b
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 >= 0) goto L_0x0172
            goto L_0x01b5
        L_0x0172:
            float r4 = r4 - r8
            r0.e = r4
            if (r34 != 0) goto L_0x0196
            if (r5 != 0) goto L_0x0196
            boolean r4 = r1.f2871b
            if (r4 == 0) goto L_0x018f
            d60 r4 = r0.f3213a
            boolean r4 = r4.p0()
            if (r4 == 0) goto L_0x018f
            d60 r4 = r0.f3213a
            h70 r8 = defpackage.h70.P9
            r4.w(r8)
            r4 = 1
            r9 = r4
            goto L_0x0191
        L_0x018f:
            r9 = r29
        L_0x0191:
            r12.A()
            r5 = 1
            goto L_0x0198
        L_0x0196:
            r9 = r29
        L_0x0198:
            float r4 = r0.p
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 == 0) goto L_0x01a4
            float r4 = r0.e
            r0.p = r4
        L_0x01a4:
            float r4 = r0.n
            float r8 = r1.A()
            float r4 = r4 - r8
            r0.W(r4)
            float r3 = r0.c
            r31 = r6
            r4 = r9
            goto L_0x028e
        L_0x01b5:
            r4 = 2
            j6 r8 = r0.f3215a
            r8.r()
            r1 = r4
            r31 = r6
            r9 = r29
            goto L_0x026f
        L_0x01c2:
            r29 = r9
            float r1 = r0.e
            float r3 = r0.g
            float r1 = r1 - r3
            float[] r3 = r33.g()
            if (r3 != 0) goto L_0x01e3
            r4 = 2
            j6 r8 = r0.f3215a
            boolean r8 = r8.k()
            if (r8 == 0) goto L_0x01da
            r4 = r4 | 1
        L_0x01da:
            r0.e = r1
            r1 = r4
            r31 = r6
            r9 = r29
            goto L_0x026f
        L_0x01e3:
            j6 r4 = r0.f3215a
            boolean r4 = r4.k()
            if (r4 == 0) goto L_0x01f5
            r4 = 1
            r0.e = r1
            r1 = r4
            r31 = r6
            r9 = r29
            goto L_0x026f
        L_0x01f5:
            r4 = 0
            r8 = r3[r4]
            r4 = 2
            r9 = r3[r4]
            float r8 = java.lang.Math.max(r8, r9)
            r9 = 1
            r10 = r3[r9]
            r9 = 3
            r9 = r3[r9]
            float r9 = java.lang.Math.min(r10, r9)
            float r10 = r9 - r8
            float r11 = r0.l
            float r16 = r6 + r11
            int r10 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r10 > 0) goto L_0x021a
            r9 = r29
            r1 = 0
            r3 = 0
            r4 = 1
            goto L_0x00bc
        L_0x021a:
            j6 r10 = r0.f3215a
            float r16 = r9 - r8
            float r16 = r16 - r6
            float r18 = r16 - r11
            int r11 = r0.f3221b
            int r4 = r0.f3228e
            r30 = r3
            float r3 = r0.b
            r31 = r6
            float r6 = r0.e
            r32 = r9
            float r9 = r0.q
            r16 = r10
            r17 = r8
            r19 = r11
            r20 = r13
            r21 = r4
            r22 = r3
            r23 = r6
            r24 = r9
            e70 r3 = r16.o(r17, r18, r19, r20, r21, r22, r23, r24)
            if (r34 != 0) goto L_0x0267
            if (r5 != 0) goto L_0x0267
            boolean r4 = r3.f2871b
            if (r4 == 0) goto L_0x0260
            d60 r4 = r0.f3213a
            boolean r4 = r4.p0()
            if (r4 == 0) goto L_0x0260
            d60 r4 = r0.f3213a
            h70 r6 = defpackage.h70.P9
            r4.w(r6)
            r4 = 1
            r9 = r4
            goto L_0x0262
        L_0x0260:
            r9 = r29
        L_0x0262:
            r12.A()
            r5 = 1
            goto L_0x0269
        L_0x0267:
            r9 = r29
        L_0x0269:
            if (r3 != 0) goto L_0x028b
            r4 = 1
            r0.e = r1
            r1 = r4
        L_0x026f:
            if (r5 == 0) goto L_0x028a
            r12.V()
            d60 r3 = r0.f3213a
            if (r3 == r12) goto L_0x027b
            r3.d(r12)
        L_0x027b:
            if (r9 == 0) goto L_0x028a
            d60 r3 = r0.f3213a
            boolean r3 = r3.p0()
            if (r3 == 0) goto L_0x028a
            d60 r3 = r0.f3213a
            r3.U()
        L_0x028a:
            return r1
        L_0x028b:
            r1 = r3
            r3 = r8
            r4 = r9
        L_0x028e:
            d60 r6 = r0.f3213a
            boolean r6 = u(r6)
            if (r6 == 0) goto L_0x0296
        L_0x0296:
            if (r34 != 0) goto L_0x02d4
            if (r2 == 0) goto L_0x02a0
            d60 r6 = r0.f3213a
            r6.x0(r2)
            r2 = 0
        L_0x02a0:
            r6 = 0
            r14[r6] = r28
            boolean r6 = r1.q()
            if (r6 == 0) goto L_0x02ac
            float r6 = r0.l
            goto L_0x02ae
        L_0x02ac:
            r6 = r31
        L_0x02ae:
            float r6 = r6 + r3
            float r8 = r1.o()
            float r6 = r6 + r8
            float r8 = r0.e
            r12.D1(r6, r8)
            r8 = r7
            r9 = r1
            r10 = r12
            r11 = r25
            r16 = r12
            r12 = r14
            r17 = r13
            r13 = r26
            float r6 = r8.o0(r9, r10, r11, r12, r13)
            r0.f = r6
            r6 = 0
            r8 = r14[r6]
            r6 = r8
            r60 r6 = (defpackage.r60) r6
            r28 = r6
            goto L_0x02d8
        L_0x02d4:
            r16 = r12
            r17 = r13
        L_0x02d8:
            boolean r6 = r0.f3227d
            if (r6 == 0) goto L_0x02e4
            boolean r6 = r1.p()
            if (r6 == 0) goto L_0x02e4
            r6 = 1
            goto L_0x02e5
        L_0x02e4:
            r6 = 0
        L_0x02e5:
            r0.f3225c = r6
            float r6 = r0.e
            boolean r8 = r1.p()
            if (r8 == 0) goto L_0x02f2
            float r8 = r0.m
            goto L_0x02f3
        L_0x02f2:
            r8 = 0
        L_0x02f3:
            float r6 = r6 - r8
            r0.e = r6
            int r6 = r0.f3226d
            r12 = 1
            int r6 = r6 + r12
            r0.f3226d = r6
            float r6 = r1.g()
            r0.q = r6
            r9 = r4
            r12 = r16
            r13 = r17
            r6 = r31
            r1 = 0
            r3 = 0
            r4 = 1
            goto L_0x00bc
        L_0x030e:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "columntext.go.with.simulate.eq.eq.false.and.text.eq.eq.null"
            java.lang.String r3 = defpackage.i10.b(r4, r3)
            r1.<init>(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ia.r(boolean, br):int");
    }

    public boolean w() {
        return this.f3219a;
    }

    public void D(float extraParagraphSpace) {
        this.m = extraParagraphSpace;
    }

    public void R(float spaceCharRatio) {
        this.o = spaceCharRatio;
    }

    public void M(int runDirection) {
        if (runDirection < 0 || runDirection > 3) {
            throw new RuntimeException(i10.a("invalid.run.direction.1", runDirection));
        }
        this.f3211a = runDirection;
    }

    public int n() {
        return this.f3211a;
    }

    public int m() {
        return this.f3226d;
    }

    public float l() {
        return this.f;
    }

    public void A(int arabicOptions) {
        this.f3228e = arabicOptions;
    }

    public float j() {
        return this.q;
    }

    public static void V(d60 canvas, int alignment, d phrase, float x, float y, float rotation, int runDirection, int arabicOptions) {
        int alignment2;
        float llx;
        float urx;
        float llx2;
        float urx2;
        float ury;
        float lly;
        int alignment3;
        int alignment4 = alignment;
        float f2 = rotation;
        int i2 = runDirection;
        if (alignment4 == 0 || alignment4 == 1 || alignment4 == 2) {
            alignment2 = alignment4;
        } else {
            alignment2 = 0;
        }
        canvas.Q0();
        ia ct = new ia(canvas);
        switch (alignment2) {
            case 0:
                urx = 20000.0f;
                llx = 0.0f;
                break;
            case 2:
                urx = 0.0f;
                llx = -20000.0f;
                break;
            default:
                urx = 20000.0f;
                llx = -20000.0f;
                break;
        }
        if (f2 == 0.0f) {
            lly = -1.0f + y;
            ury = 2.0f + y;
            urx2 = urx + x;
            llx2 = llx + x;
        } else {
            double alpha = (((double) f2) * 3.141592653589793d) / 180.0d;
            float cos = (float) Math.cos(alpha);
            float sin = (float) Math.sin(alpha);
            float f3 = sin;
            float f4 = cos;
            canvas.P(cos, sin, -sin, cos, x, y);
            lly = -1.0f;
            ury = 2.0f;
            urx2 = urx;
            llx2 = llx;
        }
        ia ct2 = ct;
        int alignment5 = alignment2;
        ct.P(phrase, llx2, lly, urx2, ury, 2.0f, alignment5);
        if (i2 == 3) {
            if (alignment5 == 0) {
                alignment3 = 2;
            } else if (alignment5 == 2) {
                alignment3 = 0;
            }
            ct2.z(alignment3);
            ct2.A(arabicOptions);
            ct2.M(i2);
            ct2.p();
            canvas.K0();
        }
        alignment3 = alignment5;
        ct2.z(alignment3);
        ct2.A(arabicOptions);
        ct2.M(i2);
        try {
            ct2.p();
            canvas.K0();
        } catch (ih e2) {
            throw new mj(e2);
        }
    }

    public static void U(d60 canvas, int alignment, d phrase, float x, float y, float rotation) {
        V(canvas, alignment, phrase, x, y, rotation, 1, 0);
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Throwable, ix] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x06d5  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x06de  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x0716 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x01a1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int s(boolean r51) {
        /*
            r50 = this;
            r0 = r50
            r1 = r51
            r2 = 0
            d60 r3 = r0.f3213a
            if (r3 == 0) goto L_0x000b
            l60 r2 = r3.f2718a
        L_0x000b:
            boolean r3 = r0.f3223b
            r4 = 0
            if (r3 == 0) goto L_0x0739
            r0.f3226d = r4
            r3 = 0
            r0.q = r3
            r5 = 1
            int r6 = r0.f3211a
            r7 = 3
            r8 = 1
            if (r6 != r7) goto L_0x001e
            r6 = 1
            goto L_0x001f
        L_0x001e:
            r6 = 0
        L_0x001f:
            java.util.LinkedList<bi> r9 = r0.f3217a
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x0028
            return r8
        L_0x0028:
            java.util.LinkedList<bi> r9 = r0.f3217a
            java.lang.Object r9 = r9.getFirst()
            bi r9 = (defpackage.bi) r9
            int r10 = r9.v()
            r11 = 12
            r12 = 0
            r13 = 2
            if (r10 != r11) goto L_0x01ac
            r10 = r9
            k50 r10 = (defpackage.k50) r10
            r11 = 0
            r14 = 0
        L_0x003f:
            if (r14 >= r13) goto L_0x0160
            float r15 = r0.e
            r16 = 0
            ia r8 = r0.f3214a
            if (r8 != 0) goto L_0x00bb
            ia r8 = new ia
            d60 r7 = r0.f3213a
            r8.<init>(r7)
            r0.f3214a = r8
            int r7 = r10.R()
            r8.z(r7)
            ia r7 = r0.f3214a
            float r8 = r10.U()
            float r19 = r10.T()
            float r8 = r8 + r19
            r7.H(r8, r4)
            ia r7 = r0.f3214a
            float r8 = r10.S()
            r7.D(r8)
            ia r7 = r0.f3214a
            float r8 = r10.U()
            r7.F(r8)
            ia r7 = r0.f3214a
            float r8 = r10.V()
            r7.L(r8)
            ia r7 = r0.f3214a
            float r8 = r10.G()
            float r4 = r10.H()
            r7.K(r8, r4)
            ia r4 = r0.f3214a
            int r7 = r0.f3211a
            r4.M(r7)
            ia r4 = r0.f3214a
            int r7 = r0.f3228e
            r4.A(r7)
            ia r4 = r0.f3214a
            float r7 = r0.o
            r4.R(r7)
            ia r4 = r0.f3214a
            r4.b(r10)
            if (r5 == 0) goto L_0x00b0
            boolean r4 = r0.f3235h
            if (r4 != 0) goto L_0x00b9
        L_0x00b0:
            float r4 = r0.e
            float r7 = r10.c()
            float r4 = r4 - r7
            r0.e = r4
        L_0x00b9:
            r16 = 1
        L_0x00bb:
            ia r4 = r0.f3214a
            if (r5 != 0) goto L_0x00c5
            float r7 = r0.q
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x00cc
        L_0x00c5:
            boolean r7 = r0.f3235h
            if (r7 == 0) goto L_0x00cc
            boolean r7 = r0.f3233g
            goto L_0x00cd
        L_0x00cc:
            r7 = 0
        L_0x00cd:
            r4.T(r7)
            ia r4 = r0.f3214a
            boolean r7 = r0.f3236i
            r4.I(r7)
            ia r4 = r0.f3214a
            float r7 = r0.c
            r4.c = r7
            float r7 = r0.d
            r4.d = r7
            float r7 = r0.e
            r4.e = r7
            float r7 = r0.n
            r4.n = r7
            boolean r7 = r0.f3223b
            r4.f3223b = r7
            float r7 = r0.b
            r4.b = r7
            float r7 = r0.a
            r4.a = r7
            boolean r4 = r10.W()
            if (r4 == 0) goto L_0x0105
            if (r16 == 0) goto L_0x0105
            if (r5 == 0) goto L_0x0103
            boolean r4 = r0.f3235h
            if (r4 != 0) goto L_0x0105
        L_0x0103:
            r4 = 1
            goto L_0x0106
        L_0x0105:
            r4 = 0
        L_0x0106:
            if (r1 != 0) goto L_0x010f
            if (r4 == 0) goto L_0x010d
            if (r14 != 0) goto L_0x010d
            goto L_0x010f
        L_0x010d:
            r7 = 0
            goto L_0x0110
        L_0x010f:
            r7 = 1
        L_0x0110:
            d60 r8 = r0.f3213a
            boolean r8 = u(r8)
            if (r8 == 0) goto L_0x011f
            if (r7 != 0) goto L_0x011f
            d60 r8 = r0.f3213a
            r8.x0(r10)
        L_0x011f:
            ia r8 = r0.f3214a
            int r11 = r8.q(r7)
            d60 r8 = r0.f3213a
            boolean r8 = u(r8)
            if (r8 == 0) goto L_0x0134
            if (r7 != 0) goto L_0x0134
            d60 r8 = r0.f3213a
            r8.H(r10)
        L_0x0134:
            ia r8 = r0.f3214a
            float r8 = r8.l()
            r0.f = r8
            ia r8 = r0.f3214a
            float r8 = r8.r
            r0.W(r8)
            r8 = r11 & 1
            if (r8 != 0) goto L_0x014e
            if (r4 == 0) goto L_0x014e
            r0.f3214a = r12
            r0.e = r15
            return r13
        L_0x014e:
            if (r1 != 0) goto L_0x0160
            if (r4 != 0) goto L_0x0153
            goto L_0x0160
        L_0x0153:
            if (r14 != 0) goto L_0x0159
            r0.f3214a = r12
            r0.e = r15
        L_0x0159:
            int r14 = r14 + 1
            r4 = 0
            r7 = 3
            r8 = 1
            goto L_0x003f
        L_0x0160:
            r4 = 0
            ia r5 = r0.f3214a
            int r5 = r5.m()
            if (r5 <= 0) goto L_0x0183
            ia r5 = r0.f3214a
            float r7 = r5.e
            r0.e = r7
            int r7 = r0.f3226d
            int r8 = r5.f3226d
            int r7 = r7 + r8
            r0.f3226d = r7
            float r7 = r5.q
            r0.q = r7
            boolean r7 = r0.f3219a
            boolean r5 = r5.w()
            r5 = r5 | r7
            r0.f3219a = r5
        L_0x0183:
            ia r5 = r0.f3214a
            float r5 = r5.g
            r0.g = r5
            r5 = r11 & 1
            if (r5 == 0) goto L_0x019d
            r0.f3214a = r12
            java.util.LinkedList<bi> r5 = r0.f3217a
            r5.removeFirst()
            float r5 = r0.e
            float r7 = r10.X()
            float r5 = r5 - r7
            r0.e = r5
        L_0x019d:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x01a2
            return r13
        L_0x01a2:
            r31 = r2
            r44 = r4
            r5 = 3
            r7 = 0
            r17 = 1
            goto L_0x0725
        L_0x01ac:
            int r4 = r9.v()
            r7 = 14
            if (r4 == r7) goto L_0x072f
            int r4 = r9.v()
            r7 = 23
            if (r4 != r7) goto L_0x0688
            r4 = r9
            u70 r4 = (defpackage.u70) r4
            int r7 = r0.f3211a
            int r8 = r4.R()
            r0.f3211a = r8
            r10 = 3
            if (r8 != r10) goto L_0x01cc
            r8 = 1
            goto L_0x01cd
        L_0x01cc:
            r8 = 0
        L_0x01cd:
            r6 = r8
            int r8 = r4.z0()
            int r10 = r4.I()
            if (r8 > r10) goto L_0x01e3
            java.util.LinkedList<bi> r8 = r0.f3217a
            r8.removeFirst()
            r31 = r2
            r21 = r5
            goto L_0x0374
        L_0x01e3:
            float r8 = r0.e
            float r10 = r0.q
            float r8 = r8 + r10
            int r10 = r0.f3232g
            if (r10 != 0) goto L_0x01f5
            boolean r10 = r0.f3235h
            if (r10 == 0) goto L_0x01f5
            float r10 = r4.C0()
            float r8 = r8 - r10
        L_0x01f5:
            float r10 = r0.b
            int r10 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r10 < 0) goto L_0x067d
            float r10 = r0.a
            int r10 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x020d
            r31 = r2
            r21 = r5
            r45 = r6
            r3 = r7
            r32 = r9
            r5 = 2
            goto L_0x0687
        L_0x020d:
            r26 = r8
            float r10 = r0.c
            r0.g = r3
            boolean r11 = r4.c0()
            if (r11 == 0) goto L_0x0221
            float r11 = r4.V()
            r0.W(r11)
            goto L_0x022f
        L_0x0221:
            float r11 = r0.n
            float r14 = r4.W()
            float r11 = r11 * r14
            r14 = 1120403456(0x42c80000, float:100.0)
            float r11 = r11 / r14
            r4.w0(r11)
        L_0x022f:
            r4.i0()
            int r14 = r4.I()
            int r15 = r4.F()
            int r3 = r14 - r15
            float r29 = r4.E()
            float r20 = r4.H()
            float r30 = r20 - r29
            boolean r20 = r4.e0()
            if (r20 == 0) goto L_0x025c
            int r12 = r0.f3232g
            if (r12 > r3) goto L_0x025c
            boolean r12 = r4.isComplete()
            if (r12 != 0) goto L_0x025a
            int r12 = r0.f3232g
            if (r12 == r3) goto L_0x025c
        L_0x025a:
            r12 = 1
            goto L_0x025d
        L_0x025c:
            r12 = 0
        L_0x025d:
            if (r12 != 0) goto L_0x0261
            float r8 = r8 - r30
        L_0x0261:
            r20 = 0
            int r13 = r0.f3232g
            if (r13 >= r14) goto L_0x0269
            r0.f3232g = r14
        L_0x0269:
            r13 = 0
            boolean r21 = r4.f0()
            if (r21 == 0) goto L_0x027f
            r31 = r2
            float r2 = r0.b
            float r2 = r8 - r2
            r21 = r5
            int r5 = r0.f3232g
            u70$b r13 = r4.C(r2, r5)
            goto L_0x0283
        L_0x027f:
            r31 = r2
            r21 = r5
        L_0x0283:
            boolean r2 = r4.f0()
            if (r2 == 0) goto L_0x0295
            int r2 = r13.f5228b
            int r5 = r4.z0()
            r17 = 1
            int r5 = r5 + -1
            if (r2 >= r5) goto L_0x02a1
        L_0x0295:
            float r8 = r8 - r29
            float r2 = r0.b
            float r2 = r8 - r2
            int r5 = r0.f3232g
            u70$b r13 = r4.C(r2, r5)
        L_0x02a1:
            float r2 = r0.b
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0674
            float r2 = r0.a
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x02b7
            r47 = r3
            r45 = r6
            r3 = r7
            r32 = r9
            r5 = 2
            goto L_0x067c
        L_0x02b7:
            int r2 = r13.f5228b
            r5 = 1
            int r2 = r2 + r5
            float r5 = r13.a
            float r8 = r8 - r5
            uy r5 = r0.f3218a
            r20 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r32 = r9
            java.lang.String r9 = "Want to split at row "
            r8.append(r9)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r5.a(r8)
            r5 = r2
        L_0x02d9:
            int r8 = r0.f3232g
            if (r5 <= r8) goto L_0x02f0
            int r8 = r4.z0()
            if (r5 >= r8) goto L_0x02f0
            t70 r8 = r4.M(r5)
            boolean r8 = r8.n()
            if (r8 == 0) goto L_0x02f0
            int r5 = r5 + -1
            goto L_0x02d9
        L_0x02f0:
            int r8 = r4.z0()
            r9 = 1
            int r8 = r8 - r9
            if (r5 >= r8) goto L_0x0304
            t70 r8 = r4.M(r5)
            boolean r8 = r8.n()
            if (r8 != 0) goto L_0x0304
            int r5 = r5 + 1
        L_0x0304:
            int r8 = r0.f3232g
            if (r5 <= r8) goto L_0x030a
            if (r5 < r2) goto L_0x031c
        L_0x030a:
            if (r5 != r14) goto L_0x0324
            t70 r8 = r4.M(r14)
            boolean r8 = r8.n()
            if (r8 == 0) goto L_0x0324
            boolean r8 = r4.d0()
            if (r8 == 0) goto L_0x0324
        L_0x031c:
            float r8 = r0.b
            r2 = r5
            r9 = 0
            r4.r0(r9)
            goto L_0x0326
        L_0x0324:
            r8 = r20
        L_0x0326:
            uy r9 = r0.f3218a
            r33 = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r34 = r7
            java.lang.String r7 = "Will split at row "
            r5.append(r7)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            r9.a(r5)
            boolean r5 = r4.g0()
            if (r5 == 0) goto L_0x034d
            if (r2 <= 0) goto L_0x034d
            int r5 = r2 + -1
            r13.a(r4, r5)
        L_0x034d:
            boolean r5 = r4.isComplete()
            if (r5 != 0) goto L_0x0355
            float r8 = r8 + r29
        L_0x0355:
            boolean r5 = r4.h0()
            r7 = -1
            if (r5 != 0) goto L_0x0390
            int r5 = r0.f3234h
            if (r5 == r7) goto L_0x0364
            r0.f3234h = r7
            goto L_0x042c
        L_0x0364:
            int r5 = r0.f3232g
            if (r2 != r5) goto L_0x042c
            int r5 = r4.z0()
            if (r2 != r5) goto L_0x037e
            java.util.LinkedList<bi> r5 = r0.f3217a
            r5.removeFirst()
        L_0x0374:
            r5 = r21
            r2 = r31
            r3 = 0
            r4 = 0
            r7 = 3
            r8 = 1
            goto L_0x001f
        L_0x037e:
            boolean r5 = r4.isComplete()
            if (r5 != 0) goto L_0x0387
            r5 = 1
            if (r2 == r5) goto L_0x038e
        L_0x0387:
            java.util.ArrayList r5 = r4.P()
            r5.remove(r2)
        L_0x038e:
            r5 = 2
            return r5
        L_0x0390:
            boolean r5 = r4.g0()
            if (r5 == 0) goto L_0x03af
            int r5 = r0.f3232g
            if (r5 < r2) goto L_0x03ab
            int r5 = r0.f3234h
            r9 = -2
            if (r5 != r9) goto L_0x03af
            int r5 = r4.I()
            if (r5 == 0) goto L_0x03ab
            boolean r5 = r4.e0()
            if (r5 == 0) goto L_0x03af
        L_0x03ab:
            r0.f3234h = r7
            goto L_0x042c
        L_0x03af:
            int r5 = r4.z0()
            if (r2 >= r5) goto L_0x042c
            float r5 = r13.b
            float r9 = r13.a
            float r5 = r5 - r9
            float r8 = r8 - r5
            float r5 = r0.b
            float r5 = r8 - r5
            t70 r9 = r4.M(r2)
            t70 r9 = r9.A(r4, r2, r5)
            if (r9 != 0) goto L_0x03db
            uy r7 = r0.f3218a
            r20 = r5
            java.lang.String r5 = "Didn't split row!"
            r7.a(r5)
            r5 = -1
            r0.f3234h = r5
            int r5 = r0.f3232g
            if (r5 != r2) goto L_0x042c
            r5 = 2
            return r5
        L_0x03db:
            r20 = r5
            int r5 = r0.f3234h
            if (r2 == r5) goto L_0x0407
            int r5 = r2 + 1
            r0.f3234h = r5
            u70 r5 = new u70
            r5.<init>((defpackage.u70) r4)
            r4 = r5
            java.util.LinkedList<bi> r5 = r0.f3217a
            r7 = 0
            r5.set(r7, r4)
            java.util.ArrayList r5 = r4.P()
            r7 = r14
        L_0x03f6:
            r22 = r4
            int r4 = r0.f3232g
            if (r7 >= r4) goto L_0x0405
            r4 = 0
            r5.set(r7, r4)
            int r7 = r7 + 1
            r4 = r22
            goto L_0x03f6
        L_0x0405:
            r4 = r22
        L_0x0407:
            float r8 = r0.b
            java.util.ArrayList r5 = r4.P()
            int r2 = r2 + 1
            r5.add(r2, r9)
            uy r5 = r0.f3218a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r22 = r4
            java.lang.String r4 = "Inserting row at position "
            r7.append(r4)
            r7.append(r2)
            java.lang.String r4 = r7.toString()
            r5.a(r4)
            r4 = r22
        L_0x042c:
            r5 = 0
            if (r1 != 0) goto L_0x05dc
            int r7 = r4.J()
            switch(r7) {
                case 1: goto L_0x0444;
                case 2: goto L_0x043d;
                default: goto L_0x0436;
            }
        L_0x0436:
            if (r6 == 0) goto L_0x044b
            float r7 = r0.n
            float r7 = r7 - r11
            float r10 = r10 + r7
            goto L_0x044b
        L_0x043d:
            if (r6 != 0) goto L_0x044b
            float r7 = r0.n
            float r7 = r7 - r11
            float r10 = r10 + r7
            goto L_0x044b
        L_0x0444:
            float r7 = r0.n
            float r7 = r7 - r11
            r9 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r9
            float r10 = r10 + r7
        L_0x044b:
            u70 r7 = defpackage.u70.y0(r4)
            java.util.ArrayList r9 = r7.P()
            if (r12 != 0) goto L_0x0472
            if (r3 <= 0) goto L_0x0472
            r44 = r5
            r45 = r6
            r5 = 0
            java.util.ArrayList r6 = r4.Q(r5, r3)
            d60 r5 = r0.f3213a
            boolean r5 = u(r5)
            if (r5 == 0) goto L_0x046e
            y70 r5 = r7.G()
            r5.f5309a = r6
        L_0x046e:
            r9.addAll(r6)
            goto L_0x0479
        L_0x0472:
            r44 = r5
            r45 = r6
            r7.m0(r15)
        L_0x0479:
            int r5 = r0.f3232g
            java.util.ArrayList r5 = r4.Q(r5, r2)
            d60 r6 = r0.f3213a
            boolean r6 = u(r6)
            if (r6 == 0) goto L_0x048d
            v70 r6 = r7.z()
            r6.f5309a = r5
        L_0x048d:
            r9.addAll(r5)
            boolean r5 = r4.f0()
            r6 = 1
            r5 = r5 ^ r6
            r20 = 0
            int r6 = r4.z0()
            if (r2 >= r6) goto L_0x04a8
            r6 = 1
            r7.l0(r6)
            r5 = 1
            r20 = 1
            r6 = r20
            goto L_0x04aa
        L_0x04a8:
            r6 = r20
        L_0x04aa:
            if (r15 <= 0) goto L_0x04d0
            boolean r20 = r7.isComplete()
            if (r20 == 0) goto L_0x04d0
            if (r5 == 0) goto L_0x04d0
            r46 = r5
            int r5 = r3 + r15
            java.util.ArrayList r5 = r4.Q(r3, r5)
            r47 = r3
            d60 r3 = r0.f3213a
            boolean r3 = u(r3)
            if (r3 == 0) goto L_0x04cc
            x70 r3 = r7.D()
            r3.f5309a = r5
        L_0x04cc:
            r9.addAll(r5)
            goto L_0x04d6
        L_0x04d0:
            r47 = r3
            r46 = r5
            r3 = 0
            r15 = r3
        L_0x04d6:
            int r3 = r9.size()
            int r3 = r3 - r15
            if (r3 <= 0) goto L_0x05d3
            r3 = 0
            int r5 = r9.size()
            r17 = 1
            int r5 = r5 + -1
            int r5 = r5 - r15
            java.lang.Object r20 = r9.get(r5)
            r21 = r3
            r3 = r20
            t70 r3 = (defpackage.t70) r3
            boolean r20 = r4.a0(r6)
            if (r20 == 0) goto L_0x050c
            float r20 = r3.f()
            r48 = r9
            float r9 = r0.b
            float r9 = r8 - r9
            float r9 = r9 + r20
            r3.y(r9)
            float r8 = r0.b
            r9 = r8
            r8 = r20
            goto L_0x0511
        L_0x050c:
            r48 = r9
            r9 = r8
            r8 = r21
        L_0x0511:
            if (r6 == 0) goto L_0x0517
            w70 r20 = r4.T()
        L_0x0517:
            r49 = r9
            d60[] r9 = r0.f3220a
            if (r9 == 0) goto L_0x0557
            r18 = 3
            r9 = r9[r18]
            boolean r9 = u(r9)
            if (r9 == 0) goto L_0x052e
            d60[] r9 = r0.f3220a
            r9 = r9[r18]
            r9.x0(r4)
        L_0x052e:
            r21 = 0
            r22 = -1
            r23 = 0
            r24 = -1
            d60[] r9 = r0.f3220a
            r28 = 0
            r20 = r7
            r25 = r10
            r27 = r9
            r20.E0(r21, r22, r23, r24, r25, r26, r27, r28)
            d60[] r9 = r0.f3220a
            r18 = 3
            r9 = r9[r18]
            boolean r9 = u(r9)
            if (r9 == 0) goto L_0x0588
            d60[] r9 = r0.f3220a
            r9 = r9[r18]
            r9.H(r4)
            goto L_0x0588
        L_0x0557:
            d60 r9 = r0.f3213a
            boolean r9 = u(r9)
            if (r9 == 0) goto L_0x0564
            d60 r9 = r0.f3213a
            r9.x0(r4)
        L_0x0564:
            r36 = 0
            r37 = -1
            r38 = 0
            r39 = -1
            d60 r9 = r0.f3213a
            r43 = 0
            r35 = r7
            r40 = r10
            r41 = r26
            r42 = r9
            r35.D0(r36, r37, r38, r39, r40, r41, r42, r43)
            d60 r9 = r0.f3213a
            boolean r9 = u(r9)
            if (r9 == 0) goto L_0x0588
            d60 r9 = r0.f3213a
            r9.H(r4)
        L_0x0588:
            boolean r9 = r4.isComplete()
            if (r9 != 0) goto L_0x0591
            r4.f(r2)
        L_0x0591:
            int r9 = r0.f3234h
            if (r9 != r2) goto L_0x05ab
            int r9 = r4.z0()
            if (r2 >= r9) goto L_0x05ab
            java.util.ArrayList r9 = r4.P()
            java.lang.Object r9 = r9.get(r2)
            t70 r9 = (defpackage.t70) r9
            r9.c(r7, r5)
            r20 = r10
            goto L_0x05c1
        L_0x05ab:
            if (r2 <= 0) goto L_0x05bf
            int r9 = r4.z0()
            if (r2 >= r9) goto L_0x05bf
            t70 r9 = r4.M(r2)
            r20 = r10
            int r10 = r2 + -1
            r9.B(r4, r10, r7, r5)
            goto L_0x05c1
        L_0x05bf:
            r20 = r10
        L_0x05c1:
            boolean r9 = r4.a0(r6)
            if (r9 == 0) goto L_0x05ca
            r3.y(r8)
        L_0x05ca:
            if (r6 == 0) goto L_0x05d0
            w70 r9 = r4.T()
        L_0x05d0:
            r8 = r49
            goto L_0x05d9
        L_0x05d3:
            r48 = r9
            r20 = r10
            r17 = 1
        L_0x05d9:
            r10 = r20
            goto L_0x05f4
        L_0x05dc:
            r47 = r3
            r44 = r5
            r45 = r6
            r17 = 1
            boolean r3 = r4.Z()
            if (r3 == 0) goto L_0x05f4
            float r3 = r0.b
            r5 = -830472192(0xffffffffce800000, float:-1.07374182E9)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x05f4
            float r8 = r0.b
        L_0x05f4:
            r0.e = r8
            r3 = 0
            r0.q = r3
            r0.g = r3
            if (r12 != 0) goto L_0x0609
            boolean r3 = r4.isComplete()
            if (r3 != 0) goto L_0x0609
            float r3 = r0.e
            float r3 = r3 + r29
            r0.e = r3
        L_0x0609:
            int r3 = r4.z0()
            if (r2 >= r3) goto L_0x0622
            float r3 = r4.N(r2)
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0622
            boolean r3 = r4.X(r2)
            if (r3 == 0) goto L_0x061f
            goto L_0x0622
        L_0x061f:
            int r2 = r2 + 1
            goto L_0x0609
        L_0x0622:
            int r3 = r4.z0()
            if (r2 < r3) goto L_0x065a
            float r3 = r0.e
            float r5 = r4.B0()
            float r3 = r3 - r5
            float r5 = r0.b
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0638
            r0.e = r5
            goto L_0x0641
        L_0x0638:
            float r3 = r0.e
            float r5 = r4.B0()
            float r3 = r3 - r5
            r0.e = r3
        L_0x0641:
            java.util.LinkedList<bi> r3 = r0.f3217a
            r3.removeFirst()
            r3 = -1
            r0.f3234h = r3
            r3 = 0
            r0.f3232g = r3
            r3 = r34
            r0.f3211a = r3
            r5 = 3
            if (r3 != r5) goto L_0x0655
            r6 = 1
            goto L_0x0656
        L_0x0655:
            r6 = 0
        L_0x0656:
            r2 = r6
            r7 = 0
            goto L_0x0725
        L_0x065a:
            r3 = r34
            int r5 = r0.f3234h
            r6 = -1
            if (r5 <= r6) goto L_0x0670
            java.util.ArrayList r5 = r4.P()
            int r6 = r0.f3232g
        L_0x0667:
            if (r6 >= r2) goto L_0x0670
            r7 = 0
            r5.set(r6, r7)
            int r6 = r6 + 1
            goto L_0x0667
        L_0x0670:
            r0.f3232g = r2
            r5 = 2
            return r5
        L_0x0674:
            r47 = r3
            r45 = r6
            r3 = r7
            r32 = r9
            r5 = 2
        L_0x067c:
            return r5
        L_0x067d:
            r31 = r2
            r21 = r5
            r45 = r6
            r3 = r7
            r32 = r9
            r5 = 2
        L_0x0687:
            return r5
        L_0x0688:
            r31 = r2
            r21 = r5
            r32 = r9
            r5 = 3
            r17 = 1
            int r2 = r32.v()
            r3 = 55
            if (r2 != r3) goto L_0x06b6
            if (r1 != 0) goto L_0x06af
            r2 = r32
            xh r2 = (defpackage.xh) r2
            d60 r8 = r0.f3213a
            float r9 = r0.c
            float r10 = r0.b
            float r11 = r0.d
            float r12 = r0.a
            float r13 = r0.e
            r7 = r2
            r7.a(r8, r9, r10, r11, r12, r13)
        L_0x06af:
            java.util.LinkedList<bi> r2 = r0.f3217a
            r2.removeFirst()
            r7 = 0
            goto L_0x0723
        L_0x06b6:
            int r2 = r32.v()
            r3 = 37
            if (r2 != r3) goto L_0x071d
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r9 = r32
        L_0x06c5:
            r2.add(r9)
            java.util.LinkedList<bi> r4 = r0.f3217a
            r4.removeFirst()
            java.util.LinkedList<bi> r4 = r0.f3217a
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x06de
            java.util.LinkedList<bi> r4 = r0.f3217a
            java.lang.Object r4 = r4.getFirst()
            bi r4 = (defpackage.bi) r4
            goto L_0x06df
        L_0x06de:
            r4 = 0
        L_0x06df:
            r9 = r4
            if (r9 == 0) goto L_0x06e8
            int r4 = r9.v()
            if (r4 == r3) goto L_0x06c5
        L_0x06e8:
            hm r3 = new hm
            boolean r4 = r0.f3233g
            r3.<init>(r2, r4)
            float r4 = r0.c
            float r7 = r0.b
            float r8 = r0.d
            float r10 = r0.e
            r3.d(r4, r7, r8, r10)
            ia r4 = r3.f3168a
            boolean r7 = r50.t()
            r4.G(r7)
            d60 r4 = r0.f3213a
            int r4 = r3.c(r4, r1)
            float r7 = r3.b()
            r0.e = r7
            r7 = 0
            r0.q = r7
            r8 = r4 & 1
            if (r8 != 0) goto L_0x071c
            java.util.LinkedList<bi> r5 = r0.f3217a
            r5.addAll(r2)
            return r4
        L_0x071c:
            goto L_0x0723
        L_0x071d:
            r7 = 0
            java.util.LinkedList<bi> r2 = r0.f3217a
            r2.removeFirst()
        L_0x0723:
            r44 = r21
        L_0x0725:
            r2 = r31
            r5 = r44
            r3 = 0
            r4 = 0
            r7 = 3
            r8 = 1
            goto L_0x001f
        L_0x072f:
            r32 = r9
            defpackage.b6.a(r32)
            r1 = 0
            r1.g()
            throw r1
        L_0x0739:
            r31 = r2
            ih r2 = new ih
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "irregular.columns.are.not.supported.in.composite.mode"
            java.lang.String r3 = defpackage.i10.b(r4, r3)
            r2.<init>((java.lang.String) r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ia.s(boolean):int");
    }

    public void B(d60 canvas) {
        this.f3213a = canvas;
        this.f3220a = null;
        ia iaVar = this.f3214a;
        if (iaVar != null) {
            iaVar.B(canvas);
        }
    }

    public void C(d60[] canvases) {
        this.f3220a = canvases;
        this.f3213a = canvases[3];
        ia iaVar = this.f3214a;
        if (iaVar != null) {
            iaVar.C(canvases);
        }
    }

    public boolean X() {
        return this.f3231f && !this.f3217a.isEmpty() && this.f3217a.getFirst().v() == 55;
    }

    public List<bi> i() {
        return this.f3217a;
    }

    public boolean v() {
        return this.f3233g;
    }

    public void T(boolean useAscender) {
        this.f3233g = useAscender;
    }

    public float k() {
        return this.r;
    }

    public void E(float filledWidth) {
        this.r = filledWidth;
    }

    public void W(float w) {
        if (w > this.r) {
            this.r = w;
        }
    }

    public void y(boolean adjustFirstLine) {
        this.f3235h = adjustFirstLine;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r0 = r1.f2719a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean u(defpackage.d60 r1) {
        /*
            if (r1 == 0) goto L_0x0012
            l60 r0 = r1.f2718a
            if (r0 == 0) goto L_0x0012
            v80 r0 = r1.f2719a
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.z0()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ia.u(d60):boolean");
    }
}
