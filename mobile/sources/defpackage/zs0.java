package defpackage;

/* renamed from: zs0  reason: default package */
public abstract class zs0 {
    private static <T extends Throwable> T d(T throwable) {
        return lu.l(throwable, zs0.class.getName());
    }

    public static void f(Object argument, String requestedClassName) {
        String argumentClassName = argument == null ? "null" : argument.getClass().getName();
        g(argumentClassName + " cannot be cast to " + requestedClassName);
    }

    public static void g(String message) {
        throw e(new ClassCastException(message));
    }

    public static ClassCastException e(ClassCastException e) {
        throw ((ClassCastException) d(e));
    }

    public static int b(Object obj) {
        if (obj instanceof wo) {
            return ((wo) obj).getArity();
        }
        if (obj instanceof tn) {
            return 0;
        }
        if (obj instanceof vn) {
            return 1;
        }
        if (obj instanceof jo) {
            return 2;
        }
        if (obj instanceof no) {
            return 4;
        }
        return -1;
    }

    public static boolean c(Object obj, int arity) {
        return (obj instanceof oo) && b(obj) == arity;
    }

    public static Object a(Object obj, int arity) {
        if (obj != null && !c(obj, arity)) {
            f(obj, "kotlin.jvm.functions.Function" + arity);
        }
        return obj;
    }
}
