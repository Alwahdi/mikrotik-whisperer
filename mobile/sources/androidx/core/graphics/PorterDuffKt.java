package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;

public final class PorterDuffKt {
    public static final PorterDuffXfermode toXfermode(PorterDuff.Mode $this$toXfermode) {
        lu.f($this$toXfermode, "<this>");
        return new PorterDuffXfermode($this$toXfermode);
    }

    public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode $this$toColorFilter, int color) {
        lu.f($this$toColorFilter, "<this>");
        return new PorterDuffColorFilter(color, $this$toColorFilter);
    }
}
