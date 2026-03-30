package defpackage;

import java.util.Collection;

/* renamed from: q9  reason: default package */
abstract class q9 extends p9 {
    public static <T> boolean k(Collection<? super T> $this$addAll, Iterable<? extends T> elements) {
        lu.f($this$addAll, "<this>");
        lu.f(elements, "elements");
        if (elements instanceof Collection) {
            return $this$addAll.addAll((Collection) elements);
        }
        boolean result = false;
        for (Object item : elements) {
            if ($this$addAll.add(item)) {
                result = true;
            }
        }
        return result;
    }
}
