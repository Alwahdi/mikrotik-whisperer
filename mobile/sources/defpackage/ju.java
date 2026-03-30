package defpackage;

/* renamed from: ju  reason: default package */
public class ju {
    private String a;

    public ju(String str) {
        this.a = str;
    }

    public int hashCode() {
        return e40.b(this.a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ju)) {
            return false;
        }
        return e40.a(this.a, ((ju) obj).a);
    }

    public String toString() {
        return e40.c(this).a("token", this.a).toString();
    }
}
