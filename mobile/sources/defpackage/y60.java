package defpackage;

import java.io.OutputStream;

/* renamed from: y60  reason: default package */
public class y60 {
    static final byte[] a;
    static final byte[] b;
    static final int c;

    /* renamed from: a  reason: collision with other field name */
    protected int f5837a;

    /* renamed from: a  reason: collision with other field name */
    protected o70 f5838a;

    /* renamed from: a  reason: collision with other field name */
    protected v80 f5839a;

    /* renamed from: b  reason: collision with other field name */
    protected int f5840b;

    static {
        byte[] b2 = fh.b(" obj\n");
        a = b2;
        byte[] b3 = fh.b("\nendobj\n");
        b = b3;
        c = b2.length + b3.length;
    }

    protected y60(int number, o70 object, v80 writer) {
        this(number, 0, object, writer);
    }

    y60(int number, int generation, o70 object, v80 writer) {
        this.f5840b = 0;
        this.f5839a = writer;
        this.f5837a = number;
        this.f5840b = generation;
        this.f5838a = object;
        o60 crypto = writer != null ? writer.a0() : null;
        if (crypto != null) {
            crypto.g(number, generation);
        }
    }

    public z60 a() {
        return new z60(this.f5838a.G(), this.f5837a, this.f5840b);
    }

    /* access modifiers changed from: protected */
    public void b(OutputStream os) {
        os.write(fh.b(String.valueOf(this.f5837a)));
        os.write(32);
        os.write(fh.b(String.valueOf(this.f5840b)));
        os.write(a);
        this.f5838a.F(this.f5839a, os);
        os.write(b);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5837a);
        stringBuffer.append(' ');
        stringBuffer.append(this.f5840b);
        stringBuffer.append(" R: ");
        o70 o70 = this.f5838a;
        stringBuffer.append(o70 != null ? o70.toString() : "null");
        return stringBuffer.toString();
    }
}
