package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;

public final class SavedStateRegistryController {
    public static final Companion Companion = new Companion((Cif) null);
    private boolean attached;
    private final SavedStateRegistryOwner owner;
    private final SavedStateRegistry savedStateRegistry;

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner, Cif ifVar) {
        this(savedStateRegistryOwner);
    }

    public static final SavedStateRegistryController create(SavedStateRegistryOwner savedStateRegistryOwner) {
        return Companion.create(savedStateRegistryOwner);
    }

    private SavedStateRegistryController(SavedStateRegistryOwner owner2) {
        this.owner = owner2;
        this.savedStateRegistry = new SavedStateRegistry();
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    @MainThread
    public final void performAttach() {
        Lifecycle lifecycle = this.owner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.INITIALIZED) {
            lifecycle.addObserver(new Recreator(this.owner));
            this.savedStateRegistry.performAttach$savedstate_release(lifecycle);
            this.attached = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    @MainThread
    public final void performRestore(Bundle savedState) {
        if (!this.attached) {
            performAttach();
        }
        Lifecycle lifecycle = this.owner.getLifecycle();
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            this.savedStateRegistry.performRestore$savedstate_release(savedState);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.getCurrentState()).toString());
    }

    @MainThread
    public final void performSave(Bundle outBundle) {
        lu.f(outBundle, "outBundle");
        this.savedStateRegistry.performSave(outBundle);
    }

    public static final class Companion {
        public /* synthetic */ Companion(Cif ifVar) {
            this();
        }

        private Companion() {
        }

        public final SavedStateRegistryController create(SavedStateRegistryOwner owner) {
            lu.f(owner, "owner");
            return new SavedStateRegistryController(owner, (Cif) null);
        }
    }
}
