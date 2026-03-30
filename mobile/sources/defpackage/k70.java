package defpackage;

/* renamed from: k70  reason: default package */
public class k70 extends o70 {
    private double a;

    public k70(String content) {
        super(2);
        try {
            this.a = Double.parseDouble(content.trim());
            E(content);
        } catch (NumberFormatException nfe) {
            throw new RuntimeException(i10.b("1.is.not.a.valid.number.2", content, nfe.toString()));
        }
    }

    public k70(int value) {
        super(2);
        this.a = (double) value;
        E(String.valueOf(value));
    }

    public k70(long value) {
        super(2);
        this.a = (double) value;
        E(String.valueOf(value));
    }

    public k70(double value) {
        super(2);
        this.a = value;
        E(w6.X(value));
    }

    public k70(float value) {
        this((double) value);
    }

    public int J() {
        return (int) this.a;
    }

    public double H() {
        return this.a;
    }

    public float I() {
        return (float) this.a;
    }
}
