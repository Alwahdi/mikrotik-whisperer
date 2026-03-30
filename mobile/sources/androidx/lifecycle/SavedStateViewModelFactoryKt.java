package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SavedStateViewModelFactoryKt {
    /* access modifiers changed from: private */
    public static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE;
    /* access modifiers changed from: private */
    public static final List<Class<?>> VIEWMODEL_SIGNATURE;

    public static final <T extends ViewModel> T newInstance(Class<T> modelClass, Constructor<T> constructor, Object... params) {
        lu.f(modelClass, "modelClass");
        lu.f(constructor, "constructor");
        lu.f(params, "params");
        try {
            return (ViewModel) constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + modelClass, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e3.getCause());
        }
    }

    static {
        Class<SavedStateHandle> cls = SavedStateHandle.class;
        ANDROID_VIEWMODEL_SIGNATURE = l9.f(Application.class, cls);
        VIEWMODEL_SIGNATURE = k9.b(cls);
    }

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> modelClass, List<? extends Class<?>> signature) {
        lu.f(modelClass, "modelClass");
        lu.f(signature, "signature");
        Constructor[] constructors = modelClass.getConstructors();
        lu.e(constructors, "modelClass.constructors");
        int length = constructors.length;
        int i = 0;
        while (i < length) {
            Constructor constructor = constructors[i];
            Class[] parameterTypes = constructor.getParameterTypes();
            lu.e(parameterTypes, "constructor.parameterTypes");
            List parameterTypes2 = l4.q(parameterTypes);
            if (lu.a(signature, parameterTypes2)) {
                lu.d(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            } else if (signature.size() != parameterTypes2.size() || !parameterTypes2.containsAll(signature)) {
                i++;
            } else {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }
}
