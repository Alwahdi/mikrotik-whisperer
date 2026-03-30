package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: z3  reason: default package */
public final class z3<E> extends s<E> {
    public static final a a = new a((Cif) null);
    private static final Object[] b = new Object[0];

    /* renamed from: a  reason: collision with other field name */
    private int f5967a;

    /* renamed from: a  reason: collision with other field name */
    private Object[] f5968a = b;

    /* renamed from: b  reason: collision with other field name */
    private int f5969b;

    public int a() {
        return this.f5969b;
    }

    private final void g(int minCapacity) {
        if (minCapacity >= 0) {
            Object[] objArr = this.f5968a;
            if (minCapacity > objArr.length) {
                if (objArr == b) {
                    this.f5968a = new Object[hd0.a(minCapacity, 10)];
                } else {
                    d(a.a(objArr.length, minCapacity));
                }
            }
        } else {
            throw new IllegalStateException("Deque is too big.");
        }
    }

    private final void d(int newCapacity) {
        Object[] newElements = new Object[newCapacity];
        Object[] objArr = this.f5968a;
        k4.c(objArr, newElements, 0, this.f5967a, objArr.length);
        Object[] objArr2 = this.f5968a;
        int length = objArr2.length;
        int i = this.f5967a;
        k4.c(objArr2, newElements, length - i, 0, i);
        this.f5967a = 0;
        this.f5968a = newElements;
    }

    private final int l(int index) {
        Object[] objArr = this.f5968a;
        return index >= objArr.length ? index - objArr.length : index;
    }

    private final int j(int index) {
        return index < 0 ? this.f5968a.length + index : index;
    }

    private final int h(int index) {
        if (index == l4.j(this.f5968a)) {
            return 0;
        }
        return index + 1;
    }

