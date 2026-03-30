package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
final class PersistableBundleApi21ImplKt {
    public static final PersistableBundleApi21ImplKt INSTANCE = new PersistableBundleApi21ImplKt();

    private PersistableBundleApi21ImplKt() {
    }

    @DoNotInline
    public static final PersistableBundle createPersistableBundle(int capacity) {
        return new PersistableBundle(capacity);
    }

    @DoNotInline
    public static final void putValue(PersistableBundle persistableBundle, String key, Object value) {
        lu.f(persistableBundle, "persistableBundle");
        PersistableBundle $this$putValue_u24lambda_u2d0 = persistableBundle;
        if (value == null) {
            $this$putValue_u24lambda_u2d0.putString(key, (String) null);
        } else if (value instanceof Boolean) {
            if (Build.VERSION.SDK_INT >= 22) {
                PersistableBundleApi22ImplKt.putBoolean($this$putValue_u24lambda_u2d0, key, ((Boolean) value).booleanValue());
                return;
            }
            throw new IllegalArgumentException("Illegal value type boolean for key \"" + key + '\"');
        } else if (value instanceof Double) {
            $this$putValue_u24lambda_u2d0.putDouble(key, ((Number) value).doubleValue());
        } else if (value instanceof Integer) {
            $this$putValue_u24lambda_u2d0.putInt(key, ((Number) value).intValue());
        } else if (value instanceof Long) {
            $this$putValue_u24lambda_u2d0.putLong(key, ((Number) value).longValue());
        } else if (value instanceof String) {
            $this$putValue_u24lambda_u2d0.putString(key, (String) value);
        } else if (value instanceof boolean[]) {
            if (Build.VERSION.SDK_INT >= 22) {
                PersistableBundleApi22ImplKt.putBooleanArray($this$putValue_u24lambda_u2d0, key, (boolean[]) value);
                return;
            }
            throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + key + '\"');
        } else if (value instanceof double[]) {
            $this$putValue_u24lambda_u2d0.putDoubleArray(key, (double[]) value);
        } else if (value instanceof int[]) {
            $this$putValue_u24lambda_u2d0.putIntArray(key, (int[]) value);
        } else if (value instanceof long[]) {
            $this$putValue_u24lambda_u2d0.putLongArray(key, (long[]) value);
        } else if (value instanceof Object[]) {
            Class componentType = value.getClass().getComponentType();
            lu.c(componentType);
            if (String.class.isAssignableFrom(componentType)) {
                lu.d(value, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                $this$putValue_u24lambda_u2d0.putStringArray(key, (String[]) value);
                return;
            }
            String valueType = componentType.getCanonicalName();
            throw new IllegalArgumentException("Illegal value array type " + valueType + " for key \"" + key + '\"');
        } else {
            String valueType2 = value.getClass().getCanonicalName();
            throw new IllegalArgumentException("Illegal value type " + valueType2 + " for key \"" + key + '\"');
        }
    }
}
