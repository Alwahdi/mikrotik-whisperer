package defpackage;

/* renamed from: dk  reason: default package */
public abstract class dk extends w5 {
    protected int b;

    public dk(int type) {
        super(0, 0, 0);
        this.b = type;
    }

    public dk(int type, float red, float green, float blue) {
        super(j(red), j(green), j(blue));
        this.b = type;
    }

    public int h() {
        return this.b;
    }

    public static int i(w5 color) {
        if (color instanceof dk) {
            return ((dk) color).h();
        }
        return 0;
    }

    static final float j(float value) {
        if (value < 0.0f) {
            return 0.0f;
        }
        if (value > 1.0f) {
            return 1.0f;
        }
        return value;
    }
}
