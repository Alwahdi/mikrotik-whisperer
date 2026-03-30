package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

/* renamed from: e7  reason: default package */
class e7 extends y5 {
    static Properties a = new Properties();
    static Properties b = new Properties();
    private static final HashMap<String, HashMap<String, Object>> c = new HashMap<>();
    private static final HashMap<String, Set<String>> d = new HashMap<>();
    private static boolean i = false;

    /* renamed from: a  reason: collision with other field name */
    private h7 f2857a;

    /* renamed from: a  reason: collision with other field name */
    private i7 f2858a;

    /* renamed from: a  reason: collision with other field name */
    private k7 f2859a;

    /* renamed from: b  reason: collision with other field name */
    private String f2860b;

    /* renamed from: b  reason: collision with other field name */
    private HashMap<String, Object> f2861b;

    /* renamed from: b  reason: collision with other field name */
    private ys f2862b;

    /* renamed from: c  reason: collision with other field name */
    private String f2863c;

    /* renamed from: c  reason: collision with other field name */
    private ys f2864c;

    /* renamed from: d  reason: collision with other field name */
    private String f2865d = "";
    private String e;
    private boolean h = false;

    private static void S() {
        if (!i) {
            synchronized (c) {
                if (!i) {
                    try {
                        T();
                        for (String font : d.get("fonts")) {
                            c.put(font, U(font));
                        }
                    } catch (Exception e2) {
                    }
                    i = true;
                }
            }
        }
    }

    private static void T() {
        InputStream is = nn0.a("com/itextpdf/text/pdf/fonts/cmaps/cjk_registry.properties");
        Properties p = new Properties();
        p.load(is);
        is.close();
        for (Object key : p.keySet()) {
            String[] sp = p.getProperty((String) key).split(" ");
            Set<String> hs = new HashSet<>();
            for (String s : sp) {
                if (s.length() > 0) {
                    hs.add(s);
                }
            }
            d.put((String) key, hs);
        }
    }

    e7(String fontName, String enc, boolean emb) {
        S();
        this.f5820a = 2;
        String nameBase = y5.i(fontName);
        if (P(nameBase, enc)) {
            if (nameBase.length() < fontName.length()) {
                this.f2865d = fontName.substring(nameBase.length());
                fontName = nameBase;
            }
            this.f2863c = fontName;
            this.f5821a = "UnicodeBigUnmarked";
            this.g = enc.endsWith("V");
            this.e = enc;
            if (enc.equals("Identity-H") || enc.equals("Identity-V")) {
                this.h = true;
            }
            R();
            return;
        }
        throw new ih(i10.b("font.1.with.2.encoding.is.not.a.cjk.font", fontName, enc));
    }

