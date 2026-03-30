package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: cb  reason: default package */
public final class cb<T> {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<Class<? super T>> f323a;

    /* renamed from: a  reason: collision with other field name */
    private final kb<T> f324a;
    private final int b;

    /* renamed from: b  reason: collision with other field name */
    private final Set<cg> f325b;
    private final Set<Class<?>> c;

    private cb(Set<Class<? super T>> providedInterfaces, Set<cg> dependencies, int instantiation, int type, kb<T> factory, Set<Class<?>> publishedEvents) {
        this.f323a = Collections.unmodifiableSet(providedInterfaces);
        this.f325b = Collections.unmodifiableSet(dependencies);
        this.a = instantiation;
        this.b = type;
        this.f324a = factory;
        this.c = Collections.unmodifiableSet(publishedEvents);
    }

    public Set<Class<? super T>> e() {
        return this.f323a;
    }

    public Set<cg> c() {
        return this.f325b;
    }

    public kb<T> d() {
        return this.f324a;
    }

    public Set<Class<?>> f() {
        return this.c;
    }

    public boolean i() {
        return this.a == 1;
    }

    public boolean j() {
        return this.a == 2;
    }

    public boolean k() {
        return this.b == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Component<");
        sb.append(Arrays.toString(this.f323a.toArray()));
        sb.append(">{");
        sb.append(this.a);
        sb.append(", type=");
        sb.append(this.b);
        sb.append(", deps=");
        sb.append(Arrays.toString(this.f325b.toArray()));
        return sb.append("}").toString();
    }

    public static <T> b<T> a(Class<T> anInterface) {
        return new b<>(anInterface, new Class[0]);
    }

    public static <T> b<T> b(Class<T> anInterface, Class<? super T>... additionalInterfaces) {
        return new b<>(anInterface, additionalInterfaces);
    }

    static /* synthetic */ Object m(Object value, hb args) {
        return value;
    }

    public static <T> cb<T> n(T value, Class<T> anInterface, Class<? super T>... additionalInterfaces) {
        return b(anInterface, additionalInterfaces).f(ab.b(value)).d();
    }

    public static <T> b<T> h(Class<T> anInterface) {
        return a(anInterface).g();
    }

    public static <T> cb<T> g(T value, Class<T> anInterface) {
        return h(anInterface).f(bb.b(value)).d();
    }

    static /* synthetic */ Object l(Object value, hb c2) {
        return value;
    }

    /* renamed from: cb$b */
    public static class b<T> {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private final Set<Class<? super T>> f326a;

        /* renamed from: a  reason: collision with other field name */
        private kb<T> f327a;
        private int b;

        /* renamed from: b  reason: collision with other field name */
        private final Set<cg> f328b;
        private Set<Class<?>> c;

        private b(Class<T> anInterface, Class<? super T>... additionalInterfaces) {
            HashSet hashSet = new HashSet();
            this.f326a = hashSet;
            this.f328b = new HashSet();
            this.a = 0;
            this.b = 0;
            this.c = new HashSet();
            w90.c(anInterface, "Null interface");
            hashSet.add(anInterface);
            for (Class<? super T> iface : additionalInterfaces) {
                w90.c(iface, "Null interface");
            }
            Collections.addAll(this.f326a, additionalInterfaces);
        }

        public b<T> b(cg dependency) {
            w90.c(dependency, "Null dependency");
            i(dependency.a());
            this.f328b.add(dependency);
            return this;
        }

        public b<T> c() {
            return h(1);
        }

        public b<T> e() {
            return h(2);
        }

        private b<T> h(int instantiation) {
            w90.d(this.a == 0, "Instantiation type has already been set.");
            this.a = instantiation;
            return this;
        }

        private void i(Class<?> anInterface) {
            w90.a(!this.f326a.contains(anInterface), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b<T> f(kb<T> value) {
            this.f327a = (kb) w90.c(value, "Null factory");
            return this;
        }

        /* access modifiers changed from: private */
        public b<T> g() {
            this.b = 1;
            return this;
        }

        public cb<T> d() {
            w90.d(this.f327a != null, "Missing required property: factory.");
            return new cb(new HashSet(this.f326a), new HashSet(this.f328b), this.a, this.b, this.f327a, this.c);
        }
    }
}
