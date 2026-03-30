package defpackage;

/* renamed from: ve  reason: default package */
public final class ve implements Comparable<ve> {
    private final String a;
    private final String b;

    public static ve b(String projectId, String databaseId) {
        return new ve(projectId, databaseId);
    }

    private ve(String projectId, String databaseId) {
        this.a = projectId;
        this.b = databaseId;
    }

    public String d() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String toString() {
        return "DatabaseId(" + this.a + ", " + this.b + ")";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ve that = (ve) o;
        if (!this.a.equals(that.a) || !this.b.equals(that.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    /* renamed from: a */
    public int compareTo(ve other) {
        int cmp = this.a.compareTo(other.a);
        return cmp != 0 ? cmp : this.b.compareTo(other.b);
    }
}
