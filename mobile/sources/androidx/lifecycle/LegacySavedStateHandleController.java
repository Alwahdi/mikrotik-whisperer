package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public final class LegacySavedStateHandleController {
    public static final LegacySavedStateHandleController INSTANCE = new LegacySavedStateHandleController();
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    private LegacySavedStateHandleController() {
    }

    public static final SavedStateHandleController create(SavedStateRegistry registry, Lifecycle lifecycle, String key, Bundle defaultArgs) {
        lu.f(registry, "registry");
        lu.f(lifecycle, "lifecycle");
        lu.c(key);
        SavedStateHandleController controller = new SavedStateHandleController(key, SavedStateHandle.Companion.createHandle(registry.consumeRestoredStateForKey(key), defaultArgs));
        controller.attachToLifecycle(registry, lifecycle);
        INSTANCE.tryToAddRecreator(registry, lifecycle);
        return controller;
    }

    public static final void attachHandleIfNeeded(ViewModel viewModel, SavedStateRegistry registry, Lifecycle lifecycle) {
        lu.f(viewModel, "viewModel");
        lu.f(registry, "registry");
        lu.f(lifecycle, "lifecycle");
        SavedStateHandleController controller = (SavedStateHandleController) viewModel.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (controller != null && !controller.isAttached()) {
            controller.attachToLifecycle(registry, lifecycle);
            INSTANCE.tryToAddRecreator(registry, lifecycle);
        }
    }

    private final void tryToAddRecreator(SavedStateRegistry registry, Lifecycle lifecycle) {
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState == Lifecycle.State.INITIALIZED || currentState.isAtLeast(Lifecycle.State.STARTED)) {
            registry.runOnNextRecreation(OnRecreation.class);
        } else {
            lifecycle.addObserver(new LegacySavedStateHandleController$tryToAddRecreator$1(lifecycle, registry));
        }
    }

    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        public void onRecreated(SavedStateRegistryOwner owner) {
            lu.f(owner, "owner");
            if (owner instanceof ViewModelStoreOwner) {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) owner).getViewModelStore();
                SavedStateRegistry savedStateRegistry = owner.getSavedStateRegistry();
                for (String key : viewModelStore.keys()) {
                    ViewModel viewModel = viewModelStore.get(key);
                    lu.c(viewModel);
                    LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, owner.getLifecycle());
                }
                if (!viewModelStore.keys().isEmpty()) {
                    savedStateRegistry.runOnNextRecreation(OnRecreation.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }
}
