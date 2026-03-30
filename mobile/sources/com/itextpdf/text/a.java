package com.itextpdf.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a implements bi, br {
    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;

    /* renamed from: a  reason: collision with other field name */
    protected b f2615a;

    /* renamed from: a  reason: collision with other field name */
    private g0 f2616a;

    /* renamed from: a  reason: collision with other field name */
    protected h70 f2617a;

    /* renamed from: a  reason: collision with other field name */
    private String f2618a;

    /* renamed from: a  reason: collision with other field name */
    protected StringBuffer f2619a;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<String, Object> f2620a;

    /* renamed from: b  reason: collision with other field name */
    protected HashMap<h70, o70> f2621b;

    static {
        a aVar = new a("\n");
        a = aVar;
        aVar.b(h70.k8);
        a aVar2 = new a("");
        b = aVar2;
        aVar2.z();
        Float valueOf = Float.valueOf(Float.NaN);
        c = new a(valueOf, false);
        d = new a(valueOf, true);
    }

    public a(String content, b font) {
        this.f2619a = null;
        this.f2615a = null;
        this.f2620a = null;
        this.f2617a = null;
        this.f2621b = null;
        this.f2616a = null;
        this.f2618a = null;
        this.f2619a = new StringBuffer(content);
        this.f2615a = font;
        this.f2617a = h70.Ta;
    }

    public a(String content) {
        this(content, new b());
    }

    private a(Float tabInterval, boolean isWhitespace) {
        this("￼", new b());
        if (tabInterval.floatValue() >= 0.0f) {
            q("TAB", new Object[]{tabInterval, Boolean.valueOf(isWhitespace)});
            q("SPLITCHARACTER", hp0.a);
            q("TABSETTINGS", (Object) null);
            this.f2617a = h70.O;
            return;
        }
        throw new IllegalArgumentException(i10.b("a.tab.position.may.not.be.lower.than.0.yours.is.1", String.valueOf(tabInterval)));
    }

    public a(tr image, float offsetX, float offsetY, boolean changeLeading) {
        this("￼", new b());
        q("IMAGE", new Object[]{image, new Float(offsetX), new Float(offsetY), Boolean.valueOf(changeLeading)});
        this.f2617a = h70.O;
    }

    public boolean a(ci listener) {
        try {
            return listener.c(this);
        } catch (ih e) {
            return false;
        }
    }

    public int v() {
        return 10;
    }

    public List<a> t() {
        List<Chunk> tmp = new ArrayList<>();
        tmp.add(this);
        return tmp;
    }

    public StringBuffer c(String string) {
        this.f2618a = null;
        StringBuffer stringBuffer = this.f2619a;
        stringBuffer.append(string);
        return stringBuffer;
    }

    public void x(b font) {
        this.f2615a = font;
    }

    public b g() {
        return this.f2615a;
    }

    public String f() {
        if (this.f2618a == null) {
            this.f2618a = this.f2619a.toString().replaceAll("\t", "");
        }
        return this.f2618a;
    }

    public String toString() {
        return f();
    }

    public boolean o() {
        return this.f2619a.toString().trim().length() == 0 && this.f2619a.toString().indexOf("\n") == -1 && this.f2620a == null;
    }

    public boolean n() {
        HashMap<String, Object> hashMap = this.f2620a;
        return hashMap != null && !hashMap.isEmpty();
    }

    public boolean m() {
        HashMap<h70, o70> hashMap = this.f2621b;
        return hashMap != null && !hashMap.isEmpty();
    }

    public HashMap<String, Object> e() {
        return this.f2620a;
    }

    public void w(HashMap<String, Object> attributes) {
        this.f2620a = attributes;
    }

    private a q(String name, Object obj) {
        if (this.f2620a == null) {
            this.f2620a = new HashMap<>();
        }
        this.f2620a.put(name, obj);
        return this;
    }

    public a y(ar hyphenation) {
        return q("HYPHENATION", hyphenation);
    }

    public tr k() {
        Object[] obj;
        HashMap<String, Object> hashMap = this.f2620a;
        if (hashMap == null || (obj = (Object[]) hashMap.get("IMAGE")) == null) {
            return null;
        }
        return (tr) obj[0];
    }

    public a z() {
        return q("NEWPAGE", (Object) null);
    }

    public boolean r() {
        return true;
    }

    public ar i() {
        HashMap<String, Object> hashMap = this.f2620a;
        if (hashMap == null) {
            return null;
        }
        return (ar) hashMap.get("HYPHENATION");
    }

    public o70 l(h70 key) {
        if (k() != null) {
            return k().l(key);
        }
        HashMap<h70, o70> hashMap = this.f2621b;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public void p(h70 key, o70 value) {
        if (k() != null) {
            k().p(key, value);
            return;
        }
        if (this.f2621b == null) {
            this.f2621b = new HashMap<>();
        }
        this.f2621b.put(key, value);
    }

    public HashMap<h70, o70> u() {
        if (k() != null) {
            return k().u();
        }
        return this.f2621b;
    }

    public h70 j() {
        if (k() != null) {
            return k().j();
        }
        return this.f2617a;
    }

    public void b(h70 role) {
        if (k() != null) {
            k().b(role);
        } else {
            this.f2617a = role;
        }
    }

    public g0 s() {
        if (this.f2616a == null) {
            this.f2616a = new g0();
        }
        return this.f2616a;
    }

    public void h(g0 id) {
        this.f2616a = id;
    }

    public boolean isInline() {
        return true;
    }
}
