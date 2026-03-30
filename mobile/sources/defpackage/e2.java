package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: e2  reason: default package */
public final class e2 implements wc {
    private final float a;

    /* renamed from: a  reason: collision with other field name */
    private final wc f2839a;

    public e2(float adjustment, wc other) {
        while (other instanceof e2) {
            other = ((e2) other).f2839a;
            adjustment += ((e2) other).a;
        }
        this.f2839a = other;
        this.a = adjustment;
    }

    public float a(RectF bounds) {
        return Math.max(0.0f, this.f2839a.a(bounds) + this.a);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof e2)) {
            return false;
        }
        e2 that = (e2) o;
        if (!this.f2839a.equals(that.f2839a) || this.a != that.a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2839a, Float.valueOf(this.a)});
    }
}
