package com.google.firebase.database.collection;

import com.google.firebase.database.collection.h;

public class i<K, V> extends j<K, V> {
    i(K key, V value) {
        super(key, value, g.i(), g.i());
    }

    i(K key, V value, h<K, V> left, h<K, V> right) {
        super(key, value, left, right);
    }

    /* access modifiers changed from: protected */
    public h.a m() {
        return h.a.RED;
    }

    public boolean d() {
        return true;
    }

    public int size() {
        return b().size() + 1 + e().size();
    }

    /* access modifiers changed from: protected */
    public j<K, V> k(K key, V value, h<K, V> left, h<K, V> right) {
        return new i(key == null ? getKey() : key, value == null ? getValue() : value, left == null ? b() : left, right == null ? e() : right);
    }
}
