package androidx.customview.poolingcontainer;

import java.util.ArrayList;

final class PoolingContainerListenerHolder {
    private final ArrayList<PoolingContainerListener> listeners = new ArrayList<>();

    public final void addListener(PoolingContainerListener listener) {
        lu.f(listener, "listener");
        this.listeners.add(listener);
    }

    public final void removeListener(PoolingContainerListener listener) {
        lu.f(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void onRelease() {
        for (int i = l9.e(this.listeners); -1 < i; i--) {
            this.listeners.get(i).onRelease();
        }
    }
}
