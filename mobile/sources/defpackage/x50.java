package defpackage;

import com.itextpdf.text.pdf.c;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: x50  reason: default package */
public class x50 extends o70 implements Iterable<o70> {
    protected ArrayList<o70> a;

    public x50() {
        super(5);
        this.a = new ArrayList<>();
    }

    public x50(o70 object) {
        super(5);
        ArrayList<o70> arrayList = new ArrayList<>();
        this.a = arrayList;
        arrayList.add(object);
    }

    public x50(float[] values) {
        super(5);
        this.a = new ArrayList<>();
        J(values);
    }

    public x50(int[] values) {
        super(5);
        this.a = new ArrayList<>();
        K(values);
    }

    public x50(x50 array) {
        super(5);
        this.a = new ArrayList<>(array.a);
    }

    public void F(v80 writer, OutputStream os) {
        v80.H(writer, 11, this);
        os.write(91);
        Iterator<o70> it = this.a.iterator();
        if (it.hasNext()) {
            o70 object = it.next();
            if (object == null) {
                object = j70.a;
            }
            object.F(writer, os);
        }
        while (it.hasNext()) {
            o70 object2 = it.next();
            if (object2 == null) {
                object2 = j70.a;
            }
            int type = object2.G();
            if (!(type == 5 || type == 6 || type == 4 || type == 3)) {
                os.write(32);
            }
            object2.F(writer, os);
        }
        os.write(93);
    }

    public String toString() {
        return this.a.toString();
    }

    public o70 U(int idx, o70 obj) {
        return this.a.set(idx, obj);
    }

    public o70 T(int idx) {
        return this.a.remove(idx);
    }

    public ArrayList<o70> N() {
        return this.a;
    }

    public int size() {
        return this.a.size();
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public boolean I(o70 object) {
        return this.a.add(object);
    }

    public boolean J(float[] values) {
        for (float k70 : values) {
            this.a.add(new k70(k70));
        }
        return true;
    }

    public boolean K(int[] values) {
        for (int k70 : values) {
            this.a.add(new k70(k70));
        }
        return true;
    }

    public void H(int index, o70 element) {
        this.a.add(index, element);
    }

    public void L(o70 object) {
        this.a.add(0, object);
    }

    public boolean M(o70 object) {
        return this.a.contains(object);
    }

    public o70 S(int idx) {
        return this.a.get(idx);
    }

    public o70 R(int idx) {
        return c.b(S(idx));
    }

    public j60 O(int idx) {
        o70 orig = R(idx);
        if (orig == null || !orig.v()) {
            return null;
        }
        return (j60) orig;
    }

    public k70 Q(int idx) {
        o70 orig = R(idx);
        if (orig == null || !orig.C()) {
            return null;
        }
        return (k70) orig;
    }

    public h70 P(int idx) {
        o70 orig = R(idx);
        if (orig == null || !orig.A()) {
            return null;
        }
        return (h70) orig;
    }

    public Iterator<o70> iterator() {
        return this.a.iterator();
    }
}
