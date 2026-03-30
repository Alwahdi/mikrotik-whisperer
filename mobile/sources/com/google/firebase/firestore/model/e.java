package com.google.firebase.firestore.model;

public final class e extends c {
    public e(mh key, hm0 version) {
        super(key, version);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        e that = (e) o;
        if (!b().equals(that.b()) || !a().equals(that.a())) {
            return false;
        }
        return true;
    }

    public boolean c() {
        return true;
    }

    public int hashCode() {
        return (a().hashCode() * 31) + b().hashCode();
    }

    public String toString() {
        return "UnknownDocument{key=" + a() + ", version=" + b() + '}';
    }
}
