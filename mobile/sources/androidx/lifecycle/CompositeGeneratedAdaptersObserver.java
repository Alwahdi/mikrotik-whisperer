package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;

public final class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {
    private final GeneratedAdapter[] generatedAdapters;

    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapters2) {
        lu.f(generatedAdapters2, "generatedAdapters");
        this.generatedAdapters = generatedAdapters2;
    }

    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        lu.f(source, "source");
        lu.f(event, NotificationCompat.CATEGORY_EVENT);
        MethodCallsLogger logger = new MethodCallsLogger();
        for (GeneratedAdapter adapter : this.generatedAdapters) {
            adapter.callMethods(source, event, false, logger);
        }
        for (GeneratedAdapter adapter2 : this.generatedAdapters) {
            adapter2.callMethods(source, event, true, logger);
        }
    }
}
