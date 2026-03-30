package defpackage;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.local.DocumentReference;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.remote.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: a10  reason: default package */
final class a10 implements x20 {
    private int a = 1;

    /* renamed from: a  reason: collision with other field name */
    private final b10 f1a;

    /* renamed from: a  reason: collision with other field name */
    private e<ph> f2a = new e<>(Collections.emptyList(), ph.a);

    /* renamed from: a  reason: collision with other field name */
    private com.google.protobuf.e f3a = k0.b;

    /* renamed from: a  reason: collision with other field name */
    private final List<v20> f4a = new ArrayList();

    a10(b10 persistence) {
        this.f1a = persistence;
    }

    public void start() {
        if (p()) {
            this.a = 1;
        }
    }

    public boolean p() {
        return this.f4a.isEmpty();
    }

    public void l(v20 batch, com.google.protobuf.e streamToken) {
        int batchId = batch.e();
        int batchIndex = o(batchId, "acknowledged");
        n4.d(batchIndex == 0, "Can only acknowledge the first batch in the mutation queue", new Object[0]);
        v20 check = this.f4a.get(batchIndex);
        n4.d(batchId == check.e(), "Queue ordering failure: expected batch %d, got batch %d", Integer.valueOf(batchId), Integer.valueOf(check.e()));
        this.f3a = (com.google.protobuf.e) v90.n(streamToken);
    }

    public com.google.protobuf.e b() {
        return this.f3a;
    }

    public void f(com.google.protobuf.e streamToken) {
        this.f3a = (com.google.protobuf.e) v90.n(streamToken);
    }

    public v20 c(pr0 localWriteTime, List<u20> baseMutations, List<u20> mutations) {
        boolean z = true;
        n4.d(!mutations.isEmpty(), "Mutation batches should not be empty", new Object[0]);
        int batchId = this.a;
        this.a++;
        int size = this.f4a.size();
        if (size > 0) {
            if (this.f4a.get(size - 1).e() >= batchId) {
                z = false;
            }
            n4.d(z, "Mutation batchIds must be monotonically increasing order", new Object[0]);
        }
        v20 batch = new v20(batchId, localWriteTime, baseMutations, mutations);
        this.f4a.add(batch);
        for (u20 mutation : mutations) {
            this.f2a = this.f2a.c(new ph(mutation.d(), batchId));
            this.f1a.a().b((me0) mutation.d().h().q());
        }
        return batch;
    }

    public v20 k(int batchId) {
        int index = n(batchId);
        if (index < 0 || index >= this.f4a.size()) {
            return null;
        }
        v20 batch = this.f4a.get(index);
        n4.d(batch.e() == batchId, "If found batch must match", new Object[0]);
        return batch;
    }

    public v20 h(int batchId) {
        int rawIndex = n(batchId + 1);
        int index = rawIndex < 0 ? 0 : rawIndex;
        if (this.f4a.size() > index) {
            return this.f4a.get(index);
        }
        return null;
    }

    public List<v20> e() {
        return Collections.unmodifiableList(this.f4a);
    }

    public List<v20> j(mh documentKey) {
        ph start = new ph(documentKey, 0);
        List<MutationBatch> result = new ArrayList<>();
        Iterator<ph> d = this.f2a.d(start);
        while (d.hasNext()) {
            ph reference = d.next();
            if (!documentKey.equals(reference.b())) {
                break;
            }
            v20 batch = k(reference.a());
            n4.d(batch != null, "Batches in the index must exist in the main table", new Object[0]);
            result.add(batch);
        }
        return result;
    }

    public List<v20> d(Iterable<mh> documentKeys) {
        ImmutableSortedSet<Integer> uniqueBatchIDs = new e<>(Collections.emptyList(), qu0.a());
        for (mh key : documentKeys) {
            Iterator<ph> d = this.f2a.d(new ph(key, 0));
            while (d.hasNext()) {
                ph reference = d.next();
                if (!key.equals(reference.b())) {
                    break;
                }
                uniqueBatchIDs = uniqueBatchIDs.c(Integer.valueOf(reference.a()));
            }
        }
        return q(uniqueBatchIDs);
    }

    /* JADX WARNING: type inference failed for: r4v7, types: [a6] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<defpackage.v20> i(com.google.firebase.firestore.core.x r10) {
        /*
            r9 = this;
            boolean r0 = r10.r()
            r0 = r0 ^ 1
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "CollectionGroup queries should be handled in LocalDocumentsView"
            defpackage.n4.d(r0, r3, r2)
            me0 r0 = r10.m()
            int r2 = r0.n()
            int r2 = r2 + 1
            r3 = r0
            boolean r4 = defpackage.mh.j(r3)
            if (r4 != 0) goto L_0x0029
            java.lang.String r4 = ""
            a6 r4 = r3.b(r4)
            r3 = r4
            me0 r3 = (defpackage.me0) r3
        L_0x0029:
            ph r4 = new ph
            mh r5 = defpackage.mh.e(r3)
            r4.<init>(r5, r1)
            r1 = r4
            com.google.firebase.database.collection.e r4 = new com.google.firebase.database.collection.e
            java.util.List r5 = java.util.Collections.emptyList()
            java.util.Comparator r6 = defpackage.qu0.a()
            r4.<init>(r5, r6)
            com.google.firebase.database.collection.e<ph> r5 = r9.f2a
            java.util.Iterator r5 = r5.d(r1)
        L_0x0046:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0074
            java.lang.Object r6 = r5.next()
            ph r6 = (defpackage.ph) r6
            mh r7 = r6.b()
            me0 r7 = r7.h()
            boolean r8 = r0.l(r7)
            if (r8 != 0) goto L_0x0061
            goto L_0x0074
        L_0x0061:
            int r8 = r7.n()
            if (r8 != r2) goto L_0x0073
            int r8 = r6.a()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            com.google.firebase.database.collection.e r4 = r4.c(r8)
        L_0x0073:
            goto L_0x0046
        L_0x0074:
            java.util.List r6 = r9.q(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a10.i(com.google.firebase.firestore.core.x):java.util.List");
    }

    private List<v20> q(e<Integer> batchIds) {
        List<MutationBatch> result = new ArrayList<>();
        Iterator<Integer> it = batchIds.iterator();
        while (it.hasNext()) {
            v20 batch = k(it.next().intValue());
            if (batch != null) {
                result.add(batch);
            }
        }
        return result;
    }

    public void g(v20 batch) {
        n4.d(o(batch.e(), "removed") == 0, "Can only remove the first entry of the mutation queue", new Object[0]);
        this.f4a.remove(0);
        ImmutableSortedSet<DocumentReference> references = this.f2a;
        for (u20 mutation : batch.h()) {
            mh key = mutation.d();
            this.f1a.c().d(key);
            references = references.f(new ph(key, batch.e()));
        }
        this.f2a = references;
    }

    public void a() {
        if (this.f4a.isEmpty()) {
            n4.d(this.f2a.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty.", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean m(mh key) {
        Iterator<ph> d = this.f2a.d(new ph(key, 0));
        if (!d.hasNext()) {
            return false;
        }
        return d.next().b().equals(key);
    }

    private int n(int batchId) {
        if (this.f4a.isEmpty()) {
            return 0;
        }
        return batchId - this.f4a.get(0).e();
    }

    private int o(int batchId, String action) {
        int index = n(batchId);
        n4.d(index >= 0 && index < this.f4a.size(), "Batches must exist to be %s", action);
        return index;
    }
}
