package defpackage;

import java.util.Collection;

/* renamed from: m9  reason: default package */
abstract class m9 extends l9 {
    public static final <T> Integer j(Iterable<? extends T> $this$collectionSizeOrNull) {
        lu.f($this$collectionSizeOrNull, "<this>");
        if ($this$collectionSizeOrNull instanceof Collection) {
            return Integer.valueOf(((Collection) $this$collectionSizeOrNull).size());
        }
        return null;
    }

    public static <T> int i(Iterable<? extends T> $this$collectionSizeOrDefault, int i) {
        lu.f($this$collectionSizeOrDefault, "<this>");
        return $this$collectionSizeOrDefault instanceof Collection ? ((Collection) $this$collectionSizeOrDefault).size() : i;
    }
}
