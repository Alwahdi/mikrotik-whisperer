package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: k9  reason: default package */
abstract class k9 {
    public static <T> List<T> b(T element) {
        List<T> singletonList = Collections.singletonList(element);
        lu.e(singletonList, "singletonList(element)");
        return singletonList;
    }

    public static final <T> Object[] a(T[] $this$copyToArrayOfAny, boolean isVarargs) {
        Class<Object[]> cls = Object[].class;
        lu.f($this$copyToArrayOfAny, "<this>");
        if (isVarargs && lu.a($this$copyToArrayOfAny.getClass(), cls)) {
            return $this$copyToArrayOfAny;
        }
        Object[] copyOf = Arrays.copyOf($this$copyToArrayOfAny, $this$copyToArrayOfAny.length, cls);
        lu.e(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }
}
