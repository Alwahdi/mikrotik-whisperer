package defpackage;

import java.io.OutputStream;

/* renamed from: n80  reason: default package */
public class n80 extends o70 {
    protected String a = "";

    /* renamed from: a  reason: collision with other field name */
    protected boolean f4416a = false;
    protected int b = 0;

    /* renamed from: b  reason: collision with other field name */
    protected String f4417b = null;
    protected int c = 0;

    /* renamed from: c  reason: collision with other field name */
    protected String f4418c = "PDF";

    public n80() {
        super(3);
    }

    public n80(String value) {
        super(3);
        this.a = value;
    }

    public n80(String value, String encoding) {
        super(3);
        this.a = value;
        this.f4418c = encoding;
    }

    public n80(byte[] bytes) {
        super(3);
        this.a = n60.d(bytes, (String) null);
        this.f4418c = "";
    }

    public void F(v80 writer, OutputStream os) {
        v80.H(writer, 11, this);
        byte[] b2 = q();
        o60 crypto = null;
        if (writer != null) {
            crypto = writer.a0();
        }
        if (crypto != null && !crypto.f()) {
            b2 = crypto.d(b2);
        }
        if (this.f4416a) {
            w6 buf = new w6();
            buf.f('<');
            for (byte U : b2) {
                buf.U(U);
            }
            buf.f('>');
            os.write(buf.c0());
            return;
        }
        os.write(qn0.c(b2));
    }

    public String toString() {
        return this.a;
    }

    public byte[] q() {
        if (this.f4495a == null) {
            String str = this.f4418c;
            if (str == null || !str.equals("UnicodeBig") || !n60.e(this.a)) {
                this.f4495a = n60.c(this.a, this.f4418c);
            } else {
                this.f4495a = n60.c(this.a, "PDF");
            }
        }
        return this.f4495a;
    }

    public String J() {
        String str = this.f4418c;
        if (str != null && str.length() != 0) {
            return this.a;
        }
        q();
        byte[] bArr = this.f4495a;
        if (bArr.length >= 2 && bArr[0] == -2 && bArr[1] == -1) {
            return n60.d(bArr, "UnicodeBig");
        }
        return n60.d(bArr, "PDF");
    }

    public n80 I(boolean hexWriting) {
        this.f4416a = hexWriting;
        return this;
    }

    public boolean H() {
        return this.f4416a;
    }
}
