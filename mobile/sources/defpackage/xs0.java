package defpackage;

import androidx.recyclerview.widget.ItemTouchHelper;
import defpackage.y5;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.StringTokenizer;

/* renamed from: xs0  reason: default package */
class xs0 extends y5 {
    private static ln a;
    private static final int[] f = {1, 2, 1};

    /* renamed from: a  reason: collision with other field name */
    private float f5754a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    protected byte[] f5755a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private HashMap<Object, Object[]> f5756b = new HashMap<>();
    private int c = -50;

    /* renamed from: c  reason: collision with other field name */
    private String f5757c;

    /* renamed from: c  reason: collision with other field name */
    private HashMap<String, Object[]> f5758c = new HashMap<>();
    private int d = -200;

    /* renamed from: d  reason: collision with other field name */
    private String f5759d;
    private int e = 1000;

    /* renamed from: e  reason: collision with other field name */
    private String f5760e = "";

    /* renamed from: f  reason: collision with other field name */
    private int f5761f = 900;

    /* renamed from: f  reason: collision with other field name */
    private String f5762f;
    private int g = -100;

    /* renamed from: g  reason: collision with other field name */
    private String f5763g = "FontSpecific";
    private int h = 50;

    /* renamed from: h  reason: collision with other field name */
    private String f5764h;

    /* renamed from: h  reason: collision with other field name */
    private boolean f5765h = false;
    private int i = 700;

    /* renamed from: i  reason: collision with other field name */
    private boolean f5766i = false;
    private int j = 480;
    private int k = 800;
    private int l = -200;
    private int m;
    private int n = 80;

