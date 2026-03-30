package defpackage;

import java.util.HashMap;
import java.util.HashSet;

/* renamed from: e50  reason: default package */
class e50 {
    protected j60 a = new j60();

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<h70, h70> f2852a;

    /* renamed from: a  reason: collision with other field name */
    protected HashSet<h70> f2853a;

    /* renamed from: a  reason: collision with other field name */
    protected int[] f2854a = {0};
    protected j60 b = new j60();
    protected j60 c = new j60();
    protected j60 d = new j60();
    protected j60 e = new j60();
    protected j60 f = new j60();
    protected j60 g = new j60();
    protected j60 h;

    e50() {
    }

    /* access modifiers changed from: package-private */
    public h70 j(h70 name) {
        h70 translated = name;
        if (this.f2853a != null && (translated = this.f2852a.get(name)) == null) {
            do {
                StringBuilder sb = new StringBuilder();
                sb.append("Xi");
                int[] iArr = this.f2854a;
                int i = iArr[0];
                iArr[0] = i + 1;
                sb.append(i);
                translated = new h70(sb.toString());
            } while (this.f2853a.contains(translated));
            this.f2852a.put(name, translated);
        }
        return translated;
    }

    /* access modifiers changed from: package-private */
    public h70 e(h70 name, z60 reference) {
        h70 name2 = j(name);
        this.a.Q(name2, reference);
        return name2;
    }

    /* access modifiers changed from: package-private */
    public h70 h(h70 name, z60 reference) {
        h70 name2 = j(name);
        this.b.Q(name2, reference);
        return name2;
    }

    /* access modifiers changed from: package-private */
    public h70 a(h70 name, z60 reference) {
        h70 name2 = j(name);
        this.c.Q(name2, reference);
        return name2;
    }

    /* access modifiers changed from: package-private */
    public void b(j60 dic) {
        this.c.O(dic);
    }

    /* access modifiers changed from: package-private */
    public void c(j60 dic) {
        this.c.P(dic);
    }

    /* access modifiers changed from: package-private */
    public h70 f(h70 name, z60 reference) {
        h70 name2 = j(name);
        this.d.Q(name2, reference);
        return name2;
    }

    /* access modifiers changed from: package-private */
    public h70 d(h70 name, z60 reference) {
        h70 name2 = j(name);
        this.f.Q(name2, reference);
        return name2;
    }

    /* access modifiers changed from: package-private */
    public h70 g(h70 name, z60 reference) {
        h70 name2 = j(name);
        this.g.Q(name2, reference);
        return name2;
    }

    /* access modifiers changed from: package-private */
    public j60 i() {
        h80 resources = new h80();
        j60 j60 = this.h;
        if (j60 != null) {
            resources.R(j60);
        }
        resources.T(h70.c4, this.a);
        resources.T(h70.Rd, this.b);
        resources.T(h70.n1, this.c);
        resources.T(h70.z8, this.d);
        resources.T(h70.Da, this.e);
        resources.T(h70.s3, this.f);
        resources.T(h70.m9, this.g);
        return resources;
    }
}
