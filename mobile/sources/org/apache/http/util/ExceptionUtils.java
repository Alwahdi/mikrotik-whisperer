package org.apache.http.util;

import java.lang.reflect.Method;

public final class ExceptionUtils {
    private static final Method INIT_CAUSE_METHOD = getInitCauseMethod();
    static /* synthetic */ Class class$java$lang$Throwable;

    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }

    private static Method getInitCauseMethod() {
        try {
            Class[] paramsClasses = new Class[1];
            Class cls = class$java$lang$Throwable;
            if (cls == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            }
            paramsClasses[0] = cls;
            Class cls2 = class$java$lang$Throwable;
            if (cls2 == null) {
                cls2 = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls2;
            }
            return cls2.getMethod("initCause", paramsClasses);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static void initCause(Throwable throwable, Throwable cause) {
        Method method = INIT_CAUSE_METHOD;
        if (method != null) {
            try {
                method.invoke(throwable, new Object[]{cause});
            } catch (Exception e) {
            }
        }
    }

    private ExceptionUtils() {
    }
}
