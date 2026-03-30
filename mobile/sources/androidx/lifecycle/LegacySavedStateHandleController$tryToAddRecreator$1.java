package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;

public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements LifecycleEventObserver {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ SavedStateRegistry $registry;

    LegacySavedStateHandleController$tryToAddRecreator$1(Lifecycle $lifecycle2, SavedStateRegistry $registry2) {
        this.$lifecycle = $lifecycle2;
        this.$registry = $registry2;
    }

    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        lu.f(source, "source");
        lu.f(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_START) {
            this.$lifecycle.removeObserver(this);
            this.$registry.runOnNextRecreation(LegacySavedStateHandleController.OnRecreation.class);
        }
    }
}
