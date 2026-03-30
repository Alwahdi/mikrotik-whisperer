package defpackage;

/* renamed from: c5  reason: default package */
final class c5 extends yw {
    private final String a;
    private final String b;

    c5(String libraryName, String version) {
        if (libraryName != null) {
            this.a = libraryName;
            if (version != null) {
                this.b = version;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.a + ", version=" + this.b + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof yw)) {
            return false;
        }
        yw that = (yw) o;
        if (!this.a.equals(that.b()) || !this.b.equals(that.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.a.hashCode()) * 1000003) ^ this.b.hashCode();
    }
}
