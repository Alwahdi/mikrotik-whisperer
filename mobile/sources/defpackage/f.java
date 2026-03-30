package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: f  reason: default package */
public final class f implements wc {
    private final float a;

    public f(float size) {
        this.a = size;
    }

    public float a(RectF bounds) {
        return this.a;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o instanceof f) && this.a == ((f) o).a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
