package androidx.core.util;

import android.util.Range;
import defpackage.e9;

public final class RangeKt$toClosedRange$1 implements e9<T> {
    final /* synthetic */ Range<T> $this_toClosedRange;

    RangeKt$toClosedRange$1(Range<T> $receiver) {
        this.$this_toClosedRange = $receiver;
    }

    public boolean contains(T value) {
        return e9.a.a(this, value);
    }

    public boolean isEmpty() {
        return e9.a.b(this);
    }

    public T getEndInclusive() {
        return this.$this_toClosedRange.getUpper();
    }

    public T getStart() {
        return this.$this_toClosedRange.getLower();
    }
}
