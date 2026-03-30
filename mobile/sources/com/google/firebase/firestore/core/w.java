package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.b;

public class w {
    private final a a;

    /* renamed from: a  reason: collision with other field name */
    final pk f2235a;

    public enum a {
        ASCENDING(1),
        DESCENDING(-1);
        
        private final int comparisonModifier;

        private a(int comparisonModifier2) {
            this.comparisonModifier = comparisonModifier2;
        }

        /* access modifiers changed from: package-private */
        public int getComparisonModifier() {
            return this.comparisonModifier;
        }
    }

    public static w d(a direction, pk path) {
        return new w(direction, path);
    }

    public a b() {
        return this.a;
    }

    public pk c() {
        return this.f2235a;
    }

    private w(a direction, pk field) {
        this.a = direction;
        this.f2235a = field;
    }

    /* access modifiers changed from: package-private */
    public int a(b d1, b d2) {
        if (this.f2235a.equals(pk.a)) {
            return this.a.getComparisonModifier() * d1.a().compareTo(d2.a());
        }
        rk v1 = d1.e(this.f2235a);
        rk v2 = d2.e(this.f2235a);
        n4.d((v1 == null || v2 == null) ? false : true, "Trying to compare documents on fields that don't exist.", new Object[0]);
        return this.a.getComparisonModifier() * v1.a(v2);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof w)) {
            return false;
        }
        w other = (w) o;
        if (this.a != other.a || !this.f2235a.equals(other.f2235a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((29 * 31) + this.a.hashCode()) * 31) + this.f2235a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a == a.ASCENDING ? "" : "-");
        sb.append(this.f2235a.c());
        return sb.toString();
    }
}
