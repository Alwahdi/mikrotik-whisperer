package defpackage;

import javax.inject.Provider;

/* renamed from: sh  reason: default package */
public final class sh<T> implements Provider<T> {
    private static final Object b = new Object();
    private volatile Object a = b;

    /* renamed from: a  reason: collision with other field name */
    private volatile Provider<T> f4985a;

    private sh(Provider<T> provider) {
        if (provider != null) {
            this.f4985a = provider;
            return;
        }
        throw new AssertionError();
    }

    public T get() {
        Object result = this.a;
        Object obj = b;
        if (result == obj) {
            synchronized (this) {
                result = this.a;
                if (result == obj) {
                    result = this.f4985a.get();
                    this.a = b(this.a, result);
                    this.f4985a = null;
                }
            }
        }
        return result;
    }

    public static Object b(Object currentInstance, Object newInstance) {
        if (!(currentInstance != b) || currentInstance == newInstance) {
            return newInstance;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + currentInstance + " & " + newInstance + ". This is likely due to a circular dependency.");
    }

    public static <P extends Provider<T>, T> Provider<T> a(P delegate) {
        x90.b(delegate);
        if (delegate instanceof sh) {
            return delegate;
        }
        return new sh(delegate);
    }
}
