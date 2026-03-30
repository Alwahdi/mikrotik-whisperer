package defpackage;

import java.util.Collection;
import java.util.List;

/* renamed from: l9  reason: default package */
abstract class l9 extends k9 {
    public static final <T> Collection<T> c(T[] $this$asCollection) {
        lu.f($this$asCollection, "<this>");
        return new x3($this$asCollection, false);
    }

    public static <T> List<T> d() {
        return ji.a;
    }

    public static <T> List<T> f(T... elements) {
        lu.f(elements, "elements");
        return elements.length > 0 ? k4.b(elements) : d();
    }

    public static <T> int e(List<? extends T> $this$lastIndex) {
        lu.f($this$lastIndex, "<this>");
        return $this$lastIndex.size() - 1;
    }

    public static <T> List<T> g(List<? extends T> $this$optimizeReadOnlyList) {
        lu.f($this$optimizeReadOnlyList, "<this>");
        switch ($this$optimizeReadOnlyList.size()) {
            case 0:
                return d();
            case 1:
                return k9.b($this$optimizeReadOnlyList.get(0));
            default:
                return $this$optimizeReadOnlyList;
        }
    }

    public static void h() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
