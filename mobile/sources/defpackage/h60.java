package defpackage;

/* renamed from: h60  reason: default package */
public class h60 extends x50 {
    private boolean a = false;

    public h60(int type, float parameter) {
        super((o70) new k70(parameter));
        switch (type) {
            case 3:
                L(h70.Q3);
                return;
            case 6:
                L(h70.T3);
                return;
            case 7:
                L(h70.U3);
                return;
            default:
                L(h70.P3);
                return;
        }
    }

    public h60(int type, float left, float top, float zoom) {
        super((o70) h70.Wd);
        if (left < 0.0f) {
            I(j70.a);
        } else {
            I(new k70(left));
        }
        if (top < 0.0f) {
            I(j70.a);
        } else {
            I(new k70(top));
        }
        I(new k70(zoom));
    }

    public boolean W() {
        return this.a;
    }

    public boolean V(z60 page) {
        if (this.a) {
            return false;
        }
        L(page);
        this.a = true;
        return true;
    }
}
