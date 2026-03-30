package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: be0  reason: default package */
public final class be0 implements wc {
    private final float a;

    private static float b(RectF bounds) {
        return Math.min(bounds.width(), bounds.height());
    }

    public be0(float percent) {
        this.a = percent;
    }

    public float a(RectF bounds) {
        return this.a * b(bounds);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o instanceof be0) && this.a == ((be0) o).a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
