package defpackage;

import com.itextpdf.text.pdf.Glyph;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: jn  reason: default package */
class jn {
    int a;

    /* renamed from: a  reason: collision with other field name */
    e7 f4075a;

    /* renamed from: a  reason: collision with other field name */
    h70 f4076a;

    /* renamed from: a  reason: collision with other field name */
    HashMap<Integer, int[]> f4077a;

    /* renamed from: a  reason: collision with other field name */
    us0 f4078a;

    /* renamed from: a  reason: collision with other field name */
    y5 f4079a;

    /* renamed from: a  reason: collision with other field name */
    ys f4080a;

    /* renamed from: a  reason: collision with other field name */
    z60 f4081a;

    /* renamed from: a  reason: collision with other field name */
    boolean f4082a;

    /* renamed from: a  reason: collision with other field name */
    byte[] f4083a;
    protected boolean b = true;

    jn(h70 fontName, z60 indirectReference, y5 baseFont) {
        this.f4076a = fontName;
        this.f4081a = indirectReference;
        this.f4079a = baseFont;
        int m = baseFont.m();
        this.a = m;
        switch (m) {
            case 0:
            case 1:
                this.f4083a = new byte[256];
                return;
            case 2:
                this.f4080a = new ys();
                this.f4075a = (e7) baseFont;
                return;
            case 3:
                this.f4077a = new HashMap<>();
                this.f4078a = (us0) baseFont;
                this.f4082a = baseFont.A();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public z60 g() {
        return this.f4081a;
    }

    /* access modifiers changed from: package-private */
    public h70 e() {
        return this.f4076a;
    }

    /* access modifiers changed from: package-private */
    public y5 d() {
        return this.f4079a;
    }

    /* access modifiers changed from: package-private */
    public byte[] b(String text) {
        int val;
        int val2;
        String str = text;
        char c = 1;
        switch (this.a) {
            case 0:
            case 1:
                byte[] b2 = this.f4079a.b(str);
                for (byte b3 : b2) {
                    this.f4083a[b3 & 255] = 1;
                }
                return b2;
            case 2:
                int len = text.length();
                if (this.f4075a.Q()) {
                    for (int k = 0; k < len; k++) {
                        this.f4080a.d(str.charAt(k), 0);
                    }
                } else {
                    int k2 = 0;
                    while (k2 < len) {
                        if (tu0.h(str, k2)) {
                            val = tu0.c(str, k2);
                            k2++;
                        } else {
                            val = str.charAt(k2);
                        }
                        this.f4080a.d(this.f4075a.K(val), 0);
                        k2++;
                    }
                }
                return this.f4075a.b(str);
            case 3:
                try {
                    int len2 = text.length();
                    char[] glyph = new char[len2];
                    int i = 0;
                    if (this.f4082a) {
                        byte[] b4 = n60.c(str, "symboltt");
                        int len3 = b4.length;
                        int k3 = 0;
                        while (k3 < len3) {
                            int[] metrics = this.f4078a.Q(b4[k3] & 255);
                            if (metrics != null) {
                                HashMap<Integer, int[]> hashMap = this.f4077a;
                                Integer valueOf = Integer.valueOf(metrics[0]);
                                int[] iArr = new int[3];
                                iArr[0] = metrics[0];
                                iArr[c] = metrics[c];
                                iArr[2] = this.f4078a.r(b4[k3] & 255);
                                hashMap.put(valueOf, iArr);
                                glyph[i] = (char) metrics[0];
                                i++;
                            }
                            k3++;
                            c = 1;
                        }
                    } else if (a()) {
                        return c(text);
                    } else {
                        int k4 = 0;
                        while (k4 < len2) {
                            if (tu0.h(str, k4)) {
                                val2 = tu0.c(str, k4);
                                k4++;
                            } else {
                                val2 = str.charAt(k4);
                            }
                            int[] metrics2 = this.f4078a.Q(val2);
                            if (metrics2 != null) {
                                int m0 = metrics2[0];
                                Integer gl = Integer.valueOf(m0);
                                if (!this.f4077a.containsKey(gl)) {
                                    this.f4077a.put(gl, new int[]{m0, metrics2[1], val2});
                                }
                                glyph[i] = (char) m0;
                                i++;
                            }
                            k4++;
                        }
                    }
                    return qn0.a(tu0.e(glyph, 0, i));
                } catch (UnsupportedEncodingException e) {
                    throw new mj(e);
                }
            case 4:
                return this.f4079a.b(str);
            case 5:
                return this.f4079a.b(str);
            default:
                return null;
        }
    }

    private boolean a() {
        return this.a == 3 && this.f4078a.j0() != null;
    }

    private byte[] c(String text) {
        if (a()) {
            Map<String, lp> j0 = this.f4078a.j0();
            Set<String> compositeCharacters = new TreeSet<>(new ls());
            compositeCharacters.addAll(j0.keySet());
            y3 tokenizer = new y3((String[]) compositeCharacters.toArray(new String[0]));
            String[] tokens = tokenizer.b(text);
            List<Glyph> glyphList = new ArrayList<>(50);
            String[] arr$ = tokens;
            int len$ = arr$.length;
            int i$ = 0;
            while (i$ < len$) {
                String token = arr$[i$];
                lp subsGlyph = j0.get(token);
                if (subsGlyph != null) {
                    glyphList.add(subsGlyph);
                } else {
                    char[] arr$2 = token.toCharArray();
                    int len$2 = arr$2.length;
                    int i$2 = 0;
                    while (i$2 < len$2) {
                        char c = arr$2[i$2];
                        Map<String, lp> map = j0;
                        int[] metrics = this.f4078a.Q(c);
                        int[] iArr = metrics;
                        glyphList.add(new lp(metrics[0], metrics[1], String.valueOf(c)));
                        i$2++;
                        String str = text;
                        j0 = map;
                        compositeCharacters = compositeCharacters;
                        tokenizer = tokenizer;
                    }
                }
                i$++;
                String str2 = text;
                j0 = j0;
                compositeCharacters = compositeCharacters;
                tokenizer = tokenizer;
            }
            Map<String, lp> map2 = j0;
            Set<String> set = compositeCharacters;
            y3 y3Var = tokenizer;
            np glyphRepositioner = f();
            if (glyphRepositioner != null) {
                glyphRepositioner.a(glyphList);
            }
            char[] charEncodedGlyphCodes = new char[glyphList.size()];
            for (int i = 0; i < glyphList.size(); i++) {
                lp glyph = (lp) glyphList.get(i);
                int i2 = glyph.a;
                charEncodedGlyphCodes[i] = (char) i2;
                Integer glyphCode = Integer.valueOf(i2);
                if (!this.f4077a.containsKey(glyphCode)) {
                    this.f4077a.put(glyphCode, new int[]{glyph.a, glyph.b, glyph.f4267a.charAt(0)});
                }
            }
            return new String(charEncodedGlyphCodes).getBytes("UnicodeBigUnmarked");
        }
        throw new IllegalArgumentException("Make sure the font type if TTF Unicode and a valid GlyphSubstitutionTable exists!");
    }

    private np f() {
        com.itextpdf.text.pdf.fonts.otf.a language = this.f4078a.k0();
        if (language != null) {
            switch (a.a[language.ordinal()]) {
                case 1:
                    return new s5(Collections.unmodifiableMap(this.f4078a.f5034d), this.f4078a.j0());
                default:
                    return null;
            }
        } else {
            throw new IllegalArgumentException("The supported language field cannot be null in " + this.f4078a.getClass().getName());
        }
    }

    /* renamed from: jn$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.itextpdf.text.pdf.fonts.otf.a.values().length];
            a = iArr;
            try {
                iArr[com.itextpdf.text.pdf.fonts.otf.a.BENGALI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public void i(v80 writer) {
        try {
            switch (this.a) {
                case 0:
                case 1:
                    int firstChar = 0;
                    while (true) {
                        if (firstChar < 256) {
                            if (this.f4083a[firstChar] == 0) {
                                firstChar++;
                            }
                        }
                    }
                    int lastChar = 255;
                    while (true) {
                        if (lastChar >= firstChar) {
                            if (this.f4083a[lastChar] == 0) {
                                lastChar--;
                            }
                        }
                    }
                    if (firstChar > 255) {
                        firstChar = 255;
                        lastChar = 255;
                    }
                    this.f4079a.E(writer, this.f4081a, new Object[]{Integer.valueOf(firstChar), Integer.valueOf(lastChar), this.f4083a, Boolean.valueOf(this.b)});
                    return;
                case 2:
                    this.f4079a.E(writer, this.f4081a, new Object[]{this.f4080a});
                    return;
                case 3:
                    this.f4079a.E(writer, this.f4081a, new Object[]{this.f4077a, Boolean.valueOf(this.b)});
                    return;
                case 5:
                    this.f4079a.E(writer, this.f4081a, (Object[]) null);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            throw new mj(e);
        }
    }

    public void h(boolean subset) {
        this.b = subset;
    }
}
