package defpackage;

import java.util.Set;

/* renamed from: bl0  reason: default package */
abstract class bl0 extends al0 {
    public static final <T> Set<T> b() {
        return mi.a;
    }

    public static <T> Set<T> d(T... elements) {
        lu.f(elements, "elements");
        return elements.length > 0 ? l4.s(elements) : b();
    }

    public static final <T> Set<T> c(Set<? extends T> $this$optimizeReadOnlySet) {
        lu.f($this$optimizeReadOnlySet, "<this>");
        switch ($this$optimizeReadOnlySet.size()) {
            case 0:
                return b();
            case 1:
                return al0.a($this$optimizeReadOnlySet.iterator().next());
            default:
                return $this$optimizeReadOnlySet;
        }
    }
}
