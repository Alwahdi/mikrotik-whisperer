package defpackage;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;

/* renamed from: gv0  reason: default package */
public abstract /* synthetic */ class gv0 {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.Companion;
    }

    public static ViewModelProvider.Factory c(ViewModelInitializer<?>... initializers) {
        return ViewModelProvider.Factory.Companion.from(initializers);
    }

    public static ViewModel a(ViewModelProvider.Factory _this, Class modelClass) {
        lu.f(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static ViewModel b(ViewModelProvider.Factory _this, Class modelClass, CreationExtras extras) {
        lu.f(modelClass, "modelClass");
        lu.f(extras, "extras");
        return _this.create(modelClass);
    }
}
