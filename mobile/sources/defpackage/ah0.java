package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.google.firebase.firestore.core.x;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.remote.k0;
import com.google.protobuf.e;
import com.google.protobuf.m;
import defpackage.dh0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ah0  reason: default package */
final class ah0 implements x20 {
    /* access modifiers changed from: private */
    public int a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public e f60a;

    /* renamed from: a  reason: collision with other field name */
    private final dh0 f61a;

    /* renamed from: a  reason: collision with other field name */
    private final String f62a;

    /* renamed from: a  reason: collision with other field name */
    private final zx f63a;

    ah0(dh0 persistence, zx serializer, yt0 user) {
        this.f61a = persistence;
        this.f63a = serializer;
        this.f62a = user.b() ? user.a() : "";
        this.f60a = k0.b;
    }

    public void start() {
        z();
        if (this.f61a.x("SELECT last_stream_token FROM mutation_queues WHERE uid = ?").a(this.f62a).b(sg0.a(this)) == 0) {
            A();
        }
    }

    private void z() {
        List<String> uids = new ArrayList<>();
        this.f61a.x("SELECT uid FROM mutation_queues").d(tg0.a(uids));
        this.a = 0;
        for (String uid : uids) {
            this.f61a.x("SELECT MAX(batch_id) FROM mutations WHERE uid = ?").a(uid).d(ug0.a(this));
        }
        this.a++;
    }

    public boolean n() {
        return this.f61a.x("SELECT batch_id FROM mutations WHERE uid = ? LIMIT 1").a(this.f62a).e();
    }

    public void l(v20 batch, e streamToken) {
        this.f60a = (e) v90.n(streamToken);
        A();
    }

    public e b() {
        return this.f60a;
    }

    public void f(e streamToken) {
        this.f60a = (e) v90.n(streamToken);
        A();
    }

    private void A() {
        this.f61a.o("INSERT OR REPLACE INTO mutation_queues (uid, last_acknowledged_batch_id, last_stream_token) VALUES (?, ?, ?)", this.f62a, -1, this.f60a.B());
    }

    public v20 c(pr0 localWriteTime, List<u20> baseMutations, List<u20> mutations) {
        int batchId = this.a;
        this.a++;
        v20 batch = new v20(batchId, localWriteTime, baseMutations, mutations);
        int i = 3;
        this.f61a.o("INSERT INTO mutations (uid, batch_id, mutations) VALUES (?, ?, ?)", this.f62a, Integer.valueOf(batchId), this.f63a.i(batch).e());
        Set<DocumentKey> inserted = new HashSet<>();
        SQLiteStatement indexInserter = this.f61a.w("INSERT INTO document_mutations (uid, path, batch_id) VALUES (?, ?, ?)");
        for (u20 mutation : mutations) {
            mh key = mutation.d();
            if (inserted.add(key)) {
                String path = oi.c(key.h());
                dh0 dh0 = this.f61a;
                Object[] objArr = new Object[i];
                objArr[0] = this.f62a;
                objArr[1] = path;
                objArr[2] = Integer.valueOf(batchId);
                dh0.n(indexInserter, objArr);
                this.f61a.a().b((me0) key.h().q());
                i = 3;
            }
        }
        return batch;
    }

    public v20 k(int batchId) {
        return (v20) this.f61a.x("SELECT SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id = ?").a(1000000, this.f62a, Integer.valueOf(batchId)).c(vg0.a(this, batchId));
    }

    public v20 h(int batchId) {
        return (v20) this.f61a.x("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id >= ? ORDER BY batch_id ASC LIMIT 1").a(1000000, this.f62a, Integer.valueOf(batchId + 1)).c(wg0.a(this));
    }

    public List<v20> e() {
        List<MutationBatch> result = new ArrayList<>();
        this.f61a.x("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? ORDER BY batch_id ASC").a(1000000, this.f62a).d(xg0.a(this, result));
        return result;
    }

    public List<v20> j(mh documentKey) {
        String path = oi.c(documentKey.h());
        List<MutationBatch> result = new ArrayList<>();
        this.f61a.x("SELECT m.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path = ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").a(1000000, this.f62a, path).d(yg0.a(this, result));
        return result;
    }

