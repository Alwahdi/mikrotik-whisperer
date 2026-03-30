package androidx.customview.poolingcontainer;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;

public final class PoolingContainer {
    private static final int IsPoolingContainerTag = R.id.is_pooling_container_tag;
    private static final int PoolingContainerListenerHolderTag = R.id.pooling_container_listener_holder_tag;

    public static final void addPoolingContainerListener(View $this$addPoolingContainerListener, PoolingContainerListener listener) {
        lu.f($this$addPoolingContainerListener, "<this>");
        lu.f(listener, "listener");
        getPoolingContainerListenerHolder($this$addPoolingContainerListener).addListener(listener);
    }

    public static final void removePoolingContainerListener(View $this$removePoolingContainerListener, PoolingContainerListener listener) {
        lu.f($this$removePoolingContainerListener, "<this>");
        lu.f(listener, "listener");
        getPoolingContainerListenerHolder($this$removePoolingContainerListener).removeListener(listener);
    }

    public static final boolean isPoolingContainer(View $this$isPoolingContainer) {
        lu.f($this$isPoolingContainer, "<this>");
        Object tag = $this$isPoolingContainer.getTag(IsPoolingContainerTag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final void setPoolingContainer(View $this$isPoolingContainer, boolean value) {
        lu.f($this$isPoolingContainer, "<this>");
        $this$isPoolingContainer.setTag(IsPoolingContainerTag, Boolean.valueOf(value));
    }

    public static final boolean isWithinPoolingContainer(View $this$isWithinPoolingContainer) {
        lu.f($this$isWithinPoolingContainer, "<this>");
        for (ViewParent it : ViewKt.getAncestors($this$isWithinPoolingContainer)) {
            if ((it instanceof View) && isPoolingContainer((View) it)) {
                return true;
            }
        }
        return false;
    }

    public static final void callPoolingContainerOnRelease(View $this$callPoolingContainerOnRelease) {
        lu.f($this$callPoolingContainerOnRelease, "<this>");
        for (View child : ViewKt.getAllViews($this$callPoolingContainerOnRelease)) {
            getPoolingContainerListenerHolder(child).onRelease();
        }
    }

    public static final void callPoolingContainerOnReleaseForChildren(ViewGroup $this$callPoolingContainerOnReleaseForChildren) {
        lu.f($this$callPoolingContainerOnReleaseForChildren, "<this>");
        for (View child : ViewGroupKt.getChildren($this$callPoolingContainerOnReleaseForChildren)) {
            getPoolingContainerListenerHolder(child).onRelease();
        }
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View $this$poolingContainerListenerHolder) {
        int i = PoolingContainerListenerHolderTag;
        PoolingContainerListenerHolder lifecycle = (PoolingContainerListenerHolder) $this$poolingContainerListenerHolder.getTag(i);
        if (lifecycle != null) {
            return lifecycle;
        }
        PoolingContainerListenerHolder lifecycle2 = new PoolingContainerListenerHolder();
        $this$poolingContainerListenerHolder.setTag(i, lifecycle2);
        return lifecycle2;
    }
}
