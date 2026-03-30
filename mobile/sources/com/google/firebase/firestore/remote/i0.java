package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.core.b0;
import com.google.firebase.firestore.core.d;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.c;
import com.google.firebase.firestore.model.d;
import com.google.firebase.firestore.remote.h0;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class i0 {
    private final b a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<Integer, g0> f2346a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private Set<Integer> f2347a = new HashSet();
    private Map<mh, c> b = new HashMap();
    private Map<mh, Set<Integer>> c = new HashMap();

    public interface b {
        bq0 a(int i);

        e<mh> b(int i);
    }

    public i0(b targetMetadataProvider) {
        this.a = targetMetadataProvider;
    }

    public void g(h0.b documentChange) {
        c document = documentChange.b();
        mh documentKey = documentChange.a();
        for (Integer intValue : documentChange.d()) {
            int targetId = intValue.intValue();
            if (document instanceof com.google.firebase.firestore.model.b) {
                a(targetId, document);
            } else if (document instanceof d) {
                m(targetId, documentKey, document);
            }
        }
        for (Integer intValue2 : documentChange.c()) {
            m(intValue2.intValue(), documentKey, documentChange.b());
        }
    }

    public void i(h0.d targetChange) {
        for (Integer intValue : f(targetChange)) {
            int targetId = intValue.intValue();
            g0 targetState = d(targetId);
            boolean z = true;
            switch (a.a[targetChange.b().ordinal()]) {
                case 1:
                    if (!j(targetId)) {
                        break;
                    } else {
                        targetState.k(targetChange.c());
                        break;
                    }
                case 2:
                    targetState.h();
                    if (!targetState.e()) {
                        targetState.b();
                    }
                    targetState.k(targetChange.c());
                    break;
                case 3:
                    targetState.h();
                    if (!targetState.e()) {
                        n(targetId);
                    }
                    if (targetChange.a() != null) {
                        z = false;
                    }
                    n4.d(z, "WatchChangeAggregator does not handle errored targets", new Object[0]);
                    break;
                case 4:
                    if (!j(targetId)) {
                        break;
                    } else {
                        targetState.f();
                        targetState.k(targetChange.c());
                        break;
                    }
                case 5:
                    if (!j(targetId)) {
                        break;
                    } else {
                        o(targetId);
                        targetState.k(targetChange.c());
                        break;
                    }
                default:
                    throw n4.a("Unknown target watch change state: %s", targetChange.b());
            }
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h0.e.values().length];
            a = iArr;
            try {
                iArr[h0.e.NoChange.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[h0.e.Added.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[h0.e.Removed.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[h0.e.Current.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[h0.e.Reset.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private Collection<Integer> f(h0.d targetChange) {
        List<Integer> targetIds = targetChange.d();
        if (!targetIds.isEmpty()) {
            return targetIds;
        }
        return this.f2346a.keySet();
    }

    public void h(h0.c watchChange) {
        int targetId = watchChange.b();
        int expectedCount = watchChange.a().a();
        bq0 targetData = k(targetId);
        if (targetData != null) {
            b0 target = targetData.f();
            if (target.j()) {
                if (expectedCount == 0) {
                    mh key = mh.e(target.g());
                    m(targetId, key, new d(key, hm0.a, false));
                    return;
                }
                n4.d(expectedCount == 1, "Single document existence filter with count: %d", Integer.valueOf(expectedCount));
            } else if (((long) e(targetId)) != ((long) expectedCount)) {
                o(targetId);
                this.f2347a.add(Integer.valueOf(targetId));
            }
        }
    }

    public ee0 b(hm0 snapshotVersion) {
        Map<Integer, TargetChange> targetChanges = new HashMap<>();
        for (Map.Entry<Integer, TargetState> entry : this.f2346a.entrySet()) {
            int targetId = entry.getKey().intValue();
            g0 targetState = (g0) entry.getValue();
            bq0 targetData = k(targetId);
            if (targetData != null) {
                if (targetState.d() && targetData.f().j()) {
                    mh key = mh.e(targetData.f().g());
                    if (this.b.get(key) == null && !p(targetId, key)) {
                        m(targetId, key, new d(key, snapshotVersion, false));
                    }
                }
                if (targetState.c()) {
                    targetChanges.put(Integer.valueOf(targetId), targetState.j());
                    targetState.b();
                }
            }
        }
        Set<DocumentKey> resolvedLimboDocuments = new HashSet<>();
        for (Map.Entry<DocumentKey, Set<Integer>> entry2 : this.c.entrySet()) {
            mh key2 = (mh) entry2.getKey();
            boolean isOnlyLimboTarget = true;
            Iterator<Integer> it = entry2.getValue().iterator();
            while (true) {
                if (it.hasNext()) {
                    bq0 targetData2 = k(it.next().intValue());
                    if (targetData2 != null && !targetData2.b().equals(com.google.firebase.firestore.local.a.LIMBO_RESOLUTION)) {
                        isOnlyLimboTarget = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (isOnlyLimboTarget) {
                resolvedLimboDocuments.add(key2);
            }
        }
        ee0 ee0 = new ee0(snapshotVersion, Collections.unmodifiableMap(targetChanges), Collections.unmodifiableSet(this.f2347a), Collections.unmodifiableMap(this.b), Collections.unmodifiableSet(resolvedLimboDocuments));
        this.b = new HashMap();
        this.c = new HashMap();
        this.f2347a = new HashSet();
        return ee0;
    }

    private void a(int targetId, c document) {
        d.a changeType;
        if (j(targetId)) {
            if (p(targetId, document.a())) {
                changeType = d.a.MODIFIED;
            } else {
                changeType = d.a.ADDED;
            }
            d(targetId).a(document.a(), changeType);
            this.b.put(document.a(), document);
            c(document.a()).add(Integer.valueOf(targetId));
        }
    }

    private void m(int targetId, mh key, c updatedDocument) {
        if (j(targetId)) {
            g0 targetState = d(targetId);
            if (p(targetId, key)) {
                targetState.a(key, d.a.REMOVED);
            } else {
                targetState.i(key);
            }
            c(key).add(Integer.valueOf(targetId));
            if (updatedDocument != null) {
                this.b.put(key, updatedDocument);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n(int targetId) {
        this.f2346a.remove(Integer.valueOf(targetId));
    }

    private int e(int targetId) {
        aq0 targetChange = d(targetId).j();
        return (this.a.b(targetId).size() + targetChange.b().size()) - targetChange.d().size();
    }

    /* access modifiers changed from: package-private */
    public void l(int targetId) {
        d(targetId).g();
    }

    private g0 d(int targetId) {
        g0 targetState = this.f2346a.get(Integer.valueOf(targetId));
        if (targetState != null) {
            return targetState;
        }
        g0 targetState2 = new g0();
        this.f2346a.put(Integer.valueOf(targetId), targetState2);
        return targetState2;
    }

    private Set<Integer> c(mh key) {
        Set<Integer> targetMapping = this.c.get(key);
        if (targetMapping != null) {
            return targetMapping;
        }
        Set<Integer> targetMapping2 = new HashSet<>();
        this.c.put(key, targetMapping2);
        return targetMapping2;
    }

    private boolean j(int targetId) {
        return k(targetId) != null;
    }

    private bq0 k(int targetId) {
        g0 targetState = this.f2346a.get(Integer.valueOf(targetId));
        if (targetState == null || !targetState.e()) {
            return this.a.a(targetId);
        }
        return null;
    }

    private void o(int targetId) {
        n4.d(this.f2346a.get(Integer.valueOf(targetId)) != null && !this.f2346a.get(Integer.valueOf(targetId)).e(), "Should only reset active targets", new Object[0]);
        this.f2346a.put(Integer.valueOf(targetId), new g0());
        Iterator<mh> it = this.a.b(targetId).iterator();
        while (it.hasNext()) {
            m(targetId, it.next(), (c) null);
        }
    }

    private boolean p(int targetId, mh key) {
        return this.a.b(targetId).contains(key);
    }
}
