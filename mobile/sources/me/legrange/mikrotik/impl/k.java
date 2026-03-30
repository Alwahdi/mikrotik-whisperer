package me.legrange.mikrotik.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class k extends j implements Map<String, String> {
    private final Map<String, String> a = new HashMap();

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public String toString() {
        return String.format("tag=%s, data=%s", new Object[]{a(), this.a});
    }

    public int size() {
        return this.a.size();
    }

    public boolean containsKey(Object o) {
        return this.a.containsKey(o);
    }

    public boolean containsValue(Object o) {
        return this.a.containsValue(o);
    }

    /* renamed from: c */
    public String get(Object o) {
        return this.a.get(o);
    }

    /* renamed from: d */
    public String put(String k, String v) {
        return this.a.put(k, v);
    }

    /* renamed from: e */
    public String remove(Object o) {
        return this.a.remove(o);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.a.putAll(map);
    }

    public void clear() {
        this.a.clear();
    }

    public Set<String> keySet() {
        return this.a.keySet();
    }

    public Collection<String> values() {
        return this.a.values();
    }

    public Set<Map.Entry<String, String>> entrySet() {
        return this.a.entrySet();
    }

    k() {
        super((String) null);
    }
}
