package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public final class SavedStateHandleSupport {
    public static final CreationExtras.Key<Bundle> DEFAULT_ARGS_KEY = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();
    private static final String SAVED_STATE_KEY = "androidx.lifecycle.internal.SavedStateHandlesProvider";
    public static final CreationExtras.Key<SavedStateRegistryOwner> SAVED_STATE_REGISTRY_OWNER_KEY = new SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1();
    private static final String VIEWMODEL_KEY = "androidx.lifecycle.internal.SavedStateHandlesVM";
    public static final CreationExtras.Key<ViewModelStoreOwner> VIEW_MODEL_STORE_OWNER_KEY = new SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1();

    @MainThread
    public static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner> void enableSavedStateHandles(T $this$enableSavedStateHandles) {
        lu.f($this$enableSavedStateHandles, "<this>");
        Lifecycle.State currentState = $this$enableSavedStateHandles.getLifecycle().getCurrentState();
        if (!(currentState == Lifecycle.State.INITIALIZED || currentState == Lifecycle.State.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if ($this$enableSavedStateHandles.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY) == null) {
            SavedStateHandlesProvider provider = new SavedStateHandlesProvider($this$enableSavedStateHandles.getSavedStateRegistry(), (ViewModelStoreOwner) $this$enableSavedStateHandles);
            $this$enableSavedStateHandles.getSavedStateRegistry().registerSavedStateProvider(SAVED_STATE_KEY, provider);
            $this$enableSavedStateHandles.getLifecycle().addObserver(new SavedStateHandleAttacher(provider));
        }
    }

    private static final SavedStateHandle createSavedStateHandle(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, String key, Bundle defaultArgs) {
        SavedStateHandlesProvider provider = getSavedStateHandlesProvider(savedStateRegistryOwner);
        SavedStateHandlesVM viewModel = getSavedStateHandlesVM(viewModelStoreOwner);
        SavedStateHandle savedStateHandle = viewModel.getHandles().get(key);
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        SavedStateHandle it = SavedStateHandle.Companion.createHandle(provider.consumeRestoredStateForKey(key), defaultArgs);
        viewModel.getHandles().put(key, it);
        return it;
    }

    @MainThread
    public static final SavedStateHandle createSavedStateHandle(CreationExtras $this$createSavedStateHandle) {
        lu.f($this$createSavedStateHandle, "<this>");
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) $this$createSavedStateHandle.get(SAVED_STATE_REGISTRY_OWNER_KEY);
        if (savedStateRegistryOwner != null) {
            ViewModelStoreOwner viewModelStateRegistryOwner = (ViewModelStoreOwner) $this$createSavedStateHandle.get(VIEW_MODEL_STORE_OWNER_KEY);
            if (viewModelStateRegistryOwner != null) {
                Bundle defaultArgs = (Bundle) $this$createSavedStateHandle.get(DEFAULT_ARGS_KEY);
                String key = (String) $this$createSavedStateHandle.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
                if (key != null) {
                    return createSavedStateHandle(savedStateRegistryOwner, viewModelStateRegistryOwner, key, defaultArgs);
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner $this$savedStateHandlesVM) {
        Class cls = SavedStateHandlesVM.class;
        lu.f($this$savedStateHandlesVM, "<this>");
        InitializerViewModelFactoryBuilder $this$_get_savedStateHandlesVM__u24lambda_u241 = new InitializerViewModelFactoryBuilder();
        $this$_get_savedStateHandlesVM__u24lambda_u241.addInitializer(xd0.b(cls), SavedStateHandleSupport$savedStateHandlesVM$1$1.INSTANCE);
        return (SavedStateHandlesVM) new ViewModelProvider($this$savedStateHandlesVM, $this$_get_savedStateHandlesVM__u24lambda_u241.build()).get(VIEWMODEL_KEY, cls);
    }

    public static final SavedStateHandlesProvider getSavedStateHandlesProvider(SavedStateRegistryOwner $this$savedStateHandlesProvider) {
        lu.f($this$savedStateHandlesProvider, "<this>");
        SavedStateRegistry.SavedStateProvider savedStateProvider = $this$savedStateHandlesProvider.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY);
        SavedStateHandlesProvider savedStateHandlesProvider = savedStateProvider instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) savedStateProvider : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }
}