    private void R() {
        try {
            HashMap<String, Object> hashMap = c.get(this.f2863c);
            this.f2861b = hashMap;
            this.f2864c = (ys) hashMap.get("W");
            this.f2862b = (ys) this.f2861b.get("W2");
            this.f2860b = "";
            HashMap<String, Set<String>> hashMap2 = d;
            Iterator i$ = hashMap2.get(((String) this.f2861b.get("Registry")) + "_Uni").iterator();
            while (true) {
                if (!i$.hasNext()) {
                    break;
                }
                String name = (String) i$.next();
                this.f2860b = name;
                if (!name.endsWith("V") || !this.g) {
                    if (!name.endsWith("V") && !this.g) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (this.h) {
                this.f2858a = g7.b(this.f2860b);
                return;
            }
            this.f2859a = g7.c(this.f2860b);
            this.f2857a = g7.a(this.e);
        } catch (Exception ex) {
            throw new ih(ex);
        }
    }

    public static boolean P(String fontName, String enc) {
        S();
        HashMap<String, Set<String>> hashMap = d;
        if (!hashMap.containsKey("fonts") || !hashMap.get("fonts").contains(fontName)) {
            return false;
        }
        if (enc.equals("Identity-H") || enc.equals("Identity-V")) {
            return true;
        }
        Set<String> encodings = hashMap.get((String) c.get(fontName).get("Registry"));
        if (encodings == null || !encodings.contains(enc)) {
            return false;
        }
        return true;
    }

    public int t(int char1) {
        int v;
        int c2 = char1;
        if (!this.h) {
            c2 = this.f2859a.n(char1);
        }
        if (this.g) {
            v = this.f2862b.b(c2);
        } else {
            v = this.f2864c.b(c2);
        }
        if (v > 0) {
            return v;
        }
        return 1000;
    }

    public int u(String text) {
        int val;
        int total = 0;
        if (this.h) {
            for (int k = 0; k < text.length(); k++) {
                total += t(text.charAt(k));
            }
        } else {
            int k2 = 0;
            while (k2 < text.length()) {
                if (tu0.h(text, k2)) {
                    val = tu0.c(text, k2);
                    k2++;
                } else {
                    val = text.charAt(k2);
                }
                total += t(val);
                k2++;
            }
        }
        return total;
    }

    /* access modifiers changed from: package-private */
    public int q(int c2, String name) {
        return 0;
    }

    public int n(int char1, int char2) {
        return 0;
    }

    private j60 N() {
        j60 dic = new j60(h70.e4);
        dic.Q(h70.P, new f70((String) this.f2861b.get("Ascent")));
        dic.Q(h70.I0, new f70((String) this.f2861b.get("CapHeight")));
        dic.Q(h70.n2, new f70((String) this.f2861b.get("Descent")));
        dic.Q(h70.X3, new f70((String) this.f2861b.get("Flags")));
        dic.Q(h70.d4, new f70((String) this.f2861b.get("FontBBox")));
        h70 h70 = h70.k4;
        dic.Q(h70, new h70(this.f2863c + this.f2865d));
        dic.Q(h70.O5, new f70((String) this.f2861b.get("ItalicAngle")));
        dic.Q(h70.hb, new f70((String) this.f2861b.get("StemV")));
        j60 pdic = new j60();
        pdic.Q(h70.s8, new n80((String) this.f2861b.get("Panose"), (String) null));
        dic.Q(h70.pb, pdic);
        return dic;
    }

    private j60 J(z60 fontDescriptor, ys cjkTag) {
        j60 dic = new j60(h70.c4);
        dic.Q(h70.tb, h70.Z0);
        h70 h70 = h70.c0;
        dic.Q(h70, new h70(this.f2863c + this.f2865d));
        dic.Q(h70.e4, fontDescriptor);
        int[] keys = cjkTag.h();
        String w = F(keys, this.f2864c);
        if (w != null) {
            dic.Q(h70.ud, new f70(w));
        }
        if (this.g) {
            String w2 = G(keys, this.f2862b, this.f2864c);
            if (w2 != null) {
                dic.Q(h70.vd, new f70(w2));
            }
        } else {
            dic.Q(h70.S2, new k70(1000));
        }
        j60 cdic = new j60();
        if (this.h) {
            cdic.Q(h70.H9, new n80(this.f2858a.g(), (String) null));
            cdic.Q(h70.b8, new n80(this.f2858a.f(), (String) null));
            cdic.Q(h70.vb, new k70(this.f2858a.h()));
        } else {
            cdic.Q(h70.H9, new n80(this.f2857a.g(), (String) null));
            cdic.Q(h70.b8, new n80(this.f2857a.f(), (String) null));
            cdic.Q(h70.vb, new k70(this.f2857a.h()));
        }
        dic.Q(h70.c1, cdic);
        return dic;
    }

    private j60 M(z60 CIDFont) {
        j60 dic = new j60(h70.c4);
        dic.Q(h70.tb, h70.Cc);
        String name = this.f2863c;
        if (this.f2865d.length() > 0) {
            name = name + "-" + this.f2865d.substring(1);
        }
        dic.Q(h70.c0, new h70(name + "-" + this.e));
        dic.Q(h70.d3, new h70(this.e));
        dic.Q(h70.m2, new x50((o70) CIDFont));
        return dic;
    }

    /* access modifiers changed from: package-private */
    public void E(v80 writer, z60 ref, Object[] params) {
        ys cjkTag = params[0];
        z60 ind_font = null;
        o70 pobj = N();
        if (pobj != null) {
            ind_font = writer.y(pobj).a();
        }
        o70 pobj2 = J(ind_font, cjkTag);
        if (pobj2 != null) {
            ind_font = writer.y(pobj2).a();
        }
        writer.z(M(ind_font), ref);
    }

    private float L(String name) {
        return (float) Integer.parseInt((String) this.f2861b.get(name));
    }

    private float I(int idx) {
        StringTokenizer tk = new StringTokenizer((String) this.f2861b.get("FontBBox"), " []\r\n\t\f");
        String ret = tk.nextToken();
        for (int k = 0; k < idx; k++) {
            ret = tk.nextToken();
        }
        return (float) Integer.parseInt(ret);
    }

    public float l(int key, float fontSize) {
        switch (key) {
            case 1:
            case 9:
                return (L("Ascent") * fontSize) / 1000.0f;
            case 2:
                return (L("CapHeight") * fontSize) / 1000.0f;
            case 3:
            case 10:
                return (L("Descent") * fontSize) / 1000.0f;
            case 4:
                return L("ItalicAngle");
            case 5:
                return (I(0) * fontSize) / 1000.0f;
            case 6:
                return (I(1) * fontSize) / 1000.0f;
            case 7:
                return (I(2) * fontSize) / 1000.0f;
            case 8:
                return (I(3) * fontSize) / 1000.0f;
            case 11:
                return 0.0f;
            case 12:
                return ((I(2) - I(0)) * fontSize) / 1000.0f;
            default:
                return 0.0f;
        }
    }

    public String o() {
        return this.f2863c;
    }

    public String[][] O() {
        return new String[][]{new String[]{"", "", "", this.f2863c}};
    }

    public String[][] k() {
        return O();
    }

    static ys H(String s) {
        ys h2 = new ys();
        StringTokenizer tk = new StringTokenizer(s);
        while (tk.hasMoreTokens()) {
            h2.d(Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken()));
        }
        return h2;
    }

    static String F(int[] keys, ys h2) {
        if (keys.length == 0) {
            return null;
        }
        int lastCid = 0;
        int lastValue = 0;
        int start = 0;
        while (true) {
            if (start >= keys.length) {
                break;
            }
            lastCid = keys[start];
            lastValue = h2.b(lastCid);
            if (lastValue != 0) {
                start++;
                break;
            }
            start++;
        }
        if (lastValue == 0) {
            return null;
        }
        StringBuilder buf = new StringBuilder();
        buf.append('[');
        buf.append(lastCid);
        int state = 0;
        for (int k = start; k < keys.length; k++) {
            int cid = keys[k];
            int value = h2.b(cid);
            if (value != 0) {
                switch (state) {
                    case 0:
                        if (cid != lastCid + 1 || value != lastValue) {
                            if (cid != lastCid + 1) {
                                buf.append('[');
                                buf.append(lastValue);
                                buf.append(']');
                                buf.append(cid);
                                break;
                            } else {
                                state = 1;
                                buf.append('[');
                                buf.append(lastValue);
                                break;
                            }
                        } else {
                            state = 2;
                            break;
                        }
                    case 1:
                        if (cid != lastCid + 1 || value != lastValue) {
                            if (cid != lastCid + 1) {
                                state = 0;
                                buf.append(' ');
                                buf.append(lastValue);
                                buf.append(']');
                                buf.append(cid);
                                break;
                            } else {
                                buf.append(' ');
                                buf.append(lastValue);
                                break;
                            }
                        } else {
                            state = 2;
                            buf.append(']');
                            buf.append(lastCid);
                            break;
                        }
                    case 2:
                        if (!(cid == lastCid + 1 && value == lastValue)) {
                            buf.append(' ');
                            buf.append(lastCid);
                            buf.append(' ');
                            buf.append(lastValue);
                            buf.append(' ');
                            buf.append(cid);
                            state = 0;
                            break;
                        }
                }
                lastValue = value;
                lastCid = cid;
            }
        }
        switch (state) {
            case 0:
                buf.append('[');
                buf.append(lastValue);
                buf.append("]]");
                break;
            case 1:
                buf.append(' ');
                buf.append(lastValue);
                buf.append("]]");
                break;
            case 2:
                buf.append(' ');
                buf.append(lastCid);
                buf.append(' ');
                buf.append(lastValue);
                buf.append(']');
                break;
        }
        return buf.toString();
    }

    static String G(int[] keys, ys v, ys h2) {
        if (keys.length == 0) {
            return null;
        }
        int lastCid = 0;
        int lastValue = 0;
        int lastHValue = 0;
        int start = 0;
        while (true) {
            if (start >= keys.length) {
                break;
            }
            lastCid = keys[start];
            lastValue = v.b(lastCid);
            if (lastValue != 0) {
                start++;
                break;
            }
            lastHValue = h2.b(lastCid);
            start++;
        }
        if (lastValue == 0) {
            return null;
        }
        if (lastHValue == 0) {
            lastHValue = 1000;
        }
        StringBuilder buf = new StringBuilder();
        buf.append('[');
        buf.append(lastCid);
        int state = 0;
        for (int k = start; k < keys.length; k++) {
            int cid = keys[k];
            int value = v.b(cid);
            if (value != 0) {
                int hValue = h2.b(lastCid);
                if (hValue == 0) {
                    hValue = 1000;
                }
                switch (state) {
                    case 0:
                        if (cid != lastCid + 1 || value != lastValue || hValue != lastHValue) {
                            buf.append(' ');
                            buf.append(lastCid);
                            buf.append(' ');
                            buf.append(-lastValue);
                            buf.append(' ');
                            buf.append(lastHValue / 2);
                            buf.append(' ');
                            buf.append(880);
                            buf.append(' ');
                            buf.append(cid);
                            break;
                        } else {
                            state = 2;
                            break;
                        }
                    case 2:
                        if (!(cid == lastCid + 1 && value == lastValue && hValue == lastHValue)) {
                            buf.append(' ');
                            buf.append(lastCid);
                            buf.append(' ');
                            buf.append(-lastValue);
                            buf.append(' ');
                            buf.append(lastHValue / 2);
                            buf.append(' ');
                            buf.append(880);
                            buf.append(' ');
                            buf.append(cid);
                            state = 0;
                            break;
                        }
                }
                lastValue = value;
                lastCid = cid;
                lastHValue = hValue;
            }
        }
        buf.append(' ');
        buf.append(lastCid);
        buf.append(' ');
        buf.append(-lastValue);
        buf.append(' ');
        buf.append(lastHValue / 2);
        buf.append(' ');
        buf.append(880);
        buf.append(" ]");
        return buf.toString();
    }

    private static HashMap<String, Object> U(String name) {
        InputStream is = nn0.a("com/itextpdf/text/pdf/fonts/cmaps/" + (name + ".properties"));
        Properties p = new Properties();
        p.load(is);
        is.close();
        ys W = H(p.getProperty("W"));
        p.remove("W");
        ys W2 = H(p.getProperty("W2"));
        p.remove("W2");
        HashMap<String, Object> map = new HashMap<>();
        Enumeration<Object> e2 = p.keys();
        while (e2.hasMoreElements()) {
            Object obj = e2.nextElement();
            map.put((String) obj, p.getProperty((String) obj));
        }
        map.put("W", W);
        map.put("W2", W2);
        return map;
    }

    public int s(int c2) {
        if (!this.h) {
            return c2;
        }
        if (c2 == 32767) {
            return 10;
        }
        return this.f2858a.n(c2);
    }

    public int K(int c2) {
        if (this.h) {
            return c2;
        }
        return this.f2859a.n(c2);
    }

    public boolean y() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int[] p(int c2, String name) {
        return null;
    }

    public byte[] b(String text) {
        int val;
        if (this.h) {
            return super.b(text);
        }
        try {
            if (text.length() == 1) {
                return a(text.charAt(0));
            }
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            int k = 0;
            while (k < text.length()) {
                if (tu0.h(text, k)) {
                    val = tu0.c(text, k);
                    k++;
                } else {
                    val = text.charAt(k);
                }
                bout.write(a(val));
                k++;
            }
            return bout.toByteArray();
        } catch (Exception ex) {
            throw new mj(ex);
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] a(int char1) {
        if (this.h) {
            return super.a(char1);
        }
        return this.f2857a.n(this.f2859a.n(char1));
    }

    public boolean Q() {
        return this.h;
    }
}
