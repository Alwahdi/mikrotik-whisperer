package defpackage;

import java.util.Arrays;

/* renamed from: lu  reason: default package */
public abstract class lu {
    public static void c(Object object) {
        if (object == null) {
            m();
        }
    }

    public static void d(Object object, String message) {
        if (object == null) {
            n(message);
        }
    }

    public static void m() {
        throw ((NullPointerException) k(new NullPointerException()));
    }

    public static void n(String message) {
        throw ((NullPointerException) k(new NullPointerException(message)));
    }

    public static void s(String message) {
        throw ((it0) k(new it0(message)));
    }

    public static void t(String propertyName) {
        s("lateinit property " + propertyName + " has not been initialized");
    }

    public static void b(Object value, String expression) {
        if (value == null) {
            throw ((IllegalStateException) k(new IllegalStateException(expression + " must not be null")));
        }
    }

    public static void e(Object value, String expression) {
        if (value == null) {
            throw ((NullPointerException) k(new NullPointerException(expression + " must not be null")));
        }
    }

    public static void g(Object value, String paramName) {
        if (value == null) {
            o(paramName);
        }
    }

    public static void f(Object value, String paramName) {
        if (value == null) {
            p(paramName);
        }
    }

    private static void o(String paramName) {
        throw ((IllegalArgumentException) k(new IllegalArgumentException(i(paramName))));
    }

    private static void p(String paramName) {
        throw ((NullPointerException) k(new NullPointerException(i(paramName))));
    }

    private static String i(String paramName) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String thisClassName = lu.class.getName();
        int i = 0;
        while (!stackTraceElements[i].getClassName().equals(thisClassName)) {
            i++;
        }
        while (stackTraceElements[i].getClassName().equals(thisClassName)) {
            i++;
        }
        StackTraceElement caller = stackTraceElements[i];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + paramName;
    }

    public static int h(int thisVal, int anotherVal) {
        if (thisVal < anotherVal) {
            return -1;
        }
        return thisVal == anotherVal ? 0 : 1;
    }

    public static boolean a(Object first, Object second) {
        if (first == null) {
            return second == null;
        }
        return first.equals(second);
    }

    public static void q() {
        r("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void r(String message) {
        throw new UnsupportedOperationException(message);
    }

    public static void j(int id, String typeParameterIdentifier) {
        q();
    }

    private static <T extends Throwable> T k(T throwable) {
        return l(throwable, lu.class.getName());
    }

    static <T extends Throwable> T l(T throwable, String classNameToDrop) {
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int size = stackTrace.length;
        int lastIntrinsic = -1;
        for (int i = 0; i < size; i++) {
            if (classNameToDrop.equals(stackTrace[i].getClassName())) {
                lastIntrinsic = i;
            }
        }
        throwable.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, lastIntrinsic + 1, size));
        return throwable;
    }
}
