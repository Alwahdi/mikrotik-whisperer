package defpackage;

import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: cl0  reason: default package */
abstract class cl0 extends bl0 {
    public static <T> Set<T> e(Set<? extends T> $this$plus, Iterable<? extends T> elements) {
        int i;
        lu.f($this$plus, "<this>");
        lu.f(elements, "elements");
        Integer j = m9.j(elements);
        if (j != null) {
            i = $this$plus.size() + j.intValue();
        } else {
            i = $this$plus.size() * 2;
        }
        LinkedHashSet result = new LinkedHashSet(zz.a(i));
        result.addAll($this$plus);
        boolean unused = q9.k(result, elements);
        return result;
    }
}
