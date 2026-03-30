package defpackage;

/* renamed from: x30  reason: default package */
public abstract class x30 {
    public static <T> T[] d(T[] reference, int length) {
        return j90.b(reference, length);
    }

    static Object[] b(Object... array) {
        return c(array, array.length);
    }

    static Object[] c(Object[] array, int length) {
        for (int i = 0; i < length; i++) {
            a(array[i], i);
        }
        return array;
    }

    static Object a(Object element, int index) {
        if (element != null) {
            return element;
        }
        throw new NullPointerException("at index " + index);
    }
}
