package androidx.core.util;

import android.util.SparseBooleanArray;

public final class SparseBooleanArrayKt {
    public static final int getSize(SparseBooleanArray $this$size) {
        lu.f($this$size, "<this>");
        return $this$size.size();
    }

    public static final boolean contains(SparseBooleanArray $this$contains, int key) {
        lu.f($this$contains, "<this>");
        return $this$contains.indexOfKey(key) >= 0;
    }

    public static final void set(SparseBooleanArray $this$set, int key, boolean value) {
        lu.f($this$set, "<this>");
        $this$set.put(key, value);
    }

    public static final SparseBooleanArray plus(SparseBooleanArray $this$plus, SparseBooleanArray other) {
        lu.f($this$plus, "<this>");
        lu.f(other, "other");
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray($this$plus.size() + other.size());
        putAll(sparseBooleanArray, $this$plus);
        putAll(sparseBooleanArray, other);
        return sparseBooleanArray;
    }

    public static final boolean containsKey(SparseBooleanArray $this$containsKey, int key) {
        lu.f($this$containsKey, "<this>");
        return $this$containsKey.indexOfKey(key) >= 0;
    }

    public static final boolean containsValue(SparseBooleanArray $this$containsValue, boolean value) {
        lu.f($this$containsValue, "<this>");
        return $this$containsValue.indexOfValue(value) >= 0;
    }

    public static final boolean getOrDefault(SparseBooleanArray $this$getOrDefault, int key, boolean defaultValue) {
        lu.f($this$getOrDefault, "<this>");
        return $this$getOrDefault.get(key, defaultValue);
    }

    public static final boolean getOrElse(SparseBooleanArray $this$getOrElse, int key, tn<Boolean> defaultValue) {
        lu.f($this$getOrElse, "<this>");
        lu.f(defaultValue, "defaultValue");
        int it = $this$getOrElse.indexOfKey(key);
        return it >= 0 ? $this$getOrElse.valueAt(it) : defaultValue.invoke().booleanValue();
    }

    public static final boolean isEmpty(SparseBooleanArray $this$isEmpty) {
        lu.f($this$isEmpty, "<this>");
        return $this$isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(SparseBooleanArray $this$isNotEmpty) {
        lu.f($this$isNotEmpty, "<this>");
        return $this$isNotEmpty.size() != 0;
    }

    public static final boolean remove(SparseBooleanArray $this$remove, int key, boolean value) {
        lu.f($this$remove, "<this>");
        int index = $this$remove.indexOfKey(key);
        if (index < 0 || value != $this$remove.valueAt(index)) {
            return false;
        }
        $this$remove.delete(key);
        return true;
    }

    public static final void putAll(SparseBooleanArray $this$putAll, SparseBooleanArray other) {
        lu.f($this$putAll, "<this>");
        lu.f(other, "other");
        SparseBooleanArray $this$forEach$iv = other;
        int size = $this$forEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            $this$putAll.put($this$forEach$iv.keyAt(index$iv), $this$forEach$iv.valueAt(index$iv));
        }
    }

    public static final void forEach(SparseBooleanArray $this$forEach, jo<? super Integer, ? super Boolean, jt0> action) {
        lu.f($this$forEach, "<this>");
        lu.f(action, "action");
        int size = $this$forEach.size();
        for (int index = 0; index < size; index++) {
            action.invoke(Integer.valueOf($this$forEach.keyAt(index)), Boolean.valueOf($this$forEach.valueAt(index)));
        }
    }

    public static final zs keyIterator(SparseBooleanArray $this$keyIterator) {
        lu.f($this$keyIterator, "<this>");
        return new SparseBooleanArrayKt$keyIterator$1($this$keyIterator);
    }

    public static final p6 valueIterator(SparseBooleanArray $this$valueIterator) {
        lu.f($this$valueIterator, "<this>");
        return new SparseBooleanArrayKt$valueIterator$1($this$valueIterator);
    }
}
