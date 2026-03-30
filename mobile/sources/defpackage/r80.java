package defpackage;

import java.util.ArrayList;

/* renamed from: r80  reason: default package */
public class r80 {
    private Float a;

    /* renamed from: a  reason: collision with other field name */
    private String f4885a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<Object> f4886a = new ArrayList<>();

    public r80(String str) {
        b(str);
    }

    public r80() {
    }

    public void a(float number) {
        if (number != 0.0f) {
            Float f = this.a;
            if (f != null) {
                Float f2 = new Float(f.floatValue() + number);
                this.a = f2;
                if (f2.floatValue() != 0.0f) {
                    d(this.a);
                } else {
                    ArrayList<Object> arrayList = this.f4886a;
                    arrayList.remove(arrayList.size() - 1);
                }
            } else {
                Float f3 = new Float(number);
                this.a = f3;
                this.f4886a.add(f3);
            }
            this.f4885a = null;
        }
    }

    public void b(String str) {
        if (str.length() > 0) {
            if (this.f4885a != null) {
                String str2 = this.f4885a + str;
                this.f4885a = str2;
                d(str2);
            } else {
                this.f4885a = str;
                this.f4886a.add(str);
            }
            this.a = null;
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Object> c() {
        return this.f4886a;
    }

    private void d(Object obj) {
        ArrayList<Object> arrayList = this.f4886a;
        arrayList.set(arrayList.size() - 1, obj);
    }
}
