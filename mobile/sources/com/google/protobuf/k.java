package com.google.protobuf;

import com.google.protobuf.l;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class k extends c<Integer> implements l.c, RandomAccess {
    private static final k a;

    /* renamed from: a  reason: collision with other field name */
    private int f2580a;

    /* renamed from: a  reason: collision with other field name */
    private int[] f2581a;

    static {
        k kVar = new k();
        a = kVar;
        kVar.i();
    }

    public static k d() {
        return a;
    }

    k() {
        this(new int[10], 0);
    }

    private k(int[] other, int size) {
        this.f2581a = other;
        this.f2580a = size;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof k)) {
            return super.equals(o);
        }
        k other = (k) o;
        if (this.f2580a != other.f2580a) {
            return false;
        }
        int[] arr = other.f2581a;
        for (int i = 0; i < this.f2580a; i++) {
            if (this.f2581a[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int result = 1;
        for (int i = 0; i < this.f2580a; i++) {
            result = (result * 31) + this.f2581a[i];
        }
        return result;
    }

    /* renamed from: y */
    public l.c w(int capacity) {
        if (capacity >= this.f2580a) {
            return new k(Arrays.copyOf(this.f2581a, capacity), this.f2580a);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: g */
    public Integer get(int index) {
        return Integer.valueOf(getInt(index));
    }

    public int getInt(int index) {
        f(index);
        return this.f2581a[index];
    }

    public int size() {
        return this.f2580a;
    }

    /* renamed from: l */
    public Integer set(int index, Integer element) {
        return Integer.valueOf(m(index, element.intValue()));
    }

    public int m(int index, int element) {
        a();
        f(index);
        int[] iArr = this.f2581a;
        int previousValue = iArr[index];
        iArr[index] = element;
        return previousValue;
    }

    /* renamed from: b */
    public void add(int index, Integer element) {
        c(index, element.intValue());
    }

    public void k(int element) {
        c(this.f2580a, element);
    }

    private void c(int index, int element) {
        int i;
        a();
        if (index < 0 || index > (i = this.f2580a)) {
            throw new IndexOutOfBoundsException(h(index));
        }
        int[] iArr = this.f2581a;
        if (i < iArr.length) {
            System.arraycopy(iArr, index, iArr, index + 1, i - index);
        } else {
            int[] newArray = new int[(((i * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, newArray, 0, index);
            System.arraycopy(this.f2581a, index, newArray, index + 1, this.f2580a - index);
            this.f2581a = newArray;
        }
        this.f2581a[index] = element;
        this.f2580a++;
        this.modCount++;
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        a();
        if (collection == null) {
            throw new NullPointerException();
        } else if (!(collection instanceof k)) {
            return super.addAll(collection);
        } else {
            k list = (k) collection;
            int i = list.f2580a;
            if (i == 0) {
                return false;
            }
            int i2 = this.f2580a;
            if (Integer.MAX_VALUE - i2 >= i) {
                int newSize = i2 + i;
                int[] iArr = this.f2581a;
                if (newSize > iArr.length) {
                    this.f2581a = Arrays.copyOf(iArr, newSize);
                }
                System.arraycopy(list.f2581a, 0, this.f2581a, this.f2580a, list.f2580a);
                this.f2580a = newSize;
                this.modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
    }

    public boolean remove(Object o) {
        a();
        for (int i = 0; i < this.f2580a; i++) {
            if (o.equals(Integer.valueOf(this.f2581a[i]))) {
                int[] iArr = this.f2581a;
                System.arraycopy(iArr, i + 1, iArr, i, this.f2580a - i);
                this.f2580a--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    public Integer remove(int index) {
        a();
        f(index);
        int[] iArr = this.f2581a;
        int value = iArr[index];
        System.arraycopy(iArr, index + 1, iArr, index, this.f2580a - index);
        this.f2580a--;
        this.modCount++;
        return Integer.valueOf(value);
    }

    private void f(int index) {
        if (index < 0 || index >= this.f2580a) {
            throw new IndexOutOfBoundsException(h(index));
        }
    }

    private String h(int index) {
        return "Index:" + index + ", Size:" + this.f2580a;
    }
}
