package defpackage;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/* renamed from: c  reason: default package */
public abstract class c {
    public static final void c(Field $receiver, Object obj, Object value) {
        lu.g($receiver, "receiver$0");
        lu.g(obj, "obj");
        lu.g(value, "value");
        try {
            $receiver.set(obj, value);
        } catch (IllegalAccessException e) {
        }
    }

    public static final Method a(Class<?> $receiver, String methodName) {
        lu.g($receiver, "receiver$0");
        lu.g(methodName, "methodName");
        for (Method method : $receiver.getMethods()) {
            lu.b(method, "method");
            if (lu.a(method.getName(), methodName)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public static final void b(Method $receiver, Object target, Object... args) {
        lu.g(target, "target");
        lu.g(args, "args");
        if ($receiver != null) {
            try {
                $receiver.invoke(target, Arrays.copyOf(args, args.length));
            } catch (IllegalAccessException e) {
                Log.d("ReflectionUtils", "Can't access method using reflection", e);
            } catch (InvocationTargetException e2) {
                Log.d("ReflectionUtils", "Can't invoke method using reflection", e2);
            }
        }
    }
}
