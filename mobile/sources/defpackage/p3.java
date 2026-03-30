package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: p3  reason: default package */
public abstract class p3 {
    public static AssertionError b(String message, Throwable cause) {
        AssertionError error = new AssertionError(message);
        error.initCause(cause);
        return error;
    }

    static Object a(Method method, Object instance, Object... args) {
        try {
            return method.invoke(instance, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }
}
