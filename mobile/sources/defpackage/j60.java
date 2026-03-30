package defpackage;

import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.c;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: j60  reason: default package */
public class j60 extends o70 {
    public static final h70 b = h70.c4;
    public static final h70 c = h70.e8;
    public static final h70 d = h70.l8;
    public static final h70 e = h70.q8;
    public static final h70 f = h70.L0;
    private h70 a;

    /* renamed from: a  reason: collision with other field name */
    protected LinkedHashMap<h70, o70> f4045a;

    public j60() {
        super(6);
        this.a = null;
        this.f4045a = new LinkedHashMap<>();
    }

    public j60(h70 type) {
        this();
        this.a = type;
        Q(h70.Bc, type);
    }

    public void F(v80 writer, OutputStream os) {
        v80.H(writer, 11, this);
        os.write(60);
        os.write(60);
        for (Map.Entry<PdfName, PdfObject> e2 : this.f4045a.entrySet()) {
            ((h70) e2.getKey()).F(writer, os);
            o70 value = (o70) e2.getValue();
            int type = value.G();
            if (!(type == 5 || type == 6 || type == 4 || type == 3)) {
                os.write(32);
            }
            value.F(writer, os);
        }
        os.write(62);
        os.write(62);
    }

    public String toString() {
        h70 h70 = h70.Bc;
        if (I(h70) == null) {
            return "Dictionary";
        }
        return "Dictionary of type: " + I(h70);
    }

    public void Q(h70 key, o70 object) {
        if (key == null) {
            throw new IllegalArgumentException(i10.b("key.is.null", new Object[0]));
        } else if (object == null || object.B()) {
            this.f4045a.remove(key);
        } else {
            this.f4045a.put(key, object);
        }
    }

    public void R(j60 dic) {
        this.f4045a.putAll(dic.f4045a);
    }

    public void S(h70 key) {
        this.f4045a.remove(key);
    }

    public o70 I(h70 key) {
        return this.f4045a.get(key);
    }

    public o70 M(h70 key) {
        return c.b(I(key));
    }

    public Set<h70> N() {
        return this.f4045a.keySet();
    }

    public int size() {
        return this.f4045a.size();
    }

    public boolean H(h70 key) {
        return this.f4045a.containsKey(key);
    }

    public void O(j60 other) {
        this.f4045a.putAll(other.f4045a);
    }

    public void P(j60 other) {
        for (h70 key : other.f4045a.keySet()) {
            if (!this.f4045a.containsKey(key)) {
                this.f4045a.put(key, other.f4045a.get(key));
            }
        }
    }

    public j60 K(h70 key) {
        o70 orig = M(key);
        if (orig == null || !orig.v()) {
            return null;
        }
        return (j60) orig;
    }

    public x50 J(h70 key) {
        o70 orig = M(key);
        if (orig == null || !orig.t()) {
            return null;
        }
        return (x50) orig;
    }

    public h70 L(h70 key) {
        o70 orig = M(key);
        if (orig == null || !orig.A()) {
            return null;
        }
        return (h70) orig;
    }
}
