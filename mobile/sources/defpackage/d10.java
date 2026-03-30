package defpackage;

import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.core.b0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: d10  reason: default package */
final class d10 implements zp0 {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f2692a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final b10 f2693a;

    /* renamed from: a  reason: collision with other field name */
    private hm0 f2694a = hm0.a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<b0, bq0> f2695a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private final vd0 f2696a = new vd0();

    d10(b10 persistence) {
        this.f2693a = persistence;
    }

    public int d() {
        return this.a;
    }

    public hm0 c() {
        return this.f2694a;
    }

    public void i(hm0 snapshotVersion) {
        this.f2694a = snapshotVersion;
    }

    public void h(bq0 targetData) {
        this.f2695a.put(targetData.f(), targetData);
        int targetId = targetData.g();
        if (targetId > this.a) {
            this.a = targetId;
        }
        if (targetData.d() > this.f2692a) {
            this.f2692a = targetData.d();
        }
    }

    public void a(bq0 targetData) {
        h(targetData);
    }

    public void k(bq0 targetData) {
        this.f2695a.remove(targetData.f());
        this.f2696a.h(targetData.g());
    }

    public bq0 g(b0 target) {
        return this.f2695a.get(target);
    }

    public void b(e<mh> keys, int targetId) {
        this.f2696a.b(keys, targetId);
        td0 referenceDelegate = this.f2693a.c();
        Iterator<mh> it = keys.iterator();
        while (it.hasNext()) {
            referenceDelegate.p(it.next());
        }
    }

    public void e(e<mh> keys, int targetId) {
        this.f2696a.g(keys, targetId);
        td0 referenceDelegate = this.f2693a.c();
        Iterator<mh> it = keys.iterator();
        while (it.hasNext()) {
            referenceDelegate.a(it.next());
        }
    }

    public e<mh> f(int targetId) {
        return this.f2696a.d(targetId);
    }

    public boolean j(mh key) {
        return this.f2696a.c(key);
    }
}
