package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: t9  reason: default package */
abstract class t9 extends s9 {
    public static <T> T l(List<? extends T> $this$firstOrNull) {
        lu.f($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            return null;
        }
        return $this$firstOrNull.get(0);
    }

    public static final <T, C extends Collection<? super T>> C n(Iterable<? extends T> $this$toCollection, C destination) {
        lu.f($this$toCollection, "<this>");
        lu.f(destination, "destination");
        for (Object item : $this$toCollection) {
            destination.add(item);
        }
        return destination;
    }

    public static <T> List<T> o(Iterable<? extends T> $this$toList) {
        lu.f($this$toList, "<this>");
        if (!($this$toList instanceof Collection)) {
            return l9.g(p($this$toList));
        }
        switch (((Collection) $this$toList).size()) {
            case 0:
                return l9.d();
            case 1:
                return k9.b($this$toList instanceof List ? ((List) $this$toList).get(0) : $this$toList.iterator().next());
            default:
                return q((Collection) $this$toList);
        }
    }

    public static final <T> List<T> p(Iterable<? extends T> $this$toMutableList) {
        lu.f($this$toMutableList, "<this>");
        if ($this$toMutableList instanceof Collection) {
            return q((Collection) $this$toMutableList);
        }
        return (List) n($this$toMutableList, new ArrayList());
    }

    public static <T> List<T> q(Collection<? extends T> $this$toMutableList) {
        lu.f($this$toMutableList, "<this>");
        return new ArrayList($this$toMutableList);
    }

    public static <T> Set<T> r(Iterable<? extends T> $this$toSet) {
        lu.f($this$toSet, "<this>");
        if (!($this$toSet instanceof Collection)) {
            return bl0.c((Set) n($this$toSet, new LinkedHashSet()));
        }
        switch (((Collection) $this$toSet).size()) {
            case 0:
                return bl0.b();
            case 1:
                return al0.a($this$toSet instanceof List ? ((List) $this$toSet).get(0) : $this$toSet.iterator().next());
            default:
                return (Set) n($this$toSet, new LinkedHashSet(zz.a(((Collection) $this$toSet).size())));
        }
    }

    public static <T> List<T> m(Collection<? extends T> $this$plus, T element) {
        lu.f($this$plus, "<this>");
        ArrayList result = new ArrayList($this$plus.size() + 1);
        result.addAll($this$plus);
        result.add(element);
        return result;
    }

    public static <T, R> List<j50<T, R>> s(Iterable<? extends T> $this$zip, Iterable<? extends R> other) {
        lu.f($this$zip, "<this>");
        lu.f(other, "other");
        Iterable $this$zip$iv = $this$zip;
        Iterator first$iv = $this$zip$iv.iterator();
        Iterator second$iv = other.iterator();
        ArrayList list$iv = new ArrayList(Math.min(m9.i($this$zip$iv, 10), m9.i(other, 10)));
        while (first$iv.hasNext() && second$iv.hasNext()) {
            list$iv.add(ws0.a(first$iv.next(), second$iv.next()));
        }
        return list$iv;
    }
}
