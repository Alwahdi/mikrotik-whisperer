package defpackage;

/* renamed from: lv  reason: default package */
public abstract class lv extends xa implements ah, gs {
    public mv a;

    public final mv t() {
        mv mvVar = this.a;
        if (mvVar != null) {
            return mvVar;
        }
        lu.t("job");
        return null;
    }

    public final void u(mv mvVar) {
        this.a = mvVar;
    }

    public boolean c() {
        return true;
    }

    public k30 d() {
        return null;
    }

    public void dispose() {
        t().a0(this);
    }

    public String toString() {
        return ef.a(this) + '@' + ef.b(this) + "[job@" + ef.b(t()) + ']';
    }
}
