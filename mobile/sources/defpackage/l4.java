package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: l4  reason: default package */
abstract class l4 extends k4 {
    public static final <T> boolean g(T[] $this$contains, T element) {
        lu.f($this$contains, "<this>");
        return k($this$contains, element) >= 0;
    }

    public static final <T> int k(T[] $this$indexOf, T element) {
        lu.f($this$indexOf, "<this>");
        if (element == null) {
            int length = $this$indexOf.length;
            for (int index = 0; index < length; index++) {
                if ($this$indexOf[index] == null) {
                    return index;
                }
            }
            return -1;
        }
        int length2 = $this$indexOf.length;
        for (int index2 = 0; index2 < length2; index2++) {
            if (lu.a(element, $this$indexOf[index2])) {
                return index2;
            }
        }
        return -1;
    }

    public static char l(char[] $this$single) {
        lu.f($this$single, "<this>");
        switch ($this$single.length) {
            case 0:
                throw new NoSuchElementException("Array is empty.");
            case 1:
                return $this$single[0];
            default:
                throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static <T> T m(T[] $this$singleOrNull) {
        lu.f($this$singleOrNull, "<this>");
        if ($this$singleOrNull.length == 1) {
            return $this$singleOrNull[0];
        }
        return null;
    }

    public static <T> List<T> h(T[] $this$filterNotNull) {
        lu.f($this$filterNotNull, "<this>");
        return (List) i($this$filterNotNull, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C i(T[] $this$filterNotNullTo, C destination) {
        lu.f($this$filterNotNullTo, "<this>");
        lu.f(destination, "destination");
        for (Object element : $this$filterNotNullTo) {
            if (element != null) {
                destination.add(element);
            }
        }
        return destination;
    }

    public static final <T> T[] n(T[] $this$sortedArrayWith, Comparator<? super T> comparator) {
        lu.f($this$sortedArrayWith, "<this>");
        lu.f(comparator, "comparator");
        if ($this$sortedArrayWith.length == 0) {
            return $this$sortedArrayWith;
        }
        Object[] $this$sortedArrayWith_u24lambda_u2470 = Arrays.copyOf($this$sortedArrayWith, $this$sortedArrayWith.length);
        lu.e($this$sortedArrayWith_u24lambda_u2470, "copyOf(this, size)");
        k4.f($this$sortedArrayWith_u24lambda_u2470, comparator);
        return $this$sortedArrayWith_u24lambda_u2470;
    }

    public static <T> List<T> o(T[] $this$sortedWith, Comparator<? super T> comparator) {
        lu.f($this$sortedWith, "<this>");
        lu.f(comparator, "comparator");
        return k4.b(n($this$sortedWith, comparator));
    }

    public static final <T> int j(T[] $this$lastIndex) {
        lu.f($this$lastIndex, "<this>");
        return $this$lastIndex.length - 1;
    }

    public static final <T, C extends Collection<? super T>> C p(T[] $this$toCollection, C destination) {
        lu.f($this$toCollection, "<this>");
        lu.f(destination, "destination");
        for (Object item : $this$toCollection) {
            destination.add(item);
        }
        return destination;
    }

    public static <T> List<T> q(T[] $this$toList) {
        lu.f($this$toList, "<this>");
        switch ($this$toList.length) {
            case 0:
                return l9.d();
            case 1:
                return k9.b($this$toList[0]);
            default:
                return r($this$toList);
        }
    }

    public static final <T> List<T> r(T[] $this$toMutableList) {
        lu.f($this$toMutableList, "<this>");
        return new ArrayList(l9.c($this$toMutableList));
    }

    public static final <T> Set<T> s(T[] $this$toSet) {
        lu.f($this$toSet, "<this>");
        switch ($this$toSet.length) {
            case 0:
                return bl0.b();
            case 1:
                return al0.a($this$toSet[0]);
            default:
                return (Set) p($this$toSet, new LinkedHashSet(zz.a($this$toSet.length)));
        }
    }
}
