package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ViewModelProvider {
    private final CreationExtras defaultCreationExtras;
    private final Factory factory;
    private final ViewModelStore store;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory2) {
        this(viewModelStore, factory2, (CreationExtras) null, 4, (Cif) null);
        lu.f(viewModelStore, "store");
        lu.f(factory2, "factory");
    }

    public ViewModelProvider(ViewModelStore store2, Factory factory2, CreationExtras defaultCreationExtras2) {
        lu.f(store2, "store");
        lu.f(factory2, "factory");
        lu.f(defaultCreationExtras2, "defaultCreationExtras");
        this.store = store2;
        this.factory = factory2;
        this.defaultCreationExtras = defaultCreationExtras2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory2, CreationExtras creationExtras, int i, Cif ifVar) {
        this(viewModelStore, factory2, (i & 4) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    public interface Factory {
        public static final Companion Companion = Companion.$$INSTANCE;

        <T extends ViewModel> T create(Class<T> cls);

        <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras);

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final Factory from(ViewModelInitializer<?>... initializers) {
                lu.f(initializers, "initializers");
                return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(initializers, initializers.length));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel) {
            lu.f(viewModel, "viewModel");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner owner) {
        this(owner.getViewModelStore(), AndroidViewModelFactory.Companion.defaultFactory$lifecycle_viewmodel_release(owner), ViewModelProviderGetKt.defaultCreationExtras(owner));
        lu.f(owner, "owner");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner owner, Factory factory2) {
        this(owner.getViewModelStore(), factory2, ViewModelProviderGetKt.defaultCreationExtras(owner));
        lu.f(owner, "owner");
        lu.f(factory2, "factory");
    }

    @MainThread
    public <T extends ViewModel> T get(Class<T> modelClass) {
        lu.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @MainThread
    public <T extends ViewModel> T get(String key, Class<T> modelClass) {
        ViewModel it;
        lu.f(key, "key");
        lu.f(modelClass, "modelClass");
        ViewModel viewModel = this.store.get(key);
        if (modelClass.isInstance(viewModel)) {
            Factory factory2 = this.factory;
            OnRequeryFactory onRequeryFactory = factory2 instanceof OnRequeryFactory ? (OnRequeryFactory) factory2 : null;
            if (onRequeryFactory != null) {
                lu.c(viewModel);
                onRequeryFactory.onRequery(viewModel);
            }
            lu.d(viewModel, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return viewModel;
        }
        MutableCreationExtras extras = new MutableCreationExtras(this.defaultCreationExtras);
        extras.set(NewInstanceFactory.VIEW_MODEL_KEY, key);
        try {
            it = this.factory.create(modelClass, extras);
        } catch (AbstractMethodError e) {
            it = this.factory.create(modelClass);
        }
        this.store.put(key, it);
        return it;
    }

    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = new Companion((Cif) null);
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = Companion.ViewModelKeyImpl.INSTANCE;
        /* access modifiers changed from: private */
        public static NewInstanceFactory sInstance;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return gv0.b(this, cls, creationExtras);
        }

        public <T extends ViewModel> T create(Class<T> modelClass) {
            lu.f(modelClass, "modelClass");
            try {
                T newInstance = modelClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                lu.e(newInstance, "{\n                modelC…wInstance()\n            }");
                return (ViewModel) newInstance;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e3);
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(Cif ifVar) {
                this();
            }

            public static /* synthetic */ void getInstance$annotations() {
            }

            private Companion() {
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.sInstance == null) {
                    NewInstanceFactory.sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory access$getSInstance$cp = NewInstanceFactory.sInstance;
                lu.c(access$getSInstance$cp);
                return access$getSInstance$cp;
            }

            private static final class ViewModelKeyImpl implements CreationExtras.Key<String> {
                public static final ViewModelKeyImpl INSTANCE = new ViewModelKeyImpl();

                private ViewModelKeyImpl() {
                }
            }
        }
    }

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static final CreationExtras.Key<Application> APPLICATION_KEY = Companion.ApplicationKeyImpl.INSTANCE;
        public static final Companion Companion = new Companion((Cif) null);
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
        /* access modifiers changed from: private */
        public static AndroidViewModelFactory sInstance;
        private final Application application;

        public static final AndroidViewModelFactory getInstance(Application application2) {
            return Companion.getInstance(application2);
        }

        private AndroidViewModelFactory(Application application2, int unused) {
            this.application = application2;
        }

        public AndroidViewModelFactory() {
            this((Application) null, 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(Application application2) {
            this(application2, 0);
            lu.f(application2, "application");
        }

        public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
            lu.f(modelClass, "modelClass");
            lu.f(extras, "extras");
            if (this.application != null) {
                return create(modelClass);
            }
            Application application2 = (Application) extras.get(APPLICATION_KEY);
            if (application2 != null) {
                return create(modelClass, application2);
            }
            if (!AndroidViewModel.class.isAssignableFrom(modelClass)) {
                return super.create(modelClass);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public <T extends ViewModel> T create(Class<T> modelClass) {
            lu.f(modelClass, "modelClass");
            Application application2 = this.application;
            if (application2 != null) {
                return create(modelClass, application2);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        private final <T extends ViewModel> T create(Class<T> modelClass, Application app) {
            if (!AndroidViewModel.class.isAssignableFrom(modelClass)) {
                return super.create(modelClass);
            }
            try {
                T t = (ViewModel) modelClass.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{app});
                lu.e(t, "{\n                try {\n…          }\n            }");
                return t;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e4);
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(Cif ifVar) {
                this();
            }

            private Companion() {
            }

            public final Factory defaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner owner) {
                lu.f(owner, "owner");
                return owner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelProviderFactory() : NewInstanceFactory.Companion.getInstance();
            }

            public final AndroidViewModelFactory getInstance(Application application) {
                lu.f(application, "application");
                if (AndroidViewModelFactory.sInstance == null) {
                    AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory access$getSInstance$cp = AndroidViewModelFactory.sInstance;
                lu.c(access$getSInstance$cp);
                return access$getSInstance$cp;
            }

            private static final class ApplicationKeyImpl implements CreationExtras.Key<Application> {
                public static final ApplicationKeyImpl INSTANCE = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }
        }
    }
}
