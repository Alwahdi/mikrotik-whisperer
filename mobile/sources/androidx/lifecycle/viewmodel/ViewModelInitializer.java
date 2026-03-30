package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;

public final class ViewModelInitializer<T extends ViewModel> {
    private final Class<T> clazz;
    private final vn<CreationExtras, T> initializer;

    public ViewModelInitializer(Class<T> clazz2, vn<? super CreationExtras, ? extends T> initializer2) {
        lu.f(clazz2, "clazz");
        lu.f(initializer2, "initializer");
        this.clazz = clazz2;
        this.initializer = initializer2;
    }

    public final Class<T> getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    public final vn<CreationExtras, T> getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }
}
