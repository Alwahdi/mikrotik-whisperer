package defpackage;

import com.itextpdf.text.b;
import com.itextpdf.text.c;

/* renamed from: kn  reason: default package */
public abstract class kn {
    private static c a = new c();

    /* renamed from: a  reason: collision with other field name */
    public static String f4125a = "Cp1252";

    /* renamed from: a  reason: collision with other field name */
    public static boolean f4126a = false;

    public static b c(String fontname, String encoding, boolean embedded, float size, int style, w5 color) {
        return a.b(fontname, encoding, embedded, size, style, color);
    }

    public static b b(String fontname, String encoding, boolean embedded, float size, int style) {
        return c(fontname, encoding, embedded, size, style, (w5) null);
    }

    public static b a(String fontname, float size, int style, w5 color) {
        return c(fontname, f4125a, f4126a, size, style, color);
    }
}
