package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.createPathInterpolator(path);
        }
        return new PathInterpolatorApi14(path);
    }

    @NonNull
    public static Interpolator create(float controlX, float controlY) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.createPathInterpolator(controlX, controlY);
        }
        return new PathInterpolatorApi14(controlX, controlY);
    }

    @NonNull
    public static Interpolator create(float controlX1, float controlY1, float controlX2, float controlY2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.createPathInterpolator(controlX1, controlY1, controlX2, controlY2);
        }
        return new PathInterpolatorApi14(controlX1, controlY1, controlX2, controlY2);
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static PathInterpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        @DoNotInline
        static PathInterpolator createPathInterpolator(float controlX, float controlY) {
            return new PathInterpolator(controlX, controlY);
        }

        @DoNotInline
        static PathInterpolator createPathInterpolator(float controlX1, float controlY1, float controlX2, float controlY2) {
            return new PathInterpolator(controlX1, controlY1, controlX2, controlY2);
        }
    }
}
