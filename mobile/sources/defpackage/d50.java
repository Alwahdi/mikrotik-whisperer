package defpackage;

/* renamed from: d50  reason: default package */
public final class d50 implements t8 {
    private final Class<?> a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2708a;

    public d50(Class<?> jClass, String moduleName) {
        lu.f(jClass, "jClass");
        lu.f(moduleName, "moduleName");
        this.a = jClass;
        this.f2708a = moduleName;
    }

    public Class<?> a() {
        return this.a;
    }

    public boolean equals(Object other) {
        return (other instanceof d50) && lu.a(a(), ((d50) other).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
