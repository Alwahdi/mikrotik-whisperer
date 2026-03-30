package defpackage;

/* renamed from: fi  reason: default package */
final class fi implements gs {
    private final boolean a;

    public fi(boolean isActive) {
        this.a = isActive;
    }

    public boolean c() {
        return this.a;
    }

    public k30 d() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(c() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
