package androidx.core.database;

import android.database.Cursor;

public final class CursorKt {
    public static final byte[] getBlobOrNull(Cursor $this$getBlobOrNull, int index) {
        lu.f($this$getBlobOrNull, "<this>");
        if ($this$getBlobOrNull.isNull(index)) {
            return null;
        }
        return $this$getBlobOrNull.getBlob(index);
    }

    public static final Double getDoubleOrNull(Cursor $this$getDoubleOrNull, int index) {
        lu.f($this$getDoubleOrNull, "<this>");
        if ($this$getDoubleOrNull.isNull(index)) {
            return null;
        }
        return Double.valueOf($this$getDoubleOrNull.getDouble(index));
    }

    public static final Float getFloatOrNull(Cursor $this$getFloatOrNull, int index) {
        lu.f($this$getFloatOrNull, "<this>");
        if ($this$getFloatOrNull.isNull(index)) {
            return null;
        }
        return Float.valueOf($this$getFloatOrNull.getFloat(index));
    }

    public static final Integer getIntOrNull(Cursor $this$getIntOrNull, int index) {
        lu.f($this$getIntOrNull, "<this>");
        if ($this$getIntOrNull.isNull(index)) {
            return null;
        }
        return Integer.valueOf($this$getIntOrNull.getInt(index));
    }

    public static final Long getLongOrNull(Cursor $this$getLongOrNull, int index) {
        lu.f($this$getLongOrNull, "<this>");
        if ($this$getLongOrNull.isNull(index)) {
            return null;
        }
        return Long.valueOf($this$getLongOrNull.getLong(index));
    }

    public static final Short getShortOrNull(Cursor $this$getShortOrNull, int index) {
        lu.f($this$getShortOrNull, "<this>");
        if ($this$getShortOrNull.isNull(index)) {
            return null;
        }
        return Short.valueOf($this$getShortOrNull.getShort(index));
    }

    public static final String getStringOrNull(Cursor $this$getStringOrNull, int index) {
        lu.f($this$getStringOrNull, "<this>");
        if ($this$getStringOrNull.isNull(index)) {
            return null;
        }
        return $this$getStringOrNull.getString(index);
    }
}
