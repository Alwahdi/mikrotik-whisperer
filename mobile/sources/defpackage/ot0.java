package defpackage;

/* renamed from: ot0  reason: default package */
public final class ot0 extends UnsupportedOperationException {
    private final nk a;

    public ot0(nk nkVar) {
        this.a = nkVar;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
