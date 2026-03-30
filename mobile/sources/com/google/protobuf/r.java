package com.google.protobuf;

import java.util.ArrayList;
import java.util.List;

final class r<E> extends c<E> {
    private static final r<Object> a;

    /* renamed from: a  reason: collision with other field name */
    private final List<E> f2589a;

    static {
        r<Object> rVar = new r<>();
        a = rVar;
        rVar.i();
    }

    public static <E> r<E> b() {
        return a;
    }

    r() {
        this(new ArrayList(10));
    }

    private r(List<E> list) {
        this.f2589a = list;
    }

    /* renamed from: c */
    public r<E> w(int capacity) {
        if (capacity >= size()) {
            List<E> newList = new ArrayList<>(capacity);
            newList.addAll(this.f2589a);
            return new r<>(newList);
        }
        throw new IllegalArgumentException();
    }

    public void add(int index, E element) {
        a();
        this.f2589a.add(index, element);
        this.modCount++;
    }

    public E get(int index) {
        return this.f2589a.get(index);
    }

    public E remove(int index) {
        a();
        E toReturn = this.f2589a.remove(index);
        this.modCount++;
        return toReturn;
    }

    public E set(int index, E element) {
        a();
        E toReturn = this.f2589a.set(index, element);
        this.modCount++;
        return toReturn;
    }

    public int size() {
        return this.f2589a.size();
    }
}
