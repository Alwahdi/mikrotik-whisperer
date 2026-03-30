package defpackage;

/* renamed from: el0  reason: default package */
public final class el0 {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final int[] f2916a = new int[10];
    private int b;
    private int c;

    public el0 e(int id, int idFlags, int value) {
        int[] iArr = this.f2916a;
        if (id >= iArr.length) {
            return this;
        }
        int bit = 1 << id;
        this.a |= bit;
        if ((idFlags & 1) != 0) {
            this.b |= bit;
        } else {
            this.b &= ~bit;
        }
        if ((idFlags & 2) != 0) {
            this.c |= bit;
        } else {
            this.c &= ~bit;
        }
        iArr[id] = value;
        return this;
    }

    public boolean d(int id) {
        if ((this.a & (1 << id)) != 0) {
            return true;
        }
        return false;
    }

    public int a(int id) {
        return this.f2916a[id];
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return Integer.bitCount(this.a);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        if ((this.a & 2) != 0) {
            return this.f2916a[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int c(int defaultValue) {
        return (this.a & 32) != 0 ? this.f2916a[5] : defaultValue;
    }
}
