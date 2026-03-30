package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap $this$applyCanvas, vn<? super Canvas, jt0> block) {
        lu.f($this$applyCanvas, "<this>");
        lu.f(block, "block");
        block.invoke(new Canvas($this$applyCanvas));
        return $this$applyCanvas;
    }

    public static final int get(Bitmap $this$get, int x, int y) {
        lu.f($this$get, "<this>");
        return $this$get.getPixel(x, y);
    }

    public static final void set(Bitmap $this$set, int x, int y, @ColorInt int color) {
        lu.f($this$set, "<this>");
        $this$set.setPixel(x, y, color);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap $this$scale_u24default, int width, int height, boolean filter, int i, Object obj) {
        if ((i & 4) != 0) {
            filter = true;
        }
        lu.f($this$scale_u24default, "<this>");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap($this$scale_u24default, width, height, filter);
        lu.e(createScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return createScaledBitmap;
    }

    public static final Bitmap scale(Bitmap $this$scale, int width, int height, boolean filter) {
        lu.f($this$scale, "<this>");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap($this$scale, width, height, filter);
        lu.e(createScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return createScaledBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int width, int height, Bitmap.Config config, int i, Object obj) {
        if ((i & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        lu.f(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(width, height, config);
        lu.e(createBitmap, "createBitmap(width, height, config)");
        return createBitmap;
    }

    public static final Bitmap createBitmap(int width, int height, Bitmap.Config config) {
        lu.f(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(width, height, config);
        lu.e(createBitmap, "createBitmap(width, height, config)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int width, int height, Bitmap.Config config, boolean hasAlpha, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i & 8) != 0) {
            hasAlpha = true;
        }
        if ((i & 16) != 0) {
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.SRGB);
            lu.e(colorSpace2, "get(ColorSpace.Named.SRGB)");
            colorSpace = colorSpace2;
        }
        lu.f(config, "config");
        lu.f(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(width, height, config, hasAlpha, colorSpace);
        lu.e(createBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    @RequiresApi(26)
    public static final Bitmap createBitmap(int width, int height, Bitmap.Config config, boolean hasAlpha, ColorSpace colorSpace) {
        lu.f(config, "config");
        lu.f(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(width, height, config, hasAlpha, colorSpace);
        lu.e(createBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    public static final boolean contains(Bitmap $this$contains, Point p) {
        int i;
        lu.f($this$contains, "<this>");
        lu.f(p, "p");
        int width = $this$contains.getWidth();
        int i2 = p.x;
        return (i2 >= 0 && i2 < width) && (i = p.y) >= 0 && i < $this$contains.getHeight();
    }

    public static final boolean contains(Bitmap $this$contains, PointF p) {
        lu.f($this$contains, "<this>");
        lu.f(p, "p");
        float f = p.x;
        if (f >= 0.0f && f < ((float) $this$contains.getWidth())) {
            float f2 = p.y;
            return f2 >= 0.0f && f2 < ((float) $this$contains.getHeight());
        }
    }
}
