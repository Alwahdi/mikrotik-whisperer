package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    private ViewParentCompat() {
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent parent, View child, AccessibilityEvent event) {
        return parent.requestSendAccessibilityEvent(child, event);
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent parent, @NonNull View child, @NonNull View target, int nestedScrollAxes) {
        return onStartNestedScroll(parent, child, target, nestedScrollAxes, 0);
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent parent, @NonNull View child, @NonNull View target, int nestedScrollAxes) {
        onNestedScrollAccepted(parent, child, target, nestedScrollAxes, 0);
    }

    public static void onStopNestedScroll(@NonNull ViewParent parent, @NonNull View target) {
        onStopNestedScroll(parent, target, 0);
    }

    public static void onNestedScroll(@NonNull ViewParent parent, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        onNestedScroll(parent, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(@NonNull ViewParent parent, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        onNestedScroll(parent, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, getTempNestedScrollConsumed());
    }

    public static void onNestedPreScroll(@NonNull ViewParent parent, @NonNull View target, int dx, int dy, @NonNull int[] consumed) {
        onNestedPreScroll(parent, target, dx, dy, consumed, 0);
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent parent, @NonNull View child, @NonNull View target, int nestedScrollAxes, int type) {
        if (parent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) parent).onStartNestedScroll(child, target, nestedScrollAxes, type);
        }
        if (type != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return Api21Impl.onStartNestedScroll(parent, child, target, nestedScrollAxes);
            } catch (AbstractMethodError e) {
                Log.e(TAG, "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                return false;
            }
        } else if (parent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) parent).onStartNestedScroll(child, target, nestedScrollAxes);
        } else {
            return false;
        }
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent parent, @NonNull View child, @NonNull View target, int nestedScrollAxes, int type) {
        if (parent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) parent).onNestedScrollAccepted(child, target, nestedScrollAxes, type);
        } else if (type != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Api21Impl.onNestedScrollAccepted(parent, child, target, nestedScrollAxes);
                } catch (AbstractMethodError e) {
                    Log.e(TAG, "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e);
                }
            } else if (parent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) parent).onNestedScrollAccepted(child, target, nestedScrollAxes);
            }
        }
    }

    public static void onStopNestedScroll(@NonNull ViewParent parent, @NonNull View target, int type) {
        if (parent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) parent).onStopNestedScroll(target, type);
        } else if (type != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Api21Impl.onStopNestedScroll(parent, target);
                } catch (AbstractMethodError e) {
                    Log.e(TAG, "ViewParent " + parent + " does not implement interface method onStopNestedScroll", e);
                }
            } else if (parent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) parent).onStopNestedScroll(target);
            }
        }
    }

    public static void onNestedScroll(@NonNull ViewParent parent, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NonNull int[] consumed) {
        ViewParent viewParent = parent;
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
            return;
        }
        consumed[0] = consumed[0] + dxUnconsumed;
        consumed[1] = consumed[1] + dyUnconsumed;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        } else if (type != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Api21Impl.onNestedScroll(parent, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
                } catch (AbstractMethodError e) {
                    Log.e(TAG, "ViewParent " + parent + " does not implement interface method onNestedScroll", e);
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
            }
        }
    }

    public static void onNestedPreScroll(@NonNull ViewParent parent, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        if (parent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) parent).onNestedPreScroll(target, dx, dy, consumed, type);
        } else if (type != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Api21Impl.onNestedPreScroll(parent, target, dx, dy, consumed);
                } catch (AbstractMethodError e) {
                    Log.e(TAG, "ViewParent " + parent + " does not implement interface method onNestedPreScroll", e);
                }
            } else if (parent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) parent).onNestedPreScroll(target, dx, dy, consumed);
            }
        }
    }

    public static boolean onNestedFling(@NonNull ViewParent parent, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return Api21Impl.onNestedFling(parent, target, velocityX, velocityY, consumed);
            } catch (AbstractMethodError e) {
                Log.e(TAG, "ViewParent " + parent + " does not implement interface method onNestedFling", e);
                return false;
            }
        } else if (parent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) parent).onNestedFling(target, velocityX, velocityY, consumed);
        } else {
            return false;
        }
    }

    public static boolean onNestedPreFling(@NonNull ViewParent parent, @NonNull View target, float velocityX, float velocityY) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return Api21Impl.onNestedPreFling(parent, target, velocityX, velocityY);
            } catch (AbstractMethodError e) {
                Log.e(TAG, "ViewParent " + parent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        } else if (parent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) parent).onNestedPreFling(target, velocityX, velocityY);
        } else {
            return false;
        }
    }

    public static void notifySubtreeAccessibilityStateChanged(@NonNull ViewParent parent, @NonNull View child, @NonNull View source, int changeType) {
        if (Build.VERSION.SDK_INT >= 19) {
            Api19Impl.notifySubtreeAccessibilityStateChanged(parent, child, source, changeType);
        }
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] iArr = sTempNestedScrollConsumed;
        if (iArr == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view1, int i) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view1, i);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean onStartNestedScroll(ViewParent viewParent, View view, View view1, int i) {
            return viewParent.onStartNestedScroll(view, view1, i);
        }

        @DoNotInline
        static void onNestedScrollAccepted(ViewParent viewParent, View view, View view1, int i) {
            viewParent.onNestedScrollAccepted(view, view1, i);
        }

        @DoNotInline
        static void onStopNestedScroll(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }

        @DoNotInline
        static void onNestedScroll(ViewParent viewParent, View view, int i, int i1, int i2, int i3) {
            viewParent.onNestedScroll(view, i, i1, i2, i3);
        }

        @DoNotInline
        static void onNestedPreScroll(ViewParent viewParent, View view, int i, int i1, int[] ints) {
            viewParent.onNestedPreScroll(view, i, i1, ints);
        }

        @DoNotInline
        static boolean onNestedFling(ViewParent viewParent, View view, float v, float v1, boolean b) {
            return viewParent.onNestedFling(view, v, v1, b);
        }

        @DoNotInline
        static boolean onNestedPreFling(ViewParent viewParent, View view, float v, float v1) {
            return viewParent.onNestedPreFling(view, v, v1);
        }
    }
}
