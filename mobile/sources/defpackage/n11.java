package defpackage;

/* renamed from: n11  reason: default package */
abstract class n11 extends lz0<String> {
    final CharSequence a;

    /* renamed from: a  reason: collision with other field name */
    private final oz0 f4397a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f4398a;
    private int b = 0;
    private int c;

    protected n11(r01 r01, CharSequence charSequence) {
        this.f4397a = r01.f4872a;
        this.f4398a = false;
        this.c = r01.a;
        this.a = charSequence;
    }

    /* access modifiers changed from: package-private */
    public abstract int c(int i);

    /* access modifiers changed from: package-private */
    public abstract int d(int i);

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a() {
        int i;
        int i2 = this.b;
        while (true) {
            int i3 = this.b;
            if (i3 != -1) {
                int c2 = c(i3);
                if (c2 == -1) {
                    c2 = this.a.length();
                    this.b = -1;
                } else {
                    this.b = d(c2);
                }
                int i4 = this.b;
                if (i4 == i2) {
                    int i5 = i4 + 1;
                    this.b = i5;
                    if (i5 > this.a.length()) {
                        this.b = -1;
                    }
                } else {
                    while (i2 < c2 && this.f4397a.b(this.a.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.f4397a.b(this.a.charAt(i - 1))) {
                        c2 = i - 1;
                    }
                    if (!this.f4398a || i2 != i) {
                        int i6 = this.c;
                    } else {
                        i2 = this.b;
                    }
                }
            } else {
                b();
                return null;
            }
        }
        int i62 = this.c;
        if (i62 == 1) {
            i = this.a.length();
            this.b = -1;
            while (i > i2 && this.f4397a.b(this.a.charAt(i - 1))) {
                i--;
            }
        } else {
            this.c = i62 - 1;
        }
        return this.a.subSequence(i2, i).toString();
    }
}
