package defpackage;

import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import java.util.HashMap;
import java.util.Map;

/* renamed from: p80  reason: default package */
public class p80 extends j60 implements lr {
    private j60 a = null;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<Integer, o70> f4692a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private v80 f4693a;

    /* renamed from: a  reason: collision with other field name */
    private z60 f4694a;
    protected HashMap<h70, o70> b = null;
    private HashMap<Integer, z60> c = null;
    private HashMap<String, o70> d;

    p80(v80 writer) {
        super(h70.ob);
        this.f4693a = writer;
        this.f4694a = writer.m0();
    }

    private void U() {
        if (this.c == null) {
            this.c = new HashMap<>();
            for (Integer i : this.f4692a.keySet()) {
                o70 obj = this.f4692a.get(i);
                if (obj.t()) {
                    this.c.put(i, this.f4693a.y((x50) obj).a());
                } else if (obj instanceof z60) {
                    this.c.put(i, (z60) obj);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void X(String record, o70 reference) {
        if (this.d == null) {
            this.d = new HashMap<>();
        }
        this.d.put(record, reference);
    }

    public v80 W() {
        return this.f4693a;
    }

    public z60 V() {
        return this.f4694a;
    }

    /* access modifiers changed from: package-private */
    public void Z(int page, z60 struc) {
        Integer i = Integer.valueOf(page);
        x50 ar = (x50) this.f4692a.get(i);
        if (ar == null) {
            ar = new x50();
            this.f4692a.put(i, ar);
        }
        ar.I(struc);
    }

    /* access modifiers changed from: package-private */
    public void Y(int structParentIndex, z60 struc) {
        this.f4692a.put(Integer.valueOf(structParentIndex), struc);
    }

    /* access modifiers changed from: package-private */
    public void T() {
        U();
        j60 dicTree = l70.a(this.c, this.f4693a);
        if (dicTree != null) {
            Q(h70.v8, this.f4693a.y(dicTree).a());
        }
        if (this.a != null && !this.b.isEmpty()) {
            for (Map.Entry<PdfName, PdfObject> entry : this.b.entrySet()) {
                o70 value = (o70) entry.getValue();
                if (value.v()) {
                    this.a.Q((h70) entry.getKey(), this.f4693a.y(value).a());
                } else if (value.t()) {
                    x50 newArray = new x50();
                    x50 array = (x50) value;
                    for (int i = 0; i < array.size(); i++) {
                        if (array.S(i).v()) {
                            newArray.I(this.f4693a.y(array.O(i)).a());
                        }
                    }
                    this.a.Q((h70) entry.getKey(), newArray);
                }
            }
            Q(h70.f1, this.f4693a.y(this.a).a());
        }
        HashMap<String, o70> hashMap = this.d;
        if (hashMap != null && !hashMap.isEmpty()) {
            Q(h70.t5, i70.a(this.d, this.f4693a));
        }
        this.f4693a.z(this, this.f4694a);
    }

    public o70 a(h70 name) {
        j60 attr = K(h70.b);
        if (attr == null || !attr.H(name)) {
            return null;
        }
        return attr.I(name);
    }
}