    private final int f(int index) {
        return index == 0 ? l4.j(this.f5968a) : index - 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final void addFirst(E element) {
        g(size() + 1);
        int f = f(this.f5967a);
        this.f5967a = f;
        this.f5968a[f] = element;
        this.f5969b = size() + 1;
    }

    public final void addLast(E element) {
        g(size() + 1);
        this.f5968a[l(this.f5967a + size())] = element;
        this.f5969b = size() + 1;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            Object[] objArr = this.f5968a;
            int i = this.f5967a;
            Object element = objArr[i];
            objArr[i] = null;
            this.f5967a = h(i);
            this.f5969b = size() - 1;
            return element;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int internalLastIndex = l(this.f5967a + l9.e(this));
            Object[] objArr = this.f5968a;
            Object element = objArr[internalLastIndex];
            objArr[internalLastIndex] = null;
            this.f5969b = size() - 1;
            return element;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public boolean add(E element) {
        addLast(element);
        return true;
    }

    public void add(int index, E element) {
        r.a.b(index, size());
        if (index == size()) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            g(size() + 1);
            int internalIndex = l(this.f5967a + index);
            if (index < ((size() + 1) >> 1)) {
                int decrementedInternalIndex = f(internalIndex);
                int decrementedHead = f(this.f5967a);
                int i = this.f5967a;
                if (decrementedInternalIndex >= i) {
                    Object[] objArr = this.f5968a;
                    objArr[decrementedHead] = objArr[i];
                    k4.c(objArr, objArr, i, i + 1, decrementedInternalIndex + 1);
                } else {
                    Object[] objArr2 = this.f5968a;
                    k4.c(objArr2, objArr2, i - 1, i, objArr2.length);
                    Object[] objArr3 = this.f5968a;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    k4.c(objArr3, objArr3, 0, 1, decrementedInternalIndex + 1);
                }
                this.f5968a[decrementedInternalIndex] = element;
                this.f5967a = decrementedHead;
            } else {
                int tail = l(this.f5967a + size());
                if (internalIndex < tail) {
                    Object[] objArr4 = this.f5968a;
                    k4.c(objArr4, objArr4, internalIndex + 1, internalIndex, tail);
                } else {
                    Object[] objArr5 = this.f5968a;
                    k4.c(objArr5, objArr5, 1, 0, tail);
                    Object[] objArr6 = this.f5968a;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    k4.c(objArr6, objArr6, internalIndex + 1, internalIndex, objArr6.length - 1);
                }
                this.f5968a[internalIndex] = element;
            }
            this.f5969b = size() + 1;
        }
    }

    private final void c(int internalIndex, Collection<? extends E> elements) {
        Iterator iterator = elements.iterator();
        int length = this.f5968a.length;
        for (int index = internalIndex; index < length && iterator.hasNext(); index++) {
            this.f5968a[index] = iterator.next();
        }
        int i = this.f5967a;
        for (int index2 = 0; index2 < i && iterator.hasNext(); index2++) {
            this.f5968a[index2] = iterator.next();
        }
        this.f5969b = size() + elements.size();
    }

    public boolean addAll(Collection<? extends E> elements) {
        lu.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        g(size() + elements.size());
        c(l(this.f5967a + size()), elements);
        return true;
    }

    public boolean addAll(int index, Collection<? extends E> elements) {
        lu.f(elements, "elements");
        r.a.b(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        g(size() + elements.size());
        int tail = l(this.f5967a + size());
        int internalIndex = l(this.f5967a + index);
        int elementsSize = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i = this.f5967a;
            int shiftedHead = i - elementsSize;
            if (internalIndex < i) {
                Object[] objArr = this.f5968a;
                k4.c(objArr, objArr, shiftedHead, i, objArr.length);
                if (elementsSize >= internalIndex) {
                    Object[] objArr2 = this.f5968a;
                    k4.c(objArr2, objArr2, objArr2.length - elementsSize, 0, internalIndex);
                } else {
                    Object[] objArr3 = this.f5968a;
                    k4.c(objArr3, objArr3, objArr3.length - elementsSize, 0, elementsSize);
                    Object[] objArr4 = this.f5968a;
                    k4.c(objArr4, objArr4, 0, elementsSize, internalIndex);
                }
            } else if (shiftedHead >= 0) {
                Object[] objArr5 = this.f5968a;
                k4.c(objArr5, objArr5, shiftedHead, i, internalIndex);
            } else {
                Object[] objArr6 = this.f5968a;
                shiftedHead += objArr6.length;
                int elementsToShift = internalIndex - i;
                int shiftToBack = objArr6.length - shiftedHead;
                if (shiftToBack >= elementsToShift) {
                    k4.c(objArr6, objArr6, shiftedHead, i, internalIndex);
                } else {
                    k4.c(objArr6, objArr6, shiftedHead, i, i + shiftToBack);
                    Object[] objArr7 = this.f5968a;
                    k4.c(objArr7, objArr7, 0, this.f5967a + shiftToBack, internalIndex);
                }
            }
            this.f5967a = shiftedHead;
            c(j(internalIndex - elementsSize), elements);
        } else {
            int shiftedInternalIndex = internalIndex + elementsSize;
            if (internalIndex < tail) {
                int i2 = tail + elementsSize;
                Object[] objArr8 = this.f5968a;
                if (i2 <= objArr8.length) {
                    k4.c(objArr8, objArr8, shiftedInternalIndex, internalIndex, tail);
                } else if (shiftedInternalIndex >= objArr8.length) {
                    k4.c(objArr8, objArr8, shiftedInternalIndex - objArr8.length, internalIndex, tail);
                } else {
                    int shiftToFront = (tail + elementsSize) - objArr8.length;
                    k4.c(objArr8, objArr8, 0, tail - shiftToFront, tail);
                    Object[] objArr9 = this.f5968a;
                    k4.c(objArr9, objArr9, shiftedInternalIndex, internalIndex, tail - shiftToFront);
                }
            } else {
                Object[] objArr10 = this.f5968a;
                k4.c(objArr10, objArr10, elementsSize, 0, tail);
                Object[] objArr11 = this.f5968a;
                if (shiftedInternalIndex >= objArr11.length) {
                    k4.c(objArr11, objArr11, shiftedInternalIndex - objArr11.length, internalIndex, objArr11.length);
                } else {
                    k4.c(objArr11, objArr11, 0, objArr11.length - elementsSize, objArr11.length);
                    Object[] objArr12 = this.f5968a;
                    k4.c(objArr12, objArr12, shiftedInternalIndex, internalIndex, objArr12.length - elementsSize);
                }
            }
            c(internalIndex, elements);
        }
        return true;
    }

    public E get(int index) {
        r.a.a(index, size());
        return this.f5968a[l(this.f5967a + index)];
    }

    public E set(int index, E element) {
        r.a.a(index, size());
        int internalIndex = l(this.f5967a + index);
        Object[] objArr = this.f5968a;
        Object oldElement = objArr[internalIndex];
        objArr[internalIndex] = element;
        return oldElement;
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public int indexOf(Object element) {
        int tail = l(this.f5967a + size());
        int index = this.f5967a;
        if (index < tail) {
            for (int index2 = this.f5967a; index2 < tail; index2++) {
                if (lu.a(element, this.f5968a[index2])) {
                    return index2 - this.f5967a;
                }
            }
            return -1;
        } else if (index < tail) {
            return -1;
        } else {
            int length = this.f5968a.length;
            for (int index3 = this.f5967a; index3 < length; index3++) {
                if (lu.a(element, this.f5968a[index3])) {
                    return index3 - this.f5967a;
                }
            }
            for (int index4 = 0; index4 < tail; index4++) {
                if (lu.a(element, this.f5968a[index4])) {
                    return (this.f5968a.length + index4) - this.f5967a;
                }
            }
            return -1;
        }
    }

    public int lastIndexOf(Object element) {
        int tail = l(this.f5967a + size());
        int i = this.f5967a;
        if (i < tail) {
            int index = tail - 1;
            if (i <= index) {
                while (!lu.a(element, this.f5968a[index])) {
                    if (index != i) {
                        index--;
                    }
                }
                return index - this.f5967a;
            }
        } else if (i > tail) {
            for (int index2 = tail - 1; -1 < index2; index2--) {
                if (lu.a(element, this.f5968a[index2])) {
                    return (this.f5968a.length + index2) - this.f5967a;
                }
            }
            int index3 = l4.j(this.f5968a);
            int i2 = this.f5967a;
            if (i2 <= index3) {
                while (!lu.a(element, this.f5968a[index3])) {
                    if (index3 != i2) {
                        index3--;
                    }
                }
                return index3 - this.f5967a;
            }
        }
        return -1;
    }

    public boolean remove(Object element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    public E b(int index) {
        r.a.a(index, size());
        if (index == l9.e(this)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        int internalIndex = l(this.f5967a + index);
        Object element = this.f5968a[internalIndex];
        if (index < (size() >> 1)) {
            int i = this.f5967a;
            if (internalIndex >= i) {
                Object[] objArr = this.f5968a;
                k4.c(objArr, objArr, i + 1, i, internalIndex);
            } else {
                Object[] objArr2 = this.f5968a;
                k4.c(objArr2, objArr2, 1, 0, internalIndex);
                Object[] objArr3 = this.f5968a;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i2 = this.f5967a;
                k4.c(objArr3, objArr3, i2 + 1, i2, objArr3.length - 1);
            }
            Object[] objArr4 = this.f5968a;
            int i3 = this.f5967a;
            objArr4[i3] = null;
            this.f5967a = h(i3);
        } else {
            int internalLastIndex = l(this.f5967a + l9.e(this));
            if (internalIndex <= internalLastIndex) {
                Object[] objArr5 = this.f5968a;
                k4.c(objArr5, objArr5, internalIndex, internalIndex + 1, internalLastIndex + 1);
            } else {
                Object[] objArr6 = this.f5968a;
                k4.c(objArr6, objArr6, internalIndex, internalIndex + 1, objArr6.length);
                Object[] objArr7 = this.f5968a;
                objArr7[objArr7.length - 1] = objArr7[0];
                k4.c(objArr7, objArr7, 0, 1, internalLastIndex + 1);
            }
            this.f5968a[internalLastIndex] = null;
        }
        this.f5969b = size() - 1;
        return element;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        int newTail$iv;
        lu.f(elements, "elements");
        boolean modified$iv = false;
        if (!isEmpty()) {
            if (!(this.f5968a.length == 0)) {
                int tail$iv = l(this.f5967a + size());
                int newTail$iv2 = this.f5967a;
                boolean modified$iv2 = false;
                if (this.f5967a < tail$iv) {
                    for (int index$iv = this.f5967a; index$iv < tail$iv; index$iv++) {
                        Object element$iv = this.f5968a[index$iv];
                        if (!elements.contains(element$iv)) {
                            this.f5968a[newTail$iv2] = element$iv;
                            newTail$iv2++;
                        } else {
                            modified$iv2 = true;
                        }
                    }
                    k4.e(this.f5968a, null, newTail$iv2, tail$iv);
                    newTail$iv = newTail$iv2;
                    modified$iv = modified$iv2;
                } else {
                    int length = this.f5968a.length;
                    for (int index$iv2 = this.f5967a; index$iv2 < length; index$iv2++) {
                        Object[] objArr = this.f5968a;
                        Object element$iv2 = objArr[index$iv2];
                        objArr[index$iv2] = null;
                        if (!elements.contains(element$iv2)) {
                            this.f5968a[newTail$iv2] = element$iv2;
                            newTail$iv2++;
                        } else {
                            modified$iv2 = true;
                        }
                    }
                    int newTail$iv3 = l(newTail$iv2);
                    for (int index$iv3 = 0; index$iv3 < tail$iv; index$iv3++) {
                        Object[] objArr2 = this.f5968a;
                        Object element$iv3 = objArr2[index$iv3];
                        objArr2[index$iv3] = null;
                        if (!elements.contains(element$iv3)) {
                            this.f5968a[newTail$iv3] = element$iv3;
                            newTail$iv3 = h(newTail$iv3);
                        } else {
                            modified$iv2 = true;
                        }
                    }
                    newTail$iv = newTail$iv3;
                    modified$iv = modified$iv2;
                }
                if (modified$iv) {
                    this.f5969b = j(newTail$iv - this.f5967a);
                }
            }
        }
        return modified$iv;
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        int newTail$iv;
        lu.f(elements, "elements");
        boolean modified$iv = false;
        if (!isEmpty()) {
            if (!(this.f5968a.length == 0)) {
                int tail$iv = l(this.f5967a + size());
                int newTail$iv2 = this.f5967a;
                boolean modified$iv2 = false;
                if (this.f5967a < tail$iv) {
                    for (int index$iv = this.f5967a; index$iv < tail$iv; index$iv++) {
                        Object element$iv = this.f5968a[index$iv];
                        if (elements.contains(element$iv)) {
                            this.f5968a[newTail$iv2] = element$iv;
                            newTail$iv2++;
                        } else {
                            modified$iv2 = true;
                        }
                    }
                    k4.e(this.f5968a, null, newTail$iv2, tail$iv);
                    boolean z = modified$iv2;
                    newTail$iv = newTail$iv2;
                    modified$iv = z;
                } else {
                    int length = this.f5968a.length;
                    for (int index$iv2 = this.f5967a; index$iv2 < length; index$iv2++) {
                        Object[] objArr = this.f5968a;
                        Object element$iv2 = objArr[index$iv2];
                        objArr[index$iv2] = null;
                        if (elements.contains(element$iv2)) {
                            this.f5968a[newTail$iv2] = element$iv2;
                            newTail$iv2++;
                        } else {
                            modified$iv2 = true;
                        }
                    }
                    int newTail$iv3 = l(newTail$iv2);
                    for (int index$iv3 = 0; index$iv3 < tail$iv; index$iv3++) {
                        Object[] objArr2 = this.f5968a;
                        Object element$iv3 = objArr2[index$iv3];
                        objArr2[index$iv3] = null;
                        if (elements.contains(element$iv3)) {
                            this.f5968a[newTail$iv3] = element$iv3;
                            newTail$iv3 = h(newTail$iv3);
                        } else {
                            modified$iv2 = true;
                        }
                    }
                    boolean z2 = modified$iv2;
                    newTail$iv = newTail$iv3;
                    modified$iv = z2;
                }
                if (modified$iv) {
                    this.f5969b = j(newTail$iv - this.f5967a);
                }
            }
        }
        return modified$iv;
    }

    public void clear() {
        int tail = l(this.f5967a + size());
        int i = this.f5967a;
        if (i < tail) {
            k4.e(this.f5968a, null, i, tail);
        } else if (!isEmpty()) {
            Object[] objArr = this.f5968a;
            k4.e(objArr, null, this.f5967a, objArr.length);
            k4.e(this.f5968a, null, 0, tail);
        }
        this.f5967a = 0;
        this.f5969b = 0;
    }

    public <T> T[] toArray(T[] array) {
        lu.f(array, "array");
        T[] a2 = array.length >= size() ? array : i4.a(array, size());
        int tail = l(this.f5967a + size());
        int i = this.f5967a;
        if (i < tail) {
            Object[] unused = k4.d(this.f5968a, a2, 0, i, tail, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f5968a;
            k4.c(objArr, a2, 0, this.f5967a, objArr.length);
            Object[] objArr2 = this.f5968a;
            k4.c(objArr2, a2, objArr2.length - this.f5967a, 0, tail);
        }
        if (a2.length > size()) {
            a2[size()] = null;
        }
        return a2;
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    /* renamed from: z3$a */
    public static final class a {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
        }

        public final int a(int oldCapacity, int minCapacity) {
            int newCapacity = (oldCapacity >> 1) + oldCapacity;
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            int newCapacity2 = 2147483639;
            if (newCapacity - 2147483639 <= 0) {
                return newCapacity;
            }
            if (minCapacity > 2147483639) {
                newCapacity2 = Integer.MAX_VALUE;
            }
            return newCapacity2;
        }
    }
}
