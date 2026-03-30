package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.w;
import com.google.firebase.firestore.model.b;
import java.util.List;

public final class c {
    private final List<rk> a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f2192a;

    public c(List<rk> position, boolean before) {
        this.a = position;
        this.f2192a = before;
    }

    public List<rk> b() {
        return this.a;
    }

    public boolean c() {
        return this.f2192a;
    }

    public String a() {
        StringBuilder builder = new StringBuilder();
        if (this.f2192a) {
            builder.append("b:");
        } else {
            builder.append("a:");
        }
        for (rk indexComponent : this.a) {
            builder.append(indexComponent.toString());
        }
        return builder.toString();
    }

    public boolean d(List<w> orderBy, b document) {
        n4.d(this.a.size() <= orderBy.size(), "Bound has more components than query's orderBy", new Object[0]);
        int comparison = 0;
        for (int i = 0; i < this.a.size(); i++) {
            w orderByComponent = orderBy.get(i);
            rk component = this.a.get(i);
            if (orderByComponent.f2235a.equals(pk.a)) {
                Object refValue = component.d();
                n4.d(refValue instanceof mh, "Bound has a non-key value where the key path is being used %s", component);
                comparison = ((mh) refValue).compareTo(document.a());
            } else {
                rk docValue = document.e(orderByComponent.c());
                n4.d(docValue != null, "Field should exist since document matched the orderBy already.", new Object[0]);
                comparison = component.a(docValue);
            }
            if (orderByComponent.b().equals(w.a.DESCENDING)) {
                comparison *= -1;
            }
            if (comparison != 0) {
                break;
            }
        }
        if (this.f2192a != 0) {
            if (comparison <= 0) {
                return true;
            }
        } else if (comparison < 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        c bound = (c) o;
        if (this.f2192a != bound.f2192a || !this.a.equals(bound.a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((int) this.f2192a) * true) + this.a.hashCode();
    }

    public String toString() {
        return "Bound{before=" + this.f2192a + ", position=" + this.a + '}';
    }
}
