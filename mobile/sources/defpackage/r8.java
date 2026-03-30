package defpackage;

import com.itextpdf.text.pdf.a;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: r8  reason: default package */
public class r8 implements q8 {
    public a a(String location) {
        String fullName = "com/itextpdf/text/pdf/fonts/cmaps/" + location;
        InputStream inp = nn0.a(fullName);
        if (inp != null) {
            return new a(new cd0(new ed0().f(inp)));
        }
        throw new IOException(i10.b("the.cmap.1.was.not.found", fullName));
    }
}
