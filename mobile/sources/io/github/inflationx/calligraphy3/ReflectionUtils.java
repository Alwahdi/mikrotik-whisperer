package io.github.inflationx.calligraphy3;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectionUtils {
    private static final String TAG = ReflectionUtils.class.getSimpleName();

    ReflectionUtils() {
    }

    static Method getMethod(Class clazz, String methodName) {
        for (Method method : clazz.getMethods()) {
            if (method.getName().equals(methodName)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    static void invokeMethod(Object object, Method method, Object... args) {
        if (method != null) {
            try {
                method.invoke(object, args);
            } catch (IllegalAccessException e) {
                Log.d(TAG, "Can't access method using reflection", e);
            } catch (InvocationTargetException e2) {
                Log.d(TAG, "Can't invoke method using reflection", e2);
            }
        }
    }
}
