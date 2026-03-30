package defpackage;

import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* renamed from: i8  reason: default package */
public final class i8 {
    public static final i8 a = new i8();

    /* renamed from: a  reason: collision with other field name */
    public static final Charset f3207a;
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;

    private i8() {
    }

    static {
        Charset forName = Charset.forName(HTTP.UTF_8);
        lu.e(forName, "forName(\"UTF-8\")");
        f3207a = forName;
        Charset forName2 = Charset.forName(HTTP.UTF_16);
        lu.e(forName2, "forName(\"UTF-16\")");
        b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        lu.e(forName3, "forName(\"UTF-16BE\")");
        c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        lu.e(forName4, "forName(\"UTF-16LE\")");
        d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        lu.e(forName5, "forName(\"US-ASCII\")");
        e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        lu.e(forName6, "forName(\"ISO-8859-1\")");
        f = forName6;
    }
}
