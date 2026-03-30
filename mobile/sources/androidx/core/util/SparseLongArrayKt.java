package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;

public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final int getSize(SparseLongArray $this$size) {
        lu.f($this$size, "<this>");
        return $this$size.size();
    }

    @RequiresApi(18)
    public static final boolean contains(SparseLongArray $this$contains, int key) {
        lu.f($this$contains, "<this>");
        return $this$contains.indexOfKey(key) >= 0;
    }

    @RequiresApi(18)
    public static final void set(SparseLongArray $this$set, int key, long value) {
        lu.f($this$set, "<this>");
        $this$set.put(key, value);
    }

    @RequiresApi(18)
    public static final SparseLongArray plus(SparseLongArray $this$plus, SparseLongArray other) {
        lu.f($this$plus, "<this>");
        lu.f(other, "other");
        SparseLongArray sparseLongArray = new SparseLongArray($this$plus.size() + other.size());
        putAll(sparseLongArray, $this$plus);
        putAll(sparseLongArray, other);
        return sparseLongArray;
    }

    @RequiresApi(18)
    public static final boolean containsKey(SparseLongArray $this$containsKey, int key) {
        lu.f($this$containsKey, "<this>");
        return $this$containsKey.indexOfKey(key) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(SparseLongArray $this$containsValue, long value) {
        lu.f($this$containsValue, "<this>");
        return $this$containsValue.indexOfValue(value) >= 0;
    }

    @RequiresApi(18)
    public static final long getOrDefault(SparseLongArray $this$getOrDefault, int key, long defaultValue) {
        lu.f($this$getOrDefault, "<this>");
        return $this$getOrDefault.get(key, defaultValue);
    }

    @RequiresApi(18)
    public static final long getOrElse(SparseLongArray $this$getOrElse, int key, tn<Long> defaultValue) {
        lu.f($this$getOrElse, "<this>");
        lu.f(defaultValue, "defaultValue");
        int it = $this$getOrElse.indexOfKey(key);
        return it >= 0 ? $this$getOrElse.valueAt(it) : defaultValue.invoke().longValue();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(SparseLongArray $this$isEmpty) {
        lu.f($this$isEmpty, "<this>");
        return $this$isEmpty.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(SparseLongArray $this$isNotEmpty) {
        lu.f($this$isNotEmpty, "<this>");
        return $this$isNotEmpty.size() != 0;
    }

    @RequiresApi(18)
    public static final boolean remove(SparseLongArray $this$remove, int key, long value) {
        lu.f($this$remove, "<this>");
        int index = $this$remove.indexOfKey(key);
        if (index < 0 || value != $this$remove.valueAt(index)) {
            return false;
        }
        $this$remove.removeAt(index);
        return true;
    }

    @RequiresApi(18)
    public static final void putAll(SparseLongArray $this$putAll, SparseLongArray other) {
        lu.f($this$putAll, "<this>");
        lu.f(other, "other");
        SparseLongArray $this$forEach$iv = other;
        int size = $this$forEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            $this$putAll.put($this$forEach$iv.keyAt(index$iv), $this$forEach$iv.valueAt(index$iv));
        }
    }

    @RequiresApi(18)
    public static final void forEach(SparseLongArray $this$forEach, jo<? super Integer, ? super Long, jt0> action) {
        lu.f($this$forEach, "<this>");
        lu.f(action, "action");
        int size = $this$forEach.size();
        for (int index = 0; index < size; index++) {
            action.invoke(Integer.valueOf($this$forEach.keyAt(index)), Long.valueOf($this$forEach.valueAt(index)));
        }
    }

    @RequiresApi(18)
    public static final zs keyIterator(SparseLongArray $this$keyIterator) {
        lu.f($this$keyIterator, "<this>");
        return new SparseLongArrayKt$keyIterator$1($this$keyIterator);
    }

    @RequiresApi(18)
    public static final dz valueIterator(SparseLongArray $this$valueIterator) {
        lu.f($this$valueIterator, "<this>");
        return new SparseLongArrayKt$valueIterator$1($this$valueIterator);
    }
}
