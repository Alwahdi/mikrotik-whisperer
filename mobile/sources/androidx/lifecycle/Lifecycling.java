package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    public static final Lifecycling INSTANCE = new Lifecycling();
    private static final int REFLECTIVE_CALLBACK = 1;
    private static final Map<Class<?>, Integer> callbackCache = new HashMap();
    private static final Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> classToAdapters = new HashMap();

    private Lifecycling() {
    }

    public static final LifecycleEventObserver lifecycleEventObserver(Object object) {
        lu.f(object, "object");
        boolean isLifecycleEventObserver = object instanceof LifecycleEventObserver;
        boolean isDefaultLifecycleObserver = object instanceof DefaultLifecycleObserver;
        if (isLifecycleEventObserver && isDefaultLifecycleObserver) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, (LifecycleEventObserver) object);
        }
        if (isDefaultLifecycleObserver) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, (LifecycleEventObserver) null);
        }
        if (isLifecycleEventObserver) {
            return (LifecycleEventObserver) object;
        }
        Class klass = object.getClass();
        Lifecycling lifecycling = INSTANCE;
        if (lifecycling.getObserverConstructorType(klass) != 2) {
            return new ReflectiveGenericLifecycleObserver(object);
        }
        List<Constructor<? extends GeneratedAdapter>> list = classToAdapters.get(klass);
        lu.c(list);
        List constructors = list;
        if (constructors.size() == 1) {
            return new SingleGeneratedAdapterObserver(lifecycling.createGeneratedAdapter((Constructor) constructors.get(0), object));
        }
        int size = constructors.size();
        GeneratedAdapter[] adapters = new GeneratedAdapter[size];
        for (int i = 0; i < size; i++) {
            adapters[i] = INSTANCE.createGeneratedAdapter((Constructor) constructors.get(i), object);
        }
        return new CompositeGeneratedAdaptersObserver(adapters);
    }

    private final GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> constructor, Object object) {
        try {
            Object newInstance = constructor.newInstance(new Object[]{object});
            lu.e(newInstance, "{\n            constructo…tance(`object`)\n        }");
            return (GeneratedAdapter) newInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private final Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> klass) {
        String str;
        String str2;
        try {
            Package aPackage = klass.getPackage();
            String name = klass.getCanonicalName();
            String fullPackage = aPackage != null ? aPackage.getName() : "";
            lu.e(fullPackage, "fullPackage");
            if (fullPackage.length() == 0) {
                str = name;
            } else {
                lu.e(name, "name");
                str = name.substring(fullPackage.length() + 1);
                lu.e(str, "this as java.lang.String).substring(startIndex)");
            }
            lu.e(str, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String adapterName = getAdapterName(str);
            if (fullPackage.length() == 0) {
                str2 = adapterName;
            } else {
                str2 = fullPackage + '.' + adapterName;
            }
            Class aClass = Class.forName(str2);
            lu.d(aClass, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor constructor = aClass.getDeclaredConstructor(new Class[]{klass});
            if (constructor.isAccessible()) {
                return constructor;
            }
            constructor.setAccessible(true);
            return constructor;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    private final int getObserverConstructorType(Class<?> klass) {
        Map<Class<?>, Integer> map = callbackCache;
        Integer callbackCache2 = map.get(klass);
        if (callbackCache2 != null) {
            return callbackCache2.intValue();
        }
        int type = resolveObserverCallbackType(klass);
        map.put(klass, Integer.valueOf(type));
        return type;
    }

    private final int resolveObserverCallbackType(Class<?> klass) {
        if (klass.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructor = generatedConstructor(klass);
        if (constructor != null) {
            classToAdapters.put(klass, k9.b(constructor));
            return 2;
        } else if (ClassesInfoCache.sInstance.hasLifecycleMethods(klass)) {
            return 1;
        } else {
            Class superclass = klass.getSuperclass();
            List adapterConstructors = null;
            if (isLifecycleParent(superclass)) {
                lu.e(superclass, "superclass");
                if (getObserverConstructorType(superclass) == 1) {
                    return 1;
                }
                List<Constructor<? extends GeneratedAdapter>> list = classToAdapters.get(superclass);
                lu.c(list);
                adapterConstructors = new ArrayList(list);
            }
            Class[] interfaces = klass.getInterfaces();
            lu.e(interfaces, "klass.interfaces");
            for (Class intrface : interfaces) {
                if (isLifecycleParent(intrface)) {
                    lu.e(intrface, "intrface");
                    if (getObserverConstructorType(intrface) == 1) {
                        return 1;
                    }
                    if (adapterConstructors == null) {
                        adapterConstructors = new ArrayList();
                    }
                    List<Constructor<? extends GeneratedAdapter>> list2 = classToAdapters.get(intrface);
                    lu.c(list2);
                    adapterConstructors.addAll(list2);
                }
            }
            if (adapterConstructors == null) {
                return 1;
            }
            classToAdapters.put(klass, adapterConstructors);
            return 2;
        }
    }

    private final boolean isLifecycleParent(Class<?> klass) {
        return klass != null && LifecycleObserver.class.isAssignableFrom(klass);
    }

    public static final String getAdapterName(String className) {
        lu.f(className, "className");
        return do0.e(className, ".", "_", false, 4, (Object) null) + "_LifecycleAdapter";
    }
}
