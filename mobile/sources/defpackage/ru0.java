package defpackage;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.http.protocol.HTTP;

/* renamed from: ru0  reason: default package */
public abstract class ru0 {
    public static final Charset a = Charset.forName(HTTP.UTF_8);

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f4948a = new byte[0];

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f4949a = new String[0];

    public static <T> List<T> a(T[] elements) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) elements.clone()));
    }

    public static <T> T[] c(Class<T> arrayType, T[] first, T[] second) {
        List<T> result = b(first, second);
        return result.toArray((Object[]) Array.newInstance(arrayType, result.size()));
    }

    private static <T> List<T> b(T[] first, T[] second) {
        List<T> result = new ArrayList<>();
        for (T a2 : first) {
            int length = second.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                T b = second[i];
                if (a2.equals(b)) {
                    result.add(b);
                    break;
                }
                i++;
            }
        }
        return result;
    }
}
