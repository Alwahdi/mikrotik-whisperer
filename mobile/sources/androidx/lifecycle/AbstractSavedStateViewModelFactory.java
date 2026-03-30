package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    public static final Companion Companion = new Companion((Cif) null);
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private Bundle defaultArgs;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    /* access modifiers changed from: protected */
    public abstract <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle);

    public AbstractSavedStateViewModelFactory() {
    }

    public AbstractSavedStateViewModelFactory(SavedStateRegistryOwner owner, Bundle defaultArgs2) {
        lu.f(owner, "owner");
        this.savedStateRegistry = owner.getSavedStateRegistry();
        this.lifecycle = owner.getLifecycle();
        this.defaultArgs = defaultArgs2;
    }

    public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
        lu.f(modelClass, "modelClass");
        lu.f(extras, "extras");
        String key = (String) extras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (key == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (this.savedStateRegistry != null) {
            return create(key, modelClass);
        } else {
            return create(key, modelClass, SavedStateHandleSupport.createSavedStateHandle(extras));
        }
    }

    private final <T extends ViewModel> T create(String key, Class<T> modelClass) {
        SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
        lu.c(savedStateRegistry2);
        Lifecycle lifecycle2 = this.lifecycle;
        lu.c(lifecycle2);
        SavedStateHandleController controller = LegacySavedStateHandleController.create(savedStateRegistry2, lifecycle2, key, this.defaultArgs);
        ViewModel viewModel = create(key, modelClass, controller.getHandle());
        viewModel.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", controller);
        return viewModel;
    }

    public <T extends ViewModel> T create(Class<T> modelClass) {
        lu.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        } else if (this.lifecycle != null) {
            return create(canonicalName, modelClass);
        } else {
            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(ViewModel viewModel) {
        lu.f(viewModel, "viewModel");
        SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
        if (savedStateRegistry2 != null) {
            lu.c(savedStateRegistry2);
            Lifecycle lifecycle2 = this.lifecycle;
            lu.c(lifecycle2);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry2, lifecycle2);
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
