package com.google.firebase.database.collection;

import com.google.firebase.database.collection.h;
import java.util.Comparator;

public abstract class j<K, V> implements h<K, V> {
    private h<K, V> a;

    /* renamed from: a  reason: collision with other field name */
    private final K f2168a;
    private final h<K, V> b;

    /* renamed from: b  reason: collision with other field name */
    private final V f2169b;

    /* access modifiers changed from: protected */
    public abstract j<K, V> k(K k, V v, h<K, V> hVar, h<K, V> hVar2);

    /* access modifiers changed from: protected */
    public abstract h.a m();

    private static h.a p(h node) {
        return node.d() ? h.a.BLACK : h.a.RED;
    }

    j(K key, V value, h<K, V> left, h<K, V> right) {
        this.f2168a = key;
        this.f2169b = value;
        this.a = left == null ? g.i() : left;
        this.b = right == null ? g.i() : right;
    }

    public h<K, V> b() {
        return this.a;
    }

    public h<K, V> e() {
        return this.b;
    }

    public K getKey() {
        return this.f2168a;
    }

    public V getValue() {
        return this.f2169b;
    }

    /* renamed from: j */
    public j<K, V> a(K key, V value, h.a color, h<K, V> left, h<K, V> right) {
        K newKey = key == null ? this.f2168a : key;
        V newValue = value == null ? this.f2169b : value;
        h<K, V> hVar = left == null ? this.a : left;
        h<K, V> hVar2 = right == null ? this.b : right;
        if (color == h.a.RED) {
            return new i(newKey, newValue, hVar, hVar2);
        }
        return new f(newKey, newValue, hVar, hVar2);
    }

    public h<K, V> g(K key, V value, Comparator<K> comparator) {
        LLRBValueNode<K, V> n;
        int cmp = comparator.compare(key, this.f2168a);
        if (cmp < 0) {
            n = k((Object) null, (Object) null, this.a.g(key, value, comparator), (LLRBNode<K, V>) null);
        } else if (cmp == 0) {
            n = k(key, value, (h) null, (h) null);
        } else {
            n = k((Object) null, (Object) null, (h) null, this.b.g(key, value, comparator));
        }
        return n.l();
    }

    public h<K, V> f(K key, Comparator<K> comparator) {
        LLRBValueNode<K, V> n;
        j jVar = this;
        if (comparator.compare(key, jVar.f2168a) < 0) {
            if (!jVar.a.isEmpty() && !jVar.a.d() && !((j) jVar.a).a.d()) {
                jVar = jVar.n();
            }
            n = jVar.k((Object) null, (Object) null, jVar.a.f(key, comparator), (h<K, V>) null);
        } else {
            if (jVar.a.d()) {
                jVar = jVar.s();
            }
            if (!jVar.b.isEmpty() && !jVar.b.d() && !((j) jVar.b).a.d()) {
                jVar = jVar.o();
            }
            if (comparator.compare(key, jVar.f2168a) == 0) {
                if (jVar.b.isEmpty()) {
                    return g.i();
                }
                LLRBNode<K, V> smallest = jVar.b.h();
                jVar = jVar.k(smallest.getKey(), smallest.getValue(), (h) null, ((j) jVar.b).q());
            }
            n = jVar.k((Object) null, (Object) null, (h) null, jVar.b.f(key, comparator));
        }
        return n.l();
    }

    public boolean isEmpty() {
        return false;
    }

    public h<K, V> h() {
        if (this.a.isEmpty()) {
            return this;
        }
        return this.a.h();
    }

    public h<K, V> c() {
        if (this.b.isEmpty()) {
            return this;
        }
        return this.b.c();
    }

    /* access modifiers changed from: package-private */
    public void t(h<K, V> left) {
        this.a = left;
    }

    private h<K, V> q() {
        if (this.a.isEmpty()) {
            return g.i();
        }
        j jVar = this;
        if (!jVar.b().d() && !jVar.b().b().d()) {
            jVar = jVar.n();
        }
        return jVar.k((Object) null, (Object) null, ((j) jVar.a).q(), (h) null).l();
    }

    private j<K, V> n() {
        LLRBValueNode<K, V> n = i();
        if (n.e().b().d()) {
            return n.k((Object) null, (Object) null, (h) null, ((j) n.e()).s()).r().i();
        }
        return n;
    }

    private j<K, V> o() {
        LLRBValueNode<K, V> n = i();
        if (n.b().b().d()) {
            return n.s().i();
        }
        return n;
    }

    private j<K, V> l() {
        j jVar = this;
        if (jVar.b.d() && !jVar.a.d()) {
            jVar = jVar.r();
        }
        if (jVar.a.d() && ((j) jVar.a).a.d()) {
            jVar = jVar.s();
        }
        if (!jVar.a.d() || !jVar.b.d()) {
            return jVar;
        }
        return jVar.i();
    }

    private j<K, V> r() {
        return (j) this.b.a(null, null, m(), a((Object) null, (Object) null, h.a.RED, (h) null, ((j) this.b).a), (j<K, V>) null);
    }

    private j<K, V> s() {
        return (j) this.a.a(null, null, m(), (h) null, a((Object) null, (Object) null, h.a.RED, ((j) this.a).b, (h<K, V>) null));
    }

    private j<K, V> i() {
        h<K, V> hVar = this.a;
        h<K, V> a2 = hVar.a(null, null, p(hVar), (h<K, V>) null, (h<K, V>) null);
        h<K, V> hVar2 = this.b;
        return a((Object) null, (Object) null, p(this), a2, hVar2.a(null, null, p(hVar2), (h<K, V>) null, (h<K, V>) null));
    }
}
