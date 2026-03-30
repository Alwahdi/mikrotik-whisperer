package defpackage;

import com.itextpdf.text.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: h3  reason: default package */
public class h3 implements bi {
    protected float a = Float.NaN;

    /* renamed from: a  reason: collision with other field name */
    protected int f3134a;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<String, Object> f3135a = new HashMap<>();
    protected float b = Float.NaN;
    protected float c = Float.NaN;
    protected float d = Float.NaN;

    public h3(h3 an) {
        this.f3134a = an.f3134a;
        this.f3135a = an.f3135a;
        this.a = an.a;
        this.b = an.b;
        this.c = an.c;
        this.d = an.d;
    }

    public int v() {
        return 29;
    }

    public boolean a(ci listener) {
        try {
            return listener.c(this);
        } catch (ih e) {
            return false;
        }
    }

    public List<a> t() {
        return new ArrayList();
    }

    public void j(float llx, float lly, float urx, float ury) {
        this.a = llx;
        this.b = lly;
        this.c = urx;
        this.d = ury;
    }

    public float f() {
        return this.a;
    }

    public float h() {
        return this.b;
    }

    public float l() {
        return this.c;
    }

    public float n() {
        return this.d;
    }

    public float g(float def) {
        if (Float.isNaN(this.a)) {
            return def;
        }
        return this.a;
    }

    public float i(float def) {
        if (Float.isNaN(this.b)) {
            return def;
        }
        return this.b;
    }

    public float m(float def) {
        if (Float.isNaN(this.c)) {
            return def;
        }
        return this.c;
    }

    public float o(float def) {
        if (Float.isNaN(this.d)) {
            return def;
        }
        return this.d;
    }

    public int b() {
        return this.f3134a;
    }

    public String k() {
        String s = (String) this.f3135a.get("title");
        if (s == null) {
            return "";
        }
        return s;
    }

    public String e() {
        String s = (String) this.f3135a.get("content");
        if (s == null) {
            return "";
        }
        return s;
    }

    public HashMap<String, Object> c() {
        return this.f3135a;
    }

    public boolean r() {
        return true;
    }
}
