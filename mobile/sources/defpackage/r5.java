package defpackage;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: r5  reason: default package */
public abstract class r5 {
    public static final boolean a = (Build.VERSION.SDK_INT < 18);

    public static void d(Rect rect, float centerX, float centerY, float halfWidth, float halfHeight) {
        rect.set((int) (centerX - halfWidth), (int) (centerY - halfHeight), (int) (centerX + halfWidth), (int) (centerY + halfHeight));
    }

    public static void a(p5 badgeDrawable, View anchor, FrameLayout customBadgeParent) {
        c(badgeDrawable, anchor, customBadgeParent);
        if (badgeDrawable.i() != null) {
            badgeDrawable.i().setForeground(badgeDrawable);
        } else if (!a) {
            anchor.getOverlay().add(badgeDrawable);
        } else {
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    public static void b(p5 badgeDrawable, View anchor) {
        if (badgeDrawable != null) {
            if (a || badgeDrawable.i() != null) {
                badgeDrawable.i().setForeground((Drawable) null);
            } else {
                anchor.getOverlay().remove(badgeDrawable);
            }
        }
    }

    public static void c(p5 badgeDrawable, View anchor, FrameLayout compatBadgeParent) {
        Rect badgeBounds = new Rect();
        anchor.getDrawingRect(badgeBounds);
        badgeDrawable.setBounds(badgeBounds);
        badgeDrawable.N(anchor, compatBadgeParent);
    }
}
