package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: bs  reason: default package */
public abstract class bs<E> extends as<E> implements List<E>, RandomAccess {
    private static final mt0<Object> a = new a(zd0.a, 0);

    public static <E> bs<E> q() {
        return zd0.a;
    }

    public static <E> bs<E> r(E element) {
        return l(element);
    }

    private static <E> bs<E> l(Object... elements) {
        return h(x30.b(elements));
    }

    static <E> bs<E> h(Object[] elements) {
        return j(elements, elements.length);
    }

    static <E> bs<E> j(Object[] elements, int length) {
        if (length == 0) {
            return q();
        }
        return new zd0(elements, length);
    }

    bs() {
    }

    /* renamed from: m */
    public lt0<E> iterator() {
        return listIterator();
    }

    /* renamed from: o */
    public mt0<E> listIterator() {
        return listIterator(0);
    }

    /* renamed from: p */
    public mt0<E> listIterator(int index) {
        v90.q(index, size());
        if (isEmpty()) {
            return a;
        }
        return new a(this, index);
    }

    /* renamed from: bs$a */
    static class a<E> extends p<E> {
        private final bs<E> a;

        a(bs<E> list, int index) {
            super(list.size(), index);
            this.a = list;
        }

        /* access modifiers changed from: protected */
        public E a(int index) {
            return this.a.get(index);
        }
    }

    public int indexOf(Object object) {
        if (object == null) {
            return -1;
        }
        return tx.b(this, object);
    }

    public int lastIndexOf(Object object) {
        if (object == null) {
            return -1;
        }
        return tx.d(this, object);
    }

    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    /* renamed from: s */
    public bs<E> subList(int fromIndex, int toIndex) {
        v90.s(fromIndex, toIndex, size());
        int length = toIndex - fromIndex;
        if (length == size()) {
            return this;
        }
        if (length == 0) {
            return q();
        }
        return t(fromIndex, toIndex);
    }

    /* access modifiers changed from: package-private */
    public bs<E> t(int fromIndex, int toIndex) {
        return new b(fromIndex, toIndex - fromIndex);
    }

    /* renamed from: bs$b */
    class b extends bs<E> {
        final transient int a;
        final transient int b;

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return bs.super.iterator();
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return bs.super.listIterator();
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return bs.super.listIterator(i);
        }

        b(int offset, int length) {
            this.a = offset;
            this.b = length;
        }

        public int size() {
            return this.b;
        }

        /* access modifiers changed from: package-private */
        public Object[] b() {
            return bs.this.b();
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return bs.this.d() + this.a;
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return bs.this.d() + this.a + this.b;
        }

        public E get(int index) {
            v90.l(index, this.b);
            return bs.this.get(this.a + index);
        }

        /* renamed from: s */
        public bs<E> subList(int fromIndex, int toIndex) {
            v90.s(fromIndex, toIndex, this.b);
            bs bsVar = bs.this;
            int i = this.a;
            return bsVar.subList(fromIndex + i, i + toIndex);
        }
    }

    public final boolean addAll(int index, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final E set(int index, E e) {
        throw new UnsupportedOperationException();
    }

    public final void add(int index, E e) {
        throw new UnsupportedOperationException();
    }

    public final E remove(int index) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int a(Object[] dst, int offset) {
        int size = size();
        for (int i = 0; i < size; i++) {
            dst[offset + i] = get(i);
        }
        return offset + size;
    }

    public boolean equals(Object obj) {
        return tx.a(this, obj);
    }

    public int hashCode() {
        int hashCode = 1;
        int n = size();
        for (int i = 0; i < n; i++) {
            hashCode = ~(~((hashCode * 31) + get(i).hashCode()));
        }
        return hashCode;
    }
}
