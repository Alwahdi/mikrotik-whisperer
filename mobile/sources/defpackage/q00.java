package defpackage;

import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: q00  reason: default package */
public abstract class q00 {
    static xc a(int cornerFamily) {
        switch (cornerFamily) {
            case 0:
                return new af0();
            case 1:
                return new ke();
            default:
                return b();
        }
    }

    static xc b() {
        return new af0();
    }

    static ai c() {
        return new ai();
    }

    public static void d(View view, float elevation) {
        Drawable background = view.getBackground();
        if (background instanceof p00) {
            ((p00) background).U(elevation);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof p00) {
            f(view, (p00) background);
        }
    }

    public static void f(View view, p00 materialShapeDrawable) {
        if (materialShapeDrawable.M()) {
            materialShapeDrawable.Y(lv0.f(view));
        }
    }
}
