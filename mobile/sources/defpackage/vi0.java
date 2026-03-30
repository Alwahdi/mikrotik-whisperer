package defpackage;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;

/* renamed from: vi0  reason: default package */
public final /* synthetic */ class vi0 implements LifecycleEventObserver {
    public final /* synthetic */ SavedStateRegistry a;

    public /* synthetic */ vi0(SavedStateRegistry savedStateRegistry) {
        this.a = savedStateRegistry;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistry.performAttach$lambda$4(this.a, lifecycleOwner, event);
    }
}
