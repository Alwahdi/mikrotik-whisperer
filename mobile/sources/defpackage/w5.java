package defpackage;

/* renamed from: w5  reason: default package */
public class w5 {
    public static final w5 a = new w5(255, 255, 255);
    public static final w5 b = new w5(192, 192, 192);
    public static final w5 c = new w5(128, 128, 128);
    public static final w5 d = new w5(64, 64, 64);
    public static final w5 e = new w5(0, 0, 0);
    public static final w5 f = new w5(255, 0, 0);
    public static final w5 g = new w5(255, 175, 175);
    public static final w5 h = new w5(255, 200, 0);
    public static final w5 i = new w5(255, 255, 0);
    public static final w5 j = new w5(0, 255, 0);
    public static final w5 k = new w5(255, 0, 255);
    public static final w5 l = new w5(0, 255, 255);
    public static final w5 m = new w5(0, 0, 255);

    /* renamed from: a  reason: collision with other field name */
    private int f5430a;

    public w5(int red, int green, int blue, int alpha) {
        f(red, green, blue, alpha);
    }

    public w5(int red, int green, int blue) {
        this(red, green, blue, 255);
    }

    public w5(float red, float green, float blue, float alpha) {
        this((int) (((double) (red * 255.0f)) + 0.5d), (int) (((double) (green * 255.0f)) + 0.5d), (int) (((double) (blue * 255.0f)) + 0.5d), (int) (((double) (255.0f * alpha)) + 0.5d));
    }

    public w5(float red, float green, float blue) {
        this(red, green, blue, 1.0f);
    }

    public int d() {
        return this.f5430a;
    }

    public int e() {
        return (d() >> 16) & 255;
    }

    public int c() {
        return (d() >> 8) & 255;
    }

    public int b() {
        return (d() >> 0) & 255;
    }

    public int a() {
        return (d() >> 24) & 255;
    }

    public boolean equals(Object obj) {
        return (obj instanceof w5) && ((w5) obj).f5430a == this.f5430a;
    }

    public int hashCode() {
        return this.f5430a;
    }

    /* access modifiers changed from: protected */
    public void f(int red, int green, int blue, int alpha) {
        g(red);
        g(green);
        g(blue);
        g(alpha);
        this.f5430a = ((alpha & 255) << 24) | ((red & 255) << 16) | ((green & 255) << 8) | ((blue & 255) << 0);
    }

    private static void g(int value) {
        if (value < 0 || value > 255) {
            throw new IllegalArgumentException(i10.b("color.value.outside.range.0.255", new Object[0]));
        }
    }

    public String toString() {
        return "Color value[" + Integer.toString(this.f5430a, 16) + "]";
    }
}
