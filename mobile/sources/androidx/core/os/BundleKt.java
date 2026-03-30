package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;

public final class BundleKt {
    public static final Bundle bundleOf(j50<String, ? extends Object>... pairs) {
        lu.f(pairs, "pairs");
        Bundle bundle = new Bundle(pairs.length);
        Bundle $this$bundleOf_u24lambda_u2d0 = bundle;
        for (j50<String, ? extends Object> j50 : pairs) {
            String key = j50.a();
            Object value = j50.b();
            if (value == null) {
                $this$bundleOf_u24lambda_u2d0.putString(key, (String) null);
            } else if (value instanceof Boolean) {
                $this$bundleOf_u24lambda_u2d0.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Byte) {
                $this$bundleOf_u24lambda_u2d0.putByte(key, ((Number) value).byteValue());
            } else if (value instanceof Character) {
                $this$bundleOf_u24lambda_u2d0.putChar(key, ((Character) value).charValue());
            } else if (value instanceof Double) {
                $this$bundleOf_u24lambda_u2d0.putDouble(key, ((Number) value).doubleValue());
            } else if (value instanceof Float) {
                $this$bundleOf_u24lambda_u2d0.putFloat(key, ((Number) value).floatValue());
            } else if (value instanceof Integer) {
                $this$bundleOf_u24lambda_u2d0.putInt(key, ((Number) value).intValue());
            } else if (value instanceof Long) {
                $this$bundleOf_u24lambda_u2d0.putLong(key, ((Number) value).longValue());
            } else if (value instanceof Short) {
                $this$bundleOf_u24lambda_u2d0.putShort(key, ((Number) value).shortValue());
            } else if (value instanceof Bundle) {
                $this$bundleOf_u24lambda_u2d0.putBundle(key, (Bundle) value);
            } else if (value instanceof CharSequence) {
                $this$bundleOf_u24lambda_u2d0.putCharSequence(key, (CharSequence) value);
            } else if (value instanceof Parcelable) {
                $this$bundleOf_u24lambda_u2d0.putParcelable(key, (Parcelable) value);
            } else if (value instanceof boolean[]) {
                $this$bundleOf_u24lambda_u2d0.putBooleanArray(key, (boolean[]) value);
            } else if (value instanceof byte[]) {
                $this$bundleOf_u24lambda_u2d0.putByteArray(key, (byte[]) value);
            } else if (value instanceof char[]) {
                $this$bundleOf_u24lambda_u2d0.putCharArray(key, (char[]) value);
            } else if (value instanceof double[]) {
                $this$bundleOf_u24lambda_u2d0.putDoubleArray(key, (double[]) value);
            } else if (value instanceof float[]) {
                $this$bundleOf_u24lambda_u2d0.putFloatArray(key, (float[]) value);
            } else if (value instanceof int[]) {
                $this$bundleOf_u24lambda_u2d0.putIntArray(key, (int[]) value);
            } else if (value instanceof long[]) {
                $this$bundleOf_u24lambda_u2d0.putLongArray(key, (long[]) value);
            } else if (value instanceof short[]) {
                $this$bundleOf_u24lambda_u2d0.putShortArray(key, (short[]) value);
            } else if (value instanceof Object[]) {
                Class componentType = value.getClass().getComponentType();
                lu.c(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    lu.d(value, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    $this$bundleOf_u24lambda_u2d0.putParcelableArray(key, (Parcelable[]) value);
                } else if (String.class.isAssignableFrom(componentType)) {
                    lu.d(value, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    $this$bundleOf_u24lambda_u2d0.putStringArray(key, (String[]) value);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    lu.d(value, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    $this$bundleOf_u24lambda_u2d0.putCharSequenceArray(key, (CharSequence[]) value);
                } else if (Serializable.class.isAssignableFrom(componentType)) {
                    $this$bundleOf_u24lambda_u2d0.putSerializable(key, (Serializable) value);
                } else {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + key + '\"');
                }
            } else if (value instanceof Serializable) {
                $this$bundleOf_u24lambda_u2d0.putSerializable(key, (Serializable) value);
            } else {
                int i = Build.VERSION.SDK_INT;
                if (i >= 18 && (value instanceof IBinder)) {
                    BundleApi18ImplKt.putBinder($this$bundleOf_u24lambda_u2d0, key, (IBinder) value);
                } else if (i >= 21 && (value instanceof Size)) {
                    BundleApi21ImplKt.putSize($this$bundleOf_u24lambda_u2d0, key, (Size) value);
                } else if (i < 21 || !(value instanceof SizeF)) {
                    throw new IllegalArgumentException("Illegal value type " + value.getClass().getCanonicalName() + " for key \"" + key + '\"');
                } else {
                    BundleApi21ImplKt.putSizeF($this$bundleOf_u24lambda_u2d0, key, (SizeF) value);
                }
            }
        }
        return bundle;
    }

    public static final Bundle bundleOf() {
        return new Bundle(0);
    }
}
