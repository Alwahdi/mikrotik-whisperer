package com.google.firebase.database.collection;

import java.util.Comparator;

public interface h<K, V> {

    public enum a {
        RED,
        BLACK
    }

    h<K, V> a(K k, V v, a aVar, h<K, V> hVar, h<K, V> hVar2);

    h<K, V> b();

    h<K, V> c();

    boolean d();

    h<K, V> e();

    h<K, V> f(K k, Comparator<K> comparator);

    h<K, V> g(K k, V v, Comparator<K> comparator);

    K getKey();

    V getValue();

    h<K, V> h();

    boolean isEmpty();

    int size();
}
