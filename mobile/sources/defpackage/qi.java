package defpackage;

/* renamed from: qi  reason: default package */
public final class qi {
    private final String a;

    public static qi b(String name) {
        return new qi(name);
    }

    public String a() {
        return this.a;
    }

    private qi(String name) {
        if (name != null) {
            this.a = name;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof qi)) {
            return false;
        }
        return this.a.equals(((qi) o).a);
    }

    public int hashCode() {
        return 1000003 ^ this.a.hashCode();
    }

    public String toString() {
        return "Encoding{name=\"" + this.a + "\"}";
    }
}
