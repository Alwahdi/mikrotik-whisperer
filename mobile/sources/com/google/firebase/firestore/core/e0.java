package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.core.d;
import com.google.firebase.firestore.core.f0;
import com.google.firebase.firestore.core.u;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class e0 {
    private e<mh> a;

    /* renamed from: a  reason: collision with other field name */
    private f0.a f2194a = f0.a.NONE;

    /* renamed from: a  reason: collision with other field name */
    private final x f2195a;

    /* renamed from: a  reason: collision with other field name */
    private rh f2196a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2197a;
    private e<mh> b;
    private e<mh> c;

    public static class b {
        final e<mh> a;

        /* renamed from: a  reason: collision with other field name */
        final e f2198a;

        /* renamed from: a  reason: collision with other field name */
        final rh f2199a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final boolean f2200a;

        /* synthetic */ b(rh x0, e x1, e x2, boolean x3, a x4) {
            this(x0, x1, x2, x3);
        }

        private b(rh newDocuments, e changes, e<mh> mutatedKeys, boolean needsRefill) {
            this.f2199a = newDocuments;
            this.f2198a = changes;
            this.a = mutatedKeys;
            this.f2200a = needsRefill;
        }

        public boolean b() {
            return this.f2200a;
        }
    }

    public e0(x query, e<mh> remoteDocuments) {
        this.f2195a = query;
        this.f2196a = rh.b(query.c());
        this.a = remoteDocuments;
        this.b = mh.d();
        this.c = mh.d();
    }

    public f0.a i() {
        return this.f2194a;
    }

    public <D extends c> b f(com.google.firebase.database.collection.c<mh, D> docChanges) {
        return g(docChanges, (b) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0121, code lost:
        if (r0.f2195a.c().compare(r15, r10) <= 0) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0132, code lost:
        if (r0.f2195a.c().compare(r15, r11) < 0) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0134, code lost:
        r12 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <D extends com.google.firebase.firestore.model.c> com.google.firebase.firestore.core.e0.b g(com.google.firebase.database.collection.c<defpackage.mh, D> r22, com.google.firebase.firestore.core.e0.b r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            if (r1 == 0) goto L_0x0009
            com.google.firebase.firestore.core.e r2 = r1.f2198a
            goto L_0x000e
        L_0x0009:
            com.google.firebase.firestore.core.e r2 = new com.google.firebase.firestore.core.e
            r2.<init>()
        L_0x000e:
            if (r1 == 0) goto L_0x0013
            rh r3 = r1.f2199a
            goto L_0x0015
        L_0x0013:
            rh r3 = r0.f2196a
        L_0x0015:
            r9 = r3
            if (r1 == 0) goto L_0x001b
            com.google.firebase.database.collection.e<mh> r3 = r1.a
            goto L_0x001d
        L_0x001b:
            com.google.firebase.database.collection.e<mh> r3 = r0.c
        L_0x001d:
            r4 = r9
            r5 = 0
            com.google.firebase.firestore.core.x r6 = r0.f2195a
            boolean r6 = r6.o()
            r7 = 0
            if (r6 == 0) goto L_0x003c
            int r6 = r9.size()
            long r10 = (long) r6
            com.google.firebase.firestore.core.x r6 = r0.f2195a
            long r12 = r6.i()
            int r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r6 != 0) goto L_0x003c
            com.google.firebase.firestore.model.b r6 = r9.f()
            goto L_0x003d
        L_0x003c:
            r6 = r7
        L_0x003d:
            r10 = r6
            com.google.firebase.firestore.core.x r6 = r0.f2195a
            boolean r6 = r6.p()
            if (r6 == 0) goto L_0x005a
            int r6 = r9.size()
            long r11 = (long) r6
            com.google.firebase.firestore.core.x r6 = r0.f2195a
            long r13 = r6.j()
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 != 0) goto L_0x005a
            com.google.firebase.firestore.model.b r7 = r9.d()
            goto L_0x005b
        L_0x005a:
        L_0x005b:
            r11 = r7
            java.util.Iterator r6 = r22.iterator()
            r12 = r5
        L_0x0061:
            boolean r5 = r6.hasNext()
            if (r5 == 0) goto L_0x01a2
            java.lang.Object r5 = r6.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r13 = r5.getKey()
            mh r13 = (defpackage.mh) r13
            com.google.firebase.firestore.model.b r14 = r9.c(r13)
            r15 = 0
            java.lang.Object r16 = r5.getValue()
            r7 = r16
            com.google.firebase.firestore.model.c r7 = (com.google.firebase.firestore.model.c) r7
            boolean r8 = r7 instanceof com.google.firebase.firestore.model.b
            if (r8 == 0) goto L_0x0087
            r15 = r7
            com.google.firebase.firestore.model.b r15 = (com.google.firebase.firestore.model.b) r15
        L_0x0087:
            if (r15 == 0) goto L_0x00b4
            mh r8 = r15.a()
            boolean r8 = r13.equals(r8)
            r18 = r5
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r16 = 0
            r5[r16] = r13
            mh r19 = r15.a()
            r17 = 1
            r5[r17] = r19
            r19 = r6
            java.lang.String r6 = "Mismatching key in doc change %s != %s"
            defpackage.n4.d(r8, r6, r5)
            com.google.firebase.firestore.core.x r5 = r0.f2195a
            boolean r5 = r5.t(r15)
            if (r5 != 0) goto L_0x00ba
            r15 = 0
            goto L_0x00ba
        L_0x00b4:
            r18 = r5
            r19 = r6
            r17 = 1
        L_0x00ba:
            if (r14 == 0) goto L_0x00ca
            com.google.firebase.database.collection.e<mh> r5 = r0.c
            mh r6 = r14.a()
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L_0x00ca
            r5 = 1
            goto L_0x00cb
        L_0x00ca:
            r5 = 0
        L_0x00cb:
            if (r15 == 0) goto L_0x00e8
            boolean r6 = r15.h()
            if (r6 != 0) goto L_0x00e5
            com.google.firebase.database.collection.e<mh> r6 = r0.c
            mh r8 = r15.a()
            boolean r6 = r6.contains(r8)
            if (r6 == 0) goto L_0x00e8
            boolean r6 = r15.g()
            if (r6 == 0) goto L_0x00e8
        L_0x00e5:
            r16 = 1
            goto L_0x00ea
        L_0x00e8:
            r16 = 0
        L_0x00ea:
            r6 = r16
            r8 = 0
            if (r14 == 0) goto L_0x014c
            if (r15 == 0) goto L_0x014c
            r20 = r7
            c40 r7 = r14.d()
            r16 = r8
            c40 r8 = r15.d()
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0139
            boolean r8 = r0.m(r14, r15)
            if (r8 != 0) goto L_0x0136
            com.google.firebase.firestore.core.d$a r8 = com.google.firebase.firestore.core.d.a.MODIFIED
            com.google.firebase.firestore.core.d r8 = com.google.firebase.firestore.core.d.a(r8, r15)
            r2.a(r8)
            r8 = 1
            if (r10 == 0) goto L_0x0124
            r17 = r7
            com.google.firebase.firestore.core.x r7 = r0.f2195a
            java.util.Comparator r7 = r7.c()
            int r7 = r7.compare(r15, r10)
            if (r7 > 0) goto L_0x0134
            goto L_0x0126
        L_0x0124:
            r17 = r7
        L_0x0126:
            if (r11 == 0) goto L_0x014b
            com.google.firebase.firestore.core.x r7 = r0.f2195a
            java.util.Comparator r7 = r7.c()
            int r7 = r7.compare(r15, r11)
            if (r7 >= 0) goto L_0x014b
        L_0x0134:
            r12 = 1
            goto L_0x014b
        L_0x0136:
            r17 = r7
            goto L_0x0149
        L_0x0139:
            r17 = r7
            if (r5 == r6) goto L_0x0149
            com.google.firebase.firestore.core.d$a r7 = com.google.firebase.firestore.core.d.a.METADATA
            com.google.firebase.firestore.core.d r7 = com.google.firebase.firestore.core.d.a(r7, r15)
            r2.a(r7)
            r7 = 1
            r8 = r7
            goto L_0x014b
        L_0x0149:
            r8 = r16
        L_0x014b:
            goto L_0x0176
        L_0x014c:
            r20 = r7
            r16 = r8
            if (r14 != 0) goto L_0x015f
            if (r15 == 0) goto L_0x015f
            com.google.firebase.firestore.core.d$a r7 = com.google.firebase.firestore.core.d.a.ADDED
            com.google.firebase.firestore.core.d r7 = com.google.firebase.firestore.core.d.a(r7, r15)
            r2.a(r7)
            r8 = 1
            goto L_0x0176
        L_0x015f:
            if (r14 == 0) goto L_0x0174
            if (r15 != 0) goto L_0x0174
            com.google.firebase.firestore.core.d$a r7 = com.google.firebase.firestore.core.d.a.REMOVED
            com.google.firebase.firestore.core.d r7 = com.google.firebase.firestore.core.d.a(r7, r14)
            r2.a(r7)
            r8 = 1
            if (r10 != 0) goto L_0x0171
            if (r11 == 0) goto L_0x0176
        L_0x0171:
            r7 = 1
            r12 = r7
            goto L_0x0176
        L_0x0174:
            r8 = r16
        L_0x0176:
            if (r8 == 0) goto L_0x019e
            if (r15 == 0) goto L_0x0196
            rh r4 = r4.a(r15)
            boolean r7 = r15.h()
            if (r7 == 0) goto L_0x018d
            mh r7 = r15.a()
            com.google.firebase.database.collection.e r3 = r3.c(r7)
            goto L_0x019e
        L_0x018d:
            mh r7 = r15.a()
            com.google.firebase.database.collection.e r3 = r3.f(r7)
            goto L_0x019e
        L_0x0196:
            rh r4 = r4.h(r13)
            com.google.firebase.database.collection.e r3 = r3.f(r13)
        L_0x019e:
            r6 = r19
            goto L_0x0061
        L_0x01a2:
            r17 = 1
            com.google.firebase.firestore.core.x r5 = r0.f2195a
            boolean r5 = r5.o()
            if (r5 != 0) goto L_0x01b8
            com.google.firebase.firestore.core.x r5 = r0.f2195a
            boolean r5 = r5.p()
            if (r5 == 0) goto L_0x01b5
            goto L_0x01b8
        L_0x01b5:
            r13 = r3
            r14 = r4
            goto L_0x020a
        L_0x01b8:
            com.google.firebase.firestore.core.x r5 = r0.f2195a
            boolean r5 = r5.o()
            if (r5 == 0) goto L_0x01c7
            com.google.firebase.firestore.core.x r5 = r0.f2195a
            long r5 = r5.i()
            goto L_0x01cd
        L_0x01c7:
            com.google.firebase.firestore.core.x r5 = r0.f2195a
            long r5 = r5.j()
        L_0x01cd:
            int r7 = r4.size()
            long r7 = (long) r7
            long r7 = r7 - r5
        L_0x01d3:
            r13 = 0
            int r15 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x0208
            com.google.firebase.firestore.core.x r13 = r0.f2195a
            boolean r13 = r13.o()
            if (r13 == 0) goto L_0x01e6
            com.google.firebase.firestore.model.b r13 = r4.f()
            goto L_0x01ea
        L_0x01e6:
            com.google.firebase.firestore.model.b r13 = r4.d()
        L_0x01ea:
            mh r14 = r13.a()
            rh r4 = r4.h(r14)
            mh r14 = r13.a()
            com.google.firebase.database.collection.e r3 = r3.f(r14)
            com.google.firebase.firestore.core.d$a r14 = com.google.firebase.firestore.core.d.a.REMOVED
            com.google.firebase.firestore.core.d r14 = com.google.firebase.firestore.core.d.a(r14, r13)
            r2.a(r14)
            r13 = 1
            long r7 = r7 - r13
            goto L_0x01d3
        L_0x0208:
            r13 = r3
            r14 = r4
        L_0x020a:
            if (r12 == 0) goto L_0x0211
            if (r1 != 0) goto L_0x020f
            goto L_0x0211
        L_0x020f:
            r7 = 0
            goto L_0x0212
        L_0x0211:
            r7 = 1
        L_0x0212:
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "View was refilled using docs that themselves needed refilling."
            defpackage.n4.d(r7, r4, r3)
            com.google.firebase.firestore.core.e0$b r15 = new com.google.firebase.firestore.core.e0$b
            r8 = 0
            r3 = r15
            r4 = r14
            r5 = r2
            r6 = r13
            r7 = r12
            r3.<init>(r4, r5, r6, r7, r8)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.core.e0.g(com.google.firebase.database.collection.c, com.google.firebase.firestore.core.e0$b):com.google.firebase.firestore.core.e0$b");
    }

    private boolean m(com.google.firebase.firestore.model.b oldDoc, com.google.firebase.firestore.model.b newDoc) {
        return oldDoc.h() && newDoc.g() && !newDoc.h();
    }

    public cv0 a(b docChanges) {
        return b(docChanges, (aq0) null);
    }

    public cv0 b(b docChanges, aq0 targetChange) {
        f0 snapshot;
        List<u> list;
        b bVar = docChanges;
        n4.d(!docChanges.f2200a, "Cannot apply changes that need a refill", new Object[0]);
        rh oldDocumentSet = this.f2196a;
        this.f2196a = bVar.f2199a;
        this.c = bVar.a;
        List<d> b2 = bVar.f2198a.b();
        Collections.sort(b2, d0.a(this));
        d(targetChange);
        List<u> n = n();
        f0.a newSyncState = this.b.size() == 0 && this.f2197a ? f0.a.SYNCED : f0.a.LOCAL;
        boolean syncStatedChanged = newSyncState != this.f2194a;
        this.f2194a = newSyncState;
        if (b2.size() != 0 || syncStatedChanged) {
            f0.a aVar = newSyncState;
            list = n;
            snapshot = new f0(this.f2195a, bVar.f2199a, oldDocumentSet, b2, newSyncState == f0.a.LOCAL, bVar.a, syncStatedChanged, false);
        } else {
            f0.a aVar2 = newSyncState;
            list = n;
            snapshot = null;
        }
        return new cv0(snapshot, list);
    }

    static /* synthetic */ int k(e0 e0Var, d o1, d o2) {
        int typeComp = qu0.d(e(o1), e(o2));
        o1.c().compareTo(o2.c());
        if (typeComp != 0) {
            return typeComp;
        }
        return e0Var.f2195a.c().compare(o1.b(), o2.b());
    }

    public cv0 c(v onlineState) {
        if (!this.f2197a || onlineState != v.OFFLINE) {
            return new cv0((f0) null, Collections.emptyList());
        }
        this.f2197a = false;
        return a(new b(this.f2196a, new e(), this.c, false, (a) null));
    }

    private void d(aq0 targetChange) {
        if (targetChange != null) {
            Iterator<mh> it = targetChange.b().iterator();
            while (it.hasNext()) {
                this.a = this.a.c(it.next());
            }
            Iterator<mh> it2 = targetChange.c().iterator();
            while (it2.hasNext()) {
                mh documentKey = it2.next();
                n4.d(this.a.contains(documentKey), "Modified document %s not found in view.", documentKey);
            }
            Iterator<mh> it3 = targetChange.d().iterator();
            while (it3.hasNext()) {
                this.a = this.a.f(it3.next());
            }
            this.f2197a = targetChange.f();
        }
    }

    private List<u> n() {
        if (!this.f2197a) {
            return Collections.emptyList();
        }
        ImmutableSortedSet<DocumentKey> oldLimboDocs = this.b;
        this.b = mh.d();
        Iterator<com.google.firebase.firestore.model.b> it = this.f2196a.iterator();
        while (it.hasNext()) {
            com.google.firebase.firestore.model.b doc = it.next();
            if (l(doc.a())) {
                this.b = this.b.c(doc.a());
            }
        }
        List<LimboDocumentChange> changes = new ArrayList<>(oldLimboDocs.size() + this.b.size());
        Iterator<mh> it2 = oldLimboDocs.iterator();
        while (it2.hasNext()) {
            mh key = it2.next();
            if (!this.b.contains(key)) {
                changes.add(new u(u.a.REMOVED, key));
            }
        }
        Iterator<mh> it3 = this.b.iterator();
        while (it3.hasNext()) {
            mh key2 = it3.next();
            if (!oldLimboDocs.contains(key2)) {
                changes.add(new u(u.a.ADDED, key2));
            }
        }
        return changes;
    }

    private boolean l(mh key) {
        com.google.firebase.firestore.model.b doc;
        if (!this.a.contains(key) && (doc = this.f2196a.c(key)) != null && !doc.h()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public e<mh> h() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public e<mh> j() {
        return this.a;
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.a.values().length];
            a = iArr;
            try {
                iArr[d.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[d.a.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[d.a.METADATA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[d.a.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static int e(d change) {
        switch (a.a[change.c().ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 2;
            case 4:
                return 0;
            default:
                throw new IllegalArgumentException("Unknown change type: " + change.c());
        }
    }
}
