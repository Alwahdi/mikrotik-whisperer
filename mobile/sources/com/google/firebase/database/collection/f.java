package com.google.firebase.database.collection;

import com.google.firebase.database.collection.h;

public class f<K, V> extends j<K, V> {
    private int a = -1;

    f(K key, V value, h<K, V> left, h<K, V> right) {
        super(key, value, left, right);
    }

    /* access modifiers changed from: protected */
    public h.a m() {
        return h.a.BLACK;
    }

    public boolean d() {
        return false;
    }

    public int size() {
        if (this.a == -1) {
            this.a = b().size() + 1 + e().size();
        }
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public void t(h<K, V> left) {
        if (this.a == -1) {
            super.t(left);
            return;
        }
        throw new IllegalStateException("Can't set left after using size");
    }

    /* access modifiers changed from: protected */
    public j<K, V> k(K key, V value, h<K, V> left, h<K, V> right) {
        return new f(key == null ? getKey() : key, value == null ? getValue() : value, left == null ? b() : left, right == null ? e() : right);
    }
}