    public List<v20> d(Iterable<mh> documentKeys) {
        List<Object> args = new ArrayList<>();
        for (mh key : documentKeys) {
            args.add(oi.c(key.h()));
        }
        dh0.b longQuery = new dh0.b(this.f61a, "SELECT DISTINCT dm.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path IN (", Arrays.asList(new Object[]{1000000, this.f62a}), args, ") AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id");
        List<MutationBatch> result = new ArrayList<>();
        Set<Integer> uniqueBatchIds = new HashSet<>();
        while (longQuery.b()) {
            longQuery.c().d(zg0.a(this, uniqueBatchIds, result));
        }
        if (longQuery.a() > 1) {
            Collections.sort(result, pg0.a());
        }
        return result;
    }

    static /* synthetic */ void q(ah0 ah0, Set uniqueBatchIds, List result, Cursor row) {
        int batchId = row.getInt(0);
        if (!uniqueBatchIds.contains(Integer.valueOf(batchId))) {
            uniqueBatchIds.add(Integer.valueOf(batchId));
            result.add(ah0.m(batchId, row.getBlob(1)));
        }
    }

    public List<v20> i(x query) {
        n4.d(!query.r(), "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
        me0 prefix = query.m();
        String prefixPath = oi.c(prefix);
        String prefixSuccessorPath = oi.f(prefixPath);
        List<MutationBatch> result = new ArrayList<>();
        this.f61a.x("SELECT dm.batch_id, dm.path, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path >= ? AND dm.path < ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").a(1000000, this.f62a, prefixPath, prefixSuccessorPath).d(qg0.a(this, result, prefix.n() + 1));
        return result;
    }

    static /* synthetic */ void s(ah0 ah0, List result, int immediateChildrenPathLength, Cursor row) {
        int batchId = row.getInt(0);
        int size = result.size();
        if ((size <= 0 || batchId != ((v20) result.get(size - 1)).e()) && oi.b(row.getString(1)).n() == immediateChildrenPathLength) {
            result.add(ah0.m(batchId, row.getBlob(2)));
        }
    }

    public void g(v20 batch) {
        SQLiteStatement mutationDeleter = this.f61a.w("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        SQLiteStatement indexDeleter = this.f61a.w("DELETE FROM document_mutations WHERE uid = ? AND path = ? AND batch_id = ?");
        int batchId = batch.e();
        n4.d(this.f61a.n(mutationDeleter, this.f62a, Integer.valueOf(batchId)) != 0, "Mutation batch (%s, %d) did not exist", this.f62a, Integer.valueOf(batch.e()));
        for (u20 mutation : batch.h()) {
            mh key = mutation.d();
            this.f61a.n(indexDeleter, this.f62a, oi.c(key.h()), Integer.valueOf(batchId));
            this.f61a.c().d(key);
        }
    }

    public void a() {
        if (n()) {
            List<ResourcePath> danglingMutationReferences = new ArrayList<>();
            this.f61a.x("SELECT path FROM document_mutations WHERE uid = ?").a(this.f62a).d(rg0.a(danglingMutationReferences));
            n4.d(danglingMutationReferences.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty. Dangling keys: %s", danglingMutationReferences);
        }
    }

    /* access modifiers changed from: private */
    public v20 m(int batchId, byte[] bytes) {
        try {
            if (bytes.length < 1000000) {
                return this.f63a.c(dw0.b0(bytes));
            }
            a accumulator = new a(bytes);
            while (accumulator.f64a) {
                this.f61a.x("SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?").a(Integer.valueOf((accumulator.d() * 1000000) + 1), 1000000, this.f62a, Integer.valueOf(batchId)).b(accumulator);
            }
            return this.f63a.c(dw0.a0(accumulator.e()));
        } catch (m e) {
            throw n4.a("MutationBatch failed to parse: %s", e);
        }
    }

    /* renamed from: ah0$a */
    private static class a implements hc<Cursor> {
        private final ArrayList<e> a = new ArrayList<>();
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public boolean f64a = true;

        a(byte[] firstChunk) {
            c(firstChunk);
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return this.a.size();
        }

        /* access modifiers changed from: package-private */
        public e e() {
            return e.h(this.a);
        }

        /* renamed from: a */
        public void accept(Cursor row) {
            byte[] bytes = row.getBlob(0);
            c(bytes);
            if (bytes.length < 1000000) {
                this.f64a = false;
            }
        }

        private void c(byte[] bytes) {
            this.a.add(e.j(bytes));
        }
    }
}
