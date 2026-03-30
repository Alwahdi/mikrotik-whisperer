package com.google.firebase.firestore;

import com.google.firebase.firestore.core.x;

public abstract class m {
    final x a;

    /* renamed from: a  reason: collision with other field name */
    final h f2277a;

    m(x query, h firestore) {
        this.a = (x) v90.n(query);
        this.f2277a = (h) v90.n(firestore);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof m)) {
            return false;
        }
        m that = (m) o;
        if (!this.a.equals(that.a) || !this.f2277a.equals(that.f2277a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f2277a.hashCode();
    }
}
