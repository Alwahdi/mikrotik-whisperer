package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DisplayCutoutCompat {
    private final DisplayCutout mDisplayCutout;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DisplayCutoutCompat(@Nullable Rect safeInsets, @Nullable List<Rect> boundingRects) {
        this(Build.VERSION.SDK_INT >= 28 ? Api28Impl.createDisplayCutout(safeInsets, boundingRects) : null);
    }

    public DisplayCutoutCompat(@NonNull Insets safeInsets, @Nullable Rect boundLeft, @Nullable Rect boundTop, @Nullable Rect boundRight, @Nullable Rect boundBottom, @NonNull Insets waterfallInsets) {
        this(constructDisplayCutout(safeInsets, boundLeft, boundTop, boundRight, boundBottom, waterfallInsets));
    }

    private static DisplayCutout constructDisplayCutout(@NonNull Insets safeInsets, @Nullable Rect boundLeft, @Nullable Rect boundTop, @Nullable Rect boundRight, @Nullable Rect boundBottom, @NonNull Insets waterfallInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            return Api30Impl.createDisplayCutout(safeInsets.toPlatformInsets(), boundLeft, boundTop, boundRight, boundBottom, waterfallInsets.toPlatformInsets());
        } else if (i >= 29) {
            return Api29Impl.createDisplayCutout(safeInsets.toPlatformInsets(), boundLeft, boundTop, boundRight, boundBottom);
        } else {
            if (i < 28) {
                return null;
            }
            Rect safeInsetRect = new Rect(safeInsets.left, safeInsets.top, safeInsets.right, safeInsets.bottom);
            ArrayList<Rect> boundingRects = new ArrayList<>();
            if (boundLeft != null) {
                boundingRects.add(boundLeft);
            }
            if (boundTop != null) {
                boundingRects.add(boundTop);
            }
            if (boundRight != null) {
                boundingRects.add(boundRight);
            }
            if (boundBottom != null) {
                boundingRects.add(boundBottom);
            }
            return Api28Impl.createDisplayCutout(safeInsetRect, boundingRects);
        }
    }

    private DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.mDisplayCutout = displayCutout;
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetTop(this.mDisplayCutout);
        }
        return 0;
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetBottom(this.mDisplayCutout);
        }
        return 0;
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetLeft(this.mDisplayCutout);
        }
        return 0;
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetRight(this.mDisplayCutout);
        }
        return 0;
    }

    @NonNull
    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getBoundingRects(this.mDisplayCutout);
        }
        return Collections.emptyList();
    }

    @NonNull
    public Insets getWaterfallInsets() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Insets.toCompatInsets(Api30Impl.getWaterfallInsets(this.mDisplayCutout));
        }
        return Insets.NONE;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat) o).mDisplayCutout);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.mDisplayCutout;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    @NonNull
    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }

    static DisplayCutoutCompat wrap(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new DisplayCutoutCompat(displayCutout);
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(28)
    public DisplayCutout unwrap() {
        return this.mDisplayCutout;
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static DisplayCutout createDisplayCutout(Rect safeInsets, List<Rect> boundingRects) {
            return new DisplayCutout(safeInsets, boundingRects);
        }

        @DoNotInline
        static int getSafeInsetTop(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }

        @DoNotInline
        static int getSafeInsetBottom(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        @DoNotInline
        static int getSafeInsetLeft(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        @DoNotInline
        static int getSafeInsetRight(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        @DoNotInline
        static List<Rect> getBoundingRects(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static DisplayCutout createDisplayCutout(android.graphics.Insets safeInsets, Rect boundLeft, Rect boundTop, Rect boundRight, Rect boundBottom, android.graphics.Insets waterfallInsets) {
            return new DisplayCutout(safeInsets, boundLeft, boundTop, boundRight, boundBottom, waterfallInsets);
        }

        @DoNotInline
        static android.graphics.Insets getWaterfallInsets(DisplayCutout displayCutout) {
            return displayCutout.getWaterfallInsets();
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static DisplayCutout createDisplayCutout(android.graphics.Insets safeInsets, Rect boundLeft, Rect boundTop, Rect boundRight, Rect boundBottom) {
            return new DisplayCutout(safeInsets, boundLeft, boundTop, boundRight, boundBottom);
        }
    }
}
