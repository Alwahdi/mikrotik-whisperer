package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.b0;
import com.google.firebase.firestore.core.g;
import com.google.firebase.firestore.core.h;
import com.google.firebase.firestore.core.w;
import com.google.firebase.firestore.core.x;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.b;
import com.google.firebase.firestore.model.mutation.FieldTransform;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.remote.h0;
import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.Value;
import com.google.firestore.v1.a;
import com.google.firestore.v1.b;
import com.google.firestore.v1.c;
import com.google.firestore.v1.d;
import com.google.firestore.v1.e;
import com.google.firestore.v1.f;
import com.google.firestore.v1.h;
import com.google.firestore.v1.i;
import com.google.firestore.v1.k;
import com.google.firestore.v1.l;
import com.google.firestore.v1.m;
import com.google.firestore.v1.n;
import com.google.firestore.v1.o;
import com.google.firestore.v1.p;
import com.google.firestore.v1.q;
import com.google.firestore.v1.r;
import com.google.firestore.v1.u;
import com.google.protobuf.j;
import com.google.protobuf.v;
import defpackage.e4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a0 {
    private final String a;

    /* renamed from: a  reason: collision with other field name */
    private final ve f2300a;

    public a0(ve databaseId) {
        this.f2300a = databaseId;
        this.a = b0(databaseId).c();
    }

    public v X(pr0 timestamp) {
        v.b builder = v.Q();
        builder.y(timestamp.p());
        builder.x(timestamp.o());
        return (v) builder.q();
    }

    public pr0 v(v proto) {
        return new pr0(proto.P(), proto.O());
    }

    public v a0(hm0 version) {
        return X(version.b());
    }

    public hm0 y(v proto) {
        if (proto.P() == 0 && proto.O() == 0) {
            return hm0.a;
        }
        return new hm0(v(proto));
    }

    private qw L(cp geoPoint) {
        return (qw) qw.Q().x(geoPoint.b()).y(geoPoint.c()).q();
    }

    private cp l(qw latLng) {
        return new cp(latLng.O(), latLng.P());
    }

    public String M(mh key) {
        return V(this.f2300a, key.h());
    }

    public mh m(String name) {
        me0 resource = u(name);
        n4.d(resource.i(1).equals(this.f2300a.d()), "Tried to deserialize key from different project.", new Object[0]);
        n4.d(resource.i(3).equals(this.f2300a.c()), "Tried to deserialize key from different database.", new Object[0]);
        return mh.e(c0(resource));
    }

    private String T(me0 path) {
        return V(this.f2300a, path);
    }

    private me0 s(String name) {
        me0 resource = u(name);
        if (resource.n() == 4) {
            return me0.a;
        }
        return c0(resource);
    }

    private String V(ve databaseId, me0 path) {
        return ((me0) ((me0) b0(databaseId).b("documents")).a(path)).c();
    }

    private me0 u(String encoded) {
        me0 resource = me0.t(encoded);
        n4.d(e0(resource), "Tried to deserialize invalid key %s", resource);
        return resource;
    }

    private static me0 b0(ve databaseId) {
        return me0.s(Arrays.asList(new String[]{"projects", databaseId.d(), "databases", databaseId.c()}));
    }

    private static me0 c0(me0 resourceName) {
        n4.d(resourceName.n() > 4 && resourceName.i(4).equals("documents"), "Tried to deserialize invalid key %s", resourceName);
        return (me0) resourceName.p(5);
    }

    private static boolean e0(me0 path) {
        if (path.n() < 4 || !path.i(0).equals("projects") || !path.i(2).equals("databases")) {
            return false;
        }
        return true;
    }

    public String a() {
        return this.a;
    }

    public q Z(rk value) {
        q.b builder = q.i0();
        if (value instanceof p30) {
            builder.F(0);
            return (q) builder.q();
        }
        Object encodedValue = value.d();
        n4.d(encodedValue != null, "Encoded field value should not be null.", new Object[0]);
        if (value instanceof q6) {
            builder.y(((Boolean) encodedValue).booleanValue());
        } else if (value instanceof et) {
            builder.D(((Long) encodedValue).longValue());
        } else if (value instanceof th) {
            builder.A(((Double) encodedValue).doubleValue());
        } else if (value instanceof rn0) {
            builder.H((String) encodedValue);
        } else if (value instanceof g4) {
            builder.x(C((g4) value));
        } else if (value instanceof c40) {
            builder.E(P((c40) value));
        } else if (value instanceof qr0) {
            builder.I(X(((qr0) value).e()));
        } else if (value instanceof dp) {
            builder.B(L((cp) encodedValue));
        } else if (value instanceof m6) {
            builder.z(((l6) encodedValue).c());
        } else if (value instanceof wd0) {
            builder.G(V(((wd0) value).e(), ((mh) encodedValue).h()));
        } else {
            throw n4.a("Can't serialize %s", value);
        }
        return (q) builder.q();
    }

    public rk x(q proto) {
        switch (a.a[proto.h0().ordinal()]) {
            case 1:
                return p30.e();
            case 2:
                return q6.g(Boolean.valueOf(proto.X()));
            case 3:
                return et.h(Long.valueOf(proto.c0()));
            case 4:
                return th.h(Double.valueOf(proto.a0()));
            case 5:
                return qr0.h(v(proto.g0()));
            case 6:
                return dp.g(l(proto.b0()));
            case 7:
                return m6.g(l6.b(proto.Y()));
            case 8:
                me0 resourceName = u(proto.e0());
                return wd0.h(ve.b(resourceName.i(1), resourceName.i(3)), mh.e(c0(resourceName)));
            case 9:
                return rn0.g(proto.f0());
            case 10:
                return c(proto.W());
            case 11:
                return n(proto.d0());
            default:
                throw n4.a("Unknown value %s", proto);
        }
    }

    private com.google.firestore.v1.a C(g4 value) {
        List<rk> g = value.g();
        a.b arrayBuilder = com.google.firestore.v1.a.R();
        for (rk subValue : g) {
            arrayBuilder.x(Z(subValue));
        }
        return (com.google.firestore.v1.a) arrayBuilder.q();
    }

    private g4 c(com.google.firestore.v1.a protoArray) {
        int count = protoArray.Q();
        List<FieldValue> wrappedList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            wrappedList.add(x(protoArray.P(i)));
        }
        return g4.e(wrappedList);
    }

    private l P(c40 value) {
        l.b builder = l.R();
        Iterator<Map.Entry<String, rk>> it = value.l().iterator();
        while (it.hasNext()) {
            Map.Entry<String, FieldValue> entry = it.next();
            builder.x(entry.getKey(), Z((rk) entry.getValue()));
        }
        return (l) builder.q();
    }

    private c40 n(l value) {
        return j(value.N());
    }

    public c40 j(Map<String, q> fields) {
        c40 result = c40.g();
        for (Map.Entry<String, Value> entry : fields.entrySet()) {
            result = result.n(pk.t(entry.getKey()), x((q) entry.getValue()));
        }
        return result;
    }

    public c E(mh key, c40 value) {
        c.b builder = c.W();
        builder.y(M(key));
        Iterator<Map.Entry<String, rk>> it = value.l().iterator();
        while (it.hasNext()) {
            Map.Entry<String, FieldValue> entry = it.next();
            builder.x(entry.getKey(), Z((rk) entry.getValue()));
        }
        return (c) builder.q();
    }

    public r Q(u20 mutation) {
        r.b builder = r.a0();
        if (mutation instanceof xk0) {
            builder.A(E(mutation.d(), ((xk0) mutation).k()));
        } else if (mutation instanceof o50) {
            builder.A(E(mutation.d(), ((o50) mutation).l()));
            builder.B(F(((o50) mutation).k()));
        } else if (mutation instanceof xr0) {
            xr0 transform = (xr0) mutation;
            h.b transformBuilder = h.S();
            transformBuilder.y(M(transform.d()));
            for (qk fieldTransform : transform.k()) {
                transformBuilder.x(J(fieldTransform));
            }
            builder.z(transformBuilder);
        } else if (mutation instanceof ag) {
            builder.y(M(mutation.d()));
        } else if (mutation instanceof zu0) {
            builder.D(M(mutation.d()));
        } else {
            throw n4.a("unknown mutation type %s", mutation.getClass());
        }
        if (!mutation.f().d()) {
            builder.x(S(mutation.f()));
        }
        return (r) builder.q();
    }

    public u20 o(r mutation) {
        u90 precondition;
        if (mutation.Y()) {
            precondition = r(mutation.R());
        } else {
            precondition = u90.a;
        }
        boolean z = true;
        switch (a.b[mutation.T().ordinal()]) {
            case 1:
                if (mutation.Z()) {
                    return new o50(m(mutation.V().S()), j(mutation.V().Q()), e(mutation.W()), precondition);
                }
                return new xk0(m(mutation.V().S()), j(mutation.V().Q()), precondition);
            case 2:
                return new ag(m(mutation.S()), precondition);
            case 3:
                ArrayList<FieldTransform> fieldTransforms = new ArrayList<>();
                for (h.c fieldTransform : mutation.U().R()) {
                    fieldTransforms.add(i(fieldTransform));
                }
                Boolean exists = precondition.b();
                if (exists == null || !exists.booleanValue()) {
                    z = false;
                }
                n4.d(z, "Transforms only support precondition \"exists == true\"", new Object[0]);
                return new xr0(m(mutation.U().Q()), fieldTransforms);
            case 4:
                return new zu0(m(mutation.X()), precondition);
            default:
                throw n4.a("Unknown mutation operation: %d", mutation.T());
        }
    }

    private m S(u90 precondition) {
        n4.d(!precondition.d(), "Can't serialize an empty precondition", new Object[0]);
        m.b builder = m.R();
        if (precondition.c() != null) {
            return (m) builder.y(a0(precondition.c())).q();
        }
        if (precondition.b() != null) {
            return (m) builder.x(precondition.b().booleanValue()).q();
        }
        throw n4.a("Unknown Precondition", new Object[0]);
    }

    private u90 r(m precondition) {
        switch (a.c[precondition.N().ordinal()]) {
            case 1:
                return u90.f(y(precondition.Q()));
            case 2:
                return u90.a(precondition.P());
            case 3:
                return u90.a;
            default:
                throw n4.a("Unknown precondition", new Object[0]);
        }
    }

    private f F(ok mask) {
        f.b builder = f.S();
        for (pk path : mask.c()) {
            builder.x(path.c());
        }
        return (f) builder.q();
    }

    private ok e(f mask) {
        int count = mask.Q();
        Set<FieldPath> paths = new HashSet<>(count);
        for (int i = 0; i < count; i++) {
            paths.add(pk.s(mask.P(i)));
        }
        return ok.b(paths);
    }

    private h.c J(qk fieldTransform) {
        yr0 transform = fieldTransform.b();
        if (transform instanceof ok0) {
            return (h.c) h.c.W().y(fieldTransform.a().c()).B(h.c.b.REQUEST_TIME).q();
        }
        if (transform instanceof e4.b) {
            return (h.c) h.c.W().y(fieldTransform.a().c()).x(B(((e4.b) transform).f())).q();
        }
        if (transform instanceof e4.a) {
            return (h.c) h.c.W().y(fieldTransform.a().c()).A(B(((e4.a) transform).f())).q();
        }
        if (transform instanceof t30) {
            return (h.c) h.c.W().y(fieldTransform.a().c()).z(Z(((t30) transform).e())).q();
        }
        throw n4.a("Unknown transform: %s", transform);
    }

    private com.google.firestore.v1.a B(List<rk> elements) {
        a.b arrayBuilder = com.google.firestore.v1.a.R();
        for (rk subValue : elements) {
            arrayBuilder.x(Z(subValue));
        }
        return (com.google.firestore.v1.a) arrayBuilder.q();
    }

    private qk i(h.c fieldTransform) {
        switch (a.d[fieldTransform.V().ordinal()]) {
            case 1:
                n4.d(fieldTransform.U() == h.c.b.REQUEST_TIME, "Unknown transform setToServerValue: %s", fieldTransform.U());
                return new qk(pk.s(fieldTransform.R()), ok0.d());
            case 2:
                return new qk(pk.s(fieldTransform.R()), new e4.b(b(fieldTransform.Q())));
            case 3:
                return new qk(pk.s(fieldTransform.R()), new e4.a(b(fieldTransform.T())));
            case 4:
                rk operand = x(fieldTransform.S());
                n4.d(operand instanceof s30, "Expected NUMERIC_ADD transform to be of number type, but was %s", operand.getClass().getCanonicalName());
                return new qk(pk.s(fieldTransform.R()), new t30((s30) x(fieldTransform.S())));
            default:
                throw n4.a("Unknown FieldTransform proto: %s", fieldTransform);
        }
    }

    private List<rk> b(com.google.firestore.v1.a elementsProto) {
        int count = elementsProto.Q();
        List<FieldValue> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(x(elementsProto.P(i)));
        }
        return result;
    }

    public y20 p(u proto, hm0 commitVersion) {
        hm0 version = y(proto.N());
        if (hm0.a.equals(version)) {
            version = commitVersion;
        }
        ArrayList<FieldValue> transformResults = null;
        int transformResultsCount = proto.M();
        if (transformResultsCount > 0) {
            transformResults = new ArrayList<>(transformResultsCount);
            for (int i = 0; i < transformResultsCount; i++) {
                transformResults.add(x(proto.L(i)));
            }
        }
        return new y20(version, transformResults);
    }

    public Map<String, String> O(bq0 targetData) {
        String value = N(targetData.b());
        if (value == null) {
            return null;
        }
        Map<String, String> result = new HashMap<>(1);
        result.put("goog-listen-tags", value);
        return result;
    }

    private String N(com.google.firebase.firestore.local.a purpose) {
        switch (a.e[purpose.ordinal()]) {
            case 1:
                return null;
            case 2:
                return "existence-filter-mismatch";
            case 3:
                return "limbo-document";
            default:
                throw n4.a("Unrecognized query purpose: %s", purpose);
        }
    }

    public o W(bq0 targetData) {
        o.b builder = o.R();
        b0 target = targetData.f();
        if (target.j()) {
            builder.x(G(target));
        } else {
            builder.y(U(target));
        }
        builder.A(targetData.g());
        builder.z(targetData.c());
        return (o) builder.q();
    }

    public o.c G(b0 target) {
        o.c.a builder = o.c.S();
        builder.x(T(target.g()));
        return (o.c) builder.q();
    }

    public b0 f(o.c target) {
        int count = target.Q();
        n4.d(count == 1, "DocumentsTarget contained other than 1 document %d", Integer.valueOf(count));
        return x.b(s(target.P(0))).z();
    }

    public o.d U(b0 target) {
        o.d.a builder = o.d.R();
        n.b structuredQueryBuilder = n.j0();
        me0 path = target.g();
        boolean z = true;
        if (target.b() != null) {
            n4.d(path.n() % 2 == 0, "Collection Group queries should be within a document path or root.", new Object[0]);
            builder.x(T(path));
            n.c.a from = n.c.P();
            from.y(target.b());
            from.x(true);
            structuredQueryBuilder.x(from);
        } else {
            if (path.n() % 2 == 0) {
                z = false;
            }
            n4.d(z, "Document queries with filters are not supported.", new Object[0]);
            builder.x(T((me0) path.q()));
            n.c.a from2 = n.c.P();
            from2.y(path.h());
            structuredQueryBuilder.x(from2);
        }
        if (target.d().size() > 0) {
            structuredQueryBuilder.D(K(target.d()));
        }
        for (w orderBy : target.f()) {
            structuredQueryBuilder.y(R(orderBy));
        }
        if (target.i()) {
            structuredQueryBuilder.A(j.O().x((int) target.e()));
        }
        if (target.h() != null) {
            structuredQueryBuilder.B(D(target.h()));
        }
        if (target.c() != null) {
            structuredQueryBuilder.z(D(target.c()));
        }
        builder.y(structuredQueryBuilder);
        return (o.d) builder.q();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r6v14, types: [a6] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.firestore.core.b0 t(com.google.firestore.v1.o.d r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.String r1 = r24.O()
            me0 r1 = r0.s(r1)
            com.google.firestore.v1.n r2 = r24.Q()
            r3 = 0
            int r4 = r2.Y()
            if (r4 <= 0) goto L_0x003c
            r5 = 0
            r6 = 1
            if (r4 != r6) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r6 = 0
        L_0x001b:
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.String r8 = "StructuredQuery.from with more than one collection is not supported."
            defpackage.n4.d(r6, r8, r7)
            com.google.firestore.v1.n$c r5 = r2.X(r5)
            boolean r6 = r5.N()
            if (r6 == 0) goto L_0x0031
            java.lang.String r3 = r5.O()
            goto L_0x003c
        L_0x0031:
            java.lang.String r6 = r5.O()
            a6 r6 = r1.b(r6)
            r1 = r6
            me0 r1 = (defpackage.me0) r1
        L_0x003c:
            boolean r5 = r2.i0()
            if (r5 == 0) goto L_0x004b
            com.google.firestore.v1.n$h r5 = r2.e0()
            java.util.List r5 = r0.k(r5)
            goto L_0x004f
        L_0x004b:
            java.util.List r5 = java.util.Collections.emptyList()
        L_0x004f:
            int r15 = r2.b0()
            if (r15 <= 0) goto L_0x006e
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r15)
            r7 = 0
        L_0x005b:
            if (r7 >= r15) goto L_0x006b
            com.google.firestore.v1.n$i r8 = r2.a0(r7)
            com.google.firebase.firestore.core.w r8 = r0.q(r8)
            r6.add(r8)
            int r7 = r7 + 1
            goto L_0x005b
        L_0x006b:
            r16 = r6
            goto L_0x0074
        L_0x006e:
            java.util.List r6 = java.util.Collections.emptyList()
            r16 = r6
        L_0x0074:
            r6 = -1
            boolean r8 = r2.g0()
            if (r8 == 0) goto L_0x0088
            com.google.protobuf.j r8 = r2.Z()
            int r8 = r8.N()
            long r6 = (long) r8
            r17 = r6
            goto L_0x008a
        L_0x0088:
            r17 = r6
        L_0x008a:
            r6 = 0
            boolean r7 = r2.h0()
            if (r7 == 0) goto L_0x009c
            com.google.firestore.v1.b r7 = r2.d0()
            com.google.firebase.firestore.core.c r6 = r0.d(r7)
            r19 = r6
            goto L_0x009e
        L_0x009c:
            r19 = r6
        L_0x009e:
            r6 = 0
            boolean r7 = r2.f0()
            if (r7 == 0) goto L_0x00b0
            com.google.firestore.v1.b r7 = r2.W()
            com.google.firebase.firestore.core.c r6 = r0.d(r7)
            r20 = r6
            goto L_0x00b2
        L_0x00b0:
            r20 = r6
        L_0x00b2:
            com.google.firebase.firestore.core.x r21 = new com.google.firebase.firestore.core.x
            com.google.firebase.firestore.core.x$a r13 = com.google.firebase.firestore.core.x.a.LIMIT_TO_FIRST
            r6 = r21
            r7 = r1
            r8 = r3
            r9 = r5
            r10 = r16
            r11 = r17
            r14 = r19
            r22 = r15
            r15 = r20
            r6.<init>(r7, r8, r9, r10, r11, r13, r14, r15)
            com.google.firebase.firestore.core.b0 r6 = r21.z()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.remote.a0.t(com.google.firestore.v1.o$d):com.google.firebase.firestore.core.b0");
    }

    private n.h K(List<com.google.firebase.firestore.core.h> filters) {
        List<StructuredQuery.Filter> protos = new ArrayList<>(filters.size());
        for (com.google.firebase.firestore.core.h filter : filters) {
            if (filter instanceof g) {
                protos.add(Y((g) filter));
            }
        }
        if (filters.size() == 1) {
            return (n.h) protos.get(0);
        }
        n.d.a composite = n.d.S();
        composite.y(n.d.b.AND);
        composite.x(protos);
        return (n.h) n.h.T().x(composite).q();
    }

    private List<com.google.firebase.firestore.core.h> k(n.h proto) {
        List<n.h> list;
        if (proto.R() == n.h.b.COMPOSITE_FILTER) {
            n4.d(proto.O().R() == n.d.b.AND, "Only AND-type composite filters are supported, got %d", proto.O().R());
            list = proto.O().Q();
        } else {
            list = Collections.singletonList(proto);
        }
        List<Filter> result = new ArrayList<>(list.size());
        for (n.h filter : list) {
            switch (a.f[filter.R().ordinal()]) {
                case 1:
                    throw n4.a("Nested composite filters are not supported.", new Object[0]);
                case 2:
                    result.add(g(filter.Q()));
                    break;
                case 3:
                    result.add(w(filter.S()));
                    break;
                default:
                    throw n4.a("Unrecognized Filter.filterType %d", filter.R());
            }
        }
        return result;
    }

    /* access modifiers changed from: package-private */
    public n.h Y(g filter) {
        if (filter.e() == h.a.EQUAL) {
            n.k.a unaryProto = n.k.R();
            unaryProto.x(I(filter.d()));
            if (filter.f().equals(th.a)) {
                unaryProto.y(n.k.c.IS_NAN);
                return (n.h) n.h.T().z(unaryProto).q();
            } else if (filter.f().equals(p30.e())) {
                unaryProto.y(n.k.c.IS_NULL);
                return (n.h) n.h.T().z(unaryProto).q();
            }
        }
        n.f.a proto = n.f.S();
        proto.x(I(filter.d()));
        proto.y(H(filter.e()));
        proto.z(Z(filter.f()));
        return (n.h) n.h.T().y(proto).q();
    }

    /* access modifiers changed from: package-private */
    public g g(n.f proto) {
        return g.c(pk.s(proto.P().N()), h(proto.Q()), x(proto.R()));
    }

    private com.google.firebase.firestore.core.h w(n.k proto) {
        pk fieldPath = pk.s(proto.O().N());
        switch (a.g[proto.P().ordinal()]) {
            case 1:
                return g.c(fieldPath, h.a.EQUAL, th.a);
            case 2:
                return g.c(fieldPath, h.a.EQUAL, p30.e());
            default:
                throw n4.a("Unrecognized UnaryFilter.operator %d", proto.P());
        }
    }

    private n.g I(pk field) {
        return (n.g) n.g.O().x(field.c()).q();
    }

    private n.f.b H(h.a operator) {
        switch (a.h[operator.ordinal()]) {
            case 1:
                return n.f.b.LESS_THAN;
            case 2:
                return n.f.b.LESS_THAN_OR_EQUAL;
            case 3:
                return n.f.b.EQUAL;
            case 4:
                return n.f.b.GREATER_THAN;
            case 5:
                return n.f.b.GREATER_THAN_OR_EQUAL;
            case 6:
                return n.f.b.ARRAY_CONTAINS;
            case 7:
                return n.f.b.IN;
            case 8:
                return n.f.b.ARRAY_CONTAINS_ANY;
            default:
                throw n4.a("Unknown operator %d", operator);
        }
    }

    private h.a h(n.f.b operator) {
        switch (a.i[operator.ordinal()]) {
            case 1:
                return h.a.LESS_THAN;
            case 2:
                return h.a.LESS_THAN_OR_EQUAL;
            case 3:
                return h.a.EQUAL;
            case 4:
                return h.a.GREATER_THAN_OR_EQUAL;
            case 5:
                return h.a.GREATER_THAN;
            case 6:
                return h.a.ARRAY_CONTAINS;
            case 7:
                return h.a.IN;
            case 8:
                return h.a.ARRAY_CONTAINS_ANY;
            default:
                throw n4.a("Unhandled FieldFilter.operator %d", operator);
        }
    }

    private n.i R(w orderBy) {
        n.i.a proto = n.i.P();
        if (orderBy.b().equals(w.a.ASCENDING)) {
            proto.x(n.e.ASCENDING);
        } else {
            proto.x(n.e.DESCENDING);
        }
        proto.y(I(orderBy.c()));
        return (n.i) proto.q();
    }

    private w q(n.i proto) {
        w.a direction;
        pk fieldPath = pk.s(proto.O().N());
        switch (a.j[proto.N().ordinal()]) {
            case 1:
                direction = w.a.ASCENDING;
                break;
            case 2:
                direction = w.a.DESCENDING;
                break;
            default:
                throw n4.a("Unrecognized direction %d", proto.N());
        }
        return w.d(direction, fieldPath);
    }

    private b D(com.google.firebase.firestore.core.c bound) {
        b.C0028b builder = b.T();
        builder.y(bound.c());
        for (rk component : bound.b()) {
            builder.x(Z(component));
        }
        return (b) builder.q();
    }

    private com.google.firebase.firestore.core.c d(b proto) {
        int valuesCount = proto.S();
        List<FieldValue> indexComponents = new ArrayList<>(valuesCount);
        for (int i = 0; i < valuesCount; i++) {
            indexComponents.add(x(proto.R(i)));
        }
        return new com.google.firebase.firestore.core.c(indexComponents, proto.P());
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] e;
        static final /* synthetic */ int[] f;
        static final /* synthetic */ int[] g;
        static final /* synthetic */ int[] h;
        static final /* synthetic */ int[] i;
        static final /* synthetic */ int[] j;
        static final /* synthetic */ int[] k;
        static final /* synthetic */ int[] l;

        static {
            int[] iArr = new int[k.c.values().length];
            l = iArr;
            try {
                iArr[k.c.TARGET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                l[k.c.DOCUMENT_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                l[k.c.DOCUMENT_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                l[k.c.DOCUMENT_REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                l[k.c.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                l[k.c.RESPONSETYPE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            int[] iArr2 = new int[p.c.values().length];
            k = iArr2;
            try {
                iArr2[p.c.NO_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                k[p.c.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                k[p.c.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                k[p.c.CURRENT.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                k[p.c.RESET.ordinal()] = 5;
            } catch (NoSuchFieldError e12) {
            }
            try {
                k[p.c.UNRECOGNIZED.ordinal()] = 6;
            } catch (NoSuchFieldError e13) {
            }
            int[] iArr3 = new int[n.e.values().length];
            j = iArr3;
            try {
                iArr3[n.e.ASCENDING.ordinal()] = 1;
            } catch (NoSuchFieldError e14) {
            }
            try {
                j[n.e.DESCENDING.ordinal()] = 2;
            } catch (NoSuchFieldError e15) {
            }
            int[] iArr4 = new int[n.f.b.values().length];
            i = iArr4;
            try {
                iArr4[n.f.b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError e16) {
            }
            try {
                i[n.f.b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError e17) {
            }
            try {
                i[n.f.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError e18) {
            }
            try {
                i[n.f.b.GREATER_THAN_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError e19) {
            }
            try {
                i[n.f.b.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError e20) {
            }
            try {
                i[n.f.b.ARRAY_CONTAINS.ordinal()] = 6;
            } catch (NoSuchFieldError e21) {
            }
            try {
                i[n.f.b.IN.ordinal()] = 7;
            } catch (NoSuchFieldError e22) {
            }
            try {
                i[n.f.b.ARRAY_CONTAINS_ANY.ordinal()] = 8;
            } catch (NoSuchFieldError e23) {
            }
            int[] iArr5 = new int[h.a.values().length];
            h = iArr5;
            try {
                iArr5[h.a.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError e24) {
            }
            try {
                h[h.a.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError e25) {
            }
            try {
                h[h.a.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError e26) {
            }
            try {
                h[h.a.GREATER_THAN.ordinal()] = 4;
            } catch (NoSuchFieldError e27) {
            }
            try {
                h[h.a.GREATER_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError e28) {
            }
            try {
                h[h.a.ARRAY_CONTAINS.ordinal()] = 6;
            } catch (NoSuchFieldError e29) {
            }
            try {
                h[h.a.IN.ordinal()] = 7;
            } catch (NoSuchFieldError e30) {
            }
            try {
                h[h.a.ARRAY_CONTAINS_ANY.ordinal()] = 8;
            } catch (NoSuchFieldError e31) {
            }
            int[] iArr6 = new int[n.k.c.values().length];
            g = iArr6;
            try {
                iArr6[n.k.c.IS_NAN.ordinal()] = 1;
            } catch (NoSuchFieldError e32) {
            }
            try {
                g[n.k.c.IS_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError e33) {
            }
            int[] iArr7 = new int[n.h.b.values().length];
            f = iArr7;
            try {
                iArr7[n.h.b.COMPOSITE_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError e34) {
            }
            try {
                f[n.h.b.FIELD_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError e35) {
            }
            try {
                f[n.h.b.UNARY_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError e36) {
            }
            int[] iArr8 = new int[com.google.firebase.firestore.local.a.values().length];
            e = iArr8;
            try {
                iArr8[com.google.firebase.firestore.local.a.LISTEN.ordinal()] = 1;
            } catch (NoSuchFieldError e37) {
            }
            try {
                e[com.google.firebase.firestore.local.a.EXISTENCE_FILTER_MISMATCH.ordinal()] = 2;
            } catch (NoSuchFieldError e38) {
            }
            try {
                e[com.google.firebase.firestore.local.a.LIMBO_RESOLUTION.ordinal()] = 3;
            } catch (NoSuchFieldError e39) {
            }
            int[] iArr9 = new int[h.c.C0030c.values().length];
            d = iArr9;
            try {
                iArr9[h.c.C0030c.SET_TO_SERVER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e40) {
            }
            try {
                d[h.c.C0030c.APPEND_MISSING_ELEMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError e41) {
            }
            try {
                d[h.c.C0030c.REMOVE_ALL_FROM_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e42) {
            }
            try {
                d[h.c.C0030c.INCREMENT.ordinal()] = 4;
            } catch (NoSuchFieldError e43) {
            }
            int[] iArr10 = new int[m.c.values().length];
            c = iArr10;
            try {
                iArr10[m.c.UPDATE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError e44) {
            }
            try {
                c[m.c.EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError e45) {
            }
            try {
                c[m.c.CONDITIONTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e46) {
            }
            int[] iArr11 = new int[r.c.values().length];
            b = iArr11;
            try {
                iArr11[r.c.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError e47) {
            }
            try {
                b[r.c.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError e48) {
            }
            try {
                b[r.c.TRANSFORM.ordinal()] = 3;
            } catch (NoSuchFieldError e49) {
            }
            try {
                b[r.c.VERIFY.ordinal()] = 4;
            } catch (NoSuchFieldError e50) {
            }
            int[] iArr12 = new int[q.c.values().length];
            a = iArr12;
            try {
                iArr12[q.c.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e51) {
            }
            try {
                a[q.c.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e52) {
            }
            try {
                a[q.c.INTEGER_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError e53) {
            }
            try {
                a[q.c.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e54) {
            }
            try {
                a[q.c.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError e55) {
            }
            try {
                a[q.c.GEO_POINT_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError e56) {
            }
            try {
                a[q.c.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError e57) {
            }
            try {
                a[q.c.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError e58) {
            }
            try {
                a[q.c.STRING_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError e59) {
            }
            try {
                a[q.c.ARRAY_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError e60) {
            }
            try {
                a[q.c.MAP_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError e61) {
            }
        }
    }

    public h0 A(k protoChange) {
        h0.e changeType;
        switch (a.l[protoChange.Q().ordinal()]) {
            case 1:
                p targetChange = protoChange.R();
                io.grpc.p cause = null;
                switch (a.k[targetChange.P().ordinal()]) {
                    case 1:
                        changeType = h0.e.NoChange;
                        break;
                    case 2:
                        changeType = h0.e.Added;
                        break;
                    case 3:
                        changeType = h0.e.Removed;
                        cause = d0(targetChange.L());
                        break;
                    case 4:
                        changeType = h0.e.Current;
                        break;
                    case 5:
                        changeType = h0.e.Reset;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown target change type");
                }
                return new h0.d(changeType, targetChange.R(), targetChange.O(), cause);
            case 2:
                d docChange = protoChange.M();
                List<Integer> added = docChange.O();
                List<Integer> removed = docChange.N();
                mh key = m(docChange.M().S());
                hm0 version = y(docChange.M().T());
                n4.d(!version.equals(hm0.a), "Got a document change without an update time", new Object[0]);
                com.google.firebase.firestore.model.b bVar = new com.google.firebase.firestore.model.b(key, version, b.a.SYNCED, docChange.M(), z.a(this));
                return new h0.b(added, removed, bVar.a(), bVar);
            case 3:
                e docDelete = protoChange.N();
                List<Integer> removed2 = docDelete.O();
                com.google.firebase.firestore.model.d doc = new com.google.firebase.firestore.model.d(m(docDelete.M()), y(docDelete.N()), false);
                return new h0.b(Collections.emptyList(), removed2, doc.a(), doc);
            case 4:
                com.google.firestore.v1.g docRemove = protoChange.O();
                return new h0.b(Collections.emptyList(), docRemove.O(), m(docRemove.M()), (com.google.firebase.firestore.model.c) null);
            case 5:
                i protoFilter = protoChange.P();
                return new h0.c(protoFilter.N(), new yj(protoFilter.L()));
            default:
                throw new IllegalArgumentException("Unknown change type set");
        }
    }

    public hm0 z(k watchChange) {
        if (watchChange.Q() != k.c.TARGET_CHANGE) {
            return hm0.a;
        }
        if (watchChange.R().Q() != 0) {
            return hm0.a;
        }
        return y(watchChange.R().N());
    }

    private io.grpc.p d0(en0 status) {
        return io.grpc.p.h(status.L()).q(status.N());
    }
}
