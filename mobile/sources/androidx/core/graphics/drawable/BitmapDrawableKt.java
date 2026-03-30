package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public final class BitmapDrawableKt {
    public static final BitmapDrawable toDrawable(Bitmap $this$toDrawable, Resources resources) {
        lu.f($this$toDrawable, "<this>");
        lu.f(resources, "resources");
        return new BitmapDrawable(resources, $this$toDrawable);
    }
}
