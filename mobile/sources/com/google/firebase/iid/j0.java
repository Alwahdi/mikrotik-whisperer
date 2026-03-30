package com.google.firebase.iid;

final class j0 {
    /* access modifiers changed from: private */
    public final long a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2433a;

    j0(String str, long j) {
        this.f2433a = (String) y90.j(str);
        this.a = j;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return this.f2433a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        if (this.a != j0Var.a || !this.f2433a.equals(j0Var.f2433a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return e40.b(this.f2433a, Long.valueOf(this.a));
    }
}
