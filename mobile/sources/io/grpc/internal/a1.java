package io.grpc.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class a1 implements cz {
    private static final RuntimeException a;

    /* renamed from: a  reason: collision with other field name */
    private static final Constructor<?> f3292a;

    /* renamed from: a  reason: collision with other field name */
    private static final Method f3293a;

    /* renamed from: a  reason: collision with other field name */
    private static final Logger f3294a = Logger.getLogger(a1.class.getName());
    private static final Method b;

    /* renamed from: a  reason: collision with other field name */
    private final Object f3295a;

    static {
        Constructor<?> defaultConstructorLookup = null;
        Method addMethodLookup = null;
        Method sumMethodLookup = null;
        Throwable caught = null;
        try {
            Class<?> klass = Class.forName("java.util.concurrent.atomic.LongAdder");
            int i = 0;
            addMethodLookup = klass.getMethod("add", new Class[]{Long.TYPE});
            sumMethodLookup = klass.getMethod("sum", new Class[0]);
            Constructor<?>[] constructors = klass.getConstructors();
            int length = constructors.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                Constructor<?> ctor = constructors[i];
                if (ctor.getParameterTypes().length == 0) {
                    defaultConstructorLookup = ctor;
                    break;
                }
                i++;
            }
        } catch (Throwable e) {
            f3294a.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", e);
            caught = e;
        }
        if (caught != null || defaultConstructorLookup == null) {
            f3292a = null;
            f3293a = null;
            b = null;
            a = new RuntimeException(caught);
            return;
        }
        f3292a = defaultConstructorLookup;
        f3293a = addMethodLookup;
        b = sumMethodLookup;
        a = null;
    }

    a1() {
        RuntimeException runtimeException = a;
        if (runtimeException == null) {
            try {
                this.f3295a = f3292a.newInstance(new Object[0]);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        } else {
            throw runtimeException;
        }
    }

    static boolean b() {
        return a == null;
    }

    public void a(long delta) {
        try {
            f3293a.invoke(this.f3295a, new Object[]{Long.valueOf(delta)});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }
}
