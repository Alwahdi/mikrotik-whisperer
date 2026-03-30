package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;

public final class DrawableKt {
    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 2) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        if ((i3 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i, i2, config);
    }

    public static final Bitmap toBitmap(Drawable $this$toBitmap, @Px int width, @Px int height, Bitmap.Config config) {
        lu.f($this$toBitmap, "<this>");
        if ($this$toBitmap instanceof BitmapDrawable) {
            if (((BitmapDrawable) $this$toBitmap).getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            } else if (config == null || ((BitmapDrawable) $this$toBitmap).getBitmap().getConfig() == config) {
                if (width == ((BitmapDrawable) $this$toBitmap).getBitmap().getWidth() && height == ((BitmapDrawable) $this$toBitmap).getBitmap().getHeight()) {
                    Bitmap bitmap = ((BitmapDrawable) $this$toBitmap).getBitmap();
                    lu.e(bitmap, "bitmap");
                    return bitmap;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(((BitmapDrawable) $this$toBitmap).getBitmap(), width, height, true);
                lu.e(createScaledBitmap, "createScaledBitmap(bitmap, width, height, true)");
                return createScaledBitmap;
            }
        }
        Rect $this$component4$iv = $this$toBitmap.getBounds();
        lu.e($this$component4$iv, "bounds");
        int oldLeft = $this$component4$iv.left;
        int oldTop = $this$component4$iv.top;
        int oldRight = $this$component4$iv.right;
        int oldBottom = $this$component4$iv.bottom;
        Bitmap bitmap2 = Bitmap.createBitmap(width, height, config == null ? Bitmap.Config.ARGB_8888 : config);
        $this$toBitmap.setBounds(0, 0, width, height);
        $this$toBitmap.draw(new Canvas(bitmap2));
        $this$toBitmap.setBounds(oldLeft, oldTop, oldRight, oldBottom);
        lu.e(bitmap2, "bitmap");
        return bitmap2;
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable drawable, int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 2) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        if ((i3 & 4) != 0) {
            config = null;
        }
        return toBitmapOrNull(drawable, i, i2, config);
    }

    public static final Bitmap toBitmapOrNull(Drawable $this$toBitmapOrNull, @Px int width, @Px int height, Bitmap.Config config) {
        lu.f($this$toBitmapOrNull, "<this>");
        if (!($this$toBitmapOrNull instanceof BitmapDrawable) || ((BitmapDrawable) $this$toBitmapOrNull).getBitmap() != null) {
            return toBitmap($this$toBitmapOrNull, width, height, config);
        }
        return null;
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = drawable.getBounds().left;
        }
        if ((i5 & 2) != 0) {
            i2 = drawable.getBounds().top;
        }
        if ((i5 & 4) != 0) {
            i3 = drawable.getBounds().right;
        }
        if ((i5 & 8) != 0) {
            i4 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i, i2, i3, i4);
    }

    public static final void updateBounds(Drawable $this$updateBounds, @Px int left, @Px int top, @Px int right, @Px int bottom) {
        lu.f($this$updateBounds, "<this>");
        $this$updateBounds.setBounds(left, top, right, bottom);
    }
}
