package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;

public final class SingleGeneratedAdapterObserver implements LifecycleEventObserver {
    private final GeneratedAdapter generatedAdapter;

    public SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter2) {
        lu.f(generatedAdapter2, "generatedAdapter");
        this.generatedAdapter = generatedAdapter2;
    }

    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        lu.f(source, "source");
        lu.f(event, NotificationCompat.CATEGORY_EVENT);
        this.generatedAdapter.callMethods(source, event, false, (MethodCallsLogger) null);
        this.generatedAdapter.callMethods(source, event, true, (MethodCallsLogger) null);
    }
}
