package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
final class PersistableBundleApi22ImplKt {
    public static final PersistableBundleApi22ImplKt INSTANCE = new PersistableBundleApi22ImplKt();

    private PersistableBundleApi22ImplKt() {
    }

    @DoNotInline
    public static final void putBoolean(PersistableBundle persistableBundle, String key, boolean value) {
        lu.f(persistableBundle, "persistableBundle");
        persistableBundle.putBoolean(key, value);
    }

    @DoNotInline
    public static final void putBooleanArray(PersistableBundle persistableBundle, String key, boolean[] value) {
        lu.f(persistableBundle, "persistableBundle");
        lu.f(value, "value");
        persistableBundle.putBooleanArray(key, value);
    }
}
