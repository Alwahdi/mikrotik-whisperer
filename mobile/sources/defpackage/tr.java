package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

/* renamed from: tr  reason: default package */
public abstract class tr extends pd0 implements km0, br {
    static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected dr f5128a = null;

    /* renamed from: a  reason: collision with other field name */
    private g0 f5129a = null;

    /* renamed from: a  reason: collision with other field name */
    protected h3 f5130a = null;

    /* renamed from: a  reason: collision with other field name */
    protected h70 f5131a = h70.H3;

    /* renamed from: a  reason: collision with other field name */
    private j60 f5132a = null;

    /* renamed from: a  reason: collision with other field name */
    protected Long f5133a = C0();

    /* renamed from: a  reason: collision with other field name */
    protected URL f5134a;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<h70, o70> f5135a = null;

    /* renamed from: a  reason: collision with other field name */
    protected m70 f5136a;

    /* renamed from: a  reason: collision with other field name */
    protected tr f5137a;

    /* renamed from: a  reason: collision with other field name */
    private z60 f5138a;

    /* renamed from: a  reason: collision with other field name */
    protected byte[] f5139a;

    /* renamed from: a  reason: collision with other field name */
    protected int[] f5140a;

    /* renamed from: a  reason: collision with other field name */
    protected q80[] f5141a = new q80[1];
    protected boolean b;

    /* renamed from: b  reason: collision with other field name */
    protected byte[] f5142b;
    protected int c;

    /* renamed from: c  reason: collision with other field name */
    protected boolean f5143c = true;
    protected int d = 1;

    /* renamed from: d  reason: collision with other field name */
    protected boolean f5144d;
    protected int e;

    /* renamed from: e  reason: collision with other field name */
    protected boolean f5145e = false;
    protected int f = -1;

    /* renamed from: f  reason: collision with other field name */
    protected boolean f5146f = false;
    protected int g = 0;

    /* renamed from: g  reason: collision with other field name */
    protected boolean f5147g = false;
    protected int h = 0;

    /* renamed from: h  reason: collision with other field name */
    private boolean f5148h;
    protected int i = 0;
    protected float j = Float.NaN;

    /* renamed from: j  reason: collision with other field name */
    protected int f5149j = -1;
    protected float k = Float.NaN;

    /* renamed from: k  reason: collision with other field name */
    protected int f5150k = 1;
    protected float l;
    protected float m;
    protected float n;
    protected float o;
    protected float p;
    private float q;
    protected float r = 0.0f;
    protected float s = 0.0f;
    protected float t;
    protected float u;
    protected float v;
    private float w = 100.0f;
    private float x = 0.0f;

    public tr(URL url) {
        super(0.0f, 0.0f);
        this.f5134a = url;
        this.e = 0;
        this.p = 0.0f;
    }

    public static tr v0(URL url) {
        return w0(url, false);
    }

