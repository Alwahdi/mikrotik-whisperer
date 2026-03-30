package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.Lazy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* renamed from: pb  reason: default package */
public class pb extends i {
    private static final mb0<Set<Object>> a = ob.a();

    /* renamed from: a  reason: collision with other field name */
    private final Map<cb<?>, sw<?>> f4696a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private final yi f4697a;
    private final Map<Class<?>, sw<?>> b = new HashMap();
    private final Map<Class<?>, sw<Set<?>>> c = new HashMap();

    public /* bridge */ /* synthetic */ Set a(Class cls) {
        return super.a(cls);
    }

    public /* bridge */ /* synthetic */ Object d(Class cls) {
        return super.d(cls);
    }

    public pb(Executor defaultEventExecutor, Iterable<lb> registrars, cb<?>... additionalComponents) {
        yi yiVar = new yi(defaultEventExecutor);
        this.f4697a = yiVar;
        List<Component<?>> componentsToAdd = new ArrayList<>();
        componentsToAdd.add(cb.n(yiVar, yi.class, io0.class, sb0.class));
        for (lb registrar : registrars) {
            componentsToAdd.addAll(registrar.getComponents());
        }
        for (Component<?> additionalComponent : additionalComponents) {
            if (additionalComponent != null) {
                componentsToAdd.add(additionalComponent);
            }
        }
        le.a(componentsToAdd);
        for (Component<?> component : componentsToAdd) {
            this.f4696a.put(component, new sw<>(mb.a(this, component)));
        }
        h();
        i();
    }

    private void h() {
        for (Map.Entry<Component<?>, Lazy<?>> entry : this.f4696a.entrySet()) {
            Component<?> component = (cb) entry.getKey();
            if (component.k()) {
                Lazy<?> lazy = (sw) entry.getValue();
                for (Class<?> anInterface : component.e()) {
                    this.b.put(anInterface, lazy);
                }
            }
        }
        j();
    }

    private void i() {
        Map<Class<?>, Set<Lazy<?>>> setIndex = new HashMap<>();
        for (Map.Entry<Component<?>, Lazy<?>> entry : this.f4696a.entrySet()) {
            Component<?> component = (cb) entry.getKey();
            if (!component.k()) {
                Lazy<?> lazy = (sw) entry.getValue();
                for (Class<?> anInterface : component.e()) {
                    if (!setIndex.containsKey(anInterface)) {
                        setIndex.put(anInterface, new HashSet());
                    }
                    setIndex.get(anInterface).add(lazy);
                }
            }
        }
        for (Map.Entry<Class<?>, Set<Lazy<?>>> entry2 : setIndex.entrySet()) {
            this.c.put(entry2.getKey(), new sw(nb.a(entry2.getValue())));
        }
    }

    static /* synthetic */ Set g(Set lazies) {
        Set<Object> set = new HashSet<>();
        Iterator it = lazies.iterator();
        while (it.hasNext()) {
            set.add(((sw) it.next()).get());
        }
        return Collections.unmodifiableSet(set);
    }

    public <T> mb0<T> b(Class<T> anInterface) {
        w90.c(anInterface, "Null interface requested.");
        return this.b.get(anInterface);
    }

    public <T> mb0<Set<T>> c(Class<T> anInterface) {
        Lazy<Set<?>> lazy = (sw) this.c.get(anInterface);
        if (lazy != null) {
            return lazy;
        }
        return a;
    }

    public void e(boolean isDefaultApp) {
        for (Map.Entry<Component<?>, Lazy<?>> entry : this.f4696a.entrySet()) {
            Component<?> component = (cb) entry.getKey();
            Lazy<?> lazy = (sw) entry.getValue();
            if (component.i() || (component.j() && isDefaultApp)) {
                lazy.get();
            }
        }
        this.f4697a.b();
    }

    private void j() {
        Iterator<cb<?>> it = this.f4696a.keySet().iterator();
        while (it.hasNext()) {
            Component<?> component = (cb) it.next();
            Iterator<cg> it2 = component.c().iterator();
            while (true) {
                if (it2.hasNext()) {
                    cg dependency = it2.next();
                    if (dependency.c() && !this.b.containsKey(dependency.a())) {
                        throw new b20(String.format("Unsatisfied dependency for component %s: %s", new Object[]{component, dependency.a()}));
                    }
                }
            }
        }
    }
}
