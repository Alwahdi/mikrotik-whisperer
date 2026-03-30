package com.google.firebase.database.collection;

import com.google.firebase.database.collection.h;
import java.util.Comparator;

public class g<K, V> implements h<K, V> {
    private static final g a = new g();

    public static <K, V> g<K, V> i() {
        return a;
    }

    private g() {
    }

    public h<K, V> a(K k, V v, h.a color, h<K, V> hVar, h<K, V> hVar2) {
        return this;
    }

    public h<K, V> g(K key, V value, Comparator<K> comparator) {
        return new i(key, value);
    }

    public h<K, V> f(K k, Comparator<K> comparator) {
        return this;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean d() {
        return false;
    }

    public K getKey() {
        return null;
    }

    public V getValue() {
        return null;
    }

    public h<K, V> b() {
        return this;
    }

    public h<K, V> e() {
        return this;
    }

    public h<K, V> h() {
        return this;
    }

    public h<K, V> c() {
        return this;
    }

    public int size() {
        return 0;
    }
}
