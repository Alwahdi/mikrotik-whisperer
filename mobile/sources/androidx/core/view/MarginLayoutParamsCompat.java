package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class MarginLayoutParamsCompat {
    public static int getMarginStart(@NonNull ViewGroup.MarginLayoutParams lp) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.getMarginStart(lp);
        }
        return lp.leftMargin;
    }

    public static int getMarginEnd(@NonNull ViewGroup.MarginLayoutParams lp) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.getMarginEnd(lp);
        }
        return lp.rightMargin;
    }

    public static void setMarginStart(@NonNull ViewGroup.MarginLayoutParams lp, int marginStart) {
        if (Build.VERSION.SDK_INT >= 17) {
            Api17Impl.setMarginStart(lp, marginStart);
        } else {
            lp.leftMargin = marginStart;
        }
    }

    public static void setMarginEnd(@NonNull ViewGroup.MarginLayoutParams lp, int marginEnd) {
        if (Build.VERSION.SDK_INT >= 17) {
            Api17Impl.setMarginEnd(lp, marginEnd);
        } else {
            lp.rightMargin = marginEnd;
        }
    }

    public static boolean isMarginRelative(@NonNull ViewGroup.MarginLayoutParams lp) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.isMarginRelative(lp);
        }
        return false;
    }

    public static int getLayoutDirection(@NonNull ViewGroup.MarginLayoutParams lp) {
        int result;
        if (Build.VERSION.SDK_INT >= 17) {
            result = Api17Impl.getLayoutDirection(lp);
        } else {
            result = 0;
        }
        if (result == 0 || result == 1) {
            return result;
        }
        return 0;
    }

    public static void setLayoutDirection(@NonNull ViewGroup.MarginLayoutParams lp, int layoutDirection) {
        if (Build.VERSION.SDK_INT >= 17) {
            Api17Impl.setLayoutDirection(lp, layoutDirection);
        }
    }

    public static void resolveLayoutDirection(@NonNull ViewGroup.MarginLayoutParams lp, int layoutDirection) {
        if (Build.VERSION.SDK_INT >= 17) {
            Api17Impl.resolveLayoutDirection(lp, layoutDirection);
        }
    }

    private MarginLayoutParamsCompat() {
    }

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        @DoNotInline
        static int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        @DoNotInline
        static void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int start) {
            marginLayoutParams.setMarginStart(start);
        }

        @DoNotInline
        static void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int end) {
            marginLayoutParams.setMarginEnd(end);
        }

        @DoNotInline
        static boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        @DoNotInline
        static int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        @DoNotInline
        static void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int layoutDirection) {
            marginLayoutParams.setLayoutDirection(layoutDirection);
        }

        @DoNotInline
        static void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int layoutDirection) {
            marginLayoutParams.resolveLayoutDirection(layoutDirection);
        }
    }
}
