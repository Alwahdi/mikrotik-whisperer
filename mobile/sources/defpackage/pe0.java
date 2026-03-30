package defpackage;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: pe0  reason: default package */
final class pe0 extends i {
    private final hb a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<Class<?>> f4707a;
    private final Set<Class<?>> b;
    private final Set<Class<?>> c;
    private final Set<Class<?>> d;
    private final Set<Class<?>> e;

    pe0(cb<?> component, hb container) {
        Set<Class<?>> directInterfaces = new HashSet<>();
        Set<Class<?>> providerInterfaces = new HashSet<>();
        Set<Class<?>> setDirectInterfaces = new HashSet<>();
        Set<Class<?>> setProviderInterfaces = new HashSet<>();
        for (cg dependency : component.c()) {
            if (dependency.b()) {
                if (dependency.d()) {
                    setDirectInterfaces.add(dependency.a());
                } else {
                    directInterfaces.add(dependency.a());
                }
            } else if (dependency.d()) {
                setProviderInterfaces.add(dependency.a());
            } else {
                providerInterfaces.add(dependency.a());
            }
        }
        if (!component.f().isEmpty()) {
            directInterfaces.add(sb0.class);
        }
        this.f4707a = Collections.unmodifiableSet(directInterfaces);
        this.b = Collections.unmodifiableSet(providerInterfaces);
        this.c = Collections.unmodifiableSet(setDirectInterfaces);
        this.d = Collections.unmodifiableSet(setProviderInterfaces);
        this.e = component.f();
        this.a = container;
    }

    public <T> T d(Class<T> anInterface) {
        if (this.f4707a.contains(anInterface)) {
            T value = this.a.d(anInterface);
            if (!anInterface.equals(sb0.class)) {
                return value;
            }
            return new a(this.e, (sb0) value);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{anInterface}));
    }

    public <T> mb0<T> b(Class<T> anInterface) {
        if (this.b.contains(anInterface)) {
            return this.a.b(anInterface);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{anInterface}));
    }

    public <T> mb0<Set<T>> c(Class<T> anInterface) {
        if (this.d.contains(anInterface)) {
            return this.a.c(anInterface);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{anInterface}));
    }

    public <T> Set<T> a(Class<T> anInterface) {
        if (this.c.contains(anInterface)) {
            return this.a.a(anInterface);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{anInterface}));
    }

    /* renamed from: pe0$a */
    private static class a implements sb0 {
        private final Set<Class<?>> a;

        /* renamed from: a  reason: collision with other field name */
        private final sb0 f4708a;

        public a(Set<Class<?>> allowedPublishedEvents, sb0 delegate) {
            this.a = allowedPublishedEvents;
            this.f4708a = delegate;
        }
    }
}
