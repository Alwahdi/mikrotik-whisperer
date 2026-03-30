package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.R;

public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    private ViewGroupCompat() {
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup group, View child, AccessibilityEvent event) {
        return group.onRequestSendAccessibilityEvent(child, event);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
        group.setMotionEventSplittingEnabled(split);
    }

    public static int getLayoutMode(@NonNull ViewGroup group) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.getLayoutMode(group);
        }
        return 0;
    }

    public static void setLayoutMode(@NonNull ViewGroup group, int mode) {
        if (Build.VERSION.SDK_INT >= 18) {
            Api18Impl.setLayoutMode(group, mode);
        }
    }

    public static void setTransitionGroup(@NonNull ViewGroup group, boolean isTransitionGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.setTransitionGroup(group, isTransitionGroup);
        } else {
            group.setTag(R.id.tag_transition_group, Boolean.valueOf(isTransitionGroup));
        }
    }

    public static boolean isTransitionGroup(@NonNull ViewGroup group) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.isTransitionGroup(group);
        }
        Boolean explicit = (Boolean) group.getTag(R.id.tag_transition_group);
        return ((explicit == null || !explicit.booleanValue()) && group.getBackground() == null && ViewCompat.getTransitionName(group) == null) ? false : true;
    }

    public static int getNestedScrollAxes(@NonNull ViewGroup group) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getNestedScrollAxes(group);
        }
        if (group instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) group).getNestedScrollAxes();
        }
        return 0;
    }

    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static int getLayoutMode(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }

        @DoNotInline
        static void setLayoutMode(ViewGroup viewGroup, int layoutMode) {
            viewGroup.setLayoutMode(layoutMode);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void setTransitionGroup(ViewGroup viewGroup, boolean isTransitionGroup) {
            viewGroup.setTransitionGroup(isTransitionGroup);
        }

        @DoNotInline
        static boolean isTransitionGroup(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        @DoNotInline
        static int getNestedScrollAxes(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }
    }
}
