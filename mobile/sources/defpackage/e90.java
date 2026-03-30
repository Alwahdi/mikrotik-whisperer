package defpackage;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import org.apache.http.HttpStatus;

/* renamed from: e90  reason: default package */
public final class e90 {
    private byte a;

    /* renamed from: a  reason: collision with other field name */
    private int f2873a;

    /* renamed from: a  reason: collision with other field name */
    private cd0 f2874a;

    /* renamed from: a  reason: collision with other field name */
    private PrintWriter f2875a;

    /* renamed from: a  reason: collision with other field name */
    private String f2876a;

    /* renamed from: a  reason: collision with other field name */
    private short f2877a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2878a;

    /* renamed from: a  reason: collision with other field name */
    private int[] f2879a = {0, 0, 0, 0, 197, 198, 199, 0, HttpStatus.SC_ACCEPTED, 0, HttpStatus.SC_RESET_CONTENT, HttpStatus.SC_PARTIAL_CONTENT, HttpStatus.SC_MULTI_STATUS, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 33, 34, 35, 36, 37, 38, 169, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 193, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 0, 184, 166, 185, 188, 178, 179, 195, 189, 0, 172, 234, 0, 0, 0, 0, 96, 0, 170, 186, 183, 177, 208, 196, 0, 0, 173, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, 0, 0, 0, 161, 162, 163, 168, 165, 0, 167, 200, 0, 227, 171, 0, 0, 0, 197, 0, 0, 0, 0, 194, 0, 182, 180, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 0, 235, 187, 0, 0, 0, 191, 0, 0, 0, 0, 0, 0, 225, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 233, 0, 0, 0, 0, 0, 0, 251, 0, 0, 0, 0, 0, 0, 241, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 249, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a  reason: collision with other field name */
    private String[] f2880a = {"W00", "W01", "W02", "W03", "macron", "breve", "dotaccent", "W07", "ring", "W09", "W0a", "W0b", "W0c", "W0d", "W0e", "W0f", "hungarumlaut", "ogonek", "caron", "W13", "W14", "W15", "W16", "W17", "W18", "W19", "W1a", "W1b", "W1c", "W1d", "W1e", "W1f", "space", "exclam", "quotedbl", "numbersign", "dollar", "percent", "ampersand", "quotesingle", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", "period", "slash", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum", "underscore", "grave", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "braceleft", "bar", "braceright", "asciitilde", "W7f", "euro", "W81", "quotesinglbase", "florin", "quotedblbase", "ellipsis", "dagger", "daggerdbl", "circumflex", "perthousand", "Scaron", "guilsinglleft", "OE", "W8d", "Zcaron", "W8f", "W90", "quoteleft", "quoteright", "quotedblleft", "quotedblright", "bullet", "endash", "emdash", "tilde", "trademark", "scaron", "guilsinglright", "oe", "W9d", "zcaron", "Ydieresis", "reqspace", "exclamdown", "cent", "sterling", "currency", "yen", "brokenbar", "section", "dieresis", "copyright", "ordfeminine", "guillemotleft", "logicalnot", "syllable", "registered", "macron", "degree", "plusminus", "twosuperior", "threesuperior", "acute", "mu", "paragraph", "periodcentered", "cedilla", "onesuperior", "ordmasculine", "guillemotright", "onequarter", "onehalf", "threequarters", "questiondown", "Agrave", "Aacute", "Acircumflex", "Atilde", "Adieresis", "Aring", "AE", "Ccedilla", "Egrave", "Eacute", "Ecircumflex", "Edieresis", "Igrave", "Iacute", "Icircumflex", "Idieresis", "Eth", "Ntilde", "Ograve", "Oacute", "Ocircumflex", "Otilde", "Odieresis", "multiply", "Oslash", "Ugrave", "Uacute", "Ucircumflex", "Udieresis", "Yacute", "Thorn", "germandbls", "agrave", "aacute", "acircumflex", "atilde", "adieresis", "aring", "ae", "ccedilla", "egrave", "eacute", "ecircumflex", "edieresis", "igrave", "iacute", "icircumflex", "idieresis", "eth", "ntilde", "ograve", "oacute", "ocircumflex", "otilde", "odieresis", "divide", "oslash", "ugrave", "uacute", "ucircumflex", "udieresis", "yacute", "thorn", "ydieresis"};
    private byte b;

    /* renamed from: b  reason: collision with other field name */
    private int f2881b;

    /* renamed from: b  reason: collision with other field name */
    private short f2882b;

    /* renamed from: b  reason: collision with other field name */
    private int[] f2883b = {0, 0, 0, 0, 2, 2, 2, 0, 2, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private byte c;

    /* renamed from: c  reason: collision with other field name */
    private int f2884c;

    /* renamed from: c  reason: collision with other field name */
    private short f2885c;
    private byte d;

    /* renamed from: d  reason: collision with other field name */
    private int f2886d;

    /* renamed from: d  reason: collision with other field name */
    private short f2887d;
    private byte e;

    /* renamed from: e  reason: collision with other field name */
    private int f2888e;

    /* renamed from: e  reason: collision with other field name */
    private short f2889e;
    private byte f;

    /* renamed from: f  reason: collision with other field name */
    private int f2890f;

    /* renamed from: f  reason: collision with other field name */
    private short f2891f;
    private byte g;

    /* renamed from: g  reason: collision with other field name */
    private int f2892g;

    /* renamed from: g  reason: collision with other field name */
    private short f2893g;
    private int h;

    /* renamed from: h  reason: collision with other field name */
    private short f2894h;
    private int i;

    /* renamed from: i  reason: collision with other field name */
    private short f2895i;
    private int j;

    /* renamed from: j  reason: collision with other field name */
    private short f2896j;
    private int k;

    /* renamed from: k  reason: collision with other field name */
    private short f2897k;
    private int l;

    /* renamed from: l  reason: collision with other field name */
    private short f2898l;
    private int m;

    /* renamed from: m  reason: collision with other field name */
    private short f2899m;
    private short n;
    private short o;
    private short p;
    private short q;
    private short r;
    private short s;

    private e90(cd0 in, OutputStream out) {
        this.f2874a = in;
        this.f2875a = new PrintWriter(new OutputStreamWriter(out, "ISO-8859-1"));
    }

    public static void a(cd0 in, OutputStream out) {
        e90 p2 = new e90(in, out);
        p2.b();
        p2.f();
        p2.e();
        p2.g();
        p2.h();
        p2.f2875a.flush();
    }

    private String j(int n2) {
        byte[] b2 = new byte[n2];
        this.f2874a.readFully(b2);
        int k2 = 0;
        while (k2 < b2.length && b2[k2] != 0) {
            k2++;
        }
        return new String(b2, 0, k2, "ISO-8859-1");
    }

    private String i() {
        StringBuffer buf = new StringBuffer();
        while (true) {
            int c2 = this.f2874a.read();
            if (c2 <= 0) {
                return buf.toString();
            }
            buf.append((char) c2);
        }
    }

    private void d(int n2) {
        this.f2875a.print(' ');
        this.f2875a.print(n2);
    }

    private void c(int code, int width, String name) {
        this.f2875a.print("C ");
        d(code);
        this.f2875a.print(" ; WX ");
        d(width);
        if (name != null) {
            this.f2875a.print(" ; N ");
            this.f2875a.print(name);
        }
        this.f2875a.print(" ;\n");
    }

    private void b() {
        int i2;
        this.f2874a.n(0);
        this.f2877a = this.f2874a.i();
        this.f2873a = this.f2874a.g();
        this.f2876a = j(60);
        this.f2882b = this.f2874a.i();
        this.f2885c = this.f2874a.i();
        this.f2887d = this.f2874a.i();
        this.f2889e = this.f2874a.i();
        this.f2891f = this.f2874a.i();
        this.f2893g = this.f2874a.i();
        this.f2894h = this.f2874a.i();
        this.a = (byte) this.f2874a.read();
        this.b = (byte) this.f2874a.read();
        this.c = (byte) this.f2874a.read();
        this.f2895i = this.f2874a.i();
        this.d = (byte) this.f2874a.read();
        this.f2896j = this.f2874a.i();
        this.f2897k = this.f2874a.i();
        this.e = (byte) this.f2874a.read();
        this.f2898l = this.f2874a.i();
        this.f2899m = this.f2874a.i();
        this.f2881b = this.f2874a.read();
        this.f2884c = this.f2874a.read();
        this.f = (byte) this.f2874a.read();
        this.g = (byte) this.f2874a.read();
        this.n = this.f2874a.i();
        this.f2886d = this.f2874a.g();
        this.f2888e = this.f2874a.g();
        this.f2890f = this.f2874a.g();
        this.f2892g = this.f2874a.g();
        this.o = this.f2874a.i();
        this.h = this.f2874a.g();
        this.i = this.f2874a.g();
        this.j = this.f2874a.g();
        this.k = this.f2874a.g();
        this.l = this.f2874a.g();
        this.m = this.f2874a.g();
        if (((long) this.f2873a) != this.f2874a.b() || this.o != 30 || (i2 = this.m) < 75 || i2 > 512) {
            throw new IOException(i10.b("not.a.valid.pfm.file", new Object[0]));
        }
        this.f2874a.n((long) (this.h + 14));
        this.p = this.f2874a.i();
        this.q = this.f2874a.i();
        this.r = this.f2874a.i();
        this.s = this.f2874a.i();
    }

    private void f() {
        this.f2875a.print("StartFontMetrics 2.0\n");
        if (this.f2876a.length() > 0) {
            PrintWriter printWriter = this.f2875a;
            printWriter.print("Comment " + this.f2876a + 10);
        }
        this.f2875a.print("FontName ");
        this.f2874a.n((long) this.m);
        String fname = i();
        this.f2875a.print(fname);
        this.f2875a.print("\nEncodingScheme ");
        if (this.d != 0) {
            this.f2875a.print("FontSpecific\n");
        } else {
            this.f2875a.print("AdobeStandardEncoding\n");
        }
        PrintWriter printWriter2 = this.f2875a;
        printWriter2.print("FullName " + fname.replace('-', ' '));
        int i2 = this.f2888e;
        if (i2 != 0) {
            this.f2874a.n((long) i2);
            PrintWriter printWriter3 = this.f2875a;
            printWriter3.print("\nFamilyName " + i());
        }
        this.f2875a.print("\nWeight ");
        if (this.f2895i > 475 || fname.toLowerCase().indexOf("bold") >= 0) {
            this.f2875a.print("Bold");
        } else {
            short s2 = this.f2895i;
            if ((s2 < 325 && s2 != 0) || fname.toLowerCase().indexOf("light") >= 0) {
                this.f2875a.print("Light");
            } else if (fname.toLowerCase().indexOf("black") >= 0) {
                this.f2875a.print("Black");
            } else {
                this.f2875a.print("Medium");
            }
        }
        this.f2875a.print("\nItalicAngle ");
        if (this.a != 0 || fname.toLowerCase().indexOf("italic") >= 0) {
            this.f2875a.print("-12.00");
        } else {
            this.f2875a.print("0");
        }
        this.f2875a.print("\nIsFixedPitch ");
        if ((this.e & 1) == 0 || this.f2898l == this.f2899m) {
            this.f2875a.print("true");
            this.f2878a = true;
        } else {
            this.f2875a.print("false");
            this.f2878a = false;
        }
        this.f2875a.print("\nFontBBox");
        if (this.f2878a) {
            d(-20);
        } else {
            d(-100);
        }
        d(-(this.s + 5));
        d(this.f2899m + 10);
        d(this.f2891f + 5);
        this.f2875a.print("\nCapHeight");
        d(this.p);
        this.f2875a.print("\nXHeight");
        d(this.q);
        this.f2875a.print("\nDescender");
        d(-this.s);
        this.f2875a.print("\nAscender");
        d(this.r);
        this.f2875a.print(10);
    }

    private void e() {
        int count = (this.f2884c - this.f2881b) + 1;
        int[] ctabs = new int[count];
        this.f2874a.n((long) this.i);
        for (int k2 = 0; k2 < count; k2++) {
            ctabs[k2] = this.f2874a.m();
        }
        int[] back = new int[256];
        if (this.d == 0) {
            for (int i2 = this.f2881b; i2 <= this.f2884c; i2++) {
                int[] iArr = this.f2879a;
                if (iArr[i2] != 0) {
                    back[iArr[i2]] = i2;
                }
            }
        }
        this.f2875a.print("StartCharMetrics");
        d(count);
        this.f2875a.print(10);
        if (this.d != 0) {
            for (int i3 = this.f2881b; i3 <= this.f2884c; i3++) {
                int i4 = this.f2881b;
                if (ctabs[i3 - i4] != 0) {
                    c(i3, ctabs[i3 - i4], (String) null);
                }
            }
        } else {
            for (int i5 = 0; i5 < 256; i5++) {
                int j2 = back[i5];
                if (j2 != 0) {
                    c(i5, ctabs[j2 - this.f2881b], this.f2880a[j2]);
                    ctabs[j2 - this.f2881b] = 0;
                }
            }
            for (int i6 = this.f2881b; i6 <= this.f2884c; i6++) {
                int i7 = this.f2881b;
                if (ctabs[i6 - i7] != 0) {
                    c(-1, ctabs[i6 - i7], this.f2880a[i6]);
                }
            }
        }
        this.f2875a.print("EndCharMetrics\n");
    }

    private void g() {
        int i2 = this.k;
        if (i2 != 0) {
            this.f2874a.n((long) i2);
            int nzero = 0;
            int[] kerns = new int[(this.f2874a.m() * 3)];
            int k2 = 0;
            while (k2 < kerns.length) {
                int k3 = k2 + 1;
                kerns[k2] = this.f2874a.read();
                int k4 = k3 + 1;
                kerns[k3] = this.f2874a.read();
                int k5 = k4 + 1;
                int i3 = this.f2874a.i();
                kerns[k4] = i3;
                if (i3 != 0) {
                    nzero++;
                    k2 = k5;
                } else {
                    k2 = k5;
                }
            }
            if (nzero != 0) {
                this.f2875a.print("StartKernData\nStartKernPairs");
                d(nzero);
                this.f2875a.print(10);
                for (int k6 = 0; k6 < kerns.length; k6 += 3) {
                    if (kerns[k6 + 2] != 0) {
                        this.f2875a.print("KPX ");
                        this.f2875a.print(this.f2880a[kerns[k6]]);
                        this.f2875a.print(' ');
                        this.f2875a.print(this.f2880a[kerns[k6 + 1]]);
                        d(kerns[k6 + 2]);
                        this.f2875a.print(10);
                    }
                }
                this.f2875a.print("EndKernPairs\nEndKernData\n");
            }
        }
    }

    private void h() {
        this.f2875a.print("EndFontMetrics\n");
    }
}
