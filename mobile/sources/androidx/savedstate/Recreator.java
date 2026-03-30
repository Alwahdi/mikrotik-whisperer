package androidx.savedstate;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class Recreator implements LifecycleEventObserver {
    public static final String CLASSES_KEY = "classes_to_restore";
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    public static final Companion Companion = new Companion((Cif) null);
    private final SavedStateRegistryOwner owner;

    public Recreator(SavedStateRegistryOwner owner2) {
        lu.f(owner2, "owner");
        this.owner = owner2;
    }

    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        lu.f(source, "source");
        lu.f(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_CREATE) {
            source.getLifecycle().removeObserver(this);
            Bundle bundle = this.owner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
            if (bundle != null) {
                List<String> classes = bundle.getStringArrayList(CLASSES_KEY);
                if (classes != null) {
                    for (String className : classes) {
                        reflectiveNew(className);
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }

    private final void reflectiveNew(String className) {
        try {
            Class clazz = Class.forName(className, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
            lu.e(clazz, "{\n                Class.…class.java)\n            }");
            try {
                Constructor constructor = clazz.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
                try {
                    Object newInstance = constructor.newInstance(new Object[0]);
                    lu.e(newInstance, "{\n                constr…wInstance()\n            }");
                    ((SavedStateRegistry.AutoRecreated) newInstance).onRecreated(this.owner);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + className, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + className + " wasn't found", e3);
        }
    }

    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        private final Set<String> classes = new LinkedHashSet();

        public SavedStateProvider(SavedStateRegistry registry) {
            lu.f(registry, "registry");
            registry.registerSavedStateProvider(Recreator.COMPONENT_KEY, this);
        }

        public Bundle saveState() {
            Bundle $this$saveState_u24lambda_u240 = new Bundle();
            $this$saveState_u24lambda_u240.putStringArrayList(Recreator.CLASSES_KEY, new ArrayList(this.classes));
            return $this$saveState_u24lambda_u240;
        }

        public final void add(String className) {
            lu.f(className, "className");
            this.classes.add(className);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(Cif ifVar) {
            this();
        }

        private Companion() {
        }
    }
}
