package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import java.util.Iterator;

public final class LongSparseArrayKt {
    @RequiresApi(16)
    public static final <T> int getSize(LongSparseArray<T> $this$size) {
        lu.f($this$size, "<this>");
        return $this$size.size();
    }

    @RequiresApi(16)
    public static final <T> boolean contains(LongSparseArray<T> $this$contains, long key) {
        lu.f($this$contains, "<this>");
        return $this$contains.indexOfKey(key) >= 0;
    }

    @RequiresApi(16)
    public static final <T> void set(LongSparseArray<T> $this$set, long key, T value) {
        lu.f($this$set, "<this>");
        $this$set.put(key, value);
    }

    @RequiresApi(16)
    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> $this$plus, LongSparseArray<T> other) {
        lu.f($this$plus, "<this>");
        lu.f(other, "other");
        LongSparseArray longSparseArray = new LongSparseArray($this$plus.size() + other.size());
        putAll(longSparseArray, $this$plus);
        putAll(longSparseArray, other);
        return longSparseArray;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(LongSparseArray<T> $this$containsKey, long key) {
        lu.f($this$containsKey, "<this>");
        return $this$containsKey.indexOfKey(key) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(LongSparseArray<T> $this$containsValue, T value) {
        lu.f($this$containsValue, "<this>");
        return $this$containsValue.indexOfValue(value) >= 0;
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(LongSparseArray<T> $this$getOrDefault, long key, T defaultValue) {
        lu.f($this$getOrDefault, "<this>");
        T t = $this$getOrDefault.get(key);
        return t == null ? defaultValue : t;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(LongSparseArray<T> $this$getOrElse, long key, tn<? extends T> defaultValue) {
        lu.f($this$getOrElse, "<this>");
        lu.f(defaultValue, "defaultValue");
        T t = $this$getOrElse.get(key);
        return t == null ? defaultValue.invoke() : t;
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(LongSparseArray<T> $this$isEmpty) {
        lu.f($this$isEmpty, "<this>");
        return $this$isEmpty.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(LongSparseArray<T> $this$isNotEmpty) {
        lu.f($this$isNotEmpty, "<this>");
        return $this$isNotEmpty.size() != 0;
    }

    @RequiresApi(16)
    public static final <T> boolean remove(LongSparseArray<T> $this$remove, long key, T value) {
        lu.f($this$remove, "<this>");
        int index = $this$remove.indexOfKey(key);
        if (index < 0 || !lu.a(value, $this$remove.valueAt(index))) {
            return false;
        }
        $this$remove.removeAt(index);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void putAll(LongSparseArray<T> $this$putAll, LongSparseArray<T> other) {
        lu.f($this$putAll, "<this>");
        lu.f(other, "other");
        LongSparseArray $this$forEach$iv = other;
        int size = $this$forEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            $this$putAll.put($this$forEach$iv.keyAt(index$iv), $this$forEach$iv.valueAt(index$iv));
        }
    }

    @RequiresApi(16)
    public static final <T> void forEach(LongSparseArray<T> $this$forEach, jo<? super Long, ? super T, jt0> action) {
        lu.f($this$forEach, "<this>");
        lu.f(action, "action");
        int size = $this$forEach.size();
        for (int index = 0; index < size; index++) {
            action.invoke(Long.valueOf($this$forEach.keyAt(index)), $this$forEach.valueAt(index));
        }
    }

    @RequiresApi(16)
    public static final <T> dz keyIterator(LongSparseArray<T> $this$keyIterator) {
        lu.f($this$keyIterator, "<this>");
        return new LongSparseArrayKt$keyIterator$1($this$keyIterator);
    }

    @RequiresApi(16)
    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> $this$valueIterator) {
        lu.f($this$valueIterator, "<this>");
        return new LongSparseArrayKt$valueIterator$1($this$valueIterator);
    }
}
