package defpackage;

import android.util.SparseArray;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.database.collection.c;
import com.google.firebase.firestore.core.b0;
import com.google.firebase.firestore.core.x;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.d;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.i;
import com.google.protobuf.e;
import defpackage.iz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: ky  reason: default package */
public final class ky {
    private static final long a = TimeUnit.MINUTES.toSeconds(5);

    /* renamed from: a  reason: collision with other field name */
    private final SparseArray<bq0> f4174a = new SparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    private final c90 f4175a;

    /* renamed from: a  reason: collision with other field name */
    private final cq0 f4176a;

    /* renamed from: a  reason: collision with other field name */
    private final de0 f4177a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<b0, Integer> f4178a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private tb0 f4179a;

    /* renamed from: a  reason: collision with other field name */
    private final vd0 f4180a;

    /* renamed from: a  reason: collision with other field name */
    private x20 f4181a;

    /* renamed from: a  reason: collision with other field name */
    private xx f4182a;

    /* renamed from: a  reason: collision with other field name */
    private final zp0 f4183a;

    public ky(c90 persistence, tb0 queryEngine, yt0 initialUser) {
        n4.d(persistence.f(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
        this.f4175a = persistence;
        zp0 e = persistence.e();
        this.f4183a = e;
        this.f4176a = cq0.b(e.d());
        this.f4181a = persistence.b(initialUser);
        de0 d = persistence.d();
        this.f4177a = d;
        xx xxVar = new xx(d, this.f4181a, persistence.a());
        this.f4182a = xxVar;
        this.f4179a = queryEngine;
        queryEngine.b(xxVar);
        vd0 vd0 = new vd0();
        this.f4180a = vd0;
        persistence.c().j(vd0);
    }

    public void B() {
        C();
    }

    private void C() {
        this.f4175a.h("Start MutationQueue", by.a(this));
    }

    public c<mh, com.google.firebase.firestore.model.c> k(yt0 user) {
        List<v20> e = this.f4181a.e();
        this.f4181a = this.f4175a.b(user);
        C();
        List<v20> e2 = this.f4181a.e();
        xx xxVar = new xx(this.f4177a, this.f4181a, this.f4175a.a());
        this.f4182a = xxVar;
        this.f4179a.b(xxVar);
        ImmutableSortedSet<DocumentKey> changedKeys = mh.d();
        for (List<MutationBatch> batches : Arrays.asList(new List[]{e, e2})) {
            Iterator<MutationBatch> it = batches.iterator();
            while (it.hasNext()) {
                for (u20 mutation : ((v20) it.next()).h()) {
                    changedKeys = changedKeys.c(mutation.d());
                }
            }
        }
        return this.f4182a.e(changedKeys);
    }

    public my D(List<u20> mutations) {
        pr0 localWriteTime = pr0.q();
        Set<DocumentKey> keys = new HashSet<>();
        for (u20 mutation : mutations) {
            keys.add(mutation.d());
        }
        return (my) this.f4175a.g("Locally write mutations", cy.a(this, keys, mutations, localWriteTime));
    }

    static /* synthetic */ my u(ky kyVar, Set keys, List mutations, pr0 localWriteTime) {
        ImmutableSortedMap<DocumentKey, MaybeDocument> existingDocuments = kyVar.f4182a.e(keys);
        List<Mutation> baseMutations = new ArrayList<>();
        Iterator it = mutations.iterator();
        while (it.hasNext()) {
            u20 mutation = (u20) it.next();
            c40 baseValue = mutation.c(existingDocuments.b(mutation.d()));
            if (baseValue != null) {
                baseMutations.add(new o50(mutation.d(), baseValue, baseValue.k(), u90.a(true)));
            }
        }
        v20 batch = kyVar.f4181a.c(localWriteTime, baseMutations, mutations);
        return new my(batch.e(), batch.a(existingDocuments));
    }

    public c<mh, com.google.firebase.firestore.model.c> a(w20 batchResult) {
        return (c) this.f4175a.g("Acknowledge batch", dy.a(this, batchResult));
    }

    static /* synthetic */ c l(ky kyVar, w20 batchResult) {
        v20 batch = batchResult.b();
        kyVar.f4181a.l(batch, batchResult.f());
        kyVar.d(batchResult);
        kyVar.f4181a.a();
        return kyVar.f4182a.e(batch.f());
    }

    public c<mh, com.google.firebase.firestore.model.c> x(int batchId) {
        return (c) this.f4175a.g("Reject batch", ey.a(this, batchId));
    }

    static /* synthetic */ c q(ky kyVar, int batchId) {
        v20 toReject = kyVar.f4181a.k(batchId);
        n4.d(toReject != null, "Attempt to reject nonexistent batch!", new Object[0]);
        kyVar.f4181a.g(toReject);
        kyVar.f4181a.a();
        return kyVar.f4182a.e(toReject.f());
    }

    public e h() {
        return this.f4181a.b();
    }

    public void z(e streamToken) {
        this.f4175a.h("Set stream token", fy.a(this, streamToken));
    }

    public hm0 g() {
        return this.f4183a.c();
    }

    public c<mh, com.google.firebase.firestore.model.c> c(ee0 remoteEvent) {
        return (c) this.f4175a.g("Apply remote event", gy.a(this, remoteEvent, remoteEvent.c()));
    }

    static /* synthetic */ c n(ky kyVar, ee0 remoteEvent, hm0 remoteVersion) {
        ky kyVar2 = kyVar;
        hm0 hm0 = remoteVersion;
        Map<Integer, aq0> d = remoteEvent.d();
        long sequenceNumber = kyVar2.f4175a.c().b();
        for (Map.Entry<Integer, TargetChange> entry : d.entrySet()) {
            int targetId = entry.getKey().intValue();
            aq0 change = (aq0) entry.getValue();
            bq0 oldTargetData = kyVar2.f4174a.get(targetId);
            if (oldTargetData != null) {
                kyVar2.f4183a.e(change.d(), targetId);
                kyVar2.f4183a.b(change.b(), targetId);
                e resumeToken = change.e();
                if (!resumeToken.isEmpty()) {
                    bq0 newTargetData = oldTargetData.i(resumeToken, remoteEvent.c()).j(sequenceNumber);
                    kyVar2.f4174a.put(targetId, newTargetData);
                    if (A(oldTargetData, newTargetData, change)) {
                        kyVar2.f4183a.a(newTargetData);
                    }
                }
            }
        }
        Map<DocumentKey, MaybeDocument> changedDocs = new HashMap<>();
        Map<mh, com.google.firebase.firestore.model.c> a2 = remoteEvent.a();
        Set<mh> b2 = remoteEvent.b();
        Map<mh, com.google.firebase.firestore.model.c> e = kyVar2.f4177a.e(a2.keySet());
        for (Map.Entry<DocumentKey, MaybeDocument> entry2 : a2.entrySet()) {
            mh key = (mh) entry2.getKey();
            com.google.firebase.firestore.model.c doc = (com.google.firebase.firestore.model.c) entry2.getValue();
            com.google.firebase.firestore.model.c existingDoc = e.get(key);
            if ((doc instanceof d) && doc.b().equals(hm0.a)) {
                kyVar2.f4177a.c(doc.a());
                changedDocs.put(key, doc);
            } else if (existingDoc == null || doc.b().compareTo(existingDoc.b()) > 0 || (doc.b().compareTo(existingDoc.b()) == 0 && existingDoc.c())) {
                n4.d(!hm0.a.equals(remoteEvent.c()), "Cannot add a document when the remote version is zero", new Object[0]);
                kyVar2.f4177a.b(doc, remoteEvent.c());
                changedDocs.put(key, doc);
            } else {
                i.a("LocalStore", "Ignoring outdated watch update for %s.Current version: %s  Watch version: %s", key, existingDoc.b(), doc.b());
            }
            if (b2.contains(key)) {
                kyVar2.f4175a.c().m(key);
            }
        }
        hm0 lastRemoteVersion = kyVar2.f4183a.c();
        if (!hm0.equals(hm0.a)) {
            n4.d(hm0.compareTo(lastRemoteVersion) >= 0, "Watch stream reverted to previous snapshot?? (%s < %s)", hm0, lastRemoteVersion);
            kyVar2.f4183a.i(hm0);
        }
        return kyVar2.f4182a.j(changedDocs);
    }

    private static boolean A(bq0 oldTargetData, bq0 newTargetData, aq0 change) {
        n4.d(!newTargetData.c().isEmpty(), "Attempted to persist query data with empty resume token", new Object[0]);
        if (!oldTargetData.c().isEmpty() && newTargetData.e().b().p() - oldTargetData.e().b().p() < a && change.b().size() + change.c().size() + change.d().size() <= 0) {
            return false;
        }
        return true;
    }

    public void v(List<ly> viewChanges) {
        this.f4175a.h("notifyLocalViewChanges", hy.a(this, viewChanges));
    }

    static /* synthetic */ void p(ky kyVar, List viewChanges) {
        Iterator it = viewChanges.iterator();
        while (it.hasNext()) {
            ly viewChange = (ly) it.next();
            int targetId = viewChange.d();
            kyVar.f4180a.b(viewChange.b(), targetId);
            ImmutableSortedSet<DocumentKey> removed = viewChange.c();
            Iterator<mh> it2 = removed.iterator();
            while (it2.hasNext()) {
                kyVar.f4175a.c().a(it2.next());
            }
            kyVar.f4180a.g(removed, targetId);
            if (!viewChange.e()) {
                bq0 targetData = kyVar.f4174a.get(targetId);
                n4.d(targetData != null, "Can't set limbo-free snapshot version for unknown target: %s", Integer.valueOf(targetId));
                kyVar.f4174a.put(targetId, targetData.h(targetData.e()));
            }
        }
    }

    public v20 i(int afterBatchId) {
        return this.f4181a.h(afterBatchId);
    }

    public com.google.firebase.firestore.model.c w(mh key) {
        return this.f4182a.c(key);
    }

    public bq0 b(b0 target) {
        int targetId;
        bq0 cached = this.f4183a.g(target);
        if (cached != null) {
            targetId = cached.g();
        } else {
            b holder = new b();
            this.f4175a.h("Allocate target", iy.a(this, holder, target));
            int targetId2 = holder.a;
            cached = holder.f4184a;
            targetId = targetId2;
        }
        if (this.f4174a.get(targetId) == null) {
            this.f4174a.put(targetId, cached);
            this.f4178a.put(target, Integer.valueOf(targetId));
        }
        return cached;
    }

    static /* synthetic */ void m(ky kyVar, b holder, b0 target) {
        int c = kyVar.f4176a.c();
        holder.a = c;
        bq0 bq0 = new bq0(target, c, kyVar.f4175a.c().b(), com.google.firebase.firestore.local.a.LISTEN);
        holder.f4184a = bq0;
        kyVar.f4183a.h(bq0);
    }

    /* access modifiers changed from: package-private */
    public bq0 j(b0 target) {
        Integer targetId = this.f4178a.get(target);
        if (targetId != null) {
            return this.f4174a.get(targetId.intValue());
        }
        return this.f4183a.g(target);
    }

    /* renamed from: ky$b */
    private static class b {
        int a;

        /* renamed from: a  reason: collision with other field name */
        bq0 f4184a;

        private b() {
        }
    }

    public void y(int targetId) {
        this.f4175a.h("Release target", jy.a(this, targetId));
    }

    static /* synthetic */ void r(ky kyVar, int targetId) {
        bq0 targetData = kyVar.f4174a.get(targetId);
        n4.d(targetData != null, "Tried to release nonexistent target: %s", Integer.valueOf(targetId));
        Iterator<mh> it = kyVar.f4180a.h(targetId).iterator();
        while (it.hasNext()) {
            kyVar.f4175a.c().a(it.next());
        }
        kyVar.f4175a.c().l(targetData);
        kyVar.f4174a.remove(targetId);
        kyVar.f4178a.remove(targetData.f());
    }

    public ub0 f(x query, boolean usePreviousResults) {
        bq0 targetData = j(query.z());
        hm0 lastLimboFreeSnapshotVersion = hm0.a;
        ImmutableSortedSet<DocumentKey> remoteKeys = mh.d();
        if (targetData != null) {
            lastLimboFreeSnapshotVersion = targetData.a();
            remoteKeys = this.f4183a.f(targetData.g());
        }
        return new ub0(this.f4179a.a(query, usePreviousResults ? lastLimboFreeSnapshotVersion : hm0.a, usePreviousResults ? remoteKeys : mh.d()), remoteKeys);
    }

    private void d(w20 batchResult) {
        v20 batch = batchResult.b();
        for (mh docKey : batch.f()) {
            com.google.firebase.firestore.model.c remoteDoc = this.f4177a.d(docKey);
            com.google.firebase.firestore.model.c doc = remoteDoc;
            hm0 ackVersion = batchResult.d().b(docKey);
            n4.d(ackVersion != null, "docVersions should contain every doc in the write.", new Object[0]);
            if (doc == null || doc.b().compareTo(ackVersion) < 0) {
                com.google.firebase.firestore.model.c doc2 = batch.c(docKey, doc, batchResult);
                if (doc2 == null) {
                    n4.d(remoteDoc == null, "Mutation batch %s applied to document %s resulted in null.", batch, remoteDoc);
                } else {
                    this.f4177a.b(doc2, batchResult.c());
                }
            }
        }
        this.f4181a.g(batch);
    }

    public iz.b e(iz garbageCollector) {
        return (iz.b) this.f4175a.g("Collect garbage", ay.a(this, garbageCollector));
    }
}
