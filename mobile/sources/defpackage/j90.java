package defpackage;

import java.lang.reflect.Array;
import java.util.Arrays;

/* renamed from: j90  reason: default package */
abstract class j90 {
    static <T> T[] b(T[] reference, int length) {
        return (Object[]) Array.newInstance(reference.getClass().getComponentType(), length);
    }

    static <T> T[] a(Object[] source, int from, int to, T[] arrayOfType) {
        return Arrays.copyOfRange(source, from, to, arrayOfType.getClass());
    }
}
