package defpackage;

/* renamed from: yt0  reason: default package */
public final class yt0 {
    public static final yt0 a = new yt0((String) null);

    /* renamed from: a  reason: collision with other field name */
    private final String f5936a;

    public yt0(String uid) {
        this.f5936a = uid;
    }

    public String a() {
        return this.f5936a;
    }

    public boolean b() {
        return this.f5936a != null;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        yt0 user = (yt0) o;
        String str = this.f5936a;
        if (str != null) {
            return str.equals(user.f5936a);
        }
        if (user.f5936a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f5936a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "User(uid:" + this.f5936a + ")";
    }
}
