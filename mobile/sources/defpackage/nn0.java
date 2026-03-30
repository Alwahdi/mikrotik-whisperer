package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* renamed from: nn0  reason: default package */
public abstract class nn0 {
    public static byte[] c(InputStream is) {
        byte[] b = new byte[8192];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while (true) {
            int read = is.read(b);
            if (read < 1) {
                out.close();
                return out.toByteArray();
            }
            out.write(b, 0, read);
        }
    }

    public static InputStream a(String key) {
        return b(key, (ClassLoader) null);
    }

    public static InputStream b(String key, ClassLoader loader) {
        if (key.startsWith("/")) {
            key = key.substring(1);
        }
        InputStream is = null;
        if (loader != null && (is = loader.getResourceAsStream(key)) != null) {
            return is;
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                is = contextClassLoader.getResourceAsStream(key);
            }
        } catch (Throwable th) {
        }
        if (is == null) {
            is = nn0.class.getResourceAsStream("/" + key);
        }
        if (is == null) {
            return ClassLoader.getSystemResourceAsStream(key);
        }
        return is;
    }
}
