package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;

public final class IconKt {
    @RequiresApi(26)
    public static final Icon toAdaptiveIcon(Bitmap $this$toAdaptiveIcon) {
        lu.f($this$toAdaptiveIcon, "<this>");
        Icon createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap($this$toAdaptiveIcon);
        lu.e(createWithAdaptiveBitmap, "createWithAdaptiveBitmap(this)");
        return createWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Bitmap $this$toIcon) {
        lu.f($this$toIcon, "<this>");
        Icon createWithBitmap = Icon.createWithBitmap($this$toIcon);
        lu.e(createWithBitmap, "createWithBitmap(this)");
        return createWithBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Uri $this$toIcon) {
        lu.f($this$toIcon, "<this>");
        Icon createWithContentUri = Icon.createWithContentUri($this$toIcon);
        lu.e(createWithContentUri, "createWithContentUri(this)");
        return createWithContentUri;
    }

    @RequiresApi(26)
    public static final Icon toIcon(byte[] $this$toIcon) {
        lu.f($this$toIcon, "<this>");
        Icon createWithData = Icon.createWithData($this$toIcon, 0, $this$toIcon.length);
        lu.e(createWithData, "createWithData(this, 0, size)");
        return createWithData;
    }
}
