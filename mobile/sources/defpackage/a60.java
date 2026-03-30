package defpackage;

/* renamed from: a60  reason: default package */
public class a60 extends x50 {
    public a60(float hRadius, float vRadius, float width) {
        this(hRadius, vRadius, width, (f60) null);
    }

    public a60(float hRadius, float vRadius, float width, f60 dash) {
        super((o70) new k70(hRadius));
        I(new k70(vRadius));
        I(new k70(width));
        if (dash != null) {
            I(dash);
        }
    }
}
