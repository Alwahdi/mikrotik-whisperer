package androidx.activity.contextaware;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ContextAwareHelper {
    private volatile Context context;
    private final Set<OnContextAvailableListener> listeners = new CopyOnWriteArraySet();

    public final Context peekAvailableContext() {
        return this.context;
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener listener) {
        lu.f(listener, "listener");
        Context it = this.context;
        if (it != null) {
            listener.onContextAvailable(it);
        }
        this.listeners.add(listener);
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener listener) {
        lu.f(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void dispatchOnContextAvailable(Context context2) {
        lu.f(context2, "context");
        this.context = context2;
        for (OnContextAvailableListener listener : this.listeners) {
            listener.onContextAvailable(context2);
        }
    }

    public final void clearAvailableContext() {
        this.context = null;
    }
}
