package com.google.firebase.firestore;

public final class n {
    static final n a = new n(false, (ok) null);
    private static final n b = new n(true, (ok) null);

    /* renamed from: a  reason: collision with other field name */
    private final ok f2284a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f2285a;

    private n(boolean merge, ok fieldMask) {
        v90.e(fieldMask == null || merge, "Cannot specify a fieldMask for non-merge sets()");
        this.f2285a = merge;
        this.f2284a = fieldMask;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f2285a;
    }

    public ok a() {
        return this.f2284a;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        n that = (n) o;
        if (this.f2285a != that.f2285a) {
            return false;
        }
        ok okVar = this.f2284a;
        if (okVar != null) {
            return okVar.equals(that.f2284a);
        }
        if (that.f2284a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = ((int) this.f2285a) * true;
        ok okVar = this.f2284a;
        return i + (okVar != null ? okVar.hashCode() : 0);
    }
}
