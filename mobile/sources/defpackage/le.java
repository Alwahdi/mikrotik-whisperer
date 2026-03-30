package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.CycleDetector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: le  reason: default package */
abstract class le {

    /* renamed from: le$c */
    private static class c {
        private final Class<?> a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final boolean f4248a;

        private c(Class<?> anInterface, boolean set) {
            this.a = anInterface;
            this.f4248a = set;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c dep = (c) obj;
            if (!dep.a.equals(this.a) || dep.f4248a != this.f4248a) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((1000003 ^ this.a.hashCode()) * 1000003) ^ Boolean.valueOf(this.f4248a).hashCode();
        }
    }

    /* renamed from: le$b */
    private static class b {
        private final cb<?> a;

        /* renamed from: a  reason: collision with other field name */
        private final Set<b> f4247a = new HashSet();
        private final Set<b> b = new HashSet();

        b(cb<?> component) {
            this.a = component;
        }

        /* access modifiers changed from: package-private */
        public void a(b node) {
            this.f4247a.add(node);
        }

        /* access modifiers changed from: package-private */
        public void b(b node) {
            this.b.add(node);
        }

        /* access modifiers changed from: package-private */
        public Set<b> d() {
            return this.f4247a;
        }

        /* access modifiers changed from: package-private */
        public void g(b node) {
            this.b.remove(node);
        }

        /* access modifiers changed from: package-private */
        public cb<?> c() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public boolean f() {
            return this.b.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            return this.f4247a.isEmpty();
        }
    }

    static void a(List<cb<?>> components) {
        Set<b> c2 = c(components);
        Set<b> b2 = b(c2);
        int numVisited = 0;
        while (!b2.isEmpty()) {
            b node = b2.iterator().next();
            b2.remove(node);
            numVisited++;
            for (b dependent : node.d()) {
                dependent.g(node);
                if (dependent.f()) {
                    b2.add(dependent);
                }
            }
        }
        if (numVisited != components.size()) {
            List<Component<?>> componentsInCycle = new ArrayList<>();
            for (b node2 : c2) {
                if (!node2.f() && !node2.e()) {
                    componentsInCycle.add(node2.c());
                }
            }
            throw new dg(componentsInCycle);
        }
    }

    private static Set<b> c(List<cb<?>> components) {
        Set<CycleDetector.ComponentNode> depComponents;
        Map<CycleDetector.Dep, Set<CycleDetector.ComponentNode>> componentIndex = new HashMap<>(components.size());
        Iterator<cb<?>> it = components.iterator();
        while (it.hasNext()) {
            Component<?> component = (cb) it.next();
            b node = new b(component);
            Iterator it2 = component.e().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Class<?> anInterface = (Class) it2.next();
                    c cmp = new c(anInterface, !component.k());
                    if (!componentIndex.containsKey(cmp)) {
                        componentIndex.put(cmp, new HashSet());
                    }
                    Set<CycleDetector.ComponentNode> nodes = componentIndex.get(cmp);
                    if (nodes.isEmpty() || cmp.f4248a) {
                        nodes.add(node);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{anInterface}));
                    }
                }
            }
        }
        for (Set<CycleDetector.ComponentNode> componentNodes : componentIndex.values()) {
            Iterator<CycleDetector.ComponentNode> it3 = componentNodes.iterator();
            while (it3.hasNext()) {
                b node2 = (b) it3.next();
                for (cg dependency : node2.c().c()) {
                    if (dependency.b() && (depComponents = componentIndex.get(new c(dependency.a(), dependency.d()))) != null) {
                        Iterator<CycleDetector.ComponentNode> it4 = depComponents.iterator();
                        while (it4.hasNext()) {
                            b depComponent = (b) it4.next();
                            node2.a(depComponent);
                            depComponent.b(node2);
                        }
                    }
                }
            }
        }
        HashSet<CycleDetector.ComponentNode> result = new HashSet<>();
        for (Set<CycleDetector.ComponentNode> componentNodes2 : componentIndex.values()) {
            result.addAll(componentNodes2);
        }
        return result;
    }

    private static Set<b> b(Set<b> components) {
        Set<CycleDetector.ComponentNode> roots = new HashSet<>();
        for (b component : components) {
            if (component.f()) {
                roots.add(component);
            }
        }
        return roots;
    }
}
