package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public final class InitializerViewModelFactory implements ViewModelProvider.Factory {
    private final ViewModelInitializer<?>[] initializers;

    public /* synthetic */ ViewModel create(Class cls) {
        return gv0.a(this, cls);
    }

    public InitializerViewModelFactory(ViewModelInitializer<?>... initializers2) {
        lu.f(initializers2, "initializers");
        this.initializers = initializers2;
    }

    public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
        lu.f(modelClass, "modelClass");
        lu.f(extras, "extras");
        Object viewModel = null;
        for (ViewModelInitializer it : this.initializers) {
            if (lu.a(it.getClazz$lifecycle_viewmodel_release(), modelClass)) {
                Object invoke = it.getInitializer$lifecycle_viewmodel_release().invoke(extras);
                viewModel = invoke instanceof ViewModel ? (ViewModel) invoke : null;
            }
        }
        if (viewModel != null) {
            return viewModel;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
