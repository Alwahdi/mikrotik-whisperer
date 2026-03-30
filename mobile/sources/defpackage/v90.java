package defpackage;

/* renamed from: v90  reason: default package */
public abstract class v90 {
    public static void d(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void f(boolean b, String errorMessageTemplate, char p1) {
        if (!b) {
            throw new IllegalArgumentException(sn0.b(errorMessageTemplate, Character.valueOf(p1)));
        }
    }

    public static void h(boolean b, String errorMessageTemplate, int p1) {
        if (!b) {
            throw new IllegalArgumentException(sn0.b(errorMessageTemplate, Integer.valueOf(p1)));
        }
    }

    public static void i(boolean b, String errorMessageTemplate, long p1) {
        if (!b) {
            throw new IllegalArgumentException(sn0.b(errorMessageTemplate, Long.valueOf(p1)));
        }
    }

    public static void j(boolean b, String errorMessageTemplate, Object p1) {
        if (!b) {
            throw new IllegalArgumentException(sn0.b(errorMessageTemplate, p1));
        }
    }

    public static void g(boolean b, String errorMessageTemplate, char p1, Object p2) {
        if (!b) {
            throw new IllegalArgumentException(sn0.b(errorMessageTemplate, Character.valueOf(p1), p2));
        }
    }

    public static void k(boolean b, String errorMessageTemplate, Object p1, Object p2) {
        if (!b) {
            throw new IllegalArgumentException(sn0.b(errorMessageTemplate, p1, p2));
        }
    }

    public static void t(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    public static void u(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    public static void v(boolean b, String errorMessageTemplate, int p1) {
        if (!b) {
            throw new IllegalStateException(sn0.b(errorMessageTemplate, Integer.valueOf(p1)));
        }
    }

    public static void w(boolean b, String errorMessageTemplate, Object p1) {
        if (!b) {
            throw new IllegalStateException(sn0.b(errorMessageTemplate, p1));
        }
    }

    public static <T> T n(T reference) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException();
    }

    public static <T> T o(T reference, Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    public static <T> T p(T obj, String errorMessageTemplate, Object p1) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(sn0.b(errorMessageTemplate, p1));
    }

    public static int l(int index, int size) {
        return m(index, size, "index");
    }

    public static int m(int index, int size, String desc) {
        if (index >= 0 && index < size) {
            return index;
        }
        throw new IndexOutOfBoundsException(a(index, size, desc));
    }

    private static String a(int index, int size, String desc) {
        if (index < 0) {
            return sn0.b("%s (%s) must not be negative", desc, Integer.valueOf(index));
        } else if (size >= 0) {
            return sn0.b("%s (%s) must be less than size (%s)", desc, Integer.valueOf(index), Integer.valueOf(size));
        } else {
            throw new IllegalArgumentException("negative size: " + size);
        }
    }

    public static int q(int index, int size) {
        return r(index, size, "index");
    }

    public static int r(int index, int size, String desc) {
        if (index >= 0 && index <= size) {
            return index;
        }
        throw new IndexOutOfBoundsException(b(index, size, desc));
    }

    private static String b(int index, int size, String desc) {
        if (index < 0) {
            return sn0.b("%s (%s) must not be negative", desc, Integer.valueOf(index));
        } else if (size >= 0) {
            return sn0.b("%s (%s) must not be greater than size (%s)", desc, Integer.valueOf(index), Integer.valueOf(size));
        } else {
            throw new IllegalArgumentException("negative size: " + size);
        }
    }

    public static void s(int start, int end, int size) {
        if (start < 0 || end < start || end > size) {
            throw new IndexOutOfBoundsException(c(start, end, size));
        }
    }

    private static String c(int start, int end, int size) {
        if (start < 0 || start > size) {
            return b(start, size, "start index");
        }
        if (end < 0 || end > size) {
            return b(end, size, "end index");
        }
        return sn0.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(end), Integer.valueOf(start));
    }
}
