package androidx.core.util;

import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class SizeFCompat {
    private final float mHeight;
    private final float mWidth;

    public SizeFCompat(float width, float height) {
        this.mWidth = Preconditions.checkArgumentFinite(width, "width");
        this.mHeight = Preconditions.checkArgumentFinite(height, "height");
    }

    public float getWidth() {
        return this.mWidth;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SizeFCompat)) {
            return false;
        }
        SizeFCompat that = (SizeFCompat) o;
        if (that.mWidth == this.mWidth && that.mHeight == this.mHeight) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.mWidth) ^ Float.floatToIntBits(this.mHeight);
    }

    @NonNull
    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }

    @RequiresApi(21)
    @NonNull
    public SizeF toSizeF() {
        return Api21Impl.toSizeF(this);
    }

    @RequiresApi(21)
    @NonNull
    public static SizeFCompat toSizeFCompat(@NonNull SizeF size) {
        return Api21Impl.toSizeFCompat(size);
    }

    @RequiresApi(21)
    private static final class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        @NonNull
        static SizeFCompat toSizeFCompat(@NonNull SizeF size) {
            Preconditions.checkNotNull(size);
            return new SizeFCompat(size.getWidth(), size.getHeight());
        }

        @DoNotInline
        @NonNull
        static SizeF toSizeF(@NonNull SizeFCompat size) {
            Preconditions.checkNotNull(size);
            return new SizeF(size.getWidth(), size.getHeight());
        }
    }
}
