package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: t11  reason: default package */
public abstract class t11<E> extends v11<E> implements List<E>, RandomAccess {
    private static final t21<Object> a = new z11(f21.a, 0);

    public static <E> t11<E> j() {
        return f21.a;
    }

    public static <E> t11<E> m(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        int i = 0;
        Object[] objArr = {e, e2, e3, e4, e5, e6, e7, e8};
        while (i < 8) {
            if (objArr[i] != null) {
                i++;
            } else {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i);
                throw new NullPointerException(sb.toString());
            }
        }
        return new f21(objArr, 8);
    }

    static <E> t11<E> o(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return f21.a;
        }
        return new f21(objArr, length);
    }

    t11() {
    }

    public final u21<E> b() {
        return (t21) listIterator();
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* renamed from: l */
    public t11<E> subList(int i, int i2) {
        t01.d(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return f21.a;
        }
        return new x11(this, i, i3);
    }

    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public final t11<E> c() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public boolean equals(Object obj) {
        if (obj == t01.c(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (h01.a(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object obj2 = get(i2);
                        i2++;
                        if (!h01.a(obj2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return b();
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        t01.e(i, size());
        if (isEmpty()) {
            return a;
        }
        return new z11(this, i);
    }

    public /* synthetic */ ListIterator listIterator() {
        return (t21) listIterator(0);
    }
}
