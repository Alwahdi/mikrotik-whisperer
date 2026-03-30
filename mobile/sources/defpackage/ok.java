package defpackage;

import java.util.Set;

/* renamed from: ok  reason: default package */
public final class ok {
    private final Set<pk> a;

    public static ok b(Set<pk> mask) {
        return new ok(mask);
    }

    private ok(Set<pk> mask) {
        this.a = mask;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.a.equals(((ok) o).a);
    }

    public String toString() {
        return "FieldMask{mask=" + this.a.toString() + "}";
    }

    public boolean a(pk fieldPath) {
        for (pk fieldMaskPath : this.a) {
            if (fieldMaskPath.l(fieldPath)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Set<pk> c() {
        return this.a;
    }
}
