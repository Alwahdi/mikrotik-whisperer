package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;

public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    private Application application;
    private Bundle defaultArgs;
    private final ViewModelProvider.Factory factory;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider.AndroidViewModelFactory();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SavedStateViewModelFactory(Application application2, SavedStateRegistryOwner owner) {
        this(application2, owner, (Bundle) null);
        lu.f(owner, "owner");
    }

    public SavedStateViewModelFactory(Application application2, SavedStateRegistryOwner owner, Bundle defaultArgs2) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        lu.f(owner, "owner");
        this.savedStateRegistry = owner.getSavedStateRegistry();
        this.lifecycle = owner.getLifecycle();
        this.defaultArgs = defaultArgs2;
        this.application = application2;
        if (application2 != null) {
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(application2);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.factory = androidViewModelFactory;
    }

    public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
        Constructor constructor;
        lu.f(modelClass, "modelClass");
        lu.f(extras, "extras");
        String key = (String) extras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (key == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (extras.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) != null && extras.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) != null) {
            Application application2 = (Application) extras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
            boolean isAndroidViewModel = AndroidViewModel.class.isAssignableFrom(modelClass);
            if (!isAndroidViewModel || application2 == null) {
                constructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.VIEWMODEL_SIGNATURE);
            } else {
                constructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.ANDROID_VIEWMODEL_SIGNATURE);
            }
            if (constructor == null) {
                return this.factory.create(modelClass, extras);
            }
            if (!isAndroidViewModel || application2 == null) {
                return SavedStateViewModelFactoryKt.newInstance(modelClass, constructor, SavedStateHandleSupport.createSavedStateHandle(extras));
            }
            return SavedStateViewModelFactoryKt.newInstance(modelClass, constructor, application2, SavedStateHandleSupport.createSavedStateHandle(extras));
        } else if (this.lifecycle != null) {
            return create(key, modelClass);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    public final <T extends ViewModel> T create(String key, Class<T> modelClass) {
        Constructor constructor;
        ViewModel viewModel;
        Application application2;
        lu.f(key, "key");
        lu.f(modelClass, "modelClass");
        Lifecycle lifecycle2 = this.lifecycle;
        if (lifecycle2 != null) {
            boolean isAndroidViewModel = AndroidViewModel.class.isAssignableFrom(modelClass);
            if (!isAndroidViewModel || this.application == null) {
                constructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.VIEWMODEL_SIGNATURE);
            } else {
                constructor = SavedStateViewModelFactoryKt.findMatchingConstructor(modelClass, SavedStateViewModelFactoryKt.ANDROID_VIEWMODEL_SIGNATURE);
            }
            if (constructor != null) {
                SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
                lu.c(savedStateRegistry2);
                SavedStateHandleController controller = LegacySavedStateHandleController.create(savedStateRegistry2, lifecycle2, key, this.defaultArgs);
                if (!isAndroidViewModel || (application2 = this.application) == null) {
                    viewModel = SavedStateViewModelFactoryKt.newInstance(modelClass, constructor, controller.getHandle());
                } else {
                    lu.c(application2);
                    viewModel = SavedStateViewModelFactoryKt.newInstance(modelClass, constructor, application2, controller.getHandle());
                }
                viewModel.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", controller);
                return viewModel;
            } else if (this.application != null) {
                return this.factory.create(modelClass);
            } else {
                return ViewModelProvider.NewInstanceFactory.Companion.getInstance().create(modelClass);
            }
        } else {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    public <T extends ViewModel> T create(Class<T> modelClass) {
        lu.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return create(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(ViewModel viewModel) {
        lu.f(viewModel, "viewModel");
        if (this.lifecycle != null) {
            SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
            lu.c(savedStateRegistry2);
            Lifecycle lifecycle2 = this.lifecycle;
            lu.c(lifecycle2);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry2, lifecycle2);
        }
    }
}
