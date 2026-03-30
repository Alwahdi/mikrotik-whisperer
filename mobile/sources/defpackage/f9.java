package defpackage;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.protocol.HTTP;

/* renamed from: f9  reason: default package */
public interface f9 extends tb, ff {

    /* renamed from: f9$a */
    public static final class a implements f9 {
        public String a() {
            return "gzip";
        }

        public OutputStream c(OutputStream os) {
            return new GZIPOutputStream(os);
        }

        public InputStream b(InputStream is) {
            return new GZIPInputStream(is);
        }
    }

    /* renamed from: f9$b */
    public static final class b implements f9 {
        public static final f9 a = new b();

        public InputStream b(InputStream is) {
            return is;
        }

        public String a() {
            return HTTP.IDENTITY_CODING;
        }

        public OutputStream c(OutputStream os) {
            return os;
        }

        private b() {
        }
    }
}
