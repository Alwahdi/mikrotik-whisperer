package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;

public final class SparseArrayKt {
    public static final <T> int getSize(SparseArray<T> $this$size) {
        lu.f($this$size, "<this>");
        return $this$size.size();
    }

    public static final <T> boolean contains(SparseArray<T> $this$contains, int key) {
        lu.f($this$contains, "<this>");
        return $this$contains.indexOfKey(key) >= 0;
    }

    public static final <T> void set(SparseArray<T> $this$set, int key, T value) {
        lu.f($this$set, "<this>");
        $this$set.put(key, value);
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> $this$plus, SparseArray<T> other) {
        lu.f($this$plus, "<this>");
        lu.f(other, "other");
        SparseArray sparseArray = new SparseArray($this$plus.size() + other.size());
        putAll(sparseArray, $this$plus);
        putAll(sparseArray, other);
        return sparseArray;
    }

    public static final <T> boolean containsKey(SparseArray<T> $this$containsKey, int key) {
        lu.f($this$containsKey, "<this>");
        return $this$containsKey.indexOfKey(key) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> $this$containsValue, T value) {
        lu.f($this$containsValue, "<this>");
        return $this$containsValue.indexOfValue(value) >= 0;
    }

    public static final <T> T getOrDefault(SparseArray<T> $this$getOrDefault, int key, T defaultValue) {
        lu.f($this$getOrDefault, "<this>");
        T t = $this$getOrDefault.get(key);
        return t == null ? defaultValue : t;
    }

    public static final <T> T getOrElse(SparseArray<T> $this$getOrElse, int key, tn<? extends T> defaultValue) {
        lu.f($this$getOrElse, "<this>");
        lu.f(defaultValue, "defaultValue");
        T t = $this$getOrElse.get(key);
        return t == null ? defaultValue.invoke() : t;
    }

    public static final <T> boolean isEmpty(SparseArray<T> $this$isEmpty) {
        lu.f($this$isEmpty, "<this>");
        return $this$isEmpty.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> $this$isNotEmpty) {
        lu.f($this$isNotEmpty, "<this>");
        return $this$isNotEmpty.size() != 0;
    }

    public static final <T> boolean remove(SparseArray<T> $this$remove, int key, T value) {
        lu.f($this$remove, "<this>");
        int index = $this$remove.indexOfKey(key);
        if (index < 0 || !lu.a(value, $this$remove.valueAt(index))) {
            return false;
        }
        $this$remove.removeAt(index);
        return true;
    }

    public static final <T> void putAll(SparseArray<T> $this$putAll, SparseArray<T> other) {
        lu.f($this$putAll, "<this>");
        lu.f(other, "other");
        SparseArray $this$forEach$iv = other;
        int size = $this$forEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            $this$putAll.put($this$forEach$iv.keyAt(index$iv), $this$forEach$iv.valueAt(index$iv));
        }
    }

    public static final <T> void forEach(SparseArray<T> $this$forEach, jo<? super Integer, ? super T, jt0> action) {
        lu.f($this$forEach, "<this>");
        lu.f(action, "action");
        int size = $this$forEach.size();
        for (int index = 0; index < size; index++) {
            action.invoke(Integer.valueOf($this$forEach.keyAt(index)), $this$forEach.valueAt(index));
        }
    }

    public static final <T> zs keyIterator(SparseArray<T> $this$keyIterator) {
        lu.f($this$keyIterator, "<this>");
        return new SparseArrayKt$keyIterator$1($this$keyIterator);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> $this$valueIterator) {
        lu.f($this$valueIterator, "<this>");
        return new SparseArrayKt$valueIterator$1($this$valueIterator);
    }
}
