package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.w;
import java.util.List;

public final class b0 {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final c f2186a;

    /* renamed from: a  reason: collision with other field name */
    private String f2187a;

    /* renamed from: a  reason: collision with other field name */
    private final List<w> f2188a;

    /* renamed from: a  reason: collision with other field name */
    private final me0 f2189a;
    private final c b;

    /* renamed from: b  reason: collision with other field name */
    private final String f2190b;

    /* renamed from: b  reason: collision with other field name */
    private final List<h> f2191b;

    b0(me0 path, String collectionGroup, List<h> filters, List<w> orderBy, long limit, c startAt, c endAt) {
        this.f2189a = path;
        this.f2190b = collectionGroup;
        this.f2188a = orderBy;
        this.f2191b = filters;
        this.a = limit;
        this.f2186a = startAt;
        this.b = endAt;
    }

    public me0 g() {
        return this.f2189a;
    }

    public String b() {
        return this.f2190b;
    }

    public boolean j() {
        return mh.j(this.f2189a) && this.f2190b == null && this.f2191b.isEmpty();
    }

    public List<h> d() {
        return this.f2191b;
    }

    public long e() {
        n4.d(i(), "Called getLimit when no limit was set", new Object[0]);
        return this.a;
    }

    public boolean i() {
        return this.a != -1;
    }

    public c h() {
        return this.f2186a;
    }

    public c c() {
        return this.b;
    }

    public List<w> f() {
        return this.f2188a;
    }

    public String a() {
        String str = this.f2187a;
        if (str != null) {
            return str;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(g().c());
        if (this.f2190b != null) {
            builder.append("|cg:");
            builder.append(this.f2190b);
        }
        builder.append("|f:");
        for (h filter : d()) {
            builder.append(filter.a());
        }
        builder.append("|ob:");
        for (w orderBy : f()) {
            builder.append(orderBy.c().c());
            builder.append(orderBy.b().equals(w.a.ASCENDING) ? "asc" : "desc");
        }
        if (i()) {
            builder.append("|l:");
            builder.append(e());
        }
        if (this.f2186a != null) {
            builder.append("|lb:");
            builder.append(this.f2186a.a());
        }
        if (this.b != null) {
            builder.append("|ub:");
            builder.append(this.b.a());
        }
        String sb = builder.toString();
        this.f2187a = sb;
        return sb;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        b0 target = (b0) o;
        String str = this.f2190b;
        if (str == null ? target.f2190b != null : !str.equals(target.f2190b)) {
            return false;
        }
        if (this.a != target.a || !this.f2188a.equals(target.f2188a) || !this.f2191b.equals(target.f2191b) || !this.f2189a.equals(target.f2189a)) {
            return false;
        }
        c cVar = this.f2186a;
        if (cVar == null ? target.f2186a != null : !cVar.equals(target.f2186a)) {
            return false;
        }
        c cVar2 = this.b;
        if (cVar2 != null) {
            return cVar2.equals(target.b);
        }
        if (target.b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f2188a.hashCode() * 31;
        String str = this.f2190b;
        int i = 0;
        int hashCode2 = str != null ? str.hashCode() : 0;
        long j = this.a;
        int result = (((((((hashCode + hashCode2) * 31) + this.f2191b.hashCode()) * 31) + this.f2189a.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        c cVar = this.f2186a;
        int result2 = (result + (cVar != null ? cVar.hashCode() : 0)) * 31;
        c cVar2 = this.b;
        if (cVar2 != null) {
            i = cVar2.hashCode();
        }
        return result2 + i;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Query(");
        builder.append(this.f2189a.c());
        if (this.f2190b != null) {
            builder.append(" collectionGroup=");
            builder.append(this.f2190b);
        }
        if (!this.f2191b.isEmpty()) {
            builder.append(" where ");
            for (int i = 0; i < this.f2191b.size(); i++) {
                if (i > 0) {
                    builder.append(" and ");
                }
                builder.append(this.f2191b.get(i).toString());
            }
        }
        if (!this.f2188a.isEmpty()) {
            builder.append(" order by ");
            for (int i2 = 0; i2 < this.f2188a.size(); i2++) {
                if (i2 > 0) {
                    builder.append(", ");
                }
                builder.append(this.f2188a.get(i2));
            }
        }
        builder.append(")");
        return builder.toString();
    }
}
