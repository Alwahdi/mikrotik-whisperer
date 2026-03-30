package defpackage;

import java.lang.reflect.Method;

/* renamed from: d20  reason: default package */
final class d20 {
    private static final a a = new a((Method) null, (Method) null, (Method) null);

    /* renamed from: a  reason: collision with other field name */
    public static final d20 f2697a = new d20();
    private static a b;

    /* renamed from: d20$a */
    private static final class a {
        public final Method a;
        public final Method b;
        public final Method c;

        public a(Method getModuleMethod, Method getDescriptorMethod, Method nameMethod) {
            this.a = getModuleMethod;
            this.b = getDescriptorMethod;
            this.c = nameMethod;
        }
    }

    private d20() {
    }

    public final String b(kotlin.coroutines.jvm.internal.a continuation) {
        lu.f(continuation, "continuation");
        a cache = b;
        if (cache == null) {
            cache = a(continuation);
        }
        if (cache == a) {
            return null;
        }
        Method method = cache.a;
        Object module = method != null ? method.invoke(continuation.getClass(), new Object[0]) : null;
        if (module == null) {
            return null;
        }
        Method method2 = cache.b;
        Object descriptor = method2 != null ? method2.invoke(module, new Object[0]) : null;
        if (descriptor == null) {
            return null;
        }
        Method method3 = cache.c;
        Object invoke = method3 != null ? method3.invoke(descriptor, new Object[0]) : null;
        if (invoke instanceof String) {
            return (String) invoke;
        }
        return null;
    }

    private final a a(kotlin.coroutines.jvm.internal.a continuation) {
        try {
            a it = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), continuation.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), continuation.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            b = it;
            return it;
        } catch (Exception e) {
            a it2 = a;
            b = it2;
            return it2;
        }
    }
}
