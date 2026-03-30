package defpackage;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

/* renamed from: cs  reason: default package */
public abstract class cs<E> extends as<E> implements Set<E> {
    private transient bs<E> a;

    public abstract int hashCode();

    /* access modifiers changed from: package-private */
    public abstract bs<E> o();

    /* access modifiers changed from: package-private */
    public abstract boolean p();

    public static <E> cs<E> q() {
        return ae0.a;
    }

    public static <E> cs<E> r(E element) {
        return new em0(element);
    }

    private static <E> cs<E> l(int n, Object... elements) {
        switch (n) {
            case 0:
                return q();
            case 1:
                return r(elements[0]);
            default:
                int tableSize = j(n);
                Object[] table = new Object[tableSize];
                int mask = tableSize - 1;
                int hashCode = 0;
                int uniques = 0;
                for (int i = 0; i < n; i++) {
                    Object element = x30.a(elements[i], i);
                    int hash = element.hashCode();
                    int j = oq.a(hash);
                    while (true) {
                        int index = j & mask;
                        Object value = table[index];
                        if (value == null) {
                            elements[uniques] = element;
                            table[index] = element;
                            hashCode += hash;
                            uniques++;
                        } else if (value.equals(element) == 0) {
                            j++;
                        }
                    }
                }
                Arrays.fill(elements, uniques, n, (Object) null);
                if (uniques == 1) {
                    return new em0(elements[0], hashCode);
                }
                if (j(uniques) < tableSize / 2) {
                    return l(uniques, elements);
                }
                return new ae0(s(uniques, elements.length) ? Arrays.copyOf(elements, uniques) : elements, hashCode, table, mask, uniques);
        }
    }

    private static boolean s(int actualUnique, int expectedUnique) {
        return actualUnique < (expectedUnique >> 1) + (expectedUnique >> 2);
    }

    static int j(int setSize) {
        int setSize2 = Math.max(setSize, 2);
        boolean z = true;
        if (setSize2 < 751619276) {
            int tableSize = Integer.highestOneBit(setSize2 - 1) << 1;
            while (((double) tableSize) * 0.7d < ((double) setSize2)) {
                tableSize <<= 1;
            }
            return tableSize;
        }
        if (setSize2 >= 1073741824) {
            z = false;
        }
        v90.e(z, "collection too large");
        return BasicMeasure.EXACTLY;
    }

    public static <E> cs<E> m(Collection<? extends E> elements) {
        if ((elements instanceof cs) && !(elements instanceof SortedSet)) {
            ImmutableSet<E> set = (cs) elements;
            if (!set.f()) {
                return set;
            }
        }
        Object[] array = elements.toArray();
        return l(array.length, array);
    }

    cs() {
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof cs) || !p() || !((cs) object).p() || hashCode() == object.hashCode()) {
            return yk0.a(this, object);
        }
        return false;
    }

    public bs<E> h() {
        ImmutableList<E> result = this.a;
        if (result != null) {
            return result;
        }
        bs<E> o = o();
        this.a = o;
        return o;
    }
}
