package defpackage;

/* renamed from: r60  reason: default package */
class r60 implements Comparable<r60> {
    private float a;

    /* renamed from: a  reason: collision with other field name */
    private y5 f4884a;
    protected float b = 1.0f;

    r60(y5 bf, float size) {
        this.a = size;
        this.f4884a = bf;
    }

    /* renamed from: a */
    public int compareTo(r60 pdfFont) {
        if (pdfFont == null) {
            return -1;
        }
        try {
            if (this.f4884a != pdfFont.f4884a) {
                return 1;
            }
            if (g() != pdfFont.g()) {
                return 2;
            }
            return 0;
        } catch (ClassCastException e) {
            return -2;
        }
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public float h() {
        return i(32);
    }

    /* access modifiers changed from: package-private */
    public float i(int character) {
        return this.f4884a.v(character, this.a) * this.b;
    }

    /* access modifiers changed from: package-private */
    public float j(String s) {
        return this.f4884a.w(s, this.a) * this.b;
    }

    /* access modifiers changed from: package-private */
    public y5 c() {
        return this.f4884a;
    }

    static r60 b() {
        try {
            return new r60(y5.d("Helvetica", "Cp1252", false), 12.0f);
        } catch (Exception ee) {
            throw new mj(ee);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(float hScale) {
        this.b = hScale;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.b;
    }
}
