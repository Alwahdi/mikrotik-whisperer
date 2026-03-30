package defpackage;

import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;

/* renamed from: yi0  reason: default package */
public class yi0 extends DrawableWrapperCompat {
    private final int a;
    private final int b;

    public yi0(Drawable drawable, int width, int height) {
        super(drawable);
        this.a = width;
        this.b = height;
    }

    public int getIntrinsicWidth() {
        return this.a;
    }

    public int getIntrinsicHeight() {
        return this.b;
    }
}
