package defpackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: gh  reason: default package */
public class gh implements eh, br {
    public static float e = 0.86f;

    /* renamed from: e  reason: collision with other field name */
    public static boolean f3078e = true;
    public static boolean f = false;
    protected float a;

    /* renamed from: a  reason: collision with other field name */
    protected int f3079a;

    /* renamed from: a  reason: collision with other field name */
    protected g0 f3080a;

    /* renamed from: a  reason: collision with other field name */
    protected h70 f3081a;

    /* renamed from: a  reason: collision with other field name */
    protected String f3082a;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<eh> f3083a;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<h70, o70> f3084a;

    /* renamed from: a  reason: collision with other field name */
    protected pd0 f3085a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f3086a;
    protected float b;

    /* renamed from: b  reason: collision with other field name */
    protected int f3087b;

    /* renamed from: b  reason: collision with other field name */
    protected String f3088b;

    /* renamed from: b  reason: collision with other field name */
    protected boolean f3089b;
    protected float c;

    /* renamed from: c  reason: collision with other field name */
    protected String f3090c;

    /* renamed from: c  reason: collision with other field name */
    protected boolean f3091c;
    protected float d;

    /* renamed from: d  reason: collision with other field name */
    protected boolean f3092d;

    public gh() {
        this(f50.k);
    }

    public gh(pd0 pageSize) {
        this(pageSize, 36.0f, 36.0f, 36.0f, 36.0f);
    }

    public gh(pd0 pageSize, float marginLeft, float marginRight, float marginTop, float marginBottom) {
        this.f3083a = new ArrayList<>();
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.f3091c = false;
        this.f3092d = false;
        this.f3082a = null;
        this.f3088b = null;
        this.f3090c = null;
        this.f3079a = 0;
        this.f3087b = 0;
        this.f3081a = h70.G2;
        this.f3084a = null;
        this.f3080a = new g0();
        this.f3085a = pageSize;
        this.a = marginLeft;
        this.b = marginRight;
        this.c = marginTop;
        this.d = marginBottom;
    }

    public void g(eh listener) {
        this.f3083a.add(listener);
        if (listener instanceof br) {
            br ae = (br) listener;
            ae.b(this.f3081a);
            ae.h(this.f3080a);
            HashMap<h70, o70> hashMap = this.f3084a;
            if (hashMap != null) {
                for (h70 key : hashMap.keySet()) {
                    ae.p(key, this.f3084a.get(key));
                }
            }
        }
    }

    public boolean c(bi element) {
        if (this.f3089b) {
            throw new ih(i10.b("the.document.has.been.closed.you.can.t.add.any.elements", new Object[0]));
        } else if (this.f3086a || !element.r()) {
            boolean success = false;
            Iterator i$ = this.f3083a.iterator();
            while (i$.hasNext()) {
                success |= i$.next().c(element);
            }
            if (element instanceof pw) {
                pw e2 = (pw) element;
                if (!e2.isComplete()) {
                    e2.d();
                }
            }
            return success;
        } else {
            throw new ih(i10.b("the.document.is.not.open.yet.you.can.only.add.meta.information", new Object[0]));
        }
    }

    public void open() {
        if (!this.f3089b) {
            this.f3086a = true;
        }
        Iterator i$ = this.f3083a.iterator();
        while (i$.hasNext()) {
            eh listener = i$.next();
            listener.d(this.f3085a);
            listener.a(this.a, this.b, this.c, this.d);
            listener.open();
        }
    }

    public boolean d(pd0 pageSize) {
        this.f3085a = pageSize;
        Iterator i$ = this.f3083a.iterator();
        while (i$.hasNext()) {
            i$.next().d(pageSize);
        }
        return true;
    }

    public boolean a(float marginLeft, float marginRight, float marginTop, float marginBottom) {
        this.a = marginLeft;
        this.b = marginRight;
        this.c = marginTop;
        this.d = marginBottom;
        Iterator i$ = this.f3083a.iterator();
        while (i$.hasNext()) {
            i$.next().a(marginLeft, marginRight, marginTop, marginBottom);
        }
        return true;
    }

    public boolean e() {
        if (!this.f3086a || this.f3089b) {
            return false;
        }
        Iterator i$ = this.f3083a.iterator();
        while (i$.hasNext()) {
            i$.next().e();
        }
        return true;
    }

    public int m() {
        return this.f3079a;
    }

    public void close() {
        if (!this.f3089b) {
            this.f3086a = false;
            this.f3089b = true;
        }
        Iterator i$ = this.f3083a.iterator();
        while (i$.hasNext()) {
            i$.next().close();
        }
    }

    public boolean i() {
        try {
            return c(new j10(5, av0.a().d()));
        } catch (ih de) {
            throw new mj(de);
        }
    }

    public boolean f() {
        try {
            return c(new j10(6, new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date())));
        } catch (ih de) {
            throw new mj(de);
        }
    }

    public float n() {
        return this.f3085a.F(this.a);
    }

    public float r() {
        return this.f3085a.K(this.c);
    }

    public float o(float margin) {
        return this.f3085a.F(this.a + margin);
    }

    public float q(float margin) {
        return this.f3085a.H(this.b + margin);
    }

    public float t(float margin) {
        return this.f3085a.K(this.c + margin);
    }

    public float k(float margin) {
        return this.f3085a.C(this.d + margin);
    }

    public o70 l(h70 key) {
        HashMap<h70, o70> hashMap = this.f3084a;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public void p(h70 key, o70 value) {
        if (this.f3084a == null) {
            this.f3084a = new HashMap<>();
        }
        this.f3084a.put(key, value);
    }

    public HashMap<h70, o70> u() {
        return this.f3084a;
    }

    public h70 j() {
        return this.f3081a;
    }

    public void b(h70 role) {
        this.f3081a = role;
    }

    public g0 s() {
        return this.f3080a;
    }

    public void h(g0 id) {
        this.f3080a = id;
    }

    public boolean isInline() {
        return false;
    }
}
