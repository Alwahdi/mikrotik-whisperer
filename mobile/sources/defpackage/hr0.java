package defpackage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: hr0  reason: default package */
public abstract class hr0 {
    private static final Object a;

    /* renamed from: a  reason: collision with other field name */
    private static final Method f3178a;
    private static final Method b;

    public static void f(Throwable throwable) {
        v90.n(throwable);
        if (throwable instanceof RuntimeException) {
            throw ((RuntimeException) throwable);
        } else if (throwable instanceof Error) {
            throw ((Error) throwable);
        }
    }

    public static String e(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    static {
        Object b2 = b();
        a = b2;
        Method method = null;
        f3178a = b2 == null ? null : a();
        if (b2 != null) {
            method = d();
        }
        b = method;
    }

    private static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, (ClassLoader) null).getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ThreadDeath death) {
            throw death;
        } catch (Throwable th) {
            return null;
        }
    }

    private static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    private static Method d() {
        try {
            Method getStackTraceDepth = c("getStackTraceDepth", Throwable.class);
            if (getStackTraceDepth == null) {
                return null;
            }
            getStackTraceDepth.invoke(b(), new Object[]{new Throwable()});
            return getStackTraceDepth;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException e) {
            return null;
        }
    }

    private static Method c(String name, Class<?>... parameterTypes) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod(name, parameterTypes);
        } catch (ThreadDeath death) {
            throw death;
        } catch (Throwable th) {
            return null;
        }
    }
}
