package defpackage;

import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* renamed from: su0  reason: default package */
abstract class su0 {
    public static final Charset a = Charset.forName(HTTP.UTF_8);

    public static void b(long size, long offset, long byteCount) {
        if ((offset | byteCount) < 0 || offset > size || size - offset < byteCount) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(size), Long.valueOf(offset), Long.valueOf(byteCount)}));
        }
    }

    public static void c(Throwable t) {
        d(t);
    }

    private static <T extends Throwable> void d(Throwable t) {
        throw t;
    }

    public static boolean a(byte[] a2, int aOffset, byte[] b, int bOffset, int byteCount) {
        for (int i = 0; i < byteCount; i++) {
            if (a2[i + aOffset] != b[i + bOffset]) {
                return false;
            }
        }
        return true;
    }
}
