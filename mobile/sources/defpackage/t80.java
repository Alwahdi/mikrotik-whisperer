package defpackage;

/* renamed from: t80  reason: default package */
public class t80 {
    public static final byte[][] a = {fh.b("\n"), fh.b("%PDF-"), fh.b("\n%âãÏÓ\n")};

    /* renamed from: a  reason: collision with other field name */
    protected char f5087a = '4';

    /* renamed from: a  reason: collision with other field name */
    protected h70 f5088a = null;

    /* renamed from: a  reason: collision with other field name */
    protected j60 f5089a = null;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f5090a = false;
    protected char b = '4';

    /* renamed from: b  reason: collision with other field name */
    protected boolean f5091b = false;

    public void e(z40 os) {
        if (this.f5091b) {
            os.write(a[0]);
            return;
        }
        byte[][] bArr = a;
        os.write(bArr[1]);
        os.write(c(this.f5087a));
        os.write(bArr[2]);
        this.f5090a = true;
    }

    public h70 d(char version) {
        switch (version) {
            case '2':
                return v80.b;
            case '3':
                return v80.c;
            case '4':
                return v80.d;
            case '5':
                return v80.e;
            case '6':
                return v80.f;
            case '7':
                return v80.g;
            default:
                return v80.d;
        }
    }

    public byte[] c(char version) {
        return fh.b(d(version).toString().substring(1));
    }

    public void a(j60 catalog) {
        h70 h70 = this.f5088a;
        if (h70 != null) {
            catalog.Q(h70.gd, h70);
        }
        j60 j60 = this.f5089a;
        if (j60 != null) {
            catalog.Q(h70.q3, j60);
        }
    }

    public char b() {
        return this.b;
    }
}
