package com.itextpdf.text;

import com.itextpdf.text.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class c {
    private static final uy a = wy.a(c.class);

    /* renamed from: a  reason: collision with other field name */
    private static String[] f2626a = {"3", "1", "1033", "3", "0", "1033", "1", "0", "0", "0", "3", "0"};

    /* renamed from: a  reason: collision with other field name */
    public String f2627a = "Cp1252";

    /* renamed from: a  reason: collision with other field name */
    private final Hashtable<String, String> f2628a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2629a = false;
    private final Hashtable<String, ArrayList<String>> b;

    public c() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        this.f2628a = hashtable;
        Hashtable<String, ArrayList<String>> hashtable2 = new Hashtable<>();
        this.b = hashtable2;
        hashtable.put("Courier".toLowerCase(), "Courier");
        hashtable.put("Courier-Bold".toLowerCase(), "Courier-Bold");
        hashtable.put("Courier-Oblique".toLowerCase(), "Courier-Oblique");
        hashtable.put("Courier-BoldOblique".toLowerCase(), "Courier-BoldOblique");
        hashtable.put("Helvetica".toLowerCase(), "Helvetica");
        hashtable.put("Helvetica-Bold".toLowerCase(), "Helvetica-Bold");
        hashtable.put("Helvetica-Oblique".toLowerCase(), "Helvetica-Oblique");
        hashtable.put("Helvetica-BoldOblique".toLowerCase(), "Helvetica-BoldOblique");
        hashtable.put("Symbol".toLowerCase(), "Symbol");
        hashtable.put("Times-Roman".toLowerCase(), "Times-Roman");
        hashtable.put("Times-Bold".toLowerCase(), "Times-Bold");
        hashtable.put("Times-Italic".toLowerCase(), "Times-Italic");
        hashtable.put("Times-BoldItalic".toLowerCase(), "Times-BoldItalic");
        hashtable.put("ZapfDingbats".toLowerCase(), "ZapfDingbats");
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("Courier");
        tmp.add("Courier-Bold");
        tmp.add("Courier-Oblique");
        tmp.add("Courier-BoldOblique");
        hashtable2.put("Courier".toLowerCase(), tmp);
        ArrayList arrayList = new ArrayList();
        arrayList.add("Helvetica");
        arrayList.add("Helvetica-Bold");
        arrayList.add("Helvetica-Oblique");
        arrayList.add("Helvetica-BoldOblique");
        hashtable2.put("Helvetica".toLowerCase(), arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("Symbol");
        hashtable2.put("Symbol".toLowerCase(), arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add("Times-Roman");
        arrayList3.add("Times-Bold");
        arrayList3.add("Times-Italic");
        arrayList3.add("Times-BoldItalic");
        hashtable2.put("Times".toLowerCase(), arrayList3);
        hashtable2.put("Times-Roman".toLowerCase(), arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add("ZapfDingbats");
        hashtable2.put("ZapfDingbats".toLowerCase(), arrayList4);
    }

    public b b(String fontname, String encoding, boolean embedded, float size, int style, w5 color) {
        return c(fontname, encoding, embedded, size, style, color, true);
    }

    public b c(String fontname, String encoding, boolean embedded, float size, int style, w5 color, boolean cached) {
        String fontname2;
        float f = size;
        int style2 = style;
        w5 w5Var = color;
        if (fontname == null) {
            return new b(b.C0035b.UNDEFINED, f, style2, w5Var);
        }
        ArrayList<String> tmp = this.b.get(fontname.toLowerCase());
        if (tmp != null) {
            synchronized (tmp) {
                int s = style2 == -1 ? 0 : style2;
                int fs = 0;
                boolean found = false;
                try {
                    Iterator i$ = tmp.iterator();
                    while (true) {
                        if (!i$.hasNext()) {
                            fontname2 = fontname;
                            break;
                        }
                        String f2 = i$.next();
                        String lcf = f2.toLowerCase();
                        fs = 0;
                        if (lcf.indexOf("bold") != -1) {
                            fs = 0 | 1;
                        }
                        if (!(lcf.indexOf("italic") == -1 && lcf.indexOf("oblique") == -1)) {
                            fs |= 2;
                        }
                        if ((s & 3) == fs) {
                            fontname2 = f2;
                            found = true;
                            break;
                        }
                    }
                    if (style2 != -1 && found) {
                        style2 = (~fs) & style2;
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            }
        } else {
            fontname2 = fontname;
        }
        try {
            y5 basefont = a(fontname2, encoding, embedded, cached);
            if (basefont == null) {
                return new b(b.C0035b.UNDEFINED, f, style2, w5Var);
            }
            return new b(basefont, f, style2, w5Var);
        } catch (ih de) {
            throw new mj(de);
        } catch (IOException e) {
            return new b(b.C0035b.UNDEFINED, f, style2, w5Var);
        } catch (NullPointerException e2) {
            return new b(b.C0035b.UNDEFINED, f, style2, w5Var);
        }
    }

    /* access modifiers changed from: protected */
    public y5 a(String fontname, String encoding, boolean embedded, boolean cached) {
        String fontname2;
        y5 basefont = null;
        try {
            basefont = y5.f(fontname, encoding, embedded, cached, (byte[]) null, (byte[]) null, true);
        } catch (ih e) {
        }
        if (basefont != null || (fontname2 = this.f2628a.get(fontname.toLowerCase())) == null) {
            return basefont;
        }
        return y5.e(fontname2, encoding, embedded, cached, (byte[]) null, (byte[]) null);
    }
}