    public static tr w0(URL url, boolean recoverFromImageError) {
        cd0 ra;
        cd0 ra2;
        cd0 ra3;
        cd0 ra4;
        URL url2 = url;
        boolean z = recoverFromImageError;
        InputStream is = null;
        ed0 randomAccessSourceFactory = new ed0();
        try {
            InputStream is2 = url.openStream();
            int c1 = is2.read();
            int c2 = is2.read();
            int c3 = is2.read();
            int c4 = is2.read();
            int c5 = is2.read();
            int c6 = is2.read();
            int c7 = is2.read();
            int c8 = is2.read();
            is2.close();
            is = null;
            if (c1 == 71 && c2 == 73 && c3 == 70) {
                tr img = new ip(url2).b(1);
                if (is != null) {
                    is.close();
                }
                return img;
            } else if (c1 == 255 && c2 == 216) {
                qv qvVar = new qv(url2);
                if (is != null) {
                    is.close();
                }
                return qvVar;
            } else if (c1 == 0 && c2 == 0 && c3 == 0 && c4 == 12) {
                pv pvVar = new pv(url2);
                if (is != null) {
                    is.close();
                }
                return pvVar;
            } else if (c1 == 255 && c2 == 79 && c3 == 255 && c4 == 81) {
                pv pvVar2 = new pv(url2);
                if (is != null) {
                    is.close();
                }
                return pvVar2;
            } else {
                int[] iArr = o90.a;
                if (c1 == iArr[0] && c2 == iArr[1] && c3 == iArr[2] && c4 == iArr[3]) {
                    tr m2 = o90.m(url);
                    if (is != null) {
                        is.close();
                    }
                    return m2;
                } else if (c1 == 215 && c2 == 205) {
                    zr zrVar = new zr(url2);
                    if (is != null) {
                        is.close();
                    }
                    return zrVar;
                } else if (c1 == 66 && c2 == 77) {
                    tr g2 = o6.g(url);
                    if (is != null) {
                        is.close();
                    }
                    return g2;
                } else if ((c1 == 77 && c2 == 77 && c3 == 0 && c4 == 42) || (c1 == 73 && c2 == 73 && c3 == 42 && c4 == 0)) {
                    ra = null;
                    if (url.getProtocol().equals("file")) {
                        ra2 = new cd0(randomAccessSourceFactory.b(tu0.l(url.getFile())));
                    } else {
                        ra2 = new cd0(randomAccessSourceFactory.g(url2));
                    }
                    tr img2 = jr0.f(ra2, 1);
                    img2.f5134a = url2;
                    ra2.close();
                    if (is != null) {
                        is.close();
                    }
                    return img2;
                } else if (c1 == 151 && c2 == 74 && c3 == 66 && c4 == 50 && c5 == 13 && c6 == 10 && c7 == 26 && c8 == 10) {
                    ra3 = null;
                    if (url.getProtocol().equals("file")) {
                        ra4 = new cd0(randomAccessSourceFactory.b(tu0.l(url.getFile())));
                    } else {
                        ra4 = new cd0(randomAccessSourceFactory.g(url2));
                    }
                    tr img3 = av.a(ra4, 1);
                    img3.f5134a = url2;
                    ra4.close();
                    if (is != null) {
                        is.close();
                    }
                    return img3;
                } else {
                    throw new IOException(i10.b("unknown.image.format", url.toString()));
                }
            }
        } catch (RuntimeException e2) {
            if (z) {
                tr img4 = jr0.h(ra, z, 1);
                img4.f5134a = url2;
                if (ra != null) {
                    ra.close();
                }
                if (is != null) {
                    is.close();
                }
                return img4;
            }
            throw e2;
        } catch (Throwable th) {
            if (is != null) {
                is.close();
            }
            throw th;
        }
    }

    public static tr u0(String filename) {
        return v0(tu0.k(filename));
    }

    public static tr o0(int width, int height, int components, int bpc, byte[] data) {
        return p0(width, height, components, bpc, data, (int[]) null);
    }

    public static tr q0(int width, int height, boolean reverseBits, int typeCCITT, int parameters, byte[] data) {
        return r0(width, height, reverseBits, typeCCITT, parameters, data, (int[]) null);
    }

    public static tr r0(int width, int height, boolean reverseBits, int typeCCITT, int parameters, byte[] data, int[] transparency) {
        if (transparency == null || transparency.length == 2) {
            vr vrVar = new vr(width, height, reverseBits, typeCCITT, parameters, data);
            vrVar.f5140a = transparency;
            return vrVar;
        }
        throw new n5(i10.b("transparency.length.must.be.equal.to.2.with.ccitt.images", new Object[0]));
    }

    public static tr p0(int width, int height, int components, int bpc, byte[] data, int[] transparency) {
        if (transparency != null && transparency.length != components * 2) {
            throw new n5(i10.b("transparency.length.must.be.equal.to.componentes.2", new Object[0]));
        } else if (components == 1 && bpc == 1) {
            return r0(width, height, false, 256, 1, b7.d(data, width, height), transparency);
        } else {
            xr xrVar = new xr(width, height, components, bpc, data);
            xrVar.f5140a = transparency;
            return xrVar;
        }
    }

    public static tr t0(q80 template) {
        return new yr(template);
    }

    public z60 i0() {
        return this.f5138a;
    }

