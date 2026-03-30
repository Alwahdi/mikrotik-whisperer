package io.grpc;

import io.grpc.l;
import java.nio.charset.Charset;

public abstract class j {
    public static final Charset a = Charset.forName("US-ASCII");

    /* renamed from: a  reason: collision with other field name */
    public static final x5 f3797a = l.f3799a;

    public interface a<T> extends l.j<T> {
    }

    public static <T> l.g<T> b(String name, a<T> marshaller) {
        boolean isPseudo = false;
        if (name != null && !name.isEmpty() && name.charAt(0) == ':') {
            isPseudo = true;
        }
        return l.g.g(name, isPseudo, marshaller);
    }

    public static l c(byte[]... binaryValues) {
        return new l(binaryValues);
    }

    public static byte[][] d(l md) {
        return md.p();
    }

    public static int a(l md) {
        return md.g();
    }
}
