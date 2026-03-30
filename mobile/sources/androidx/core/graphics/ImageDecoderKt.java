package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;

public final class ImageDecoderKt {
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source $this$decodeBitmap, lo<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, jt0> action) {
        lu.f($this$decodeBitmap, "<this>");
        lu.f(action, "action");
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap($this$decodeBitmap, new ImageDecoderKt$decodeBitmap$1(action));
        lu.e(decodeBitmap, "crossinline action: Imag…ction(info, source)\n    }");
        return decodeBitmap;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source $this$decodeDrawable, lo<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, jt0> action) {
        lu.f($this$decodeDrawable, "<this>");
        lu.f(action, "action");
        Drawable decodeDrawable = ImageDecoder.decodeDrawable($this$decodeDrawable, new ImageDecoderKt$decodeDrawable$1(action));
        lu.e(decodeDrawable, "crossinline action: Imag…ction(info, source)\n    }");
        return decodeDrawable;
    }
}
