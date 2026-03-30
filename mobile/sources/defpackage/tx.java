package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: tx  reason: default package */
public abstract class tx {
    public static <E> ArrayList<E> f() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> g(Iterable<? extends E> elements) {
        v90.n(elements);
        if (elements instanceof Collection) {
            return new ArrayList<>(i9.a(elements));
        }
        return h(elements.iterator());
    }

    public static <E> ArrayList<E> h(Iterator<? extends E> elements) {
        ArrayList<E> list = f();
        zu.a(list, elements);
        return list;
    }

    static boolean a(List<?> thisList, Object other) {
        if (other == v90.n(thisList)) {
            return true;
        }
        if (!(other instanceof List)) {
            return false;
        }
        List<?> otherList = (List) other;
        int size = thisList.size();
        if (size != otherList.size()) {
            return false;
        }
        if (!(thisList instanceof RandomAccess) || !(otherList instanceof RandomAccess)) {
            return zu.b(thisList.iterator(), otherList.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!f40.a(thisList.get(i), otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    static int b(List<?> list, Object element) {
        if (list instanceof RandomAccess) {
            return c(list, element);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (f40.a(element, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int c(List<?> list, Object element) {
        int size = list.size();
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) == null) {
                    return i;
                }
            }
            return -1;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (element.equals(list.get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    static int d(List<?> list, Object element) {
        if (list instanceof RandomAccess) {
            return e(list, element);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (f40.a(element, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int e(List<?> list, Object element) {
        if (element == null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) == null) {
                    return i;
                }
            }
            return -1;
        }
        for (int i2 = list.size() - 1; i2 >= 0; i2--) {
            if (element.equals(list.get(i2))) {
                return i2;
            }
        }
        return -1;
    }
}
