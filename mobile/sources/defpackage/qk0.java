package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* renamed from: qk0  reason: default package */
abstract class qk0 {

    /* renamed from: qk0$b */
    public interface b<T> {
        boolean a(T t);

        int b(T t);
    }

    public static <T> T e(Class<T> klass, Iterable<Class<?>> hardcoded, ClassLoader cl, b<T> priorityAccessor) {
        List<T> candidates = f(klass, hardcoded, cl, priorityAccessor);
        if (candidates.isEmpty()) {
            return null;
        }
        return candidates.get(0);
    }

    public static <T> List<T> f(Class<T> klass, Iterable<Class<?>> hardcoded, ClassLoader cl, b<T> priorityAccessor) {
        Iterable<T> candidates;
        if (d(cl)) {
            candidates = b(klass, hardcoded);
        } else {
            candidates = c(klass, cl);
        }
        List<T> list = new ArrayList<>();
        for (T current : candidates) {
            if (priorityAccessor.a(current)) {
                list.add(current);
            }
        }
        Collections.sort(list, Collections.reverseOrder(new a(priorityAccessor)));
        return Collections.unmodifiableList(list);
    }

    /* renamed from: qk0$a */
    class a implements Comparator<T> {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        public int compare(T f1, T f2) {
            int pd = this.a.b(f1) - this.a.b(f2);
            if (pd != 0) {
                return pd;
            }
            return f1.getClass().getName().compareTo(f2.getClass().getName());
        }
    }

    static boolean d(ClassLoader cl) {
        try {
            Class.forName("android.app.Application", false, cl);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static <T> Iterable<T> c(Class<T> klass, ClassLoader cl) {
        Iterable<T> i = ServiceLoader.load(klass, cl);
        if (!i.iterator().hasNext()) {
            return ServiceLoader.load(klass);
        }
        return i;
    }

    static <T> Iterable<T> b(Class<T> klass, Iterable<Class<?>> hardcoded) {
        List<T> list = new ArrayList<>();
        for (Class<?> candidate : hardcoded) {
            list.add(a(klass, candidate));
        }
        return list;
    }

    static <T> T a(Class<T> klass, Class<?> rawClass) {
        try {
            return rawClass.asSubclass(klass).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable t) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", new Object[]{rawClass.getName(), t}), t);
        }
    }
}
