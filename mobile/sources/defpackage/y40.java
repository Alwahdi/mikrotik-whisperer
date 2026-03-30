package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: y40  reason: default package */
public class y40<T> {
    private final Class<?> a;

    /* renamed from: a  reason: collision with other field name */
    private final String f5816a;

    /* renamed from: a  reason: collision with other field name */
    private final Class[] f5817a;

    public y40(Class<?> returnType, String methodName, Class... methodParams) {
        this.a = returnType;
        this.f5816a = methodName;
        this.f5817a = methodParams;
    }

    public boolean g(T target) {
        return a(target.getClass()) != null;
    }

    public Object d(T target, Object... args) {
        Method m = a(target.getClass());
        if (m == null) {
            return null;
        }
        try {
            return m.invoke(target, args);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public Object e(T target, Object... args) {
        try {
            return d(target, args);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError error = new AssertionError("Unexpected exception");
            error.initCause(targetException);
            throw error;
        }
    }

    public Object c(T target, Object... args) {
        Method m = a(target.getClass());
        if (m != null) {
            try {
                return m.invoke(target, args);
            } catch (IllegalAccessException e) {
                AssertionError error = new AssertionError("Unexpectedly could not call: " + m);
                error.initCause(e);
                throw error;
            }
        } else {
            throw new AssertionError("Method " + this.f5816a + " not supported for object " + target);
        }
    }

    public Object f(T target, Object... args) {
        try {
            return c(target, args);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError error = new AssertionError("Unexpected exception");
            error.initCause(targetException);
            throw error;
        }
    }

    private Method a(Class<?> clazz) {
        Class<?> cls;
        String str = this.f5816a;
        if (str == null) {
            return null;
        }
        Method method = b(clazz, str, this.f5817a);
        if (method == null || (cls = this.a) == null || cls.isAssignableFrom(method.getReturnType())) {
            return method;
        }
        return null;
    }

    private static Method b(Class<?> clazz, String methodName, Class[] parameterTypes) {
        if (clazz == null) {
            return null;
        }
        try {
            if ((clazz.getModifiers() & 1) == 0) {
                return b(clazz.getSuperclass(), methodName, parameterTypes);
            }
            Method method = clazz.getMethod(methodName, parameterTypes);
            if ((method.getModifiers() & 1) == 0) {
                return null;
            }
            return method;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}
