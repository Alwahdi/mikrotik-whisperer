package com.google.firebase.firestore.core;

public class u {
    private final a a;

    /* renamed from: a  reason: collision with other field name */
    private final mh f2234a;

    public enum a {
        ADDED,
        REMOVED
    }

    public u(a type, mh key) {
        this.a = type;
        this.f2234a = key;
    }

    public a b() {
        return this.a;
    }

    public mh a() {
        return this.f2234a;
    }

    public boolean equals(Object o) {
        if (!(o instanceof u)) {
            return false;
        }
        u other = (u) o;
        if (!this.a.equals(other.b()) || !this.f2234a.equals(other.a())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((67 * 31) + this.a.hashCode()) * 31) + this.f2234a.hashCode();
    }
}
