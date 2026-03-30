package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;

public final class SavedStateRegistry {
    private static final Companion Companion = new Companion((Cif) null);
    @Deprecated
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;
    private final SafeIterableMap<String, SavedStateProvider> components = new SafeIterableMap<>();
    private boolean isAllowingSavingState = true;
    private boolean isRestored;
    private Recreator.SavedStateProvider recreatorProvider;
    private Bundle restoredState;

    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    public interface SavedStateProvider {
        Bundle saveState();
    }

    @MainThread
    public final boolean isRestored() {
        return this.isRestored;
    }

    public final boolean isAllowingSavingState$savedstate_release() {
        return this.isAllowingSavingState;
    }

    public final void setAllowingSavingState$savedstate_release(boolean z) {
        this.isAllowingSavingState = z;
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String key) {
        lu.f(key, "key");
        if (this.isRestored) {
            Bundle bundle = this.restoredState;
            if (bundle == null) {
                return null;
            }
            Bundle result = bundle != null ? bundle.getBundle(key) : null;
            Bundle bundle2 = this.restoredState;
            if (bundle2 != null) {
                bundle2.remove(key);
            }
            Bundle bundle3 = this.restoredState;
            boolean z = false;
            if (bundle3 != null && !bundle3.isEmpty()) {
                z = true;
            }
            if (!z) {
                this.restoredState = null;
            }
            return result;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    @MainThread
    public final void registerSavedStateProvider(String key, SavedStateProvider provider) {
        lu.f(key, "key");
        lu.f(provider, "provider");
        if (!(this.components.putIfAbsent(key, provider) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final SavedStateProvider getSavedStateProvider(String key) {
        lu.f(key, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> it = this.components.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            lu.e(next, "components");
            SavedStateProvider value = (SavedStateProvider) next.getValue();
            if (lu.a((String) next.getKey(), key)) {
                return value;
            }
        }
        return null;
    }

    @MainThread
    public final void unregisterSavedStateProvider(String key) {
        lu.f(key, "key");
        this.components.remove(key);
    }

    @MainThread
    public final void runOnNextRecreation(Class<? extends AutoRecreated> clazz) {
        lu.f(clazz, "clazz");
        if (this.isAllowingSavingState) {
            Recreator.SavedStateProvider savedStateProvider = this.recreatorProvider;
            if (savedStateProvider == null) {
                savedStateProvider = new Recreator.SavedStateProvider(this);
            }
            this.recreatorProvider = savedStateProvider;
            try {
                clazz.getDeclaredConstructor(new Class[0]);
                Recreator.SavedStateProvider savedStateProvider2 = this.recreatorProvider;
                if (savedStateProvider2 != null) {
                    String name = clazz.getName();
                    lu.e(name, "clazz.name");
                    savedStateProvider2.add(name);
                }
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
    }

    @MainThread
    public final void performAttach$savedstate_release(Lifecycle lifecycle) {
        lu.f(lifecycle, "lifecycle");
        if (!this.attached) {
            lifecycle.addObserver(new vi0(this));
            this.attached = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    /* access modifiers changed from: private */
    public static final void performAttach$lambda$4(SavedStateRegistry this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        lu.f(this$0, "this$0");
        lu.f(lifecycleOwner, "<anonymous parameter 0>");
        lu.f(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_START) {
            this$0.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.isAllowingSavingState = false;
        }
    }

    @MainThread
    public final void performRestore$savedstate_release(Bundle savedState) {
        if (!this.attached) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        } else if (!this.isRestored) {
            this.restoredState = savedState != null ? savedState.getBundle(SAVED_COMPONENTS_KEY) : null;
            this.isRestored = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
    }

    @MainThread
    public final void performSave(Bundle outBundle) {
        lu.f(outBundle, "outBundle");
        Bundle components2 = new Bundle();
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            components2.putAll(bundle);
        }
        Iterator it = this.components.iteratorWithAdditions();
        lu.e(it, "this.components.iteratorWithAdditions()");
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            components2.putBundle((String) entry.getKey(), ((SavedStateProvider) entry.getValue()).saveState());
        }
        if (!components2.isEmpty()) {
            outBundle.putBundle(SAVED_COMPONENTS_KEY, components2);
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(Cif ifVar) {
            this();
        }

        private Companion() {
        }
    }
}
