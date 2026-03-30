package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class x {
    private static final w a;
    private static final w b;

    /* renamed from: a  reason: collision with other field name */
    private final long f2236a;

    /* renamed from: a  reason: collision with other field name */
    private b0 f2237a;

    /* renamed from: a  reason: collision with other field name */
    private final c f2238a;

    /* renamed from: a  reason: collision with other field name */
    private final a f2239a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2240a;

    /* renamed from: a  reason: collision with other field name */
    private final List<w> f2241a;

    /* renamed from: a  reason: collision with other field name */
    private final me0 f2242a;

    /* renamed from: b  reason: collision with other field name */
    private final c f2243b;

    /* renamed from: b  reason: collision with other field name */
    private List<w> f2244b;
    private final List<h> c;

    public enum a {
        LIMIT_TO_FIRST,
        LIMIT_TO_LAST
    }

    public static x b(me0 path) {
        return new x(path, (String) null);
    }

    static {
        w.a aVar = w.a.ASCENDING;
        pk pkVar = pk.a;
        a = w.d(aVar, pkVar);
        b = w.d(w.a.DESCENDING, pkVar);
    }

    public x(me0 path, String collectionGroup, List<h> filters, List<w> explicitSortOrder, long limit, a limitType, c startAt, c endAt) {
        this.f2242a = path;
        this.f2240a = collectionGroup;
        this.f2241a = explicitSortOrder;
        this.c = filters;
        this.f2236a = limit;
        this.f2239a = limitType;
        this.f2238a = startAt;
        this.f2243b = endAt;
    }

    public x(me0 path, String collectionGroup) {
        this(path, collectionGroup, Collections.emptyList(), Collections.emptyList(), -1, a.LIMIT_TO_FIRST, (c) null, (c) null);
    }

    public me0 m() {
        return this.f2242a;
    }

    public String d() {
        return this.f2240a;
    }

    public boolean s() {
        return mh.j(this.f2242a) && this.f2240a == null && this.c.isEmpty();
    }

    public boolean r() {
        return this.f2240a != null;
    }

    public boolean u() {
        if (this.c.isEmpty() && this.f2236a == -1 && this.f2238a == null && this.f2243b == null) {
            if (!f().isEmpty()) {
                return f().size() == 1 && h().u();
            }
            return true;
        }
    }

    public List<h> g() {
        return this.c;
    }

    public long i() {
        n4.d(o(), "Called getLimitToFirst when no limit was set", new Object[0]);
        return this.f2236a;
    }

    public boolean o() {
        return this.f2239a == a.LIMIT_TO_FIRST && this.f2236a != -1;
    }

    public long j() {
        n4.d(p(), "Called getLimitToLast when no limit was set", new Object[0]);
        return this.f2236a;
    }

    public boolean p() {
        return this.f2239a == a.LIMIT_TO_LAST && this.f2236a != -1;
    }

    public a k() {
        n4.d(p() || o(), "Called getLimitType when no limit was set", new Object[0]);
        return this.f2239a;
    }

    public c n() {
        return this.f2238a;
    }

    public c e() {
        return this.f2243b;
    }

    public pk h() {
        if (this.f2241a.isEmpty()) {
            return null;
        }
        return this.f2241a.get(0).c();
    }

    public pk q() {
        for (h filter : this.c) {
            if (filter instanceof g) {
                g fieldfilter = (g) filter;
                if (fieldfilter.g()) {
                    return fieldfilter.d();
                }
            }
        }
        return null;
    }

    public x a(me0 path) {
        return new x(path, (String) null, this.c, this.f2241a, this.f2236a, this.f2239a, this.f2238a, this.f2243b);
    }

    public List<w> f() {
        return this.f2241a;
    }

    public List<w> l() {
        w.a lastDirection;
        if (this.f2244b == null) {
            pk inequalityField = q();
            pk firstOrderByField = h();
            if (inequalityField == null || firstOrderByField != null) {
                List<OrderBy> res = new ArrayList<>();
                boolean foundKeyOrdering = false;
                for (w explicit : this.f2241a) {
                    res.add(explicit);
                    if (explicit.c().equals(pk.a)) {
                        foundKeyOrdering = true;
                    }
                }
                if (!foundKeyOrdering) {
                    if (this.f2241a.size() > 0) {
                        List<w> list = this.f2241a;
                        lastDirection = list.get(list.size() - 1).b();
                    } else {
                        lastDirection = w.a.ASCENDING;
                    }
                    res.add(lastDirection.equals(w.a.ASCENDING) ? a : b);
                }
                this.f2244b = res;
            } else if (inequalityField.u()) {
                this.f2244b = Collections.singletonList(a);
            } else {
                this.f2244b = Arrays.asList(new w[]{w.d(w.a.ASCENDING, inequalityField), a});
            }
        }
        return this.f2244b;
    }

    private boolean y(com.google.firebase.firestore.model.b doc) {
        me0 docPath = doc.a().h();
        if (this.f2240a != null) {
            if (!doc.a().i(this.f2240a) || !this.f2242a.l(docPath)) {
                return false;
            }
            return true;
        } else if (mh.j(this.f2242a)) {
            return this.f2242a.equals(docPath);
        } else {
            if (!this.f2242a.l(docPath) || this.f2242a.n() != docPath.n() - 1) {
                return false;
            }
            return true;
        }
    }

    private boolean w(com.google.firebase.firestore.model.b doc) {
        for (h filter : this.c) {
            if (!filter.b(doc)) {
                return false;
            }
        }
        return true;
    }

    private boolean x(com.google.firebase.firestore.model.b doc) {
        for (w order : this.f2241a) {
            if (!order.c().equals(pk.a) && doc.e(order.f2235a) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean v(com.google.firebase.firestore.model.b doc) {
        c cVar = this.f2238a;
        if (cVar != null && !cVar.d(l(), doc)) {
            return false;
        }
        c cVar2 = this.f2243b;
        if (cVar2 == null || !cVar2.d(l(), doc)) {
            return true;
        }
        return false;
    }

    public boolean t(com.google.firebase.firestore.model.b doc) {
        return y(doc) && x(doc) && w(doc) && v(doc);
    }

    public Comparator<com.google.firebase.firestore.model.b> c() {
        return new b(l());
    }

    private static class b implements Comparator<com.google.firebase.firestore.model.b> {
        private final List<w> a;

        b(List<w> order) {
            boolean hasKeyOrdering = false;
            for (w orderBy : order) {
                hasKeyOrdering = hasKeyOrdering || orderBy.c().equals(pk.a);
            }
            if (hasKeyOrdering) {
                this.a = order;
                return;
            }
            throw new IllegalArgumentException("QueryComparator needs to have a key ordering");
        }

        /* renamed from: a */
        public int compare(com.google.firebase.firestore.model.b doc1, com.google.firebase.firestore.model.b doc2) {
            for (w order : this.a) {
                int comp = order.a(doc1, doc2);
                if (comp != 0) {
                    return comp;
                }
            }
            return 0;
        }
    }

    public b0 z() {
        c newEndAt;
        if (this.f2237a == null) {
            if (this.f2239a == a.LIMIT_TO_FIRST) {
                this.f2237a = new b0(m(), d(), g(), l(), this.f2236a, n(), e());
            } else {
                ArrayList<OrderBy> newOrderBy = new ArrayList<>();
                for (w orderBy : l()) {
                    w.a b2 = orderBy.b();
                    w.a dir = w.a.DESCENDING;
                    if (b2 == dir) {
                        dir = w.a.ASCENDING;
                    }
                    newOrderBy.add(w.d(dir, orderBy.c()));
                }
                c cVar = this.f2243b;
                c newStartAt = cVar != null ? new c(cVar.b(), !this.f2243b.c()) : null;
                c cVar2 = this.f2238a;
                if (cVar2 != null) {
                    newEndAt = new c(cVar2.b(), !this.f2238a.c());
                } else {
                    newEndAt = null;
                }
                this.f2237a = new b0(m(), d(), g(), newOrderBy, this.f2236a, newStartAt, newEndAt);
            }
        }
        return this.f2237a;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        x query = (x) o;
        if (this.f2239a != query.f2239a) {
            return false;
        }
        return z().equals(query.z());
    }

    public int hashCode() {
        return (z().hashCode() * 31) + this.f2239a.hashCode();
    }

    public String toString() {
        return "Query(target=" + z().toString() + ";limitType=" + this.f2239a.toString() + ")";
    }
}