    xs0(String afmFile, String enc, boolean emb, byte[] ttfAfm, byte[] pfb, boolean forceRead) {
        cd0 rf;
        cd0 rf2;
        if (!emb || ttfAfm == null || pfb != null) {
            if (emb && ttfAfm != null) {
                this.f5755a = pfb;
            }
            this.f5821a = enc;
            this.f5824a = emb;
            this.f5764h = afmFile;
            this.f5820a = 0;
            cd0 rf3 = null;
            InputStream is = null;
            if (y5.a.containsKey(afmFile)) {
                this.f5824a = false;
                this.f5766i = true;
                byte[] buf = new byte[1024];
                try {
                    if (a == null) {
                        a = new ln();
                    }
                    is = nn0.b("com/itextpdf/text/pdf/fonts/" + afmFile + ".afm", a.getClass().getClassLoader());
                    if (is != null) {
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        while (true) {
                            int size = is.read(buf);
                            if (size < 0) {
                                break;
                            }
                            out.write(buf, 0, size);
                        }
                        byte[] buf2 = out.toByteArray();
                        try {
                            is.close();
                        } catch (Exception e2) {
                        }
                        try {
                            rf3 = new cd0(buf2);
                            I(rf3);
                            try {
                                rf3.close();
                            } catch (Exception e3) {
                            }
                        } catch (Throwable th) {
                            if (rf3 != null) {
                                try {
                                    rf3.close();
                                } catch (Exception e4) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        String msg = i10.b("1.not.found.as.resource", afmFile);
                        System.err.println(msg);
                        throw new ih(msg);
                    }
                } catch (Throwable th2) {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th2;
                }
            } else if (afmFile.toLowerCase().endsWith(".afm")) {
                if (ttfAfm == null) {
                    try {
                        rf2 = new cd0(afmFile, forceRead, gh.f);
                    } catch (Throwable th3) {
                        if (rf3 != null) {
                            try {
                                rf3.close();
                            } catch (Exception e6) {
                            }
                        }
                        throw th3;
                    }
                } else {
                    rf2 = new cd0(ttfAfm);
                }
                I(rf2);
                try {
                    rf2.close();
                } catch (Exception e7) {
                }
            } else if (afmFile.toLowerCase().endsWith(".pfm")) {
                try {
                    ByteArrayOutputStream ba = new ByteArrayOutputStream();
                    if (ttfAfm == null) {
                        rf = new cd0(afmFile, forceRead, gh.f);
                    } else {
                        rf = new cd0(ttfAfm);
                    }
                    e90.a(rf, ba);
                    rf.close();
                    cd0 rf4 = new cd0(ba.toByteArray());
                    I(rf4);
                    try {
                        rf4.close();
                    } catch (Exception e8) {
                    }
                } catch (Throwable th4) {
                    if (rf3 != null) {
                        try {
                            rf3.close();
                        } catch (Exception e9) {
                        }
                    }
                    throw th4;
                }
            } else {
                throw new ih(i10.b("1.is.not.an.afm.or.pfm.font.file", afmFile));
            }
            String trim = this.f5763g.trim();
            this.f5763g = trim;
            if (trim.equals("AdobeStandardEncoding") || this.f5763g.equals("StandardEncoding")) {
                this.f5830b = false;
            }
            if (!this.f5821a.startsWith("#")) {
                n60.c(" ", enc);
            }
            c();
            return;
        }
        throw new ih(i10.b("two.byte.arrays.are.needed.if.the.type1.font.is.embedded", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public int q(int c2, String name) {
        Object[] metrics;
        if (name == null) {
            metrics = this.f5756b.get(Integer.valueOf(c2));
        } else if (name.equals(".notdef")) {
            return 0;
        } else {
            metrics = this.f5756b.get(name);
        }
        if (metrics != null) {
            return ((Integer) metrics[1]).intValue();
        }
        return 0;
    }

    public int n(int char1, int char2) {
        String second;
        Object[] obj;
        String first = mp.b(char1);
        if (first == null || (second = mp.b(char2)) == null || (obj = this.f5758c.get(first)) == null) {
            return 0;
        }
        for (int k2 = 0; k2 < obj.length; k2 += 2) {
            if (second.equals(obj[k2])) {
                return ((Integer) obj[k2 + 1]).intValue();
            }
        }
        return 0;
    }

    public void I(cd0 rf) {
        Object[] space;
        boolean isMetrics = false;
        while (true) {
            String readLine = rf.readLine();
            String line = readLine;
            if (readLine == null) {
                break;
            }
            StringTokenizer tok = new StringTokenizer(line, " ,\n\r\t\f");
            if (tok.hasMoreTokens()) {
                String ident = tok.nextToken();
                if (ident.equals("FontName")) {
                    this.b = tok.nextToken("ÿ").substring(1);
                } else if (ident.equals("FullName")) {
                    this.f5757c = tok.nextToken("ÿ").substring(1);
                } else if (ident.equals("FamilyName")) {
                    this.f5759d = tok.nextToken("ÿ").substring(1);
                } else if (ident.equals("Weight")) {
                    this.f5760e = tok.nextToken("ÿ").substring(1);
                } else if (ident.equals("ItalicAngle")) {
                    this.f5754a = Float.parseFloat(tok.nextToken());
                } else if (ident.equals("IsFixedPitch")) {
                    this.f5765h = tok.nextToken().equals("true");
                } else if (ident.equals("CharacterSet")) {
                    this.f5762f = tok.nextToken("ÿ").substring(1);
                } else if (ident.equals("FontBBox")) {
                    this.c = (int) Float.parseFloat(tok.nextToken());
                    this.d = (int) Float.parseFloat(tok.nextToken());
                    this.e = (int) Float.parseFloat(tok.nextToken());
                    this.f5761f = (int) Float.parseFloat(tok.nextToken());
                } else if (ident.equals("UnderlinePosition")) {
                    this.g = (int) Float.parseFloat(tok.nextToken());
                } else if (ident.equals("UnderlineThickness")) {
                    this.h = (int) Float.parseFloat(tok.nextToken());
                } else if (ident.equals("EncodingScheme")) {
                    this.f5763g = tok.nextToken("ÿ").substring(1);
                } else if (ident.equals("CapHeight")) {
                    this.i = (int) Float.parseFloat(tok.nextToken());
                } else if (ident.equals("XHeight")) {
                    this.j = (int) Float.parseFloat(tok.nextToken());
                } else if (ident.equals("Ascender")) {
                    this.k = (int) Float.parseFloat(tok.nextToken());
                } else if (ident.equals("Descender")) {
                    this.l = (int) Float.parseFloat(tok.nextToken());
                } else if (ident.equals("StdHW")) {
                    this.m = (int) Float.parseFloat(tok.nextToken());
                } else if (ident.equals("StdVW")) {
                    this.n = (int) Float.parseFloat(tok.nextToken());
                } else if (ident.equals("StartCharMetrics")) {
                    isMetrics = true;
                    break;
                }
            }
        }
        if (isMetrics) {
            while (true) {
                String readLine2 = rf.readLine();
                String line2 = readLine2;
                if (readLine2 == null) {
                    break;
                }
                StringTokenizer tok2 = new StringTokenizer(line2);
                if (tok2.hasMoreTokens()) {
                    if (tok2.nextToken().equals("EndCharMetrics")) {
                        isMetrics = false;
                        break;
                    }
                    Integer C = -1;
                    Integer WX = Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                    String N = "";
                    int[] B = null;
                    StringTokenizer tok3 = new StringTokenizer(line2, ";");
                    while (tok3.hasMoreTokens()) {
                        StringTokenizer tokc = new StringTokenizer(tok3.nextToken());
                        if (tokc.hasMoreTokens()) {
                            String ident2 = tokc.nextToken();
                            if (ident2.equals("C")) {
                                C = Integer.valueOf(tokc.nextToken());
                            } else if (ident2.equals("WX")) {
                                WX = Integer.valueOf((int) Float.parseFloat(tokc.nextToken()));
                            } else if (ident2.equals("N")) {
                                N = tokc.nextToken();
                            } else if (ident2.equals("B")) {
                                B = new int[]{Integer.parseInt(tokc.nextToken()), Integer.parseInt(tokc.nextToken()), Integer.parseInt(tokc.nextToken()), Integer.parseInt(tokc.nextToken())};
                            }
                        }
                    }
                    Object[] metrics = {C, WX, N, B};
                    if (C.intValue() >= 0) {
                        this.f5756b.put(C, metrics);
                    }
                    this.f5756b.put(N, metrics);
                }
            }
            if (!isMetrics) {
                if (!this.f5756b.containsKey("nonbreakingspace") && (space = this.f5756b.get("space")) != null) {
                    this.f5756b.put("nonbreakingspace", space);
                }
                while (true) {
                    String readLine3 = rf.readLine();
                    String line3 = readLine3;
                    if (readLine3 == null) {
                        break;
                    }
                    StringTokenizer tok4 = new StringTokenizer(line3);
                    if (tok4.hasMoreTokens()) {
                        String ident3 = tok4.nextToken();
                        if (!ident3.equals("EndFontMetrics")) {
                            if (ident3.equals("StartKernPairs")) {
                                isMetrics = true;
                                break;
                            }
                        } else {
                            return;
                        }
                    }
                }
                if (isMetrics) {
                    while (true) {
                        String readLine4 = rf.readLine();
                        String line4 = readLine4;
                        if (readLine4 == null) {
                            break;
                        }
                        StringTokenizer tok5 = new StringTokenizer(line4);
                        if (tok5.hasMoreTokens()) {
                            String ident4 = tok5.nextToken();
                            if (ident4.equals("KPX")) {
                                String first = tok5.nextToken();
                                String second = tok5.nextToken();
                                Integer width = Integer.valueOf((int) Float.parseFloat(tok5.nextToken()));
                                Object[] relates = this.f5758c.get(first);
                                if (relates == null) {
                                    this.f5758c.put(first, new Object[]{second, width});
                                } else {
                                    int n2 = relates.length;
                                    Object[] relates2 = new Object[(n2 + 2)];
                                    System.arraycopy(relates, 0, relates2, 0, n2);
                                    relates2[n2] = second;
                                    relates2[n2 + 1] = width;
                                    this.f5758c.put(first, relates2);
                                }
                            } else if (ident4.equals("EndKernPairs")) {
                                isMetrics = false;
                                break;
                            }
                        }
                    }
                    if (!isMetrics) {
                        rf.close();
                    } else {
                        throw new ih(i10.b("missing.endkernpairs.in.1", this.f5764h));
                    }
                } else {
                    throw new ih(i10.b("missing.endfontmetrics.in.1", this.f5764h));
                }
            } else {
                throw new ih(i10.b("missing.endcharmetrics.in.1", this.f5764h));
            }
        } else {
            throw new ih(i10.b("missing.startcharmetrics.in.1", this.f5764h));
        }
    }

    public m80 H() {
        cd0 rf;
        if (this.f5766i || !this.f5824a) {
            return null;
        }
        cd0 rf2 = null;
        try {
            StringBuilder sb = new StringBuilder();
            String str = this.f5764h;
            sb.append(str.substring(0, str.length() - 3));
            sb.append("pfb");
            String filePfb = sb.toString();
            byte[] bArr = this.f5755a;
            if (bArr == null) {
                rf = new cd0(filePfb, true, gh.f);
            } else {
                rf = new cd0(bArr);
            }
            byte[] st = new byte[(((int) rf.b()) - 18)];
            int[] lengths = new int[3];
            int bytePtr = 0;
            int k2 = 0;
            while (k2 < 3) {
                if (rf.read() != 128) {
                    throw new ih(i10.b("start.marker.missing.in.1", filePfb));
                } else if (rf.read() == f[k2]) {
                    int size = rf.read() + (rf.read() << 8) + (rf.read() << 16) + (rf.read() << 24);
                    lengths[k2] = size;
                    while (size != 0) {
                        int got = rf.read(st, bytePtr, size);
                        if (got >= 0) {
                            bytePtr += got;
                            size -= got;
                        } else {
                            throw new ih(i10.b("premature.end.in.1", filePfb));
                        }
                    }
                    k2++;
                } else {
                    throw new ih(i10.b("incorrect.segment.type.in.1", filePfb));
                }
            }
            y5.a aVar = new y5.a(st, lengths, this.f5829b);
            try {
                rf.close();
            } catch (Exception e2) {
            }
            return aVar;
        } catch (Exception e3) {
            throw new ih(e3);
        } catch (Throwable th) {
            if (rf2 != null) {
                try {
                    rf2.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    private j60 G(z60 fontStream) {
        if (this.f5766i) {
            return null;
        }
        j60 dic = new j60(h70.e4);
        dic.Q(h70.P, new k70(this.k));
        dic.Q(h70.I0, new k70(this.i));
        dic.Q(h70.n2, new k70(this.l));
        dic.Q(h70.d4, new f80((float) this.c, (float) this.d, (float) this.e, (float) this.f5761f));
        dic.Q(h70.k4, new h70(this.b));
        dic.Q(h70.O5, new k70(this.f5754a));
        dic.Q(h70.hb, new k70(this.n));
        if (fontStream != null) {
            dic.Q(h70.g4, fontStream);
        }
        int flags = 0;
        if (this.f5765h) {
            flags = 0 | 1;
        }
        int flags2 = flags | (this.f5830b ? 4 : 32);
        if (this.f5754a < 0.0f) {
            flags2 |= 64;
        }
        if (this.b.indexOf("Caps") >= 0 || this.b.endsWith("SC")) {
            flags2 |= 131072;
        }
        if (this.f5760e.equals("Bold")) {
            flags2 |= 262144;
        }
        dic.Q(h70.X3, new k70(flags2));
        return dic;
    }

    private j60 F(z60 fontDescriptor, int firstChar, int lastChar, byte[] shortTag) {
        j60 dic = new j60(h70.c4);
        dic.Q(h70.tb, h70.Dc);
        dic.Q(h70.c0, new h70(this.b));
        boolean stdEncoding = this.f5821a.equals("Cp1252") || this.f5821a.equals("MacRoman");
        if (!this.f5830b || this.f5823a != null) {
            int k2 = firstChar;
            while (true) {
                if (k2 > lastChar) {
                    break;
                } else if (!this.f5827a[k2].equals(".notdef")) {
                    firstChar = k2;
                    break;
                } else {
                    k2++;
                }
            }
            if (stdEncoding) {
                dic.Q(h70.d3, this.f5821a.equals("Cp1252") ? h70.Dd : h70.J6);
            } else {
                j60 enc = new j60(h70.d3);
                x50 dif = new x50();
                boolean gap = true;
                for (int k3 = firstChar; k3 <= lastChar; k3++) {
                    if (shortTag[k3] != 0) {
                        if (gap) {
                            dif.I(new k70(k3));
                            gap = false;
                        }
                        dif.I(new h70(this.f5827a[k3]));
                    } else {
                        gap = true;
                    }
                }
                enc.Q(h70.w2, dif);
                dic.Q(h70.d3, enc);
            }
        }
        if (this.f5823a != null || this.f5831c || !this.f5766i || (!this.f5830b && !stdEncoding)) {
            dic.Q(h70.M3, new k70(firstChar));
            dic.Q(h70.g6, new k70(lastChar));
            x50 wd = new x50();
            for (int k4 = firstChar; k4 <= lastChar; k4++) {
                if (shortTag[k4] == 0) {
                    wd.I(new k70(0));
                } else {
                    wd.I(new k70(this.f5826a[k4]));
                }
            }
            dic.Q(h70.Bd, wd);
        }
        if (!this.f5766i && fontDescriptor != null) {
            dic.Q(h70.e4, fontDescriptor);
        }
        return dic;
    }

    /* access modifiers changed from: package-private */
    public void E(v80 writer, z60 ref, Object[] params) {
        boolean subsetp = false;
        int firstChar = params[0].intValue();
        int lastChar = params[1].intValue();
        byte[] shortTag = params[2];
        if (params[3].booleanValue() && this.f5833e) {
            subsetp = true;
        }
        if (!subsetp || !this.f5824a) {
            firstChar = 0;
            lastChar = shortTag.length - 1;
            for (int k2 = 0; k2 < shortTag.length; k2++) {
                shortTag[k2] = 1;
            }
        }
        z60 ind_font = null;
        o70 pobj = H();
        if (pobj != null) {
            ind_font = writer.y(pobj).a();
        }
        o70 pobj2 = G(ind_font);
        if (pobj2 != null) {
            ind_font = writer.y(pobj2).a();
        }
        writer.z(F(ind_font, firstChar, lastChar, shortTag), ref);
    }

    public float l(int key, float fontSize) {
        switch (key) {
            case 1:
            case 9:
                return (((float) this.k) * fontSize) / 1000.0f;
            case 2:
                return (((float) this.i) * fontSize) / 1000.0f;
            case 3:
            case 10:
                return (((float) this.l) * fontSize) / 1000.0f;
            case 4:
                return this.f5754a;
            case 5:
                return (((float) this.c) * fontSize) / 1000.0f;
            case 6:
                return (((float) this.d) * fontSize) / 1000.0f;
            case 7:
                return (((float) this.e) * fontSize) / 1000.0f;
            case 8:
                return (((float) this.f5761f) * fontSize) / 1000.0f;
            case 11:
                return 0.0f;
            case 12:
                return (((float) (this.e - this.c)) * fontSize) / 1000.0f;
            case 13:
                return (((float) this.g) * fontSize) / 1000.0f;
            case 14:
                return (((float) this.h) * fontSize) / 1000.0f;
            default:
                return 0.0f;
        }
    }

    public String o() {
        return this.b;
    }

    public String[][] k() {
        return new String[][]{new String[]{"", "", "", this.f5759d}};
    }

    public boolean y() {
        return !this.f5758c.isEmpty();
    }

    /* access modifiers changed from: protected */
    public int[] p(int c2, String name) {
        Object[] metrics;
        if (name == null) {
            metrics = this.f5756b.get(Integer.valueOf(c2));
        } else if (name.equals(".notdef")) {
            return null;
        } else {
            metrics = this.f5756b.get(name);
        }
        if (metrics != null) {
            return (int[]) metrics[3];
        }
        return null;
    }
}
