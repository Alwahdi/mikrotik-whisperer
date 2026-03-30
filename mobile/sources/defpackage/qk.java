package defpackage;

/* renamed from: qk  reason: default package */
public final class qk {
    private final pk a;

    /* renamed from: a  reason: collision with other field name */
    private final yr0 f4846a;

    public qk(pk fieldPath, yr0 operation) {
        this.a = fieldPath;
        this.f4846a = operation;
    }

    public pk a() {
        return this.a;
    }

    public yr0 b() {
        return this.f4846a;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        qk that = (qk) o;
        if (!this.a.equals(that.a)) {
            return false;
        }
        return this.f4846a.equals(that.f4846a);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f4846a.hashCode();
    }
}
