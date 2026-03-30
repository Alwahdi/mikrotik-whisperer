package defpackage;

/* renamed from: s70  reason: default package */
public class s70 extends q70 {
    protected String a = null;
    protected int g = 0;

    public s70(s70 headerCell) {
        super((q70) headerCell);
        this.f4776a = headerCell.f4776a;
        this.g = headerCell.g;
        this.a = headerCell.L0();
    }

    public String L0() {
        return this.a;
    }

    public h70 j() {
        return this.f4776a;
    }

    public void b(h70 role) {
        this.f4776a = role;
    }

    public int M0() {
        return this.g;
    }
}
