package defpackage;

import java.io.UnsupportedEncodingException;

/* renamed from: m10  reason: default package */
public class m10 extends n10 {
    static final String[] a = {"Courier", "Courier-Bold", "Courier-Oblique", "Courier-BoldOblique", "Helvetica", "Helvetica-Bold", "Helvetica-Oblique", "Helvetica-BoldOblique", "Times-Roman", "Times-Bold", "Times-Italic", "Times-BoldItalic", "Symbol", "ZapfDingbats"};

    /* renamed from: a  reason: collision with other field name */
    float f4304a;

    /* renamed from: a  reason: collision with other field name */
    String f4305a = "arial";

    /* renamed from: a  reason: collision with other field name */
    y5 f4306a = null;

    /* renamed from: a  reason: collision with other field name */
    boolean f4307a;
    int b;

    /* renamed from: b  reason: collision with other field name */
    boolean f4308b;
    int c;
    int d;
    int e;
    int f;

    public m10() {
        this.a = 3;
    }

    public void e(rs in) {
        this.b = Math.abs(in.e());
        int i = 2;
        in.g(2);
        this.f4304a = (float) ((((double) in.e()) / 1800.0d) * 3.141592653589793d);
        in.g(2);
        boolean z = true;
        this.c = in.e() >= 600 ? 1 : 0;
        if (in.b() == 0) {
            i = 0;
        }
        this.d = i;
        this.f4307a = in.b() != 0;
        if (in.b() == 0) {
            z = false;
        }
        this.f4308b = z;
        this.e = in.b();
        in.g(3);
        this.f = in.b();
        byte[] name = new byte[32];
        int k = 0;
        while (k < 32) {
            int c2 = in.b();
            if (c2 != 0) {
                name[k] = (byte) c2;
                k++;
            }
        }
        try {
            this.f4305a = new String(name, 0, k, "Cp1252");
        } catch (UnsupportedEncodingException e2) {
            this.f4305a = new String(name, 0, k);
        }
        this.f4305a = this.f4305a.toLowerCase();
    }

    public y5 c() {
        String fontName;
        y5 y5Var = this.f4306a;
        if (y5Var != null) {
            return y5Var;
        }
        y5 c2 = kn.b(this.f4305a, "Cp1252", true, 10.0f, (this.d != 0 ? 2 : 0) | (this.c != 0 ? 1 : 0)).c();
        this.f4306a = c2;
        if (c2 != null) {
            return c2;
        }
        if (this.f4305a.indexOf("courier") == -1 && this.f4305a.indexOf("terminal") == -1 && this.f4305a.indexOf("fixedsys") == -1) {
            if (this.f4305a.indexOf("ms sans serif") == -1 && this.f4305a.indexOf("arial") == -1 && this.f4305a.indexOf("system") == -1) {
                if (this.f4305a.indexOf("arial black") == -1) {
                    if (this.f4305a.indexOf("times") == -1 && this.f4305a.indexOf("ms serif") == -1 && this.f4305a.indexOf("roman") == -1) {
                        if (this.f4305a.indexOf("symbol") == -1) {
                            int i = this.f;
                            int pitch = i & 3;
                            switch ((i >> 4) & 7) {
                                case 1:
                                    fontName = a[this.d + 8 + this.c];
                                    break;
                                case 2:
                                case 4:
                                case 5:
                                    fontName = a[this.d + 4 + this.c];
                                    break;
                                case 3:
                                    fontName = a[this.d + 0 + this.c];
                                    break;
                                default:
                                    switch (pitch) {
                                        case 1:
                                            fontName = a[this.d + 0 + this.c];
                                            break;
                                        default:
                                            fontName = a[this.d + 4 + this.c];
                                            break;
                                    }
                            }
                        } else {
                            fontName = a[12];
                        }
                    } else {
                        fontName = a[this.d + 8 + this.c];
                    }
                } else {
                    fontName = a[this.d + 4 + 1];
                }
            } else {
                fontName = a[this.d + 4 + this.c];
            }
        } else {
            fontName = a[this.d + 0 + this.c];
        }
        try {
            y5 d2 = y5.d(fontName, "Cp1252", false);
            this.f4306a = d2;
            return d2;
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    public float b() {
        return this.f4304a;
    }

    public boolean g() {
        return this.f4307a;
    }

    public boolean f() {
        return this.f4308b;
    }

    public float d(p10 state) {
        return Math.abs(state.H(this.b) - state.H(0)) * gh.e;
    }
}