    public static tr s0(tr image) {
        if (image == null) {
            return null;
        }
        try {
            return (tr) image.getClass().getDeclaredConstructor(new Class[]{tr.class}).newInstance(new Object[]{image});
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    public int v() {
        return this.c;
    }

    public boolean M0() {
        return this.c == 34;
    }

    public boolean N0() {
        return this.c == 35;
    }

    public URL G0() {
        return this.f5134a;
    }

    public void p1(URL url) {
        this.f5134a = url;
    }

    public byte[] z0() {
        return this.f5139a;
    }

    public int e0() {
        return this.d;
    }

    public q80 E0() {
        return this.f5141a[0];
    }

    public void n1(q80 template) {
        this.f5141a[0] = template;
    }

    public int c0() {
        return this.e;
    }

    public void b1(float absoluteX, float absoluteY) {
        this.j = absoluteX;
        this.k = absoluteY;
    }

    public boolean I0() {
        return !Float.isNaN(this.j);
    }

    public float Z() {
        return this.j;
    }

    public boolean J0() {
        return !Float.isNaN(this.k);
    }

    public float a0() {
        return this.k;
    }

    public float B0() {
        return this.n;
    }

    public float A0() {
        return this.o;
    }

    public void Y0(float newWidth, float newHeight) {
        this.l = newWidth;
        this.m = newHeight;
        float[] matrix = W0();
        this.n = matrix[6] - matrix[4];
        this.o = matrix[7] - matrix[5];
        q1(0.0f);
    }

    public void Z0(float percent) {
        a1(percent, percent);
    }

    public void a1(float percentX, float percentY) {
        this.l = (M() * percentX) / 100.0f;
        this.m = (D() * percentY) / 100.0f;
        float[] matrix = W0();
        this.n = matrix[6] - matrix[4];
        this.o = matrix[7] - matrix[5];
        q1(0.0f);
    }

    public float[] W0() {
        return X0(1.0f);
    }

    public float[] X0(float scalePercentage) {
        float[] matrix = new float[8];
        float cosX = (float) Math.cos((double) this.p);
        float sinX = (float) Math.sin((double) this.p);
        float f2 = this.l;
        matrix[0] = f2 * cosX * scalePercentage;
        matrix[1] = f2 * sinX * scalePercentage;
        float f3 = this.m;
        matrix[2] = (-f3) * sinX * scalePercentage;
        matrix[3] = f3 * cosX * scalePercentage;
        float f4 = this.p;
        if (((double) f4) < 1.5707963267948966d) {
            matrix[4] = matrix[2];
            matrix[5] = 0.0f;
            matrix[6] = matrix[0];
            matrix[7] = matrix[1] + matrix[3];
        } else if (((double) f4) < 3.141592653589793d) {
            matrix[4] = matrix[0] + matrix[2];
            matrix[5] = matrix[3];
            matrix[6] = 0.0f;
            matrix[7] = matrix[1];
        } else if (((double) f4) < 4.71238898038469d) {
            matrix[4] = matrix[0];
            matrix[5] = matrix[1] + matrix[3];
            matrix[6] = matrix[2];
            matrix[7] = 0.0f;
        } else {
            matrix[4] = 0.0f;
            matrix[5] = matrix[1];
            matrix[6] = matrix[0] + matrix[2];
            matrix[7] = matrix[3];
        }
        return matrix;
    }

    protected static synchronized Long C0() {
        Long valueOf;
        synchronized (tr.class) {
            long j2 = a + 1;
            a = j2;
            valueOf = Long.valueOf(j2);
        }
        return valueOf;
    }

    public Long y0() {
        return this.f5133a;
    }

    public float l0() {
        float rot = (float) (((double) (this.p - this.q)) % 6.283185307179586d);
        if (rot < 0.0f) {
            return (float) (((double) rot) + 6.283185307179586d);
        }
        return rot;
    }

    public void l1(float r2) {
        float f2 = (float) (((double) (this.q + r2)) % 6.283185307179586d);
        this.p = f2;
        if (f2 < 0.0f) {
            this.p = (float) (((double) f2) + 6.283185307179586d);
        }
        float[] matrix = W0();
        this.n = matrix[6] - matrix[4];
        this.o = matrix[7] - matrix[5];
    }

    public void h1(float initialRotation) {
        this.q = initialRotation;
        l1(this.p - this.q);
    }

    public float m0() {
        return this.r;
    }

    public float n0() {
        return this.s;
    }

    public float c() {
        return this.t;
    }

    public float D0() {
        return this.u;
    }

    public float m() {
        return this.v;
    }

    public float H0() {
        return this.w;
    }

    public void q1(float widthPercentage) {
        this.w = widthPercentage;
    }

    public boolean T0() {
        return this.b;
    }

    public void m1(boolean scaleToFitLineWhenOverflow) {
        this.b = scaleToFitLineWhenOverflow;
    }

    public boolean S0() {
        return this.f5143c;
    }

    public h3 d0() {
        return this.f5130a;
    }

    public m70 x0() {
        return this.f5136a;
    }

    public boolean O0() {
        return this.f5144d;
    }

    public void k1(int originalType) {
        this.g = originalType;
    }

    public void j1(byte[] originalData) {
        this.f5142b = originalData;
    }

    public boolean L0() {
        return this.f5145e;
    }

    public void e1(boolean deflated) {
        this.f5145e = deflated;
    }

    public void f1(int dpiX, int dpiY) {
        this.h = dpiX;
        this.i = dpiY;
    }

    public void r1(float XYRatio) {
        this.x = XYRatio;
    }

    public int g0() {
        return this.f5149j;
    }

    public void d1(int c2) {
        this.f5150k = c2;
    }

    public int f0() {
        return this.f5150k;
    }

    public boolean P0() {
        return this.f5146f;
    }

    public void i1(boolean invert) {
        this.f5146f = invert;
    }

    public void s1(dr profile) {
        this.f5128a = profile;
    }

    public boolean K0() {
        return this.f5128a != null;
    }

    public dr j0() {
        return this.f5128a;
    }

    public j60 b0() {
        return this.f5132a;
    }

    public void c1(j60 additional) {
        this.f5132a = additional;
    }

    public boolean Q0() {
        return this.f5147g;
    }

    public void V0() {
        if (R0()) {
            this.f5147g = true;
            return;
        }
        throw new ih(i10.b("this.image.can.not.be.an.image.mask", new Object[0]));
    }

    public boolean R0() {
        if ((this.c != 34 || this.d <= 255) && this.f5149j != 1) {
            return false;
        }
        return true;
    }

    public tr k0() {
        return this.f5137a;
    }

    public void g1(tr mask) {
        boolean z = false;
        if (this.f5147g) {
            throw new ih(i10.b("an.image.mask.cannot.contain.another.image.mask", new Object[0]));
        } else if (mask.f5147g) {
            this.f5137a = mask;
            int i2 = mask.d;
            if (i2 > 1 && i2 <= 8) {
                z = true;
            }
            this.f5148h = z;
        } else {
            throw new ih(i10.b("the.image.mask.is.not.a.mask.did.you.do.makemask", new Object[0]));
        }
    }

    public boolean U0() {
        return this.f5148h;
    }

    public int[] F0() {
        return this.f5140a;
    }

    public void o1(int[] transparency) {
        this.f5140a = transparency;
    }

    public int h0() {
        return this.f;
    }

    public o70 l(h70 key) {
        HashMap<h70, o70> hashMap = this.f5135a;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public void p(h70 key, o70 value) {
        if (this.f5135a == null) {
            this.f5135a = new HashMap<>();
        }
        this.f5135a.put(key, value);
    }

    public HashMap<h70, o70> u() {
        return this.f5135a;
    }

    public h70 j() {
        return this.f5131a;
    }

    public void b(h70 role) {
        this.f5131a = role;
    }

    public g0 s() {
        if (this.f5129a == null) {
            this.f5129a = new g0();
        }
        return this.f5129a;
    }

    public void h(g0 id) {
        this.f5129a = id;
    }

    public boolean isInline() {
        return true;
    }
}
