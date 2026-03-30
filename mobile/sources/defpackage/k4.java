package defpackage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* renamed from: k4  reason: default package */
abstract class k4 extends j4 {
    public static final <T> List<T> b(T[] $this$asList) {
        lu.f($this$asList, "<this>");
        List<T> a = m4.a($this$asList);
        lu.e(a, "asList(this)");
        return a;
    }

    public static /* synthetic */ Object[] d(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return c(objArr, objArr2, i, i2, i3);
    }

    public static final <T> T[] c(T[] $this$copyInto, T[] destination, int destinationOffset, int startIndex, int endIndex) {
        lu.f($this$copyInto, "<this>");
        lu.f(destination, "destination");
        System.arraycopy($this$copyInto, startIndex, destination, destinationOffset, endIndex - startIndex);
        return destination;
    }

    public static final <T> void e(T[] $this$fill, T element, int fromIndex, int toIndex) {
        lu.f($this$fill, "<this>");
        Arrays.fill($this$fill, fromIndex, toIndex, element);
    }

    public static final <T> void f(T[] $this$sortWith, Comparator<? super T> comparator) {
        lu.f($this$sortWith, "<this>");
        lu.f(comparator, "comparator");
        if ($this$sortWith.length > 1) {
            Arrays.sort($this$sortWith, comparator);
        }
    }
}
