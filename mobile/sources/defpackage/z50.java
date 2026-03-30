package defpackage;

/* renamed from: z50  reason: default package */
public class z50 extends o70 {
    public static final z50 a = new z50(true);
    public static final z50 b = new z50(false);

    /* renamed from: a  reason: collision with other field name */
    private boolean f6004a;

    public z50(boolean value) {
        super(1);
        if (value) {
            E("true");
        } else {
            E("false");
        }
        this.f6004a = value;
    }

    public String toString() {
        return this.f6004a ? "true" : "false";
    }
}
