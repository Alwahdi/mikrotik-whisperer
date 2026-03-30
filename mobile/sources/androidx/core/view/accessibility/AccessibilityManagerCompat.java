package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

public final class AccessibilityManagerCompat {

    @Deprecated
    public interface AccessibilityStateChangeListener {
        @Deprecated
        void onAccessibilityStateChanged(boolean z);
    }

    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean z);
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager manager, AccessibilityStateChangeListener listener) {
        if (listener == null) {
            return false;
        }
        return manager.addAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(listener));
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager manager, AccessibilityStateChangeListener listener) {
        if (listener == null) {
            return false;
        }
        return manager.removeAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(listener));
    }

    private static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
        AccessibilityStateChangeListener mListener;

        AccessibilityStateChangeListenerWrapper(@NonNull AccessibilityStateChangeListener listener) {
            this.mListener = listener;
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof AccessibilityStateChangeListenerWrapper)) {
                return false;
            }
            return this.mListener.equals(((AccessibilityStateChangeListenerWrapper) o).mListener);
        }

        public void onAccessibilityStateChanged(boolean enabled) {
            this.mListener.onAccessibilityStateChanged(enabled);
        }
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager manager) {
        return manager.getInstalledAccessibilityServiceList();
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager manager, int feedbackTypeFlags) {
        return manager.getEnabledAccessibilityServiceList(feedbackTypeFlags);
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager manager) {
        return manager.isTouchExplorationEnabled();
    }

    public static boolean addTouchExplorationStateChangeListener(@NonNull AccessibilityManager manager, @NonNull TouchExplorationStateChangeListener listener) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.addTouchExplorationStateChangeListenerWrapper(manager, listener);
        }
        return false;
    }

    public static boolean removeTouchExplorationStateChangeListener(@NonNull AccessibilityManager manager, @NonNull TouchExplorationStateChangeListener listener) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.removeTouchExplorationStateChangeListenerWrapper(manager, listener);
        }
        return false;
    }

    @RequiresApi(19)
    private static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
        final TouchExplorationStateChangeListener mListener;

        TouchExplorationStateChangeListenerWrapper(@NonNull TouchExplorationStateChangeListener listener) {
            this.mListener = listener;
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof TouchExplorationStateChangeListenerWrapper)) {
                return false;
            }
            return this.mListener.equals(((TouchExplorationStateChangeListenerWrapper) o).mListener);
        }

        public void onTouchExplorationStateChanged(boolean enabled) {
            this.mListener.onTouchExplorationStateChanged(enabled);
        }
    }

    private AccessibilityManagerCompat() {
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static boolean addTouchExplorationStateChangeListenerWrapper(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener listener) {
            return accessibilityManager.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(listener));
        }

        @DoNotInline
        static boolean removeTouchExplorationStateChangeListenerWrapper(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener listener) {
            return accessibilityManager.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(listener));
        }
    }
}
