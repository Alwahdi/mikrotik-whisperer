package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;

public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final rw viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry2, ViewModelStoreOwner viewModelStoreOwner) {
        lu.f(savedStateRegistry2, "savedStateRegistry");
        lu.f(viewModelStoreOwner, "viewModelStoreOwner");
        this.savedStateRegistry = savedStateRegistry2;
        this.viewModel$delegate = vw.a(new SavedStateHandlesProvider$viewModel$2(viewModelStoreOwner));
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) this.viewModel$delegate.getValue();
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle $this$saveState_u24lambda_u241 = bundle;
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            $this$saveState_u24lambda_u241.putAll(bundle2);
        }
        for (Map.Entry element$iv : getViewModel().getHandles().entrySet()) {
            String key = (String) element$iv.getKey();
            Bundle savedState = ((SavedStateHandle) element$iv.getValue()).savedStateProvider().saveState();
            if (!lu.a(savedState, Bundle.EMPTY)) {
                $this$saveState_u24lambda_u241.putBundle(key, savedState);
            }
        }
        Bundle bundle3 = bundle;
        this.restored = false;
        return bundle;
    }

    public final void performRestore() {
        if (!this.restored) {
            this.restoredState = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
            this.restored = true;
            getViewModel();
        }
    }

    public final Bundle consumeRestoredStateForKey(String key) {
        lu.f(key, "key");
        performRestore();
        Bundle bundle = this.restoredState;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = bundle2;
        Bundle bundle4 = this.restoredState;
        if (bundle4 != null) {
            bundle4.remove(key);
        }
        Bundle bundle5 = this.restoredState;
        boolean z = true;
        if (bundle5 == null || !bundle5.isEmpty()) {
            z = false;
        }
        if (z) {
            this.restoredState = null;
        }
        return bundle2;
    }
}
