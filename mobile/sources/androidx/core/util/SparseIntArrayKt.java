package androidx.core.util;

import android.util.SparseIntArray;

public final class SparseIntArrayKt {
    public static final int getSize(SparseIntArray $this$size) {
        lu.f($this$size, "<this>");
        return $this$size.size();
    }

    public static final boolean contains(SparseIntArray $this$contains, int key) {
        lu.f($this$contains, "<this>");
        return $this$contains.indexOfKey(key) >= 0;
    }

    public static final void set(SparseIntArray $this$set, int key, int value) {
        lu.f($this$set, "<this>");
        $this$set.put(key, value);
    }

    public static final SparseIntArray plus(SparseIntArray $this$plus, SparseIntArray other) {
        lu.f($this$plus, "<this>");
        lu.f(other, "other");
        SparseIntArray sparseIntArray = new SparseIntArray($this$plus.size() + other.size());
        putAll(sparseIntArray, $this$plus);
        putAll(sparseIntArray, other);
        return sparseIntArray;
    }

    public static final boolean containsKey(SparseIntArray $this$containsKey, int key) {
        lu.f($this$containsKey, "<this>");
        return $this$containsKey.indexOfKey(key) >= 0;
    }

    public static final boolean containsValue(SparseIntArray $this$containsValue, int value) {
        lu.f($this$containsValue, "<this>");
        return $this$containsValue.indexOfValue(value) >= 0;
    }

    public static final int getOrDefault(SparseIntArray $this$getOrDefault, int key, int defaultValue) {
        lu.f($this$getOrDefault, "<this>");
        return $this$getOrDefault.get(key, defaultValue);
    }

    public static final int getOrElse(SparseIntArray $this$getOrElse, int key, tn<Integer> defaultValue) {
        lu.f($this$getOrElse, "<this>");
        lu.f(defaultValue, "defaultValue");
        int it = $this$getOrElse.indexOfKey(key);
        return it >= 0 ? $this$getOrElse.valueAt(it) : defaultValue.invoke().intValue();
    }

    public static final boolean isEmpty(SparseIntArray $this$isEmpty) {
        lu.f($this$isEmpty, "<this>");
        return $this$isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(SparseIntArray $this$isNotEmpty) {
        lu.f($this$isNotEmpty, "<this>");
        return $this$isNotEmpty.size() != 0;
    }

    public static final boolean remove(SparseIntArray $this$remove, int key, int value) {
        lu.f($this$remove, "<this>");
        int index = $this$remove.indexOfKey(key);
        if (index < 0 || value != $this$remove.valueAt(index)) {
            return false;
        }
        $this$remove.removeAt(index);
        return true;
    }

    public static final void putAll(SparseIntArray $this$putAll, SparseIntArray other) {
        lu.f($this$putAll, "<this>");
        lu.f(other, "other");
        SparseIntArray $this$forEach$iv = other;
        int size = $this$forEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            $this$putAll.put($this$forEach$iv.keyAt(index$iv), $this$forEach$iv.valueAt(index$iv));
        }
    }

    public static final void forEach(SparseIntArray $this$forEach, jo<? super Integer, ? super Integer, jt0> action) {
        lu.f($this$forEach, "<this>");
        lu.f(action, "action");
        int size = $this$forEach.size();
        for (int index = 0; index < size; index++) {
            action.invoke(Integer.valueOf($this$forEach.keyAt(index)), Integer.valueOf($this$forEach.valueAt(index)));
        }
    }

    public static final zs keyIterator(SparseIntArray $this$keyIterator) {
        lu.f($this$keyIterator, "<this>");
        return new SparseIntArrayKt$keyIterator$1($this$keyIterator);
    }

    public static final zs valueIterator(SparseIntArray $this$valueIterator) {
        lu.f($this$valueIterator, "<this>");
        return new SparseIntArrayKt$valueIterator$1($this$valueIterator);
    }
}
