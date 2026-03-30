package defpackage;

import java.io.OutputStream;
import java.io.Serializable;

/* renamed from: o70  reason: default package */
public abstract class o70 implements Serializable {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    protected b50 f4494a;

    /* renamed from: a  reason: collision with other field name */
    protected byte[] f4495a;

    protected o70(int type) {
        this.a = type;
    }

    protected o70(int type, String content) {
        this.a = type;
        this.f4495a = n60.c(content, (String) null);
    }

    protected o70(int type, byte[] bytes) {
        this.f4495a = bytes;
        this.a = type;
    }

    public void F(v80 writer, OutputStream os) {
        if (this.f4495a != null) {
            v80.H(writer, 11, this);
            os.write(this.f4495a);
        }
    }

    public String toString() {
        byte[] bArr = this.f4495a;
        if (bArr == null) {
            return super.toString();
        }
        return n60.d(bArr, (String) null);
    }

    public byte[] q() {
        return this.f4495a;
    }

    public boolean o() {
        switch (this.a) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    public void E(String content) {
        this.f4495a = n60.c(content, (String) null);
    }

    public int G() {
        return this.a;
    }

    public boolean B() {
        return this.a == 8;
    }

    public boolean C() {
        return this.a == 2;
    }

    public boolean D() {
        return this.a == 3;
    }

    public boolean A() {
        return this.a == 4;
    }

    public boolean t() {
        return this.a == 5;
    }

    public boolean v() {
        return this.a == 6;
    }

    public boolean z() {
        return this.a == 10;
    }

    public b50 r() {
        return this.f4494a;
    }
}
