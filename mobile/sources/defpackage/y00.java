package defpackage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: y00  reason: default package */
class y00 implements td0 {
    private final b10 a;

    /* renamed from: a  reason: collision with other field name */
    private Set<mh> f5784a;

    /* renamed from: a  reason: collision with other field name */
    private vd0 f5785a;

    y00(b10 persistence) {
        this.a = persistence;
    }

    public long b() {
        return -1;
    }

    public void j(vd0 inMemoryPins) {
        this.f5785a = inMemoryPins;
    }

    public void p(mh key) {
        this.f5784a.remove(key);
    }

    public void a(mh key) {
        this.f5784a.add(key);
    }

    public void d(mh key) {
        this.f5784a.add(key);
    }

    public void l(bq0 targetData) {
        d10 targetCache = this.a.e();
        Iterator<mh> it = targetCache.f(targetData.g()).iterator();
        while (it.hasNext()) {
            this.f5784a.add(it.next());
        }
        targetCache.k(targetData);
    }

    public void e() {
        this.f5784a = new HashSet();
    }

    public void k() {
        c10 remoteDocuments = this.a.d();
        for (mh key : this.f5784a) {
            if (!c(key)) {
                remoteDocuments.c(key);
            }
        }
        this.f5784a = null;
    }

    public void m(mh key) {
        if (c(key)) {
            this.f5784a.remove(key);
        } else {
            this.f5784a.add(key);
        }
    }

    private boolean f(mh key) {
        for (a10 queue : this.a.k()) {
            if (queue.m(key)) {
                return true;
            }
        }
        return false;
    }

    private boolean c(mh key) {
        if (this.a.e().j(key) || f(key)) {
            return true;
        }
        vd0 vd0 = this.f5785a;
        if (vd0 == null || !vd0.c(key)) {
            return false;
        }
        return true;
    }
}
