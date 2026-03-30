package com.google.firebase.firestore.model;

public final class d extends c {
    private boolean a;

    public d(mh key, hm0 version, boolean hasCommittedMutations) {
        super(key, version);
        this.a = hasCommittedMutations;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        d that = (d) o;
        if (this.a != that.a || !b().equals(that.b()) || !a().equals(that.a())) {
            return false;
        }
        return true;
    }

    public boolean c() {
        return d();
    }

    public boolean d() {
        return this.a;
    }

    public int hashCode() {
        return (((a().hashCode() * 31) + (this.a ? 1 : 0)) * 31) + b().hashCode();
    }

    public String toString() {
        return "NoDocument{key=" + a() + ", version=" + b() + ", hasCommittedMutations=" + d() + "}";
    }
}
