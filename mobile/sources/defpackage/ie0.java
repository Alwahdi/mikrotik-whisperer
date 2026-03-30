package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: ie0  reason: default package */
public final class ie0<T> {
    private volatile AtomicReferenceArray<T> array;

    public ie0(int initialLength) {
        this.array = new AtomicReferenceArray<>(initialLength);
    }

    public final int a() {
        return this.array.length();
    }

    public final T b(int index) {
        AtomicReferenceArray array2 = this.array;
        if (index < array2.length()) {
            return array2.get(index);
        }
        return null;
    }

    public final void c(int index, T value) {
        AtomicReferenceArray curArray = this.array;
        int curLen = curArray.length();
        if (index < curLen) {
            curArray.set(index, value);
            return;
        }
        AtomicReferenceArray newArray = new AtomicReferenceArray(hd0.a(index + 1, curLen * 2));
        for (int i = 0; i < curLen; i++) {
            newArray.set(i, curArray.get(i));
        }
        newArray.set(index, value);
        this.array = newArray;
    }
}
