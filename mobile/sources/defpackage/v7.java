package defpackage;

import android.graphics.Canvas;
import android.os.Build;

/* renamed from: v7  reason: default package */
public abstract class v7 {
    public static int a(Canvas canvas, float left, float top, float right, float bottom, int alpha) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(left, top, right, bottom, alpha);
        }
        return canvas.saveLayerAlpha(left, top, right, bottom, alpha, 31);
    }
}
