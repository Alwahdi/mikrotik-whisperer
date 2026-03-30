package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

public final class ColorDrawableKt {
    public static final ColorDrawable toDrawable(@ColorInt int $this$toDrawable) {
        return new ColorDrawable($this$toDrawable);
    }

    @RequiresApi(26)
    public static final ColorDrawable toDrawable(Color $this$toDrawable) {
        lu.f($this$toDrawable, "<this>");
        return new ColorDrawable($this$toDrawable.toArgb());
    }
}
