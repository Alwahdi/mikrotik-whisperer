package com.google.firebase.database.collection;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class d<K, V> implements Iterator<Map.Entry<K, V>> {
    private final ArrayDeque<j<K, V>> a = new ArrayDeque<>();

    /* renamed from: a  reason: collision with other field name */
    private final boolean f2167a;

    d(h<K, V> root, K startKey, Comparator<K> comparator, boolean isReverse) {
        int cmp;
        this.f2167a = isReverse;
        h<K, V> hVar = root;
        while (!hVar.isEmpty()) {
            if (startKey == null) {
                cmp = 1;
            } else if (isReverse) {
                cmp = comparator.compare(startKey, hVar.getKey());
            } else {
                cmp = comparator.compare(hVar.getKey(), startKey);
            }
            if (cmp < 0) {
                if (isReverse) {
                    hVar = hVar.b();
                } else {
                    hVar = hVar.e();
                }
            } else if (cmp == 0) {
                this.a.push((j) hVar);
                return;
            } else {
                this.a.push((j) hVar);
                if (isReverse) {
                    hVar = hVar.e();
                } else {
                    hVar = hVar.b();
                }
            }
        }
    }

    public boolean hasNext() {
        return this.a.size() > 0;
    }

    /* renamed from: a */
    public Map.Entry<K, V> next() {
        try {
            LLRBValueNode<K, V> node = (j) this.a.pop();
            Map.Entry<K, V> entry = new AbstractMap.SimpleEntry<>(node.getKey(), node.getValue());
            if (this.f2167a) {
                for (h b = node.b(); !b.isEmpty(); b = b.e()) {
                    this.a.push((j) b);
                }
            } else {
                for (h e = node.e(); !e.isEmpty(); e = e.b()) {
                    this.a.push((j) e);
                }
            }
            return entry;
        } catch (EmptyStackException e2) {
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
