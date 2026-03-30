package com.itextpdf.text;

import androidx.core.os.EnvironmentCompat;

public class b implements Comparable<b> {
    private float a;

    /* renamed from: a  reason: collision with other field name */
    private int f2622a;

    /* renamed from: a  reason: collision with other field name */
    private C0035b f2623a;

    /* renamed from: a  reason: collision with other field name */
    private w5 f2624a;

    /* renamed from: a  reason: collision with other field name */
    private y5 f2625a;

    /* renamed from: com.itextpdf.text.b$b  reason: collision with other inner class name */
    public enum C0035b {
        COURIER,
        HELVETICA,
        TIMES_ROMAN,
        SYMBOL,
        ZAPFDINGBATS,
        UNDEFINED
    }

    public b(b other) {
        this.f2623a = C0035b.UNDEFINED;
        this.a = -1.0f;
        this.f2622a = -1;
        this.f2624a = null;
        this.f2625a = null;
        this.f2623a = other.f2623a;
        this.a = other.a;
        this.f2622a = other.f2622a;
        this.f2624a = other.f2624a;
        this.f2625a = other.f2625a;
    }

    public b(C0035b family, float size, int style, w5 color) {
        this.f2623a = C0035b.UNDEFINED;
        this.a = -1.0f;
        this.f2622a = -1;
        this.f2624a = null;
        this.f2625a = null;
        this.f2623a = family;
        this.a = size;
        this.f2622a = style;
        this.f2624a = color;
    }

    public b(y5 bf, float size, int style, w5 color) {
        this.f2623a = C0035b.UNDEFINED;
        this.a = -1.0f;
        this.f2622a = -1;
        this.f2624a = null;
        this.f2625a = null;
        this.f2625a = bf;
        this.a = size;
        this.f2622a = style;
        this.f2624a = color;
    }

    public b(y5 bf, float size, int style) {
        this(bf, size, style, (w5) null);
    }

    public b(C0035b family, float size, int style) {
        this(family, size, style, (w5) null);
    }

    public b() {
        this(C0035b.UNDEFINED, -1.0f, -1, (w5) null);
    }

    /* renamed from: a */
    public int compareTo(b font) {
        if (font == null) {
            return -1;
        }
        try {
            y5 y5Var = this.f2625a;
            if (y5Var != null && !y5Var.equals(font.c())) {
                return -2;
            }
            if (this.f2623a != font.i()) {
                return 1;
            }
            if (this.a != font.k()) {
                return 2;
            }
            if (this.f2622a != font.l()) {
                return 3;
            }
            w5 w5Var = this.f2624a;
            return w5Var == null ? font.f2624a == null ? 0 : 4 : (font.f2624a != null && w5Var.equals(font.h())) ? 0 : 4;
        } catch (ClassCastException e) {
            return -3;
        }
    }

