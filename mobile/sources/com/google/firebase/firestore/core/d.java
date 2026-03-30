package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.b;

public class d {
    private final a a;

    /* renamed from: a  reason: collision with other field name */
    private final b f2193a;

    public enum a {
        REMOVED,
        ADDED,
        MODIFIED,
        METADATA
    }

    public static d a(a type, b document) {
        return new d(type, document);
    }

    private d(a type, b document) {
        this.a = type;
        this.f2193a = document;
    }

    public b b() {
        return this.f2193a;
    }

    public a c() {
        return this.a;
    }

    public boolean equals(Object o) {
        if (!(o instanceof d)) {
            return false;
        }
        d other = (d) o;
        if (!this.a.equals(other.a) || !this.f2193a.equals(other.f2193a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((61 * 31) + this.a.hashCode()) * 31) + this.f2193a.hashCode();
    }

    public String toString() {
        return "DocumentViewChange(" + this.f2193a + "," + this.a + ")";
    }
}
