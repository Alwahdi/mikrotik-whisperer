package defpackage;

/* renamed from: n51  reason: default package */
public final class n51 extends c01 {
    private final String a;

    private n51(String str) {
        this.a = y90.g(str, "A valid API key must be provided");
    }

    public final String a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n51)) {
            return false;
        }
        return e40.a(this.a, ((n51) obj).a);
    }

    public final int hashCode() {
        return e40.b(this.a);
    }

    public final /* synthetic */ Object clone() {
        return new s51(this.a).a();
    }

    /* synthetic */ n51(String str, o51 o51) {
        this(str);
    }
}