    public C0035b i() {
        return this.f2623a;
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C0035b.values().length];
            a = iArr;
            try {
                iArr[C0035b.COURIER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[C0035b.HELVETICA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[C0035b.TIMES_ROMAN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[C0035b.SYMBOL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[C0035b.ZAPFDINGBATS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public String j() {
        String tmp = EnvironmentCompat.MEDIA_UNKNOWN;
        switch (a.a[i().ordinal()]) {
            case 1:
                return "Courier";
            case 2:
                return "Helvetica";
            case 3:
                return "Times-Roman";
            case 4:
                return "Symbol";
            case 5:
                return "ZapfDingbats";
            default:
                y5 y5Var = this.f2625a;
                if (y5Var != null) {
                    for (String[] name : y5Var.k()) {
                        if ("0".equals(name[2])) {
                            return name[3];
                        }
                        if ("1033".equals(name[2])) {
                            tmp = name[3];
                        }
                        if ("".equals(name[2])) {
                            tmp = name[3];
                        }
                    }
                }
                return tmp;
        }
    }

    public float k() {
        return this.a;
    }

    public float g() {
        float s = this.a;
        if (s == -1.0f) {
            return 12.0f;
        }
        return s;
    }

    public float e(float multipliedLeading) {
        return g() * multipliedLeading;
    }

    public int l() {
        return this.f2622a;
    }

    public boolean p() {
        int i = this.f2622a;
        if (i != -1 && (i & 4) == 4) {
            return true;
        }
        return false;
    }

    public boolean o() {
        int i = this.f2622a;
        if (i != -1 && (i & 8) == 8) {
            return true;
        }
        return false;
    }

    public void r(int style) {
        this.f2622a = style;
    }

    public w5 h() {
        return this.f2624a;
    }

    public void q(w5 color) {
        this.f2624a = color;
    }

    public y5 c() {
        return this.f2625a;
    }

    public y5 d(boolean specialEncoding) {
        String fontName;
        y5 y5Var = this.f2625a;
        if (y5Var != null) {
            return y5Var;
        }
        int style = this.f2622a;
        if (style == -1) {
            style = 0;
        }
        String encoding = "Cp1252";
        switch (a.a[this.f2623a.ordinal()]) {
            case 1:
                switch (style & 3) {
                    case 1:
                        fontName = "Courier-Bold";
                        break;
                    case 2:
                        fontName = "Courier-Oblique";
                        break;
                    case 3:
                        fontName = "Courier-BoldOblique";
                        break;
                    default:
                        fontName = "Courier";
                        break;
                }
            case 3:
                switch (style & 3) {
                    case 1:
                        fontName = "Times-Bold";
                        break;
                    case 2:
                        fontName = "Times-Italic";
                        break;
                    case 3:
                        fontName = "Times-BoldItalic";
                        break;
                    default:
                        fontName = "Times-Roman";
                        break;
                }
            case 4:
                fontName = "Symbol";
                if (specialEncoding) {
                    encoding = "Symbol";
                    break;
                }
                break;
            case 5:
                fontName = "ZapfDingbats";
                if (specialEncoding) {
                    encoding = "ZapfDingbats";
                    break;
                }
                break;
            default:
                switch (style & 3) {
                    case 1:
                        fontName = "Helvetica-Bold";
                        break;
                    case 2:
                        fontName = "Helvetica-Oblique";
                        break;
                    case 3:
                        fontName = "Helvetica-BoldOblique";
                        break;
                    default:
                        fontName = "Helvetica";
                        break;
                }
        }
        try {
            return y5.d(fontName, encoding, false);
        } catch (Exception ee) {
            throw new mj(ee);
        }
    }

    public boolean n() {
        return this.f2623a == C0035b.UNDEFINED && this.a == -1.0f && this.f2622a == -1 && this.f2624a == null && this.f2625a == null;
    }

    public b b(b font) {
        if (font == null) {
            return this;
        }
        float dSize = font.a;
        if (dSize == -1.0f) {
            dSize = this.a;
        }
        int dStyle = -1;
        int style1 = this.f2622a;
        int style2 = font.l();
        if (!(style1 == -1 && style2 == -1)) {
            if (style1 == -1) {
                style1 = 0;
            }
            if (style2 == -1) {
                style2 = 0;
            }
            dStyle = style1 | style2;
        }
        w5 dColor = font.f2624a;
        if (dColor == null) {
            dColor = this.f2624a;
        }
        y5 y5Var = font.f2625a;
        if (y5Var != null) {
            return new b(y5Var, dSize, dStyle, dColor);
        }
        if (font.i() != C0035b.UNDEFINED) {
            return new b(font.f2623a, dSize, dStyle, dColor);
        }
        y5 y5Var2 = this.f2625a;
        if (y5Var2 == null) {
            return new b(this.f2623a, dSize, dStyle, dColor);
        }
        if (dStyle == style1) {
            return new b(y5Var2, dSize, dStyle, dColor);
        }
        return kn.a(j(), dSize, dStyle, dColor);
    }
}
