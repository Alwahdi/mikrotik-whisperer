package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;

public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(Size $this$component1) {
        lu.f($this$component1, "<this>");
        return $this$component1.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(Size $this$component2) {
        lu.f($this$component2, "<this>");
        return $this$component2.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(SizeF $this$component1) {
        lu.f($this$component1, "<this>");
        return $this$component1.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(SizeF $this$component2) {
        lu.f($this$component2, "<this>");
        return $this$component2.getHeight();
    }

    public static final float component1(SizeFCompat $this$component1) {
        lu.f($this$component1, "<this>");
        return $this$component1.getWidth();
    }

    public static final float component2(SizeFCompat $this$component2) {
        lu.f($this$component2, "<this>");
        return $this$component2.getHeight();
    }
}
