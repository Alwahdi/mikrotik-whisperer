package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.a;
import java.io.IOException;
import java.util.ArrayList;

public class b {
    private a a;

    public b(a tokeniser) {
        this.a = tokeniser;
    }

    public ArrayList<o70> b(ArrayList<o70> ls) {
        o70 ob;
        if (ls == null) {
            ls = new ArrayList<>();
        } else {
            ls.clear();
        }
        do {
            o70 e = e();
            ob = e;
            if (e == null) {
                break;
            }
            ls.add(ob);
        } while (ob.G() != 200);
        return ls;
    }

    public j60 d() {
        j60 dic = new j60();
        while (a()) {
            a.C0036a e = this.a.e();
            a.C0036a aVar = a.C0036a.END_DIC;
            if (e == aVar) {
                return dic;
            }
            if (this.a.e() != a.C0036a.OTHER || !"def".equals(this.a.d())) {
                if (this.a.e() == a.C0036a.NAME) {
                    h70 name = new h70(this.a.d(), false);
                    o70 obj = e();
                    int type = obj.G();
                    if ((-type) == aVar.ordinal()) {
                        throw new IOException(i10.b("unexpected.gt.gt", new Object[0]));
                    } else if ((-type) != a.C0036a.END_ARRAY.ordinal()) {
                        dic.Q(name, obj);
                    } else {
                        throw new IOException(i10.b("unexpected.close.bracket", new Object[0]));
                    }
                } else {
                    throw new IOException(i10.b("dictionary.key.1.is.not.a.name", this.a.d()));
                }
            }
        }
        throw new IOException(i10.b("unexpected.end.of.file", new Object[0]));
    }

    public x50 c() {
        x50 array = new x50();
        while (true) {
            o70 obj = e();
            int type = obj.G();
            if ((-type) == a.C0036a.END_ARRAY.ordinal()) {
                return array;
            }
            if ((-type) != a.C0036a.END_DIC.ordinal()) {
                array.I(obj);
            } else {
                throw new IOException(i10.b("unexpected.gt.gt", new Object[0]));
            }
        }
    }

    public o70 e() {
        if (!a()) {
            return null;
        }
        a.C0036a type = this.a.e();
        switch (a.a[type.ordinal()]) {
            case 1:
                return d();
            case 2:
                return c();
            case 3:
                return new n80(this.a.d(), (String) null).I(this.a.f());
            case 4:
                return new h70(this.a.d(), false);
            case 5:
                return new k70(this.a.d());
            case 6:
                return new f70(200, this.a.d());
            default:
                return new f70(-type.ordinal(), this.a.d());
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.C0036a.values().length];
            a = iArr;
            try {
                iArr[a.C0036a.START_DIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[a.C0036a.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[a.C0036a.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[a.C0036a.NAME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[a.C0036a.NUMBER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[a.C0036a.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public boolean a() {
        while (this.a.i()) {
            if (this.a.e() != a.C0036a.COMMENT) {
                return true;
            }
        }
        return false;
    }
}
