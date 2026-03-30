package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;

public final class RangeKt {
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T $this$rangeTo, T that) {
        lu.f($this$rangeTo, "<this>");
        lu.f(that, "that");
        return new Range<>($this$rangeTo, that);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> $this$plus, T value) {
        lu.f($this$plus, "<this>");
        lu.f(value, "value");
        Range<T> extend = $this$plus.extend(value);
        lu.e(extend, "extend(value)");
        return extend;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> $this$plus, Range<T> other) {
        lu.f($this$plus, "<this>");
        lu.f(other, "other");
        Range<T> extend = $this$plus.extend(other);
        lu.e(extend, "extend(other)");
        return extend;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> $this$and, Range<T> other) {
        lu.f($this$and, "<this>");
        lu.f(other, "other");
        Range<T> intersect = $this$and.intersect(other);
        lu.e(intersect, "intersect(other)");
        return intersect;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> e9<T> toClosedRange(Range<T> $this$toClosedRange) {
        lu.f($this$toClosedRange, "<this>");
        return new RangeKt$toClosedRange$1($this$toClosedRange);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(e9<T> $this$toRange) {
        lu.f($this$toRange, "<this>");
        return new Range<>($this$toRange.getStart(), $this$toRange.getEndInclusive());
    }
}
