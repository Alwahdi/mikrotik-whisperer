package androidx.core.content;

import android.content.ContentValues;

public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(j50<String, ? extends Object>... pairs) {
        lu.f(pairs, "pairs");
        ContentValues contentValues = new ContentValues(pairs.length);
        ContentValues $this$contentValuesOf_u24lambda_u2d0 = contentValues;
        for (j50<String, ? extends Object> j50 : pairs) {
            String key = j50.a();
            Object value = j50.b();
            if (value == null) {
                $this$contentValuesOf_u24lambda_u2d0.putNull(key);
            } else if (value instanceof String) {
                $this$contentValuesOf_u24lambda_u2d0.put(key, (String) value);
            } else if (value instanceof Integer) {
                $this$contentValuesOf_u24lambda_u2d0.put(key, (Integer) value);
            } else if (value instanceof Long) {
                $this$contentValuesOf_u24lambda_u2d0.put(key, (Long) value);
            } else if (value instanceof Boolean) {
                $this$contentValuesOf_u24lambda_u2d0.put(key, (Boolean) value);
            } else if (value instanceof Float) {
                $this$contentValuesOf_u24lambda_u2d0.put(key, (Float) value);
            } else if (value instanceof Double) {
                $this$contentValuesOf_u24lambda_u2d0.put(key, (Double) value);
            } else if (value instanceof byte[]) {
                $this$contentValuesOf_u24lambda_u2d0.put(key, (byte[]) value);
            } else if (value instanceof Byte) {
                $this$contentValuesOf_u24lambda_u2d0.put(key, (Byte) value);
            } else if (value instanceof Short) {
                $this$contentValuesOf_u24lambda_u2d0.put(key, (Short) value);
            } else {
                throw new IllegalArgumentException("Illegal value type " + value.getClass().getCanonicalName() + " for key \"" + key + '\"');
            }
        }
        return contentValues;
    }
}
